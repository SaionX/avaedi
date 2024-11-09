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
import es.caib.avaedi.common.model.AcusticaMejorasAcusticasId;
import es.caib.avaedi.front.service.general.InspeccionBaseService;
import es.caib.avaedi.logic.bo.AcusticaMejorasAcusticasBO;
import es.caib.avaedi.logic.bo.InspeccionBO;
import es.caib.avaedi.logic.util.Keys;
import es.caib.avaedi.logic.vo.AcusticaMejorasAcusticasFormVO;
import es.caib.avaedi.logic.vo.AcusticaMejorasAcusticasListadoVO;
import es.caib.avaedi.logic.vo.CimentacionesListadoVO;

/**
 * Servicio para tratar el formulario: AcusticaMejorasAcusticas
 * 
 * @author agarcia@at4.net
 * 
 */
@Service("acusticamejorasacusticas")
public class AcusticaMejorasAcusticasService extends InspeccionBaseService<AcusticaMejorasAcusticasBO, AcusticaMejorasAcusticasListadoVO, AcusticaMejorasAcusticasFormVO> {

	/**
	 * The logger object.
	 */
	private static Logger log = LogService.getLogger(AcusticaMejorasAcusticasService.class);

	/**
	 * Bean para acceder a los métodos de negocio: AcusticaMejorasAcusticas
	 */
	@Autowired
	@Qualifier("AcusticaMejorasAcusticasBean")
	protected AcusticaMejorasAcusticasBO mainBO;

	/**
	 * Bean para acceder a los métodos de negocio: AcusticaMejorasAcusticas
	 * 
	 * @param bean
	 *            the bean to set
	 */
	protected AcusticaMejorasAcusticasBO getMainBO() {
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
			formItem.setText(this.getMessage("forms.acusticamejorasacusticas.title", locale));
		}

		GridMetaData metaData = this.getBaseMetaData(formItem, locale);
		
		//Nombre de la clase js de formulario
		metaData.setFormClassName("AcusticaMejorasAcusticasForm");

		//Nombre de la clase js de listado
		metaData.setListClassName("ListadoGrid");

		//Configurar las acciones posibles según los permisos
		metaData.setShowNewButton(this.hasPerms(usuari, PERMS_ADD));
		metaData.setShowDeleteButton(this.hasPerms(usuari, PERMS_DELETE));
		metaData.setShowUpdateButton(this.hasPerms(usuari, PERMS_UPDATE));
		metaData.setShowExportControls(this.hasPerms(usuari, PERMS_EXPORT));

		//TODO: desactivar si no se quiere hacer grid editable
		metaData.setEditable(this.hasPerms(usuari, PERMS_UPDATE));

		//Sobre escribimos un par de campos del Base
		//Clave compuesta
		metaData.getRecordField("oid").setMapping("id.claveInforme+'|'+raw.id.mejorasOrden");
		metaData.getRecordField("oid").setType(GridRecordFieldMetaData.STRING_TYPE);
		
		//Clave informe
		metaData.getRecordField("claveInforme").setMapping("id.claveInforme");
		
		
		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("mejorasOrden", "id.mejorasOrden", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("mejorasOrden", this.getMessage("forms.acusticamejorasacusticas.columns.mejorasOrden.header", locale)));
		metaData.getColumn("mejorasOrden").setGroupable(false);
		metaData.getColumn("mejorasOrden").setSortable(true);
		metaData.getColumn("mejorasOrden").setSofaFilter(GridColumnFilter.TYPE_NUMERIC);

		metaData.getColumn("mejorasOrden").setEditable(true);

		
		
		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("proteccionRuidoExteriorTipoId", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("proteccionRuidoExteriorTipoId", this.getMessage("forms.acusticamejorasacusticas.columns.proteccionRuidoExteriorTipoId.header", locale)));
		metaData.getColumn("proteccionRuidoExteriorTipoId").setTooltip(this.getMessage("forms.acusticamejorasacusticas.columns.proteccionRuidoExteriorTipoId.description", locale));
		metaData.getColumn("proteccionRuidoExteriorTipoId").setGroupable(false);
		metaData.getColumn("proteccionRuidoExteriorTipoId").setSortable(true);
		metaData.getColumn("proteccionRuidoExteriorTipoId").setSofaFilter(GridColumnFilter.TYPE_LIST);
		
