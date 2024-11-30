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
import es.caib.avaedi.common.model.Informe;
import es.caib.avaedi.common.persistence.EdificioDao;
import es.caib.avaedi.common.persistence.EstadoInformeDao;
import es.caib.avaedi.common.persistence.InformeDao;
import es.caib.avaedi.common.persistence.InspeccionDao;
import es.caib.avaedi.logic.util.TransferObjectFactory;
import es.caib.avaedi.logic.vo.InformeFormVO;
import es.caib.avaedi.logic.vo.InformeListadoVO;

/**
 * Bean negocio para tratar el formulario: Informe
 * 
 * @author agarcia@at4.net
 * 
 */
@Repository("InformeBean")
public class InformeBean extends BaseBean<Informe, InformeListadoVO, InformeFormVO> implements InformeBO {

	public InformeBean() {
		super(Informe.class, InformeListadoVO.class, InformeFormVO.class);
	}

	/**
	 * Bean para acceder a los métodos de negocio: Informe
	 */
	@Autowired
	@Qualifier("InformeDao")
	protected InformeDao mainDao;

	/**
	 * Bean para acceder a los métodos de negocio: Informe
	 * 
	 * @param bean
	 *            the bean to set
	 */
	protected InformeDao getMainDao() {
		return this.mainDao;
	}

	/**
	 * DAO para acceder al modelo: EstadoInforme
	 */
	@Autowired
	@Qualifier("EstadoInformeDao")
	protected EstadoInformeDao estadoInformeDao;

	/**
	 * DAO para acceder al modelo: EstadoInforme
	 * 
	 * @param dao
	 *            the dao to set
	 */
	public void setEstadoInformeDao(EstadoInformeDao dao) {
		this.estadoInformeDao = dao;
	}

	/**
	 * DAO para acceder al modelo: Edificio
	 */
	@Autowired
	@Qualifier("EdificioDao")
	protected EdificioDao edificioDao;

