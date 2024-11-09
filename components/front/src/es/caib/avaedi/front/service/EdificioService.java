package es.caib.avaedi.front.service;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
import es.caib.avaedi.logic.bo.EdificioBO;
import es.caib.avaedi.logic.bo.InformeBO;
import es.caib.avaedi.logic.bo.ViaBO;
import es.caib.avaedi.logic.vo.EdificioFormVO;
import es.caib.avaedi.logic.vo.EdificioListadoVO;
import es.caib.avaedi.logic.vo.InformeFormVO;
import es.caib.avaedi.logic.vo.InspeccionListadoVO;

/**
 * Servicio para tratar el formulario: Edificio
 * 
 * @author agarcia@at4.net
 * 
 */
@Service("edificio")
public class EdificioService extends BaseService<EdificioBO, EdificioListadoVO, EdificioFormVO> {

	/**
	 * The logger object.
	 */
	private static Logger log = LogService.getLogger(EdificioService.class);

	/**
	 * Bean para acceder a los métodos de negocio: Edificio
	 */
	@Autowired
	@Qualifier("EdificioBean")
	protected EdificioBO mainBO;

	/**
	 * Bean para acceder a los métodos de negocio: Edificio
	 * 
	 * @param bean
	 *            the bean to set
	 */
	protected EdificioBO getMainBO() {
		return this.mainBO;
	}

	/**
	 * Bean para acceder a los metodos de negocio: Via
	 */
	@Autowired
	@Qualifier("ViaBean")
	private ViaBO viaBO;

	/**
	 * Bean para acceder a los metodos de negocio: Via
	 * 
	 * @param bean
	 *            the bean to set
	 */
	public void setViaBO(ViaBO bean) {
		this.viaBO = bean;
	}

	/**
	 * Bean para acceder a los metodos de negocio: Informe
	 */
	@Autowired
	@Qualifier("InformeBean")
	private InformeBO informeBO;

	/**
	 * Bean para acceder a los metodos de negocio: Informe
	 * 
	 * @param bean
	 *            the bean to set
	 */
	public void setInformeBO(InformeBO bean) {
		this.informeBO = bean;
	}

