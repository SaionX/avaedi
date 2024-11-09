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
import es.caib.avaedi.logic.bo.AccesibilidadPublicosBO;
import es.caib.avaedi.logic.bo.InspeccionBO;
import es.caib.avaedi.logic.util.Keys;
import es.caib.avaedi.logic.vo.AccesibilidadPublicosFormVO;
import es.caib.avaedi.logic.vo.AccesibilidadPublicosListadoVO;
import es.caib.avaedi.logic.vo.CimentacionesListadoVO;

/**
 * Servicio para tratar el formulario: AccesibilidadPublicos
 * 
 * @author agarcia@at4.net
 * 
 */
@Service("accesibilidadpublicos")
public class AccesibilidadPublicosService extends InspeccionBaseService<AccesibilidadPublicosBO, AccesibilidadPublicosListadoVO, AccesibilidadPublicosFormVO> {

	/**
	 * The logger object.
	 */
	private static Logger log = LogService.getLogger(AccesibilidadPublicosService.class);

	/**
	 * Bean para acceder a los métodos de negocio: AccesibilidadPublicos
	 */
	@Autowired
	@Qualifier("AccesibilidadPublicosBean")
	protected AccesibilidadPublicosBO mainBO;

	/**
	 * Bean para acceder a los métodos de negocio: AccesibilidadPublicos
	 * 
	 * @param bean
	 *            the bean to set
	 */
	protected AccesibilidadPublicosBO getMainBO() {
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
			formItem.setText(this.getMessage("forms.accesibilidadpublicos.title", locale));
		}

		GridMetaData metaData = this.getBaseMetaData(formItem, locale);

		//Nombre de la clase js de formulario
		metaData.setFormClassName("AccesibilidadPublicosForm");

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
		/*metaData.addColumn(new GridColumnMetaData("claveInforme", this.getMessage("forms.accesibilidadpublicos.columns.claveInforme.header", locale)));
		metaData.getColumn("claveInforme").setGroupable(false);
		metaData.getColumn("claveInforme").setSortable(true);
		metaData.getColumn("claveInforme").setSofaFilter(GridColumnFilter.TYPE_NUMERIC);*/

		///Creamos el registro para el record
		/*metaData.addRecordField(new GridRecordFieldMetaData("inspeccionId", GridRecordFieldMetaData.INT_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("inspeccionLabel", GridRecordFieldMetaData.INT_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("inspeccion", "inspeccionLabel", GridRecordFieldMetaData.INT_TYPE));*/

