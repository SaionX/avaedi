package es.caib.avaedi.logic.bo;

import java.util.Collection;

import es.caib.avaedi.at4forms.common.exception.GenericBusinessException;
import es.caib.avaedi.at4forms.logic.bo.BaseBO;
import es.caib.avaedi.logic.vo.ConfigExportacionFormVO;
import es.caib.avaedi.logic.vo.ConfigExportacionListadoVO;

/**
 * Interfaz que define los métodos de negocio del Bean: ConfigExportacion
 * 
 * @author agarcia@at4.net
 * 
 */
public interface ConfigExportacionBO extends BaseBO<ConfigExportacionListadoVO, ConfigExportacionFormVO> {

	/*
	 * Finders para relaciones
	 */

	/**
	 * Devuelve la instancia de ConfigExportacionFormVO que cumple con la
	 * búsqueda findByEtiqueta
	 * 
	 * @param etiqueta
	 * @param nombre
	 * @param usuario
	 * @return la instancia de ConfigExportacionFormVO
	 * @throws GenericBusinessException
	 */
	public ConfigExportacionFormVO findByEtiqueta(String etiqueta, String nombre, String usuario) throws GenericBusinessException;

	/**
	 * Devuelve la lista de instancias ConfigExportacionListadoVO que cumplen
	 * con la búsqueda searchAvailables
	 * 
	 * @param nombre
	 * @param usuario
	 * @return la lista de instancias
	 * @throws GenericBusinessException
	 */
	public Collection<ConfigExportacionListadoVO> searchAvailables(String nombre, String usuario) throws GenericBusinessException;

}
