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
import es.caib.avaedi.common.model.Edificio;
import es.caib.avaedi.common.model.TipoVia;
import es.caib.avaedi.common.model.Via;
import es.caib.avaedi.common.persistence.MunicipioDao;
import es.caib.avaedi.common.persistence.TipoViaDao;
import es.caib.avaedi.common.persistence.ViaDao;
import es.caib.avaedi.logic.server.vo.ViaRestVO;
import es.caib.avaedi.logic.util.TransferObjectFactory;
import es.caib.avaedi.logic.vo.ViaFormVO;
import es.caib.avaedi.logic.vo.ViaListadoVO;

/**
 * Bean negocio para tratar el formulario: Via
 * 
 * @author agarcia@at4.net
 * 
 */
@Repository("ViaBean")
public class ViaBean extends BaseBean<Via, ViaListadoVO, ViaFormVO> implements ViaBO {

	public ViaBean() {
		super(Via.class, ViaListadoVO.class, ViaFormVO.class);
	}

	/**
	 * Bean para acceder a los métodos de negocio: Via
	 */
	@Autowired
	@Qualifier("ViaDao")
	protected ViaDao mainDao;

	/**
	 * Bean para acceder a los métodos de negocio: Via
	 * 
	 * @param bean
	 *            the bean to set
	 */
	protected ViaDao getMainDao() {
		return this.mainDao;
	}

	/**
	 * DAO para acceder al modelo: TipoVia
	 */
	@Autowired
	@Qualifier("TipoViaDao")
	protected TipoViaDao tipoViaDao;

	/**
	 * DAO para acceder al modelo: TipoVia
	 * 
	 * @param dao
	 *            the dao to set
	 */
	public void setTipoViaDao(TipoViaDao dao) {
		this.tipoViaDao = dao;
	}

	/**
	 * DAO para acceder al modelo: Municipio
	 */
	@Autowired
	@Qualifier("MunicipioDao")
	protected MunicipioDao municipioDao;

	/**
	 * DAO para acceder al modelo: Municipio
	 * 
	 * @param dao
	 *            the dao to set
	 */
	public void setMunicipioDao(MunicipioDao dao) {
		this.municipioDao = dao;
	}

	/*
	 * Finders para relaciones
	 */

	@Override
	public ResultadoBusqueda<ViaListadoVO> findByTipoVia(int tipoViaId) throws GenericBusinessException {
		return this.findByTipoVia(tipoViaId, null, null);
	}

	@Override
	public ResultadoBusqueda<ViaListadoVO> findByTipoVia(int tipoViaId, PagingConfig pagingConfig) throws GenericBusinessException {
		return this.findByTipoVia(tipoViaId, pagingConfig, null);
	}

