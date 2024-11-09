package es.caib.avaedi.at4forms.front.service;

import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.directwebremoting.io.FileTransfer;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.servlet.view.AbstractView;

import es.caib.avaedi.at4forms.common.exception.GenericBusinessException;
import es.caib.avaedi.at4forms.common.realm.BaseFrontPrincipal;
import es.caib.avaedi.at4forms.common.search.DatosExportacion;
import es.caib.avaedi.at4forms.common.search.FilterConfig;
import es.caib.avaedi.at4forms.common.search.PagingConfig;
import es.caib.avaedi.at4forms.common.search.ResultadoActualizacion;
import es.caib.avaedi.at4forms.common.search.ResultadoBusqueda;
import es.caib.avaedi.at4forms.common.search.ResultadoExportacion;
import es.caib.avaedi.at4forms.common.search.TipoCampoExportacion;
import es.caib.avaedi.at4forms.common.util.StringUtils;
import es.caib.avaedi.at4forms.common.util.log.LogService;
import es.caib.avaedi.at4forms.front.controller.DocumentDownload;
import es.caib.avaedi.at4forms.front.items.FormItem;
import es.caib.avaedi.at4forms.front.service.items.ContenidoFormulario;
import es.caib.avaedi.at4forms.front.service.items.GridColumnMetaData;
import es.caib.avaedi.at4forms.front.service.items.GridMetaData;
import es.caib.avaedi.at4forms.front.util.FileConstraints;
import es.caib.avaedi.at4forms.front.util.ImageConstraints;
import es.caib.avaedi.at4forms.front.util.ImageUtil;
import es.caib.avaedi.at4forms.front.util.ImageUtil.ImageSize;
import es.caib.avaedi.at4forms.logic.bo.BaseBO;
import es.caib.avaedi.at4forms.logic.vo.FormVO;
import es.caib.avaedi.at4forms.logic.vo.ListadoVO;
import es.caib.avaedi.logic.bo.BlobBO;
import es.caib.avaedi.logic.vo.BlobFormVO;
import org.slf4j.Logger;
	

/**
 * Clase base sobre la que construir servicios de front. En particular,
 * formularios (FormService)
 *
 * @author agarcia
 *
 */
public abstract class DefaultBaseService< BO extends BaseBO<LO, FO>, LO extends ListadoVO, FO extends FormVO > extends MessageService implements FormService<BO, LO, FO> {

	public static final String YES_TEXT = "Ext.grid.filter.Boolean.yesText";
	public static final String NO_TEXT = "Ext.grid.filter.Boolean.noText";
	
	
	/**
	 * The logger object.
	 */
	private static Logger log = LogService.getLogger(DefaultBaseService.class);

	/**
	 * constante para definir el permiso "añadir"
	 */
	public static final String PERMS_ADD 	= "add";

	/**
	 * constante para definir el permiso "borrar"
	 */
	public static final String PERMS_DELETE = "delete";

	/**
	 * constante para definir el permiso "actualizar"
	 */
	public static final String PERMS_UPDATE = "update";

	/**
	 * constante para definir el permiso "listar"
	 */
	public static final String PERMS_LIST = "list";

	/**
	 * constante para definir el permiso "exportar"
	 */
	public static final String PERMS_EXPORT = "export";


	//protected AuditoriaBO auditBO;

	/**
	 * @param auditDao the dao to set
	 *
	public void setAuditoriaBO(AuditoriaBO auditBO) {
		this.auditBO = auditBO;
	}
	 */
	
	/**
	* Bean para acceder a los blobs
	* TODO: extraer a un interfaz que se implemente en cada aplicación
	*/
	@Autowired @Qualifier("BlobBean")
	protected BlobBO blobBO;
	
	/** Bean para acceder a los blobs
	* @param bean the bean to set
	*/
	public void setBlobBO(BlobBO bean) {
		this.blobBO = bean;
	}
	
	
	protected abstract BO getMainBO();
	
	/**
	 * Implementación por defecto que simplemente lanza una excepción
	 * @param fieldName
	 * @param query
	 * @param usuari
	 * @param locale
	 * @throws GenericBusinessException
	 */
	public ResultadoBusqueda<Map<String, String>> getRelationPopupData(String fieldName, String query, Collection<FilterConfig> extraFilters, 
			BaseFrontPrincipal usuari, Locale locale) throws GenericBusinessException {

		throw new GenericBusinessException("getRelationPopupData: se desconoce " + fieldName);

	}

