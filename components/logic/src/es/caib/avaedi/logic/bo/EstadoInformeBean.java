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
import es.caib.avaedi.common.model.EstadoInforme;
import es.caib.avaedi.common.persistence.EstadoInformeDao;
import es.caib.avaedi.logic.vo.EstadoInformeFormVO;
import es.caib.avaedi.logic.vo.EstadoInformeListadoVO;

/**
 * Bean negocio para tratar el formulario: EstadoInforme
 * 
 * @author agarcia@at4.net
 * 
 */
@Repository("EstadoInformeBean")
public class EstadoInformeBean extends BaseBean<EstadoInforme, EstadoInformeListadoVO, EstadoInformeFormVO> implements EstadoInformeBO {

	public EstadoInformeBean() {
		super(EstadoInforme.class, EstadoInformeListadoVO.class, EstadoInformeFormVO.class);
	}

	/**
	 * Bean para acceder a los métodos de negocio: EstadoInforme
	 */
	@Autowired
	@Qualifier("EstadoInformeDao")
	protected EstadoInformeDao mainDao;

	/**
	 * Bean para acceder a los métodos de negocio: EstadoInforme
	 * 
	 * @param bean
	 *            the bean to set
	 */
	protected EstadoInformeDao getMainDao() {
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