		/** Creamos la columna */
		/*metaData.addColumn(new GridColumnMetaData("inspeccion", this.getMessage("forms.accesibilidadpublicos.columns.inspeccion.header", locale)));
		metaData.getColumn("inspeccion").setGroupable(true);
		metaData.getColumn("inspeccion").setSortable(true);
		metaData.getColumn("inspeccion").setSofaFilter(GridColumnFilter.TYPE_MULTICOMBO);
		metaData.getColumn("inspeccion").setRelatedForm("Inspeccion");

		metaData.getColumn("inspeccion").setEditable(true);*/

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("alojamientosaccesibles1porcada50", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("alojamientosaccesibles1porcada50", this.getMessage("forms.accesibilidadpublicos.columns.alojamientosaccesibles1porcada50.header", locale)));
		metaData.getColumn("alojamientosaccesibles1porcada50").setTooltip(this.getMessage("forms.accesibilidadpublicos.columns.alojamientosaccesibles1porcada50.description", locale));
		metaData.getColumn("alojamientosaccesibles1porcada50").setGroupable(false);
		metaData.getColumn("alojamientosaccesibles1porcada50").setSortable(true);
		metaData.getColumn("alojamientosaccesibles1porcada50").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("alojamientosaccesibles1porcada50").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] alojamiento1porcada50Store = new String[][]{
				{ String.valueOf(Keys.ACCESIBILIDAD_PUBLICOS_1_POR_CADA_50_SI), this.getMessage("forms.accesibilidadpublicos.columns.alojamientosaccesibles1porcada50." + Keys.ACCESIBILIDAD_PUBLICOS_1_POR_CADA_50_SI, locale)},
				{ String.valueOf(Keys.ACCESIBILIDAD_PUBLICOS_1_POR_CADA_50_NO), this.getMessage("forms.accesibilidadpublicos.columns.alojamientosaccesibles1porcada50." + Keys.ACCESIBILIDAD_PUBLICOS_1_POR_CADA_50_NO, locale)},
		};

		metaData.getColumn("alojamientosaccesibles1porcada50").setSofaStoreValues(alojamiento1porcada50Store);

		metaData.getColumn("alojamientosaccesibles1porcada50").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("alojamientosaccesibles1porcada50").setEditable(true);
		metaData.getColumn("alojamientosaccesibles1porcada50").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("alojamientosaccesiblesMinimo1", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("alojamientosaccesiblesMinimo1", this.getMessage("forms.accesibilidadpublicos.columns.alojamientosaccesiblesMinimo1.header", locale)));
		metaData.getColumn("alojamientosaccesiblesMinimo1").setTooltip(this.getMessage("forms.accesibilidadpublicos.columns.alojamientosaccesiblesMinimo1.description", locale));
		metaData.getColumn("alojamientosaccesiblesMinimo1").setGroupable(false);
		metaData.getColumn("alojamientosaccesiblesMinimo1").setSortable(true);
		metaData.getColumn("alojamientosaccesiblesMinimo1").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("alojamientosaccesiblesMinimo1").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] minimo1Store = new String[][]{
				{ String.valueOf(Keys.ACCESIBILIDAD_PUBLICOS_MINIMO_1_SI), this.getMessage("forms.accesibilidadpublicos.columns.alojamientosaccesiblesMinimo1." + Keys.ACCESIBILIDAD_PUBLICOS_MINIMO_1_SI, locale)},
				{ String.valueOf(Keys.ACCESIBILIDAD_PUBLICOS_MINIMO_1_NO), this.getMessage("forms.accesibilidadpublicos.columns.alojamientosaccesiblesMinimo1." + Keys.ACCESIBILIDAD_PUBLICOS_MINIMO_1_NO, locale)},
		};

		metaData.getColumn("alojamientosaccesiblesMinimo1").setSofaStoreValues(minimo1Store);

		metaData.getColumn("alojamientosaccesiblesMinimo1").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("alojamientosaccesiblesMinimo1").setEditable(true);
		metaData.getColumn("alojamientosaccesiblesMinimo1").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("alojamientosaccesiblesMinimo2", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("alojamientosaccesiblesMinimo2", this.getMessage("forms.accesibilidadpublicos.columns.alojamientosaccesiblesMinimo2.header", locale)));
		metaData.getColumn("alojamientosaccesiblesMinimo2").setTooltip(this.getMessage("forms.accesibilidadpublicos.columns.alojamientosaccesiblesMinimo2.description", locale));
		metaData.getColumn("alojamientosaccesiblesMinimo2").setGroupable(false);
		metaData.getColumn("alojamientosaccesiblesMinimo2").setSortable(true);
		metaData.getColumn("alojamientosaccesiblesMinimo2").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("alojamientosaccesiblesMinimo2").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] minimo2Store = new String[][]{
				{ String.valueOf(Keys.ACCESIBILIDAD_PUBLICOS_MINIMO_2_SI), this.getMessage("forms.accesibilidadpublicos.columns.alojamientosaccesiblesMinimo2." + Keys.ACCESIBILIDAD_PUBLICOS_MINIMO_2_SI, locale)},
				{ String.valueOf(Keys.ACCESIBILIDAD_PUBLICOS_MINIMO_2_NO), this.getMessage("forms.accesibilidadpublicos.columns.alojamientosaccesiblesMinimo2." + Keys.ACCESIBILIDAD_PUBLICOS_MINIMO_2_NO, locale)},
		};

		metaData.getColumn("alojamientosaccesiblesMinimo2").setSofaStoreValues(minimo2Store);

		metaData.getColumn("alojamientosaccesiblesMinimo2").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("alojamientosaccesiblesMinimo2").setEditable(true);
		metaData.getColumn("alojamientosaccesiblesMinimo2").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("alojamientosaccesiblesMinimo4", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("alojamientosaccesiblesMinimo4", this.getMessage("forms.accesibilidadpublicos.columns.alojamientosaccesiblesMinimo4.header", locale)));
		metaData.getColumn("alojamientosaccesiblesMinimo4").setTooltip(this.getMessage("forms.accesibilidadpublicos.columns.alojamientosaccesiblesMinimo4.description", locale));
		metaData.getColumn("alojamientosaccesiblesMinimo4").setGroupable(false);
		metaData.getColumn("alojamientosaccesiblesMinimo4").setSortable(true);
		metaData.getColumn("alojamientosaccesiblesMinimo4").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("alojamientosaccesiblesMinimo4").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] minimo4Store = new String[][]{
				{ String.valueOf(Keys.ACCESIBILIDAD_PUBLICOS_MINIMO_4_SI), this.getMessage("forms.accesibilidadpublicos.columns.alojamientosaccesiblesMinimo4." + Keys.ACCESIBILIDAD_PUBLICOS_MINIMO_4_SI, locale)},
				{ String.valueOf(Keys.ACCESIBILIDAD_PUBLICOS_MINIMO_4_NO), this.getMessage("forms.accesibilidadpublicos.columns.alojamientosaccesiblesMinimo4." + Keys.ACCESIBILIDAD_PUBLICOS_MINIMO_4_NO, locale)},
		};

		metaData.getColumn("alojamientosaccesiblesMinimo4").setSofaStoreValues(minimo4Store);

		metaData.getColumn("alojamientosaccesiblesMinimo4").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("alojamientosaccesiblesMinimo4").setEditable(true);
		metaData.getColumn("alojamientosaccesiblesMinimo4").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("alojamientosaccesiblesMinimo6", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("alojamientosaccesiblesMinimo6", this.getMessage("forms.accesibilidadpublicos.columns.alojamientosaccesiblesMinimo6.header", locale)));
		metaData.getColumn("alojamientosaccesiblesMinimo6").setTooltip(this.getMessage("forms.accesibilidadpublicos.columns.alojamientosaccesiblesMinimo6.description", locale));
		metaData.getColumn("alojamientosaccesiblesMinimo6").setGroupable(false);
		metaData.getColumn("alojamientosaccesiblesMinimo6").setSortable(true);
		metaData.getColumn("alojamientosaccesiblesMinimo6").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("alojamientosaccesiblesMinimo6").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] minimo6Store = new String[][]{
				{ String.valueOf(Keys.ACCESIBILIDAD_PUBLICOS_MINIMO_6_SI), this.getMessage("forms.accesibilidadpublicos.columns.alojamientosaccesiblesMinimo6." + Keys.ACCESIBILIDAD_PUBLICOS_MINIMO_6_SI, locale)},
				{ String.valueOf(Keys.ACCESIBILIDAD_PUBLICOS_MINIMO_6_NO), this.getMessage("forms.accesibilidadpublicos.columns.alojamientosaccesiblesMinimo6." + Keys.ACCESIBILIDAD_PUBLICOS_MINIMO_6_NO, locale)},
		};

		metaData.getColumn("alojamientosaccesiblesMinimo6").setSofaStoreValues(minimo6Store);

		metaData.getColumn("alojamientosaccesiblesMinimo6").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("alojamientosaccesiblesMinimo6").setEditable(true);
		metaData.getColumn("alojamientosaccesiblesMinimo6").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("alojamientosaccesiblesMinimo8", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("alojamientosaccesiblesMinimo8", this.getMessage("forms.accesibilidadpublicos.columns.alojamientosaccesiblesMinimo8.header", locale)));
		metaData.getColumn("alojamientosaccesiblesMinimo8").setTooltip(this.getMessage("forms.accesibilidadpublicos.columns.alojamientosaccesiblesMinimo8.description", locale));
		metaData.getColumn("alojamientosaccesiblesMinimo8").setGroupable(false);
		metaData.getColumn("alojamientosaccesiblesMinimo8").setSortable(true);
		metaData.getColumn("alojamientosaccesiblesMinimo8").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("alojamientosaccesiblesMinimo8").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] minimo8Store = new String[][]{
				{ String.valueOf(Keys.ACCESIBILIDAD_PUBLICOS_MINIMO_8_SI), this.getMessage("forms.accesibilidadpublicos.columns.alojamientosaccesiblesMinimo8." + Keys.ACCESIBILIDAD_PUBLICOS_MINIMO_8_SI, locale)},
				{ String.valueOf(Keys.ACCESIBILIDAD_PUBLICOS_MINIMO_8_NO), this.getMessage("forms.accesibilidadpublicos.columns.alojamientosaccesiblesMinimo8." + Keys.ACCESIBILIDAD_PUBLICOS_MINIMO_8_NO, locale)},
		};

		metaData.getColumn("alojamientosaccesiblesMinimo8").setSofaStoreValues(minimo8Store);

		metaData.getColumn("alojamientosaccesiblesMinimo8").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("alojamientosaccesiblesMinimo8").setEditable(true);
		metaData.getColumn("alojamientosaccesiblesMinimo8").setHidden(true);

		//Creamos el registro para el record
		//metaData.addRecordField(new GridRecordFieldMetaData("alojamientosaccesiblesObservaciones", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		/*
		 * metaData.addColumn( new GridColumnMetaData(
		 * "alojamientosaccesiblesObservaciones", this.getMessage(
		 * "forms.accesibilidadpublicos.columns.alojamientosaccesiblesObservaciones.header"
		 * , locale) ) );
		 * metaData.getColumn("alojamientosaccesiblesObservaciones").setTooltip(
		 * this.getMessage(
		 * "forms.accesibilidadpublicos.columns.alojamientosaccesiblesObservaciones.description"
		 * , locale) );
		 * metaData.getColumn("alojamientosaccesiblesObservaciones")
		 * .setGroupable( false );
		 * metaData.getColumn("alojamientosaccesiblesObservaciones"
		 * ).setSortable( true );
		 * metaData.getColumn("alojamientosaccesiblesObservaciones"
		 * ).setSofaFilter( GridColumnFilter.TYPE_STRING );
		 * 
		 * metaData.getColumn("alojamientosaccesiblesObservaciones").setSofaRenderer
		 * ( GridColumnMetaData.RENDERER_LARGETEXT );
		 * 
		 * metaData.getColumn("alojamientosaccesiblesObservaciones").setEditable(
		 * true );
		 */

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("aparcamientoComercialPorfraccion", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("aparcamientoComercialPorfraccion", this.getMessage("forms.accesibilidadpublicos.columns.aparcamientoComercialPorfraccion.header", locale)));
		metaData.getColumn("aparcamientoComercialPorfraccion").setTooltip(this.getMessage("forms.accesibilidadpublicos.columns.aparcamientoComercialPorfraccion.description", locale));
		metaData.getColumn("aparcamientoComercialPorfraccion").setGroupable(false);
		metaData.getColumn("aparcamientoComercialPorfraccion").setSortable(true);
		metaData.getColumn("aparcamientoComercialPorfraccion").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("aparcamientoComercialPorfraccion").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] aparcamientoComercialPorfraccionStore = new String[][]{
				{ String.valueOf(Keys.ACCESIBILIDAD_APARCAMIENTO_COMERCIAL_POR_FRACCION_SI), this.getMessage("forms.accesibilidadpublicos.columns.aparcamientoComercialPorfraccion." + Keys.ACCESIBILIDAD_APARCAMIENTO_COMERCIAL_POR_FRACCION_SI, locale)},
				{ String.valueOf(Keys.ACCESIBILIDAD_APARCAMIENTO_COMERCIAL_POR_FRACCION_NO), this.getMessage("forms.accesibilidadpublicos.columns.aparcamientoComercialPorfraccion." + Keys.ACCESIBILIDAD_APARCAMIENTO_COMERCIAL_POR_FRACCION_NO, locale)},
		};

		metaData.getColumn("aparcamientoComercialPorfraccion").setSofaStoreValues(aparcamientoComercialPorfraccionStore);

		metaData.getColumn("aparcamientoComercialPorfraccion").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("aparcamientoComercialPorfraccion").setEditable(true);
		//metaData.getColumn("aparcamientoComercialPorfraccion").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("tecnico", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("tecnico", this.getMessage("forms.accesibilidadpublicos.columns.tecnico.header", locale)));
		metaData.getColumn("tecnico").setGroupable(false);
		metaData.getColumn("tecnico").setSortable(true);
		metaData.getColumn("tecnico").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("tecnico").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("tecnico").setEditable(true);


		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("nif", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("nif", this.getMessage("forms.accesibilidadpublicos.columns.nif.header", locale)));
		metaData.getColumn("nif").setGroupable(false);
		metaData.getColumn("nif").setSortable(true);
		metaData.getColumn("nif").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("nif").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("nif").setEditable(true);
		//metaData.getColumn("nif").setHidden(true);


		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("titulacion", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("titulacion", this.getMessage("forms.accesibilidadpublicos.columns.titulacion.header", locale)));
		metaData.getColumn("titulacion").setGroupable(false);
		metaData.getColumn("titulacion").setSortable(true);
		metaData.getColumn("titulacion").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("titulacion").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("titulacion").setEditable(true);
		//metaData.getColumn("titulacion").setHidden(true);



		//Creamos el registro para el record
		//metaData.addRecordField(new GridRecordFieldMetaData("aparcamientoObservaciones", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		/*
		 * metaData.addColumn( new GridColumnMetaData(
		 * "aparcamientoObservaciones", this.getMessage(
		 * "forms.accesibilidadpublicos.columns.aparcamientoObservaciones.header"
		 * , locale) ) );
		 * metaData.getColumn("aparcamientoObservaciones").setGroupable( false
		 * ); metaData.getColumn("aparcamientoObservaciones").setSortable( true
		 * ); metaData.getColumn("aparcamientoObservaciones").setSofaFilter(
		 * GridColumnFilter.TYPE_STRING );
		 * 
		 * metaData.getColumn("aparcamientoObservaciones").setSofaRenderer(
		 * GridColumnMetaData.RENDERER_LARGETEXT );
		 * 
		 * metaData.getColumn("aparcamientoObservaciones").setEditable( true );
		 */

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("aparcamientoOtrosusosMinimoaparcamientosUnamasporfraccion", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("aparcamientoOtrosusosMinimoaparcamientosUnamasporfraccion", this.getMessage("forms.accesibilidadpublicos.columns.aparcamientoOtrosusosMinimoaparcamientosUnamasporfraccion.header", locale)));
		metaData.getColumn("aparcamientoOtrosusosMinimoaparcamientosUnamasporfraccion").setTooltip(this.getMessage("forms.accesibilidadpublicos.columns.aparcamientoOtrosusosMinimoaparcamientosUnamasporfraccion.description", locale));
		metaData.getColumn("aparcamientoOtrosusosMinimoaparcamientosUnamasporfraccion").setGroupable(false);
		metaData.getColumn("aparcamientoOtrosusosMinimoaparcamientosUnamasporfraccion").setSortable(true);
		metaData.getColumn("aparcamientoOtrosusosMinimoaparcamientosUnamasporfraccion").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("aparcamientoOtrosusosMinimoaparcamientosUnamasporfraccion").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] unasMasPorFraccionStore = new String[][]{
				{ String.valueOf(Keys.ACCESIBILIDAD_APARCAMIENTO_UNA_MAS_POR_FRACCION_SI), this.getMessage("forms.accesibilidadpublicos.columns.aparcamientoOtrosusosMinimoaparcamientosUnamasporfraccion." + Keys.ACCESIBILIDAD_APARCAMIENTO_UNA_MAS_POR_FRACCION_SI, locale)},
				{ String.valueOf(Keys.ACCESIBILIDAD_APARCAMIENTO_UNA_MAS_POR_FRACCION_NO), this.getMessage("forms.accesibilidadpublicos.columns.aparcamientoOtrosusosMinimoaparcamientosUnamasporfraccion." + Keys.ACCESIBILIDAD_APARCAMIENTO_UNA_MAS_POR_FRACCION_NO, locale)},
		};

		metaData.getColumn("aparcamientoOtrosusosMinimoaparcamientosUnamasporfraccion").setSofaStoreValues(unasMasPorFraccionStore);

		metaData.getColumn("aparcamientoOtrosusosMinimoaparcamientosUnamasporfraccion").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("aparcamientoOtrosusosMinimoaparcamientosUnamasporfraccion").setEditable(true);
		metaData.getColumn("aparcamientoOtrosusosMinimoaparcamientosUnamasporfraccion").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("aparcamientoOtrosusosMinimoaparcamientosUnaporfraccion", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("aparcamientoOtrosusosMinimoaparcamientosUnaporfraccion", this.getMessage("forms.accesibilidadpublicos.columns.aparcamientoOtrosusosMinimoaparcamientosUnaporfraccion.header", locale)));
		metaData.getColumn("aparcamientoOtrosusosMinimoaparcamientosUnaporfraccion").setTooltip(this.getMessage("forms.accesibilidadpublicos.columns.aparcamientoOtrosusosMinimoaparcamientosUnaporfraccion.description", locale));
		metaData.getColumn("aparcamientoOtrosusosMinimoaparcamientosUnaporfraccion").setGroupable(false);
		metaData.getColumn("aparcamientoOtrosusosMinimoaparcamientosUnaporfraccion").setSortable(true);
		metaData.getColumn("aparcamientoOtrosusosMinimoaparcamientosUnaporfraccion").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("aparcamientoOtrosusosMinimoaparcamientosUnaporfraccion").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] unaPorFraccionStore = new String[][]{
				{ String.valueOf(Keys.ACCESIBILIDAD_APARCAMIENTO_UNA_POR_FRACCION_SI), this.getMessage("forms.accesibilidadpublicos.columns.aparcamientoOtrosusosMinimoaparcamientosUnaporfraccion." + Keys.ACCESIBILIDAD_APARCAMIENTO_UNA_POR_FRACCION_SI, locale)},
				{ String.valueOf(Keys.ACCESIBILIDAD_APARCAMIENTO_UNA_POR_FRACCION_NO), this.getMessage("forms.accesibilidadpublicos.columns.aparcamientoOtrosusosMinimoaparcamientosUnaporfraccion." + Keys.ACCESIBILIDAD_APARCAMIENTO_UNA_POR_FRACCION_NO, locale)},
		};

		metaData.getColumn("aparcamientoOtrosusosMinimoaparcamientosUnaporfraccion").setSofaStoreValues(unaPorFraccionStore);

		metaData.getColumn("aparcamientoOtrosusosMinimoaparcamientosUnaporfraccion").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("aparcamientoOtrosusosMinimoaparcamientosUnaporfraccion").setEditable(true);
		metaData.getColumn("aparcamientoOtrosusosMinimoaparcamientosUnaporfraccion").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("aparcamientoResidencialpublicoPoralojamiento", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("aparcamientoResidencialpublicoPoralojamiento", this.getMessage("forms.accesibilidadpublicos.columns.aparcamientoResidencialpublicoPoralojamiento.header", locale)));
		metaData.getColumn("aparcamientoResidencialpublicoPoralojamiento").setTooltip(this.getMessage("forms.accesibilidadpublicos.columns.aparcamientoResidencialpublicoPoralojamiento.description", locale));
		metaData.getColumn("aparcamientoResidencialpublicoPoralojamiento").setGroupable(false);
		metaData.getColumn("aparcamientoResidencialpublicoPoralojamiento").setSortable(true);
		metaData.getColumn("aparcamientoResidencialpublicoPoralojamiento").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("aparcamientoResidencialpublicoPoralojamiento").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] aparcamientoResidencialpublicoPoralojamientoStore = new String[][]{
				{ String.valueOf(Keys.ACCESIBILIDAD_APARCAMIENTO_RESIDENCIAL_PUBLICO_POR_ALOJAMIENTO_SI), this.getMessage("forms.accesibilidadpublicos.columns.aparcamientoResidencialpublicoPoralojamiento." + Keys.ACCESIBILIDAD_APARCAMIENTO_RESIDENCIAL_PUBLICO_POR_ALOJAMIENTO_SI, locale)},
				{ String.valueOf(Keys.ACCESIBILIDAD_APARCAMIENTO_RESIDENCIAL_PUBLICO_POR_ALOJAMIENTO_NO), this.getMessage("forms.accesibilidadpublicos.columns.aparcamientoResidencialpublicoPoralojamiento." + Keys.ACCESIBILIDAD_APARCAMIENTO_RESIDENCIAL_PUBLICO_POR_ALOJAMIENTO_NO, locale)},
		};

		metaData.getColumn("aparcamientoResidencialpublicoPoralojamiento").setSofaStoreValues(aparcamientoResidencialpublicoPoralojamientoStore);

		metaData.getColumn("aparcamientoResidencialpublicoPoralojamiento").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("aparcamientoResidencialpublicoPoralojamiento").setEditable(true);
		metaData.getColumn("aparcamientoResidencialpublicoPoralojamiento").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("aparcamientoSillaruedas", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("aparcamientoSillaruedas", this.getMessage("forms.accesibilidadpublicos.columns.aparcamientoSillaruedas.header", locale)));
		metaData.getColumn("aparcamientoSillaruedas").setGroupable(false);
		metaData.getColumn("aparcamientoSillaruedas").setSortable(true);
		metaData.getColumn("aparcamientoSillaruedas").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("aparcamientoSillaruedas").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] aparcamientoSillaruedasStore = new String[][]{
				{ String.valueOf(Keys.ACCESIBILIDAD_APARCAMIENTO_SILLA_RUEDAS_SI), this.getMessage("forms.accesibilidadpublicos.columns.aparcamientoSillaruedas." + Keys.ACCESIBILIDAD_APARCAMIENTO_SILLA_RUEDAS_SI, locale)},
				{ String.valueOf(Keys.ACCESIBILIDAD_APARCAMIENTO_SILLA_RUEDAS_NO), this.getMessage("forms.accesibilidadpublicos.columns.aparcamientoSillaruedas." + Keys.ACCESIBILIDAD_APARCAMIENTO_SILLA_RUEDAS_NO, locale)},
		};

		metaData.getColumn("aparcamientoSillaruedas").setSofaStoreValues(aparcamientoSillaruedasStore);

		metaData.getColumn("aparcamientoSillaruedas").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("aparcamientoSillaruedas").setEditable(true);
		metaData.getColumn("aparcamientoSillaruedas").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("entreplantasAccesible", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("entreplantasAccesible", this.getMessage("forms.accesibilidadpublicos.columns.entreplantasAccesible.header", locale)));
		metaData.getColumn("entreplantasAccesible").setGroupable(false);
		metaData.getColumn("entreplantasAccesible").setSortable(true);
		metaData.getColumn("entreplantasAccesible").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("entreplantasAccesible").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] entreplantasAccesibleStore = new String[][]{
				{ String.valueOf(Keys.ACCESIBILIDAD_ACCESIBLE_SI), this.getMessage("forms.accesibilidadpublicos.columns.entreplantasAccesible." + Keys.ACCESIBILIDAD_ACCESIBLE_SI, locale)},
				{ String.valueOf(Keys.ACCESIBILIDAD_ACCESIBLE_NO), this.getMessage("forms.accesibilidadpublicos.columns.entreplantasAccesible." + Keys.ACCESIBILIDAD_ACCESIBLE_NO, locale)},
		};

		metaData.getColumn("entreplantasAccesible").setSofaStoreValues(entreplantasAccesibleStore);

		metaData.getColumn("entreplantasAccesible").setEditable(true);
		metaData.getColumn("entreplantasAccesible").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("entreplantasAccesibleAscensornoaccesible", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("entreplantasAccesibleAscensornoaccesible", this.getMessage("forms.accesibilidadpublicos.columns.entreplantasAccesibleAscensornoaccesible.header", locale)));
		metaData.getColumn("entreplantasAccesibleAscensornoaccesible").setTooltip(this.getMessage("forms.accesibilidadpublicos.columns.entreplantasAccesibleAscensornoaccesible.description", locale));
		metaData.getColumn("entreplantasAccesibleAscensornoaccesible").setGroupable(false);
		metaData.getColumn("entreplantasAccesibleAscensornoaccesible").setSortable(true);
		metaData.getColumn("entreplantasAccesibleAscensornoaccesible").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("entreplantasAccesibleAscensornoaccesible").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] entreplantasAccesibleAscensornoaccesibleStore = new String[][]{
				{ String.valueOf(Keys.ACCESIBILIDAD_ASCENSOR_NO_ACCESIBLE_SI), this.getMessage("forms.accesibilidadpublicos.columns.entreplantasAccesibleAscensornoaccesible." + Keys.ACCESIBILIDAD_ASCENSOR_NO_ACCESIBLE_SI, locale)},
				{ String.valueOf(Keys.ACCESIBILIDAD_ASCENSOR_NO_ACCESIBLE_NO), this.getMessage("forms.accesibilidadpublicos.columns.entreplantasAccesibleAscensornoaccesible." + Keys.ACCESIBILIDAD_ASCENSOR_NO_ACCESIBLE_NO, locale)},
		};

		metaData.getColumn("entreplantasAccesibleAscensornoaccesible").setSofaStoreValues(entreplantasAccesibleAscensornoaccesibleStore);

		metaData.getColumn("entreplantasAccesibleAscensornoaccesible").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("entreplantasAccesibleAscensornoaccesible").setEditable(true);
		metaData.getColumn("entreplantasAccesibleAscensornoaccesible").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("entreplantasAccesibleAscensornoaccesibleDimensiones", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("entreplantasAccesibleAscensornoaccesibleDimensiones", this.getMessage("forms.accesibilidadpublicos.columns.entreplantasAccesibleAscensornoaccesibleDimensiones.header", locale)));
		metaData.getColumn("entreplantasAccesibleAscensornoaccesibleDimensiones").setTooltip(this.getMessage("forms.accesibilidadpublicos.columns.entreplantasAccesibleAscensornoaccesibleDimensiones.description", locale));
		metaData.getColumn("entreplantasAccesibleAscensornoaccesibleDimensiones").setGroupable(false);
		metaData.getColumn("entreplantasAccesibleAscensornoaccesibleDimensiones").setSortable(true);
		metaData.getColumn("entreplantasAccesibleAscensornoaccesibleDimensiones").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("entreplantasAccesibleAscensornoaccesibleDimensiones").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("entreplantasAccesibleAscensornoaccesibleDimensiones").setEditable(true);
		metaData.getColumn("entreplantasAccesibleAscensornoaccesibleDimensiones").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("entreplantasAccesibleAscensororampaaccesible", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("entreplantasAccesibleAscensororampaaccesible", this.getMessage("forms.accesibilidadpublicos.columns.entreplantasAccesibleAscensororampaaccesible.header", locale)));
		metaData.getColumn("entreplantasAccesibleAscensororampaaccesible").setTooltip(this.getMessage("forms.accesibilidadpublicos.columns.entreplantasAccesibleAscensororampaaccesible.description", locale));
		metaData.getColumn("entreplantasAccesibleAscensororampaaccesible").setGroupable(false);
		metaData.getColumn("entreplantasAccesibleAscensororampaaccesible").setSortable(true);
		metaData.getColumn("entreplantasAccesibleAscensororampaaccesible").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("entreplantasAccesibleAscensororampaaccesible").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] entreplantasAccesibleAscensororampaaccesibleStore = new String[][]{
				{ String.valueOf(Keys.ACCESIBILIDAD_ASCENSOR_O_RAMPA_ACCESIBLE_SI), this.getMessage("forms.accesibilidadpublicos.columns.entreplantasAccesibleAscensororampaaccesible." + Keys.ACCESIBILIDAD_ASCENSOR_O_RAMPA_ACCESIBLE_SI, locale)},
				{ String.valueOf(Keys.ACCESIBILIDAD_ASCENSOR_O_RAMPA_ACCESIBLE_NO), this.getMessage("forms.accesibilidadpublicos.columns.entreplantasAccesibleAscensororampaaccesible." + Keys.ACCESIBILIDAD_ASCENSOR_O_RAMPA_ACCESIBLE_NO, locale)},
		};

		metaData.getColumn("entreplantasAccesibleAscensororampaaccesible").setSofaStoreValues(entreplantasAccesibleAscensororampaaccesibleStore);

		metaData.getColumn("entreplantasAccesibleAscensororampaaccesible").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("entreplantasAccesibleAscensororampaaccesible").setEditable(true);
		metaData.getColumn("entreplantasAccesibleAscensororampaaccesible").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("entreplantasAccesibleRampaascensornoaccesible", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("entreplantasAccesibleRampaascensornoaccesible", this.getMessage("forms.accesibilidadpublicos.columns.entreplantasAccesibleRampaascensornoaccesible.header", locale)));
		metaData.getColumn("entreplantasAccesibleRampaascensornoaccesible").setTooltip(this.getMessage("forms.accesibilidadpublicos.columns.entreplantasAccesibleRampaascensornoaccesible.description", locale));
		metaData.getColumn("entreplantasAccesibleRampaascensornoaccesible").setGroupable(false);
		metaData.getColumn("entreplantasAccesibleRampaascensornoaccesible").setSortable(true);
		metaData.getColumn("entreplantasAccesibleRampaascensornoaccesible").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("entreplantasAccesibleRampaascensornoaccesible").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] entreplantasAccesibleRampaascensornoaccesibleStore = new String[][]{
				{ String.valueOf(Keys.ACCESIBILIDAD_ASCENSOR_O_RAMPA_NO_ACCESIBLE_SI), this.getMessage("forms.accesibilidadpublicos.columns.entreplantasAccesibleRampaascensornoaccesible." + Keys.ACCESIBILIDAD_ASCENSOR_O_RAMPA_NO_ACCESIBLE_SI, locale)},
				{ String.valueOf(Keys.ACCESIBILIDAD_ASCENSOR_O_RAMPA_NO_ACCESIBLE_NO), this.getMessage("forms.accesibilidadpublicos.columns.entreplantasAccesibleRampaascensornoaccesible." + Keys.ACCESIBILIDAD_ASCENSOR_O_RAMPA_NO_ACCESIBLE_NO, locale)},
		};

		metaData.getColumn("entreplantasAccesibleRampaascensornoaccesible").setSofaStoreValues(entreplantasAccesibleRampaascensornoaccesibleStore);

		metaData.getColumn("entreplantasAccesibleRampaascensornoaccesible").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("entreplantasAccesibleRampaascensornoaccesible").setEditable(true);
		metaData.getColumn("entreplantasAccesibleRampaascensornoaccesible").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("entreplantasElementosaccesibles", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("entreplantasElementosaccesibles", this.getMessage("forms.accesibilidadpublicos.columns.entreplantasElementosaccesibles.header", locale)));
		metaData.getColumn("entreplantasElementosaccesibles").setTooltip(this.getMessage("forms.accesibilidadpublicos.columns.entreplantasElementosaccesibles.description", locale));
		metaData.getColumn("entreplantasElementosaccesibles").setGroupable(false);
		metaData.getColumn("entreplantasElementosaccesibles").setSortable(true);
		metaData.getColumn("entreplantasElementosaccesibles").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("entreplantasElementosaccesibles").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] entreplantasElementosaccesiblesStore = new String[][]{
				{ String.valueOf(Keys.ACCESIBILIDAD_ELEMENTOS_ACCESIBLES_SI), this.getMessage("forms.accesibilidadpublicos.columns.entreplantasElementosaccesibles." + Keys.ACCESIBILIDAD_ELEMENTOS_ACCESIBLES_SI, locale)},
				{ String.valueOf(Keys.ACCESIBILIDAD_ELEMENTOS_ACCESIBLES_NO), this.getMessage("forms.accesibilidadpublicos.columns.entreplantasElementosaccesibles." + Keys.ACCESIBILIDAD_ELEMENTOS_ACCESIBLES_NO, locale)},
		};

		metaData.getColumn("entreplantasElementosaccesibles").setSofaStoreValues(entreplantasElementosaccesiblesStore);

		metaData.getColumn("entreplantasElementosaccesibles").setEditable(true);
		metaData.getColumn("entreplantasElementosaccesibles").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("entreplantasElementosaccesiblesAscensornoaccesible", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("entreplantasElementosaccesiblesAscensornoaccesible", this.getMessage("forms.accesibilidadpublicos.columns.entreplantasElementosaccesiblesAscensornoaccesible.header", locale)));
		metaData.getColumn("entreplantasElementosaccesiblesAscensornoaccesible").setTooltip(this.getMessage("forms.accesibilidadpublicos.columns.entreplantasElementosaccesiblesAscensornoaccesible.description", locale));
		metaData.getColumn("entreplantasElementosaccesiblesAscensornoaccesible").setGroupable(false);
		metaData.getColumn("entreplantasElementosaccesiblesAscensornoaccesible").setSortable(true);
		metaData.getColumn("entreplantasElementosaccesiblesAscensornoaccesible").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("entreplantasElementosaccesiblesAscensornoaccesible").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] entreplantasElementosaccesiblesAscensornoaccesibleStore = new String[][]{
				{ String.valueOf(Keys.ACCESIBILIDAD_ELEMENTOS_ACCESIBLES_ASCENSOR_NO_ACCESIBLE_SI), this.getMessage("forms.accesibilidadpublicos.columns.entreplantasElementosaccesiblesAscensornoaccesible." + Keys.ACCESIBILIDAD_ELEMENTOS_ACCESIBLES_ASCENSOR_NO_ACCESIBLE_SI, locale)},
				{ String.valueOf(Keys.ACCESIBILIDAD_ELEMENTOS_ACCESIBLES_ASCENSOR_NO_ACCESIBLE_NO), this.getMessage("forms.accesibilidadpublicos.columns.entreplantasElementosaccesiblesAscensornoaccesible." + Keys.ACCESIBILIDAD_ELEMENTOS_ACCESIBLES_ASCENSOR_NO_ACCESIBLE_NO, locale)},
		};

		metaData.getColumn("entreplantasElementosaccesiblesAscensornoaccesible").setSofaStoreValues(entreplantasElementosaccesiblesAscensornoaccesibleStore);

		metaData.getColumn("entreplantasElementosaccesiblesAscensornoaccesible").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("entreplantasElementosaccesiblesAscensornoaccesible").setEditable(true);
		metaData.getColumn("entreplantasElementosaccesiblesAscensornoaccesible").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("entreplantasElementosaccesiblesAscensornoaccesibleDimensione", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("entreplantasElementosaccesiblesAscensornoaccesibleDimensione", this.getMessage("forms.accesibilidadpublicos.columns.entreplantasElementosaccesiblesAscensornoaccesibleDimensione.header", locale)));
		metaData.getColumn("entreplantasElementosaccesiblesAscensornoaccesibleDimensione").setTooltip(this.getMessage("forms.accesibilidadpublicos.columns.entreplantasElementosaccesiblesAscensornoaccesibleDimensione.description", locale));
		metaData.getColumn("entreplantasElementosaccesiblesAscensornoaccesibleDimensione").setGroupable(false);
		metaData.getColumn("entreplantasElementosaccesiblesAscensornoaccesibleDimensione").setSortable(true);
		metaData.getColumn("entreplantasElementosaccesiblesAscensornoaccesibleDimensione").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("entreplantasElementosaccesiblesAscensornoaccesibleDimensione").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("entreplantasElementosaccesiblesAscensornoaccesibleDimensione").setEditable(true);
		metaData.getColumn("entreplantasElementosaccesiblesAscensornoaccesibleDimensione").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("entreplantasElementosaccesiblesAscensororampaaccesible", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("entreplantasElementosaccesiblesAscensororampaaccesible", this.getMessage("forms.accesibilidadpublicos.columns.entreplantasElementosaccesiblesAscensororampaaccesible.header", locale)));
		metaData.getColumn("entreplantasElementosaccesiblesAscensororampaaccesible").setTooltip(this.getMessage("forms.accesibilidadpublicos.columns.entreplantasElementosaccesiblesAscensororampaaccesible.description", locale));
		metaData.getColumn("entreplantasElementosaccesiblesAscensororampaaccesible").setGroupable(false);
		metaData.getColumn("entreplantasElementosaccesiblesAscensororampaaccesible").setSortable(true);
		metaData.getColumn("entreplantasElementosaccesiblesAscensororampaaccesible").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("entreplantasElementosaccesiblesAscensororampaaccesible").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] entreplantasElementosaccesiblesAscensororampaaccesibleStore = new String[][]{
				{ String.valueOf(Keys.ACCESIBILIDAD_ELEMENTOS_ACCESIBLES_ASCENSOR_O_RAMPA_ACCESIBLE_SI), this.getMessage("forms.accesibilidadpublicos.columns.entreplantasElementosaccesiblesAscensororampaaccesible." + Keys.ACCESIBILIDAD_ELEMENTOS_ACCESIBLES_ASCENSOR_O_RAMPA_ACCESIBLE_SI, locale)},
				{ String.valueOf(Keys.ACCESIBILIDAD_ELEMENTOS_ACCESIBLES_ASCENSOR_O_RAMPA_ACCESIBLE_NO), this.getMessage("forms.accesibilidadpublicos.columns.entreplantasElementosaccesiblesAscensororampaaccesible." + Keys.ACCESIBILIDAD_ELEMENTOS_ACCESIBLES_ASCENSOR_O_RAMPA_ACCESIBLE_NO, locale)},
		};

		metaData.getColumn("entreplantasElementosaccesiblesAscensororampaaccesible").setSofaStoreValues(entreplantasElementosaccesiblesAscensororampaaccesibleStore);

		metaData.getColumn("entreplantasElementosaccesiblesAscensororampaaccesible").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("entreplantasElementosaccesiblesAscensororampaaccesible").setEditable(true);
		metaData.getColumn("entreplantasElementosaccesiblesAscensororampaaccesible").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("entreplantasElementosaccesiblesRampaascensornoaccesible", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("entreplantasElementosaccesiblesRampaascensornoaccesible", this.getMessage("forms.accesibilidadpublicos.columns.entreplantasElementosaccesiblesRampaascensornoaccesible.header", locale)));
		metaData.getColumn("entreplantasElementosaccesiblesRampaascensornoaccesible").setTooltip(this.getMessage("forms.accesibilidadpublicos.columns.entreplantasElementosaccesiblesRampaascensornoaccesible.description", locale));
		metaData.getColumn("entreplantasElementosaccesiblesRampaascensornoaccesible").setGroupable(false);
		metaData.getColumn("entreplantasElementosaccesiblesRampaascensornoaccesible").setSortable(true);
		metaData.getColumn("entreplantasElementosaccesiblesRampaascensornoaccesible").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("entreplantasElementosaccesiblesRampaascensornoaccesible").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] entreplantasElementosaccesiblesRampaascensornoaccesibleStore = new String[][]{
				{ String.valueOf(Keys.ACCESIBILIDAD_ELEMENTOS_ACCESIBLES_ASCENSOR_O_RAMPA_NO_ACCESIBLE_SI), this.getMessage("forms.accesibilidadpublicos.columns.entreplantasElementosaccesiblesRampaascensornoaccesible." + Keys.ACCESIBILIDAD_ELEMENTOS_ACCESIBLES_ASCENSOR_O_RAMPA_NO_ACCESIBLE_SI, locale)},
				{ String.valueOf(Keys.ACCESIBILIDAD_ELEMENTOS_ACCESIBLES_ASCENSOR_O_RAMPA_NO_ACCESIBLE_NO), this.getMessage("forms.accesibilidadpublicos.columns.entreplantasElementosaccesiblesRampaascensornoaccesible." + Keys.ACCESIBILIDAD_ELEMENTOS_ACCESIBLES_ASCENSOR_O_RAMPA_NO_ACCESIBLE_NO, locale)},
		};

		metaData.getColumn("entreplantasElementosaccesiblesRampaascensornoaccesible").setSofaStoreValues(entreplantasElementosaccesiblesRampaascensornoaccesibleStore);

		metaData.getColumn("entreplantasElementosaccesiblesRampaascensornoaccesible").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("entreplantasElementosaccesiblesRampaascensornoaccesible").setEditable(true);
		metaData.getColumn("entreplantasElementosaccesiblesRampaascensornoaccesible").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("entreplantasNoaccesible", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("entreplantasNoaccesible", this.getMessage("forms.accesibilidadpublicos.columns.entreplantasNoaccesible.header", locale)));
		metaData.getColumn("entreplantasNoaccesible").setGroupable(false);
		metaData.getColumn("entreplantasNoaccesible").setSortable(true);
		metaData.getColumn("entreplantasNoaccesible").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("entreplantasNoaccesible").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] entreplantasNoaccesibleStore = new String[][]{
				{ String.valueOf(Keys.ACCESIBILIDAD_NO_ACCESIBLE_SI), this.getMessage("forms.accesibilidadpublicos.columns.entreplantasNoaccesible." + Keys.ACCESIBILIDAD_NO_ACCESIBLE_SI, locale)},
				{ String.valueOf(Keys.ACCESIBILIDAD_NO_ACCESIBLE_NO), this.getMessage("forms.accesibilidadpublicos.columns.entreplantasNoaccesible." + Keys.ACCESIBILIDAD_NO_ACCESIBLE_NO, locale)},
		};

		metaData.getColumn("entreplantasNoaccesible").setSofaStoreValues(entreplantasNoaccesibleStore);

		metaData.getColumn("entreplantasNoaccesible").setEditable(true);
		metaData.getColumn("entreplantasNoaccesible").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("entreplantasNoaccesibleAscensornoaccesible", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("entreplantasNoaccesibleAscensornoaccesible", this.getMessage("forms.accesibilidadpublicos.columns.entreplantasNoaccesibleAscensornoaccesible.header", locale)));
		metaData.getColumn("entreplantasNoaccesibleAscensornoaccesible").setTooltip(this.getMessage("forms.accesibilidadpublicos.columns.entreplantasNoaccesibleAscensornoaccesible.description", locale));
		metaData.getColumn("entreplantasNoaccesibleAscensornoaccesible").setGroupable(false);
		metaData.getColumn("entreplantasNoaccesibleAscensornoaccesible").setSortable(true);
		metaData.getColumn("entreplantasNoaccesibleAscensornoaccesible").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("entreplantasNoaccesibleAscensornoaccesible").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] entreplantasNoaccesibleAscensornoaccesibleStore = new String[][]{
				{ String.valueOf(Keys.ACCESIBILIDAD_NO_ACCESIBLE_ASCENSOR_NO_ACCESIBLE_SI), this.getMessage("forms.accesibilidadpublicos.columns.entreplantasNoaccesibleAscensornoaccesible." + Keys.ACCESIBILIDAD_NO_ACCESIBLE_ASCENSOR_NO_ACCESIBLE_SI, locale)},
				{ String.valueOf(Keys.ACCESIBILIDAD_NO_ACCESIBLE_ASCENSOR_NO_ACCESIBLE_NO), this.getMessage("forms.accesibilidadpublicos.columns.entreplantasNoaccesibleAscensornoaccesible." + Keys.ACCESIBILIDAD_NO_ACCESIBLE_ASCENSOR_NO_ACCESIBLE_NO, locale)},
		};

		metaData.getColumn("entreplantasNoaccesibleAscensornoaccesible").setSofaStoreValues(entreplantasNoaccesibleAscensornoaccesibleStore);

		metaData.getColumn("entreplantasNoaccesibleAscensornoaccesible").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("entreplantasNoaccesibleAscensornoaccesible").setEditable(true);
		metaData.getColumn("entreplantasNoaccesibleAscensornoaccesible").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("entreplantasNoaccesibleAscensornoaccesibleDimensiones", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("entreplantasNoaccesibleAscensornoaccesibleDimensiones", this.getMessage("forms.accesibilidadpublicos.columns.entreplantasNoaccesibleAscensornoaccesibleDimensiones.header", locale)));
		metaData.getColumn("entreplantasNoaccesibleAscensornoaccesibleDimensiones").setTooltip(this.getMessage("forms.accesibilidadpublicos.columns.entreplantasNoaccesibleAscensornoaccesibleDimensiones.description", locale));
		metaData.getColumn("entreplantasNoaccesibleAscensornoaccesibleDimensiones").setGroupable(false);
		metaData.getColumn("entreplantasNoaccesibleAscensornoaccesibleDimensiones").setSortable(true);
		metaData.getColumn("entreplantasNoaccesibleAscensornoaccesibleDimensiones").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("entreplantasNoaccesibleAscensornoaccesibleDimensiones").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("entreplantasNoaccesibleAscensornoaccesibleDimensiones").setEditable(true);
		metaData.getColumn("entreplantasNoaccesibleAscensornoaccesibleDimensiones").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("entreplantasNoaccesibleAscensororampaaccesible", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("entreplantasNoaccesibleAscensororampaaccesible", this.getMessage("forms.accesibilidadpublicos.columns.entreplantasNoaccesibleAscensororampaaccesible.header", locale)));
		metaData.getColumn("entreplantasNoaccesibleAscensororampaaccesible").setTooltip(this.getMessage("forms.accesibilidadpublicos.columns.entreplantasNoaccesibleAscensororampaaccesible.description", locale));
		metaData.getColumn("entreplantasNoaccesibleAscensororampaaccesible").setGroupable(false);
		metaData.getColumn("entreplantasNoaccesibleAscensororampaaccesible").setSortable(true);
		metaData.getColumn("entreplantasNoaccesibleAscensororampaaccesible").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("entreplantasNoaccesibleAscensororampaaccesible").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] entreplantasNoaccesibleAscensororampaaccesibleStore = new String[][]{
				{ String.valueOf(Keys.ACCESIBILIDAD_NO_ACCESIBLE_ASCENSOR_0_RAMPA_ACCESIBLE_SI), this.getMessage("forms.accesibilidadpublicos.columns.entreplantasNoaccesibleAscensororampaaccesible." + Keys.ACCESIBILIDAD_NO_ACCESIBLE_ASCENSOR_0_RAMPA_ACCESIBLE_SI, locale)},
				{ String.valueOf(Keys.ACCESIBILIDAD_NO_ACCESIBLE_ASCENSOR_O_RAMPA_ACCESIBLE_NO), this.getMessage("forms.accesibilidadpublicos.columns.entreplantasNoaccesibleAscensororampaaccesible." + Keys.ACCESIBILIDAD_NO_ACCESIBLE_ASCENSOR_O_RAMPA_ACCESIBLE_NO, locale)},
		};

		metaData.getColumn("entreplantasNoaccesibleAscensororampaaccesible").setSofaStoreValues(entreplantasNoaccesibleAscensororampaaccesibleStore);

		metaData.getColumn("entreplantasNoaccesibleAscensororampaaccesible").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("entreplantasNoaccesibleAscensororampaaccesible").setEditable(true);
		metaData.getColumn("entreplantasNoaccesibleAscensororampaaccesible").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("entreplantasNoaccesibleRampaascensornoaccesible", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("entreplantasNoaccesibleRampaascensornoaccesible", this.getMessage("forms.accesibilidadpublicos.columns.entreplantasNoaccesibleRampaascensornoaccesible.header", locale)));
		metaData.getColumn("entreplantasNoaccesibleRampaascensornoaccesible").setTooltip(this.getMessage("forms.accesibilidadpublicos.columns.entreplantasNoaccesibleRampaascensornoaccesible.description", locale));
		metaData.getColumn("entreplantasNoaccesibleRampaascensornoaccesible").setGroupable(false);
		metaData.getColumn("entreplantasNoaccesibleRampaascensornoaccesible").setSortable(true);
		metaData.getColumn("entreplantasNoaccesibleRampaascensornoaccesible").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("entreplantasNoaccesibleRampaascensornoaccesible").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] entreplantasNoaccesibleRampaascensornoaccesibleStore = new String[][]{
				{ String.valueOf(Keys.ACCESIBILIDAD_NO_ACCESIBLE_ASCENSOR_0_RAMPA_NO_ACCESIBLE_SI), this.getMessage("forms.accesibilidadpublicos.columns.entreplantasNoaccesibleRampaascensornoaccesible." + Keys.ACCESIBILIDAD_NO_ACCESIBLE_ASCENSOR_0_RAMPA_NO_ACCESIBLE_SI, locale)},
				{ String.valueOf(Keys.ACCESIBILIDAD_NO_ACCESIBLE_ASCENSOR_O_RAMPA_NO_ACCESIBLE_NO), this.getMessage("forms.accesibilidadpublicos.columns.entreplantasNoaccesibleRampaascensornoaccesible." + Keys.ACCESIBILIDAD_NO_ACCESIBLE_ASCENSOR_O_RAMPA_NO_ACCESIBLE_NO, locale)},
		};

		metaData.getColumn("entreplantasNoaccesibleRampaascensornoaccesible").setSofaStoreValues(entreplantasNoaccesibleRampaascensornoaccesibleStore);

		metaData.getColumn("entreplantasNoaccesibleRampaascensornoaccesible").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("entreplantasNoaccesibleRampaascensornoaccesible").setEditable(true);
		metaData.getColumn("entreplantasNoaccesibleRampaascensornoaccesible").setHidden(true);

		//Creamos el registro para el record
		//metaData.addRecordField(new GridRecordFieldMetaData("entreplantasObservaciones", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		/*
		 * metaData.addColumn( new GridColumnMetaData(
		 * "entreplantasObservaciones", this.getMessage(
		 * "forms.accesibilidadpublicos.columns.entreplantasObservaciones.header"
		 * , locale) ) );
		 * metaData.getColumn("entreplantasObservaciones").setGroupable( false
		 * ); metaData.getColumn("entreplantasObservaciones").setSortable( true
		 * ); metaData.getColumn("entreplantasObservaciones").setSofaFilter(
		 * GridColumnFilter.TYPE_STRING );
		 * 
		 * metaData.getColumn("entreplantasObservaciones").setSofaRenderer(
		 * GridColumnMetaData.RENDERER_LARGETEXT );
		 * 
		 * metaData.getColumn("entreplantasObservaciones").setEditable( true );
		 */

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("entreplantasZonasusopublico", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("entreplantasZonasusopublico", this.getMessage("forms.accesibilidadpublicos.columns.entreplantasZonasusopublico.header", locale)));
		metaData.getColumn("entreplantasZonasusopublico").setGroupable(false);
		metaData.getColumn("entreplantasZonasusopublico").setSortable(true);
		metaData.getColumn("entreplantasZonasusopublico").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("entreplantasZonasusopublico").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] entreplantasZonasusopublicoStore = new String[][]{
				{ String.valueOf(Keys.ACCESIBILIDAD_ZONAS_USO_PUBLICO_SI), this.getMessage("forms.accesibilidadpublicos.columns.entreplantasZonasusopublico." + Keys.ACCESIBILIDAD_ZONAS_USO_PUBLICO_SI, locale)},
				{ String.valueOf(Keys.ACCESIBILIDAD_ZONAS_USO_PUBLICO_NO), this.getMessage("forms.accesibilidadpublicos.columns.entreplantasZonasusopublico." + Keys.ACCESIBILIDAD_ZONAS_USO_PUBLICO_NO, locale)},
		};

		metaData.getColumn("entreplantasZonasusopublico").setSofaStoreValues(entreplantasZonasusopublicoStore);

		metaData.getColumn("entreplantasZonasusopublico").setEditable(true);
		metaData.getColumn("entreplantasZonasusopublico").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("entreplantasZonasusopublicoAscensornoaccesible", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("entreplantasZonasusopublicoAscensornoaccesible", this.getMessage("forms.accesibilidadpublicos.columns.entreplantasZonasusopublicoAscensornoaccesible.header", locale)));
		metaData.getColumn("entreplantasZonasusopublicoAscensornoaccesible").setTooltip(this.getMessage("forms.accesibilidadpublicos.columns.entreplantasZonasusopublicoAscensornoaccesible.description", locale));
		metaData.getColumn("entreplantasZonasusopublicoAscensornoaccesible").setGroupable(false);
		metaData.getColumn("entreplantasZonasusopublicoAscensornoaccesible").setSortable(true);
		metaData.getColumn("entreplantasZonasusopublicoAscensornoaccesible").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("entreplantasZonasusopublicoAscensornoaccesible").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] entreplantasZonasusopublicoAscensornoaccesibleStore = new String[][]{
				{ String.valueOf(Keys.ACCESIBILIDAD_ZONA_USO_PUBLICO_ASCENSOR_NO_ACCESIBLE_SI), this.getMessage("forms.accesibilidadpublicos.columns.entreplantasZonasusopublicoAscensornoaccesible." + Keys.ACCESIBILIDAD_ZONA_USO_PUBLICO_ASCENSOR_NO_ACCESIBLE_SI, locale)},
				{ String.valueOf(Keys.ACCESIBILIDAD_ZONA_USO_PUBLICO_ASCENSOR_NO_ACCESIBLE_NO), this.getMessage("forms.accesibilidadpublicos.columns.entreplantasZonasusopublicoAscensornoaccesible." + Keys.ACCESIBILIDAD_ZONA_USO_PUBLICO_ASCENSOR_NO_ACCESIBLE_NO, locale)},
		};

		metaData.getColumn("entreplantasZonasusopublicoAscensornoaccesible").setSofaStoreValues(entreplantasZonasusopublicoAscensornoaccesibleStore);

		metaData.getColumn("entreplantasZonasusopublicoAscensornoaccesible").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("entreplantasZonasusopublicoAscensornoaccesible").setEditable(true);
		metaData.getColumn("entreplantasZonasusopublicoAscensornoaccesible").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("entreplantasZonasusopublicoAscensornoaccesibleDimensiones", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("entreplantasZonasusopublicoAscensornoaccesibleDimensiones", this.getMessage("forms.accesibilidadpublicos.columns.entreplantasZonasusopublicoAscensornoaccesibleDimensiones.header", locale)));
		metaData.getColumn("entreplantasZonasusopublicoAscensornoaccesibleDimensiones").setTooltip(this.getMessage("forms.accesibilidadpublicos.columns.entreplantasZonasusopublicoAscensornoaccesibleDimensiones.description", locale));
		metaData.getColumn("entreplantasZonasusopublicoAscensornoaccesibleDimensiones").setGroupable(false);
		metaData.getColumn("entreplantasZonasusopublicoAscensornoaccesibleDimensiones").setSortable(true);
		metaData.getColumn("entreplantasZonasusopublicoAscensornoaccesibleDimensiones").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("entreplantasZonasusopublicoAscensornoaccesibleDimensiones").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("entreplantasZonasusopublicoAscensornoaccesibleDimensiones").setEditable(true);
		metaData.getColumn("entreplantasZonasusopublicoAscensornoaccesibleDimensiones").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("entreplantasZonasusopublicoAscensororampaaccesible", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("entreplantasZonasusopublicoAscensororampaaccesible", this.getMessage("forms.accesibilidadpublicos.columns.entreplantasZonasusopublicoAscensororampaaccesible.header", locale)));
		metaData.getColumn("entreplantasZonasusopublicoAscensororampaaccesible").setTooltip(this.getMessage("forms.accesibilidadpublicos.columns.entreplantasZonasusopublicoAscensororampaaccesible.description", locale));
		metaData.getColumn("entreplantasZonasusopublicoAscensororampaaccesible").setGroupable(false);
		metaData.getColumn("entreplantasZonasusopublicoAscensororampaaccesible").setSortable(true);
		metaData.getColumn("entreplantasZonasusopublicoAscensororampaaccesible").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("entreplantasZonasusopublicoAscensororampaaccesible").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] entreplantasZonasusopublicoAscensororampaaccesibleStore = new String[][]{
				{ String.valueOf(Keys.ACCESIBILIDAD_ZONA_USO_PUBLICO_ASCENSOR_O_RAMPA_ACCESIBLE_SI), this.getMessage("forms.accesibilidadpublicos.columns.entreplantasZonasusopublicoAscensororampaaccesible." + Keys.ACCESIBILIDAD_ZONA_USO_PUBLICO_ASCENSOR_O_RAMPA_ACCESIBLE_SI, locale)},
				{ String.valueOf(Keys.ACCESIBILIDAD_ZONA_USO_PUBLICO_ASCENSOR_O_RAMPA_ACCESIBLE_NO), this.getMessage("forms.accesibilidadpublicos.columns.entreplantasZonasusopublicoAscensororampaaccesible." + Keys.ACCESIBILIDAD_ZONA_USO_PUBLICO_ASCENSOR_O_RAMPA_ACCESIBLE_NO, locale)},
		};

		metaData.getColumn("entreplantasZonasusopublicoAscensororampaaccesible").setSofaStoreValues(entreplantasZonasusopublicoAscensororampaaccesibleStore);

		metaData.getColumn("entreplantasZonasusopublicoAscensororampaaccesible").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("entreplantasZonasusopublicoAscensororampaaccesible").setEditable(true);
		metaData.getColumn("entreplantasZonasusopublicoAscensororampaaccesible").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("entreplantasZonasusopublicoRampaascensornoaccesible", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("entreplantasZonasusopublicoRampaascensornoaccesible", this.getMessage("forms.accesibilidadpublicos.columns.entreplantasZonasusopublicoRampaascensornoaccesible.header", locale)));
		metaData.getColumn("entreplantasZonasusopublicoRampaascensornoaccesible").setTooltip(this.getMessage("forms.accesibilidadpublicos.columns.entreplantasZonasusopublicoRampaascensornoaccesible.description", locale));
		metaData.getColumn("entreplantasZonasusopublicoRampaascensornoaccesible").setGroupable(false);
		metaData.getColumn("entreplantasZonasusopublicoRampaascensornoaccesible").setSortable(true);
		metaData.getColumn("entreplantasZonasusopublicoRampaascensornoaccesible").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("entreplantasZonasusopublicoRampaascensornoaccesible").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] entreplantasZonasusopublicoRampaascensornoaccesibleStore = new String[][]{
				{ String.valueOf(Keys.ACCESIBILIDAD_ZONA_USO_PUBLICO_ASCENSOR_O_RAMPA_NO_ACCESIBLE_SI), this.getMessage("forms.accesibilidadpublicos.columns.entreplantasZonasusopublicoRampaascensornoaccesible." + Keys.ACCESIBILIDAD_ZONA_USO_PUBLICO_ASCENSOR_O_RAMPA_NO_ACCESIBLE_SI, locale)},
				{ String.valueOf(Keys.ACCESIBILIDAD_ZONA_USO_PUBLICO_ASCENSOR_O_RAMPA_NO_ACCESIBLE_NO), this.getMessage("forms.accesibilidadpublicos.columns.entreplantasZonasusopublicoRampaascensornoaccesible." + Keys.ACCESIBILIDAD_ZONA_USO_PUBLICO_ASCENSOR_O_RAMPA_NO_ACCESIBLE_NO, locale)},
		};

		metaData.getColumn("entreplantasZonasusopublicoRampaascensornoaccesible").setSofaStoreValues(entreplantasZonasusopublicoRampaascensornoaccesibleStore);

		metaData.getColumn("entreplantasZonasusopublicoRampaascensornoaccesible").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("entreplantasZonasusopublicoRampaascensornoaccesible").setEditable(true);
		metaData.getColumn("entreplantasZonasusopublicoRampaascensornoaccesible").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("esTecnicoInspeccion", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("esTecnicoInspeccion", this.getMessage("forms.accesibilidadpublicos.columns.esTecnicoInspeccion.header", locale)));
		metaData.getColumn("esTecnicoInspeccion").setGroupable(false);
		metaData.getColumn("esTecnicoInspeccion").setSortable(true);
		metaData.getColumn("esTecnicoInspeccion").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("esTecnicoInspeccion").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] esTecnicoInspeccionStore = new String[][]{
				{ String.valueOf(Keys.ACCESIBILIDAD_TECNICO_INSPECCION_SI), this.getMessage("forms.accesibilidadpublicos.columns.esTecnicoInspeccion." + Keys.ACCESIBILIDAD_TECNICO_INSPECCION_SI, locale)},
				{ String.valueOf(Keys.ACCESIBILIDAD_TECNICO_INSPECCION_NO), this.getMessage("forms.accesibilidadpublicos.columns.esTecnicoInspeccion." + Keys.ACCESIBILIDAD_TECNICO_INSPECCION_NO, locale)},
		};

		metaData.getColumn("esTecnicoInspeccion").setSofaStoreValues(esTecnicoInspeccionStore);

		metaData.getColumn("esTecnicoInspeccion").setEditable(true);
		//metaData.getColumn("esTecnicoInspeccion").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("exteriorEdificioitinerarioaccesibleViapublica", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("exteriorEdificioitinerarioaccesibleViapublica", this.getMessage("forms.accesibilidadpublicos.columns.exteriorEdificioitinerarioaccesibleViapublica.header", locale)));
		metaData.getColumn("exteriorEdificioitinerarioaccesibleViapublica").setTooltip(this.getMessage("forms.accesibilidadpublicos.columns.exteriorEdificioitinerarioaccesibleViapublica.description", locale));
		metaData.getColumn("exteriorEdificioitinerarioaccesibleViapublica").setGroupable(false);
		metaData.getColumn("exteriorEdificioitinerarioaccesibleViapublica").setSortable(true);
		metaData.getColumn("exteriorEdificioitinerarioaccesibleViapublica").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("exteriorEdificioitinerarioaccesibleViapublica").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] exteriorEdificioitinerarioaccesibleViapublicaStore = new String[][]{
				{ String.valueOf(Keys.ACCESIBILIDAD_EDIFICIO_ITINERARIO_ACCESIBLE_VIA_PUBLICA_SI), this.getMessage("forms.accesibilidadpublicos.columns.exteriorEdificioitinerarioaccesibleViapublica." + Keys.ACCESIBILIDAD_EDIFICIO_ITINERARIO_ACCESIBLE_VIA_PUBLICA_SI, locale)},
				{ String.valueOf(Keys.ACCESIBILIDAD_EDIFICIO_ITINERARIO_ACCESIBLE_VIA_PUBLICA_NO), this.getMessage("forms.accesibilidadpublicos.columns.exteriorEdificioitinerarioaccesibleViapublica." + Keys.ACCESIBILIDAD_EDIFICIO_ITINERARIO_ACCESIBLE_VIA_PUBLICA_NO, locale)},
		};

		metaData.getColumn("exteriorEdificioitinerarioaccesibleViapublica").setSofaStoreValues(exteriorEdificioitinerarioaccesibleViapublicaStore);

		metaData.getColumn("exteriorEdificioitinerarioaccesibleViapublica").setEditable(true);
		metaData.getColumn("exteriorEdificioitinerarioaccesibleViapublica").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("exteriorEdificioitinerarioaccesibleZonascomunes", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("exteriorEdificioitinerarioaccesibleZonascomunes", this.getMessage("forms.accesibilidadpublicos.columns.exteriorEdificioitinerarioaccesibleZonascomunes.header", locale)));
		metaData.getColumn("exteriorEdificioitinerarioaccesibleZonascomunes").setTooltip(this.getMessage("forms.accesibilidadpublicos.columns.exteriorEdificioitinerarioaccesibleZonascomunes.description", locale));
		metaData.getColumn("exteriorEdificioitinerarioaccesibleZonascomunes").setGroupable(false);
		metaData.getColumn("exteriorEdificioitinerarioaccesibleZonascomunes").setSortable(true);
		metaData.getColumn("exteriorEdificioitinerarioaccesibleZonascomunes").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("exteriorEdificioitinerarioaccesibleZonascomunes").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] exteriorEdificioitinerarioaccesibleZonascomunesStore = new String[][]{
				{ String.valueOf(Keys.ACCESIBILIDAD_EDIFICIO_ITINERARIO_ACCESIBLE_ZONAS_COMUNES_SI), this.getMessage("forms.accesibilidadpublicos.columns.exteriorEdificioitinerarioaccesibleZonascomunes." + Keys.ACCESIBILIDAD_EDIFICIO_ITINERARIO_ACCESIBLE_ZONAS_COMUNES_SI, locale)},
				{ String.valueOf(Keys.ACCESIBILIDAD_EDIFICIO_ITINERARIO_ACCESIBLE_ZONAS_COMUNES_NO), this.getMessage("forms.accesibilidadpublicos.columns.exteriorEdificioitinerarioaccesibleZonascomunes." + Keys.ACCESIBILIDAD_EDIFICIO_ITINERARIO_ACCESIBLE_ZONAS_COMUNES_NO, locale)},
		};

		metaData.getColumn("exteriorEdificioitinerarioaccesibleZonascomunes").setSofaStoreValues(exteriorEdificioitinerarioaccesibleZonascomunesStore);

		metaData.getColumn("exteriorEdificioitinerarioaccesibleZonascomunes").setEditable(true);
		metaData.getColumn("exteriorEdificioitinerarioaccesibleZonascomunes").setHidden(true);

		//Creamos el registro para el record
		//metaData.addRecordField(new GridRecordFieldMetaData("exteriorObservaciones", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		/*
		 * metaData.addColumn( new GridColumnMetaData( "exteriorObservaciones",
		 * this.getMessage(
		 * "forms.accesibilidadpublicos.columns.exteriorObservaciones.header",
		 * locale) ) );
		 * metaData.getColumn("exteriorObservaciones").setGroupable( false );
		 * metaData.getColumn("exteriorObservaciones").setSortable( true );
		 * metaData.getColumn("exteriorObservaciones").setSofaFilter(
		 * GridColumnFilter.TYPE_STRING );
		 * 
		 * metaData.getColumn("exteriorObservaciones").setSofaRenderer(
		 * GridColumnMetaData.RENDERER_LARGETEXT );
		 * 
		 * metaData.getColumn("exteriorObservaciones").setEditable( true );
		 */

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("informacionsenalizacionAscensores", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("informacionsenalizacionAscensores", this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionAscensores.header", locale)));
		metaData.getColumn("informacionsenalizacionAscensores").setTooltip(this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionAscensores.description", locale));
		metaData.getColumn("informacionsenalizacionAscensores").setGroupable(false);
		metaData.getColumn("informacionsenalizacionAscensores").setSortable(true);
		metaData.getColumn("informacionsenalizacionAscensores").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("informacionsenalizacionAscensores").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] informacionsenalizacionAscensoresStore = new String[][]{
				{ String.valueOf(Keys.ACCESIBILIDAD_ASCENSORES_SI), this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionAscensores." + Keys.ACCESIBILIDAD_ASCENSORES_SI, locale)},
				{ String.valueOf(Keys.ACCESIBILIDAD_ASCENSORES_NO), this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionAscensores." + Keys.ACCESIBILIDAD_ASCENSORES_NO, locale)},
		};

		metaData.getColumn("informacionsenalizacionAscensores").setSofaStoreValues(informacionsenalizacionAscensoresStore);

		metaData.getColumn("informacionsenalizacionAscensores").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("informacionsenalizacionAscensores").setEditable(true);
		metaData.getColumn("informacionsenalizacionAscensores").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("informacionsenalizacionAscensoresBrailearabigo", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("informacionsenalizacionAscensoresBrailearabigo", this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionAscensoresBrailearabigo.header", locale)));
		metaData.getColumn("informacionsenalizacionAscensoresBrailearabigo").setTooltip(this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionAscensoresBrailearabigo.description", locale));
		metaData.getColumn("informacionsenalizacionAscensoresBrailearabigo").setGroupable(false);
		metaData.getColumn("informacionsenalizacionAscensoresBrailearabigo").setSortable(true);
		metaData.getColumn("informacionsenalizacionAscensoresBrailearabigo").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("informacionsenalizacionAscensoresBrailearabigo").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] informacionsenalizacionAscensoresBrailearabigoStore = new String[][]{
				{ String.valueOf(Keys.ACCESIBILIDAD_ASCENSORES_BRAILLE_ARABIGO_SI), this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionAscensoresBrailearabigo." + Keys.ACCESIBILIDAD_ASCENSORES_BRAILLE_ARABIGO_SI, locale)},
				{ String.valueOf(Keys.ACCESIBILIDAD_ASCENSORES_BRAILLE_ARABIGO_NO), this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionAscensoresBrailearabigo." + Keys.ACCESIBILIDAD_ASCENSORES_BRAILLE_ARABIGO_NO, locale)},
		};

		metaData.getColumn("informacionsenalizacionAscensoresBrailearabigo").setSofaStoreValues(informacionsenalizacionAscensoresBrailearabigoStore);

		metaData.getColumn("informacionsenalizacionAscensoresBrailearabigo").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("informacionsenalizacionAscensoresBrailearabigo").setEditable(true);
		metaData.getColumn("informacionsenalizacionAscensoresBrailearabigo").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("informacionsenalizacionAscensoresNumeroplanta", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("informacionsenalizacionAscensoresNumeroplanta", this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionAscensoresNumeroplanta.header", locale)));
		metaData.getColumn("informacionsenalizacionAscensoresNumeroplanta").setTooltip(this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionAscensoresNumeroplanta.description", locale));
		metaData.getColumn("informacionsenalizacionAscensoresNumeroplanta").setGroupable(false);
		metaData.getColumn("informacionsenalizacionAscensoresNumeroplanta").setSortable(true);
		metaData.getColumn("informacionsenalizacionAscensoresNumeroplanta").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("informacionsenalizacionAscensoresNumeroplanta").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] informacionsenalizacionAscensoresNumeroplantaStore = new String[][]{
				{ String.valueOf(Keys.ACCESIBILIDAD_ASCENSORES_NUMERO_PLANTA_SI), this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionAscensoresNumeroplanta." + Keys.ACCESIBILIDAD_ASCENSORES_NUMERO_PLANTA_SI, locale)},
				{ String.valueOf(Keys.ACCESIBILIDAD_ASCENSORES_NUMERO_PLANTA_NO), this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionAscensoresNumeroplanta." + Keys.ACCESIBILIDAD_ASCENSORES_NUMERO_PLANTA_NO, locale)},
		};

		metaData.getColumn("informacionsenalizacionAscensoresNumeroplanta").setSofaStoreValues(informacionsenalizacionAscensoresNumeroplantaStore);

		metaData.getColumn("informacionsenalizacionAscensoresNumeroplanta").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("informacionsenalizacionAscensoresNumeroplanta").setEditable(true);
		metaData.getColumn("informacionsenalizacionAscensoresNumeroplanta").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("informacionsenalizacionBandasvisualestactiles", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("informacionsenalizacionBandasvisualestactiles", this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionBandasvisualestactiles.header", locale)));
		metaData.getColumn("informacionsenalizacionBandasvisualestactiles").setTooltip(this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionBandasvisualestactiles.description", locale));
		metaData.getColumn("informacionsenalizacionBandasvisualestactiles").setGroupable(false);
		metaData.getColumn("informacionsenalizacionBandasvisualestactiles").setSortable(true);
		metaData.getColumn("informacionsenalizacionBandasvisualestactiles").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("informacionsenalizacionBandasvisualestactiles").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] informacionsenalizacionBandasvisualestactilesStore = new String[][]{
				{ String.valueOf(Keys.ACCESIBILIDAD_BANDAS_VISUALES_TACTILES_SI), this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionBandasvisualestactiles." + Keys.ACCESIBILIDAD_BANDAS_VISUALES_TACTILES_SI, locale)},
				{ String.valueOf(Keys.ACCESIBILIDAD_BANDAS_VISUALES_TACTILES_NO), this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionBandasvisualestactiles." + Keys.ACCESIBILIDAD_BANDAS_VISUALES_TACTILES_NO, locale)},
		};

		metaData.getColumn("informacionsenalizacionBandasvisualestactiles").setSofaStoreValues(informacionsenalizacionBandasvisualestactilesStore);

		metaData.getColumn("informacionsenalizacionBandasvisualestactiles").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("informacionsenalizacionBandasvisualestactiles").setEditable(true);
		metaData.getColumn("informacionsenalizacionBandasvisualestactiles").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("informacionsenalizacionBandasvisualestactilesArranqueescalera", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("informacionsenalizacionBandasvisualestactilesArranqueescalera", this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionBandasvisualestactilesArranqueescalera.header", locale)));
		metaData.getColumn("informacionsenalizacionBandasvisualestactilesArranqueescalera").setTooltip(this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionBandasvisualestactilesArranqueescalera.description", locale));
		metaData.getColumn("informacionsenalizacionBandasvisualestactilesArranqueescalera").setGroupable(false);
		metaData.getColumn("informacionsenalizacionBandasvisualestactilesArranqueescalera").setSortable(true);
		metaData.getColumn("informacionsenalizacionBandasvisualestactilesArranqueescalera").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("informacionsenalizacionBandasvisualestactilesArranqueescalera").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] informacionsenalizacionBandasvisualestactilesArranqueescaleraStore = new String[][]{
				{ String.valueOf(Keys.ACCESIBILIDAD_ARRANQUE_ESCALERAS_SI), this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionBandasvisualestactilesArranqueescalera." + Keys.ACCESIBILIDAD_ARRANQUE_ESCALERAS_SI, locale)},
				{ String.valueOf(Keys.ACCESIBILIDAD_ARRANQUE_ESCALERAS_NO), this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionBandasvisualestactilesArranqueescalera." + Keys.ACCESIBILIDAD_ARRANQUE_ESCALERAS_NO, locale)},
		};

		metaData.getColumn("informacionsenalizacionBandasvisualestactilesArranqueescalera").setSofaStoreValues(informacionsenalizacionBandasvisualestactilesArranqueescaleraStore);

		metaData.getColumn("informacionsenalizacionBandasvisualestactilesArranqueescalera").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("informacionsenalizacionBandasvisualestactilesArranqueescalera").setEditable(true);
		metaData.getColumn("informacionsenalizacionBandasvisualestactilesArranqueescalera").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("informacionsenalizacionBandasvisualestactilesColorcontrastado", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("informacionsenalizacionBandasvisualestactilesColorcontrastado", this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionBandasvisualestactilesColorcontrastado.header", locale)));
		metaData.getColumn("informacionsenalizacionBandasvisualestactilesColorcontrastado").setTooltip(this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionBandasvisualestactilesColorcontrastado.description", locale));
		metaData.getColumn("informacionsenalizacionBandasvisualestactilesColorcontrastado").setGroupable(false);
		metaData.getColumn("informacionsenalizacionBandasvisualestactilesColorcontrastado").setSortable(true);
		metaData.getColumn("informacionsenalizacionBandasvisualestactilesColorcontrastado").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("informacionsenalizacionBandasvisualestactilesColorcontrastado").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] informacionsenalizacionBandasvisualestactilesColorcontrastadoStore = new String[][]{
				{ String.valueOf(Keys.ACCESIBILIDAD_COLOR_CONTRASTADO_SI), this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionBandasvisualestactilesColorcontrastado." + Keys.ACCESIBILIDAD_COLOR_CONTRASTADO_SI, locale)},
				{ String.valueOf(Keys.ACCESIBILIDAD_COLOR_CONTRASTADO_NO), this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionBandasvisualestactilesColorcontrastado." + Keys.ACCESIBILIDAD_COLOR_CONTRASTADO_NO, locale)},
		};

		metaData.getColumn("informacionsenalizacionBandasvisualestactilesColorcontrastado").setSofaStoreValues(informacionsenalizacionBandasvisualestactilesColorcontrastadoStore);

		metaData.getColumn("informacionsenalizacionBandasvisualestactilesColorcontrastado").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("informacionsenalizacionBandasvisualestactilesColorcontrastado").setEditable(true);
		metaData.getColumn("informacionsenalizacionBandasvisualestactilesColorcontrastado").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("informacionsenalizacionBandasvisualestactilesItinerarioaccesi", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("informacionsenalizacionBandasvisualestactilesItinerarioaccesi", this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionBandasvisualestactilesItinerarioaccesi.header", locale)));
		metaData.getColumn("informacionsenalizacionBandasvisualestactilesItinerarioaccesi").setTooltip(this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionBandasvisualestactilesItinerarioaccesi.description", locale));
		metaData.getColumn("informacionsenalizacionBandasvisualestactilesItinerarioaccesi").setGroupable(false);
		metaData.getColumn("informacionsenalizacionBandasvisualestactilesItinerarioaccesi").setSortable(true);
		metaData.getColumn("informacionsenalizacionBandasvisualestactilesItinerarioaccesi").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("informacionsenalizacionBandasvisualestactilesItinerarioaccesi").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] informacionsenalizacionBandasvisualestactilesItinerarioaccesiStore = new String[][]{
				{ String.valueOf(Keys.ACCESIBILIDAD_ITINERARIO_ACCESIBLE_SI), this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionBandasvisualestactilesItinerarioaccesi." + Keys.ACCESIBILIDAD_ITINERARIO_ACCESIBLE_SI, locale)},
				{ String.valueOf(Keys.ACCESIBILIDAD_ITINERARIO_ACCESIBLE_NO), this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionBandasvisualestactilesItinerarioaccesi." + Keys.ACCESIBILIDAD_ITINERARIO_ACCESIBLE_NO, locale)},
		};

		metaData.getColumn("informacionsenalizacionBandasvisualestactilesItinerarioaccesi").setSofaStoreValues(informacionsenalizacionBandasvisualestactilesItinerarioaccesiStore);

		metaData.getColumn("informacionsenalizacionBandasvisualestactilesItinerarioaccesi").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("informacionsenalizacionBandasvisualestactilesItinerarioaccesi").setEditable(true);
		metaData.getColumn("informacionsenalizacionBandasvisualestactilesItinerarioaccesi").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("informacionsenalizacionBandasvisualestactilesRelieveexterior", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("informacionsenalizacionBandasvisualestactilesRelieveexterior", this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionBandasvisualestactilesRelieveexterior.header", locale)));
		metaData.getColumn("informacionsenalizacionBandasvisualestactilesRelieveexterior").setTooltip(this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionBandasvisualestactilesRelieveexterior.description", locale));
		metaData.getColumn("informacionsenalizacionBandasvisualestactilesRelieveexterior").setGroupable(false);
		metaData.getColumn("informacionsenalizacionBandasvisualestactilesRelieveexterior").setSortable(true);
		metaData.getColumn("informacionsenalizacionBandasvisualestactilesRelieveexterior").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("informacionsenalizacionBandasvisualestactilesRelieveexterior").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] informacionsenalizacionBandasvisualestactilesRelieveexteriorStore = new String[][]{
				{ String.valueOf(Keys.ACCESIBILIDAD_RELIEVE_EXTERIOR_SI), this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionBandasvisualestactilesRelieveexterior." + Keys.ACCESIBILIDAD_RELIEVE_EXTERIOR_SI, locale)},
				{ String.valueOf(Keys.ACCESIBILIDAD_RELIEVE_EXTERIOR_NO), this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionBandasvisualestactilesRelieveexterior." + Keys.ACCESIBILIDAD_RELIEVE_EXTERIOR_NO, locale)},
		};

		metaData.getColumn("informacionsenalizacionBandasvisualestactilesRelieveexterior").setSofaStoreValues(informacionsenalizacionBandasvisualestactilesRelieveexteriorStore);

		metaData.getColumn("informacionsenalizacionBandasvisualestactilesRelieveexterior").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("informacionsenalizacionBandasvisualestactilesRelieveexterior").setEditable(true);
		metaData.getColumn("informacionsenalizacionBandasvisualestactilesRelieveexterior").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("informacionsenalizacionBandasvisualestactilesRelieveinterior", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("informacionsenalizacionBandasvisualestactilesRelieveinterior", this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionBandasvisualestactilesRelieveinterior.header", locale)));
		metaData.getColumn("informacionsenalizacionBandasvisualestactilesRelieveinterior").setTooltip(this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionBandasvisualestactilesRelieveinterior.description", locale));
		metaData.getColumn("informacionsenalizacionBandasvisualestactilesRelieveinterior").setGroupable(false);
		metaData.getColumn("informacionsenalizacionBandasvisualestactilesRelieveinterior").setSortable(true);
		metaData.getColumn("informacionsenalizacionBandasvisualestactilesRelieveinterior").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("informacionsenalizacionBandasvisualestactilesRelieveinterior").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] informacionsenalizacionBandasvisualestactilesRelieveinteriorStore = new String[][]{
				{ String.valueOf(Keys.ACCESIBILIDAD_RELIEVE_INTERIOR_SI), this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionBandasvisualestactilesRelieveinterior." + Keys.ACCESIBILIDAD_RELIEVE_INTERIOR_SI, locale)},
				{ String.valueOf(Keys.ACCESIBILIDAD_RELIEVE_INTERIOR_NO), this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionBandasvisualestactilesRelieveinterior." + Keys.ACCESIBILIDAD_RELIEVE_INTERIOR_NO, locale)},
		};

		metaData.getColumn("informacionsenalizacionBandasvisualestactilesRelieveinterior").setSofaStoreValues(informacionsenalizacionBandasvisualestactilesRelieveinteriorStore);

		metaData.getColumn("informacionsenalizacionBandasvisualestactilesRelieveinterior").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("informacionsenalizacionBandasvisualestactilesRelieveinterior").setEditable(true);
		metaData.getColumn("informacionsenalizacionBandasvisualestactilesRelieveinterior").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("informacionsenalizacionBuclemagnetico", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("informacionsenalizacionBuclemagnetico", this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionBuclemagnetico.header", locale)));
		metaData.getColumn("informacionsenalizacionBuclemagnetico").setTooltip(this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionBuclemagnetico.description", locale));
		metaData.getColumn("informacionsenalizacionBuclemagnetico").setGroupable(false);
		metaData.getColumn("informacionsenalizacionBuclemagnetico").setSortable(true);
		metaData.getColumn("informacionsenalizacionBuclemagnetico").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("informacionsenalizacionBuclemagnetico").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] informacionsenalizacionBuclemagneticoStore = new String[][]{
				{ String.valueOf(Keys.ACCESIBILIDAD_BUCLE_MAGNETICO_SI), this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionBuclemagnetico." + Keys.ACCESIBILIDAD_BUCLE_MAGNETICO_SI, locale)},
				{ String.valueOf(Keys.ACCESIBILIDAD_BUCLE_MAGNETICO_NO), this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionBuclemagnetico." + Keys.ACCESIBILIDAD_BUCLE_MAGNETICO_NO, locale)},
		};

		metaData.getColumn("informacionsenalizacionBuclemagnetico").setSofaStoreValues(informacionsenalizacionBuclemagneticoStore);

		metaData.getColumn("informacionsenalizacionBuclemagnetico").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("informacionsenalizacionBuclemagnetico").setEditable(true);
		metaData.getColumn("informacionsenalizacionBuclemagnetico").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("informacionsenalizacionBuclemagneticoSenalizado", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("informacionsenalizacionBuclemagneticoSenalizado", this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionBuclemagneticoSenalizado.header", locale)));
		metaData.getColumn("informacionsenalizacionBuclemagneticoSenalizado").setTooltip(this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionBuclemagneticoSenalizado.description", locale));
		metaData.getColumn("informacionsenalizacionBuclemagneticoSenalizado").setGroupable(false);
		metaData.getColumn("informacionsenalizacionBuclemagneticoSenalizado").setSortable(true);
		metaData.getColumn("informacionsenalizacionBuclemagneticoSenalizado").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("informacionsenalizacionBuclemagneticoSenalizado").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] informacionsenalizacionBuclemagneticoSenalizadoStore = new String[][]{
				{ String.valueOf(Keys.ACCESIBILIDAD_BUCLE_MAGNETICO_SENALIZADO_SI), this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionBuclemagneticoSenalizado." + Keys.ACCESIBILIDAD_BUCLE_MAGNETICO_SENALIZADO_SI, locale)},
				{ String.valueOf(Keys.ACCESIBILIDAD_BUCLE_MAGNETICO_SENALIZADO_NO), this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionBuclemagneticoSenalizado." + Keys.ACCESIBILIDAD_BUCLE_MAGNETICO_SENALIZADO_NO, locale)},
		};

		metaData.getColumn("informacionsenalizacionBuclemagneticoSenalizado").setSofaStoreValues(informacionsenalizacionBuclemagneticoSenalizadoStore);

		metaData.getColumn("informacionsenalizacionBuclemagneticoSenalizado").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("informacionsenalizacionBuclemagneticoSenalizado").setEditable(true);
		metaData.getColumn("informacionsenalizacionBuclemagneticoSenalizado").setHidden(true);

		//Creamos el registro para el record
		//metaData.addRecordField(new GridRecordFieldMetaData("informacionsenalizacionObservaciones", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		/*
		 * metaData.addColumn( new GridColumnMetaData(
		 * "informacionsenalizacionObservaciones", this.getMessage(
		 * "forms.accesibilidadpublicos.columns.informacionsenalizacionObservaciones.header"
		 * , locale) ) );
		 * metaData.getColumn("informacionsenalizacionObservaciones"
		 * ).setTooltip( this.getMessage(
		 * "forms.accesibilidadpublicos.columns.informacionsenalizacionObservaciones.description"
		 * , locale) );
		 * metaData.getColumn("informacionsenalizacionObservaciones"
		 * ).setGroupable( false );
		 * metaData.getColumn("informacionsenalizacionObservaciones"
		 * ).setSortable( true );
		 * metaData.getColumn("informacionsenalizacionObservaciones"
		 * ).setSofaFilter( GridColumnFilter.TYPE_STRING );
		 * 
		 * metaData.getColumn("informacionsenalizacionObservaciones").
		 * setSofaRenderer( GridColumnMetaData.RENDERER_LARGETEXT );
		 * 
		 * metaData.getColumn("informacionsenalizacionObservaciones").setEditable
		 * ( true );
		 */

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("informacionsenalizacionPrivadoSiaAparcamiento", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("informacionsenalizacionPrivadoSiaAparcamiento", this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionPrivadoSiaAparcamiento.header", locale)));
		metaData.getColumn("informacionsenalizacionPrivadoSiaAparcamiento").setTooltip(this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionPrivadoSiaAparcamiento.description", locale));
		metaData.getColumn("informacionsenalizacionPrivadoSiaAparcamiento").setGroupable(false);
		metaData.getColumn("informacionsenalizacionPrivadoSiaAparcamiento").setSortable(true);
		metaData.getColumn("informacionsenalizacionPrivadoSiaAparcamiento").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("informacionsenalizacionPrivadoSiaAparcamiento").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] informacionsenalizacionPrivadoSiaAparcamientoStore = new String[][]{
				{ String.valueOf(Keys.ACCESIBILIDAD_PRIVADO_SIA_APACAMIENTO_SI), this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionPrivadoSiaAparcamiento." + Keys.ACCESIBILIDAD_PRIVADO_SIA_APACAMIENTO_SI, locale)},
				{ String.valueOf(Keys.ACCESIBILIDAD_PRIVADO_SIA_APACAMIENTO_NO), this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionPrivadoSiaAparcamiento." + Keys.ACCESIBILIDAD_PRIVADO_SIA_APACAMIENTO_NO, locale)},
		};

		metaData.getColumn("informacionsenalizacionPrivadoSiaAparcamiento").setSofaStoreValues(informacionsenalizacionPrivadoSiaAparcamientoStore);

		metaData.getColumn("informacionsenalizacionPrivadoSiaAparcamiento").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("informacionsenalizacionPrivadoSiaAparcamiento").setEditable(true);
		metaData.getColumn("informacionsenalizacionPrivadoSiaAparcamiento").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("informacionsenalizacionPrivadoSiaAscensores", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("informacionsenalizacionPrivadoSiaAscensores", this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionPrivadoSiaAscensores.header", locale)));
		metaData.getColumn("informacionsenalizacionPrivadoSiaAscensores").setTooltip(this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionPrivadoSiaAscensores.description", locale));
		metaData.getColumn("informacionsenalizacionPrivadoSiaAscensores").setGroupable(false);
		metaData.getColumn("informacionsenalizacionPrivadoSiaAscensores").setSortable(true);
		metaData.getColumn("informacionsenalizacionPrivadoSiaAscensores").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("informacionsenalizacionPrivadoSiaAscensores").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] informacionsenalizacionPrivadoSiaAscensoresStore = new String[][]{
				{ String.valueOf(Keys.ACCESIBILIDAD_PRIVADO_SIA_ASCENSORES_SI), this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionPrivadoSiaAscensores." + Keys.ACCESIBILIDAD_PRIVADO_SIA_ASCENSORES_SI, locale)},
				{ String.valueOf(Keys.ACCESIBILIDAD_PRIVADO_SIA_ASCENSORES_NO), this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionPrivadoSiaAscensores." + Keys.ACCESIBILIDAD_PRIVADO_SIA_ASCENSORES_NO, locale)},
		};

		metaData.getColumn("informacionsenalizacionPrivadoSiaAscensores").setSofaStoreValues(informacionsenalizacionPrivadoSiaAscensoresStore);

		metaData.getColumn("informacionsenalizacionPrivadoSiaAscensores").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("informacionsenalizacionPrivadoSiaAscensores").setEditable(true);
		metaData.getColumn("informacionsenalizacionPrivadoSiaAscensores").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("informacionsenalizacionPrivadoSiaEntradas", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("informacionsenalizacionPrivadoSiaEntradas", this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionPrivadoSiaEntradas.header", locale)));
		metaData.getColumn("informacionsenalizacionPrivadoSiaEntradas").setTooltip(this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionPrivadoSiaEntradas.description", locale));
		metaData.getColumn("informacionsenalizacionPrivadoSiaEntradas").setGroupable(false);
		metaData.getColumn("informacionsenalizacionPrivadoSiaEntradas").setSortable(true);
		metaData.getColumn("informacionsenalizacionPrivadoSiaEntradas").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("informacionsenalizacionPrivadoSiaEntradas").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] informacionsenalizacionPrivadoSiaEntradasStore = new String[][]{
				{ String.valueOf(Keys.ACCESIBILIDAD_PRIVADO_SIA_ENTRADAS_SI), this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionPrivadoSiaEntradas." + Keys.ACCESIBILIDAD_PRIVADO_SIA_ENTRADAS_SI, locale)},
				{ String.valueOf(Keys.ACCESIBILIDAD_PRIVADO_SIA_ENTRADAS_NO), this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionPrivadoSiaEntradas." + Keys.ACCESIBILIDAD_PRIVADO_SIA_ENTRADAS_NO, locale)},
		};

		metaData.getColumn("informacionsenalizacionPrivadoSiaEntradas").setSofaStoreValues(informacionsenalizacionPrivadoSiaEntradasStore);

		metaData.getColumn("informacionsenalizacionPrivadoSiaEntradas").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("informacionsenalizacionPrivadoSiaEntradas").setEditable(true);
		metaData.getColumn("informacionsenalizacionPrivadoSiaEntradas").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("informacionsenalizacionPrivadoSiaItinerarios", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("informacionsenalizacionPrivadoSiaItinerarios", this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionPrivadoSiaItinerarios.header", locale)));
		metaData.getColumn("informacionsenalizacionPrivadoSiaItinerarios").setTooltip(this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionPrivadoSiaItinerarios.description", locale));
		metaData.getColumn("informacionsenalizacionPrivadoSiaItinerarios").setGroupable(false);
		metaData.getColumn("informacionsenalizacionPrivadoSiaItinerarios").setSortable(true);
		metaData.getColumn("informacionsenalizacionPrivadoSiaItinerarios").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("informacionsenalizacionPrivadoSiaItinerarios").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] informacionsenalizacionPrivadoSiaItinerariosStore = new String[][]{
				{ String.valueOf(Keys.ACCESIBILIDAD_PRIVADO_SIA_ITINERARIOS_SI), this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionPrivadoSiaItinerarios." + Keys.ACCESIBILIDAD_PRIVADO_SIA_ITINERARIOS_SI, locale)},
				{ String.valueOf(Keys.ACCESIBILIDAD_PRIVADO_SIA_ITINERARIOS_NO), this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionPrivadoSiaItinerarios." + Keys.ACCESIBILIDAD_PRIVADO_SIA_ITINERARIOS_NO, locale)},
		};

		metaData.getColumn("informacionsenalizacionPrivadoSiaItinerarios").setSofaStoreValues(informacionsenalizacionPrivadoSiaItinerariosStore);

		metaData.getColumn("informacionsenalizacionPrivadoSiaItinerarios").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("informacionsenalizacionPrivadoSiaItinerarios").setEditable(true);
		metaData.getColumn("informacionsenalizacionPrivadoSiaItinerarios").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("informacionsenalizacionPrivadoSiaPlazasreservadas", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("informacionsenalizacionPrivadoSiaPlazasreservadas", this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionPrivadoSiaPlazasreservadas.header", locale)));
		metaData.getColumn("informacionsenalizacionPrivadoSiaPlazasreservadas").setTooltip(this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionPrivadoSiaPlazasreservadas.description", locale));
		metaData.getColumn("informacionsenalizacionPrivadoSiaPlazasreservadas").setGroupable(false);
		metaData.getColumn("informacionsenalizacionPrivadoSiaPlazasreservadas").setSortable(true);
		metaData.getColumn("informacionsenalizacionPrivadoSiaPlazasreservadas").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("informacionsenalizacionPrivadoSiaPlazasreservadas").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] informacionsenalizacionPrivadoSiaPlazasreservadasStore = new String[][]{
				{ String.valueOf(Keys.ACCESIBILIDAD_PRIVADO_SIA_PLAZAS_RESERVADAS_SI), this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionPrivadoSiaPlazasreservadas." + Keys.ACCESIBILIDAD_PRIVADO_SIA_PLAZAS_RESERVADAS_SI, locale)},
				{ String.valueOf(Keys.ACCESIBILIDAD_PRIVADO_SIA_PLAZAS_RESERVADAS_NO), this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionPrivadoSiaPlazasreservadas." + Keys.ACCESIBILIDAD_PRIVADO_SIA_PLAZAS_RESERVADAS_NO, locale)},
		};

		metaData.getColumn("informacionsenalizacionPrivadoSiaPlazasreservadas").setSofaStoreValues(informacionsenalizacionPrivadoSiaPlazasreservadasStore);

		metaData.getColumn("informacionsenalizacionPrivadoSiaPlazasreservadas").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("informacionsenalizacionPrivadoSiaPlazasreservadas").setEditable(true);
		metaData.getColumn("informacionsenalizacionPrivadoSiaPlazasreservadas").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("informacionsenalizacionPublicoSiaAparcamiento", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("informacionsenalizacionPublicoSiaAparcamiento", this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionPublicoSiaAparcamiento.header", locale)));
		metaData.getColumn("informacionsenalizacionPublicoSiaAparcamiento").setTooltip(this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionPublicoSiaAparcamiento.description", locale));
		metaData.getColumn("informacionsenalizacionPublicoSiaAparcamiento").setGroupable(false);
		metaData.getColumn("informacionsenalizacionPublicoSiaAparcamiento").setSortable(true);
		metaData.getColumn("informacionsenalizacionPublicoSiaAparcamiento").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("informacionsenalizacionPublicoSiaAparcamiento").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] informacionsenalizacionPublicoSiaAparcamientoStore = new String[][]{
				{ String.valueOf(Keys.ACCESIBILIDAD_PUBLICO_SIA_APACAMIENTO_SI), this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionPublicoSiaAparcamiento." + Keys.ACCESIBILIDAD_PUBLICO_SIA_APACAMIENTO_SI, locale)},
				{ String.valueOf(Keys.ACCESIBILIDAD_PUBLICO_SIA_APACAMIENTO_NO), this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionPublicoSiaAparcamiento." + Keys.ACCESIBILIDAD_PUBLICO_SIA_APACAMIENTO_NO, locale)},
		};

		metaData.getColumn("informacionsenalizacionPublicoSiaAparcamiento").setSofaStoreValues(informacionsenalizacionPublicoSiaAparcamientoStore);

		metaData.getColumn("informacionsenalizacionPublicoSiaAparcamiento").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("informacionsenalizacionPublicoSiaAparcamiento").setEditable(true);
		metaData.getColumn("informacionsenalizacionPublicoSiaAparcamiento").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("informacionsenalizacionPublicoSiaAscensores", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("informacionsenalizacionPublicoSiaAscensores", this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionPublicoSiaAscensores.header", locale)));
		metaData.getColumn("informacionsenalizacionPublicoSiaAscensores").setTooltip(this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionPublicoSiaAscensores.description", locale));
		metaData.getColumn("informacionsenalizacionPublicoSiaAscensores").setGroupable(false);
		metaData.getColumn("informacionsenalizacionPublicoSiaAscensores").setSortable(true);
		metaData.getColumn("informacionsenalizacionPublicoSiaAscensores").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("informacionsenalizacionPublicoSiaAscensores").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] informacionsenalizacionPublicoSiaAscensoresStore = new String[][]{
				{ String.valueOf(Keys.ACCESIBILIDAD_PUBLICO_SIA_ASCENSORES_SI), this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionPublicoSiaAscensores." + Keys.ACCESIBILIDAD_PUBLICO_SIA_ASCENSORES_SI, locale)},
				{ String.valueOf(Keys.ACCESIBILIDAD_PUBLICO_SIA_ASCENSORES_NO), this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionPublicoSiaAscensores." + Keys.ACCESIBILIDAD_PUBLICO_SIA_ASCENSORES_NO, locale)},
		};

		metaData.getColumn("informacionsenalizacionPublicoSiaAscensores").setSofaStoreValues(informacionsenalizacionPublicoSiaAscensoresStore);

		metaData.getColumn("informacionsenalizacionPublicoSiaAscensores").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("informacionsenalizacionPublicoSiaAscensores").setEditable(true);
		metaData.getColumn("informacionsenalizacionPublicoSiaAscensores").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("informacionsenalizacionPublicoSiaEntradas", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("informacionsenalizacionPublicoSiaEntradas", this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionPublicoSiaEntradas.header", locale)));
		metaData.getColumn("informacionsenalizacionPublicoSiaEntradas").setTooltip(this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionPublicoSiaEntradas.description", locale));
		metaData.getColumn("informacionsenalizacionPublicoSiaEntradas").setGroupable(false);
		metaData.getColumn("informacionsenalizacionPublicoSiaEntradas").setSortable(true);
		metaData.getColumn("informacionsenalizacionPublicoSiaEntradas").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("informacionsenalizacionPublicoSiaEntradas").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] informacionsenalizacionPublicoSiaEntradasStore = new String[][]{
				{ String.valueOf(Keys.ACCESIBILIDAD_PUBLICO_SIA_ENTRADAS_SI), this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionPublicoSiaEntradas." + Keys.ACCESIBILIDAD_PUBLICO_SIA_ENTRADAS_SI, locale)},
				{ String.valueOf(Keys.ACCESIBILIDAD_PUBLICO_SIA_ENTRADAS_NO), this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionPublicoSiaEntradas." + Keys.ACCESIBILIDAD_PUBLICO_SIA_ENTRADAS_NO, locale)},
		};

		metaData.getColumn("informacionsenalizacionPublicoSiaEntradas").setSofaStoreValues(informacionsenalizacionPublicoSiaEntradasStore);

		metaData.getColumn("informacionsenalizacionPublicoSiaEntradas").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("informacionsenalizacionPublicoSiaEntradas").setEditable(true);
		metaData.getColumn("informacionsenalizacionPublicoSiaEntradas").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("informacionsenalizacionPublicoSiaItinerarios", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("informacionsenalizacionPublicoSiaItinerarios", this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionPublicoSiaItinerarios.header", locale)));
		metaData.getColumn("informacionsenalizacionPublicoSiaItinerarios").setTooltip(this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionPublicoSiaItinerarios.description", locale));
		metaData.getColumn("informacionsenalizacionPublicoSiaItinerarios").setGroupable(false);
		metaData.getColumn("informacionsenalizacionPublicoSiaItinerarios").setSortable(true);
		metaData.getColumn("informacionsenalizacionPublicoSiaItinerarios").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("informacionsenalizacionPublicoSiaItinerarios").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] informacionsenalizacionPublicoSiaItinerariosStore = new String[][]{
				{ String.valueOf(Keys.ACCESIBILIDAD_PUBLICO_SIA_ITINERARIOS_SI), this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionPublicoSiaItinerarios." + Keys.ACCESIBILIDAD_PUBLICO_SIA_ITINERARIOS_SI, locale)},
				{ String.valueOf(Keys.ACCESIBILIDAD_PUBLICO_SIA_ITINERARIOS_NO), this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionPublicoSiaItinerarios." + Keys.ACCESIBILIDAD_PUBLICO_SIA_ITINERARIOS_NO, locale)},
		};

		metaData.getColumn("informacionsenalizacionPublicoSiaItinerarios").setSofaStoreValues(informacionsenalizacionPublicoSiaItinerariosStore);

		metaData.getColumn("informacionsenalizacionPublicoSiaItinerarios").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("informacionsenalizacionPublicoSiaItinerarios").setEditable(true);
		metaData.getColumn("informacionsenalizacionPublicoSiaItinerarios").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("informacionsenalizacionPublicoSiaPlazasreservadas", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("informacionsenalizacionPublicoSiaPlazasreservadas", this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionPublicoSiaPlazasreservadas.header", locale)));
		metaData.getColumn("informacionsenalizacionPublicoSiaPlazasreservadas").setTooltip(this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionPublicoSiaPlazasreservadas.description", locale));
		metaData.getColumn("informacionsenalizacionPublicoSiaPlazasreservadas").setGroupable(false);
		metaData.getColumn("informacionsenalizacionPublicoSiaPlazasreservadas").setSortable(true);
		metaData.getColumn("informacionsenalizacionPublicoSiaPlazasreservadas").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("informacionsenalizacionPublicoSiaPlazasreservadas").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] informacionsenalizacionPublicoSiaPlazasreservadasStore = new String[][]{
				{ String.valueOf(Keys.ACCESIBILIDAD_PUBLICO_SIA_PLAZAS_RESERVADAS_SI), this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionPublicoSiaPlazasreservadas." + Keys.ACCESIBILIDAD_PUBLICO_SIA_PLAZAS_RESERVADAS_SI, locale)},
				{ String.valueOf(Keys.ACCESIBILIDAD_PUBLICO_SIA_PLAZAS_RESERVADAS_NO), this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionPublicoSiaPlazasreservadas." + Keys.ACCESIBILIDAD_PUBLICO_SIA_PLAZAS_RESERVADAS_NO, locale)},
		};

		metaData.getColumn("informacionsenalizacionPublicoSiaPlazasreservadas").setSofaStoreValues(informacionsenalizacionPublicoSiaPlazasreservadasStore);

		metaData.getColumn("informacionsenalizacionPublicoSiaPlazasreservadas").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("informacionsenalizacionPublicoSiaPlazasreservadas").setEditable(true);
		metaData.getColumn("informacionsenalizacionPublicoSiaPlazasreservadas").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("informacionsenalizacionPublicoSiaPuntosatencion", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("informacionsenalizacionPublicoSiaPuntosatencion", this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionPublicoSiaPuntosatencion.header", locale)));
		metaData.getColumn("informacionsenalizacionPublicoSiaPuntosatencion").setTooltip(this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionPublicoSiaPuntosatencion.description", locale));
		metaData.getColumn("informacionsenalizacionPublicoSiaPuntosatencion").setGroupable(false);
		metaData.getColumn("informacionsenalizacionPublicoSiaPuntosatencion").setSortable(true);
		metaData.getColumn("informacionsenalizacionPublicoSiaPuntosatencion").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("informacionsenalizacionPublicoSiaPuntosatencion").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] informacionsenalizacionPublicoSiaPuntosatencionStore = new String[][]{
				{ String.valueOf(Keys.ACCESIBILIDAD_PUBLICO_SIA_PUNTOS_ATENCION_SI), this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionPublicoSiaPuntosatencion." + Keys.ACCESIBILIDAD_PUBLICO_SIA_PUNTOS_ATENCION_SI, locale)},
				{ String.valueOf(Keys.ACCESIBILIDAD_PUBLICO_SIA_PUNTOS_ATENCION_NO), this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionPublicoSiaPuntosatencion." + Keys.ACCESIBILIDAD_PUBLICO_SIA_PUNTOS_ATENCION_NO, locale)},
		};

		metaData.getColumn("informacionsenalizacionPublicoSiaPuntosatencion").setSofaStoreValues(informacionsenalizacionPublicoSiaPuntosatencionStore);

		metaData.getColumn("informacionsenalizacionPublicoSiaPuntosatencion").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("informacionsenalizacionPublicoSiaPuntosatencion").setEditable(true);
		metaData.getColumn("informacionsenalizacionPublicoSiaPuntosatencion").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("informacionsenalizacionPublicoSiaServicioshigienicos", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("informacionsenalizacionPublicoSiaServicioshigienicos", this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionPublicoSiaServicioshigienicos.header", locale)));
		metaData.getColumn("informacionsenalizacionPublicoSiaServicioshigienicos").setTooltip(this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionPublicoSiaServicioshigienicos.description", locale));
		metaData.getColumn("informacionsenalizacionPublicoSiaServicioshigienicos").setGroupable(false);
		metaData.getColumn("informacionsenalizacionPublicoSiaServicioshigienicos").setSortable(true);
		metaData.getColumn("informacionsenalizacionPublicoSiaServicioshigienicos").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("informacionsenalizacionPublicoSiaServicioshigienicos").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] informacionsenalizacionPublicoSiaServicioshigienicosStore = new String[][]{
				{ String.valueOf(Keys.ACCESIBILIDAD_PUBLICO_SIA_SERVICIOS_HIGIENICOS_SI), this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionPublicoSiaServicioshigienicos." + Keys.ACCESIBILIDAD_PUBLICO_SIA_SERVICIOS_HIGIENICOS_SI, locale)},
				{ String.valueOf(Keys.ACCESIBILIDAD_PUBLICO_SIA_SERVICIOS_HIGIENICOS_NO), this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionPublicoSiaServicioshigienicos." + Keys.ACCESIBILIDAD_PUBLICO_SIA_SERVICIOS_HIGIENICOS_NO, locale)},
		};

		metaData.getColumn("informacionsenalizacionPublicoSiaServicioshigienicos").setSofaStoreValues(informacionsenalizacionPublicoSiaServicioshigienicosStore);

		metaData.getColumn("informacionsenalizacionPublicoSiaServicioshigienicos").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("informacionsenalizacionPublicoSiaServicioshigienicos").setEditable(true);
		metaData.getColumn("informacionsenalizacionPublicoSiaServicioshigienicos").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("informacionsenalizacionServicioshigienicossenalizados", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("informacionsenalizacionServicioshigienicossenalizados", this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionServicioshigienicossenalizados.header", locale)));
		metaData.getColumn("informacionsenalizacionServicioshigienicossenalizados").setTooltip(this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionServicioshigienicossenalizados.description", locale));
		metaData.getColumn("informacionsenalizacionServicioshigienicossenalizados").setGroupable(false);
		metaData.getColumn("informacionsenalizacionServicioshigienicossenalizados").setSortable(true);
		metaData.getColumn("informacionsenalizacionServicioshigienicossenalizados").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("informacionsenalizacionServicioshigienicossenalizados").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] informacionsenalizacionServicioshigienicossenalizadosStore = new String[][]{
				{ String.valueOf(Keys.ACCESIBILIDAD_SERVICIOS_HIGIENICOS_SENALIZADOS_SI), this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionServicioshigienicossenalizados." + Keys.ACCESIBILIDAD_SERVICIOS_HIGIENICOS_SENALIZADOS_SI, locale)},
				{ String.valueOf(Keys.ACCESIBILIDAD_SERVICIOS_HIGIENICOS_SENALIZADOS_NO), this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionServicioshigienicossenalizados." + Keys.ACCESIBILIDAD_SERVICIOS_HIGIENICOS_SENALIZADOS_NO, locale)},
		};

		metaData.getColumn("informacionsenalizacionServicioshigienicossenalizados").setSofaStoreValues(informacionsenalizacionServicioshigienicossenalizadosStore);

		metaData.getColumn("informacionsenalizacionServicioshigienicossenalizados").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("informacionsenalizacionServicioshigienicossenalizados").setEditable(true);
		metaData.getColumn("informacionsenalizacionServicioshigienicossenalizados").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("informacionsenalizacionSianorma", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("informacionsenalizacionSianorma", this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionSianorma.header", locale)));
		metaData.getColumn("informacionsenalizacionSianorma").setTooltip(this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionSianorma.description", locale));
		metaData.getColumn("informacionsenalizacionSianorma").setGroupable(false);
		metaData.getColumn("informacionsenalizacionSianorma").setSortable(true);
		metaData.getColumn("informacionsenalizacionSianorma").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("informacionsenalizacionSianorma").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] informacionsenalizacionSianormaStore = new String[][]{
				{ String.valueOf(Keys.ACCESIBILIDAD_SIANORMA_SI), this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionSianorma." + Keys.ACCESIBILIDAD_SIANORMA_SI, locale)},
				{ String.valueOf(Keys.ACCESIBILIDAD_SIANORMA_NO), this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionSianorma." + Keys.ACCESIBILIDAD_SIANORMA_NO, locale)},
		};

		metaData.getColumn("informacionsenalizacionSianorma").setSofaStoreValues(informacionsenalizacionSianormaStore);

		metaData.getColumn("informacionsenalizacionSianorma").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("informacionsenalizacionSianorma").setEditable(true);
		metaData.getColumn("informacionsenalizacionSianorma").setHidden(true);

		//Creamos el registro para el record
		//metaData.addRecordField(new GridRecordFieldMetaData("informacionsenalizacionTodosusosObservaciones", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		/*
		 * metaData.addColumn( new GridColumnMetaData(
		 * "informacionsenalizacionTodosusosObservaciones", this.getMessage(
		 * "forms.accesibilidadpublicos.columns.informacionsenalizacionTodosusosObservaciones.header"
		 * , locale) ) );
		 * metaData.getColumn("informacionsenalizacionTodosusosObservaciones"
		 * ).setTooltip( this.getMessage(
		 * "forms.accesibilidadpublicos.columns.informacionsenalizacionTodosusosObservaciones.description"
		 * , locale) );
		 * metaData.getColumn("informacionsenalizacionTodosusosObservaciones"
		 * ).setGroupable( false );
		 * metaData.getColumn("informacionsenalizacionTodosusosObservaciones"
		 * ).setSortable( true );
		 * metaData.getColumn("informacionsenalizacionTodosusosObservaciones"
		 * ).setSofaFilter( GridColumnFilter.TYPE_STRING );
		 * 
		 * metaData.getColumn("informacionsenalizacionTodosusosObservaciones").
		 * setSofaRenderer( GridColumnMetaData.RENDERER_LARGETEXT );
		 * 
		 * metaData.getColumn("informacionsenalizacionTodosusosObservaciones").
		 * setEditable( true );
		 */

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("mecanismosAccesibles", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("mecanismosAccesibles", this.getMessage("forms.accesibilidadpublicos.columns.mecanismosAccesibles.header", locale)));
		metaData.getColumn("mecanismosAccesibles").setGroupable(false);
		metaData.getColumn("mecanismosAccesibles").setSortable(true);
		metaData.getColumn("mecanismosAccesibles").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("mecanismosAccesibles").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] mecanismosAccesiblesStore = new String[][]{
				{ String.valueOf(Keys.ACCESIBILIDAD_MECANISMOS_ACCESIBLES_SI), this.getMessage("forms.accesibilidadpublicos.columns.mecanismosAccesibles." + Keys.ACCESIBILIDAD_MECANISMOS_ACCESIBLES_SI, locale)},
				{ String.valueOf(Keys.ACCESIBILIDAD_MECANISMOS_ACCESIBLES_NO), this.getMessage("forms.accesibilidadpublicos.columns.mecanismosAccesibles." + Keys.ACCESIBILIDAD_MECANISMOS_ACCESIBLES_NO, locale)},
		};

		metaData.getColumn("mecanismosAccesibles").setSofaStoreValues(mecanismosAccesiblesStore);

		metaData.getColumn("mecanismosAccesibles").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("mecanismosAccesibles").setEditable(true);
		metaData.getColumn("mecanismosAccesibles").setHidden(true);

		//Creamos el registro para el record
		//metaData.addRecordField(new GridRecordFieldMetaData("mecanismosObservaciones", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		/*
		 * metaData.addColumn( new GridColumnMetaData(
		 * "mecanismosObservaciones", this.getMessage(
		 * "forms.accesibilidadpublicos.columns.mecanismosObservaciones.header",
		 * locale) ) );
		 * metaData.getColumn("mecanismosObservaciones").setGroupable( false );
		 * metaData.getColumn("mecanismosObservaciones").setSortable( true );
		 * metaData.getColumn("mecanismosObservaciones").setSofaFilter(
		 * GridColumnFilter.TYPE_STRING );
		 * 
		 * metaData.getColumn("mecanismosObservaciones").setSofaRenderer(
		 * GridColumnMetaData.RENDERER_LARGETEXT );
		 * 
		 * metaData.getColumn("mecanismosObservaciones").setEditable( true );
		 */

		//Creamos el registro para el record
		//metaData.addRecordField(new GridRecordFieldMetaData("mobiliariofijoObservaciones", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		/*
		 * metaData.addColumn( new GridColumnMetaData(
		 * "mobiliariofijoObservaciones", this.getMessage(
		 * "forms.accesibilidadpublicos.columns.mobiliariofijoObservaciones.header"
		 * , locale) ) );
		 * metaData.getColumn("mobiliariofijoObservaciones").setGroupable( false
		 * ); metaData.getColumn("mobiliariofijoObservaciones").setSortable(
		 * true );
		 * metaData.getColumn("mobiliariofijoObservaciones").setSofaFilter(
		 * GridColumnFilter.TYPE_STRING );
		 * 
		 * metaData.getColumn("mobiliariofijoObservaciones").setSofaRenderer(
		 * GridColumnMetaData.RENDERER_LARGETEXT );
		 * 
		 * metaData.getColumn("mobiliariofijoObservaciones").setEditable( true
		 * );
		 */

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("mobiliariofijoPuntoaccesible", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("mobiliariofijoPuntoaccesible", this.getMessage("forms.accesibilidadpublicos.columns.mobiliariofijoPuntoaccesible.header", locale)));
		metaData.getColumn("mobiliariofijoPuntoaccesible").setGroupable(false);
		metaData.getColumn("mobiliariofijoPuntoaccesible").setSortable(true);
		metaData.getColumn("mobiliariofijoPuntoaccesible").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("mobiliariofijoPuntoaccesible").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] mobiliariofijoPuntoaccesibleStore = new String[][]{
				{ String.valueOf(Keys.ACCESIBILIDAD_MOBILIARIO_FIJO_PUNTO_ACCESIBLE_SI), this.getMessage("forms.accesibilidadpublicos.columns.mobiliariofijoPuntoaccesible." + Keys.ACCESIBILIDAD_MOBILIARIO_FIJO_PUNTO_ACCESIBLE_SI, locale)},
				{ String.valueOf(Keys.ACCESIBILIDAD_MOBILIARIO_FIJO_PUNTO_ACCESIBLE_NO), this.getMessage("forms.accesibilidadpublicos.columns.mobiliariofijoPuntoaccesible." + Keys.ACCESIBILIDAD_MOBILIARIO_FIJO_PUNTO_ACCESIBLE_NO, locale)},
		};

		metaData.getColumn("mobiliariofijoPuntoaccesible").setSofaStoreValues(mobiliariofijoPuntoaccesibleStore);

		metaData.getColumn("mobiliariofijoPuntoaccesible").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("mobiliariofijoPuntoaccesible").setEditable(true);
		metaData.getColumn("mobiliariofijoPuntoaccesible").setHidden(true);


		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("piscinasEntradaaccesible", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("piscinasEntradaaccesible", this.getMessage("forms.accesibilidadpublicos.columns.piscinasEntradaaccesible.header", locale)));
		metaData.getColumn("piscinasEntradaaccesible").setGroupable(false);
		metaData.getColumn("piscinasEntradaaccesible").setSortable(true);
		metaData.getColumn("piscinasEntradaaccesible").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("piscinasEntradaaccesible").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] piscinasEntradaaccesibleStore = new String[][]{
				{ String.valueOf(Keys.ACCESIBILIDAD_ENTRADA_ACCESIBLE_PISCINAS_SI), this.getMessage("forms.accesibilidadpublicos.columns.piscinasEntradaaccesible." + Keys.ACCESIBILIDAD_ENTRADA_ACCESIBLE_PISCINAS_SI, locale)},
				{ String.valueOf(Keys.ACCESIBILIDAD_ENTRADA_ACCESIBLE_PISCINAS_NO), this.getMessage("forms.accesibilidadpublicos.columns.piscinasEntradaaccesible." + Keys.ACCESIBILIDAD_ENTRADA_ACCESIBLE_PISCINAS_NO, locale)},
		};

		metaData.getColumn("piscinasEntradaaccesible").setSofaStoreValues(piscinasEntradaaccesibleStore);

		metaData.getColumn("piscinasEntradaaccesible").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("piscinasEntradaaccesible").setEditable(true);
		metaData.getColumn("piscinasEntradaaccesible").setHidden(true);

		//Creamos el registro para el record
		//metaData.addRecordField(new GridRecordFieldMetaData("piscinasObservaciones", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		/*
		 * metaData.addColumn( new GridColumnMetaData( "piscinasObservaciones",
		 * this.getMessage(
		 * "forms.accesibilidadpublicos.columns.piscinasObservaciones.header",
		 * locale) ) );
		 * metaData.getColumn("piscinasObservaciones").setGroupable( false );
		 * metaData.getColumn("piscinasObservaciones").setSortable( true );
		 * metaData.getColumn("piscinasObservaciones").setSofaFilter(
		 * GridColumnFilter.TYPE_STRING );
		 * 
		 * metaData.getColumn("piscinasObservaciones").setSofaRenderer(
		 * GridColumnMetaData.RENDERER_LARGETEXT );
		 * 
		 * metaData.getColumn("piscinasObservaciones").setEditable( true );
		 */

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("plantasItinerarioaccesibleElementosaccesibles", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("plantasItinerarioaccesibleElementosaccesibles", this.getMessage("forms.accesibilidadpublicos.columns.plantasItinerarioaccesibleElementosaccesibles.header", locale)));
		metaData.getColumn("plantasItinerarioaccesibleElementosaccesibles").setTooltip(this.getMessage("forms.accesibilidadpublicos.columns.plantasItinerarioaccesibleElementosaccesibles.description", locale));
		metaData.getColumn("plantasItinerarioaccesibleElementosaccesibles").setGroupable(false);
		metaData.getColumn("plantasItinerarioaccesibleElementosaccesibles").setSortable(true);
		metaData.getColumn("plantasItinerarioaccesibleElementosaccesibles").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("plantasItinerarioaccesibleElementosaccesibles").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] plantasItinerarioaccesibleElementosaccesiblesStore = new String[][]{
				{ String.valueOf(Keys.ACCESIBILIDAD_PLANTAS_ITINERARIO_ELEMENTOS_ACCESIBLES_SI), this.getMessage("forms.accesibilidadpublicos.columns.plantasItinerarioaccesibleElementosaccesibles." + Keys.ACCESIBILIDAD_PLANTAS_ITINERARIO_ELEMENTOS_ACCESIBLES_SI, locale)},
				{ String.valueOf(Keys.ACCESIBILIDAD_PLANTAS_ITINERARIO_ELEMENTOS_ACCESIBLES_NO), this.getMessage("forms.accesibilidadpublicos.columns.plantasItinerarioaccesibleElementosaccesibles." + Keys.ACCESIBILIDAD_PLANTAS_ITINERARIO_ELEMENTOS_ACCESIBLES_NO, locale)},
		};

		metaData.getColumn("plantasItinerarioaccesibleElementosaccesibles").setSofaStoreValues(plantasItinerarioaccesibleElementosaccesiblesStore);

		metaData.getColumn("plantasItinerarioaccesibleElementosaccesibles").setEditable(true);
		metaData.getColumn("plantasItinerarioaccesibleElementosaccesibles").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("plantasItinerarioaccesibleEntresi", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("plantasItinerarioaccesibleEntresi", this.getMessage("forms.accesibilidadpublicos.columns.plantasItinerarioaccesibleEntresi.header", locale)));
		metaData.getColumn("plantasItinerarioaccesibleEntresi").setTooltip(this.getMessage("forms.accesibilidadpublicos.columns.plantasItinerarioaccesibleEntresi.description", locale));
		metaData.getColumn("plantasItinerarioaccesibleEntresi").setGroupable(false);
		metaData.getColumn("plantasItinerarioaccesibleEntresi").setSortable(true);
		metaData.getColumn("plantasItinerarioaccesibleEntresi").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("plantasItinerarioaccesibleEntresi").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] plantasItinerarioaccesibleEntresiStore = new String[][]{
				{ String.valueOf(Keys.ACCESIBILIDAD_PLANTAS_ITINERARIO_ENTRESI_SI), this.getMessage("forms.accesibilidadpublicos.columns.plantasItinerarioaccesibleEntresi." + Keys.ACCESIBILIDAD_PLANTAS_ITINERARIO_ENTRESI_SI, locale)},
				{ String.valueOf(Keys.ACCESIBILIDAD_PLANTAS_ITINERARIO_ENTRESI_NO), this.getMessage("forms.accesibilidadpublicos.columns.plantasItinerarioaccesibleEntresi." + Keys.ACCESIBILIDAD_PLANTAS_ITINERARIO_ENTRESI_NO, locale)},
		};

		metaData.getColumn("plantasItinerarioaccesibleEntresi").setSofaStoreValues(plantasItinerarioaccesibleEntresiStore);

		metaData.getColumn("plantasItinerarioaccesibleEntresi").setEditable(true);
		metaData.getColumn("plantasItinerarioaccesibleEntresi").setHidden(true);

		//Creamos el registro para el record
		//metaData.addRecordField(new GridRecordFieldMetaData("plantasItinerarioaccesibleObservaciones", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		/*
		 * metaData.addColumn( new GridColumnMetaData(
		 * "plantasItinerarioaccesibleObservaciones", this.getMessage(
		 * "forms.accesibilidadpublicos.columns.plantasItinerarioaccesibleObservaciones.header"
		 * , locale) ) );
		 * metaData.getColumn("plantasItinerarioaccesibleObservaciones"
		 * ).setTooltip( this.getMessage(
		 * "forms.accesibilidadpublicos.columns.plantasItinerarioaccesibleObservaciones.description"
		 * , locale) );
		 * metaData.getColumn("plantasItinerarioaccesibleObservaciones"
		 * ).setGroupable( false );
		 * metaData.getColumn("plantasItinerarioaccesibleObservaciones"
		 * ).setSortable( true );
		 * metaData.getColumn("plantasItinerarioaccesibleObservaciones"
		 * ).setSofaFilter( GridColumnFilter.TYPE_STRING );
		 * 
		 * metaData.getColumn("plantasItinerarioaccesibleObservaciones").
		 * setSofaRenderer( GridColumnMetaData.RENDERER_LARGETEXT );
		 * 
		 * metaData.getColumn("plantasItinerarioaccesibleObservaciones").setEditable
		 * ( true );
		 */

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("plantasItinerarioaccesibleZonasusoprivado", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("plantasItinerarioaccesibleZonasusoprivado", this.getMessage("forms.accesibilidadpublicos.columns.plantasItinerarioaccesibleZonasusoprivado.header", locale)));
		metaData.getColumn("plantasItinerarioaccesibleZonasusoprivado").setTooltip(this.getMessage("forms.accesibilidadpublicos.columns.plantasItinerarioaccesibleZonasusoprivado.description", locale));
		metaData.getColumn("plantasItinerarioaccesibleZonasusoprivado").setGroupable(false);
		metaData.getColumn("plantasItinerarioaccesibleZonasusoprivado").setSortable(true);
		metaData.getColumn("plantasItinerarioaccesibleZonasusoprivado").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("plantasItinerarioaccesibleZonasusoprivado").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] plantasItinerarioaccesibleZonasusoprivadoStore = new String[][]{
				{ String.valueOf(Keys.ACCESIBILIDAD_PLANTAS_ITINERARIO_ZONA_USO_PRIVADO_SI), this.getMessage("forms.accesibilidadpublicos.columns.plantasItinerarioaccesibleZonasusoprivado." + Keys.ACCESIBILIDAD_PLANTAS_ITINERARIO_ZONA_USO_PRIVADO_SI, locale)},
				{ String.valueOf(Keys.ACCESIBILIDAD_PLANTAS_ITINERARIO_ZONA_USO_PRIVADO_NO), this.getMessage("forms.accesibilidadpublicos.columns.plantasItinerarioaccesibleZonasusoprivado." + Keys.ACCESIBILIDAD_PLANTAS_ITINERARIO_ZONA_USO_PRIVADO_NO, locale)},
		};

		metaData.getColumn("plantasItinerarioaccesibleZonasusoprivado").setSofaStoreValues(plantasItinerarioaccesibleZonasusoprivadoStore);

		metaData.getColumn("plantasItinerarioaccesibleZonasusoprivado").setEditable(true);
		metaData.getColumn("plantasItinerarioaccesibleZonasusoprivado").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("plantasItinerarioaccesibleZonasusopublico", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("plantasItinerarioaccesibleZonasusopublico", this.getMessage("forms.accesibilidadpublicos.columns.plantasItinerarioaccesibleZonasusopublico.header", locale)));
		metaData.getColumn("plantasItinerarioaccesibleZonasusopublico").setTooltip(this.getMessage("forms.accesibilidadpublicos.columns.plantasItinerarioaccesibleZonasusopublico.description", locale));
		metaData.getColumn("plantasItinerarioaccesibleZonasusopublico").setGroupable(false);
		metaData.getColumn("plantasItinerarioaccesibleZonasusopublico").setSortable(true);
		metaData.getColumn("plantasItinerarioaccesibleZonasusopublico").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("plantasItinerarioaccesibleZonasusopublico").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] plantasItinerarioaccesibleZonasusopublicoStore = new String[][]{
				{ String.valueOf(Keys.ACCESIBILIDAD_PLANTAS_ITINERARIO_ZONA_USO_PUBLICO_SI), this.getMessage("forms.accesibilidadpublicos.columns.plantasItinerarioaccesibleZonasusopublico." + Keys.ACCESIBILIDAD_PLANTAS_ITINERARIO_ZONA_USO_PUBLICO_SI, locale)},
				{ String.valueOf(Keys.ACCESIBILIDAD_PLANTAS_ITINERARIO_ZONA_USO_PUBLICO_NO), this.getMessage("forms.accesibilidadpublicos.columns.plantasItinerarioaccesibleZonasusopublico." + Keys.ACCESIBILIDAD_PLANTAS_ITINERARIO_ZONA_USO_PUBLICO_NO, locale)},
		};

		metaData.getColumn("plantasItinerarioaccesibleZonasusopublico").setSofaStoreValues(plantasItinerarioaccesibleZonasusopublicoStore);

		metaData.getColumn("plantasItinerarioaccesibleZonasusopublico").setEditable(true);
		metaData.getColumn("plantasItinerarioaccesibleZonasusopublico").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("plazasreservadasDiscapacidadauditiva", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("plazasreservadasDiscapacidadauditiva", this.getMessage("forms.accesibilidadpublicos.columns.plazasreservadasDiscapacidadauditiva.header", locale)));
		metaData.getColumn("plazasreservadasDiscapacidadauditiva").setTooltip(this.getMessage("forms.accesibilidadpublicos.columns.plazasreservadasDiscapacidadauditiva.description", locale));
		metaData.getColumn("plazasreservadasDiscapacidadauditiva").setGroupable(false);
		metaData.getColumn("plazasreservadasDiscapacidadauditiva").setSortable(true);
		metaData.getColumn("plazasreservadasDiscapacidadauditiva").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("plazasreservadasDiscapacidadauditiva").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] plazasreservadasDiscapacidadauditivaStore = new String[][]{
				{ String.valueOf(Keys.ACCESIBILIDAD_PLANTAS_ITINERARIO_DISCAPACIDAD_AUDITIVA_SI), this.getMessage("forms.accesibilidadpublicos.columns.plazasreservadasDiscapacidadauditiva." + Keys.ACCESIBILIDAD_PLANTAS_ITINERARIO_DISCAPACIDAD_AUDITIVA_SI, locale)},
				{ String.valueOf(Keys.ACCESIBILIDAD_PLANTAS_ITINERARIO_DISCAPACIDAD_AUDITIVA_NO), this.getMessage("forms.accesibilidadpublicos.columns.plazasreservadasDiscapacidadauditiva." + Keys.ACCESIBILIDAD_PLANTAS_ITINERARIO_DISCAPACIDAD_AUDITIVA_NO, locale)},
		};

		metaData.getColumn("plazasreservadasDiscapacidadauditiva").setSofaStoreValues(plazasreservadasDiscapacidadauditivaStore);

		metaData.getColumn("plazasreservadasDiscapacidadauditiva").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("plazasreservadasDiscapacidadauditiva").setEditable(true);
		metaData.getColumn("plazasreservadasDiscapacidadauditiva").setHidden(true);

		//Creamos el registro para el record
		//metaData.addRecordField(new GridRecordFieldMetaData("plazasreservadasObservaciones", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		/*
		 * metaData.addColumn( new GridColumnMetaData(
		 * "plazasreservadasObservaciones", this.getMessage(
		 * "forms.accesibilidadpublicos.columns.plazasreservadasObservaciones.header"
		 * , locale) ) );
		 * metaData.getColumn("plazasreservadasObservaciones").setTooltip(
		 * this.getMessage(
		 * "forms.accesibilidadpublicos.columns.plazasreservadasObservaciones.description"
		 * , locale) );
		 * metaData.getColumn("plazasreservadasObservaciones").setGroupable(
		 * false );
		 * metaData.getColumn("plazasreservadasObservaciones").setSortable( true
		 * ); metaData.getColumn("plazasreservadasObservaciones").setSofaFilter(
		 * GridColumnFilter.TYPE_STRING );
		 * 
		 * metaData.getColumn("plazasreservadasObservaciones").setSofaRenderer(
		 * GridColumnMetaData.RENDERER_LARGETEXT );
		 * 
		 * metaData.getColumn("plazasreservadasObservaciones").setEditable( true
		 * );
		 */

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("plazasreservadasSillaruedas", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("plazasreservadasSillaruedas", this.getMessage("forms.accesibilidadpublicos.columns.plazasreservadasSillaruedas.header", locale)));
		metaData.getColumn("plazasreservadasSillaruedas").setGroupable(false);
		metaData.getColumn("plazasreservadasSillaruedas").setSortable(true);
		metaData.getColumn("plazasreservadasSillaruedas").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("plazasreservadasSillaruedas").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] plazasreservadasSillaruedasStore = new String[][]{
				{ String.valueOf(Keys.ACCESIBILIDAD_PLANTAS_ITINERARIO_SILLA_RUEDAS_SI), this.getMessage("forms.accesibilidadpublicos.columns.plazasreservadasSillaruedas." + Keys.ACCESIBILIDAD_PLANTAS_ITINERARIO_SILLA_RUEDAS_SI, locale)},
				{ String.valueOf(Keys.ACCESIBILIDAD_PLANTAS_ITINERARIO_SILLA_RUEDAS_NO), this.getMessage("forms.accesibilidadpublicos.columns.plazasreservadasSillaruedas." + Keys.ACCESIBILIDAD_PLANTAS_ITINERARIO_SILLA_RUEDAS_NO, locale)},
		};

		metaData.getColumn("plazasreservadasSillaruedas").setSofaStoreValues(plazasreservadasSillaruedasStore);

		metaData.getColumn("plazasreservadasSillaruedas").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("plazasreservadasSillaruedas").setEditable(true);
		metaData.getColumn("plazasreservadasSillaruedas").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("plazasreservadasZonaesperaSillaruedas", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("plazasreservadasZonaesperaSillaruedas", this.getMessage("forms.accesibilidadpublicos.columns.plazasreservadasZonaesperaSillaruedas.header", locale)));
		metaData.getColumn("plazasreservadasZonaesperaSillaruedas").setTooltip(this.getMessage("forms.accesibilidadpublicos.columns.plazasreservadasZonaesperaSillaruedas.description", locale));
		metaData.getColumn("plazasreservadasZonaesperaSillaruedas").setGroupable(false);
		metaData.getColumn("plazasreservadasZonaesperaSillaruedas").setSortable(true);
		metaData.getColumn("plazasreservadasZonaesperaSillaruedas").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("plazasreservadasZonaesperaSillaruedas").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] plazasreservadasZonaesperaSillaruedasStore = new String[][]{
				{ String.valueOf(Keys.ACCESIBILIDAD_PLANTAS_ITINERARIO_ZONA_ESPERA_SILLA_RUEDAS_SI), this.getMessage("forms.accesibilidadpublicos.columns.plazasreservadasZonaesperaSillaruedas." + Keys.ACCESIBILIDAD_PLANTAS_ITINERARIO_ZONA_ESPERA_SILLA_RUEDAS_SI, locale)},
				{ String.valueOf(Keys.ACCESIBILIDAD_PLANTAS_ITINERARIO_ZONA_ESPERA_SILLA_RUEDAS_NO), this.getMessage("forms.accesibilidadpublicos.columns.plazasreservadasZonaesperaSillaruedas." + Keys.ACCESIBILIDAD_PLANTAS_ITINERARIO_ZONA_ESPERA_SILLA_RUEDAS_NO, locale)},
		};

		metaData.getColumn("plazasreservadasZonaesperaSillaruedas").setSofaStoreValues(plazasreservadasZonaesperaSillaruedasStore);

		metaData.getColumn("plazasreservadasZonaesperaSillaruedas").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("plazasreservadasZonaesperaSillaruedas").setEditable(true);
		metaData.getColumn("plazasreservadasZonaesperaSillaruedas").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("servicioshigienicosAseoaccesible", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("servicioshigienicosAseoaccesible", this.getMessage("forms.accesibilidadpublicos.columns.servicioshigienicosAseoaccesible.header", locale)));
		metaData.getColumn("servicioshigienicosAseoaccesible").setTooltip(this.getMessage("forms.accesibilidadpublicos.columns.servicioshigienicosAseoaccesible.description", locale));
		metaData.getColumn("servicioshigienicosAseoaccesible").setGroupable(false);
		metaData.getColumn("servicioshigienicosAseoaccesible").setSortable(true);
		metaData.getColumn("servicioshigienicosAseoaccesible").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("servicioshigienicosAseoaccesible").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] servicioshigienicosAseoaccesibleStore = new String[][]{
				{ String.valueOf(Keys.ACCESIBILIDAD_PLANTAS_ITINERARIO_ASEO_ACCESIBLE_SI), this.getMessage("forms.accesibilidadpublicos.columns.servicioshigienicosAseoaccesible." + Keys.ACCESIBILIDAD_PLANTAS_ITINERARIO_ASEO_ACCESIBLE_SI, locale)},
				{ String.valueOf(Keys.ACCESIBILIDAD_PLANTAS_ITINERARIO_ASEO_ACCESIBLE_NO), this.getMessage("forms.accesibilidadpublicos.columns.servicioshigienicosAseoaccesible." + Keys.ACCESIBILIDAD_PLANTAS_ITINERARIO_ASEO_ACCESIBLE_NO, locale)},
		};

		metaData.getColumn("servicioshigienicosAseoaccesible").setSofaStoreValues(servicioshigienicosAseoaccesibleStore);

		metaData.getColumn("servicioshigienicosAseoaccesible").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("servicioshigienicosAseoaccesible").setEditable(true);
		metaData.getColumn("servicioshigienicosAseoaccesible").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("servicioshigienicosCabinaduchaaccesibles", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("servicioshigienicosCabinaduchaaccesibles", this.getMessage("forms.accesibilidadpublicos.columns.servicioshigienicosCabinaduchaaccesibles.header", locale)));
		metaData.getColumn("servicioshigienicosCabinaduchaaccesibles").setTooltip(this.getMessage("forms.accesibilidadpublicos.columns.servicioshigienicosCabinaduchaaccesibles.description", locale));
		metaData.getColumn("servicioshigienicosCabinaduchaaccesibles").setGroupable(false);
		metaData.getColumn("servicioshigienicosCabinaduchaaccesibles").setSortable(true);
		metaData.getColumn("servicioshigienicosCabinaduchaaccesibles").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("servicioshigienicosCabinaduchaaccesibles").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] servicioshigienicosCabinaduchaaccesiblesStore = new String[][]{
				{ String.valueOf(Keys.ACCESIBILIDAD_PLANTAS_ITINERARIO_CABINA_DUCHA_ACCESIBLE_SI), this.getMessage("forms.accesibilidadpublicos.columns.servicioshigienicosCabinaduchaaccesibles." + Keys.ACCESIBILIDAD_PLANTAS_ITINERARIO_CABINA_DUCHA_ACCESIBLE_SI, locale)},
				{ String.valueOf(Keys.ACCESIBILIDAD_PLANTAS_ITINERARIO_CABINA_DUCHA_ACCESIBLE_NO), this.getMessage("forms.accesibilidadpublicos.columns.servicioshigienicosCabinaduchaaccesibles." + Keys.ACCESIBILIDAD_PLANTAS_ITINERARIO_CABINA_DUCHA_ACCESIBLE_NO, locale)},
		};

		metaData.getColumn("servicioshigienicosCabinaduchaaccesibles").setSofaStoreValues(servicioshigienicosCabinaduchaaccesiblesStore);

		metaData.getColumn("servicioshigienicosCabinaduchaaccesibles").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("servicioshigienicosCabinaduchaaccesibles").setEditable(true);
		metaData.getColumn("servicioshigienicosCabinaduchaaccesibles").setHidden(true);

		//Creamos el registro para el record
		//metaData.addRecordField(new GridRecordFieldMetaData("servicioshigienicosObservaciones", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		/*
		 * metaData.addColumn( new GridColumnMetaData(
		 * "servicioshigienicosObservaciones", this.getMessage(
		 * "forms.accesibilidadpublicos.columns.servicioshigienicosObservaciones.header"
		 * , locale) ) );
		 * metaData.getColumn("servicioshigienicosObservaciones").setTooltip(
		 * this.getMessage(
		 * "forms.accesibilidadpublicos.columns.servicioshigienicosObservaciones.description"
		 * , locale) );
		 * metaData.getColumn("servicioshigienicosObservaciones").setGroupable(
		 * false );
		 * metaData.getColumn("servicioshigienicosObservaciones").setSortable(
		 * true );
		 * metaData.getColumn("servicioshigienicosObservaciones").setSofaFilter(
		 * GridColumnFilter.TYPE_STRING );
		 * 
		 * metaData.getColumn("servicioshigienicosObservaciones").setSofaRenderer
		 * ( GridColumnMetaData.RENDERER_LARGETEXT );
		 * 
		 * metaData.getColumn("servicioshigienicosObservaciones").setEditable(
		 * true );
		 */


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

		datosExportacion.add("claveInforme", this.getMessage("forms.accesibilidadpublicos.columns.claveInforme.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("inspeccion", this.getMessage("forms.accesibilidadpublicos.columns.inspeccion.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("alojamientosaccesibles1porcada50", this.getMessage("forms.accesibilidadpublicos.columns.alojamientosaccesibles1porcada50.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("alojamientosaccesiblesMinimo1", this.getMessage("forms.accesibilidadpublicos.columns.alojamientosaccesiblesMinimo1.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("alojamientosaccesiblesMinimo2", this.getMessage("forms.accesibilidadpublicos.columns.alojamientosaccesiblesMinimo2.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("alojamientosaccesiblesMinimo4", this.getMessage("forms.accesibilidadpublicos.columns.alojamientosaccesiblesMinimo4.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("alojamientosaccesiblesMinimo6", this.getMessage("forms.accesibilidadpublicos.columns.alojamientosaccesiblesMinimo6.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("alojamientosaccesiblesMinimo8", this.getMessage("forms.accesibilidadpublicos.columns.alojamientosaccesiblesMinimo8.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("alojamientosaccesiblesObservaciones", this.getMessage("forms.accesibilidadpublicos.columns.alojamientosaccesiblesObservaciones.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("aparcamientoComercialPorfraccion", this.getMessage("forms.accesibilidadpublicos.columns.aparcamientoComercialPorfraccion.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("aparcamientoObservaciones", this.getMessage("forms.accesibilidadpublicos.columns.aparcamientoObservaciones.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("aparcamientoOtrosusosMinimoaparcamientosUnamasporfraccion", this.getMessage("forms.accesibilidadpublicos.columns.aparcamientoOtrosusosMinimoaparcamientosUnamasporfraccion.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("aparcamientoOtrosusosMinimoaparcamientosUnaporfraccion", this.getMessage("forms.accesibilidadpublicos.columns.aparcamientoOtrosusosMinimoaparcamientosUnaporfraccion.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("aparcamientoResidencialpublicoPoralojamiento", this.getMessage("forms.accesibilidadpublicos.columns.aparcamientoResidencialpublicoPoralojamiento.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("aparcamientoSillaruedas", this.getMessage("forms.accesibilidadpublicos.columns.aparcamientoSillaruedas.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("entreplantasAccesible", this.getMessage("forms.accesibilidadpublicos.columns.entreplantasAccesible.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("entreplantasAccesibleAscensornoaccesible", this.getMessage("forms.accesibilidadpublicos.columns.entreplantasAccesibleAscensornoaccesible.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("entreplantasAccesibleAscensornoaccesibleDimensiones", this.getMessage("forms.accesibilidadpublicos.columns.entreplantasAccesibleAscensornoaccesibleDimensiones.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("entreplantasAccesibleAscensororampaaccesible", this.getMessage("forms.accesibilidadpublicos.columns.entreplantasAccesibleAscensororampaaccesible.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("entreplantasAccesibleRampaascensornoaccesible", this.getMessage("forms.accesibilidadpublicos.columns.entreplantasAccesibleRampaascensornoaccesible.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("entreplantasElementosaccesibles", this.getMessage("forms.accesibilidadpublicos.columns.entreplantasElementosaccesibles.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("entreplantasElementosaccesiblesAscensornoaccesible", this.getMessage("forms.accesibilidadpublicos.columns.entreplantasElementosaccesiblesAscensornoaccesible.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("entreplantasElementosaccesiblesAscensornoaccesibleDimensione", this.getMessage("forms.accesibilidadpublicos.columns.entreplantasElementosaccesiblesAscensornoaccesibleDimensione.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("entreplantasElementosaccesiblesAscensororampaaccesible", this.getMessage("forms.accesibilidadpublicos.columns.entreplantasElementosaccesiblesAscensororampaaccesible.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("entreplantasElementosaccesiblesRampaascensornoaccesible", this.getMessage("forms.accesibilidadpublicos.columns.entreplantasElementosaccesiblesRampaascensornoaccesible.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("entreplantasNoaccesible", this.getMessage("forms.accesibilidadpublicos.columns.entreplantasNoaccesible.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("entreplantasNoaccesibleAscensornoaccesible", this.getMessage("forms.accesibilidadpublicos.columns.entreplantasNoaccesibleAscensornoaccesible.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("entreplantasNoaccesibleAscensornoaccesibleDimensiones", this.getMessage("forms.accesibilidadpublicos.columns.entreplantasNoaccesibleAscensornoaccesibleDimensiones.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("entreplantasNoaccesibleAscensororampaaccesible", this.getMessage("forms.accesibilidadpublicos.columns.entreplantasNoaccesibleAscensororampaaccesible.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("entreplantasNoaccesibleRampaascensornoaccesible", this.getMessage("forms.accesibilidadpublicos.columns.entreplantasNoaccesibleRampaascensornoaccesible.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("entreplantasObservaciones", this.getMessage("forms.accesibilidadpublicos.columns.entreplantasObservaciones.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("entreplantasZonasusopublico", this.getMessage("forms.accesibilidadpublicos.columns.entreplantasZonasusopublico.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("entreplantasZonasusopublicoAscensornoaccesible", this.getMessage("forms.accesibilidadpublicos.columns.entreplantasZonasusopublicoAscensornoaccesible.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("entreplantasZonasusopublicoAscensornoaccesibleDimensiones", this.getMessage("forms.accesibilidadpublicos.columns.entreplantasZonasusopublicoAscensornoaccesibleDimensiones.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("entreplantasZonasusopublicoAscensororampaaccesible", this.getMessage("forms.accesibilidadpublicos.columns.entreplantasZonasusopublicoAscensororampaaccesible.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("entreplantasZonasusopublicoRampaascensornoaccesible", this.getMessage("forms.accesibilidadpublicos.columns.entreplantasZonasusopublicoRampaascensornoaccesible.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("esTecnicoInspeccion", this.getMessage("forms.accesibilidadpublicos.columns.esTecnicoInspeccion.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("exteriorEdificioitinerarioaccesibleViapublica", this.getMessage("forms.accesibilidadpublicos.columns.exteriorEdificioitinerarioaccesibleViapublica.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("exteriorEdificioitinerarioaccesibleZonascomunes", this.getMessage("forms.accesibilidadpublicos.columns.exteriorEdificioitinerarioaccesibleZonascomunes.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("exteriorObservaciones", this.getMessage("forms.accesibilidadpublicos.columns.exteriorObservaciones.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("informacionsenalizacionAscensores", this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionAscensores.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("informacionsenalizacionAscensoresBrailearabigo", this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionAscensoresBrailearabigo.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("informacionsenalizacionAscensoresNumeroplanta", this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionAscensoresNumeroplanta.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("informacionsenalizacionBandasvisualestactiles", this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionBandasvisualestactiles.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("informacionsenalizacionBandasvisualestactilesArranqueescalera", this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionBandasvisualestactilesArranqueescalera.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("informacionsenalizacionBandasvisualestactilesColorcontrastado", this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionBandasvisualestactilesColorcontrastado.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("informacionsenalizacionBandasvisualestactilesItinerarioaccesi", this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionBandasvisualestactilesItinerarioaccesi.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("informacionsenalizacionBandasvisualestactilesRelieveexterior", this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionBandasvisualestactilesRelieveexterior.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("informacionsenalizacionBandasvisualestactilesRelieveinterior", this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionBandasvisualestactilesRelieveinterior.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("informacionsenalizacionBuclemagnetico", this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionBuclemagnetico.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("informacionsenalizacionBuclemagneticoSenalizado", this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionBuclemagneticoSenalizado.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("informacionsenalizacionObservaciones", this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionObservaciones.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("informacionsenalizacionPrivadoSiaAparcamiento", this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionPrivadoSiaAparcamiento.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("informacionsenalizacionPrivadoSiaAscensores", this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionPrivadoSiaAscensores.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("informacionsenalizacionPrivadoSiaEntradas", this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionPrivadoSiaEntradas.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("informacionsenalizacionPrivadoSiaItinerarios", this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionPrivadoSiaItinerarios.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("informacionsenalizacionPrivadoSiaPlazasreservadas", this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionPrivadoSiaPlazasreservadas.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("informacionsenalizacionPublicoSiaAparcamiento", this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionPublicoSiaAparcamiento.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("informacionsenalizacionPublicoSiaAscensores", this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionPublicoSiaAscensores.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("informacionsenalizacionPublicoSiaEntradas", this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionPublicoSiaEntradas.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("informacionsenalizacionPublicoSiaItinerarios", this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionPublicoSiaItinerarios.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("informacionsenalizacionPublicoSiaPlazasreservadas", this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionPublicoSiaPlazasreservadas.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("informacionsenalizacionPublicoSiaPuntosatencion", this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionPublicoSiaPuntosatencion.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("informacionsenalizacionPublicoSiaServicioshigienicos", this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionPublicoSiaServicioshigienicos.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("informacionsenalizacionServicioshigienicossenalizados", this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionServicioshigienicossenalizados.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("informacionsenalizacionSianorma", this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionSianorma.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("informacionsenalizacionTodosusosObservaciones", this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionTodosusosObservaciones.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("mecanismosAccesibles", this.getMessage("forms.accesibilidadpublicos.columns.mecanismosAccesibles.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("mecanismosObservaciones", this.getMessage("forms.accesibilidadpublicos.columns.mecanismosObservaciones.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("mobiliariofijoObservaciones", this.getMessage("forms.accesibilidadpublicos.columns.mobiliariofijoObservaciones.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("mobiliariofijoPuntoaccesible", this.getMessage("forms.accesibilidadpublicos.columns.mobiliariofijoPuntoaccesible.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("nif", this.getMessage("forms.accesibilidadpublicos.columns.nif.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("piscinasEntradaaccesible", this.getMessage("forms.accesibilidadpublicos.columns.piscinasEntradaaccesible.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("piscinasObservaciones", this.getMessage("forms.accesibilidadpublicos.columns.piscinasObservaciones.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("plantasItinerarioaccesibleElementosaccesibles", this.getMessage("forms.accesibilidadpublicos.columns.plantasItinerarioaccesibleElementosaccesibles.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("plantasItinerarioaccesibleEntresi", this.getMessage("forms.accesibilidadpublicos.columns.plantasItinerarioaccesibleEntresi.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("plantasItinerarioaccesibleObservaciones", this.getMessage("forms.accesibilidadpublicos.columns.plantasItinerarioaccesibleObservaciones.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("plantasItinerarioaccesibleZonasusoprivado", this.getMessage("forms.accesibilidadpublicos.columns.plantasItinerarioaccesibleZonasusoprivado.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("plantasItinerarioaccesibleZonasusopublico", this.getMessage("forms.accesibilidadpublicos.columns.plantasItinerarioaccesibleZonasusopublico.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("plazasreservadasDiscapacidadauditiva", this.getMessage("forms.accesibilidadpublicos.columns.plazasreservadasDiscapacidadauditiva.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("plazasreservadasObservaciones", this.getMessage("forms.accesibilidadpublicos.columns.plazasreservadasObservaciones.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("plazasreservadasSillaruedas", this.getMessage("forms.accesibilidadpublicos.columns.plazasreservadasSillaruedas.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("plazasreservadasZonaesperaSillaruedas", this.getMessage("forms.accesibilidadpublicos.columns.plazasreservadasZonaesperaSillaruedas.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("servicioshigienicosAseoaccesible", this.getMessage("forms.accesibilidadpublicos.columns.servicioshigienicosAseoaccesible.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("servicioshigienicosCabinaduchaaccesibles", this.getMessage("forms.accesibilidadpublicos.columns.servicioshigienicosCabinaduchaaccesibles.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("servicioshigienicosObservaciones", this.getMessage("forms.accesibilidadpublicos.columns.servicioshigienicosObservaciones.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("tecnico", this.getMessage("forms.accesibilidadpublicos.columns.tecnico.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("titulacion", this.getMessage("forms.accesibilidadpublicos.columns.titulacion.header", locale), TipoCampoExportacion.STRING);

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
		AccesibilidadPublicosListadoVO instance = (AccesibilidadPublicosListadoVO) rawInstance;

		List<String> excelRow = new ArrayList<String>();

		excelRow.add(FormData2Java.toString(instance.getClaveInforme()));
		excelRow.add(FormData2Java.toString(instance.getInspeccionLabel()));

		//excelRow.add(instance.getAlojamientosaccesibles1porcada50());
		if (instance.getAlojamientosaccesibles1porcada50()!=null){
			excelRow.add( this.getMessage("forms.accesibilidadpublicospublicos.columns.alojamientosaccesibles1porcada50." + instance.getAlojamientosaccesibles1porcada50(), locale) );
		}else{
			excelRow.add("null");
		}	

		//excelRow.add(instance.getAlojamientosaccesiblesMinimo1());
		if (instance.getAlojamientosaccesiblesMinimo1()!=null){
			excelRow.add( this.getMessage("forms.accesibilidadpublicos.columns.alojamientosaccesiblesMinimo1." + instance.getAlojamientosaccesiblesMinimo1(), locale) );
		}else{
			excelRow.add("null");
		}	

		//excelRow.add(instance.getAlojamientosaccesiblesMinimo2());
		if (instance.getAlojamientosaccesiblesMinimo2()!=null){
			excelRow.add( this.getMessage("forms.accesibilidadpublicos.columns.alojamientosaccesiblesMinimo2." + instance.getAlojamientosaccesiblesMinimo2(), locale) );
		}else{
			excelRow.add("null");
		}	

		//excelRow.add(instance.getAlojamientosaccesiblesMinimo4());
		if (instance.getAlojamientosaccesiblesMinimo4()!=null){
			excelRow.add( this.getMessage("forms.accesibilidadpublicos.columns.alojamientosaccesiblesMinimo4." + instance.getAlojamientosaccesiblesMinimo4(), locale) );
		}else{
			excelRow.add("null");
		}	

		//excelRow.add(instance.getAlojamientosaccesiblesMinimo6());
		if (instance.getAlojamientosaccesiblesMinimo6()!=null){
			excelRow.add( this.getMessage("forms.accesibilidadpublicos.columns.alojamientosaccesiblesMinimo6." + instance.getAlojamientosaccesiblesMinimo6(), locale) );
		}else{
			excelRow.add("null");
		}	

		//excelRow.add(instance.getAlojamientosaccesiblesMinimo8());
		if (instance.getAlojamientosaccesiblesMinimo8()!=null){
			excelRow.add( this.getMessage("forms.accesibilidadpublicos.columns.alojamientosaccesiblesMinimo8." + instance.getAlojamientosaccesiblesMinimo8(), locale) );

			excelRow.add(instance.getAlojamientosaccesiblesObservaciones());
		}else{
			excelRow.add("null");
		}	

		//excelRow.add(instance.getAparcamientoComercialPorfraccion());
		if (instance.getAparcamientoComercialPorfraccion()!=null){
			excelRow.add( this.getMessage("forms.accesibilidadpublicos.columns.aparcamientoComercialPorfraccion." + instance.getAparcamientoComercialPorfraccion(), locale) );
		}else{
			excelRow.add("null");
		}	

		excelRow.add(instance.getAparcamientoObservaciones());

		//excelRow.add(instance.getAparcamientoOtrosusosMinimoaparcamientosUnamasporfraccion());
		if (instance.getAparcamientoOtrosusosMinimoaparcamientosUnamasporfraccion()!=null){
			excelRow.add( this.getMessage("forms.accesibilidadpublicos.columns.aparcamientoOtrosusosMinimoaparcamientosUnamasporfraccion." + instance.getAparcamientoOtrosusosMinimoaparcamientosUnamasporfraccion(), locale) );
		}else{
			excelRow.add("null");
		}	

		//excelRow.add(instance.getAparcamientoOtrosusosMinimoaparcamientosUnaporfraccion());
		if (instance.getAparcamientoOtrosusosMinimoaparcamientosUnaporfraccion()!=null){
			excelRow.add( this.getMessage("forms.accesibilidadpublicos.columns.aparcamientoOtrosusosMinimoaparcamientosUnaporfraccion." + instance.getAparcamientoOtrosusosMinimoaparcamientosUnaporfraccion(), locale) );
		}else{
			excelRow.add("null");
		}	

		//excelRow.add(instance.getAparcamientoResidencialpublicoPoralojamiento());
		if (instance.getAparcamientoResidencialpublicoPoralojamiento()!=null){
			excelRow.add( this.getMessage("forms.accesibilidadpublicos.columns.aparcamientoResidencialpublicoPoralojamiento." + instance.getAparcamientoResidencialpublicoPoralojamiento(), locale) );
		}else{
			excelRow.add("null");
		}	

		//excelRow.add(instance.getAparcamientoSillaruedas());
		if (instance.getAparcamientoSillaruedas()!=null){
			excelRow.add( this.getMessage("forms.accesibilidadpublicos.columns.aparcamientoSillaruedas." + instance.getAparcamientoSillaruedas(), locale) );
		}else{
			excelRow.add("null");
		}	

		//excelRow.add(FormData2Java.toString(instance.getEntreplantasAccesible()));
		if (instance.getEntreplantasAccesible()!=null){
			excelRow.add( this.getMessage("forms.accesibilidadpublicos.columns.entreplantasAccesible." + instance.getEntreplantasAccesible(), locale) );
		}else{
			excelRow.add("null");
		}	

		//excelRow.add(instance.getEntreplantasAccesibleAscensornoaccesible());
		if (instance.getEntreplantasAccesibleAscensornoaccesible()!=null){
			excelRow.add( this.getMessage("forms.accesibilidadpublicos.columns.entreplantasAccesibleAscensornoaccesible." + instance.getEntreplantasAccesibleAscensornoaccesible(), locale) );
		}else{
			excelRow.add("null");
		}	

		excelRow.add(instance.getEntreplantasAccesibleAscensornoaccesibleDimensiones());

		//excelRow.add(instance.getEntreplantasAccesibleAscensororampaaccesible());
		if (instance.getEntreplantasAccesibleAscensororampaaccesible()!=null){
			excelRow.add( this.getMessage("forms.accesibilidadpublicos.columns.entreplantasAccesibleAscensororampaaccesible." + instance.getEntreplantasAccesibleAscensororampaaccesible(), locale) );
		}else{
			excelRow.add("null");
		}	

		//excelRow.add(instance.getEntreplantasAccesibleRampaascensornoaccesible());
		if (instance.getEntreplantasAccesibleRampaascensornoaccesible()!=null){
			excelRow.add( this.getMessage("forms.accesibilidadpublicos.columns.entreplantasAccesibleRampaascensornoaccesible." + instance.getEntreplantasAccesibleRampaascensornoaccesible(), locale) );
		}else{
			excelRow.add("null");
		}	

		//excelRow.add(FormData2Java.toString(instance.getEntreplantasElementosaccesibles()));
		if (instance.getEntreplantasElementosaccesibles()!=null){
			excelRow.add( this.getMessage("forms.accesibilidadpublicos.columns.entreplantasElementosaccesibles." + instance.getEntreplantasElementosaccesibles(), locale) );
		}else{
			excelRow.add("null");
		}	

		//excelRow.add(instance.getEntreplantasElementosaccesiblesAscensornoaccesible());
		if (instance.getEntreplantasElementosaccesiblesAscensornoaccesible()!=null){
			excelRow.add( this.getMessage("forms.accesibilidadpublicos.columns.entreplantasElementosaccesiblesAscensornoaccesible." + instance.getEntreplantasElementosaccesiblesAscensornoaccesible(), locale) );
		}else{
			excelRow.add("null");
		}	

		excelRow.add(instance.getEntreplantasElementosaccesiblesAscensornoaccesibleDimensione());

		//excelRow.add(instance.getEntreplantasElementosaccesiblesAscensororampaaccesible());
		if (instance.getEntreplantasElementosaccesiblesAscensororampaaccesible()!=null){
			excelRow.add( this.getMessage("forms.accesibilidadpublicos.columns.entreplantasElementosaccesiblesAscensororampaaccesible." + instance.getEntreplantasElementosaccesiblesAscensororampaaccesible(), locale) );
		}else{
			excelRow.add("null");
		}	

		//excelRow.add(instance.getEntreplantasElementosaccesiblesRampaascensornoaccesible());
		if (instance.getEntreplantasElementosaccesiblesRampaascensornoaccesible()!=null){
			excelRow.add( this.getMessage("forms.accesibilidadpublicos.columns.entreplantasElementosaccesiblesRampaascensornoaccesible." + instance.getEntreplantasElementosaccesiblesRampaascensornoaccesible(), locale) );
		}else{
			excelRow.add("null");
		}	

		//excelRow.add(FormData2Java.toString(instance.getEntreplantasNoaccesible()));
		if (instance.getEntreplantasNoaccesible()!=null){
			excelRow.add( this.getMessage("forms.accesibilidadpublicos.columns.entreplantasNoaccesible." + instance.getEntreplantasNoaccesible(), locale) );
		}else{
			excelRow.add("null");
		}	

		//excelRow.add(instance.getEntreplantasNoaccesibleAscensornoaccesible());
		if (instance.getEntreplantasNoaccesibleAscensornoaccesible()!=null){
			excelRow.add( this.getMessage("forms.accesibilidadpublicos.columns.entreplantasNoaccesibleAscensornoaccesible." + instance.getEntreplantasNoaccesibleAscensornoaccesible(), locale) );
		}else{
			excelRow.add("null");
		}	

		excelRow.add(instance.getEntreplantasNoaccesibleAscensornoaccesibleDimensiones());

		//excelRow.add(instance.getEntreplantasNoaccesibleAscensororampaaccesible());
		if (instance.getEntreplantasNoaccesibleAscensororampaaccesible()!=null){
			excelRow.add( this.getMessage("forms.accesibilidadpublicos.columns.entreplantasNoaccesibleAscensororampaaccesible." + instance.getEntreplantasNoaccesibleAscensororampaaccesible(), locale) );
		}else{
			excelRow.add("null");
		}	

		//excelRow.add(instance.getEntreplantasNoaccesibleRampaascensornoaccesible());
		if (instance.getEntreplantasNoaccesibleRampaascensornoaccesible()!=null){
			excelRow.add( this.getMessage("forms.accesibilidadpublicos.columns.entreplantasNoaccesibleRampaascensornoaccesible." + instance.getEntreplantasNoaccesibleRampaascensornoaccesible(), locale) );
		}else{
			excelRow.add("null");
		}	

		excelRow.add(instance.getEntreplantasObservaciones());

		//excelRow.add(FormData2Java.toString(instance.getEntreplantasZonasusopublico()));
		if (instance.getEntreplantasZonasusopublico()!=null){
			excelRow.add( this.getMessage("forms.accesibilidadpublicos.columns.entreplantasZonasusopublico." + instance.getEntreplantasZonasusopublico(), locale) );
		}else{
			excelRow.add("null");
		}	

		//excelRow.add(instance.getEntreplantasZonasusopublicoAscensornoaccesible());
		if (instance.getEntreplantasZonasusopublicoAscensornoaccesible()!=null){
			excelRow.add( this.getMessage("forms.accesibilidadpublicos.columns.entreplantasZonasusopublicoAscensornoaccesible." + instance.getEntreplantasZonasusopublicoAscensornoaccesible(), locale) );
		}else{
			excelRow.add("null");
		}	

		//excelRow.add(instance.getEntreplantasZonasusopublicoAscensornoaccesibleDimensiones());
		if (instance.getEntreplantasZonasusopublicoAscensornoaccesibleDimensiones()!=null){
			excelRow.add( this.getMessage("forms.accesibilidadpublicos.columns.entreplantasZonasusopublicoAscensornoaccesibleDimensiones." + instance.getEntreplantasZonasusopublicoAscensornoaccesibleDimensiones(), locale) );
		}else{
			excelRow.add("null");
		}	

		//excelRow.add(instance.getEntreplantasZonasusopublicoAscensororampaaccesible());
		if (instance.getEntreplantasZonasusopublicoAscensororampaaccesible()!=null){
			excelRow.add( this.getMessage("forms.accesibilidadpublicos.columns.entreplantasZonasusopublicoAscensororampaaccesible." + instance.getEntreplantasZonasusopublicoAscensororampaaccesible(), locale) );
		}else{
			excelRow.add("null");
		}	

		//excelRow.add(instance.getEntreplantasZonasusopublicoRampaascensornoaccesible());
		if (instance.getEntreplantasZonasusopublicoRampaascensornoaccesible()!=null){
			excelRow.add( this.getMessage("forms.accesibilidadpublicos.columns.entreplantasZonasusopublicoRampaascensornoaccesible." + instance.getEntreplantasZonasusopublicoRampaascensornoaccesible(), locale) );
		}else{
			excelRow.add("null");
		}	

		//excelRow.add(FormData2Java.toString(instance.getEsTecnicoInspeccion()));
		if (instance.getEsTecnicoInspeccion()!=null){
			excelRow.add( this.getMessage("forms.accesibilidadpublicos.columns.esTecnicoInspeccion." + instance.getEsTecnicoInspeccion(), locale) );
		}else{
			excelRow.add("null");
		}	

		//excelRow.add(FormData2Java.toString(instance.getExteriorEdificioitinerarioaccesibleViapublica()));
		if (instance.getExteriorEdificioitinerarioaccesibleViapublica()!=null){
			excelRow.add( this.getMessage("forms.accesibilidadpublicos.columns.exteriorEdificioitinerarioaccesibleViapublica." + instance.getExteriorEdificioitinerarioaccesibleViapublica(), locale) );
		}else{
			excelRow.add("null");
		}	

		//excelRow.add(FormData2Java.toString(instance.getExteriorEdificioitinerarioaccesibleZonascomunes()));
		if (instance.getExteriorEdificioitinerarioaccesibleZonascomunes()!=null){
			excelRow.add( this.getMessage("forms.accesibilidadpublicos.columns.exteriorEdificioitinerarioaccesibleZonascomunes." + instance.getExteriorEdificioitinerarioaccesibleZonascomunes(), locale) );
		}else{
			excelRow.add("null");
		}	

		excelRow.add(instance.getExteriorObservaciones());

		//excelRow.add(instance.getInformacionsenalizacionAscensores());
		if (instance.getInformacionsenalizacionAscensores()!=null){
			excelRow.add( this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionAscensores." + instance.getInformacionsenalizacionAscensores(), locale) );
		}else{
			excelRow.add("null");
		}	

		//excelRow.add(instance.getInformacionsenalizacionAscensoresBrailearabigo());
		if (instance.getInformacionsenalizacionAscensoresBrailearabigo()!=null){
			excelRow.add( this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionAscensoresBrailearabigo." + instance.getInformacionsenalizacionAscensoresBrailearabigo(), locale) );
		}else{
			excelRow.add("null");
		}	

		//excelRow.add(instance.getInformacionsenalizacionAscensoresNumeroplanta());
		if (instance.getInformacionsenalizacionAscensoresNumeroplanta()!=null){
			excelRow.add( this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionAscensoresNumeroplanta." + instance.getInformacionsenalizacionAscensoresNumeroplanta(), locale) );
		}else{
			excelRow.add("null");
		}	

		//excelRow.add(instance.getInformacionsenalizacionBandasvisualestactiles());
		if (instance.getInformacionsenalizacionBandasvisualestactiles()!=null){
			excelRow.add( this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionBandasvisualestactiles." + instance.getInformacionsenalizacionBandasvisualestactiles(), locale) );
		}else{
			excelRow.add("null");
		}	

		//excelRow.add(instance.getInformacionsenalizacionBandasvisualestactilesArranqueescalera());
		if (instance.getInformacionsenalizacionBandasvisualestactilesArranqueescalera()!=null){
			excelRow.add( this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionBandasvisualestactilesArranqueescalera." + instance.getInformacionsenalizacionBandasvisualestactilesArranqueescalera(), locale) );
		}else{
			excelRow.add("null");
		}	

		//excelRow.add(instance.getInformacionsenalizacionBandasvisualestactilesColorcontrastado());
		if (instance.getInformacionsenalizacionBandasvisualestactilesColorcontrastado()!=null){
			excelRow.add( this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionBandasvisualestactilesColorcontrastado." + instance.getInformacionsenalizacionBandasvisualestactilesColorcontrastado(), locale) );
		}else{
			excelRow.add("null");
		}	

		//excelRow.add(instance.getInformacionsenalizacionBandasvisualestactilesItinerarioaccesi());
		if (instance.getInformacionsenalizacionBandasvisualestactilesItinerarioaccesi()!=null){
			excelRow.add( this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionBandasvisualestactilesItinerarioaccesi." + instance.getInformacionsenalizacionBandasvisualestactilesItinerarioaccesi(), locale) );
		}else{
			excelRow.add("null");
		}	

		//excelRow.add(instance.getInformacionsenalizacionBandasvisualestactilesRelieveexterior());
		if (instance.getInformacionsenalizacionBandasvisualestactilesRelieveexterior()!=null){
			excelRow.add( this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionBandasvisualestactilesRelieveexterior." + instance.getInformacionsenalizacionBandasvisualestactilesRelieveexterior(), locale) );
		}else{
			excelRow.add("null");
		}	

		//excelRow.add(instance.getInformacionsenalizacionBandasvisualestactilesRelieveinterior());
		if (instance.getInformacionsenalizacionBandasvisualestactilesRelieveinterior()!=null){
			excelRow.add( this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionBandasvisualestactilesRelieveinterior." + instance.getInformacionsenalizacionBandasvisualestactilesRelieveinterior(), locale) );
		}else{
			excelRow.add("null");
		}	

		//excelRow.add(instance.getInformacionsenalizacionBuclemagnetico());
		if (instance.getInformacionsenalizacionBuclemagnetico()!=null){
			excelRow.add( this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionBuclemagnetico." + instance.getInformacionsenalizacionBuclemagnetico(), locale) );
		}else{
			excelRow.add("null");
		}	

		//excelRow.add(instance.getInformacionsenalizacionBuclemagneticoSenalizado());
		if (instance.getInformacionsenalizacionBuclemagneticoSenalizado()!=null){
			excelRow.add( this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionBuclemagneticoSenalizado." + instance.getInformacionsenalizacionBuclemagneticoSenalizado(), locale) );
		}else{
			excelRow.add("null");
		}	

		excelRow.add(instance.getInformacionsenalizacionObservaciones());

		//excelRow.add(instance.getInformacionsenalizacionPrivadoSiaAparcamiento());
		if (instance.getInformacionsenalizacionPrivadoSiaAparcamiento()!=null){
			excelRow.add( this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionPrivadoSiaAparcamiento." + instance.getInformacionsenalizacionPrivadoSiaAparcamiento(), locale) );
		}else{
			excelRow.add("null");
		}	

		//excelRow.add(instance.getInformacionsenalizacionPrivadoSiaAscensores());
		if (instance.getInformacionsenalizacionPrivadoSiaAscensores()!=null){
			excelRow.add( this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionPrivadoSiaAscensores." + instance.getInformacionsenalizacionPrivadoSiaAscensores(), locale) );
		}else{
			excelRow.add("null");
		}	

		//excelRow.add(instance.getInformacionsenalizacionPrivadoSiaEntradas());
		if (instance.getInformacionsenalizacionPrivadoSiaEntradas()!=null){
			excelRow.add( this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionPrivadoSiaEntradas." + instance.getInformacionsenalizacionPrivadoSiaEntradas(), locale) );
		}else{
			excelRow.add("null");
		}	

		//excelRow.add(instance.getInformacionsenalizacionPrivadoSiaItinerarios());
		if (instance.getInformacionsenalizacionPrivadoSiaItinerarios()!=null){
			excelRow.add( this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionPrivadoSiaItinerarios." + instance.getInformacionsenalizacionPrivadoSiaItinerarios(), locale) );
		}else{
			excelRow.add("null");
		}	

		//excelRow.add(instance.getInformacionsenalizacionPrivadoSiaPlazasreservadas());
		if (instance.getInformacionsenalizacionPrivadoSiaPlazasreservadas()!=null){
			excelRow.add( this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionPrivadoSiaPlazasreservadas." + instance.getInformacionsenalizacionPrivadoSiaPlazasreservadas(), locale) );
		}else{
			excelRow.add("null");
		}	

		//excelRow.add(instance.getInformacionsenalizacionPublicoSiaAparcamiento());
		if (instance.getInformacionsenalizacionPublicoSiaAparcamiento()!=null){
			excelRow.add( this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionPublicoSiaAparcamiento." + instance.getInformacionsenalizacionPublicoSiaAparcamiento(), locale) );
		}else{
			excelRow.add("null");
		}	

		//excelRow.add(instance.getInformacionsenalizacionPublicoSiaAscensores());
		if (instance.getInformacionsenalizacionPublicoSiaAscensores()!=null){
			excelRow.add( this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionPublicoSiaAscensores." + instance.getInformacionsenalizacionPublicoSiaAscensores(), locale) );
		}else{
			excelRow.add("null");
		}	

		//excelRow.add(instance.getInformacionsenalizacionPublicoSiaEntradas());
		if (instance.getInformacionsenalizacionPublicoSiaEntradas()!=null){
			excelRow.add( this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionPublicoSiaEntradas." + instance.getInformacionsenalizacionPublicoSiaEntradas(), locale) );
		}else{
			excelRow.add("null");
		}	

		//excelRow.add(instance.getInformacionsenalizacionPublicoSiaItinerarios());
		if (instance.getInformacionsenalizacionPublicoSiaItinerarios()!=null){
			excelRow.add( this.getMessage("forms.accesibilidadpublicos.columns.." + instance.getInformacionsenalizacionPublicoSiaItinerarios(), locale) );
		}else{
			excelRow.add("null");
		}	

		//excelRow.add(instance.getInformacionsenalizacionPublicoSiaPlazasreservadas());
		if (instance.getInformacionsenalizacionPublicoSiaPlazasreservadas()!=null){
			excelRow.add( this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionPublicoSiaPlazasreservadas." + instance.getInformacionsenalizacionPublicoSiaPlazasreservadas(), locale) );
		}else{
			excelRow.add("null");
		}	

		//excelRow.add(instance.getInformacionsenalizacionPublicoSiaPuntosatencion());
		if (instance.getInformacionsenalizacionPublicoSiaPuntosatencion()!=null){
			excelRow.add( this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionPublicoSiaPuntosatencion." + instance.getInformacionsenalizacionPublicoSiaPuntosatencion(), locale) );
		}else{
			excelRow.add("null");
		}	

		//excelRow.add(instance.getInformacionsenalizacionPublicoSiaServicioshigienicos());
		if (instance.getInformacionsenalizacionPublicoSiaServicioshigienicos()!=null){
			excelRow.add( this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionPublicoSiaServicioshigienicos." + instance.getInformacionsenalizacionPublicoSiaServicioshigienicos(), locale) );
		}else{
			excelRow.add("null");
		}	

		//excelRow.add(instance.getInformacionsenalizacionServicioshigienicossenalizados());
		if (instance.getInformacionsenalizacionServicioshigienicossenalizados()!=null){
			excelRow.add( this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionServicioshigienicossenalizados." + instance.getInformacionsenalizacionServicioshigienicossenalizados(), locale) );
		}else{
			excelRow.add("null");
		}	

		//excelRow.add(instance.getInformacionsenalizacionSianorma());
		if (instance.getInformacionsenalizacionSianorma()!=null){
			excelRow.add( this.getMessage("forms.accesibilidadpublicos.columns.informacionsenalizacionSianorma." + instance.getInformacionsenalizacionSianorma(), locale) );
		}else{
			excelRow.add("null");
		}	

		excelRow.add(instance.getInformacionsenalizacionTodosusosObservaciones());

		//excelRow.add(instance.getMecanismosAccesibles());
		if (instance.getMecanismosAccesibles()!=null){
			excelRow.add( this.getMessage("forms.accesibilidadpublicos.columns.mecanismosAccesibles." + instance.getMecanismosAccesibles(), locale) );
		}else{
			excelRow.add("null");
		}	

		excelRow.add(instance.getMecanismosObservaciones());
		excelRow.add(instance.getMobiliariofijoObservaciones());

		//excelRow.add(instance.getMobiliariofijoPuntoaccesible());
		if (instance.getMobiliariofijoPuntoaccesible()!=null){
			excelRow.add( this.getMessage("forms.accesibilidadpublicos.columns.mobiliariofijoPuntoaccesible." + instance.getMobiliariofijoPuntoaccesible(), locale) );
		}else{
			excelRow.add("null");
		}	

		excelRow.add(instance.getNif());
		//excelRow.add(instance.getPiscinasEntradaaccesible());
		if (instance.getPiscinasEntradaaccesible()!=null){
			excelRow.add( this.getMessage("forms.accesibilidadpublicos.columns.piscinasEntradaaccesible." + instance.getPiscinasEntradaaccesible(), locale) );
		}else{
			excelRow.add("null");
		}	

		excelRow.add(instance.getPiscinasObservaciones());
		//excelRow.add(FormData2Java.toString(instance.getPlantasItinerarioaccesibleElementosaccesibles()));
		if (instance.getPlantasItinerarioaccesibleElementosaccesibles()!=null){
			excelRow.add( this.getMessage("forms.accesibilidadpublicos.columns.plantasItinerarioaccesibleElementosaccesibles." + instance.getPlantasItinerarioaccesibleElementosaccesibles(), locale) );
		}else{
			excelRow.add("null");
		}	

		//excelRow.add(FormData2Java.toString(instance.getPlantasItinerarioaccesibleEntresi()));
		if (instance.getPlantasItinerarioaccesibleEntresi()!=null){
			excelRow.add( this.getMessage("forms.accesibilidadpublicos.columns.plantasItinerarioaccesibleEntresi." + instance.getPlantasItinerarioaccesibleEntresi(), locale) );
		}else{
			excelRow.add("null");
		}	

		excelRow.add(instance.getPlantasItinerarioaccesibleObservaciones());

		//excelRow.add(FormData2Java.toString(instance.getPlantasItinerarioaccesibleZonasusoprivado()));
		if (instance.getPlantasItinerarioaccesibleZonasusoprivado()!=null){
			excelRow.add( this.getMessage("forms.accesibilidadpublicos.columns.plantasItinerarioaccesibleZonasusoprivado." + instance.getPlantasItinerarioaccesibleZonasusoprivado(), locale) );
		}else{
			excelRow.add("null");
		}	

		//excelRow.add(FormData2Java.toString(instance.getPlantasItinerarioaccesibleZonasusopublico()));
		if (instance.getPlantasItinerarioaccesibleZonasusopublico()!=null){
			excelRow.add( this.getMessage("forms.accesibilidadpublicos.columns.plantasItinerarioaccesibleZonasusopublico." + instance.getPlantasItinerarioaccesibleZonasusopublico(), locale) );
		}else{
			excelRow.add("null");
		}	

		//excelRow.add(instance.getPlazasreservadasDiscapacidadauditiva());
		if (instance.getPlazasreservadasDiscapacidadauditiva()!=null){
			excelRow.add( this.getMessage("forms.accesibilidadpublicos.columns.plazasreservadasDiscapacidadauditiva." + instance.getPlazasreservadasDiscapacidadauditiva(), locale) );
		}else{
			excelRow.add("null");
		}	

		excelRow.add(instance.getPlazasreservadasObservaciones());

		//excelRow.add(instance.getPlazasreservadasSillaruedas());
		if (instance.getPlazasreservadasSillaruedas()!=null){
			excelRow.add( this.getMessage("forms.accesibilidadpublicos.columns.plazasreservadasSillaruedas." + instance.getPlazasreservadasSillaruedas(), locale) );
		}else{
			excelRow.add("null");
		}	

		//excelRow.add(instance.getPlazasreservadasZonaesperaSillaruedas());
		if (instance.getPlazasreservadasZonaesperaSillaruedas()!=null){
			excelRow.add( this.getMessage("forms.accesibilidadpublicos.columns.plazasreservadasZonaesperaSillaruedas." + instance.getPlazasreservadasZonaesperaSillaruedas(), locale) );
		}else{
			excelRow.add("null");
		}	

		//excelRow.add(instance.getServicioshigienicosAseoaccesible());
		if (instance.getServicioshigienicosCabinaduchaaccesibles()!=null){
			excelRow.add( this.getMessage("forms.accesibilidadpublicos.columns.servicioshigienicosAseoaccesible." + instance.getServicioshigienicosAseoaccesible(), locale) );
		}else{
			excelRow.add("null");
		}	

		//excelRow.add(instance.getServicioshigienicosCabinaduchaaccesibles());
		if (instance.getServicioshigienicosCabinaduchaaccesibles()!=null){
			excelRow.add( this.getMessage("forms.accesibilidadpublicos.columns.servicioshigienicosCabinaduchaaccesibles." + instance.getServicioshigienicosCabinaduchaaccesibles(), locale) );
		}else{
			excelRow.add("null");
		}	

		excelRow.add(instance.getServicioshigienicosObservaciones());
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
	 * Rellena una instancia de AccesibilidadPublicosFormVO con el contenido de
	 * un formulario recibido en formato Map<String, ?>
	 */
	protected void setFormData(AccesibilidadPublicosFormVO record, Map<String, ?> formData) throws GenericBusinessException {
		String formDataStr = null;
		if (!StringUtils.isEmpty(formData, "inspeccionId")) {
			formDataStr = (String) formData.get("inspeccionId");
			record.setInspeccionId(FormData2Java.toInteger(formDataStr));

		}
		if (formData.containsKey("alojamientosaccesibles1porcada50")) {
			formDataStr = (String) formData.get("alojamientosaccesibles1porcada50");
			record.setAlojamientosaccesibles1porcada50(formDataStr);
		}
		if (formData.containsKey("alojamientosaccesiblesMinimo1")) {
			formDataStr = (String) formData.get("alojamientosaccesiblesMinimo1");
			record.setAlojamientosaccesiblesMinimo1(formDataStr);
		}
		if (formData.containsKey("alojamientosaccesiblesMinimo2")) {
			formDataStr = (String) formData.get("alojamientosaccesiblesMinimo2");
			record.setAlojamientosaccesiblesMinimo2(formDataStr);
		}
		if (formData.containsKey("alojamientosaccesiblesMinimo4")) {
			formDataStr = (String) formData.get("alojamientosaccesiblesMinimo4");
			record.setAlojamientosaccesiblesMinimo4(formDataStr);
		}
		if (formData.containsKey("alojamientosaccesiblesMinimo6")) {
			formDataStr = (String) formData.get("alojamientosaccesiblesMinimo6");
			record.setAlojamientosaccesiblesMinimo6(formDataStr);
		}
		if (formData.containsKey("alojamientosaccesiblesMinimo8")) {
			formDataStr = (String) formData.get("alojamientosaccesiblesMinimo8");
			record.setAlojamientosaccesiblesMinimo8(formDataStr);
		}
		if (formData.containsKey("alojamientosaccesiblesObservaciones")) {
			formDataStr = (String) formData.get("alojamientosaccesiblesObservaciones");
			record.setAlojamientosaccesiblesObservaciones(formDataStr);
		}
		if (formData.containsKey("aparcamientoComercialPorfraccion")) {
			formDataStr = (String) formData.get("aparcamientoComercialPorfraccion");
			record.setAparcamientoComercialPorfraccion(formDataStr);
		}
		if (formData.containsKey("aparcamientoObservaciones")) {
			formDataStr = (String) formData.get("aparcamientoObservaciones");
			record.setAparcamientoObservaciones(formDataStr);
		}
		if (formData.containsKey("aparcamientoOtrosusosMinimoaparcamientosUnamasporfraccion")) {
			formDataStr = (String) formData.get("aparcamientoOtrosusosMinimoaparcamientosUnamasporfraccion");
			record.setAparcamientoOtrosusosMinimoaparcamientosUnamasporfraccion(formDataStr);
		}
		if (formData.containsKey("aparcamientoOtrosusosMinimoaparcamientosUnaporfraccion")) {
			formDataStr = (String) formData.get("aparcamientoOtrosusosMinimoaparcamientosUnaporfraccion");
			record.setAparcamientoOtrosusosMinimoaparcamientosUnaporfraccion(formDataStr);
		}
		if (formData.containsKey("aparcamientoResidencialpublicoPoralojamiento")) {
			formDataStr = (String) formData.get("aparcamientoResidencialpublicoPoralojamiento");
			record.setAparcamientoResidencialpublicoPoralojamiento(formDataStr);
		}
		if (formData.containsKey("aparcamientoSillaruedas")) {
			formDataStr = (String) formData.get("aparcamientoSillaruedas");
			record.setAparcamientoSillaruedas(formDataStr);
		}
		if (formData.containsKey("entreplantasAccesible")) {
			formDataStr = (String) formData.get("entreplantasAccesible");
			record.setEntreplantasAccesible(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("entreplantasAccesibleAscensornoaccesible")) {
			formDataStr = (String) formData.get("entreplantasAccesibleAscensornoaccesible");
			record.setEntreplantasAccesibleAscensornoaccesible(formDataStr);
		}
		if (formData.containsKey("entreplantasAccesibleAscensornoaccesibleDimensiones")) {
			formDataStr = (String) formData.get("entreplantasAccesibleAscensornoaccesibleDimensiones");
			record.setEntreplantasAccesibleAscensornoaccesibleDimensiones(formDataStr);
		}
		if (formData.containsKey("entreplantasAccesibleAscensororampaaccesible")) {
			formDataStr = (String) formData.get("entreplantasAccesibleAscensororampaaccesible");
			record.setEntreplantasAccesibleAscensororampaaccesible(formDataStr);
		}
		if (formData.containsKey("entreplantasAccesibleRampaascensornoaccesible")) {
			formDataStr = (String) formData.get("entreplantasAccesibleRampaascensornoaccesible");
			record.setEntreplantasAccesibleRampaascensornoaccesible(formDataStr);
		}
		if (formData.containsKey("entreplantasElementosaccesibles")) {
			formDataStr = (String) formData.get("entreplantasElementosaccesibles");
			record.setEntreplantasElementosaccesibles(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("entreplantasElementosaccesiblesAscensornoaccesible")) {
			formDataStr = (String) formData.get("entreplantasElementosaccesiblesAscensornoaccesible");
			record.setEntreplantasElementosaccesiblesAscensornoaccesible(formDataStr);
		}
		if (formData.containsKey("entreplantasElementosaccesiblesAscensornoaccesibleDimensione")) {
			formDataStr = (String) formData.get("entreplantasElementosaccesiblesAscensornoaccesibleDimensione");
			record.setEntreplantasElementosaccesiblesAscensornoaccesibleDimensione(formDataStr);
		}
		if (formData.containsKey("entreplantasElementosaccesiblesAscensororampaaccesible")) {
			formDataStr = (String) formData.get("entreplantasElementosaccesiblesAscensororampaaccesible");
			record.setEntreplantasElementosaccesiblesAscensororampaaccesible(formDataStr);
		}
		if (formData.containsKey("entreplantasElementosaccesiblesRampaascensornoaccesible")) {
			formDataStr = (String) formData.get("entreplantasElementosaccesiblesRampaascensornoaccesible");
			record.setEntreplantasElementosaccesiblesRampaascensornoaccesible(formDataStr);
		}
		if (formData.containsKey("entreplantasNoaccesible")) {
			formDataStr = (String) formData.get("entreplantasNoaccesible");
			record.setEntreplantasNoaccesible(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("entreplantasNoaccesibleAscensornoaccesible")) {
			formDataStr = (String) formData.get("entreplantasNoaccesibleAscensornoaccesible");
			record.setEntreplantasNoaccesibleAscensornoaccesible(formDataStr);
		}
		if (formData.containsKey("entreplantasNoaccesibleAscensornoaccesibleDimensiones")) {
			formDataStr = (String) formData.get("entreplantasNoaccesibleAscensornoaccesibleDimensiones");
			record.setEntreplantasNoaccesibleAscensornoaccesibleDimensiones(formDataStr);
		}
		if (formData.containsKey("entreplantasNoaccesibleAscensororampaaccesible")) {
			formDataStr = (String) formData.get("entreplantasNoaccesibleAscensororampaaccesible");
			record.setEntreplantasNoaccesibleAscensororampaaccesible(formDataStr);
		}
		if (formData.containsKey("entreplantasNoaccesibleRampaascensornoaccesible")) {
			formDataStr = (String) formData.get("entreplantasNoaccesibleRampaascensornoaccesible");
			record.setEntreplantasNoaccesibleRampaascensornoaccesible(formDataStr);
		}
		if (formData.containsKey("entreplantasObservaciones")) {
			formDataStr = (String) formData.get("entreplantasObservaciones");
			record.setEntreplantasObservaciones(formDataStr);
		}
		if (formData.containsKey("entreplantasZonasusopublico")) {
			formDataStr = (String) formData.get("entreplantasZonasusopublico");
			record.setEntreplantasZonasusopublico(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("entreplantasZonasusopublicoAscensornoaccesible")) {
			formDataStr = (String) formData.get("entreplantasZonasusopublicoAscensornoaccesible");
			record.setEntreplantasZonasusopublicoAscensornoaccesible(formDataStr);
		}
		if (formData.containsKey("entreplantasZonasusopublicoAscensornoaccesibleDimensiones")) {
			formDataStr = (String) formData.get("entreplantasZonasusopublicoAscensornoaccesibleDimensiones");
			record.setEntreplantasZonasusopublicoAscensornoaccesibleDimensiones(formDataStr);
		}
		if (formData.containsKey("entreplantasZonasusopublicoAscensororampaaccesible")) {
			formDataStr = (String) formData.get("entreplantasZonasusopublicoAscensororampaaccesible");
			record.setEntreplantasZonasusopublicoAscensororampaaccesible(formDataStr);
		}
		if (formData.containsKey("entreplantasZonasusopublicoRampaascensornoaccesible")) {
			formDataStr = (String) formData.get("entreplantasZonasusopublicoRampaascensornoaccesible");
			record.setEntreplantasZonasusopublicoRampaascensornoaccesible(formDataStr);
		}
		if (formData.containsKey("esTecnicoInspeccion")) {
			formDataStr = (String) formData.get("esTecnicoInspeccion");
			record.setEsTecnicoInspeccion(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("exteriorEdificioitinerarioaccesibleViapublica")) {
			formDataStr = (String) formData.get("exteriorEdificioitinerarioaccesibleViapublica");
			record.setExteriorEdificioitinerarioaccesibleViapublica(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("exteriorEdificioitinerarioaccesibleZonascomunes")) {
			formDataStr = (String) formData.get("exteriorEdificioitinerarioaccesibleZonascomunes");
			record.setExteriorEdificioitinerarioaccesibleZonascomunes(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("exteriorObservaciones")) {
			formDataStr = (String) formData.get("exteriorObservaciones");
			record.setExteriorObservaciones(formDataStr);
		}
		if (formData.containsKey("informacionsenalizacionAscensores")) {
			formDataStr = (String) formData.get("informacionsenalizacionAscensores");
			record.setInformacionsenalizacionAscensores(formDataStr);
		}
		if (formData.containsKey("informacionsenalizacionAscensoresBrailearabigo")) {
			formDataStr = (String) formData.get("informacionsenalizacionAscensoresBrailearabigo");
			record.setInformacionsenalizacionAscensoresBrailearabigo(formDataStr);
		}
		if (formData.containsKey("informacionsenalizacionAscensoresNumeroplanta")) {
			formDataStr = (String) formData.get("informacionsenalizacionAscensoresNumeroplanta");
			record.setInformacionsenalizacionAscensoresNumeroplanta(formDataStr);
		}
		if (formData.containsKey("informacionsenalizacionBandasvisualestactiles")) {
			formDataStr = (String) formData.get("informacionsenalizacionBandasvisualestactiles");
			record.setInformacionsenalizacionBandasvisualestactiles(formDataStr);
		}
		if (formData.containsKey("informacionsenalizacionBandasvisualestactilesArranqueescalera")) {
			formDataStr = (String) formData.get("informacionsenalizacionBandasvisualestactilesArranqueescalera");
			record.setInformacionsenalizacionBandasvisualestactilesArranqueescalera(formDataStr);
		}
		if (formData.containsKey("informacionsenalizacionBandasvisualestactilesColorcontrastado")) {
			formDataStr = (String) formData.get("informacionsenalizacionBandasvisualestactilesColorcontrastado");
			record.setInformacionsenalizacionBandasvisualestactilesColorcontrastado(formDataStr);
		}
		if (formData.containsKey("informacionsenalizacionBandasvisualestactilesItinerarioaccesi")) {
			formDataStr = (String) formData.get("informacionsenalizacionBandasvisualestactilesItinerarioaccesi");
			record.setInformacionsenalizacionBandasvisualestactilesItinerarioaccesi(formDataStr);
		}
		if (formData.containsKey("informacionsenalizacionBandasvisualestactilesRelieveexterior")) {
			formDataStr = (String) formData.get("informacionsenalizacionBandasvisualestactilesRelieveexterior");
			record.setInformacionsenalizacionBandasvisualestactilesRelieveexterior(formDataStr);
		}
		if (formData.containsKey("informacionsenalizacionBandasvisualestactilesRelieveinterior")) {
			formDataStr = (String) formData.get("informacionsenalizacionBandasvisualestactilesRelieveinterior");
			record.setInformacionsenalizacionBandasvisualestactilesRelieveinterior(formDataStr);
		}
		if (formData.containsKey("informacionsenalizacionBuclemagnetico")) {
			formDataStr = (String) formData.get("informacionsenalizacionBuclemagnetico");
			record.setInformacionsenalizacionBuclemagnetico(formDataStr);
		}
		if (formData.containsKey("informacionsenalizacionBuclemagneticoSenalizado")) {
			formDataStr = (String) formData.get("informacionsenalizacionBuclemagneticoSenalizado");
			record.setInformacionsenalizacionBuclemagneticoSenalizado(formDataStr);
		}
		if (formData.containsKey("informacionsenalizacionObservaciones")) {
			formDataStr = (String) formData.get("informacionsenalizacionObservaciones");
			record.setInformacionsenalizacionObservaciones(formDataStr);
		}
		if (formData.containsKey("informacionsenalizacionPrivadoSiaAparcamiento")) {
			formDataStr = (String) formData.get("informacionsenalizacionPrivadoSiaAparcamiento");
			record.setInformacionsenalizacionPrivadoSiaAparcamiento(formDataStr);
		}
		if (formData.containsKey("informacionsenalizacionPrivadoSiaAscensores")) {
			formDataStr = (String) formData.get("informacionsenalizacionPrivadoSiaAscensores");
			record.setInformacionsenalizacionPrivadoSiaAscensores(formDataStr);
		}
		if (formData.containsKey("informacionsenalizacionPrivadoSiaEntradas")) {
			formDataStr = (String) formData.get("informacionsenalizacionPrivadoSiaEntradas");
			record.setInformacionsenalizacionPrivadoSiaEntradas(formDataStr);
		}
		if (formData.containsKey("informacionsenalizacionPrivadoSiaItinerarios")) {
			formDataStr = (String) formData.get("informacionsenalizacionPrivadoSiaItinerarios");
			record.setInformacionsenalizacionPrivadoSiaItinerarios(formDataStr);
		}
		if (formData.containsKey("informacionsenalizacionPrivadoSiaPlazasreservadas")) {
			formDataStr = (String) formData.get("informacionsenalizacionPrivadoSiaPlazasreservadas");
			record.setInformacionsenalizacionPrivadoSiaPlazasreservadas(formDataStr);
		}
		if (formData.containsKey("informacionsenalizacionPublicoSiaAparcamiento")) {
			formDataStr = (String) formData.get("informacionsenalizacionPublicoSiaAparcamiento");
			record.setInformacionsenalizacionPublicoSiaAparcamiento(formDataStr);
		}
		if (formData.containsKey("informacionsenalizacionPublicoSiaAscensores")) {
			formDataStr = (String) formData.get("informacionsenalizacionPublicoSiaAscensores");
			record.setInformacionsenalizacionPublicoSiaAscensores(formDataStr);
		}
		if (formData.containsKey("informacionsenalizacionPublicoSiaEntradas")) {
			formDataStr = (String) formData.get("informacionsenalizacionPublicoSiaEntradas");
			record.setInformacionsenalizacionPublicoSiaEntradas(formDataStr);
		}
		if (formData.containsKey("informacionsenalizacionPublicoSiaItinerarios")) {
			formDataStr = (String) formData.get("informacionsenalizacionPublicoSiaItinerarios");
			record.setInformacionsenalizacionPublicoSiaItinerarios(formDataStr);
		}
		if (formData.containsKey("informacionsenalizacionPublicoSiaPlazasreservadas")) {
			formDataStr = (String) formData.get("informacionsenalizacionPublicoSiaPlazasreservadas");
			record.setInformacionsenalizacionPublicoSiaPlazasreservadas(formDataStr);
		}
		if (formData.containsKey("informacionsenalizacionPublicoSiaPuntosatencion")) {
			formDataStr = (String) formData.get("informacionsenalizacionPublicoSiaPuntosatencion");
			record.setInformacionsenalizacionPublicoSiaPuntosatencion(formDataStr);
		}
		if (formData.containsKey("informacionsenalizacionPublicoSiaServicioshigienicos")) {
			formDataStr = (String) formData.get("informacionsenalizacionPublicoSiaServicioshigienicos");
			record.setInformacionsenalizacionPublicoSiaServicioshigienicos(formDataStr);
		}
		if (formData.containsKey("informacionsenalizacionServicioshigienicossenalizados")) {
			formDataStr = (String) formData.get("informacionsenalizacionServicioshigienicossenalizados");
			record.setInformacionsenalizacionServicioshigienicossenalizados(formDataStr);
		}
		if (formData.containsKey("informacionsenalizacionSianorma")) {
			formDataStr = (String) formData.get("informacionsenalizacionSianorma");
			record.setInformacionsenalizacionSianorma(formDataStr);
		}
		if (formData.containsKey("informacionsenalizacionTodosusosObservaciones")) {
			formDataStr = (String) formData.get("informacionsenalizacionTodosusosObservaciones");
			record.setInformacionsenalizacionTodosusosObservaciones(formDataStr);
		}
		if (formData.containsKey("mecanismosAccesibles")) {
			formDataStr = (String) formData.get("mecanismosAccesibles");
			record.setMecanismosAccesibles(formDataStr);
		}
		if (formData.containsKey("mecanismosObservaciones")) {
			formDataStr = (String) formData.get("mecanismosObservaciones");
			record.setMecanismosObservaciones(formDataStr);
		}
		if (formData.containsKey("mobiliariofijoObservaciones")) {
			formDataStr = (String) formData.get("mobiliariofijoObservaciones");
			record.setMobiliariofijoObservaciones(formDataStr);
		}
		if (formData.containsKey("mobiliariofijoPuntoaccesible")) {
			formDataStr = (String) formData.get("mobiliariofijoPuntoaccesible");
			record.setMobiliariofijoPuntoaccesible(formDataStr);
		}
		if (formData.containsKey("nif")) {
			formDataStr = (String) formData.get("nif");
			record.setNif(formDataStr);
		}
		if (formData.containsKey("piscinasEntradaaccesible")) {
			formDataStr = (String) formData.get("piscinasEntradaaccesible");
			record.setPiscinasEntradaaccesible(formDataStr);
		}
		if (formData.containsKey("piscinasObservaciones")) {
			formDataStr = (String) formData.get("piscinasObservaciones");
			record.setPiscinasObservaciones(formDataStr);
		}
		if (formData.containsKey("plantasItinerarioaccesibleElementosaccesibles")) {
			formDataStr = (String) formData.get("plantasItinerarioaccesibleElementosaccesibles");
			record.setPlantasItinerarioaccesibleElementosaccesibles(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("plantasItinerarioaccesibleEntresi")) {
			formDataStr = (String) formData.get("plantasItinerarioaccesibleEntresi");
			record.setPlantasItinerarioaccesibleEntresi(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("plantasItinerarioaccesibleObservaciones")) {
			formDataStr = (String) formData.get("plantasItinerarioaccesibleObservaciones");
			record.setPlantasItinerarioaccesibleObservaciones(formDataStr);
		}
		if (formData.containsKey("plantasItinerarioaccesibleZonasusoprivado")) {
			formDataStr = (String) formData.get("plantasItinerarioaccesibleZonasusoprivado");
			record.setPlantasItinerarioaccesibleZonasusoprivado(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("plantasItinerarioaccesibleZonasusopublico")) {
			formDataStr = (String) formData.get("plantasItinerarioaccesibleZonasusopublico");
			record.setPlantasItinerarioaccesibleZonasusopublico(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("plazasreservadasDiscapacidadauditiva")) {
			formDataStr = (String) formData.get("plazasreservadasDiscapacidadauditiva");
			record.setPlazasreservadasDiscapacidadauditiva(formDataStr);
		}
		if (formData.containsKey("plazasreservadasObservaciones")) {
			formDataStr = (String) formData.get("plazasreservadasObservaciones");
			record.setPlazasreservadasObservaciones(formDataStr);
		}
		if (formData.containsKey("plazasreservadasSillaruedas")) {
			formDataStr = (String) formData.get("plazasreservadasSillaruedas");
			record.setPlazasreservadasSillaruedas(formDataStr);
		}
		if (formData.containsKey("plazasreservadasZonaesperaSillaruedas")) {
			formDataStr = (String) formData.get("plazasreservadasZonaesperaSillaruedas");
			record.setPlazasreservadasZonaesperaSillaruedas(formDataStr);
		}
		if (formData.containsKey("servicioshigienicosAseoaccesible")) {
			formDataStr = (String) formData.get("servicioshigienicosAseoaccesible");
			record.setServicioshigienicosAseoaccesible(formDataStr);
		}
		if (formData.containsKey("servicioshigienicosCabinaduchaaccesibles")) {
			formDataStr = (String) formData.get("servicioshigienicosCabinaduchaaccesibles");
			record.setServicioshigienicosCabinaduchaaccesibles(formDataStr);
		}
		if (formData.containsKey("servicioshigienicosObservaciones")) {
			formDataStr = (String) formData.get("servicioshigienicosObservaciones");
			record.setServicioshigienicosObservaciones(formDataStr);
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
