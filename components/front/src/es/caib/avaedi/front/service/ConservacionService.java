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
import es.caib.avaedi.logic.bo.ConservacionBO;
import es.caib.avaedi.logic.bo.InspeccionBO;
import es.caib.avaedi.logic.util.Keys;
import es.caib.avaedi.logic.vo.ConservacionFormVO;
import es.caib.avaedi.logic.vo.ConservacionListadoVO;
import es.caib.avaedi.logic.vo.InspeccionListadoVO;

/**
 * Servicio para tratar el formulario: Conservacion
 * 
 * @author agarcia@at4.net
 * 
 */
@Service("conservacion")
public class ConservacionService extends InspeccionBaseService<ConservacionBO, ConservacionListadoVO, ConservacionFormVO> {

	/**
	 * The logger object.
	 */
	private static Logger log = LogService.getLogger(ConservacionService.class);

	/**
	 * Bean para acceder a los métodos de negocio: Conservacion
	 */
	@Autowired
	@Qualifier("ConservacionBean")
	protected ConservacionBO mainBO;

	/**
	 * Bean para acceder a los métodos de negocio: Conservacion
	 * 
	 * @param bean
	 *            the bean to set
	 */
	protected ConservacionBO getMainBO() {
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
			formItem.setText(this.getMessage("forms.conservacion.title", locale));
		}

		GridMetaData metaData = this.getBaseMetaData(formItem, locale);

