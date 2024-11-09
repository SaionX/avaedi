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
import es.caib.avaedi.at4forms.logic.bo.ListadoTransformer;
import es.caib.avaedi.common.model.EficienciasEnergeticas;
import es.caib.avaedi.common.persistence.EficienciasEnergeticasDao;
import es.caib.avaedi.common.persistence.InspeccionDao;
import es.caib.avaedi.logic.util.TransferObjectFactory;
import es.caib.avaedi.logic.vo.EficienciasEnergeticasFormVO;
import es.caib.avaedi.logic.vo.EficienciasEnergeticasListadoVO;

/**
 * Bean negocio para tratar el formulario: EficienciasEnergeticas
 * 
 * @author agarcia@at4.net
 * 
 */
@Repository("EficienciasEnergeticasBean")
public class EficienciasEnergeticasBean extends InspeccionBaseBean<EficienciasEnergeticas, EficienciasEnergeticasListadoVO, EficienciasEnergeticasFormVO> implements EficienciasEnergeticasBO {

	public EficienciasEnergeticasBean() {
		super(EficienciasEnergeticas.class, EficienciasEnergeticasListadoVO.class, EficienciasEnergeticasFormVO.class);
	}

	/**
	 * Bean para acceder a los métodos de negocio: EficienciasEnergeticas
	 */
	@Autowired
	@Qualifier("EficienciasEnergeticasDao")
	protected EficienciasEnergeticasDao mainDao;

	/**
	 * Bean para acceder a los métodos de negocio: EficienciasEnergeticas
	 * 
	 * @param bean
	 *            the bean to set
	 */
	protected EficienciasEnergeticasDao getMainDao() {
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
	public ResultadoBusqueda<EficienciasEnergeticasListadoVO> findByInspeccion(int inspeccionId) throws GenericBusinessException {
		return this.findByInspeccion(inspeccionId, null, null);
	}

	@Override
	public ResultadoBusqueda<EficienciasEnergeticasListadoVO> findByInspeccion(int inspeccionId, PagingConfig pagingConfig) throws GenericBusinessException {
		return this.findByInspeccion(inspeccionId, pagingConfig, null);
	}

	@Override
	public ResultadoBusqueda<EficienciasEnergeticasListadoVO> findByInspeccion(int inspeccionId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException {
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
	 * Rellena una instancia de EficienciasEnergeticas con los datos recibidos
	 * de la capa de servicio
	 */
	protected EficienciasEnergeticas setFormData(EficienciasEnergeticasFormVO formData, EficienciasEnergeticas record) throws GenericBusinessException {

		if (record == null) {
			record = new EficienciasEnergeticas();
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

	private class LvoTransformer implements ListadoTransformer<EficienciasEnergeticas, EficienciasEnergeticasListadoVO> {

		@Override
		public EficienciasEnergeticasListadoVO transform(EficienciasEnergeticas instance, EficienciasEnergeticasListadoVO ret) {

			if (instance == null) {
				return null;
			}
			try {
				//Copiamos las propiedades simples, excluyendo relaciones
				TransferObjectFactory.copyProperties(ret, instance, new String[] { "inspeccion" });

				setDatosInspeccion(ret, instance.getInspeccion());

				return ret;
			} catch (TransferObjectCreateException e) {
				log.error(e.getMessage(), e);
				throw new FunctorException(e);
			}

		}

		@Override
		public EficienciasEnergeticasListadoVO transform(EficienciasEnergeticas instance) {
			if (instance == null) {
				return null;
			}
			EficienciasEnergeticasListadoVO ret = new EficienciasEnergeticasListadoVO();
			return transform(instance, ret);
		}
	}

	private class FvoTransformer implements Transformer<EficienciasEnergeticas, EficienciasEnergeticasFormVO> {

		@Override
		public EficienciasEnergeticasFormVO transform(EficienciasEnergeticas instance) {
			if (instance == null) {
				return null;
			}
			EficienciasEnergeticasFormVO ret = new EficienciasEnergeticasFormVO();
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
	public Transformer<EficienciasEnergeticas, EficienciasEnergeticasFormVO> formTransformer() {

		return new FvoTransformer();

	}

	/**
	 * Transforma modelos a value objects
	 * 
	 * @return
	 */
	@Override
	public ListadoTransformer<EficienciasEnergeticas, EficienciasEnergeticasListadoVO> listadoTransformer() {

		return new LvoTransformer();

	}

	/**
	 * Modifica los filtros adecuándolos a su uso por los dao.
	 * 
	 * @param filters
	 * @param pagingConfig
	 */
	protected void normalizeFilters(Collection<FilterConfig> filters, PagingConfig pagingConfig) {

		Map<String, String> filterAssigments = this.getBaseFilters();
		Map<String, String> orderAssigments = this.getBaseOrders();
		filterAssigments.put("primaryLabel", "claveInforme");
		orderAssigments.put("primaryLabel", "claveInforme");

		filterAssigments.put("inspeccion", "inspeccion.id");
		orderAssigments.put("inspeccion", "inspeccion.id");

		CriteriaUtils.normalizeFilters(filterAssigments, filters);
		CriteriaUtils.normalizeOrders(orderAssigments, pagingConfig);
	}

}
