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
import es.caib.avaedi.logic.bo.AccesibilidadAjustesRazonablesBO;
import es.caib.avaedi.logic.bo.InspeccionBO;
import es.caib.avaedi.logic.util.Keys;
import es.caib.avaedi.logic.vo.AccesibilidadAjustesRazonablesFormVO;
import es.caib.avaedi.logic.vo.AccesibilidadAjustesRazonablesListadoVO;
import es.caib.avaedi.logic.vo.CimentacionesListadoVO;

/**
 * Servicio para tratar el formulario: AccesibilidadAjustesRazonables
 * 
 * @author agarcia@at4.net
 * 
 */
@Service("accesibilidadajustesrazonables")
public class AccesibilidadAjustesRazonablesService extends InspeccionBaseService<AccesibilidadAjustesRazonablesBO, AccesibilidadAjustesRazonablesListadoVO, AccesibilidadAjustesRazonablesFormVO> {

	/**
	 * The logger object.
	 */
	private static Logger log = LogService.getLogger(AccesibilidadAjustesRazonablesService.class);

	/**
	 * Bean para acceder a los métodos de negocio:
	 * AccesibilidadAjustesRazonables
	 */
	@Autowired
	@Qualifier("AccesibilidadAjustesRazonablesBean")
	protected AccesibilidadAjustesRazonablesBO mainBO;

	/**
	 * Bean para acceder a los métodos de negocio:
	 * AccesibilidadAjustesRazonables
	 * 
	 * @param bean
	 *            the bean to set
	 */
	protected AccesibilidadAjustesRazonablesBO getMainBO() {
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
			formItem.setText(this.getMessage("forms.accesibilidadajustesrazonables.title", locale));
		}

		GridMetaData metaData = this.getBaseMetaData(formItem, locale);

		//Nombre de la clase js de formulario
		metaData.setFormClassName("AccesibilidadAjustesRazonablesForm");

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
		/*metaData.addColumn(new GridColumnMetaData("claveInforme", this.getMessage("forms.accesibilidadajustesrazonables.columns.claveInforme.header", locale)));
		metaData.getColumn("claveInforme").setGroupable(false);
		metaData.getColumn("claveInforme").setSortable(true);
		metaData.getColumn("claveInforme").setSofaFilter(GridColumnFilter.TYPE_NUMERIC);*/

		//Creamos el registro para el record
		/*metaData.addRecordField(new GridRecordFieldMetaData("inspeccionId", GridRecordFieldMetaData.INT_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("inspeccionLabel", GridRecordFieldMetaData.INT_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("inspeccion", "inspeccionLabel", GridRecordFieldMetaData.INT_TYPE));*/

