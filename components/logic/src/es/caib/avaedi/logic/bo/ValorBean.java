package es.caib.avaedi.logic.bo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections4.FunctorException;
import org.apache.commons.collections4.Transformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import es.caib.avaedi.at4forms.common.exception.DaoException;
import es.caib.avaedi.at4forms.common.exception.GenericBusinessException;
import es.caib.avaedi.at4forms.common.exception.TransferObjectCreateException;
import es.caib.avaedi.at4forms.common.search.CriteriaUtils;
import es.caib.avaedi.at4forms.common.search.FilterConfig;
import es.caib.avaedi.at4forms.common.search.PagingConfig;
import es.caib.avaedi.at4forms.common.search.ResultadoBusqueda;
import es.caib.avaedi.at4forms.logic.bo.BaseBean;
import es.caib.avaedi.at4forms.logic.bo.ListadoTransformer;
import es.caib.avaedi.common.model.Valor;
import es.caib.avaedi.common.model.ValorId;
import es.caib.avaedi.common.persistence.CaracteristicaDao;
import es.caib.avaedi.common.persistence.ValorDao;
import es.caib.avaedi.logic.util.TransferObjectFactory;
import es.caib.avaedi.logic.vo.ValorFormVO;
import es.caib.avaedi.logic.vo.ValorListadoVO;

/**
 * Bean negocio para tratar el formulario: Valor
 * 
 * @author agarcia@at4.net
 * 
 */
@Repository("ValorBean")
public class ValorBean extends BaseBean<Valor, ValorListadoVO, ValorFormVO> implements ValorBO {

	public ValorBean() {
		super(Valor.class, ValorListadoVO.class, ValorFormVO.class);
	}

	/**
	 * Bean para acceder a los métodos de negocio: Valor
	 */
	@Autowired
	@Qualifier("ValorDao")
	protected ValorDao mainDao;

	/**
	 * Bean para acceder a los métodos de negocio: Valor
	 * 
	 * @param bean
	 *            the bean to set
	 */
	protected ValorDao getMainDao() {
		return this.mainDao;
	}

	/**
	 * DAO para acceder al modelo: Caracteristica
	 */
	@Autowired
	@Qualifier("CaracteristicaDao")
	protected CaracteristicaDao caracteristicaDao;

	/**
	 * DAO para acceder al modelo: Caracteristica
	 * 
	 * @param dao
	 *            the dao to set
	 */
	public void setCaracteristicaDao(CaracteristicaDao dao) {
		this.caracteristicaDao = dao;
	}

	/*
	 * Finders para relaciones
	 */

	@Override
	public ResultadoBusqueda<ValorListadoVO> findByCaracteristica(java.lang.String caracteristicaId) throws GenericBusinessException {
		return this.findByCaracteristica(caracteristicaId, null, null);
	}

	@Override
	public ResultadoBusqueda<ValorListadoVO> findByCaracteristica(java.lang.String caracteristicaId, PagingConfig pagingConfig) throws GenericBusinessException {
		return this.findByCaracteristica(caracteristicaId, pagingConfig, null);
	}

