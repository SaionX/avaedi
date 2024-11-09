package es.caib.avaedi.front.service;

import java.io.Serializable;
import java.util.ArrayList;
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
import es.caib.avaedi.front.service.general.InspeccionBaseService;
import es.caib.avaedi.logic.bo.CimentacionesBO;
import es.caib.avaedi.logic.bo.InspeccionBO;
import es.caib.avaedi.logic.vo.AcusticasListadoVO;
import es.caib.avaedi.logic.vo.CimentacionesFormVO;
import es.caib.avaedi.logic.vo.CimentacionesListadoVO;

/**
 * Servicio para tratar el formulario: Cimentaciones
 * 
 * @author agarcia@at4.net
 * 
 */
@Service("cimentaciones")
public class CimentacionesService extends InspeccionBaseService<CimentacionesBO, CimentacionesListadoVO, CimentacionesFormVO> {

	/**
	 * The logger object.
	 */
	private static Logger log = LogService.getLogger(CimentacionesService.class);

	/**
	 * Bean para acceder a los métodos de negocio: Cimentaciones
	 */
	@Autowired
	@Qualifier("CimentacionesBean")
	protected CimentacionesBO mainBO;

	/**
	 * Bean para acceder a los métodos de negocio: Cimentaciones
	 * 
	 * @param bean
	 *            the bean to set
	 */
	protected CimentacionesBO getMainBO() {
		return this.mainBO;
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
			formItem.setText(this.getMessage("forms.cimentaciones.title", locale));
		}

		GridMetaData metaData = this.getBaseMetaData(formItem, locale);

		//Nombre de la clase js de formulario
		metaData.setFormClassName("CimentacionesForm");

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
		//metaData.addRecordField(new GridRecordFieldMetaData("oid", "claveInforme", GridRecordFieldMetaData.INT_TYPE));

		//Creamos el registro para el record
		//metaData.addRecordField(new GridRecordFieldMetaData("claveInforme", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		/*metaData.addColumn(new GridColumnMetaData("claveInforme", this.getMessage("forms.cimentaciones.columns.claveInforme.header", locale)));
		metaData.getColumn("claveInforme").setGroupable(false);
		metaData.getColumn("claveInforme").setSortable(true);
		metaData.getColumn("claveInforme").setSofaFilter(GridColumnFilter.TYPE_NUMERIC);*/

		//Creamos el registro para el record
		/*metaData.addRecordField(new GridRecordFieldMetaData("inspeccionId", GridRecordFieldMetaData.INT_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("inspeccionLabel", GridRecordFieldMetaData.INT_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("inspeccion", "inspeccionLabel", GridRecordFieldMetaData.INT_TYPE));*/

		/** Creamos la columna */
		/*metaData.addColumn(new GridColumnMetaData("inspeccion", this.getMessage("forms.cimentaciones.columns.inspeccion.header", locale)));
		metaData.getColumn("inspeccion").setGroupable(true);
		metaData.getColumn("inspeccion").setSortable(true);
		metaData.getColumn("inspeccion").setSofaFilter(GridColumnFilter.TYPE_MULTICOMBO);
		metaData.getColumn("inspeccion").setRelatedForm("Inspeccion");

		metaData.getColumn("inspeccion").setEditable(true);*/

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("cimentacionprofundaTexto", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("cimentacionprofundaTexto", this.getMessage("forms.cimentaciones.columns.cimentacionprofundaTexto.header", locale)));
		metaData.getColumn("cimentacionprofundaTexto").setGroupable(false);
		metaData.getColumn("cimentacionprofundaTexto").setSortable(true);
		metaData.getColumn("cimentacionprofundaTexto").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("cimentacionprofundaTexto").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("cimentacionprofundaTexto").setEditable(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("cimentacionsuperficialTexto", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("cimentacionsuperficialTexto", this.getMessage("forms.cimentaciones.columns.cimentacionsuperficialTexto.header", locale)));
		metaData.getColumn("cimentacionsuperficialTexto").setGroupable(false);
		metaData.getColumn("cimentacionsuperficialTexto").setSortable(true);
		metaData.getColumn("cimentacionsuperficialTexto").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("cimentacionsuperficialTexto").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("cimentacionsuperficialTexto").setEditable(true);

		/*//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("observaciones", GridRecordFieldMetaData.STRING_TYPE));

		// Creamos la columna
		metaData.addColumn(new GridColumnMetaData("observaciones", this.getMessage("forms.cimentaciones.columns.observaciones.header", locale)));
		metaData.getColumn("observaciones").setGroupable(false);
		metaData.getColumn("observaciones").setSortable(true);
		metaData.getColumn("observaciones").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("observaciones").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("observaciones").setEditable(true);*/

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("sistemascontencionTexto", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("sistemascontencionTexto", this.getMessage("forms.cimentaciones.columns.sistemascontencionTexto.header", locale)));
		metaData.getColumn("sistemascontencionTexto").setGroupable(false);
		metaData.getColumn("sistemascontencionTexto").setSortable(true);
		metaData.getColumn("sistemascontencionTexto").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("sistemascontencionTexto").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("sistemascontencionTexto").setEditable(true);

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

		datosExportacion.add("claveInforme", this.getMessage("forms.cimentaciones.columns.claveInforme.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("inspeccion", this.getMessage("forms.cimentaciones.columns.inspeccion.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("cimentacionprofundaTexto", this.getMessage("forms.cimentaciones.columns.cimentacionprofundaTexto.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("cimentacionsuperficialTexto", this.getMessage("forms.cimentaciones.columns.cimentacionsuperficialTexto.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("observaciones", this.getMessage("forms.cimentaciones.columns.observaciones.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("sistemascontencionTexto", this.getMessage("forms.cimentaciones.columns.sistemascontencionTexto.header", locale), TipoCampoExportacion.STRING);

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
		CimentacionesListadoVO instance = (CimentacionesListadoVO) rawInstance;

		List<String> excelRow = new ArrayList<String>();

		excelRow.add(FormData2Java.toString(instance.getClaveInforme()));
		excelRow.add(FormData2Java.toString(instance.getInspeccionLabel()));
		excelRow.add(instance.getCimentacionprofundaTexto());
		excelRow.add(instance.getCimentacionsuperficialTexto());
		excelRow.add(instance.getObservaciones());
		excelRow.add(instance.getSistemascontencionTexto());
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
	 * Rellena una instancia de CimentacionesFormVO con el contenido de un
	 * formulario recibido en formato Map<String, ?>
	 */
	protected void setFormData(CimentacionesFormVO record, Map<String, ?> formData) throws GenericBusinessException {
		String formDataStr = null;
		if (!StringUtils.isEmpty(formData, "inspeccionId")) {
			formDataStr = (String) formData.get("inspeccionId");
			record.setInspeccionId(FormData2Java.toInteger(formDataStr));

		}
		if (!StringUtils.isEmpty(formData, "cimentacionprofundaTexto")) {
			formDataStr = (String) formData.get("cimentacionprofundaTexto");
			record.setCimentacionprofundaTexto(formDataStr);
		}
		if (formData.containsKey("cimentacionsuperficialTexto")) {
			formDataStr = (String) formData.get("cimentacionsuperficialTexto");
			record.setCimentacionsuperficialTexto(formDataStr);
		}
		if (formData.containsKey("observaciones")) {
			formDataStr = (String) formData.get("observaciones");
			record.setObservaciones(formDataStr);
		}
		if (formData.containsKey("sistemascontencionTexto")) {
			formDataStr = (String) formData.get("sistemascontencionTexto");
			record.setSistemascontencionTexto(formDataStr);
		}
	}

}