		metaData.getColumn("proteccionRuidoExteriorTipoId").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] proteccionRuidoExteriorTipoIdStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_MEJORAS_DEFICIENTE), this.getMessage("forms.acusticamejorasacusticas.columns.proteccionRuidoExteriorTipoId." + Keys.ACUSTICA_MEJORAS_DEFICIENTE, locale)},
				{ String.valueOf(Keys.ACUSTICA_MEJORAS_REGULAR), this.getMessage("forms.acusticamejorasacusticas.columns.proteccionRuidoExteriorTipoId." + Keys.ACUSTICA_MEJORAS_REGULAR, locale)},
				{ String.valueOf(Keys.ACUSTICA_MEJORAS_RAZONABLE), this.getMessage("forms.acusticamejorasacusticas.columns.proteccionRuidoExteriorTipoId." + Keys.ACUSTICA_MEJORAS_RAZONABLE, locale)},
				{ String.valueOf(Keys.ACUSTICA_MEJORAS_BUENO), this.getMessage("forms.acusticamejorasacusticas.columns.proteccionRuidoExteriorTipoId." + Keys.ACUSTICA_MEJORAS_BUENO, locale)},
		};

		metaData.getColumn("proteccionRuidoExteriorTipoId").setSofaStoreValues(proteccionRuidoExteriorTipoIdStore);

		metaData.getColumn("proteccionRuidoExteriorTipoId").setEditable(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("mejorasAnalisisTecnico", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("mejorasAnalisisTecnico", this.getMessage("forms.acusticamejorasacusticas.columns.mejorasAnalisisTecnico.header", locale)));
		metaData.getColumn("mejorasAnalisisTecnico").setGroupable(false);
		metaData.getColumn("mejorasAnalisisTecnico").setSortable(true);
		metaData.getColumn("mejorasAnalisisTecnico").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("mejorasAnalisisTecnico").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("mejorasAnalisisTecnico").setEditable(true);
		metaData.getColumn("mejorasAnalisisTecnico").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("proteccionRuidoInstalacionesTipoId", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("proteccionRuidoInstalacionesTipoId", this.getMessage("forms.acusticamejorasacusticas.columns.proteccionRuidoInstalacionesTipoId.header", locale)));
		metaData.getColumn("proteccionRuidoInstalacionesTipoId").setTooltip(this.getMessage("forms.acusticamejorasacusticas.columns.proteccionRuidoInstalacionesTipoId.description", locale));
		metaData.getColumn("proteccionRuidoInstalacionesTipoId").setGroupable(false);
		metaData.getColumn("proteccionRuidoInstalacionesTipoId").setSortable(true);
		metaData.getColumn("proteccionRuidoInstalacionesTipoId").setSofaFilter(GridColumnFilter.TYPE_LIST);
		
		metaData.getColumn("proteccionRuidoInstalacionesTipoId").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] proteccionRuidoInstalacionesTipoIdStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_MEJORAS_DEFICIENTE), this.getMessage("forms.acusticamejorasacusticas.columns.proteccionRuidoInstalacionesTipoId." + Keys.ACUSTICA_MEJORAS_DEFICIENTE, locale)},
				{ String.valueOf(Keys.ACUSTICA_MEJORAS_REGULAR), this.getMessage("forms.acusticamejorasacusticas.columns.proteccionRuidoInstalacionesTipoId." + Keys.ACUSTICA_MEJORAS_REGULAR, locale)},
				{ String.valueOf(Keys.ACUSTICA_MEJORAS_RAZONABLE), this.getMessage("forms.acusticamejorasacusticas.columns.proteccionRuidoInstalacionesTipoId." + Keys.ACUSTICA_MEJORAS_RAZONABLE, locale)},
				{ String.valueOf(Keys.ACUSTICA_MEJORAS_BUENO), this.getMessage("forms.acusticamejorasacusticas.columns.proteccionRuidoInstalacionesTipoId." + Keys.ACUSTICA_MEJORAS_BUENO, locale)},
		};

		metaData.getColumn("proteccionRuidoInstalacionesTipoId").setSofaStoreValues(proteccionRuidoInstalacionesTipoIdStore);

		metaData.getColumn("proteccionRuidoInstalacionesTipoId").setEditable(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("mejorasDescripcion", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("mejorasDescripcion", this.getMessage("forms.acusticamejorasacusticas.columns.mejorasDescripcion.header", locale)));
		metaData.getColumn("mejorasDescripcion").setGroupable(false);
		metaData.getColumn("mejorasDescripcion").setSortable(true);
		metaData.getColumn("mejorasDescripcion").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("mejorasDescripcion").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("mejorasDescripcion").setEditable(true);
		metaData.getColumn("mejorasDescripcion").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("proteccionRuidoInteriorAereoTipoId", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("proteccionRuidoInteriorAereoTipoId", this.getMessage("forms.acusticamejorasacusticas.columns.proteccionRuidoInteriorAereoTipoId.header", locale)));
		metaData.getColumn("proteccionRuidoInteriorAereoTipoId").setTooltip(this.getMessage("forms.acusticamejorasacusticas.columns.proteccionRuidoInteriorAereoTipoId.description", locale));
		metaData.getColumn("proteccionRuidoInteriorAereoTipoId").setGroupable(false);
		metaData.getColumn("proteccionRuidoInteriorAereoTipoId").setSortable(true);
		metaData.getColumn("proteccionRuidoInteriorAereoTipoId").setSofaFilter(GridColumnFilter.TYPE_LIST);
		
		metaData.getColumn("proteccionRuidoInteriorAereoTipoId").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] proteccionRuidoInteriorAereoTipoIdStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_MEJORAS_DEFICIENTE), this.getMessage("forms.acusticamejorasacusticas.columns.proteccionRuidoInteriorAereoTipoId." + Keys.ACUSTICA_MEJORAS_DEFICIENTE, locale)},
				{ String.valueOf(Keys.ACUSTICA_MEJORAS_REGULAR), this.getMessage("forms.acusticamejorasacusticas.columns.proteccionRuidoInteriorAereoTipoId." + Keys.ACUSTICA_MEJORAS_REGULAR, locale)},
				{ String.valueOf(Keys.ACUSTICA_MEJORAS_RAZONABLE), this.getMessage("forms.acusticamejorasacusticas.columns.proteccionRuidoInteriorAereoTipoId." + Keys.ACUSTICA_MEJORAS_RAZONABLE, locale)},
				{ String.valueOf(Keys.ACUSTICA_MEJORAS_BUENO), this.getMessage("forms.acusticamejorasacusticas.columns.proteccionRuidoInteriorAereoTipoId." + Keys.ACUSTICA_MEJORAS_BUENO, locale)},
		};

		metaData.getColumn("proteccionRuidoInteriorAereoTipoId").setSofaStoreValues(proteccionRuidoInteriorAereoTipoIdStore);

		metaData.getColumn("proteccionRuidoInteriorAereoTipoId").setEditable(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("mejorasObservaciones", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("mejorasObservaciones", this.getMessage("forms.acusticamejorasacusticas.columns.mejorasObservaciones.header", locale)));
		metaData.getColumn("mejorasObservaciones").setGroupable(false);
		metaData.getColumn("mejorasObservaciones").setSortable(true);
		metaData.getColumn("mejorasObservaciones").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("mejorasObservaciones").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("mejorasObservaciones").setEditable(true);
		metaData.getColumn("mejorasObservaciones").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("proteccionRuidoInteriorImpactosTipoId", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("proteccionRuidoInteriorImpactosTipoId", this.getMessage("forms.acusticamejorasacusticas.columns.proteccionRuidoInteriorImpactosTipoId.header", locale)));
		metaData.getColumn("proteccionRuidoInteriorImpactosTipoId").setTooltip(this.getMessage("forms.acusticamejorasacusticas.columns.proteccionRuidoInteriorImpactosTipoId.description", locale));
		metaData.getColumn("proteccionRuidoInteriorImpactosTipoId").setGroupable(false);
		metaData.getColumn("proteccionRuidoInteriorImpactosTipoId").setSortable(true);
		metaData.getColumn("proteccionRuidoInteriorImpactosTipoId").setSofaFilter(GridColumnFilter.TYPE_LIST);
		
		metaData.getColumn("proteccionRuidoInteriorImpactosTipoId").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);
		String[][] proteccionRuidoInteriorImpactosTipoIdStore = new String[][]{
				{ String.valueOf(Keys.ACUSTICA_MEJORAS_DEFICIENTE), this.getMessage("forms.acusticamejorasacusticas.columns.proteccionRuidoInteriorImpactosTipoId." + Keys.ACUSTICA_MEJORAS_DEFICIENTE, locale)},
				{ String.valueOf(Keys.ACUSTICA_MEJORAS_REGULAR), this.getMessage("forms.acusticamejorasacusticas.columns.proteccionRuidoInteriorImpactosTipoId." + Keys.ACUSTICA_MEJORAS_REGULAR, locale)},
				{ String.valueOf(Keys.ACUSTICA_MEJORAS_RAZONABLE), this.getMessage("forms.acusticamejorasacusticas.columns.proteccionRuidoInteriorImpactosTipoId." + Keys.ACUSTICA_MEJORAS_RAZONABLE, locale)},
				{ String.valueOf(Keys.ACUSTICA_MEJORAS_BUENO), this.getMessage("forms.acusticamejorasacusticas.columns.proteccionRuidoInteriorImpactosTipoId." + Keys.ACUSTICA_MEJORAS_BUENO, locale)},
		};

		metaData.getColumn("proteccionRuidoInteriorImpactosTipoId").setSofaStoreValues(proteccionRuidoInteriorImpactosTipoIdStore);

		metaData.getColumn("proteccionRuidoInteriorImpactosTipoId").setEditable(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("mejorasValoracionEconomica", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("mejorasValoracionEconomica", this.getMessage("forms.acusticamejorasacusticas.columns.mejorasValoracionEconomica.header", locale)));
		metaData.getColumn("mejorasValoracionEconomica").setGroupable(false);
		metaData.getColumn("mejorasValoracionEconomica").setSortable(true);
		metaData.getColumn("mejorasValoracionEconomica").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("mejorasValoracionEconomica").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("mejorasValoracionEconomica").setEditable(true);
		metaData.getColumn("mejorasValoracionEconomica").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("potencialObservaciones", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("potencialObservaciones", this.getMessage("forms.acusticamejorasacusticas.columns.potencialObservaciones.header", locale)));
		metaData.getColumn("potencialObservaciones").setGroupable(false);
		metaData.getColumn("potencialObservaciones").setSortable(true);
		metaData.getColumn("potencialObservaciones").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("potencialObservaciones").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("potencialObservaciones").setEditable(true);
		metaData.getColumn("potencialObservaciones").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("incidenciaObservaciones", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("incidenciaObservaciones", this.getMessage("forms.acusticamejorasacusticas.columns.incidenciaObservaciones.header", locale)));
		metaData.getColumn("incidenciaObservaciones").setGroupable(false);
		metaData.getColumn("incidenciaObservaciones").setSortable(true);
		metaData.getColumn("incidenciaObservaciones").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("incidenciaObservaciones").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("incidenciaObservaciones").setEditable(true);
		metaData.getColumn("incidenciaObservaciones").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("incidenciaTexto", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("incidenciaTexto", this.getMessage("forms.acusticamejorasacusticas.columns.incidenciaTexto.header", locale)));
		metaData.getColumn("incidenciaTexto").setGroupable(false);
		metaData.getColumn("incidenciaTexto").setSortable(true);
		metaData.getColumn("incidenciaTexto").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("incidenciaTexto").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("incidenciaTexto").setEditable(true);
		metaData.getColumn("incidenciaTexto").setHidden(true);
		
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

		datosExportacion.add("claveInforme", this.getMessage("forms.acusticamejorasacusticas.columns.claveInforme.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("inspeccion", this.getMessage("forms.acusticamejorasacusticas.columns.inspeccion.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("proteccionRuidoExteriorTipoId", this.getMessage("forms.acusticamejorasacusticas.columns.proteccionRuidoExteriorTipoId.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("mejorasAnalisisTecnico", this.getMessage("forms.acusticamejorasacusticas.columns.mejorasAnalisisTecnico.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("proteccionRuidoInstalacionesTipoId", this.getMessage("forms.acusticamejorasacusticas.columns.proteccionRuidoInstalacionesTipoId.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("mejorasDescripcion", this.getMessage("forms.acusticamejorasacusticas.columns.mejorasDescripcion.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("proteccionRuidoInteriorAereoTipoId", this.getMessage("forms.acusticamejorasacusticas.columns.proteccionRuidoInteriorAereoTipoId.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("mejorasObservaciones", this.getMessage("forms.acusticamejorasacusticas.columns.mejorasObservaciones.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("proteccionRuidoInteriorImpactosTipoId", this.getMessage("forms.acusticamejorasacusticas.columns.proteccionRuidoInteriorImpactosTipoId.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("mejorasOrden", this.getMessage("forms.acusticamejorasacusticas.columns.mejorasOrden.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("mejorasValoracionEconomica", this.getMessage("forms.acusticamejorasacusticas.columns.mejorasValoracionEconomica.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("potencialObservaciones", this.getMessage("forms.acusticamejorasacusticas.columns.potencialObservaciones.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("incidenciaObservaciones", this.getMessage("forms.acusticamejorasacusticas.columns.incidenciaObservaciones.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("incidenciaTexto", this.getMessage("forms.acusticamejorasacusticas.columns.incidenciaTexto.header", locale), TipoCampoExportacion.STRING);

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
		AcusticaMejorasAcusticasListadoVO instance = (AcusticaMejorasAcusticasListadoVO) rawInstance;

		List<String> excelRow = new ArrayList<String>();

		excelRow.add(FormData2Java.toString(instance.getId().getClaveInforme()));
		excelRow.add(FormData2Java.toString(instance.getInspeccionLabel()));
		excelRow.add(FormData2Java.toString(instance.getProteccionRuidoExteriorTipoId()));
		excelRow.add(instance.getMejorasAnalisisTecnico());
		excelRow.add(FormData2Java.toString(instance.getProteccionRuidoInstalacionesTipoId()));
		excelRow.add(instance.getMejorasDescripcion());
		excelRow.add(FormData2Java.toString(instance.getProteccionRuidoInteriorAereoTipoId()));
		excelRow.add(instance.getMejorasObservaciones());
		excelRow.add(FormData2Java.toString(instance.getProteccionRuidoInteriorImpactosTipoId()));
		excelRow.add(FormData2Java.toString(instance.getId().getMejorasOrden()));
		excelRow.add(instance.getMejorasValoracionEconomica());
		excelRow.add(instance.getPotencialObservaciones());
		excelRow.add(instance.getIncidenciaObservaciones());
		excelRow.add(instance.getIncidenciaTexto());
		excelRow.add(FormData2Java.toString(instance.getDateCreation()));
		excelRow.add(FormData2Java.toString(instance.getLastModified()));
		excelRow.add(instance.getCreatorUser());
		excelRow.add(instance.getModUser());

		return excelRow;

	}

	@Override
	public Serializable toSerializableId(String id) {
		
		return AcusticaMejorasAcusticasId.fromString(id);
		
	}

	@Override
	public String fromSerializableId(Serializable id) {
		
		return id.toString();
		
	}

	/**
	 * Rellena una instancia de AcusticaMejorasAcusticasFormVO con el contenido
	 * de un formulario recibido en formato Map<String, ?>
	 */
	protected void setFormData(AcusticaMejorasAcusticasFormVO record, Map<String, ?> formData) throws GenericBusinessException {
		String formDataStr = null;
		if (!StringUtils.isEmpty(formData, "inspeccionId")) {
			formDataStr = (String) formData.get("inspeccionId");
			record.setInspeccionId(FormData2Java.toInteger(formDataStr));

		}
		if (formData.containsKey("proteccionRuidoExteriorTipoId")) {
			formDataStr = (String) formData.get("proteccionRuidoExteriorTipoId");
			record.setProteccionRuidoExteriorTipoId(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("mejorasAnalisisTecnico")) {
			formDataStr = (String) formData.get("mejorasAnalisisTecnico");
			record.setMejorasAnalisisTecnico(formDataStr);
		}
		if (formData.containsKey("proteccionRuidoInstalacionesTipoId")) {
			formDataStr = (String) formData.get("proteccionRuidoInstalacionesTipoId");
			record.setProteccionRuidoInstalacionesTipoId(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("mejorasDescripcion")) {
			formDataStr = (String) formData.get("mejorasDescripcion");
			record.setMejorasDescripcion(formDataStr);
		}
		if (formData.containsKey("proteccionRuidoInteriorAereoTipoId")) {
			formDataStr = (String) formData.get("proteccionRuidoInteriorAereoTipoId");
			record.setProteccionRuidoInteriorAereoTipoId(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("mejorasObservaciones")) {
			formDataStr = (String) formData.get("mejorasObservaciones");
			record.setMejorasObservaciones(formDataStr);
		}
		if (formData.containsKey("proteccionRuidoInteriorImpactosTipoId")) {
			formDataStr = (String) formData.get("proteccionRuidoInteriorImpactosTipoId");
			record.setProteccionRuidoInteriorImpactosTipoId(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("mejorasValoracionEconomica")) {
			formDataStr = (String) formData.get("mejorasValoracionEconomica");
			record.setMejorasValoracionEconomica(formDataStr);
		}
		if (formData.containsKey("potencialObservaciones")) {
			formDataStr = (String) formData.get("potencialObservaciones");
			record.setPotencialObservaciones(formDataStr);
		}
		if (formData.containsKey("incidenciaObservaciones")) {
			formDataStr = (String) formData.get("incidenciaObservaciones");
			record.setIncidenciaObservaciones(formDataStr);
		}
		if (formData.containsKey("incidenciaTexto")) {
			formDataStr = (String) formData.get("incidenciaTexto");
			record.setIncidenciaTexto(formDataStr);
		}
	}

}
