package es.caib.avaedi.front.service;

import java.io.Serializable;
import java.math.BigDecimal;
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
import es.caib.avaedi.logic.bo.CerramientosCubiertasBO;
import es.caib.avaedi.logic.bo.InspeccionBO;
import es.caib.avaedi.logic.util.Keys;
import es.caib.avaedi.logic.vo.AcusticasListadoVO;
import es.caib.avaedi.logic.vo.CerramientosCubiertasFormVO;
import es.caib.avaedi.logic.vo.CerramientosCubiertasListadoVO;

/**
 * Servicio para tratar el formulario: CerramientosCubiertas
 * 
 * @author agarcia@at4.net
 * 
 */
@Service("cerramientoscubiertas")
public class CerramientosCubiertasService extends InspeccionBaseService<CerramientosCubiertasBO, CerramientosCubiertasListadoVO, CerramientosCubiertasFormVO> {

	/**
	 * The logger object.
	 */
	private static Logger log = LogService.getLogger(CerramientosCubiertasService.class);

	/**
	 * Bean para acceder a los métodos de negocio: CerramientosCubiertas
	 */
	@Autowired
	@Qualifier("CerramientosCubiertasBean")
	protected CerramientosCubiertasBO mainBO;

	/**
	 * Bean para acceder a los métodos de negocio: CerramientosCubiertas
	 * 
	 * @param bean
	 *            the bean to set
	 */
	protected CerramientosCubiertasBO getMainBO() {
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
			formItem.setText(this.getMessage("forms.cerramientoscubiertas.title", locale));
		}

		GridMetaData metaData = this.getBaseMetaData(formItem, locale);

