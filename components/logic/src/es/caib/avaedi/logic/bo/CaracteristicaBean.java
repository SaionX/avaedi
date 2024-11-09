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
import es.caib.avaedi.at4forms.common.util.FormData2Java;
import es.caib.avaedi.at4forms.logic.bo.BaseBean;
import es.caib.avaedi.at4forms.logic.bo.ListadoTransformer;
import es.caib.avaedi.common.model.Caracteristica;
import es.caib.avaedi.common.persistence.CaracteristicaDao;
import es.caib.avaedi.common.persistence.GrupoCaracteristicasDao;
import es.caib.avaedi.logic.util.TransferObjectFactory;
import es.caib.avaedi.logic.vo.CaracteristicaFormVO;
import es.caib.avaedi.logic.vo.CaracteristicaListadoVO;

/**
 * Bean negocio para tratar el formulario: Caracteristica
 * 
 * @author agarcia@at4.net
 * 
 */
@Repository("CaracteristicaBean")
public class CaracteristicaBean extends BaseBean<Caracteristica, CaracteristicaListadoVO, CaracteristicaFormVO> implements CaracteristicaBO {

	public CaracteristicaBean() {
		super(Caracteristica.class, CaracteristicaListadoVO.class, CaracteristicaFormVO.class);
	}

	/**
	 * Bean para acceder a los métodos de negocio: Caracteristica
	 */
	@Autowired
	@Qualifier("CaracteristicaDao")
	protected CaracteristicaDao mainDao;

	/**
	 * Bean para acceder a los métodos de negocio: Caracteristica
	 * 
	 * @param bean
	 *            the bean to set
	 */
	protected CaracteristicaDao getMainDao() {
		return this.mainDao;
	}

	/**
	 * DAO para acceder al modelo: GrupoCaracteristicas
	 */
	@Autowired
	@Qualifier("GrupoCaracteristicasDao")
	protected GrupoCaracteristicasDao grupoCaracteristicasDao;

	/**
	 * DAO para acceder al modelo: GrupoCaracteristicas
	 * 
	 * @param dao
	 *            the dao to set
	 */
	public void setGrupoCaracteristicasDao(GrupoCaracteristicasDao dao) {
		this.grupoCaracteristicasDao = dao;
	}

	/*
	 * Finders para relaciones
	 */

	@Override
	public ResultadoBusqueda<CaracteristicaListadoVO> findByGrupoCaracteristicas(int grupoCaracteristicasId) throws GenericBusinessException {
		return this.findByGrupoCaracteristicas(grupoCaracteristicasId, null, null);
	}

	@Override
	public ResultadoBusqueda<CaracteristicaListadoVO> findByGrupoCaracteristicas(int grupoCaracteristicasId, PagingConfig pagingConfig) throws GenericBusinessException {
		return this.findByGrupoCaracteristicas(grupoCaracteristicasId, pagingConfig, null);
	}

	@Override
	public ResultadoBusqueda<CaracteristicaListadoVO> findByGrupoCaracteristicas(int grupoCaracteristicasId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException {
		if (filters == null) {
			filters = new ArrayList<FilterConfig>();
		}
		if (pagingConfig == null) {
			pagingConfig = new PagingConfig();
		}
		filters.add(new FilterConfig(FilterConfig.TYPE_AUTO, "grupoCaracteristicas.id", FormData2Java.toString(grupoCaracteristicasId)));
		return this.getListado(filters, pagingConfig);
	}

	/**
	 * Rellena una instancia de Caracteristica con los datos recibidos de la
	 * capa de servicio
	 */
	protected Caracteristica setFormData(CaracteristicaFormVO formData, Caracteristica record) throws GenericBusinessException {

		if (record == null) {
			record = new Caracteristica();
		}
		try {
			//Copiamos las propiedades simples, excluyendo relaciones
			TransferObjectFactory.copyProperties(record, formData, new String[] { "valores", "grupoCaracteristicas" });

			//----- Relacion GrupoCaracteristicas
			record.setGrupoCaracteristicas(this.grupoCaracteristicasDao.findById(formData.getGrupoCaracteristicasId()));

			return record;

		} catch (TransferObjectCreateException e) {
			log.error(e.getMessage(), e);
			throw new GenericBusinessException(e);
		} catch (DaoException e) {
			log.error(e.getMessage(), e);
			throw new GenericBusinessException(e);
		}

	}

	private class LvoTransformer implements ListadoTransformer<Caracteristica, CaracteristicaListadoVO> {

		@Override
		public CaracteristicaListadoVO transform(Caracteristica instance, CaracteristicaListadoVO ret) {

			if (instance == null) {
				return null;
			}
			try {
				//Copiamos las propiedades simples, excluyendo relaciones
				TransferObjectFactory.copyProperties(ret, instance, new String[] { "grupoCaracteristicas", "valores" });

				ret.setGrupoCaracteristicasId(instance.getGrupoCaracteristicas().getId());
				ret.setGrupoCaracteristicasLabel(instance.getGrupoCaracteristicas().getNombreEs());

				return ret;
			} catch (TransferObjectCreateException e) {
				log.error(e.getMessage(), e);
				throw new FunctorException(e);
			}

		}

		@Override
		public CaracteristicaListadoVO transform(Caracteristica instance) {
			if (instance == null) {
				return null;
			}
			CaracteristicaListadoVO ret = new CaracteristicaListadoVO();
			return transform(instance, ret);
		}
	}

	private class FvoTransformer implements Transformer<Caracteristica, CaracteristicaFormVO> {

		@Override
		public CaracteristicaFormVO transform(Caracteristica instance) {
			if (instance == null) {
				return null;
			}
			CaracteristicaFormVO ret = new CaracteristicaFormVO();
			listadoTransformer().transform(instance, ret);

			/*
			 * Descomentar para pasar el valor de esta colección al formulario
			 * ret.setValores( new
			 * HashSet<ValorListadoVO>(CollectionUtils.collect
			 * (instance.getValores(), new ValorBean().listadoTransformer() ))
			 * );
			 */

			return ret;
		}

	}

	/**
	 * Transforma modelos a value objects
	 * 
	 * @return
	 */
	@Override
	public Transformer<Caracteristica, CaracteristicaFormVO> formTransformer() {

		return new FvoTransformer();

	}

	/**
	 * Transforma modelos a value objects
	 * 
	 * @return
	 */
	@Override
	public ListadoTransformer<Caracteristica, CaracteristicaListadoVO> listadoTransformer() {

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

		filterAssigments.put("grupoCaracteristicas", "grupoCaracteristicas.id");
		orderAssigments.put("grupoCaracteristicas", "grupoCaracteristicas.nombreEs");

		CriteriaUtils.normalizeFilters(filterAssigments, filters);
		CriteriaUtils.normalizeOrders(orderAssigments, pagingConfig);
	}

}
