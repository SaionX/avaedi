package es.caib.avaedi.at4forms.front.service;

import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.directwebremoting.io.FileTransfer;
import org.springframework.web.servlet.view.AbstractView;

import es.caib.avaedi.at4forms.common.exception.GenericBusinessException;
import es.caib.avaedi.at4forms.common.realm.BaseFrontPrincipal;
import es.caib.avaedi.at4forms.common.search.DatosExportacion;
import es.caib.avaedi.at4forms.common.search.FilterConfig;
import es.caib.avaedi.at4forms.common.search.PagingConfig;
import es.caib.avaedi.at4forms.common.search.ResultadoActualizacion;
import es.caib.avaedi.at4forms.common.search.ResultadoBusqueda;
import es.caib.avaedi.at4forms.common.search.ResultadoExportacion;
import es.caib.avaedi.at4forms.front.controller.DocumentDownload;
import es.caib.avaedi.at4forms.front.items.FormItem;
import es.caib.avaedi.at4forms.front.service.items.ContenidoFormulario;
import es.caib.avaedi.at4forms.front.service.items.GridMetaData;
import es.caib.avaedi.at4forms.front.util.FileConstraints;
import es.caib.avaedi.at4forms.front.util.ImageConstraints;
import es.caib.avaedi.at4forms.logic.bo.BaseBO;
import es.caib.avaedi.at4forms.logic.vo.FormVO;
import es.caib.avaedi.at4forms.logic.vo.ListadoVO;


/**
 * Interfaz que debe implementar un bean de servicio para un formulario básico front
 * @author agarcia
 *
 */
public interface FormService< BO extends BaseBO<LO, FO>, LO extends ListadoVO, FO extends FormVO > {
	

	
	public List<String> listadoToExportRow(ListadoVO instance, Locale locale);

	/**
	 * Devuelve la configuración de columnas para un grid
	 * @param formItem
	 * @param usuari
	 * @param locale
	 * @return configuración de columnas
	 */
	GridMetaData getListMetadata(FormItem formItem, BaseFrontPrincipal usuari, Locale locale);

	/**
	 * Ejecuta el listado
	 * @param searchId
	 * @param filters
	 * @param pagingConfig
	 * @param usuari
	 * @param locale
	 * @return resultado de la ejecución del listado
	 * @throws GenericBusinessException
	 */
	ResultadoBusqueda<LO> getListado(Collection<FilterConfig> filters, PagingConfig pagingConfig, BaseFrontPrincipal usuari, Locale locale) throws GenericBusinessException;

	/** Ejecuta una exportación
	 *
	 * @param searchId
	 * @param filters
	 * @param pagingConfig
	 * @param usuari
	 * @param locale
	 * @return el resultado de la ejecución de la exportación
	 * @throws GenericBusinessException
	 */
	public ResultadoExportacion getExportacion(Collection<FilterConfig> filters, PagingConfig pagingConfig, List<String> camposAexportar, BaseFrontPrincipal usuari, Locale locale) throws GenericBusinessException;

	/**
	 * Carga el contenido del formulario
	 * @param id
	 * @param usuari
	 * @param locale
	 * @return contenido de un formulario web
	 * @throws GenericBusinessException
	 */
	ContenidoFormulario<FO> load(String id, BaseFrontPrincipal usuari, Locale locale) throws GenericBusinessException;

	/**
	 * Ejecuta una actualización de formulario web
	 * @param id
	 * @param formData
	 * @param usuari
	 * @param locale
	 * @return resultado de la actualización
	 * @throws GenericBusinessException
	 */
	ResultadoActualizacion update(String id, Map<String, ?> formData, BaseFrontPrincipal usuari, Locale locale) throws GenericBusinessException;

	/**
	 * Ejecuta la inserción de un formulario web
	 * @param formData
	 * @param usuari
	 * @param locale
	 * @return resultado de la actualización
	 * @throws GenericBusinessException
	 */
	ResultadoActualizacion add(Map<String, ?> formData, BaseFrontPrincipal usuari, Locale locale) throws GenericBusinessException;

