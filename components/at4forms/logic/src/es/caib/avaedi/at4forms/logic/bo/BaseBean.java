package es.caib.avaedi.at4forms.logic.bo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.security.RolesAllowed;

import org.apache.commons.collections4.FunctorException;
import org.apache.commons.collections4.Transformer;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import org.slf4j.Logger;

import es.caib.avaedi.at4forms.common.basedao.BaseDao;
import es.caib.avaedi.at4forms.common.basedao.Model;
import es.caib.avaedi.at4forms.common.exception.DaoException;
import es.caib.avaedi.at4forms.common.exception.GenericBusinessException;
import es.caib.avaedi.at4forms.common.exception.TransferObjectCreateException;
import es.caib.avaedi.at4forms.common.persistence.service.HibernateService;
import es.caib.avaedi.at4forms.common.search.FilterConfig;
import es.caib.avaedi.at4forms.common.search.PagingConfig;
import es.caib.avaedi.at4forms.common.search.ResultadoBusqueda;
import es.caib.avaedi.at4forms.common.util.log.LogService;
import es.caib.avaedi.at4forms.logic.vo.FormVO;
import es.caib.avaedi.at4forms.logic.vo.ListadoVO;
import es.caib.avaedi.common.realm.Constants;
import es.caib.avaedi.logic.util.TransferObjectFactory;


/**
 * Clase base sobre la que construir los beans de negocio.
 *
 * @author agarcia
 *
 */
@Transactional (rollbackFor = GenericBusinessException.class)
public abstract class BaseBean<T extends Model, LO extends ListadoVO, FO extends FormVO> implements BaseBO<LO, FO> {

	private Class<T> modelClass;
	private Class<LO> listadoVoClass;
	private Class<FO> formVoClass;
	
	private SessionFactory sessionFactory = null;

	/**
	 * El objeto logger
	 */
	protected static final Logger log = LogService.getLogger(BaseBean.class);
	
	public BaseBean(Class<T> modelClass, Class<LO> lvoClass, Class<FO> fvoClass) {
        this.modelClass = modelClass;
        this.listadoVoClass = lvoClass;
        this.formVoClass = fvoClass;
    }

	/**
	 * DAO para acceder al modelo
	 */
	protected abstract BaseDao<T> getMainDao();

	/**
	 * Modifica los filtros adecuándolos a su uso por los dao.
	 * @param filters
	 * @param pagingConfig
	 */
	abstract protected void normalizeFilters(Collection<FilterConfig> filters, PagingConfig pagingConfig);
	
	
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

	/* ************************** Métodos del acceso al modelo ************************************ */

	/**
	 * @ejb.create-method view-type="both"
	 */
	public ResultadoBusqueda<LO> getListado(Collection<FilterConfig> filters,
			PagingConfig pagingConfig) throws GenericBusinessException {

		return this.getListado(filters, pagingConfig, listadoTransformer());

	}

	/**
	 * @ejb.create-method view-type="both"
	 */
	public ResultadoBusqueda<LO> getListado() throws GenericBusinessException {

		return this.getListado(new ArrayList<FilterConfig>(), new PagingConfig(), listadoTransformer());

	}
	

	/**
	 * Ejecuta un listado, aplicando un transformer arbitrario al resultado
	 * @param <D>
	 * @param filters
	 * @param pagingConfig
	 * @param transformer
	 * @return
	 * @throws GenericBusinessException
	 */
	protected <D> ResultadoBusqueda<D> getListado(Collection<FilterConfig> filters,
			PagingConfig pagingConfig, Transformer<T,D> transformer) throws GenericBusinessException {

		try {
			this.normalizeFilters(filters, pagingConfig);
			ResultadoBusqueda<T> daoResult = this.getMainDao().searchByFilters(filters, pagingConfig);
			ResultadoBusqueda<D> result = new ResultadoBusqueda<D>(daoResult, transformer );
			return result;
		} catch (DaoException sbe) {
			String error = sbe.getMessage();
			log.error(error, sbe);
			throw new GenericBusinessException(sbe);
		}
	}


	

	/**
	 * @ejb.interface-method view-type="both"
	 */
	public FO load(Serializable id) throws GenericBusinessException {
		return this.load(id, formTransformer());
	}

	/**
	 * Carga un registro, aplicando una transformación arbitraria al resultado
	 * @ejb.interface-method view-type="both"
	 */
	public <D> D load(Serializable id, Transformer<T,D> transformer) throws GenericBusinessException {
		try {
			T instance = this.getMainDao().findById( id );
			if (instance == null) {
				return null;
			} else {
				return transformer.transform(instance);
			}
			
		} catch (DaoException sbe) {
			String error = sbe.getMessage();
			log.error(error, sbe);
			throw new GenericBusinessException(sbe);
		}
	}
	

