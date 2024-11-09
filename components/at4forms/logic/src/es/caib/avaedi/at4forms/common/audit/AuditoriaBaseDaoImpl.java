/**
 *
 */
package es.caib.avaedi.at4forms.common.audit;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Table;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.metadata.ClassMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import es.caib.avaedi.at4forms.common.basedao.Model;
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
public class AuditoriaBaseDaoImpl<A extends BaseAudit<T>, T extends Model> implements AuditoriaBaseDao<A, T> {

	/**
	 * The logger object.
	 */
	private final static Logger log = LogService.getLogger(AuditoriaBaseDaoImpl.class);

	private Class<A> auditClass;
	private String tableName;
	
	@Autowired @Qualifier("sessionFactory")
	private SessionFactory sessionFactory = null;

	private Class<T> typeClass;

	
	public AuditoriaBaseDaoImpl(Class<A> auditClass, Class<T> typeClass) {
	   this.tableName = auditClass.getAnnotation(Table.class).name();
       this.auditClass = auditClass;
	   this.typeClass = typeClass;
    }

	public AuditoriaBaseDaoImpl(Class<A> entityClass, Class<T> typeClass, SessionFactory sessionFactory) {
		this(entityClass, typeClass);
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

    @SuppressWarnings("unchecked")
	public A findById(Serializable id) throws DaoException  {
        log.debug("getting instance with id: " + id);
        try {
			A instance = (A) getSessionFactory().getCurrentSession().get(this.auditClass, id);
            if (instance==null) {
                log.debug("get successful, no instance found");
            }
            else {
                log.debug("get successful, instance found");
            }
            return populateRecords(instance);
        }
        catch (HibernateException re) {
            log.error("get failed", re);
            throw new DaoException(re);
        }
    }

	/**
	 * @param class1
	 * @return criteria para la clase class1
	 */
	protected Criteria createCriteria() {
		return this.getSessionFactory().getCurrentSession().createCriteria(this.auditClass);
	}
    
	/**
	 * @param class1
	 * @return ClassMetadata para la clase
	 */
	protected ClassMetadata getClassMetadata() {
		return this.getSessionFactory().getClassMetadata(this.auditClass);
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
	public ResultadoBusqueda<A> searchByFilters (
				Collection<FilterConfig> filters, 
				PagingConfig paginacion
				) throws DaoException {

		QueryCriteria criteria = new QueryCriteria(createCriteria());
		QueryCriteria countCriteria = new QueryCriteria(createCriteria());

		try {
			
			CriteriaUtils.addFilters(
				this.auditClass,
				this.getSessionFactory(), 
				filters, 
				criteria, 
				countCriteria );
			ResultadoBusqueda<A> res = CriteriaUtils.getResultadoBusqueda(criteria, countCriteria, paginacion);
			return this.populateRecords(res);

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

	@Override
	public ResultadoBusqueda<A> searchByRecordId(Serializable id, Collection<FilterConfig> filters, PagingConfig paginacion) throws DaoException {
		if (filters == null) {
			filters = new ArrayList<FilterConfig>();
			filters.add(new FilterConfig("newRecordId", id.toString()));
		}
		return this.searchByFilters(filters, paginacion);
	}    

   @SuppressWarnings("unchecked")
   private T getNewRecord(long id) {
	   Query query = this.getSessionFactory().getCurrentSession().createSQLQuery("SELECT (audit_new).* from audit." + tableName + " where audit_id = ?")
	   .addEntity(typeClass);
	   query.setLong(0, id);
	   return (T) query.uniqueResult();
	}   
   @SuppressWarnings("unchecked")
   private T getOldRecord(long id) {
	   Query query = this.getSessionFactory().getCurrentSession().createSQLQuery("SELECT (audit_old).* from audit." + tableName + " where audit_id = ?")
	   .addEntity(typeClass);
	   query.setLong(0, id);
	   return (T) query.uniqueResult();
	}   
	
	
	private ResultadoBusqueda<A> populateRecords(ResultadoBusqueda<A> res) {
		for (A r : res.getResultados()) {
			this.populateRecords(r);
		}
		return res;
	}
	private A populateRecords(A instance) {
		
		instance.setNewRecord( this.getNewRecord(instance.getId()) );
		if (instance.getAction() == AuditConstants.OPERATION_TYPE_UPDATE) { //Sólo los updates tienen oldRecord
			instance.setOldRecord( this.getOldRecord(instance.getId()) );
		}
		
		return instance;
	}
   
}
