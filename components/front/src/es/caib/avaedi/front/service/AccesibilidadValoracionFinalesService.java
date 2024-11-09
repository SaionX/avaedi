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
import es.caib.avaedi.logic.bo.AccesibilidadValoracionFinalesBO;
import es.caib.avaedi.logic.bo.InspeccionBO;
import es.caib.avaedi.logic.util.Keys;
import es.caib.avaedi.logic.vo.AccesibilidadValoracionFinalesFormVO;
import es.caib.avaedi.logic.vo.AccesibilidadValoracionFinalesListadoVO;
import es.caib.avaedi.logic.vo.CimentacionesListadoVO;

/**
 * Servicio para tratar el formulario: AccesibilidadValoracionFinales
 * 
 * @author agarcia@at4.net
 * 
 */
@Service("accesibilidadvaloracionfinales")
public class AccesibilidadValoracionFinalesService extends InspeccionBaseService<AccesibilidadValoracionFinalesBO, AccesibilidadValoracionFinalesListadoVO, AccesibilidadValoracionFinalesFormVO> {

	/**
	 * The logger object.
	 */
	private static Logger log = LogService.getLogger(AccesibilidadValoracionFinalesService.class);

	/**
	 * Bean para acceder a los métodos de negocio:
	 * AccesibilidadValoracionFinales
	 */
	@Autowired
	@Qualifier("AccesibilidadValoracionFinalesBean")
	protected AccesibilidadValoracionFinalesBO mainBO;

	/**
	 * Bean para acceder a los métodos de negocio:
	 * AccesibilidadValoracionFinales
	 * 
	 * @param bean
	 *            the bean to set
	 */
	protected AccesibilidadValoracionFinalesBO getMainBO() {
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
			formItem.setText(this.getMessage("forms.accesibilidadvaloracionfinales.title", locale));
		}

		GridMetaData metaData = this.getBaseMetaData(formItem, locale);

		//Nombre de la clase js de formulario
		metaData.setFormClassName("AccesibilidadValoracionFinalesForm");

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
		/*
		 * metaData.addColumn(new GridColumnMetaData("claveInforme",
		 * this.getMessage
		 * ("forms.accesibilidadvaloracionfinales.columns.claveInforme.header",
		 * locale))); metaData.getColumn("claveInforme").setGroupable(false);
		 * metaData.getColumn("claveInforme").setSortable(true);
		 * metaData.getColumn
		 * ("claveInforme").setSofaFilter(GridColumnFilter.TYPE_NUMERIC);
		 */

		//Creamos el registro para el record
		/*
		 * metaData.addRecordField(new GridRecordFieldMetaData("inspeccionId",
		 * GridRecordFieldMetaData.INT_TYPE)); metaData.addRecordField(new
		 * GridRecordFieldMetaData("inspeccionLabel",
		 * GridRecordFieldMetaData.INT_TYPE)); metaData.addRecordField(new
		 * GridRecordFieldMetaData("inspeccion", "inspeccionLabel",
		 * GridRecordFieldMetaData.INT_TYPE));
		 */

