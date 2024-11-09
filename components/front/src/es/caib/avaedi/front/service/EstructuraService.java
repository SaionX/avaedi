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
import es.caib.avaedi.logic.bo.EstructuraBO;
import es.caib.avaedi.logic.bo.InspeccionBO;
import es.caib.avaedi.logic.vo.EstructuraFormVO;
import es.caib.avaedi.logic.vo.EstructuraListadoVO;
import es.caib.avaedi.logic.vo.InspeccionListadoVO;

/**
 * Servicio para tratar el formulario: Estructura
 * 
 * @author agarcia@at4.net
 * 
 */
@Service("estructura")
public class EstructuraService extends InspeccionBaseService<EstructuraBO, EstructuraListadoVO, EstructuraFormVO> {

	/**
	 * The logger object.
	 */
	private static Logger log = LogService.getLogger(EstructuraService.class);

	/**
	 * Bean para acceder a los métodos de negocio: Estructura
	 */
	@Autowired
	@Qualifier("EstructuraBean")
	protected EstructuraBO mainBO;

	/**
	 * Bean para acceder a los métodos de negocio: Estructura
	 * 
	 * @param bean
	 *            the bean to set
	 */
	protected EstructuraBO getMainBO() {
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
			formItem.setText(this.getMessage("forms.estructura.title", locale));
		}

		GridMetaData metaData = this.getBaseMetaData(formItem, locale);