	/**
	 * Implementación por defecto que simplemente lanza una excepción
	 * @param formData
	 * @param id
	 * @param subFormName
	 * @param usuari
	 * @param locale
	 * @throws GenericBusinessException
	 */
	public ResultadoActualizacion addSubForm(Map<String, ?> formData,
			String id, String subFormName, BaseFrontPrincipal usuari, Locale locale)
			throws GenericBusinessException {

		throw new GenericBusinessException("addSubForm: se desconoce " + subFormName);

	}

	/**
	 * Implementación por defecto que simplemente lanza una excepción
	 * @param id
	 * @param subFormName
	 * @param subId
	 * @param usuari
	 * @param locale
	 * @throws GenericBusinessException
	 */
	public ResultadoActualizacion deleteSubForm(String id, String subFormName,
			String subId, BaseFrontPrincipal usuari, Locale locale)
			throws GenericBusinessException {

		throw new GenericBusinessException("deleteSubForm: se desconoce " + subFormName);
	}

	/**
	 * Implementación por defecto que simplemente lanza una excepción
	 * @param id
	 * @param formData
	 * @param subFormName
	 * @param subId
	 * @param usuari
	 * @param locale
	 * @throws GenericBusinessException
	 */
	public ResultadoActualizacion updateSubForm(String id,
			Map<String, ?> formData, String subFormName, String subId,
			BaseFrontPrincipal usuari, Locale locale)
			throws GenericBusinessException {

		throw new GenericBusinessException("updateSubForm: se desconoce " + subFormName);
	}



	/**
	 * Carga una colección de datos del formulario. Para formularios que implementen el modo de carga de subpaneles diferido (deferredLoad)
	 * y desee usarse la implementación por defecto de loadSubPanel, debe implementarse este método de modo que retorne el
	 * formulario con los datos de la colección pedida, y modificar el método {@link #load(String, FrontPrincipal, Locale)} para
	 * que devuelva el contenido reducido
	 * Esta implementación por defecto carga los datos de la colección utilizando {@link #load(String, FrontPrincipal, Locale)}
	 * @param id
	 * @param usuari
	 * @param locale
	 * @return
	 * @throws GenericBusinessException
	 */
	@SuppressWarnings("unchecked")
	public Collection<? extends ListadoVO> loadCollecionData(String id, String multiFormName, BaseFrontPrincipal usuari, Locale locale) throws GenericBusinessException {
		try {
			FO instance = this.getMainBO().load( toSerializableId(id) );
			//Comprueba permisos de lectura
			this.checkPerms(usuari, PERMS_LIST, instance, locale);

			PropertyDescriptor property = BeanUtils.getPropertyDescriptor(instance.getClass(), multiFormName);
			if (property == null) {
				throw new GenericBusinessException ("Se desconoce la propiedad " + multiFormName);
			}
			Object resultData = property.getReadMethod().invoke(instance, new Object[0]);
			return (Collection<ListadoVO>) resultData;
		} catch (IllegalAccessException e) {
			log.error(e.getMessage(), e);
			throw new GenericBusinessException (e);
		} catch (InvocationTargetException e) {
			log.error(e.getMessage(), e);
			throw new GenericBusinessException (e);
		}
	}


	/* (non-Javadoc)
	 * @see es.caib.avaedi.front.service.FormService#getListado(java.util.Collection, es.caib.avaedi.common.search.PagingConfig, es.caib.avaedi.common.realm.BaseFrontPrincipal)
	 */
	public ResultadoBusqueda<LO> getListado(Collection<FilterConfig> filters,
			PagingConfig pagingConfig, BaseFrontPrincipal usuari, Locale locale) throws GenericBusinessException {

		//Comprueba permisos de lectura
		this.checkPerms(usuari, PERMS_LIST, locale);

		//Añade aggregates automáticamente desde el GridMetaData
		GridMetaData metaData = this.getListMetadata(new FormItem("dummy"), usuari, locale);
		for (GridColumnMetaData col : metaData.getColumns()) {
			if (!StringUtils.isEmpty(col.getSummaryType())) {
				if (col.getSummaryType().equals(PagingConfig.SUMMARY_SUM) || 
						col.getSummaryType().equals(PagingConfig.SUMMARY_AVERAGE) || 
						col.getSummaryType().equals(PagingConfig.SUMMARY_MAX) || 
						col.getSummaryType().equals(PagingConfig.SUMMARY_MIN) ) {
					pagingConfig.addAggregate(col.getDataIndex(), PagingConfig.SUMMARY_SUM);
				}
			}
		}
		
		return this.getMainBO().getListado(filters, pagingConfig);

	}


