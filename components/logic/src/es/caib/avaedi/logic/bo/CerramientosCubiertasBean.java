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
import es.caib.avaedi.common.model.CerramientosCubiertas;
import es.caib.avaedi.common.persistence.CerramientosCubiertasDao;
import es.caib.avaedi.common.persistence.InspeccionDao;
import es.caib.avaedi.logic.util.TransferObjectFactory;
import es.caib.avaedi.logic.vo.CerramientosCubiertasFormVO;
import es.caib.avaedi.logic.vo.CerramientosCubiertasListadoVO;

/**
 * Bean negocio para tratar el formulario: CerramientosCubiertas
 * 
 * @author agarcia@at4.net
 * 
 */
@Repository("CerramientosCubiertasBean")
public class CerramientosCubiertasBean extends InspeccionBaseBean<CerramientosCubiertas, CerramientosCubiertasListadoVO, CerramientosCubiertasFormVO> implements CerramientosCubiertasBO {

	public CerramientosCubiertasBean() {
		super(CerramientosCubiertas.class, CerramientosCubiertasListadoVO.class, CerramientosCubiertasFormVO.class);
	}

	/**
	 * Bean para acceder a los métodos de negocio: CerramientosCubiertas
	 */
	@Autowired
	@Qualifier("CerramientosCubiertasDao")
	protected CerramientosCubiertasDao mainDao;

	/**
	 * Bean para acceder a los métodos de negocio: CerramientosCubiertas
	 * 
	 * @param bean
	 *            the bean to set
	 */
	protected CerramientosCubiertasDao getMainDao() {
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
	public ResultadoBusqueda<CerramientosCubiertasListadoVO> findByInspeccion(int inspeccionId) throws GenericBusinessException {
		return this.findByInspeccion(inspeccionId, null, null);
	}

	@Override
	public ResultadoBusqueda<CerramientosCubiertasListadoVO> findByInspeccion(int inspeccionId, PagingConfig pagingConfig) throws GenericBusinessException {
		return this.findByInspeccion(inspeccionId, pagingConfig, null);
	}

	@Override
	public ResultadoBusqueda<CerramientosCubiertasListadoVO> findByInspeccion(int inspeccionId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException {
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
	 * Rellena una instancia de CerramientosCubiertas con los datos recibidos de
	 * la capa de servicio
	 */
	protected CerramientosCubiertas setFormData(CerramientosCubiertasFormVO formData, CerramientosCubiertas record) throws GenericBusinessException {

		if (record == null) {
			record = new CerramientosCubiertas();
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

	private class LvoTransformer implements ListadoTransformer<CerramientosCubiertas, CerramientosCubiertasListadoVO> {

		@Override
		public CerramientosCubiertasListadoVO transform(CerramientosCubiertas instance, CerramientosCubiertasListadoVO ret) {

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
		public CerramientosCubiertasListadoVO transform(CerramientosCubiertas instance) {
			if (instance == null) {
				return null;
			}
			CerramientosCubiertasListadoVO ret = new CerramientosCubiertasListadoVO();
			return transform(instance, ret);
		}
	}

	private class FvoTransformer implements Transformer<CerramientosCubiertas, CerramientosCubiertasFormVO> {

		@Override
		public CerramientosCubiertasFormVO transform(CerramientosCubiertas instance) {
			if (instance == null) {
				return null;
			}
			CerramientosCubiertasFormVO ret = new CerramientosCubiertasFormVO();
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
	public Transformer<CerramientosCubiertas, CerramientosCubiertasFormVO> formTransformer() {

		return new FvoTransformer();

	}

	/**
	 * Transforma modelos a value objects
	 * 
	 * @return
	 */
	@Override
	public ListadoTransformer<CerramientosCubiertas, CerramientosCubiertasListadoVO> listadoTransformer() {

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
