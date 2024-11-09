package es.caib.avaedi.logic.bo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import es.caib.avaedi.at4forms.common.exception.DaoException;
import es.caib.avaedi.at4forms.common.exception.GenericBusinessException;
import es.caib.avaedi.at4forms.common.search.CriteriaUtils;
import es.caib.avaedi.at4forms.common.search.FilterConfig;
import es.caib.avaedi.at4forms.common.search.PagingConfig;
import es.caib.avaedi.at4forms.logic.bo.BaseBean;
import es.caib.avaedi.common.model.ConfigExportacion;
import es.caib.avaedi.common.persistence.ConfigExportacionDao;
import es.caib.avaedi.logic.vo.ConfigExportacionFormVO;
import es.caib.avaedi.logic.vo.ConfigExportacionListadoVO;

/**
 * Bean negocio para tratar el formulario: ConfigExportacion
 * 
 * @author agarcia@at4.net
 * 
 */
@Repository("ConfigExportacionBean")
public class ConfigExportacionBean extends BaseBean<ConfigExportacion, ConfigExportacionListadoVO, ConfigExportacionFormVO> implements ConfigExportacionBO {

	public ConfigExportacionBean() {
		super(ConfigExportacion.class, ConfigExportacionListadoVO.class, ConfigExportacionFormVO.class);
	}

	/**
	 * Bean para acceder a los métodos de negocio: ConfigExportacion
	 */
	@Autowired
	@Qualifier("ConfigExportacionDao")
	protected ConfigExportacionDao mainDao;

	/**
	 * Bean para acceder a los métodos de negocio: ConfigExportacion
	 * 
	 * @param bean
	 *            the bean to set
	 */
	protected ConfigExportacionDao getMainDao() {
		return this.mainDao;
	}

	/*
	 * Finders para relaciones
	 */

	/**
	 * Devuelve la instancia de ConfigExportacionFormVO que cumple con la
	 * búsqueda findByEtiqueta
	 * 
	 * @param etiqueta
	 * @param nombre
	 * @param usuario
	 * @return la instancia de ConfigExportacionFormVO
	 * @throws GenericBusinessException
	 */
	public ConfigExportacionFormVO findByEtiqueta(String etiqueta, String nombre, String usuario) throws GenericBusinessException {
		try {
			return formTransformer().transform(this.mainDao.findByEtiqueta(etiqueta, nombre, usuario));
		} catch (DaoException e) {
			log.error(e.getMessage(), e);
			throw new GenericBusinessException(e);
		}
	}

	/**
	 * Devuelve la lista de instancias ConfigExportacionListadoVO que cumplen
	 * con la búsqueda searchAvailables
	 * 
	 * @param nombre
	 * @param usuario
	 * @return la lista de instancias
	 * @throws GenericBusinessException
	 */
	@Override
	public Collection<ConfigExportacionListadoVO> searchAvailables(String nombre, String usuario) throws GenericBusinessException {
		try {
			return CollectionUtils.collect(this.mainDao.searchAvailables(nombre, usuario), listadoTransformer());
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
