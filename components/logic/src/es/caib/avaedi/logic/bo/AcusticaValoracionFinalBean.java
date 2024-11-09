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
import es.caib.avaedi.common.model.AcusticaValoracionFinal;
import es.caib.avaedi.common.persistence.AcusticaValoracionFinalDao;
import es.caib.avaedi.common.persistence.InspeccionDao;
import es.caib.avaedi.logic.util.TransferObjectFactory;
import es.caib.avaedi.logic.vo.AcusticaValoracionFinalFormVO;
import es.caib.avaedi.logic.vo.AcusticaValoracionFinalListadoVO;

/**
 * Bean negocio para tratar el formulario: AcusticaValoracionFinal
 * 
 * @author agarcia@at4.net
 * 
 */
@Repository("AcusticaValoracionFinalBean")
public class AcusticaValoracionFinalBean extends InspeccionBaseBean<AcusticaValoracionFinal, AcusticaValoracionFinalListadoVO, AcusticaValoracionFinalFormVO> implements AcusticaValoracionFinalBO {

	public AcusticaValoracionFinalBean() {
		super(AcusticaValoracionFinal.class, AcusticaValoracionFinalListadoVO.class, AcusticaValoracionFinalFormVO.class);
	}

	/**
	 * Bean para acceder a los métodos de negocio: AcusticaValoracionFinal
	 */
	@Autowired
	@Qualifier("AcusticaValoracionFinalDao")
	protected AcusticaValoracionFinalDao mainDao;

	/**
	 * Bean para acceder a los métodos de negocio: AcusticaValoracionFinal
	 * 
	 * @param bean
	 *            the bean to set
	 */
	protected AcusticaValoracionFinalDao getMainDao() {
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
	public ResultadoBusqueda<AcusticaValoracionFinalListadoVO> findByInspeccion(int inspeccionId) throws GenericBusinessException {
		return this.findByInspeccion(inspeccionId, null, null);
	}

	@Override
	public ResultadoBusqueda<AcusticaValoracionFinalListadoVO> findByInspeccion(int inspeccionId, PagingConfig pagingConfig) throws GenericBusinessException {
		return this.findByInspeccion(inspeccionId, pagingConfig, null);
	}

	@Override
	public ResultadoBusqueda<AcusticaValoracionFinalListadoVO> findByInspeccion(int inspeccionId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException {
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
	 * Rellena una instancia de AcusticaValoracionFinal con los datos recibidos
	 * de la capa de servicio
	 */
	protected AcusticaValoracionFinal setFormData(AcusticaValoracionFinalFormVO formData, AcusticaValoracionFinal record) throws GenericBusinessException {

		if (record == null) {
			record = new AcusticaValoracionFinal();
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

	private class LvoTransformer implements ListadoTransformer<AcusticaValoracionFinal, AcusticaValoracionFinalListadoVO> {

		@Override
		public AcusticaValoracionFinalListadoVO transform(AcusticaValoracionFinal instance, AcusticaValoracionFinalListadoVO ret) {

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
		public AcusticaValoracionFinalListadoVO transform(AcusticaValoracionFinal instance) {
			if (instance == null) {
				return null;
			}
			AcusticaValoracionFinalListadoVO ret = new AcusticaValoracionFinalListadoVO();
			return transform(instance, ret);
		}
	}

	private class FvoTransformer implements Transformer<AcusticaValoracionFinal, AcusticaValoracionFinalFormVO> {

		@Override
		public AcusticaValoracionFinalFormVO transform(AcusticaValoracionFinal instance) {
			if (instance == null) {
				return null;
			}
			AcusticaValoracionFinalFormVO ret = new AcusticaValoracionFinalFormVO();
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
	public Transformer<AcusticaValoracionFinal, AcusticaValoracionFinalFormVO> formTransformer() {

		return new FvoTransformer();

	}

	/**
	 * Transforma modelos a value objects
	 * 
	 * @return
	 */
	@Override
	public ListadoTransformer<AcusticaValoracionFinal, AcusticaValoracionFinalListadoVO> listadoTransformer() {

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
