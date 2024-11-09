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
import es.caib.avaedi.logic.bo.AcusticaRuidosExterioresBO;
import es.caib.avaedi.logic.bo.InspeccionBO;
import es.caib.avaedi.logic.util.Keys;
import es.caib.avaedi.logic.vo.AcusticaRuidosExterioresFormVO;
import es.caib.avaedi.logic.vo.AcusticaRuidosExterioresListadoVO;
import es.caib.avaedi.logic.vo.AcusticasListadoVO;

/**
 * Servicio para tratar el formulario: AcusticaRuidosExteriores
 * 
 * @author agarcia@at4.net
 * 
 */
@Service("acusticaruidosexteriores")
public class AcusticaRuidosExterioresService extends InspeccionBaseService<AcusticaRuidosExterioresBO, AcusticaRuidosExterioresListadoVO, AcusticaRuidosExterioresFormVO> {

	/**
	 * The logger object.
	 */
	private static Logger log = LogService.getLogger(AcusticaRuidosExterioresService.class);

	/**
	 * Bean para acceder a los métodos de negocio: AcusticaRuidosExteriores
	 */
	@Autowired
	@Qualifier("AcusticaRuidosExterioresBean")
	protected AcusticaRuidosExterioresBO mainBO;

	/**
	 * Bean para acceder a los métodos de negocio: AcusticaRuidosExteriores
	 * 
	 * @param bean
	 *            the bean to set
	 */
	protected AcusticaRuidosExterioresBO getMainBO() {
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
			formItem.setText(this.getMessage("forms.acusticaruidosexteriores.title", locale));
		}

		GridMetaData metaData = this.getBaseMetaData(formItem, locale);

		//Nombre de la clase js de formulario
		metaData.setFormClassName("AcusticaRuidosExterioresForm");

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
		 * ("forms.acusticaruidosexteriores.columns.claveInforme.header",
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
		 * ("forms.acusticaruidosexteriores.columns.inspeccion.header",
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
		metaData.addRecordField(new GridRecordFieldMetaData("aireadoresAsilamientoAcustico", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("aireadoresAsilamientoAcustico", this.getMessage("forms.acusticaruidosexteriores.columns.aireadoresAsilamientoAcustico.header", locale)));
		metaData.getColumn("aireadoresAsilamientoAcustico").setTooltip(this.getMessage("forms.acusticaruidosexteriores.columns.aireadoresAsilamientoAcustico.description", locale));
		metaData.getColumn("aireadoresAsilamientoAcustico").setGroupable(false);
		metaData.getColumn("aireadoresAsilamientoAcustico").setSortable(true);
		metaData.getColumn("aireadoresAsilamientoAcustico").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("aireadoresAsilamientoAcustico").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] aireadoresAsilamientoAcusticoStore = new String[][] { { String.valueOf(Keys.ACUSTICA_RUIDO_EXTERIORES_NS), this.getMessage("forms.acusticaruidosexteriores.columns.aireadoresAsilamientoAcustico." + Keys.ACUSTICA_RUIDO_EXTERIORES_NS, locale) }, { String.valueOf(Keys.ACUSTICA_RUIDO_EXTERIORES_SI), this.getMessage("forms.acusticaruidosexteriores.columns.aireadoresAsilamientoAcustico." + Keys.ACUSTICA_RUIDO_EXTERIORES_SI, locale) }, { String.valueOf(Keys.ACUSTICA_RUIDO_EXTERIORES_NO), this.getMessage("forms.acusticaruidosexteriores.columns.aireadoresAsilamientoAcustico." + Keys.ACUSTICA_RUIDO_EXTERIORES_NO, locale) }, };

		metaData.getColumn("aireadoresAsilamientoAcustico").setSofaStoreValues(aireadoresAsilamientoAcusticoStore);

		metaData.getColumn("aireadoresAsilamientoAcustico").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("aireadoresAsilamientoAcustico").setEditable(true);
		metaData.getColumn("aireadoresAsilamientoAcustico").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("aireadoresTiene", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("aireadoresTiene", this.getMessage("forms.acusticaruidosexteriores.columns.aireadoresTiene.header", locale)));
		metaData.getColumn("aireadoresTiene").setGroupable(false);
		metaData.getColumn("aireadoresTiene").setSortable(true);
		metaData.getColumn("aireadoresTiene").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("aireadoresTiene").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] aireadoresTieneStore = new String[][] { { String.valueOf(Keys.ACUSTICA_RUIDO_EXTERIORES_NS), this.getMessage("forms.acusticaruidosexteriores.columns.aireadoresTiene." + Keys.ACUSTICA_RUIDO_EXTERIORES_NS, locale) }, { String.valueOf(Keys.ACUSTICA_RUIDO_EXTERIORES_SI), this.getMessage("forms.acusticaruidosexteriores.columns.aireadoresTiene." + Keys.ACUSTICA_RUIDO_EXTERIORES_SI, locale) }, { String.valueOf(Keys.ACUSTICA_RUIDO_EXTERIORES_NO), this.getMessage("forms.acusticaruidosexteriores.columns.aireadoresTiene." + Keys.ACUSTICA_RUIDO_EXTERIORES_NO, locale) }, };

		metaData.getColumn("aireadoresTiene").setSofaStoreValues(aireadoresTieneStore);

		metaData.getColumn("aireadoresTiene").setEditable(true);
		metaData.getColumn("aireadoresTiene").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("capialzadosAislamientoAcustico", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("capialzadosAislamientoAcustico", this.getMessage("forms.acusticaruidosexteriores.columns.capialzadosAislamientoAcustico.header", locale)));
		metaData.getColumn("capialzadosAislamientoAcustico").setTooltip(this.getMessage("forms.acusticaruidosexteriores.columns.capialzadosAislamientoAcustico.description", locale));
		metaData.getColumn("capialzadosAislamientoAcustico").setGroupable(false);
		metaData.getColumn("capialzadosAislamientoAcustico").setSortable(true);
		metaData.getColumn("capialzadosAislamientoAcustico").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("capialzadosAislamientoAcustico").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] capialzadosAislamientoAcusticoStore = new String[][] { { String.valueOf(Keys.ACUSTICA_RUIDO_EXTERIORES_NS), this.getMessage("forms.acusticaruidosexteriores.columns.capialzadosAislamientoAcustico." + Keys.ACUSTICA_RUIDO_EXTERIORES_NS, locale) }, { String.valueOf(Keys.ACUSTICA_RUIDO_EXTERIORES_SI), this.getMessage("forms.acusticaruidosexteriores.columns.capialzadosAislamientoAcustico." + Keys.ACUSTICA_RUIDO_EXTERIORES_SI, locale) }, { String.valueOf(Keys.ACUSTICA_RUIDO_EXTERIORES_NO), this.getMessage("forms.acusticaruidosexteriores.columns.capialzadosAislamientoAcustico." + Keys.ACUSTICA_RUIDO_EXTERIORES_NO, locale) }, };

