package es.caib.avaedi.common.persistence;

import es.caib.avaedi.at4forms.common.basedao.BaseDao;
import es.caib.avaedi.at4forms.common.exception.DaoException;
import es.caib.avaedi.common.model.Via;

/**
 * Interfaz DAO para Via.
 * 
 * @see es.caib.avaedi.common.model.Via
 * @author agarcia
 */
public interface ViaDao extends BaseDao<Via> {

	/**
	 * Devuelve la instancia de Via que cumple con la búsqueda
	 * 
	 * @param codigo
	 * @param municipioId
	 * @return la instancia de Via
	 * @throws DaoException
	 */
	public Via findViaDeMunicipio(int codigo, int municipioId) throws DaoException;

	/**
	 * Devuelve la instancia de Via que cumple con la búsqueda
	 * 
	 * @param codigo
	 * @param municipio
	 * @return la instancia de Via
	 * @throws DaoException
	 */
	public Via findByCodigoCatastro(int codigo, int municipio) throws DaoException;

	/**
	 * Devuelve la instancia de Via que cumple con la búsqueda
	 * 
	 * @param nombre
	 * @param municipioId
	 * @param tipoViaId
	 * @return la instancia de Via
	 * @throws DaoException
	 */
	public Via findViaDuplicada(String nombre, int municipioId, int tipoViaId) throws DaoException;

	/**
	 * Devuelve la instancia de Via que cumple con la búsqueda
	 * 
	 * @param nombre
	 * @param municipioId
	 * @return la instancia de Via
	 * @throws DaoException
	 */
	public Via findViaDeMunicipioNombre(String nombre, int municipioId) throws DaoException;

	/**
	 * Devuelve la instancia de Via que cumple con la búsqueda
	 * 
	 * @param nombre
	 * @return la instancia de Via
	 * @throws DaoException
	 */
	public Via findByNombre(String nombre) throws DaoException;

}