	/**
	 * Ejecuta la eliminación de un formulario web
	 * @param id
	 * @param usuari
	 * @param locale
	 * @return resultado de la actualización
	 * @throws GenericBusinessException
	 */
	ResultadoActualizacion delete(String id, BaseFrontPrincipal usuari, Locale locale) throws GenericBusinessException;

	/**
	 * Devuelve los datos para el popup de nombre fieldName.
	 *
	 * @param fieldName
	 * @param query
	 * @param filters 
	 * @param usuari
	 * @param locale
	 * @return los datos para el popup de nombre fieldName
	 * @throws GenericBusinessException
	 */
	ResultadoBusqueda<?> getRelationPopupData(String fieldName, String query, Collection<FilterConfig> filters, BaseFrontPrincipal usuari, Locale locale) throws GenericBusinessException;

	/**
	 * Ejecuta la inserción de datos de un subFormulario
	 * @param formData
	 * @param id
	 * @param subFormName
	 * @param usuari
	 * @param locale
	 * @return el resultado de la operación
	 * @throws GenericBusinessException
	 */
	ResultadoActualizacion addSubForm(Map<String, ?> formData, String id, String subFormName, BaseFrontPrincipal usuari, Locale locale) throws GenericBusinessException;

	/**
	 * Ejecuta la actualización de datos de un subFormulario
	 * @param id
	 * @param formData
	 * @param subFormName
	 * @param subId
	 * @param usuari
	 * @param locale
	 * @return el resultado de la operación
	 * @throws GenericBusinessException
	 */
	ResultadoActualizacion updateSubForm(String id, Map<String, ?> formData, String subFormName, String subId, BaseFrontPrincipal usuari, Locale locale) throws GenericBusinessException;

	/**
	 * Ejecuta la eliminación de un subformulario web
	 * @param id
	 * @param subFormName
	 * @param subId
	 * @param usuari
	 * @param locale
	 * @return el resultado de la operación
	 * @throws GenericBusinessException
	 */
	ResultadoActualizacion deleteSubForm(String id, String subFormName, String subId, BaseFrontPrincipal usuari, Locale locale) throws GenericBusinessException;

	
	/**
	 * @param file
	 * @param docname
	 * @param id
	 * @param usuari
	 * @param locale
	 * @return
	 * @throws GenericBusinessException
	 */
	ResultadoActualizacion guardarBlob(FileTransfer file, String id, String docname, BaseFrontPrincipal usuari, Locale locale) throws GenericBusinessException;
	
	ResultadoActualizacion eliminarBlob(String id, String docname, BaseFrontPrincipal usuari, Locale locale) throws GenericBusinessException;
	
	DocumentDownload obtenerBlob(String id, String docname, BaseFrontPrincipal usuari, Locale locale) throws GenericBusinessException;
	
	/**
	 * Devuelve el contenido de un subpanel (MultiForm) de un formulario web, para paneles marcados como deferredLoad
	 * @param id
	 * @param multiFormName
	 * @param usuari
	 * @param locale
	 * @return
	 * @throws GenericBusinessException
	 */
	Collection<? extends ListadoVO> loadCollecionData(String id, String multiFormName, BaseFrontPrincipal usuari, Locale locale) throws GenericBusinessException;

	/**
	 * Obtiene las caracteristicas de tamaño configuradas para una imagen del formulario
	 * @param docname
	 * @return
	 * @throws GenericBusinessException
	 */
	ImageConstraints obtenerImageConstraints(String docname) throws GenericBusinessException;

	/**
	 * Obtiene las caracteristicas de tipo de archivo configuradas para una archivo del formulario
	 * @param docname
	 * @return
	 * @throws GenericBusinessException
	 */
	FileConstraints obtenerFileConstraints(String docname) throws GenericBusinessException;

	/**
	 * Devuelve la vista spring que implementa un formato de exportación personalizado
	 * @param format
	 * @return
	 * @throws GenericBusinessException
	 */
	AbstractView getCustomExportFormat(String format) throws GenericBusinessException;
	
	
	DatosExportacion getDatosExportacion(Locale locale) throws GenericBusinessException;
}
