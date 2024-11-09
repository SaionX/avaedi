package es.caib.avaedi.front.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
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
import es.caib.avaedi.at4forms.common.search.FilterConfig;
import es.caib.avaedi.at4forms.common.search.PagingConfig;
import es.caib.avaedi.at4forms.common.search.ResultadoBusqueda;
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
import es.caib.avaedi.common.realm.Constants;
import es.caib.avaedi.front.config.AuthUtils;
import es.caib.avaedi.front.service.general.BaseService;
import es.caib.avaedi.logic.bo.MunicipioBO;
import es.caib.avaedi.logic.bo.TipoViaBO;
import es.caib.avaedi.logic.bo.ViaBO;
import es.caib.avaedi.logic.vo.AcusticasListadoVO;
import es.caib.avaedi.logic.vo.ViaFormVO;
import es.caib.avaedi.logic.vo.ViaListadoVO;

/**
 * Servicio para tratar el formulario: Via
 * 
 * @author agarcia@at4.net
 * 
 */
@Service("via")
public class ViaService extends BaseService<ViaBO, ViaListadoVO, ViaFormVO> {

	/**
	 * The logger object.
	 */
	private static Logger log = LogService.getLogger(ViaService.class);

	/**
	 * Bean para acceder a los métodos de negocio: Via
	 */
	@Autowired
	@Qualifier("ViaBean")
	protected ViaBO mainBO;

	/**
	 * Bean para acceder a los métodos de negocio: Via
	 * 
	 * @param bean
	 *            the bean to set
	 */
	protected ViaBO getMainBO() {
		return this.mainBO;
	}

	/**
	 * Bean para acceder a los metodos de negocio: TipoVia
	 */
	@Autowired
	@Qualifier("TipoViaBean")
	private TipoViaBO tipoViaBO;

	/**
	 * Bean para acceder a los metodos de negocio: TipoVia
	 * 
	 * @param bean
	 *            the bean to set
	 */
	public void setTipoViaBO(TipoViaBO bean) {
		this.tipoViaBO = bean;
	}

	/**
	 * Bean para acceder a los metodos de negocio: Municipio
	 */
	@Autowired
	@Qualifier("MunicipioBean")
	private MunicipioBO municipioBO;

	/**
	 * Bean para acceder a los metodos de negocio: Municipio
	 * 
	 * @param bean
	 *            the bean to set
	 */
	public void setMunicipioBO(MunicipioBO bean) {
		this.municipioBO = bean;
	}

	@Override
	protected boolean hasPerms(BaseFrontPrincipal usuari, String action, ViaFormVO instance) {

		if (instance != null) {
			//Estamos actuando sobre una instancia en concreto, aquí comprobamos que el usuario tenga acceso al municipio 
			if (!AuthUtils.hasAccess(usuari, instance.getMunicipioId())) {
				return false;
			}
		}

		if (action.equals(PERMS_UPDATE)) {
			return usuari.isInAnyRole(Constants.ADMIN, Constants.OPERADOR, Constants.MUNICIPI);
		} else if (action.equals(PERMS_LIST) || action.equals(PERMS_EXPORT)) {
			return usuari.isInAnyRole(Constants.ADMIN, Constants.OPERADOR, Constants.CONSULTA, Constants.MUNICIPI);
		}

		return false;
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
			formItem.setText(this.getMessage("forms.via.title", locale));
		}

		GridMetaData metaData = new GridMetaData(formItem);

