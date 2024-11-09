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
import es.caib.avaedi.logic.bo.AcusticaDatosGeneralesBO;
import es.caib.avaedi.logic.bo.InspeccionBO;
import es.caib.avaedi.logic.util.Keys;
import es.caib.avaedi.logic.vo.AcusticaDatosGeneralesFormVO;
import es.caib.avaedi.logic.vo.AcusticaDatosGeneralesListadoVO;
import es.caib.avaedi.logic.vo.CimentacionesListadoVO;

/**
 * Servicio para tratar el formulario: AcusticaDatosGenerales
 * 
 * @author agarcia@at4.net
 * 
 */
@Service("acusticadatosgenerales")
public class AcusticaDatosGeneralesService extends InspeccionBaseService<AcusticaDatosGeneralesBO, AcusticaDatosGeneralesListadoVO, AcusticaDatosGeneralesFormVO> {

	/**
	 * The logger object.
	 */
	private static Logger log = LogService.getLogger(AcusticaDatosGeneralesService.class);

	/**
	 * Bean para acceder a los métodos de negocio: AcusticaDatosGenerales
	 */
	@Autowired
	@Qualifier("AcusticaDatosGeneralesBean")
	protected AcusticaDatosGeneralesBO mainBO;

	/**
	 * Bean para acceder a los métodos de negocio: AcusticaDatosGenerales
	 * 
	 * @param bean
	 *            the bean to set
	 */
	protected AcusticaDatosGeneralesBO getMainBO() {
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
			formItem.setText(this.getMessage("forms.acusticadatosgenerales.title", locale));
		}

		GridMetaData metaData = this.getBaseMetaData(formItem, locale);

