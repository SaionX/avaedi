package es.caib.avaedi.at4forms.common.basedao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import es.caib.avaedi.at4forms.common.exception.DaoException;
import es.caib.avaedi.at4forms.common.search.FilterConfig;
import es.caib.avaedi.at4forms.common.search.PagingConfig;
import es.caib.avaedi.at4forms.common.search.ResultadoBusqueda;

/**
 * Interfaz de base con los métodos comunes a todos los dao
 * @author agarcia
 *
 */
public interface BaseDao<T extends Model> {

	/**
	 * Inserta una nueva instancia
	 * @param instance
	 * @return la instancia recién insertada
	 * @throws DaoException
	 */
    public T add(T instance) throws DaoException;

    /**
     * Actualiza la instancia instance
     * @param instance
     * @throws DaoException
     */
    public void update(T instance) throws DaoException ;
    
    /**
     * Elimina la instancia instance
     * @param instance
     * @throws DaoException
     */
    public void delete(T instance) throws DaoException ;

    /**
     * Elimina la instancia instance
     * @param instance
     * @throws DaoException
     */
    public void deleteById(Serializable id) throws DaoException ;
    
    /**
     * Devuelve todas las instancias de T
     * @return las instancias
     * @throws DaoException
     */
    public List<T> searchAll() throws DaoException;
    
    /**
     * Devuelve la instancia clave id
     * @param id
     * @return la instancia de clave id
     * @throws DaoException
     */
    public T findById(Serializable id) throws DaoException;
    
    /**
     * Ejecuta una búsqueda "basada en el ejemplo" (query by example)
     * @param instance
     * @return los resultados de la búsqueda
     * @throws DaoException
     */
    public List<T> searchByExample(T instance) throws DaoException;

    /**
     * Ejecuta una búsqueda basada en filtros y paginada
     * @param filters
     * @param paginacion
     * @return los resultados de la búsqueda
     * @throws DaoException
     */
	public ResultadoBusqueda<T> searchByFilters (
				Collection<FilterConfig> filters, 
				PagingConfig paginacion
				) throws DaoException;

	
	
}

