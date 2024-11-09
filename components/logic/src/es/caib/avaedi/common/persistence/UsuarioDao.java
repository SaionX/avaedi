package es.caib.avaedi.common.persistence;

import es.caib.avaedi.at4forms.common.basedao.BaseDao;
import es.caib.avaedi.at4forms.common.exception.DaoException;
import es.caib.avaedi.common.model.Usuario;

/**
 * Interfaz DAO para Usuario.
 * 
 * @see es.caib.avaedi.common.model.Usuario
 * @author agarcia
 */
public interface UsuarioDao extends BaseDao<Usuario> {

	/**
	 * Devuelve la instancia de Usuario que cumple con la búsqueda
	 * 
	 * @param username
	 * @return la instancia de Usuario
	 * @throws DaoException
	 */
	public Usuario findUsuarioByUsername(String username) throws DaoException;

}
