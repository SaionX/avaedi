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
import es.caib.avaedi.logic.bo.AcusticasBO;
import es.caib.avaedi.logic.bo.InspeccionBO;
import es.caib.avaedi.logic.util.Keys;
import es.caib.avaedi.logic.vo.AcusticasFormVO;
import es.caib.avaedi.logic.vo.AcusticasListadoVO;

/**
 * Servicio para tratar el formulario: Acusticas
 * 
 * @author agarcia@at4.net
 * 
 */
@Service("acusticas")
public class AcusticasService extends InspeccionBaseService<AcusticasBO, AcusticasListadoVO, AcusticasFormVO> {

	/**
	 * The logger object.
	 */
	private static Logger log = LogService.getLogger(AcusticasService.class);

	/**
	 * Bean para acceder a los métodos de negocio: Acusticas
	 */
	@Autowired
	@Qualifier("AcusticasBean")
	protected AcusticasBO mainBO;

	/**
	 * Bean para acceder a los métodos de negocio: Acusticas
	 * 
	 * @param bean
	 *            the bean to set
	 */
	protected AcusticasBO getMainBO() {
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
			formItem.setText(this.getMessage("forms.acusticas.title", locale));
		}

		GridMetaData metaData = this.getBaseMetaData(formItem, locale);

		//Nombre de la clase js de formulario
		metaData.setFormClassName("AcusticasForm");

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
		/*metaData.addColumn(new GridColumnMetaData("claveInforme", this.getMessage("forms.acusticas.columns.claveInforme.header", locale)));
		metaData.getColumn("claveInforme").setGroupable(false);
		metaData.getColumn("claveInforme").setSortable(true);
		metaData.getColumn("claveInforme").setSofaFilter(GridColumnFilter.TYPE_NUMERIC);*/

		//Creamos el registro para el record
		/*metaData.addRecordField(new GridRecordFieldMetaData("inspeccionId", GridRecordFieldMetaData.INT_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("inspeccionLabel", GridRecordFieldMetaData.INT_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("inspeccion", "inspeccionLabel", GridRecordFieldMetaData.INT_TYPE));*/

