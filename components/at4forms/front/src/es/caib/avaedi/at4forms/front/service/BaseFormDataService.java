package es.caib.avaedi.at4forms.front.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.io.FileTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.servlet.view.AbstractView;

import org.slf4j.Logger;

import es.caib.avaedi.at4forms.common.exception.GenericBusinessException;
import es.caib.avaedi.at4forms.common.exception.PrincipalException;
import es.caib.avaedi.at4forms.common.realm.BaseFrontPrincipal;
import es.caib.avaedi.at4forms.common.search.DatosExportacion;
import es.caib.avaedi.at4forms.common.search.FilterConfig;
import es.caib.avaedi.at4forms.common.search.PagingConfig;
import es.caib.avaedi.at4forms.common.search.ResultadoActualizacion;
import es.caib.avaedi.at4forms.common.search.ResultadoBusqueda;
import es.caib.avaedi.at4forms.common.search.ResultadoExportacion;
import es.caib.avaedi.at4forms.common.util.log.LogService;
import es.caib.avaedi.at4forms.front.controller.DocumentDownload;
import es.caib.avaedi.at4forms.front.items.FormItem;
import es.caib.avaedi.at4forms.front.service.items.ContenidoFormulario;
import es.caib.avaedi.at4forms.front.service.items.GridMetaData;
import es.caib.avaedi.at4forms.front.util.FileConstraints;
import es.caib.avaedi.at4forms.front.util.ImageConstraints;
import es.caib.avaedi.at4forms.logic.bo.BaseBO;
import es.caib.avaedi.at4forms.logic.bo.BaseBean;
import es.caib.avaedi.at4forms.logic.vo.BaseMapVO;
import es.caib.avaedi.at4forms.logic.vo.BaseVO;
import es.caib.avaedi.at4forms.logic.vo.ListadoVO;
import es.caib.avaedi.logic.bo.ConfigAplicacionBO;
import es.caib.avaedi.logic.bo.ConfigExportacionBO;
import es.caib.avaedi.logic.vo.ConfigAplicacionListadoVO;
import es.caib.avaedi.logic.vo.ConfigExportacionListadoVO;

/**
 * FormDataService es el bean de servicio para del framework general de
 * formularios de front.<br/>
 * Se configura como un bean de spring y los clientes javascript, a través de
 * DWR acceden a los diferentes formularios. Cada formulario está representado
 * por un nombre mapeado en {@link #getForms()} a un bean {@link FormService}
 * 
 * @see FormService
 * @author agarcia
 * 
 */
public abstract class BaseFormDataService extends MessageService {

	/**
	 * The logger object.
	 */
	private static Logger log = LogService.getLogger(BaseFormDataService.class);

	/** Mapa de tratamiento de formularios */
	@Resource
	private Map<String, FormService<?, ?, ?>> forms;

	/** Mapa de beans */
	@Resource
	private Map<String, BaseBO<?, ?>> beans;


	/**
	 * Obtiene la configuración de un grid (listado) para el formulario de
	 * nombre formItem
	 * 
	 * @see FormService#getListMetadata(FormItem, FrontPrincipal, Locale)
	 * @param formItem
	 * @param request
	 * @param context
	 * @return configuración de un grid (listado) para el formulario de nombre
	 *         formItem
	 * @throws GenericBusinessException
	 */
	@RemoteMethod
	public GridMetaData getListMetadata(FormItem formItem, HttpServletRequest request, ServletContext context) throws GenericBusinessException {

		try {
			FormService<?, ?, ?> form = this.getForm(formItem.getForm());
			return form.getListMetadata(formItem, getUsuari(request), this.getLocale(request));
		} catch (Exception t) {
			throw new GenericBusinessException(this.getExceptionMessage(request, t, ""));
		}

	}

	protected FormService<?, ?, ?> getForm(String form) throws GenericBusinessException {
		if (this.forms == null) {
			throw new GenericBusinessException("No se han fijado los formularios existentes. Debe fijar la propiedad 'forms'");
		}

		if (form == null) {
			throw new GenericBusinessException("Recibido form vacío");

		}

		if (!this.forms.containsKey(form)) {
			throw new GenericBusinessException("Se desconoce cómo tratar el formulario: " + form);
		}

		return this.forms.get(form);
	}

