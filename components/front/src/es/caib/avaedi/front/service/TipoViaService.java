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
import es.caib.avaedi.at4forms.common.util.log.LogService;
import es.caib.avaedi.at4forms.front.items.FormItem;
import es.caib.avaedi.at4forms.front.service.items.GridColumnFilter;
import es.caib.avaedi.at4forms.front.service.items.GridColumnMetaData;
import es.caib.avaedi.at4forms.front.service.items.GridMetaData;
import es.caib.avaedi.at4forms.front.service.items.GridRecordFieldMetaData;
import es.caib.avaedi.at4forms.logic.vo.ListadoVO;
import es.caib.avaedi.common.realm.Constants;
import es.caib.avaedi.front.service.general.BaseService;
import es.caib.avaedi.logic.bo.TipoViaBO;
import es.caib.avaedi.logic.vo.AcusticasListadoVO;
import es.caib.avaedi.logic.vo.TipoViaFormVO;
import es.caib.avaedi.logic.vo.TipoViaListadoVO;

/**
 * Servicio para tratar el formulario: TipoVia
 * 
 * @author agarcia@at4.net
 * 
 */
@Service("tipovia")
public class TipoViaService extends BaseService<TipoViaBO, TipoViaListadoVO, TipoViaFormVO> {

	/**
	 * The logger object.
	 */
	private static Logger log = LogService.getLogger(TipoViaService.class);

	/**
	 * Bean para acceder a los métodos de negocio: TipoVia
	 */
	@Autowired
	@Qualifier("TipoViaBean")
	protected TipoViaBO mainBO;

	/**
	 * Bean para acceder a los métodos de negocio: TipoVia
	 * 
	 * @param bean
	 *            the bean to set
	 */
	protected TipoViaBO getMainBO() {
		return this.mainBO;
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
	protected boolean hasPerms(BaseFrontPrincipal usuari, String action, TipoViaFormVO instance) {

		if (action.equals(PERMS_UPDATE)) {
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
			formItem.setText(this.getMessage("forms.tipovia.title", locale));
		}

		GridMetaData metaData = new GridMetaData(formItem);

		//Nombre de la clase js de formulario
		metaData.setFormClassName("TipoViaForm");

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
		metaData.addColumn(new GridColumnMetaData("clave", this.getMessage("forms.tipovia.columns.clave.header", locale)));
		metaData.getColumn("clave").setGroupable(false);
		metaData.getColumn("clave").setSortable(true);
		metaData.getColumn("clave").setSofaFilter(GridColumnFilter.TYPE_NUMERIC);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("codigoCatastro", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("codigoCatastro", this.getMessage("forms.tipovia.columns.codigoCatastro.header", locale)));
		metaData.getColumn("codigoCatastro").setGroupable(false);
		metaData.getColumn("codigoCatastro").setSortable(true);
		metaData.getColumn("codigoCatastro").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("codigoCatastro").setEditable(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("nombreEs", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("nombreEs", this.getMessage("forms.tipovia.columns.nombreEs.header", locale)));
		metaData.getColumn("nombreEs").setGroupable(false);
		metaData.getColumn("nombreEs").setSortable(true);
		metaData.getColumn("nombreEs").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("nombreEs").setEditable(true);

		//Creamos el registro para el record
		metaData.addRecordField(new GridRecordFieldMetaData("nombreCa", GridRecordFieldMetaData.STRING_TYPE));

		/** Creamos la columna */
		metaData.addColumn(new GridColumnMetaData("nombreCa", this.getMessage("forms.tipovia.columns.nombreCa.header", locale)));
		metaData.getColumn("nombreCa").setGroupable(false);
		metaData.getColumn("nombreCa").setSortable(true);
		metaData.getColumn("nombreCa").setSofaFilter(GridColumnFilter.TYPE_STRING);

		metaData.getColumn("nombreCa").setHidden(true);
		metaData.getColumn("nombreCa").setEditable(true);

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

		datosExportacion.add("clave", this.getMessage("forms.tipovia.columns.clave.header", locale), TipoCampoExportacion.NUMBER);
		datosExportacion.add("codigoCatastro", this.getMessage("forms.tipovia.columns.codigoCatastro.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("nombreEs", this.getMessage("forms.tipovia.columns.nombreEs.header", locale), TipoCampoExportacion.STRING);
		datosExportacion.add("nombreCa", this.getMessage("forms.tipovia.columns.nombreCa.header", locale), TipoCampoExportacion.STRING);

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
		TipoViaListadoVO instance = (TipoViaListadoVO) rawInstance;

		List<String> excelRow = new ArrayList<String>();

		excelRow.add(FormData2Java.toString(instance.getClave()));
		excelRow.add(instance.getCodigoCatastro());
		excelRow.add(instance.getNombreEs());
		excelRow.add(instance.getNombreCa());
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
	 * Rellena una instancia de TipoViaFormVO con el contenido de un formulario
	 * recibido en formato Map<String, ?>
	 */
	protected void setFormData(TipoViaFormVO record, Map<String, ?> formData) throws GenericBusinessException {
		String formDataStr = null;
		/*if (formData.containsKey("codigoCatastro")) {
			formDataStr = (String) formData.get("codigoCatastro");
			record.setCodigoCatastro(formDataStr);
		}*/
		if (FormData2Java.needsUpdate(formData, "nombreEs")) {
			formDataStr = (String) formData.get("nombreEs");
			record.setNombreEs(formDataStr);
		}
		if (FormData2Java.needsUpdate(formData, "nombreCa")) {
			formDataStr = (String) formData.get("nombreCa");
			record.setNombreCa(formDataStr);
		}
	}

}
