/**
 *
 */
package es.caib.avaedi.at4forms.common.basedao;

import static org.hibernate.criterion.Example.create;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.metadata.ClassMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import es.caib.avaedi.at4forms.common.exception.DaoException;
import es.caib.avaedi.at4forms.common.persistence.service.HibernateService;
import es.caib.avaedi.at4forms.common.search.CriteriaUtils;
import es.caib.avaedi.at4forms.common.search.CriteriaUtilsException;
import es.caib.avaedi.at4forms.common.search.FilterConfig;
import es.caib.avaedi.at4forms.common.search.PagingConfig;
import es.caib.avaedi.at4forms.common.search.ResultadoBusqueda;
import es.caib.avaedi.at4forms.common.search.CriteriaUtils.QueryCriteria;
import es.caib.avaedi.at4forms.common.util.log.LogService;

import org.slf4j.Logger;


/**
 * Clase base de las implementaciones hibernate-spring de los dao
 *
 * @author  agarcia
 *
 */
public class BaseDaoImpl<T extends Model> implements BaseDao<T> {

	/**
	 * The logger object.
	 */
	private final static Logger log = LogService.getLogger(BaseDaoImpl.class);

	private Class<T> entityClass;
	
	@Autowired @Qualifier("sessionFactory")
	private SessionFactory sessionFactory = null;

	
	public BaseDaoImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

	public BaseDaoImpl(Class<T> entityClass, SessionFactory sessionFactory) {
		this(entityClass);
		this.setSessionFactory(sessionFactory);
	}

	
	/** Obtiene la SessionFactory de hibernate
	 *
	 * @return
	 * @throws HibernateException
	 */
	public SessionFactory getSessionFactory() throws HibernateException {
		if (this.sessionFactory == null) {
			this.sessionFactory = HibernateService.getSessionFactory();
		}
		return this.sessionFactory;
	}

	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * @param instance
	 * @return
	 * @throws DaoException
	 */
    @SuppressWarnings("unchecked")
	public T add(T instance) throws DaoException {
        log.debug("persisting instance");
        try {
			Serializable id = getSessionFactory().getCurrentSession().save(instance);
			T ret = (T)getSessionFactory().getCurrentSession().get(this.entityClass, id);
			//flush + refresh: importante para que se refresquen operaciones de triggers en bd, etc
			getSessionFactory().getCurrentSession().flush();
			getSessionFactory().getCurrentSession().refresh(ret);
			return ret;
        }
        catch (HibernateException re) {
            log.error("persist failed", re);
			throw new DaoException(re);
		} finally {
			log.debug("finished add instance");
		}
    }

    /**
     * @param instance
     * @throws DaoException
     */
    public void update(T instance) throws DaoException  {
        log.debug("updating instance");
		try {
			// Now update the data.
			getSessionFactory().getCurrentSession().update(instance);
			//flush + refresh: importante para que se refresquen operaciones de triggers en bd, etc
			getSessionFactory().getCurrentSession().flush();
			getSessionFactory().getCurrentSession().refresh(instance);
		} catch (HibernateException e) {
			log.error("update failed", e);
			throw new DaoException(e);
		} finally {
			log.debug("finished updating instance");
		}
    }

    /**
     * 
     * @param instance
     * @throws DaoException
     */
    public void delete(T instance) throws DaoException  {
        log.debug("deleting T instance");
		try {
			getSessionFactory().getCurrentSession().delete(instance);
		}
        catch (HibernateException e) {
			log.error("delete failed", e);
			throw new DaoException(e);
		} finally {
			log.debug("finished deleting T instance");
		}
    }

    /**
     * 
     * @param id
     * @throws DaoException
     */
    public void deleteById(Serializable id) throws DaoException  {
        log.debug("deleting T id");
		try {
			// First get the data.
			T instance = this.findById(id);
			getSessionFactory().getCurrentSession().delete(instance);
		}
        catch (HibernateException e) {
			log.error("delete failed", e);
			throw new DaoException(e);
		} finally {
			log.debug("finished deleting T id");
		}
    }

    /**
     * 
     * @return
     * @throws DaoException
     */
    @SuppressWarnings("unchecked")
    public List<T> searchAll() throws DaoException {
        log.debug("searchAll T");
        try {
	   		 Criteria criteria = this.getSessionFactory().getCurrentSession().createCriteria(this.entityClass);
			List<T> instances = (List<T>)criteria.list();
            if (instances.size()==0) {
                log.debug("get successful, no instance found");
            }
            else {
                log.debug("get successful, instances found");
            }
            return instances;
        }
        catch (HibernateException re) {
            log.error("get failed", re);
            throw new DaoException(re);
        }

    }
    
    @SuppressWarnings("unchecked")
	public T findById(Serializable id) throws DaoException  {
        log.debug("getting instance with id: " + id);
        try {
			T instance = (T) getSessionFactory().getCurrentSession().get(this.entityClass, id);
            if (instance==null) {
                log.debug("get successful, no instance found");
            }
            else {
                log.debug("get successful, instance found");
            }
            return instance;
        }
        catch (HibernateException re) {
            log.error("get failed", re);
            throw new DaoException(re);
        }
    }

    /**
     * 
     * @param instance
     * @return
     * @throws DaoException
     */
    @SuppressWarnings("unchecked")
    public List<T> searchByExample(T instance) throws DaoException  {
        log.debug("finding T instance by example");
        try {
            List<T> results = (List<T>) createCriteria() 
                    .add( create(instance).enableLike(MatchMode.ANYWHERE).excludeZeroes() )
            .list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        }
        catch (HibernateException re) {
            log.error("find by example failed", re);
            throw new DaoException(re);
        }
    } 
    
	/**
	 * @param class1
	 * @return criteria para la clase class1
	 */
	protected Criteria createCriteria() {
		return this.getSessionFactory().getCurrentSession().createCriteria(this.entityClass);
	}
    
	/**
	 * @param class1
	 * @return ClassMetadata para la clase
	 */
	protected ClassMetadata getClassMetadata() {
		return this.getSessionFactory().getClassMetadata(this.entityClass);
	}


	/**
	 * @param name
	 * @return la Query de nombre name
	 */
	protected Query getNamedQuery(String name) {
		return this.getSessionFactory().getCurrentSession().getNamedQuery(name);
	}

	
	/**
	 * 
	 * @param filters
	 * @param paginacion
	 * @return
	 * @throws DaoException
	 */
	public ResultadoBusqueda<T> searchByFilters (
				Collection<FilterConfig> filters, 
				PagingConfig paginacion
				) throws DaoException {

		QueryCriteria criteria = new QueryCriteria(createCriteria());
		QueryCriteria countCriteria = new QueryCriteria(createCriteria());

		try {
			CriteriaUtils.addFilters(
				this.entityClass,
				this.getSessionFactory(), 
				filters, 
				criteria, 
				countCriteria );
			return CriteriaUtils.getResultadoBusqueda(criteria, countCriteria, paginacion);

		} 
        catch (HibernateException e) {
			log.error("DataAccessException", e);
			throw new DaoException(e);
		} catch (CriteriaUtilsException e) {
			log.error("CriteriaUtilsException", e);
			throw new DaoException(e);
		} finally {
			log.debug("finished searchByFilters(Collection<FilterConfig> filters, PagingConfig paginacion)");
		}
	}    
	
}
