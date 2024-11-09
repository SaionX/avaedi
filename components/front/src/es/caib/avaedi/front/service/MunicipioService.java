package es.caib.avaedi.front.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import es.caib.avaedi.at4forms.common.exception.GenericBusinessException;
import es.caib.avaedi.at4forms.common.realm.BaseFrontPrincipal;
import es.caib.avaedi.at4forms.common.search.DatosExportacion;
import es.caib.avaedi.at4forms.common.search.FilterConfig;
import es.caib.avaedi.at4forms.common.search.PagingConfig;
import es.caib.avaedi.at4forms.common.search.ResultadoActualizacion;
import es.caib.avaedi.at4forms.common.search.ResultadoBusqueda;
import es.caib.avaedi.at4forms.common.search.TipoCampoExportacion;
import es.caib.avaedi.at4forms.common.util.FormData2Java;
import es.caib.avaedi.at4forms.common.util.StringUtils;
import es.caib.avaedi.at4forms.common.util.log.LogService;
import es.caib.avaedi.at4forms.front.items.FormItem;
import es.caib.avaedi.at4forms.front.service.items.GridColumnFilter;
import es.caib.avaedi.at4forms.front.service.items.GridColumnMetaData;
import es.caib.avaedi.at4forms.front.service.items.GridMetaData;
import es.caib.avaedi.at4forms.front.service.items.GridRecordFieldMetaData;
import es.caib.avaedi.at4forms.logic.vo.ListadoVO;
import es.caib.avaedi.common.realm.Constants;
import es.caib.avaedi.front.config.AuthUtils;
import es.caib.avaedi.front.service.general.BaseService;
import es.caib.avaedi.logic.bo.IslaBO;
import es.caib.avaedi.logic.bo.MunicipioBO;
import es.caib.avaedi.logic.vo.AcusticasListadoVO;
import es.caib.avaedi.logic.vo.InspeccionFormVO;
import es.caib.avaedi.logic.vo.MunicipioFormVO;
import es.caib.avaedi.logic.vo.MunicipioListadoVO;

/**
 * Servicio para tratar el formulario: Municipio
 * 
 * @author agarcia@at4.net
 * 
 */
@Service("municipio")
public class MunicipioService extends BaseService<MunicipioBO, MunicipioListadoVO, MunicipioFormVO> {

	/**
	 * The logger object.
	 */
	private static Logger log = LogService.getLogger(MunicipioService.class);

	/**
	 * Bean para acceder a los métodos de negocio: Municipio
	 */
	@Autowired
	@Qualifier("MunicipioBean")
	protected MunicipioBO mainBO;

	/**
	 * Bean para acceder a los métodos de negocio: Municipio
	 * 
	 * @param bean
	 *            the bean to set
	 */
	protected MunicipioBO getMainBO() {
		return this.mainBO;
	}

	/**
	 * Bean para acceder a los metodos de negocio: Isla
	 */
	@Autowired
	@Qualifier("IslaBean")
	private IslaBO islaBO;

	/**
	 * Bean para acceder a los metodos de negocio: Isla
	 * 
	 * @param bean
	 *            the bean to set
	 */
	public void setIslaBO(IslaBO bean) {
		this.islaBO = bean;
	}

	@Override
	protected boolean hasPerms(BaseFrontPrincipal usuari, String action, MunicipioFormVO instance) {

		if (instance != null) {
			//Estamos actuando sobre una instancia en concreto, aquí comprobamos que el usuario tenga acceso al municipio 
			if (!AuthUtils.hasAccess(usuari, instance.getClave())) {
				return false;
			}
		}

		if (action.equals(PERMS_UPDATE)) {
			return usuari.isInAnyRole(Constants.ADMIN, Constants.OPERADOR, Constants.MUNICIPI);
		} else if (action.equals(PERMS_LIST) || action.equals(PERMS_EXPORT)) {
			return usuari.isInAnyRole(Constants.ADMIN, Constants.OPERADOR, Constants.CONSULTA, Constants.MUNICIPI);
		}

		return false;
	}

