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
import es.caib.avaedi.common.model.GrupoCaracteristicas;
import es.caib.avaedi.common.persistence.GrupoCaracteristicasDao;
import es.caib.avaedi.logic.vo.GrupoCaracteristicasFormVO;
import es.caib.avaedi.logic.vo.GrupoCaracteristicasListadoVO;

/**
 * Bean negocio para tratar el formulario: GrupoCaracteristicas
 * 
 * @author agarcia@at4.net
 * 
 */
@Repository("GrupoCaracteristicasBean")
public class GrupoCaracteristicasBean extends BaseBean<GrupoCaracteristicas, GrupoCaracteristicasListadoVO, GrupoCaracteristicasFormVO> implements GrupoCaracteristicasBO {

	public GrupoCaracteristicasBean() {
		super(GrupoCaracteristicas.class, GrupoCaracteristicasListadoVO.class, GrupoCaracteristicasFormVO.class);
	}

	/**
	 * Bean para acceder a los métodos de negocio: GrupoCaracteristicas
	 */
	@Autowired
	@Qualifier("GrupoCaracteristicasDao")
	protected GrupoCaracteristicasDao mainDao;

	/**
	 * Bean para acceder a los métodos de negocio: GrupoCaracteristicas
	 * 
	 * @param bean
	 *            the bean to set
	 */
	protected GrupoCaracteristicasDao getMainDao() {
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
		filterAssigments.put("primaryLabel", "nombreEs");
		orderAssigments.put("primaryLabel", "nombreEs");

		CriteriaUtils.normalizeFilters(filterAssigments, filters);
		CriteriaUtils.normalizeOrders(orderAssigments, pagingConfig);
	}

}
