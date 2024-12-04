package es.caib.avaedi.front.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import es.caib.avaedi.logic.bo.TipusIee;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import es.caib.avaedi.at4forms.common.exception.GenericBusinessException;
import es.caib.avaedi.at4forms.common.realm.BaseFrontPrincipal;
import es.caib.avaedi.at4forms.common.search.DatosExportacion;
import es.caib.avaedi.at4forms.common.search.FilterConfig;
import es.caib.avaedi.at4forms.common.search.PagingConfig;
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
import es.caib.avaedi.at4forms.front.util.FileConstraints;
import es.caib.avaedi.at4forms.logic.vo.ListadoVO;
import es.caib.avaedi.common.realm.Constants;
import es.caib.avaedi.front.config.AuthUtils;
import es.caib.avaedi.front.service.general.BaseService;
import es.caib.avaedi.logic.bo.EdificioBO;
import es.caib.avaedi.logic.bo.EstadoInformeBO;
import es.caib.avaedi.logic.bo.InformeBO;
import es.caib.avaedi.logic.bo.InspeccionBO;
import es.caib.avaedi.logic.vo.AcusticasListadoVO;
import es.caib.avaedi.logic.vo.InformeFormVO;
import es.caib.avaedi.logic.vo.InformeListadoVO;

/**
 * Servicio para tratar el formulario: Informe
 * 
 * @author agarcia@at4.net
 * 
 */
@Service("informe")
public class InformeService extends BaseService<InformeBO, InformeListadoVO, InformeFormVO> {

	/**
	 * The logger object.
	 */
	private static Logger log = LogService.getLogger(InformeService.class);

	/**
	 * Bean para acceder a los métodos de negocio: Informe
	 */
	@Autowired
	@Qualifier("InformeBean")
	protected InformeBO mainBO;

	/**
	 * Bean para acceder a los métodos de negocio: Informe
	 * 
	 * @param bean
	 *            the bean to set
	 */
	protected InformeBO getMainBO() {
		return this.mainBO;
	}

	/**
	 * Bean para acceder a los metodos de negocio: EstadoInforme
	 */
	@Autowired
	@Qualifier("EstadoInformeBean")
	private EstadoInformeBO estadoInformeBO;

	/**
	 * Bean para acceder a los metodos de negocio: EstadoInforme
	 * 
	 * @param bean
	 *            the bean to set
	 */
	public void setEstadoInformeBO(EstadoInformeBO bean) {
		this.estadoInformeBO = bean;
	}

	/**
	 * Bean para acceder a los metodos de negocio: Edificio
	 */
	@Autowired
	@Qualifier("EdificioBean")
	private EdificioBO edificioBO;

	/**
	 * Bean para acceder a los metodos de negocio: Edificio
	 * 
	 * @param bean
	 *            the bean to set
	 */
	public void setEdificioBO(EdificioBO bean) {
		this.edificioBO = bean;
	}

	/**
	 * Bean para acceder a los metodos de negocio: Inspeccion
	 */
	@Autowired
	@Qualifier("InspeccionBean")
	private InspeccionBO inspeccionBO;

	/**
	 * Bean para acceder a los metodos de negocio: Inspeccion
	 * 
	 * @param bean
	 *            the bean to set
	 */
	public void setInspeccionBO(InspeccionBO bean) {
		this.inspeccionBO = bean;
	}

