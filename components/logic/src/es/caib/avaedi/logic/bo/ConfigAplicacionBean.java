package es.caib.avaedi.logic.bo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import es.caib.avaedi.at4forms.common.exception.DaoException;
import es.caib.avaedi.at4forms.common.exception.GenericBusinessException;
import es.caib.avaedi.at4forms.common.search.CriteriaUtils;
import es.caib.avaedi.at4forms.common.search.FilterConfig;
import es.caib.avaedi.at4forms.common.search.PagingConfig;
import es.caib.avaedi.at4forms.logic.bo.BaseBean;
import es.caib.avaedi.common.model.ConfigAplicacion;
import es.caib.avaedi.common.persistence.ConfigAplicacionDao;
import es.caib.avaedi.logic.vo.ConfigAplicacionFormVO;
import es.caib.avaedi.logic.vo.ConfigAplicacionListadoVO;

/**
 * Bean negocio para tratar el formulario: ConfigAplicacion
 * 
 * @author agarcia@at4.net
 * 
 */
@Repository("ConfigAplicacionBean")
public class ConfigAplicacionBean extends BaseBean<ConfigAplicacion, ConfigAplicacionListadoVO, ConfigAplicacionFormVO> implements ConfigAplicacionBO {

	public ConfigAplicacionBean() {
		super(ConfigAplicacion.class, ConfigAplicacionListadoVO.class, ConfigAplicacionFormVO.class);
	}

	/**
	 * Bean para acceder a los métodos de negocio: ConfigAplicacion
	 */
	@Autowired
	@Qualifier("ConfigAplicacionDao")
	protected ConfigAplicacionDao mainDao;

	/**
	 * Bean para acceder a los métodos de negocio: ConfigAplicacion
	 * 
	 * @param bean
	 *            the bean to set
	 */
	protected ConfigAplicacionDao getMainDao() {
		return this.mainDao;
	}

	/*
	 * Finders para relaciones
	 */

	/**
	 * Devuelve la instancia de ConfigAplicacionFormVO que cumple con la
	 * búsqueda findByEtiqueta
	 * 
	 * @param etiqueta
	 * @param nombre
	 * @param usuario
	 * @return la instancia de ConfigAplicacionFormVO
	 * @throws GenericBusinessException
	 */
	public ConfigAplicacionFormVO findByEtiqueta(String etiqueta, String nombre, String usuario) throws GenericBusinessException {
		try {
			return formTransformer().transform(this.mainDao.findByEtiqueta(etiqueta, nombre, usuario));
		} catch (DaoException e) {
			log.error(e.getMessage(), e);
			throw new GenericBusinessException(e);
		}
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

		CriteriaUtils.normalizeFilters(filterAssigments, filters);
		CriteriaUtils.normalizeOrders(orderAssigments, pagingConfig);
	}

}