	protected BaseBO<?, ?> getBean(String bean) throws GenericBusinessException {
		if (this.beans == null) {
			throw new GenericBusinessException("No se han fijado los beans existentes. Debe fijar la propiedad 'beans'");
		}

		if (bean == null) {
			throw new GenericBusinessException("Recibido bean vacío");

		}

		String beanName = bean + "Bean";

		if (!this.beans.containsKey(beanName)) {
			throw new GenericBusinessException("Se desconoce cómo tratar el bean: " + bean);
		}

		return this.beans.get(beanName);
	}

	
	
	
	
	
	
	@RemoteMethod
	public ResultadoBusqueda<Map<String, String>> getExportCols(String formName,String query,Collection<FilterConfig> extraFilters, HttpServletRequest request, ServletContext context) throws GenericBusinessException{
		
		Locale locale = this.getLocale(request);
		
		FormService<?, ?, ?> form = this.getForm(formName);
		
		
		DatosExportacion datosExp = form.getDatosExportacion(locale);

		List<String> campos = datosExp.getCampos();
		List<String> cabeceras = datosExp.getCabeceras();
		if(campos.size() != cabeceras.size()){
			throw new GenericBusinessException("Campos y cabeceras no tienen el mismo tamaño");
		}
		HashMap<String, String> resultado;
		List<Map<String, String>> resultados = new ArrayList<Map<String, String>>();
		for (int i = 0; i < campos.size(); i++){
			resultado = new HashMap<String, String>();
			resultado.put("ID", campos.get(i));
			resultado.put("DISPLAY", cabeceras.get(i));
			resultado.put("ORDER", String.valueOf(i));
			resultados.add(resultado);
		}

		
		
		return new ResultadoBusqueda<Map<String, String>>(resultados);
	}
	
	
	
	
	
	
	/**
	 * Obtiene un listado de resultados
	 * 
	 * @see FormService#getListado(String, Collection, PagingConfig,
	 *      FrontPrincipal, Locale)
	 * @param filters
	 * @param searchId
	 *            Identificador de búsqueda
	 * @param pagingConfig
	 * @param request
	 * @return listado de resultados
	 * @throws GenericBusinessException
	 */
	@RemoteMethod
	public ResultadoBusqueda<?> getListado(String formName, Collection<FilterConfig> filters, PagingConfig pagingConfig, HttpServletRequest request, ServletContext context) throws GenericBusinessException {

		try {
			FormService<?, ?, ?> form = this.getForm(formName);
			if (filters == null) {
				filters = new ArrayList<FilterConfig>();
			}

			return form.getListado(filters, pagingConfig, getUsuari(request), this.getLocale(request));
		} catch (Exception t) {
			throw new GenericBusinessException(this.getExceptionMessage(request, t, ""));
		}

	}

	/**
	 * Obtiene el contenido de un campo relationpopup
	 * 
	 * @see FormService#getRelationPopupData(String, String, FrontPrincipal,
	 *      Locale)
	 * @param formName
	 * @param fieldName
	 * @param request
	 * @return datos para un relationpopup
	 * @throws GenericBusinessException
	 * @RemoteMethod public ResultadoBusqueda<?> getRelationPopupData (String
	 *               formName, String fieldName, String query,
	 *               Collection<FilterConfig> filters, HttpServletRequest
	 *               request, ServletContext context) throws
	 *               GenericBusinessException {
	 * 
	 *               try { log.debug("started getRelationPopupData");
	 *               FormService<?, ?, ?> form = this.getForm(formName); return
	 *               form.getRelationPopupData(fieldName, query, filters,
	 *               getUsuari(request), this.getLocale(request)); } catch(
	 *               Exception t ) { ResultadoBusqueda<?> res = new
	 *               ResultadoBusqueda<Object>(); res.setError(true);
	 *               res.setMsg(this.getExceptionMessage(request, t, ""));
	 *               return res; }
	 * 
	 *               }
	 */

