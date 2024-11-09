package es.caib.avaedi.common.persistence;

import es.caib.avaedi.at4forms.common.basedao.BaseDao;
import es.caib.avaedi.at4forms.common.exception.DaoException;
import es.caib.avaedi.common.model.Municipio;

/**
 * Interfaz DAO para Municipio.
 * 
 * @see es.caib.avaedi.common.model.Municipio
 * @author agarcia
 */
public interface MunicipioDao extends BaseDao<Municipio> {

	/**
	 * Devuelve la instancia de Municipio que cumple con la búsqueda
	 * 
	 * @param nombre
	 * @return la instancia de Municipio
	 * @throws DaoException
	 */
	public Municipio findByNombre(String nombre) throws DaoException;

	/**
	 * Devuelve la instancia de Municipio que cumple con la búsqueda
	 * 
	 * @param codigoCatastro
	 * @return la instancia de Municipio
	 * @throws DaoException
	 */
	public Municipio findByCodigoCatastro(int codigoCatastro) throws DaoException;

}
