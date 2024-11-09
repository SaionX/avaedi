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
import es.caib.avaedi.logic.bo.AcusticaRuidosInterioresVerticalesBO;
import es.caib.avaedi.logic.bo.InspeccionBO;
import es.caib.avaedi.logic.util.Keys;
import es.caib.avaedi.logic.vo.AcusticaRuidosInterioresVerticalesFormVO;
import es.caib.avaedi.logic.vo.AcusticaRuidosInterioresVerticalesListadoVO;
import es.caib.avaedi.logic.vo.AcusticasListadoVO;

/**
 * Servicio para tratar el formulario: AcusticaRuidosInterioresVerticales
 * 
 * @author agarcia@at4.net
 * 
 */
@Service("acusticaruidosinterioresverticales")
public class AcusticaRuidosInterioresVerticalesService extends InspeccionBaseService<AcusticaRuidosInterioresVerticalesBO, AcusticaRuidosInterioresVerticalesListadoVO, AcusticaRuidosInterioresVerticalesFormVO> {

	/**
	 * The logger object.
	 */
	private static Logger log = LogService.getLogger(AcusticaRuidosInterioresVerticalesService.class);

	/**
	 * Bean para acceder a los métodos de negocio:
	 * AcusticaRuidosInterioresVerticales
	 */
	@Autowired
	@Qualifier("AcusticaRuidosInterioresVerticalesBean")
	protected AcusticaRuidosInterioresVerticalesBO mainBO;

	/**
	 * Bean para acceder a los métodos de negocio:
	 * AcusticaRuidosInterioresVerticales
	 * 
	 * @param bean
	 *            the bean to set
	 */
	protected AcusticaRuidosInterioresVerticalesBO getMainBO() {
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
			formItem.setText(this.getMessage("forms.acusticaruidosinterioresverticales.title", locale));
		}

		GridMetaData metaData = this.getBaseMetaData(formItem, locale);

		//Nombre de la clase js de formulario
		metaData.setFormClassName("AcusticaRuidosInterioresVerticalesForm");

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
		/*metaData.addColumn(new GridColumnMetaData("claveInforme", this.getMessage("forms.acusticaruidosinterioresverticales.columns.claveInforme.header", locale)));
		metaData.getColumn("claveInforme").setGroupable(false);
		metaData.getColumn("claveInforme").setSortable(true);
		metaData.getColumn("claveInforme").setSofaFilter(GridColumnFilter.TYPE_NUMERIC);*/

		//Creamos el registro para el record
		/*metaData.addRecordField(new GridRecordFieldMetaData("inspeccionId", GridRecordFieldMetaData.INT_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("inspeccionLabel", GridRecordFieldMetaData.INT_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("inspeccion", "inspeccionLabel", GridRecordFieldMetaData.INT_TYPE));*/

		/** Creamos la columna */
		/*metaData.addColumn(new GridColumnMetaData("inspeccion", this.getMessage("forms.acusticaruidosinterioresverticales.columns.inspeccion.header", locale)));
		metaData.getColumn("inspeccion").setGroupable(true);
		metaData.getColumn("inspeccion").setSortable(true);
		metaData.getColumn("inspeccion").setSofaFilter(GridColumnFilter.TYPE_MULTICOMBO);
		metaData.getColumn("inspeccion").setRelatedForm("Inspeccion");

		metaData.getColumn("inspeccion").setEditable(true);*/

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("ruiiIntVertSepTipoTex", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("ruiiIntVertSepTipoTex", this.getMessage("forms.acusticaruidosinterioresverticales.columns.ruiiIntVertSepTipoTex.header", locale)));
		metaData.getColumn("ruiiIntVertSepTipoTex").setTooltip(this.getMessage("forms.acusticaruidosinterioresverticales.columns.ruiiIntVertSepTipoTex.description", locale));
		metaData.getColumn("ruiiIntVertSepTipoTex").setGroupable(false);
		metaData.getColumn("ruiiIntVertSepTipoTex").setSortable(true);
		metaData.getColumn("ruiiIntVertSepTipoTex").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("ruiiIntVertSepTipoTex").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("ruiiIntVertSepTipoTex").setEditable(true);
		metaData.getColumn("ruiiIntVertSepTipoTex").setHidden(true);
		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("ruiIntVertTabTipoTex", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("ruiIntVertTabTipoTex", this.getMessage("forms.acusticaruidosinterioresverticales.columns.ruiIntVertTabTipoTex.header", locale)));
		metaData.getColumn("ruiIntVertTabTipoTex").setTooltip(this.getMessage("forms.acusticaruidosinterioresverticales.columns.ruiIntVertTabTipoTex.description", locale));
		metaData.getColumn("ruiIntVertTabTipoTex").setGroupable(false);
		metaData.getColumn("ruiIntVertTabTipoTex").setSortable(true);
		metaData.getColumn("ruiIntVertTabTipoTex").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("ruiIntVertTabTipoTex").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("ruiIntVertTabTipoTex").setEditable(true);
		metaData.getColumn("ruiIntVertTabTipoTex").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("caracteristicasHuecosAdosados", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("caracteristicasHuecosAdosados", this.getMessage("forms.acusticaruidosinterioresverticales.columns.caracteristicasHuecosAdosados.header", locale)));
		metaData.getColumn("caracteristicasHuecosAdosados").setTooltip(this.getMessage("forms.acusticaruidosinterioresverticales.columns.caracteristicasHuecosAdosados.description", locale));
		metaData.getColumn("caracteristicasHuecosAdosados").setGroupable(false);
		metaData.getColumn("caracteristicasHuecosAdosados").setSortable(true);
		metaData.getColumn("caracteristicasHuecosAdosados").setSofaFilter(GridColumnFilter.TYPE_LIST);
		
