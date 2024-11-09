package es.caib.avaedi.at4forms.common.audit;

import java.io.Serializable;
import java.util.Collection;

import es.caib.avaedi.at4forms.common.basedao.Model;
import es.caib.avaedi.at4forms.common.exception.DaoException;
import es.caib.avaedi.at4forms.common.search.FilterConfig;
import es.caib.avaedi.at4forms.common.search.PagingConfig;
import es.caib.avaedi.at4forms.common.search.ResultadoBusqueda;

/**
 * Interfaz de base con los métodos comunes a todos los dao
 * @author agarcia
 *
 */
public interface AuditoriaBaseDao<A extends BaseAudit<T>, T extends Model> {

    /**
     * Devuelve la instancia clave id
     * @param id
     * @return la instancia de clave id
     * @throws DaoException
     */
    public A findById(Serializable id) throws DaoException;

    /**
     * Ejecuta una búsqueda basada en filtros y paginada
     * @param filters
     * @param paginacion
     * @return los resultados de la búsqueda
     * @throws DaoException
     */
	public ResultadoBusqueda<A> searchByRecordId (
				Serializable id, 
				Collection<FilterConfig> filters, 
				PagingConfig paginacion
				) throws DaoException;
    
    /**
     * Ejecuta una búsqueda basada en filtros y paginada
     * @param filters
     * @param paginacion
     * @return los resultados de la búsqueda
     * @throws DaoException
     */
	public ResultadoBusqueda<A> searchByFilters (
				Collection<FilterConfig> filters, 
				PagingConfig paginacion
				) throws DaoException;

	
	
}

