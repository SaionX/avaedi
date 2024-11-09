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
import es.caib.avaedi.common.model.ValoracionParcial;
import es.caib.avaedi.common.persistence.InspeccionDao;
import es.caib.avaedi.common.persistence.ValoracionParcialDao;
import es.caib.avaedi.logic.util.TransferObjectFactory;
import es.caib.avaedi.logic.vo.ValoracionParcialFormVO;
import es.caib.avaedi.logic.vo.ValoracionParcialListadoVO;

/**
 * Bean negocio para tratar el formulario: ValoracionParcial
 * 
 * @author agarcia@at4.net
 * 
 */
@Repository("ValoracionParcialBean")
public class ValoracionParcialBean extends BaseBean<ValoracionParcial, ValoracionParcialListadoVO, ValoracionParcialFormVO> implements ValoracionParcialBO {

	public ValoracionParcialBean() {
		super(ValoracionParcial.class, ValoracionParcialListadoVO.class, ValoracionParcialFormVO.class);
	}

	/**
	 * Bean para acceder a los métodos de negocio: ValoracionParcial
	 */
	@Autowired
	@Qualifier("ValoracionParcialDao")
	protected ValoracionParcialDao mainDao;

	/**
	 * Bean para acceder a los métodos de negocio: ValoracionParcial
	 * 
	 * @param bean
	 *            the bean to set
	 */
	protected ValoracionParcialDao getMainDao() {
		return this.mainDao;
	}

	/**
	 * DAO para acceder al modelo: Inspeccion
	 */
	@Autowired
	@Qualifier("InspeccionDao")
	protected InspeccionDao inspeccionDao;

	/**
	 * DAO para acceder al modelo: Inspeccion
	 * 
	 * @param dao
	 *            the dao to set
	 */
	public void setInspeccionDao(InspeccionDao dao) {
		this.inspeccionDao = dao;
	}

	/*
	 * Finders para relaciones
	 */

	@Override
	public ResultadoBusqueda<ValoracionParcialListadoVO> findByInspeccion(int inspeccionId) throws GenericBusinessException {
		return this.findByInspeccion(inspeccionId, null, null);
	}

	@Override
	public ResultadoBusqueda<ValoracionParcialListadoVO> findByInspeccion(int inspeccionId, PagingConfig pagingConfig) throws GenericBusinessException {
		return this.findByInspeccion(inspeccionId, pagingConfig, null);
	}

	@Override
	public ResultadoBusqueda<ValoracionParcialListadoVO> findByInspeccion(int inspeccionId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException {
		if (filters == null) {
			filters = new ArrayList<FilterConfig>();
		}
		if (pagingConfig == null) {
			pagingConfig = new PagingConfig();
		}
		filters.add(new FilterConfig(FilterConfig.TYPE_AUTO, "inspeccion.id", FormData2Java.toString(inspeccionId)));
		return this.getListado(filters, pagingConfig);
	}

	/**
	 * Rellena una instancia de ValoracionParcial con los datos recibidos de la
	 * capa de servicio
	 */
	protected ValoracionParcial setFormData(ValoracionParcialFormVO formData, ValoracionParcial record) throws GenericBusinessException {

		if (record == null) {
			record = new ValoracionParcial();
		}
		try {
			//Copiamos las propiedades simples, excluyendo relaciones
			TransferObjectFactory.copyProperties(record, formData, new String[] { "inspeccion" });

			//----- Relacion Inspeccion
			record.setInspeccion(this.inspeccionDao.findById(formData.getInspeccionId()));

			return record;

		} catch (TransferObjectCreateException e) {
			log.error(e.getMessage(), e);
			throw new GenericBusinessException(e);
		} catch (DaoException e) {
			log.error(e.getMessage(), e);
			throw new GenericBusinessException(e);
		}

	}

	private class LvoTransformer implements ListadoTransformer<ValoracionParcial, ValoracionParcialListadoVO> {

		@Override
		public ValoracionParcialListadoVO transform(ValoracionParcial instance, ValoracionParcialListadoVO ret) {

			if (instance == null) {
				return null;
			}
			try {
				//Copiamos las propiedades simples, excluyendo relaciones
				TransferObjectFactory.copyProperties(ret, instance, new String[] { "inspeccion" });

				ret.setInspeccionId(instance.getInspeccion().getId());
				ret.setInspeccionLabel(FormData2Java.toString(instance.getInspeccion().getId()));

				return ret;
			} catch (TransferObjectCreateException e) {
				log.error(e.getMessage(), e);
				throw new FunctorException(e);
			}

		}

		@Override
		public ValoracionParcialListadoVO transform(ValoracionParcial instance) {
			if (instance == null) {
				return null;
			}
			ValoracionParcialListadoVO ret = new ValoracionParcialListadoVO();
			return transform(instance, ret);
		}
	}

	private class FvoTransformer implements Transformer<ValoracionParcial, ValoracionParcialFormVO> {

		@Override
		public ValoracionParcialFormVO transform(ValoracionParcial instance) {
			if (instance == null) {
				return null;
			}
			ValoracionParcialFormVO ret = new ValoracionParcialFormVO();
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
	public Transformer<ValoracionParcial, ValoracionParcialFormVO> formTransformer() {

		return new FvoTransformer();

	}

	/**
	 * Transforma modelos a value objects
	 * 
	 * @return
	 */
	@Override
	public ListadoTransformer<ValoracionParcial, ValoracionParcialListadoVO> listadoTransformer() {

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
		filterAssigments.put("primaryLabel", "id");
		orderAssigments.put("primaryLabel", "id");

		filterAssigments.put("inspeccion", "inspeccion.id");
		orderAssigments.put("inspeccion", "inspeccion.id");

		CriteriaUtils.normalizeFilters(filterAssigments, filters);
		CriteriaUtils.normalizeOrders(orderAssigments, pagingConfig);
	}

}
