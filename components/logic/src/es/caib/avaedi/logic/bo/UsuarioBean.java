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
import es.caib.avaedi.common.model.Usuario;
import es.caib.avaedi.common.persistence.MunicipioDao;
import es.caib.avaedi.common.persistence.UsuarioDao;
import es.caib.avaedi.logic.util.TransferObjectFactory;
import es.caib.avaedi.logic.vo.UsuarioFormVO;
import es.caib.avaedi.logic.vo.UsuarioListadoVO;

/**
 * Bean negocio para tratar el formulario: Usuario
 * 
 * @author agarcia@at4.net
 * 
 */
@Repository("UsuarioBean")
public class UsuarioBean extends BaseBean<Usuario, UsuarioListadoVO, UsuarioFormVO> implements UsuarioBO {

	public UsuarioBean() {
		super(Usuario.class, UsuarioListadoVO.class, UsuarioFormVO.class);
	}

	/**
	 * Bean para acceder a los métodos de negocio: Usuario
	 */
	@Autowired
	@Qualifier("UsuarioDao")
	protected UsuarioDao mainDao;

	/**
	 * Bean para acceder a los métodos de negocio: Usuario
	 * 
	 * @param bean
	 *            the bean to set
	 */
	protected UsuarioDao getMainDao() {
		return this.mainDao;
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
	public ResultadoBusqueda<UsuarioListadoVO> findByMunicipio(int municipioId) throws GenericBusinessException {
		return this.findByMunicipio(municipioId, null, null);
	}

	@Override
	public ResultadoBusqueda<UsuarioListadoVO> findByMunicipio(int municipioId, PagingConfig pagingConfig) throws GenericBusinessException {
		return this.findByMunicipio(municipioId, pagingConfig, null);
	}

	@Override
	public ResultadoBusqueda<UsuarioListadoVO> findByMunicipio(int municipioId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException {
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
	 * Devuelve la instancia de UsuarioFormVO que cumple con la búsqueda
	 * findUsuarioByUsername
	 * 
	 * @param username
	 * @return la instancia de UsuarioFormVO
	 * @throws GenericBusinessException
	 */
	public UsuarioFormVO findUsuarioByUsername(String username) throws GenericBusinessException {
		try {
			return formTransformer().transform(this.mainDao.findUsuarioByUsername(username));
		} catch (DaoException e) {
			log.error(e.getMessage(), e);
			throw new GenericBusinessException(e);
		}
	}

	/**
	 * Rellena una instancia de Usuario con los datos recibidos de la capa de
	 * servicio
	 */
	protected Usuario setFormData(UsuarioFormVO formData, Usuario record) throws GenericBusinessException {

		if (record == null) {
			record = new Usuario();
		}
		try {
			//Copiamos las propiedades simples, excluyendo relaciones
			TransferObjectFactory.copyProperties(record, formData, new String[] { "municipio" });

			//----- Relacion Municipio
			Integer municipioId = formData.getMunicipioId();
			if (municipioId != null) {
				record.setMunicipio(this.municipioDao.findById(municipioId));
			} else {
				record.setMunicipio(null);
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

	private class LvoTransformer implements ListadoTransformer<Usuario, UsuarioListadoVO> {

		@Override
		public UsuarioListadoVO transform(Usuario instance, UsuarioListadoVO ret) {

			if (instance == null) {
				return null;
			}
			try {
				//Copiamos las propiedades simples, excluyendo relaciones
				TransferObjectFactory.copyProperties(ret, instance, new String[] { "municipio" });

				if (instance.getMunicipio() != null) {
					ret.setMunicipioId(instance.getMunicipio().getClave());
					ret.setMunicipioLabel(instance.getMunicipio().getNombre());
				}

				return ret;
			} catch (TransferObjectCreateException e) {
				log.error(e.getMessage(), e);
				throw new FunctorException(e);
			}

		}

		@Override
		public UsuarioListadoVO transform(Usuario instance) {
			if (instance == null) {
				return null;
			}
			UsuarioListadoVO ret = new UsuarioListadoVO();
			return transform(instance, ret);
		}
	}

	private class FvoTransformer implements Transformer<Usuario, UsuarioFormVO> {

		@Override
		public UsuarioFormVO transform(Usuario instance) {
			if (instance == null) {
				return null;
			}
			UsuarioFormVO ret = new UsuarioFormVO();
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
	public Transformer<Usuario, UsuarioFormVO> formTransformer() {

		return new FvoTransformer();

	}

	/**
	 * Transforma modelos a value objects
	 * 
	 * @return
	 */
	@Override
	public ListadoTransformer<Usuario, UsuarioListadoVO> listadoTransformer() {

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
		filterAssigments.put("primaryLabel", "username");
		orderAssigments.put("primaryLabel", "username");

		filterAssigments.put("municipio", "municipio.clave");
		orderAssigments.put("municipio", "municipio.nombre");

		CriteriaUtils.normalizeFilters(filterAssigments, filters);
		CriteriaUtils.normalizeOrders(orderAssigments, pagingConfig);
	}

}