	/**
	 * Devuelve los datos para el popup de nombre fieldName.
	 * 
	 * @param fieldName
	 * @param query
	 * @param usuari
	 * @param locale
	 * @return los datos para el popup de nombre fieldName
	 * @throws GenericBusinessException
	 */
	public ResultadoBusqueda<Map<String, String>> getRelationPopupData(String beanName, String query, Collection<FilterConfig> extraFilters, HttpServletRequest request, ServletContext context) throws GenericBusinessException {
		PagingConfig order = new PagingConfig();
		List<Map<String, String>> resultados = new ArrayList<Map<String, String>>();
		Map<String, String> resultado = null;

		Collection<FilterConfig> filters = new ArrayList<FilterConfig>();
		FilterConfig filter = null;
		filter = new FilterConfig(FilterConfig.TYPE_STRING, null, null, query);
		if ((query != null) && !query.equals("")) {
			filters.add(filter);
		}
		if (extraFilters != null && extraFilters.size() > 0) {
			filters.addAll(extraFilters);
		}


		BaseBO<?, ?> bean = this.getBean(beanName);

		order.setSort("primaryLabel");
		filter.setField("primaryLabel");
		ResultadoBusqueda<? extends ListadoVO> items = (ResultadoBusqueda<? extends ListadoVO>) bean.getListado(filters, order);
		for (ListadoVO entity : items.getResultados()) {
			resultado = new HashMap<String, String>();
			resultado.put("ID", String.valueOf(entity.getPrimaryKey()));
			resultado.put("DISPLAY", entity.getPrimaryLabel());
			resultados.add(resultado);
		}
		return new ResultadoBusqueda<Map<String, String>>(resultados);

	}

	/**
	 * Devuelve la vista necesaria para implementar el formato de exportación
	 * "format". Permite así añadir nuevos formatos o sobreescribir los
	 * existentes
	 * 
	 * @param format
	 * @return
	 * @throws GenericBusinessException
	 */
	public AbstractView getExportFormat(HttpServletRequest request, String format) throws GenericBusinessException {
		String formName = request.getParameter("formName");
		FormService<?, ?, ?> form = this.getForm(formName);
		return form.getCustomExportFormat(format);
	}

	/**
	 * Ejecuta una exportación de formulario
	 * 
	 * @see FormService#getExportacion(String, Collection, PagingConfig,
	 *      FrontPrincipal, Locale)
	 * @param request
	 * @return resultado de la exportación
	 * @throws GenericBusinessException
	 */
	@RemoteMethod
	public ResultadoExportacion getExportacion(HttpServletRequest request) throws GenericBusinessException {

		try {
			log.debug("started getExportacion");

			String formName = request.getParameter("formName");
			FormService<?, ?, ?> form = this.getForm(formName);

			Collection<FilterConfig> filters = getFilters(request);
			PagingConfig pagingConfig = getPagingConfig(request);
			
			 List<String> camposAexportar = getCamposAexportar(request);
			ResultadoExportacion resultado = form.getExportacion(filters, pagingConfig, camposAexportar, getUsuari(request), this.getLocale(request));

			log.debug("finished getExportacion");

			return resultado;
		} catch (Exception t) {
			throw new GenericBusinessException(this.getExceptionMessage(request, t, ""));
		}

	}

	protected List<String> getCamposAexportar(HttpServletRequest request) {
		String colsRaw = request.getParameter("exportCols");
		if(colsRaw != null && colsRaw.length() > 0){
			String[] cols = colsRaw.split(",");
			return Arrays.asList(cols);
		}		
		return new ArrayList<String>();
	}

	/*
	 * 
	 */
	protected abstract BaseFrontPrincipal getUsuari(HttpServletRequest request) throws PrincipalException;

