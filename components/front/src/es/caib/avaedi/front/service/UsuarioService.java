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
import es.caib.avaedi.at4forms.common.search.ResultadoActualizacion;
import es.caib.avaedi.at4forms.common.search.TipoCampoExportacion;
import es.caib.avaedi.at4forms.common.util.FormData2Java;
import es.caib.avaedi.at4forms.common.util.log.LogService;
import es.caib.avaedi.at4forms.front.items.FormItem;
import es.caib.avaedi.at4forms.front.service.items.GridColumnFilter;
import es.caib.avaedi.at4forms.front.service.items.GridColumnMetaData;
import es.caib.avaedi.at4forms.front.service.items.GridMetaData;
import es.caib.avaedi.at4forms.front.service.items.GridRecordFieldMetaData;
import es.caib.avaedi.at4forms.logic.vo.ListadoVO;
import es.caib.avaedi.common.realm.Constants;
import es.caib.avaedi.front.service.general.BaseService;
import es.caib.avaedi.logic.bo.MunicipioBO;
import es.caib.avaedi.logic.bo.UsuarioBO;
import es.caib.avaedi.logic.vo.AcusticasListadoVO;
import es.caib.avaedi.logic.vo.UsuarioFormVO;
import es.caib.avaedi.logic.vo.UsuarioListadoVO;

/**
 * Servicio para tratar el formulario: Usuario
 * 
 * @author agarcia@at4.net
 * 
 */
@Service("usuario")
public class UsuarioService extends BaseService<UsuarioBO, UsuarioListadoVO, UsuarioFormVO> {

	/**
	 * The logger object.
	 */
	private static Logger log = LogService.getLogger(UsuarioService.class);

	/**
	 * Bean para acceder a los métodos de negocio: Usuario
	 */
	@Autowired
	@Qualifier("UsuarioBean")
	protected UsuarioBO mainBO;