	@Override
	public ResultadoBusqueda<ValorListadoVO> findByCaracteristica(java.lang.String caracteristicaId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException {
		if (filters == null) {
			filters = new ArrayList<FilterConfig>();
		}
		if (pagingConfig == null) {
			pagingConfig = new PagingConfig();
		}
		filters.add(new FilterConfig(FilterConfig.TYPE_AUTO, "caracteristica.caracteristica", caracteristicaId.toString()));
		return this.getListado(filters, pagingConfig);
	}

	/**
	 * Rellena una instancia de Valor con los datos recibidos de la capa de
	 * servicio
	 */
	protected Valor setFormData(ValorFormVO formData, Valor record) throws GenericBusinessException {

		if (record == null) {
			record = new Valor();
		}
		try {
			//Copiamos las propiedades simples, excluyendo relaciones
			TransferObjectFactory.copyProperties(record, formData, new String[] { "caracteristica" });

			//fks de clave compuesta id 
			if (record.getId() == null) {
				record.setId(new ValorId());
			}
			record.getId().setCaracteristica(formData.getCaracteristicaId());

			//----- Relacion Caracteristica
			if (formData.getCaracteristicaId() != null) {
				record.setCaracteristica(this.caracteristicaDao.findById(formData.getCaracteristicaId()));
			} else {
				record.setCaracteristica(null);
			}

			return record;

		} catch (TransferObjectCreateException e) {
			log.error(e.getMessage(), e);
			throw new GenericBusinessException(e);
		} catch (DaoException e) {
			log.error(e.getMessage(), e);
			throw new GenericBusinessException(e);
		}

	}

	private class LvoTransformer implements ListadoTransformer<Valor, ValorListadoVO> {

		@Override
		public ValorListadoVO transform(Valor instance, ValorListadoVO ret) {

			if (instance == null) {
				return null;
			}
			try {
				//Copiamos las propiedades simples, excluyendo relaciones
				TransferObjectFactory.copyProperties(ret, instance, new String[] { "caracteristica" });

				ret.setCaracteristicaId(instance.getCaracteristica().getCaracteristica());
				ret.setCaracteristicaLabel(instance.getCaracteristica().getNombreEs());

				return ret;
			} catch (TransferObjectCreateException e) {
				log.error(e.getMessage(), e);
				throw new FunctorException(e);
			}

		}

		@Override
		public ValorListadoVO transform(Valor instance) {
			if (instance == null) {
				return null;
			}
			ValorListadoVO ret = new ValorListadoVO();
			return transform(instance, ret);
		}
	}

	private class FvoTransformer implements Transformer<Valor, ValorFormVO> {

		@Override
		public ValorFormVO transform(Valor instance) {
			if (instance == null) {
				return null;
			}
			ValorFormVO ret = new ValorFormVO();
			listadoTransformer().transform(instance, ret);

			return ret;
		}

	}

	/**
	 * Transforma modelos a value objects
	 * 
	 * @return
	 */
	@Override
	public Transformer<Valor, ValorFormVO> formTransformer() {

		return new FvoTransformer();

	}

	/**
	 * Transforma modelos a value objects
	 * 
	 * @return
	 */
	@Override
	public ListadoTransformer<Valor, ValorListadoVO> listadoTransformer() {

		return new LvoTransformer();

	}

	/**
	 * Modifica los filtros adecuándolos a su uso por los dao.
	 * 
	 * @param filters
	 * @param pagingConfig
	 */
	protected void normalizeFilters(Collection<FilterConfig> filters, PagingConfig pagingConfig) {

		Map<String, String> filterAssigments = new HashMap<String, String>();
		Map<String, String> orderAssigments = new HashMap<String, String>();
		filterAssigments.put("primaryLabel", "nombreEs");
		orderAssigments.put("primaryLabel", "nombreEs");

		//Clave compuesta id 
		filterAssigments.put("id", "id#id");
		orderAssigments.put("id", "id#nombreEs");
		filterAssigments.put("caracteristica", "caracteristica.caracteristica");
		orderAssigments.put("caracteristica", "caracteristica.nombreEs");

		CriteriaUtils.normalizeFilters(filterAssigments, filters);
		CriteriaUtils.normalizeOrders(orderAssigments, pagingConfig);
	}
	


    /**
     * Devuelve la instancia de ValorFormVO que cumple con la búsqueda findBy
     * @param caracteristica
     * @param valId
     * @return la instancia de ValorFormVO
     * @throws GenericBusinessException
     */
	@Override
    public ValorFormVO findByCarId(String caracteristica, int valId) throws GenericBusinessException {
        try {
    	    return formTransformer().transform(this.mainDao.findByCarId(caracteristica, valId));
		} catch (DaoException e) {
			log.error(e.getMessage(), e);
			throw new GenericBusinessException(e);
		}
    }


}
