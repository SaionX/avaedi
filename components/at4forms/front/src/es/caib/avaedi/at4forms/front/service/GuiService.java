package es.caib.avaedi.at4forms.front.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import es.caib.avaedi.at4forms.common.exception.GenericBusinessException;
import es.caib.avaedi.at4forms.common.search.CriteriaUtils;
import es.caib.avaedi.at4forms.common.search.FilterConfig;
import es.caib.avaedi.at4forms.common.search.PagingConfig;
import es.caib.avaedi.at4forms.common.search.ResultadoBusqueda;
import es.caib.avaedi.at4forms.common.util.log.LogService;
import es.caib.avaedi.at4forms.front.items.FormItem;
import es.caib.avaedi.at4forms.front.items.MenuItem;
import es.caib.avaedi.at4forms.front.items.StateData;
import es.caib.avaedi.at4forms.front.items.StateDataItem;
import es.caib.avaedi.at4forms.front.items.TextItem;
import es.caib.avaedi.at4forms.front.items.ToolbarElements;
import es.caib.avaedi.at4forms.front.menuDefinition.DoMenuDefinitionData;
import es.caib.avaedi.at4forms.front.menuDefinition.model.Form;
import es.caib.avaedi.at4forms.front.menuDefinition.model.Link;
import es.caib.avaedi.at4forms.front.menuDefinition.model.Menu;
import es.caib.avaedi.at4forms.front.menuDefinition.model.MenuDefinition;
import es.caib.avaedi.common.model.EstadoAplicacionId;
import es.caib.avaedi.front.config.LocalAuthenticationProvider;
import es.caib.avaedi.front.config.LocalUserDetails;
import es.caib.avaedi.logic.bo.ConfigAplicacionBO;
import es.caib.avaedi.logic.bo.ConfigExportacionBO;
import es.caib.avaedi.logic.bo.EstadoAplicacionBO;
import es.caib.avaedi.logic.vo.ConfigAplicacionFormVO;
import es.caib.avaedi.logic.vo.ConfigAplicacionListadoVO;
import es.caib.avaedi.logic.vo.ConfigExportacionFormVO;
import es.caib.avaedi.logic.vo.ConfigExportacionListadoVO;
import es.caib.avaedi.logic.vo.EstadoAplicacionFormVO;
import es.caib.avaedi.logic.vo.EstadoAplicacionListadoVO;
import org.slf4j.Logger;


/**
 * Servicio para obtener datos del gui, menú, etc.
 * @author agarcia
 *
 */
@Service("GuiService")
@RemoteProxy
public class GuiService extends MessageService {

	private static final String DWR_STATE_ATTRIBUTE = "DwrStateProviderState";
	/**
	 * The logger object.
	 */
	private static Logger log = LogService.getLogger(GuiService.class);

	@Autowired 
	private LocalAuthenticationProvider authProvider;	

	/**
	 * Bean para acceder a los metodos de negocio: EstatAplicacio
	 */
	@Autowired @Qualifier("EstadoAplicacionBean")
	private EstadoAplicacionBO estatAplicacioBO;

	/** Bean para acceder a los metodos de negocio: EstatAplicacio
	 * @param bean the bean to set
	 */
	public void setEstadoAplicacionBO(EstadoAplicacionBO bo) {
		this.estatAplicacioBO = bo;
	}
	@Autowired
	@Qualifier("ConfigAplicacionBean")
	private ConfigAplicacionBO configAplicacionBO;
	/**
	 * Bean para acceder a los metodos de negocio: ConfigAplicacion
	 * 
	 * @param bean
	 *            the bean to set
	 */
	public void setConfigAplicacionBO (ConfigAplicacionBO bean) {
		this.configAplicacionBO = bean;
	}

	
	@Autowired
	@Qualifier("ConfigExportacionBean")
	private ConfigExportacionBO configExportacionBO;
	/**
	 * Bean para acceder a los metodos de negocio: ConfigAplicacion
	 * 
	 * @param bean
	 *            the bean to set
	 */
	public void setConfigExportacionBO (ConfigExportacionBO bean) {
		this.configExportacionBO = bean;
	}
	


