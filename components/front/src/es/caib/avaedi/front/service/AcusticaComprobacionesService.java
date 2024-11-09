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
import es.caib.avaedi.logic.bo.AcusticaComprobacionesBO;
import es.caib.avaedi.logic.bo.InspeccionBO;
import es.caib.avaedi.logic.util.Keys;
import es.caib.avaedi.logic.vo.AcusticaComprobacionesFormVO;
import es.caib.avaedi.logic.vo.AcusticaComprobacionesListadoVO;
import es.caib.avaedi.logic.vo.CimentacionesListadoVO;

/**
 * Servicio para tratar el formulario: AcusticaComprobaciones
 * 
 * @author agarcia@at4.net
 * 
 */
@Service("acusticacomprobaciones")
public class AcusticaComprobacionesService extends InspeccionBaseService<AcusticaComprobacionesBO, AcusticaComprobacionesListadoVO, AcusticaComprobacionesFormVO> {

	/**
	 * The logger object.
	 */
	private static Logger log = LogService.getLogger(AcusticaComprobacionesService.class);

	/**
	 * Bean para acceder a los métodos de negocio: AcusticaComprobaciones
	 */
	@Autowired
	@Qualifier("AcusticaComprobacionesBean")
	protected AcusticaComprobacionesBO mainBO;

	/**
	 * Bean para acceder a los métodos de negocio: AcusticaComprobaciones
	 * 
	 * @param bean
	 *            the bean to set
	 */
	protected AcusticaComprobacionesBO getMainBO() {
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
			formItem.setText(this.getMessage("forms.acusticacomprobaciones.title", locale));
		}

		GridMetaData metaData = this.getBaseMetaData(formItem, locale);

		//Nombre de la clase js de formulario
		metaData.setFormClassName("AcusticaComprobacionesForm");

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
		/*metaData.addColumn(new GridColumnMetaData("claveInforme", this.getMessage("forms.acusticacomprobaciones.columns.claveInforme.header", locale)));
		metaData.getColumn("claveInforme").setGroupable(false);
		metaData.getColumn("claveInforme").setSortable(true);
		metaData.getColumn("claveInforme").setSofaFilter(GridColumnFilter.TYPE_NUMERIC);*/

		//Creamos el registro para el record
		/*metaData.addRecordField(new GridRecordFieldMetaData("inspeccionId", GridRecordFieldMetaData.INT_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("inspeccionLabel", GridRecordFieldMetaData.INT_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("inspeccion", "inspeccionLabel", GridRecordFieldMetaData.INT_TYPE));*/