	@Override
	protected boolean hasPerms(BaseFrontPrincipal usuari, String action, EdificioFormVO instance) {

		if (instance != null) {
			//Estamos actuando sobre una instancia en concreto, aquí comprobamos que el usuario tenga acceso al municipio 
			if (!AuthUtils.hasAccess(usuari, instance.getMunicipioId())) {
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
			formItem.setText(this.getMessage("forms.edificio.title", locale));
		}

		GridMetaData metaData = new GridMetaData(formItem);

		//Nombre de la clase js de formulario
		metaData.setFormClassName("EdificioForm");

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
		metaData.addColumn(new GridColumnMetaData("clave", this.getMessage("forms.edificio.columns.clave.header", locale)));
		metaData.getColumn("clave").setGroupable(false);
		metaData.getColumn("clave").setSortable(true);
		metaData.getColumn("clave").setSofaFilter(GridColumnFilter.TYPE_NUMERIC);

		metaData.addRecordField(new GridRecordFieldMetaData("municipioId", GridRecordFieldMetaData.INT_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("municipioLabel", GridRecordFieldMetaData.STRING_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("municipio", "municipioLabel", GridRecordFieldMetaData.STRING_TYPE));

		// Creamos la columna
		//this.getMessage("forms.conservacion.columns.inspeccion.header", locale) 
		metaData.addColumn(new GridColumnMetaData("municipio", this.getMessage("forms.edificio.columns.municipio.header", locale)));
		metaData.getColumn("municipio").setGroupable(true);
		metaData.getColumn("municipio").setSortable(true);
		metaData.getColumn("municipio").setSofaFilter(GridColumnFilter.TYPE_MULTICOMBO);
		metaData.getColumn("municipio").setRelatedForm("Municipio");

		metaData.getColumn("municipio").setEditable(false);
		
		
		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("viaId", GridRecordFieldMetaData.INT_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("viaLabel", GridRecordFieldMetaData.STRING_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("via", "viaLabel", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("via", this.getMessage("forms.edificio.columns.via.header", locale)));
		metaData.getColumn("via").setGroupable(true);
		metaData.getColumn("via").setSortable(true);
		metaData.getColumn("via").setSofaFilter(GridColumnFilter.TYPE_MULTICOMBO);
		metaData.getColumn("via").setRelatedForm("Via");

		metaData.getColumn("via").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("via").setEditable(false);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("numeroCatastro", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("numeroCatastro", this.getMessage("forms.edificio.columns.numeroCatastro.header", locale)));
		metaData.getColumn("numeroCatastro").setTooltip(this.getMessage("forms.edificio.columns.numeroCatastro.description", locale));
		metaData.getColumn("numeroCatastro").setGroupable(false);
		metaData.getColumn("numeroCatastro").setSortable(true);
		metaData.getColumn("numeroCatastro").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("numeroCatastro").setEditable(false);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("numeroExtra", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("numeroExtra", this.getMessage("forms.edificio.columns.numeroExtra.header", locale)));
		metaData.getColumn("numeroExtra").setTooltip(this.getMessage("forms.edificio.columns.numeroExtra.description", locale));
		metaData.getColumn("numeroExtra").setGroupable(false);
		metaData.getColumn("numeroExtra").setSortable(true);
		metaData.getColumn("numeroExtra").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("numeroExtra").setEditable(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("referenciaCatastral", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("referenciaCatastral", this.getMessage("forms.edificio.columns.referenciaCatastral.header", locale)));
		metaData.getColumn("referenciaCatastral").setTooltip(this.getMessage("forms.edificio.columns.referenciaCatastral.description", locale));
		metaData.getColumn("referenciaCatastral").setGroupable(false);
		metaData.getColumn("referenciaCatastral").setSortable(true);
		metaData.getColumn("referenciaCatastral").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("referenciaCatastral").setEditable(false);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("antiguedad", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("antiguedad", this.getMessage("forms.edificio.columns.antiguedad.header", locale)));
		metaData.getColumn("antiguedad").setTooltip(this.getMessage("forms.edificio.columns.antiguedad.description", locale));
		metaData.getColumn("antiguedad").setGroupable(false);
		metaData.getColumn("antiguedad").setSortable(true);
		metaData.getColumn("antiguedad").setSofaFilter(GridColumnFilter.TYPE_NUMERIC);

		metaData.getColumn("antiguedad").setEditable(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("centroX", GridRecordFieldMetaData.AUTO_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("centroX", this.getMessage("forms.edificio.columns.centroX.header", locale)));
		metaData.getColumn("centroX").setTooltip(this.getMessage("forms.edificio.columns.centroX.description", locale));
		metaData.getColumn("centroX").setGroupable(true);
		metaData.getColumn("centroX").setSortable(true);
		metaData.getColumn("centroX").setSofaFilter(GridColumnFilter.TYPE_MULTICOMBO);

		metaData.getColumn("centroX").setEditable(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("centroY", GridRecordFieldMetaData.AUTO_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("centroY", this.getMessage("forms.edificio.columns.centroY.header", locale)));
		metaData.getColumn("centroY").setTooltip(this.getMessage("forms.edificio.columns.centroY.description", locale));
		metaData.getColumn("centroY").setGroupable(true);
		metaData.getColumn("centroY").setSortable(true);
		metaData.getColumn("centroY").setSofaFilter(GridColumnFilter.TYPE_MULTICOMBO);

		metaData.getColumn("centroY").setEditable(true);

		return metaData;
	}

	@Override
	public ResultadoBusqueda<EdificioListadoVO> getListado(Collection<FilterConfig> filters, PagingConfig pagingConfig, BaseFrontPrincipal usuari, Locale locale) throws GenericBusinessException {
		this.addMunicipioFilter(filters, usuari);
		return super.getListado(filters, pagingConfig, usuari, locale);
	}

	private void addMunicipioFilter(Collection<FilterConfig> filters, BaseFrontPrincipal usuari) {
		String municipioId = AuthUtils.municipioId(usuari);
		if (!StringUtils.isEmpty(municipioId)) {

			//Añadimos el filtro de tipos de contrato
			filters.add(new FilterConfig(FilterConfig.TYPE_AUTO, "via.municipio.clave", municipioId));

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

		datosExportacion.add("clave", this.getMessage("forms.edificio.columns.clave.header", locale), TipoCampoExportacion.NUMBER);
		//TODO:
		datosExportacion.add("municipio", this.getMessage("forms.edificio.columns.municipio.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("via", this.getMessage("forms.edificio.columns.via.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("numeroCatastro", this.getMessage("forms.edificio.columns.numeroCatastro.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("numeroExtra", this.getMessage("forms.edificio.columns.numeroExtra.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("referenciaCatastral", this.getMessage("forms.edificio.columns.referenciaCatastral.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("antiguedad", this.getMessage("forms.edificio.columns.antiguedad.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("centroX", this.getMessage("forms.edificio.columns.centroX.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("centroY", this.getMessage("forms.edificio.columns.centroY.header", locale), TipoCampoExportacion.NUMBER);

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
		EdificioListadoVO instance = (EdificioListadoVO) rawInstance;

		List<String> excelRow = new ArrayList<String>();

		excelRow.add(FormData2Java.toString(instance.getClave()));
		excelRow.add(instance.getMunicipioLabel());
		excelRow.add(instance.getViaLabel());
		excelRow.add(instance.getNumeroCatastro());
		excelRow.add(instance.getNumeroExtra());
		excelRow.add(instance.getReferenciaCatastral());
		excelRow.add(FormData2Java.toString(instance.getAntiguedad()));
		BigDecimal centrox = instance.getCentroX();
		BigDecimal centroy = instance.getCentroY();
		excelRow.add(centrox==null? "0.0" : centrox.toString());
		excelRow.add(centroy==null? "0.0" : centroy.toString());
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
	 * Rellena una instancia de EdificioFormVO con el contenido de un formulario
	 * recibido en formato Map<String, ?>
	 */
	protected void setFormData(EdificioFormVO record, Map<String, ?> formData) throws GenericBusinessException {
		String formDataStr = null;
		/*if (FormData2Java.needsUpdate(formData, "viaId")) {
			formDataStr = (String) formData.get("viaId");
			record.setViaId(FormData2Java.toInteger(formDataStr));

		}
		if (formData.containsKey("numeroCatastro")) {
			formDataStr = (String) formData.get("numeroCatastro");
			record.setNumeroCatastro(formDataStr);
		}*/
		if (FormData2Java.needsUpdate(formData, "numeroExtra")) {
			formDataStr = (String) formData.get("numeroExtra");
			record.setNumeroExtra(formDataStr);
		}
		/*if (FormData2Java.needsUpdate(formData, "referenciaCatastral")) {
			formDataStr = (String) formData.get("referenciaCatastral");
			record.setReferenciaCatastral(formDataStr);
		}*/
		if (FormData2Java.needsUpdate(formData, "antiguedad")) {
			formDataStr = (String) formData.get("antiguedad");
			record.setAntiguedad(FormData2Java.toInteger(formDataStr));
		}
		if (FormData2Java.needsUpdate(formData, "centroX")) {
			formDataStr = (String) formData.get("centroX");
			record.setCentroX(FormData2Java.toBigDecimal(formDataStr));
		}
		if (FormData2Java.needsUpdate(formData, "centroY")) {
			formDataStr = (String) formData.get("centroY");
			record.setCentroY(FormData2Java.toBigDecimal(formDataStr));
		}
	}

	/**
	 * Rellena una instancia de InformeFormVO con el contenido de un formulario
	 * recibido en formato Map<String, ?>
	 */
	protected void setFormData(InformeFormVO record, Map<String, ?> formData) throws GenericBusinessException {
		String formDataStr = null;
		if (FormData2Java.needsUpdate(formData, "estadoInformeId")) {
			formDataStr = (String) formData.get("estadoInformeId");
			record.setEstadoInformeId(FormData2Java.toInteger(formDataStr));

		}
		if (FormData2Java.needsUpdate(formData, "edificioId")) {
			formDataStr = (String) formData.get("edificioId");
			record.setEdificioId(FormData2Java.toInteger(formDataStr));

		}
		if (FormData2Java.needsUpdate(formData, "fechaInforme")) {
			formDataStr = (String) formData.get("fechaInforme");
			record.setFechaInforme(FormData2Java.toDate(formDataStr));
		}
		if (FormData2Java.needsUpdate(formData, "fechaAlta")) {
			formDataStr = (String) formData.get("fechaAlta");
			record.setFechaAlta(FormData2Java.toDate(formDataStr));
		}
	}

	@Override
	public ResultadoActualizacion addSubForm(Map<String, ?> formData, String id, String subFormName, BaseFrontPrincipal usuari, Locale locale) throws GenericBusinessException {

		EdificioFormVO instance = this.mainBO.load(FormData2Java.toInteger(id));
		//Comprueba permisos de alta
		this.checkPerms(usuari, PERMS_UPDATE, instance, locale);

		if (subFormName.equals("informes")) {
			ResultadoActualizacion ret = new ResultadoActualizacion();
			InformeFormVO newRecord = new InformeFormVO();
			this.setFormData(newRecord, formData);
			newRecord.setEdificioId(instance.getClave());

			//Fija los campos automáticos
			java.util.Date ahora = new java.util.Date();
			newRecord.setDateCreation(ahora);
			newRecord.setLastModified(ahora);
			newRecord.setCreatorUser(usuari.getUsername());
			newRecord.setModUser(usuari.getUsername());

			newRecord = this.informeBO.add(newRecord);
			ret.addedElement(String.valueOf(newRecord.getClave()));
			ret.setUpdatedElement(newRecord);
			return ret;

		}

		return super.addSubForm(formData, id, subFormName, usuari, locale);

	}

	@Override
	public ResultadoActualizacion deleteSubForm(String id, String subFormName, String subId, BaseFrontPrincipal usuari, Locale locale) throws GenericBusinessException {

		EdificioFormVO instance = this.mainBO.load(FormData2Java.toInteger(id));
		this.checkPerms(usuari, PERMS_UPDATE, instance, locale);

		if (subFormName.equals("informes")) {
			InformeFormVO recordToDelete = this.informeBO.load(FormData2Java.toInteger(subId));
			if (!((Serializable) recordToDelete.getEdificioId()).equals(instance.getClave())) {
				String error = this.getMessage("forms.errors.instanciaOriginal", locale);
				log.error(error);
				throw new GenericBusinessException(error);
			}
			this.informeBO.delete(recordToDelete.getClave());
			ResultadoActualizacion ret = new ResultadoActualizacion();
			ret.deletedElement(subId);
			return ret;
		}

		return super.deleteSubForm(id, subFormName, subId, usuari, locale);

	}

	@Override
	public ResultadoActualizacion updateSubForm(String id, Map<String, ?> formData, String subFormName, String subId, BaseFrontPrincipal usuari, Locale locale) throws GenericBusinessException {

		EdificioFormVO instance = this.mainBO.load(FormData2Java.toInteger(id));
		//Comprueba permisos de actualización
		this.checkPerms(usuari, PERMS_UPDATE, instance, locale);

		if (subFormName.equals("informes")) {
			InformeFormVO recordToUpdate = this.informeBO.load(FormData2Java.toInteger(subId));
			if (!((Serializable) recordToUpdate.getEdificioId()).equals(instance.getClave())) {
				String error = this.getMessage("forms.errors.instanciaOriginal", locale);
				log.error(error);
				throw new GenericBusinessException(error);
			}
			this.setFormData(recordToUpdate, formData);
			//Fija los campos automáticos
			recordToUpdate.setLastModified(new java.util.Date());
			recordToUpdate.setModUser(usuari.getUsername());

			ResultadoActualizacion ret = new ResultadoActualizacion();
			recordToUpdate = informeBO.update(recordToUpdate.getClave(), recordToUpdate);

			ret.setUpdatedElement(recordToUpdate);
			ret.updatedElement(subId);
			return ret;
		}

		return super.updateSubForm(id, formData, subFormName, subId, usuari, locale);

	}

}