	/* (non-Javadoc)
	 * @see es.caib.avaedi.front.service.FormService#load(java.lang.String, es.caib.avaedi.common.realm.BaseFrontPrincipal)
	 */
	public ContenidoFormulario<FO> load(String id, BaseFrontPrincipal usuari, Locale locale) throws GenericBusinessException {
		FO instance = this.getMainBO().load( toSerializableId(id) );
		//Comprueba permisos de lectura
		this.checkPerms(usuari, PERMS_LIST, instance, locale);
		
		@SuppressWarnings("unchecked")
		ContenidoFormulario<FO> ret = (ContenidoFormulario<FO>) new ContenidoFormulario<FormVO>( instance );
		ret.setCanDelete( this.hasPerms(usuari, PERMS_DELETE, instance));
		ret.setCanUpdate( this.hasPerms(usuari, PERMS_UPDATE, instance));
		
		return ret;
	}

	
	protected abstract Serializable toSerializableId(String id);
	protected abstract String fromSerializableId(Serializable id);

	/**
	 * Rellena una instancia de FestivoFormVO con el contenido de un formulario recibido en formato Map<String, ?>
	 */
	protected abstract void setFormData(FO record, Map<String, ?> formData) throws GenericBusinessException ;
	
	@Override
	public AbstractView getCustomExportFormat(String format) throws GenericBusinessException {
		return null;
	}
	
	/* (non-Javadoc)
	 * @see es.caib.avaedi.front.service.FormService#add(java.util.Map, es.caib.avaedi.common.realm.BaseFrontPrincipal)
	 */
	public ResultadoActualizacion add(Map<String, ?> formData, BaseFrontPrincipal usuari, Locale locale)
			throws GenericBusinessException {

		ResultadoActualizacion ret = new ResultadoActualizacion();
		FO newRecord = this.getMainBO().newModel();
		this.setFormData (newRecord, formData);

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
		ret.addedElement(  this.fromSerializableId( newRecord.getPrimaryKey()) );
		ret.setUpdatedElement( newRecord );
		return ret;

	}

	public FO clone(FO record) throws GenericBusinessException {
		FO ret = this.getMainBO().newModel();
		BeanUtils.copyProperties(record, ret);
		return ret;
		
	}

	/* (non-Javadoc)
	 * @see es.caib.avaedi.front.service.FormService#update(java.lang.String, java.util.Map, es.caib.avaedi.common.realm.BaseFrontPrincipal)
	 */
	public ResultadoActualizacion update(String id, Map<String, ?> formData, BaseFrontPrincipal usuari, Locale locale)
			throws GenericBusinessException {

		ResultadoActualizacion ret = new ResultadoActualizacion();

		FO recordToUpdate = this.getMainBO().load( toSerializableId(id) );
		FO oldRecord = this.clone(recordToUpdate);
		
		this.setFormData(recordToUpdate, formData);

		//Fija los campos automáticos
		recordToUpdate.setLastModified(new java.util.Date());
		recordToUpdate.setModUser(usuari.getUsername());

		//Comprueba permisos de actualización
		this.checkPerms(usuari, PERMS_UPDATE, recordToUpdate, locale);
		
		//Antes de actualizar, validamos el registro
		this.validateRecord(ret, recordToUpdate, oldRecord, usuari, locale);
		if (!ret.isCorrecto()) {
			return ret;
		}
		recordToUpdate = this.getMainBO().update(toSerializableId(id), recordToUpdate);
		ret.updatedElement( this.fromSerializableId( recordToUpdate.getPrimaryKey()) );
		ret.setUpdatedElement( recordToUpdate );
		return ret;

	}

	/**
	 * Valida un registro para actualización. Por defecto, llama a {@link #validateRecord(ResultadoActualizacion, FormVO, BaseFrontPrincipal, Locale)}
	 * @param ret
	 * @param recordToUpdate
	 * @param oldRecord
	 * @param usuari
	 * @param locale
	 * @throws GenericBusinessException 
	 */
	protected void validateRecord(ResultadoActualizacion ret, FO recordToUpdate, FO oldRecord, BaseFrontPrincipal usuari, Locale locale) throws GenericBusinessException {
		this.validateRecord(ret, recordToUpdate, usuari, locale);
	}

