package es.caib.avaedi.logic.bo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import es.caib.avaedi.at4forms.common.search.CriteriaUtils;
import es.caib.avaedi.at4forms.common.search.FilterConfig;
import es.caib.avaedi.at4forms.common.search.PagingConfig;
import es.caib.avaedi.at4forms.logic.bo.BaseBean;
import es.caib.avaedi.common.model.EstadoAplicacion;
import es.caib.avaedi.common.persistence.EstadoAplicacionDao;
import es.caib.avaedi.logic.vo.EstadoAplicacionFormVO;
import es.caib.avaedi.logic.vo.EstadoAplicacionListadoVO;

/**
 * Bean negocio para tratar el formulario: EstadoAplicacion
 * 
 * @author agarcia@at4.net
 * 
 */
@Repository("EstadoAplicacionBean")
public class EstadoAplicacionBean extends BaseBean<EstadoAplicacion, EstadoAplicacionListadoVO, EstadoAplicacionFormVO> implements EstadoAplicacionBO {

	public EstadoAplicacionBean() {
		super(EstadoAplicacion.class, EstadoAplicacionListadoVO.class, EstadoAplicacionFormVO.class);
	}

	/**
	 * Bean para acceder a los métodos de negocio: EstadoAplicacion
	 */
	@Autowired
	@Qualifier("EstadoAplicacionDao")
	protected EstadoAplicacionDao mainDao;

	/**
	 * Bean para acceder a los métodos de negocio: EstadoAplicacion
	 * 
	 * @param bean
	 *            the bean to set
	 */
	protected EstadoAplicacionDao getMainDao() {
		return this.mainDao;
	}

	/*
	 * Finders para relaciones
	 */

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

		//Clave compuesta id 
		filterAssigments.put("username", "id#username");
		orderAssigments.put("username", "id#id");
		filterAssigments.put("nombre", "id#nombre");
		orderAssigments.put("nombre", "id#id");

		CriteriaUtils.normalizeFilters(filterAssigments, filters);
		CriteriaUtils.normalizeOrders(orderAssigments, pagingConfig);
	}

}
