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
import es.caib.avaedi.logic.bo.InspeccionBO;
import es.caib.avaedi.logic.bo.InstalacionesBO;
import es.caib.avaedi.logic.util.Keys;
import es.caib.avaedi.logic.vo.AcusticasListadoVO;
import es.caib.avaedi.logic.vo.InstalacionesFormVO;
import es.caib.avaedi.logic.vo.InstalacionesListadoVO;

/**
 * Servicio para tratar el formulario: Instalaciones
 * 
 * @author agarcia@at4.net
 * 
 */
@Service("instalaciones")
public class InstalacionesService extends InspeccionBaseService<InstalacionesBO, InstalacionesListadoVO, InstalacionesFormVO> {

	/**
	 * The logger object.
	 */
	private static Logger log = LogService.getLogger(InstalacionesService.class);

	/**
	 * Bean para acceder a los métodos de negocio: Instalaciones
	 */
	@Autowired
	@Qualifier("InstalacionesBean")
	protected InstalacionesBO mainBO;

	/**
	 * Bean para acceder a los métodos de negocio: Instalaciones
	 * 
	 * @param bean
	 *            the bean to set
	 */
	protected InstalacionesBO getMainBO() {
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
			formItem.setText(this.getMessage("forms.instalaciones.title", locale));
		}

		GridMetaData metaData = this.getBaseMetaData(formItem, locale);

		//Nombre de la clase js de formulario
		metaData.setFormClassName("InstalacionesForm");

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
		 * GridColumnMetaData("claveInforme",
		 * this.getMessage("forms.instalaciones.columns.claveInforme.header",
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
		 * this.getMessage("forms.instalaciones.columns.inspeccion.header",
		 * locale))); metaData.getColumn("inspeccion").setGroupable(true);
		 * metaData.getColumn("inspeccion").setSortable(true);
		 * metaData.getColumn
		 * ("inspeccion").setSofaFilter(GridColumnFilter.TYPE_MULTICOMBO);
		 * metaData.getColumn("inspeccion").setRelatedForm("Inspeccion");
		 * 
		 * metaData.getColumn("inspeccion").setEditable(true);
		 */

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("acsCaptadoressolares", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("acsCaptadoressolares", this.getMessage("forms.instalaciones.columns.acsCaptadoressolares.header", locale)));
		metaData.getColumn("acsCaptadoressolares").setGroupable(false);
		metaData.getColumn("acsCaptadoressolares").setSortable(true);
		metaData.getColumn("acsCaptadoressolares").setSofaFilter(GridColumnFilter.TYPE_NUMERIC);