	/**
	 * Valida un registro para creación.
	 * @param ret
	 * @param newRecord
	 * @param usuari
	 * @param locale
	 * @throws GenericBusinessException 
	 */
	protected void validateRecord(ResultadoActualizacion ret, FO newRecord, BaseFrontPrincipal usuari, Locale locale) throws GenericBusinessException {
	}
	

	/* (non-Javadoc)
	 * @see es.caib.avaedi.front.service.FormService#delete(java.lang.String, es.caib.avaedi.common.realm.BaseFrontPrincipal)
	 */
	public ResultadoActualizacion delete(String id, BaseFrontPrincipal usuari, Locale locale) throws GenericBusinessException {
		FO recordToDelete = this.getMainBO().load( toSerializableId(id) );
		//Comprueba permisos de borrado
		this.checkPerms(usuari, PERMS_DELETE, recordToDelete, locale);
		
		//TODO: condicionar a si tenemos o no activada auditoría para este Service
		//Fijamos los campos de auditoría, para tener constancia de quién lo ha borrado
		recordToDelete.setLastModified(new java.util.Date());
		recordToDelete.setModUser(usuari.getUsername());
		this.getMainBO().update(toSerializableId(id), recordToDelete);
		
		this.getMainBO().delete( toSerializableId(id) );
		ResultadoActualizacion ret = new ResultadoActualizacion();
		ret.deletedElement(id);
		return ret;
	}

	
	/**
	 * Obtiene el id para un blob, usando el nombre de la propiedad
	 * @param instance
	 * @param docname
	 * @return
	 * @throws GenericBusinessException
	 */
	private Long obtenerIdBlob(FO instance, String docname) throws GenericBusinessException {
		try {
			PropertyDescriptor property = BeanUtils.getPropertyDescriptor(instance.getClass(), docname);
			if (property == null) {
				throw new GenericBusinessException ("Se desconoce la propiedad " + docname);
			}
			return (Long)property.getReadMethod().invoke(instance, new Object[0]);
		} catch (IllegalAccessException e) {
			log.error(e.getMessage(), e);
			throw new GenericBusinessException (e);
		} catch (InvocationTargetException e) {
			log.error(e.getMessage(), e);
			throw new GenericBusinessException (e);
		}
		
	}
	

	/**
	 * Obtiene el id para un blob, usando el nombre de la propiedad
	 * @param instance
	 * @param docname
	 * @return
	 * @throws GenericBusinessException
	 */
	private String obtenerMimeBlob(FO instance, String docname) throws GenericBusinessException {
		try {
			PropertyDescriptor property = BeanUtils.getPropertyDescriptor(instance.getClass(), docname + "Mime");
			if (property == null) {
				throw new GenericBusinessException ("Se desconoce la propiedad " + docname + "Mime");
			}
			return (String)property.getReadMethod().invoke(instance, new Object[0]);
		} catch (IllegalAccessException e) {
			log.error(e.getMessage(), e);
			throw new GenericBusinessException (e);
		} catch (InvocationTargetException e) {
			log.error(e.getMessage(), e);
			throw new GenericBusinessException (e);
		}
		
	}
	
	/**
	 * Nuestros campos de imagen, tienen campos _x e _y donde guardamos el tamaño
	 * @param instance
	 * @param docname
	 * @return
	 */
	private boolean isImage (FO instance, String docname) {
		//X
		PropertyDescriptor property = BeanUtils.getPropertyDescriptor(instance.getClass(), docname + "X");
		if (property == null) {
			//Si no hay propiedad para el x, no es imagen
			return false;
		}
		
		//Y
		property = BeanUtils.getPropertyDescriptor(instance.getClass(), docname + "Y");
		if (property == null) {
			//Si no hay propiedad para el Y, no es imagen
			return false;
		}
		
		return true;
		
	}
	