		//Nombre de la clase js de formulario
		metaData.setFormClassName("AcusticaDatosGeneralesForm");

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
		 * ("forms.acusticadatosgenerales.columns.claveInforme.header",
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
		 * ("forms.acusticadatosgenerales.columns.inspeccion.header", locale)));
		 * metaData.getColumn("inspeccion").setGroupable(true);
		 * metaData.getColumn("inspeccion").setSortable(true);
		 * metaData.getColumn
		 * ("inspeccion").setSofaFilter(GridColumnFilter.TYPE_MULTICOMBO);
		 * metaData.getColumn("inspeccion").setRelatedForm("Inspeccion");
		 * 
		 * metaData.getColumn("inspeccion").setEditable(true);
		 */
		//forms.general.snnc.0
		String[][] sinoncStore = new String[][]{
				{ String.valueOf(Keys.SNNC_NO), this.getMessage("forms.acusticacomprobaciones.columns.otras." + Keys.SNNC_NO, locale)},
				{ String.valueOf(Keys.SNNC_SI), this.getMessage("forms.acusticacomprobaciones.columns.otras." + Keys.SNNC_SI, locale)},
				{ String.valueOf(Keys.SNNC_NC), this.getMessage("forms.acusticacomprobaciones.columns.otras." + Keys.SNNC_NC, locale)},
		};

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("tipoAreaAcustica", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("tipoAreaAcustica", this.getMessage("forms.acusticadatosgenerales.columns.tipoAreaAcustica.header", locale)));
		metaData.getColumn("tipoAreaAcustica").setGroupable(false);
		metaData.getColumn("tipoAreaAcustica").setSortable(true);
		metaData.getColumn("tipoAreaAcustica").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("tipoAreaAcustica").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("tipoAreaAcustica").setEditable(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("indiceRuidoDia", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("indiceRuidoDia", this.getMessage("forms.acusticadatosgenerales.columns.indiceRuidoDia.header", locale)));
		metaData.getColumn("indiceRuidoDia").setGroupable(false);
		metaData.getColumn("indiceRuidoDia").setSortable(true);
		metaData.getColumn("indiceRuidoDia").setSofaFilter(GridColumnFilter.TYPE_NUMERIC);

		metaData.getColumn("indiceRuidoDia").setEditable(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("objetivoCalidadAcustica", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("objetivoCalidadAcustica", this.getMessage("forms.acusticadatosgenerales.columns.objetivoCalidadAcustica.header", locale)));
		metaData.getColumn("objetivoCalidadAcustica").setGroupable(false);
		metaData.getColumn("objetivoCalidadAcustica").setSortable(true);
		metaData.getColumn("objetivoCalidadAcustica").setSofaFilter(GridColumnFilter.TYPE_NUMERIC);

		metaData.getColumn("objetivoCalidadAcustica").setEditable(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("estudioEspecifico", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("estudioEspecifico", this.getMessage("forms.acusticadatosgenerales.columns.estudioEspecifico.header", locale)));
		metaData.getColumn("estudioEspecifico").setGroupable(false);
		metaData.getColumn("estudioEspecifico").setSortable(true);
		metaData.getColumn("estudioEspecifico").setSofaFilter(GridColumnFilter.TYPE_NUMERIC);

		metaData.getColumn("estudioEspecifico").setEditable(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("fachadasNoExpuestasRuido", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("fachadasNoExpuestasRuido", this.getMessage("forms.acusticadatosgenerales.columns.fachadasNoExpuestasRuido.header", locale)));
		metaData.getColumn("fachadasNoExpuestasRuido").setGroupable(false);
		metaData.getColumn("fachadasNoExpuestasRuido").setSortable(true);
		metaData.getColumn("fachadasNoExpuestasRuido").setSofaFilter(GridColumnFilter.TYPE_LIST);
		metaData.getColumn("fachadasNoExpuestasRuido").setSofaStoreValues(sinoncStore);
		metaData.getColumn("fachadasNoExpuestasRuido").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);

		metaData.getColumn("fachadasNoExpuestasRuido").setEditable(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("zonaRuidoAeronaves", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("zonaRuidoAeronaves", this.getMessage("forms.acusticadatosgenerales.columns.zonaRuidoAeronaves.header", locale)));
		metaData.getColumn("zonaRuidoAeronaves").setGroupable(false);
		metaData.getColumn("zonaRuidoAeronaves").setSortable(true);
		metaData.getColumn("zonaRuidoAeronaves").setSofaFilter(GridColumnFilter.TYPE_LIST);
		metaData.getColumn("zonaRuidoAeronaves").setSofaStoreValues(sinoncStore);
		metaData.getColumn("zonaRuidoAeronaves").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);

		metaData.getColumn("zonaRuidoAeronaves").setEditable(true);
		metaData.getColumn("zonaRuidoAeronaves").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("recintosInstalacionesRecintosHabitables", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("recintosInstalacionesRecintosHabitables", this.getMessage("forms.acusticadatosgenerales.columns.recintosInstalacionesRecintosHabitables.header", locale)));
		metaData.getColumn("recintosInstalacionesRecintosHabitables").setTooltip(this.getMessage("forms.acusticadatosgenerales.columns.recintosInstalacionesRecintosHabitables.description", locale));
		metaData.getColumn("recintosInstalacionesRecintosHabitables").setGroupable(false);
		metaData.getColumn("recintosInstalacionesRecintosHabitables").setSortable(true);
		metaData.getColumn("recintosInstalacionesRecintosHabitables").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("recintosInstalacionesRecintosHabitables").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("recintosInstalacionesRecintosHabitables").setEditable(true);
		metaData.getColumn("recintosInstalacionesRecintosHabitables").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("recintosInstalacionesZonasComunes", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("recintosInstalacionesZonasComunes", this.getMessage("forms.acusticadatosgenerales.columns.recintosInstalacionesZonasComunes.header", locale)));
		metaData.getColumn("recintosInstalacionesZonasComunes").setTooltip(this.getMessage("forms.acusticadatosgenerales.columns.recintosInstalacionesZonasComunes.description", locale));
		metaData.getColumn("recintosInstalacionesZonasComunes").setGroupable(false);
		metaData.getColumn("recintosInstalacionesZonasComunes").setSortable(true);
		metaData.getColumn("recintosInstalacionesZonasComunes").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("recintosInstalacionesZonasComunes").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("recintosInstalacionesZonasComunes").setEditable(true);
		metaData.getColumn("recintosInstalacionesZonasComunes").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("existenRecintosInstalaciones", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("existenRecintosInstalaciones", this.getMessage("forms.acusticadatosgenerales.columns.existenRecintosInstalaciones.header", locale)));
		metaData.getColumn("existenRecintosInstalaciones").setTooltip(this.getMessage("forms.acusticadatosgenerales.columns.existenRecintosInstalaciones.description", locale));
		metaData.getColumn("existenRecintosInstalaciones").setGroupable(false);
		metaData.getColumn("existenRecintosInstalaciones").setSortable(true);
		metaData.getColumn("existenRecintosInstalaciones").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("existenRecintosInstalaciones").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("existenRecintosInstalaciones").setEditable(true);
		metaData.getColumn("existenRecintosInstalaciones").setHidden(true);

		/*
		 * //Creamos el registro para el record metaData.addRecordField(new
		 * GridRecordFieldMetaData("observaciones",
		 * GridRecordFieldMetaData.STRING_TYPE));
		 * 
		 * // Creamos la columna metaData.addColumn(new
		 * GridColumnMetaData("observaciones", this.getMessage(
		 * "forms.acusticadatosgenerales.columns.observaciones.header",
		 * locale))); metaData.getColumn("observaciones").setGroupable(false);
		 * metaData.getColumn("observaciones").setSortable(true);
		 * metaData.getColumn
		 * ("observaciones").setSofaFilter(GridColumnFilter.TYPE_STRING);
		 * 
		 * metaData.getColumn("observaciones").setSofaRenderer(GridColumnMetaData
		 * .RENDERER_LARGETEXT);
		 * 
		 * metaData.getColumn("observaciones").setEditable(true) ;
		 * metaData.getColumn("observaciones").setHidden(true);
		 */

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("recintosProtegidosAscensor", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("recintosProtegidosAscensor", this.getMessage("forms.acusticadatosgenerales.columns.recintosProtegidosAscensor.header", locale)));
		metaData.getColumn("recintosProtegidosAscensor").setGroupable(false);
		metaData.getColumn("recintosProtegidosAscensor").setSortable(true);
		metaData.getColumn("recintosProtegidosAscensor").setSofaFilter(GridColumnFilter.TYPE_LIST);
		metaData.getColumn("recintosProtegidosAscensor").setSofaStoreValues(sinoncStore);
		metaData.getColumn("recintosProtegidosAscensor").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);

		metaData.getColumn("recintosProtegidosAscensor").setEditable(true);
		metaData.getColumn("recintosProtegidosAscensor").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("recintosProtegidosRecintosHabitables", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("recintosProtegidosRecintosHabitables", this.getMessage("forms.acusticadatosgenerales.columns.recintosProtegidosRecintosHabitables.header", locale)));
		metaData.getColumn("recintosProtegidosRecintosHabitables").setTooltip(this.getMessage("forms.acusticadatosgenerales.columns.recintosProtegidosRecintosHabitables.description", locale));
		metaData.getColumn("recintosProtegidosRecintosHabitables").setGroupable(false);
		metaData.getColumn("recintosProtegidosRecintosHabitables").setSortable(true);
		metaData.getColumn("recintosProtegidosRecintosHabitables").setSofaFilter(GridColumnFilter.TYPE_LIST);
		metaData.getColumn("recintosProtegidosRecintosHabitables").setSofaStoreValues(sinoncStore);
		metaData.getColumn("recintosProtegidosRecintosHabitables").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);

		metaData.getColumn("recintosProtegidosRecintosHabitables").setEditable(true);
		metaData.getColumn("recintosProtegidosRecintosHabitables").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("recintosProtegidosRecintosInstalaciones", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("recintosProtegidosRecintosInstalaciones", this.getMessage("forms.acusticadatosgenerales.columns.recintosProtegidosRecintosInstalaciones.header", locale)));
		metaData.getColumn("recintosProtegidosRecintosInstalaciones").setTooltip(this.getMessage("forms.acusticadatosgenerales.columns.recintosProtegidosRecintosInstalaciones.description", locale));
		metaData.getColumn("recintosProtegidosRecintosInstalaciones").setGroupable(false);
		metaData.getColumn("recintosProtegidosRecintosInstalaciones").setSortable(true);
		metaData.getColumn("recintosProtegidosRecintosInstalaciones").setSofaFilter(GridColumnFilter.TYPE_LIST);
		metaData.getColumn("recintosProtegidosRecintosInstalaciones").setSofaStoreValues(sinoncStore);
		metaData.getColumn("recintosProtegidosRecintosInstalaciones").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);

		metaData.getColumn("recintosProtegidosRecintosInstalaciones").setEditable(true);
		metaData.getColumn("recintosProtegidosRecintosInstalaciones").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("recintosProtegidosRecintosProtegidos", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("recintosProtegidosRecintosProtegidos", this.getMessage("forms.acusticadatosgenerales.columns.recintosProtegidosRecintosProtegidos.header", locale)));
		metaData.getColumn("recintosProtegidosRecintosProtegidos").setTooltip(this.getMessage("forms.acusticadatosgenerales.columns.recintosProtegidosRecintosProtegidos.description", locale));
		metaData.getColumn("recintosProtegidosRecintosProtegidos").setGroupable(false);
		metaData.getColumn("recintosProtegidosRecintosProtegidos").setSortable(true);
		metaData.getColumn("recintosProtegidosRecintosProtegidos").setSofaFilter(GridColumnFilter.TYPE_LIST);
		metaData.getColumn("recintosProtegidosRecintosProtegidos").setSofaStoreValues(sinoncStore);
		metaData.getColumn("recintosProtegidosRecintosProtegidos").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);

		metaData.getColumn("recintosProtegidosRecintosProtegidos").setEditable(true);
		metaData.getColumn("recintosProtegidosRecintosProtegidos").setHidden(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("recintosProtegidosZonaComun", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("recintosProtegidosZonaComun", this.getMessage("forms.acusticadatosgenerales.columns.recintosProtegidosZonaComun.header", locale)));
		metaData.getColumn("recintosProtegidosZonaComun").setGroupable(false);
		metaData.getColumn("recintosProtegidosZonaComun").setSortable(true);
		metaData.getColumn("recintosProtegidosZonaComun").setSofaFilter(GridColumnFilter.TYPE_LIST);
		metaData.getColumn("recintosProtegidosZonaComun").setSofaStoreValues(sinoncStore);
		metaData.getColumn("recintosProtegidosZonaComun").setSofaRenderer(GridColumnMetaData.RENDERER_POPUP);

		metaData.getColumn("recintosProtegidosZonaComun").setEditable(true);
		metaData.getColumn("recintosProtegidosZonaComun").setHidden(true);

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

		datosExportacion.add("claveInforme", this.getMessage("forms.acusticadatosgenerales.columns.claveInforme.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("inspeccion", this.getMessage("forms.acusticadatosgenerales.columns.inspeccion.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("estudioEspecifico", this.getMessage("forms.acusticadatosgenerales.columns.estudioEspecifico.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("existenRecintosInstalaciones", this.getMessage("forms.acusticadatosgenerales.columns.existenRecintosInstalaciones.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("fachadasNoExpuestasRuido", this.getMessage("forms.acusticadatosgenerales.columns.fachadasNoExpuestasRuido.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("indiceRuidoDia", this.getMessage("forms.acusticadatosgenerales.columns.indiceRuidoDia.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("objetivoCalidadAcustica", this.getMessage("forms.acusticadatosgenerales.columns.objetivoCalidadAcustica.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("observaciones", this.getMessage("forms.acusticadatosgenerales.columns.observaciones.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("recintosInstalacionesRecintosHabitables", this.getMessage("forms.acusticadatosgenerales.columns.recintosInstalacionesRecintosHabitables.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("recintosInstalacionesZonasComunes", this.getMessage("forms.acusticadatosgenerales.columns.recintosInstalacionesZonasComunes.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("recintosProtegidosAscensor", this.getMessage("forms.acusticadatosgenerales.columns.recintosProtegidosAscensor.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("recintosProtegidosRecintosHabitables", this.getMessage("forms.acusticadatosgenerales.columns.recintosProtegidosRecintosHabitables.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("recintosProtegidosRecintosInstalaciones", this.getMessage("forms.acusticadatosgenerales.columns.recintosProtegidosRecintosInstalaciones.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("recintosProtegidosRecintosProtegidos", this.getMessage("forms.acusticadatosgenerales.columns.recintosProtegidosRecintosProtegidos.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("recintosProtegidosZonaComun", this.getMessage("forms.acusticadatosgenerales.columns.recintosProtegidosZonaComun.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("tipoAreaAcustica", this.getMessage("forms.acusticadatosgenerales.columns.tipoAreaAcustica.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("zonaRuidoAeronaves", this.getMessage("forms.acusticadatosgenerales.columns.zonaRuidoAeronaves.header", locale), TipoCampoExportacion.STRING);

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
		AcusticaDatosGeneralesListadoVO instance = (AcusticaDatosGeneralesListadoVO) rawInstance;

		List<String> excelRow = new ArrayList<String>();

		
		//this.getMessage("forms.acusticacomprobaciones.columns.otras." + Keys.SNNC_NO, locale)
		excelRow.add(FormData2Java.toString(instance.getClaveInforme()));
		excelRow.add(FormData2Java.toString(instance.getInspeccionLabel()));
		excelRow.add(FormData2Java.toString(instance.getEstudioEspecifico()));
		excelRow.add(instance.getExistenRecintosInstalaciones());
		excelRow.add(this.getMessage("forms.acusticacomprobaciones.columns.otras." +FormData2Java.toString(instance.getFachadasNoExpuestasRuido()), locale));
		excelRow.add(FormData2Java.toString(instance.getIndiceRuidoDia()));
		excelRow.add(FormData2Java.toString(instance.getObjetivoCalidadAcustica()));
		excelRow.add(instance.getObservaciones());
		excelRow.add(instance.getRecintosInstalacionesRecintosHabitables());
		excelRow.add(instance.getRecintosInstalacionesZonasComunes());
		excelRow.add(this.getMessage("forms.acusticacomprobaciones.columns.otras." +FormData2Java.toString(instance.getRecintosProtegidosAscensor()), locale));
		excelRow.add(this.getMessage("forms.acusticacomprobaciones.columns.otras." +FormData2Java.toString(instance.getRecintosProtegidosRecintosHabitables()), locale));
		excelRow.add(this.getMessage("forms.acusticacomprobaciones.columns.otras." +FormData2Java.toString(instance.getRecintosProtegidosRecintosInstalaciones()), locale));
		excelRow.add(this.getMessage("forms.acusticacomprobaciones.columns.otras." +FormData2Java.toString(instance.getRecintosProtegidosRecintosProtegidos()), locale));
		excelRow.add(this.getMessage("forms.acusticacomprobaciones.columns.otras." +FormData2Java.toString(instance.getRecintosProtegidosZonaComun()), locale));
		excelRow.add(instance.getTipoAreaAcustica());
		excelRow.add(this.getMessage("forms.acusticacomprobaciones.columns.otras." +FormData2Java.toString(instance.getZonaRuidoAeronaves()), locale));
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
	 * Rellena una instancia de AcusticaDatosGeneralesFormVO con el contenido de
	 * un formulario recibido en formato Map<String, ?>
	 */
	protected void setFormData(AcusticaDatosGeneralesFormVO record, Map<String, ?> formData) throws GenericBusinessException {
		String formDataStr = null;
		if (!StringUtils.isEmpty(formData, "inspeccionId")) {
			formDataStr = (String) formData.get("inspeccionId");
			record.setInspeccionId(FormData2Java.toInteger(formDataStr));

		}
		if (formData.containsKey("estudioEspecifico")) {
			formDataStr = (String) formData.get("estudioEspecifico");
			record.setEstudioEspecifico(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("existenRecintosInstalaciones")) {
			formDataStr = (String) formData.get("existenRecintosInstalaciones");
			record.setExistenRecintosInstalaciones(formDataStr);
		}
		if (formData.containsKey("fachadasNoExpuestasRuido")) {
			formDataStr = (String) formData.get("fachadasNoExpuestasRuido");
			record.setFachadasNoExpuestasRuido(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("indiceRuidoDia")) {
			formDataStr = (String) formData.get("indiceRuidoDia");
			record.setIndiceRuidoDia(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("objetivoCalidadAcustica")) {
			formDataStr = (String) formData.get("objetivoCalidadAcustica");
			record.setObjetivoCalidadAcustica(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("observaciones")) {
			formDataStr = (String) formData.get("observaciones");
			record.setObservaciones(formDataStr);
		}
		if (formData.containsKey("recintosInstalacionesRecintosHabitables")) {
			formDataStr = (String) formData.get("recintosInstalacionesRecintosHabitables");
			record.setRecintosInstalacionesRecintosHabitables(formDataStr);
		}
		if (formData.containsKey("recintosInstalacionesZonasComunes")) {
			formDataStr = (String) formData.get("recintosInstalacionesZonasComunes");
			record.setRecintosInstalacionesZonasComunes(formDataStr);
		}
		if (formData.containsKey("recintosProtegidosAscensor")) {
			formDataStr = (String) formData.get("recintosProtegidosAscensor");
			record.setRecintosProtegidosAscensor(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("recintosProtegidosRecintosHabitables")) {
			formDataStr = (String) formData.get("recintosProtegidosRecintosHabitables");
			record.setRecintosProtegidosRecintosHabitables(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("recintosProtegidosRecintosInstalaciones")) {
			formDataStr = (String) formData.get("recintosProtegidosRecintosInstalaciones");
			record.setRecintosProtegidosRecintosInstalaciones(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("recintosProtegidosRecintosProtegidos")) {
			formDataStr = (String) formData.get("recintosProtegidosRecintosProtegidos");
			record.setRecintosProtegidosRecintosProtegidos(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("recintosProtegidosZonaComun")) {
			formDataStr = (String) formData.get("recintosProtegidosZonaComun");
			record.setRecintosProtegidosZonaComun(FormData2Java.toInteger(formDataStr));
		}
		if (formData.containsKey("tipoAreaAcustica")) {
			formDataStr = (String) formData.get("tipoAreaAcustica");
			record.setTipoAreaAcustica(formDataStr);
		}
		if (formData.containsKey("zonaRuidoAeronaves")) {
			formDataStr = (String) formData.get("zonaRuidoAeronaves");
			record.setZonaRuidoAeronaves(FormData2Java.toInteger(formDataStr));
		}
	}

}