	@Override
	protected boolean hasPerms(BaseFrontPrincipal usuari, String action, InformeFormVO instance) {

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

	@Override
	public ResultadoBusqueda<InformeListadoVO> getListado(Collection<FilterConfig> filters, PagingConfig pagingConfig, BaseFrontPrincipal usuari, Locale locale) throws GenericBusinessException {
		this.addMunicipioFilter(filters, usuari);
		return super.getListado(filters, pagingConfig, usuari, locale);
	}

	private void addMunicipioFilter(Collection<FilterConfig> filters, BaseFrontPrincipal usuari) {
		String municipioId = AuthUtils.municipioId(usuari);
		if (!StringUtils.isEmpty(municipioId)) {

			//Añadimos el filtro de tipos de contrato
			filters.add(new FilterConfig(FilterConfig.TYPE_AUTO, "edificio.via.municipio.clave", municipioId));

		}

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
			formItem.setText(this.getMessage("forms.informe.title", locale));
		}

		GridMetaData metaData = new GridMetaData(formItem);

		//Nombre de la clase js de formulario
		metaData.setFormClassName("InformeForm");

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
		metaData.addColumn(new GridColumnMetaData("clave", this.getMessage("forms.informe.columns.clave.header", locale)));
		metaData.getColumn("clave").setGroupable(false);
		metaData.getColumn("clave").setSortable(true);
		metaData.getColumn("clave").setSofaFilter(GridColumnFilter.TYPE_NUMERIC);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("estadoInformeId", GridRecordFieldMetaData.INT_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("estadoInformeLabel", GridRecordFieldMetaData.STRING_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("estadoInforme", "estadoInformeLabel", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("estadoInforme", this.getMessage("forms.informe.columns.estadoInforme.header", locale)));
		metaData.getColumn("estadoInforme").setTooltip(this.getMessage("forms.informe.columns.estadoInforme.description", locale));
		metaData.getColumn("estadoInforme").setGroupable(true);
		metaData.getColumn("estadoInforme").setSortable(true);
		metaData.getColumn("estadoInforme").setSofaFilter(GridColumnFilter.TYPE_MULTICOMBO);
		metaData.getColumn("estadoInforme").setRelatedForm("EstadoInforme");

		metaData.getColumn("estadoInforme").setEditable(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("edificioId", GridRecordFieldMetaData.INT_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("edificioLabel", GridRecordFieldMetaData.STRING_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("edificio", "edificioLabel", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("edificio", this.getMessage("forms.informe.columns.edificio.header", locale)));
		metaData.getColumn("edificio").setGroupable(true);
		metaData.getColumn("edificio").setSortable(true);
		metaData.getColumn("edificio").setSofaFilter(GridColumnFilter.TYPE_MULTICOMBO);
		metaData.getColumn("edificio").setRelatedForm("Edificio");

		metaData.getColumn("edificio").setEditable(false);

		metaData.addRecordField(new GridRecordFieldMetaData("municipioId", GridRecordFieldMetaData.INT_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("municipioLabel", GridRecordFieldMetaData.STRING_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("municipio", "municipioLabel", GridRecordFieldMetaData.STRING_TYPE));

		// Creamos la columna
		//this.getMessage("forms.conservacion.columns.inspeccion.header", locale) 
		metaData.addColumn(new GridColumnMetaData("municipio", this.getMessage("forms.informe.columns.municipio.header", locale)));
		metaData.getColumn("municipio").setGroupable(true);
		metaData.getColumn("municipio").setSortable(true);
		metaData.getColumn("municipio").setSofaFilter(GridColumnFilter.TYPE_MULTICOMBO);
		metaData.getColumn("municipio").setRelatedForm("Municipio");

		metaData.getColumn("municipio").setEditable(false);
		
		
		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("fechaInforme", GridRecordFieldMetaData.DATE_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("fechaInforme", this.getMessage("forms.informe.columns.fechaInforme.header", locale)));
		metaData.getColumn("fechaInforme").setGroupable(true);
		metaData.getColumn("fechaInforme").setSortable(true);
		metaData.getColumn("fechaInforme").setSofaFilter(GridColumnFilter.TYPE_DATE);

		//TODO: debe ser date o datetime?
		metaData.getRecordField("fechaInforme").setDateFormat(this.getDateFormat());
		metaData.getColumn("fechaInforme").setSofaRenderer(GridColumnMetaData.RENDERER_DATE);
		log.info("(" + usuari.getUsername() + ") Fecha informe editable: " + usuari.isInAnyRole(Constants.ADMIN, Constants.OPERADOR));
		metaData.getColumn("fechaInforme").setEditable(usuari.isInAnyRole(Constants.ADMIN, Constants.OPERADOR));

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("fechaAlta", GridRecordFieldMetaData.DATE_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("fechaAlta", this.getMessage("forms.informe.columns.fechaAlta.header", locale)));
		metaData.getColumn("fechaAlta").setGroupable(true);
		metaData.getColumn("fechaAlta").setSortable(true);
		metaData.getColumn("fechaAlta").setSofaFilter(GridColumnFilter.TYPE_DATE);

		//TODO: debe ser date o datetime?
		metaData.getRecordField("fechaAlta").setDateFormat(this.getDateFormat());
		metaData.getColumn("fechaAlta").setSofaRenderer(GridColumnMetaData.RENDERER_DATE);

		metaData.getColumn("fechaAlta").setEditable(true);


		// Informe de 30/50 anys
//		metaData.addRecordField(new GridRecordFieldMetaData("tipusIeeId", GridRecordFieldMetaData.INT_TYPE));
//		metaData.addRecordField(new GridRecordFieldMetaData("tipusIeeLabel", GridRecordFieldMetaData.STRING_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("tipusIeeCodi", this.getMessage("forms.informe.columns.tipusIee.header", locale), GridRecordFieldMetaData.STRING_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("tipusIeeLabel", this.getMessage("forms.informe.columns.tipusIee.header", locale), GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("tipusIeeLabel", this.getMessage("forms.informe.columns.tipusIee.header", locale)));
		metaData.getColumn("tipusIeeLabel").setTooltip(this.getMessage("forms.informe.columns.tipusIee.description", locale));
		metaData.getColumn("tipusIeeLabel").setGroupable(false);
		metaData.getColumn("tipusIeeLabel").setSortable(false);
		metaData.getColumn("tipusIeeLabel").setSofaFilter(GridColumnFilter.TYPE_MULTICOMBO);
		metaData.getColumn("tipusIeeLabel").setEditable(usuari.isInAnyRole(Constants.ADMIN, Constants.OPERADOR));
		metaData.getColumn("tipusIeeLabel").setWidth(120);
//		metaData.getColumn("tipusIee").setSofaRenderer("tipusIeeRenderer");


		// Renovació
		metaData.addRecordField(new GridRecordFieldMetaData("renovacio", this.getMessage("forms.informe.columns.renovacio.header", locale), GridRecordFieldMetaData.BOOLEAN_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("renovacio", this.getMessage("forms.informe.columns.renovacio.header", locale)));
		metaData.getColumn("renovacio").setTooltip(this.getMessage("forms.informe.columns.renovacio.description", locale));
		metaData.getColumn("renovacio").setGroupable(false);
		metaData.getColumn("renovacio").setSortable(false);
		metaData.getColumn("renovacio").setSofaFilter(GridColumnFilter.TYPE_MULTICOMBO);
		metaData.getColumn("renovacio").setEditable(usuari.isInAnyRole(Constants.ADMIN, Constants.OPERADOR));
		metaData.getColumn("renovacio").setSofaRenderer(GridColumnMetaData.RENDERER_BOOLEAN);

		return metaData;
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

		datosExportacion.add("clave", this.getMessage("forms.informe.columns.clave.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("estadoInforme", this.getMessage("forms.informe.columns.estadoInforme.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("edificio", this.getMessage("forms.informe.columns.edificio.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("municipio", this.getMessage("forms.informe.columns.municipio.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("fechaInforme", this.getMessage("forms.informe.columns.fechaInforme.header", locale), TipoCampoExportacion.DATE);
		datosExportacion.add("fechaAlta", this.getMessage("forms.informe.columns.fechaAlta.header", locale), TipoCampoExportacion.DATE);
		datosExportacion.add("tipusIee", this.getMessage("forms.informe.columns.tipusIee.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("renovacio", this.getMessage("forms.informe.columns.renovacio.header", locale), TipoCampoExportacion.STRING);

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
		InformeListadoVO instance = (InformeListadoVO) rawInstance;

		List<String> excelRow = new ArrayList<String>();

		excelRow.add(FormData2Java.toString(instance.getClave()));
		excelRow.add(instance.getEstadoInformeLabel());
		excelRow.add(instance.getEdificioLabel());
		excelRow.add(instance.getMunicipioLabel());
		excelRow.add(FormData2Java.toString(instance.getFechaInforme()));
		excelRow.add(FormData2Java.toString(instance.getFechaAlta()));
		excelRow.add(FormData2Java.toString(instance.getDateCreation()));
		excelRow.add(FormData2Java.toString(instance.getLastModified()));
		excelRow.add(instance.getTipusIee().getText());
		excelRow.add(instance.getRenovacio() != null ? (instance.getRenovacio() ? "SI" : "NO") : "");
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
	 * Rellena una instancia de InformeFormVO con el contenido de un formulario
	 * recibido en formato Map<String, ?>
	 */
	protected void setFormData(InformeFormVO record, Map<String, ?> formData) throws GenericBusinessException {
		String formDataStr = null;
		if (FormData2Java.needsUpdate(formData, "estadoInformeId")) {
			formDataStr = (String) formData.get("estadoInformeId");
			record.setEstadoInformeId(FormData2Java.toInteger(formDataStr));
		}
//		if (FormData2Java.needsUpdate(formData, "edificioId")) {
//			formDataStr = (String) formData.get("edificioId");
//			record.setEdificioId(FormData2Java.toInteger(formDataStr));
//
//		}
		if (FormData2Java.needsUpdate(formData, "fechaInforme")) {
			formDataStr = (String) formData.get("fechaInforme");
			record.setFechaInforme(FormData2Java.toDate(formDataStr));
		}
//		if (FormData2Java.needsUpdate(formData, "fechaAlta")) {
//			formDataStr = (String) formData.get("fechaAlta");
//			record.setFechaAlta(FormData2Java.toDate(formDataStr));
//		}
		if (FormData2Java.needsUpdate(formData, "tipusIee")) {
			formDataStr = (String) formData.get("tipusIee");
			record.setTipusIee(TipusIee.fromName(formDataStr));
		}
	}

	@Override
	public FileConstraints obtenerFileConstraints(String docname) {

		/*
		 * Ejemplos: return new FileConstraints(3024, "pdf"); //pdf de 3MB
		 * máximo return new FileConstraints("pdf,zip); //pdf, zip (sin máximo
		 * de MB)
		 */

		if ("ieeArxiu".equals(docname)) {
			/* TODO: fijar FileConstraints para "ieeArxiu" */
			//return new FileConstraints ( maxKB, "ext1,extN" );
		}

		if ("pdfArxiu".equals(docname)) {
			/* TODO: fijar FileConstraints para "pdfArxiu" */
			//return new FileConstraints ( maxKB, "ext1,extN" );
		}

		return new FileConstraints();
	}

}