	/**
	 * Obtiene el id para un blob, usando el nombre de la propiedad
	 * @param instance
	 * @param docname
	 * @return
	 * @throws GenericBusinessException
	 */
	private void fijarDatosBlob(FO instance, String docname, Serializable idBlob, String mime, Integer x, Integer y) throws GenericBusinessException {
		
		this.fijarDatosBlob(instance, docname, idBlob, mime);
		
		//X
		try {
			PropertyDescriptor property = BeanUtils.getPropertyDescriptor(instance.getClass(), docname + "X");
			if (property != null) {
				//Si no hay propiedad para el x, simplemente lo ignoramos
				property.getWriteMethod().invoke(instance, new Object[]{x} );
			}
		} catch (IllegalAccessException e) {
			log.error(e.getMessage(), e);
			throw new GenericBusinessException (e);
		} catch (InvocationTargetException e) {
			log.error(e.getMessage(), e);
			throw new GenericBusinessException (e);
		}
		
		//Y
		try {
			PropertyDescriptor property = BeanUtils.getPropertyDescriptor(instance.getClass(), docname + "Y");
			if (property != null) {
				//Si no hay propiedad para el Y, simplemente la ignoramos
				property.getWriteMethod().invoke(instance, new Object[]{y} );
			}
		} catch (IllegalAccessException e) {
			log.error(e.getMessage(), e);
			throw new GenericBusinessException (e);
		} catch (InvocationTargetException e) {
			log.error(e.getMessage(), e);
			throw new GenericBusinessException (e);
		}
				
	}

