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
import es.caib.avaedi.common.model.Deficiencia;
import es.caib.avaedi.common.persistence.DeficienciaDao;
import es.caib.avaedi.common.persistence.DeficienciaTipoDao;
import es.caib.avaedi.common.persistence.InspeccionDao;
import es.caib.avaedi.logic.util.TransferObjectFactory;
import es.caib.avaedi.logic.vo.DeficienciaFormVO;
import es.caib.avaedi.logic.vo.DeficienciaListadoVO;

/**
 * Bean negocio para tratar el formulario: Deficiencia
 * 
 * @author agarcia@at4.net
 * 
 */
@Repository("DeficienciaBean")
public class DeficienciaBean extends BaseBean<Deficiencia, DeficienciaListadoVO, DeficienciaFormVO> implements DeficienciaBO {

	public DeficienciaBean() {
		super(Deficiencia.class, DeficienciaListadoVO.class, DeficienciaFormVO.class);
	}

	/**
	 * Bean para acceder a los métodos de negocio: Deficiencia
	 */
	@Autowired
	@Qualifier("DeficienciaDao")
	protected DeficienciaDao mainDao;

	/**
	 * Bean para acceder a los métodos de negocio: Deficiencia
	 * 
	 * @param bean
	 *            the bean to set
	 */
	protected DeficienciaDao getMainDao() {
		return this.mainDao;
	}

	/**
	 * DAO para acceder al modelo: DeficienciaTipo
	 */
	@Autowired
	@Qualifier("DeficienciaTipoDao")
	protected DeficienciaTipoDao deficienciaTipoDao;

	/**
	 * DAO para acceder al modelo: DeficienciaTipo
	 * 
	 * @param dao
	 *            the dao to set
	 */
	public void setDeficienciaTipoDao(DeficienciaTipoDao dao) {
		this.deficienciaTipoDao = dao;
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
	public ResultadoBusqueda<DeficienciaListadoVO> findByDeficienciaTipo(int deficienciaTipoId) throws GenericBusinessException {
		return this.findByDeficienciaTipo(deficienciaTipoId, null, null);
	}

	@Override
	public ResultadoBusqueda<DeficienciaListadoVO> findByDeficienciaTipo(int deficienciaTipoId, PagingConfig pagingConfig) throws GenericBusinessException {
		return this.findByDeficienciaTipo(deficienciaTipoId, pagingConfig, null);
	}

	@Override
	public ResultadoBusqueda<DeficienciaListadoVO> findByDeficienciaTipo(int deficienciaTipoId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException {
		if (filters == null) {
			filters = new ArrayList<FilterConfig>();
		}
		if (pagingConfig == null) {
			pagingConfig = new PagingConfig();
		}
		filters.add(new FilterConfig(FilterConfig.TYPE_AUTO, "deficienciaTipo.id", FormData2Java.toString(deficienciaTipoId)));
		return this.getListado(filters, pagingConfig);
	}

	@Override
	public ResultadoBusqueda<DeficienciaListadoVO> findByInspeccion(int inspeccionId) throws GenericBusinessException {
		return this.findByInspeccion(inspeccionId, null, null);
	}

	@Override
	public ResultadoBusqueda<DeficienciaListadoVO> findByInspeccion(int inspeccionId, PagingConfig pagingConfig) throws GenericBusinessException {
		return this.findByInspeccion(inspeccionId, pagingConfig, null);
	}

	@Override
	public ResultadoBusqueda<DeficienciaListadoVO> findByInspeccion(int inspeccionId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException {
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
	 * Rellena una instancia de Deficiencia con los datos recibidos de la capa
	 * de servicio
	 */
	protected Deficiencia setFormData(DeficienciaFormVO formData, Deficiencia record) throws GenericBusinessException {

		if (record == null) {
			record = new Deficiencia();
		}
		try {
			//Copiamos las propiedades simples, excluyendo relaciones
			TransferObjectFactory.copyProperties(record, formData, new String[] { "inspeccion", "deficienciaTipo" });

			//----- Relacion DeficienciaTipo
			record.setDeficienciaTipo(this.deficienciaTipoDao.findById(formData.getDeficienciaTipoId()));

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

	private class LvoTransformer implements ListadoTransformer<Deficiencia, DeficienciaListadoVO> {

		@Override
		public DeficienciaListadoVO transform(Deficiencia instance, DeficienciaListadoVO ret) {

			if (instance == null) {
				return null;
			}
			try {
				//Copiamos las propiedades simples, excluyendo relaciones
				TransferObjectFactory.copyProperties(ret, instance, new String[] { "inspeccion", "deficienciaTipo" });

				ret.setDeficienciaTipoId(instance.getDeficienciaTipo().getId());
				ret.setDeficienciaTipoLabel(instance.getDeficienciaTipo().getNombre());
				ret.setInspeccionId(instance.getInspeccion().getId());
				ret.setInspeccionLabel(FormData2Java.toString(instance.getInspeccion().getId()));

				return ret;
			} catch (TransferObjectCreateException e) {
				log.error(e.getMessage(), e);
				throw new FunctorException(e);
			}

		}

		@Override
		public DeficienciaListadoVO transform(Deficiencia instance) {
			if (instance == null) {
				return null;
			}
			DeficienciaListadoVO ret = new DeficienciaListadoVO();
			return transform(instance, ret);
		}
	}

	private class FvoTransformer implements Transformer<Deficiencia, DeficienciaFormVO> {

		@Override
		public DeficienciaFormVO transform(Deficiencia instance) {
			if (instance == null) {
				return null;
			}
			DeficienciaFormVO ret = new DeficienciaFormVO();
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
	public Transformer<Deficiencia, DeficienciaFormVO> formTransformer() {

		return new FvoTransformer();

	}

	/**
	 * Transforma modelos a value objects
	 * 
	 * @return
	 */
	@Override
	public ListadoTransformer<Deficiencia, DeficienciaListadoVO> listadoTransformer() {

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

		filterAssigments.put("deficienciaTipo", "deficienciaTipo.id");
		orderAssigments.put("deficienciaTipo", "deficienciaTipo.id");
		filterAssigments.put("inspeccion", "inspeccion.id");
		orderAssigments.put("inspeccion", "inspeccion.id");

		CriteriaUtils.normalizeFilters(filterAssigments, filters);
		CriteriaUtils.normalizeOrders(orderAssigments, pagingConfig);
	}

}
