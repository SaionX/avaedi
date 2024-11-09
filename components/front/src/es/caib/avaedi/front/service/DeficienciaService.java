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
import es.caib.avaedi.front.service.general.BaseService;
import es.caib.avaedi.logic.bo.DeficienciaBO;
import es.caib.avaedi.logic.bo.DeficienciaTipoBO;
import es.caib.avaedi.logic.bo.InspeccionBO;
import es.caib.avaedi.logic.vo.DeficienciaFormVO;
import es.caib.avaedi.logic.vo.DeficienciaListadoVO;
import es.caib.avaedi.logic.vo.InspeccionListadoVO;

/**
 * Servicio para tratar el formulario: Deficiencia
 * 
 * @author agarcia@at4.net
 * 
 */
@Service("deficiencia")
public class DeficienciaService extends BaseService<DeficienciaBO, DeficienciaListadoVO, DeficienciaFormVO> {

	/**
	 * The logger object.
	 */
	private static Logger log = LogService.getLogger(DeficienciaService.class);

	/**
	 * Bean para acceder a los métodos de negocio: Deficiencia
	 */
	@Autowired
	@Qualifier("DeficienciaBean")
	protected DeficienciaBO mainBO;

	/**
	 * Bean para acceder a los métodos de negocio: Deficiencia
	 * 
	 * @param bean
	 *            the bean to set
	 */
	protected DeficienciaBO getMainBO() {
		return this.mainBO;
	}

	/**
	 * Bean para acceder a los metodos de negocio: DeficienciaTipo
	 */
	@Autowired
	@Qualifier("DeficienciaTipoBean")
	private DeficienciaTipoBO deficienciaTipoBO;

	/**
	 * Bean para acceder a los metodos de negocio: DeficienciaTipo
	 * 
	 * @param bean
	 *            the bean to set
	 */
	public void setDeficienciaTipoBO(DeficienciaTipoBO bean) {
		this.deficienciaTipoBO = bean;
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
			formItem.setText(this.getMessage("forms.deficiencia.title", locale));
		}

		GridMetaData metaData = new GridMetaData(formItem);