	public static PagingConfig getPagingConfig(HttpServletRequest request) {
		String groupBy = request.getParameter("groupBy");
		String sort = request.getParameter("sort");
		String direction = request.getParameter("direction");
		PagingConfig pageConfig = new PagingConfig();
		pageConfig.setGroupBy(groupBy);
		pageConfig.setSort(sort);
		pageConfig.setDirection(direction);
		return pageConfig;
	}

	public static Collection<FilterConfig> getFilters(HttpServletRequest request) {

		//Leemos los filtros
		ArrayList<FilterConfig> filtros = new ArrayList<FilterConfig>();
		int filterNum = 0;
		FilterConfig filtro;
		while (request.getParameter("filter_type_" + filterNum) != null) {
			filtro = new FilterConfig();
			filtro.setType(request.getParameter("filter_type_" + filterNum));
			filtro.setField(request.getParameter("filter_field_" + filterNum));
			filtro.setValue(request.getParameter("filter_value_" + filterNum));
			String comparison = request.getParameter("filter_comparison_" + filterNum);
			if ((comparison != null) && !comparison.equals("undefined")) {
				filtro.setComparison(comparison);
			}
			filtros.add(filtro);
			filterNum++;
		}

		return filtros;
	}

	/**
	 * Añade un nuevo registro desde un formulario web
	 * 
	 * @see FormService#add(Map, FrontPrincipal, Locale)
	 * @param formName
	 *            nombre del formulario
	 * @param formData
	 *            contenido del formulario
	 * @param request
	 * @return el resultado de la operación
	 * @throws GenericBusinessException
	 */
	@RemoteMethod
	public ResultadoActualizacion addForm(String formName, Map<String, ?> formData, HttpServletRequest request) throws GenericBusinessException {
		FormService<?, ?, ?> form = this.getForm(formName);
		ResultadoActualizacion resultadoActualizacion = new ResultadoActualizacion();
		try {
			resultadoActualizacion = form.add(formData, getUsuari(request), this.getLocale(request));
		} catch (Exception t) {
			this.trataExcepcion(request, resultadoActualizacion, t);
		} catch (Throwable t) {
			this.trataExcepcion(request, resultadoActualizacion, t);
		}
		return resultadoActualizacion;
	}

	/**
	 * Modifica un registro desde un formulario web
	 * 
	 * @see FormService#update(String, Map, FrontPrincipal, Locale)
	 * @param formName
	 * @param id
	 * @param formData
	 * @param request
	 * @return el resultado de la operación
	 * @throws GenericBusinessException
	 */
	@RemoteMethod
	public ResultadoActualizacion updateForm(String formName, String id, Map<String, ?> formData, HttpServletRequest request) throws GenericBusinessException {
		FormService<?, ?, ?> form = this.getForm(formName);
		ResultadoActualizacion resultadoActualizacion = new ResultadoActualizacion();
		try {
			resultadoActualizacion = form.update(id, formData, getUsuari(request), this.getLocale(request));
		} catch (Exception t) {
			this.trataExcepcion(request, resultadoActualizacion, t);
		} catch (Throwable t) {
			this.trataExcepcion(request, resultadoActualizacion, t);
		}
		return resultadoActualizacion;
	}

	/**
	 * Elimina un registro desde un formulario web
	 * 
	 * @see FormService#delete(String, FrontPrincipal, Locale)
	 * @param formName
	 * @param id
	 * @param request
	 * @return el resultado de la operación
	 * @throws GenericBusinessException
	 */
	@RemoteMethod
	public ResultadoActualizacion deleteForm(String formName, String id, HttpServletRequest request) throws GenericBusinessException {
		FormService<?, ?, ?> form = this.getForm(formName);
		ResultadoActualizacion resultadoActualizacion = new ResultadoActualizacion();
		try {
			resultadoActualizacion = form.delete(id, getUsuari(request), this.getLocale(request));
		} catch (Exception t) {
			this.trataExcepcion(request, resultadoActualizacion, t);
		}

		return resultadoActualizacion;
	}

