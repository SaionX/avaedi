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
import es.caib.avaedi.common.model.Isla;
import es.caib.avaedi.common.persistence.IslaDao;
import es.caib.avaedi.logic.vo.IslaFormVO;
import es.caib.avaedi.logic.vo.IslaListadoVO;

/**
 * Bean negocio para tratar el formulario: Isla
 * 
 * @author agarcia@at4.net
 * 
 */
@Repository("IslaBean")
public class IslaBean extends BaseBean<Isla, IslaListadoVO, IslaFormVO> implements IslaBO {

	public IslaBean() {
		super(Isla.class, IslaListadoVO.class, IslaFormVO.class);
	}

	/**
	 * Bean para acceder a los métodos de negocio: Isla
	 */
	@Autowired
	@Qualifier("IslaDao")
	protected IslaDao mainDao;

	/**
	 * Bean para acceder a los métodos de negocio: Isla
	 * 
	 * @param bean
	 *            the bean to set
	 */
	protected IslaDao getMainDao() {
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
		filterAssigments.put("primaryLabel", "nombre");
		orderAssigments.put("primaryLabel", "nombre");

		CriteriaUtils.normalizeFilters(filterAssigments, filters);
		CriteriaUtils.normalizeOrders(orderAssigments, pagingConfig);
	}

}
