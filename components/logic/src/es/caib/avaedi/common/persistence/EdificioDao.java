package es.caib.avaedi.common.persistence;

import es.caib.avaedi.at4forms.common.basedao.BaseDao;
import es.caib.avaedi.at4forms.common.exception.DaoException;
import es.caib.avaedi.common.model.Edificio;

/**
 * Interfaz DAO para Edificio.
 * 
 * @see es.caib.avaedi.common.model.Edificio
 * @author agarcia
 */
public interface EdificioDao extends BaseDao<Edificio> {

	/**
	 * Devuelve la instancia de Edificio que cumple con la búsqueda
	 * 
	 * @param codigoCatastro
	 * @return la instancia de Edificio
	 * @throws DaoException
	 */
	public Edificio findByCodigoCatastro(String codigoCatastro) throws DaoException;

}
