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
import es.caib.avaedi.logic.bo.EficienciasEnergeticasBO;
import es.caib.avaedi.logic.bo.InspeccionBO;
import es.caib.avaedi.logic.util.Keys;
import es.caib.avaedi.logic.vo.EficienciasEnergeticasFormVO;
import es.caib.avaedi.logic.vo.EficienciasEnergeticasListadoVO;
import es.caib.avaedi.logic.vo.InspeccionListadoVO;

/**
 * Servicio para tratar el formulario: EficienciasEnergeticas
 * 
 * @author agarcia@at4.net
 * 
 */
@Service("eficienciasenergeticas")
public class EficienciasEnergeticasService extends InspeccionBaseService<EficienciasEnergeticasBO, EficienciasEnergeticasListadoVO, EficienciasEnergeticasFormVO> {

	/**
	 * The logger object.
	 */
	private static Logger log = LogService.getLogger(EficienciasEnergeticasService.class);

	/**
	 * Bean para acceder a los métodos de negocio: EficienciasEnergeticas
	 */
	@Autowired
	@Qualifier("EficienciasEnergeticasBean")
	protected EficienciasEnergeticasBO mainBO;

	/**
	 * Bean para acceder a los métodos de negocio: EficienciasEnergeticas
	 * 
	 * @param bean
	 *            the bean to set
	 */
	protected EficienciasEnergeticasBO getMainBO() {
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
	 * ************************** Métodos del interfaz FormService
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
			formItem.setText(this.getMessage("forms.eficienciasenergeticas.title", locale));
		}

		GridMetaData metaData = this.getBaseMetaData(formItem, locale);

		//Nombre de la clase js de formulario
		metaData.setFormClassName("EficienciasEnergeticasForm");

		//Nombre de la clase js de listado
		metaData.setListClassName("ListadoGrid");

		//Configurar las acciones posibles según los permisos
		metaData.setShowNewButton(this.hasPerms(usuari, PERMS_ADD));
		metaData.setShowDeleteButton(this.hasPerms(usuari, PERMS_DELETE));
		metaData.setShowUpdateButton(this.hasPerms(usuari, PERMS_UPDATE));
		metaData.setShowExportControls(this.hasPerms(usuari, PERMS_EXPORT));

		//TODO: desactivar si no se quiere hacer grid editable
		metaData.setEditable(this.hasPerms(usuari, PERMS_UPDATE));

		/*
		 * //Añadimos el campo de oid al registro (el campo oid es el
		 * "object identifier") metaData.addRecordField(new
		 * GridRecordFieldMetaData("oid", "claveInforme",
		 * GridRecordFieldMetaData.INT_TYPE));
		 * 
		 * //Creamos el registro para el record metaData.addRecordField(new
		 * GridRecordFieldMetaData("claveInforme",
		 * GridRecordFieldMetaData.INT_TYPE));
		 * 
		 * // Creamos la columna metaData.addColumn(new
		 * GridColumnMetaData("claveInforme", this.getMessage(
		 * "forms.eficienciasenergeticas.columns.claveInforme.header",
		 * locale))); metaData.getColumn("claveInforme").setGroupable(false);
		 * metaData.getColumn("claveInforme").setSortable(true);
		 * metaData.getColumn
		 * ("claveInforme").setSofaFilter(GridColumnFilter.TYPE_NUMERIC);
		 * 
		 * //Creamos el registro para el record metaData.addRecordField(new
		 * GridRecordFieldMetaData("inspeccionId",
		 * GridRecordFieldMetaData.INT_TYPE)); metaData.addRecordField(new
		 * GridRecordFieldMetaData("inspeccionLabel",
		 * GridRecordFieldMetaData.INT_TYPE)); metaData.addRecordField(new
		 * GridRecordFieldMetaData("inspeccion", "inspeccionLabel",
		 * GridRecordFieldMetaData.INT_TYPE));
		 * 
		 * // Creamos la columna metaData.addColumn(new
		 * GridColumnMetaData("inspeccion",
		 * this.getMessage("forms.eficienciasenergeticas.columns.inspeccion.header"
		 * , locale))); metaData.getColumn("inspeccion").setGroupable(true);
		 * metaData.getColumn("inspeccion").setSortable(true);
		 * metaData.getColumn
		 * ("inspeccion").setSofaFilter(GridColumnFilter.TYPE_MULTICOMBO);
		 * metaData.getColumn("inspeccion").setRelatedForm("Inspeccion");
		 * 
		 * metaData.getColumn("inspeccion").setEditable(true) ;
		 * metaData.getColumn("inspeccion").setHidden(true);
		 */