	/**
	 * @ejb.interface-method view-type="both"
	 */
	@RolesAllowed(Constants.ADMIN + "," + Constants.OPERADOR)
	public FO add(FO formData)
			throws GenericBusinessException {
		try {
			T newRecord = this.setFormData (formData, null);
			newRecord = this.getMainDao().add(newRecord);
			return formTransformer().transform(newRecord);
		} catch (DaoException sbe) {
			String error = sbe.getMessage();
			log.error(error, sbe);
			throw new GenericBusinessException(sbe);
		}
	}


	/**
	 * @ejb.interface-method view-type="both"
	 */
	@RolesAllowed(Constants.ADMIN + "," + Constants.OPERADOR)
	public FO update(Serializable id, FO formData)
			throws GenericBusinessException {
		try {
			T recordToUpdate = this.getMainDao().findById( id );
			this.setFormData(formData, recordToUpdate);
			this.getMainDao().update(recordToUpdate);
			return formTransformer().transform(recordToUpdate);
		} catch (DaoException sbe) {
			String error = sbe.getMessage();
			log.error(error, sbe);
			throw new GenericBusinessException(sbe);
		}
	}


	/**
	 * @ejb.interface-method view-type="both"
	 */
	@RolesAllowed(Constants.ADMIN + "," + Constants.OPERADOR)
	public boolean delete(Serializable id) throws GenericBusinessException {
		try {
			this.getMainDao().deleteById( id );
			return true;
		} catch (DaoException sbe) {
			String error = sbe.getMessage();
			log.error(error, sbe);
			throw new GenericBusinessException(sbe);
		}
	}

	/**
	 * Rellena una instancia  con los datos recibidos de la capa de servicio
	 */
	protected T setFormData(FO formData, T record)
			throws GenericBusinessException {

		try {
			if (record == null) {
				record = this.modelClass.newInstance();
			}
			//Copiamos las propiedades simples, excluyendo relaciones
			TransferObjectFactory.copyProperties(record, formData, new String[]{});
			return record;

		} catch (TransferObjectCreateException e) {
			log.error(e.getMessage(), e);
			throw new GenericBusinessException(e);
		} catch (InstantiationException e) {
			log.error(e.getMessage(), e);
			throw new GenericBusinessException(e);
		} catch (IllegalAccessException e) {
			log.error(e.getMessage(), e);
			throw new GenericBusinessException(e);
		}
	}



	private class LvoTransformer implements ListadoTransformer<T, LO> {

		private Class<LO> lvoClass;

		public LvoTransformer (Class<LO> clazz) {
			this.lvoClass = clazz;
		}
		
		@Override
		public LO transform(T instance, LO ret) {

			if (instance == null) {
				return null;
			}
			try {
				TransferObjectFactory.copyProperties(ret, instance, new String[]{});
		    	return ret;
			} catch (TransferObjectCreateException e) {
				log.error(e.getMessage(), e);
				throw new FunctorException(e);
			}
			
		}

		@Override
		public LO transform(T instance) {
			if (instance == null) {
				return null;
			}
			try {
				LO ret = this.lvoClass.newInstance();
				return transform(instance, ret);
			} catch (InstantiationException e) {
				log.error(e.getMessage(), e);
				throw new FunctorException(e);
			} catch (IllegalAccessException e) {
				log.error(e.getMessage(), e);
				throw new FunctorException(e);
			}
		
		}
	}
	
	private class FvoTransformer implements Transformer<T, FO> {

		private Class<FO> fvoClass;

		public FvoTransformer (Class<FO> clazz) {
			this.fvoClass = clazz;
		}
		
		@SuppressWarnings("unchecked")
		@Override
		public FO transform(T instance) {
			if (instance == null) {
				return null;
			}
			try {
				FO ret = this.fvoClass.newInstance();
				listadoTransformer().transform(instance, (LO) ret);
		    	return ret;
			} catch (InstantiationException e) {
				log.error(e.getMessage(), e);
				throw new FunctorException(e);
			} catch (IllegalAccessException e) {
				log.error(e.getMessage(), e);
				throw new FunctorException(e);
			}
			
		}
		
    }
	
	/**
	 * Transforma modelos a value objects
	 * @return
	 */
	public Transformer<T, FO> formTransformer() {

		return new FvoTransformer(this.formVoClass);
		
	}

	/**
	 * Transforma modelos a value objects
	 * @return
	 */
	public ListadoTransformer<T, LO> listadoTransformer() {

		return new LvoTransformer(this.listadoVoClass);
		
	}



	@Override
	public FO newModel() throws GenericBusinessException {
		try {
			return this.formVoClass.newInstance();
		} catch (InstantiationException e) {
			log.error(e.getMessage(), e);
			throw new GenericBusinessException(e);
		} catch (IllegalAccessException e) {
			log.error(e.getMessage(), e);
			throw new GenericBusinessException(e);
		}
	}

	
	
}
