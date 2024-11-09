package es.caib.avaedi.common.persistence;

import es.caib.avaedi.at4forms.common.basedao.BaseDao;
import es.caib.avaedi.at4forms.common.exception.DaoException;
import es.caib.avaedi.common.model.ConfigAplicacion;

/**
 * Interfaz DAO para ConfigAplicacion.
 * 
 * @see es.caib.avaedi.common.model.ConfigAplicacion
 * @author agarcia
 */
public interface ConfigAplicacionDao extends BaseDao<ConfigAplicacion> {

	/**
	 * Devuelve la instancia de ConfigAplicacion que cumple con la búsqueda
	 * 
	 * @param etiqueta
	 * @param nombre
	 * @param usuario
	 * @return la instancia de ConfigAplicacion
	 * @throws DaoException
	 */
	public ConfigAplicacion findByEtiqueta(String etiqueta, String nombre, String usuario) throws DaoException;

}