		//Nombre de la clase js de formulario
		metaData.setFormClassName("ViaForm");

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
		metaData.addRecordField(new GridRecordFieldMetaData("oid", "clave", GridRecordFieldMetaData.INT_TYPE));

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("clave", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("clave", this.getMessage("forms.via.columns.clave.header", locale)));
		metaData.getColumn("clave").setGroupable(false);
		metaData.getColumn("clave").setSortable(true);
		metaData.getColumn("clave").setSofaFilter(GridColumnFilter.TYPE_NUMERIC);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("tipoViaId", GridRecordFieldMetaData.INT_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("tipoViaLabel", GridRecordFieldMetaData.STRING_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("tipoVia", "tipoViaLabel", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("tipoVia", this.getMessage("forms.via.columns.tipoVia.header", locale)));
		metaData.getColumn("tipoVia").setGroupable(true);
		metaData.getColumn("tipoVia").setSortable(true);
		metaData.getColumn("tipoVia").setSofaFilter(GridColumnFilter.TYPE_MULTICOMBO);
		metaData.getColumn("tipoVia").setRelatedForm("TipoVia");

		metaData.getColumn("tipoVia").setEditable(false);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("municipioId", GridRecordFieldMetaData.INT_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("municipioLabel", GridRecordFieldMetaData.STRING_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("municipio", "municipioLabel", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("municipio", this.getMessage("forms.via.columns.municipio.header", locale)));
		metaData.getColumn("municipio").setGroupable(true);
		metaData.getColumn("municipio").setSortable(true);
		metaData.getColumn("municipio").setSofaFilter(GridColumnFilter.TYPE_MULTICOMBO);
		metaData.getColumn("municipio").setRelatedForm("Municipio");

		metaData.getColumn("municipio").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("municipio").setEditable(false);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("nombre", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("nombre", this.getMessage("forms.via.columns.nombre.header", locale)));
		metaData.getColumn("nombre").setGroupable(false);
		metaData.getColumn("nombre").setSortable(true);
		metaData.getColumn("nombre").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("nombre").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("nombre").setEditable(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("codigoCatastro", GridRecordFieldMetaData.INT_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("codigoCatastro", this.getMessage("forms.via.columns.codigoCatastro.header", locale)));
		metaData.getColumn("codigoCatastro").setGroupable(false);
		metaData.getColumn("codigoCatastro").setSortable(true);
		metaData.getColumn("codigoCatastro").setSofaFilter(GridColumnFilter.TYPE_NUMERIC);

		metaData.getColumn("codigoCatastro").setEditable(false);

		return metaData;
	}

	@Override
	public ResultadoBusqueda<ViaListadoVO> getListado(Collection<FilterConfig> filters, PagingConfig pagingConfig, BaseFrontPrincipal usuari, Locale locale) throws GenericBusinessException {
		this.addMunicipioFilter(filters, usuari);
		return super.getListado(filters, pagingConfig, usuari, locale);
	}

	private void addMunicipioFilter(Collection<FilterConfig> filters, BaseFrontPrincipal usuari) {
		String municipioId = AuthUtils.municipioId(usuari);
		if (!StringUtils.isEmpty(municipioId)) {

			//Añadimos el filtro de tipos de contrato
			filters.add(new FilterConfig(FilterConfig.TYPE_AUTO, "municipio", municipioId));

		}

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

		datosExportacion.add("clave", this.getMessage("forms.via.columns.clave.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("tipoVia", this.getMessage("forms.via.columns.tipoVia.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("municipio", this.getMessage("forms.via.columns.municipio.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("nombre", this.getMessage("forms.via.columns.nombre.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("codigoCatastro", this.getMessage("forms.via.columns.codigoCatastro.header", locale), TipoCampoExportacion.NUMBER);

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
		ViaListadoVO instance = (ViaListadoVO) rawInstance;

		List<String> excelRow = new ArrayList<String>();

		excelRow.add(FormData2Java.toString(instance.getClave()));
		excelRow.add(instance.getTipoViaLabel());
		excelRow.add(instance.getMunicipioLabel());
		excelRow.add(instance.getNombre());
		excelRow.add(FormData2Java.toString(instance.getCodigoCatastro()));
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
	 * Rellena una instancia de ViaFormVO con el contenido de un formulario
	 * recibido en formato Map<String, ?>
	 */
	protected void setFormData(ViaFormVO record, Map<String, ?> formData) throws GenericBusinessException {
		String formDataStr = null;
		/*if (FormData2Java.needsUpdate(formData, "tipoViaId")) {
			formDataStr = (String) formData.get("tipoViaId");
			record.setTipoViaId(FormData2Java.toInteger(formDataStr));

		}
		if (FormData2Java.needsUpdate(formData, "municipioId")) {
			formDataStr = (String) formData.get("municipioId");
			record.setMunicipioId(FormData2Java.toInteger(formDataStr));

		}*/
		if (FormData2Java.needsUpdate(formData, "nombre")) {
			formDataStr = (String) formData.get("nombre");
			record.setNombre(formDataStr);
		}
		/*if (FormData2Java.needsUpdate(formData, "codigoCatastro")) {
			formDataStr = (String) formData.get("codigoCatastro");
			record.setCodigoCatastro(FormData2Java.toInteger(formDataStr));
		}*/
	}

}