	/**
	 * Interviene en las excepciones SQL, para obtener el mensaje final.
	 * 
	 * @param request
	 * @param resultadoActualizacion
	 * @param t
	 * @throws GenericBusinessException
	 */
	protected void trataExcepcion(HttpServletRequest request, ResultadoActualizacion resultadoActualizacion, Throwable t) throws GenericBusinessException {

		resultadoActualizacion.setCorrecto(false);
		if (resultadoActualizacion.getMessage() == null) {
			resultadoActualizacion.setMessage("");
		}

		String message = this.getExceptionMessage(request, t, resultadoActualizacion.getMessage());

		resultadoActualizacion.setMessage(message);

	}

	/**
	 * Trata de devolver un mensaje reconocido. En caso contrario, dispara
	 * GenericBusinessException
	 * 
	 * @param request
	 * @param t
	 * @param messageBase
	 * @return
	 * @throws GenericBusinessException
	 */
	protected String getExceptionMessage(HttpServletRequest request, Throwable t, String messageBase) throws GenericBusinessException {

		StringBuilder message = new StringBuilder(messageBase);
		SQLException sqle = this.findSqlException(t);

		log.error(t.getMessage(), t);

		if (sqle != null) {

			//TODO: 
			//	- Ampliar los códigos reconocidos (http://www.postgresql.org/docs/8.3/static/errcodes-appendix.html)
			//	- Localear los mensajes
			//	- Permitir configurar mensajes específicos para nombre de ck o fk 

			String sqlState = sqle.getSQLState();
			if (sqlState != null) {
				if (sqlState.startsWith("08")) {
					//Class 08 — Connection Exception
					message.append("Ocurrió un error relacionado con la conexión al servidor de base de datos. \n");
				} else if (sqlState.startsWith("23")) {
					//Class 23 — Integrity Constraint Violation
					/*
					 * 23000 integrity_constraint_violation 23001
					 * restrict_violation 23502 not_null_violation 23503
					 * foreign_key_violation 23505 unique_violation 23514
					 * check_violation
					 */

					if (sqlState.equals("23000")) {
						message.append("Existe un problema con los datos de entrada. \n");
						message.append("Los datos o el resultado de la operación vulneran una restricción de integridad de datos. \n");
					} else if (sqlState.equals("23001")) {
						message.append("Existe un problema con los datos de entrada. \n");
						message.append("Los datos o el resultado de la operación vulneran una restricción de datos. \n");
					} else if (sqlState.equals("23502")) {
						message.append("Existe un problema con los datos de entrada. \n");
						message.append("Algún campo que debería tener valor, se ha introducido como nulo. \n");
					} else if (sqlState.equals("23503")) {
						message.append("Existe un problema con los datos de entrada. \n");
						message.append("Los datos o el resultado de la operación vulneran una relación con otros datos. \n");
					} else if (sqlState.equals("23505")) {
						message.append("Existe un problema con los datos de entrada. \n");
						message.append("Se está incluyendo un valor duplicado en un campo único. \n");
					} else if (sqlState.equals("23514")) {
						message.append("Existe un problema con los datos de entrada. \n");
						message.append("Se ha vulnerado una restricción de integridad. \n");
					}

				}
			}

			while (sqle != null) {
				if (sqle.getMessage().indexOf("getNextException") == -1) {
					message.append(sqle.getMessage()).append(". \n");
				}
				sqle = sqle.getNextException();
			}
		} else {
			throw new GenericBusinessException(t.getMessage(), t);
		}

		return message.toString();
	}

	private SQLException findSqlException(Throwable exception) {

		if (exception instanceof SQLException) {
			return (SQLException) exception;
		} else if (exception.getCause() != null) {
			return this.findSqlException(exception.getCause());
		} else {
			return null;
		}

	}

	/**
	 * Devuelve el contenido de un formulario web
	 * 
	 * @see FormService#load(String, FrontPrincipal, Locale)
	 * @param formName
	 * @param id
	 * @param request
	 * @return el contenido del formulario
	 * @throws GenericBusinessException
	 */
	@RemoteMethod
	public ContenidoFormulario<?> loadFormData(String formName, String id, HttpServletRequest request) throws GenericBusinessException {

		try {
			FormService<?, ?, ?> form = this.getForm(formName);
			return form.load(id, getUsuari(request), this.getLocale(request));
		} catch (Exception t) {
			throw new GenericBusinessException(this.getExceptionMessage(request, t, ""), t);
		}
	}

