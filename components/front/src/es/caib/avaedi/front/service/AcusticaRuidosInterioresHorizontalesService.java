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
import es.caib.avaedi.logic.bo.AcusticaRuidosInterioresHorizontalesBO;
import es.caib.avaedi.logic.bo.InspeccionBO;
import es.caib.avaedi.logic.util.Keys;
import es.caib.avaedi.logic.vo.AcusticaRuidosInterioresHorizontalesFormVO;
import es.caib.avaedi.logic.vo.AcusticaRuidosInterioresHorizontalesListadoVO;
import es.caib.avaedi.logic.vo.AcusticasListadoVO;

/**
 * Servicio para tratar el formulario: AcusticaRuidosInterioresHorizontales
 * 
 * @author agarcia@at4.net
 * 
 */
@Service("acusticaruidosinterioreshorizontales")
public class AcusticaRuidosInterioresHorizontalesService extends InspeccionBaseService<AcusticaRuidosInterioresHorizontalesBO, AcusticaRuidosInterioresHorizontalesListadoVO, AcusticaRuidosInterioresHorizontalesFormVO> {

	/**
	 * The logger object.
	 */
	private static Logger log = LogService.getLogger(AcusticaRuidosInterioresHorizontalesService.class);

	/**
	 * Bean para acceder a los métodos de negocio:
	 * AcusticaRuidosInterioresHorizontales
	 */
	@Autowired
	@Qualifier("AcusticaRuidosInterioresHorizontalesBean")
	protected AcusticaRuidosInterioresHorizontalesBO mainBO;

	/**
	 * Bean para acceder a los métodos de negocio:
	 * AcusticaRuidosInterioresHorizontales
	 * 
	 * @param bean
	 *            the bean to set
	 */
	protected AcusticaRuidosInterioresHorizontalesBO getMainBO() {
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
			formItem.setText(this.getMessage("forms.acusticaruidosinterioreshorizontales.title", locale));
		}

		GridMetaData metaData = this.getBaseMetaData(formItem, locale);

		//Nombre de la clase js de formulario
		metaData.setFormClassName("AcusticaRuidosInterioresHorizontalesForm");

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
		/*metaData.addColumn(new GridColumnMetaData("claveInforme", this.getMessage("forms.acusticaruidosinterioreshorizontales.columns.claveInforme.header", locale)));
		metaData.getColumn("claveInforme").setGroupable(false);
		metaData.getColumn("claveInforme").setSortable(true);
		metaData.getColumn("claveInforme").setSofaFilter(GridColumnFilter.TYPE_NUMERIC);*/

		//Creamos el registro para el record
		/*metaData.addRecordField(new GridRecordFieldMetaData("inspeccionId", GridRecordFieldMetaData.INT_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("inspeccionLabel", GridRecordFieldMetaData.INT_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("inspeccion", "inspeccionLabel", GridRecordFieldMetaData.INT_TYPE));*/

		/** Creamos la columna */
		/*metaData.addColumn(new GridColumnMetaData("inspeccion", this.getMessage("forms.acusticaruidosinterioreshorizontales.columns.inspeccion.header", locale)));
		metaData.getColumn("inspeccion").setGroupable(true);
		metaData.getColumn("inspeccion").setSortable(true);
		metaData.getColumn("inspeccion").setSofaFilter(GridColumnFilter.TYPE_MULTICOMBO);
		metaData.getColumn("inspeccion").setRelatedForm("Inspeccion");

		metaData.getColumn("inspeccion").setEditable(true);*/

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("caracteristicasCamaraAireContinua", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("caracteristicasCamaraAireContinua", this.getMessage("forms.acusticaruidosinterioreshorizontales.columns.caracteristicasCamaraAireContinua.header", locale)));
		metaData.getColumn("caracteristicasCamaraAireContinua").setTooltip(this.getMessage("forms.acusticaruidosinterioreshorizontales.columns.caracteristicasCamaraAireContinua.description", locale));
		metaData.getColumn("caracteristicasCamaraAireContinua").setGroupable(false);
		metaData.getColumn("caracteristicasCamaraAireContinua").setSortable(true);
		metaData.getColumn("caracteristicasCamaraAireContinua").setSofaFilter(GridColumnFilter.TYPE_LIST);
		