	@Override
	public ResultadoBusqueda<ViaListadoVO> findByTipoVia(int tipoViaId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException {
		if (filters == null) {
			filters = new ArrayList<FilterConfig>();
		}
		if (pagingConfig == null) {
			pagingConfig = new PagingConfig();
		}
		filters.add(new FilterConfig(FilterConfig.TYPE_AUTO, "tipoVia.clave", FormData2Java.toString(tipoViaId)));
		return this.getListado(filters, pagingConfig);
	}

	@Override
	public ResultadoBusqueda<ViaListadoVO> findByMunicipio(int municipioId) throws GenericBusinessException {
		return this.findByMunicipio(municipioId, null, null);
	}

	@Override
	public ResultadoBusqueda<ViaListadoVO> findByMunicipio(int municipioId, PagingConfig pagingConfig) throws GenericBusinessException {
		return this.findByMunicipio(municipioId, pagingConfig, null);
	}

	@Override
	public ResultadoBusqueda<ViaListadoVO> findByMunicipio(int municipioId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException {
		if (filters == null) {
			filters = new ArrayList<FilterConfig>();
		}
		if (pagingConfig == null) {
			pagingConfig = new PagingConfig();
		}
		filters.add(new FilterConfig(FilterConfig.TYPE_AUTO, "municipio.clave", FormData2Java.toString(municipioId)));
		return this.getListado(filters, pagingConfig);
	}

	/**
	 * Devuelve la instancia de ViaFormVO que cumple con la búsqueda
	 * findViaDeMunicipio
	 * 
	 * @param codigo
	 * @param municipioId
	 * @return la instancia de ViaFormVO
	 * @throws GenericBusinessException
	 */
	public ViaFormVO findViaDeMunicipio(int codigo, int municipioId) throws GenericBusinessException {
		try {
			return formTransformer().transform(this.mainDao.findViaDeMunicipio(codigo, municipioId));
		} catch (DaoException e) {
			log.error(e.getMessage(), e);
			throw new GenericBusinessException(e);
		}
	}

	/**
	 * Devuelve la instancia de ViaFormVO que cumple con la búsqueda
	 * findByCodigoCatastro
	 * 
	 * @param codigo
	 * @param municipio
	 * @return la instancia de ViaFormVO
	 * @throws GenericBusinessException
	 */
	public ViaFormVO findByCodigoCatastro(int codigo, int municipio) throws GenericBusinessException {
		try {
			return formTransformer().transform(this.mainDao.findByCodigoCatastro(codigo, municipio));
		} catch (DaoException e) {
			log.error(e.getMessage(), e);
			throw new GenericBusinessException(e);
		}
	}

	/**
	 * Devuelve la instancia de ViaFormVO que cumple con la búsqueda
	 * findViaDuplicada
	 * 
	 * @param nombre
	 * @param municipioId
	 * @param tipoViaId
	 * @return la instancia de ViaFormVO
	 * @throws GenericBusinessException
	 */
	public ViaFormVO findViaDuplicada(String nombre, int municipioId, int tipoViaId) throws GenericBusinessException {
		try {
			return formTransformer().transform(this.mainDao.findViaDuplicada(nombre, municipioId, tipoViaId));
		} catch (DaoException e) {
			log.error(e.getMessage(), e);
			throw new GenericBusinessException(e);
		}
	}

	/**
	 * Devuelve la instancia de ViaFormVO que cumple con la búsqueda
	 * findViaDeMunicipioNombre
	 * 
	 * @param nombre
	 * @param municipioId
	 * @return la instancia de ViaFormVO
	 * @throws GenericBusinessException
	 */
	public ViaFormVO findViaDeMunicipioNombre(String nombre, int municipioId) throws GenericBusinessException {
		try {
			return formTransformer().transform(this.mainDao.findViaDeMunicipioNombre(nombre, municipioId));
		} catch (DaoException e) {
			log.error(e.getMessage(), e);
			throw new GenericBusinessException(e);
		}
	}

	/**
	 * Devuelve la instancia de ViaFormVO que cumple con la búsqueda
	 * findByNombre
	 * 
	 * @param nombre
	 * @return la instancia de ViaFormVO
	 * @throws GenericBusinessException
	 */
	public ViaFormVO findByNombre(String nombre) throws GenericBusinessException {
		try {
			return formTransformer().transform(this.mainDao.findByNombre(nombre));
		} catch (DaoException e) {
			log.error(e.getMessage(), e);
			throw new GenericBusinessException(e);
		}
	}

	/**
	 * Rellena una instancia de Via con los datos recibidos de la capa de
	 * servicio
	 */
	protected Via setFormData(ViaFormVO formData, Via record) throws GenericBusinessException {

		if (record == null) {
			record = new Via();
		}
		try {
			//Copiamos las propiedades simples, excluyendo relaciones
			TransferObjectFactory.copyProperties(record, formData, new String[] { "municipio", "tipoVia" });

			//----- Relacion TipoVia
			record.setTipoVia(this.tipoViaDao.findById(formData.getTipoViaId()));

			//----- Relacion Municipio
			record.setMunicipio(this.municipioDao.findById(formData.getMunicipioId()));

			return record;

		} catch (TransferObjectCreateException e) {
			log.error(e.getMessage(), e);
			throw new GenericBusinessException(e);
		} catch (DaoException e) {
			log.error(e.getMessage(), e);
			throw new GenericBusinessException(e);
		}

	}

	private class LvoTransformer implements ListadoTransformer<Via, ViaListadoVO> {

		@Override
		public ViaListadoVO transform(Via instance, ViaListadoVO ret) {

			if (instance == null) {
				return null;
			}
			try {
				//Copiamos las propiedades simples, excluyendo relaciones
				TransferObjectFactory.copyProperties(ret, instance, new String[] { "municipio", "tipoVia" });

				ret.setTipoViaId(instance.getTipoVia().getClave());
				ret.setTipoViaLabel(instance.getTipoVia().getNombreEs());
				ret.setMunicipioId(instance.getMunicipio().getClave());
				ret.setMunicipioLabel(instance.getMunicipio().getNombre());

				return ret;
			} catch (TransferObjectCreateException e) {
				log.error(e.getMessage(), e);
				throw new FunctorException(e);
			}

		}

		@Override
		public ViaListadoVO transform(Via instance) {
			if (instance == null) {
				return null;
			}
			ViaListadoVO ret = new ViaListadoVO();
			return transform(instance, ret);
		}
	}

	private class FvoTransformer implements Transformer<Via, ViaFormVO> {

		@Override
		public ViaFormVO transform(Via instance) {
			if (instance == null) {
				return null;
			}
			ViaFormVO ret = new ViaFormVO();
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
	public Transformer<Via, ViaFormVO> formTransformer() {

		return new FvoTransformer();

	}

	/**
	 * Transforma modelos a value objects
	 * 
	 * @return
	 */
	@Override
	public ListadoTransformer<Via, ViaListadoVO> listadoTransformer() {

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
		filterAssigments.put("primaryLabel", "nombre");
		orderAssigments.put("primaryLabel", "nombre");

		filterAssigments.put("tipoVia", "tipoVia.clave");
		orderAssigments.put("tipoVia", "tipoVia.nombreEs");
		filterAssigments.put("municipio", "municipio.clave");
		orderAssigments.put("municipio", "municipio.nombre");

		CriteriaUtils.normalizeFilters(filterAssigments, filters);
		CriteriaUtils.normalizeOrders(orderAssigments, pagingConfig);
	}

	private class RestTransformer implements ListadoTransformer<Via, ViaRestVO> {

		@Override
		public ViaRestVO transform(Via instance, ViaRestVO ret) {

			if (instance == null) {
				return null;
			}
			ret.setClave(instance.getClave());

			TipoVia tipoVia = instance.getTipoVia();

			ret.setNombreCa(instance.getNombre() + " (" + tipoVia.getCodigoCatastro() + ")");
			ret.setNombreEs(instance.getNombre() + " (" + tipoVia.getCodigoCatastro() + ")");
			ret.setLastModified(instance.getLastModified());

			return ret;

		}

		@Override
		public ViaRestVO transform(Via instance) {
			if (instance == null) {
				return null;
			}
			ViaRestVO ret = new ViaRestVO();
			return transform(instance, ret);
		}
	}

	@Override
	public ResultadoBusqueda<ViaRestVO> restListado(Collection<FilterConfig> filters, PagingConfig pagingConfig) throws GenericBusinessException {

		return this.getListado(filters, pagingConfig, new RestTransformer());

	}
	public static String composeLabel(Via via){
		String viaLabel =  "["+ via.getTipoVia().getCodigoCatastro() + "] " + via.getNombre();
		return viaLabel;
	}

}
