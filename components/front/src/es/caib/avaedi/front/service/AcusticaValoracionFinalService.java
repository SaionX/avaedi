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
import es.caib.avaedi.logic.bo.AcusticaValoracionFinalBO;
import es.caib.avaedi.logic.bo.InspeccionBO;
import es.caib.avaedi.logic.util.Keys;
import es.caib.avaedi.logic.vo.AcusticaValoracionFinalFormVO;
import es.caib.avaedi.logic.vo.AcusticaValoracionFinalListadoVO;
import es.caib.avaedi.logic.vo.AcusticasListadoVO;

/**
 * Servicio para tratar el formulario: AcusticaValoracionFinal
 * 
 * @author agarcia@at4.net
 * 
 */
@Service("acusticavaloracionfinal")
public class AcusticaValoracionFinalService extends InspeccionBaseService<AcusticaValoracionFinalBO, AcusticaValoracionFinalListadoVO, AcusticaValoracionFinalFormVO> {

	/**
	 * The logger object.
	 */
	private static Logger log = LogService.getLogger(AcusticaValoracionFinalService.class);

	/**
	 * Bean para acceder a los métodos de negocio: AcusticaValoracionFinal
	 */
	@Autowired
	@Qualifier("AcusticaValoracionFinalBean")
	protected AcusticaValoracionFinalBO mainBO;

	/**
	 * Bean para acceder a los métodos de negocio: AcusticaValoracionFinal
	 * 
	 * @param bean
	 *            the bean to set
	 */
	protected AcusticaValoracionFinalBO getMainBO() {
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
			formItem.setText(this.getMessage("forms.acusticavaloracionfinal.title", locale));
		}

		GridMetaData metaData = this.getBaseMetaData(formItem, locale);

		//Nombre de la clase js de formulario
		metaData.setFormClassName("AcusticaValoracionFinalForm");

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
		/*metaData.addColumn(new GridColumnMetaData("claveInforme", this.getMessage("forms.acusticavaloracionfinal.columns.claveInforme.header", locale)));
		metaData.getColumn("claveInforme").setGroupable(false);
		metaData.getColumn("claveInforme").setSortable(true);
		metaData.getColumn("claveInforme").setSofaFilter(GridColumnFilter.TYPE_NUMERIC);*/