	/**
	 * Devuelve el contenido de un subpanel (MultiForm) de un formulario web,
	 * para paneles marcados como deferredLoad
	 * 
	 * @see FormService#loadSubPanel(String, String, FrontPrincipal, Locale)
	 * @param formName
	 * @param id
	 * @param multiFormName
	 * @param request
	 * @return el contenido del formulario
	 * @throws GenericBusinessException
	 */
	@RemoteMethod
	public ContenidoFormulario<?> loadSubPanelFormData(String formName, String id, String multiFormName, HttpServletRequest request) throws GenericBusinessException {
		FormService<?, ?, ?> form = this.getForm(formName);

		try {
			Object resultData = form.loadCollecionData(id, multiFormName, getUsuari(request), this.getLocale(request));
			BaseMapVO result = new BaseMapVO();
			result.put(multiFormName, resultData);
			ContenidoFormulario<BaseMapVO> ret = new ContenidoFormulario<BaseMapVO>(result);
			return ret;
		} catch (Exception t) {
			throw new GenericBusinessException(this.getExceptionMessage(request, t, ""), t);
		}

	}

	public ResultadoBusqueda<?> loadListData(String formName, String id, HttpServletRequest request) throws GenericBusinessException {
		//FormService<?, ?, ?> form = this.getForm(formName);
		//return form.getListado(filters, pagingConfig, getUsuari(request), this.getLocale(request));
		return null;
	}

	/**
	 * Modifica varios registros desde un formulario web
	 * 
	 * @param formName
	 * @param array
	 *            ids
	 * @param array
	 *            formData
	 * @param request
	 * @return el resultado de la operación
	 * @throws GenericBusinessException
	 */
	@RemoteMethod
	public ResultadoActualizacion updateGrid(String formName, String[] id, Map<String, ?>[] formData, HttpServletRequest request) throws GenericBusinessException {
		FormService<?, ?, ?> form = this.getForm(formName);
		ResultadoActualizacion resultadoActualizacionLinea = new ResultadoActualizacion();
		ResultadoActualizacion resultadoActualizacionGrid = new ResultadoActualizacion();

		try {
			for (int i = 0; i < id.length; i++) {
				resultadoActualizacionLinea = form.update(id[i], formData[i], getUsuari(request), this.getLocale(request));
				if (!resultadoActualizacionLinea.isCorrecto()) {
					resultadoActualizacionGrid.setCorrecto(false);
				}
			}
		} catch (Exception t) {
			this.trataExcepcion(request, resultadoActualizacionGrid, t);
		}

		return resultadoActualizacionGrid;
	}

	/**
	 * @return the forms
	 */
	public Map<String, FormService<?, ?, ?>> getForms() {
		return this.forms;
	}

	/**
	 * Fija el mapa de formularios
	 * 
	 * @param forms
	 *            the forms to set
	 */
	public void setForms(Map<String, FormService<?, ?, ?>> forms) {
		this.forms = forms;
	}

	/**
	 * Añade un nuevo registro desde un formulario web
	 * 
	 * @see FormService#add(Map, FrontPrincipal, Locale)
	 * @param formName
	 *            nombre del formulario
	 * @param formData
	 *            contenido del formulario
	 * @param request
	 * @return el resultado de la operación
	 * @throws GenericBusinessException
	 */
	@RemoteMethod
	public ResultadoActualizacion addSubForm(String formName, String id, String subFormName, Map<String, ?> formData, HttpServletRequest request) throws GenericBusinessException {
		FormService<?, ?, ?> form = this.getForm(formName);
		ResultadoActualizacion resultadoActualizacion = new ResultadoActualizacion();
		try {
			resultadoActualizacion = form.addSubForm(formData, id, subFormName, getUsuari(request), this.getLocale(request));
		} catch (Exception t) {
			this.trataExcepcion(request, resultadoActualizacion, t);
		}
		return resultadoActualizacion;
	}