		metaData.getColumn("acsCaptadoressolares").setEditable(true);
		//metaData.getColumn("acsCaptadoressolares").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("acsTiene", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("acsTiene", this.getMessage("forms.instalaciones.columns.acsTiene.header", locale)));
		metaData.getColumn("acsTiene").setGroupable(false);
		metaData.getColumn("acsTiene").setSortable(true);
		metaData.getColumn("acsTiene").setSofaFilter(GridColumnFilter.TYPE_LIST);
		metaData.getColumn("acsTiene").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] acsTieneStore = new String[][] { { String.valueOf(Keys.INSTALACIONES_ACS_TIENE_SI), this.getMessage("forms.instalaciones.columns.acsTiene." + Keys.INSTALACIONES_ACS_TIENE_SI, locale) }, { String.valueOf(Keys.INSTALACIONES_ACS_TIENE_NO), this.getMessage("forms.instalaciones.columns.acsTiene." + Keys.INSTALACIONES_ACS_TIENE_NO, locale) }, };

		metaData.getColumn("acsTiene").setSofaStoreValues(acsTieneStore);

		metaData.getColumn("acsTiene").setEditable(true);
		//metaData.getColumn("acsTiene").setHidden(true);


		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("acsCentralTiene", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("acsCentralTiene", this.getMessage("forms.instalaciones.columns.acsCentralTiene.header", locale)));
		metaData.getColumn("acsCentralTiene").setGroupable(false);
		metaData.getColumn("acsCentralTiene").setSortable(true);
		metaData.getColumn("acsCentralTiene").setSofaFilter(GridColumnFilter.TYPE_LIST);
		metaData.getColumn("acsCentralTiene").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] acsCentralTieneStore = new String[][] { { String.valueOf(Keys.INSTALACIONES_ACS_TIENE_CENTRAL_SI), this.getMessage("forms.instalaciones.columns.acsCentralTiene." + Keys.INSTALACIONES_ACS_TIENE_CENTRAL_SI, locale) }, { String.valueOf(Keys.INSTALACIONES_ACS_TIENE_CENTRAL_NO), this.getMessage("forms.instalaciones.columns.acsCentralTiene." + Keys.INSTALACIONES_ACS_TIENE_CENTRAL_NO, locale) }, };

		metaData.getColumn("acsCentralTiene").setSofaStoreValues(acsCentralTieneStore);

		metaData.getColumn("acsCentralTiene").setEditable(true);
		//metaData.getColumn("acsCentralTiene").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("calefaccionTiene", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("calefaccionTiene", this.getMessage("forms.instalaciones.columns.calefaccionTiene.header", locale)));
		metaData.getColumn("calefaccionTiene").setGroupable(false);
		metaData.getColumn("calefaccionTiene").setSortable(true);
		metaData.getColumn("calefaccionTiene").setSofaFilter(GridColumnFilter.TYPE_LIST);
		metaData.getColumn("calefaccionTiene").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] calefaccionTieneStore = new String[][] { { String.valueOf(Keys.INSTALACIONES_CALEFACCION_TIENE_SI), this.getMessage("forms.instalaciones.columns.calefaccionTiene." + Keys.INSTALACIONES_CALEFACCION_TIENE_SI, locale) }, { String.valueOf(Keys.INSTALACIONES_CALEFACCION_TIENE_NO), this.getMessage("forms.instalaciones.columns.calefaccionTiene." + Keys.INSTALACIONES_CALEFACCION_TIENE_NO, locale) }, };

		metaData.getColumn("calefaccionTiene").setSofaStoreValues(calefaccionTieneStore);

		metaData.getColumn("calefaccionTiene").setEditable(true);
		//metaData.getColumn("calefaccionTiene").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("calefaccionCentralTiene", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("calefaccionCentralTiene", this.getMessage("forms.instalaciones.columns.calefaccionCentralTiene.header", locale)));
		metaData.getColumn("calefaccionCentralTiene").setGroupable(false);
		metaData.getColumn("calefaccionCentralTiene").setSortable(true);
		metaData.getColumn("calefaccionCentralTiene").setSofaFilter(GridColumnFilter.TYPE_LIST);
		metaData.getColumn("calefaccionCentralTiene").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] calefaccionCentralTieneStore = new String[][] { { String.valueOf(Keys.INSTALACIONES_CALEFACCION_TIENE_CENTRAL_SI), this.getMessage("forms.instalaciones.columns.calefaccionCentralTiene." + Keys.INSTALACIONES_CALEFACCION_TIENE_CENTRAL_SI, locale) }, { String.valueOf(Keys.INSTALACIONES_CALEFACCION_TIENE_CENTRAL_NO), this.getMessage("forms.instalaciones.columns.calefaccionCentralTiene." + Keys.INSTALACIONES_CALEFACCION_TIENE_CENTRAL_NO, locale) }, };

		metaData.getColumn("calefaccionCentralTiene").setSofaStoreValues(calefaccionCentralTieneStore);

		metaData.getColumn("calefaccionCentralTiene").setEditable(true);
		//metaData.getColumn("calefaccionCentralTiene").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("comunicacionesictTiene", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("comunicacionesictTiene", this.getMessage("forms.instalaciones.columns.comunicacionesictTiene.header", locale)));
		metaData.getColumn("comunicacionesictTiene").setGroupable(false);
		metaData.getColumn("comunicacionesictTiene").setSortable(true);
		metaData.getColumn("comunicacionesictTiene").setSofaFilter(GridColumnFilter.TYPE_LIST);
		metaData.getColumn("comunicacionesictTiene").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] comunicacionesIctTieneStore = new String[][] { { String.valueOf(Keys.INSTALACIONES_COMUNICACIONES_ICT_TIENE_SI), this.getMessage("forms.instalaciones.columns.comunicacionesictTiene." + Keys.INSTALACIONES_COMUNICACIONES_ICT_TIENE_SI, locale) }, { String.valueOf(Keys.INSTALACIONES_COMUNICACIONES_ICT_TIENE_NO), this.getMessage("forms.instalaciones.columns.comunicacionesictTiene." + Keys.INSTALACIONES_COMUNICACIONES_ICT_TIENE_NO, locale) }, };

		metaData.getColumn("comunicacionesictTiene").setSofaStoreValues(comunicacionesIctTieneStore);

		metaData.getColumn("comunicacionesictTiene").setEditable(true);
		//metaData.getColumn("comunicacionesictTiene").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("contraincendiosTiene", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("contraincendiosTiene", this.getMessage("forms.instalaciones.columns.contraincendiosTiene.header", locale)));
		metaData.getColumn("contraincendiosTiene").setGroupable(false);
		metaData.getColumn("contraincendiosTiene").setSortable(true);
		metaData.getColumn("contraincendiosTiene").setSofaFilter(GridColumnFilter.TYPE_LIST);
		metaData.getColumn("contraincendiosTiene").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] contraIncendiosTieneStore = new String[][] { { String.valueOf(Keys.INSTALACIONES_CONTRA_INCENDIOS_TIENE_SI), this.getMessage("forms.instalaciones.columns.contraincendiosTiene." + Keys.INSTALACIONES_CONTRA_INCENDIOS_TIENE_SI, locale) }, { String.valueOf(Keys.INSTALACIONES_CONTRA_INCENDIOS_TIENE_NO), this.getMessage("forms.instalaciones.columns.contraincendiosTiene." + Keys.INSTALACIONES_CONTRA_INCENDIOS_TIENE_NO, locale) }, };

		metaData.getColumn("contraincendiosTiene").setSofaStoreValues(contraIncendiosTieneStore);

		metaData.getColumn("contraincendiosTiene").setEditable(true);
		//metaData.getColumn("contraincendiosTiene").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("contrarayoTiene", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("contrarayoTiene", this.getMessage("forms.instalaciones.columns.contrarayoTiene.header", locale)));
		metaData.getColumn("contrarayoTiene").setGroupable(false);
		metaData.getColumn("contrarayoTiene").setSortable(true);
		metaData.getColumn("contrarayoTiene").setSofaFilter(GridColumnFilter.TYPE_LIST);
		metaData.getColumn("contrarayoTiene").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] contraRayoTieneStore = new String[][] { { String.valueOf(Keys.INSTALACIONES_CONTRA_RAYO_TIENE_SI), this.getMessage("forms.instalaciones.columns.contrarayoTiene." + Keys.INSTALACIONES_CONTRA_RAYO_TIENE_SI, locale) }, { String.valueOf(Keys.INSTALACIONES_CONTRA_RAYO_TIENE_NO), this.getMessage("forms.instalaciones.columns.contrarayoTiene." + Keys.INSTALACIONES_CONTRA_RAYO_TIENE_NO, locale) }, };

		metaData.getColumn("contrarayoTiene").setSofaStoreValues(contraRayoTieneStore);

		metaData.getColumn("contrarayoTiene").setEditable(true);
		//metaData.getColumn("contrarayoTiene").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("gascanalizadoTiene", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("gascanalizadoTiene", this.getMessage("forms.instalaciones.columns.gascanalizadoTiene.header", locale)));
		metaData.getColumn("gascanalizadoTiene").setGroupable(false);
		metaData.getColumn("gascanalizadoTiene").setSortable(true);
		metaData.getColumn("gascanalizadoTiene").setSofaFilter(GridColumnFilter.TYPE_LIST);
		metaData.getColumn("gascanalizadoTiene").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] gasCanalizadoTieneStore = new String[][] { { String.valueOf(Keys.INSTALACIONES_GAS_CANALIZADO_TIENE_SI), this.getMessage("forms.instalaciones.columns.gascanalizadoTiene." + Keys.INSTALACIONES_GAS_CANALIZADO_TIENE_SI, locale) }, { String.valueOf(Keys.INSTALACIONES_GAS_CANALIZADO_TIENE_NO), this.getMessage("forms.instalaciones.columns.gascanalizadoTiene." + Keys.INSTALACIONES_GAS_CANALIZADO_TIENE_NO, locale) }, };

		metaData.getColumn("gascanalizadoTiene").setSofaStoreValues(gasCanalizadoTieneStore);

		metaData.getColumn("gascanalizadoTiene").setEditable(true);
		//metaData.getColumn("gascanalizadoTiene").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("refrigeracionTiene", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("refrigeracionTiene", this.getMessage("forms.instalaciones.columns.refrigeracionTiene.header", locale)));
		metaData.getColumn("refrigeracionTiene").setGroupable(false);
		metaData.getColumn("refrigeracionTiene").setSortable(true);
		metaData.getColumn("refrigeracionTiene").setSofaFilter(GridColumnFilter.TYPE_LIST);
		metaData.getColumn("refrigeracionTiene").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] refrigeracionTieneStore = new String[][] { { String.valueOf(Keys.INSTALACIONES_REFRIGERACION_TIENE_SI), this.getMessage("forms.instalaciones.columns.refrigeracionTiene." + Keys.INSTALACIONES_REFRIGERACION_TIENE_SI, locale) }, { String.valueOf(Keys.INSTALACIONES_REFRIGERACION_TIENE_NO), this.getMessage("forms.instalaciones.columns.refrigeracionTiene." + Keys.INSTALACIONES_REFRIGERACION_TIENE_NO, locale) }, };

		metaData.getColumn("refrigeracionTiene").setSofaStoreValues(refrigeracionTieneStore);

		metaData.getColumn("refrigeracionTiene").setEditable(true);
		//metaData.getColumn("refrigeracionTiene").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("refrigeracionColectivoTiene", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("refrigeracionColectivoTiene", this.getMessage("forms.instalaciones.columns.refrigeracionColectivoTiene.header", locale)));
		metaData.getColumn("refrigeracionColectivoTiene").setGroupable(false);
		metaData.getColumn("refrigeracionColectivoTiene").setSortable(true);
		metaData.getColumn("refrigeracionColectivoTiene").setSofaFilter(GridColumnFilter.TYPE_LIST);
		metaData.getColumn("refrigeracionColectivoTiene").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] refrigeracionColectivoTieneStore = new String[][] { { String.valueOf(Keys.INSTALACIONES_REFRIGERACION_TIENE_COLECTIVO_SI), this.getMessage("forms.instalaciones.columns.refrigeracionColectivoTiene." + Keys.INSTALACIONES_REFRIGERACION_TIENE_COLECTIVO_SI, locale) }, { String.valueOf(Keys.INSTALACIONES_REFRIGERACION_TIENE_COLECTIVO_NO), this.getMessage("forms.instalaciones.columns.refrigeracionColectivoTiene." + Keys.INSTALACIONES_REFRIGERACION_TIENE_COLECTIVO_NO, locale) }, };

		metaData.getColumn("refrigeracionColectivoTiene").setSofaStoreValues(refrigeracionColectivoTieneStore);

		metaData.getColumn("refrigeracionColectivoTiene").setEditable(true);
		//metaData.getColumn("refrigeracionColectivoTiene").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("ventilacionCuartoshumedosSinventilacion", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("ventilacionCuartoshumedosSinventilacion", this.getMessage("forms.instalaciones.columns.ventilacionCuartoshumedosSinventilacion.header", locale)));
		metaData.getColumn("ventilacionCuartoshumedosSinventilacion").setTooltip(this.getMessage("forms.instalaciones.columns.ventilacionCuartoshumedosSinventilacion.description", locale));
		metaData.getColumn("ventilacionCuartoshumedosSinventilacion").setGroupable(false);
		metaData.getColumn("ventilacionCuartoshumedosSinventilacion").setSortable(true);
		metaData.getColumn("ventilacionCuartoshumedosSinventilacion").setSofaFilter(GridColumnFilter.TYPE_LIST);
		metaData.getColumn("ventilacionCuartoshumedosSinventilacion").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] ventilacionCuartosHumedosStore = new String[][] { { String.valueOf(Keys.INSTALACIONES_VENTILACION_CUARTOS_HUMEDOS_SI), this.getMessage("forms.instalaciones.columns.ventilacionCuartoshumedosSinventilacion." + Keys.INSTALACIONES_VENTILACION_CUARTOS_HUMEDOS_SI, locale) }, { String.valueOf(Keys.INSTALACIONES_VENTILACION_CUARTOS_HUMEDOS_NO), this.getMessage("forms.instalaciones.columns.ventilacionCuartoshumedosSinventilacion." + Keys.INSTALACIONES_VENTILACION_CUARTOS_HUMEDOS_NO, locale) }, };

		metaData.getColumn("ventilacionCuartoshumedosSinventilacion").setSofaStoreValues(ventilacionCuartosHumedosStore);

		metaData.getColumn("ventilacionCuartoshumedosSinventilacion").setEditable(true);
		//metaData.getColumn("ventilacionCuartoshumedosSinventilacion").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("ventilacionTiene", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("ventilacionTiene", this.getMessage("forms.instalaciones.columns.ventilacionTiene.header", locale)));
		metaData.getColumn("ventilacionTiene").setGroupable(false);
		metaData.getColumn("ventilacionTiene").setSortable(true);
		metaData.getColumn("ventilacionTiene").setSofaFilter(GridColumnFilter.TYPE_LIST);
		metaData.getColumn("ventilacionTiene").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] ieeStore = new String[][] { { String.valueOf(Keys.INSTALACIONES_VENTILACION_TIENE_SI), this.getMessage("forms.instalaciones.columns.ventilacionTiene." + Keys.INSTALACIONES_VENTILACION_TIENE_SI, locale) }, { String.valueOf(Keys.INSTALACIONES_VENTILACION_TIENE_NO), this.getMessage("forms.instalaciones.columns.ventilacionTiene." + Keys.INSTALACIONES_VENTILACION_TIENE_NO, locale) }, };

		metaData.getColumn("ventilacionTiene").setSofaStoreValues(ieeStore);

		metaData.getColumn("ventilacionTiene").setEditable(true);
		//metaData.getColumn("ventilacionTiene").setHidden(true);


		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("acsCentralCombustibleTexto", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("acsCentralCombustibleTexto", this.getMessage("forms.instalaciones.columns.acsCentralCombustibleTexto.header", locale)));
		metaData.getColumn("acsCentralCombustibleTexto").setGroupable(false);
		metaData.getColumn("acsCentralCombustibleTexto").setSortable(true);
		metaData.getColumn("acsCentralCombustibleTexto").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("acsCentralCombustibleTexto").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("acsCentralCombustibleTexto").setEditable(true);
		metaData.getColumn("acsCentralCombustibleTexto").setHidden(true);


		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("acsNocentralCalentadoreselectricosporcentaje", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("acsNocentralCalentadoreselectricosporcentaje", this.getMessage("forms.instalaciones.columns.acsNocentralCalentadoreselectricosporcentaje.header", locale)));
		metaData.getColumn("acsNocentralCalentadoreselectricosporcentaje").setTooltip(this.getMessage("forms.instalaciones.columns.acsNocentralCalentadoreselectricosporcentaje.description", locale));
		metaData.getColumn("acsNocentralCalentadoreselectricosporcentaje").setGroupable(false);
		metaData.getColumn("acsNocentralCalentadoreselectricosporcentaje").setSortable(true);
		metaData.getColumn("acsNocentralCalentadoreselectricosporcentaje").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("acsNocentralCalentadoreselectricosporcentaje").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("acsNocentralCalentadoreselectricosporcentaje").setEditable(true);
		metaData.getColumn("acsNocentralCalentadoreselectricosporcentaje").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("acsNocentralGascanalizadoporcentaje", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("acsNocentralGascanalizadoporcentaje", this.getMessage("forms.instalaciones.columns.acsNocentralGascanalizadoporcentaje.header", locale)));
		metaData.getColumn("acsNocentralGascanalizadoporcentaje").setTooltip(this.getMessage("forms.instalaciones.columns.acsNocentralGascanalizadoporcentaje.description", locale));
		metaData.getColumn("acsNocentralGascanalizadoporcentaje").setGroupable(false);
		metaData.getColumn("acsNocentralGascanalizadoporcentaje").setSortable(true);
		metaData.getColumn("acsNocentralGascanalizadoporcentaje").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("acsNocentralGascanalizadoporcentaje").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("acsNocentralGascanalizadoporcentaje").setEditable(true);
		metaData.getColumn("acsNocentralGascanalizadoporcentaje").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("acsNocentralGasembotelladoporcentaje", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("acsNocentralGasembotelladoporcentaje", this.getMessage("forms.instalaciones.columns.acsNocentralGasembotelladoporcentaje.header", locale)));
		metaData.getColumn("acsNocentralGasembotelladoporcentaje").setTooltip(this.getMessage("forms.instalaciones.columns.acsNocentralGasembotelladoporcentaje.description", locale));
		metaData.getColumn("acsNocentralGasembotelladoporcentaje").setGroupable(false);
		metaData.getColumn("acsNocentralGasembotelladoporcentaje").setSortable(true);
		metaData.getColumn("acsNocentralGasembotelladoporcentaje").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("acsNocentralGasembotelladoporcentaje").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("acsNocentralGasembotelladoporcentaje").setEditable(true);
		metaData.getColumn("acsNocentralGasembotelladoporcentaje").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("acsNocentralIndividualporcentaje", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("acsNocentralIndividualporcentaje", this.getMessage("forms.instalaciones.columns.acsNocentralIndividualporcentaje.header", locale)));
		metaData.getColumn("acsNocentralIndividualporcentaje").setTooltip(this.getMessage("forms.instalaciones.columns.acsNocentralIndividualporcentaje.description", locale));
		metaData.getColumn("acsNocentralIndividualporcentaje").setGroupable(false);
		metaData.getColumn("acsNocentralIndividualporcentaje").setSortable(true);
		metaData.getColumn("acsNocentralIndividualporcentaje").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("acsNocentralIndividualporcentaje").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("acsNocentralIndividualporcentaje").setEditable(true);
		metaData.getColumn("acsNocentralIndividualporcentaje").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("acsNocentralOtrosporcentaje", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("acsNocentralOtrosporcentaje", this.getMessage("forms.instalaciones.columns.acsNocentralOtrosporcentaje.header", locale)));
		metaData.getColumn("acsNocentralOtrosporcentaje").setGroupable(false);
		metaData.getColumn("acsNocentralOtrosporcentaje").setSortable(true);
		metaData.getColumn("acsNocentralOtrosporcentaje").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("acsNocentralOtrosporcentaje").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("acsNocentralOtrosporcentaje").setEditable(true);
		metaData.getColumn("acsNocentralOtrosporcentaje").setHidden(true);



		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("calefaccionCentralCombustibleTexto", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("calefaccionCentralCombustibleTexto", this.getMessage("forms.instalaciones.columns.calefaccionCentralCombustibleTexto.header", locale)));
		metaData.getColumn("calefaccionCentralCombustibleTexto").setTooltip(this.getMessage("forms.instalaciones.columns.calefaccionCentralCombustibleTexto.description", locale));
		metaData.getColumn("calefaccionCentralCombustibleTexto").setGroupable(false);
		metaData.getColumn("calefaccionCentralCombustibleTexto").setSortable(true);
		metaData.getColumn("calefaccionCentralCombustibleTexto").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("calefaccionCentralCombustibleTexto").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("calefaccionCentralCombustibleTexto").setEditable(true);
		metaData.getColumn("calefaccionCentralCombustibleTexto").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("calefaccionCentralTexto", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("calefaccionCentralTexto", this.getMessage("forms.instalaciones.columns.calefaccionCentralTexto.header", locale)));
		metaData.getColumn("calefaccionCentralTexto").setGroupable(false);
		metaData.getColumn("calefaccionCentralTexto").setSortable(true);
		metaData.getColumn("calefaccionCentralTexto").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("calefaccionCentralTexto").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("calefaccionCentralTexto").setEditable(true);
		metaData.getColumn("calefaccionCentralTexto").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("calefaccionNocentralCalderagasoleoporcentaje", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("calefaccionNocentralCalderagasoleoporcentaje", this.getMessage("forms.instalaciones.columns.calefaccionNocentralCalderagasoleoporcentaje.header", locale)));
		metaData.getColumn("calefaccionNocentralCalderagasoleoporcentaje").setTooltip(this.getMessage("forms.instalaciones.columns.calefaccionNocentralCalderagasoleoporcentaje.description", locale));
		metaData.getColumn("calefaccionNocentralCalderagasoleoporcentaje").setGroupable(false);
		metaData.getColumn("calefaccionNocentralCalderagasoleoporcentaje").setSortable(true);
		metaData.getColumn("calefaccionNocentralCalderagasoleoporcentaje").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("calefaccionNocentralCalderagasoleoporcentaje").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("calefaccionNocentralCalderagasoleoporcentaje").setEditable(true);
		metaData.getColumn("calefaccionNocentralCalderagasoleoporcentaje").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("calefaccionNocentralCalefaccionelectricaporcentaje", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("calefaccionNocentralCalefaccionelectricaporcentaje", this.getMessage("forms.instalaciones.columns.calefaccionNocentralCalefaccionelectricaporcentaje.header", locale)));
		metaData.getColumn("calefaccionNocentralCalefaccionelectricaporcentaje").setTooltip(this.getMessage("forms.instalaciones.columns.calefaccionNocentralCalefaccionelectricaporcentaje.description", locale));
		metaData.getColumn("calefaccionNocentralCalefaccionelectricaporcentaje").setGroupable(false);
		metaData.getColumn("calefaccionNocentralCalefaccionelectricaporcentaje").setSortable(true);
		metaData.getColumn("calefaccionNocentralCalefaccionelectricaporcentaje").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("calefaccionNocentralCalefaccionelectricaporcentaje").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("calefaccionNocentralCalefaccionelectricaporcentaje").setEditable(true);
		metaData.getColumn("calefaccionNocentralCalefaccionelectricaporcentaje").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("calefaccionNocentralGascanalizadoporcentaje", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("calefaccionNocentralGascanalizadoporcentaje", this.getMessage("forms.instalaciones.columns.calefaccionNocentralGascanalizadoporcentaje.header", locale)));
		metaData.getColumn("calefaccionNocentralGascanalizadoporcentaje").setTooltip(this.getMessage("forms.instalaciones.columns.calefaccionNocentralGascanalizadoporcentaje.description", locale));
		metaData.getColumn("calefaccionNocentralGascanalizadoporcentaje").setGroupable(false);
		metaData.getColumn("calefaccionNocentralGascanalizadoporcentaje").setSortable(true);
		metaData.getColumn("calefaccionNocentralGascanalizadoporcentaje").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("calefaccionNocentralGascanalizadoporcentaje").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("calefaccionNocentralGascanalizadoporcentaje").setEditable(true);
		metaData.getColumn("calefaccionNocentralGascanalizadoporcentaje").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("calefaccionNocentralIndividualporcentaje", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("calefaccionNocentralIndividualporcentaje", this.getMessage("forms.instalaciones.columns.calefaccionNocentralIndividualporcentaje.header", locale)));
		metaData.getColumn("calefaccionNocentralIndividualporcentaje").setTooltip(this.getMessage("forms.instalaciones.columns.calefaccionNocentralIndividualporcentaje.description", locale));
		metaData.getColumn("calefaccionNocentralIndividualporcentaje").setGroupable(false);
		metaData.getColumn("calefaccionNocentralIndividualporcentaje").setSortable(true);
		metaData.getColumn("calefaccionNocentralIndividualporcentaje").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("calefaccionNocentralIndividualporcentaje").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("calefaccionNocentralIndividualporcentaje").setEditable(true);
		metaData.getColumn("calefaccionNocentralIndividualporcentaje").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("calefaccionNocentralOtrosporcentaje", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("calefaccionNocentralOtrosporcentaje", this.getMessage("forms.instalaciones.columns.calefaccionNocentralOtrosporcentaje.header", locale)));
		metaData.getColumn("calefaccionNocentralOtrosporcentaje").setTooltip(this.getMessage("forms.instalaciones.columns.calefaccionNocentralOtrosporcentaje.description", locale));
		metaData.getColumn("calefaccionNocentralOtrosporcentaje").setGroupable(false);
		metaData.getColumn("calefaccionNocentralOtrosporcentaje").setSortable(true);
		metaData.getColumn("calefaccionNocentralOtrosporcentaje").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("calefaccionNocentralOtrosporcentaje").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("calefaccionNocentralOtrosporcentaje").setEditable(true);
		metaData.getColumn("calefaccionNocentralOtrosporcentaje").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("comunicacionesictTexto", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("comunicacionesictTexto", this.getMessage("forms.instalaciones.columns.comunicacionesictTexto.header", locale)));
		metaData.getColumn("comunicacionesictTexto").setGroupable(false);
		metaData.getColumn("comunicacionesictTexto").setSortable(true);
		metaData.getColumn("comunicacionesictTexto").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("comunicacionesictTexto").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("comunicacionesictTexto").setEditable(true);
		metaData.getColumn("comunicacionesictTexto").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("contrarayoTexto", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("contrarayoTexto", this.getMessage("forms.instalaciones.columns.contrarayoTexto.header", locale)));
		metaData.getColumn("contrarayoTexto").setGroupable(false);
		metaData.getColumn("contrarayoTexto").setSortable(true);
		metaData.getColumn("contrarayoTexto").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("contrarayoTexto").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("contrarayoTexto").setEditable(true);
		metaData.getColumn("contrarayoTexto").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("electricaTexto", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("electricaTexto", this.getMessage("forms.instalaciones.columns.electricaTexto.header", locale)));
		metaData.getColumn("electricaTexto").setGroupable(false);
		metaData.getColumn("electricaTexto").setSortable(true);
		metaData.getColumn("electricaTexto").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("electricaTexto").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("electricaTexto").setEditable(true);
		metaData.getColumn("electricaTexto").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("gascanalizadoPorcentaje", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("gascanalizadoPorcentaje", this.getMessage("forms.instalaciones.columns.gascanalizadoPorcentaje.header", locale)));
		metaData.getColumn("gascanalizadoPorcentaje").setGroupable(false);
		metaData.getColumn("gascanalizadoPorcentaje").setSortable(true);
		metaData.getColumn("gascanalizadoPorcentaje").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("gascanalizadoPorcentaje").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("gascanalizadoPorcentaje").setEditable(true);
		metaData.getColumn("gascanalizadoPorcentaje").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("instalacionesAcsnocentralgascanalizados", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("instalacionesAcsnocentralgascanalizados", this.getMessage("forms.instalaciones.columns.instalacionesAcsnocentralgascanalizados.header", locale)));
		metaData.getColumn("instalacionesAcsnocentralgascanalizados").setTooltip(this.getMessage("forms.instalaciones.columns.instalacionesAcsnocentralgascanalizados.description", locale));
		metaData.getColumn("instalacionesAcsnocentralgascanalizados").setGroupable(false);
		metaData.getColumn("instalacionesAcsnocentralgascanalizados").setSortable(true);
		metaData.getColumn("instalacionesAcsnocentralgascanalizados").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("instalacionesAcsnocentralgascanalizados").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("instalacionesAcsnocentralgascanalizados").setEditable(true);
		metaData.getColumn("instalacionesAcsnocentralgascanalizados").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("instalacionesAcsnocentralgasembotellados", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("instalacionesAcsnocentralgasembotellados", this.getMessage("forms.instalaciones.columns.instalacionesAcsnocentralgasembotellados.header", locale)));
		metaData.getColumn("instalacionesAcsnocentralgasembotellados").setTooltip(this.getMessage("forms.instalaciones.columns.instalacionesAcsnocentralgasembotellados.description", locale));
		metaData.getColumn("instalacionesAcsnocentralgasembotellados").setGroupable(false);
		metaData.getColumn("instalacionesAcsnocentralgasembotellados").setSortable(true);
		metaData.getColumn("instalacionesAcsnocentralgasembotellados").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("instalacionesAcsnocentralgasembotellados").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("instalacionesAcsnocentralgasembotellados").setEditable(true);
		metaData.getColumn("instalacionesAcsnocentralgasembotellados").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("instalacionesCalefaccionnocentralcalefaccionelectricas", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("instalacionesCalefaccionnocentralcalefaccionelectricas", this.getMessage("forms.instalaciones.columns.instalacionesCalefaccionnocentralcalefaccionelectricas.header", locale)));
		metaData.getColumn("instalacionesCalefaccionnocentralcalefaccionelectricas").setTooltip(this.getMessage("forms.instalaciones.columns.instalacionesCalefaccionnocentralcalefaccionelectricas.description", locale));
		metaData.getColumn("instalacionesCalefaccionnocentralcalefaccionelectricas").setGroupable(false);
		metaData.getColumn("instalacionesCalefaccionnocentralcalefaccionelectricas").setSortable(true);
		metaData.getColumn("instalacionesCalefaccionnocentralcalefaccionelectricas").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("instalacionesCalefaccionnocentralcalefaccionelectricas").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("instalacionesCalefaccionnocentralcalefaccionelectricas").setEditable(true);
		metaData.getColumn("instalacionesCalefaccionnocentralcalefaccionelectricas").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("instalacionesCalefaccionnocentralgascanalizados", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("instalacionesCalefaccionnocentralgascanalizados", this.getMessage("forms.instalaciones.columns.instalacionesCalefaccionnocentralgascanalizados.header", locale)));
		metaData.getColumn("instalacionesCalefaccionnocentralgascanalizados").setTooltip(this.getMessage("forms.instalaciones.columns.instalacionesCalefaccionnocentralgascanalizados.description", locale));
		metaData.getColumn("instalacionesCalefaccionnocentralgascanalizados").setGroupable(false);
		metaData.getColumn("instalacionesCalefaccionnocentralgascanalizados").setSortable(true);
		metaData.getColumn("instalacionesCalefaccionnocentralgascanalizados").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("instalacionesCalefaccionnocentralgascanalizados").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("instalacionesCalefaccionnocentralgascanalizados").setEditable(true);
		metaData.getColumn("instalacionesCalefaccionnocentralgascanalizados").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("observaciones", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("observaciones", this.getMessage("forms.instalaciones.columns.observaciones.header", locale)));
		metaData.getColumn("observaciones").setGroupable(false);
		metaData.getColumn("observaciones").setSortable(true);
		metaData.getColumn("observaciones").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("observaciones").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("observaciones").setEditable(true);
		metaData.getColumn("observaciones").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("refrigeracionNocolectivoAparatosenfachadas", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("refrigeracionNocolectivoAparatosenfachadas", this.getMessage("forms.instalaciones.columns.refrigeracionNocolectivoAparatosenfachadas.header", locale)));
		metaData.getColumn("refrigeracionNocolectivoAparatosenfachadas").setTooltip(this.getMessage("forms.instalaciones.columns.refrigeracionNocolectivoAparatosenfachadas.description", locale));
		metaData.getColumn("refrigeracionNocolectivoAparatosenfachadas").setGroupable(false);
		metaData.getColumn("refrigeracionNocolectivoAparatosenfachadas").setSortable(true);
		metaData.getColumn("refrigeracionNocolectivoAparatosenfachadas").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("refrigeracionNocolectivoAparatosenfachadas").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("refrigeracionNocolectivoAparatosenfachadas").setEditable(true);
		metaData.getColumn("refrigeracionNocolectivoAparatosenfachadas").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("refrigeracionNocolectivoIndividualporcentaje", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("refrigeracionNocolectivoIndividualporcentaje", this.getMessage("forms.instalaciones.columns.refrigeracionNocolectivoIndividualporcentaje.header", locale)));
		metaData.getColumn("refrigeracionNocolectivoIndividualporcentaje").setTooltip(this.getMessage("forms.instalaciones.columns.refrigeracionNocolectivoIndividualporcentaje.description", locale));
		metaData.getColumn("refrigeracionNocolectivoIndividualporcentaje").setGroupable(false);
		metaData.getColumn("refrigeracionNocolectivoIndividualporcentaje").setSortable(true);
		metaData.getColumn("refrigeracionNocolectivoIndividualporcentaje").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("refrigeracionNocolectivoIndividualporcentaje").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("refrigeracionNocolectivoIndividualporcentaje").setEditable(true);
		metaData.getColumn("refrigeracionNocolectivoIndividualporcentaje").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("saneamientoBajantesTexto", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("saneamientoBajantesTexto", this.getMessage("forms.instalaciones.columns.saneamientoBajantesTexto.header", locale)));
		metaData.getColumn("saneamientoBajantesTexto").setGroupable(false);
		metaData.getColumn("saneamientoBajantesTexto").setSortable(true);
		metaData.getColumn("saneamientoBajantesTexto").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("saneamientoBajantesTexto").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("saneamientoBajantesTexto").setEditable(true);
		metaData.getColumn("saneamientoBajantesTexto").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("saneamientoColectoresTexto", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("saneamientoColectoresTexto", this.getMessage("forms.instalaciones.columns.saneamientoColectoresTexto.header", locale)));
		metaData.getColumn("saneamientoColectoresTexto").setGroupable(false);
		metaData.getColumn("saneamientoColectoresTexto").setSortable(true);
		metaData.getColumn("saneamientoColectoresTexto").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("saneamientoColectoresTexto").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("saneamientoColectoresTexto").setEditable(true);
		metaData.getColumn("saneamientoColectoresTexto").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("ventilacionCuartoshumedosTexto", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("ventilacionCuartoshumedosTexto", this.getMessage("forms.instalaciones.columns.ventilacionCuartoshumedosTexto.header", locale)));
		metaData.getColumn("ventilacionCuartoshumedosTexto").setTooltip(this.getMessage("forms.instalaciones.columns.ventilacionCuartoshumedosTexto.description", locale));
		metaData.getColumn("ventilacionCuartoshumedosTexto").setGroupable(false);
		metaData.getColumn("ventilacionCuartoshumedosTexto").setSortable(true);
		metaData.getColumn("ventilacionCuartoshumedosTexto").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("ventilacionCuartoshumedosTexto").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("ventilacionCuartoshumedosTexto").setEditable(true);
		metaData.getColumn("ventilacionCuartoshumedosTexto").setHidden(true);

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

		datosExportacion.add("claveInforme", this.getMessage("forms.instalaciones.columns.claveInforme.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("inspeccion", this.getMessage("forms.instalaciones.columns.inspeccion.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("acsCaptadoressolares", this.getMessage("forms.instalaciones.columns.acsCaptadoressolares.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("acsCentralCombustibleTexto", this.getMessage("forms.instalaciones.columns.acsCentralCombustibleTexto.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("acsCentralTiene", this.getMessage("forms.instalaciones.columns.acsCentralTiene.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("acsNocentralCalentadoreselectricosporcentaje", this.getMessage("forms.instalaciones.columns.acsNocentralCalentadoreselectricosporcentaje.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("acsNocentralGascanalizadoporcentaje", this.getMessage("forms.instalaciones.columns.acsNocentralGascanalizadoporcentaje.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("acsNocentralGasembotelladoporcentaje", this.getMessage("forms.instalaciones.columns.acsNocentralGasembotelladoporcentaje.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("acsNocentralIndividualporcentaje", this.getMessage("forms.instalaciones.columns.acsNocentralIndividualporcentaje.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("acsNocentralOtrosporcentaje", this.getMessage("forms.instalaciones.columns.acsNocentralOtrosporcentaje.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("acsTiene", this.getMessage("forms.instalaciones.columns.acsTiene.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("calefaccionCentralCombustibleTexto", this.getMessage("forms.instalaciones.columns.calefaccionCentralCombustibleTexto.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("calefaccionCentralTexto", this.getMessage("forms.instalaciones.columns.calefaccionCentralTexto.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("calefaccionCentralTiene", this.getMessage("forms.instalaciones.columns.calefaccionCentralTiene.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("calefaccionNocentralCalderagasoleoporcentaje", this.getMessage("forms.instalaciones.columns.calefaccionNocentralCalderagasoleoporcentaje.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("calefaccionNocentralCalefaccionelectricaporcentaje", this.getMessage("forms.instalaciones.columns.calefaccionNocentralCalefaccionelectricaporcentaje.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("calefaccionNocentralGascanalizadoporcentaje", this.getMessage("forms.instalaciones.columns.calefaccionNocentralGascanalizadoporcentaje.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("calefaccionNocentralIndividualporcentaje", this.getMessage("forms.instalaciones.columns.calefaccionNocentralIndividualporcentaje.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("calefaccionNocentralOtrosporcentaje", this.getMessage("forms.instalaciones.columns.calefaccionNocentralOtrosporcentaje.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("calefaccionTiene", this.getMessage("forms.instalaciones.columns.calefaccionTiene.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("comunicacionesictTexto", this.getMessage("forms.instalaciones.columns.comunicacionesictTexto.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("comunicacionesictTiene", this.getMessage("forms.instalaciones.columns.comunicacionesictTiene.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("contraincendiosTiene", this.getMessage("forms.instalaciones.columns.contraincendiosTiene.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("contrarayoTexto", this.getMessage("forms.instalaciones.columns.contrarayoTexto.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("contrarayoTiene", this.getMessage("forms.instalaciones.columns.contrarayoTiene.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("electricaTexto", this.getMessage("forms.instalaciones.columns.electricaTexto.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("gascanalizadoPorcentaje", this.getMessage("forms.instalaciones.columns.gascanalizadoPorcentaje.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("gascanalizadoTiene", this.getMessage("forms.instalaciones.columns.gascanalizadoTiene.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("instalacionesAcsnocentralgascanalizados", this.getMessage("forms.instalaciones.columns.instalacionesAcsnocentralgascanalizados.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("instalacionesAcsnocentralgasembotellados", this.getMessage("forms.instalaciones.columns.instalacionesAcsnocentralgasembotellados.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("instalacionesCalefaccionnocentralcalefaccionelectricas", this.getMessage("forms.instalaciones.columns.instalacionesCalefaccionnocentralcalefaccionelectricas.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("instalacionesCalefaccionnocentralgascanalizados", this.getMessage("forms.instalaciones.columns.instalacionesCalefaccionnocentralgascanalizados.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("observaciones", this.getMessage("forms.instalaciones.columns.observaciones.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("refrigeracionColectivoTiene", this.getMessage("forms.instalaciones.columns.refrigeracionColectivoTiene.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("refrigeracionNocolectivoAparatosenfachadas", this.getMessage("forms.instalaciones.columns.refrigeracionNocolectivoAparatosenfachadas.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("refrigeracionNocolectivoIndividualporcentaje", this.getMessage("forms.instalaciones.columns.refrigeracionNocolectivoIndividualporcentaje.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("refrigeracionTiene", this.getMessage("forms.instalaciones.columns.refrigeracionTiene.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("saneamientoBajantesTexto", this.getMessage("forms.instalaciones.columns.saneamientoBajantesTexto.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("saneamientoColectoresTexto", this.getMessage("forms.instalaciones.columns.saneamientoColectoresTexto.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("ventilacionCuartoshumedosSinventilacion", this.getMessage("forms.instalaciones.columns.ventilacionCuartoshumedosSinventilacion.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("ventilacionCuartoshumedosTexto", this.getMessage("forms.instalaciones.columns.ventilacionCuartoshumedosTexto.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("ventilacionTiene", this.getMessage("forms.instalaciones.columns.ventilacionTiene.header", locale), TipoCampoExportacion.STRING);

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
		InstalacionesListadoVO instance = (InstalacionesListadoVO) rawInstance;

		List<String> excelRow = new ArrayList<String>();

		excelRow.add(FormData2Java.toString(instance.getClaveInforme()));
		excelRow.add(FormData2Java.toString(instance.getInspeccionLabel()));
		excelRow.add(FormData2Java.toString(instance.getAcsCaptadoressolares()));
		excelRow.add(instance.getAcsCentralCombustibleTexto());
		//excelRow.add(FormData2Java.toString(instance.getAcsCentralTiene()));
		if (instance.getAcsCentralTiene()!=null){
			excelRow.add(this.getMessage("forms.instalaciones.columns.acsCentralTiene." + instance.getAcsCentralTiene(), locale));
		}else{
			excelRow.add("null");
		}	

		excelRow.add(instance.getAcsNocentralCalentadoreselectricosporcentaje());
		excelRow.add(instance.getAcsNocentralGascanalizadoporcentaje());
		excelRow.add(instance.getAcsNocentralGasembotelladoporcentaje());
		excelRow.add(instance.getAcsNocentralIndividualporcentaje());
		excelRow.add(instance.getAcsNocentralOtrosporcentaje());

		//excelRow.add(FormData2Java.toString(instance.getAcsTiene()));
		if (instance.getAcsTiene()!=null){
			excelRow.add(this.getMessage("forms.instalaciones.columns.acsTiene." + instance.getAcsTiene(), locale));
		}else{
			excelRow.add("null");
		}	

		excelRow.add(instance.getCalefaccionCentralCombustibleTexto());
		excelRow.add(instance.getCalefaccionCentralTexto());

		//excelRow.add(FormData2Java.toString(instance.getCalefaccionCentralTiene()));
		if (instance.getCalefaccionCentralTiene()!=null){
			excelRow.add(this.getMessage("forms.instalaciones.columns.calefaccionCentralTiene." + instance.getCalefaccionCentralTiene(), locale));
		}else{
			excelRow.add("null");
		}	

		excelRow.add(instance.getCalefaccionNocentralCalderagasoleoporcentaje());
		excelRow.add(instance.getCalefaccionNocentralCalefaccionelectricaporcentaje());
		excelRow.add(instance.getCalefaccionNocentralGascanalizadoporcentaje());
		excelRow.add(instance.getCalefaccionNocentralIndividualporcentaje());
		excelRow.add(instance.getCalefaccionNocentralOtrosporcentaje());

		//excelRow.add(FormData2Java.toString(instance.getCalefaccionTiene()));
		if (instance.getCalefaccionTiene()!=null){
			excelRow.add(this.getMessage("forms.instalaciones.columns.calefaccionTiene." + instance.getCalefaccionTiene(), locale));
		}else{
			excelRow.add("null");
		}	

		excelRow.add(instance.getComunicacionesictTexto());

		//excelRow.add(FormData2Java.toString(instance.getComunicacionesictTiene()));
		if (instance.getComunicacionesictTiene()!=null){
			excelRow.add(this.getMessage("forms.instalaciones.columns.comunicacionesictTiene." + instance.getComunicacionesictTiene(), locale));
		}else{
			excelRow.add("null");
		}	

		//excelRow.add(FormData2Java.toString(instance.getContraincendiosTiene()));
		if (instance.getContraincendiosTiene()!=null){
			excelRow.add(this.getMessage("forms.instalaciones.columns.contraincendiosTiene." + instance.getContraincendiosTiene(), locale));
		}else{
			excelRow.add("null");
		}	

		excelRow.add(instance.getContrarayoTexto());

		//excelRow.add(FormData2Java.toString(instance.getContrarayoTiene()));
		if (instance.getContrarayoTiene()!=null){
			excelRow.add(this.getMessage("forms.instalaciones.columns.contrarayoTiene." + instance.getContrarayoTiene(), locale));
		}else{
			excelRow.add("null");
		}	

		excelRow.add(instance.getElectricaTexto());
		excelRow.add(instance.getGascanalizadoPorcentaje());

		//excelRow.add(FormData2Java.toString(instance.getGascanalizadoTiene()));
		if (instance.getGascanalizadoTiene()!=null){
			excelRow.add(this.getMessage("forms.instalaciones.columns.gascanalizadoTiene." + instance.getGascanalizadoTiene(), locale));
		}else{
			excelRow.add("null");
		}	

		excelRow.add(instance.getInstalacionesAcsnocentralgascanalizados());
		excelRow.add(instance.getInstalacionesAcsnocentralgasembotellados());
		excelRow.add(instance.getInstalacionesCalefaccionnocentralcalefaccionelectricas());
		excelRow.add(instance.getInstalacionesCalefaccionnocentralgascanalizados());
		excelRow.add(instance.getObservaciones());

		//excelRow.add(FormData2Java.toString(instance.getRefrigeracionColectivoTiene()));
		if (instance.getRefrigeracionColectivoTiene()!=null){
			excelRow.add(this.getMessage("forms.instalaciones.columns.refrigeracionColectivoTiene." + instance.getRefrigeracionColectivoTiene(), locale));
		}else{
			excelRow.add("null");
		}	

		excelRow.add(instance.getRefrigeracionNocolectivoAparatosenfachadas());
		excelRow.add(instance.getRefrigeracionNocolectivoIndividualporcentaje());

		//excelRow.add(FormData2Java.toString(instance.getRefrigeracionTiene()));
		if (instance.getRefrigeracionTiene()!=null){
			excelRow.add(this.getMessage("forms.instalaciones.columns.refrigeracionTiene." + instance.getRefrigeracionTiene(), locale));
		}else{
			excelRow.add("null");
		}	

		excelRow.add(instance.getSaneamientoBajantesTexto());
		excelRow.add(instance.getSaneamientoColectoresTexto());

		//excelRow.add(FormData2Java.toString(instance.getVentilacionCuartoshumedosSinventilacion()));
		if (instance.getVentilacionCuartoshumedosSinventilacion()!=null){
			excelRow.add(this.getMessage("forms.instalaciones.columns.ventilacionCuartoshumedosSinventilacion." + instance.getVentilacionCuartoshumedosSinventilacion(), locale));
		}else{
			excelRow.add("null");
		}	

		excelRow.add(instance.getVentilacionCuartoshumedosTexto());

		//excelRow.add(FormData2Java.toString(instance.getVentilacionTiene()));
		if (instance.getVentilacionTiene()!=null){
			excelRow.add(this.getMessage("forms.instalaciones.columns.ventilacionTiene." + instance.getVentilacionTiene(), locale));
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
	 * Rellena una instancia de InstalacionesFormVO con el contenido de un
	 * formulario recibido en formato Map<String, ?>
	 */
	protected void setFormData(InstalacionesFormVO record, Map<String, ?> formData) throws GenericBusinessException {
		String formDataStr = null;
		if (!StringUtils.isEmpty(formData, "inspeccionId")) {
			formDataStr = (String) formData.get("inspeccionId");
			record.setInspeccionId(FormData2Java.toInteger(formDataStr));

		}
		if (formData.containsKey("acsCaptadoressolares")) {
			formDataStr = (String) formData.get("acsCaptadoressolares");
			record.setAcsCaptadoressolares(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("acsCentralCombustibleTexto")) {
			formDataStr = (String) formData.get("acsCentralCombustibleTexto");
			record.setAcsCentralCombustibleTexto(formDataStr);
		}
		if (formData.containsKey("acsCentralTiene")) {
			formDataStr = (String) formData.get("acsCentralTiene");
			record.setAcsCentralTiene(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("acsNocentralCalentadoreselectricosporcentaje")) {
			formDataStr = (String) formData.get("acsNocentralCalentadoreselectricosporcentaje");
			record.setAcsNocentralCalentadoreselectricosporcentaje(formDataStr);
		}
		if (formData.containsKey("acsNocentralGascanalizadoporcentaje")) {
			formDataStr = (String) formData.get("acsNocentralGascanalizadoporcentaje");
			record.setAcsNocentralGascanalizadoporcentaje(formDataStr);
		}
		if (formData.containsKey("acsNocentralGasembotelladoporcentaje")) {
			formDataStr = (String) formData.get("acsNocentralGasembotelladoporcentaje");
			record.setAcsNocentralGasembotelladoporcentaje(formDataStr);
		}
		if (formData.containsKey("acsNocentralIndividualporcentaje")) {
			formDataStr = (String) formData.get("acsNocentralIndividualporcentaje");
			record.setAcsNocentralIndividualporcentaje(formDataStr);
		}
		if (formData.containsKey("acsNocentralOtrosporcentaje")) {
			formDataStr = (String) formData.get("acsNocentralOtrosporcentaje");
			record.setAcsNocentralOtrosporcentaje(formDataStr);
		}
		if (formData.containsKey("acsTiene")) {
			formDataStr = (String) formData.get("acsTiene");
			record.setAcsTiene(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("calefaccionCentralCombustibleTexto")) {
			formDataStr = (String) formData.get("calefaccionCentralCombustibleTexto");
			record.setCalefaccionCentralCombustibleTexto(formDataStr);
		}
		if (formData.containsKey("calefaccionCentralTexto")) {
			formDataStr = (String) formData.get("calefaccionCentralTexto");
			record.setCalefaccionCentralTexto(formDataStr);
		}
		if (formData.containsKey("calefaccionCentralTiene")) {
			formDataStr = (String) formData.get("calefaccionCentralTiene");
			record.setCalefaccionCentralTiene(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("calefaccionNocentralCalderagasoleoporcentaje")) {
			formDataStr = (String) formData.get("calefaccionNocentralCalderagasoleoporcentaje");
			record.setCalefaccionNocentralCalderagasoleoporcentaje(formDataStr);
		}
		if (formData.containsKey("calefaccionNocentralCalefaccionelectricaporcentaje")) {
			formDataStr = (String) formData.get("calefaccionNocentralCalefaccionelectricaporcentaje");
			record.setCalefaccionNocentralCalefaccionelectricaporcentaje(formDataStr);
		}
		if (formData.containsKey("calefaccionNocentralGascanalizadoporcentaje")) {
			formDataStr = (String) formData.get("calefaccionNocentralGascanalizadoporcentaje");
			record.setCalefaccionNocentralGascanalizadoporcentaje(formDataStr);
		}
		if (formData.containsKey("calefaccionNocentralIndividualporcentaje")) {
			formDataStr = (String) formData.get("calefaccionNocentralIndividualporcentaje");
			record.setCalefaccionNocentralIndividualporcentaje(formDataStr);
		}
		if (formData.containsKey("calefaccionNocentralOtrosporcentaje")) {
			formDataStr = (String) formData.get("calefaccionNocentralOtrosporcentaje");
			record.setCalefaccionNocentralOtrosporcentaje(formDataStr);
		}
		if (formData.containsKey("calefaccionTiene")) {
			formDataStr = (String) formData.get("calefaccionTiene");
			record.setCalefaccionTiene(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("comunicacionesictTexto")) {
			formDataStr = (String) formData.get("comunicacionesictTexto");
			record.setComunicacionesictTexto(formDataStr);
		}
		if (formData.containsKey("comunicacionesictTiene")) {
			formDataStr = (String) formData.get("comunicacionesictTiene");
			record.setComunicacionesictTiene(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("contraincendiosTiene")) {
			formDataStr = (String) formData.get("contraincendiosTiene");
			record.setContraincendiosTiene(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("contrarayoTexto")) {
			formDataStr = (String) formData.get("contrarayoTexto");
			record.setContrarayoTexto(formDataStr);
		}
		if (formData.containsKey("contrarayoTiene")) {
			formDataStr = (String) formData.get("contrarayoTiene");
			record.setContrarayoTiene(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("electricaTexto")) {
			formDataStr = (String) formData.get("electricaTexto");
			record.setElectricaTexto(formDataStr);
		}
		if (formData.containsKey("gascanalizadoPorcentaje")) {
			formDataStr = (String) formData.get("gascanalizadoPorcentaje");
			record.setGascanalizadoPorcentaje(formDataStr);
		}
		if (formData.containsKey("gascanalizadoTiene")) {
			formDataStr = (String) formData.get("gascanalizadoTiene");
			record.setGascanalizadoTiene(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("instalacionesAcsnocentralgascanalizados")) {
			formDataStr = (String) formData.get("instalacionesAcsnocentralgascanalizados");
			record.setInstalacionesAcsnocentralgascanalizados(formDataStr);
		}
		if (formData.containsKey("instalacionesAcsnocentralgasembotellados")) {
			formDataStr = (String) formData.get("instalacionesAcsnocentralgasembotellados");
			record.setInstalacionesAcsnocentralgasembotellados(formDataStr);
		}
		if (formData.containsKey("instalacionesCalefaccionnocentralcalefaccionelectricas")) {
			formDataStr = (String) formData.get("instalacionesCalefaccionnocentralcalefaccionelectricas");
			record.setInstalacionesCalefaccionnocentralcalefaccionelectricas(formDataStr);
		}
		if (formData.containsKey("instalacionesCalefaccionnocentralgascanalizados")) {
			formDataStr = (String) formData.get("instalacionesCalefaccionnocentralgascanalizados");
			record.setInstalacionesCalefaccionnocentralgascanalizados(formDataStr);
		}
		if (formData.containsKey("observaciones")) {
			formDataStr = (String) formData.get("observaciones");
			record.setObservaciones(formDataStr);
		}
		if (formData.containsKey("refrigeracionColectivoTiene")) {
			formDataStr = (String) formData.get("refrigeracionColectivoTiene");
			record.setRefrigeracionColectivoTiene(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("refrigeracionNocolectivoAparatosenfachadas")) {
			formDataStr = (String) formData.get("refrigeracionNocolectivoAparatosenfachadas");
			record.setRefrigeracionNocolectivoAparatosenfachadas(formDataStr);
		}
		if (formData.containsKey("refrigeracionNocolectivoIndividualporcentaje")) {
			formDataStr = (String) formData.get("refrigeracionNocolectivoIndividualporcentaje");
			record.setRefrigeracionNocolectivoIndividualporcentaje(formDataStr);
		}
		if (formData.containsKey("refrigeracionTiene")) {
			formDataStr = (String) formData.get("refrigeracionTiene");
			record.setRefrigeracionTiene(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("saneamientoBajantesTexto")) {
			formDataStr = (String) formData.get("saneamientoBajantesTexto");
			record.setSaneamientoBajantesTexto(formDataStr);
		}
		if (formData.containsKey("saneamientoColectoresTexto")) {
			formDataStr = (String) formData.get("saneamientoColectoresTexto");
			record.setSaneamientoColectoresTexto(formDataStr);
		}
		if (formData.containsKey("ventilacionCuartoshumedosSinventilacion")) {
			formDataStr = (String) formData.get("ventilacionCuartoshumedosSinventilacion");
			record.setVentilacionCuartoshumedosSinventilacion(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("ventilacionCuartoshumedosTexto")) {
			formDataStr = (String) formData.get("ventilacionCuartoshumedosTexto");
			record.setVentilacionCuartoshumedosTexto(formDataStr);
		}
		if (formData.containsKey("ventilacionTiene")) {
			formDataStr = (String) formData.get("ventilacionTiene");
			record.setVentilacionTiene(FormData2Java.toInteger(formDataStr));
		}
	}

}