		/** Creamos la columna */
		/*metaData.addColumn(new GridColumnMetaData("inspeccion", this.getMessage("forms.acusticacomprobaciones.columns.inspeccion.header", locale)));
		metaData.getColumn("inspeccion").setGroupable(true);
		metaData.getColumn("inspeccion").setSortable(true);
		metaData.getColumn("inspeccion").setSofaFilter(GridColumnFilter.TYPE_MULTICOMBO);
		metaData.getColumn("inspeccion").setRelatedForm("Inspeccion");

		metaData.getColumn("inspeccion").setEditable(true);*/

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("calasCatasElementosConstructivos", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("calasCatasElementosConstructivos", this.getMessage("forms.acusticacomprobaciones.columns.calasCatasElementosConstructivos.header", locale)));
		metaData.getColumn("calasCatasElementosConstructivos").setTooltip(this.getMessage("forms.acusticacomprobaciones.columns.calasCatasElementosConstructivos.description", locale));
		metaData.getColumn("calasCatasElementosConstructivos").setGroupable(false);
		metaData.getColumn("calasCatasElementosConstructivos").setSortable(true);
		metaData.getColumn("calasCatasElementosConstructivos").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("calasCatasElementosConstructivos").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] calasCatasElementosConstructivosStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_COMPROBACIONES_SI), this.getMessage("forms.acusticacomprobaciones.columns.calasCatasElementosConstructivos." + Keys.ACUSTICA_COMPROBACIONES_SI, locale)},
				{ String.valueOf(Keys.ACUSTICA_COMPROBACIONES_NO), this.getMessage("forms.acusticacomprobaciones.columns.calasCatasElementosConstructivos." + Keys.ACUSTICA_COMPROBACIONES_NO, locale)},
		};

		metaData.getColumn("calasCatasElementosConstructivos").setSofaStoreValues(calasCatasElementosConstructivosStore);

		metaData.getColumn("calasCatasElementosConstructivos").setEditable(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("cuestionariosConfortAcustico", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("cuestionariosConfortAcustico", this.getMessage("forms.acusticacomprobaciones.columns.cuestionariosConfortAcustico.header", locale)));
		metaData.getColumn("cuestionariosConfortAcustico").setGroupable(false);
		metaData.getColumn("cuestionariosConfortAcustico").setSortable(true);
		metaData.getColumn("cuestionariosConfortAcustico").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("cuestionariosConfortAcustico").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] cuestionariosConfortAcusticoStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_COMPROBACIONES_SI), this.getMessage("forms.acusticacomprobaciones.columns.cuestionariosConfortAcustico." + Keys.ACUSTICA_COMPROBACIONES_SI, locale)},
				{ String.valueOf(Keys.ACUSTICA_COMPROBACIONES_NO), this.getMessage("forms.acusticacomprobaciones.columns.cuestionariosConfortAcustico." + Keys.ACUSTICA_COMPROBACIONES_NO, locale)},
		};

		metaData.getColumn("cuestionariosConfortAcustico").setSofaStoreValues(cuestionariosConfortAcusticoStore);

		metaData.getColumn("cuestionariosConfortAcustico").setEditable(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("medicionesAislamientoAcustico", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("medicionesAislamientoAcustico", this.getMessage("forms.acusticacomprobaciones.columns.medicionesAislamientoAcustico.header", locale)));
		metaData.getColumn("medicionesAislamientoAcustico").setTooltip(this.getMessage("forms.acusticacomprobaciones.columns.medicionesAislamientoAcustico.description", locale));
		metaData.getColumn("medicionesAislamientoAcustico").setGroupable(false);
		metaData.getColumn("medicionesAislamientoAcustico").setSortable(true);
		metaData.getColumn("medicionesAislamientoAcustico").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("medicionesAislamientoAcustico").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] medicionesAislamientoAcusticoStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_COMPROBACIONES_SI), this.getMessage("forms.acusticacomprobaciones.columns.medicionesAislamientoAcustico." + Keys.ACUSTICA_COMPROBACIONES_SI, locale)},
				{ String.valueOf(Keys.ACUSTICA_COMPROBACIONES_NO), this.getMessage("forms.acusticacomprobaciones.columns.medicionesAislamientoAcustico." + Keys.ACUSTICA_COMPROBACIONES_NO, locale)},
		};

		metaData.getColumn("medicionesAislamientoAcustico").setSofaStoreValues(medicionesAislamientoAcusticoStore);

		metaData.getColumn("medicionesAislamientoAcustico").setEditable(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("observaciones", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("observaciones", this.getMessage("forms.acusticacomprobaciones.columns.observaciones.header", locale)));
		metaData.getColumn("observaciones").setGroupable(false);
		metaData.getColumn("observaciones").setSortable(true);
		metaData.getColumn("observaciones").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("observaciones").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("observaciones").setEditable(true);
		metaData.getColumn("observaciones").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("otras", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("otras", this.getMessage("forms.acusticacomprobaciones.columns.otras.header", locale)));
		metaData.getColumn("otras").setGroupable(false);
		metaData.getColumn("otras").setSortable(true);
		metaData.getColumn("otras").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("otras").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] otrasStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_COMPROBACIONES_SI), this.getMessage("forms.acusticacomprobaciones.columns.otras." + Keys.ACUSTICA_COMPROBACIONES_SI, locale)},
				{ String.valueOf(Keys.ACUSTICA_COMPROBACIONES_NO), this.getMessage("forms.acusticacomprobaciones.columns.otras." + Keys.ACUSTICA_COMPROBACIONES_NO, locale)},
		};

		metaData.getColumn("otras").setSofaStoreValues(otrasStore);

		metaData.getColumn("otras").setEditable(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("otrasTexto", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("otrasTexto", this.getMessage("forms.acusticacomprobaciones.columns.otrasTexto.header", locale)));
		metaData.getColumn("otrasTexto").setGroupable(false);
		metaData.getColumn("otrasTexto").setSortable(true);
		metaData.getColumn("otrasTexto").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("otrasTexto").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("otrasTexto").setEditable(true);
		metaData.getColumn("otrasTexto").setHidden(true);

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

		datosExportacion.add("claveInforme", this.getMessage("forms.acusticacomprobaciones.columns.claveInforme.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("inspeccion", this.getMessage("forms.acusticacomprobaciones.columns.inspeccion.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("calasCatasElementosConstructivos", this.getMessage("forms.acusticacomprobaciones.columns.calasCatasElementosConstructivos.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("cuestionariosConfortAcustico", this.getMessage("forms.acusticacomprobaciones.columns.cuestionariosConfortAcustico.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("medicionesAislamientoAcustico", this.getMessage("forms.acusticacomprobaciones.columns.medicionesAislamientoAcustico.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("observaciones", this.getMessage("forms.acusticacomprobaciones.columns.observaciones.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("otras", this.getMessage("forms.acusticacomprobaciones.columns.otras.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("otrasTexto", this.getMessage("forms.acusticacomprobaciones.columns.otrasTexto.header", locale), TipoCampoExportacion.STRING);

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
		AcusticaComprobacionesListadoVO instance = (AcusticaComprobacionesListadoVO) rawInstance;

		List<String> excelRow = new ArrayList<String>();

		excelRow.add(FormData2Java.toString(instance.getClaveInforme()));
		excelRow.add(FormData2Java.toString(instance.getInspeccionLabel()));

		//excelRow.add(FormData2Java.toString(instance.getCalasCatasElementosConstructivos()));
		if (instance.getCalasCatasElementosConstructivos()!=null){
			excelRow.add( this.getMessage("forms.acusticacomprobaciones.columns.calasCatasElementosConstructivos." + instance.getCalasCatasElementosConstructivos(), locale) );
		}else{
			excelRow.add("null");
		}	

		//excelRow.add(FormData2Java.toString(instance.getCuestionariosConfortAcustico()));
		if (instance.getCuestionariosConfortAcustico()!=null){
			excelRow.add( this.getMessage("forms.acusticacomprobaciones.columns.cuestionariosConfortAcustico." + instance.getCuestionariosConfortAcustico(), locale) );
		}else{
			excelRow.add("null");
		}	

		//excelRow.add(FormData2Java.toString(instance.getMedicionesAislamientoAcustico()));
		if (instance.getMedicionesAislamientoAcustico()!=null){
			excelRow.add( this.getMessage("forms.acusticacomprobaciones.columns.medicionesAislamientoAcustico." + instance.getMedicionesAislamientoAcustico(), locale) );
		}else{
			excelRow.add("null");
		}	

		excelRow.add(instance.getObservaciones());

		//excelRow.add(FormData2Java.toString(instance.getOtras()));
		if (instance.getOtras()!=null){
			excelRow.add( this.getMessage("forms.acusticacomprobaciones.columns.otras." + instance.getOtras(), locale) );
		}else{
			excelRow.add("null");
		}	

		excelRow.add(instance.getOtrasTexto());
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
	 * Rellena una instancia de AcusticaComprobacionesFormVO con el contenido de
	 * un formulario recibido en formato Map<String, ?>
	 */
	protected void setFormData(AcusticaComprobacionesFormVO record, Map<String, ?> formData) throws GenericBusinessException {
		String formDataStr = null;
		if (!StringUtils.isEmpty(formData, "inspeccionId")) {
			formDataStr = (String) formData.get("inspeccionId");
			record.setInspeccionId(FormData2Java.toInteger(formDataStr));

		}
		if (formData.containsKey("calasCatasElementosConstructivos")) {
			formDataStr = (String) formData.get("calasCatasElementosConstructivos");
			record.setCalasCatasElementosConstructivos(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("cuestionariosConfortAcustico")) {
			formDataStr = (String) formData.get("cuestionariosConfortAcustico");
			record.setCuestionariosConfortAcustico(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("medicionesAislamientoAcustico")) {
			formDataStr = (String) formData.get("medicionesAislamientoAcustico");
			record.setMedicionesAislamientoAcustico(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("observaciones")) {
			formDataStr = (String) formData.get("observaciones");
			record.setObservaciones(formDataStr);
		}
		if (formData.containsKey("otras")) {
			formDataStr = (String) formData.get("otras");
			record.setOtras(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("otrasTexto")) {
			formDataStr = (String) formData.get("otrasTexto");
			record.setOtrasTexto(formDataStr);
		}
	}

}