		metaData.getColumn("caracteristicasHuecosAdosados").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] caracteristicasHuecosAdosadosStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_NS), this.getMessage("forms.acusticaruidosinterioresverticales.columns.caracteristicasHuecosAdosados." + Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_NS, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_SI), this.getMessage("forms.acusticaruidosinterioresverticales.columns.caracteristicasHuecosAdosados." + Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_SI, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_NO), this.getMessage("forms.acusticaruidosinterioresverticales.columns.caracteristicasHuecosAdosados." + Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_NO, locale)},
		};

		metaData.getColumn("caracteristicasHuecosAdosados").setSofaStoreValues(caracteristicasHuecosAdosadosStore);

		metaData.getColumn("caracteristicasHuecosAdosados").setEditable(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("caracteristicasHuecosAdosadosRevestidos", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("caracteristicasHuecosAdosadosRevestidos", this.getMessage("forms.acusticaruidosinterioresverticales.columns.caracteristicasHuecosAdosadosRevestidos.header", locale)));
		metaData.getColumn("caracteristicasHuecosAdosadosRevestidos").setTooltip(this.getMessage("forms.acusticaruidosinterioresverticales.columns.caracteristicasHuecosAdosadosRevestidos.description", locale));
		metaData.getColumn("caracteristicasHuecosAdosadosRevestidos").setGroupable(false);
		metaData.getColumn("caracteristicasHuecosAdosadosRevestidos").setSortable(true);
		metaData.getColumn("caracteristicasHuecosAdosadosRevestidos").setSofaFilter(GridColumnFilter.TYPE_LIST);
		
		metaData.getColumn("caracteristicasHuecosAdosadosRevestidos").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] caracteristicasHuecosAdosadosRevestidosStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_NS), this.getMessage("forms.acusticaruidosinterioresverticales.columns.caracteristicasHuecosAdosadosRevestidos." + Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_NS, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_SI), this.getMessage("forms.acusticaruidosinterioresverticales.columns.caracteristicasHuecosAdosadosRevestidos." + Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_SI, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_NO), this.getMessage("forms.acusticaruidosinterioresverticales.columns.caracteristicasHuecosAdosadosRevestidos." + Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_NO, locale)},
		};

		metaData.getColumn("caracteristicasHuecosAdosadosRevestidos").setSofaStoreValues(caracteristicasHuecosAdosadosRevestidosStore);

		metaData.getColumn("caracteristicasHuecosAdosadosRevestidos").setEditable(true);
		metaData.getColumn("caracteristicasHuecosAdosadosRevestidos").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("caracteristicasHuecosAdosadosRuidoMolesto", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("caracteristicasHuecosAdosadosRuidoMolesto", this.getMessage("forms.acusticaruidosinterioresverticales.columns.caracteristicasHuecosAdosadosRuidoMolesto.header", locale)));
		metaData.getColumn("caracteristicasHuecosAdosadosRuidoMolesto").setTooltip(this.getMessage("forms.acusticaruidosinterioresverticales.columns.caracteristicasHuecosAdosadosRuidoMolesto.description", locale));
		metaData.getColumn("caracteristicasHuecosAdosadosRuidoMolesto").setGroupable(false);
		metaData.getColumn("caracteristicasHuecosAdosadosRuidoMolesto").setSortable(true);
		metaData.getColumn("caracteristicasHuecosAdosadosRuidoMolesto").setSofaFilter(GridColumnFilter.TYPE_LIST);
		
		metaData.getColumn("caracteristicasHuecosAdosadosRuidoMolesto").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] caracteristicasHuecosAdosadosRuidoMolestoStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_NS), this.getMessage("forms.acusticaruidosinterioresverticales.columns.caracteristicasHuecosAdosadosRuidoMolesto." + Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_NS, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_SI), this.getMessage("forms.acusticaruidosinterioresverticales.columns.caracteristicasHuecosAdosadosRuidoMolesto." + Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_SI, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_NO), this.getMessage("forms.acusticaruidosinterioresverticales.columns.caracteristicasHuecosAdosadosRuidoMolesto." + Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_NO, locale)},
		};

		metaData.getColumn("caracteristicasHuecosAdosadosRuidoMolesto").setSofaStoreValues(caracteristicasHuecosAdosadosRuidoMolestoStore);

		metaData.getColumn("caracteristicasHuecosAdosadosRuidoMolesto").setEditable(true);
		metaData.getColumn("caracteristicasHuecosAdosadosRuidoMolesto").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("caracteristicasInstalacionesAtraviesanRecintos", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("caracteristicasInstalacionesAtraviesanRecintos", this.getMessage("forms.acusticaruidosinterioresverticales.columns.caracteristicasInstalacionesAtraviesanRecintos.header", locale)));
		metaData.getColumn("caracteristicasInstalacionesAtraviesanRecintos").setTooltip(this.getMessage("forms.acusticaruidosinterioresverticales.columns.caracteristicasInstalacionesAtraviesanRecintos.description", locale));
		metaData.getColumn("caracteristicasInstalacionesAtraviesanRecintos").setGroupable(false);
		metaData.getColumn("caracteristicasInstalacionesAtraviesanRecintos").setSortable(true);
		metaData.getColumn("caracteristicasInstalacionesAtraviesanRecintos").setSofaFilter(GridColumnFilter.TYPE_LIST);
		
		metaData.getColumn("caracteristicasInstalacionesAtraviesanRecintos").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] caracteristicasInstalacionesAtraviesanRecintosStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_NS), this.getMessage("forms.acusticaruidosinterioresverticales.columns.caracteristicasInstalacionesAtraviesanRecintos." + Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_NS, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_SI), this.getMessage("forms.acusticaruidosinterioresverticales.columns.caracteristicasInstalacionesAtraviesanRecintos." + Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_SI, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_NO), this.getMessage("forms.acusticaruidosinterioresverticales.columns.caracteristicasInstalacionesAtraviesanRecintos." + Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_NO, locale)},
		};

		metaData.getColumn("caracteristicasInstalacionesAtraviesanRecintos").setSofaStoreValues(caracteristicasInstalacionesAtraviesanRecintosStore);

		metaData.getColumn("caracteristicasInstalacionesAtraviesanRecintos").setEditable(true);
		metaData.getColumn("caracteristicasInstalacionesAtraviesanRecintos").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("caracteristicasInstalacionesConectanRecintos", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("caracteristicasInstalacionesConectanRecintos", this.getMessage("forms.acusticaruidosinterioresverticales.columns.caracteristicasInstalacionesConectanRecintos.header", locale)));
		metaData.getColumn("caracteristicasInstalacionesConectanRecintos").setTooltip(this.getMessage("forms.acusticaruidosinterioresverticales.columns.caracteristicasInstalacionesConectanRecintos.description", locale));
		metaData.getColumn("caracteristicasInstalacionesConectanRecintos").setGroupable(false);
		metaData.getColumn("caracteristicasInstalacionesConectanRecintos").setSortable(true);
		metaData.getColumn("caracteristicasInstalacionesConectanRecintos").setSofaFilter(GridColumnFilter.TYPE_LIST);
		
		metaData.getColumn("caracteristicasInstalacionesConectanRecintos").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] caracteristicasInstalacionesConectanRecintosStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_NS), this.getMessage("forms.acusticaruidosinterioresverticales.columns.caracteristicasInstalacionesConectanRecintos." + Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_NS, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_SI), this.getMessage("forms.acusticaruidosinterioresverticales.columns.caracteristicasInstalacionesConectanRecintos." + Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_SI, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_NO), this.getMessage("forms.acusticaruidosinterioresverticales.columns.caracteristicasInstalacionesConectanRecintos." + Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_NO, locale)},
		};

		metaData.getColumn("caracteristicasInstalacionesConectanRecintos").setSofaStoreValues(caracteristicasInstalacionesConectanRecintosStore);

		metaData.getColumn("caracteristicasInstalacionesConectanRecintos").setEditable(true);
		metaData.getColumn("caracteristicasInstalacionesConectanRecintos").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("caracteristicasPilaresConectanRecintos", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("caracteristicasPilaresConectanRecintos", this.getMessage("forms.acusticaruidosinterioresverticales.columns.caracteristicasPilaresConectanRecintos.header", locale)));
		metaData.getColumn("caracteristicasPilaresConectanRecintos").setTooltip(this.getMessage("forms.acusticaruidosinterioresverticales.columns.caracteristicasPilaresConectanRecintos.description", locale));
		metaData.getColumn("caracteristicasPilaresConectanRecintos").setGroupable(false);
		metaData.getColumn("caracteristicasPilaresConectanRecintos").setSortable(true);
		metaData.getColumn("caracteristicasPilaresConectanRecintos").setSofaFilter(GridColumnFilter.TYPE_LIST);
		
		metaData.getColumn("caracteristicasPilaresConectanRecintos").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] caracteristicasPilaresConectanRecintosStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_NS), this.getMessage("forms.acusticaruidosinterioresverticales.columns.caracteristicasPilaresConectanRecintos." + Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_NS, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_SI), this.getMessage("forms.acusticaruidosinterioresverticales.columns.caracteristicasPilaresConectanRecintos." + Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_SI, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_NO), this.getMessage("forms.acusticaruidosinterioresverticales.columns.caracteristicasPilaresConectanRecintos." + Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_NO, locale)},
		};

		metaData.getColumn("caracteristicasPilaresConectanRecintos").setSofaStoreValues(caracteristicasPilaresConectanRecintosStore);

		metaData.getColumn("caracteristicasPilaresConectanRecintos").setEditable(true);
		metaData.getColumn("caracteristicasPilaresConectanRecintos").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("caracteristicasPilaresConectanRecintosRevestidos", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("caracteristicasPilaresConectanRecintosRevestidos", this.getMessage("forms.acusticaruidosinterioresverticales.columns.caracteristicasPilaresConectanRecintosRevestidos.header", locale)));
		metaData.getColumn("caracteristicasPilaresConectanRecintosRevestidos").setTooltip(this.getMessage("forms.acusticaruidosinterioresverticales.columns.caracteristicasPilaresConectanRecintosRevestidos.description", locale));
		metaData.getColumn("caracteristicasPilaresConectanRecintosRevestidos").setGroupable(false);
		metaData.getColumn("caracteristicasPilaresConectanRecintosRevestidos").setSortable(true);
		metaData.getColumn("caracteristicasPilaresConectanRecintosRevestidos").setSofaFilter(GridColumnFilter.TYPE_LIST);
		
		metaData.getColumn("caracteristicasPilaresConectanRecintosRevestidos").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] caracteristicasPilaresConectanRecintosRevestidosStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_NS), this.getMessage("forms.acusticaruidosinterioresverticales.columns.caracteristicasPilaresConectanRecintosRevestidos." + Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_NS, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_SI), this.getMessage("forms.acusticaruidosinterioresverticales.columns.caracteristicasPilaresConectanRecintosRevestidos." + Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_SI, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_NO), this.getMessage("forms.acusticaruidosinterioresverticales.columns.caracteristicasPilaresConectanRecintosRevestidos." + Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_NO, locale)},
		};

		metaData.getColumn("caracteristicasPilaresConectanRecintosRevestidos").setSofaStoreValues(caracteristicasPilaresConectanRecintosRevestidosStore);

		metaData.getColumn("caracteristicasPilaresConectanRecintosRevestidos").setEditable(true);
		metaData.getColumn("caracteristicasPilaresConectanRecintosRevestidos").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("caracteristicasTuberiasAncladas", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("caracteristicasTuberiasAncladas", this.getMessage("forms.acusticaruidosinterioresverticales.columns.caracteristicasTuberiasAncladas.header", locale)));
		metaData.getColumn("caracteristicasTuberiasAncladas").setTooltip(this.getMessage("forms.acusticaruidosinterioresverticales.columns.caracteristicasTuberiasAncladas.description", locale));
		metaData.getColumn("caracteristicasTuberiasAncladas").setGroupable(false);
		metaData.getColumn("caracteristicasTuberiasAncladas").setSortable(true);
		metaData.getColumn("caracteristicasTuberiasAncladas").setSofaFilter(GridColumnFilter.TYPE_LIST);
		
		metaData.getColumn("caracteristicasTuberiasAncladas").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] caracteristicasTuberiasAncladasStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_NS), this.getMessage("forms.acusticaruidosinterioresverticales.columns.caracteristicasTuberiasAncladas." + Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_NS, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_SI), this.getMessage("forms.acusticaruidosinterioresverticales.columns.caracteristicasTuberiasAncladas." + Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_SI, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_NO), this.getMessage("forms.acusticaruidosinterioresverticales.columns.caracteristicasTuberiasAncladas." + Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_NO, locale)},
		};

		metaData.getColumn("caracteristicasTuberiasAncladas").setSofaStoreValues(caracteristicasTuberiasAncladasStore);

		metaData.getColumn("caracteristicasTuberiasAncladas").setEditable(true);
		metaData.getColumn("caracteristicasTuberiasAncladas").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("deficienciasObservaciones", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("deficienciasObservaciones", this.getMessage("forms.acusticaruidosinterioresverticales.columns.deficienciasObservaciones.header", locale)));
		metaData.getColumn("deficienciasObservaciones").setGroupable(false);
		metaData.getColumn("deficienciasObservaciones").setSortable(true);
		metaData.getColumn("deficienciasObservaciones").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("deficienciasObservaciones").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("deficienciasObservaciones").setEditable(true);
		metaData.getColumn("deficienciasObservaciones").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("estadoSeparacionBueno", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("estadoSeparacionBueno", this.getMessage("forms.acusticaruidosinterioresverticales.columns.estadoSeparacionBueno.header", locale)));
		metaData.getColumn("estadoSeparacionBueno").setGroupable(false);
		metaData.getColumn("estadoSeparacionBueno").setSortable(true);
		metaData.getColumn("estadoSeparacionBueno").setSofaFilter(GridColumnFilter.TYPE_LIST);
		
		metaData.getColumn("estadoSeparacionBueno").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] estadoSeparacionBuenoStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_NS), this.getMessage("forms.acusticaruidosinterioresverticales.columns.estadoSeparacionBueno." + Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_NS, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_SI), this.getMessage("forms.acusticaruidosinterioresverticales.columns.estadoSeparacionBueno." + Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_SI, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_NO), this.getMessage("forms.acusticaruidosinterioresverticales.columns.estadoSeparacionBueno." + Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_NO, locale)},
		};

		metaData.getColumn("estadoSeparacionBueno").setSofaStoreValues(estadoSeparacionBuenoStore);

		metaData.getColumn("estadoSeparacionBueno").setEditable(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("observaciones", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("observaciones", this.getMessage("forms.acusticaruidosinterioresverticales.columns.observaciones.header", locale)));
		metaData.getColumn("observaciones").setGroupable(false);
		metaData.getColumn("observaciones").setSortable(true);
		metaData.getColumn("observaciones").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("observaciones").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("observaciones").setEditable(true);
		metaData.getColumn("observaciones").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("separacionEntramadoAutoportante", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("separacionEntramadoAutoportante", this.getMessage("forms.acusticaruidosinterioresverticales.columns.separacionEntramadoAutoportante.header", locale)));
		metaData.getColumn("separacionEntramadoAutoportante").setTooltip(this.getMessage("forms.acusticaruidosinterioresverticales.columns.separacionEntramadoAutoportante.description", locale));
		metaData.getColumn("separacionEntramadoAutoportante").setGroupable(false);
		metaData.getColumn("separacionEntramadoAutoportante").setSortable(true);
		metaData.getColumn("separacionEntramadoAutoportante").setSofaFilter(GridColumnFilter.TYPE_LIST);
		
		metaData.getColumn("separacionEntramadoAutoportante").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] separacionEntramadoAutoportanteStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_NS), this.getMessage("forms.acusticaruidosinterioresverticales.columns.separacionEntramadoAutoportante." + Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_NS, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_SI), this.getMessage("forms.acusticaruidosinterioresverticales.columns.separacionEntramadoAutoportante." + Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_SI, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_NO), this.getMessage("forms.acusticaruidosinterioresverticales.columns.separacionEntramadoAutoportante." + Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_NO, locale)},
		};

		metaData.getColumn("separacionEntramadoAutoportante").setSofaStoreValues(separacionEntramadoAutoportanteStore);

		metaData.getColumn("separacionEntramadoAutoportante").setEditable(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("separacionEntramadoAutoportanteAbsorbente", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("separacionEntramadoAutoportanteAbsorbente", this.getMessage("forms.acusticaruidosinterioresverticales.columns.separacionEntramadoAutoportanteAbsorbente.header", locale)));
		metaData.getColumn("separacionEntramadoAutoportanteAbsorbente").setTooltip(this.getMessage("forms.acusticaruidosinterioresverticales.columns.separacionEntramadoAutoportanteAbsorbente.description", locale));
		metaData.getColumn("separacionEntramadoAutoportanteAbsorbente").setGroupable(false);
		metaData.getColumn("separacionEntramadoAutoportanteAbsorbente").setSortable(true);
		metaData.getColumn("separacionEntramadoAutoportanteAbsorbente").setSofaFilter(GridColumnFilter.TYPE_LIST);
		
		metaData.getColumn("separacionEntramadoAutoportanteAbsorbente").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] separacionEntramadoAutoportanteAbsorbenteStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_SI), this.getMessage("forms.acusticaruidosinterioresverticales.columns.separacionEntramadoAutoportanteAbsorbenteStore." + Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_SI, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_NO), this.getMessage("forms.acusticaruidosinterioresverticales.columns.separacionEntramadoAutoportanteAbsorbenteStore." + Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_NO, locale)},
		};

		metaData.getColumn("separacionEntramadoAutoportanteAbsorbente").setSofaStoreValues(separacionEntramadoAutoportanteAbsorbenteStore);

		metaData.getColumn("separacionEntramadoAutoportanteAbsorbente").setEditable(true);
		metaData.getColumn("separacionEntramadoAutoportanteAbsorbente").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("separacionEntramadoAutoportanteDoshojas", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("separacionEntramadoAutoportanteDoshojas", this.getMessage("forms.acusticaruidosinterioresverticales.columns.separacionEntramadoAutoportanteDoshojas.header", locale)));
		metaData.getColumn("separacionEntramadoAutoportanteDoshojas").setTooltip(this.getMessage("forms.acusticaruidosinterioresverticales.columns.separacionEntramadoAutoportanteDoshojas.description", locale));
		metaData.getColumn("separacionEntramadoAutoportanteDoshojas").setGroupable(false);
		metaData.getColumn("separacionEntramadoAutoportanteDoshojas").setSortable(true);
		metaData.getColumn("separacionEntramadoAutoportanteDoshojas").setSofaFilter(GridColumnFilter.TYPE_LIST);
		
		metaData.getColumn("separacionEntramadoAutoportanteDoshojas").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] separacionEntramadoAutoportanteDoshojasStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_SI), this.getMessage("forms.acusticaruidosinterioresverticales.columns.separacionEntramadoAutoportanteDoshojas." + Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_SI, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_NO), this.getMessage("forms.acusticaruidosinterioresverticales.columns.separacionEntramadoAutoportanteDoshojas." + Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_NO, locale)},
		};

		metaData.getColumn("separacionEntramadoAutoportanteDoshojas").setSofaStoreValues(separacionEntramadoAutoportanteDoshojasStore);

		metaData.getColumn("separacionEntramadoAutoportanteDoshojas").setEditable(true);
		metaData.getColumn("separacionEntramadoAutoportanteDoshojas").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("separacionEntramadoAutoportanteDoshojasEspesor", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("separacionEntramadoAutoportanteDoshojasEspesor", this.getMessage("forms.acusticaruidosinterioresverticales.columns.separacionEntramadoAutoportanteDoshojasEspesor.header", locale)));
		metaData.getColumn("separacionEntramadoAutoportanteDoshojasEspesor").setTooltip(this.getMessage("forms.acusticaruidosinterioresverticales.columns.separacionEntramadoAutoportanteDoshojasEspesor.description", locale));
		metaData.getColumn("separacionEntramadoAutoportanteDoshojasEspesor").setGroupable(false);
		metaData.getColumn("separacionEntramadoAutoportanteDoshojasEspesor").setSortable(true);
		metaData.getColumn("separacionEntramadoAutoportanteDoshojasEspesor").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("separacionEntramadoAutoportanteDoshojasEspesor").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("separacionEntramadoAutoportanteDoshojasEspesor").setEditable(true);
		metaData.getColumn("separacionEntramadoAutoportanteDoshojasEspesor").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("separacionEntramadoAutoportanteUnahoja", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("separacionEntramadoAutoportanteUnahoja", this.getMessage("forms.acusticaruidosinterioresverticales.columns.separacionEntramadoAutoportanteUnahoja.header", locale)));
		metaData.getColumn("separacionEntramadoAutoportanteUnahoja").setTooltip(this.getMessage("forms.acusticaruidosinterioresverticales.columns.separacionEntramadoAutoportanteUnahoja.description", locale));
		metaData.getColumn("separacionEntramadoAutoportanteUnahoja").setGroupable(false);
		metaData.getColumn("separacionEntramadoAutoportanteUnahoja").setSortable(true);
		metaData.getColumn("separacionEntramadoAutoportanteUnahoja").setSofaFilter(GridColumnFilter.TYPE_LIST);
		
		metaData.getColumn("separacionEntramadoAutoportanteUnahoja").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] separacionEntramadoAutoportanteUnahojaStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_SI), this.getMessage("forms.acusticaruidosinterioresverticales.columns.separacionEntramadoAutoportanteUnahoja." + Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_SI, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_NO), this.getMessage("forms.acusticaruidosinterioresverticales.columns.separacionEntramadoAutoportanteUnahoja." + Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_NO, locale)},
		};

		metaData.getColumn("separacionEntramadoAutoportanteUnahoja").setSofaStoreValues(separacionEntramadoAutoportanteUnahojaStore);

		metaData.getColumn("separacionEntramadoAutoportanteUnahoja").setEditable(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("separacionEntramadoAutoportanteUnahojaEspesor", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("separacionEntramadoAutoportanteUnahojaEspesor", this.getMessage("forms.acusticaruidosinterioresverticales.columns.separacionEntramadoAutoportanteUnahojaEspesor.header", locale)));
		metaData.getColumn("separacionEntramadoAutoportanteUnahojaEspesor").setTooltip(this.getMessage("forms.acusticaruidosinterioresverticales.columns.separacionEntramadoAutoportanteUnahojaEspesor.description", locale));
		metaData.getColumn("separacionEntramadoAutoportanteUnahojaEspesor").setGroupable(false);
		metaData.getColumn("separacionEntramadoAutoportanteUnahojaEspesor").setSortable(true);
		metaData.getColumn("separacionEntramadoAutoportanteUnahojaEspesor").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("separacionEntramadoAutoportanteUnahojaEspesor").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("separacionEntramadoAutoportanteUnahojaEspesor").setEditable(true);
		metaData.getColumn("separacionEntramadoAutoportanteUnahojaEspesor").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("separacionEntramadoMadera", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("separacionEntramadoMadera", this.getMessage("forms.acusticaruidosinterioresverticales.columns.separacionEntramadoMadera.header", locale)));
		metaData.getColumn("separacionEntramadoMadera").setGroupable(false);
		metaData.getColumn("separacionEntramadoMadera").setSortable(true);
		metaData.getColumn("separacionEntramadoMadera").setSofaFilter(GridColumnFilter.TYPE_LIST);
		
		metaData.getColumn("separacionEntramadoMadera").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] separacionEntramadoMaderaStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_SI), this.getMessage("forms.acusticaruidosinterioresverticales.columns.separacionEntramadoMadera." + Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_SI, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_NO), this.getMessage("forms.acusticaruidosinterioresverticales.columns.separacionEntramadoMadera." + Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_NO, locale)},
		};

		metaData.getColumn("separacionEntramadoMadera").setSofaStoreValues(separacionEntramadoMaderaStore);

		metaData.getColumn("separacionEntramadoMadera").setEditable(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("separacionEntramadoMaderaEspesor", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("separacionEntramadoMaderaEspesor", this.getMessage("forms.acusticaruidosinterioresverticales.columns.separacionEntramadoMaderaEspesor.header", locale)));
		metaData.getColumn("separacionEntramadoMaderaEspesor").setTooltip(this.getMessage("forms.acusticaruidosinterioresverticales.columns.separacionEntramadoMaderaEspesor.description", locale));
		metaData.getColumn("separacionEntramadoMaderaEspesor").setGroupable(false);
		metaData.getColumn("separacionEntramadoMaderaEspesor").setSortable(true);
		metaData.getColumn("separacionEntramadoMaderaEspesor").setSofaFilter(GridColumnFilter.TYPE_NUMERIC);

		metaData.getColumn("separacionEntramadoMaderaEspesor").setEditable(true);
		metaData.getColumn("separacionEntramadoMaderaEspesor").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("separacionEntramadoMaderaRevestido", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("separacionEntramadoMaderaRevestido", this.getMessage("forms.acusticaruidosinterioresverticales.columns.separacionEntramadoMaderaRevestido.header", locale)));
		metaData.getColumn("separacionEntramadoMaderaRevestido").setTooltip(this.getMessage("forms.acusticaruidosinterioresverticales.columns.separacionEntramadoMaderaRevestido.description", locale));
		metaData.getColumn("separacionEntramadoMaderaRevestido").setGroupable(false);
		metaData.getColumn("separacionEntramadoMaderaRevestido").setSortable(true);
		metaData.getColumn("separacionEntramadoMaderaRevestido").setSofaFilter(GridColumnFilter.TYPE_LIST);
		
		metaData.getColumn("separacionEntramadoMaderaRevestido").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] separacionEntramadoMaderaRevestidoStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_SI), this.getMessage("forms.acusticaruidosinterioresverticales.columns.separacionEntramadoMaderaRevestido." + Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_SI, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_NO), this.getMessage("forms.acusticaruidosinterioresverticales.columns.separacionEntramadoMaderaRevestido." + Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_NO, locale)},
		};

		metaData.getColumn("separacionEntramadoMaderaRevestido").setSofaStoreValues(separacionEntramadoMaderaRevestidoStore);

		metaData.getColumn("separacionEntramadoMaderaRevestido").setEditable(true);
		metaData.getColumn("separacionEntramadoMaderaRevestido").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("separacionFabrica", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("separacionFabrica", this.getMessage("forms.acusticaruidosinterioresverticales.columns.separacionFabrica.header", locale)));
		metaData.getColumn("separacionFabrica").setGroupable(false);
		metaData.getColumn("separacionFabrica").setSortable(true);
		metaData.getColumn("separacionFabrica").setSofaFilter(GridColumnFilter.TYPE_LIST);
		
		metaData.getColumn("separacionFabrica").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] separacionFabricaStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_SI), this.getMessage("forms.acusticaruidosinterioresverticales.columns.separacionFabrica." + Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_SI, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_NO), this.getMessage("forms.acusticaruidosinterioresverticales.columns.separacionFabrica." + Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_NO, locale)},
		};

		metaData.getColumn("separacionFabrica").setSofaStoreValues(separacionFabricaStore);

		metaData.getColumn("separacionFabrica").setEditable(true);
		metaData.getColumn("separacionFabrica").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("separacionFabricaRevestido", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("separacionFabricaRevestido", this.getMessage("forms.acusticaruidosinterioresverticales.columns.separacionFabricaRevestido.header", locale)));
		metaData.getColumn("separacionFabricaRevestido").setGroupable(false);
		metaData.getColumn("separacionFabricaRevestido").setSortable(true);
		metaData.getColumn("separacionFabricaRevestido").setSofaFilter(GridColumnFilter.TYPE_LIST);
		
		metaData.getColumn("separacionFabricaRevestido").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] separacionFabricaRevestidoStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_NS), this.getMessage("forms.acusticaruidosinterioresverticales.columns.separacionFabricaRevestido." + Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_NS, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_SI), this.getMessage("forms.acusticaruidosinterioresverticales.columns.separacionFabricaRevestido." + Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_SI, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_NO), this.getMessage("forms.acusticaruidosinterioresverticales.columns.separacionFabricaRevestido." + Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_NO, locale)},
		};

		metaData.getColumn("separacionFabricaRevestido").setSofaStoreValues(separacionFabricaRevestidoStore);

		metaData.getColumn("separacionFabricaRevestido").setEditable(true);
		metaData.getColumn("separacionFabricaRevestido").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("separacionOtros", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("separacionOtros", this.getMessage("forms.acusticaruidosinterioresverticales.columns.separacionOtros.header", locale)));
		metaData.getColumn("separacionOtros").setGroupable(false);
		metaData.getColumn("separacionOtros").setSortable(true);
		metaData.getColumn("separacionOtros").setSofaFilter(GridColumnFilter.TYPE_LIST);
		
		metaData.getColumn("separacionOtros").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] separacionOtrosStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_SI), this.getMessage("forms.acusticaruidosinterioresverticales.columns.separacionOtros." + Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_SI, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_NO), this.getMessage("forms.acusticaruidosinterioresverticales.columns.separacionOtros." + Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_NO, locale)},
		};

		metaData.getColumn("separacionOtros").setSofaStoreValues(separacionOtrosStore);

		metaData.getColumn("separacionOtros").setEditable(true);
		metaData.getColumn("separacionOtros").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("separacionOtrosTexto", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("separacionOtrosTexto", this.getMessage("forms.acusticaruidosinterioresverticales.columns.separacionOtrosTexto.header", locale)));
		metaData.getColumn("separacionOtrosTexto").setGroupable(false);
		metaData.getColumn("separacionOtrosTexto").setSortable(true);
		metaData.getColumn("separacionOtrosTexto").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("separacionOtrosTexto").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("separacionOtrosTexto").setEditable(true);
		metaData.getColumn("separacionOtrosTexto").setHidden(true);
		
		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("tabiquesEntramadoAutoportanteMetalico", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("tabiquesEntramadoAutoportanteMetalico", this.getMessage("forms.acusticaruidosinterioresverticales.columns.tabiquesEntramadoAutoportanteMetalico.header", locale)));
		metaData.getColumn("tabiquesEntramadoAutoportanteMetalico").setTooltip(this.getMessage("forms.acusticaruidosinterioresverticales.columns.tabiquesEntramadoAutoportanteMetalico.description", locale));
		metaData.getColumn("tabiquesEntramadoAutoportanteMetalico").setGroupable(false);
		metaData.getColumn("tabiquesEntramadoAutoportanteMetalico").setSortable(true);
		metaData.getColumn("tabiquesEntramadoAutoportanteMetalico").setSofaFilter(GridColumnFilter.TYPE_LIST);
		
		metaData.getColumn("tabiquesEntramadoAutoportanteMetalico").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] tabiquesEntramadoAutoportanteMetalicoStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_SI), this.getMessage("forms.acusticaruidosinterioresverticales.columns.tabiquesEntramadoAutoportanteMetalico." + Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_SI, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_NO), this.getMessage("forms.acusticaruidosinterioresverticales.columns.tabiquesEntramadoAutoportanteMetalico." + Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_NO, locale)},
		};

		metaData.getColumn("tabiquesEntramadoAutoportanteMetalico").setSofaStoreValues(tabiquesEntramadoAutoportanteMetalicoStore);

		metaData.getColumn("tabiquesEntramadoAutoportanteMetalico").setEditable(true);
		metaData.getColumn("tabiquesEntramadoAutoportanteMetalico").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("tabiquesEntramadoAutoportanteMetalicoEspesor", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("tabiquesEntramadoAutoportanteMetalicoEspesor", this.getMessage("forms.acusticaruidosinterioresverticales.columns.tabiquesEntramadoAutoportanteMetalicoEspesor.header", locale)));
		metaData.getColumn("tabiquesEntramadoAutoportanteMetalicoEspesor").setTooltip(this.getMessage("forms.acusticaruidosinterioresverticales.columns.tabiquesEntramadoAutoportanteMetalicoEspesor.description", locale));
		metaData.getColumn("tabiquesEntramadoAutoportanteMetalicoEspesor").setGroupable(false);
		metaData.getColumn("tabiquesEntramadoAutoportanteMetalicoEspesor").setSortable(true);
		metaData.getColumn("tabiquesEntramadoAutoportanteMetalicoEspesor").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("tabiquesEntramadoAutoportanteMetalicoEspesor").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("tabiquesEntramadoAutoportanteMetalicoEspesor").setEditable(true);
		metaData.getColumn("tabiquesEntramadoAutoportanteMetalicoEspesor").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("tabiquesEntramadoMaderaRelleno", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("tabiquesEntramadoMaderaRelleno", this.getMessage("forms.acusticaruidosinterioresverticales.columns.tabiquesEntramadoMaderaRelleno.header", locale)));
		metaData.getColumn("tabiquesEntramadoMaderaRelleno").setTooltip(this.getMessage("forms.acusticaruidosinterioresverticales.columns.tabiquesEntramadoMaderaRelleno.description", locale));
		metaData.getColumn("tabiquesEntramadoMaderaRelleno").setGroupable(false);
		metaData.getColumn("tabiquesEntramadoMaderaRelleno").setSortable(true);
		metaData.getColumn("tabiquesEntramadoMaderaRelleno").setSofaFilter(GridColumnFilter.TYPE_LIST);
		
		metaData.getColumn("tabiquesEntramadoMaderaRelleno").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] tabiquesEntramadoMaderaRellenoStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_SI), this.getMessage("forms.acusticaruidosinterioresverticales.columns.tabiquesEntramadoMaderaRelleno." + Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_SI, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_NO), this.getMessage("forms.acusticaruidosinterioresverticales.columns.tabiquesEntramadoMaderaRelleno." + Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_NO, locale)},
		};

		metaData.getColumn("tabiquesEntramadoMaderaRelleno").setSofaStoreValues(tabiquesEntramadoMaderaRellenoStore);

		metaData.getColumn("tabiquesEntramadoMaderaRelleno").setEditable(true);
		metaData.getColumn("tabiquesEntramadoMaderaRelleno").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("tabiquesEntramadoMaderaRellenoEspesor", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("tabiquesEntramadoMaderaRellenoEspesor", this.getMessage("forms.acusticaruidosinterioresverticales.columns.tabiquesEntramadoMaderaRellenoEspesor.header", locale)));
		metaData.getColumn("tabiquesEntramadoMaderaRellenoEspesor").setTooltip(this.getMessage("forms.acusticaruidosinterioresverticales.columns.tabiquesEntramadoMaderaRellenoEspesor.description", locale));
		metaData.getColumn("tabiquesEntramadoMaderaRellenoEspesor").setGroupable(false);
		metaData.getColumn("tabiquesEntramadoMaderaRellenoEspesor").setSortable(true);
		metaData.getColumn("tabiquesEntramadoMaderaRellenoEspesor").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("tabiquesEntramadoMaderaRellenoEspesor").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("tabiquesEntramadoMaderaRellenoEspesor").setEditable(true);
		metaData.getColumn("tabiquesEntramadoMaderaRellenoEspesor").setHidden(true);
		
		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("tabiquesFabrica", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("tabiquesFabrica", this.getMessage("forms.acusticaruidosinterioresverticales.columns.tabiquesFabrica.header", locale)));
		metaData.getColumn("tabiquesFabrica").setGroupable(false);
		metaData.getColumn("tabiquesFabrica").setSortable(true);
		metaData.getColumn("tabiquesFabrica").setSofaFilter(GridColumnFilter.TYPE_LIST);
		
		metaData.getColumn("tabiquesFabrica").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] tabiquesFabricaStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_SI), this.getMessage("forms.acusticaruidosinterioresverticales.columns.tabiquesFabrica." + Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_SI, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_NO), this.getMessage("forms.acusticaruidosinterioresverticales.columns.tabiquesFabrica." + Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_NO, locale)},
		};

		metaData.getColumn("tabiquesFabrica").setSofaStoreValues(tabiquesFabricaStore);

		metaData.getColumn("tabiquesFabrica").setEditable(true);
		metaData.getColumn("tabiquesFabrica").setHidden(true);
		
		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("zonaComunHallPuerta", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("zonaComunHallPuerta", this.getMessage("forms.acusticaruidosinterioresverticales.columns.zonaComunHallPuerta.header", locale)));
		metaData.getColumn("zonaComunHallPuerta").setGroupable(false);
		metaData.getColumn("zonaComunHallPuerta").setSortable(true);
		metaData.getColumn("zonaComunHallPuerta").setSofaFilter(GridColumnFilter.TYPE_LIST);
		
		metaData.getColumn("zonaComunHallPuerta").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] zonaComunHallPuertaStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_NS), this.getMessage("forms.acusticaruidosinterioresverticales.columns.zonaComunHallPuerta." + Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_NS, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_SI), this.getMessage("forms.acusticaruidosinterioresverticales.columns.zonaComunHallPuerta." + Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_SI, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_NO), this.getMessage("forms.acusticaruidosinterioresverticales.columns.zonaComunHallPuerta." + Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_NO, locale)},
		};

		metaData.getColumn("zonaComunHallPuerta").setSofaStoreValues(zonaComunHallPuertaStore);

		metaData.getColumn("zonaComunHallPuerta").setEditable(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("zonaComunPuertasAcusticamenteFavorables", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("zonaComunPuertasAcusticamenteFavorables", this.getMessage("forms.acusticaruidosinterioresverticales.columns.zonaComunPuertasAcusticamenteFavorables.header", locale)));
		metaData.getColumn("zonaComunPuertasAcusticamenteFavorables").setTooltip(this.getMessage("forms.acusticaruidosinterioresverticales.columns.zonaComunPuertasAcusticamenteFavorables.description", locale));
		metaData.getColumn("zonaComunPuertasAcusticamenteFavorables").setGroupable(false);
		metaData.getColumn("zonaComunPuertasAcusticamenteFavorables").setSortable(true);
		metaData.getColumn("zonaComunPuertasAcusticamenteFavorables").setSofaFilter(GridColumnFilter.TYPE_LIST);
		
		metaData.getColumn("zonaComunPuertasAcusticamenteFavorables").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] zonaComunPuertasAcusticamenteFavorablesStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_NS), this.getMessage("forms.acusticaruidosinterioresverticales.columns.zonaComunPuertasAcusticamenteFavorables." + Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_NS, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_SI), this.getMessage("forms.acusticaruidosinterioresverticales.columns.zonaComunPuertasAcusticamenteFavorables." + Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_SI, locale)},
				{ String.valueOf(Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_NO), this.getMessage("forms.acusticaruidosinterioresverticales.columns.zonaComunPuertasAcusticamenteFavorables." + Keys.ACUSTICA_RUIDO_INTERIORES_VERTICALES_NO, locale)},
		};

		metaData.getColumn("zonaComunPuertasAcusticamenteFavorables").setSofaStoreValues(zonaComunPuertasAcusticamenteFavorablesStore);

		metaData.getColumn("zonaComunPuertasAcusticamenteFavorables").setEditable(true);
		metaData.getColumn("zonaComunPuertasAcusticamenteFavorables").setHidden(true);
		
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

		datosExportacion.add("claveInforme", this.getMessage("forms.acusticaruidosinterioresverticales.columns.claveInforme.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("inspeccion", this.getMessage("forms.acusticaruidosinterioresverticales.columns.inspeccion.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("ruiiIntVertSepTipoTex", this.getMessage("forms.acusticaruidosinterioresverticales.columns.ruiiIntVertSepTipoTex.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("ruiIntVertTabTipoTex", this.getMessage("forms.acusticaruidosinterioresverticales.columns.ruiIntVertTabTipoTex.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("caracteristicasHuecosAdosados", this.getMessage("forms.acusticaruidosinterioresverticales.columns.caracteristicasHuecosAdosados.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("caracteristicasHuecosAdosadosRevestidos", this.getMessage("forms.acusticaruidosinterioresverticales.columns.caracteristicasHuecosAdosadosRevestidos.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("caracteristicasHuecosAdosadosRuidoMolesto", this.getMessage("forms.acusticaruidosinterioresverticales.columns.caracteristicasHuecosAdosadosRuidoMolesto.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("caracteristicasInstalacionesAtraviesanRecintos", this.getMessage("forms.acusticaruidosinterioresverticales.columns.caracteristicasInstalacionesAtraviesanRecintos.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("caracteristicasInstalacionesConectanRecintos", this.getMessage("forms.acusticaruidosinterioresverticales.columns.caracteristicasInstalacionesConectanRecintos.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("caracteristicasPilaresConectanRecintos", this.getMessage("forms.acusticaruidosinterioresverticales.columns.caracteristicasPilaresConectanRecintos.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("caracteristicasPilaresConectanRecintosRevestidos", this.getMessage("forms.acusticaruidosinterioresverticales.columns.caracteristicasPilaresConectanRecintosRevestidos.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("caracteristicasTuberiasAncladas", this.getMessage("forms.acusticaruidosinterioresverticales.columns.caracteristicasTuberiasAncladas.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("deficienciasObservaciones", this.getMessage("forms.acusticaruidosinterioresverticales.columns.deficienciasObservaciones.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("estadoSeparacionBueno", this.getMessage("forms.acusticaruidosinterioresverticales.columns.estadoSeparacionBueno.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("observaciones", this.getMessage("forms.acusticaruidosinterioresverticales.columns.observaciones.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("separacionEntramadoAutoportante", this.getMessage("forms.acusticaruidosinterioresverticales.columns.separacionEntramadoAutoportante.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("separacionEntramadoAutoportanteAbsorbente", this.getMessage("forms.acusticaruidosinterioresverticales.columns.separacionEntramadoAutoportanteAbsorbente.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("separacionEntramadoAutoportanteDoshojas", this.getMessage("forms.acusticaruidosinterioresverticales.columns.separacionEntramadoAutoportanteDoshojas.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("separacionEntramadoAutoportanteDoshojasEspesor", this.getMessage("forms.acusticaruidosinterioresverticales.columns.separacionEntramadoAutoportanteDoshojasEspesor.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("separacionEntramadoAutoportanteUnahoja", this.getMessage("forms.acusticaruidosinterioresverticales.columns.separacionEntramadoAutoportanteUnahoja.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("separacionEntramadoAutoportanteUnahojaEspesor", this.getMessage("forms.acusticaruidosinterioresverticales.columns.separacionEntramadoAutoportanteUnahojaEspesor.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("separacionEntramadoMadera", this.getMessage("forms.acusticaruidosinterioresverticales.columns.separacionEntramadoMadera.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("separacionEntramadoMaderaEspesor", this.getMessage("forms.acusticaruidosinterioresverticales.columns.separacionEntramadoMaderaEspesor.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("separacionEntramadoMaderaRevestido", this.getMessage("forms.acusticaruidosinterioresverticales.columns.separacionEntramadoMaderaRevestido.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("separacionFabrica", this.getMessage("forms.acusticaruidosinterioresverticales.columns.separacionFabrica.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("separacionFabricaRevestido", this.getMessage("forms.acusticaruidosinterioresverticales.columns.separacionFabricaRevestido.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("separacionOtros", this.getMessage("forms.acusticaruidosinterioresverticales.columns.separacionOtros.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("separacionOtrosTexto", this.getMessage("forms.acusticaruidosinterioresverticales.columns.separacionOtrosTexto.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("tabiquesEntramadoAutoportanteMetalico", this.getMessage("forms.acusticaruidosinterioresverticales.columns.tabiquesEntramadoAutoportanteMetalico.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("tabiquesEntramadoAutoportanteMetalicoEspesor", this.getMessage("forms.acusticaruidosinterioresverticales.columns.tabiquesEntramadoAutoportanteMetalicoEspesor.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("tabiquesEntramadoMaderaRelleno", this.getMessage("forms.acusticaruidosinterioresverticales.columns.tabiquesEntramadoMaderaRelleno.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("tabiquesEntramadoMaderaRellenoEspesor", this.getMessage("forms.acusticaruidosinterioresverticales.columns.tabiquesEntramadoMaderaRellenoEspesor.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("tabiquesFabrica", this.getMessage("forms.acusticaruidosinterioresverticales.columns.tabiquesFabrica.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("zonaComunHallPuerta", this.getMessage("forms.acusticaruidosinterioresverticales.columns.zonaComunHallPuerta.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("zonaComunPuertasAcusticamenteFavorables", this.getMessage("forms.acusticaruidosinterioresverticales.columns.zonaComunPuertasAcusticamenteFavorables.header", locale), TipoCampoExportacion.STRING);

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
		AcusticaRuidosInterioresVerticalesListadoVO instance = (AcusticaRuidosInterioresVerticalesListadoVO) rawInstance;

		List<String> excelRow = new ArrayList<String>();

		excelRow.add(FormData2Java.toString(instance.getClaveInforme()));
		excelRow.add(FormData2Java.toString(instance.getInspeccionLabel()));
		excelRow.add(instance.getRuiiIntVertSepTipoTex());
		excelRow.add(instance.getRuiIntVertTabTipoTex());
		//excelRow.add(FormData2Java.toString(instance.getCaracteristicasHuecosAdosados()));
		if (instance.getCaracteristicasHuecosAdosados()!=null){
			excelRow.add( this.getMessage("forms.acusticaruidosinterioresverticales.columns.caracteristicasHuecosAdosados." + instance.getCaracteristicasHuecosAdosados(), locale) );
		}else{
			excelRow.add("null");
		}
		
		//excelRow.add(FormData2Java.toString(instance.getCaracteristicasHuecosAdosadosRevestidos()));
		if (instance.getCaracteristicasHuecosAdosadosRevestidos()!=null){
			excelRow.add( this.getMessage("forms.acusticaruidosinterioresverticales.columns.caracteristicasHuecosAdosadosRevestidos." + instance.getCaracteristicasHuecosAdosadosRevestidos(), locale) );
		}else{
			excelRow.add("null");
		}
		
		//excelRow.add(FormData2Java.toString(instance.getCaracteristicasHuecosAdosadosRuidoMolesto()));
		if (instance.getCaracteristicasHuecosAdosadosRuidoMolesto()!=null){
			excelRow.add( this.getMessage("forms.acusticaruidosinterioresverticales.columns.caracteristicasHuecosAdosadosRuidoMolesto." + instance.getCaracteristicasHuecosAdosadosRuidoMolesto(), locale) );
		}else{
			excelRow.add("null");
		}
		
		//excelRow.add(FormData2Java.toString(instance.getCaracteristicasInstalacionesAtraviesanRecintos()));
		if (instance.getCaracteristicasInstalacionesAtraviesanRecintos()!=null){
			excelRow.add( this.getMessage("forms.acusticaruidosinterioresverticales.columns.caracteristicasInstalacionesAtraviesanRecintos." + instance.getCaracteristicasInstalacionesAtraviesanRecintos(), locale) );
		}else{
			excelRow.add("null");
		}
		
		//excelRow.add(FormData2Java.toString(instance.getCaracteristicasInstalacionesConectanRecintos()));
		if (instance.getCaracteristicasInstalacionesConectanRecintos()!=null){
			excelRow.add( this.getMessage("forms.acusticaruidosinterioresverticales.columns.caracteristicasInstalacionesConectanRecintos." + instance.getCaracteristicasInstalacionesConectanRecintos(), locale) );
		}else{
			excelRow.add("null");
		}
		
		//excelRow.add(FormData2Java.toString(instance.getCaracteristicasPilaresConectanRecintos()));
		if (instance.getCaracteristicasPilaresConectanRecintos()!=null){
			excelRow.add( this.getMessage("forms.acusticaruidosinterioresverticales.columns.caracteristicasPilaresConectanRecintos." + instance.getCaracteristicasPilaresConectanRecintos(), locale) );
		}else{
			excelRow.add("null");
		}
		
		//excelRow.add(FormData2Java.toString(instance.getCaracteristicasPilaresConectanRecintosRevestidos()));
		if (instance.getCaracteristicasPilaresConectanRecintosRevestidos()!=null){
			excelRow.add( this.getMessage("forms.acusticaruidosinterioresverticales.columns.caracteristicasPilaresConectanRecintosRevestidos." + instance.getCaracteristicasPilaresConectanRecintosRevestidos(), locale) );
		}else{
			excelRow.add("null");
		}
		
		//excelRow.add(FormData2Java.toString(instance.getCaracteristicasTuberiasAncladas()));
		if (instance.getCaracteristicasTuberiasAncladas()!=null){
			excelRow.add( this.getMessage("forms.acusticaruidosinterioresverticales.columns.caracteristicasTuberiasAncladas." + instance.getCaracteristicasTuberiasAncladas(), locale) );
		}else{
			excelRow.add("null");
		}
		
		excelRow.add(instance.getDeficienciasObservaciones());
		//excelRow.add(FormData2Java.toString(instance.getEstadoSeparacionBueno()));
		if (instance.getEstadoSeparacionBueno()!=null){
			excelRow.add( this.getMessage("forms.acusticaruidosinterioresverticales.columns.estadoSeparacionBueno." + instance.getEstadoSeparacionBueno(), locale) );
		}else{
			excelRow.add("null");
		}
		
		excelRow.add(instance.getObservaciones());
		//excelRow.add(FormData2Java.toString(instance.getSeparacionEntramadoAutoportante()));
		if (instance.getSeparacionEntramadoAutoportante()!=null){
			excelRow.add( this.getMessage("forms.acusticaruidosinterioresverticales.columns.separacionEntramadoAutoportante." + instance.getSeparacionEntramadoAutoportante(), locale) );
		}else{
			excelRow.add("null");
		}
		
		//excelRow.add(FormData2Java.toString(instance.getSeparacionEntramadoAutoportanteAbsorbente()));
		if (instance.getSeparacionEntramadoAutoportanteAbsorbente()!=null){
			excelRow.add( this.getMessage("forms.acusticaruidosinterioresverticales.columns.separacionEntramadoAutoportanteAbsorbente." + instance.getSeparacionEntramadoAutoportanteAbsorbente(), locale) );
		}else{
			excelRow.add("null");
		}
		
		//excelRow.add(FormData2Java.toString(instance.getSeparacionEntramadoAutoportanteDoshojas()));
		if (instance.getSeparacionEntramadoAutoportanteDoshojas()!=null){
			excelRow.add( this.getMessage("forms.acusticaruidosinterioresverticales.columns.separacionEntramadoAutoportanteDoshojas." + instance.getSeparacionEntramadoAutoportanteDoshojas(), locale) );
		}else{
			excelRow.add("null");
		}
		
		excelRow.add(instance.getSeparacionEntramadoAutoportanteDoshojasEspesor());
		//excelRow.add(FormData2Java.toString(instance.getSeparacionEntramadoAutoportanteUnahoja()));
		if (instance.getSeparacionEntramadoAutoportanteUnahoja()!=null){
			excelRow.add( this.getMessage("forms.acusticaruidosinterioresverticales.columns.separacionEntramadoAutoportanteUnahoja." + instance.getSeparacionEntramadoAutoportanteUnahoja(), locale) );
		}else{
			excelRow.add("null");
		}
		
		excelRow.add(instance.getSeparacionEntramadoAutoportanteUnahojaEspesor());
		//excelRow.add(FormData2Java.toString(instance.getSeparacionEntramadoMadera()));
		if (instance.getSeparacionEntramadoMadera()!=null){
			excelRow.add( this.getMessage("forms.acusticaruidosinterioresverticales.columns.separacionEntramadoMadera." + instance.getSeparacionEntramadoMadera(), locale) );
		}else{
			excelRow.add("null");
		}
		
		excelRow.add(FormData2Java.toString(instance.getSeparacionEntramadoMaderaEspesor()));
		//excelRow.add(FormData2Java.toString(instance.getSeparacionEntramadoMaderaRevestido()));
		if (instance.getSeparacionEntramadoMaderaRevestido()!=null){
			excelRow.add( this.getMessage("forms.acusticaruidosinterioresverticales.columns.separacionEntramadoMaderaRevestido." + instance.getSeparacionEntramadoMaderaRevestido(), locale) );
		}else{
			excelRow.add("null");
		}
		
		//excelRow.add(FormData2Java.toString(instance.getSeparacionFabrica()));
		if (instance.getSeparacionFabrica()!=null){
			excelRow.add( this.getMessage("forms.acusticaruidosinterioresverticales.columns.separacionFabrica." + instance.getSeparacionFabrica(), locale) );
		}else{
			excelRow.add("null");
		}
		
		//excelRow.add(FormData2Java.toString(instance.getSeparacionFabricaRevestido()));
		if (instance.getSeparacionFabricaRevestido()!=null){
			excelRow.add( this.getMessage("forms.acusticaruidosinterioresverticales.columns.separacionFabricaRevestido." + instance.getSeparacionFabricaRevestido(), locale) );
		}else{
			excelRow.add("null");
		}
		
		//excelRow.add(FormData2Java.toString(instance.getSeparacionOtros()));
		if (instance.getSeparacionOtros()!=null){
			excelRow.add( this.getMessage("forms.acusticaruidosinterioresverticales.columns.separacionOtros." + instance.getSeparacionOtros(), locale) );
		}else{
			excelRow.add("null");
		}
		
		excelRow.add(instance.getSeparacionOtrosTexto());
		//excelRow.add(FormData2Java.toString(instance.getTabiquesEntramadoAutoportanteMetalico()));
		if (instance.getTabiquesEntramadoAutoportanteMetalico()!=null){
			excelRow.add( this.getMessage("forms.acusticaruidosinterioresverticales.columns.tabiquesEntramadoAutoportanteMetalico." + instance.getTabiquesEntramadoAutoportanteMetalico(), locale) );
		}else{
			excelRow.add("null");
		}
		
		excelRow.add(instance.getTabiquesEntramadoAutoportanteMetalicoEspesor());
		//excelRow.add(FormData2Java.toString(instance.getTabiquesEntramadoMaderaRelleno()));
		if (instance.getTabiquesEntramadoMaderaRelleno()!=null){
			excelRow.add( this.getMessage("forms.acusticaruidosinterioresverticales.columns.tabiquesEntramadoMaderaRelleno." + instance.getTabiquesEntramadoMaderaRelleno(), locale) );
		}else{
			excelRow.add("null");
		}
		
		excelRow.add(instance.getTabiquesEntramadoMaderaRellenoEspesor());
		//excelRow.add(FormData2Java.toString(instance.getTabiquesFabrica()));
		if (instance.getTabiquesFabrica()!=null){
			excelRow.add( this.getMessage("forms.acusticaruidosinterioresverticales.columns.tabiquesFabrica." + instance.getTabiquesFabrica(), locale) );
		}else{
			excelRow.add("null");
		}
		
		//excelRow.add(FormData2Java.toString(instance.getZonaComunHallPuerta()));
		if (instance.getZonaComunHallPuerta()!=null){
			excelRow.add( this.getMessage("forms.acusticaruidosinterioresverticales.columns.zonaComunHallPuerta." + instance.getZonaComunHallPuerta(), locale) );
		}else{
			excelRow.add("null");
		}
		
		//excelRow.add(FormData2Java.toString(instance.getZonaComunPuertasAcusticamenteFavorables()));
		if (instance.getZonaComunPuertasAcusticamenteFavorables()!=null){
			excelRow.add( this.getMessage("forms.acusticaruidosinterioresverticales.columns.zonaComunPuertasAcusticamenteFavorables." + instance.getZonaComunPuertasAcusticamenteFavorables(), locale) );
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
	 * Rellena una instancia de AcusticaRuidosInterioresVerticalesFormVO con el
	 * contenido de un formulario recibido en formato Map<String, ?>
	 */
	protected void setFormData(AcusticaRuidosInterioresVerticalesFormVO record, Map<String, ?> formData) throws GenericBusinessException {
		String formDataStr = null;
		if (!StringUtils.isEmpty(formData, "inspeccionId")) {
			formDataStr = (String) formData.get("inspeccionId");
			record.setInspeccionId(FormData2Java.toInteger(formDataStr));

		}
		if (formData.containsKey("ruiiIntVertSepTipoTex")) {
			formDataStr = (String) formData.get("ruiiIntVertSepTipoTex");
			record.setRuiiIntVertSepTipoTex(formDataStr);
		}
		if (formData.containsKey("ruiIntVertTabTipoTex")) {
			formDataStr = (String) formData.get("ruiIntVertTabTipoTex");
			record.setRuiIntVertTabTipoTex(formDataStr);
		}
		if (formData.containsKey("caracteristicasHuecosAdosados")) {
			formDataStr = (String) formData.get("caracteristicasHuecosAdosados");
			record.setCaracteristicasHuecosAdosados(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("caracteristicasHuecosAdosadosRevestidos")) {
			formDataStr = (String) formData.get("caracteristicasHuecosAdosadosRevestidos");
			record.setCaracteristicasHuecosAdosadosRevestidos(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("caracteristicasHuecosAdosadosRuidoMolesto")) {
			formDataStr = (String) formData.get("caracteristicasHuecosAdosadosRuidoMolesto");
			record.setCaracteristicasHuecosAdosadosRuidoMolesto(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("caracteristicasInstalacionesAtraviesanRecintos")) {
			formDataStr = (String) formData.get("caracteristicasInstalacionesAtraviesanRecintos");
			record.setCaracteristicasInstalacionesAtraviesanRecintos(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("caracteristicasInstalacionesConectanRecintos")) {
			formDataStr = (String) formData.get("caracteristicasInstalacionesConectanRecintos");
			record.setCaracteristicasInstalacionesConectanRecintos(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("caracteristicasPilaresConectanRecintos")) {
			formDataStr = (String) formData.get("caracteristicasPilaresConectanRecintos");
			record.setCaracteristicasPilaresConectanRecintos(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("caracteristicasPilaresConectanRecintosRevestidos")) {
			formDataStr = (String) formData.get("caracteristicasPilaresConectanRecintosRevestidos");
			record.setCaracteristicasPilaresConectanRecintosRevestidos(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("caracteristicasTuberiasAncladas")) {
			formDataStr = (String) formData.get("caracteristicasTuberiasAncladas");
			record.setCaracteristicasTuberiasAncladas(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("deficienciasObservaciones")) {
			formDataStr = (String) formData.get("deficienciasObservaciones");
			record.setDeficienciasObservaciones(formDataStr);
		}
		if (formData.containsKey("estadoSeparacionBueno")) {
			formDataStr = (String) formData.get("estadoSeparacionBueno");
			record.setEstadoSeparacionBueno(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("observaciones")) {
			formDataStr = (String) formData.get("observaciones");
			record.setObservaciones(formDataStr);
		}
		if (formData.containsKey("separacionEntramadoAutoportante")) {
			formDataStr = (String) formData.get("separacionEntramadoAutoportante");
			record.setSeparacionEntramadoAutoportante(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("separacionEntramadoAutoportanteAbsorbente")) {
			formDataStr = (String) formData.get("separacionEntramadoAutoportanteAbsorbente");
			record.setSeparacionEntramadoAutoportanteAbsorbente(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("separacionEntramadoAutoportanteDoshojas")) {
			formDataStr = (String) formData.get("separacionEntramadoAutoportanteDoshojas");
			record.setSeparacionEntramadoAutoportanteDoshojas(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("separacionEntramadoAutoportanteDoshojasEspesor")) {
			formDataStr = (String) formData.get("separacionEntramadoAutoportanteDoshojasEspesor");
			record.setSeparacionEntramadoAutoportanteDoshojasEspesor(formDataStr);
		}
		if (formData.containsKey("separacionEntramadoAutoportanteUnahoja")) {
			formDataStr = (String) formData.get("separacionEntramadoAutoportanteUnahoja");
			record.setSeparacionEntramadoAutoportanteUnahoja(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("separacionEntramadoAutoportanteUnahojaEspesor")) {
			formDataStr = (String) formData.get("separacionEntramadoAutoportanteUnahojaEspesor");
			record.setSeparacionEntramadoAutoportanteUnahojaEspesor(formDataStr);
		}
		if (formData.containsKey("separacionEntramadoMadera")) {
			formDataStr = (String) formData.get("separacionEntramadoMadera");
			record.setSeparacionEntramadoMadera(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("separacionEntramadoMaderaEspesor")) {
			formDataStr = (String) formData.get("separacionEntramadoMaderaEspesor");
			record.setSeparacionEntramadoMaderaEspesor(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("separacionEntramadoMaderaRevestido")) {
			formDataStr = (String) formData.get("separacionEntramadoMaderaRevestido");
			record.setSeparacionEntramadoMaderaRevestido(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("separacionFabrica")) {
			formDataStr = (String) formData.get("separacionFabrica");
			record.setSeparacionFabrica(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("separacionFabricaRevestido")) {
			formDataStr = (String) formData.get("separacionFabricaRevestido");
			record.setSeparacionFabricaRevestido(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("separacionOtros")) {
			formDataStr = (String) formData.get("separacionOtros");
			record.setSeparacionOtros(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("separacionOtrosTexto")) {
			formDataStr = (String) formData.get("separacionOtrosTexto");
			record.setSeparacionOtrosTexto(formDataStr);
		}
		if (formData.containsKey("tabiquesEntramadoAutoportanteMetalico")) {
			formDataStr = (String) formData.get("tabiquesEntramadoAutoportanteMetalico");
			record.setTabiquesEntramadoAutoportanteMetalico(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("tabiquesEntramadoAutoportanteMetalicoEspesor")) {
			formDataStr = (String) formData.get("tabiquesEntramadoAutoportanteMetalicoEspesor");
			record.setTabiquesEntramadoAutoportanteMetalicoEspesor(formDataStr);
		}
		if (formData.containsKey("tabiquesEntramadoMaderaRelleno")) {
			formDataStr = (String) formData.get("tabiquesEntramadoMaderaRelleno");
			record.setTabiquesEntramadoMaderaRelleno(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("tabiquesEntramadoMaderaRellenoEspesor")) {
			formDataStr = (String) formData.get("tabiquesEntramadoMaderaRellenoEspesor");
			record.setTabiquesEntramadoMaderaRellenoEspesor(formDataStr);
		}
		if (formData.containsKey("tabiquesFabrica")) {
			formDataStr = (String) formData.get("tabiquesFabrica");
			record.setTabiquesFabrica(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("zonaComunHallPuerta")) {
			formDataStr = (String) formData.get("zonaComunHallPuerta");
			record.setZonaComunHallPuerta(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("zonaComunPuertasAcusticamenteFavorables")) {
			formDataStr = (String) formData.get("zonaComunPuertasAcusticamenteFavorables");
			record.setZonaComunPuertasAcusticamenteFavorables(FormData2Java.toInteger(formDataStr));
		}
	}

}