		//Nombre de la clase js de formulario
		metaData.setFormClassName("CerramientosCubiertasForm");

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
		 * ("forms.cerramientoscubiertas.columns.claveInforme.header",
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
		 * ("forms.cerramientoscubiertas.columns.inspeccion.header", locale)));
		 * metaData.getColumn("inspeccion").setGroupable(true);
		 * metaData.getColumn("inspeccion").setSortable(true);
		 * metaData.getColumn
		 * ("inspeccion").setSofaFilter(GridColumnFilter.TYPE_MULTICOMBO);
		 * metaData.getColumn("inspeccion").setRelatedForm("Inspeccion");
		 * 
		 * metaData.getColumn("inspeccion").setEditable(true) ;
		 * metaData.getColumn("inspeccion").setHidden(true);
		 */

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("fachadaPrincipalSuperficie", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("fachadaPrincipalSuperficie", this.getMessage("forms.cerramientoscubiertas.columns.fachadaPrincipalSuperficie.header", locale)));
		metaData.getColumn("fachadaPrincipalSuperficie").setGroupable(true);
		metaData.getColumn("fachadaPrincipalSuperficie").setSortable(true);
		metaData.getColumn("fachadaPrincipalSuperficie").setSofaFilter(GridColumnFilter.TYPE_STRING);
		
		metaData.getColumn("fachadaPrincipalSuperficie").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("fachadaPrincipalSuperficie").setEditable(true);
		//metaData.getColumn("fachadaPrincipalSuperficie").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("fachadaPrincipalPorcentaje", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("fachadaPrincipalPorcentaje", this.getMessage("forms.cerramientoscubiertas.columns.fachadaPrincipalPorcentaje.header", locale)));
		metaData.getColumn("fachadaPrincipalPorcentaje").setGroupable(false);
		metaData.getColumn("fachadaPrincipalPorcentaje").setSortable(true);
		metaData.getColumn("fachadaPrincipalPorcentaje").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("fachadaPrincipalPorcentaje").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("fachadaPrincipalPorcentaje").setEditable(true);
		//metaData.getColumn("fachadaPrincipalPorcentaje").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("otrasFachadasSuperficie", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("otrasFachadasSuperficie", this.getMessage("forms.cerramientoscubiertas.columns.otrasFachadasSuperficie.header", locale)));
		metaData.getColumn("otrasFachadasSuperficie").setGroupable(false);
		metaData.getColumn("otrasFachadasSuperficie").setSortable(true);
		metaData.getColumn("otrasFachadasSuperficie").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("otrasFachadasSuperficie").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("otrasFachadasSuperficie").setEditable(true);
		//metaData.getColumn("otrasFachadasSuperficie").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("otrasFachadasPorcentaje", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("otrasFachadasPorcentaje", this.getMessage("forms.cerramientoscubiertas.columns.otrasFachadasPorcentaje.header", locale)));
		metaData.getColumn("otrasFachadasPorcentaje").setGroupable(false);
		metaData.getColumn("otrasFachadasPorcentaje").setSortable(true);
		metaData.getColumn("otrasFachadasPorcentaje").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("otrasFachadasPorcentaje").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("otrasFachadasPorcentaje").setEditable(true);
		//metaData.getColumn("otrasFachadasPorcentaje").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("carpinteriaVidrioSuperficie", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("carpinteriaVidrioSuperficie", this.getMessage("forms.cerramientoscubiertas.columns.carpinteriaVidrioSuperficie.header", locale)));
		metaData.getColumn("carpinteriaVidrioSuperficie").setGroupable(false);
		metaData.getColumn("carpinteriaVidrioSuperficie").setSortable(true);
		metaData.getColumn("carpinteriaVidrioSuperficie").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("carpinteriaVidrioSuperficie").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("carpinteriaVidrioSuperficie").setEditable(true);
		//metaData.getColumn("carpinteriaVidrioSuperficie").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("carpinteriaVidrioPorcentaje", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("carpinteriaVidrioPorcentaje", this.getMessage("forms.cerramientoscubiertas.columns.carpinteriaVidrioPorcentaje.header", locale)));
		metaData.getColumn("carpinteriaVidrioPorcentaje").setGroupable(false);
		metaData.getColumn("carpinteriaVidrioPorcentaje").setSortable(true);
		metaData.getColumn("carpinteriaVidrioPorcentaje").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("carpinteriaVidrioPorcentaje").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("carpinteriaVidrioPorcentaje").setEditable(true);
		//metaData.getColumn("carpinteriaVidrioPorcentaje").setHidden(true);
		

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("carpinteriavidrioCarpinteriapredominanteTexto", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("carpinteriavidrioCarpinteriapredominanteTexto", this.getMessage("forms.cerramientoscubiertas.columns.carpinteriavidrioCarpinteriapredominanteTexto.header", locale)));
		metaData.getColumn("carpinteriavidrioCarpinteriapredominanteTexto").setTooltip(this.getMessage("forms.cerramientoscubiertas.columns.carpinteriavidrioCarpinteriapredominanteTexto.description", locale));
		metaData.getColumn("carpinteriavidrioCarpinteriapredominanteTexto").setGroupable(false);
		metaData.getColumn("carpinteriavidrioCarpinteriapredominanteTexto").setSortable(true);
		metaData.getColumn("carpinteriavidrioCarpinteriapredominanteTexto").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("carpinteriavidrioCarpinteriapredominanteTexto").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("carpinteriavidrioCarpinteriapredominanteTexto").setEditable(true);
		metaData.getColumn("carpinteriavidrioCarpinteriapredominanteTexto").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("carpinteriavidrioVidriopredominanteTexto", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("carpinteriavidrioVidriopredominanteTexto", this.getMessage("forms.cerramientoscubiertas.columns.carpinteriavidrioVidriopredominanteTexto.header", locale)));
		metaData.getColumn("carpinteriavidrioVidriopredominanteTexto").setTooltip(this.getMessage("forms.cerramientoscubiertas.columns.carpinteriavidrioVidriopredominanteTexto.description", locale));
		metaData.getColumn("carpinteriavidrioVidriopredominanteTexto").setGroupable(false);
		metaData.getColumn("carpinteriavidrioVidriopredominanteTexto").setSortable(true);
		metaData.getColumn("carpinteriavidrioVidriopredominanteTexto").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("carpinteriavidrioVidriopredominanteTexto").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("carpinteriavidrioVidriopredominanteTexto").setEditable(true);
		metaData.getColumn("carpinteriavidrioVidriopredominanteTexto").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("cubiertaInclinadaPorcentaje", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("cubiertaInclinadaPorcentaje", this.getMessage("forms.cerramientoscubiertas.columns.cubiertaInclinadaPorcentaje.header", locale)));
		metaData.getColumn("cubiertaInclinadaPorcentaje").setGroupable(false);
		metaData.getColumn("cubiertaInclinadaPorcentaje").setSortable(true);
		metaData.getColumn("cubiertaInclinadaPorcentaje").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("cubiertaInclinadaPorcentaje").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("cubiertaInclinadaPorcentaje").setEditable(true);
		metaData.getColumn("cubiertaInclinadaPorcentaje").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("cubiertaInclinadaSuperficie", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("cubiertaInclinadaSuperficie", this.getMessage("forms.cerramientoscubiertas.columns.cubiertaInclinadaSuperficie.header", locale)));
		metaData.getColumn("cubiertaInclinadaSuperficie").setGroupable(false);
		metaData.getColumn("cubiertaInclinadaSuperficie").setSortable(true);
		metaData.getColumn("cubiertaInclinadaSuperficie").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("cubiertaInclinadaSuperficie").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("cubiertaInclinadaSuperficie").setEditable(true);
		metaData.getColumn("cubiertaInclinadaSuperficie").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("cubiertaPlanaPorcentaje", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("cubiertaPlanaPorcentaje", this.getMessage("forms.cerramientoscubiertas.columns.cubiertaPlanaPorcentaje.header", locale)));
		metaData.getColumn("cubiertaPlanaPorcentaje").setGroupable(false);
		metaData.getColumn("cubiertaPlanaPorcentaje").setSortable(true);
		metaData.getColumn("cubiertaPlanaPorcentaje").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("cubiertaPlanaPorcentaje").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("cubiertaPlanaPorcentaje").setEditable(true);
		metaData.getColumn("cubiertaPlanaPorcentaje").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("cubiertaPlanaSuperficie", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("cubiertaPlanaSuperficie", this.getMessage("forms.cerramientoscubiertas.columns.cubiertaPlanaSuperficie.header", locale)));
		metaData.getColumn("cubiertaPlanaSuperficie").setGroupable(false);
		metaData.getColumn("cubiertaPlanaSuperficie").setSortable(true);
		metaData.getColumn("cubiertaPlanaSuperficie").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("cubiertaPlanaSuperficie").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("cubiertaPlanaSuperficie").setEditable(true);
		metaData.getColumn("cubiertaPlanaSuperficie").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("cubiertainclinadaAislamientotermicoTipoId", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("cubiertainclinadaAislamientotermicoTipoId", this.getMessage("forms.cerramientoscubiertas.columns.cubiertainclinadaAislamientotermicoTipoId.header", locale)));
		metaData.getColumn("cubiertainclinadaAislamientotermicoTipoId").setTooltip(this.getMessage("forms.cerramientoscubiertas.columns.cubiertainclinadaAislamientotermicoTipoId.description", locale));
		metaData.getColumn("cubiertainclinadaAislamientotermicoTipoId").setGroupable(false);
		metaData.getColumn("cubiertainclinadaAislamientotermicoTipoId").setSortable(true);
		metaData.getColumn("cubiertainclinadaAislamientotermicoTipoId").setSofaFilter(GridColumnFilter.TYPE_LIST);
		metaData.getColumn("cubiertainclinadaAislamientotermicoTipoId").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] inclinadaAislamientotermicoStore = new String[][] { { String.valueOf(Keys.CERRAMIENTOS_CUBIERTA_INCLINADA_AISLAMIENTO_TERMICO_SI), this.getMessage("forms.cerramientoscubiertas.columns.cubiertainclinadaAislamientotermicoTipoId." + Keys.CERRAMIENTOS_CUBIERTA_INCLINADA_AISLAMIENTO_TERMICO_SI, locale) }, { String.valueOf(Keys.CERRAMIENTOS_CUBIERTA_INCLINADA_AISLAMIENTO_TERMICO_NO), this.getMessage("forms.cerramientoscubiertas.columns.cubiertainclinadaAislamientotermicoTipoId." + Keys.CERRAMIENTOS_CUBIERTA_INCLINADA_AISLAMIENTO_TERMICO_NO, locale) }, { String.valueOf(Keys.CERRAMIENTOS_CUBIERTA_INCLINADA_AISLAMIENTO_TERMICO_SE_DESCONOCE), this.getMessage("forms.cerramientoscubiertas.columns.cubiertainclinadaAislamientotermicoTipoId." + Keys.CERRAMIENTOS_CUBIERTA_INCLINADA_AISLAMIENTO_TERMICO_SE_DESCONOCE, locale) }, };

		metaData.getColumn("cubiertainclinadaAislamientotermicoTipoId").setSofaStoreValues(inclinadaAislamientotermicoStore);

		metaData.getColumn("cubiertainclinadaAislamientotermicoTipoId").setEditable(true);
		metaData.getColumn("cubiertainclinadaAislamientotermicoTipoId").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("cubiertaplanaAislamientotermicoTipoId", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("cubiertaplanaAislamientotermicoTipoId", this.getMessage("forms.cerramientoscubiertas.columns.cubiertaplanaAislamientotermicoTipoId.header", locale)));
		metaData.getColumn("cubiertaplanaAislamientotermicoTipoId").setTooltip(this.getMessage("forms.cerramientoscubiertas.columns.cubiertaplanaAislamientotermicoTipoId.description", locale));
		metaData.getColumn("cubiertaplanaAislamientotermicoTipoId").setGroupable(false);
		metaData.getColumn("cubiertaplanaAislamientotermicoTipoId").setSortable(true);
		metaData.getColumn("cubiertaplanaAislamientotermicoTipoId").setSofaFilter(GridColumnFilter.TYPE_LIST);
		metaData.getColumn("cubiertaplanaAislamientotermicoTipoId").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] planaAislamientotermicoStore = new String[][] { { String.valueOf(Keys.CERRAMIENTOS_CUBIERTA_PLANA_AISLAMIENTO_TERMICO_SI), this.getMessage("forms.cerramientoscubiertas.columns.cubiertaplanaAislamientotermicoTipoId." + Keys.CERRAMIENTOS_CUBIERTA_PLANA_AISLAMIENTO_TERMICO_SI, locale) }, { String.valueOf(Keys.CERRAMIENTOS_CUBIERTA_PLANA_AISLAMIENTO_TERMICO_NO), this.getMessage("forms.cerramientoscubiertas.columns.cubiertaplanaAislamientotermicoTipoId." + Keys.CERRAMIENTOS_CUBIERTA_PLANA_AISLAMIENTO_TERMICO_NO, locale) }, { String.valueOf(Keys.CERRAMIENTOS_CUBIERTA_PLANA_AISLAMIENTO_TERMICO_SE_DESCONOCE), this.getMessage("forms.cerramientoscubiertas.columns.cubiertaplanaAislamientotermicoTipoId." + Keys.CERRAMIENTOS_CUBIERTA_PLANA_AISLAMIENTO_TERMICO_SE_DESCONOCE, locale) }, };

		metaData.getColumn("cubiertaplanaAislamientotermicoTipoId").setSofaStoreValues(planaAislamientotermicoStore);

		metaData.getColumn("cubiertaplanaAislamientotermicoTipoId").setEditable(true);
		metaData.getColumn("cubiertaplanaAislamientotermicoTipoId").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("cubiertaplanaLaminaimpermeabilizanteTipoId", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("cubiertaplanaLaminaimpermeabilizanteTipoId", this.getMessage("forms.cerramientoscubiertas.columns.cubiertaplanaLaminaimpermeabilizanteTipoId.header", locale)));
		metaData.getColumn("cubiertaplanaLaminaimpermeabilizanteTipoId").setTooltip(this.getMessage("forms.cerramientoscubiertas.columns.cubiertaplanaLaminaimpermeabilizanteTipoId.description", locale));
		metaData.getColumn("cubiertaplanaLaminaimpermeabilizanteTipoId").setGroupable(false);
		metaData.getColumn("cubiertaplanaLaminaimpermeabilizanteTipoId").setSortable(true);
		metaData.getColumn("cubiertaplanaLaminaimpermeabilizanteTipoId").setSofaFilter(GridColumnFilter.TYPE_LIST);
		metaData.getColumn("cubiertaplanaLaminaimpermeabilizanteTipoId").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] planaLaminaimpermeabilizanteStore = new String[][] { { String.valueOf(Keys.CERRAMIENTOS_CUBIERTA_PLANA_LAMINA_IMPERMEABILIZANTE_SI), this.getMessage("forms.cerramientoscubiertas.columns.cubiertaplanaLaminaimpermeabilizanteTipoId." + Keys.CERRAMIENTOS_CUBIERTA_PLANA_LAMINA_IMPERMEABILIZANTE_SI, locale) }, { String.valueOf(Keys.CERRAMIENTOS_CUBIERTA_PLANA_LAMINA_IMPERMEABILIZANTE_NO), this.getMessage("forms.cerramientoscubiertas.columns.cubiertaplanaLaminaimpermeabilizanteTipoId." + Keys.CERRAMIENTOS_CUBIERTA_PLANA_LAMINA_IMPERMEABILIZANTE_NO, locale) }, { String.valueOf(Keys.CERRAMIENTOS_CUBIERTA_PLANA_LAMINA_IMPERMEABILIZANTE_SE_DESCONOCE), this.getMessage("forms.cerramientoscubiertas.columns.cubiertaplanaLaminaimpermeabilizanteTipoId." + Keys.CERRAMIENTOS_CUBIERTA_PLANA_LAMINA_IMPERMEABILIZANTE_SE_DESCONOCE, locale) }, };

		metaData.getColumn("cubiertaplanaLaminaimpermeabilizanteTipoId").setSofaStoreValues(planaLaminaimpermeabilizanteStore);

		metaData.getColumn("cubiertaplanaLaminaimpermeabilizanteTipoId").setEditable(true);
		metaData.getColumn("cubiertaplanaLaminaimpermeabilizanteTipoId").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("fachadaprincipalAcabadorevestidoPorcentaje", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("fachadaprincipalAcabadorevestidoPorcentaje", this.getMessage("forms.cerramientoscubiertas.columns.fachadaprincipalAcabadorevestidoPorcentaje.header", locale)));
		metaData.getColumn("fachadaprincipalAcabadorevestidoPorcentaje").setTooltip(this.getMessage("forms.cerramientoscubiertas.columns.fachadaprincipalAcabadorevestidoPorcentaje.description", locale));
		metaData.getColumn("fachadaprincipalAcabadorevestidoPorcentaje").setGroupable(false);
		metaData.getColumn("fachadaprincipalAcabadorevestidoPorcentaje").setSortable(true);
		metaData.getColumn("fachadaprincipalAcabadorevestidoPorcentaje").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("fachadaprincipalAcabadorevestidoPorcentaje").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("fachadaprincipalAcabadorevestidoPorcentaje").setEditable(true);
		metaData.getColumn("fachadaprincipalAcabadorevestidoPorcentaje").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("fachadaprincipalAcabadorevestidoTexto", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("fachadaprincipalAcabadorevestidoTexto", this.getMessage("forms.cerramientoscubiertas.columns.fachadaprincipalAcabadorevestidoTexto.header", locale)));
		metaData.getColumn("fachadaprincipalAcabadorevestidoTexto").setTooltip(this.getMessage("forms.cerramientoscubiertas.columns.fachadaprincipalAcabadorevestidoTexto.description", locale));
		metaData.getColumn("fachadaprincipalAcabadorevestidoTexto").setGroupable(false);
		metaData.getColumn("fachadaprincipalAcabadorevestidoTexto").setSortable(true);
		metaData.getColumn("fachadaprincipalAcabadorevestidoTexto").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("fachadaprincipalAcabadorevestidoTexto").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("fachadaprincipalAcabadorevestidoTexto").setEditable(true);
		metaData.getColumn("fachadaprincipalAcabadorevestidoTexto").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("fachadaprincipalAcabadovistoPorcentaje", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("fachadaprincipalAcabadovistoPorcentaje", this.getMessage("forms.cerramientoscubiertas.columns.fachadaprincipalAcabadovistoPorcentaje.header", locale)));
		metaData.getColumn("fachadaprincipalAcabadovistoPorcentaje").setTooltip(this.getMessage("forms.cerramientoscubiertas.columns.fachadaprincipalAcabadovistoPorcentaje.description", locale));
		metaData.getColumn("fachadaprincipalAcabadovistoPorcentaje").setGroupable(false);
		metaData.getColumn("fachadaprincipalAcabadovistoPorcentaje").setSortable(true);
		metaData.getColumn("fachadaprincipalAcabadovistoPorcentaje").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("fachadaprincipalAcabadovistoPorcentaje").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("fachadaprincipalAcabadovistoPorcentaje").setEditable(true);
		metaData.getColumn("fachadaprincipalAcabadovistoPorcentaje").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("fachadaprincipalAcabadovistoTexto", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("fachadaprincipalAcabadovistoTexto", this.getMessage("forms.cerramientoscubiertas.columns.fachadaprincipalAcabadovistoTexto.header", locale)));
		metaData.getColumn("fachadaprincipalAcabadovistoTexto").setTooltip(this.getMessage("forms.cerramientoscubiertas.columns.fachadaprincipalAcabadovistoTexto.description", locale));
		metaData.getColumn("fachadaprincipalAcabadovistoTexto").setGroupable(false);
		metaData.getColumn("fachadaprincipalAcabadovistoTexto").setSortable(true);
		metaData.getColumn("fachadaprincipalAcabadovistoTexto").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("fachadaprincipalAcabadovistoTexto").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("fachadaprincipalAcabadovistoTexto").setEditable(true);
		metaData.getColumn("fachadaprincipalAcabadovistoTexto").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("fachadaprincipalAislamientotermicoTipoId", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("fachadaprincipalAislamientotermicoTipoId", this.getMessage("forms.cerramientoscubiertas.columns.fachadaprincipalAislamientotermicoTipoId.header", locale)));
		metaData.getColumn("fachadaprincipalAislamientotermicoTipoId").setTooltip(this.getMessage("forms.cerramientoscubiertas.columns.fachadaprincipalAislamientotermicoTipoId.description", locale));
		metaData.getColumn("fachadaprincipalAislamientotermicoTipoId").setGroupable(false);
		metaData.getColumn("fachadaprincipalAislamientotermicoTipoId").setSortable(true);
		metaData.getColumn("fachadaprincipalAislamientotermicoTipoId").setSofaFilter(GridColumnFilter.TYPE_LIST);
		metaData.getColumn("fachadaprincipalAislamientotermicoTipoId").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] fachadaPrincipalAislamientoTermicoStore = new String[][] { { String.valueOf(Keys.CERRAMIENTOS_FACHADA_PRINCIPAL_AISLAMIENTO_TERMICO_SI), this.getMessage("forms.cerramientoscubiertas.columns.fachadaprincipalAislamientotermicoTipoId." + Keys.CERRAMIENTOS_FACHADA_PRINCIPAL_AISLAMIENTO_TERMICO_SI, locale) }, { String.valueOf(Keys.CERRAMIENTOS_FACHADA_PRINCIPAL_AISLAMIENTO_TERMICO_NO), this.getMessage("forms.cerramientoscubiertas.columns.fachadaprincipalAislamientotermicoTipoId." + Keys.CERRAMIENTOS_FACHADA_PRINCIPAL_AISLAMIENTO_TERMICO_NO, locale) }, { String.valueOf(Keys.CERRAMIENTOS_FACHADA_PRINCIPAL_AISLAMIENTO_TERMICO_SE_DESCONOCE), this.getMessage("forms.cerramientoscubiertas.columns.fachadaprincipalAislamientotermicoTipoId." + Keys.CERRAMIENTOS_FACHADA_PRINCIPAL_AISLAMIENTO_TERMICO_SE_DESCONOCE, locale) }, };

		metaData.getColumn("fachadaprincipalAislamientotermicoTipoId").setSofaStoreValues(fachadaPrincipalAislamientoTermicoStore);

		metaData.getColumn("fachadaprincipalAislamientotermicoTipoId").setEditable(true);
		metaData.getColumn("fachadaprincipalAislamientotermicoTipoId").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("fachadaprincipalCamaraaireTipoId", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("fachadaprincipalCamaraaireTipoId", this.getMessage("forms.cerramientoscubiertas.columns.fachadaprincipalCamaraaireTipoId.header", locale)));
		metaData.getColumn("fachadaprincipalCamaraaireTipoId").setTooltip(this.getMessage("forms.cerramientoscubiertas.columns.fachadaprincipalCamaraaireTipoId.description", locale));
		metaData.getColumn("fachadaprincipalCamaraaireTipoId").setGroupable(false);
		metaData.getColumn("fachadaprincipalCamaraaireTipoId").setSortable(true);
		metaData.getColumn("fachadaprincipalCamaraaireTipoId").setSofaFilter(GridColumnFilter.TYPE_LIST);
		metaData.getColumn("fachadaprincipalCamaraaireTipoId").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] fachadaPrincipalCamaAireStore = new String[][] { { String.valueOf(Keys.CERRAMIENTOS_FACHADA_PRINCIPAL_CAMA_AIRE_SI), this.getMessage("forms.cerramientoscubiertas.columns.fachadaprincipalCamaraaireTipoId." + Keys.CERRAMIENTOS_FACHADA_PRINCIPAL_CAMA_AIRE_SI, locale) }, { String.valueOf(Keys.CERRAMIENTOS_FACHADA_PRINCIPAL_CAMA_AIRE_NO), this.getMessage("forms.cerramientoscubiertas.columns.fachadaprincipalCamaraaireTipoId." + Keys.CERRAMIENTOS_FACHADA_PRINCIPAL_CAMA_AIRE_NO, locale) }, { String.valueOf(Keys.CERRAMIENTOS_FACHADA_PRINCIPAL_CAMA_AIRE_SE_DESCONOCE), this.getMessage("forms.cerramientoscubiertas.columns.fachadaprincipalCamaraaireTipoId." + Keys.CERRAMIENTOS_FACHADA_PRINCIPAL_CAMA_AIRE_SE_DESCONOCE, locale) }, };

		metaData.getColumn("fachadaprincipalCamaraaireTipoId").setSofaStoreValues(fachadaPrincipalCamaAireStore);

		metaData.getColumn("fachadaprincipalCamaraaireTipoId").setEditable(true);
		metaData.getColumn("fachadaprincipalCamaraaireTipoId").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("observaciones", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("observaciones", this.getMessage("forms.cerramientoscubiertas.columns.observaciones.header", locale)));
		metaData.getColumn("observaciones").setGroupable(false);
		metaData.getColumn("observaciones").setSortable(true);
		metaData.getColumn("observaciones").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("observaciones").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("observaciones").setEditable(true);
		metaData.getColumn("observaciones").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("otrasfachadasAcabadorevestidoPorcentaje", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("otrasfachadasAcabadorevestidoPorcentaje", this.getMessage("forms.cerramientoscubiertas.columns.otrasfachadasAcabadorevestidoPorcentaje.header", locale)));
		metaData.getColumn("otrasfachadasAcabadorevestidoPorcentaje").setTooltip(this.getMessage("forms.cerramientoscubiertas.columns.otrasfachadasAcabadorevestidoPorcentaje.description", locale));
		metaData.getColumn("otrasfachadasAcabadorevestidoPorcentaje").setGroupable(false);
		metaData.getColumn("otrasfachadasAcabadorevestidoPorcentaje").setSortable(true);
		metaData.getColumn("otrasfachadasAcabadorevestidoPorcentaje").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("otrasfachadasAcabadorevestidoPorcentaje").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("otrasfachadasAcabadorevestidoPorcentaje").setEditable(true);
		metaData.getColumn("otrasfachadasAcabadorevestidoPorcentaje").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("otrasfachadasAcabadorevestidoTexto", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("otrasfachadasAcabadorevestidoTexto", this.getMessage("forms.cerramientoscubiertas.columns.otrasfachadasAcabadorevestidoTexto.header", locale)));
		metaData.getColumn("otrasfachadasAcabadorevestidoTexto").setTooltip(this.getMessage("forms.cerramientoscubiertas.columns.otrasfachadasAcabadorevestidoTexto.description", locale));
		metaData.getColumn("otrasfachadasAcabadorevestidoTexto").setGroupable(false);
		metaData.getColumn("otrasfachadasAcabadorevestidoTexto").setSortable(true);
		metaData.getColumn("otrasfachadasAcabadorevestidoTexto").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("otrasfachadasAcabadorevestidoTexto").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("otrasfachadasAcabadorevestidoTexto").setEditable(true);
		metaData.getColumn("otrasfachadasAcabadorevestidoTexto").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("otrasfachadasAcabadovistoPorcentaje", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("otrasfachadasAcabadovistoPorcentaje", this.getMessage("forms.cerramientoscubiertas.columns.otrasfachadasAcabadovistoPorcentaje.header", locale)));
		metaData.getColumn("otrasfachadasAcabadovistoPorcentaje").setTooltip(this.getMessage("forms.cerramientoscubiertas.columns.otrasfachadasAcabadovistoPorcentaje.description", locale));
		metaData.getColumn("otrasfachadasAcabadovistoPorcentaje").setGroupable(false);
		metaData.getColumn("otrasfachadasAcabadovistoPorcentaje").setSortable(true);
		metaData.getColumn("otrasfachadasAcabadovistoPorcentaje").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("otrasfachadasAcabadovistoPorcentaje").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("otrasfachadasAcabadovistoPorcentaje").setEditable(true);
		metaData.getColumn("otrasfachadasAcabadovistoPorcentaje").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("otrasfachadasAcabadovistoTexto", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("otrasfachadasAcabadovistoTexto", this.getMessage("forms.cerramientoscubiertas.columns.otrasfachadasAcabadovistoTexto.header", locale)));
		metaData.getColumn("otrasfachadasAcabadovistoTexto").setTooltip(this.getMessage("forms.cerramientoscubiertas.columns.otrasfachadasAcabadovistoTexto.description", locale));
		metaData.getColumn("otrasfachadasAcabadovistoTexto").setGroupable(false);
		metaData.getColumn("otrasfachadasAcabadovistoTexto").setSortable(true);
		metaData.getColumn("otrasfachadasAcabadovistoTexto").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("otrasfachadasAcabadovistoTexto").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("otrasfachadasAcabadovistoTexto").setEditable(true);
		metaData.getColumn("otrasfachadasAcabadovistoTexto").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("otrasfachadasAislamientotermicoTipoId", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("otrasfachadasAislamientotermicoTipoId", this.getMessage("forms.cerramientoscubiertas.columns.otrasfachadasAislamientotermicoTipoId.header", locale)));
		metaData.getColumn("otrasfachadasAislamientotermicoTipoId").setTooltip(this.getMessage("forms.cerramientoscubiertas.columns.otrasfachadasAislamientotermicoTipoId.description", locale));
		metaData.getColumn("otrasfachadasAislamientotermicoTipoId").setGroupable(false);
		metaData.getColumn("otrasfachadasAislamientotermicoTipoId").setSortable(true);
		metaData.getColumn("otrasfachadasAislamientotermicoTipoId").setSofaFilter(GridColumnFilter.TYPE_LIST);
		metaData.getColumn("otrasfachadasAislamientotermicoTipoId").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] otrasFachadasAislamientoTermicoStore = new String[][] { { String.valueOf(Keys.CERRAMIENTOS_FACHADA_OTRAS_FACHADAS_AISLAMIENTO_TERMICO_SI), this.getMessage("forms.cerramientoscubiertas.columns.otrasfachadasAislamientotermicoTipoId." + Keys.CERRAMIENTOS_FACHADA_OTRAS_FACHADAS_AISLAMIENTO_TERMICO_SI, locale) }, { String.valueOf(Keys.CERRAMIENTOS_FACHADA_OTRAS_FACHADAS_AISLAMIENTO_TERMICO_NO), this.getMessage("forms.cerramientoscubiertas.columns.otrasfachadasAislamientotermicoTipoId." + Keys.CERRAMIENTOS_FACHADA_OTRAS_FACHADAS_AISLAMIENTO_TERMICO_NO, locale) }, { String.valueOf(Keys.CERRAMIENTOS_FACHADA_OTRAS_FACHADAS_AISLAMIENTO_TERMICO_SE_DESCONOCE), this.getMessage("forms.cerramientoscubiertas.columns.otrasfachadasAislamientotermicoTipoId." + Keys.CERRAMIENTOS_FACHADA_OTRAS_FACHADAS_AISLAMIENTO_TERMICO_SE_DESCONOCE, locale) }, };

		metaData.getColumn("otrasfachadasAislamientotermicoTipoId").setSofaStoreValues(otrasFachadasAislamientoTermicoStore);

		metaData.getColumn("otrasfachadasAislamientotermicoTipoId").setEditable(true);
		metaData.getColumn("otrasfachadasAislamientotermicoTipoId").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("otrasfachadasCamaraaireTipoId", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("otrasfachadasCamaraaireTipoId", this.getMessage("forms.cerramientoscubiertas.columns.otrasfachadasCamaraaireTipoId.header", locale)));
		metaData.getColumn("otrasfachadasCamaraaireTipoId").setTooltip(this.getMessage("forms.cerramientoscubiertas.columns.otrasfachadasCamaraaireTipoId.description", locale));
		metaData.getColumn("otrasfachadasCamaraaireTipoId").setGroupable(false);
		metaData.getColumn("otrasfachadasCamaraaireTipoId").setSortable(true);
		metaData.getColumn("otrasfachadasCamaraaireTipoId").setSofaFilter(GridColumnFilter.TYPE_LIST);
		metaData.getColumn("otrasfachadasCamaraaireTipoId").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] otrasFachadasCamaraAireStore = new String[][] { { String.valueOf(Keys.CERRAMIENTOS_FACHADA_OTRAS_FACHADAS_CAMA_AIRE_SI), this.getMessage("forms.cerramientoscubiertas.columns.otrasfachadasCamaraaireTipoId." + Keys.CERRAMIENTOS_FACHADA_OTRAS_FACHADAS_CAMA_AIRE_SI, locale) }, { String.valueOf(Keys.CERRAMIENTOS_FACHADA_OTRAS_FACHADAS_CAMA_AIRE_NO), this.getMessage("forms.cerramientoscubiertas.columns.otrasfachadasCamaraaireTipoId." + Keys.CERRAMIENTOS_FACHADA_OTRAS_FACHADAS_CAMA_AIRE_NO, locale) }, { String.valueOf(Keys.CERRAMIENTOS_FACHADA_OTRAS_FACHADAS_CAMA_AIRE_SE_DESCONOCE), this.getMessage("forms.cerramientoscubiertas.columns.otrasfachadasCamaraaireTipoId." + Keys.CERRAMIENTOS_FACHADA_OTRAS_FACHADAS_CAMA_AIRE_SE_DESCONOCE, locale) }, };

		metaData.getColumn("otrasfachadasCamaraaireTipoId").setSofaStoreValues(otrasFachadasCamaraAireStore);

		metaData.getColumn("otrasfachadasCamaraaireTipoId").setEditable(true);
		metaData.getColumn("otrasfachadasCamaraaireTipoId").setHidden(true);

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

		datosExportacion.add("claveInforme", this.getMessage("forms.cerramientoscubiertas.columns.claveInforme.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("inspeccion", this.getMessage("forms.cerramientoscubiertas.columns.inspeccion.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("carpinteriaVidrioPorcentaje", this.getMessage("forms.cerramientoscubiertas.columns.carpinteriaVidrioPorcentaje.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("carpinteriaVidrioSuperficie", this.getMessage("forms.cerramientoscubiertas.columns.carpinteriaVidrioSuperficie.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("carpinteriavidrioCarpinteriapredominanteTexto", this.getMessage("forms.cerramientoscubiertas.columns.carpinteriavidrioCarpinteriapredominanteTexto.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("carpinteriavidrioVidriopredominanteTexto", this.getMessage("forms.cerramientoscubiertas.columns.carpinteriavidrioVidriopredominanteTexto.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("cubiertaInclinadaPorcentaje", this.getMessage("forms.cerramientoscubiertas.columns.cubiertaInclinadaPorcentaje.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("cubiertaInclinadaSuperficie", this.getMessage("forms.cerramientoscubiertas.columns.cubiertaInclinadaSuperficie.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("cubiertaPlanaPorcentaje", this.getMessage("forms.cerramientoscubiertas.columns.cubiertaPlanaPorcentaje.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("cubiertaPlanaSuperficie", this.getMessage("forms.cerramientoscubiertas.columns.cubiertaPlanaSuperficie.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("cubiertainclinadaAislamientotermicoTipoId", this.getMessage("forms.cerramientoscubiertas.columns.cubiertainclinadaAislamientotermicoTipoId.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("cubiertaplanaAislamientotermicoTipoId", this.getMessage("forms.cerramientoscubiertas.columns.cubiertaplanaAislamientotermicoTipoId.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("cubiertaplanaLaminaimpermeabilizanteTipoId", this.getMessage("forms.cerramientoscubiertas.columns.cubiertaplanaLaminaimpermeabilizanteTipoId.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("fachadaPrincipalPorcentaje", this.getMessage("forms.cerramientoscubiertas.columns.fachadaPrincipalPorcentaje.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("fachadaPrincipalSuperficie", this.getMessage("forms.cerramientoscubiertas.columns.fachadaPrincipalSuperficie.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("fachadaprincipalAcabadorevestidoPorcentaje", this.getMessage("forms.cerramientoscubiertas.columns.fachadaprincipalAcabadorevestidoPorcentaje.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("fachadaprincipalAcabadorevestidoTexto", this.getMessage("forms.cerramientoscubiertas.columns.fachadaprincipalAcabadorevestidoTexto.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("fachadaprincipalAcabadovistoPorcentaje", this.getMessage("forms.cerramientoscubiertas.columns.fachadaprincipalAcabadovistoPorcentaje.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("fachadaprincipalAcabadovistoTexto", this.getMessage("forms.cerramientoscubiertas.columns.fachadaprincipalAcabadovistoTexto.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("fachadaprincipalAislamientotermicoTipoId", this.getMessage("forms.cerramientoscubiertas.columns.fachadaprincipalAislamientotermicoTipoId.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("fachadaprincipalCamaraaireTipoId", this.getMessage("forms.cerramientoscubiertas.columns.fachadaprincipalCamaraaireTipoId.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("observaciones", this.getMessage("forms.cerramientoscubiertas.columns.observaciones.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("otrasFachadasPorcentaje", this.getMessage("forms.cerramientoscubiertas.columns.otrasFachadasPorcentaje.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("otrasFachadasSuperficie", this.getMessage("forms.cerramientoscubiertas.columns.otrasFachadasSuperficie.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("otrasfachadasAcabadorevestidoPorcentaje", this.getMessage("forms.cerramientoscubiertas.columns.otrasfachadasAcabadorevestidoPorcentaje.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("otrasfachadasAcabadorevestidoTexto", this.getMessage("forms.cerramientoscubiertas.columns.otrasfachadasAcabadorevestidoTexto.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("otrasfachadasAcabadovistoPorcentaje", this.getMessage("forms.cerramientoscubiertas.columns.otrasfachadasAcabadovistoPorcentaje.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("otrasfachadasAcabadovistoTexto", this.getMessage("forms.cerramientoscubiertas.columns.otrasfachadasAcabadovistoTexto.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("otrasfachadasAislamientotermicoTipoId", this.getMessage("forms.cerramientoscubiertas.columns.otrasfachadasAislamientotermicoTipoId.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("otrasfachadasCamaraaireTipoId", this.getMessage("forms.cerramientoscubiertas.columns.otrasfachadasCamaraaireTipoId.header", locale), TipoCampoExportacion.NUMBER);

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
		CerramientosCubiertasListadoVO instance = (CerramientosCubiertasListadoVO) rawInstance;

		List<String> excelRow = new ArrayList<String>();

		excelRow.add(FormData2Java.toString(instance.getClaveInforme()));
		excelRow.add(FormData2Java.toString(instance.getInspeccionLabel()));
		excelRow.add(instance.getCarpinteriaVidrioPorcentaje());
		excelRow.add(instance.getCarpinteriaVidrioSuperficie());
		excelRow.add(instance.getCarpinteriavidrioCarpinteriapredominanteTexto());
		excelRow.add(instance.getCarpinteriavidrioVidriopredominanteTexto());
		excelRow.add(instance.getCubiertaInclinadaPorcentaje());
		excelRow.add(instance.getCubiertaInclinadaSuperficie());
		excelRow.add(instance.getCubiertaPlanaPorcentaje());
		excelRow.add(instance.getCubiertaPlanaSuperficie());

		//excelRow.add(FormData2Java.toString(instance.getCubiertainclinadaAislamientotermicoTipoId()));
		if (instance.getCubiertainclinadaAislamientotermicoTipoId()!=null){
			excelRow.add( this.getMessage("forms.cerramientoscubiertas.columns.cubiertainclinadaAislamientotermicoTipoId." + instance.getCubiertainclinadaAislamientotermicoTipoId(), locale) );
		}else{
			excelRow.add("null");
		}
		
		//excelRow.add(FormData2Java.toString(instance.getCubiertaplanaAislamientotermicoTipoId()));
		if (instance.getCubiertaplanaAislamientotermicoTipoId()!=null){
			excelRow.add( this.getMessage("forms.cerramientoscubiertas.columns.cubiertaplanaAislamientotermicoTipoId." + instance.getCubiertaplanaAislamientotermicoTipoId(), locale) );
		}else{
			excelRow.add("null");
		}
		
		//excelRow.add(FormData2Java.toString(instance.getCubiertaplanaLaminaimpermeabilizanteTipoId()));
		if (instance.getCubiertaplanaLaminaimpermeabilizanteTipoId()!=null){
			excelRow.add( this.getMessage("forms.cerramientoscubiertas.columns.cubiertaplanaLaminaimpermeabilizanteTipoId." + instance.getCubiertaplanaLaminaimpermeabilizanteTipoId(), locale) );
		}else{
			excelRow.add("null");
		}
		
		excelRow.add(instance.getFachadaPrincipalPorcentaje());
		excelRow.add(FormData2Java.toString(instance.getFachadaPrincipalSuperficie()));
		excelRow.add(instance.getFachadaprincipalAcabadorevestidoPorcentaje());
		excelRow.add(instance.getFachadaprincipalAcabadorevestidoTexto());
		excelRow.add(instance.getFachadaprincipalAcabadovistoPorcentaje());
		excelRow.add(instance.getFachadaprincipalAcabadovistoTexto());
		excelRow.add(FormData2Java.toString(instance.getFachadaprincipalAislamientotermicoTipoId()));
		excelRow.add(FormData2Java.toString(instance.getFachadaprincipalCamaraaireTipoId()));
		excelRow.add(instance.getObservaciones());
		excelRow.add(instance.getOtrasFachadasPorcentaje());
		excelRow.add(instance.getOtrasFachadasSuperficie());
		excelRow.add(instance.getOtrasfachadasAcabadorevestidoPorcentaje());
		excelRow.add(instance.getOtrasfachadasAcabadorevestidoTexto());
		excelRow.add(instance.getOtrasfachadasAcabadovistoPorcentaje());
		excelRow.add(instance.getOtrasfachadasAcabadovistoTexto());
		excelRow.add(FormData2Java.toString(instance.getOtrasfachadasAislamientotermicoTipoId()));
		excelRow.add(FormData2Java.toString(instance.getOtrasfachadasCamaraaireTipoId()));
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
	 * Rellena una instancia de CerramientosCubiertasFormVO con el contenido de
	 * un formulario recibido en formato Map<String, ?>
	 */
	protected void setFormData(CerramientosCubiertasFormVO record, Map<String, ?> formData) throws GenericBusinessException {
		String formDataStr = null;
		if (!StringUtils.isEmpty(formData, "inspeccionId")) {
			formDataStr = (String) formData.get("inspeccionId");
			record.setInspeccionId(FormData2Java.toInteger(formDataStr));

		}
		if (formData.containsKey("carpinteriaVidrioPorcentaje")) {
			formDataStr = (String) formData.get("carpinteriaVidrioPorcentaje");
			record.setCarpinteriaVidrioPorcentaje(formDataStr);
		}
		if (formData.containsKey("carpinteriaVidrioSuperficie")) {
			formDataStr = (String) formData.get("carpinteriaVidrioSuperficie");
			record.setCarpinteriaVidrioSuperficie(formDataStr);
		}
		if (formData.containsKey("carpinteriavidrioCarpinteriapredominanteTexto")) {
			formDataStr = (String) formData.get("carpinteriavidrioCarpinteriapredominanteTexto");
			record.setCarpinteriavidrioCarpinteriapredominanteTexto(formDataStr);
		}
		if (formData.containsKey("carpinteriavidrioVidriopredominanteTexto")) {
			formDataStr = (String) formData.get("carpinteriavidrioVidriopredominanteTexto");
			record.setCarpinteriavidrioVidriopredominanteTexto(formDataStr);
		}
		if (formData.containsKey("cubiertaInclinadaPorcentaje")) {
			formDataStr = (String) formData.get("cubiertaInclinadaPorcentaje");
			record.setCubiertaInclinadaPorcentaje(formDataStr);
		}
		if (formData.containsKey("cubiertaInclinadaSuperficie")) {
			formDataStr = (String) formData.get("cubiertaInclinadaSuperficie");
			record.setCubiertaInclinadaSuperficie(formDataStr);
		}
		if (formData.containsKey("cubiertaPlanaPorcentaje")) {
			formDataStr = (String) formData.get("cubiertaPlanaPorcentaje");
			record.setCubiertaPlanaPorcentaje(formDataStr);
		}
		if (formData.containsKey("cubiertaPlanaSuperficie")) {
			formDataStr = (String) formData.get("cubiertaPlanaSuperficie");
			record.setCubiertaPlanaSuperficie(formDataStr);
		}
		if (formData.containsKey("cubiertainclinadaAislamientotermicoTipoId")) {
			formDataStr = (String) formData.get("cubiertainclinadaAislamientotermicoTipoId");
			record.setCubiertainclinadaAislamientotermicoTipoId(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("cubiertaplanaAislamientotermicoTipoId")) {
			formDataStr = (String) formData.get("cubiertaplanaAislamientotermicoTipoId");
			record.setCubiertaplanaAislamientotermicoTipoId(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("cubiertaplanaLaminaimpermeabilizanteTipoId")) {
			formDataStr = (String) formData.get("cubiertaplanaLaminaimpermeabilizanteTipoId");
			record.setCubiertaplanaLaminaimpermeabilizanteTipoId(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("fachadaPrincipalPorcentaje")) {
			formDataStr = (String) formData.get("fachadaPrincipalPorcentaje");
			record.setFachadaPrincipalPorcentaje(formDataStr);
		}
		if (formData.containsKey("fachadaPrincipalSuperficie")) {
			formDataStr = (String) formData.get("fachadaPrincipalSuperficie");
			record.setFachadaPrincipalSuperficie(new BigDecimal(formDataStr));
		}
		if (formData.containsKey("fachadaprincipalAcabadorevestidoPorcentaje")) {
			formDataStr = (String) formData.get("fachadaprincipalAcabadorevestidoPorcentaje");
			record.setFachadaprincipalAcabadorevestidoPorcentaje(formDataStr);
		}
		if (formData.containsKey("fachadaprincipalAcabadorevestidoTexto")) {
			formDataStr = (String) formData.get("fachadaprincipalAcabadorevestidoTexto");
			record.setFachadaprincipalAcabadorevestidoTexto(formDataStr);
		}
		if (formData.containsKey("fachadaprincipalAcabadovistoPorcentaje")) {
			formDataStr = (String) formData.get("fachadaprincipalAcabadovistoPorcentaje");
			record.setFachadaprincipalAcabadovistoPorcentaje(formDataStr);
		}
		if (formData.containsKey("fachadaprincipalAcabadovistoTexto")) {
			formDataStr = (String) formData.get("fachadaprincipalAcabadovistoTexto");
			record.setFachadaprincipalAcabadovistoTexto(formDataStr);
		}
		if (formData.containsKey("fachadaprincipalAislamientotermicoTipoId")) {
			formDataStr = (String) formData.get("fachadaprincipalAislamientotermicoTipoId");
			record.setFachadaprincipalAislamientotermicoTipoId(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("fachadaprincipalCamaraaireTipoId")) {
			formDataStr = (String) formData.get("fachadaprincipalCamaraaireTipoId");
			record.setFachadaprincipalCamaraaireTipoId(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("observaciones")) {
			formDataStr = (String) formData.get("observaciones");
			record.setObservaciones(formDataStr);
		}
		if (formData.containsKey("otrasFachadasPorcentaje")) {
			formDataStr = (String) formData.get("otrasFachadasPorcentaje");
			record.setOtrasFachadasPorcentaje(formDataStr);
		}
		if (formData.containsKey("otrasFachadasSuperficie")) {
			formDataStr = (String) formData.get("otrasFachadasSuperficie");
			record.setOtrasFachadasSuperficie(formDataStr);
		}
		if (formData.containsKey("otrasfachadasAcabadorevestidoPorcentaje")) {
			formDataStr = (String) formData.get("otrasfachadasAcabadorevestidoPorcentaje");
			record.setOtrasfachadasAcabadorevestidoPorcentaje(formDataStr);
		}
		if (formData.containsKey("otrasfachadasAcabadorevestidoTexto")) {
			formDataStr = (String) formData.get("otrasfachadasAcabadorevestidoTexto");
			record.setOtrasfachadasAcabadorevestidoTexto(formDataStr);
		}
		if (formData.containsKey("otrasfachadasAcabadovistoPorcentaje")) {
			formDataStr = (String) formData.get("otrasfachadasAcabadovistoPorcentaje");
			record.setOtrasfachadasAcabadovistoPorcentaje(formDataStr);
		}
		if (formData.containsKey("otrasfachadasAcabadovistoTexto")) {
			formDataStr = (String) formData.get("otrasfachadasAcabadovistoTexto");
			record.setOtrasfachadasAcabadovistoTexto(formDataStr);
		}
		if (formData.containsKey("otrasfachadasAislamientotermicoTipoId")) {
			formDataStr = (String) formData.get("otrasfachadasAislamientotermicoTipoId");
			record.setOtrasfachadasAislamientotermicoTipoId(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("otrasfachadasCamaraaireTipoId")) {
			formDataStr = (String) formData.get("otrasfachadasCamaraaireTipoId");
			record.setOtrasfachadasCamaraaireTipoId(FormData2Java.toInteger(formDataStr));
		}
	}

}