		/** Creamos la columna */
		/*metaData.addColumn(new GridColumnMetaData("inspeccion", this.getMessage("forms.acusticas.columns.inspeccion.header", locale)));
		metaData.getColumn("inspeccion").setGroupable(true);
		metaData.getColumn("inspeccion").setSortable(true);
		metaData.getColumn("inspeccion").setSofaFilter(GridColumnFilter.TYPE_MULTICOMBO);
		metaData.getColumn("inspeccion").setRelatedForm("Inspeccion");

		metaData.getColumn("inspeccion").setEditable(true);*/

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("esTecnicoInspeccion", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("esTecnicoInspeccion", this.getMessage("forms.acusticas.columns.esTecnicoInspeccion.header", locale)));
		metaData.getColumn("esTecnicoInspeccion").setGroupable(false);
		metaData.getColumn("esTecnicoInspeccion").setSortable(true);
		metaData.getColumn("esTecnicoInspeccion").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("esTecnicoInspeccion").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] esTecnicoInspeccionStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICAS_SI), this.getMessage("forms.acusticas.columns.esTecnicoInspeccion." + Keys.ACUSTICAS_SI, locale)},
				{ String.valueOf(Keys.ACUSTICAS_NO), this.getMessage("forms.acusticas.columns.esTecnicoInspeccion." + Keys.ACUSTICAS_NO, locale)},
		};

		metaData.getColumn("esTecnicoInspeccion").setSofaStoreValues(esTecnicoInspeccionStore);

		metaData.getColumn("esTecnicoInspeccion").setEditable(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("incluirInformeAcustica", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("incluirInformeAcustica", this.getMessage("forms.acusticas.columns.incluirInformeAcustica.header", locale)));
		metaData.getColumn("incluirInformeAcustica").setGroupable(false);
		metaData.getColumn("incluirInformeAcustica").setSortable(true);
		metaData.getColumn("incluirInformeAcustica").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("incluirInformeAcustica").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] incluirInformeAcusticaStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICAS_SI), this.getMessage("forms.acusticas.columns.incluirInformeAcustica." + Keys.ACUSTICAS_SI, locale)},
				{ String.valueOf(Keys.ACUSTICAS_NO), this.getMessage("forms.acusticas.columns.incluirInformeAcustica." + Keys.ACUSTICAS_NO, locale)},
		};

		metaData.getColumn("incluirInformeAcustica").setSofaStoreValues(incluirInformeAcusticaStore);

		metaData.getColumn("incluirInformeAcustica").setEditable(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("nif", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("nif", this.getMessage("forms.acusticas.columns.nif.header", locale)));
		metaData.getColumn("nif").setGroupable(false);
		metaData.getColumn("nif").setSortable(true);
		metaData.getColumn("nif").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("nif").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("nif").setEditable(true);

		/*//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("observaciones", GridRecordFieldMetaData.STRING_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("observaciones", this.getMessage("forms.acusticas.columns.observaciones.header", locale)));
		metaData.getColumn("observaciones").setGroupable(false);
		metaData.getColumn("observaciones").setSortable(true);
		metaData.getColumn("observaciones").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("observaciones").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("observaciones").setEditable(true);*/

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("tecnico", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("tecnico", this.getMessage("forms.acusticas.columns.tecnico.header", locale)));
		metaData.getColumn("tecnico").setGroupable(false);
		metaData.getColumn("tecnico").setSortable(true);
		metaData.getColumn("tecnico").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("tecnico").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("tecnico").setEditable(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("titulacion", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("titulacion", this.getMessage("forms.acusticas.columns.titulacion.header", locale)));
		metaData.getColumn("titulacion").setGroupable(false);
		metaData.getColumn("titulacion").setSortable(true);
		metaData.getColumn("titulacion").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("titulacion").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("titulacion").setEditable(true);

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

		datosExportacion.add("claveInforme", this.getMessage("forms.acusticas.columns.claveInforme.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("inspeccion", this.getMessage("forms.acusticas.columns.inspeccion.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("esTecnicoInspeccion", this.getMessage("forms.acusticas.columns.esTecnicoInspeccion.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("incluirInformeAcustica", this.getMessage("forms.acusticas.columns.incluirInformeAcustica.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("nif", this.getMessage("forms.acusticas.columns.nif.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("observaciones", this.getMessage("forms.acusticas.columns.observaciones.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("tecnico", this.getMessage("forms.acusticas.columns.tecnico.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("titulacion", this.getMessage("forms.acusticas.columns.titulacion.header", locale), TipoCampoExportacion.STRING);

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
		AcusticasListadoVO instance = (AcusticasListadoVO) rawInstance;

		List<String> excelRow = new ArrayList<String>();

		excelRow.add(FormData2Java.toString(instance.getClaveInforme()));
		excelRow.add(FormData2Java.toString(instance.getInspeccionLabel()));
		//excelRow.add(FormData2Java.toString(instance.getEsTecnicoInspeccion()));
		if (instance.getEsTecnicoInspeccion()!=null){
			excelRow.add( this.getMessage("forms.acusticas.columns.esTecnicoInspeccion." + instance.getEsTecnicoInspeccion(), locale) );
		}else{
			excelRow.add("null");
		}	

		//excelRow.add(instance.getIncluirInformeAcustica());
		if (instance.getIncluirInformeAcustica()!=null){
			excelRow.add( this.getMessage("forms.acusticas.columns.incluirInformeAcustica." + instance.getIncluirInformeAcustica(), locale) );
		}else{
			excelRow.add("null");
		}	

		excelRow.add(instance.getNif());
		excelRow.add(instance.getObservaciones());
		excelRow.add(instance.getTecnico());
		excelRow.add(instance.getTitulacion());
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
	 * Rellena una instancia de AcusticasFormVO con el contenido de un
	 * formulario recibido en formato Map<String, ?>
	 */
	protected void setFormData(AcusticasFormVO record, Map<String, ?> formData) throws GenericBusinessException {
		String formDataStr = null;
		if (!StringUtils.isEmpty(formData, "inspeccionId")) {
			formDataStr = (String) formData.get("inspeccionId");
			record.setInspeccionId(FormData2Java.toInteger(formDataStr));

		}
		if (formData.containsKey("esTecnicoInspeccion")) {
			formDataStr = (String) formData.get("esTecnicoInspeccion");
			record.setEsTecnicoInspeccion(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("incluirInformeAcustica")) {
			formDataStr = (String) formData.get("incluirInformeAcustica");
			record.setIncluirInformeAcustica(formDataStr);
		}
		if (formData.containsKey("nif")) {
			formDataStr = (String) formData.get("nif");
			record.setNif(formDataStr);
		}
		if (formData.containsKey("observaciones")) {
			formDataStr = (String) formData.get("observaciones");
			record.setObservaciones(formDataStr);
		}
		if (formData.containsKey("tecnico")) {
			formDataStr = (String) formData.get("tecnico");
			record.setTecnico(formDataStr);
		}
		if (formData.containsKey("titulacion")) {
			formDataStr = (String) formData.get("titulacion");
			record.setTitulacion(formDataStr);
		}
	}


}