	/**
	 * DAO para acceder al modelo: Edificio
	 * 
	 * @param dao
	 *            the dao to set
	 */
	public void setEdificioDao(EdificioDao dao) {
		this.edificioDao = dao;
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
	public ResultadoBusqueda<InformeListadoVO> findByEstadoInforme(int estadoInformeId) throws GenericBusinessException {
		return this.findByEstadoInforme(estadoInformeId, null, null);
	}

	@Override
	public ResultadoBusqueda<InformeListadoVO> findByEstadoInforme(int estadoInformeId, PagingConfig pagingConfig) throws GenericBusinessException {
		return this.findByEstadoInforme(estadoInformeId, pagingConfig, null);
	}

	@Override
	public ResultadoBusqueda<InformeListadoVO> findByEstadoInforme(int estadoInformeId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException {
		if (filters == null) {
			filters = new ArrayList<FilterConfig>();
		}
		if (pagingConfig == null) {
			pagingConfig = new PagingConfig();
		}
		filters.add(new FilterConfig(FilterConfig.TYPE_AUTO, "estadoInforme.clave", FormData2Java.toString(estadoInformeId)));
		return this.getListado(filters, pagingConfig);
	}

	@Override
	public ResultadoBusqueda<InformeListadoVO> findByEdificio(int edificioId) throws GenericBusinessException {
		return this.findByEdificio(edificioId, null, null);
	}

	@Override
	public ResultadoBusqueda<InformeListadoVO> findByEdificio(int edificioId, PagingConfig pagingConfig) throws GenericBusinessException {
		return this.findByEdificio(edificioId, pagingConfig, null);
	}

	@Override
	public ResultadoBusqueda<InformeListadoVO> findByEdificio(int edificioId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException {
		if (filters == null) {
			filters = new ArrayList<FilterConfig>();
		}
		if (pagingConfig == null) {
			pagingConfig = new PagingConfig();
		}
		filters.add(new FilterConfig(FilterConfig.TYPE_AUTO, "edificio.clave", FormData2Java.toString(edificioId)));
		return this.getListado(filters, pagingConfig);
	}

	/**
	 * Rellena una instancia de Informe con los datos recibidos de la capa de
	 * servicio
	 */
	protected Informe setFormData(InformeFormVO formData, Informe record) throws GenericBusinessException {

		if (record == null) {
			record = new Informe();
		}
		try {
			//Copiamos las propiedades simples, excluyendo relaciones
			TransferObjectFactory.copyProperties(record, formData, new String[] { "inspeccion", "edificio", "estadoInforme", "renovacio", "subsana", "tipusIee" });

			//----- Relacion EstadoInforme
			record.setEstadoInforme(this.estadoInformeDao.findById(formData.getEstadoInformeId()));

			//----- Relacion Edificio
			record.setEdificio(this.edificioDao.findById(formData.getEdificioId()));

			//----- Relacion Inspeccion
			record.setInspeccion(this.inspeccionDao.findById(formData.getInspeccionId()));

			record.setRenovacio(formData.getRenovacio() != null ? formData.getRenovacio() : false );
			record.setSubsana(formData.getSubsana() != null ? formData.getSubsana() : false );
			if (formData.getTipusIee() != null)
				record.setTipusIee(formData.getTipusIee());

			return record;

		} catch (TransferObjectCreateException e) {
			log.error(e.getMessage(), e);
			throw new GenericBusinessException(e);
		} catch (DaoException e) {
			log.error(e.getMessage(), e);
			throw new GenericBusinessException(e);
		}

	}

	private class LvoTransformer implements ListadoTransformer<Informe, InformeListadoVO> {

		@Override
		public InformeListadoVO transform(Informe instance, InformeListadoVO ret) {

			if (instance == null) {
				return null;
			}
			try {
				//Copiamos las propiedades simples, excluyendo relaciones
				TransferObjectFactory.copyProperties(ret, instance, new String[] { "inspeccion", "edificio", "estadoInforme" });

				ret.setEstadoInformeId(instance.getEstadoInforme().getClave());
				ret.setEstadoInformeLabel(instance.getEstadoInforme().getNombreEs());
				ret.setEdificioId(instance.getEdificio().getClave());
				String edificioLabel = EdificioBean.composeLabel(instance.getEdificio());
				ret.setEdificioLabel(edificioLabel);
				ret.setMunicipioId(instance.getEdificio().getVia().getMunicipio().getClave());
				ret.setMunicipioLabel(instance.getEdificio().getVia().getMunicipio().getNombre());

				if (instance.getInspeccion() != null) {
					ret.setInspeccionId(instance.getInspeccion().getId());
					ret.setInspeccionLabel(FormData2Java.toString(instance.getInspeccion().getId()));
				}

				return ret;
			} catch (TransferObjectCreateException e) {
				log.error(e.getMessage(), e);
				throw new FunctorException(e);
			}

		}

		@Override
		public InformeListadoVO transform(Informe instance) {
			if (instance == null) {
				return null;
			}
			InformeListadoVO ret = new InformeListadoVO();
			return transform(instance, ret);
		}
	}

	private class FvoTransformer implements Transformer<Informe, InformeFormVO> {

		@Override
		public InformeFormVO transform(Informe instance) {
			if (instance == null) {
				return null;
			}
			InformeFormVO ret = new InformeFormVO();
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
	public Transformer<Informe, InformeFormVO> formTransformer() {

		return new FvoTransformer();

	}

	/**
	 * Transforma modelos a value objects
	 * 
	 * @return
	 */
	@Override
	public ListadoTransformer<Informe, InformeListadoVO> listadoTransformer() {

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
		filterAssigments.put("primaryLabel", "clave");
		orderAssigments.put("primaryLabel", "clave");
		
		filterAssigments.put("municipio", "edificio.via.municipio.clave");
		orderAssigments.put("municipio", "edificio.via.municipio.nombre");

		filterAssigments.put("estadoInforme", "estadoInforme.clave");
		orderAssigments.put("estadoInforme", "estadoInforme.nombreEs");
		filterAssigments.put("edificio", "edificio.clave");
		orderAssigments.put("edificio", "edificio.referenciaCatastral");
		filterAssigments.put("inspeccion", "inspeccion.id");
		orderAssigments.put("inspeccion", "inspeccion.id");

		CriteriaUtils.normalizeFilters(filterAssigments, filters);
		CriteriaUtils.normalizeOrders(orderAssigments, pagingConfig);
	}

}