		//Creamos el registro para el record
		/*metaData.addRecordField(new GridRecordFieldMetaData("inspeccionId", GridRecordFieldMetaData.INT_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("inspeccionLabel", GridRecordFieldMetaData.INT_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("inspeccion", "inspeccionLabel", GridRecordFieldMetaData.INT_TYPE));*/

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("inspeccion", this.getMessage("forms.acusticavaloracionfinal.columns.inspeccion.header", locale)));
		metaData.getColumn("inspeccion").setGroupable(true);
		metaData.getColumn("inspeccion").setSortable(true);
		metaData.getColumn("inspeccion").setSofaFilter(GridColumnFilter.TYPE_MULTICOMBO);
		metaData.getColumn("inspeccion").setRelatedForm("Inspeccion");

		metaData.getColumn("inspeccion").setEditable(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("observaciones", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("observaciones", this.getMessage("forms.acusticavaloracionfinal.columns.observaciones.header", locale)));
		metaData.getColumn("observaciones").setGroupable(false);
		metaData.getColumn("observaciones").setSortable(true);
		metaData.getColumn("observaciones").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("observaciones").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("observaciones").setEditable(true);
		metaData.getColumn("observaciones").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("proteccionRuidoExteriorTipoId", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("proteccionRuidoExteriorTipoId", this.getMessage("forms.acusticavaloracionfinal.columns.proteccionRuidoExteriorTipoId.header", locale)));
		metaData.getColumn("proteccionRuidoExteriorTipoId").setTooltip(this.getMessage("forms.acusticavaloracionfinal.columns.proteccionRuidoExteriorTipoId.description", locale));
		metaData.getColumn("proteccionRuidoExteriorTipoId").setGroupable(false);
		metaData.getColumn("proteccionRuidoExteriorTipoId").setSortable(true);
		metaData.getColumn("proteccionRuidoExteriorTipoId").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("proteccionRuidoExteriorTipoId").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] proteccionRuidoExteriorTipoIdStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_VALORACION_DEFICIENTE), this.getMessage("forms.acusticavaloracionfinal.columns.proteccionRuidoExteriorTipoId." + Keys.ACUSTICA_VALORACION_DEFICIENTE, locale)},
				{ String.valueOf(Keys.ACUSTICA_VALORACION_REGULAR), this.getMessage("forms.acusticavaloracionfinal.columns.proteccionRuidoExteriorTipoId." + Keys.ACUSTICA_VALORACION_REGULAR, locale)},
				{ String.valueOf(Keys.ACUSTICA_VALORACION_RAZONABLE), this.getMessage("forms.acusticavaloracionfinal.columns.proteccionRuidoExteriorTipoId." + Keys.ACUSTICA_VALORACION_RAZONABLE, locale)},
				{ String.valueOf(Keys.ACUSTICA_VALORACION_BUENO), this.getMessage("forms.acusticavaloracionfinal.columns.proteccionRuidoExteriorTipoId." + Keys.ACUSTICA_VALORACION_BUENO, locale)},
		};

		metaData.getColumn("proteccionRuidoExteriorTipoId").setSofaStoreValues(proteccionRuidoExteriorTipoIdStore);

		metaData.getColumn("proteccionRuidoExteriorTipoId").setEditable(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("proteccionRuidoInstalacionesTipoId", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("proteccionRuidoInstalacionesTipoId", this.getMessage("forms.acusticavaloracionfinal.columns.proteccionRuidoInstalacionesTipoId.header", locale)));
		metaData.getColumn("proteccionRuidoInstalacionesTipoId").setTooltip(this.getMessage("forms.acusticavaloracionfinal.columns.proteccionRuidoInstalacionesTipoId.description", locale));
		metaData.getColumn("proteccionRuidoInstalacionesTipoId").setGroupable(false);
		metaData.getColumn("proteccionRuidoInstalacionesTipoId").setSortable(true);
		metaData.getColumn("proteccionRuidoInstalacionesTipoId").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("proteccionRuidoInstalacionesTipoId").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] proteccionRuidoInstalacionesTipoIdStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_VALORACION_DEFICIENTE), this.getMessage("forms.acusticavaloracionfinal.columns.proteccionRuidoInstalacionesTipoId." + Keys.ACUSTICA_VALORACION_DEFICIENTE, locale)},
				{ String.valueOf(Keys.ACUSTICA_VALORACION_REGULAR), this.getMessage("forms.acusticavaloracionfinal.columns.proteccionRuidoInstalacionesTipoId." + Keys.ACUSTICA_VALORACION_REGULAR, locale)},
				{ String.valueOf(Keys.ACUSTICA_VALORACION_RAZONABLE), this.getMessage("forms.acusticavaloracionfinal.columns.proteccionRuidoInstalacionesTipoId." + Keys.ACUSTICA_VALORACION_RAZONABLE, locale)},
				{ String.valueOf(Keys.ACUSTICA_VALORACION_BUENO), this.getMessage("forms.acusticavaloracionfinal.columns.proteccionRuidoInstalacionesTipoId." + Keys.ACUSTICA_VALORACION_BUENO, locale)},
		};

		metaData.getColumn("proteccionRuidoInstalacionesTipoId").setSofaStoreValues(proteccionRuidoInstalacionesTipoIdStore);

		metaData.getColumn("proteccionRuidoInstalacionesTipoId").setEditable(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("proteccionRuidoInteriorAereoHorizontalTipoId", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("proteccionRuidoInteriorAereoHorizontalTipoId", this.getMessage("forms.acusticavaloracionfinal.columns.proteccionRuidoInteriorAereoHorizontalTipoId.header", locale)));
		metaData.getColumn("proteccionRuidoInteriorAereoHorizontalTipoId").setTooltip(this.getMessage("forms.acusticavaloracionfinal.columns.proteccionRuidoInteriorAereoHorizontalTipoId.description", locale));
		metaData.getColumn("proteccionRuidoInteriorAereoHorizontalTipoId").setGroupable(false);
		metaData.getColumn("proteccionRuidoInteriorAereoHorizontalTipoId").setSortable(true);
		metaData.getColumn("proteccionRuidoInteriorAereoHorizontalTipoId").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("proteccionRuidoInteriorAereoHorizontalTipoId").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] proteccionRuidoInteriorAereoHorizontalTipoIdStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_VALORACION_DEFICIENTE), this.getMessage("forms.acusticavaloracionfinal.columns.proteccionRuidoInteriorAereoHorizontalTipoId." + Keys.ACUSTICA_VALORACION_DEFICIENTE, locale)},
				{ String.valueOf(Keys.ACUSTICA_VALORACION_REGULAR), this.getMessage("forms.acusticavaloracionfinal.columns.proteccionRuidoInteriorAereoHorizontalTipoId." + Keys.ACUSTICA_VALORACION_REGULAR, locale)},
				{ String.valueOf(Keys.ACUSTICA_VALORACION_RAZONABLE), this.getMessage("forms.acusticavaloracionfinal.columns.proteccionRuidoInteriorAereoHorizontalTipoId." + Keys.ACUSTICA_VALORACION_RAZONABLE, locale)},
				{ String.valueOf(Keys.ACUSTICA_VALORACION_BUENO), this.getMessage("forms.acusticavaloracionfinal.columns.proteccionRuidoInteriorAereoHorizontalTipoId." + Keys.ACUSTICA_VALORACION_BUENO, locale)},
		};

		metaData.getColumn("proteccionRuidoInteriorAereoHorizontalTipoId").setSofaStoreValues(proteccionRuidoInteriorAereoHorizontalTipoIdStore);

		metaData.getColumn("proteccionRuidoInteriorAereoHorizontalTipoId").setEditable(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("proteccionRuidoInteriorAereoVerticalTipoId", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("proteccionRuidoInteriorAereoVerticalTipoId", this.getMessage("forms.acusticavaloracionfinal.columns.proteccionRuidoInteriorAereoVerticalTipoId.header", locale)));
		metaData.getColumn("proteccionRuidoInteriorAereoVerticalTipoId").setTooltip(this.getMessage("forms.acusticavaloracionfinal.columns.proteccionRuidoInteriorAereoVerticalTipoId.description", locale));
		metaData.getColumn("proteccionRuidoInteriorAereoVerticalTipoId").setGroupable(false);
		metaData.getColumn("proteccionRuidoInteriorAereoVerticalTipoId").setSortable(true);
		metaData.getColumn("proteccionRuidoInteriorAereoVerticalTipoId").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("proteccionRuidoInteriorAereoVerticalTipoId").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] ieeStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_VALORACION_DEFICIENTE), this.getMessage("forms.acusticavaloracionfinal.columns.proteccionRuidoInteriorAereoVerticalTipoId." + Keys.ACUSTICA_VALORACION_DEFICIENTE, locale)},
				{ String.valueOf(Keys.ACUSTICA_VALORACION_REGULAR), this.getMessage("forms.acusticavaloracionfinal.columns.proteccionRuidoInteriorAereoVerticalTipoId." + Keys.ACUSTICA_VALORACION_REGULAR, locale)},
				{ String.valueOf(Keys.ACUSTICA_VALORACION_RAZONABLE), this.getMessage("forms.acusticavaloracionfinal.columns.proteccionRuidoInteriorAereoVerticalTipoId." + Keys.ACUSTICA_VALORACION_RAZONABLE, locale)},
				{ String.valueOf(Keys.ACUSTICA_VALORACION_BUENO), this.getMessage("forms.acusticavaloracionfinal.columns.proteccionRuidoInteriorAereoVerticalTipoId." + Keys.ACUSTICA_VALORACION_BUENO, locale)},
		};

		metaData.getColumn("proteccionRuidoInteriorAereoVerticalTipoId").setSofaStoreValues(ieeStore);

		metaData.getColumn("proteccionRuidoInteriorAereoVerticalTipoId").setEditable(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("proteccionRuidoInteriorImpactosHorizontalTipoId", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("proteccionRuidoInteriorImpactosHorizontalTipoId", this.getMessage("forms.acusticavaloracionfinal.columns.proteccionRuidoInteriorImpactosHorizontalTipoId.header", locale)));
		metaData.getColumn("proteccionRuidoInteriorImpactosHorizontalTipoId").setTooltip(this.getMessage("forms.acusticavaloracionfinal.columns.proteccionRuidoInteriorImpactosHorizontalTipoId.description", locale));
		metaData.getColumn("proteccionRuidoInteriorImpactosHorizontalTipoId").setGroupable(false);
		metaData.getColumn("proteccionRuidoInteriorImpactosHorizontalTipoId").setSortable(true);
		metaData.getColumn("proteccionRuidoInteriorImpactosHorizontalTipoId").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("proteccionRuidoInteriorImpactosHorizontalTipoId").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] proteccionRuidoInteriorImpactosHorizontalTipoIdStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_VALORACION_DEFICIENTE), this.getMessage("forms.acusticavaloracionfinal.columns.proteccionRuidoInteriorImpactosHorizontalTipoId." + Keys.ACUSTICA_VALORACION_DEFICIENTE, locale)},
				{ String.valueOf(Keys.ACUSTICA_VALORACION_REGULAR), this.getMessage("forms.acusticavaloracionfinal.columns.proteccionRuidoInteriorImpactosHorizontalTipoId." + Keys.ACUSTICA_VALORACION_REGULAR, locale)},
				{ String.valueOf(Keys.ACUSTICA_VALORACION_RAZONABLE), this.getMessage("forms.acusticavaloracionfinal.columns.proteccionRuidoInteriorImpactosHorizontalTipoId." + Keys.ACUSTICA_VALORACION_RAZONABLE, locale)},
				{ String.valueOf(Keys.ACUSTICA_VALORACION_BUENO), this.getMessage("forms.acusticavaloracionfinal.columns.proteccionRuidoInteriorImpactosHorizontalTipoId." + Keys.ACUSTICA_VALORACION_BUENO, locale)},
		};

		metaData.getColumn("proteccionRuidoInteriorImpactosHorizontalTipoId").setSofaStoreValues(proteccionRuidoInteriorImpactosHorizontalTipoIdStore);

		metaData.getColumn("proteccionRuidoInteriorImpactosHorizontalTipoId").setEditable(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("proteccionRuidoInteriorImpactosVerticalTipoId", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("proteccionRuidoInteriorImpactosVerticalTipoId", this.getMessage("forms.acusticavaloracionfinal.columns.proteccionRuidoInteriorImpactosVerticalTipoId.header", locale)));
		metaData.getColumn("proteccionRuidoInteriorImpactosVerticalTipoId").setTooltip(this.getMessage("forms.acusticavaloracionfinal.columns.proteccionRuidoInteriorImpactosVerticalTipoId.description", locale));
		metaData.getColumn("proteccionRuidoInteriorImpactosVerticalTipoId").setGroupable(false);
		metaData.getColumn("proteccionRuidoInteriorImpactosVerticalTipoId").setSortable(true);
		metaData.getColumn("proteccionRuidoInteriorImpactosVerticalTipoId").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("proteccionRuidoInteriorImpactosVerticalTipoId").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] proteccionRuidoInteriorImpactosVerticalTipoIdStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_VALORACION_DEFICIENTE), this.getMessage("forms.acusticavaloracionfinal.columns.proteccionRuidoInteriorImpactosVerticalTipoId." + Keys.ACUSTICA_VALORACION_DEFICIENTE, locale)},
				{ String.valueOf(Keys.ACUSTICA_VALORACION_REGULAR), this.getMessage("forms.acusticavaloracionfinal.columns.proteccionRuidoInteriorImpactosVerticalTipoId." + Keys.ACUSTICA_VALORACION_REGULAR, locale)},
				{ String.valueOf(Keys.ACUSTICA_VALORACION_RAZONABLE), this.getMessage("forms.acusticavaloracionfinal.columns.proteccionRuidoInteriorImpactosVerticalTipoId." + Keys.ACUSTICA_VALORACION_RAZONABLE, locale)},
				{ String.valueOf(Keys.ACUSTICA_VALORACION_BUENO), this.getMessage("forms.acusticavaloracionfinal.columns.proteccionRuidoInteriorImpactosVerticalTipoId." + Keys.ACUSTICA_VALORACION_BUENO, locale)},
		};

		metaData.getColumn("proteccionRuidoInteriorImpactosVerticalTipoId").setSofaStoreValues(proteccionRuidoInteriorImpactosVerticalTipoIdStore);

		metaData.getColumn("proteccionRuidoInteriorImpactosVerticalTipoId").setEditable(true);

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

		datosExportacion.add("claveInforme", this.getMessage("forms.acusticavaloracionfinal.columns.claveInforme.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("inspeccion", this.getMessage("forms.acusticavaloracionfinal.columns.inspeccion.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("observaciones", this.getMessage("forms.acusticavaloracionfinal.columns.observaciones.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("proteccionRuidoExteriorTipoId", this.getMessage("forms.acusticavaloracionfinal.columns.proteccionRuidoExteriorTipoId.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("proteccionRuidoInstalacionesTipoId", this.getMessage("forms.acusticavaloracionfinal.columns.proteccionRuidoInstalacionesTipoId.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("proteccionRuidoInteriorAereoHorizontalTipoId", this.getMessage("forms.acusticavaloracionfinal.columns.proteccionRuidoInteriorAereoHorizontalTipoId.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("proteccionRuidoInteriorAereoVerticalTipoId", this.getMessage("forms.acusticavaloracionfinal.columns.proteccionRuidoInteriorAereoVerticalTipoId.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("proteccionRuidoInteriorImpactosHorizontalTipoId", this.getMessage("forms.acusticavaloracionfinal.columns.proteccionRuidoInteriorImpactosHorizontalTipoId.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("proteccionRuidoInteriorImpactosVerticalTipoId", this.getMessage("forms.acusticavaloracionfinal.columns.proteccionRuidoInteriorImpactosVerticalTipoId.header", locale), TipoCampoExportacion.STRING);

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
		AcusticaValoracionFinalListadoVO instance = (AcusticaValoracionFinalListadoVO) rawInstance;

		List<String> excelRow = new ArrayList<String>();

		excelRow.add(FormData2Java.toString(instance.getClaveInforme()));
		excelRow.add(FormData2Java.toString(instance.getInspeccionLabel()));
		excelRow.add(instance.getObservaciones());

		//excelRow.add(FormData2Java.toString(instance.getProteccionRuidoExteriorTipoId()));
		if (instance.getProteccionRuidoExteriorTipoId()!=null){
			excelRow.add( this.getMessage("forms.acusticavaloracionfinal.columns.proteccionRuidoExteriorTipoId." + instance.getProteccionRuidoExteriorTipoId(), locale) );
		}else{
			excelRow.add("null");
		}

		//excelRow.add(FormData2Java.toString(instance.getProteccionRuidoInstalacionesTipoId()));
		if (instance.getProteccionRuidoInstalacionesTipoId()!=null){
			excelRow.add( this.getMessage("forms.acusticavaloracionfinal.columns.proteccionRuidoInstalacionesTipoId." + instance.getProteccionRuidoInstalacionesTipoId(), locale) );
		}else{
			excelRow.add("null");
		}

		//excelRow.add(FormData2Java.toString(instance.getProteccionRuidoInteriorAereoHorizontalTipoId()));
		if (instance.getProteccionRuidoInteriorAereoHorizontalTipoId()!=null){
			excelRow.add( this.getMessage("forms.acusticavaloracionfinal.columns.proteccionRuidoInteriorAereoHorizontalTipoId." + instance.getProteccionRuidoInteriorAereoHorizontalTipoId(), locale) );
		}else{
			excelRow.add("null");
		}

		//excelRow.add(FormData2Java.toString(instance.getProteccionRuidoInteriorAereoVerticalTipoId()));
		if (instance.getProteccionRuidoInteriorAereoVerticalTipoId()!=null){
			excelRow.add( this.getMessage("forms.acusticavaloracionfinal.columns.proteccionRuidoInteriorAereoVerticalTipoId." + instance.getProteccionRuidoInteriorAereoVerticalTipoId(), locale) );
		}else{
			excelRow.add("null");
		}

		//excelRow.add(FormData2Java.toString(instance.getProteccionRuidoInteriorImpactosHorizontalTipoId()));
		if (instance.getProteccionRuidoInteriorImpactosHorizontalTipoId()!=null){
			excelRow.add( this.getMessage("forms.acusticavaloracionfinal.columns.proteccionRuidoInteriorImpactosHorizontalTipoId." + instance.getProteccionRuidoInteriorImpactosHorizontalTipoId(), locale) );
		}else{
			excelRow.add("null");
		}

		//excelRow.add(FormData2Java.toString(instance.getProteccionRuidoInteriorImpactosVerticalTipoId()));
		if (instance.getProteccionRuidoInteriorImpactosVerticalTipoId()!=null){
			excelRow.add( this.getMessage("forms.acusticavaloracionfinal.columns.proteccionRuidoInteriorImpactosVerticalTipoId." + instance.getProteccionRuidoInteriorImpactosVerticalTipoId(), locale) );
		}else{
			excelRow.add("null");
		}

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
	 * Rellena una instancia de AcusticaValoracionFinalFormVO con el contenido
	 * de un formulario recibido en formato Map<String, ?>
	 */
	protected void setFormData(AcusticaValoracionFinalFormVO record, Map<String, ?> formData) throws GenericBusinessException {
		String formDataStr = null;
		if (!StringUtils.isEmpty(formData, "inspeccionId")) {
			formDataStr = (String) formData.get("inspeccionId");
			record.setInspeccionId(FormData2Java.toInteger(formDataStr));

		}
		if (formData.containsKey("observaciones")) {
			formDataStr = (String) formData.get("observaciones");
			record.setObservaciones(formDataStr);
		}
		if (formData.containsKey("proteccionRuidoExteriorTipoId")) {
			formDataStr = (String) formData.get("proteccionRuidoExteriorTipoId");
			record.setProteccionRuidoExteriorTipoId(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("proteccionRuidoInstalacionesTipoId")) {
			formDataStr = (String) formData.get("proteccionRuidoInstalacionesTipoId");
			record.setProteccionRuidoInstalacionesTipoId(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("proteccionRuidoInteriorAereoHorizontalTipoId")) {
			formDataStr = (String) formData.get("proteccionRuidoInteriorAereoHorizontalTipoId");
			record.setProteccionRuidoInteriorAereoHorizontalTipoId(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("proteccionRuidoInteriorAereoVerticalTipoId")) {
			formDataStr = (String) formData.get("proteccionRuidoInteriorAereoVerticalTipoId");
			record.setProteccionRuidoInteriorAereoVerticalTipoId(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("proteccionRuidoInteriorImpactosHorizontalTipoId")) {
			formDataStr = (String) formData.get("proteccionRuidoInteriorImpactosHorizontalTipoId");
			record.setProteccionRuidoInteriorImpactosHorizontalTipoId(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("proteccionRuidoInteriorImpactosVerticalTipoId")) {
			formDataStr = (String) formData.get("proteccionRuidoInteriorImpactosVerticalTipoId");
			record.setProteccionRuidoInteriorImpactosVerticalTipoId(FormData2Java.toInteger(formDataStr));
		}
	}

}