		/** Creamos la columna */
		/*metaData.addColumn(new GridColumnMetaData("inspeccion", this.getMessage("forms.accesibilidadajustesrazonables.columns.inspeccion.header", locale)));
		metaData.getColumn("inspeccion").setGroupable(true);
		metaData.getColumn("inspeccion").setSortable(true);
		metaData.getColumn("inspeccion").setSofaFilter(GridColumnFilter.TYPE_MULTICOMBO);
		metaData.getColumn("inspeccion").setRelatedForm("Inspeccion");

		metaData.getColumn("inspeccion").setEditable(true);*/

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("ajustesrazonablesCoste", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("ajustesrazonablesCoste", this.getMessage("forms.accesibilidadajustesrazonables.columns.ajustesrazonablesCoste.header", locale)));
		metaData.getColumn("ajustesrazonablesCoste").setGroupable(false);
		metaData.getColumn("ajustesrazonablesCoste").setSortable(true);
		metaData.getColumn("ajustesrazonablesCoste").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("ajustesrazonablesCoste").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("ajustesrazonablesCoste").setEditable(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("financiacionayuda", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("financiacionayuda", this.getMessage("forms.accesibilidadajustesrazonables.columns.financiacionayuda.header", locale)));
		metaData.getColumn("financiacionayuda").setGroupable(false);
		metaData.getColumn("financiacionayuda").setSortable(true);
		metaData.getColumn("financiacionayuda").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("financiacionayuda").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("financiacionayuda").setEditable(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("importegastoscomunes", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("importegastoscomunes", this.getMessage("forms.accesibilidadajustesrazonables.columns.importegastoscomunes.header", locale)));
		metaData.getColumn("importegastoscomunes").setGroupable(false);
		metaData.getColumn("importegastoscomunes").setSortable(true);
		metaData.getColumn("importegastoscomunes").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("importegastoscomunes").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("importegastoscomunes").setEditable(true);
	

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("edificionosusceptibleajustes", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("edificionosusceptibleajustes", this.getMessage("forms.accesibilidadajustesrazonables.columns.edificionosusceptibleajustes.header", locale)));
		metaData.getColumn("edificionosusceptibleajustes").setGroupable(false);
		metaData.getColumn("edificionosusceptibleajustes").setSortable(true);
		metaData.getColumn("edificionosusceptibleajustes").setSofaFilter(GridColumnFilter.TYPE_LIST);
		
		metaData.getColumn("edificionosusceptibleajustes").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] edificionosusceptibleajustesStore = new String[][]{
				{ String.valueOf(Keys.ACCESIBILIDAD_AJUSTES_RAZONABLES_SI), this.getMessage("forms.accesibilidadajustesrazonables.columns.edificionosusceptibleajustes." + Keys.ACCESIBILIDAD_AJUSTES_RAZONABLES_SI, locale)},
				{ String.valueOf(Keys.ACCESIBILIDAD_AJUSTES_RAZONABLES_NO), this.getMessage("forms.accesibilidadajustesrazonables.columns.edificionosusceptibleajustes." + Keys.ACCESIBILIDAD_AJUSTES_RAZONABLES_NO, locale)},
		};

		metaData.getColumn("edificionosusceptibleajustes").setSofaStoreValues(edificionosusceptibleajustesStore);

		metaData.getColumn("edificionosusceptibleajustes").setEditable(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("edificiosusceptibleajustesTotal", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("edificiosusceptibleajustesTotal", this.getMessage("forms.accesibilidadajustesrazonables.columns.edificiosusceptibleajustesTotal.header", locale)));
		metaData.getColumn("edificiosusceptibleajustesTotal").setTooltip(this.getMessage("forms.accesibilidadajustesrazonables.columns.edificiosusceptibleajustesTotal.description", locale));
		metaData.getColumn("edificiosusceptibleajustesTotal").setGroupable(false);
		metaData.getColumn("edificiosusceptibleajustesTotal").setSortable(true);
		metaData.getColumn("edificiosusceptibleajustesTotal").setSofaFilter(GridColumnFilter.TYPE_LIST);
		
		metaData.getColumn("edificiosusceptibleajustesTotal").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] edificiosusceptibleajustesTotalStore = new String[][]{
				{ String.valueOf(Keys.ACCESIBILIDAD_AJUSTES_RAZONABLES_SI), this.getMessage("forms.accesibilidadajustesrazonables.columns.edificiosusceptibleajustesTotal." + Keys.ACCESIBILIDAD_AJUSTES_RAZONABLES_SI, locale)},
				{ String.valueOf(Keys.ACCESIBILIDAD_AJUSTES_RAZONABLES_NO), this.getMessage("forms.accesibilidadajustesrazonables.columns.edificiosusceptibleajustesTotal." + Keys.ACCESIBILIDAD_AJUSTES_RAZONABLES_NO, locale)},
		};

		metaData.getColumn("edificiosusceptibleajustesTotal").setSofaStoreValues(edificiosusceptibleajustesTotalStore);

		metaData.getColumn("edificiosusceptibleajustesTotal").setEditable(true);

	
		
		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("ajustesrazonablesDescripcion", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("ajustesrazonablesDescripcion", this.getMessage("forms.accesibilidadajustesrazonables.columns.ajustesrazonablesDescripcion.header", locale)));
		metaData.getColumn("ajustesrazonablesDescripcion").setGroupable(false);
		metaData.getColumn("ajustesrazonablesDescripcion").setSortable(true);
		metaData.getColumn("ajustesrazonablesDescripcion").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("ajustesrazonablesDescripcion").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("ajustesrazonablesDescripcion").setEditable(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("observacionesAnalisisNoMedidas", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("observacionesAnalisisNoMedidas", this.getMessage("forms.accesibilidadajustesrazonables.columns.observacionesAnalisisNoMedidas.header", locale)));
		metaData.getColumn("observacionesAnalisisNoMedidas").setTooltip(this.getMessage("forms.accesibilidadajustesrazonables.columns.observacionesAnalisisNoMedidas.description", locale));
		metaData.getColumn("observacionesAnalisisNoMedidas").setGroupable(false);
		metaData.getColumn("observacionesAnalisisNoMedidas").setSortable(true);
		metaData.getColumn("observacionesAnalisisNoMedidas").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("observacionesAnalisisNoMedidas").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("observacionesAnalisisNoMedidas").setEditable(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("observacionesCargaeconomica", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("observacionesCargaeconomica", this.getMessage("forms.accesibilidadajustesrazonables.columns.observacionesCargaeconomica.header", locale)));
		metaData.getColumn("observacionesCargaeconomica").setGroupable(false);
		metaData.getColumn("observacionesCargaeconomica").setSortable(true);
		metaData.getColumn("observacionesCargaeconomica").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("observacionesCargaeconomica").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("observacionesCargaeconomica").setEditable(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("observacionesConsideracionesinmueble", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("observacionesConsideracionesinmueble", this.getMessage("forms.accesibilidadajustesrazonables.columns.observacionesConsideracionesinmueble.header", locale)));
		metaData.getColumn("observacionesConsideracionesinmueble").setTooltip(this.getMessage("forms.accesibilidadajustesrazonables.columns.observacionesConsideracionesinmueble.description", locale));
		metaData.getColumn("observacionesConsideracionesinmueble").setGroupable(false);
		metaData.getColumn("observacionesConsideracionesinmueble").setSortable(true);
		metaData.getColumn("observacionesConsideracionesinmueble").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("observacionesConsideracionesinmueble").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("observacionesConsideracionesinmueble").setEditable(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("personasdiscapacitadasomayores", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("personasdiscapacitadasomayores", this.getMessage("forms.accesibilidadajustesrazonables.columns.personasdiscapacitadasomayores.header", locale)));
		metaData.getColumn("personasdiscapacitadasomayores").setGroupable(false);
		metaData.getColumn("personasdiscapacitadasomayores").setSortable(true);
		metaData.getColumn("personasdiscapacitadasomayores").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("personasdiscapacitadasomayores").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("personasdiscapacitadasomayores").setEditable(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("viviendasnoitinerarioaccesible", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("viviendasnoitinerarioaccesible", this.getMessage("forms.accesibilidadajustesrazonables.columns.viviendasnoitinerarioaccesible.header", locale)));
		metaData.getColumn("viviendasnoitinerarioaccesible").setTooltip(this.getMessage("forms.accesibilidadajustesrazonables.columns.viviendasnoitinerarioaccesible.description", locale));
		metaData.getColumn("viviendasnoitinerarioaccesible").setGroupable(false);
		metaData.getColumn("viviendasnoitinerarioaccesible").setSortable(true);
		metaData.getColumn("viviendasnoitinerarioaccesible").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("viviendasnoitinerarioaccesible").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("viviendasnoitinerarioaccesible").setEditable(true);

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

		datosExportacion.add("claveInforme", this.getMessage("forms.accesibilidadajustesrazonables.columns.claveInforme.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("inspeccion", this.getMessage("forms.accesibilidadajustesrazonables.columns.inspeccion.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("ajustesrazonablesCoste", this.getMessage("forms.accesibilidadajustesrazonables.columns.ajustesrazonablesCoste.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("ajustesrazonablesDescripcion", this.getMessage("forms.accesibilidadajustesrazonables.columns.ajustesrazonablesDescripcion.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("edificionosusceptibleajustes", this.getMessage("forms.accesibilidadajustesrazonables.columns.edificionosusceptibleajustes.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("edificiosusceptibleajustesTotal", this.getMessage("forms.accesibilidadajustesrazonables.columns.edificiosusceptibleajustesTotal.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("financiacionayuda", this.getMessage("forms.accesibilidadajustesrazonables.columns.financiacionayuda.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("importegastoscomunes", this.getMessage("forms.accesibilidadajustesrazonables.columns.importegastoscomunes.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("observacionesAnalisisNoMedidas", this.getMessage("forms.accesibilidadajustesrazonables.columns.observacionesAnalisisNoMedidas.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("observacionesCargaeconomica", this.getMessage("forms.accesibilidadajustesrazonables.columns.observacionesCargaeconomica.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("observacionesConsideracionesinmueble", this.getMessage("forms.accesibilidadajustesrazonables.columns.observacionesConsideracionesinmueble.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("personasdiscapacitadasomayores", this.getMessage("forms.accesibilidadajustesrazonables.columns.personasdiscapacitadasomayores.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("viviendasnoitinerarioaccesible", this.getMessage("forms.accesibilidadajustesrazonables.columns.viviendasnoitinerarioaccesible.header", locale), TipoCampoExportacion.STRING);

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
		AccesibilidadAjustesRazonablesListadoVO instance = (AccesibilidadAjustesRazonablesListadoVO) rawInstance;

		List<String> excelRow = new ArrayList<String>();

		excelRow.add(FormData2Java.toString(instance.getClaveInforme()));
		excelRow.add(FormData2Java.toString(instance.getInspeccionLabel()));
		excelRow.add(instance.getAjustesrazonablesCoste());
		excelRow.add(instance.getAjustesrazonablesDescripcion());
		//excelRow.add(FormData2Java.toString(instance.getEdificionosusceptibleajustes()));
		if (instance.getEdificionosusceptibleajustes()!=null){
			excelRow.add( this.getMessage("forms.accesibilidadajustesrazonables.columns.edificionosusceptibleajustes." + instance.getEdificionosusceptibleajustes(), locale) );
		}else{
			excelRow.add("null");
		}
		
		//excelRow.add(FormData2Java.toString(instance.getEdificiosusceptibleajustesTotal()));
		if (instance.getEdificionosusceptibleajustes()!=null){
			excelRow.add( this.getMessage("forms.accesibilidadajustesrazonables.columns.edificiosusceptibleajustesTotal." + instance.getEdificiosusceptibleajustesTotal(), locale) );
		}else{
			excelRow.add("null");
		}	
		excelRow.add(instance.getFinanciacionayuda());
		excelRow.add(instance.getImportegastoscomunes());
		excelRow.add(instance.getObservacionesAnalisisNoMedidas());
		excelRow.add(instance.getObservacionesCargaeconomica());
		excelRow.add(instance.getObservacionesConsideracionesinmueble());
		excelRow.add(instance.getPersonasdiscapacitadasomayores());
		excelRow.add(instance.getViviendasnoitinerarioaccesible());
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
	 * Rellena una instancia de AccesibilidadAjustesRazonablesFormVO con el
	 * contenido de un formulario recibido en formato Map<String, ?>
	 */
	protected void setFormData(AccesibilidadAjustesRazonablesFormVO record, Map<String, ?> formData) throws GenericBusinessException {
		String formDataStr = null;
		if (!StringUtils.isEmpty(formData, "inspeccionId")) {
			formDataStr = (String) formData.get("inspeccionId");
			record.setInspeccionId(FormData2Java.toInteger(formDataStr));

		}
		if (formData.containsKey("ajustesrazonablesCoste")) {
			formDataStr = (String) formData.get("ajustesrazonablesCoste");
			record.setAjustesrazonablesCoste(formDataStr);
		}
		if (formData.containsKey("ajustesrazonablesDescripcion")) {
			formDataStr = (String) formData.get("ajustesrazonablesDescripcion");
			record.setAjustesrazonablesDescripcion(formDataStr);
		}
		if (formData.containsKey("edificionosusceptibleajustes")) {
			formDataStr = (String) formData.get("edificionosusceptibleajustes");
			record.setEdificionosusceptibleajustes(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("edificiosusceptibleajustesTotal")) {
			formDataStr = (String) formData.get("edificiosusceptibleajustesTotal");
			record.setEdificiosusceptibleajustesTotal(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("financiacionayuda")) {
			formDataStr = (String) formData.get("financiacionayuda");
			record.setFinanciacionayuda(formDataStr);
		}
		if (formData.containsKey("importegastoscomunes")) {
			formDataStr = (String) formData.get("importegastoscomunes");
			record.setImportegastoscomunes(formDataStr);
		}
		if (formData.containsKey("observacionesAnalisisNoMedidas")) {
			formDataStr = (String) formData.get("observacionesAnalisisNoMedidas");
			record.setObservacionesAnalisisNoMedidas(formDataStr);
		}
		if (formData.containsKey("observacionesCargaeconomica")) {
			formDataStr = (String) formData.get("observacionesCargaeconomica");
			record.setObservacionesCargaeconomica(formDataStr);
		}
		if (formData.containsKey("observacionesConsideracionesinmueble")) {
			formDataStr = (String) formData.get("observacionesConsideracionesinmueble");
			record.setObservacionesConsideracionesinmueble(formDataStr);
		}
		if (formData.containsKey("personasdiscapacitadasomayores")) {
			formDataStr = (String) formData.get("personasdiscapacitadasomayores");
			record.setPersonasdiscapacitadasomayores(formDataStr);
		}
		if (formData.containsKey("viviendasnoitinerarioaccesible")) {
			formDataStr = (String) formData.get("viviendasnoitinerarioaccesible");
			record.setViviendasnoitinerarioaccesible(formDataStr);
		}
	}

}