	/**
	 * Bean para acceder a los métodos de negocio: Usuario
	 * 
	 * @param bean
	 *            the bean to set
	 */
	protected UsuarioBO getMainBO() {
		return this.mainBO;
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

	/**
	 * Indica si el usuario dispone de permisos para la acción action.
	 * 
	 * @param usuari
	 * @param action
	 * @param instance
	 * @return true/false según si el usuario dispone o no de permisos
	 */
	@Override
	protected boolean hasPerms(BaseFrontPrincipal usuari, String action, UsuarioFormVO instance) {

		if (action.equals(PERMS_ADD) || action.equals(PERMS_UPDATE) || action.equals(PERMS_DELETE)) {
			return usuari.isInAnyRole(Constants.ADMIN);
		} else if (action.equals(PERMS_LIST) || action.equals(PERMS_EXPORT)) {
			return usuari.isInAnyRole(Constants.ADMIN, Constants.CONSULTA);
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
			formItem.setText(this.getMessage("forms.usuario.title", locale));
		}

		GridMetaData metaData = new GridMetaData(formItem);

		//Nombre de la clase js de formulario
		metaData.setFormClassName("UsuarioForm");

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
		metaData.addColumn(new GridColumnMetaData("clave", this.getMessage("forms.usuario.columns.clave.header", locale)));
		metaData.getColumn("clave").setGroupable(false);
		metaData.getColumn("clave").setSortable(true);
		metaData.getColumn("clave").setSofaFilter(GridColumnFilter.TYPE_NUMERIC);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("municipioId", GridRecordFieldMetaData.INT_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("municipioLabel", GridRecordFieldMetaData.STRING_TYPE));
		metaData.addRecordField(new GridRecordFieldMetaData("municipio", "municipioLabel", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("municipio", this.getMessage("forms.usuario.columns.municipio.header", locale)));
		metaData.getColumn("municipio").setGroupable(true);
		metaData.getColumn("municipio").setSortable(true);
		metaData.getColumn("municipio").setSofaFilter(GridColumnFilter.TYPE_MULTICOMBO);
		metaData.getColumn("municipio").setRelatedForm("Municipio");

		metaData.getColumn("municipio").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("municipio").setEditable(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("username", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("username", this.getMessage("forms.usuario.columns.username.header", locale)));
		metaData.getColumn("username").setTooltip(this.getMessage("forms.usuario.columns.username.description", locale));
		metaData.getColumn("username").setGroupable(false);
		metaData.getColumn("username").setSortable(true);
		metaData.getColumn("username").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("username").setEditable(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("nombre", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("nombre", this.getMessage("forms.usuario.columns.nombre.header", locale)));
		metaData.getColumn("nombre").setTooltip(this.getMessage("forms.usuario.columns.nombre.description", locale));
		metaData.getColumn("nombre").setGroupable(false);
		metaData.getColumn("nombre").setSortable(true);
		metaData.getColumn("nombre").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("nombre").setEditable(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("apellidos", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("apellidos", this.getMessage("forms.usuario.columns.apellidos.header", locale)));
		metaData.getColumn("apellidos").setTooltip(this.getMessage("forms.usuario.columns.apellidos.description", locale));
		metaData.getColumn("apellidos").setGroupable(false);
		metaData.getColumn("apellidos").setSortable(true);
		metaData.getColumn("apellidos").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("apellidos").setSofaRenderer(GridColumnMetaData.RENDERER_LARGETEXT);

		metaData.getColumn("apellidos").setEditable(true);

		//Creamos el registro para el record
		/*
		 * metaData.addRecordField(new GridRecordFieldMetaData("idioma",
		 * GridRecordFieldMetaData.STRING_TYPE));
		 * 
		 * //Creamos la columna metaData.addColumn( new GridColumnMetaData(
		 * "idioma", this.getMessage("forms.usuario.columns.idioma.header",
		 * locale) ) ); metaData.getColumn("idioma").setTooltip(
		 * this.getMessage("forms.usuario.columns.idioma.description", locale)
		 * ); metaData.getColumn("idioma").setGroupable( false );
		 * metaData.getColumn("idioma").setSortable( true );
		 * metaData.getColumn("idioma").setSofaFilter(
		 * GridColumnFilter.TYPE_STRING );
		 * 
		 * 
		 * metaData.getColumn("idioma").setEditable( true );
		 */

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

		datosExportacion.add("clave", this.getMessage("forms.usuario.columns.clave.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("municipio", this.getMessage("forms.usuario.columns.municipio.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("username", this.getMessage("forms.usuario.columns.username.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("nombre", this.getMessage("forms.usuario.columns.nombre.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("apellidos", this.getMessage("forms.usuario.columns.apellidos.header", locale), TipoCampoExportacion.STRING);
		//datosExportacion.add( "idioma", this.getMessage("forms.usuario.columns.idioma.header", locale), TipoCampoExportacion.STRING );

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
		UsuarioListadoVO instance = (UsuarioListadoVO) rawInstance;

		List<String> excelRow = new ArrayList<String>();

		excelRow.add(FormData2Java.toString(instance.getClave()));
		excelRow.add(instance.getMunicipioLabel());
		excelRow.add(instance.getUsername());
		excelRow.add(instance.getNombre());
		excelRow.add(instance.getApellidos());
		//excelRow.add( instance.getIdioma() );
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
	 * Rellena una instancia de UsuarioFormVO con el contenido de un formulario
	 * recibido en formato Map<String, ?>
	 */
	protected void setFormData(UsuarioFormVO record, Map<String, ?> formData) throws GenericBusinessException {
		String formDataStr = null;
		if (FormData2Java.needsUpdate(formData, "municipioId")) {
			formDataStr = (String) formData.get("municipioId");
			record.setMunicipioId(FormData2Java.toInteger(formDataStr));

		}
		if (FormData2Java.needsUpdate(formData, "username")) {
			formDataStr = (String) formData.get("username");
			record.setUsername(formDataStr);
		}
		if (FormData2Java.needsUpdate(formData, "nombre")) {
			formDataStr = (String) formData.get("nombre");
			record.setNombre(formDataStr);
		}
		if (FormData2Java.needsUpdate(formData, "apellidos")) {
			formDataStr = (String) formData.get("apellidos");
			record.setApellidos(formDataStr);
		}
		/*
		 * if (FormData2Java.needsUpdate(formData,"idioma")) { formDataStr =
		 * (String)formData.get("idioma"); record.setIdioma( formDataStr );
		 * record.setIdioma("CA"); }
		 */
	}

	/**
	 * @author: garrom@at4.net
	 * 
	 *          Hace override de la funcion de añadir para que ponga el idioma
	 *          en CA
	 */
	@Override
	public ResultadoActualizacion add(Map<String, ?> formData, BaseFrontPrincipal usuari, Locale locale) throws GenericBusinessException {
		ResultadoActualizacion ret = new ResultadoActualizacion();
		UsuarioFormVO newRecord = this.getMainBO().newModel();
		this.setFormData(newRecord, formData);
		newRecord.setIdioma("CA");

		//Fija los campos automáticos
		java.util.Date ahora = new java.util.Date();
		newRecord.setDateCreation(ahora);
		newRecord.setLastModified(ahora);
		newRecord.setCreatorUser(usuari.getUsername());
		newRecord.setCreatorUser(usuari.getUsername());

		//Comprueba permisos de inserción
		this.checkPerms(usuari, PERMS_ADD, newRecord, locale);

		//Antes de insertar, validamos el registro
		this.validateRecord(ret, newRecord, usuari, locale);
		if (!ret.isCorrecto()) {
			return ret;
		}
		newRecord = this.getMainBO().add(newRecord);
		ret.addedElement(this.fromSerializableId(newRecord.getPrimaryKey()));
		ret.setUpdatedElement(newRecord);
		return ret;
	}

}