	/**
	 * Obtiene el id para un blob, usando el nombre de la propiedad
	 * @param instance
	 * @param docname
	 * @return
	 * @throws GenericBusinessException
	 */
	private void fijarDatosBlob(FO instance, String docname, Serializable idBlob, String mime) throws GenericBusinessException {
		
		//Blob
		try {
			PropertyDescriptor property = BeanUtils.getPropertyDescriptor(instance.getClass(), docname);
			if (property == null) {
				throw new GenericBusinessException ("Se desconoce la propiedad " + docname);
			}
			property.getWriteMethod().invoke(instance, new Object[]{idBlob} );
		} catch (IllegalAccessException e) {
			log.error(e.getMessage(), e);
			throw new GenericBusinessException (e);
		} catch (InvocationTargetException e) {
			log.error(e.getMessage(), e);
			throw new GenericBusinessException (e);
		}
		
		//Mime
		try {
			PropertyDescriptor property = BeanUtils.getPropertyDescriptor(instance.getClass(), docname + "Mime");
			if (property != null) { 
				//Si no hay propiedad para el mime, simplemente lo ignoramos
				property.getWriteMethod().invoke(instance, new Object[]{mime} );
			}
		} catch (IllegalAccessException e) {
			log.error(e.getMessage(), e);
			throw new GenericBusinessException (e);
		} catch (InvocationTargetException e) {
			log.error(e.getMessage(), e);
			throw new GenericBusinessException (e);
		}
		
				
	}
	
	
	/**
	 * Guarda y asocia un archivo
	 * 
	 * @param file
	 * @param docExpId
	 * @param request
	 * @param locale
	 * @return el resultado de la operación
	 * @throws GenericBusinessException
	 */
	public ResultadoActualizacion guardarBlob(FileTransfer file, String id, String docname, BaseFrontPrincipal usuari, Locale locale) throws GenericBusinessException {
		log.debug("guardar blob - start ");

		ContenidoFormulario<FO> form = this.load(id, usuari, locale);
		FO instance = form.getData();
		this.checkPerms(usuari, PERMS_UPDATE, instance, locale);

		ResultadoActualizacion ret = new ResultadoActualizacion();

		try {

			// Almacenamos el archivo
			byte[] buffer = new byte[file.getInputStream().available()];
			InputStream bytesArchivo = file.getInputStream();
			for (int offset = 0; offset < buffer.length; offset++) {
				bytesArchivo.read(buffer, offset, (buffer.length - offset));
			}
			
			
			boolean isImage = isImage (instance, docname);
			ImageSize size;
			String mime;

			if (isImage) {
				//Validamos la imagen (formato y tamaño)
				size = ImageUtil.getImageSize(buffer);
				mime = size.mime;

				if (	size.type != ImageSize.GIF &&
						size.type != ImageSize.JPEG &&
						size.type != ImageSize.PNG) {

					log.debug("guardar archivo - Formato incorrecto");
					ret.setCorrecto(false);
					ret.addError("error", this.getMessage("guardarArchivo.error.fileformat", locale));
					ret.setMessage(this.getMessage("guardarArchivo.error.fileformat", locale));
					return ret;
				}
				
				ImageConstraints constraints = this.obtenerImageConstraints(docname);
				int status = ImageUtil.validateImageSize(size.x, size.y, constraints );
				if (status == ImageConstraints.WARNING) {
					ret.addWarning(this.getMessage("guardarArchivo.warning.imagesize", locale));
				} else if (status == ImageConstraints.INVALID) {
					//Este procedimiento es algo rebuscado, de hecho se podría llamar primero directamente a resizeToconstraints.
					//TODO: mejorar
					
					//Intentamos redimensionar la imagen
					buffer = ImageUtil.resizeToconstraints(buffer, size, constraints);
					size = ImageUtil.getImageSize(buffer);
					
					status = ImageUtil.validateImageSize(size.x, size.y, constraints );
					
					if (status == ImageConstraints.VALID) {
						ret.addWarning(this.getMessage("guardarArchivo.warning.imageresized", locale));
					} else if (status == ImageConstraints.WARNING) {
						ret.addWarning(this.getMessage("guardarArchivo.warning.imageresized", locale));
						ret.addWarning(this.getMessage("guardarArchivo.warning.imagesize", locale));
					} else if (status == ImageConstraints.INVALID) {
						log.debug("guardar archivo - tamaño incorrecto de imagen");
						ret.setCorrecto(false);
						ret.addError("error", this.getMessage("guardarArchivo.error.imagesize", locale));
						ret.setMessage(this.getMessage("guardarArchivo.error.imagesize", locale));
						return ret;
					}
				}

			} else {
				FileConstraints fc = this.obtenerFileConstraints(docname);
				int status = ImageUtil.validateFile(file, buffer, fc);
				if (status == FileConstraints.INVALID_TYPE) {
					log.debug("guardar archivo - tipo incorrecto de archivo");
					ret.setCorrecto(false);
					ret.addError("error", this.getMessage("guardarArchivo.error.filetype", locale));
					ret.setMessage(this.getMessage("guardarArchivo.error.filetype", locale));
					return ret;
				} else if (status == FileConstraints.INVALID_SIZE) {
					log.debug("guardar archivo - tamaño incorrecto de archivo");
					ret.setCorrecto(false);
					ret.addError("error", this.getMessage("guardarArchivo.error.filesize", locale));
					ret.setMessage(this.getMessage("guardarArchivo.error.filesize", locale));
					return ret;
				}
				size = new ImageUtil.ImageSize();
				//TODO: la operación getMime, que puede ser costosa, se está haciendo 2 veces
				mime = ImageUtil.getMime(file, buffer, fc );
				
			}
			

			BlobFormVO archivo = new BlobFormVO();
			archivo.setDatos(buffer);
			//Fija los campos automáticos
			java.util.Date ahora = new java.util.Date();
			archivo.setDateCreation(ahora);
			archivo.setLastModified(ahora);
			archivo.setCreatorUser(usuari.getUsername());
			archivo.setModUser(usuari.getUsername());
			
			archivo = this.blobBO.add(archivo);

			// Si ya tenía asociado un archivo, lo borramos de la BBDD
			Long idBlob = this.obtenerIdBlob(instance, docname);
			if (idBlob != null) {
				this.blobBO.delete(idBlob);
			}

			if (isImage) {
				this.fijarDatosBlob(instance, docname, archivo.getPrimaryKey(), mime, size.x, size.y);
			} else {
				this.fijarDatosBlob(instance, docname, archivo.getPrimaryKey(), mime);
			}
			
			//garrom: Actualiza el lastmodified a ahora.
			instance.setLastModified(ahora);
			instance.setModUser(usuari.getUsername());
			instance = this.getMainBO().update(instance.getPrimaryKey(), instance);
			ret.updatedElement(instance.getPrimaryKey().toString());
			ret.addedElement(archivo.getPrimaryKey().toString());
			//Garrom: Para que la respuesta incluya el objeto actualizado
			ret.setUpdatedElement(instance);

			log.debug("guardar blob - end ");

			return ret;

		} catch (IOException ex) {
			log.error(ex.getMessage(), ex);
			ret.setCorrecto(false);
			ret.addError("error", this.getMessage("guardarArchivo.error.sincronizacion", locale));
			ret.setMessage(this.getMessage("guardarArchivo.error.sincronizacion", locale));
			return ret;
		} catch (GenericBusinessException ex) {
			log.error(ex.getMessage(), ex);
			ret.setCorrecto(false);
			ret.addError("error", this.getMessage("guardarArchivo.error.save", locale));
			ret.setMessage(this.getMessage("guardarArchivo.error.save", locale));
			return ret;
		}
	}