	/**
	 * Modifica un registro desde un formulario web
	 * 
	 * @see FormService#update(String, Map, FrontPrincipal, Locale)
	 * @param formName
	 * @param id
	 * @param formData
	 * @param request
	 * @return el resultado de la operación
	 * @throws GenericBusinessException
	 */
	@RemoteMethod
	public ResultadoActualizacion updateSubForm(String formName, String id, String subFormName, String subId, Map<String, ?> formData, HttpServletRequest request) throws GenericBusinessException {
		ResultadoActualizacion resultadoActualizacion = new ResultadoActualizacion();

		try {
			FormService<?, ?, ?> form = this.getForm(formName);
			resultadoActualizacion = form.updateSubForm(id, formData, subFormName, subId, getUsuari(request), this.getLocale(request));
		} catch (Exception t) {
			this.trataExcepcion(request, resultadoActualizacion, t);
		}
		return resultadoActualizacion;
	}

	/**
	 * Modifica varios registros desde un formulario web
	 * 
	 * @param formName
	 * @param array
	 *            ids
	 * @param array
	 *            formData
	 * @param request
	 * @return el resultado de la operación
	 * @throws GenericBusinessException
	 */
	@RemoteMethod
	public ResultadoActualizacion updateSubFormList(String formName, String subFormName, String idForm, String[] subFormId, Map<String, ?>[] formData, HttpServletRequest request) throws GenericBusinessException {
		FormService<?, ?, ?> form = this.getForm(formName);
		ResultadoActualizacion resultadoActualizacionLinea = new ResultadoActualizacion();
		ResultadoActualizacion resultadoActualizacionSubFormList = new ResultadoActualizacion();

		try {
			for (int i = 0; i < subFormId.length; i++) {
				resultadoActualizacionLinea = form.updateSubForm(idForm, formData[i], subFormName, subFormId[i], getUsuari(request), this.getLocale(request));
				if (!resultadoActualizacionLinea.isCorrecto()) {
					resultadoActualizacionSubFormList.setCorrecto(false);
				}
			}
		} catch (Exception t) {
			this.trataExcepcion(request, resultadoActualizacionSubFormList, t);
		}

		return resultadoActualizacionSubFormList;
	}

	/**
	 * Elimina un registro desde un formulario web
	 * 
	 * @see FormService#delete(String, FrontPrincipal, Locale)
	 * @param formName
	 * @param id
	 * @param subFormName
	 * @param subId
	 * @param request
	 * @return el resultado de la operación
	 * @throws GenericBusinessException
	 */
	@RemoteMethod
	public ResultadoActualizacion deleteSubForm(String formName, String id, String subFormName, String subId, HttpServletRequest request) throws GenericBusinessException {
		FormService<?, ?, ?> form = this.getForm(formName);
		ResultadoActualizacion resultadoActualizacion = new ResultadoActualizacion();
		try {
			resultadoActualizacion = form.deleteSubForm(id, subFormName, subId, getUsuari(request), this.getLocale(request));
		} catch (Exception t) {
			this.trataExcepcion(request, resultadoActualizacion, t);
		}
		return resultadoActualizacion;
	}

	@RemoteMethod
	public ResultadoActualizacion unlinkSubForm(String formName, String id, String subFormName, String subId, HttpServletRequest request) throws GenericBusinessException {
		return getForm(formName).deleteSubForm(id, subFormName, subId, getUsuari(request), getLocale(request));
	}