		/*
		 * //Creamos el registro para el record metaData.addRecordField(new
		 * GridRecordFieldMetaData("ambitoAplicacion",
		 * GridRecordFieldMetaData.INT_TYPE));
		 * 
		 * // Creamos la columna metaData.addColumn(new
		 * GridColumnMetaData("ambitoAplicacion", this.getMessage(
		 * "forms.eficienciasenergeticas.columns.ambitoAplicacion.header",
		 * locale)));
		 * metaData.getColumn("ambitoAplicacion").setGroupable(false);
		 * metaData.getColumn("ambitoAplicacion").setSortable(true);
		 * metaData.getColumn
		 * ("ambitoAplicacion").setSofaFilter(GridColumnFilter.TYPE_NUMERIC);
		 * 
		 * metaData.getColumn("ambitoAplicacion").setEditable(true) ;
		 * metaData.getColumn("ambitoAplicacion").setHidden(true);
		 */

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("esTecnicoInspeccion", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("esTecnicoInspeccion", this.getMessage("forms.eficienciasenergeticas.columns.esTecnicoInspeccion.header", locale)));
		metaData.getColumn("esTecnicoInspeccion").setGroupable(false);
		metaData.getColumn("esTecnicoInspeccion").setSortable(true);
		metaData.getColumn("esTecnicoInspeccion").setSofaFilter(GridColumnFilter.TYPE_LIST);
		metaData.getColumn("esTecnicoInspeccion").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] esTecnicoInspeccionStore = new String[][] { { String.valueOf(Keys.EFICIENCIA_ES_TECNICO_INSPECCION_SI), this.getMessage("forms.eficienciasenergeticas.columns.esTecnicoInspeccion." + Keys.EFICIENCIA_ES_TECNICO_INSPECCION_SI, locale) }, { String.valueOf(Keys.EFICIENCIA_ES_TECNICO_INSPECCION_NO), this.getMessage("forms.eficienciasenergeticas.columns.esTecnicoInspeccion." + Keys.EFICIENCIA_ES_TECNICO_INSPECCION_NO, locale) }, };

		metaData.getColumn("esTecnicoInspeccion").setSofaStoreValues(esTecnicoInspeccionStore);

		metaData.getColumn("esTecnicoInspeccion").setEditable(true);
		//metaData.getColumn("esTecnicoInspeccion").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("demandaGlobalCalefaccion", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("demandaGlobalCalefaccion", this.getMessage("forms.eficienciasenergeticas.columns.demandaGlobalCalefaccion.header", locale)));
		metaData.getColumn("demandaGlobalCalefaccion").setGroupable(false);
		metaData.getColumn("demandaGlobalCalefaccion").setSortable(true);
		metaData.getColumn("demandaGlobalCalefaccion").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("demandaGlobalCalefaccion").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("demandaGlobalCalefaccion").setEditable(true);
		//metaData.getColumn("demandaGlobalCalefaccion").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("demandaGlobalCalefaccionCalificacionTipoId", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("demandaGlobalCalefaccionCalificacionTipoId", this.getMessage("forms.eficienciasenergeticas.columns.demandaGlobalCalefaccionCalificacionTipoId.header", locale)));
		metaData.getColumn("demandaGlobalCalefaccionCalificacionTipoId").setTooltip(this.getMessage("forms.eficienciasenergeticas.columns.demandaGlobalCalefaccionCalificacionTipoId.description", locale));
		metaData.getColumn("demandaGlobalCalefaccionCalificacionTipoId").setGroupable(false);
		metaData.getColumn("demandaGlobalCalefaccionCalificacionTipoId").setSortable(true);
		metaData.getColumn("demandaGlobalCalefaccionCalificacionTipoId").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("demandaGlobalCalefaccionCalificacionTipoId").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] demandaGlobalCalefaccionCalificacionTipoIdStore = new String[][] { { String.valueOf(Keys.EFICIENCIA_CALIFICACION_CALEFACCION_A), this.getMessage("forms.eficienciasenergeticas.columns.demandaGlobalCalefaccionCalificacionTipoId." + Keys.EFICIENCIA_CALIFICACION_CALEFACCION_A, locale) }, { String.valueOf(Keys.EFICIENCIA_CALIFICACION_CALEFACCION_B), this.getMessage("forms.eficienciasenergeticas.columns.demandaGlobalCalefaccionCalificacionTipoId." + Keys.EFICIENCIA_CALIFICACION_CALEFACCION_B, locale) }, { String.valueOf(Keys.EFICIENCIA_CALIFICACION_CALEFACCION_C), this.getMessage("forms.eficienciasenergeticas.columns.demandaGlobalCalefaccionCalificacionTipoId." + Keys.EFICIENCIA_CALIFICACION_CALEFACCION_C, locale) }, { String.valueOf(Keys.EFICIENCIA_CALIFICACION_CALEFACCION_D), this.getMessage("forms.eficienciasenergeticas.columns.demandaGlobalCalefaccionCalificacionTipoId." + Keys.EFICIENCIA_CALIFICACION_CALEFACCION_D, locale) }, { String.valueOf(Keys.EFICIENCIA_CALIFICACION_CALEFACCION_E), this.getMessage("forms.eficienciasenergeticas.columns.demandaGlobalCalefaccionCalificacionTipoId." + Keys.EFICIENCIA_CALIFICACION_CALEFACCION_E, locale) }, { String.valueOf(Keys.EFICIENCIA_CALIFICACION_CALEFACCION_F), this.getMessage("forms.eficienciasenergeticas.columns.demandaGlobalCalefaccionCalificacionTipoId." + Keys.EFICIENCIA_CALIFICACION_CALEFACCION_F, locale) }, { String.valueOf(Keys.EFICIENCIA_CALIFICACION_CALEFACCION_G), this.getMessage("forms.eficienciasenergeticas.columns.demandaGlobalCalefaccionCalificacionTipoId." + Keys.EFICIENCIA_CALIFICACION_CALEFACCION_G, locale) }, { String.valueOf(Keys.EFICIENCIA_CALIFICACION_CALEFACCION_NC), this.getMessage("forms.eficienciasenergeticas.columns.demandaGlobalCalefaccionCalificacionTipoId." + Keys.EFICIENCIA_CALIFICACION_CALEFACCION_NC, locale) }, };

		metaData.getColumn("demandaGlobalCalefaccionCalificacionTipoId").setSofaStoreValues(demandaGlobalCalefaccionCalificacionTipoIdStore);

		metaData.getColumn("demandaGlobalCalefaccionCalificacionTipoId").setEditable(true);
		metaData.getColumn("demandaGlobalCalefaccionCalificacionTipoId").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("demandaGlobalRefrigeracion", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("demandaGlobalRefrigeracion", this.getMessage("forms.eficienciasenergeticas.columns.demandaGlobalRefrigeracion.header", locale)));
		metaData.getColumn("demandaGlobalRefrigeracion").setGroupable(false);
		metaData.getColumn("demandaGlobalRefrigeracion").setSortable(true);
		metaData.getColumn("demandaGlobalRefrigeracion").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("demandaGlobalRefrigeracion").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("demandaGlobalRefrigeracion").setEditable(true);
		//metaData.getColumn("demandaGlobalRefrigeracion").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("demandaGlobalRefrigeracionCalificacionTipoId", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("demandaGlobalRefrigeracionCalificacionTipoId", this.getMessage("forms.eficienciasenergeticas.columns.demandaGlobalRefrigeracionCalificacionTipoId.header", locale)));
		metaData.getColumn("demandaGlobalRefrigeracionCalificacionTipoId").setTooltip(this.getMessage("forms.eficienciasenergeticas.columns.demandaGlobalRefrigeracionCalificacionTipoId.description", locale));
		metaData.getColumn("demandaGlobalRefrigeracionCalificacionTipoId").setGroupable(false);
		metaData.getColumn("demandaGlobalRefrigeracionCalificacionTipoId").setSortable(true);
		metaData.getColumn("demandaGlobalRefrigeracionCalificacionTipoId").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("demandaGlobalRefrigeracionCalificacionTipoId").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] demandaGlobalRefrigeracionCalificacionTipoIdStore = new String[][] { { String.valueOf(Keys.EFICIENCIA_CALIFICACION_REFRIGERACION_A), this.getMessage("forms.eficienciasenergeticas.columns.demandaGlobalRefrigeracionCalificacionTipoId." + Keys.EFICIENCIA_CALIFICACION_REFRIGERACION_A, locale) }, { String.valueOf(Keys.EFICIENCIA_CALIFICACION_REFRIGERACION_B), this.getMessage("forms.eficienciasenergeticas.columns.demandaGlobalRefrigeracionCalificacionTipoId." + Keys.EFICIENCIA_CALIFICACION_REFRIGERACION_B, locale) }, { String.valueOf(Keys.EFICIENCIA_CALIFICACION_REFRIGERACION_C), this.getMessage("forms.eficienciasenergeticas.columns.demandaGlobalRefrigeracionCalificacionTipoId." + Keys.EFICIENCIA_CALIFICACION_REFRIGERACION_C, locale) }, { String.valueOf(Keys.EFICIENCIA_CALIFICACION_REFRIGERACION_D), this.getMessage("forms.eficienciasenergeticas.columns.demandaGlobalRefrigeracionCalificacionTipoId." + Keys.EFICIENCIA_CALIFICACION_REFRIGERACION_D, locale) }, { String.valueOf(Keys.EFICIENCIA_CALIFICACION_REFRIGERACION_E), this.getMessage("forms.eficienciasenergeticas.columns.demandaGlobalRefrigeracionCalificacionTipoId." + Keys.EFICIENCIA_CALIFICACION_REFRIGERACION_E, locale) }, { String.valueOf(Keys.EFICIENCIA_CALIFICACION_REFRIGERACION_F), this.getMessage("forms.eficienciasenergeticas.columns.demandaGlobalRefrigeracionCalificacionTipoId." + Keys.EFICIENCIA_CALIFICACION_REFRIGERACION_F, locale) }, { String.valueOf(Keys.EFICIENCIA_CALIFICACION_REFRIGERACION_G), this.getMessage("forms.eficienciasenergeticas.columns.demandaGlobalRefrigeracionCalificacionTipoId." + Keys.EFICIENCIA_CALIFICACION_REFRIGERACION_G, locale) }, { String.valueOf(Keys.EFICIENCIA_CALIFICACION_REFRIGERACION_NC), this.getMessage("forms.eficienciasenergeticas.columns.demandaGlobalRefrigeracionCalificacionTipoId." + Keys.EFICIENCIA_CALIFICACION_REFRIGERACION_NC, locale) }, };

		metaData.getColumn("demandaGlobalRefrigeracionCalificacionTipoId").setSofaStoreValues(demandaGlobalRefrigeracionCalificacionTipoIdStore);

		metaData.getColumn("demandaGlobalRefrigeracionCalificacionTipoId").setEditable(true);
		metaData.getColumn("demandaGlobalRefrigeracionCalificacionTipoId").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("indicadorGlobalCalificacionTipoId", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("indicadorGlobalCalificacionTipoId", this.getMessage("forms.eficienciasenergeticas.columns.indicadorGlobalCalificacionTipoId.header", locale)));
		metaData.getColumn("indicadorGlobalCalificacionTipoId").setTooltip(this.getMessage("forms.eficienciasenergeticas.columns.indicadorGlobalCalificacionTipoId.description", locale));
		metaData.getColumn("indicadorGlobalCalificacionTipoId").setGroupable(false);
		metaData.getColumn("indicadorGlobalCalificacionTipoId").setSortable(true);
		metaData.getColumn("indicadorGlobalCalificacionTipoId").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("indicadorGlobalCalificacionTipoId").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] indicadorGlobalCalificacionTipoIdStore = new String[][] { { String.valueOf(Keys.EFICIENCIA_CALIFICACION_GLOBAL_A), this.getMessage("forms.eficienciasenergeticas.columns.indicadorGlobalCalificacionTipoId." + Keys.EFICIENCIA_CALIFICACION_GLOBAL_A, locale) }, { String.valueOf(Keys.EFICIENCIA_CALIFICACION_GLOBAL_B), this.getMessage("forms.eficienciasenergeticas.columns.indicadorGlobalCalificacionTipoId." + Keys.EFICIENCIA_CALIFICACION_GLOBAL_B, locale) }, { String.valueOf(Keys.EFICIENCIA_CALIFICACION_GLOBAL_C), this.getMessage("forms.eficienciasenergeticas.columns.indicadorGlobalCalificacionTipoId." + Keys.EFICIENCIA_CALIFICACION_GLOBAL_C, locale) }, { String.valueOf(Keys.EFICIENCIA_CALIFICACION_GLOBAL_D), this.getMessage("forms.eficienciasenergeticas.columns.indicadorGlobalCalificacionTipoId." + Keys.EFICIENCIA_CALIFICACION_GLOBAL_D, locale) }, { String.valueOf(Keys.EFICIENCIA_CALIFICACION_GLOBAL_E), this.getMessage("forms.eficienciasenergeticas.columns.indicadorGlobalCalificacionTipoId." + Keys.EFICIENCIA_CALIFICACION_GLOBAL_E, locale) }, { String.valueOf(Keys.EFICIENCIA_CALIFICACION_GLOBAL_F), this.getMessage("forms.eficienciasenergeticas.columns.indicadorGlobalCalificacionTipoId." + Keys.EFICIENCIA_CALIFICACION_GLOBAL_F, locale) }, { String.valueOf(Keys.EFICIENCIA_CALIFICACION_GLOBAL_G), this.getMessage("forms.eficienciasenergeticas.columns.indicadorGlobalCalificacionTipoId." + Keys.EFICIENCIA_CALIFICACION_GLOBAL_G, locale) }, { String.valueOf(Keys.EFICIENCIA_CALIFICACION_GLOBAL_NC), this.getMessage("forms.eficienciasenergeticas.columns.indicadorGlobalCalificacionTipoId." + Keys.EFICIENCIA_CALIFICACION_GLOBAL_NC, locale) }, };

		metaData.getColumn("indicadorGlobalCalificacionTipoId").setSofaStoreValues(indicadorGlobalCalificacionTipoIdStore);

		metaData.getColumn("indicadorGlobalCalificacionTipoId").setEditable(true);
		metaData.getColumn("indicadorGlobalCalificacionTipoId").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("indicadorGlobalEmisiones", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("indicadorGlobalEmisiones", this.getMessage("forms.eficienciasenergeticas.columns.indicadorGlobalEmisiones.header", locale)));
		metaData.getColumn("indicadorGlobalEmisiones").setGroupable(false);
		metaData.getColumn("indicadorGlobalEmisiones").setSortable(true);
		metaData.getColumn("indicadorGlobalEmisiones").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("indicadorGlobalEmisiones").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("indicadorGlobalEmisiones").setEditable(true);
		//metaData.getColumn("indicadorGlobalEmisiones").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("indicadorGlobalPrimariaCalificacionTipoId", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("indicadorGlobalPrimariaCalificacionTipoId", this.getMessage("forms.eficienciasenergeticas.columns.indicadorGlobalPrimariaCalificacionTipoId.header", locale)));
		metaData.getColumn("indicadorGlobalPrimariaCalificacionTipoId").setTooltip(this.getMessage("forms.eficienciasenergeticas.columns.indicadorGlobalPrimariaCalificacionTipoId.description", locale));
		metaData.getColumn("indicadorGlobalPrimariaCalificacionTipoId").setGroupable(false);
		metaData.getColumn("indicadorGlobalPrimariaCalificacionTipoId").setSortable(true);
		metaData.getColumn("indicadorGlobalPrimariaCalificacionTipoId").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("indicadorGlobalPrimariaCalificacionTipoId").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] indicadorGlobalPrimariaCalificacionTipoIdStore = new String[][] { { String.valueOf(Keys.EFICIENCIA_CALIFICACION_PRIMARIA_A), this.getMessage("forms.eficienciasenergeticas.columns.indicadorGlobalPrimariaCalificacionTipoId." + Keys.EFICIENCIA_CALIFICACION_PRIMARIA_A, locale) }, { String.valueOf(Keys.EFICIENCIA_CALIFICACION_PRIMARIA_B), this.getMessage("forms.eficienciasenergeticas.columns.indicadorGlobalPrimariaCalificacionTipoId." + Keys.EFICIENCIA_CALIFICACION_PRIMARIA_B, locale) }, { String.valueOf(Keys.EFICIENCIA_CALIFICACION_PRIMARIA_C), this.getMessage("forms.eficienciasenergeticas.columns.indicadorGlobalPrimariaCalificacionTipoId." + Keys.EFICIENCIA_CALIFICACION_PRIMARIA_C, locale) }, { String.valueOf(Keys.EFICIENCIA_CALIFICACION_PRIMARIA_D), this.getMessage("forms.eficienciasenergeticas.columns.indicadorGlobalPrimariaCalificacionTipoId." + Keys.EFICIENCIA_CALIFICACION_PRIMARIA_D, locale) }, { String.valueOf(Keys.EFICIENCIA_CALIFICACION_PRIMARIA_E), this.getMessage("forms.eficienciasenergeticas.columns.indicadorGlobalPrimariaCalificacionTipoId." + Keys.EFICIENCIA_CALIFICACION_PRIMARIA_E, locale) }, { String.valueOf(Keys.EFICIENCIA_CALIFICACION_PRIMARIA_F), this.getMessage("forms.eficienciasenergeticas.columns.indicadorGlobalPrimariaCalificacionTipoId." + Keys.EFICIENCIA_CALIFICACION_PRIMARIA_F, locale) }, { String.valueOf(Keys.EFICIENCIA_CALIFICACION_PRIMARIA_G), this.getMessage("forms.eficienciasenergeticas.columns.indicadorGlobalPrimariaCalificacionTipoId." + Keys.EFICIENCIA_CALIFICACION_PRIMARIA_G, locale) }, { String.valueOf(Keys.EFICIENCIA_CALIFICACION_PRIMARIA_NC), this.getMessage("forms.eficienciasenergeticas.columns.indicadorGlobalPrimariaCalificacionTipoId." + Keys.EFICIENCIA_CALIFICACION_PRIMARIA_NC, locale) }, };

		metaData.getColumn("indicadorGlobalPrimariaCalificacionTipoId").setSofaStoreValues(indicadorGlobalPrimariaCalificacionTipoIdStore);

		metaData.getColumn("indicadorGlobalPrimariaCalificacionTipoId").setEditable(true);
		metaData.getColumn("indicadorGlobalPrimariaCalificacionTipoId").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("indicadorGlobalPrimariaConsumo", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("indicadorGlobalPrimariaConsumo", this.getMessage("forms.eficienciasenergeticas.columns.indicadorGlobalPrimariaConsumo.header", locale)));
		metaData.getColumn("indicadorGlobalPrimariaConsumo").setTooltip(this.getMessage("forms.eficienciasenergeticas.columns.indicadorGlobalPrimariaConsumo.description", locale));
		metaData.getColumn("indicadorGlobalPrimariaConsumo").setGroupable(false);
		metaData.getColumn("indicadorGlobalPrimariaConsumo").setSortable(true);
		metaData.getColumn("indicadorGlobalPrimariaConsumo").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("indicadorGlobalPrimariaConsumo").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("indicadorGlobalPrimariaConsumo").setEditable(true);
		//metaData.getColumn("indicadorGlobalPrimariaConsumo").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("indicadorParcialEmisionesAcs", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("indicadorParcialEmisionesAcs", this.getMessage("forms.eficienciasenergeticas.columns.indicadorParcialEmisionesAcs.header", locale)));
		metaData.getColumn("indicadorParcialEmisionesAcs").setTooltip(this.getMessage("forms.eficienciasenergeticas.columns.indicadorParcialEmisionesAcs.description", locale));
		metaData.getColumn("indicadorParcialEmisionesAcs").setGroupable(false);
		metaData.getColumn("indicadorParcialEmisionesAcs").setSortable(true);
		metaData.getColumn("indicadorParcialEmisionesAcs").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("indicadorParcialEmisionesAcs").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("indicadorParcialEmisionesAcs").setEditable(true);
		metaData.getColumn("indicadorParcialEmisionesAcs").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("indicadorParcialEmisionesCalefaccion", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("indicadorParcialEmisionesCalefaccion", this.getMessage("forms.eficienciasenergeticas.columns.indicadorParcialEmisionesCalefaccion.header", locale)));
		metaData.getColumn("indicadorParcialEmisionesCalefaccion").setTooltip(this.getMessage("forms.eficienciasenergeticas.columns.indicadorParcialEmisionesCalefaccion.description", locale));
		metaData.getColumn("indicadorParcialEmisionesCalefaccion").setGroupable(false);
		metaData.getColumn("indicadorParcialEmisionesCalefaccion").setSortable(true);
		metaData.getColumn("indicadorParcialEmisionesCalefaccion").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("indicadorParcialEmisionesCalefaccion").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("indicadorParcialEmisionesCalefaccion").setEditable(true);
		metaData.getColumn("indicadorParcialEmisionesCalefaccion").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("indicadorParcialEmisionesRefrigeracion", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("indicadorParcialEmisionesRefrigeracion", this.getMessage("forms.eficienciasenergeticas.columns.indicadorParcialEmisionesRefrigeracion.header", locale)));
		metaData.getColumn("indicadorParcialEmisionesRefrigeracion").setTooltip(this.getMessage("forms.eficienciasenergeticas.columns.indicadorParcialEmisionesRefrigeracion.description", locale));
		metaData.getColumn("indicadorParcialEmisionesRefrigeracion").setGroupable(false);
		metaData.getColumn("indicadorParcialEmisionesRefrigeracion").setSortable(true);
		metaData.getColumn("indicadorParcialEmisionesRefrigeracion").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("indicadorParcialEmisionesRefrigeracion").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("indicadorParcialEmisionesRefrigeracion").setEditable(true);
		metaData.getColumn("indicadorParcialEmisionesRefrigeracion").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("indicadorParcialPrimariaAcs", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("indicadorParcialPrimariaAcs", this.getMessage("forms.eficienciasenergeticas.columns.indicadorParcialPrimariaAcs.header", locale)));
		metaData.getColumn("indicadorParcialPrimariaAcs").setGroupable(false);
		metaData.getColumn("indicadorParcialPrimariaAcs").setSortable(true);
		metaData.getColumn("indicadorParcialPrimariaAcs").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("indicadorParcialPrimariaAcs").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("indicadorParcialPrimariaAcs").setEditable(true);
		metaData.getColumn("indicadorParcialPrimariaAcs").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("indicadorParcialPrimariaCalefaccion", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("indicadorParcialPrimariaCalefaccion", this.getMessage("forms.eficienciasenergeticas.columns.indicadorParcialPrimariaCalefaccion.header", locale)));
		metaData.getColumn("indicadorParcialPrimariaCalefaccion").setTooltip(this.getMessage("forms.eficienciasenergeticas.columns.indicadorParcialPrimariaCalefaccion.description", locale));
		metaData.getColumn("indicadorParcialPrimariaCalefaccion").setGroupable(false);
		metaData.getColumn("indicadorParcialPrimariaCalefaccion").setSortable(true);
		metaData.getColumn("indicadorParcialPrimariaCalefaccion").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("indicadorParcialPrimariaCalefaccion").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("indicadorParcialPrimariaCalefaccion").setEditable(true);
		metaData.getColumn("indicadorParcialPrimariaCalefaccion").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("indicadorParcialPrimariaRefrigeracion", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("indicadorParcialPrimariaRefrigeracion", this.getMessage("forms.eficienciasenergeticas.columns.indicadorParcialPrimariaRefrigeracion.header", locale)));
		metaData.getColumn("indicadorParcialPrimariaRefrigeracion").setTooltip(this.getMessage("forms.eficienciasenergeticas.columns.indicadorParcialPrimariaRefrigeracion.description", locale));
		metaData.getColumn("indicadorParcialPrimariaRefrigeracion").setGroupable(false);
		metaData.getColumn("indicadorParcialPrimariaRefrigeracion").setSortable(true);
		metaData.getColumn("indicadorParcialPrimariaRefrigeracion").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("indicadorParcialPrimariaRefrigeracion").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("indicadorParcialPrimariaRefrigeracion").setEditable(true);
		metaData.getColumn("indicadorParcialPrimariaRefrigeracion").setHidden(true);

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("observaciones", this.getMessage("forms.eficienciasenergeticas.columns.observaciones.header", locale)));
		metaData.getColumn("observaciones").setGroupable(false);
		metaData.getColumn("observaciones").setSortable(true);
		metaData.getColumn("observaciones").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("observaciones").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("observaciones").setEditable(true);
		metaData.getColumn("observaciones").setHidden(true);

		/*//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("nif", GridRecordFieldMetaData.STRING_TYPE));

		// Creamos la columna
		metaData.addColumn(new GridColumnMetaData("nif", this.getMessage("forms.eficienciasenergeticas.columns.nif.header", locale)));
		metaData.getColumn("nif").setGroupable(false);
		metaData.getColumn("nif").setSortable(true);
		metaData.getColumn("nif").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("nif").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("nif").setEditable(true);
		metaData.getColumn("nif").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("observaciones", GridRecordFieldMetaData.STRING_TYPE));

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("tecnico", GridRecordFieldMetaData.STRING_TYPE));

		//Creamos la columna
		metaData.addColumn(new GridColumnMetaData("tecnico", this.getMessage("forms.eficienciasenergeticas.columns.tecnico.header", locale)));
		metaData.getColumn("tecnico").setGroupable(false);
		metaData.getColumn("tecnico").setSortable(true);
		metaData.getColumn("tecnico").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("tecnico").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("tecnico").setEditable(true);
		metaData.getColumn("tecnico").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("titulacion", GridRecordFieldMetaData.STRING_TYPE));

		// Creamos la columna 
		metaData.addColumn(new GridColumnMetaData("titulacion", this.getMessage("forms.eficienciasenergeticas.columns.titulacion.header", locale)));
		metaData.getColumn("titulacion").setGroupable(false);
		metaData.getColumn("titulacion").setSortable(true);
		metaData.getColumn("titulacion").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("titulacion").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("titulacion").setEditable(true);
		metaData.getColumn("titulacion").setHidden(true);*/

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

		datosExportacion.add("claveInforme", this.getMessage("forms.eficienciasenergeticas.columns.claveInforme.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("inspeccion", this.getMessage("forms.eficienciasenergeticas.columns.inspeccion.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("ambitoAplicacion", this.getMessage("forms.eficienciasenergeticas.columns.ambitoAplicacion.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("demandaGlobalCalefaccion", this.getMessage("forms.eficienciasenergeticas.columns.demandaGlobalCalefaccion.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("demandaGlobalCalefaccionCalificacionTipoId", this.getMessage("forms.eficienciasenergeticas.columns.demandaGlobalCalefaccionCalificacionTipoId.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("demandaGlobalRefrigeracion", this.getMessage("forms.eficienciasenergeticas.columns.demandaGlobalRefrigeracion.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("demandaGlobalRefrigeracionCalificacionTipoId", this.getMessage("forms.eficienciasenergeticas.columns.demandaGlobalRefrigeracionCalificacionTipoId.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("esTecnicoInspeccion", this.getMessage("forms.eficienciasenergeticas.columns.esTecnicoInspeccion.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("indicadorGlobalCalificacionTipoId", this.getMessage("forms.eficienciasenergeticas.columns.indicadorGlobalCalificacionTipoId.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("indicadorGlobalEmisiones", this.getMessage("forms.eficienciasenergeticas.columns.indicadorGlobalEmisiones.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("indicadorGlobalPrimariaCalificacionTipoId", this.getMessage("forms.eficienciasenergeticas.columns.indicadorGlobalPrimariaCalificacionTipoId.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("indicadorGlobalPrimariaConsumo", this.getMessage("forms.eficienciasenergeticas.columns.indicadorGlobalPrimariaConsumo.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("indicadorParcialEmisionesAcs", this.getMessage("forms.eficienciasenergeticas.columns.indicadorParcialEmisionesAcs.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("indicadorParcialEmisionesCalefaccion", this.getMessage("forms.eficienciasenergeticas.columns.indicadorParcialEmisionesCalefaccion.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("indicadorParcialEmisionesRefrigeracion", this.getMessage("forms.eficienciasenergeticas.columns.indicadorParcialEmisionesRefrigeracion.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("indicadorParcialPrimariaAcs", this.getMessage("forms.eficienciasenergeticas.columns.indicadorParcialPrimariaAcs.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("indicadorParcialPrimariaCalefaccion", this.getMessage("forms.eficienciasenergeticas.columns.indicadorParcialPrimariaCalefaccion.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("indicadorParcialPrimariaRefrigeracion", this.getMessage("forms.eficienciasenergeticas.columns.indicadorParcialPrimariaRefrigeracion.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("nif", this.getMessage("forms.eficienciasenergeticas.columns.nif.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("observaciones", this.getMessage("forms.eficienciasenergeticas.columns.observaciones.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("tecnico", this.getMessage("forms.eficienciasenergeticas.columns.tecnico.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("titulacion", this.getMessage("forms.eficienciasenergeticas.columns.titulacion.header", locale), TipoCampoExportacion.STRING);

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
		EficienciasEnergeticasListadoVO instance = (EficienciasEnergeticasListadoVO) rawInstance;

		List<String> excelRow = new ArrayList<String>();

		excelRow.add(FormData2Java.toString(instance.getClaveInforme()));
		excelRow.add(FormData2Java.toString(instance.getInspeccionLabel()));
		excelRow.add(FormData2Java.toString(instance.getAmbitoAplicacion()));
		excelRow.add(instance.getDemandaGlobalCalefaccion());

		//excelRow.add(FormData2Java.toString(instance.getDemandaGlobalCalefaccionCalificacionTipoId()));
		if (instance.getDemandaGlobalCalefaccionCalificacionTipoId() != null) {
			excelRow.add(this.getMessage("forms.eficienciasenergeticas.columns.demandaGlobalCalefaccionCalificacionTipoId." + instance.getDemandaGlobalCalefaccionCalificacionTipoId(), locale));
		} else {
			excelRow.add("null");
		}

		excelRow.add(instance.getDemandaGlobalRefrigeracion());

		//excelRow.add(FormData2Java.toString(instance.getDemandaGlobalRefrigeracionCalificacionTipoId()));
		if (instance.getDemandaGlobalRefrigeracionCalificacionTipoId() != null) {
			excelRow.add(this.getMessage("forms.eficienciasenergeticas.columns.demandaGlobalRefrigeracionCalificacionTipoId." + instance.getDemandaGlobalRefrigeracionCalificacionTipoId(), locale));
		} else {
			excelRow.add("null");
		}

		//excelRow.add(FormData2Java.toString(instance.getEsTecnicoInspeccion()));
		if (instance.getEsTecnicoInspeccion() != null) {
			excelRow.add(this.getMessage("forms.eficienciasenergeticas.columns.esTecnicoInspeccion." + instance.getEsTecnicoInspeccion(), locale));
		} else {
			excelRow.add("null");
		}

		//excelRow.add(FormData2Java.toString(instance.getIndicadorGlobalCalificacionTipoId()));
		if (instance.getIndicadorGlobalCalificacionTipoId() != null) {
			excelRow.add(this.getMessage("forms.eficienciasenergeticas.columns.indicadorGlobalCalificacionTipoId." + instance.getIndicadorGlobalCalificacionTipoId(), locale));
		} else {
			excelRow.add("null");
		}

		excelRow.add(instance.getIndicadorGlobalEmisiones());

		//excelRow.add(FormData2Java.toString(instance.getIndicadorGlobalPrimariaCalificacionTipoId()));
		if (instance.getIndicadorGlobalPrimariaCalificacionTipoId() != null) {
			excelRow.add(this.getMessage("forms.eficienciasenergeticas.columns.indicadorGlobalPrimariaCalificacionTipoId." + instance.getIndicadorGlobalPrimariaCalificacionTipoId(), locale));
		} else {
			excelRow.add("null");
		}

		excelRow.add(instance.getIndicadorGlobalPrimariaConsumo());
		excelRow.add(instance.getIndicadorParcialEmisionesAcs());
		excelRow.add(instance.getIndicadorParcialEmisionesCalefaccion());
		excelRow.add(instance.getIndicadorParcialEmisionesRefrigeracion());
		excelRow.add(instance.getIndicadorParcialPrimariaAcs());
		excelRow.add(instance.getIndicadorParcialPrimariaCalefaccion());
		excelRow.add(instance.getIndicadorParcialPrimariaRefrigeracion());
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
	 * Rellena una instancia de EficienciasEnergeticasFormVO con el contenido de
	 * un formulario recibido en formato Map<String, ?>
	 */
	protected void setFormData(EficienciasEnergeticasFormVO record, Map<String, ?> formData) throws GenericBusinessException {
		String formDataStr = null;
		if (!StringUtils.isEmpty(formData, "inspeccionId")) {
			formDataStr = (String) formData.get("inspeccionId");
			record.setInspeccionId(FormData2Java.toInteger(formDataStr));

		}
		if (formData.containsKey("ambitoAplicacion")) {
			formDataStr = (String) formData.get("ambitoAplicacion");
			record.setAmbitoAplicacion(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("demandaGlobalCalefaccion")) {
			formDataStr = (String) formData.get("demandaGlobalCalefaccion");
			record.setDemandaGlobalCalefaccion(formDataStr);
		}
		if (formData.containsKey("demandaGlobalCalefaccionCalificacionTipoId")) {
			formDataStr = (String) formData.get("demandaGlobalCalefaccionCalificacionTipoId");
			record.setDemandaGlobalCalefaccionCalificacionTipoId(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("demandaGlobalRefrigeracion")) {
			formDataStr = (String) formData.get("demandaGlobalRefrigeracion");
			record.setDemandaGlobalRefrigeracion(formDataStr);
		}
		if (formData.containsKey("demandaGlobalRefrigeracionCalificacionTipoId")) {
			formDataStr = (String) formData.get("demandaGlobalRefrigeracionCalificacionTipoId");
			record.setDemandaGlobalRefrigeracionCalificacionTipoId(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("esTecnicoInspeccion")) {
			formDataStr = (String) formData.get("esTecnicoInspeccion");
			record.setEsTecnicoInspeccion(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("indicadorGlobalCalificacionTipoId")) {
			formDataStr = (String) formData.get("indicadorGlobalCalificacionTipoId");
			record.setIndicadorGlobalCalificacionTipoId(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("indicadorGlobalEmisiones")) {
			formDataStr = (String) formData.get("indicadorGlobalEmisiones");
			record.setIndicadorGlobalEmisiones(formDataStr);
		}
		if (formData.containsKey("indicadorGlobalPrimariaCalificacionTipoId")) {
			formDataStr = (String) formData.get("indicadorGlobalPrimariaCalificacionTipoId");
			record.setIndicadorGlobalPrimariaCalificacionTipoId(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("indicadorGlobalPrimariaConsumo")) {
			formDataStr = (String) formData.get("indicadorGlobalPrimariaConsumo");
			record.setIndicadorGlobalPrimariaConsumo(formDataStr);
		}
		if (formData.containsKey("indicadorParcialEmisionesAcs")) {
			formDataStr = (String) formData.get("indicadorParcialEmisionesAcs");
			record.setIndicadorParcialEmisionesAcs(formDataStr);
		}
		if (formData.containsKey("indicadorParcialEmisionesCalefaccion")) {
			formDataStr = (String) formData.get("indicadorParcialEmisionesCalefaccion");
			record.setIndicadorParcialEmisionesCalefaccion(formDataStr);
		}
		if (formData.containsKey("indicadorParcialEmisionesRefrigeracion")) {
			formDataStr = (String) formData.get("indicadorParcialEmisionesRefrigeracion");
			record.setIndicadorParcialEmisionesRefrigeracion(formDataStr);
		}
		if (formData.containsKey("indicadorParcialPrimariaAcs")) {
			formDataStr = (String) formData.get("indicadorParcialPrimariaAcs");
			record.setIndicadorParcialPrimariaAcs(formDataStr);
		}
		if (formData.containsKey("indicadorParcialPrimariaCalefaccion")) {
			formDataStr = (String) formData.get("indicadorParcialPrimariaCalefaccion");
			record.setIndicadorParcialPrimariaCalefaccion(formDataStr);
		}
		if (formData.containsKey("indicadorParcialPrimariaRefrigeracion")) {
			formDataStr = (String) formData.get("indicadorParcialPrimariaRefrigeracion");
			record.setIndicadorParcialPrimariaRefrigeracion(formDataStr);
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
