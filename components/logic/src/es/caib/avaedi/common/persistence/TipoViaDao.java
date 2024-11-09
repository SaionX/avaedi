package es.caib.avaedi.common.persistence;

import es.caib.avaedi.at4forms.common.basedao.BaseDao;
import es.caib.avaedi.at4forms.common.exception.DaoException;
import es.caib.avaedi.common.model.TipoVia;

/**
 * Interfaz DAO para TipoVia.
 * 
 * @see es.caib.avaedi.common.model.TipoVia
 * @author agarcia
 */
public interface TipoViaDao extends BaseDao<TipoVia> {

	/**
	 * Devuelve la instancia de TipoVia que cumple con la búsqueda
	 * 
	 * @param codigo
	 * @return la instancia de TipoVia
	 * @throws DaoException
	 */
	public TipoVia findByCodigoCatastro(String codigo) throws DaoException;

}