		//Nombre de la clase js de formulario
		metaData.setFormClassName("DeficienciaForm");

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
		metaData.addRecordField(new GridRecordFieldMetaData("oid", "id", GridRecordFieldMetaData.INT_TYPE));

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("id", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("id", this.getMessage("forms.deficiencia.columns.id.header", locale)));
		metaData.getColumn("id").setGroupable(false);
		metaData.getColumn("id").setSortable(true);
		metaData.getColumn("id").setSofaFilter(GridColumnFilter.TYPE_NUMERIC);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("deficienciaTipoId", GridRecordFieldMetaData.INT_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("deficienciaTipoLabel", GridRecordFieldMetaData.INT_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("deficienciaTipo", "deficienciaTipoLabel", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("deficienciaTipo", this.getMessage("forms.deficiencia.columns.deficienciaTipo.header", locale)));
		metaData.getColumn("deficienciaTipo").setGroupable(true);
		metaData.getColumn("deficienciaTipo").setSortable(true);
		metaData.getColumn("deficienciaTipo").setSofaFilter(GridColumnFilter.TYPE_MULTICOMBO);
		metaData.getColumn("deficienciaTipo").setRelatedForm("DeficienciaTipo");

		metaData.getColumn("deficienciaTipo").setEditable(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("inspeccionId", GridRecordFieldMetaData.INT_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("inspeccionLabel", GridRecordFieldMetaData.INT_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("inspeccion", "inspeccionLabel", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("inspeccion", this.getMessage("forms.deficiencia.columns.inspeccion.header", locale)));
		metaData.getColumn("inspeccion").setGroupable(true);
		metaData.getColumn("inspeccion").setSortable(true);
		metaData.getColumn("inspeccion").setSofaFilter(GridColumnFilter.TYPE_MULTICOMBO);
		metaData.getColumn("inspeccion").setRelatedForm("Inspeccion");

		metaData.getColumn("inspeccion").setEditable(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("conservacionSistemasconstructivosTipoId", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("conservacionSistemasconstructivosTipoId", this.getMessage("forms.deficiencia.columns.conservacionSistemasconstructivosTipoId.header", locale)));
		metaData.getColumn("conservacionSistemasconstructivosTipoId").setTooltip(this.getMessage("forms.deficiencia.columns.conservacionSistemasconstructivosTipoId.description", locale));
		metaData.getColumn("conservacionSistemasconstructivosTipoId").setGroupable(false);
		metaData.getColumn("conservacionSistemasconstructivosTipoId").setSortable(true);
		metaData.getColumn("conservacionSistemasconstructivosTipoId").setSofaFilter(GridColumnFilter.TYPE_NUMERIC);

		metaData.getColumn("conservacionSistemasconstructivosTipoId").setEditable(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("descripcionDeficiencia", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("descripcionDeficiencia", this.getMessage("forms.deficiencia.columns.descripcionDeficiencia.header", locale)));
		metaData.getColumn("descripcionDeficiencia").setGroupable(false);
		metaData.getColumn("descripcionDeficiencia").setSortable(true);
		metaData.getColumn("descripcionDeficiencia").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("descripcionDeficiencia").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("descripcionDeficiencia").setEditable(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("esGrave", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("esGrave", this.getMessage("forms.deficiencia.columns.esGrave.header", locale)));
		metaData.getColumn("esGrave").setGroupable(false);
		metaData.getColumn("esGrave").setSortable(true);
		metaData.getColumn("esGrave").setSofaFilter(GridColumnFilter.TYPE_NUMERIC);

		metaData.getColumn("esGrave").setEditable(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("localizacionDeficiencia", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("localizacionDeficiencia", this.getMessage("forms.deficiencia.columns.localizacionDeficiencia.header", locale)));
		metaData.getColumn("localizacionDeficiencia").setGroupable(false);
		metaData.getColumn("localizacionDeficiencia").setSortable(true);
		metaData.getColumn("localizacionDeficiencia").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("localizacionDeficiencia").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("localizacionDeficiencia").setEditable(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("nombreDeficiencia", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("nombreDeficiencia", this.getMessage("forms.deficiencia.columns.nombreDeficiencia.header", locale)));
		metaData.getColumn("nombreDeficiencia").setGroupable(false);
		metaData.getColumn("nombreDeficiencia").setSortable(true);
		metaData.getColumn("nombreDeficiencia").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("nombreDeficiencia").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("nombreDeficiencia").setEditable(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("observaciones", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("observaciones", this.getMessage("forms.deficiencia.columns.observaciones.header", locale)));
		metaData.getColumn("observaciones").setGroupable(false);
		metaData.getColumn("observaciones").setSortable(true);
		metaData.getColumn("observaciones").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("observaciones").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("observaciones").setEditable(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("pruebasEnsayosRealizados", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("pruebasEnsayosRealizados", this.getMessage("forms.deficiencia.columns.pruebasEnsayosRealizados.header", locale)));
		metaData.getColumn("pruebasEnsayosRealizados").setGroupable(false);
		metaData.getColumn("pruebasEnsayosRealizados").setSortable(true);
		metaData.getColumn("pruebasEnsayosRealizados").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("pruebasEnsayosRealizados").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("pruebasEnsayosRealizados").setEditable(true);

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

		datosExportacion.add("id", this.getMessage("forms.deficiencia.columns.id.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("deficienciaTipo", this.getMessage("forms.deficiencia.columns.deficienciaTipo.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("inspeccion", this.getMessage("forms.deficiencia.columns.inspeccion.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("conservacionSistemasconstructivosTipoId", this.getMessage("forms.deficiencia.columns.conservacionSistemasconstructivosTipoId.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("descripcionDeficiencia", this.getMessage("forms.deficiencia.columns.descripcionDeficiencia.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("esGrave", this.getMessage("forms.deficiencia.columns.esGrave.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("localizacionDeficiencia", this.getMessage("forms.deficiencia.columns.localizacionDeficiencia.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("nombreDeficiencia", this.getMessage("forms.deficiencia.columns.nombreDeficiencia.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("observaciones", this.getMessage("forms.deficiencia.columns.observaciones.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("pruebasEnsayosRealizados", this.getMessage("forms.deficiencia.columns.pruebasEnsayosRealizados.header", locale), TipoCampoExportacion.STRING);

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
		DeficienciaListadoVO instance = (DeficienciaListadoVO) rawInstance;

		List<String> excelRow = new ArrayList<String>();

		excelRow.add(FormData2Java.toString(instance.getId()));
		excelRow.add(FormData2Java.toString(instance.getDeficienciaTipoLabel()));
		excelRow.add(FormData2Java.toString(instance.getInspeccionLabel()));
		excelRow.add(FormData2Java.toString(instance.getConservacionSistemasconstructivosTipoId()));
		excelRow.add(instance.getDescripcionDeficiencia());
		excelRow.add(FormData2Java.toString(instance.getEsGrave()));
		excelRow.add(instance.getLocalizacionDeficiencia());
		excelRow.add(instance.getNombreDeficiencia());
		excelRow.add(instance.getObservaciones());
		excelRow.add(instance.getPruebasEnsayosRealizados());
		excelRow.add(FormData2Java.toString(instance.getDateCreation()));
		excelRow.add(FormData2Java.toString(instance.getLastModified()));
		excelRow.add(instance.getCreatorUser());
		excelRow.add(instance.getModUser());

		return excelRow;

	}

	@Override
	public Serializable toSerializableId(String id) {

		return FormData2Java.toLong(id);

	}

	@Override
	public String fromSerializableId(Serializable id) {

		return FormData2Java.toString(id);

	}

	/**
	 * Rellena una instancia de DeficienciaFormVO con el contenido de un
	 * formulario recibido en formato Map<String, ?>
	 */
	protected void setFormData(DeficienciaFormVO record, Map<String, ?> formData) throws GenericBusinessException {
		String formDataStr = null;
		if (!StringUtils.isEmpty(formData, "deficienciaTipoId")) {
			formDataStr = (String) formData.get("deficienciaTipoId");
			record.setDeficienciaTipoId(FormData2Java.toInteger(formDataStr));

		}
		if (!StringUtils.isEmpty(formData, "inspeccionId")) {
			formDataStr = (String) formData.get("inspeccionId");
			record.setInspeccionId(FormData2Java.toInteger(formDataStr));

		}
		if (formData.containsKey("conservacionSistemasconstructivosTipoId")) {
			formDataStr = (String) formData.get("conservacionSistemasconstructivosTipoId");
			record.setConservacionSistemasconstructivosTipoId(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("descripcionDeficiencia")) {
			formDataStr = (String) formData.get("descripcionDeficiencia");
			record.setDescripcionDeficiencia(formDataStr);
		}
		if (formData.containsKey("esGrave")) {
			formDataStr = (String) formData.get("esGrave");
			record.setEsGrave(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("localizacionDeficiencia")) {
			formDataStr = (String) formData.get("localizacionDeficiencia");
			record.setLocalizacionDeficiencia(formDataStr);
		}
		if (formData.containsKey("nombreDeficiencia")) {
			formDataStr = (String) formData.get("nombreDeficiencia");
			record.setNombreDeficiencia(formDataStr);
		}
		if (formData.containsKey("observaciones")) {
			formDataStr = (String) formData.get("observaciones");
			record.setObservaciones(formDataStr);
		}
		if (formData.containsKey("pruebasEnsayosRealizados")) {
			formDataStr = (String) formData.get("pruebasEnsayosRealizados");
			record.setPruebasEnsayosRealizados(formDataStr);
		}
	}

}