	/**
	 * Elimina un Blob
	 * 
	 * @param id
	 * @param request
	 * @param usuari
	 * @param locale
	 * @return el resultado de la operación
	 */
	public ResultadoActualizacion eliminarBlob(String id, String docname, BaseFrontPrincipal usuari, Locale locale) throws GenericBusinessException {
		log.debug("eliminarBlob - start ");

		ContenidoFormulario<FO> form = this.load(id, usuari, locale);
		FO instance = form.getData();
		this.checkPerms(usuari, PERMS_UPDATE, instance, locale);

		ResultadoActualizacion ret = new ResultadoActualizacion();

		try {

			// Si ya tenía asociado un archivo, lo borramos de la BBDD
			Long idBlob = this.obtenerIdBlob(instance, docname);
			if (idBlob != null) {
				this.blobBO.delete(idBlob);
			}

			//Borra los datos del blob
			this.fijarDatosBlob(instance, docname, null, null, null, null);

			instance = this.getMainBO().update(instance.getPrimaryKey(), instance);
			ret.updatedElement(instance.getPrimaryKey().toString());
			
			log.debug("eliminar archivo de blob - end ");

			return ret;

		} catch (GenericBusinessException ex) {
			log.error(ex.getMessage(), ex);
			ret.setCorrecto(false);
			ret.addError("error", this.getMessage("guardarArchivo.error.save", locale));
			ret.setMessage(this.getMessage("guardarArchivo.error.save", locale));
			return ret;
		}
	}

	/**
	 * Obtiene un archivo 
	 * 
	 * @param id
	 * @param request
	 * @param usuari
	 * @param locale
	 * @return
	 * @throws GenericBusinessException
	 */
	public DocumentDownload obtenerBlob(String id, String docname, BaseFrontPrincipal usuari, Locale locale) throws GenericBusinessException {

		ContenidoFormulario<FO> form = this.load(id, usuari, locale);
		FO instance = form.getData();

		DocumentDownload ret = null;
		BlobFormVO archivo = this.blobBO.load( this.obtenerIdBlob(instance, docname));
		if (archivo != null) {
			ret = new DocumentDownload();
			ret.setData(archivo.getDatos());
			ret.setMime(this.obtenerMimeBlob(instance, docname));
			ret.setFilename(docname + "_" + instance.getPrimaryKey().toString() + "_" + archivo.getPrimaryKey().toString());
		}

		
		return ret;
	}
	
	public ImageConstraints obtenerImageConstraints(String docname) {
		return new ImageConstraints();
	}
	
	public FileConstraints obtenerFileConstraints(String docname) {
		return new FileConstraints();
	}

	/** Formato de fecha en toString */
	protected String getDateFormat() {
		return "Y-m-d";
	}

	/** Formato de fecha en toString */
	protected String getDateTimeFormat() {
		return "Y-m-d H:i:s.u";
	}

	/** Formato de fecha en toString */
	protected String getTimeFormat() {
		return "H:i:s";
	}

	/**
	 * Máximo número de registros a devolver en una exportación
	 */
	public static final int EXPORT_MAX_LIMIT = 1000000;

	
	/* (non-Javadoc)
	 * @see es.caib.avaedi.front.service.FormService#getExportacion(java.util.Collection, es.caib.avaedi.common.search.PagingConfig, es.caib.avaedi.common.realm.BaseFrontPrincipal, java.util.Locale)
	 */
	public ResultadoExportacion getExportacion(Collection<FilterConfig> filters, PagingConfig pagingConfig, List<String> camposAexportar, BaseFrontPrincipal usuari, Locale locale) throws GenericBusinessException {

		//Comprueba permisos de exportación
		this.checkPerms(usuari, PERMS_EXPORT, locale);

		ResultadoBusqueda<LO> resultadoBusqueda = this.getListado(filters, pagingConfig, usuari, locale);
		DatosExportacion datos = this.getDatosExportacion(locale);
		ResultadoExportacion resultadoExportacion = new ResultadoExportacion(datos);

		List<String> excelRow;
		List<String> finalExcelRow;
		LO instance;
		int numRecords = 0;

		Iterator<LO> iter = resultadoBusqueda.getResultados().iterator();
		List<List<String>> resultados = new ArrayList<List<String>>();

		while (iter.hasNext() && (numRecords < EXPORT_MAX_LIMIT)) {
			instance = iter.next();
			excelRow = this.listadoToExportRow(instance, locale);

			finalExcelRow = this.filterExcelRow(datos, camposAexportar, excelRow);
			
			resultados.add(finalExcelRow);
			numRecords++;
		}

		DatosExportacion datosFinales = this.filterDatosExportacion(datos, camposAexportar);
		
		resultadoExportacion.setCabeceras(datosFinales.getCabeceras());
		resultadoExportacion.setCampos(datosFinales.getCampos());
		resultadoExportacion.setTiposCampo(datosFinales.getTiposCampo());
		resultadoExportacion.setResultados(resultados);
		return resultadoExportacion;

	}
	