		//Nombre de la clase js de formulario
		metaData.setFormClassName("ConservacionForm");

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
		 * // Creamos la columna metaData.addColumn( new GridColumnMetaData(
		 * "claveInforme",
		 * this.getMessage("forms.conservacion.columns.claveInforme.header",
		 * locale) ) ); metaData.getColumn("claveInforme").setGroupable( false
		 * ); metaData.getColumn("claveInforme").setSortable( true );
		 * metaData.getColumn("claveInforme").setSofaFilter(
		 * GridColumnFilter.TYPE_NUMERIC );
		 * 
		 * 
		 * 
		 * //Creamos el registro para el record metaData.addRecordField(new
		 * GridRecordFieldMetaData("inspeccionId",
		 * GridRecordFieldMetaData.INT_TYPE)); metaData.addRecordField(new
		 * GridRecordFieldMetaData("inspeccionLabel",
		 * GridRecordFieldMetaData.INT_TYPE)); metaData.addRecordField(new
		 * GridRecordFieldMetaData("inspeccion", "inspeccionLabel",
		 * GridRecordFieldMetaData.INT_TYPE));
		 * 
		 * // Creamos la columna metaData.addColumn( new GridColumnMetaData(
		 * "inspeccion",
		 * this.getMessage("forms.conservacion.columns.inspeccion.header",
		 * locale) ) ); metaData.getColumn("inspeccion").setGroupable( true );
		 * metaData.getColumn("inspeccion").setSortable( true );
		 * metaData.getColumn("inspeccion").setSofaFilter(
		 * GridColumnFilter.TYPE_MULTICOMBO );
		 * metaData.getColumn("inspeccion").setRelatedForm( "Inspeccion" );
		 * 
		 * metaData.getColumn("inspeccion").setEditable( true ) ;
		 * metaData.getColumn("inspeccion").setHidden(true);
		 */

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("tecnico", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("tecnico", this.getMessage("forms.conservacion.columns.tecnico.header", locale)));
		metaData.getColumn("tecnico").setGroupable(false);
		metaData.getColumn("tecnico").setSortable(true);
		metaData.getColumn("tecnico").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("tecnico").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("tecnico").setEditable(true);
		//metaData.getColumn("tecnico").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("titulacion", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("titulacion", this.getMessage("forms.conservacion.columns.titulacion.header", locale)));
		metaData.getColumn("titulacion").setGroupable(false);
		metaData.getColumn("titulacion").setSortable(true);
		metaData.getColumn("titulacion").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("titulacion").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("titulacion").setEditable(true);
		//metaData.getColumn("titulacion").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("nif", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("nif", this.getMessage("forms.conservacion.columns.nif.header", locale)));
		metaData.getColumn("nif").setGroupable(false);
		metaData.getColumn("nif").setSortable(true);
		metaData.getColumn("nif").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("nif").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("nif").setEditable(true);
		//metaData.getColumn("nif").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("esTecnicoInspeccion", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("esTecnicoInspeccion", this.getMessage("forms.conservacion.columns.esTecnicoInspeccion.header", locale)));
		metaData.getColumn("esTecnicoInspeccion").setGroupable(false);
		metaData.getColumn("esTecnicoInspeccion").setSortable(true);
		metaData.getColumn("esTecnicoInspeccion").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("esTecnicoInspeccion").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] esTecnicoInspeccionStore = new String[][] { { String.valueOf(Keys.CONSERVACION_ES_TECNICO_INSPECCION_SI), this.getMessage("forms.conservacion.columns.esTecnicoInspeccion." + Keys.CONSERVACION_ES_TECNICO_INSPECCION_SI, locale) }, { String.valueOf(Keys.CONSERVACION_ES_TECNICO_INSPECCION_NO), this.getMessage("forms.conservacion.columns.esTecnicoInspeccion." + Keys.CONSERVACION_ES_TECNICO_INSPECCION_NO, locale) }, };

		metaData.getColumn("esTecnicoInspeccion").setSofaStoreValues(esTecnicoInspeccionStore);

		metaData.getColumn("esTecnicoInspeccion").setEditable(true);
		//metaData.getColumn("esTecnicoInspeccion").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("conservacionValoracionesTipoId", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("conservacionValoracionesTipoId", this.getMessage("forms.conservacion.columns.conservacionValoracionesTipoId.header", locale)));
		metaData.getColumn("conservacionValoracionesTipoId").setTooltip(this.getMessage("forms.conservacion.columns.conservacionValoracionesTipoId.description", locale));
		metaData.getColumn("conservacionValoracionesTipoId").setGroupable(false);
		metaData.getColumn("conservacionValoracionesTipoId").setSortable(true);
		metaData.getColumn("conservacionValoracionesTipoId").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("conservacionValoracionesTipoId").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] conservacionValoracionesStore = new String[][] { { String.valueOf(Keys.CONSERVACION_VALORACIONES_ID_FAVORABLE), this.getMessage("forms.conservacion.columns.conservacionValoracionesTipoId." + Keys.CONSERVACION_VALORACIONES_ID_FAVORABLE, locale) }, { String.valueOf(Keys.CONSERVACION_VALORACIONES_ID_DESFAVORABLE), this.getMessage("forms.conservacion.columns.conservacionValoracionesTipoId." + Keys.CONSERVACION_VALORACIONES_ID_DESFAVORABLE, locale) }, };

		metaData.getColumn("conservacionValoracionesTipoId").setSofaStoreValues(conservacionValoracionesStore);

		metaData.getColumn("conservacionValoracionesTipoId").setEditable(true);
		metaData.getColumn("conservacionValoracionesTipoId").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("impedimentosVisita", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("impedimentosVisita", this.getMessage("forms.conservacion.columns.impedimentosVisita.header", locale)));
		metaData.getColumn("impedimentosVisita").setGroupable(false);
		metaData.getColumn("impedimentosVisita").setSortable(true);
		metaData.getColumn("impedimentosVisita").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("impedimentosVisita").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("impedimentosVisita").setEditable(true);
		metaData.getColumn("impedimentosVisita").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("fechaEmisionInformeValoracion", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("fechaEmisionInformeValoracion", this.getMessage("forms.conservacion.columns.fechaEmisionInformeValoracion.header", locale)));
		metaData.getColumn("fechaEmisionInformeValoracion").setTooltip(this.getMessage("forms.conservacion.columns.fechaEmisionInformeValoracion.description", locale));
		metaData.getColumn("fechaEmisionInformeValoracion").setGroupable(false);
		metaData.getColumn("fechaEmisionInformeValoracion").setSortable(true);
		metaData.getColumn("fechaEmisionInformeValoracion").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("fechaEmisionInformeValoracion").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("fechaEmisionInformeValoracion").setEditable(true);
		metaData.getColumn("fechaEmisionInformeValoracion").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("medidasSeguridadVisita", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("medidasSeguridadVisita", this.getMessage("forms.conservacion.columns.medidasSeguridadVisita.header", locale)));
		metaData.getColumn("medidasSeguridadVisita").setGroupable(false);
		metaData.getColumn("medidasSeguridadVisita").setSortable(true);
		metaData.getColumn("medidasSeguridadVisita").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("medidasSeguridadVisita").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("medidasSeguridadVisita").setEditable(true);
		metaData.getColumn("medidasSeguridadVisita").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("mediosInspeccion", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("mediosInspeccion", this.getMessage("forms.conservacion.columns.mediosInspeccion.header", locale)));
		metaData.getColumn("mediosInspeccion").setGroupable(false);
		metaData.getColumn("mediosInspeccion").setSortable(true);
		metaData.getColumn("mediosInspeccion").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("mediosInspeccion").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("mediosInspeccion").setEditable(true);
		metaData.getColumn("mediosInspeccion").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("numLocalesInspeccionados", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("numLocalesInspeccionados", this.getMessage("forms.conservacion.columns.numLocalesInspeccionados.header", locale)));
		metaData.getColumn("numLocalesInspeccionados").setGroupable(false);
		metaData.getColumn("numLocalesInspeccionados").setSortable(true);
		metaData.getColumn("numLocalesInspeccionados").setSofaFilter(GridColumnFilter.TYPE_NUMERIC);

		metaData.getColumn("numLocalesInspeccionados").setEditable(true);
		metaData.getColumn("numLocalesInspeccionados").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("numViviendasInspeccionadas", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("numViviendasInspeccionadas", this.getMessage("forms.conservacion.columns.numViviendasInspeccionadas.header", locale)));
		metaData.getColumn("numViviendasInspeccionadas").setGroupable(false);
		metaData.getColumn("numViviendasInspeccionadas").setSortable(true);
		metaData.getColumn("numViviendasInspeccionadas").setSofaFilter(GridColumnFilter.TYPE_NUMERIC);

		metaData.getColumn("numViviendasInspeccionadas").setEditable(true);
		metaData.getColumn("numViviendasInspeccionadas").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("observaciones", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("observaciones", this.getMessage("forms.conservacion.columns.observaciones.header", locale)));
		metaData.getColumn("observaciones").setGroupable(false);
		metaData.getColumn("observaciones").setSortable(true);
		metaData.getColumn("observaciones").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("observaciones").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("observaciones").setEditable(true);
		metaData.getColumn("observaciones").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("pruebasRealizadas", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("pruebasRealizadas", this.getMessage("forms.conservacion.columns.pruebasRealizadas.header", locale)));
		metaData.getColumn("pruebasRealizadas").setGroupable(false);
		metaData.getColumn("pruebasRealizadas").setSortable(true);
		metaData.getColumn("pruebasRealizadas").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("pruebasRealizadas").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("pruebasRealizadas").setEditable(true);
		metaData.getColumn("pruebasRealizadas").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("existePeligroInminente", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("existePeligroInminente", this.getMessage("forms.conservacion.columns.existePeligroInminente.header", locale)));
		metaData.getColumn("existePeligroInminente").setGroupable(false);
		metaData.getColumn("existePeligroInminente").setSortable(true);
		metaData.getColumn("existePeligroInminente").setSofaFilter(GridColumnFilter.TYPE_LIST);

		metaData.getColumn("existePeligroInminente").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] existePeligroInminenteStore = new String[][] { { String.valueOf(Keys.CONSERVACION_PELIGRO_INMINENTE_SI), this.getMessage("forms.conservacion.columns.existePeligroInminente." + Keys.CONSERVACION_PELIGRO_INMINENTE_SI, locale) }, { String.valueOf(Keys.CONSERVACION_PELIGRO_INMINENTE_NO), this.getMessage("forms.conservacion.columns.existePeligroInminente." + Keys.CONSERVACION_PELIGRO_INMINENTE_NO, locale) }, };

		metaData.getColumn("existePeligroInminente").setSofaStoreValues(existePeligroInminenteStore);

		metaData.getColumn("existePeligroInminente").setEditable(true);
		metaData.getColumn("existePeligroInminente").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("descripcionPeligroInminente", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("descripcionPeligroInminente", this.getMessage("forms.conservacion.columns.descripcionPeligroInminente.header", locale)));
		metaData.getColumn("descripcionPeligroInminente").setGroupable(false);
		metaData.getColumn("descripcionPeligroInminente").setSortable(true);
		metaData.getColumn("descripcionPeligroInminente").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("descripcionPeligroInminente").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("descripcionPeligroInminente").setEditable(true);
		metaData.getColumn("descripcionPeligroInminente").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("fechaLimiteActuacion", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("fechaLimiteActuacion", this.getMessage("forms.conservacion.columns.fechaLimiteActuacion.header", locale)));
		metaData.getColumn("fechaLimiteActuacion").setGroupable(false);
		metaData.getColumn("fechaLimiteActuacion").setSortable(true);
		metaData.getColumn("fechaLimiteActuacion").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("fechaLimiteActuacion").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("fechaLimiteActuacion").setEditable(true);
		metaData.getColumn("fechaLimiteActuacion").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("medidas", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("medidas", this.getMessage("forms.conservacion.columns.medidas.header", locale)));
		metaData.getColumn("medidas").setGroupable(false);
		metaData.getColumn("medidas").setSortable(true);
		metaData.getColumn("medidas").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("medidas").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("medidas").setEditable(true);
		metaData.getColumn("medidas").setHidden(true);

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

		datosExportacion.add("claveInforme", this.getMessage("forms.conservacion.columns.claveInforme.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("inspeccion", this.getMessage("forms.conservacion.columns.inspeccion.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("esTecnicoInspeccion", this.getMessage("forms.conservacion.columns.esTecnicoInspeccion.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("conservacionValoracionesTipoId", this.getMessage("forms.conservacion.columns.conservacionValoracionesTipoId.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("impedimentosVisita", this.getMessage("forms.conservacion.columns.impedimentosVisita.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("fechaEmisionInformeValoracion", this.getMessage("forms.conservacion.columns.fechaEmisionInformeValoracion.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("medidasSeguridadVisita", this.getMessage("forms.conservacion.columns.medidasSeguridadVisita.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("mediosInspeccion", this.getMessage("forms.conservacion.columns.mediosInspeccion.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("nif", this.getMessage("forms.conservacion.columns.nif.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("numLocalesInspeccionados", this.getMessage("forms.conservacion.columns.numLocalesInspeccionados.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("numViviendasInspeccionadas", this.getMessage("forms.conservacion.columns.numViviendasInspeccionadas.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("observaciones", this.getMessage("forms.conservacion.columns.observaciones.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("pruebasRealizadas", this.getMessage("forms.conservacion.columns.pruebasRealizadas.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("tecnico", this.getMessage("forms.conservacion.columns.tecnico.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("titulacion", this.getMessage("forms.conservacion.columns.titulacion.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("existePeligroInminente", this.getMessage("forms.conservacion.columns.existePeligroInminente.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("descripcionPeligroInminente", this.getMessage("forms.conservacion.columns.descripcionPeligroInminente.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("fechaLimiteActuacion", this.getMessage("forms.conservacion.columns.fechaLimiteActuacion.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("medidas", this.getMessage("forms.conservacion.columns.medidas.header", locale), TipoCampoExportacion.STRING);

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
		ConservacionListadoVO instance = (ConservacionListadoVO) rawInstance;

		List<String> excelRow = new ArrayList<String>();

		excelRow.add(FormData2Java.toString(instance.getClaveInforme()));
		excelRow.add(FormData2Java.toString(instance.getInspeccionLabel()));

		//excelRow.add(FormData2Java.toString(instance.getEsTecnicoInspeccion()));
		if (instance.getEsTecnicoInspeccion()!=null){
			excelRow.add(this.getMessage("forms.conservacion.columns.esTecnicoInspeccion." + instance.getEsTecnicoInspeccion(), locale));
		}else{
			excelRow.add("null");
		}	

		//excelRow.add(FormData2Java.toString(instance.getConservacionValoracionesTipoId()));
		if (instance.getConservacionValoracionesTipoId()!=null){
			excelRow.add(this.getMessage("forms.conservacion.columns.conservacionValoracionesTipoId." + instance.getConservacionValoracionesTipoId(), locale));
		}else{
			excelRow.add("null");
		}	

		excelRow.add(instance.getImpedimentosVisita());
		excelRow.add(instance.getFechaEmisionInformeValoracion());
		excelRow.add(instance.getMedidasSeguridadVisita());
		excelRow.add(instance.getMediosInspeccion());
		excelRow.add(instance.getNif());
		excelRow.add(FormData2Java.toString(instance.getNumLocalesInspeccionados()));
		excelRow.add(FormData2Java.toString(instance.getNumViviendasInspeccionadas()));
		excelRow.add(instance.getObservaciones());
		excelRow.add(instance.getPruebasRealizadas());
		excelRow.add(instance.getTecnico());
		excelRow.add(instance.getTitulacion());

		//excelRow.add(FormData2Java.toString(instance.getExistePeligroInminente()));
		if (instance.getExistePeligroInminente()!=null){
			excelRow.add(this.getMessage("forms.conservacion.columns.existePeligroInminente." + instance.getExistePeligroInminente(), locale));
		}else{
			excelRow.add("null");
		}	

		excelRow.add(instance.getDescripcionPeligroInminente());
		excelRow.add(instance.getFechaLimiteActuacion());
		excelRow.add(instance.getMedidas());
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
	 * Rellena una instancia de ConservacionFormVO con el contenido de un
	 * formulario recibido en formato Map<String, ?>
	 */
	protected void setFormData(ConservacionFormVO record, Map<String, ?> formData) throws GenericBusinessException {
		String formDataStr = null;
		if (!StringUtils.isEmpty(formData, "inspeccionId")) {
			formDataStr = (String) formData.get("inspeccionId");
			record.setInspeccionId(FormData2Java.toInteger(formDataStr));

		}
		if (formData.containsKey("esTecnicoInspeccion")) {
			formDataStr = (String) formData.get("esTecnicoInspeccion");
			record.setEsTecnicoInspeccion(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("conservacionValoracionesTipoId")) {
			formDataStr = (String) formData.get("conservacionValoracionesTipoId");
			record.setConservacionValoracionesTipoId(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("impedimentosVisita")) {
			formDataStr = (String) formData.get("impedimentosVisita");
			record.setImpedimentosVisita(formDataStr);
		}
		if (formData.containsKey("fechaEmisionInformeValoracion")) {
			formDataStr = (String) formData.get("fechaEmisionInformeValoracion");
			record.setFechaEmisionInformeValoracion(formDataStr);
		}
		if (formData.containsKey("medidasSeguridadVisita")) {
			formDataStr = (String) formData.get("medidasSeguridadVisita");
			record.setMedidasSeguridadVisita(formDataStr);
		}
		if (formData.containsKey("mediosInspeccion")) {
			formDataStr = (String) formData.get("mediosInspeccion");
			record.setMediosInspeccion(formDataStr);
		}
		if (formData.containsKey("nif")) {
			formDataStr = (String) formData.get("nif");
			record.setNif(formDataStr);
		}
		if (formData.containsKey("numLocalesInspeccionados")) {
			formDataStr = (String) formData.get("numLocalesInspeccionados");
			record.setNumLocalesInspeccionados(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("numViviendasInspeccionadas")) {
			formDataStr = (String) formData.get("numViviendasInspeccionadas");
			record.setNumViviendasInspeccionadas(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("observaciones")) {
			formDataStr = (String) formData.get("observaciones");
			record.setObservaciones(formDataStr);
		}
		if (formData.containsKey("pruebasRealizadas")) {
			formDataStr = (String) formData.get("pruebasRealizadas");
			record.setPruebasRealizadas(formDataStr);
		}
		if (formData.containsKey("tecnico")) {
			formDataStr = (String) formData.get("tecnico");
			record.setTecnico(formDataStr);
		}
		if (formData.containsKey("titulacion")) {
			formDataStr = (String) formData.get("titulacion");
			record.setTitulacion(formDataStr);
		}
		if (formData.containsKey("existePeligroInminente")) {
			formDataStr = (String) formData.get("existePeligroInminente");
			record.setExistePeligroInminente(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("descripcionPeligroInminente")) {
			formDataStr = (String) formData.get("descripcionPeligroInminente");
			record.setDescripcionPeligroInminente(formDataStr);
		}
		if (formData.containsKey("fechaLimiteActuacion")) {
			formDataStr = (String) formData.get("fechaLimiteActuacion");
			record.setFechaLimiteActuacion(formDataStr);
		}
		if (formData.containsKey("medidas")) {
			formDataStr = (String) formData.get("medidas");
			record.setMedidas(formDataStr);
		}
	}

}