		/** Creamos la columna */
		/*
		 * metaData.addColumn(new GridColumnMetaData("inspeccion",
		 * this.getMessage
		 * ("forms.accesibilidadvaloracionfinales.columns.inspeccion.header",
		 * locale))); metaData.getColumn("inspeccion").setGroupable(true);
		 * metaData.getColumn("inspeccion").setSortable(true);
		 * metaData.getColumn
		 * ("inspeccion").setSofaFilter(GridColumnFilter.TYPE_MULTICOMBO);
		 * metaData.getColumn("inspeccion").setRelatedForm("Inspeccion");
		 * 
		 * metaData.getColumn("inspeccion").setEditable(true) ;
		 * metaData.getColumn("inspeccion").setHidden(true);
		 */

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("satisfaceCondicionesBasicas", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("satisfaceCondicionesBasicas", this.getMessage("forms.accesibilidadvaloracionfinales.columns.satisfaceCondicionesBasicas.header", locale)));
		metaData.getColumn("satisfaceCondicionesBasicas").setGroupable(false);
		metaData.getColumn("satisfaceCondicionesBasicas").setSortable(true);
		metaData.getColumn("satisfaceCondicionesBasicas").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("satisfaceCondicionesBasicas").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] satisfaceCondicionesBasicasStore = new String[][] { { String.valueOf(Keys.ACCESIBILIDAD_VALORACION_FINAL_SI), this.getMessage("forms.accesibilidadvaloracionfinales.columns.satisfaceCondicionesBasicas." + Keys.ACCESIBILIDAD_VALORACION_FINAL_SI, locale) }, { String.valueOf(Keys.ACCESIBILIDAD_VALORACION_FINAL_NO), this.getMessage("forms.accesibilidadvaloracionfinales.columns.satisfaceCondicionesBasicas." + Keys.ACCESIBILIDAD_VALORACION_FINAL_NO, locale) }, };

		metaData.getColumn("satisfaceCondicionesBasicas").setSofaStoreValues(satisfaceCondicionesBasicasStore);

		metaData.getColumn("satisfaceCondicionesBasicas").setEditable(true);
		//metaData.getColumn("satisfaceCondicionesBasicas").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("deficienciasPublicoAlojamientosaccesibles", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("deficienciasPublicoAlojamientosaccesibles", this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoAlojamientosaccesibles.header", locale)));
		metaData.getColumn("deficienciasPublicoAlojamientosaccesibles").setTooltip(this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoAlojamientosaccesibles.description", locale));
		metaData.getColumn("deficienciasPublicoAlojamientosaccesibles").setGroupable(false);
		metaData.getColumn("deficienciasPublicoAlojamientosaccesibles").setSortable(true);
		metaData.getColumn("deficienciasPublicoAlojamientosaccesibles").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("deficienciasPublicoAlojamientosaccesibles").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] deficienciasPublicoAlojamientosaccesiblesStore = new String[][] { { String.valueOf(Keys.ACCESIBILIDAD_VALORACION_FINAL_SI), this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoAlojamientosaccesibles." + Keys.ACCESIBILIDAD_VALORACION_FINAL_SI, locale) }, { String.valueOf(Keys.ACCESIBILIDAD_VALORACION_FINAL_NO), this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoAlojamientosaccesibles." + Keys.ACCESIBILIDAD_VALORACION_FINAL_NO, locale) }, };

		metaData.getColumn("deficienciasPublicoAlojamientosaccesibles").setSofaStoreValues(deficienciasPublicoAlojamientosaccesiblesStore);

		metaData.getColumn("deficienciasPublicoAlojamientosaccesibles").setEditable(true);
		metaData.getColumn("deficienciasPublicoAlojamientosaccesibles").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("deficienciasPublicoAparcamiento", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("deficienciasPublicoAparcamiento", this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoAparcamiento.header", locale)));
		metaData.getColumn("deficienciasPublicoAparcamiento").setTooltip(this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoAparcamiento.description", locale));
		metaData.getColumn("deficienciasPublicoAparcamiento").setGroupable(false);
		metaData.getColumn("deficienciasPublicoAparcamiento").setSortable(true);
		metaData.getColumn("deficienciasPublicoAparcamiento").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("deficienciasPublicoAparcamiento").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] deficienciasPublicoAparcamientoStore = new String[][] { { String.valueOf(Keys.ACCESIBILIDAD_VALORACION_FINAL_SI), this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoAparcamiento." + Keys.ACCESIBILIDAD_VALORACION_FINAL_SI, locale) }, { String.valueOf(Keys.ACCESIBILIDAD_VALORACION_FINAL_NO), this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoAparcamiento." + Keys.ACCESIBILIDAD_VALORACION_FINAL_NO, locale) }, };

		metaData.getColumn("deficienciasPublicoAparcamiento").setSofaStoreValues(deficienciasPublicoAparcamientoStore);

		metaData.getColumn("deficienciasPublicoAparcamiento").setEditable(true);
		metaData.getColumn("deficienciasPublicoAparcamiento").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("deficienciasPublicoEntreplantas", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("deficienciasPublicoEntreplantas", this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoEntreplantas.header", locale)));
		metaData.getColumn("deficienciasPublicoEntreplantas").setTooltip(this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoEntreplantas.description", locale));
		metaData.getColumn("deficienciasPublicoEntreplantas").setGroupable(false);
		metaData.getColumn("deficienciasPublicoEntreplantas").setSortable(true);
		metaData.getColumn("deficienciasPublicoEntreplantas").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("deficienciasPublicoEntreplantas").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] deficienciasPublicoEntreplantasStore = new String[][] { { String.valueOf(Keys.ACCESIBILIDAD_VALORACION_FINAL_SI), this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoEntreplantas." + Keys.ACCESIBILIDAD_VALORACION_FINAL_SI, locale) }, { String.valueOf(Keys.ACCESIBILIDAD_VALORACION_FINAL_NO), this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoEntreplantas." + Keys.ACCESIBILIDAD_VALORACION_FINAL_NO, locale) }, };

		metaData.getColumn("deficienciasPublicoEntreplantas").setSofaStoreValues(deficienciasPublicoEntreplantasStore);

		metaData.getColumn("deficienciasPublicoEntreplantas").setEditable(true);
		metaData.getColumn("deficienciasPublicoEntreplantas").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("deficienciasPublicoExterior", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("deficienciasPublicoExterior", this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoExterior.header", locale)));
		metaData.getColumn("deficienciasPublicoExterior").setGroupable(false);
		metaData.getColumn("deficienciasPublicoExterior").setSortable(true);
		metaData.getColumn("deficienciasPublicoExterior").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("deficienciasPublicoExterior").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] deficienciasPublicoExteriorStore = new String[][] { { String.valueOf(Keys.ACCESIBILIDAD_VALORACION_FINAL_SI), this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoExterior." + Keys.ACCESIBILIDAD_VALORACION_FINAL_SI, locale) }, { String.valueOf(Keys.ACCESIBILIDAD_VALORACION_FINAL_NO), this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoExterior." + Keys.ACCESIBILIDAD_VALORACION_FINAL_NO, locale) }, };

		metaData.getColumn("deficienciasPublicoExterior").setSofaStoreValues(deficienciasPublicoExteriorStore);

		metaData.getColumn("deficienciasPublicoExterior").setEditable(true);
		metaData.getColumn("deficienciasPublicoExterior").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("deficienciasPublicoInformacionsenalizacion", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("deficienciasPublicoInformacionsenalizacion", this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoInformacionsenalizacion.header", locale)));
		metaData.getColumn("deficienciasPublicoInformacionsenalizacion").setTooltip(this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoInformacionsenalizacion.description", locale));
		metaData.getColumn("deficienciasPublicoInformacionsenalizacion").setGroupable(false);
		metaData.getColumn("deficienciasPublicoInformacionsenalizacion").setSortable(true);
		metaData.getColumn("deficienciasPublicoInformacionsenalizacion").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("deficienciasPublicoInformacionsenalizacion").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] deficienciasPublicoInformacionsenalizacionStore = new String[][] { { String.valueOf(Keys.ACCESIBILIDAD_VALORACION_FINAL_SI), this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoInformacionsenalizacion." + Keys.ACCESIBILIDAD_VALORACION_FINAL_SI, locale) }, { String.valueOf(Keys.ACCESIBILIDAD_VALORACION_FINAL_NO), this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoInformacionsenalizacion." + Keys.ACCESIBILIDAD_VALORACION_FINAL_NO, locale) }, };

		metaData.getColumn("deficienciasPublicoInformacionsenalizacion").setSofaStoreValues(deficienciasPublicoInformacionsenalizacionStore);

		metaData.getColumn("deficienciasPublicoInformacionsenalizacion").setEditable(true);
		metaData.getColumn("deficienciasPublicoInformacionsenalizacion").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("deficienciasPublicoMecanismos", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("deficienciasPublicoMecanismos", this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoMecanismos.header", locale)));
		metaData.getColumn("deficienciasPublicoMecanismos").setTooltip(this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoMecanismos.description", locale));
		metaData.getColumn("deficienciasPublicoMecanismos").setGroupable(false);
		metaData.getColumn("deficienciasPublicoMecanismos").setSortable(true);
		metaData.getColumn("deficienciasPublicoMecanismos").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("deficienciasPublicoMecanismos").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] deficienciasPublicoMecanismosStore = new String[][] { { String.valueOf(Keys.ACCESIBILIDAD_VALORACION_FINAL_SI), this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoMecanismos." + Keys.ACCESIBILIDAD_VALORACION_FINAL_SI, locale) }, { String.valueOf(Keys.ACCESIBILIDAD_VALORACION_FINAL_NO), this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoMecanismos." + Keys.ACCESIBILIDAD_VALORACION_FINAL_NO, locale) }, };

		metaData.getColumn("deficienciasPublicoMecanismos").setSofaStoreValues(deficienciasPublicoMecanismosStore);

		metaData.getColumn("deficienciasPublicoMecanismos").setEditable(true);
		metaData.getColumn("deficienciasPublicoMecanismos").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("deficienciasPublicoMobiliariofijo", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("deficienciasPublicoMobiliariofijo", this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoMobiliariofijo.header", locale)));
		metaData.getColumn("deficienciasPublicoMobiliariofijo").setTooltip(this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoMobiliariofijo.description", locale));
		metaData.getColumn("deficienciasPublicoMobiliariofijo").setGroupable(false);
		metaData.getColumn("deficienciasPublicoMobiliariofijo").setSortable(true);
		metaData.getColumn("deficienciasPublicoMobiliariofijo").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("deficienciasPublicoMobiliariofijo").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] deficienciasPublicoMobiliariofijoStore = new String[][] { { String.valueOf(Keys.ACCESIBILIDAD_VALORACION_FINAL_SI), this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoMobiliariofijo." + Keys.ACCESIBILIDAD_VALORACION_FINAL_SI, locale) }, { String.valueOf(Keys.ACCESIBILIDAD_VALORACION_FINAL_NO), this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoMobiliariofijo." + Keys.ACCESIBILIDAD_VALORACION_FINAL_NO, locale) }, };

		metaData.getColumn("deficienciasPublicoMobiliariofijo").setSofaStoreValues(deficienciasPublicoMobiliariofijoStore);

		metaData.getColumn("deficienciasPublicoMobiliariofijo").setEditable(true);
		metaData.getColumn("deficienciasPublicoMobiliariofijo").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("deficienciasPublicoPiscinas", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("deficienciasPublicoPiscinas", this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoPiscinas.header", locale)));
		metaData.getColumn("deficienciasPublicoPiscinas").setGroupable(false);
		metaData.getColumn("deficienciasPublicoPiscinas").setSortable(true);
		metaData.getColumn("deficienciasPublicoPiscinas").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("deficienciasPublicoPiscinas").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] deficienciasPublicoPiscinasStore = new String[][] { { String.valueOf(Keys.ACCESIBILIDAD_VALORACION_FINAL_SI), this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoPiscinas." + Keys.ACCESIBILIDAD_VALORACION_FINAL_SI, locale) }, { String.valueOf(Keys.ACCESIBILIDAD_VALORACION_FINAL_NO), this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoPiscinas." + Keys.ACCESIBILIDAD_VALORACION_FINAL_NO, locale) }, };

		metaData.getColumn("deficienciasPublicoPiscinas").setSofaStoreValues(deficienciasPublicoPiscinasStore);

		metaData.getColumn("deficienciasPublicoPiscinas").setEditable(true);
		metaData.getColumn("deficienciasPublicoPiscinas").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("deficienciasPublicoPlantas", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("deficienciasPublicoPlantas", this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoPlantas.header", locale)));
		metaData.getColumn("deficienciasPublicoPlantas").setGroupable(false);
		metaData.getColumn("deficienciasPublicoPlantas").setSortable(true);
		metaData.getColumn("deficienciasPublicoPlantas").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("deficienciasPublicoPlantas").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] deficienciasPublicoPlantasStore = new String[][] { { String.valueOf(Keys.ACCESIBILIDAD_VALORACION_FINAL_SI), this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoPlantas." + Keys.ACCESIBILIDAD_VALORACION_FINAL_SI, locale) }, { String.valueOf(Keys.ACCESIBILIDAD_VALORACION_FINAL_NO), this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoPlantas." + Keys.ACCESIBILIDAD_VALORACION_FINAL_NO, locale) }, };

		metaData.getColumn("deficienciasPublicoPlantas").setSofaStoreValues(deficienciasPublicoPlantasStore);

		metaData.getColumn("deficienciasPublicoPlantas").setEditable(true);
		metaData.getColumn("deficienciasPublicoPlantas").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("deficienciasPublicoPlazasreservadas", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("deficienciasPublicoPlazasreservadas", this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoPlazasreservadas.header", locale)));
		metaData.getColumn("deficienciasPublicoPlazasreservadas").setTooltip(this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoPlazasreservadas.description", locale));
		metaData.getColumn("deficienciasPublicoPlazasreservadas").setGroupable(false);
		metaData.getColumn("deficienciasPublicoPlazasreservadas").setSortable(true);
		metaData.getColumn("deficienciasPublicoPlazasreservadas").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("deficienciasPublicoPlazasreservadas").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] deficienciasPublicoPlazasreservadasStore = new String[][] { { String.valueOf(Keys.ACCESIBILIDAD_VALORACION_FINAL_SI), this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoPlazasreservadas." + Keys.ACCESIBILIDAD_VALORACION_FINAL_SI, locale) }, { String.valueOf(Keys.ACCESIBILIDAD_VALORACION_FINAL_NO), this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoPlazasreservadas." + Keys.ACCESIBILIDAD_VALORACION_FINAL_NO, locale) }, };

		metaData.getColumn("deficienciasPublicoPlazasreservadas").setSofaStoreValues(deficienciasPublicoPlazasreservadasStore);

		metaData.getColumn("deficienciasPublicoPlazasreservadas").setEditable(true);
		metaData.getColumn("deficienciasPublicoPlazasreservadas").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("deficienciasPublicoServicioshigienicos", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("deficienciasPublicoServicioshigienicos", this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoServicioshigienicos.header", locale)));
		metaData.getColumn("deficienciasPublicoServicioshigienicos").setTooltip(this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoServicioshigienicos.description", locale));
		metaData.getColumn("deficienciasPublicoServicioshigienicos").setGroupable(false);
		metaData.getColumn("deficienciasPublicoServicioshigienicos").setSortable(true);
		metaData.getColumn("deficienciasPublicoServicioshigienicos").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("deficienciasPublicoServicioshigienicos").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] deficienciasPublicoServicioshigienicosStore = new String[][] { { String.valueOf(Keys.ACCESIBILIDAD_VALORACION_FINAL_SI), this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoServicioshigienicos." + Keys.ACCESIBILIDAD_VALORACION_FINAL_SI, locale) }, { String.valueOf(Keys.ACCESIBILIDAD_VALORACION_FINAL_NO), this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoServicioshigienicos." + Keys.ACCESIBILIDAD_VALORACION_FINAL_NO, locale) }, };

		metaData.getColumn("deficienciasPublicoServicioshigienicos").setSofaStoreValues(deficienciasPublicoServicioshigienicosStore);

		metaData.getColumn("deficienciasPublicoServicioshigienicos").setEditable(true);
		metaData.getColumn("deficienciasPublicoServicioshigienicos").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("deficienciasViviendaAparcamiento", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("deficienciasViviendaAparcamiento", this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasViviendaAparcamiento.header", locale)));
		metaData.getColumn("deficienciasViviendaAparcamiento").setTooltip(this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasViviendaAparcamiento.description", locale));
		metaData.getColumn("deficienciasViviendaAparcamiento").setGroupable(false);
		metaData.getColumn("deficienciasViviendaAparcamiento").setSortable(true);
		metaData.getColumn("deficienciasViviendaAparcamiento").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("deficienciasViviendaAparcamiento").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] deficienciasViviendaAparcamientoStore = new String[][] { { String.valueOf(Keys.ACCESIBILIDAD_VALORACION_FINAL_SI), this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasViviendaAparcamiento." + Keys.ACCESIBILIDAD_VALORACION_FINAL_SI, locale) }, { String.valueOf(Keys.ACCESIBILIDAD_VALORACION_FINAL_NO), this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasViviendaAparcamiento." + Keys.ACCESIBILIDAD_VALORACION_FINAL_NO, locale) }, };

		metaData.getColumn("deficienciasViviendaAparcamiento").setSofaStoreValues(deficienciasViviendaAparcamientoStore);

		metaData.getColumn("deficienciasViviendaAparcamiento").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("deficienciasViviendaAparcamiento").setEditable(true);
		metaData.getColumn("deficienciasViviendaAparcamiento").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("deficienciasViviendaEntreplantas", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("deficienciasViviendaEntreplantas", this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasViviendaEntreplantas.header", locale)));
		metaData.getColumn("deficienciasViviendaEntreplantas").setTooltip(this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasViviendaEntreplantas.description", locale));
		metaData.getColumn("deficienciasViviendaEntreplantas").setGroupable(false);
		metaData.getColumn("deficienciasViviendaEntreplantas").setSortable(true);
		metaData.getColumn("deficienciasViviendaEntreplantas").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("deficienciasViviendaEntreplantas").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] deficienciasViviendaEntreplantasStore = new String[][] { { String.valueOf(Keys.ACCESIBILIDAD_VALORACION_FINAL_SI), this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasViviendaEntreplantas." + Keys.ACCESIBILIDAD_VALORACION_FINAL_SI, locale) }, { String.valueOf(Keys.ACCESIBILIDAD_VALORACION_FINAL_NO), this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasViviendaEntreplantas." + Keys.ACCESIBILIDAD_VALORACION_FINAL_NO, locale) }, };

		metaData.getColumn("deficienciasViviendaEntreplantas").setSofaStoreValues(deficienciasViviendaEntreplantasStore);

		metaData.getColumn("deficienciasViviendaEntreplantas").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("deficienciasViviendaEntreplantas").setEditable(true);
		metaData.getColumn("deficienciasViviendaEntreplantas").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("deficienciasViviendaExterior", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("deficienciasViviendaExterior", this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasViviendaExterior.header", locale)));
		metaData.getColumn("deficienciasViviendaExterior").setTooltip(this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasViviendaExterior.description", locale));
		metaData.getColumn("deficienciasViviendaExterior").setGroupable(false);
		metaData.getColumn("deficienciasViviendaExterior").setSortable(true);
		metaData.getColumn("deficienciasViviendaExterior").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("deficienciasViviendaExterior").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] deficienciasViviendaExteriorStore = new String[][] { { String.valueOf(Keys.ACCESIBILIDAD_VALORACION_FINAL_SI), this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasViviendaExterior." + Keys.ACCESIBILIDAD_VALORACION_FINAL_SI, locale) }, { String.valueOf(Keys.ACCESIBILIDAD_VALORACION_FINAL_NO), this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasViviendaExterior." + Keys.ACCESIBILIDAD_VALORACION_FINAL_NO, locale) }, };

		metaData.getColumn("deficienciasViviendaExterior").setSofaStoreValues(deficienciasViviendaExteriorStore);

		metaData.getColumn("deficienciasViviendaExterior").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("deficienciasViviendaExterior").setEditable(true);
		metaData.getColumn("deficienciasViviendaExterior").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("deficienciasViviendaInformacionsenalizacion", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("deficienciasViviendaInformacionsenalizacion", this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasViviendaInformacionsenalizacion.header", locale)));
		metaData.getColumn("deficienciasViviendaInformacionsenalizacion").setTooltip(this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasViviendaInformacionsenalizacion.description", locale));
		metaData.getColumn("deficienciasViviendaInformacionsenalizacion").setGroupable(false);
		metaData.getColumn("deficienciasViviendaInformacionsenalizacion").setSortable(true);
		metaData.getColumn("deficienciasViviendaInformacionsenalizacion").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("deficienciasViviendaInformacionsenalizacion").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] deficienciasViviendaInformacionsenalizacionStore = new String[][] { { String.valueOf(Keys.ACCESIBILIDAD_VALORACION_FINAL_SI), this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasViviendaInformacionsenalizacion." + Keys.ACCESIBILIDAD_VALORACION_FINAL_SI, locale) }, { String.valueOf(Keys.ACCESIBILIDAD_VALORACION_FINAL_NO), this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasViviendaInformacionsenalizacion." + Keys.ACCESIBILIDAD_VALORACION_FINAL_NO, locale) }, };

		metaData.getColumn("deficienciasViviendaInformacionsenalizacion").setSofaStoreValues(deficienciasViviendaInformacionsenalizacionStore);

		metaData.getColumn("deficienciasViviendaInformacionsenalizacion").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("deficienciasViviendaInformacionsenalizacion").setEditable(true);
		metaData.getColumn("deficienciasViviendaInformacionsenalizacion").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("deficienciasViviendaMecanismos", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("deficienciasViviendaMecanismos", this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasViviendaMecanismos.header", locale)));
		metaData.getColumn("deficienciasViviendaMecanismos").setTooltip(this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasViviendaMecanismos.description", locale));
		metaData.getColumn("deficienciasViviendaMecanismos").setGroupable(false);
		metaData.getColumn("deficienciasViviendaMecanismos").setSortable(true);
		metaData.getColumn("deficienciasViviendaMecanismos").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("deficienciasViviendaMecanismos").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] deficienciasViviendaMecanismosStore = new String[][] { { String.valueOf(Keys.ACCESIBILIDAD_VALORACION_FINAL_SI), this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasViviendaMecanismos." + Keys.ACCESIBILIDAD_VALORACION_FINAL_SI, locale) }, { String.valueOf(Keys.ACCESIBILIDAD_VALORACION_FINAL_NO), this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasViviendaMecanismos." + Keys.ACCESIBILIDAD_VALORACION_FINAL_NO, locale) }, };

		metaData.getColumn("deficienciasViviendaMecanismos").setSofaStoreValues(deficienciasViviendaMecanismosStore);

		metaData.getColumn("deficienciasViviendaMecanismos").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("deficienciasViviendaMecanismos").setEditable(true);
		metaData.getColumn("deficienciasViviendaMecanismos").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("deficienciasViviendaPiscinas", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("deficienciasViviendaPiscinas", this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasViviendaPiscinas.header", locale)));
		metaData.getColumn("deficienciasViviendaPiscinas").setTooltip(this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasViviendaPiscinas.description", locale));
		metaData.getColumn("deficienciasViviendaPiscinas").setGroupable(false);
		metaData.getColumn("deficienciasViviendaPiscinas").setSortable(true);
		metaData.getColumn("deficienciasViviendaPiscinas").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("deficienciasViviendaPiscinas").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] deficienciasViviendaPiscinasStore = new String[][] { { String.valueOf(Keys.ACCESIBILIDAD_VALORACION_FINAL_SI), this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasViviendaPiscinas." + Keys.ACCESIBILIDAD_VALORACION_FINAL_SI, locale) }, { String.valueOf(Keys.ACCESIBILIDAD_VALORACION_FINAL_NO), this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasViviendaPiscinas." + Keys.ACCESIBILIDAD_VALORACION_FINAL_NO, locale) }, };

		metaData.getColumn("deficienciasViviendaPiscinas").setSofaStoreValues(deficienciasViviendaPiscinasStore);

		metaData.getColumn("deficienciasViviendaPiscinas").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("deficienciasViviendaPiscinas").setEditable(true);
		metaData.getColumn("deficienciasViviendaPiscinas").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("deficienciasViviendaPlantas", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("deficienciasViviendaPlantas", this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasViviendaPlantas.header", locale)));
		metaData.getColumn("deficienciasViviendaPlantas").setGroupable(false);
		metaData.getColumn("deficienciasViviendaPlantas").setSortable(true);
		metaData.getColumn("deficienciasViviendaPlantas").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("deficienciasViviendaPlantas").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] deficienciasViviendaPlantasStore = new String[][] { { String.valueOf(Keys.ACCESIBILIDAD_VALORACION_FINAL_SI), this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasViviendaPlantas." + Keys.ACCESIBILIDAD_VALORACION_FINAL_SI, locale) }, { String.valueOf(Keys.ACCESIBILIDAD_VALORACION_FINAL_NO), this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasViviendaPlantas." + Keys.ACCESIBILIDAD_VALORACION_FINAL_NO, locale) }, };

		metaData.getColumn("deficienciasViviendaPlantas").setSofaStoreValues(deficienciasViviendaPlantasStore);

		metaData.getColumn("deficienciasViviendaPlantas").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("deficienciasViviendaPlantas").setEditable(true);
		metaData.getColumn("deficienciasViviendaPlantas").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("deficienciasViviendaServicioshigienicos", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("deficienciasViviendaServicioshigienicos", this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasViviendaServicioshigienicos.header", locale)));
		metaData.getColumn("deficienciasViviendaServicioshigienicos").setTooltip(this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasViviendaServicioshigienicos.description", locale));
		metaData.getColumn("deficienciasViviendaServicioshigienicos").setGroupable(false);
		metaData.getColumn("deficienciasViviendaServicioshigienicos").setSortable(true);
		metaData.getColumn("deficienciasViviendaServicioshigienicos").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("deficienciasViviendaServicioshigienicos").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] deficienciasViviendaServicioshigienicosStore = new String[][] { { String.valueOf(Keys.ACCESIBILIDAD_VALORACION_FINAL_SI), this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasViviendaServicioshigienicos." + Keys.ACCESIBILIDAD_VALORACION_FINAL_SI, locale) }, { String.valueOf(Keys.ACCESIBILIDAD_VALORACION_FINAL_NO), this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasViviendaServicioshigienicos." + Keys.ACCESIBILIDAD_VALORACION_FINAL_NO, locale) }, };

		metaData.getColumn("deficienciasViviendaServicioshigienicos").setSofaStoreValues(deficienciasViviendaServicioshigienicosStore);

		metaData.getColumn("deficienciasViviendaServicioshigienicos").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("deficienciasViviendaServicioshigienicos").setEditable(true);
		metaData.getColumn("deficienciasViviendaServicioshigienicos").setHidden(true);

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

		datosExportacion.add("claveInforme", this.getMessage("forms.accesibilidadvaloracionfinales.columns.claveInforme.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("inspeccion", this.getMessage("forms.accesibilidadvaloracionfinales.columns.inspeccion.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("deficienciasPublicoAlojamientosaccesibles", this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoAlojamientosaccesibles.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("deficienciasPublicoAparcamiento", this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoAparcamiento.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("deficienciasPublicoEntreplantas", this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoEntreplantas.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("deficienciasPublicoExterior", this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoExterior.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("deficienciasPublicoInformacionsenalizacion", this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoInformacionsenalizacion.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("deficienciasPublicoMecanismos", this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoMecanismos.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("deficienciasPublicoMobiliariofijo", this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoMobiliariofijo.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("deficienciasPublicoPiscinas", this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoPiscinas.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("deficienciasPublicoPlantas", this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoPlantas.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("deficienciasPublicoPlazasreservadas", this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoPlazasreservadas.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("deficienciasPublicoServicioshigienicos", this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoServicioshigienicos.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("deficienciasViviendaAparcamiento", this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasViviendaAparcamiento.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("deficienciasViviendaEntreplantas", this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasViviendaEntreplantas.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("deficienciasViviendaExterior", this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasViviendaExterior.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("deficienciasViviendaInformacionsenalizacion", this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasViviendaInformacionsenalizacion.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("deficienciasViviendaMecanismos", this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasViviendaMecanismos.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("deficienciasViviendaPiscinas", this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasViviendaPiscinas.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("deficienciasViviendaPlantas", this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasViviendaPlantas.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("deficienciasViviendaServicioshigienicos", this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasViviendaServicioshigienicos.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("satisfaceCondicionesBasicas", this.getMessage("forms.accesibilidadvaloracionfinales.columns.satisfaceCondicionesBasicas.header", locale), TipoCampoExportacion.STRING);

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
		AccesibilidadValoracionFinalesListadoVO instance = (AccesibilidadValoracionFinalesListadoVO) rawInstance;

		List<String> excelRow = new ArrayList<String>();

		excelRow.add(FormData2Java.toString(instance.getClaveInforme()));
		excelRow.add(FormData2Java.toString(instance.getInspeccionLabel()));

		//excelRow.add(FormData2Java.toString(instance.getDeficienciasPublicoAlojamientosaccesibles()));
		if (instance.getDeficienciasPublicoAlojamientosaccesibles()!=null){
		excelRow.add(this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoAlojamientosaccesibles." + instance.getDeficienciasPublicoAlojamientosaccesibles(), locale));
		}else{
			excelRow.add("null");
		}	

		//excelRow.add(FormData2Java.toString(instance.getDeficienciasPublicoAparcamiento()));
		if (instance.getDeficienciasPublicoAparcamiento()!=null){
		excelRow.add(this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoAparcamiento." + instance.getDeficienciasPublicoAparcamiento(), locale));
		}else{
			excelRow.add("null");
		}	

		//excelRow.add(FormData2Java.toString(instance.getDeficienciasPublicoEntreplantas()));
		if (instance.getDeficienciasPublicoEntreplantas()!=null){
		excelRow.add(this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoEntreplantas." + instance.getDeficienciasPublicoEntreplantas(), locale));
		}else{
			excelRow.add("null");
		}	

		//excelRow.add(FormData2Java.toString(instance.getDeficienciasPublicoExterior()));
		if (instance.getDeficienciasPublicoExterior()!=null){
		excelRow.add(this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoExterior." + instance.getDeficienciasPublicoExterior(), locale));
		}else{
			excelRow.add("null");
		}	

		//excelRow.add(FormData2Java.toString(instance.getDeficienciasPublicoInformacionsenalizacion()));
		if (instance.getDeficienciasPublicoInformacionsenalizacion()!=null){
		excelRow.add(this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoInformacionsenalizacion." + instance.getDeficienciasPublicoInformacionsenalizacion(), locale));
		}else{
			excelRow.add("null");
		}	

		//excelRow.add(FormData2Java.toString(instance.getDeficienciasPublicoMecanismos()));
		if (instance.getDeficienciasPublicoMecanismos()!=null){
		excelRow.add(this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoMecanismos." + instance.getDeficienciasPublicoMecanismos(), locale));
		}else{
			excelRow.add("null");
		}	

		//excelRow.add(FormData2Java.toString(instance.getDeficienciasPublicoMobiliariofijo()));
		if (instance.getDeficienciasPublicoMobiliariofijo()!=null){
		excelRow.add(this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoMobiliariofijo." + instance.getDeficienciasPublicoMobiliariofijo(), locale));
		}else{
			excelRow.add("null");
		}	

		//excelRow.add(FormData2Java.toString(instance.getDeficienciasPublicoPiscinas()));
		if (instance.getDeficienciasPublicoPiscinas()!=null){
		excelRow.add(this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoPiscinas." + instance.getDeficienciasPublicoPiscinas(), locale));
		}else{
			excelRow.add("null");
		}	

		//excelRow.add(FormData2Java.toString(instance.getDeficienciasPublicoPlantas()));
		if (instance.getDeficienciasPublicoPlantas()!=null){
		excelRow.add(this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoPlantas." + instance.getDeficienciasPublicoPlantas(), locale));
		}else{
			excelRow.add("null");
		}	

		//excelRow.add(FormData2Java.toString(instance.getDeficienciasPublicoPlazasreservadas()));
		if (instance.getDeficienciasPublicoPlazasreservadas()!=null){
		excelRow.add(this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoPlazasreservadas." + instance.getDeficienciasPublicoPlazasreservadas(), locale));
		}else{
			excelRow.add("null");
		}	

		//excelRow.add(FormData2Java.toString(instance.getDeficienciasPublicoServicioshigienicos()));
		if (instance.getDeficienciasPublicoServicioshigienicos()!=null){
		excelRow.add(this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoServicioshigienicos." + instance.getDeficienciasPublicoServicioshigienicos(), locale));
		}else{
			excelRow.add("null");
		}	

		//excelRow.add(instance.getDeficienciasViviendaAparcamiento());
		if (instance.getDeficienciasViviendaAparcamiento()!=null){
		excelRow.add(this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasViviendaAparcamiento." + instance.getDeficienciasViviendaAparcamiento(), locale));
		}else{
			excelRow.add("null");
		}	

		//excelRow.add(instance.getDeficienciasViviendaEntreplantas());
		if (instance.getDeficienciasViviendaEntreplantas()!=null){
		excelRow.add(this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasViviendaEntreplantas." + instance.getDeficienciasViviendaEntreplantas(), locale));
		}else{
			excelRow.add("null");
		}	

		//excelRow.add(instance.getDeficienciasViviendaExterior());
		if (instance.getDeficienciasViviendaExterior()!=null){
		excelRow.add(this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasViviendaExterior." + instance.getDeficienciasViviendaExterior(), locale));
		}else{
			excelRow.add("null");
		}	

		//excelRow.add(instance.getDeficienciasViviendaInformacionsenalizacion());
		if (instance.getDeficienciasViviendaInformacionsenalizacion()!=null){
		excelRow.add(this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasViviendaInformacionsenalizacion." + instance.getDeficienciasViviendaInformacionsenalizacion(), locale));
		}else{
			excelRow.add("null");
		}	

		//excelRow.add(instance.getDeficienciasViviendaMecanismos());
		if (instance.getDeficienciasViviendaMecanismos()!=null){
		excelRow.add(this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasViviendaMecanismos." + instance.getDeficienciasViviendaMecanismos(), locale));
		}else{
			excelRow.add("null");
		}	

		//excelRow.add(instance.getDeficienciasViviendaPiscinas());
		if (instance.getDeficienciasViviendaPiscinas()!=null){
		excelRow.add(this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasViviendaPiscinas." + instance.getDeficienciasViviendaPiscinas(), locale));
		}else{
			excelRow.add("null");
		}	

		//excelRow.add(instance.getDeficienciasViviendaPlantas());
		if (instance.getDeficienciasViviendaPlantas()!=null){
		excelRow.add(this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasViviendaPlantas." + instance.getDeficienciasViviendaPlantas(), locale));
		}else{
			excelRow.add("null");
		}	

		//excelRow.add(instance.getDeficienciasViviendaServicioshigienicos());
		if (instance.getDeficienciasViviendaServicioshigienicos()!=null){
		excelRow.add(this.getMessage("forms.accesibilidadvaloracionfinales.columns.deficienciasViviendaServicioshigienicos." + instance.getDeficienciasViviendaServicioshigienicos(), locale));
		}else{
			excelRow.add("null");
		}	

		//excelRow.add(FormData2Java.toString(instance.getSatisfaceCondicionesBasicas()));
		if (instance.getSatisfaceCondicionesBasicas()!=null){
		excelRow.add(this.getMessage("forms.accesibilidadvaloracionfinales.columns.satisfaceCondicionesBasicas." + instance.getSatisfaceCondicionesBasicas(), locale));
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
	 * Rellena una instancia de AccesibilidadValoracionFinalesFormVO con el
	 * contenido de un formulario recibido en formato Map<String, ?>
	 */
	protected void setFormData(AccesibilidadValoracionFinalesFormVO record, Map<String, ?> formData) throws GenericBusinessException {
		String formDataStr = null;
		if (!StringUtils.isEmpty(formData, "inspeccionId")) {
			formDataStr = (String) formData.get("inspeccionId");
			record.setInspeccionId(FormData2Java.toInteger(formDataStr));

		}
		if (formData.containsKey("deficienciasPublicoAlojamientosaccesibles")) {
			formDataStr = (String) formData.get("deficienciasPublicoAlojamientosaccesibles");
			record.setDeficienciasPublicoAlojamientosaccesibles(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("deficienciasPublicoAparcamiento")) {
			formDataStr = (String) formData.get("deficienciasPublicoAparcamiento");
			record.setDeficienciasPublicoAparcamiento(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("deficienciasPublicoEntreplantas")) {
			formDataStr = (String) formData.get("deficienciasPublicoEntreplantas");
			record.setDeficienciasPublicoEntreplantas(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("deficienciasPublicoExterior")) {
			formDataStr = (String) formData.get("deficienciasPublicoExterior");
			record.setDeficienciasPublicoExterior(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("deficienciasPublicoInformacionsenalizacion")) {
			formDataStr = (String) formData.get("deficienciasPublicoInformacionsenalizacion");
			record.setDeficienciasPublicoInformacionsenalizacion(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("deficienciasPublicoMecanismos")) {
			formDataStr = (String) formData.get("deficienciasPublicoMecanismos");
			record.setDeficienciasPublicoMecanismos(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("deficienciasPublicoMobiliariofijo")) {
			formDataStr = (String) formData.get("deficienciasPublicoMobiliariofijo");
			record.setDeficienciasPublicoMobiliariofijo(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("deficienciasPublicoPiscinas")) {
			formDataStr = (String) formData.get("deficienciasPublicoPiscinas");
			record.setDeficienciasPublicoPiscinas(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("deficienciasPublicoPlantas")) {
			formDataStr = (String) formData.get("deficienciasPublicoPlantas");
			record.setDeficienciasPublicoPlantas(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("deficienciasPublicoPlazasreservadas")) {
			formDataStr = (String) formData.get("deficienciasPublicoPlazasreservadas");
			record.setDeficienciasPublicoPlazasreservadas(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("deficienciasPublicoServicioshigienicos")) {
			formDataStr = (String) formData.get("deficienciasPublicoServicioshigienicos");
			record.setDeficienciasPublicoServicioshigienicos(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("deficienciasViviendaAparcamiento")) {
			formDataStr = (String) formData.get("deficienciasViviendaAparcamiento");
			record.setDeficienciasViviendaAparcamiento(formDataStr);
		}
		if (formData.containsKey("deficienciasViviendaEntreplantas")) {
			formDataStr = (String) formData.get("deficienciasViviendaEntreplantas");
			record.setDeficienciasViviendaEntreplantas(formDataStr);
		}
		if (formData.containsKey("deficienciasViviendaExterior")) {
			formDataStr = (String) formData.get("deficienciasViviendaExterior");
			record.setDeficienciasViviendaExterior(formDataStr);
		}
		if (formData.containsKey("deficienciasViviendaInformacionsenalizacion")) {
			formDataStr = (String) formData.get("deficienciasViviendaInformacionsenalizacion");
			record.setDeficienciasViviendaInformacionsenalizacion(formDataStr);
		}
		if (formData.containsKey("deficienciasViviendaMecanismos")) {
			formDataStr = (String) formData.get("deficienciasViviendaMecanismos");
			record.setDeficienciasViviendaMecanismos(formDataStr);
		}
		if (formData.containsKey("deficienciasViviendaPiscinas")) {
			formDataStr = (String) formData.get("deficienciasViviendaPiscinas");
			record.setDeficienciasViviendaPiscinas(formDataStr);
		}
		if (formData.containsKey("deficienciasViviendaPlantas")) {
			formDataStr = (String) formData.get("deficienciasViviendaPlantas");
			record.setDeficienciasViviendaPlantas(formDataStr);
		}
		if (formData.containsKey("deficienciasViviendaServicioshigienicos")) {
			formDataStr = (String) formData.get("deficienciasViviendaServicioshigienicos");
			record.setDeficienciasViviendaServicioshigienicos(formDataStr);
		}
		if (formData.containsKey("satisfaceCondicionesBasicas")) {
			formDataStr = (String) formData.get("satisfaceCondicionesBasicas");
			record.setSatisfaceCondicionesBasicas(FormData2Java.toInteger(formDataStr));
		}
	}

}
