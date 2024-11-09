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
import es.caib.avaedi.logic.bo.AcusticaRuidoInstalacionesBO;
import es.caib.avaedi.logic.bo.InspeccionBO;
import es.caib.avaedi.logic.util.Keys;
import es.caib.avaedi.logic.vo.AcusticaRuidoInstalacionesFormVO;
import es.caib.avaedi.logic.vo.AcusticaRuidoInstalacionesListadoVO;
import es.caib.avaedi.logic.vo.AcusticasListadoVO;

/**
 * Servicio para tratar el formulario: AcusticaRuidoInstalaciones
 * 
 * @author agarcia@at4.net
 * 
 */
@Service("acusticaruidoinstalaciones")
public class AcusticaRuidoInstalacionesService extends InspeccionBaseService<AcusticaRuidoInstalacionesBO, AcusticaRuidoInstalacionesListadoVO, AcusticaRuidoInstalacionesFormVO> {

	/**
	 * The logger object.
	 */
	private static Logger log = LogService.getLogger(AcusticaRuidoInstalacionesService.class);

	/**
	 * Bean para acceder a los métodos de negocio: AcusticaRuidoInstalaciones
	 */
	@Autowired
	@Qualifier("AcusticaRuidoInstalacionesBean")
	protected AcusticaRuidoInstalacionesBO mainBO;

	/**
	 * Bean para acceder a los métodos de negocio: AcusticaRuidoInstalaciones
	 * 
	 * @param bean
	 *            the bean to set
	 */
	protected AcusticaRuidoInstalacionesBO getMainBO() {
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
			formItem.setText(this.getMessage("forms.acusticaruidoinstalaciones.title", locale));
		}

		GridMetaData metaData = this.getBaseMetaData(formItem, locale);

		//Nombre de la clase js de formulario
		metaData.setFormClassName("AcusticaRuidoInstalacionesForm");

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
		/*metaData.addColumn(new GridColumnMetaData("claveInforme", this.getMessage("forms.acusticaruidoinstalaciones.columns.claveInforme.header", locale)));
		metaData.getColumn("claveInforme").setGroupable(false);
		metaData.getColumn("claveInforme").setSortable(true);
		metaData.getColumn("claveInforme").setSofaFilter(GridColumnFilter.TYPE_NUMERIC);*/

		//Creamos el registro para el record
		/*metaData.addRecordField(new GridRecordFieldMetaData("inspeccionId", GridRecordFieldMetaData.INT_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("inspeccionLabel", GridRecordFieldMetaData.INT_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("inspeccion", "inspeccionLabel", GridRecordFieldMetaData.INT_TYPE));*/

		/** Creamos la columna */
		/*metaData.addColumn(new GridColumnMetaData("inspeccion", this.getMessage("forms.acusticaruidoinstalaciones.columns.inspeccion.header", locale)));
		metaData.getColumn("inspeccion").setGroupable(true);
		metaData.getColumn("inspeccion").setSortable(true);
		metaData.getColumn("inspeccion").setSofaFilter(GridColumnFilter.TYPE_MULTICOMBO);
		metaData.getColumn("inspeccion").setRelatedForm("Inspeccion");

		metaData.getColumn("inspeccion").setEditable(true);*/

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("equiposInstalacionesColindantes", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("equiposInstalacionesColindantes", this.getMessage("forms.acusticaruidoinstalaciones.columns.equiposInstalacionesColindantes.header", locale)));
		metaData.getColumn("equiposInstalacionesColindantes").setTooltip(this.getMessage("forms.acusticaruidoinstalaciones.columns.equiposInstalacionesColindantes.description", locale));
		metaData.getColumn("equiposInstalacionesColindantes").setGroupable(false);
		metaData.getColumn("equiposInstalacionesColindantes").setSortable(true);
		metaData.getColumn("equiposInstalacionesColindantes").setSofaFilter(GridColumnFilter.TYPE_LIST);
		