		//Nombre de la clase js de formulario
		metaData.setFormClassName("EstructuraForm");

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
		//Añadimos el campo de oid al registro (el campo oid es el "object identifier")
		metaData.addRecordField(new GridRecordFieldMetaData("oid", "claveInforme", GridRecordFieldMetaData.INT_TYPE));

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("claveInforme", GridRecordFieldMetaData.INT_TYPE));

		// Creamos la columna
		metaData.addColumn(new GridColumnMetaData("claveInforme", this.getMessage("forms.estructura.columns.claveInforme.header", locale)));
		metaData.getColumn("claveInforme").setGroupable(false);
		metaData.getColumn("claveInforme").setSortable(true);
		metaData.getColumn("claveInforme").setSofaFilter(GridColumnFilter.TYPE_NUMERIC);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("inspeccionId", GridRecordFieldMetaData.INT_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("inspeccionLabel", GridRecordFieldMetaData.INT_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("inspeccion", "inspeccionLabel", GridRecordFieldMetaData.INT_TYPE));

		// Creamos la columna 
		metaData.addColumn(new GridColumnMetaData("inspeccion", this.getMessage("forms.estructura.columns.inspeccion.header", locale)));
		metaData.getColumn("inspeccion").setGroupable(true);
		metaData.getColumn("inspeccion").setSortable(true);
		metaData.getColumn("inspeccion").setSofaFilter(GridColumnFilter.TYPE_MULTICOMBO);
		metaData.getColumn("inspeccion").setRelatedForm("Inspeccion");

		metaData.getColumn("inspeccion").setEditable(true);*/

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("cubiertaForjadoinclinadoTexto", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("cubiertaForjadoinclinadoTexto", this.getMessage("forms.estructura.columns.cubiertaForjadoinclinadoTexto.header", locale)));
		metaData.getColumn("cubiertaForjadoinclinadoTexto").setTooltip(this.getMessage("forms.estructura.columns.cubiertaForjadoinclinadoTexto.description", locale));
		metaData.getColumn("cubiertaForjadoinclinadoTexto").setGroupable(false);
		metaData.getColumn("cubiertaForjadoinclinadoTexto").setSortable(true);
		metaData.getColumn("cubiertaForjadoinclinadoTexto").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("cubiertaForjadoinclinadoTexto").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("cubiertaForjadoinclinadoTexto").setEditable(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("cubiertaOtrosTexto", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("cubiertaOtrosTexto", this.getMessage("forms.estructura.columns.cubiertaOtrosTexto.header", locale)));
		metaData.getColumn("cubiertaOtrosTexto").setGroupable(false);
		metaData.getColumn("cubiertaOtrosTexto").setSortable(true);
		metaData.getColumn("cubiertaOtrosTexto").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("cubiertaOtrosTexto").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("cubiertaOtrosTexto").setEditable(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("horizontalplantatipoOtrosTexto", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("horizontalplantatipoOtrosTexto", this.getMessage("forms.estructura.columns.horizontalplantatipoOtrosTexto.header", locale)));
		metaData.getColumn("horizontalplantatipoOtrosTexto").setTooltip(this.getMessage("forms.estructura.columns.horizontalplantatipoOtrosTexto.description", locale));
		metaData.getColumn("horizontalplantatipoOtrosTexto").setGroupable(false);
		metaData.getColumn("horizontalplantatipoOtrosTexto").setSortable(true);
		metaData.getColumn("horizontalplantatipoOtrosTexto").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("horizontalplantatipoOtrosTexto").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("horizontalplantatipoOtrosTexto").setEditable(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("horizontalsueloOtrosTexto", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("horizontalsueloOtrosTexto", this.getMessage("forms.estructura.columns.horizontalsueloOtrosTexto.header", locale)));
		metaData.getColumn("horizontalsueloOtrosTexto").setGroupable(false);
		metaData.getColumn("horizontalsueloOtrosTexto").setSortable(true);
		metaData.getColumn("horizontalsueloOtrosTexto").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("horizontalsueloOtrosTexto").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("horizontalsueloOtrosTexto").setEditable(true);

		/*//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("observaciones", GridRecordFieldMetaData.STRING_TYPE));

		// Creamos la columna
		metaData.addColumn(new GridColumnMetaData("observaciones", this.getMessage("forms.estructura.columns.observaciones.header", locale)));
		metaData.getColumn("observaciones").setGroupable(false);
		metaData.getColumn("observaciones").setSortable(true);
		metaData.getColumn("observaciones").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("observaciones").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("observaciones").setEditable(true);*/

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("verticalOtros", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("verticalOtros", this.getMessage("forms.estructura.columns.verticalOtros.header", locale)));
		metaData.getColumn("verticalOtros").setGroupable(false);
		metaData.getColumn("verticalOtros").setSortable(true);
		metaData.getColumn("verticalOtros").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("verticalOtros").setEditable(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("verticalOtrosTexto", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("verticalOtrosTexto", this.getMessage("forms.estructura.columns.verticalOtrosTexto.header", locale)));
		metaData.getColumn("verticalOtrosTexto").setGroupable(false);
		metaData.getColumn("verticalOtrosTexto").setSortable(true);
		metaData.getColumn("verticalOtrosTexto").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("verticalOtrosTexto").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("verticalOtrosTexto").setEditable(true);

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

		datosExportacion.add("claveInforme", this.getMessage("forms.estructura.columns.claveInforme.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("inspeccion", this.getMessage("forms.estructura.columns.inspeccion.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("cubiertaForjadoinclinadoTexto", this.getMessage("forms.estructura.columns.cubiertaForjadoinclinadoTexto.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("cubiertaOtrosTexto", this.getMessage("forms.estructura.columns.cubiertaOtrosTexto.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("horizontalplantatipoOtrosTexto", this.getMessage("forms.estructura.columns.horizontalplantatipoOtrosTexto.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("horizontalsueloOtrosTexto", this.getMessage("forms.estructura.columns.horizontalsueloOtrosTexto.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("observaciones", this.getMessage("forms.estructura.columns.observaciones.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("verticalOtros", this.getMessage("forms.estructura.columns.verticalOtros.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("verticalOtrosTexto", this.getMessage("forms.estructura.columns.verticalOtrosTexto.header", locale), TipoCampoExportacion.STRING);

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
		EstructuraListadoVO instance = (EstructuraListadoVO) rawInstance;

		List<String> excelRow = new ArrayList<String>();

		excelRow.add(FormData2Java.toString(instance.getClaveInforme()));
		excelRow.add(FormData2Java.toString(instance.getInspeccionLabel()));
		excelRow.add(instance.getCubiertaForjadoinclinadoTexto());
		excelRow.add(instance.getCubiertaOtrosTexto());
		excelRow.add(instance.getHorizontalplantatipoOtrosTexto());
		excelRow.add(instance.getHorizontalsueloOtrosTexto());
		excelRow.add(instance.getObservaciones());
		excelRow.add(instance.getVerticalOtros());
		excelRow.add(instance.getVerticalOtrosTexto());
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
	 * Rellena una instancia de EstructuraFormVO con el contenido de un
	 * formulario recibido en formato Map<String, ?>
	 */
	protected void setFormData(EstructuraFormVO record, Map<String, ?> formData) throws GenericBusinessException {
		String formDataStr = null;
		if (!StringUtils.isEmpty(formData, "inspeccionId")) {
			formDataStr = (String) formData.get("inspeccionId");
			record.setInspeccionId(FormData2Java.toInteger(formDataStr));

		}
		if (formData.containsKey("cubiertaForjadoinclinadoTexto")) {
			formDataStr = (String) formData.get("cubiertaForjadoinclinadoTexto");
			record.setCubiertaForjadoinclinadoTexto(formDataStr);
		}
		if (formData.containsKey("cubiertaOtrosTexto")) {
			formDataStr = (String) formData.get("cubiertaOtrosTexto");
			record.setCubiertaOtrosTexto(formDataStr);
		}
		if (formData.containsKey("horizontalplantatipoOtrosTexto")) {
			formDataStr = (String) formData.get("horizontalplantatipoOtrosTexto");
			record.setHorizontalplantatipoOtrosTexto(formDataStr);
		}
		if (formData.containsKey("horizontalsueloOtrosTexto")) {
			formDataStr = (String) formData.get("horizontalsueloOtrosTexto");
			record.setHorizontalsueloOtrosTexto(formDataStr);
		}
		if (formData.containsKey("observaciones")) {
			formDataStr = (String) formData.get("observaciones");
			record.setObservaciones(formDataStr);
		}
		if (formData.containsKey("verticalOtros")) {
			formDataStr = (String) formData.get("verticalOtros");
			record.setVerticalOtros(formDataStr);
		}
		if (formData.containsKey("verticalOtrosTexto")) {
			formDataStr = (String) formData.get("verticalOtrosTexto");
			record.setVerticalOtrosTexto(formDataStr);
		}
	}

}