	/** Obtiene los elementos del menú y la barra de iconos
	 * @param request
	 * @throws GenericBusinessException
	 **/
	@RemoteMethod
	public ToolbarElements getToolBarElements (HttpServletRequest request) throws GenericBusinessException {

		log.debug("started getToolBarElements()");
		
		LocalUserDetails user = this.authProvider.loadFromAuthenticatedRequest(request); 
		
		DoMenuDefinitionData md = new DoMenuDefinitionData(user);
		MenuDefinition datosMenuTratados = md.getMenu();

		MenuItem menu = new MenuItem("");
		this.addElements (menu, datosMenuTratados.getTOOLBAROrLINKOrFORM(), this.getLocale(request));
		ToolbarElements toolbar = new ToolbarElements();
		//toolbar.setMenus(menu.getItemsAsMenus());
		toolbar.setMenus(menu.getItems());

		log.debug("finished getToolBarElements()");
		return toolbar;
	}




	/** Guarda el estado de extjs
	 * @param request
	 **/
	@RemoteMethod
	public StateData saveState (List<StateDataItem> estats, HttpServletRequest request) {
		log.debug("started saveState()");

		for (StateDataItem stateItem : estats) {
			try {
				this.saveState(stateItem, request);
			} catch (GenericBusinessException e) {
				log.error(e.getMessage(), e);
			}
		}
		log.debug("finished saveState()");
		return (StateData) request.getSession().getAttribute(DWR_STATE_ATTRIBUTE);

	}

	/**
	 * Guarda un item de estado
	 * @param stateItem
	 * @param request
	 * @throws GenericBusinessException
	 */
	@RemoteMethod
	private void saveState(StateDataItem stateItem, HttpServletRequest request) throws GenericBusinessException {
		StateData stateData = this.getStateData(request);
		stateData.put(stateItem);
		if (stateItem.getValue().length() > 40000) {
			return; //No guardamos en BD tamaños mayores a 40000. Se quedan sólo en la sesión actual
		}

		String username = request.getUserPrincipal().getName();
		
		EstadoAplicacionId id = new EstadoAplicacionId(username, stateItem.getName());
		EstadoAplicacionFormVO data = null;
		Date ahora = new Date();
		try {
			data = this.estatAplicacioBO.load(id);
		} catch (Exception e) {
			//Esto es debido a un fallo de diseño de la capa de negocio: si no existe, salta una excepción.
			log.warn(e.getMessage(), e);
		}
		
		if (data == null) {
			data = new EstadoAplicacionFormVO();
			data.setId(id);
			data.setValor(stateItem.getValue());
			data.setCreatorUser(username);
			data.setModUser(username);
			data.setDateCreation(ahora);
			data.setLastModified(ahora);
			this.estatAplicacioBO.add(data);
		} else {
			data.setValor(stateItem.getValue());
			this.estatAplicacioBO.update(id, data);
			data.setModUser(username);
			data.setLastModified(ahora);
		}
		

	}


	private StateData getStateData(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (session.getAttribute(DWR_STATE_ATTRIBUTE) == null) {

			StateData stateData = new StateData();

			//Cargamos el estado de base de datos
			try {
				String username = request.getUserPrincipal().getName();
				Collection<FilterConfig> filters = new ArrayList<FilterConfig>();
				filters.add(new FilterConfig(FilterConfig.TYPE_STRING, "id.username", CriteriaUtils.COMPARISON_EQUAL, username));
				 ResultadoBusqueda<EstadoAplicacionListadoVO> estats = this.estatAplicacioBO.getListado(filters, new PagingConfig());

				for (EstadoAplicacionListadoVO estat : estats.getResultados()) {
					stateData.put(new StateDataItem(estat.getId().getNombre(), estat.getValor()));
				}

			} catch (GenericBusinessException e) {
				log.error(e.getMessage(), e);
				return new StateData(null, false);
			}
			session.setAttribute(DWR_STATE_ATTRIBUTE, stateData);

		}
		return (StateData) session.getAttribute(DWR_STATE_ATTRIBUTE);
	}