		metaData.getColumn("caracteristicasCamaraAireContinua").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] caracteristicasCamaraAireContinuaStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INTERIORES_HORIZONTALES_NS), this.getMessage("forms.acusticaruidosinterioreshorizontales.columns.caracteristicasCamaraAireContinua." + Keys.ACUSTICA_RUIDO_INTERIORES_HORIZONTALES_NS, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INTERIORES_HORIZONTALES_SI), this.getMessage("forms.acusticaruidosinterioreshorizontales.columns.caracteristicasCamaraAireContinua." + Keys.ACUSTICA_RUIDO_INTERIORES_HORIZONTALES_SI, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INTERIORES_HORIZONTALES_NO), this.getMessage("forms.acusticaruidosinterioreshorizontales.columns.caracteristicasCamaraAireContinua." + Keys.ACUSTICA_RUIDO_INTERIORES_HORIZONTALES_NO, locale)},
		};

		metaData.getColumn("caracteristicasCamaraAireContinua").setSofaStoreValues(caracteristicasCamaraAireContinuaStore);

		metaData.getColumn("caracteristicasCamaraAireContinua").setEditable(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("caracteristicasLuminariasEmpotradasSelladas", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("caracteristicasLuminariasEmpotradasSelladas", this.getMessage("forms.acusticaruidosinterioreshorizontales.columns.caracteristicasLuminariasEmpotradasSelladas.header", locale)));
		metaData.getColumn("caracteristicasLuminariasEmpotradasSelladas").setTooltip(this.getMessage("forms.acusticaruidosinterioreshorizontales.columns.caracteristicasLuminariasEmpotradasSelladas.description", locale));
		metaData.getColumn("caracteristicasLuminariasEmpotradasSelladas").setGroupable(false);
		metaData.getColumn("caracteristicasLuminariasEmpotradasSelladas").setSortable(true);
		metaData.getColumn("caracteristicasLuminariasEmpotradasSelladas").setSofaFilter(GridColumnFilter.TYPE_LIST);
		
		metaData.getColumn("caracteristicasLuminariasEmpotradasSelladas").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] caracteristicasLuminariasEmpotradasSelladasStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INTERIORES_HORIZONTALES_NS), this.getMessage("forms.acusticaruidosinterioreshorizontales.columns.caracteristicasLuminariasEmpotradasSelladas." + Keys.ACUSTICA_RUIDO_INTERIORES_HORIZONTALES_NS, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INTERIORES_HORIZONTALES_SI), this.getMessage("forms.acusticaruidosinterioreshorizontales.columns.caracteristicasLuminariasEmpotradasSelladas." + Keys.ACUSTICA_RUIDO_INTERIORES_HORIZONTALES_SI, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INTERIORES_HORIZONTALES_NO), this.getMessage("forms.acusticaruidosinterioreshorizontales.columns.caracteristicasLuminariasEmpotradasSelladas." + Keys.ACUSTICA_RUIDO_INTERIORES_HORIZONTALES_NO, locale)},
		};

		metaData.getColumn("caracteristicasLuminariasEmpotradasSelladas").setSofaStoreValues(caracteristicasLuminariasEmpotradasSelladasStore);

		metaData.getColumn("caracteristicasLuminariasEmpotradasSelladas").setEditable(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("caracteristicasSueloFlotanteContactoDirecto", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("caracteristicasSueloFlotanteContactoDirecto", this.getMessage("forms.acusticaruidosinterioreshorizontales.columns.caracteristicasSueloFlotanteContactoDirecto.header", locale)));
		metaData.getColumn("caracteristicasSueloFlotanteContactoDirecto").setTooltip(this.getMessage("forms.acusticaruidosinterioreshorizontales.columns.caracteristicasSueloFlotanteContactoDirecto.description", locale));
		metaData.getColumn("caracteristicasSueloFlotanteContactoDirecto").setGroupable(false);
		metaData.getColumn("caracteristicasSueloFlotanteContactoDirecto").setSortable(true);
		metaData.getColumn("caracteristicasSueloFlotanteContactoDirecto").setSofaFilter(GridColumnFilter.TYPE_LIST);
		
		metaData.getColumn("caracteristicasSueloFlotanteContactoDirecto").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] caracteristicasSueloFlotanteContactoDirectoStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INTERIORES_HORIZONTALES_NS), this.getMessage("forms.acusticaruidosinterioreshorizontales.columns.caracteristicasSueloFlotanteContactoDirecto." + Keys.ACUSTICA_RUIDO_INTERIORES_HORIZONTALES_NS, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INTERIORES_HORIZONTALES_SI), this.getMessage("forms.acusticaruidosinterioreshorizontales.columns.caracteristicasSueloFlotanteContactoDirecto." + Keys.ACUSTICA_RUIDO_INTERIORES_HORIZONTALES_SI, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INTERIORES_HORIZONTALES_NO), this.getMessage("forms.acusticaruidosinterioreshorizontales.columns.caracteristicasSueloFlotanteContactoDirecto." + Keys.ACUSTICA_RUIDO_INTERIORES_HORIZONTALES_NO, locale)},
		};

		metaData.getColumn("caracteristicasSueloFlotanteContactoDirecto").setSofaStoreValues(caracteristicasSueloFlotanteContactoDirectoStore);

		metaData.getColumn("caracteristicasSueloFlotanteContactoDirecto").setEditable(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("caracteristicasSueloFlotanteRevestidas", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("caracteristicasSueloFlotanteRevestidas", this.getMessage("forms.acusticaruidosinterioreshorizontales.columns.caracteristicasSueloFlotanteRevestidas.header", locale)));
		metaData.getColumn("caracteristicasSueloFlotanteRevestidas").setTooltip(this.getMessage("forms.acusticaruidosinterioreshorizontales.columns.caracteristicasSueloFlotanteRevestidas.description", locale));
		metaData.getColumn("caracteristicasSueloFlotanteRevestidas").setGroupable(false);
		metaData.getColumn("caracteristicasSueloFlotanteRevestidas").setSortable(true);
		metaData.getColumn("caracteristicasSueloFlotanteRevestidas").setSofaFilter(GridColumnFilter.TYPE_LIST);
		
		metaData.getColumn("caracteristicasSueloFlotanteRevestidas").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] caracteristicasSueloFlotanteRevestidasStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INTERIORES_HORIZONTALES_NS), this.getMessage("forms.acusticaruidosinterioreshorizontales.columns.caracteristicasSueloFlotanteRevestidas." + Keys.ACUSTICA_RUIDO_INTERIORES_HORIZONTALES_NS, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INTERIORES_HORIZONTALES_SI), this.getMessage("forms.acusticaruidosinterioreshorizontales.columns.caracteristicasSueloFlotanteRevestidas." + Keys.ACUSTICA_RUIDO_INTERIORES_HORIZONTALES_SI, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INTERIORES_HORIZONTALES_NO), this.getMessage("forms.acusticaruidosinterioreshorizontales.columns.caracteristicasSueloFlotanteRevestidas." + Keys.ACUSTICA_RUIDO_INTERIORES_HORIZONTALES_NO, locale)},
		};

		metaData.getColumn("caracteristicasSueloFlotanteRevestidas").setSofaStoreValues(caracteristicasSueloFlotanteRevestidasStore);

		metaData.getColumn("caracteristicasSueloFlotanteRevestidas").setEditable(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("deficienciasObservaciones", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("deficienciasObservaciones", this.getMessage("forms.acusticaruidosinterioreshorizontales.columns.deficienciasObservaciones.header", locale)));
		metaData.getColumn("deficienciasObservaciones").setGroupable(false);
		metaData.getColumn("deficienciasObservaciones").setSortable(true);
		metaData.getColumn("deficienciasObservaciones").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("deficienciasObservaciones").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("deficienciasObservaciones").setEditable(true);
		metaData.getColumn("deficienciasObservaciones").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("estadoBueno", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("estadoBueno", this.getMessage("forms.acusticaruidosinterioreshorizontales.columns.estadoBueno.header", locale)));
		metaData.getColumn("estadoBueno").setGroupable(false);
		metaData.getColumn("estadoBueno").setSortable(true);
		metaData.getColumn("estadoBueno").setSofaFilter(GridColumnFilter.TYPE_LIST);
		
		metaData.getColumn("estadoBueno").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] estadoBuenoStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INTERIORES_HORIZONTALES_NS), this.getMessage("forms.acusticaruidosinterioreshorizontales.columns.estadoBueno." + Keys.ACUSTICA_RUIDO_INTERIORES_HORIZONTALES_NS, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INTERIORES_HORIZONTALES_SI), this.getMessage("forms.acusticaruidosinterioreshorizontales.columns.estadoBueno." + Keys.ACUSTICA_RUIDO_INTERIORES_HORIZONTALES_SI, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INTERIORES_HORIZONTALES_NO), this.getMessage("forms.acusticaruidosinterioreshorizontales.columns.estadoBueno." + Keys.ACUSTICA_RUIDO_INTERIORES_HORIZONTALES_NO, locale)},
		};

		metaData.getColumn("estadoBueno").setSofaStoreValues(estadoBuenoStore);

		metaData.getColumn("estadoBueno").setEditable(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("forjadoPlantagarajeOtro", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("forjadoPlantagarajeOtro", this.getMessage("forms.acusticaruidosinterioreshorizontales.columns.forjadoPlantagarajeOtro.header", locale)));
		metaData.getColumn("forjadoPlantagarajeOtro").setGroupable(false);
		metaData.getColumn("forjadoPlantagarajeOtro").setSortable(true);
		metaData.getColumn("forjadoPlantagarajeOtro").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("forjadoPlantagarajeOtro").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("forjadoPlantagarajeOtro").setEditable(true);
		metaData.getColumn("forjadoPlantagarajeOtro").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("forjadoPlantatipoOtro", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("forjadoPlantatipoOtro", this.getMessage("forms.acusticaruidosinterioreshorizontales.columns.forjadoPlantatipoOtro.header", locale)));
		metaData.getColumn("forjadoPlantatipoOtro").setGroupable(false);
		metaData.getColumn("forjadoPlantatipoOtro").setSortable(true);
		metaData.getColumn("forjadoPlantatipoOtro").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("forjadoPlantatipoOtro").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("forjadoPlantatipoOtro").setEditable(true);
		metaData.getColumn("forjadoPlantatipoOtro").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("observaciones", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("observaciones", this.getMessage("forms.acusticaruidosinterioreshorizontales.columns.observaciones.header", locale)));
		metaData.getColumn("observaciones").setGroupable(false);
		metaData.getColumn("observaciones").setSortable(true);
		metaData.getColumn("observaciones").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("observaciones").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("observaciones").setEditable(true);
		metaData.getColumn("observaciones").setHidden(true);
		
		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("plantagarajeCantoForjado", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("plantagarajeCantoForjado", this.getMessage("forms.acusticaruidosinterioreshorizontales.columns.plantagarajeCantoForjado.header", locale)));
		metaData.getColumn("plantagarajeCantoForjado").setGroupable(false);
		metaData.getColumn("plantagarajeCantoForjado").setSortable(true);
		metaData.getColumn("plantagarajeCantoForjado").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("plantagarajeCantoForjado").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("plantagarajeCantoForjado").setEditable(true);
		metaData.getColumn("plantagarajeCantoForjado").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("plantatipoCantoForjado", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("plantatipoCantoForjado", this.getMessage("forms.acusticaruidosinterioreshorizontales.columns.plantatipoCantoForjado.header", locale)));
		metaData.getColumn("plantatipoCantoForjado").setGroupable(false);
		metaData.getColumn("plantatipoCantoForjado").setSortable(true);
		metaData.getColumn("plantatipoCantoForjado").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("plantatipoCantoForjado").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("plantatipoCantoForjado").setEditable(true);
		metaData.getColumn("plantatipoCantoForjado").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("sueloFlotanteTiene", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("sueloFlotanteTiene", this.getMessage("forms.acusticaruidosinterioreshorizontales.columns.sueloFlotanteTiene.header", locale)));
		metaData.getColumn("sueloFlotanteTiene").setGroupable(false);
		metaData.getColumn("sueloFlotanteTiene").setSortable(true);
		metaData.getColumn("sueloFlotanteTiene").setSofaFilter(GridColumnFilter.TYPE_LIST);
		
		metaData.getColumn("sueloFlotanteTiene").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] sueloFlotanteTieneStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INTERIORES_HORIZONTALES_NS), this.getMessage("forms.acusticaruidosinterioreshorizontales.columns.sueloFlotanteTiene." + Keys.ACUSTICA_RUIDO_INTERIORES_HORIZONTALES_NS, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INTERIORES_HORIZONTALES_SI), this.getMessage("forms.acusticaruidosinterioreshorizontales.columns.sueloFlotanteTiene." + Keys.ACUSTICA_RUIDO_INTERIORES_HORIZONTALES_SI, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INTERIORES_HORIZONTALES_NO), this.getMessage("forms.acusticaruidosinterioreshorizontales.columns.sueloFlotanteTiene." + Keys.ACUSTICA_RUIDO_INTERIORES_HORIZONTALES_NO, locale)},
		};

		metaData.getColumn("sueloFlotanteTiene").setSofaStoreValues(sueloFlotanteTieneStore);

		metaData.getColumn("sueloFlotanteTiene").setEditable(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("techoSuspendidoTiene", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("techoSuspendidoTiene", this.getMessage("forms.acusticaruidosinterioreshorizontales.columns.techoSuspendidoTiene.header", locale)));
		metaData.getColumn("techoSuspendidoTiene").setGroupable(false);
		metaData.getColumn("techoSuspendidoTiene").setSortable(true);
		metaData.getColumn("techoSuspendidoTiene").setSofaFilter(GridColumnFilter.TYPE_LIST);
		
		metaData.getColumn("techoSuspendidoTiene").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] techoSuspendidoTieneStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INTERIORES_HORIZONTALES_NS), this.getMessage("forms.acusticaruidosinterioreshorizontales.columns.techoSuspendidoTiene." + Keys.ACUSTICA_RUIDO_INTERIORES_HORIZONTALES_NS, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INTERIORES_HORIZONTALES_SI), this.getMessage("forms.acusticaruidosinterioreshorizontales.columns.techoSuspendidoTiene." + Keys.ACUSTICA_RUIDO_INTERIORES_HORIZONTALES_SI, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INTERIORES_HORIZONTALES_NO), this.getMessage("forms.acusticaruidosinterioreshorizontales.columns.techoSuspendidoTiene." + Keys.ACUSTICA_RUIDO_INTERIORES_HORIZONTALES_NO, locale)},
		};

		metaData.getColumn("techoSuspendidoTiene").setSofaStoreValues(techoSuspendidoTieneStore);

		metaData.getColumn("techoSuspendidoTiene").setEditable(true);

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

		datosExportacion.add("claveInforme", this.getMessage("forms.acusticaruidosinterioreshorizontales.columns.claveInforme.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("inspeccion", this.getMessage("forms.acusticaruidosinterioreshorizontales.columns.inspeccion.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("caracteristicasCamaraAireContinua", this.getMessage("forms.acusticaruidosinterioreshorizontales.columns.caracteristicasCamaraAireContinua.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("caracteristicasLuminariasEmpotradasSelladas", this.getMessage("forms.acusticaruidosinterioreshorizontales.columns.caracteristicasLuminariasEmpotradasSelladas.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("caracteristicasSueloFlotanteContactoDirecto", this.getMessage("forms.acusticaruidosinterioreshorizontales.columns.caracteristicasSueloFlotanteContactoDirecto.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("caracteristicasSueloFlotanteRevestidas", this.getMessage("forms.acusticaruidosinterioreshorizontales.columns.caracteristicasSueloFlotanteRevestidas.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("deficienciasObservaciones", this.getMessage("forms.acusticaruidosinterioreshorizontales.columns.deficienciasObservaciones.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("estadoBueno", this.getMessage("forms.acusticaruidosinterioreshorizontales.columns.estadoBueno.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("forjadoPlantagarajeOtro", this.getMessage("forms.acusticaruidosinterioreshorizontales.columns.forjadoPlantagarajeOtro.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("forjadoPlantatipoOtro", this.getMessage("forms.acusticaruidosinterioreshorizontales.columns.forjadoPlantatipoOtro.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("observaciones", this.getMessage("forms.acusticaruidosinterioreshorizontales.columns.observaciones.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("plantagarajeCantoForjado", this.getMessage("forms.acusticaruidosinterioreshorizontales.columns.plantagarajeCantoForjado.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("plantatipoCantoForjado", this.getMessage("forms.acusticaruidosinterioreshorizontales.columns.plantatipoCantoForjado.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("sueloFlotanteTiene", this.getMessage("forms.acusticaruidosinterioreshorizontales.columns.sueloFlotanteTiene.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("techoSuspendidoTiene", this.getMessage("forms.acusticaruidosinterioreshorizontales.columns.techoSuspendidoTiene.header", locale), TipoCampoExportacion.STRING);

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
		AcusticaRuidosInterioresHorizontalesListadoVO instance = (AcusticaRuidosInterioresHorizontalesListadoVO) rawInstance;

		List<String> excelRow = new ArrayList<String>();

		excelRow.add(FormData2Java.toString(instance.getClaveInforme()));
		excelRow.add(FormData2Java.toString(instance.getInspeccionLabel()));
		//excelRow.add(FormData2Java.toString(instance.getCaracteristicasCamaraAireContinua()));
		if (instance.getCaracteristicasCamaraAireContinua()!=null){
			excelRow.add( this.getMessage("forms.acusticaruidosinterioreshorizontales.columns.caracteristicasCamaraAireContinua." + instance.getCaracteristicasCamaraAireContinua(), locale) );
		}else{
			excelRow.add("null");
		}
		
		//excelRow.add(FormData2Java.toString(instance.getCaracteristicasLuminariasEmpotradasSelladas()));
		if (instance.getCaracteristicasLuminariasEmpotradasSelladas()!=null){
			excelRow.add( this.getMessage("forms.acusticaruidosinterioreshorizontales.columns.caracteristicasLuminariasEmpotradasSelladas." + instance.getCaracteristicasLuminariasEmpotradasSelladas(), locale) );
		}else{
			excelRow.add("null");
		}
		
		//excelRow.add(FormData2Java.toString(instance.getCaracteristicasSueloFlotanteContactoDirecto()));
		if (instance.getCaracteristicasSueloFlotanteContactoDirecto()!=null){
			excelRow.add( this.getMessage("forms.acusticaruidosinterioreshorizontales.columns.caracteristicasSueloFlotanteContactoDirecto." + instance.getCaracteristicasSueloFlotanteContactoDirecto(), locale) );
		}else{
			excelRow.add("null");
		}
		
		//excelRow.add(FormData2Java.toString(instance.getCaracteristicasSueloFlotanteRevestidas()));
		if (instance.getCaracteristicasSueloFlotanteRevestidas()!=null){
			excelRow.add( this.getMessage("forms.acusticaruidosinterioreshorizontales.columns.caracteristicasSueloFlotanteRevestidas." + instance.getCaracteristicasSueloFlotanteRevestidas(), locale) );
		}else{
			excelRow.add("null");
		}
		
		excelRow.add(instance.getDeficienciasObservaciones());
		//excelRow.add(FormData2Java.toString(instance.getEstadoBueno()));
		if (instance.getEstadoBueno()!=null){
			excelRow.add( this.getMessage("forms.acusticaruidosinterioreshorizontales.columns.estadoBueno." + instance.getEstadoBueno(), locale) );
		}else{
			excelRow.add("null");
		}
		
		excelRow.add(instance.getForjadoPlantagarajeOtro());
		excelRow.add(instance.getForjadoPlantatipoOtro());
		excelRow.add(instance.getObservaciones());
		excelRow.add(instance.getPlantagarajeCantoForjado());
		excelRow.add(instance.getPlantatipoCantoForjado());
		//excelRow.add(FormData2Java.toString(instance.getSueloFlotanteTiene()));
		if (instance.getSueloFlotanteTiene()!=null){
			excelRow.add( this.getMessage("forms.acusticaruidosinterioreshorizontales.columns.sueloFlotanteTiene." + instance.getSueloFlotanteTiene(), locale) );
		}else{
			excelRow.add("null");
		}
		
		//excelRow.add(FormData2Java.toString(instance.getTechoSuspendidoTiene()));
		if (instance.getTechoSuspendidoTiene()!=null){
			excelRow.add( this.getMessage("forms.acusticaruidosinterioreshorizontales.columns.techoSuspendidoTiene." + instance.getTechoSuspendidoTiene(), locale) );
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
	 * Rellena una instancia de AcusticaRuidosInterioresHorizontalesFormVO con
	 * el contenido de un formulario recibido en formato Map<String, ?>
	 */
	protected void setFormData(AcusticaRuidosInterioresHorizontalesFormVO record, Map<String, ?> formData) throws GenericBusinessException {
		String formDataStr = null;
		if (!StringUtils.isEmpty(formData, "inspeccionId")) {
			formDataStr = (String) formData.get("inspeccionId");
			record.setInspeccionId(FormData2Java.toInteger(formDataStr));

		}
		if (formData.containsKey("caracteristicasCamaraAireContinua")) {
			formDataStr = (String) formData.get("caracteristicasCamaraAireContinua");
			record.setCaracteristicasCamaraAireContinua(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("caracteristicasLuminariasEmpotradasSelladas")) {
			formDataStr = (String) formData.get("caracteristicasLuminariasEmpotradasSelladas");
			record.setCaracteristicasLuminariasEmpotradasSelladas(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("caracteristicasSueloFlotanteContactoDirecto")) {
			formDataStr = (String) formData.get("caracteristicasSueloFlotanteContactoDirecto");
			record.setCaracteristicasSueloFlotanteContactoDirecto(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("caracteristicasSueloFlotanteRevestidas")) {
			formDataStr = (String) formData.get("caracteristicasSueloFlotanteRevestidas");
			record.setCaracteristicasSueloFlotanteRevestidas(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("deficienciasObservaciones")) {
			formDataStr = (String) formData.get("deficienciasObservaciones");
			record.setDeficienciasObservaciones(formDataStr);
		}
		if (formData.containsKey("estadoBueno")) {
			formDataStr = (String) formData.get("estadoBueno");
			record.setEstadoBueno(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("forjadoPlantagarajeOtro")) {
			formDataStr = (String) formData.get("forjadoPlantagarajeOtro");
			record.setForjadoPlantagarajeOtro(formDataStr);
		}
		if (formData.containsKey("forjadoPlantatipoOtro")) {
			formDataStr = (String) formData.get("forjadoPlantatipoOtro");
			record.setForjadoPlantatipoOtro(formDataStr);
		}
		if (formData.containsKey("observaciones")) {
			formDataStr = (String) formData.get("observaciones");
			record.setObservaciones(formDataStr);
		}
		if (formData.containsKey("plantagarajeCantoForjado")) {
			formDataStr = (String) formData.get("plantagarajeCantoForjado");
			record.setPlantagarajeCantoForjado(formDataStr);
		}
		if (formData.containsKey("plantatipoCantoForjado")) {
			formDataStr = (String) formData.get("plantatipoCantoForjado");
			record.setPlantatipoCantoForjado(formDataStr);
		}
		if (formData.containsKey("sueloFlotanteTiene")) {
			formDataStr = (String) formData.get("sueloFlotanteTiene");
			record.setSueloFlotanteTiene(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("techoSuspendidoTiene")) {
			formDataStr = (String) formData.get("techoSuspendidoTiene");
			record.setTechoSuspendidoTiene(FormData2Java.toInteger(formDataStr));
		}
	}

}