	/**
	 * Ejecuta el almacenamiento de un archivo de cualquier estructura
	 * 
	 * @param formName
	 * @param file
	 * @param id
	 * @param request
	 * @return El resultado de la operación
	 * @throws GenericBusinessException
	 */
	@RemoteMethod
	public ResultadoActualizacion guardarDocumento(String docname, FileTransfer file, String id, HttpServletRequest request) throws GenericBusinessException {
		ResultadoActualizacion resultadoActualizacion = new ResultadoActualizacion();

		String[] docData = docname.split("-");
		if (docData.length != 2) {
			log.error("guardarDocumento: recibido docname no válido: " + docname);
		}
		String formName = docData[0];
		docname = docData[1];
		if ((formName == null) || (id == null)) {
			return null;
		}

		try {
			return this.getForm(formName).guardarBlob(file, id, docname, getUsuari(request), getLocale(request));
		} catch (Exception t) {
			log.warn("Se capturo una excepcion al guardar un documento");
			log.warn(t.getMessage());
			trataExcepcion(request, resultadoActualizacion, new GenericBusinessException("Error al guardar el documento, por favor, compruebe las restricciones o contacte con un administrador."));
		}
		return resultadoActualizacion;
	}

	/**
	 * Ejecuta el almacenamiento de un archivo de cualquier estructura
	 * 
	 * @param formName
	 * @param file
	 * @param id
	 * @param request
	 * @return El resultado de la operación
	 * @throws GenericBusinessException
	 */
	@RemoteMethod
	public DocumentDownload obtenerDocumento(String docname, String id, HttpServletRequest request) throws GenericBusinessException {
		try {
			String[] docData = docname.split("-");
			if (docData.length != 2) {
				log.error("obtenerDocumento: recibido docname no válido: " + docname);
			}
			String formName = docData[0];
			docname = docData[1];
			if ((formName == null) || (id == null)) {
				return null;
			}
			DocumentDownload ret = this.getForm(formName).obtenerBlob(id, docname, getUsuari(request), getLocale(request));

			return ret;
		} catch (Exception t) {
			throw new GenericBusinessException(getExceptionMessage(request, t, ""), t);
		}
	}

	/**
	 * Ejecuta el almacenamiento de un archivo de cualquier estructura
	 * 
	 * @param formName
	 * @param id
	 * @param request
	 * @return El resultado de la operación
	 * @throws GenericBusinessException
	 */
	@RemoteMethod
	public ResultadoActualizacion eliminarDocumento(String docname, String id, HttpServletRequest request) throws GenericBusinessException {
		ResultadoActualizacion resultadoActualizacion = new ResultadoActualizacion();

		String[] docData = docname.split("-");
		if (docData.length != 2) {
			log.error("obtenerDocumento: recibido docname no válido: " + docname);
		}
		String formName = docData[0];
		docname = docData[1];
		if ((formName == null) || (id == null)) {
			return null;
		}
		try {
			return this.getForm(formName).eliminarBlob(id, docname, getUsuari(request), getLocale(request));
		} catch (Exception t) {
			trataExcepcion(request, resultadoActualizacion, t);
		}
		return resultadoActualizacion;
	}

	/**
	 * Devuelve las características de tamaño configurado para una imagen
	 * 
	 * @param formName
	 * @param file
	 * @param id
	 * @param request
	 * @return El resultado de la operación
	 * @throws GenericBusinessException
	 */
	@RemoteMethod
	public ImageConstraints obtenerConstraints(String docname) throws GenericBusinessException {

		String[] docData = docname.split("-");
		if (docData.length != 2) {
			log.error("guardarDocumento: recibido docname no válido: " + docname);
		}
		String formName = docData[0];
		docname = docData[1];
		if ((formName == null)) {
			return null;
		}

		return this.getForm(formName).obtenerImageConstraints(docname);
	}

	/**
	 * Devuelve las características de tamaño configurado para una imagen
	 * 
	 * @param formName
	 * @param file
	 * @param id
	 * @param request
	 * @return El resultado de la operación
	 * @throws GenericBusinessException
	 */
	@RemoteMethod
	public FileConstraints obtenerFileConstraints(String docname) throws GenericBusinessException {

		String[] docData = docname.split("-");
		if (docData.length != 2) {
			log.error("guardarDocumento: recibido docname no válido: " + docname);
		}
		String formName = docData[0];
		docname = docData[1];
		if ((formName == null)) {
			return null;
		}

		return this.getForm(formName).obtenerFileConstraints(docname);
	}

}