	/** Guarda el estado de extjs
	 * @param request
	 * @throws GenericBusinessException
	 **/
	@RemoteMethod
	public StateData loadState (HttpServletRequest request) {
		log.debug("started loadState()");
		StateData ret = this.getStateData(request);
		log.debug("finished loadState()");
		return ret;
	}

	@RemoteMethod
	public ConfigAplicacionFormVO saveAppConfig (ConfigAplicacionFormVO formData,boolean update, HttpServletRequest request) throws GenericBusinessException {
		String username = request.getUserPrincipal().getName();
		Date now = new Date();
		formData.setUsername(username);
		formData.setLastModified(now);
		formData.setModUser(username);
		ConfigAplicacionFormVO ret = null;
		if(!update){
			formData.setDateCreation(now);
			formData.setCreatorUser(username);
			ret =this.configAplicacionBO.add(formData);
		}else{
			ConfigAplicacionFormVO entity = this.configAplicacionBO.findByEtiqueta(formData.getEtiqueta(),formData.getNombre(), formData.getUsername());
			entity.setValor(formData.getValor());
			ret = this.configAplicacionBO.update(entity.getPrimaryKey(), entity);
		}
		 
		return ret;
	}
	@RemoteMethod
	public ConfigExportacionFormVO saveExportConfig (ConfigExportacionFormVO formData,boolean update, HttpServletRequest request) throws GenericBusinessException {
		String username = request.getUserPrincipal().getName();
		Date now = new Date();
		formData.setUsername(username);
		formData.setLastModified(now);
		formData.setModUser(username);
		//TODO: Test this:
		if(formData.getPrivada().equals("true")){
			formData.setPrivada("1");
		}else{
			formData.setPrivada("0");
		}

		ConfigExportacionFormVO ret = null;
		if(!update){
			formData.setDateCreation(now);
			formData.setCreatorUser(username);
			ret =this.configExportacionBO.add(formData);
		}else{
			ConfigExportacionFormVO entity = this.configExportacionBO.findByEtiqueta(formData.getEtiqueta(),formData.getNombre(), formData.getUsername());
			entity.setColumnas(formData.getColumnas());
			entity.setFormato(formData.getFormato());
			entity.setPrivada(formData.getPrivada());
			
			
			ret = this.configExportacionBO.update(entity.getPrimaryKey(), entity);
		}
		return ret;
	}

	@RemoteMethod
	public boolean isAppCfgNameUsed (String etiqueta,String nombre, HttpServletRequest request) throws GenericBusinessException {
		String username = request.getUserPrincipal().getName();
		return this.configAplicacionBO.findByEtiqueta(etiqueta,nombre, username) == null;
	}
	@RemoteMethod
	public boolean isExportCfgNameUsed (String etiqueta,String nombre, HttpServletRequest request) throws GenericBusinessException {
		String username = request.getUserPrincipal().getName();
		return this.configExportacionBO.findByEtiqueta(etiqueta, nombre, username) == null;
	}
	
	
	@RemoteMethod
	public ResultadoBusqueda<Map<String, String>> getListadoConfigAplicacion(String beanName, String query, Collection<FilterConfig> extraFilters, HttpServletRequest request, ServletContext context) throws GenericBusinessException{
		String username = request.getUserPrincipal().getName();

		PagingConfig order = new PagingConfig();
		List<Map<String, String>> resultados = new ArrayList<Map<String, String>>();
		Map<String, String> resultado = null;

		Collection<FilterConfig> filters = new ArrayList<FilterConfig>();
		
		if (extraFilters != null && extraFilters.size() > 0) {
			filters.addAll(extraFilters);
		}
		

		order.setSort("etiqueta");
		order.setDirection(PagingConfig.ORDER_DIRECTION_ASC);
		filters.add(new FilterConfig(FilterConfig.TYPE_STRING, "username", "like", username));
		ResultadoBusqueda<ConfigAplicacionListadoVO> items = this.configAplicacionBO.getListado(filters, order);
		Iterator<ConfigAplicacionListadoVO> iter = items.getResultados().iterator();
		ConfigAplicacionListadoVO entity = null;
		while (iter.hasNext()) {
			entity = iter.next();
			resultado = new HashMap<String, String>();
			resultado.put("ID", String.valueOf(entity.getClave()));
			resultado.put("DISPLAY", entity.getEtiqueta());
			resultado.put("VALOR", entity.getValor());
			resultados.add(resultado);
		}
		return new ResultadoBusqueda<Map<String, String>>(resultados);
	}
	
	
	@RemoteMethod
	public ResultadoBusqueda<Map<String, String>> getListadoConfigExportacion(
			String beanName, String query, String extraFilters, 
			HttpServletRequest request, ServletContext context) throws GenericBusinessException{
		String username = request.getUserPrincipal().getName();
		

		List<Map<String, String>> resultados = new ArrayList<Map<String, String>>();
		Map<String, String> resultado = null;
		
		/*
		PagingConfig order = new PagingConfig();

		Collection<FilterConfig> filters = new ArrayList<FilterConfig>();
		if (extraFilters != null && extraFilters.size() > 0) {
			filters.addAll(extraFilters);
		}
		
		
		
		order.setSort("etiqueta");
		order.setDirection(PagingConfig.ORDER_DIRECTION_ASC);

		filters.add(new FilterConfig(FilterConfig.TYPE_AUTO, "username,privada", CriteriaUtils.COMPARISON_EQUAL, username + ",false"));
		*/
		
		Collection<ConfigExportacionListadoVO> items = this.configExportacionBO.searchAvailables(query, username);
		for (ConfigExportacionListadoVO entity : items) {
			resultado = new HashMap<String, String>();
			resultado.put("ID", String.valueOf(entity.getClave()));
			resultado.put("DISPLAY", entity.getEtiqueta());
			resultado.put("FORMATO", entity.getFormato());
			resultado.put("COLUMNAS", entity.getColumnas());
			resultado.put("EDITABLE", String.valueOf(entity.getUsername().equals(username)));
			resultados.add(resultado);
		}
		return new ResultadoBusqueda<Map<String, String>>(resultados);
	}
	
	
	