		metaData.getColumn("capialzadosAislamientoAcustico").setSofaStoreValues(capialzadosAislamientoAcusticoStore);

		metaData.getColumn("capialzadosAislamientoAcustico").setEditable(true);
		metaData.getColumn("capialzadosAislamientoAcustico").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("capialzadosNoPrefabricados", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("capialzadosNoPrefabricados", this.getMessage("forms.acusticaruidosexteriores.columns.capialzadosNoPrefabricados.header", locale)));
		metaData.getColumn("capialzadosNoPrefabricados").setGroupable(false);
		metaData.getColumn("capialzadosNoPrefabricados").setSortable(true);
		metaData.getColumn("capialzadosNoPrefabricados").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("capialzadosNoPrefabricados").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] capialzadosNoPrefabricadosStore = new String[][] { { String.valueOf(Keys.ACUSTICA_RUIDO_EXTERIORES_NS), this.getMessage("forms.acusticaruidosexteriores.columns.capialzadosNoPrefabricados." + Keys.ACUSTICA_RUIDO_EXTERIORES_NS, locale) }, { String.valueOf(Keys.ACUSTICA_RUIDO_EXTERIORES_SI), this.getMessage("forms.acusticaruidosexteriores.columns.capialzadosNoPrefabricados." + Keys.ACUSTICA_RUIDO_EXTERIORES_SI, locale) }, { String.valueOf(Keys.ACUSTICA_RUIDO_EXTERIORES_NO), this.getMessage("forms.acusticaruidosexteriores.columns.capialzadosNoPrefabricados." + Keys.ACUSTICA_RUIDO_EXTERIORES_NO, locale) }, };

		metaData.getColumn("capialzadosNoPrefabricados").setSofaStoreValues(capialzadosNoPrefabricadosStore);

		metaData.getColumn("capialzadosNoPrefabricados").setEditable(true);
		metaData.getColumn("capialzadosNoPrefabricados").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("capialzadosTiene", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("capialzadosTiene", this.getMessage("forms.acusticaruidosexteriores.columns.capialzadosTiene.header", locale)));
		metaData.getColumn("capialzadosTiene").setGroupable(false);
		metaData.getColumn("capialzadosTiene").setSortable(true);
		metaData.getColumn("capialzadosTiene").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("capialzadosTiene").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] capialzadosTieneStore = new String[][] { { String.valueOf(Keys.ACUSTICA_RUIDO_EXTERIORES_NS), this.getMessage("forms.acusticaruidosexteriores.columns.capialzadosTiene." + Keys.ACUSTICA_RUIDO_EXTERIORES_NS, locale) }, { String.valueOf(Keys.ACUSTICA_RUIDO_EXTERIORES_SI), this.getMessage("forms.acusticaruidosexteriores.columns.capialzadosTiene." + Keys.ACUSTICA_RUIDO_EXTERIORES_SI, locale) }, { String.valueOf(Keys.ACUSTICA_RUIDO_EXTERIORES_NO), this.getMessage("forms.acusticaruidosexteriores.columns.capialzadosTiene." + Keys.ACUSTICA_RUIDO_EXTERIORES_NO, locale) }, };

		metaData.getColumn("capialzadosTiene").setSofaStoreValues(capialzadosTieneStore);

		metaData.getColumn("capialzadosTiene").setEditable(true);
		metaData.getColumn("capialzadosTiene").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("cubiertasLigeras", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("cubiertasLigeras", this.getMessage("forms.acusticaruidosexteriores.columns.cubiertasLigeras.header", locale)));
		metaData.getColumn("cubiertasLigeras").setGroupable(false);
		metaData.getColumn("cubiertasLigeras").setSortable(true);
		metaData.getColumn("cubiertasLigeras").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("cubiertasLigeras").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] cubiertasLigerasStore = new String[][] { { String.valueOf(Keys.ACUSTICA_RUIDO_EXTERIORES_SI), this.getMessage("forms.acusticaruidosexteriores.columns.cubiertasLigeras." + Keys.ACUSTICA_RUIDO_EXTERIORES_SI, locale) }, { String.valueOf(Keys.ACUSTICA_RUIDO_EXTERIORES_NO), this.getMessage("forms.acusticaruidosexteriores.columns.cubiertasLigeras." + Keys.ACUSTICA_RUIDO_EXTERIORES_NO, locale) }, };

		metaData.getColumn("cubiertasLigeras").setSofaStoreValues(cubiertasLigerasStore);

		metaData.getColumn("cubiertasLigeras").setEditable(true);
		metaData.getColumn("cubiertasLigeras").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("cubiertasLigerasTecho", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("cubiertasLigerasTecho", this.getMessage("forms.acusticaruidosexteriores.columns.cubiertasLigerasTecho.header", locale)));
		metaData.getColumn("cubiertasLigerasTecho").setGroupable(false);
		metaData.getColumn("cubiertasLigerasTecho").setSortable(true);
		metaData.getColumn("cubiertasLigerasTecho").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("cubiertasLigerasTecho").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] cubiertasLigerasTechoStore = new String[][] { { String.valueOf(Keys.ACUSTICA_RUIDO_EXTERIORES_NS), this.getMessage("forms.acusticaruidosexteriores.columns.cubiertasLigerasTecho." + Keys.ACUSTICA_RUIDO_EXTERIORES_NS, locale) }, { String.valueOf(Keys.ACUSTICA_RUIDO_EXTERIORES_SI), this.getMessage("forms.acusticaruidosexteriores.columns.cubiertasLigerasTecho." + Keys.ACUSTICA_RUIDO_EXTERIORES_SI, locale) }, { String.valueOf(Keys.ACUSTICA_RUIDO_EXTERIORES_NO), this.getMessage("forms.acusticaruidosexteriores.columns.cubiertasLigerasTecho." + Keys.ACUSTICA_RUIDO_EXTERIORES_NO, locale) }, };

		metaData.getColumn("cubiertasLigerasTecho").setSofaStoreValues(cubiertasLigerasTechoStore);

		metaData.getColumn("cubiertasLigerasTecho").setEditable(true);
		metaData.getColumn("cubiertasLigerasTecho").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("cubiertasPesadas", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("cubiertasPesadas", this.getMessage("forms.acusticaruidosexteriores.columns.cubiertasPesadas.header", locale)));
		metaData.getColumn("cubiertasPesadas").setGroupable(false);
		metaData.getColumn("cubiertasPesadas").setSortable(true);
		metaData.getColumn("cubiertasPesadas").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("cubiertasPesadas").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] cubiertasPesadasStore = new String[][] { { String.valueOf(Keys.ACUSTICA_RUIDO_EXTERIORES_SI), this.getMessage("forms.acusticaruidosexteriores.columns.cubiertasPesadas." + Keys.ACUSTICA_RUIDO_EXTERIORES_SI, locale) }, { String.valueOf(Keys.ACUSTICA_RUIDO_EXTERIORES_NO), this.getMessage("forms.acusticaruidosexteriores.columns.cubiertasPesadas." + Keys.ACUSTICA_RUIDO_EXTERIORES_NO, locale) }, };

		metaData.getColumn("cubiertasPesadas").setSofaStoreValues(cubiertasPesadasStore);

		metaData.getColumn("cubiertasPesadas").setEditable(true);
		metaData.getColumn("cubiertasPesadas").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("deficienciasObservaciones", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("deficienciasObservaciones", this.getMessage("forms.acusticaruidosexteriores.columns.deficienciasObservaciones.header", locale)));
		metaData.getColumn("deficienciasObservaciones").setGroupable(false);
		metaData.getColumn("deficienciasObservaciones").setSortable(true);
		metaData.getColumn("deficienciasObservaciones").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("deficienciasObservaciones").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("deficienciasObservaciones").setEditable(true);
		metaData.getColumn("deficienciasObservaciones").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("estadoCapialzadosBueno", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("estadoCapialzadosBueno", this.getMessage("forms.acusticaruidosexteriores.columns.estadoCapialzadosBueno.header", locale)));
		metaData.getColumn("estadoCapialzadosBueno").setGroupable(false);
		metaData.getColumn("estadoCapialzadosBueno").setSortable(true);
		metaData.getColumn("estadoCapialzadosBueno").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("estadoCapialzadosBueno").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] estadoCapialzadosBuenoStore = new String[][] { { String.valueOf(Keys.ACUSTICA_RUIDO_EXTERIORES_NS), this.getMessage("forms.acusticaruidosexteriores.columns.estadoCapialzadosBueno." + Keys.ACUSTICA_RUIDO_EXTERIORES_NS, locale) }, { String.valueOf(Keys.ACUSTICA_RUIDO_EXTERIORES_SI), this.getMessage("forms.acusticaruidosexteriores.columns.estadoCapialzadosBueno." + Keys.ACUSTICA_RUIDO_EXTERIORES_SI, locale) }, { String.valueOf(Keys.ACUSTICA_RUIDO_EXTERIORES_NO), this.getMessage("forms.acusticaruidosexteriores.columns.estadoCapialzadosBueno." + Keys.ACUSTICA_RUIDO_EXTERIORES_NO, locale) }, };

		metaData.getColumn("estadoCapialzadosBueno").setSofaStoreValues(estadoCapialzadosBuenoStore);

		metaData.getColumn("estadoCapialzadosBueno").setEditable(true);
		//metaData.getColumn("estadoCapialzadosBueno").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("estadoCubiertasBueno", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("estadoCubiertasBueno", this.getMessage("forms.acusticaruidosexteriores.columns.estadoCubiertasBueno.header", locale)));
		metaData.getColumn("estadoCubiertasBueno").setGroupable(false);
		metaData.getColumn("estadoCubiertasBueno").setSortable(true);
		metaData.getColumn("estadoCubiertasBueno").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("estadoCubiertasBueno").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] estadoCubiertasBuenoStore = new String[][] { { String.valueOf(Keys.ACUSTICA_RUIDO_EXTERIORES_NS), this.getMessage("forms.acusticaruidosexteriores.columns.estadoCubiertasBueno." + Keys.ACUSTICA_RUIDO_EXTERIORES_NS, locale) }, { String.valueOf(Keys.ACUSTICA_RUIDO_EXTERIORES_SI), this.getMessage("forms.acusticaruidosexteriores.columns.estadoCubiertasBueno." + Keys.ACUSTICA_RUIDO_EXTERIORES_SI, locale) }, { String.valueOf(Keys.ACUSTICA_RUIDO_EXTERIORES_NO), this.getMessage("forms.acusticaruidosexteriores.columns.estadoCubiertasBueno." + Keys.ACUSTICA_RUIDO_EXTERIORES_NO, locale) }, };

		metaData.getColumn("estadoCubiertasBueno").setSofaStoreValues(estadoCubiertasBuenoStore);

		metaData.getColumn("estadoCubiertasBueno").setEditable(true);
		//metaData.getColumn("estadoCubiertasBueno").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("estadoFachadasBueno", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("estadoFachadasBueno", this.getMessage("forms.acusticaruidosexteriores.columns.estadoFachadasBueno.header", locale)));
		metaData.getColumn("estadoFachadasBueno").setGroupable(false);
		metaData.getColumn("estadoFachadasBueno").setSortable(true);
		metaData.getColumn("estadoFachadasBueno").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("estadoFachadasBueno").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] estadoFachadasBuenoStore = new String[][] { { String.valueOf(Keys.ACUSTICA_RUIDO_EXTERIORES_NS), this.getMessage("forms.acusticaruidosexteriores.columns.estadoFachadasBueno." + Keys.ACUSTICA_RUIDO_EXTERIORES_NS, locale) }, { String.valueOf(Keys.ACUSTICA_RUIDO_EXTERIORES_SI), this.getMessage("forms.acusticaruidosexteriores.columns.estadoFachadasBueno." + Keys.ACUSTICA_RUIDO_EXTERIORES_SI, locale) }, { String.valueOf(Keys.ACUSTICA_RUIDO_EXTERIORES_NO), this.getMessage("forms.acusticaruidosexteriores.columns.estadoFachadasBueno." + Keys.ACUSTICA_RUIDO_EXTERIORES_NO, locale) }, };

		metaData.getColumn("estadoFachadasBueno").setSofaStoreValues(estadoFachadasBuenoStore);

		metaData.getColumn("estadoFachadasBueno").setEditable(true);
		//metaData.getColumn("estadoFachadasBueno").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("estadoVentanasBueno", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("estadoVentanasBueno", this.getMessage("forms.acusticaruidosexteriores.columns.estadoVentanasBueno.header", locale)));
		metaData.getColumn("estadoVentanasBueno").setGroupable(false);
		metaData.getColumn("estadoVentanasBueno").setSortable(true);
		metaData.getColumn("estadoVentanasBueno").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("estadoVentanasBueno").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] estadoVentanasBuenoStore = new String[][] { { String.valueOf(Keys.ACUSTICA_RUIDO_EXTERIORES_NS), this.getMessage("forms.acusticaruidosexteriores.columns.estadoVentanasBueno." + Keys.ACUSTICA_RUIDO_EXTERIORES_NS, locale) }, { String.valueOf(Keys.ACUSTICA_RUIDO_EXTERIORES_SI), this.getMessage("forms.acusticaruidosexteriores.columns.estadoVentanasBueno." + Keys.ACUSTICA_RUIDO_EXTERIORES_SI, locale) }, { String.valueOf(Keys.ACUSTICA_RUIDO_EXTERIORES_NO), this.getMessage("forms.acusticaruidosexteriores.columns.estadoVentanasBueno." + Keys.ACUSTICA_RUIDO_EXTERIORES_NO, locale) }, };

		metaData.getColumn("estadoVentanasBueno").setSofaStoreValues(estadoVentanasBuenoStore);

		metaData.getColumn("estadoVentanasBueno").setEditable(true);
		//metaData.getColumn("estadoVentanasBueno").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("fachadasLigeras", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("fachadasLigeras", this.getMessage("forms.acusticaruidosexteriores.columns.fachadasLigeras.header", locale)));
		metaData.getColumn("fachadasLigeras").setGroupable(false);
		metaData.getColumn("fachadasLigeras").setSortable(true);
		metaData.getColumn("fachadasLigeras").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("fachadasLigeras").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] fachadasLigerasStore = new String[][] { { String.valueOf(Keys.ACUSTICA_RUIDO_EXTERIORES_SI), this.getMessage("forms.acusticaruidosexteriores.columns.fachadasLigeras." + Keys.ACUSTICA_RUIDO_EXTERIORES_SI, locale) }, { String.valueOf(Keys.ACUSTICA_RUIDO_EXTERIORES_NO), this.getMessage("forms.acusticaruidosexteriores.columns.fachadasLigeras." + Keys.ACUSTICA_RUIDO_EXTERIORES_NO, locale) }, };

		metaData.getColumn("fachadasLigeras").setSofaStoreValues(fachadasLigerasStore);

		metaData.getColumn("fachadasLigeras").setEditable(true);
		metaData.getColumn("fachadasLigeras").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("fachadasPesadas", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("fachadasPesadas", this.getMessage("forms.acusticaruidosexteriores.columns.fachadasPesadas.header", locale)));
		metaData.getColumn("fachadasPesadas").setGroupable(false);
		metaData.getColumn("fachadasPesadas").setSortable(true);
		metaData.getColumn("fachadasPesadas").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("fachadasPesadas").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] fachadasPesadasStore = new String[][] { { String.valueOf(Keys.ACUSTICA_RUIDO_EXTERIORES_SI), this.getMessage("forms.acusticaruidosexteriores.columns.fachadasPesadas." + Keys.ACUSTICA_RUIDO_EXTERIORES_SI, locale) }, { String.valueOf(Keys.ACUSTICA_RUIDO_EXTERIORES_NO), this.getMessage("forms.acusticaruidosexteriores.columns.fachadasPesadas." + Keys.ACUSTICA_RUIDO_EXTERIORES_NO, locale) }, };

		metaData.getColumn("fachadasPesadas").setSofaStoreValues(fachadasPesadasStore);

		metaData.getColumn("fachadasPesadas").setEditable(true);
		metaData.getColumn("fachadasPesadas").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("observaciones", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("observaciones", this.getMessage("forms.acusticaruidosexteriores.columns.observaciones.header", locale)));
		metaData.getColumn("observaciones").setGroupable(false);
		metaData.getColumn("observaciones").setSortable(true);
		metaData.getColumn("observaciones").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("observaciones").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("observaciones").setEditable(true);
		metaData.getColumn("observaciones").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("ruidoMolestoExterior", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("ruidoMolestoExterior", this.getMessage("forms.acusticaruidosexteriores.columns.ruidoMolestoExterior.header", locale)));
		metaData.getColumn("ruidoMolestoExterior").setGroupable(false);
		metaData.getColumn("ruidoMolestoExterior").setSortable(true);
		metaData.getColumn("ruidoMolestoExterior").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("ruidoMolestoExterior").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] ruidoMolestoExteriorStore = new String[][] { { String.valueOf(Keys.ACUSTICA_RUIDO_EXTERIORES_NS), this.getMessage("forms.acusticaruidosexteriores.columns.ruidoMolestoExterior." + Keys.ACUSTICA_RUIDO_EXTERIORES_NS, locale) }, { String.valueOf(Keys.ACUSTICA_RUIDO_EXTERIORES_SI), this.getMessage("forms.acusticaruidosexteriores.columns.ruidoMolestoExterior." + Keys.ACUSTICA_RUIDO_EXTERIORES_SI, locale) }, { String.valueOf(Keys.ACUSTICA_RUIDO_EXTERIORES_NO), this.getMessage("forms.acusticaruidosexteriores.columns.ruidoMolestoExterior." + Keys.ACUSTICA_RUIDO_EXTERIORES_NO, locale) }, };

		metaData.getColumn("ruidoMolestoExterior").setSofaStoreValues(ruidoMolestoExteriorStore);

		metaData.getColumn("ruidoMolestoExterior").setEditable(true);
		//metaData.getColumn("ruidoMolestoExterior").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("ventanasLocalizacionTiposVentanas", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("ventanasLocalizacionTiposVentanas", this.getMessage("forms.acusticaruidosexteriores.columns.ventanasLocalizacionTiposVentanas.header", locale)));
		metaData.getColumn("ventanasLocalizacionTiposVentanas").setTooltip(this.getMessage("forms.acusticaruidosexteriores.columns.ventanasLocalizacionTiposVentanas.description", locale));
		metaData.getColumn("ventanasLocalizacionTiposVentanas").setGroupable(false);
		metaData.getColumn("ventanasLocalizacionTiposVentanas").setSortable(true);
		metaData.getColumn("ventanasLocalizacionTiposVentanas").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("ventanasLocalizacionTiposVentanas").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("ventanasLocalizacionTiposVentanas").setEditable(true);
		metaData.getColumn("ventanasLocalizacionTiposVentanas").setHidden(true);

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

		datosExportacion.add("claveInforme", this.getMessage("forms.acusticaruidosexteriores.columns.claveInforme.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("inspeccion", this.getMessage("forms.acusticaruidosexteriores.columns.inspeccion.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("aireadoresAsilamientoAcustico", this.getMessage("forms.acusticaruidosexteriores.columns.aireadoresAsilamientoAcustico.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("aireadoresTiene", this.getMessage("forms.acusticaruidosexteriores.columns.aireadoresTiene.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("capialzadosAislamientoAcustico", this.getMessage("forms.acusticaruidosexteriores.columns.capialzadosAislamientoAcustico.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("capialzadosNoPrefabricados", this.getMessage("forms.acusticaruidosexteriores.columns.capialzadosNoPrefabricados.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("capialzadosTiene", this.getMessage("forms.acusticaruidosexteriores.columns.capialzadosTiene.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("cubiertasLigeras", this.getMessage("forms.acusticaruidosexteriores.columns.cubiertasLigeras.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("cubiertasLigerasTecho", this.getMessage("forms.acusticaruidosexteriores.columns.cubiertasLigerasTecho.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("cubiertasPesadas", this.getMessage("forms.acusticaruidosexteriores.columns.cubiertasPesadas.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("deficienciasObservaciones", this.getMessage("forms.acusticaruidosexteriores.columns.deficienciasObservaciones.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("estadoCapialzadosBueno", this.getMessage("forms.acusticaruidosexteriores.columns.estadoCapialzadosBueno.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("estadoCubiertasBueno", this.getMessage("forms.acusticaruidosexteriores.columns.estadoCubiertasBueno.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("estadoFachadasBueno", this.getMessage("forms.acusticaruidosexteriores.columns.estadoFachadasBueno.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("estadoVentanasBueno", this.getMessage("forms.acusticaruidosexteriores.columns.estadoVentanasBueno.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("fachadasLigeras", this.getMessage("forms.acusticaruidosexteriores.columns.fachadasLigeras.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("fachadasPesadas", this.getMessage("forms.acusticaruidosexteriores.columns.fachadasPesadas.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("observaciones", this.getMessage("forms.acusticaruidosexteriores.columns.observaciones.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("ruidoMolestoExterior", this.getMessage("forms.acusticaruidosexteriores.columns.ruidoMolestoExterior.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("ventanasLocalizacionTiposVentanas", this.getMessage("forms.acusticaruidosexteriores.columns.ventanasLocalizacionTiposVentanas.header", locale), TipoCampoExportacion.STRING);

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
		AcusticaRuidosExterioresListadoVO instance = (AcusticaRuidosExterioresListadoVO) rawInstance;

		List<String> excelRow = new ArrayList<String>();

		excelRow.add(FormData2Java.toString(instance.getClaveInforme()));
		excelRow.add(FormData2Java.toString(instance.getInspeccionLabel()));
		//excelRow.add(instance.getAireadoresAsilamientoAcustico());
		if (instance.getAireadoresAsilamientoAcustico() != null) {
			excelRow.add(this.getMessage("forms.acusticaruidosexteriores.columns.aireadoresAsilamientoAcustico." + instance.getAireadoresAsilamientoAcustico(), locale));
		} else {
			excelRow.add("null");
		}

		//excelRow.add(FormData2Java.toString(instance.getAireadoresTiene()));
		if (instance.getAireadoresTiene() != null) {
			excelRow.add(this.getMessage("forms.acusticaruidosexteriores.columns.aireadoresTiene." + instance.getAireadoresTiene(), locale));
		} else {
			excelRow.add("null");
		}

		//excelRow.add(FormData2Java.toString(instance.getCapialzadosAislamientoAcustico()));
		if (instance.getCapialzadosAislamientoAcustico() != null) {
			excelRow.add(this.getMessage("forms.acusticaruidosexteriores.columns.capialzadosAislamientoAcustico." + instance.getCapialzadosAislamientoAcustico(), locale));
		} else {
			excelRow.add("null");
		}

		//excelRow.add(FormData2Java.toString(instance.getCapialzadosNoPrefabricados()));
		if (instance.getCapialzadosNoPrefabricados() != null) {
			excelRow.add(this.getMessage("forms.acusticaruidosexteriores.columns.capialzadosNoPrefabricados." + instance.getCapialzadosNoPrefabricados(), locale));
		} else {
			excelRow.add("null");
		}

		//excelRow.add(FormData2Java.toString(instance.getCapialzadosTiene()));
		if (instance.getCapialzadosTiene() != null) {
			excelRow.add(this.getMessage("forms.acusticaruidosexteriores.columns.capialzadosTiene." + instance.getCapialzadosTiene(), locale));
		} else {
			excelRow.add("null");
		}

		//excelRow.add(FormData2Java.toString(instance.getCubiertasLigeras()));
		if (instance.getCubiertasLigeras() != null) {
			excelRow.add(this.getMessage("forms.acusticaruidosexteriores.columns.cubiertasLigeras." + instance.getCubiertasLigeras(), locale));
		} else {
			excelRow.add("null");
		}

		//excelRow.add(FormData2Java.toString(instance.getCubiertasLigerasTecho()));
		if (instance.getCubiertasLigerasTecho() != null) {
			excelRow.add(this.getMessage("forms.acusticaruidosexteriores.columns.cubiertasLigerasTecho." + instance.getCubiertasLigerasTecho(), locale));
		} else {
			excelRow.add("null");
		}

		//excelRow.add(FormData2Java.toString(instance.getCubiertasPesadas()));
		if (instance.getCubiertasPesadas() != null) {
			excelRow.add(this.getMessage("forms.acusticaruidosexteriores.columns.cubiertasPesadas." + instance.getCubiertasPesadas(), locale));
		} else {
			excelRow.add("null");
		}

		excelRow.add(instance.getDeficienciasObservaciones());
		//excelRow.add(FormData2Java.toString(instance.getEstadoCapialzadosBueno()));
		if (instance.getEstadoCapialzadosBueno() != null) {
			excelRow.add(this.getMessage("forms.acusticaruidosexteriores.columns.estadoCapialzadosBueno." + instance.getEstadoCapialzadosBueno(), locale));
		} else {
			excelRow.add("null");
		}

		//excelRow.add(FormData2Java.toString(instance.getEstadoCubiertasBueno()));
		if (instance.getEstadoCubiertasBueno() != null) {
			excelRow.add(this.getMessage("forms.acusticaruidosexteriores.columns.estadoCubiertasBueno." + instance.getEstadoCubiertasBueno(), locale));
		} else {
			excelRow.add("null");
		}

		//excelRow.add(FormData2Java.toString(instance.getEstadoFachadasBueno()));
		if (instance.getEstadoFachadasBueno() != null) {
			excelRow.add(this.getMessage("forms.acusticaruidosexteriores.columns.estadoFachadasBueno." + instance.getEstadoFachadasBueno(), locale));
		} else {
			excelRow.add("null");
		}

		//excelRow.add(FormData2Java.toString(instance.getEstadoVentanasBueno()));
		if (instance.getEstadoVentanasBueno() != null) {
			excelRow.add(this.getMessage("forms.acusticaruidosexteriores.columns.estadoVentanasBueno." + instance.getEstadoVentanasBueno(), locale));
		} else {
			excelRow.add("null");
		}

		//excelRow.add(FormData2Java.toString(instance.getFachadasLigeras()));
		if (instance.getFachadasLigeras() != null) {
			excelRow.add(this.getMessage("forms.acusticaruidosexteriores.columns.fachadasLigeras." + instance.getFachadasLigeras(), locale));
		} else {
			excelRow.add("null");
		}

		//excelRow.add(FormData2Java.toString(instance.getFachadasPesadas()));
		if (instance.getFachadasPesadas() != null) {
			excelRow.add(this.getMessage("forms.acusticaruidosexteriores.columns.fachadasPesadas." + instance.getFachadasPesadas(), locale));
		} else {
			excelRow.add("null");
		}

		excelRow.add(instance.getObservaciones());
		//excelRow.add(FormData2Java.toString(instance.getRuidoMolestoExterior()));
		if (instance.getRuidoMolestoExterior() != null) {
			excelRow.add(this.getMessage("forms.acusticaruidosexteriores.columns.ruidoMolestoExterior." + instance.getRuidoMolestoExterior(), locale));
		} else {
			excelRow.add("null");
		}

		excelRow.add(instance.getVentanasLocalizacionTiposVentanas());
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
	 * Rellena una instancia de AcusticaRuidosExterioresFormVO con el contenido
	 * de un formulario recibido en formato Map<String, ?>
	 */
	protected void setFormData(AcusticaRuidosExterioresFormVO record, Map<String, ?> formData) throws GenericBusinessException {
		String formDataStr = null;
		if (!StringUtils.isEmpty(formData, "inspeccionId")) {
			formDataStr = (String) formData.get("inspeccionId");
			record.setInspeccionId(FormData2Java.toInteger(formDataStr));

		}
		if (formData.containsKey("aireadoresAsilamientoAcustico")) {
			formDataStr = (String) formData.get("aireadoresAsilamientoAcustico");
			record.setAireadoresAsilamientoAcustico(formDataStr);
		}
		if (formData.containsKey("aireadoresTiene")) {
			formDataStr = (String) formData.get("aireadoresTiene");
			record.setAireadoresTiene(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("capialzadosAislamientoAcustico")) {
			formDataStr = (String) formData.get("capialzadosAislamientoAcustico");
			record.setCapialzadosAislamientoAcustico(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("capialzadosNoPrefabricados")) {
			formDataStr = (String) formData.get("capialzadosNoPrefabricados");
			record.setCapialzadosNoPrefabricados(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("capialzadosTiene")) {
			formDataStr = (String) formData.get("capialzadosTiene");
			record.setCapialzadosTiene(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("cubiertasLigeras")) {
			formDataStr = (String) formData.get("cubiertasLigeras");
			record.setCubiertasLigeras(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("cubiertasLigerasTecho")) {
			formDataStr = (String) formData.get("cubiertasLigerasTecho");
			record.setCubiertasLigerasTecho(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("cubiertasPesadas")) {
			formDataStr = (String) formData.get("cubiertasPesadas");
			record.setCubiertasPesadas(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("deficienciasObservaciones")) {
			formDataStr = (String) formData.get("deficienciasObservaciones");
			record.setDeficienciasObservaciones(formDataStr);
		}
		if (formData.containsKey("estadoCapialzadosBueno")) {
			formDataStr = (String) formData.get("estadoCapialzadosBueno");
			record.setEstadoCapialzadosBueno(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("estadoCubiertasBueno")) {
			formDataStr = (String) formData.get("estadoCubiertasBueno");
			record.setEstadoCubiertasBueno(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("estadoFachadasBueno")) {
			formDataStr = (String) formData.get("estadoFachadasBueno");
			record.setEstadoFachadasBueno(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("estadoVentanasBueno")) {
			formDataStr = (String) formData.get("estadoVentanasBueno");
			record.setEstadoVentanasBueno(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("fachadasLigeras")) {
			formDataStr = (String) formData.get("fachadasLigeras");
			record.setFachadasLigeras(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("fachadasPesadas")) {
			formDataStr = (String) formData.get("fachadasPesadas");
			record.setFachadasPesadas(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("observaciones")) {
			formDataStr = (String) formData.get("observaciones");
			record.setObservaciones(formDataStr);
		}
		if (formData.containsKey("ruidoMolestoExterior")) {
			formDataStr = (String) formData.get("ruidoMolestoExterior");
			record.setRuidoMolestoExterior(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("ventanasLocalizacionTiposVentanas")) {
			formDataStr = (String) formData.get("ventanasLocalizacionTiposVentanas");
			record.setVentanasLocalizacionTiposVentanas(formDataStr);
		}
	}

}