	private DatosExportacion filterDatosExportacion(DatosExportacion datos, List<String> camposAexportar) {
		if(camposAexportar == null || camposAexportar.size() < 1){
			return datos;
		}
		DatosExportacion datosFinales = new DatosExportacion();
		List<String> campos = datos.getCampos();
		List<String> cabeceras = datos.getCabeceras();
		List<TipoCampoExportacion> tiposCampo = datos.getTiposCampo();
		for(int i = 0; i < campos.size(); i++){
			String campo = campos.get(i);
			if(camposAexportar.contains(campo)){
				datosFinales.getCampos().add(campo);
				datosFinales.getCabeceras().add(cabeceras.get(i));
				datosFinales.getTiposCampo().add(tiposCampo.get(i));
			}
		}
		return datosFinales;
	}


	private List<String> filterExcelRow(DatosExportacion datos, List<String> camposAexportar, List<String> valoresRaw) {
		if(camposAexportar == null || camposAexportar.size() < 1){
			return valoresRaw;
		}
		
		List<String> campos = datos.getCampos();
		ArrayList<String> valoresADevolver = new ArrayList<String>();
		for(int i = 0; i < campos.size(); i++){
			String campo = campos.get(i);
			if(camposAexportar.contains(campo)){
				valoresADevolver.add(valoresRaw.get(i));
			}
		}
		
		return valoresADevolver;
	}
	
	


	/**
	 * Método genérico que comprueba permisos de administración o lectura.
	 * Para la mayoría de tablas que requieren permisos de administración 
	 * @param usuari
	 * @param action
	 * @param instance
	 * @return
	public abstract boolean hasPermsAdminLectura(BaseFrontPrincipal usuari, String action);
	 */

	/**
	 * Método genérico que comprueba permisos de operador o lectura.
	 * Para la operatoria normal 
	 * @param usuari
	 * @param action
	 * @param instance
	 * @return
	public abstract boolean hasPermsOperadorLectura(BaseFrontPrincipal usuari, String action);
	 */

	/**
	 * Metódo genérico que comprueba permisos para listados.
	 * Para los formularios que no permiten modificación en ningún caso
	 * @param usuari
	 * @param action
	 * @return
	public abstract boolean hasPermsListados(BaseFrontPrincipal usuari, String action);
	 */

	
	abstract protected boolean hasPerms(BaseFrontPrincipal usuari, String action, FO instance);

	/**
	 * Indica si el usuario dispone de permisos para la acción action
	 * @param usuari
	 * @param action
	 * @return true/false según si el usuario dispone o no de permisos
	 */
	protected boolean hasPerms(BaseFrontPrincipal usuari, String action) {
		return this.hasPerms(usuari, action, null);
	}

	/**
	 * Comprueba los permisos para la acción
	 * @param usuari
	 * @param action
	 * @param instance
	 * @param locale
	 * @throws GenericBusinessException
	 */
	protected final void checkPerms(BaseFrontPrincipal usuari, String action, FO instance, Locale locale) throws GenericBusinessException {

		if (!this.hasPerms(usuari, action, instance)) {
			String error = this.getMessage("errors.insufficientPerms", locale);
			log.error(error);
			throw new GenericBusinessException(error);
		}

	}


	/**
	 * Comprueba los permisos para la acción
	 * @param usuari
	 * @param action
	 * @param locale
	 * @throws GenericBusinessException
	 */
	protected final void checkPerms(BaseFrontPrincipal usuari, String action, Locale locale) throws GenericBusinessException {
		this.checkPerms(usuari, action, null, locale);

	}
	
}