	@RemoteMethod
	public  boolean removeConfigAplicacion (Integer id, HttpServletRequest request) throws GenericBusinessException {
		//TODO: Añadir comprobacion de que no esta borrando un registro de otro usuario 
		return this.configAplicacionBO.delete(id);
	}
	@RemoteMethod
	public boolean removeConfigExportacion (Integer id,  HttpServletRequest request) throws GenericBusinessException {
		//TODO: Añadir comprobacion de que no esta borrando un registro de otro usuario 
		return this.configExportacionBO.delete(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

    /**
     * @todo Tratar el toolbar
     * @param menu
     * @param elementosMenu
     * @param locale
     */
	private void addElements(MenuItem menu, List<Object> elementosMenu, Locale locale) {

    	Iterator<Object> ite = elementosMenu.iterator();

    	while (ite.hasNext()) {

    		Object nextItem = ite.next();
    		if (Menu.class.isInstance(nextItem)) {
    			//es un menu
    			Menu menuElement = ((Menu)nextItem);
    	    	MenuItem subMenu = new MenuItem( this.getMessage(menuElement.getTITLE(), locale) );
    	    	this.addElements(subMenu, menuElement.getLINKOrFORMOrMENU(), locale);
    			menu.getItems().add( new TextItem ( this.getMessage(menuElement.getTITLE(), locale), menuElement.getICON(), subMenu));
    		/*
    		 } else if (Toolbar.class.isInstance(nextItem)) {
    			//es un toolbar
    			//toolbar no está implementado
   			 */
    		} else if (Link.class.isInstance(nextItem)) {
    			//es un link
    			Link linkElement = ((Link)nextItem);
    			menu.getItems().add(new TextItem( this.getMessage(linkElement.getTITLE(), locale), linkElement.getHREF(), true));
    		} else if (Form.class.isInstance(nextItem)) {
    			//es un form
    			Form formElement = ((Form)nextItem);
				//Se trata de un formulario
    			String mode = formElement.getMODE().value();
    			TextItem item;
    			//Se trata de un formulario nuevo
    			FormItem formItem = new FormItem( this.getMessage(formElement.getTITLE(), locale), formElement.getTABLE(), mode, formElement.getICON());
    		    item = formItem;
    			menu.getItems().add(item);
    		}

    	}

	}

}