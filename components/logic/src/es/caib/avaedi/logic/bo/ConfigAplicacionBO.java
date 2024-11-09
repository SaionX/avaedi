package es.caib.avaedi.logic.bo;

import es.caib.avaedi.at4forms.common.exception.GenericBusinessException;
import es.caib.avaedi.at4forms.logic.bo.BaseBO;
import es.caib.avaedi.logic.vo.ConfigAplicacionFormVO;
import es.caib.avaedi.logic.vo.ConfigAplicacionListadoVO;

/**
 * Interfaz que define los métodos de negocio del Bean: ConfigAplicacion
 * 
 * @author agarcia@at4.net
 * 
 */
public interface ConfigAplicacionBO extends BaseBO<ConfigAplicacionListadoVO, ConfigAplicacionFormVO> {

	/*
	 * Finders para relaciones
	 */

	/**
	 * Devuelve la instancia de ConfigAplicacionFormVO que cumple con la
	 * búsqueda findByEtiqueta
	 * 
	 * @param etiqueta
	 * @param nombre
	 * @param usuario
	 * @return la instancia de ConfigAplicacionFormVO
	 * @throws GenericBusinessException
	 */
	public ConfigAplicacionFormVO findByEtiqueta(String etiqueta, String nombre, String usuario) throws GenericBusinessException;

}