		metaData.getColumn("equiposInstalacionesColindantes").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] equiposInstalacionesColindantesStore = new String[][]{
				{ String.valueOf(Keys.ACCESIBILIDAD_AJUSTES_RAZONABLES_SI), this.getMessage("forms.acusticaruidoinstalaciones.columns.equiposInstalacionesColindantes." + Keys.ACCESIBILIDAD_AJUSTES_RAZONABLES_SI, locale)},
				{ String.valueOf(Keys.ACCESIBILIDAD_AJUSTES_RAZONABLES_NO), this.getMessage("forms.acusticaruidoinstalaciones.columns.equiposInstalacionesColindantes." + Keys.ACCESIBILIDAD_AJUSTES_RAZONABLES_NO, locale)},
		};

		metaData.getColumn("equiposInstalacionesColindantes").setSofaStoreValues(equiposInstalacionesColindantesStore);

		metaData.getColumn("equiposInstalacionesColindantes").setEditable(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("equiposInstalacionesConductosAnclados", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("equiposInstalacionesConductosAnclados", this.getMessage("forms.acusticaruidoinstalaciones.columns.equiposInstalacionesConductosAnclados.header", locale)));
		metaData.getColumn("equiposInstalacionesConductosAnclados").setTooltip(this.getMessage("forms.acusticaruidoinstalaciones.columns.equiposInstalacionesConductosAnclados.description", locale));
		metaData.getColumn("equiposInstalacionesConductosAnclados").setGroupable(false);
		metaData.getColumn("equiposInstalacionesConductosAnclados").setSortable(true);
		metaData.getColumn("equiposInstalacionesConductosAnclados").setSofaFilter(GridColumnFilter.TYPE_LIST);
		
		metaData.getColumn("equiposInstalacionesConductosAnclados").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] equiposInstalacionesConductosAncladosStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NS), this.getMessage("forms.acusticaruidoinstalaciones.columns.equiposInstalacionesConductosAnclados." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NS, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_SI), this.getMessage("forms.acusticaruidoinstalaciones.columns.equiposInstalacionesConductosAnclados." + Keys.ACUSTICA_RUIDO_INSTALACIONES_SI, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NO), this.getMessage("forms.acusticaruidoinstalaciones.columns.equiposInstalacionesConductosAnclados." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NO, locale)},
		};

		metaData.getColumn("equiposInstalacionesConductosAnclados").setSofaStoreValues(equiposInstalacionesConductosAncladosStore);

		metaData.getColumn("equiposInstalacionesConductosAnclados").setEditable(true);
		metaData.getColumn("equiposInstalacionesConductosAnclados").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("equiposInstalacionesConectoresFlexibles", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("equiposInstalacionesConectoresFlexibles", this.getMessage("forms.acusticaruidoinstalaciones.columns.equiposInstalacionesConectoresFlexibles.header", locale)));
		metaData.getColumn("equiposInstalacionesConectoresFlexibles").setTooltip(this.getMessage("forms.acusticaruidoinstalaciones.columns.equiposInstalacionesConectoresFlexibles.description", locale));
		metaData.getColumn("equiposInstalacionesConectoresFlexibles").setGroupable(false);
		metaData.getColumn("equiposInstalacionesConectoresFlexibles").setSortable(true);
		metaData.getColumn("equiposInstalacionesConectoresFlexibles").setSofaFilter(GridColumnFilter.TYPE_LIST);
		
		metaData.getColumn("equiposInstalacionesConectoresFlexibles").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] equiposInstalacionesConectoresFlexiblesStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NS), this.getMessage("forms.acusticaruidoinstalaciones.columns.equiposInstalacionesConectoresFlexibles." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NS, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_SI), this.getMessage("forms.acusticaruidoinstalaciones.columns.equiposInstalacionesConectoresFlexibles." + Keys.ACUSTICA_RUIDO_INSTALACIONES_SI, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NO), this.getMessage("forms.acusticaruidoinstalaciones.columns.equiposInstalacionesConectoresFlexibles." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NO, locale)},
		};

		metaData.getColumn("equiposInstalacionesConectoresFlexibles").setSofaStoreValues(equiposInstalacionesConectoresFlexiblesStore);

		metaData.getColumn("equiposInstalacionesConectoresFlexibles").setEditable(true);
		metaData.getColumn("equiposInstalacionesConectoresFlexibles").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("equiposInstalacionesHolgurasSelladas", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("equiposInstalacionesHolgurasSelladas", this.getMessage("forms.acusticaruidoinstalaciones.columns.equiposInstalacionesHolgurasSelladas.header", locale)));
		metaData.getColumn("equiposInstalacionesHolgurasSelladas").setTooltip(this.getMessage("forms.acusticaruidoinstalaciones.columns.equiposInstalacionesHolgurasSelladas.description", locale));
		metaData.getColumn("equiposInstalacionesHolgurasSelladas").setGroupable(false);
		metaData.getColumn("equiposInstalacionesHolgurasSelladas").setSortable(true);
		metaData.getColumn("equiposInstalacionesHolgurasSelladas").setSofaFilter(GridColumnFilter.TYPE_LIST);
		
		metaData.getColumn("equiposInstalacionesHolgurasSelladas").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] equiposInstalacionesHolgurasSelladasStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NS), this.getMessage("forms.acusticaruidoinstalaciones.columns.equiposInstalacionesHolgurasSelladas." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NS, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_SI), this.getMessage("forms.acusticaruidoinstalaciones.columns.equiposInstalacionesHolgurasSelladas." + Keys.ACUSTICA_RUIDO_INSTALACIONES_SI, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NO), this.getMessage("forms.acusticaruidoinstalaciones.columns.equiposInstalacionesHolgurasSelladas." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NO, locale)},
		};

		metaData.getColumn("equiposInstalacionesHolgurasSelladas").setSofaStoreValues(equiposInstalacionesHolgurasSelladasStore);

		metaData.getColumn("equiposInstalacionesHolgurasSelladas").setEditable(true);
		metaData.getColumn("equiposInstalacionesHolgurasSelladas").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("equiposInstalacionesRuidoMolesto", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("equiposInstalacionesRuidoMolesto", this.getMessage("forms.acusticaruidoinstalaciones.columns.equiposInstalacionesRuidoMolesto.header", locale)));
		metaData.getColumn("equiposInstalacionesRuidoMolesto").setTooltip(this.getMessage("forms.acusticaruidoinstalaciones.columns.equiposInstalacionesRuidoMolesto.description", locale));
		metaData.getColumn("equiposInstalacionesRuidoMolesto").setGroupable(false);
		metaData.getColumn("equiposInstalacionesRuidoMolesto").setSortable(true);
		metaData.getColumn("equiposInstalacionesRuidoMolesto").setSofaFilter(GridColumnFilter.TYPE_LIST);
		
		metaData.getColumn("equiposInstalacionesRuidoMolesto").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] equiposInstalacionesRuidoMolestoStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NS), this.getMessage("forms.acusticaruidoinstalaciones.columns.equiposInstalacionesRuidoMolesto." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NS, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_SI), this.getMessage("forms.acusticaruidoinstalaciones.columns.equiposInstalacionesRuidoMolesto." + Keys.ACUSTICA_RUIDO_INSTALACIONES_SI, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NO), this.getMessage("forms.acusticaruidoinstalaciones.columns.equiposInstalacionesRuidoMolesto." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NO, locale)},
		};

		metaData.getColumn("equiposInstalacionesRuidoMolesto").setSofaStoreValues(equiposInstalacionesRuidoMolestoStore);

		metaData.getColumn("equiposInstalacionesRuidoMolesto").setEditable(true);
		metaData.getColumn("equiposInstalacionesRuidoMolesto").setHidden(true);
		
		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("equiposInstalacionesRuidoMolestoTipoLocalizacion", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("equiposInstalacionesRuidoMolestoTipoLocalizacion", this.getMessage("forms.acusticaruidoinstalaciones.columns.equiposInstalacionesRuidoMolestoTipoLocalizacion.header", locale)));
		metaData.getColumn("equiposInstalacionesRuidoMolestoTipoLocalizacion").setTooltip(this.getMessage("forms.acusticaruidoinstalaciones.columns.equiposInstalacionesRuidoMolestoTipoLocalizacion.description", locale));
		metaData.getColumn("equiposInstalacionesRuidoMolestoTipoLocalizacion").setGroupable(false);
		metaData.getColumn("equiposInstalacionesRuidoMolestoTipoLocalizacion").setSortable(true);
		metaData.getColumn("equiposInstalacionesRuidoMolestoTipoLocalizacion").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("equiposInstalacionesRuidoMolestoTipoLocalizacion").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("equiposInstalacionesRuidoMolestoTipoLocalizacion").setEditable(true);
		metaData.getColumn("equiposInstalacionesRuidoMolestoTipoLocalizacion").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("equiposInstalacionesSistemaAmortiguante", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("equiposInstalacionesSistemaAmortiguante", this.getMessage("forms.acusticaruidoinstalaciones.columns.equiposInstalacionesSistemaAmortiguante.header", locale)));
		metaData.getColumn("equiposInstalacionesSistemaAmortiguante").setTooltip(this.getMessage("forms.acusticaruidoinstalaciones.columns.equiposInstalacionesSistemaAmortiguante.description", locale));
		metaData.getColumn("equiposInstalacionesSistemaAmortiguante").setGroupable(false);
		metaData.getColumn("equiposInstalacionesSistemaAmortiguante").setSortable(true);
		metaData.getColumn("equiposInstalacionesSistemaAmortiguante").setSofaFilter(GridColumnFilter.TYPE_LIST);
		
		metaData.getColumn("equiposInstalacionesSistemaAmortiguante").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] equiposInstalacionesSistemaAmortiguanteStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NS), this.getMessage("forms.acusticaruidoinstalaciones.columns.equiposInstalacionesSistemaAmortiguante." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NS, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_SI), this.getMessage("forms.acusticaruidoinstalaciones.columns.equiposInstalacionesSistemaAmortiguante." + Keys.ACUSTICA_RUIDO_INSTALACIONES_SI, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NO), this.getMessage("forms.acusticaruidoinstalaciones.columns.equiposInstalacionesSistemaAmortiguante." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NO, locale)},
		};

		metaData.getColumn("equiposInstalacionesSistemaAmortiguante").setSofaStoreValues(equiposInstalacionesSistemaAmortiguanteStore);

		metaData.getColumn("equiposInstalacionesSistemaAmortiguante").setEditable(true);
		metaData.getColumn("equiposInstalacionesSistemaAmortiguante").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("equiposInstalacionesZonasExteriores", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("equiposInstalacionesZonasExteriores", this.getMessage("forms.acusticaruidoinstalaciones.columns.equiposInstalacionesZonasExteriores.header", locale)));
		metaData.getColumn("equiposInstalacionesZonasExteriores").setTooltip(this.getMessage("forms.acusticaruidoinstalaciones.columns.equiposInstalacionesZonasExteriores.description", locale));
		metaData.getColumn("equiposInstalacionesZonasExteriores").setGroupable(false);
		metaData.getColumn("equiposInstalacionesZonasExteriores").setSortable(true);
		metaData.getColumn("equiposInstalacionesZonasExteriores").setSofaFilter(GridColumnFilter.TYPE_LIST);
		
		metaData.getColumn("equiposInstalacionesZonasExteriores").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] equiposInstalacionesZonasExterioresStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_SI), this.getMessage("forms.acusticaruidoinstalaciones.columns.equiposInstalacionesZonasExteriores." + Keys.ACUSTICA_RUIDO_INSTALACIONES_SI, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NO), this.getMessage("forms.acusticaruidoinstalaciones.columns.equiposInstalacionesZonasExteriores." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NO, locale)},
		};

		metaData.getColumn("equiposInstalacionesZonasExteriores").setSofaStoreValues(equiposInstalacionesZonasExterioresStore);

		metaData.getColumn("equiposInstalacionesZonasExteriores").setEditable(true);
		metaData.getColumn("equiposInstalacionesZonasExteriores").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("equiposInstalacionesZonasExterioresPantallas", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("equiposInstalacionesZonasExterioresPantallas", this.getMessage("forms.acusticaruidoinstalaciones.columns.equiposInstalacionesZonasExterioresPantallas.header", locale)));
		metaData.getColumn("equiposInstalacionesZonasExterioresPantallas").setTooltip(this.getMessage("forms.acusticaruidoinstalaciones.columns.equiposInstalacionesZonasExterioresPantallas.description", locale));
		metaData.getColumn("equiposInstalacionesZonasExterioresPantallas").setGroupable(false);
		metaData.getColumn("equiposInstalacionesZonasExterioresPantallas").setSortable(true);
		metaData.getColumn("equiposInstalacionesZonasExterioresPantallas").setSofaFilter(GridColumnFilter.TYPE_LIST);
		
		metaData.getColumn("equiposInstalacionesZonasExterioresPantallas").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] equiposInstalacionesZonasExterioresPantallasStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NS), this.getMessage("forms.acusticaruidoinstalaciones.columns.equiposInstalacionesZonasExterioresPantallas." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NS, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_SI), this.getMessage("forms.acusticaruidoinstalaciones.columns.equiposInstalacionesZonasExterioresPantallas." + Keys.ACUSTICA_RUIDO_INSTALACIONES_SI, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NO), this.getMessage("forms.acusticaruidoinstalaciones.columns.equiposInstalacionesZonasExterioresPantallas." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NO, locale)},
		};

		metaData.getColumn("equiposInstalacionesZonasExterioresPantallas").setSofaStoreValues(equiposInstalacionesZonasExterioresPantallasStore);

		metaData.getColumn("equiposInstalacionesZonasExterioresPantallas").setEditable(true);
		metaData.getColumn("equiposInstalacionesZonasExterioresPantallas").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("observaciones", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("observaciones", this.getMessage("forms.acusticaruidoinstalaciones.columns.observaciones.header", locale)));
		metaData.getColumn("observaciones").setGroupable(false);
		metaData.getColumn("observaciones").setSortable(true);
		metaData.getColumn("observaciones").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("observaciones").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("observaciones").setEditable(true);
		metaData.getColumn("observaciones").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("otrasAscensoresColindantes", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("otrasAscensoresColindantes", this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasAscensoresColindantes.header", locale)));
		metaData.getColumn("otrasAscensoresColindantes").setGroupable(false);
		metaData.getColumn("otrasAscensoresColindantes").setSortable(true);
		metaData.getColumn("otrasAscensoresColindantes").setSofaFilter(GridColumnFilter.TYPE_LIST);
		
		metaData.getColumn("otrasAscensoresColindantes").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] otrasAscensoresColindantesStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NS), this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasAscensoresColindantes." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NS, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_SI), this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasAscensoresColindantes." + Keys.ACUSTICA_RUIDO_INSTALACIONES_SI, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NO), this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasAscensoresColindantes." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NO, locale)},
		};

		metaData.getColumn("otrasAscensoresColindantes").setSofaStoreValues(otrasAscensoresColindantesStore);

		metaData.getColumn("otrasAscensoresColindantes").setEditable(true);
		metaData.getColumn("otrasAscensoresColindantes").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("otrasAscensoresCuadroManiobras", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("otrasAscensoresCuadroManiobras", this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasAscensoresCuadroManiobras.header", locale)));
		metaData.getColumn("otrasAscensoresCuadroManiobras").setTooltip(this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasAscensoresCuadroManiobras.description", locale));
		metaData.getColumn("otrasAscensoresCuadroManiobras").setGroupable(false);
		metaData.getColumn("otrasAscensoresCuadroManiobras").setSortable(true);
		metaData.getColumn("otrasAscensoresCuadroManiobras").setSofaFilter(GridColumnFilter.TYPE_LIST);
		
		metaData.getColumn("otrasAscensoresCuadroManiobras").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] otrasAscensoresCuadroManiobrasStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NS), this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasAscensoresCuadroManiobras." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NS, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_SI), this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasAscensoresCuadroManiobras." + Keys.ACUSTICA_RUIDO_INSTALACIONES_SI, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NO), this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasAscensoresCuadroManiobras." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NO, locale)},
		};

		metaData.getColumn("otrasAscensoresCuadroManiobras").setSofaStoreValues(otrasAscensoresCuadroManiobrasStore);

		metaData.getColumn("otrasAscensoresCuadroManiobras").setEditable(true);
		metaData.getColumn("otrasAscensoresCuadroManiobras").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("otrasAscensoresCuartoMaquinas", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("otrasAscensoresCuartoMaquinas", this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasAscensoresCuartoMaquinas.header", locale)));
		metaData.getColumn("otrasAscensoresCuartoMaquinas").setTooltip(this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasAscensoresCuartoMaquinas.description", locale));
		metaData.getColumn("otrasAscensoresCuartoMaquinas").setGroupable(false);
		metaData.getColumn("otrasAscensoresCuartoMaquinas").setSortable(true);
		metaData.getColumn("otrasAscensoresCuartoMaquinas").setSofaFilter(GridColumnFilter.TYPE_LIST);
		
		metaData.getColumn("otrasAscensoresCuartoMaquinas").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] otrasAscensoresCuartoMaquinasStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NS), this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasAscensoresCuartoMaquinas." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NS, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_SI), this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasAscensoresCuartoMaquinas." + Keys.ACUSTICA_RUIDO_INSTALACIONES_SI, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NO), this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasAscensoresCuartoMaquinas." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NO, locale)},
		};

		metaData.getColumn("otrasAscensoresCuartoMaquinas").setSofaStoreValues(otrasAscensoresCuartoMaquinasStore);

		metaData.getColumn("otrasAscensoresCuartoMaquinas").setEditable(true);
		metaData.getColumn("otrasAscensoresCuartoMaquinas").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("otrasAscensoresRuidoMolesto", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("otrasAscensoresRuidoMolesto", this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasAscensoresRuidoMolesto.header", locale)));
		metaData.getColumn("otrasAscensoresRuidoMolesto").setGroupable(false);
		metaData.getColumn("otrasAscensoresRuidoMolesto").setSortable(true);
		metaData.getColumn("otrasAscensoresRuidoMolesto").setSofaFilter(GridColumnFilter.TYPE_LIST);
		
		metaData.getColumn("otrasAscensoresRuidoMolesto").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] otrasAscensoresRuidoMolestoStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NS), this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasAscensoresRuidoMolesto." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NS, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_SI), this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasAscensoresRuidoMolesto." + Keys.ACUSTICA_RUIDO_INSTALACIONES_SI, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NO), this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasAscensoresRuidoMolesto." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NO, locale)},
		};

		metaData.getColumn("otrasAscensoresRuidoMolesto").setSofaStoreValues(otrasAscensoresRuidoMolestoStore);

		metaData.getColumn("otrasAscensoresRuidoMolesto").setEditable(true);
		metaData.getColumn("otrasAscensoresRuidoMolesto").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("otrasAscensoresRuidoMolestoTipoLocalizacion", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("otrasAscensoresRuidoMolestoTipoLocalizacion", this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasAscensoresRuidoMolestoTipoLocalizacion.header", locale)));
		metaData.getColumn("otrasAscensoresRuidoMolestoTipoLocalizacion").setTooltip(this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasAscensoresRuidoMolestoTipoLocalizacion.description", locale));
		metaData.getColumn("otrasAscensoresRuidoMolestoTipoLocalizacion").setGroupable(false);
		metaData.getColumn("otrasAscensoresRuidoMolestoTipoLocalizacion").setSortable(true);
		metaData.getColumn("otrasAscensoresRuidoMolestoTipoLocalizacion").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("otrasAscensoresRuidoMolestoTipoLocalizacion").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("otrasAscensoresRuidoMolestoTipoLocalizacion").setEditable(true);
		metaData.getColumn("otrasAscensoresRuidoMolestoTipoLocalizacion").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("otrasAscensoresSistemaAmortiguante", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("otrasAscensoresSistemaAmortiguante", this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasAscensoresSistemaAmortiguante.header", locale)));
		metaData.getColumn("otrasAscensoresSistemaAmortiguante").setTooltip(this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasAscensoresSistemaAmortiguante.description", locale));
		metaData.getColumn("otrasAscensoresSistemaAmortiguante").setGroupable(false);
		metaData.getColumn("otrasAscensoresSistemaAmortiguante").setSortable(true);
		metaData.getColumn("otrasAscensoresSistemaAmortiguante").setSofaFilter(GridColumnFilter.TYPE_LIST);
		
		metaData.getColumn("otrasAscensoresSistemaAmortiguante").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] otrasAscensoresSistemaAmortiguanteStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NS), this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasAscensoresSistemaAmortiguante." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NS, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_SI), this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasAscensoresSistemaAmortiguante." + Keys.ACUSTICA_RUIDO_INSTALACIONES_SI, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NO), this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasAscensoresSistemaAmortiguante." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NO, locale)},
		};

		metaData.getColumn("otrasAscensoresSistemaAmortiguante").setSofaStoreValues(otrasAscensoresSistemaAmortiguanteStore);

		metaData.getColumn("otrasAscensoresSistemaAmortiguante").setEditable(true);
		metaData.getColumn("otrasAscensoresSistemaAmortiguante").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("otrasAscensoresTrasdosado", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("otrasAscensoresTrasdosado", this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasAscensoresTrasdosado.header", locale)));
		metaData.getColumn("otrasAscensoresTrasdosado").setGroupable(false);
		metaData.getColumn("otrasAscensoresTrasdosado").setSortable(true);
		metaData.getColumn("otrasAscensoresTrasdosado").setSofaFilter(GridColumnFilter.TYPE_LIST);
		
		metaData.getColumn("otrasAscensoresTrasdosado").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] otrasAscensoresTrasdosadoStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NS), this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasAscensoresTrasdosado." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NS, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_SI), this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasAscensoresTrasdosado." + Keys.ACUSTICA_RUIDO_INSTALACIONES_SI, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NO), this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasAscensoresTrasdosado." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NO, locale)},
		};

		metaData.getColumn("otrasAscensoresTrasdosado").setSofaStoreValues(otrasAscensoresTrasdosadoStore);

		metaData.getColumn("otrasAscensoresTrasdosado").setEditable(true);
		metaData.getColumn("otrasAscensoresTrasdosado").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("otrasCuartosHumedosAireAcondicionado", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("otrasCuartosHumedosAireAcondicionado", this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasCuartosHumedosAireAcondicionado.header", locale)));
		metaData.getColumn("otrasCuartosHumedosAireAcondicionado").setTooltip(this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasCuartosHumedosAireAcondicionado.description", locale));
		metaData.getColumn("otrasCuartosHumedosAireAcondicionado").setGroupable(false);
		metaData.getColumn("otrasCuartosHumedosAireAcondicionado").setSortable(true);
		metaData.getColumn("otrasCuartosHumedosAireAcondicionado").setSofaFilter(GridColumnFilter.TYPE_LIST);
		
		metaData.getColumn("otrasCuartosHumedosAireAcondicionado").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] otrasCuartosHumedosAireAcondicionadoStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NS), this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasCuartosHumedosAireAcondicionado." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NS, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_SI), this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasCuartosHumedosAireAcondicionado." + Keys.ACUSTICA_RUIDO_INSTALACIONES_SI, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NO), this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasCuartosHumedosAireAcondicionado." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NO, locale)},
		};

		metaData.getColumn("otrasCuartosHumedosAireAcondicionado").setSofaStoreValues(otrasCuartosHumedosAireAcondicionadoStore);

		metaData.getColumn("otrasCuartosHumedosAireAcondicionado").setEditable(true);
		metaData.getColumn("otrasCuartosHumedosAireAcondicionado").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("otrasCuartosHumedosLuminariasEmpotradas", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("otrasCuartosHumedosLuminariasEmpotradas", this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasCuartosHumedosLuminariasEmpotradas.header", locale)));
		metaData.getColumn("otrasCuartosHumedosLuminariasEmpotradas").setTooltip(this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasCuartosHumedosLuminariasEmpotradas.description", locale));
		metaData.getColumn("otrasCuartosHumedosLuminariasEmpotradas").setGroupable(false);
		metaData.getColumn("otrasCuartosHumedosLuminariasEmpotradas").setSortable(true);
		metaData.getColumn("otrasCuartosHumedosLuminariasEmpotradas").setSofaFilter(GridColumnFilter.TYPE_LIST);
		
		metaData.getColumn("otrasCuartosHumedosLuminariasEmpotradas").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] otrasCuartosHumedosLuminariasEmpotradasStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NS), this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasCuartosHumedosLuminariasEmpotradas." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NS, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_SI), this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasCuartosHumedosLuminariasEmpotradas." + Keys.ACUSTICA_RUIDO_INSTALACIONES_SI, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NO), this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasCuartosHumedosLuminariasEmpotradas." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NO, locale)},
		};

		metaData.getColumn("otrasCuartosHumedosLuminariasEmpotradas").setSofaStoreValues(otrasCuartosHumedosLuminariasEmpotradasStore);

		metaData.getColumn("otrasCuartosHumedosLuminariasEmpotradas").setEditable(true);
		metaData.getColumn("otrasCuartosHumedosLuminariasEmpotradas").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("otrasCuartosHumedosRuidoMolesto", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("otrasCuartosHumedosRuidoMolesto", this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasCuartosHumedosRuidoMolesto.header", locale)));
		metaData.getColumn("otrasCuartosHumedosRuidoMolesto").setTooltip(this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasCuartosHumedosRuidoMolesto.description", locale));
		metaData.getColumn("otrasCuartosHumedosRuidoMolesto").setGroupable(false);
		metaData.getColumn("otrasCuartosHumedosRuidoMolesto").setSortable(true);
		metaData.getColumn("otrasCuartosHumedosRuidoMolesto").setSofaFilter(GridColumnFilter.TYPE_LIST);
		
		metaData.getColumn("otrasCuartosHumedosRuidoMolesto").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] otrasCuartosHumedosRuidoMolestoStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NS), this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasCuartosHumedosRuidoMolesto." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NS, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_SI), this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasCuartosHumedosRuidoMolesto." + Keys.ACUSTICA_RUIDO_INSTALACIONES_SI, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NO), this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasCuartosHumedosRuidoMolesto." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NO, locale)},
		};

		metaData.getColumn("otrasCuartosHumedosRuidoMolesto").setSofaStoreValues(otrasCuartosHumedosRuidoMolestoStore);

		metaData.getColumn("otrasCuartosHumedosRuidoMolesto").setEditable(true);
		metaData.getColumn("otrasCuartosHumedosRuidoMolesto").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("otrasCuartosHumedosRuidoMolestoTipoLocalizacion", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("otrasCuartosHumedosRuidoMolestoTipoLocalizacion", this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasCuartosHumedosRuidoMolestoTipoLocalizacion.header", locale)));
		metaData.getColumn("otrasCuartosHumedosRuidoMolestoTipoLocalizacion").setTooltip(this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasCuartosHumedosRuidoMolestoTipoLocalizacion.description", locale));
		metaData.getColumn("otrasCuartosHumedosRuidoMolestoTipoLocalizacion").setGroupable(false);
		metaData.getColumn("otrasCuartosHumedosRuidoMolestoTipoLocalizacion").setSortable(true);
		metaData.getColumn("otrasCuartosHumedosRuidoMolestoTipoLocalizacion").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("otrasCuartosHumedosRuidoMolestoTipoLocalizacion").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("otrasCuartosHumedosRuidoMolestoTipoLocalizacion").setEditable(true);
		metaData.getColumn("otrasCuartosHumedosRuidoMolestoTipoLocalizacion").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("otrasCuartosHumedosSaneamiento", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("otrasCuartosHumedosSaneamiento", this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasCuartosHumedosSaneamiento.header", locale)));
		metaData.getColumn("otrasCuartosHumedosSaneamiento").setTooltip(this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasCuartosHumedosSaneamiento.description", locale));
		metaData.getColumn("otrasCuartosHumedosSaneamiento").setGroupable(false);
		metaData.getColumn("otrasCuartosHumedosSaneamiento").setSortable(true);
		metaData.getColumn("otrasCuartosHumedosSaneamiento").setSofaFilter(GridColumnFilter.TYPE_LIST);
		
		metaData.getColumn("otrasCuartosHumedosSaneamiento").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] otrasCuartosHumedosSaneamientoStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NS), this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasCuartosHumedosSaneamiento." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NS, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_SI), this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasCuartosHumedosSaneamiento." + Keys.ACUSTICA_RUIDO_INSTALACIONES_SI, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NO), this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasCuartosHumedosSaneamiento." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NO, locale)},
		};

		metaData.getColumn("otrasCuartosHumedosSaneamiento").setSofaStoreValues(otrasCuartosHumedosSaneamientoStore);

		metaData.getColumn("otrasCuartosHumedosSaneamiento").setEditable(true);
		metaData.getColumn("otrasCuartosHumedosSaneamiento").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("otrasCuartosHumedosSaneamientoConectoresFlexibles", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("otrasCuartosHumedosSaneamientoConectoresFlexibles", this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasCuartosHumedosSaneamientoConectoresFlexibles.header", locale)));
		metaData.getColumn("otrasCuartosHumedosSaneamientoConectoresFlexibles").setTooltip(this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasCuartosHumedosSaneamientoConectoresFlexibles.description", locale));
		metaData.getColumn("otrasCuartosHumedosSaneamientoConectoresFlexibles").setGroupable(false);
		metaData.getColumn("otrasCuartosHumedosSaneamientoConectoresFlexibles").setSortable(true);
		metaData.getColumn("otrasCuartosHumedosSaneamientoConectoresFlexibles").setSofaFilter(GridColumnFilter.TYPE_LIST);
		
		metaData.getColumn("otrasCuartosHumedosSaneamientoConectoresFlexibles").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] otrasCuartosHumedosSaneamientoConectoresFlexiblesStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NS), this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasCuartosHumedosSaneamientoConectoresFlexibles." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NS, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_SI), this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasCuartosHumedosSaneamientoConectoresFlexibles." + Keys.ACUSTICA_RUIDO_INSTALACIONES_SI, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NO), this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasCuartosHumedosSaneamientoConectoresFlexibles." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NO, locale)},
		};

		metaData.getColumn("otrasCuartosHumedosSaneamientoConectoresFlexibles").setSofaStoreValues(otrasCuartosHumedosSaneamientoConectoresFlexiblesStore);

		metaData.getColumn("otrasCuartosHumedosSaneamientoConectoresFlexibles").setEditable(true);
		metaData.getColumn("otrasCuartosHumedosSaneamientoConectoresFlexibles").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("otrasCuartosHumedosSaneamientoLanaMineral", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("otrasCuartosHumedosSaneamientoLanaMineral", this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasCuartosHumedosSaneamientoLanaMineral.header", locale)));
		metaData.getColumn("otrasCuartosHumedosSaneamientoLanaMineral").setTooltip(this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasCuartosHumedosSaneamientoLanaMineral.description", locale));
		metaData.getColumn("otrasCuartosHumedosSaneamientoLanaMineral").setGroupable(false);
		metaData.getColumn("otrasCuartosHumedosSaneamientoLanaMineral").setSortable(true);
		metaData.getColumn("otrasCuartosHumedosSaneamientoLanaMineral").setSofaFilter(GridColumnFilter.TYPE_LIST);
		
		metaData.getColumn("otrasCuartosHumedosSaneamientoLanaMineral").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] otrasCuartosHumedosSaneamientoLanaMineralStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NS), this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasCuartosHumedosSaneamientoLanaMineral." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NS, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_SI), this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasCuartosHumedosSaneamientoLanaMineral." + Keys.ACUSTICA_RUIDO_INSTALACIONES_SI, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NO), this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasCuartosHumedosSaneamientoLanaMineral." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NO, locale)},
		};

		metaData.getColumn("otrasCuartosHumedosSaneamientoLanaMineral").setSofaStoreValues(otrasCuartosHumedosSaneamientoLanaMineralStore);

		metaData.getColumn("otrasCuartosHumedosSaneamientoLanaMineral").setEditable(true);
		metaData.getColumn("otrasCuartosHumedosSaneamientoLanaMineral").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("otrasCuartosHumedosSaneamientoMaterialElastico", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("otrasCuartosHumedosSaneamientoMaterialElastico", this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasCuartosHumedosSaneamientoMaterialElastico.header", locale)));
		metaData.getColumn("otrasCuartosHumedosSaneamientoMaterialElastico").setTooltip(this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasCuartosHumedosSaneamientoMaterialElastico.description", locale));
		metaData.getColumn("otrasCuartosHumedosSaneamientoMaterialElastico").setGroupable(false);
		metaData.getColumn("otrasCuartosHumedosSaneamientoMaterialElastico").setSortable(true);
		metaData.getColumn("otrasCuartosHumedosSaneamientoMaterialElastico").setSofaFilter(GridColumnFilter.TYPE_LIST);
		
		metaData.getColumn("otrasCuartosHumedosSaneamientoMaterialElastico").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] otrasCuartosHumedosSaneamientoMaterialElasticoStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NS), this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasCuartosHumedosSaneamientoMaterialElastico." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NS, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_SI), this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasCuartosHumedosSaneamientoMaterialElastico." + Keys.ACUSTICA_RUIDO_INSTALACIONES_SI, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NO), this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasCuartosHumedosSaneamientoMaterialElastico." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NO, locale)},
		};

		metaData.getColumn("otrasCuartosHumedosSaneamientoMaterialElastico").setSofaStoreValues(otrasCuartosHumedosSaneamientoMaterialElasticoStore);

		metaData.getColumn("otrasCuartosHumedosSaneamientoMaterialElastico").setEditable(true);
		metaData.getColumn("otrasCuartosHumedosSaneamientoMaterialElastico").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("otrasCuartosHumedosSaneamientoTechoSellado", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("otrasCuartosHumedosSaneamientoTechoSellado", this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasCuartosHumedosSaneamientoTechoSellado.header", locale)));
		metaData.getColumn("otrasCuartosHumedosSaneamientoTechoSellado").setTooltip(this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasCuartosHumedosSaneamientoTechoSellado.description", locale));
		metaData.getColumn("otrasCuartosHumedosSaneamientoTechoSellado").setGroupable(false);
		metaData.getColumn("otrasCuartosHumedosSaneamientoTechoSellado").setSortable(true);
		metaData.getColumn("otrasCuartosHumedosSaneamientoTechoSellado").setSofaFilter(GridColumnFilter.TYPE_LIST);
		
		metaData.getColumn("otrasCuartosHumedosSaneamientoTechoSellado").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] otrasCuartosHumedosSaneamientoTechoSelladoStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NS), this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasCuartosHumedosSaneamientoTechoSellado." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NS, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_SI), this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasCuartosHumedosSaneamientoTechoSellado." + Keys.ACUSTICA_RUIDO_INSTALACIONES_SI, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NO), this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasCuartosHumedosSaneamientoTechoSellado." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NO, locale)},
		};

		metaData.getColumn("otrasCuartosHumedosSaneamientoTechoSellado").setSofaStoreValues(otrasCuartosHumedosSaneamientoTechoSelladoStore);

		metaData.getColumn("otrasCuartosHumedosSaneamientoTechoSellado").setEditable(true);
		metaData.getColumn("otrasCuartosHumedosSaneamientoTechoSellado").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("otrasPuertasGarajeAncladas", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("otrasPuertasGarajeAncladas", this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasPuertasGarajeAncladas.header", locale)));
		metaData.getColumn("otrasPuertasGarajeAncladas").setGroupable(false);
		metaData.getColumn("otrasPuertasGarajeAncladas").setSortable(true);
		metaData.getColumn("otrasPuertasGarajeAncladas").setSofaFilter(GridColumnFilter.TYPE_LIST);
		
		metaData.getColumn("otrasPuertasGarajeAncladas").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] otrasPuertasGarajeAncladasStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NS), this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasPuertasGarajeAncladas." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NS, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_SI), this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasPuertasGarajeAncladas." + Keys.ACUSTICA_RUIDO_INSTALACIONES_SI, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NO), this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasPuertasGarajeAncladas." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NO, locale)},
		};

		metaData.getColumn("otrasPuertasGarajeAncladas").setSofaStoreValues(otrasPuertasGarajeAncladasStore);

		metaData.getColumn("otrasPuertasGarajeAncladas").setEditable(true);
		metaData.getColumn("otrasPuertasGarajeAncladas").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("otrasPuertasGarajeAncladasMarcoAmortiguadores", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("otrasPuertasGarajeAncladasMarcoAmortiguadores", this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasPuertasGarajeAncladasMarcoAmortiguadores.header", locale)));
		metaData.getColumn("otrasPuertasGarajeAncladasMarcoAmortiguadores").setTooltip(this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasPuertasGarajeAncladasMarcoAmortiguadores.description", locale));
		metaData.getColumn("otrasPuertasGarajeAncladasMarcoAmortiguadores").setGroupable(false);
		metaData.getColumn("otrasPuertasGarajeAncladasMarcoAmortiguadores").setSortable(true);
		metaData.getColumn("otrasPuertasGarajeAncladasMarcoAmortiguadores").setSofaFilter(GridColumnFilter.TYPE_LIST);
		
		metaData.getColumn("otrasPuertasGarajeAncladasMarcoAmortiguadores").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] otrasPuertasGarajeAncladasMarcoAmortiguadoresStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NS), this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasPuertasGarajeAncladasMarcoAmortiguadores." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NS, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_SI), this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasPuertasGarajeAncladasMarcoAmortiguadores." + Keys.ACUSTICA_RUIDO_INSTALACIONES_SI, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NO), this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasPuertasGarajeAncladasMarcoAmortiguadores." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NO, locale)},
		};

		metaData.getColumn("otrasPuertasGarajeAncladasMarcoAmortiguadores").setSofaStoreValues(otrasPuertasGarajeAncladasMarcoAmortiguadoresStore);

		metaData.getColumn("otrasPuertasGarajeAncladasMarcoAmortiguadores").setEditable(true);
		metaData.getColumn("otrasPuertasGarajeAncladasMarcoAmortiguadores").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("otrasPuertasGarajeAncladasMotoresAmortiguadores", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("otrasPuertasGarajeAncladasMotoresAmortiguadores", this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasPuertasGarajeAncladasMotoresAmortiguadores.header", locale)));
		metaData.getColumn("otrasPuertasGarajeAncladasMotoresAmortiguadores").setTooltip(this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasPuertasGarajeAncladasMotoresAmortiguadores.description", locale));
		metaData.getColumn("otrasPuertasGarajeAncladasMotoresAmortiguadores").setGroupable(false);
		metaData.getColumn("otrasPuertasGarajeAncladasMotoresAmortiguadores").setSortable(true);
		metaData.getColumn("otrasPuertasGarajeAncladasMotoresAmortiguadores").setSofaFilter(GridColumnFilter.TYPE_LIST);
		
		metaData.getColumn("otrasPuertasGarajeAncladasMotoresAmortiguadores").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] otrasPuertasGarajeAncladasMotoresAmortiguadoresStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NS), this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasPuertasGarajeAncladasMotoresAmortiguadores." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NS, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_SI), this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasPuertasGarajeAncladasMotoresAmortiguadores." + Keys.ACUSTICA_RUIDO_INSTALACIONES_SI, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NO), this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasPuertasGarajeAncladasMotoresAmortiguadores." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NO, locale)},
		};

		metaData.getColumn("otrasPuertasGarajeAncladasMotoresAmortiguadores").setSofaStoreValues(otrasPuertasGarajeAncladasMotoresAmortiguadoresStore);

		metaData.getColumn("otrasPuertasGarajeAncladasMotoresAmortiguadores").setEditable(true);
		metaData.getColumn("otrasPuertasGarajeAncladasMotoresAmortiguadores").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("otrasPuertasGarajeAncladasRuidoPuerta", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("otrasPuertasGarajeAncladasRuidoPuerta", this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasPuertasGarajeAncladasRuidoPuerta.header", locale)));
		metaData.getColumn("otrasPuertasGarajeAncladasRuidoPuerta").setTooltip(this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasPuertasGarajeAncladasRuidoPuerta.description", locale));
		metaData.getColumn("otrasPuertasGarajeAncladasRuidoPuerta").setGroupable(false);
		metaData.getColumn("otrasPuertasGarajeAncladasRuidoPuerta").setSortable(true);
		metaData.getColumn("otrasPuertasGarajeAncladasRuidoPuerta").setSofaFilter(GridColumnFilter.TYPE_LIST);
		
		metaData.getColumn("otrasPuertasGarajeAncladasRuidoPuerta").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] otrasPuertasGarajeAncladasRuidoPuertaStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NS), this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasPuertasGarajeAncladasRuidoPuerta." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NS, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_SI), this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasPuertasGarajeAncladasRuidoPuerta." + Keys.ACUSTICA_RUIDO_INSTALACIONES_SI, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NO), this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasPuertasGarajeAncladasRuidoPuerta." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NO, locale)},
		};

		metaData.getColumn("otrasPuertasGarajeAncladasRuidoPuerta").setSofaStoreValues(otrasPuertasGarajeAncladasRuidoPuertaStore);

		metaData.getColumn("otrasPuertasGarajeAncladasRuidoPuerta").setEditable(true);
		metaData.getColumn("otrasPuertasGarajeAncladasRuidoPuerta").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("recintosActividadRevestido", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("recintosActividadRevestido", this.getMessage("forms.acusticaruidoinstalaciones.columns.recintosActividadRevestido.header", locale)));
		metaData.getColumn("recintosActividadRevestido").setGroupable(false);
		metaData.getColumn("recintosActividadRevestido").setSortable(true);
		metaData.getColumn("recintosActividadRevestido").setSofaFilter(GridColumnFilter.TYPE_LIST);
		
		metaData.getColumn("recintosActividadRevestido").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] recintosActividadRevestidoStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NS), this.getMessage("forms.acusticaruidoinstalaciones.columns.recintosActividadRevestido." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NS, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_SI), this.getMessage("forms.acusticaruidoinstalaciones.columns.recintosActividadRevestido." + Keys.ACUSTICA_RUIDO_INSTALACIONES_SI, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NO), this.getMessage("forms.acusticaruidoinstalaciones.columns.recintosActividadRevestido." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NO, locale)},
		};

		metaData.getColumn("recintosActividadRevestido").setSofaStoreValues(recintosActividadRevestidoStore);

		metaData.getColumn("recintosActividadRevestido").setEditable(true);
		metaData.getColumn("recintosActividadRevestido").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("recintosActividadRuidoMolesto", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("recintosActividadRuidoMolesto", this.getMessage("forms.acusticaruidoinstalaciones.columns.recintosActividadRuidoMolesto.header", locale)));
		metaData.getColumn("recintosActividadRuidoMolesto").setTooltip(this.getMessage("forms.acusticaruidoinstalaciones.columns.recintosActividadRuidoMolesto.description", locale));
		metaData.getColumn("recintosActividadRuidoMolesto").setGroupable(false);
		metaData.getColumn("recintosActividadRuidoMolesto").setSortable(true);
		metaData.getColumn("recintosActividadRuidoMolesto").setSofaFilter(GridColumnFilter.TYPE_LIST);
		
		metaData.getColumn("recintosActividadRuidoMolesto").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] recintosActividadRuidoMolestoStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NS), this.getMessage("forms.acusticaruidoinstalaciones.columns.recintosActividadRuidoMolesto." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NS, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_SI), this.getMessage("forms.acusticaruidoinstalaciones.columns.recintosActividadRuidoMolesto." + Keys.ACUSTICA_RUIDO_INSTALACIONES_SI, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NO), this.getMessage("forms.acusticaruidoinstalaciones.columns.recintosActividadRuidoMolesto." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NO, locale)},
		};

		metaData.getColumn("recintosActividadRuidoMolesto").setSofaStoreValues(recintosActividadRuidoMolestoStore);

		metaData.getColumn("recintosActividadRuidoMolesto").setEditable(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("recintosActividadRuidoMolestoTipoLocalizacion", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("recintosActividadRuidoMolestoTipoLocalizacion", this.getMessage("forms.acusticaruidoinstalaciones.columns.recintosActividadRuidoMolestoTipoLocalizacion.header", locale)));
		metaData.getColumn("recintosActividadRuidoMolestoTipoLocalizacion").setTooltip(this.getMessage("forms.acusticaruidoinstalaciones.columns.recintosActividadRuidoMolestoTipoLocalizacion.description", locale));
		metaData.getColumn("recintosActividadRuidoMolestoTipoLocalizacion").setGroupable(false);
		metaData.getColumn("recintosActividadRuidoMolestoTipoLocalizacion").setSortable(true);
		metaData.getColumn("recintosActividadRuidoMolestoTipoLocalizacion").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("recintosActividadRuidoMolestoTipoLocalizacion").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("recintosActividadRuidoMolestoTipoLocalizacion").setEditable(true);
		metaData.getColumn("recintosActividadRuidoMolestoTipoLocalizacion").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("recintosActividadSueloFlotante", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("recintosActividadSueloFlotante", this.getMessage("forms.acusticaruidoinstalaciones.columns.recintosActividadSueloFlotante.header", locale)));
		metaData.getColumn("recintosActividadSueloFlotante").setTooltip(this.getMessage("forms.acusticaruidoinstalaciones.columns.recintosActividadSueloFlotante.description", locale));
		metaData.getColumn("recintosActividadSueloFlotante").setGroupable(false);
		metaData.getColumn("recintosActividadSueloFlotante").setSortable(true);
		metaData.getColumn("recintosActividadSueloFlotante").setSofaFilter(GridColumnFilter.TYPE_LIST);
		
		metaData.getColumn("recintosActividadSueloFlotante").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] recintosActividadSueloFlotanteStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NS), this.getMessage("forms.acusticaruidoinstalaciones.columns.recintosActividadSueloFlotante." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NS, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_SI), this.getMessage("forms.acusticaruidoinstalaciones.columns.recintosActividadSueloFlotante." + Keys.ACUSTICA_RUIDO_INSTALACIONES_SI, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NO), this.getMessage("forms.acusticaruidoinstalaciones.columns.recintosActividadSueloFlotante." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NO, locale)},
		};

		metaData.getColumn("recintosActividadSueloFlotante").setSofaStoreValues(recintosActividadSueloFlotanteStore);

		metaData.getColumn("recintosActividadSueloFlotante").setEditable(true);
		metaData.getColumn("recintosActividadSueloFlotante").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("recintosActividadTechoSuspendido", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("recintosActividadTechoSuspendido", this.getMessage("forms.acusticaruidoinstalaciones.columns.recintosActividadTechoSuspendido.header", locale)));
		metaData.getColumn("recintosActividadTechoSuspendido").setTooltip(this.getMessage("forms.acusticaruidoinstalaciones.columns.recintosActividadTechoSuspendido.description", locale));
		metaData.getColumn("recintosActividadTechoSuspendido").setGroupable(false);
		metaData.getColumn("recintosActividadTechoSuspendido").setSortable(true);
		metaData.getColumn("recintosActividadTechoSuspendido").setSofaFilter(GridColumnFilter.TYPE_LIST);
		
		metaData.getColumn("recintosActividadTechoSuspendido").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] recintosActividadTechoSuspendidoStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NS), this.getMessage("forms.acusticaruidoinstalaciones.columns.recintosActividadTechoSuspendido." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NS, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_SI), this.getMessage("forms.acusticaruidoinstalaciones.columns.recintosActividadTechoSuspendido." + Keys.ACUSTICA_RUIDO_INSTALACIONES_SI, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NO), this.getMessage("forms.acusticaruidoinstalaciones.columns.recintosActividadTechoSuspendido." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NO, locale)},
		};

		metaData.getColumn("recintosActividadTechoSuspendido").setSofaStoreValues(recintosActividadTechoSuspendidoStore);

		metaData.getColumn("recintosActividadTechoSuspendido").setEditable(true);
		metaData.getColumn("recintosActividadTechoSuspendido").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("recintosActividadTechoSuspendidoAbsorvente", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("recintosActividadTechoSuspendidoAbsorvente", this.getMessage("forms.acusticaruidoinstalaciones.columns.recintosActividadTechoSuspendidoAbsorvente.header", locale)));
		metaData.getColumn("recintosActividadTechoSuspendidoAbsorvente").setTooltip(this.getMessage("forms.acusticaruidoinstalaciones.columns.recintosActividadTechoSuspendidoAbsorvente.description", locale));
		metaData.getColumn("recintosActividadTechoSuspendidoAbsorvente").setGroupable(false);
		metaData.getColumn("recintosActividadTechoSuspendidoAbsorvente").setSortable(true);
		metaData.getColumn("recintosActividadTechoSuspendidoAbsorvente").setSofaFilter(GridColumnFilter.TYPE_LIST);
		
		metaData.getColumn("recintosActividadTechoSuspendidoAbsorvente").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] recintosActividadTechoSuspendidoAbsorventeStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NS), this.getMessage("forms.acusticaruidoinstalaciones.columns.recintosActividadTechoSuspendidoAbsorvente." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NS, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_SI), this.getMessage("forms.acusticaruidoinstalaciones.columns.recintosActividadTechoSuspendidoAbsorvente." + Keys.ACUSTICA_RUIDO_INSTALACIONES_SI, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NO), this.getMessage("forms.acusticaruidoinstalaciones.columns.recintosActividadTechoSuspendidoAbsorvente." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NO, locale)},
		};

		metaData.getColumn("recintosActividadTechoSuspendidoAbsorvente").setSofaStoreValues(recintosActividadTechoSuspendidoAbsorventeStore);

		metaData.getColumn("recintosActividadTechoSuspendidoAbsorvente").setEditable(true);
		metaData.getColumn("recintosActividadTechoSuspendidoAbsorvente").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("recintosActividadTechoSuspendidoAmortiguadores", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("recintosActividadTechoSuspendidoAmortiguadores", this.getMessage("forms.acusticaruidoinstalaciones.columns.recintosActividadTechoSuspendidoAmortiguadores.header", locale)));
		metaData.getColumn("recintosActividadTechoSuspendidoAmortiguadores").setTooltip(this.getMessage("forms.acusticaruidoinstalaciones.columns.recintosActividadTechoSuspendidoAmortiguadores.description", locale));
		metaData.getColumn("recintosActividadTechoSuspendidoAmortiguadores").setGroupable(false);
		metaData.getColumn("recintosActividadTechoSuspendidoAmortiguadores").setSortable(true);
		metaData.getColumn("recintosActividadTechoSuspendidoAmortiguadores").setSofaFilter(GridColumnFilter.TYPE_LIST);
		
		metaData.getColumn("recintosActividadTechoSuspendidoAmortiguadores").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] recintosActividadTechoSuspendidoAmortiguadoresStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NS), this.getMessage("forms.acusticaruidoinstalaciones.columns.recintosActividadTechoSuspendidoAmortiguadores." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NS, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_SI), this.getMessage("forms.acusticaruidoinstalaciones.columns.recintosActividadTechoSuspendidoAmortiguadores." + Keys.ACUSTICA_RUIDO_INSTALACIONES_SI, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NO), this.getMessage("forms.acusticaruidoinstalaciones.columns.recintosActividadTechoSuspendidoAmortiguadores." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NO, locale)},
		};

		metaData.getColumn("recintosActividadTechoSuspendidoAmortiguadores").setSofaStoreValues(recintosActividadTechoSuspendidoAmortiguadoresStore);

		metaData.getColumn("recintosActividadTechoSuspendidoAmortiguadores").setEditable(true);
		metaData.getColumn("recintosActividadTechoSuspendidoAmortiguadores").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("recintosActividadTiene", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("recintosActividadTiene", this.getMessage("forms.acusticaruidoinstalaciones.columns.recintosActividadTiene.header", locale)));
		metaData.getColumn("recintosActividadTiene").setGroupable(false);
		metaData.getColumn("recintosActividadTiene").setSortable(true);
		metaData.getColumn("recintosActividadTiene").setSofaFilter(GridColumnFilter.TYPE_LIST);
		
		metaData.getColumn("recintosActividadTiene").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] recintosActividadTieneStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NS), this.getMessage("forms.acusticaruidoinstalaciones.columns.recintosActividadTiene." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NS, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_SI), this.getMessage("forms.acusticaruidoinstalaciones.columns.recintosActividadTiene." + Keys.ACUSTICA_RUIDO_INSTALACIONES_SI, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NO), this.getMessage("forms.acusticaruidoinstalaciones.columns.recintosActividadTiene." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NO, locale)},
		};

		metaData.getColumn("recintosActividadTiene").setSofaStoreValues(recintosActividadTieneStore);

		metaData.getColumn("recintosActividadTiene").setEditable(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("recintosActividadTipoLocalizacion", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("recintosActividadTipoLocalizacion", this.getMessage("forms.acusticaruidoinstalaciones.columns.recintosActividadTipoLocalizacion.header", locale)));
		metaData.getColumn("recintosActividadTipoLocalizacion").setTooltip(this.getMessage("forms.acusticaruidoinstalaciones.columns.recintosActividadTipoLocalizacion.description", locale));
		metaData.getColumn("recintosActividadTipoLocalizacion").setGroupable(false);
		metaData.getColumn("recintosActividadTipoLocalizacion").setSortable(true);
		metaData.getColumn("recintosActividadTipoLocalizacion").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("recintosActividadTipoLocalizacion").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("recintosActividadTipoLocalizacion").setEditable(true);
		metaData.getColumn("recintosActividadTipoLocalizacion").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("recintosActividadTrasdosados", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("recintosActividadTrasdosados", this.getMessage("forms.acusticaruidoinstalaciones.columns.recintosActividadTrasdosados.header", locale)));
		metaData.getColumn("recintosActividadTrasdosados").setGroupable(false);
		metaData.getColumn("recintosActividadTrasdosados").setSortable(true);
		metaData.getColumn("recintosActividadTrasdosados").setSofaFilter(GridColumnFilter.TYPE_LIST);
		
		metaData.getColumn("recintosActividadTrasdosados").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] recintosActividadTrasdosadosStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NS), this.getMessage("forms.acusticaruidoinstalaciones.columns.recintosActividadTrasdosados." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NS, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_SI), this.getMessage("forms.acusticaruidoinstalaciones.columns.recintosActividadTrasdosados." + Keys.ACUSTICA_RUIDO_INSTALACIONES_SI, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NO), this.getMessage("forms.acusticaruidoinstalaciones.columns.recintosActividadTrasdosados." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NO, locale)},
		};

		metaData.getColumn("recintosActividadTrasdosados").setSofaStoreValues(recintosActividadTrasdosadosStore);

		metaData.getColumn("recintosActividadTrasdosados").setEditable(true);
		metaData.getColumn("recintosActividadTrasdosados").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("recintosActividadTrasdosadosAmortiguadores", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("recintosActividadTrasdosadosAmortiguadores", this.getMessage("forms.acusticaruidoinstalaciones.columns.recintosActividadTrasdosadosAmortiguadores.header", locale)));
		metaData.getColumn("recintosActividadTrasdosadosAmortiguadores").setTooltip(this.getMessage("forms.acusticaruidoinstalaciones.columns.recintosActividadTrasdosadosAmortiguadores.description", locale));
		metaData.getColumn("recintosActividadTrasdosadosAmortiguadores").setGroupable(false);
		metaData.getColumn("recintosActividadTrasdosadosAmortiguadores").setSortable(true);
		metaData.getColumn("recintosActividadTrasdosadosAmortiguadores").setSofaFilter(GridColumnFilter.TYPE_LIST);
		
		metaData.getColumn("recintosActividadTrasdosadosAmortiguadores").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] recintosActividadTrasdosadosAmortiguadoresStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NS), this.getMessage("forms.acusticaruidoinstalaciones.columns.recintosActividadTrasdosadosAmortiguadores." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NS, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_SI), this.getMessage("forms.acusticaruidoinstalaciones.columns.recintosActividadTrasdosadosAmortiguadores." + Keys.ACUSTICA_RUIDO_INSTALACIONES_SI, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NO), this.getMessage("forms.acusticaruidoinstalaciones.columns.recintosActividadTrasdosadosAmortiguadores." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NO, locale)},
		};

		metaData.getColumn("recintosActividadTrasdosadosAmortiguadores").setSofaStoreValues(recintosActividadTrasdosadosAmortiguadoresStore);

		metaData.getColumn("recintosActividadTrasdosadosAmortiguadores").setEditable(true);
		metaData.getColumn("recintosActividadTrasdosadosAmortiguadores").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("recintosActividadTratamientoAbsorvente", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("recintosActividadTratamientoAbsorvente", this.getMessage("forms.acusticaruidoinstalaciones.columns.recintosActividadTratamientoAbsorvente.header", locale)));
		metaData.getColumn("recintosActividadTratamientoAbsorvente").setTooltip(this.getMessage("forms.acusticaruidoinstalaciones.columns.recintosActividadTratamientoAbsorvente.description", locale));
		metaData.getColumn("recintosActividadTratamientoAbsorvente").setGroupable(false);
		metaData.getColumn("recintosActividadTratamientoAbsorvente").setSortable(true);
		metaData.getColumn("recintosActividadTratamientoAbsorvente").setSofaFilter(GridColumnFilter.TYPE_LIST);
		
		metaData.getColumn("recintosActividadTratamientoAbsorvente").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] recintosActividadTratamientoAbsorventeStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NS), this.getMessage("forms.acusticaruidoinstalaciones.columns.recintosActividadTratamientoAbsorvente." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NS, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_SI), this.getMessage("forms.acusticaruidoinstalaciones.columns.recintosActividadTratamientoAbsorvente." + Keys.ACUSTICA_RUIDO_INSTALACIONES_SI, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NO), this.getMessage("forms.acusticaruidoinstalaciones.columns.recintosActividadTratamientoAbsorvente." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NO, locale)},
		};

		metaData.getColumn("recintosActividadTratamientoAbsorvente").setSofaStoreValues(recintosActividadTratamientoAbsorventeStore);

		metaData.getColumn("recintosActividadTratamientoAbsorvente").setEditable(true);
		metaData.getColumn("recintosActividadTratamientoAbsorvente").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("redesAguaRuidoMolestoTipoLocalizacion", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("redesAguaRuidoMolestoTipoLocalizacion", this.getMessage("forms.acusticaruidoinstalaciones.columns.redesAguaRuidoMolestoTipoLocalizacion.header", locale)));
		metaData.getColumn("redesAguaRuidoMolestoTipoLocalizacion").setTooltip(this.getMessage("forms.acusticaruidoinstalaciones.columns.redesAguaRuidoMolestoTipoLocalizacion.description", locale));
		metaData.getColumn("redesAguaRuidoMolestoTipoLocalizacion").setGroupable(false);
		metaData.getColumn("redesAguaRuidoMolestoTipoLocalizacion").setSortable(true);
		metaData.getColumn("redesAguaRuidoMolestoTipoLocalizacion").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("redesAguaRuidoMolestoTipoLocalizacion").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("redesAguaRuidoMolestoTipoLocalizacion").setEditable(true);
		metaData.getColumn("redesAguaRuidoMolestoTipoLocalizacion").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("redesAireAcondicionadoFalsoTecho", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("redesAireAcondicionadoFalsoTecho", this.getMessage("forms.acusticaruidoinstalaciones.columns.redesAireAcondicionadoFalsoTecho.header", locale)));
		metaData.getColumn("redesAireAcondicionadoFalsoTecho").setTooltip(this.getMessage("forms.acusticaruidoinstalaciones.columns.redesAireAcondicionadoFalsoTecho.description", locale));
		metaData.getColumn("redesAireAcondicionadoFalsoTecho").setGroupable(false);
		metaData.getColumn("redesAireAcondicionadoFalsoTecho").setSortable(true);
		metaData.getColumn("redesAireAcondicionadoFalsoTecho").setSofaFilter(GridColumnFilter.TYPE_LIST);
		
		metaData.getColumn("redesAireAcondicionadoFalsoTecho").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] redesAireAcondicionadoFalsoTechoStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NS), this.getMessage("forms.acusticaruidoinstalaciones.columns.redesAireAcondicionadoFalsoTecho." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NS, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_SI), this.getMessage("forms.acusticaruidoinstalaciones.columns.redesAireAcondicionadoFalsoTecho." + Keys.ACUSTICA_RUIDO_INSTALACIONES_SI, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NO), this.getMessage("forms.acusticaruidoinstalaciones.columns.redesAireAcondicionadoFalsoTecho." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NO, locale)},
		};

		metaData.getColumn("redesAireAcondicionadoFalsoTecho").setSofaStoreValues(redesAireAcondicionadoFalsoTechoStore);

		metaData.getColumn("redesAireAcondicionadoFalsoTecho").setEditable(true);
		metaData.getColumn("redesAireAcondicionadoFalsoTecho").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("redesAireAcondicionadoRuidoMolesto", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("redesAireAcondicionadoRuidoMolesto", this.getMessage("forms.acusticaruidoinstalaciones.columns.redesAireAcondicionadoRuidoMolesto.header", locale)));
		metaData.getColumn("redesAireAcondicionadoRuidoMolesto").setTooltip(this.getMessage("forms.acusticaruidoinstalaciones.columns.redesAireAcondicionadoRuidoMolesto.description", locale));
		metaData.getColumn("redesAireAcondicionadoRuidoMolesto").setGroupable(false);
		metaData.getColumn("redesAireAcondicionadoRuidoMolesto").setSortable(true);
		metaData.getColumn("redesAireAcondicionadoRuidoMolesto").setSofaFilter(GridColumnFilter.TYPE_LIST);
		
		metaData.getColumn("redesAireAcondicionadoRuidoMolesto").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] redesAireAcondicionadoRuidoMolestoStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NS), this.getMessage("forms.acusticaruidoinstalaciones.columns.redesAireAcondicionadoRuidoMolesto." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NS, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_SI), this.getMessage("forms.acusticaruidoinstalaciones.columns.redesAireAcondicionadoRuidoMolesto." + Keys.ACUSTICA_RUIDO_INSTALACIONES_SI, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NO), this.getMessage("forms.acusticaruidoinstalaciones.columns.redesAireAcondicionadoRuidoMolesto." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NO, locale)},
		};

		metaData.getColumn("redesAireAcondicionadoRuidoMolesto").setSofaStoreValues(redesAireAcondicionadoRuidoMolestoStore);

		metaData.getColumn("redesAireAcondicionadoRuidoMolesto").setEditable(true);
		metaData.getColumn("redesAireAcondicionadoRuidoMolesto").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("redesSaneamientoBajantesAbrazaderas", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("redesSaneamientoBajantesAbrazaderas", this.getMessage("forms.acusticaruidoinstalaciones.columns.redesSaneamientoBajantesAbrazaderas.header", locale)));
		metaData.getColumn("redesSaneamientoBajantesAbrazaderas").setTooltip(this.getMessage("forms.acusticaruidoinstalaciones.columns.redesSaneamientoBajantesAbrazaderas.description", locale));
		metaData.getColumn("redesSaneamientoBajantesAbrazaderas").setGroupable(false);
		metaData.getColumn("redesSaneamientoBajantesAbrazaderas").setSortable(true);
		metaData.getColumn("redesSaneamientoBajantesAbrazaderas").setSofaFilter(GridColumnFilter.TYPE_LIST);
		
		metaData.getColumn("redesSaneamientoBajantesAbrazaderas").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] redesSaneamientoBajantesAbrazaderasStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NS), this.getMessage("forms.acusticaruidoinstalaciones.columns.redesSaneamientoBajantesAbrazaderas." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NS, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_SI), this.getMessage("forms.acusticaruidoinstalaciones.columns.redesSaneamientoBajantesAbrazaderas." + Keys.ACUSTICA_RUIDO_INSTALACIONES_SI, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NO), this.getMessage("forms.acusticaruidoinstalaciones.columns.redesSaneamientoBajantesAbrazaderas." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NO, locale)},
		};

		metaData.getColumn("redesSaneamientoBajantesAbrazaderas").setSofaStoreValues(redesSaneamientoBajantesAbrazaderasStore);

		metaData.getColumn("redesSaneamientoBajantesAbrazaderas").setEditable(true);
		metaData.getColumn("redesSaneamientoBajantesAbrazaderas").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("redesSaneamientoBajantesForradas", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("redesSaneamientoBajantesForradas", this.getMessage("forms.acusticaruidoinstalaciones.columns.redesSaneamientoBajantesForradas.header", locale)));
		metaData.getColumn("redesSaneamientoBajantesForradas").setTooltip(this.getMessage("forms.acusticaruidoinstalaciones.columns.redesSaneamientoBajantesForradas.description", locale));
		metaData.getColumn("redesSaneamientoBajantesForradas").setGroupable(false);
		metaData.getColumn("redesSaneamientoBajantesForradas").setSortable(true);
		metaData.getColumn("redesSaneamientoBajantesForradas").setSofaFilter(GridColumnFilter.TYPE_LIST);
		
		metaData.getColumn("redesSaneamientoBajantesForradas").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] redesSaneamientoBajantesForradasStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NS), this.getMessage("forms.acusticaruidoinstalaciones.columns.redesSaneamientoBajantesForradas." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NS, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_SI), this.getMessage("forms.acusticaruidoinstalaciones.columns.redesSaneamientoBajantesForradas." + Keys.ACUSTICA_RUIDO_INSTALACIONES_SI, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NO), this.getMessage("forms.acusticaruidoinstalaciones.columns.redesSaneamientoBajantesForradas." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NO, locale)},
		};

		metaData.getColumn("redesSaneamientoBajantesForradas").setSofaStoreValues(redesSaneamientoBajantesForradasStore);

		metaData.getColumn("redesSaneamientoBajantesForradas").setEditable(true);
		metaData.getColumn("redesSaneamientoBajantesForradas").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("redesSaneamientoBajantesRevestidas", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("redesSaneamientoBajantesRevestidas", this.getMessage("forms.acusticaruidoinstalaciones.columns.redesSaneamientoBajantesRevestidas.header", locale)));
		metaData.getColumn("redesSaneamientoBajantesRevestidas").setTooltip(this.getMessage("forms.acusticaruidoinstalaciones.columns.redesSaneamientoBajantesRevestidas.description", locale));
		metaData.getColumn("redesSaneamientoBajantesRevestidas").setGroupable(false);
		metaData.getColumn("redesSaneamientoBajantesRevestidas").setSortable(true);
		metaData.getColumn("redesSaneamientoBajantesRevestidas").setSofaFilter(GridColumnFilter.TYPE_LIST);
		
		metaData.getColumn("redesSaneamientoBajantesRevestidas").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] redesSaneamientoBajantesRevestidasStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NS), this.getMessage("forms.acusticaruidoinstalaciones.columns.redesSaneamientoBajantesRevestidas." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NS, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_SI), this.getMessage("forms.acusticaruidoinstalaciones.columns.redesSaneamientoBajantesRevestidas." + Keys.ACUSTICA_RUIDO_INSTALACIONES_SI, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NO), this.getMessage("forms.acusticaruidoinstalaciones.columns.redesSaneamientoBajantesRevestidas." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NO, locale)},
		};

		metaData.getColumn("redesSaneamientoBajantesRevestidas").setSofaStoreValues(redesSaneamientoBajantesRevestidasStore);

		metaData.getColumn("redesSaneamientoBajantesRevestidas").setEditable(true);
		metaData.getColumn("redesSaneamientoBajantesRevestidas").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("redesSaneamientoCodoBajante", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("redesSaneamientoCodoBajante", this.getMessage("forms.acusticaruidoinstalaciones.columns.redesSaneamientoCodoBajante.header", locale)));
		metaData.getColumn("redesSaneamientoCodoBajante").setGroupable(false);
		metaData.getColumn("redesSaneamientoCodoBajante").setSortable(true);
		metaData.getColumn("redesSaneamientoCodoBajante").setSofaFilter(GridColumnFilter.TYPE_LIST);
		
		metaData.getColumn("redesSaneamientoCodoBajante").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] redesSaneamientoCodoBajanteStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NS), this.getMessage("forms.acusticaruidoinstalaciones.columns.redesSaneamientoCodoBajante." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NS, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_SI), this.getMessage("forms.acusticaruidoinstalaciones.columns.redesSaneamientoCodoBajante." + Keys.ACUSTICA_RUIDO_INSTALACIONES_SI, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NO), this.getMessage("forms.acusticaruidoinstalaciones.columns.redesSaneamientoCodoBajante." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NO, locale)},
		};

		metaData.getColumn("redesSaneamientoCodoBajante").setSofaStoreValues(redesSaneamientoCodoBajanteStore);

		metaData.getColumn("redesSaneamientoCodoBajante").setEditable(true);
		metaData.getColumn("redesSaneamientoCodoBajante").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("redesSaneamientoRuidoMolesto", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("redesSaneamientoRuidoMolesto", this.getMessage("forms.acusticaruidoinstalaciones.columns.redesSaneamientoRuidoMolesto.header", locale)));
		metaData.getColumn("redesSaneamientoRuidoMolesto").setTooltip(this.getMessage("forms.acusticaruidoinstalaciones.columns.redesSaneamientoRuidoMolesto.description", locale));
		metaData.getColumn("redesSaneamientoRuidoMolesto").setGroupable(false);
		metaData.getColumn("redesSaneamientoRuidoMolesto").setSortable(true);
		metaData.getColumn("redesSaneamientoRuidoMolesto").setSofaFilter(GridColumnFilter.TYPE_LIST);
		
		metaData.getColumn("redesSaneamientoRuidoMolesto").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] redesSaneamientoRuidoMolestoStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NS), this.getMessage("forms.acusticaruidoinstalaciones.columns.redesSaneamientoRuidoMolesto." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NS, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_SI), this.getMessage("forms.acusticaruidoinstalaciones.columns.redesSaneamientoRuidoMolesto." + Keys.ACUSTICA_RUIDO_INSTALACIONES_SI, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NO), this.getMessage("forms.acusticaruidoinstalaciones.columns.redesSaneamientoRuidoMolesto." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NO, locale)},
		};

		metaData.getColumn("redesSaneamientoRuidoMolesto").setSofaStoreValues(redesSaneamientoRuidoMolestoStore);

		metaData.getColumn("redesSaneamientoRuidoMolesto").setEditable(true);
		metaData.getColumn("redesSaneamientoRuidoMolesto").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("redesSaneamientoRuidoMolestoTipoLocalizacion", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("redesSaneamientoRuidoMolestoTipoLocalizacion", this.getMessage("forms.acusticaruidoinstalaciones.columns.redesSaneamientoRuidoMolestoTipoLocalizacion.header", locale)));
		metaData.getColumn("redesSaneamientoRuidoMolestoTipoLocalizacion").setTooltip(this.getMessage("forms.acusticaruidoinstalaciones.columns.redesSaneamientoRuidoMolestoTipoLocalizacion.description", locale));
		metaData.getColumn("redesSaneamientoRuidoMolestoTipoLocalizacion").setGroupable(false);
		metaData.getColumn("redesSaneamientoRuidoMolestoTipoLocalizacion").setSortable(true);
		metaData.getColumn("redesSaneamientoRuidoMolestoTipoLocalizacion").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("redesSaneamientoRuidoMolestoTipoLocalizacion").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("redesSaneamientoRuidoMolestoTipoLocalizacion").setEditable(true);
		metaData.getColumn("redesSaneamientoRuidoMolestoTipoLocalizacion").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("redesSuministroAguaRuidoGolpeAriete", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("redesSuministroAguaRuidoGolpeAriete", this.getMessage("forms.acusticaruidoinstalaciones.columns.redesSuministroAguaRuidoGolpeAriete.header", locale)));
		metaData.getColumn("redesSuministroAguaRuidoGolpeAriete").setTooltip(this.getMessage("forms.acusticaruidoinstalaciones.columns.redesSuministroAguaRuidoGolpeAriete.description", locale));
		metaData.getColumn("redesSuministroAguaRuidoGolpeAriete").setGroupable(false);
		metaData.getColumn("redesSuministroAguaRuidoGolpeAriete").setSortable(true);
		metaData.getColumn("redesSuministroAguaRuidoGolpeAriete").setSofaFilter(GridColumnFilter.TYPE_LIST);
		
		metaData.getColumn("redesSuministroAguaRuidoGolpeAriete").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] redesSuministroAguaRuidoGolpeArieteStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NS), this.getMessage("forms.acusticaruidoinstalaciones.columns.redesSuministroAguaRuidoGolpeAriete." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NS, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_SI), this.getMessage("forms.acusticaruidoinstalaciones.columns.redesSuministroAguaRuidoGolpeAriete." + Keys.ACUSTICA_RUIDO_INSTALACIONES_SI, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NO), this.getMessage("forms.acusticaruidoinstalaciones.columns.redesSuministroAguaRuidoGolpeAriete." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NO, locale)},
		};

		metaData.getColumn("redesSuministroAguaRuidoGolpeAriete").setSofaStoreValues(redesSuministroAguaRuidoGolpeArieteStore);

		metaData.getColumn("redesSuministroAguaRuidoGolpeAriete").setEditable(true);
		metaData.getColumn("redesSuministroAguaRuidoGolpeAriete").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("redesSuministroAguaRuidoMolesto", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("redesSuministroAguaRuidoMolesto", this.getMessage("forms.acusticaruidoinstalaciones.columns.redesSuministroAguaRuidoMolesto.header", locale)));
		metaData.getColumn("redesSuministroAguaRuidoMolesto").setTooltip(this.getMessage("forms.acusticaruidoinstalaciones.columns.redesSuministroAguaRuidoMolesto.description", locale));
		metaData.getColumn("redesSuministroAguaRuidoMolesto").setGroupable(false);
		metaData.getColumn("redesSuministroAguaRuidoMolesto").setSortable(true);
		metaData.getColumn("redesSuministroAguaRuidoMolesto").setSofaFilter(GridColumnFilter.TYPE_LIST);
		
		metaData.getColumn("redesSuministroAguaRuidoMolesto").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] redesSuministroAguaRuidoMolestoStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NS), this.getMessage("forms.acusticaruidoinstalaciones.columns.redesSuministroAguaRuidoMolesto." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NS, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_SI), this.getMessage("forms.acusticaruidoinstalaciones.columns.redesSuministroAguaRuidoMolesto." + Keys.ACUSTICA_RUIDO_INSTALACIONES_SI, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NO), this.getMessage("forms.acusticaruidoinstalaciones.columns.redesSuministroAguaRuidoMolesto." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NO, locale)},
		};

		metaData.getColumn("redesSuministroAguaRuidoMolesto").setSofaStoreValues(redesSuministroAguaRuidoMolestoStore);

		metaData.getColumn("redesSuministroAguaRuidoMolesto").setEditable(true);
		metaData.getColumn("redesSuministroAguaRuidoMolesto").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("redesSuministroAguaTuberiasForradas", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("redesSuministroAguaTuberiasForradas", this.getMessage("forms.acusticaruidoinstalaciones.columns.redesSuministroAguaTuberiasForradas.header", locale)));
		metaData.getColumn("redesSuministroAguaTuberiasForradas").setTooltip(this.getMessage("forms.acusticaruidoinstalaciones.columns.redesSuministroAguaTuberiasForradas.description", locale));
		metaData.getColumn("redesSuministroAguaTuberiasForradas").setGroupable(false);
		metaData.getColumn("redesSuministroAguaTuberiasForradas").setSortable(true);
		metaData.getColumn("redesSuministroAguaTuberiasForradas").setSofaFilter(GridColumnFilter.TYPE_LIST);
		
		metaData.getColumn("redesSuministroAguaTuberiasForradas").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] redesSuministroAguaTuberiasForradasStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NS), this.getMessage("forms.acusticaruidoinstalaciones.columns.redesSuministroAguaTuberiasForradas." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NS, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_SI), this.getMessage("forms.acusticaruidoinstalaciones.columns.redesSuministroAguaTuberiasForradas." + Keys.ACUSTICA_RUIDO_INSTALACIONES_SI, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NO), this.getMessage("forms.acusticaruidoinstalaciones.columns.redesSuministroAguaTuberiasForradas." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NO, locale)},
		};

		metaData.getColumn("redesSuministroAguaTuberiasForradas").setSofaStoreValues(redesSuministroAguaTuberiasForradasStore);

		metaData.getColumn("redesSuministroAguaTuberiasForradas").setEditable(true);
		metaData.getColumn("redesSuministroAguaTuberiasForradas").setHidden(true);
		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("redesVentilacionConductoIndividual", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("redesVentilacionConductoIndividual", this.getMessage("forms.acusticaruidoinstalaciones.columns.redesVentilacionConductoIndividual.header", locale)));
		metaData.getColumn("redesVentilacionConductoIndividual").setTooltip(this.getMessage("forms.acusticaruidoinstalaciones.columns.redesVentilacionConductoIndividual.description", locale));
		metaData.getColumn("redesVentilacionConductoIndividual").setGroupable(false);
		metaData.getColumn("redesVentilacionConductoIndividual").setSortable(true);
		metaData.getColumn("redesVentilacionConductoIndividual").setSofaFilter(GridColumnFilter.TYPE_LIST);
		
		metaData.getColumn("redesVentilacionConductoIndividual").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] redesVentilacionConductoIndividualStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NS), this.getMessage("forms.acusticaruidoinstalaciones.columns.redesVentilacionConductoIndividual." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NS, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_SI), this.getMessage("forms.acusticaruidoinstalaciones.columns.redesVentilacionConductoIndividual." + Keys.ACUSTICA_RUIDO_INSTALACIONES_SI, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NO), this.getMessage("forms.acusticaruidoinstalaciones.columns.redesVentilacionConductoIndividual." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NO, locale)},
		};

		metaData.getColumn("redesVentilacionConductoIndividual").setSofaStoreValues(redesVentilacionConductoIndividualStore);

		metaData.getColumn("redesVentilacionConductoIndividual").setEditable(true);
		metaData.getColumn("redesVentilacionConductoIndividual").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("redesVentilacionConductosShunt", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("redesVentilacionConductosShunt", this.getMessage("forms.acusticaruidoinstalaciones.columns.redesVentilacionConductosShunt.header", locale)));
		metaData.getColumn("redesVentilacionConductosShunt").setTooltip(this.getMessage("forms.acusticaruidoinstalaciones.columns.redesVentilacionConductosShunt.description", locale));
		metaData.getColumn("redesVentilacionConductosShunt").setGroupable(false);
		metaData.getColumn("redesVentilacionConductosShunt").setSortable(true);
		metaData.getColumn("redesVentilacionConductosShunt").setSofaFilter(GridColumnFilter.TYPE_NUMERIC);
		
		metaData.getColumn("redesVentilacionConductosShunt").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] redesVentilacionConductosShuntStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NS), this.getMessage("forms.acusticaruidoinstalaciones.columns.redesVentilacionConductosShunt." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NS, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_SI), this.getMessage("forms.acusticaruidoinstalaciones.columns.redesVentilacionConductosShunt." + Keys.ACUSTICA_RUIDO_INSTALACIONES_SI, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NO), this.getMessage("forms.acusticaruidoinstalaciones.columns.redesVentilacionConductosShunt." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NO, locale)},
		};

		metaData.getColumn("redesVentilacionConductosShunt").setSofaStoreValues(redesVentilacionConductosShuntStore);

		metaData.getColumn("redesVentilacionConductosShunt").setEditable(true);
		metaData.getColumn("redesVentilacionConductosShunt").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("redesVentilacionRuidoViviendasColindantes", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("redesVentilacionRuidoViviendasColindantes", this.getMessage("forms.acusticaruidoinstalaciones.columns.redesVentilacionRuidoViviendasColindantes.header", locale)));
		metaData.getColumn("redesVentilacionRuidoViviendasColindantes").setTooltip(this.getMessage("forms.acusticaruidoinstalaciones.columns.redesVentilacionRuidoViviendasColindantes.description", locale));
		metaData.getColumn("redesVentilacionRuidoViviendasColindantes").setGroupable(false);
		metaData.getColumn("redesVentilacionRuidoViviendasColindantes").setSortable(true);
		metaData.getColumn("redesVentilacionRuidoViviendasColindantes").setSofaFilter(GridColumnFilter.TYPE_LIST);
		
		metaData.getColumn("redesVentilacionRuidoViviendasColindantes").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] redesVentilacionRuidoViviendasColindantesStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NS), this.getMessage("forms.acusticaruidoinstalaciones.columns.redesVentilacionRuidoViviendasColindantes." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NS, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_SI), this.getMessage("forms.acusticaruidoinstalaciones.columns.redesVentilacionRuidoViviendasColindantes." + Keys.ACUSTICA_RUIDO_INSTALACIONES_SI, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INSTALACIONES_NO), this.getMessage("forms.acusticaruidoinstalaciones.columns.redesVentilacionRuidoViviendasColindantes." + Keys.ACUSTICA_RUIDO_INSTALACIONES_NO, locale)},
		};

		metaData.getColumn("redesVentilacionRuidoViviendasColindantes").setSofaStoreValues(redesVentilacionRuidoViviendasColindantesStore);

		metaData.getColumn("redesVentilacionRuidoViviendasColindantes").setEditable(true);
		metaData.getColumn("redesVentilacionRuidoViviendasColindantes").setHidden(true);

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

		datosExportacion.add("claveInforme", this.getMessage("forms.acusticaruidoinstalaciones.columns.claveInforme.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("inspeccion", this.getMessage("forms.acusticaruidoinstalaciones.columns.inspeccion.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("equiposInstalacionesColindantes", this.getMessage("forms.acusticaruidoinstalaciones.columns.equiposInstalacionesColindantes.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("equiposInstalacionesConductosAnclados", this.getMessage("forms.acusticaruidoinstalaciones.columns.equiposInstalacionesConductosAnclados.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("equiposInstalacionesConectoresFlexibles", this.getMessage("forms.acusticaruidoinstalaciones.columns.equiposInstalacionesConectoresFlexibles.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("equiposInstalacionesHolgurasSelladas", this.getMessage("forms.acusticaruidoinstalaciones.columns.equiposInstalacionesHolgurasSelladas.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("equiposInstalacionesRuidoMolesto", this.getMessage("forms.acusticaruidoinstalaciones.columns.equiposInstalacionesRuidoMolesto.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("equiposInstalacionesRuidoMolestoTipoLocalizacion", this.getMessage("forms.acusticaruidoinstalaciones.columns.equiposInstalacionesRuidoMolestoTipoLocalizacion.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("equiposInstalacionesSistemaAmortiguante", this.getMessage("forms.acusticaruidoinstalaciones.columns.equiposInstalacionesSistemaAmortiguante.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("equiposInstalacionesZonasExteriores", this.getMessage("forms.acusticaruidoinstalaciones.columns.equiposInstalacionesZonasExteriores.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("equiposInstalacionesZonasExterioresPantallas", this.getMessage("forms.acusticaruidoinstalaciones.columns.equiposInstalacionesZonasExterioresPantallas.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("observaciones", this.getMessage("forms.acusticaruidoinstalaciones.columns.observaciones.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("otrasAscensoresColindantes", this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasAscensoresColindantes.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("otrasAscensoresCuadroManiobras", this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasAscensoresCuadroManiobras.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("otrasAscensoresCuartoMaquinas", this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasAscensoresCuartoMaquinas.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("otrasAscensoresRuidoMolesto", this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasAscensoresRuidoMolesto.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("otrasAscensoresRuidoMolestoTipoLocalizacion", this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasAscensoresRuidoMolestoTipoLocalizacion.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("otrasAscensoresSistemaAmortiguante", this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasAscensoresSistemaAmortiguante.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("otrasAscensoresTrasdosado", this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasAscensoresTrasdosado.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("otrasCuartosHumedosAireAcondicionado", this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasCuartosHumedosAireAcondicionado.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("otrasCuartosHumedosLuminariasEmpotradas", this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasCuartosHumedosLuminariasEmpotradas.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("otrasCuartosHumedosRuidoMolesto", this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasCuartosHumedosRuidoMolesto.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("otrasCuartosHumedosRuidoMolestoTipoLocalizacion", this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasCuartosHumedosRuidoMolestoTipoLocalizacion.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("otrasCuartosHumedosSaneamiento", this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasCuartosHumedosSaneamiento.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("otrasCuartosHumedosSaneamientoConectoresFlexibles", this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasCuartosHumedosSaneamientoConectoresFlexibles.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("otrasCuartosHumedosSaneamientoLanaMineral", this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasCuartosHumedosSaneamientoLanaMineral.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("otrasCuartosHumedosSaneamientoMaterialElastico", this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasCuartosHumedosSaneamientoMaterialElastico.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("otrasCuartosHumedosSaneamientoTechoSellado", this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasCuartosHumedosSaneamientoTechoSellado.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("otrasPuertasGarajeAncladas", this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasPuertasGarajeAncladas.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("otrasPuertasGarajeAncladasMarcoAmortiguadores", this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasPuertasGarajeAncladasMarcoAmortiguadores.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("otrasPuertasGarajeAncladasMotoresAmortiguadores", this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasPuertasGarajeAncladasMotoresAmortiguadores.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("otrasPuertasGarajeAncladasRuidoPuerta", this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasPuertasGarajeAncladasRuidoPuerta.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("recintosActividadRevestido", this.getMessage("forms.acusticaruidoinstalaciones.columns.recintosActividadRevestido.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("recintosActividadRuidoMolesto", this.getMessage("forms.acusticaruidoinstalaciones.columns.recintosActividadRuidoMolesto.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("recintosActividadRuidoMolestoTipoLocalizacion", this.getMessage("forms.acusticaruidoinstalaciones.columns.recintosActividadRuidoMolestoTipoLocalizacion.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("recintosActividadSueloFlotante", this.getMessage("forms.acusticaruidoinstalaciones.columns.recintosActividadSueloFlotante.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("recintosActividadTechoSuspendido", this.getMessage("forms.acusticaruidoinstalaciones.columns.recintosActividadTechoSuspendido.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("recintosActividadTechoSuspendidoAbsorvente", this.getMessage("forms.acusticaruidoinstalaciones.columns.recintosActividadTechoSuspendidoAbsorvente.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("recintosActividadTechoSuspendidoAmortiguadores", this.getMessage("forms.acusticaruidoinstalaciones.columns.recintosActividadTechoSuspendidoAmortiguadores.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("recintosActividadTiene", this.getMessage("forms.acusticaruidoinstalaciones.columns.recintosActividadTiene.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("recintosActividadTipoLocalizacion", this.getMessage("forms.acusticaruidoinstalaciones.columns.recintosActividadTipoLocalizacion.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("recintosActividadTrasdosados", this.getMessage("forms.acusticaruidoinstalaciones.columns.recintosActividadTrasdosados.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("recintosActividadTrasdosadosAmortiguadores", this.getMessage("forms.acusticaruidoinstalaciones.columns.recintosActividadTrasdosadosAmortiguadores.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("recintosActividadTratamientoAbsorvente", this.getMessage("forms.acusticaruidoinstalaciones.columns.recintosActividadTratamientoAbsorvente.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("redesAguaRuidoMolestoTipoLocalizacion", this.getMessage("forms.acusticaruidoinstalaciones.columns.redesAguaRuidoMolestoTipoLocalizacion.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("redesAireAcondicionadoFalsoTecho", this.getMessage("forms.acusticaruidoinstalaciones.columns.redesAireAcondicionadoFalsoTecho.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("redesAireAcondicionadoRuidoMolesto", this.getMessage("forms.acusticaruidoinstalaciones.columns.redesAireAcondicionadoRuidoMolesto.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("redesSaneamientoBajantesAbrazaderas", this.getMessage("forms.acusticaruidoinstalaciones.columns.redesSaneamientoBajantesAbrazaderas.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("redesSaneamientoBajantesForradas", this.getMessage("forms.acusticaruidoinstalaciones.columns.redesSaneamientoBajantesForradas.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("redesSaneamientoBajantesRevestidas", this.getMessage("forms.acusticaruidoinstalaciones.columns.redesSaneamientoBajantesRevestidas.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("redesSaneamientoCodoBajante", this.getMessage("forms.acusticaruidoinstalaciones.columns.redesSaneamientoCodoBajante.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("redesSaneamientoRuidoMolesto", this.getMessage("forms.acusticaruidoinstalaciones.columns.redesSaneamientoRuidoMolesto.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("redesSaneamientoRuidoMolestoTipoLocalizacion", this.getMessage("forms.acusticaruidoinstalaciones.columns.redesSaneamientoRuidoMolestoTipoLocalizacion.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("redesSuministroAguaRuidoGolpeAriete", this.getMessage("forms.acusticaruidoinstalaciones.columns.redesSuministroAguaRuidoGolpeAriete.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("redesSuministroAguaRuidoMolesto", this.getMessage("forms.acusticaruidoinstalaciones.columns.redesSuministroAguaRuidoMolesto.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("redesSuministroAguaTuberiasForradas", this.getMessage("forms.acusticaruidoinstalaciones.columns.redesSuministroAguaTuberiasForradas.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("redesVentilacionConductoIndividual", this.getMessage("forms.acusticaruidoinstalaciones.columns.redesVentilacionConductoIndividual.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("redesVentilacionConductosShunt", this.getMessage("forms.acusticaruidoinstalaciones.columns.redesVentilacionConductosShunt.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("redesVentilacionRuidoViviendasColindantes", this.getMessage("forms.acusticaruidoinstalaciones.columns.redesVentilacionRuidoViviendasColindantes.header", locale), TipoCampoExportacion.STRING);

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
		AcusticaRuidoInstalacionesListadoVO instance = (AcusticaRuidoInstalacionesListadoVO) rawInstance;

		List<String> excelRow = new ArrayList<String>();

		excelRow.add(FormData2Java.toString(instance.getClaveInforme()));
		excelRow.add(FormData2Java.toString(instance.getInspeccionLabel()));
		//excelRow.add(FormData2Java.toString(instance.getEquiposInstalacionesColindantes()));
		if (instance.getEquiposInstalacionesColindantes()!=null){
		excelRow.add( this.getMessage("forms.acusticaruidoinstalaciones.columns.equiposInstalacionesColindantes." + instance.getEquiposInstalacionesColindantes(), locale) );
		}else{
			excelRow.add("null");
		}
		//excelRow.add(FormData2Java.toString(instance.getEquiposInstalacionesConductosAnclados()));
		if (instance.getEquiposInstalacionesConductosAnclados()!=null){
		excelRow.add( this.getMessage("forms.acusticaruidoinstalaciones.columns.equiposInstalacionesConductosAnclados." + instance.getEquiposInstalacionesConductosAnclados(), locale) );
		}else{
			excelRow.add("null");
		}
		//excelRow.add(FormData2Java.toString(instance.getEquiposInstalacionesConectoresFlexibles()));
		if (instance.getEquiposInstalacionesConectoresFlexibles()!=null){
		excelRow.add( this.getMessage("forms.acusticaruidoinstalaciones.columns.equiposInstalacionesConectoresFlexibles." + instance.getEquiposInstalacionesConectoresFlexibles(), locale) );
		}else{
			excelRow.add("null");
		}
		//excelRow.add(FormData2Java.toString(instance.getEquiposInstalacionesHolgurasSelladas()));
		if (instance.getEquiposInstalacionesHolgurasSelladas()!=null){
		excelRow.add( this.getMessage("forms.acusticaruidoinstalaciones.columns.equiposInstalacionesHolgurasSelladas." + instance.getEquiposInstalacionesHolgurasSelladas(), locale) );
		}else{
			excelRow.add("null");
		}
		//excelRow.add(FormData2Java.toString(instance.getEquiposInstalacionesRuidoMolesto()));
		if (instance.getEquiposInstalacionesRuidoMolesto()!=null){
		excelRow.add( this.getMessage("forms.acusticaruidoinstalaciones.columns.equiposInstalacionesRuidoMolesto." + instance.getEquiposInstalacionesRuidoMolesto(), locale) );
		}else{
			excelRow.add("null");
		}
		excelRow.add(instance.getEquiposInstalacionesRuidoMolestoTipoLocalizacion());
		
		//excelRow.add(FormData2Java.toString(instance.getEquiposInstalacionesSistemaAmortiguante()));
		if (instance.getEquiposInstalacionesSistemaAmortiguante()!=null){
		excelRow.add( this.getMessage("forms.acusticaruidoinstalaciones.columns.equiposInstalacionesSistemaAmortiguante." + instance.getEquiposInstalacionesSistemaAmortiguante(), locale) );
		}else{
			excelRow.add("null");
		}
		//excelRow.add(FormData2Java.toString(instance.getEquiposInstalacionesZonasExteriores()));
		if (instance.getEquiposInstalacionesZonasExteriores()!=null){
		excelRow.add( this.getMessage("forms.acusticaruidoinstalaciones.columns.equiposInstalacionesZonasExteriores." + instance.getEquiposInstalacionesZonasExteriores(), locale) );
		}else{
			excelRow.add("null");
		}
		//excelRow.add(FormData2Java.toString(instance.getEquiposInstalacionesZonasExterioresPantallas()));
		if (instance.getEquiposInstalacionesZonasExterioresPantallas()!=null){
		excelRow.add( this.getMessage("forms.acusticaruidoinstalaciones.columns.equiposInstalacionesZonasExterioresPantallas." + instance.getEquiposInstalacionesZonasExterioresPantallas(), locale) );
		}else{
			excelRow.add("null");
		}
		excelRow.add(instance.getObservaciones());
		
		//excelRow.add(FormData2Java.toString(instance.getOtrasAscensoresColindantes()));
		if (instance.getOtrasAscensoresColindantes()!=null){
		excelRow.add( this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasAscensoresColindantes." + instance.getOtrasAscensoresColindantes(), locale) );
		}else{
			excelRow.add("null");
		}
		//excelRow.add(FormData2Java.toString(instance.getOtrasAscensoresCuadroManiobras()));
		if (instance.getOtrasAscensoresCuadroManiobras()!=null){
		excelRow.add( this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasAscensoresCuadroManiobras." + instance.getOtrasAscensoresCuadroManiobras(), locale) );
		}else{
			excelRow.add("null");
		}
		//excelRow.add(FormData2Java.toString(instance.getOtrasAscensoresCuartoMaquinas()));
		if (instance.getOtrasAscensoresCuartoMaquinas()!=null){
		excelRow.add( this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasAscensoresCuartoMaquinas." + instance.getOtrasAscensoresCuartoMaquinas(), locale) );
		}else{
			excelRow.add("null");
		}
		//excelRow.add(FormData2Java.toString(instance.getOtrasAscensoresRuidoMolesto()));
		if (instance.getOtrasAscensoresRuidoMolesto()!=null){
		excelRow.add( this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasAscensoresRuidoMolesto." + instance.getOtrasAscensoresRuidoMolesto(), locale) );
		}else{
			excelRow.add("null");
		}
		excelRow.add(instance.getOtrasAscensoresRuidoMolestoTipoLocalizacion());
		
		//excelRow.add(FormData2Java.toString(instance.getOtrasAscensoresSistemaAmortiguante()));
		if (instance.getOtrasAscensoresSistemaAmortiguante()!=null){
		excelRow.add( this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasAscensoresSistemaAmortiguante." + instance.getOtrasAscensoresSistemaAmortiguante(), locale) );
		}else{
			excelRow.add("null");
		}
		//excelRow.add(FormData2Java.toString(instance.getOtrasAscensoresTrasdosado()));
		if (instance.getOtrasAscensoresTrasdosado()!=null){
		excelRow.add( this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasAscensoresTrasdosado." + instance.getOtrasAscensoresTrasdosado(), locale) );
		}else{
			excelRow.add("null");
		}
		//excelRow.add(FormData2Java.toString(instance.getOtrasCuartosHumedosAireAcondicionado()));
		if (instance.getOtrasCuartosHumedosAireAcondicionado()!=null){
		excelRow.add( this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasCuartosHumedosAireAcondicionado." + instance.getOtrasCuartosHumedosAireAcondicionado(), locale) );
		}else{
			excelRow.add("null");
		}
		//excelRow.add(FormData2Java.toString(instance.getOtrasCuartosHumedosLuminariasEmpotradas()));
		if (instance.getOtrasCuartosHumedosLuminariasEmpotradas()!=null){
		excelRow.add( this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasCuartosHumedosLuminariasEmpotradas." + instance.getOtrasCuartosHumedosLuminariasEmpotradas(), locale) );
		}else{
			excelRow.add("null");
		}
		//excelRow.add(FormData2Java.toString(instance.getOtrasCuartosHumedosRuidoMolesto()));
		if (instance.getOtrasCuartosHumedosRuidoMolesto()!=null){
		excelRow.add( this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasCuartosHumedosRuidoMolesto." + instance.getOtrasCuartosHumedosRuidoMolesto(), locale) );
		}else{
			excelRow.add("null");
		}
		excelRow.add(instance.getOtrasCuartosHumedosRuidoMolestoTipoLocalizacion());
		
		//excelRow.add(FormData2Java.toString(instance.getOtrasCuartosHumedosSaneamiento()));
		if (instance.getOtrasCuartosHumedosSaneamiento()!=null){
		excelRow.add( this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasCuartosHumedosSaneamiento." + instance.getOtrasCuartosHumedosSaneamiento(), locale) );
		}else{
			excelRow.add("null");
		}
		//excelRow.add(FormData2Java.toString(instance.getOtrasCuartosHumedosSaneamientoConectoresFlexibles()));
		if (instance.getOtrasCuartosHumedosSaneamientoConectoresFlexibles()!=null){
		excelRow.add( this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasCuartosHumedosSaneamientoConectoresFlexibles." + instance.getOtrasCuartosHumedosSaneamientoConectoresFlexibles(), locale) );
		}else{
			excelRow.add("null");
		}
		//excelRow.add(FormData2Java.toString(instance.getOtrasCuartosHumedosSaneamientoLanaMineral()));
		if (instance.getOtrasCuartosHumedosSaneamientoLanaMineral()!=null){
		excelRow.add( this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasCuartosHumedosSaneamientoLanaMineral." + instance.getOtrasCuartosHumedosSaneamientoLanaMineral(), locale) );
		}else{
			excelRow.add("null");
		}
		//excelRow.add(FormData2Java.toString(instance.getOtrasCuartosHumedosSaneamientoMaterialElastico()));
		if (instance.getOtrasCuartosHumedosSaneamientoMaterialElastico()!=null){
		excelRow.add( this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasCuartosHumedosSaneamientoMaterialElastico." + instance.getOtrasCuartosHumedosSaneamientoMaterialElastico(), locale) );
		}else{
			excelRow.add("null");
		}
		//excelRow.add(FormData2Java.toString(instance.getOtrasCuartosHumedosSaneamientoTechoSellado()));
		if (instance.getOtrasCuartosHumedosSaneamientoTechoSellado()!=null){
		excelRow.add( this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasCuartosHumedosSaneamientoTechoSellado." + instance.getOtrasCuartosHumedosSaneamientoTechoSellado(), locale) );
		}else{
			excelRow.add("null");
		}
		//excelRow.add(FormData2Java.toString(instance.getOtrasPuertasGarajeAncladas()));
		if (instance.getOtrasPuertasGarajeAncladas()!=null){
		excelRow.add( this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasPuertasGarajeAncladas." + instance.getOtrasPuertasGarajeAncladas(), locale) );
		}else{
			excelRow.add("null");
		}
		//excelRow.add(FormData2Java.toString(instance.getOtrasPuertasGarajeAncladasMarcoAmortiguadores()));
		if (instance.getOtrasPuertasGarajeAncladasMarcoAmortiguadores()!=null){
		excelRow.add( this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasPuertasGarajeAncladasMarcoAmortiguadores." + instance.getOtrasPuertasGarajeAncladasMarcoAmortiguadores(), locale) );
		}else{
			excelRow.add("null");
		}
		//excelRow.add(FormData2Java.toString(instance.getOtrasPuertasGarajeAncladasMotoresAmortiguadores()));
		if (instance.getOtrasPuertasGarajeAncladasMotoresAmortiguadores()!=null){
		excelRow.add( this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasPuertasGarajeAncladasMotoresAmortiguadores." + instance.getOtrasPuertasGarajeAncladasMotoresAmortiguadores(), locale) );
		}else{
			excelRow.add("null");
		}
		//excelRow.add(FormData2Java.toString(instance.getOtrasPuertasGarajeAncladasRuidoPuerta()));
		if (instance.getOtrasPuertasGarajeAncladasRuidoPuerta()!=null){
		excelRow.add( this.getMessage("forms.acusticaruidoinstalaciones.columns.otrasPuertasGarajeAncladasRuidoPuerta." + instance.getOtrasPuertasGarajeAncladasRuidoPuerta(), locale) );
		}else{
			excelRow.add("null");
		}
		//excelRow.add(FormData2Java.toString(instance.getRecintosActividadRevestido()));
		if (instance.getRecintosActividadRevestido()!=null){
		excelRow.add( this.getMessage("forms.acusticaruidoinstalaciones.columns.recintosActividadRevestido." + instance.getRecintosActividadRevestido(), locale) );
		}else{
			excelRow.add("null");
		}
		//excelRow.add(FormData2Java.toString(instance.getRecintosActividadRuidoMolesto()));
		if (instance.getRecintosActividadRuidoMolesto()!=null){
		excelRow.add( this.getMessage("forms.acusticaruidoinstalaciones.columns.recintosActividadRuidoMolesto." + instance.getRecintosActividadRuidoMolesto(), locale) );
		}else{
			excelRow.add("null");
		}
		excelRow.add(instance.getRecintosActividadRuidoMolestoTipoLocalizacion());
		
		//excelRow.add(FormData2Java.toString(instance.getRecintosActividadSueloFlotante()));
		if (instance.getRecintosActividadSueloFlotante()!=null){
		excelRow.add( this.getMessage("forms.acusticaruidoinstalaciones.columns.recintosActividadSueloFlotante." + instance.getRecintosActividadSueloFlotante(), locale) );
		}else{
			excelRow.add("null");
		}
		//excelRow.add(FormData2Java.toString(instance.getRecintosActividadTechoSuspendido()));
		if (instance.getRecintosActividadTechoSuspendido()!=null){
		excelRow.add( this.getMessage("forms.acusticaruidoinstalaciones.columns.recintosActividadTechoSuspendido." + instance.getRecintosActividadTechoSuspendido(), locale) );
		}else{
			excelRow.add("null");
		}
		//excelRow.add(FormData2Java.toString(instance.getRecintosActividadTechoSuspendidoAbsorvente()));
		if (instance.getRecintosActividadTechoSuspendidoAbsorvente()!=null){
		excelRow.add( this.getMessage("forms.acusticaruidoinstalaciones.columns.recintosActividadTechoSuspendidoAbsorvente." + instance.getRecintosActividadTechoSuspendidoAbsorvente(), locale) );
		}else{
			excelRow.add("null");
		}
		//excelRow.add(FormData2Java.toString(instance.getRecintosActividadTechoSuspendidoAmortiguadores()));
		if (instance.getRecintosActividadTechoSuspendidoAmortiguadores()!=null){
		excelRow.add( this.getMessage("forms.acusticaruidoinstalaciones.columns.recintosActividadTechoSuspendidoAmortiguadores." + instance.getRecintosActividadTechoSuspendidoAmortiguadores(), locale) );
		}else{
			excelRow.add("null");
		}
		//excelRow.add(FormData2Java.toString(instance.getRecintosActividadTiene()));
		if (instance.getRecintosActividadTiene()!=null){
		excelRow.add( this.getMessage("forms.acusticaruidoinstalaciones.columns.recintosActividadTiene." + instance.getRecintosActividadTiene(), locale) );
		}else{
			excelRow.add("null");
		}
		excelRow.add(instance.getRecintosActividadTipoLocalizacion());
		
		//excelRow.add(FormData2Java.toString(instance.getRecintosActividadTrasdosados()));
		if (instance.getRecintosActividadTrasdosados()!=null){
		excelRow.add( this.getMessage("forms.acusticaruidoinstalaciones.columns.recintosActividadTrasdosados." + instance.getRecintosActividadTrasdosados(), locale) );
		}else{
			excelRow.add("null");
		}
		//excelRow.add(FormData2Java.toString(instance.getRecintosActividadTrasdosadosAmortiguadores()));
		if (instance.getRecintosActividadTrasdosadosAmortiguadores()!=null){
		excelRow.add( this.getMessage("forms.acusticaruidoinstalaciones.columns.recintosActividadTrasdosadosAmortiguadores." + instance.getRecintosActividadTrasdosadosAmortiguadores(), locale) );
		}else{
			excelRow.add("null");
		}
		//excelRow.add(FormData2Java.toString(instance.getRecintosActividadTratamientoAbsorvente()));
		if (instance.getRecintosActividadTratamientoAbsorvente()!=null){
		excelRow.add( this.getMessage("forms.acusticaruidoinstalaciones.columns.recintosActividadTratamientoAbsorvente." + instance.getRecintosActividadTratamientoAbsorvente(), locale) );
		}else{
			excelRow.add("null");
		}
		excelRow.add(instance.getRedesAguaRuidoMolestoTipoLocalizacion());
		
		//excelRow.add(FormData2Java.toString(instance.getRedesAireAcondicionadoFalsoTecho()));
		if (instance.getRedesAireAcondicionadoFalsoTecho()!=null){
		excelRow.add( this.getMessage("forms.acusticaruidoinstalaciones.columns.redesAireAcondicionadoFalsoTecho." + instance.getRedesAireAcondicionadoFalsoTecho(), locale) );
		}else{
			excelRow.add("null");
		}
		//excelRow.add(FormData2Java.toString(instance.getRedesAireAcondicionadoRuidoMolesto()));
		if (instance.getRedesAireAcondicionadoRuidoMolesto()!=null){
		excelRow.add( this.getMessage("forms.acusticaruidoinstalaciones.columns.redesAireAcondicionadoRuidoMolesto." + instance.getRedesAireAcondicionadoRuidoMolesto(), locale) );
		}else{
			excelRow.add("null");
		}
		//excelRow.add(FormData2Java.toString(instance.getRedesSaneamientoBajantesAbrazaderas()));
		if (instance.getRedesSaneamientoBajantesAbrazaderas()!=null){
		excelRow.add( this.getMessage("forms.acusticaruidoinstalaciones.columns.redesSaneamientoBajantesAbrazaderas." + instance.getRedesSaneamientoBajantesAbrazaderas(), locale) );
		}else{
			excelRow.add("null");
		}
		//excelRow.add(FormData2Java.toString(instance.getRedesSaneamientoBajantesForradas()));
		if (instance.getRedesSaneamientoBajantesForradas()!=null){
		excelRow.add( this.getMessage("forms.acusticaruidoinstalaciones.columns.redesSaneamientoBajantesForradas." + instance.getRedesSaneamientoBajantesForradas(), locale) );
		}else{
			excelRow.add("null");
		}
		//excelRow.add(FormData2Java.toString(instance.getRedesSaneamientoBajantesRevestidas()));
		if (instance.getRedesSaneamientoBajantesRevestidas()!=null){
		excelRow.add( this.getMessage("forms.acusticaruidoinstalaciones.columns.redesSaneamientoBajantesRevestidas." + instance.getRedesSaneamientoBajantesRevestidas(), locale) );
		}else{
			excelRow.add("null");
		}
		//excelRow.add(FormData2Java.toString(instance.getRedesSaneamientoCodoBajante()));
		if (instance.getRedesSaneamientoCodoBajante()!=null){
		excelRow.add( this.getMessage("forms.acusticaruidoinstalaciones.columns.redesSaneamientoCodoBajante." + instance.getRedesSaneamientoCodoBajante(), locale) );
		}else{
			excelRow.add("null");
		}
		//excelRow.add(FormData2Java.toString(instance.getRedesSaneamientoRuidoMolesto()));
		if (instance.getRedesSaneamientoRuidoMolesto()!=null){
		excelRow.add( this.getMessage("forms.acusticaruidoinstalaciones.columns.redesSaneamientoRuidoMolesto." + instance.getRedesSaneamientoRuidoMolesto(), locale) );
		}else{
			excelRow.add("null");
		}
		excelRow.add(instance.getRedesSaneamientoRuidoMolestoTipoLocalizacion());
		
		//excelRow.add(FormData2Java.toString(instance.getRedesSuministroAguaRuidoGolpeAriete()));
		if (instance.getRedesSuministroAguaRuidoGolpeAriete()!=null){
		excelRow.add( this.getMessage("forms.acusticaruidoinstalaciones.columns.redesSuministroAguaRuidoGolpeAriete." + instance.getRedesSuministroAguaRuidoGolpeAriete(), locale) );
		}else{
			excelRow.add("null");
		}
		//excelRow.add(FormData2Java.toString(instance.getRedesSuministroAguaRuidoMolesto()));
		if (instance.getRedesSuministroAguaRuidoMolesto()!=null){
		excelRow.add( this.getMessage("forms.acusticaruidoinstalaciones.columns.redesSuministroAguaRuidoMolesto." + instance.getRedesSuministroAguaRuidoMolesto(), locale) );
		}else{
			excelRow.add("null");
		}
		//excelRow.add(FormData2Java.toString(instance.getRedesSuministroAguaTuberiasForradas()));
		if (instance.getRedesSuministroAguaTuberiasForradas()!=null){
		excelRow.add( this.getMessage("forms.acusticaruidoinstalaciones.columns.redesSuministroAguaTuberiasForradas." + instance.getRedesSuministroAguaTuberiasForradas(), locale) );
		}else{
			excelRow.add("null");
		}
		//excelRow.add(FormData2Java.toString(instance.getRedesVentilacionConductoIndividual()));
		if (instance.getRedesVentilacionConductoIndividual()!=null){
		excelRow.add( this.getMessage("forms.acusticaruidoinstalaciones.columns.redesVentilacionConductoIndividual." + instance.getRedesVentilacionConductoIndividual(), locale) );
		}else{
			excelRow.add("null");
		}
		//excelRow.add(FormData2Java.toString(instance.getRedesVentilacionConductosShunt()));
		if (instance.getRedesVentilacionConductosShunt()!=null){
		excelRow.add( this.getMessage("forms.acusticaruidoinstalaciones.columns.redesVentilacionConductosShunt." + instance.getRedesVentilacionConductosShunt(), locale) );
		}else{
			excelRow.add("null");
		}
		//excelRow.add(FormData2Java.toString(instance.getRedesVentilacionRuidoViviendasColindantes()));
		if (instance.getRedesVentilacionRuidoViviendasColindantes()!=null){
		excelRow.add( this.getMessage("forms.acusticaruidoinstalaciones.columns.redesVentilacionRuidoViviendasColindantes." + instance.getRedesVentilacionRuidoViviendasColindantes(), locale) );
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
	 * Rellena una instancia de AcusticaRuidoInstalacionesFormVO con el
	 * contenido de un formulario recibido en formato Map<String, ?>
	 */
	protected void setFormData(AcusticaRuidoInstalacionesFormVO record, Map<String, ?> formData) throws GenericBusinessException {
		String formDataStr = null;
		if (!StringUtils.isEmpty(formData, "inspeccionId")) {
			formDataStr = (String) formData.get("inspeccionId");
			record.setInspeccionId(FormData2Java.toInteger(formDataStr));

		}
		if (formData.containsKey("equiposInstalacionesColindantes")) {
			formDataStr = (String) formData.get("equiposInstalacionesColindantes");
			record.setEquiposInstalacionesColindantes(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("equiposInstalacionesConductosAnclados")) {
			formDataStr = (String) formData.get("equiposInstalacionesConductosAnclados");
			record.setEquiposInstalacionesConductosAnclados(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("equiposInstalacionesConectoresFlexibles")) {
			formDataStr = (String) formData.get("equiposInstalacionesConectoresFlexibles");
			record.setEquiposInstalacionesConectoresFlexibles(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("equiposInstalacionesHolgurasSelladas")) {
			formDataStr = (String) formData.get("equiposInstalacionesHolgurasSelladas");
			record.setEquiposInstalacionesHolgurasSelladas(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("equiposInstalacionesRuidoMolesto")) {
			formDataStr = (String) formData.get("equiposInstalacionesRuidoMolesto");
			record.setEquiposInstalacionesRuidoMolesto(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("equiposInstalacionesRuidoMolestoTipoLocalizacion")) {
			formDataStr = (String) formData.get("equiposInstalacionesRuidoMolestoTipoLocalizacion");
			record.setEquiposInstalacionesRuidoMolestoTipoLocalizacion(formDataStr);
		}
		if (formData.containsKey("equiposInstalacionesSistemaAmortiguante")) {
			formDataStr = (String) formData.get("equiposInstalacionesSistemaAmortiguante");
			record.setEquiposInstalacionesSistemaAmortiguante(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("equiposInstalacionesZonasExteriores")) {
			formDataStr = (String) formData.get("equiposInstalacionesZonasExteriores");
			record.setEquiposInstalacionesZonasExteriores(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("equiposInstalacionesZonasExterioresPantallas")) {
			formDataStr = (String) formData.get("equiposInstalacionesZonasExterioresPantallas");
			record.setEquiposInstalacionesZonasExterioresPantallas(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("observaciones")) {
			formDataStr = (String) formData.get("observaciones");
			record.setObservaciones(formDataStr);
		}
		if (formData.containsKey("otrasAscensoresColindantes")) {
			formDataStr = (String) formData.get("otrasAscensoresColindantes");
			record.setOtrasAscensoresColindantes(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("otrasAscensoresCuadroManiobras")) {
			formDataStr = (String) formData.get("otrasAscensoresCuadroManiobras");
			record.setOtrasAscensoresCuadroManiobras(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("otrasAscensoresCuartoMaquinas")) {
			formDataStr = (String) formData.get("otrasAscensoresCuartoMaquinas");
			record.setOtrasAscensoresCuartoMaquinas(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("otrasAscensoresRuidoMolesto")) {
			formDataStr = (String) formData.get("otrasAscensoresRuidoMolesto");
			record.setOtrasAscensoresRuidoMolesto(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("otrasAscensoresRuidoMolestoTipoLocalizacion")) {
			formDataStr = (String) formData.get("otrasAscensoresRuidoMolestoTipoLocalizacion");
			record.setOtrasAscensoresRuidoMolestoTipoLocalizacion(formDataStr);
		}
		if (formData.containsKey("otrasAscensoresSistemaAmortiguante")) {
			formDataStr = (String) formData.get("otrasAscensoresSistemaAmortiguante");
			record.setOtrasAscensoresSistemaAmortiguante(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("otrasAscensoresTrasdosado")) {
			formDataStr = (String) formData.get("otrasAscensoresTrasdosado");
			record.setOtrasAscensoresTrasdosado(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("otrasCuartosHumedosAireAcondicionado")) {
			formDataStr = (String) formData.get("otrasCuartosHumedosAireAcondicionado");
			record.setOtrasCuartosHumedosAireAcondicionado(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("otrasCuartosHumedosLuminariasEmpotradas")) {
			formDataStr = (String) formData.get("otrasCuartosHumedosLuminariasEmpotradas");
			record.setOtrasCuartosHumedosLuminariasEmpotradas(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("otrasCuartosHumedosRuidoMolesto")) {
			formDataStr = (String) formData.get("otrasCuartosHumedosRuidoMolesto");
			record.setOtrasCuartosHumedosRuidoMolesto(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("otrasCuartosHumedosRuidoMolestoTipoLocalizacion")) {
			formDataStr = (String) formData.get("otrasCuartosHumedosRuidoMolestoTipoLocalizacion");
			record.setOtrasCuartosHumedosRuidoMolestoTipoLocalizacion(formDataStr);
		}
		if (formData.containsKey("otrasCuartosHumedosSaneamiento")) {
			formDataStr = (String) formData.get("otrasCuartosHumedosSaneamiento");
			record.setOtrasCuartosHumedosSaneamiento(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("otrasCuartosHumedosSaneamientoConectoresFlexibles")) {
			formDataStr = (String) formData.get("otrasCuartosHumedosSaneamientoConectoresFlexibles");
			record.setOtrasCuartosHumedosSaneamientoConectoresFlexibles(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("otrasCuartosHumedosSaneamientoLanaMineral")) {
			formDataStr = (String) formData.get("otrasCuartosHumedosSaneamientoLanaMineral");
			record.setOtrasCuartosHumedosSaneamientoLanaMineral(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("otrasCuartosHumedosSaneamientoMaterialElastico")) {
			formDataStr = (String) formData.get("otrasCuartosHumedosSaneamientoMaterialElastico");
			record.setOtrasCuartosHumedosSaneamientoMaterialElastico(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("otrasCuartosHumedosSaneamientoTechoSellado")) {
			formDataStr = (String) formData.get("otrasCuartosHumedosSaneamientoTechoSellado");
			record.setOtrasCuartosHumedosSaneamientoTechoSellado(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("otrasPuertasGarajeAncladas")) {
			formDataStr = (String) formData.get("otrasPuertasGarajeAncladas");
			record.setOtrasPuertasGarajeAncladas(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("otrasPuertasGarajeAncladasMarcoAmortiguadores")) {
			formDataStr = (String) formData.get("otrasPuertasGarajeAncladasMarcoAmortiguadores");
			record.setOtrasPuertasGarajeAncladasMarcoAmortiguadores(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("otrasPuertasGarajeAncladasMotoresAmortiguadores")) {
			formDataStr = (String) formData.get("otrasPuertasGarajeAncladasMotoresAmortiguadores");
			record.setOtrasPuertasGarajeAncladasMotoresAmortiguadores(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("otrasPuertasGarajeAncladasRuidoPuerta")) {
			formDataStr = (String) formData.get("otrasPuertasGarajeAncladasRuidoPuerta");
			record.setOtrasPuertasGarajeAncladasRuidoPuerta(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("recintosActividadRevestido")) {
			formDataStr = (String) formData.get("recintosActividadRevestido");
			record.setRecintosActividadRevestido(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("recintosActividadRuidoMolesto")) {
			formDataStr = (String) formData.get("recintosActividadRuidoMolesto");
			record.setRecintosActividadRuidoMolesto(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("recintosActividadRuidoMolestoTipoLocalizacion")) {
			formDataStr = (String) formData.get("recintosActividadRuidoMolestoTipoLocalizacion");
			record.setRecintosActividadRuidoMolestoTipoLocalizacion(formDataStr);
		}
		if (formData.containsKey("recintosActividadSueloFlotante")) {
			formDataStr = (String) formData.get("recintosActividadSueloFlotante");
			record.setRecintosActividadSueloFlotante(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("recintosActividadTechoSuspendido")) {
			formDataStr = (String) formData.get("recintosActividadTechoSuspendido");
			record.setRecintosActividadTechoSuspendido(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("recintosActividadTechoSuspendidoAbsorvente")) {
			formDataStr = (String) formData.get("recintosActividadTechoSuspendidoAbsorvente");
			record.setRecintosActividadTechoSuspendidoAbsorvente(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("recintosActividadTechoSuspendidoAmortiguadores")) {
			formDataStr = (String) formData.get("recintosActividadTechoSuspendidoAmortiguadores");
			record.setRecintosActividadTechoSuspendidoAmortiguadores(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("recintosActividadTiene")) {
			formDataStr = (String) formData.get("recintosActividadTiene");
			record.setRecintosActividadTiene(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("recintosActividadTipoLocalizacion")) {
			formDataStr = (String) formData.get("recintosActividadTipoLocalizacion");
			record.setRecintosActividadTipoLocalizacion(formDataStr);
		}
		if (formData.containsKey("recintosActividadTrasdosados")) {
			formDataStr = (String) formData.get("recintosActividadTrasdosados");
			record.setRecintosActividadTrasdosados(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("recintosActividadTrasdosadosAmortiguadores")) {
			formDataStr = (String) formData.get("recintosActividadTrasdosadosAmortiguadores");
			record.setRecintosActividadTrasdosadosAmortiguadores(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("recintosActividadTratamientoAbsorvente")) {
			formDataStr = (String) formData.get("recintosActividadTratamientoAbsorvente");
			record.setRecintosActividadTratamientoAbsorvente(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("redesAguaRuidoMolestoTipoLocalizacion")) {
			formDataStr = (String) formData.get("redesAguaRuidoMolestoTipoLocalizacion");
			record.setRedesAguaRuidoMolestoTipoLocalizacion(formDataStr);
		}
		if (formData.containsKey("redesAireAcondicionadoFalsoTecho")) {
			formDataStr = (String) formData.get("redesAireAcondicionadoFalsoTecho");
			record.setRedesAireAcondicionadoFalsoTecho(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("redesAireAcondicionadoRuidoMolesto")) {
			formDataStr = (String) formData.get("redesAireAcondicionadoRuidoMolesto");
			record.setRedesAireAcondicionadoRuidoMolesto(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("redesSaneamientoBajantesAbrazaderas")) {
			formDataStr = (String) formData.get("redesSaneamientoBajantesAbrazaderas");
			record.setRedesSaneamientoBajantesAbrazaderas(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("redesSaneamientoBajantesForradas")) {
			formDataStr = (String) formData.get("redesSaneamientoBajantesForradas");
			record.setRedesSaneamientoBajantesForradas(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("redesSaneamientoBajantesRevestidas")) {
			formDataStr = (String) formData.get("redesSaneamientoBajantesRevestidas");
			record.setRedesSaneamientoBajantesRevestidas(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("redesSaneamientoCodoBajante")) {
			formDataStr = (String) formData.get("redesSaneamientoCodoBajante");
			record.setRedesSaneamientoCodoBajante(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("redesSaneamientoRuidoMolesto")) {
			formDataStr = (String) formData.get("redesSaneamientoRuidoMolesto");
			record.setRedesSaneamientoRuidoMolesto(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("redesSaneamientoRuidoMolestoTipoLocalizacion")) {
			formDataStr = (String) formData.get("redesSaneamientoRuidoMolestoTipoLocalizacion");
			record.setRedesSaneamientoRuidoMolestoTipoLocalizacion(formDataStr);
		}
		if (formData.containsKey("redesSuministroAguaRuidoGolpeAriete")) {
			formDataStr = (String) formData.get("redesSuministroAguaRuidoGolpeAriete");
			record.setRedesSuministroAguaRuidoGolpeAriete(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("redesSuministroAguaRuidoMolesto")) {
			formDataStr = (String) formData.get("redesSuministroAguaRuidoMolesto");
			record.setRedesSuministroAguaRuidoMolesto(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("redesSuministroAguaTuberiasForradas")) {
			formDataStr = (String) formData.get("redesSuministroAguaTuberiasForradas");
			record.setRedesSuministroAguaTuberiasForradas(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("redesVentilacionConductoIndividual")) {
			formDataStr = (String) formData.get("redesVentilacionConductoIndividual");
			record.setRedesVentilacionConductoIndividual(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("redesVentilacionConductosShunt")) {
			formDataStr = (String) formData.get("redesVentilacionConductosShunt");
			record.setRedesVentilacionConductosShunt(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("redesVentilacionRuidoViviendasColindantes")) {
			formDataStr = (String) formData.get("redesVentilacionRuidoViviendasColindantes");
			record.setRedesVentilacionRuidoViviendasColindantes(FormData2Java.toInteger(formDataStr));
		}
	}

}