	/*
	 *  ************************** Métodos del interfaz FormService
	 * ************************************
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.caib.avaedi.front.service.FormService#getListMetadata(es.caib.avaedi
	 * .front.items.FormItem, es.caib.avaedi.common.realm.BaseFrontPrincipal,
	 * java.util.Locale)
	 */
	public GridMetaData getListMetadata(FormItem formItem, BaseFrontPrincipal usuari, Locale locale) {

		if ((formItem.getText() == null) || formItem.getText().equals("")) {
			formItem.setText(this.getMessage("forms.municipio.title", locale));
		}

		GridMetaData metaData = new GridMetaData(formItem);

		//Nombre de la clase js de formulario
		metaData.setFormClassName("MunicipioForm");

		//Nombre de la clase js de listado
		metaData.setListClassName("ListadoGrid");

		//Configurar las acciones posibles según los permisos
		metaData.setShowNewButton(this.hasPerms(usuari, PERMS_ADD));
		metaData.setShowDeleteButton(this.hasPerms(usuari, PERMS_DELETE));
		metaData.setShowUpdateButton(this.hasPerms(usuari, PERMS_UPDATE));
		metaData.setShowExportControls(this.hasPerms(usuari, PERMS_EXPORT));

		//TODO: desactivar si no se quiere hacer grid editable
		metaData.setEditable(this.hasPerms(usuari, PERMS_UPDATE));

		//Añadimos el campo de oid al registro (el campo oid es el "object identifier")
		metaData.addRecordField(new GridRecordFieldMetaData("oid", "clave", GridRecordFieldMetaData.INT_TYPE));

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("clave", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("clave", this.getMessage("forms.municipio.columns.clave.header", locale)));
		metaData.getColumn("clave").setGroupable(false);
		metaData.getColumn("clave").setSortable(true);
		metaData.getColumn("clave").setSofaFilter(GridColumnFilter.TYPE_NUMERIC);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("islaId", GridRecordFieldMetaData.INT_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("islaLabel", GridRecordFieldMetaData.STRING_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("isla", "islaLabel", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("isla", this.getMessage("forms.municipio.columns.isla.header", locale)));
		metaData.getColumn("isla").setTooltip(this.getMessage("forms.municipio.columns.isla.description", locale));
		metaData.getColumn("isla").setGroupable(true);
		metaData.getColumn("isla").setSortable(true);
		metaData.getColumn("isla").setSofaFilter(GridColumnFilter.TYPE_MULTICOMBO);
		metaData.getColumn("isla").setRelatedForm("Isla");

		metaData.getColumn("isla").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("isla").setEditable(!usuari.isInRole(Constants.MUNICIPI));

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("nombre", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("nombre", this.getMessage("forms.municipio.columns.nombre.header", locale)));
		metaData.getColumn("nombre").setGroupable(false);
		metaData.getColumn("nombre").setSortable(true);
		metaData.getColumn("nombre").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("nombre").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("nombre").setEditable(!usuari.isInRole(Constants.MUNICIPI));

		//Creamos el registro para el record
		//metaData.addRecordField(new GridRecordFieldMetaData("codigoIne", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		/*metaData.addColumn(new GridColumnMetaData("codigoIne", this.getMessage("forms.municipio.columns.codigoIne.header", locale)));
		metaData.getColumn("codigoIne").setGroupable(false);
		metaData.getColumn("codigoIne").setSortable(true);
		metaData.getColumn("codigoIne").setSofaFilter(GridColumnFilter.TYPE_NUMERIC);

		metaData.getColumn("codigoIne").setEditable(true);*/

		//Creamos el registro para el record
		//metaData.addRecordField(new GridRecordFieldMetaData("codigoCatastro", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		/*metaData.addColumn(new GridColumnMetaData("codigoCatastro", this.getMessage("forms.municipio.columns.codigoCatastro.header", locale)));
		metaData.getColumn("codigoCatastro").setGroupable(false);
		metaData.getColumn("codigoCatastro").setSortable(true);
		metaData.getColumn("codigoCatastro").setSofaFilter(GridColumnFilter.TYPE_NUMERIC);

		metaData.getColumn("codigoCatastro").setEditable(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("organismoContacto", GridRecordFieldMetaData.STRING_TYPE));

		// Creamos la columna
		metaData.addColumn(new GridColumnMetaData("organismoContacto", this.getMessage("forms.municipio.columns.organismoContacto.header", locale)));
		metaData.getColumn("organismoContacto").setGroupable(false);
		metaData.getColumn("organismoContacto").setSortable(true);
		metaData.getColumn("organismoContacto").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("organismoContacto").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("organismoContacto").setEditable(true);*/

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("direccion", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("direccion", this.getMessage("forms.municipio.columns.direccion.header", locale)));
		metaData.getColumn("direccion").setGroupable(false);
		metaData.getColumn("direccion").setSortable(true);
		metaData.getColumn("direccion").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("direccion").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("direccion").setEditable(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("telefono", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("telefono", this.getMessage("forms.municipio.columns.telefono.header", locale)));
		metaData.getColumn("telefono").setGroupable(false);
		metaData.getColumn("telefono").setSortable(true);
		metaData.getColumn("telefono").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("telefono").setEditable(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("email", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("email", this.getMessage("forms.municipio.columns.email.header", locale)));
		metaData.getColumn("email").setGroupable(false);
		metaData.getColumn("email").setSortable(true);
		metaData.getColumn("email").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("email").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("email").setEditable(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("url", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("url", this.getMessage("forms.municipio.columns.url.header", locale)));
		metaData.getColumn("url").setGroupable(false);
		metaData.getColumn("url").setSortable(true);
		metaData.getColumn("url").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("url").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("url").setEditable(true);

		return metaData;
	}

	@Override
	public ResultadoBusqueda<MunicipioListadoVO> getListado(Collection<FilterConfig> filters, PagingConfig pagingConfig, BaseFrontPrincipal usuari, Locale locale) throws GenericBusinessException {
		this.addMunicipioFilter(filters, usuari);
		return super.getListado(filters, pagingConfig, usuari, locale);
	}

	private void addMunicipioFilter(Collection<FilterConfig> filters, BaseFrontPrincipal usuari) {
		String municipioId = AuthUtils.municipioId(usuari);
		if (!StringUtils.isEmpty(municipioId)) {

			//Añadimos el filtro de tipos de contrato
			filters.add(new FilterConfig(FilterConfig.TYPE_AUTO, "clave", municipioId));

		}

	}

	/**
	 * Devuelve los datos disponibles para la exportación
	 * 
	 * @param locale
	 * @return
	 * @throws GenericBusinessException
	 */
	public DatosExportacion getDatosExportacion(Locale locale) throws GenericBusinessException {

		DatosExportacion datosExportacion = new DatosExportacion();

		/* Configuramos el header */
		/* Informamos de los tipos de campo */

		datosExportacion.add("clave", this.getMessage("forms.municipio.columns.clave.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("isla", this.getMessage("forms.municipio.columns.isla.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("nombre", this.getMessage("forms.municipio.columns.nombre.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("codigoIne", this.getMessage("forms.municipio.columns.codigoIne.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("codigoCatastro", this.getMessage("forms.municipio.columns.codigoCatastro.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("organismoContacto", this.getMessage("forms.municipio.columns.organismoContacto.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("direccion", this.getMessage("forms.municipio.columns.direccion.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("telefono", this.getMessage("forms.municipio.columns.telefono.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("email", this.getMessage("forms.municipio.columns.email.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("url", this.getMessage("forms.municipio.columns.url.header", locale), TipoCampoExportacion.STRING);

		datosExportacion.add("dateCreation", this.getMessage("forms.general.columns.dateCreation.header", locale), TipoCampoExportacion.DATE);
		datosExportacion.add("lastModified", this.getMessage("forms.general.columns.lastModified.header", locale), TipoCampoExportacion.DATE);
		datosExportacion.add("creatorUser", this.getMessage("forms.general.columns.creatorUser.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("modUser", this.getMessage("forms.general.columns.modUser.header", locale), TipoCampoExportacion.STRING);

		return datosExportacion;
	}

	/**
	 * Convierte a un registro de exportación
	 **/
	@Override
	public List<String> listadoToExportRow(ListadoVO rawInstance, Locale locale) {
		MunicipioListadoVO instance = (MunicipioListadoVO) rawInstance;

		List<String> excelRow = new ArrayList<String>();

		excelRow.add(FormData2Java.toString(instance.getClave()));
		excelRow.add(instance.getIslaLabel());
		excelRow.add(instance.getNombre());
		excelRow.add(FormData2Java.toString(instance.getCodigoIne()));
		excelRow.add(FormData2Java.toString(instance.getCodigoCatastro()));
		excelRow.add(instance.getOrganismoContacto());
		excelRow.add(instance.getDireccion());
		excelRow.add(instance.getTelefono());
		excelRow.add(instance.getEmail());
		excelRow.add(instance.getUrl());
		excelRow.add(FormData2Java.toString(instance.getDateCreation()));
		excelRow.add(FormData2Java.toString(instance.getLastModified()));
		excelRow.add(instance.getCreatorUser());
		excelRow.add(instance.getModUser());

		return excelRow;

	}

	@Override
	public Serializable toSerializableId(String id) {

		return FormData2Java.toInteger(id);

	}

	@Override
	public String fromSerializableId(Serializable id) {

		return FormData2Java.toString(id);

	}

	/**
	 * Rellena una instancia de MunicipioFormVO con el contenido de un
	 * formulario recibido en formato Map<String, ?>
	 */
	protected void setFormData(MunicipioFormVO record, Map<String, ?> formData) throws GenericBusinessException {
		String formDataStr = null;
		if (FormData2Java.needsUpdate(formData, "islaId")) {
			formDataStr = (String) formData.get("islaId");
			record.setIslaId(FormData2Java.toInteger(formDataStr));

		}
		if (FormData2Java.needsUpdate(formData, "nombre")) {
			formDataStr = (String) formData.get("nombre");
			record.setNombre(formDataStr);
		}
		/*if (FormData2Java.needsUpdate(formData, "codigoIne")) {
			formDataStr = (String) formData.get("codigoIne");
			record.setCodigoIne(FormData2Java.toInteger(formDataStr));
		}
		if (FormData2Java.needsUpdate(formData, "codigoCatastro")) {
			formDataStr = (String) formData.get("codigoCatastro");
			record.setCodigoCatastro(FormData2Java.toInteger(formDataStr));
		}*/
		if (formData.containsKey("organismoContacto")) {
			formDataStr = (String) formData.get("organismoContacto");
			record.setOrganismoContacto(formDataStr);
		}
		if (formData.containsKey("direccion")) {
			formDataStr = (String) formData.get("direccion");
			record.setDireccion(formDataStr);
		}
		if (formData.containsKey("telefono")) {
			formDataStr = (String) formData.get("telefono");
			record.setTelefono(formDataStr);
		}
		if (formData.containsKey("email")) {
			formDataStr = (String) formData.get("email");
			record.setEmail(formDataStr);
		}
		if (formData.containsKey("url")) {
			formDataStr = (String) formData.get("url");
			record.setUrl(formDataStr);
		}
	}
	
	@Override
	public ResultadoActualizacion update(String id, Map<String, ?> formData, BaseFrontPrincipal usuari, Locale locale) throws GenericBusinessException {

		ResultadoActualizacion ret = new ResultadoActualizacion();

		MunicipioFormVO recordToUpdate = this.getMainBO().load( toSerializableId(id) );
		MunicipioFormVO oldRecord = this.clone(recordToUpdate);
		
		this.setFormData(recordToUpdate, formData);

		//Fija los campos automáticos
		recordToUpdate.setLastModified(new java.util.Date());
		recordToUpdate.setModUser(usuari.getUsername());

		//Comprueba permisos de actualización
		this.checkPerms(usuari, PERMS_UPDATE, recordToUpdate, locale);
		/**
		 * 13/10/2016 
		 * @author garrom@at4.net
		 * El nombre del municipio no debe ser modificable para los usuarios de tipo MUNICIPI
		 */
		if(usuari.isInRole(Constants.MUNICIPI)){
			recordToUpdate.setNombre(oldRecord.getNombre());
		}
		
		//Antes de actualizar, validamos el registro
		this.validateRecord(ret, recordToUpdate, oldRecord, usuari, locale);
		if (!ret.isCorrecto()) {
			return ret;
		}
		recordToUpdate = this.getMainBO().update(toSerializableId(id), recordToUpdate);
		ret.updatedElement( this.fromSerializableId( recordToUpdate.getPrimaryKey()) );
		ret.setUpdatedElement( recordToUpdate );
		return ret;

	}

}
