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
import es.caib.avaedi.common.model.DeficienciaTipo;
import es.caib.avaedi.common.persistence.DeficienciaTipoDao;
import es.caib.avaedi.logic.vo.DeficienciaTipoFormVO;
import es.caib.avaedi.logic.vo.DeficienciaTipoListadoVO;

/**
 * Bean negocio para tratar el formulario: DeficienciaTipo
 * 
 * @author agarcia@at4.net
 * 
 */
@Repository("DeficienciaTipoBean")
public class DeficienciaTipoBean extends BaseBean<DeficienciaTipo, DeficienciaTipoListadoVO, DeficienciaTipoFormVO> implements DeficienciaTipoBO {

	public DeficienciaTipoBean() {
		super(DeficienciaTipo.class, DeficienciaTipoListadoVO.class, DeficienciaTipoFormVO.class);
	}

	/**
	 * Bean para acceder a los métodos de negocio: DeficienciaTipo
	 */
	@Autowired
	@Qualifier("DeficienciaTipoDao")
	protected DeficienciaTipoDao mainDao;

	/**
	 * Bean para acceder a los métodos de negocio: DeficienciaTipo
	 * 
	 * @param bean
	 *            the bean to set
	 */
	protected DeficienciaTipoDao getMainDao() {
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

		CriteriaUtils.normalizeFilters(filterAssigments, filters);
		CriteriaUtils.normalizeOrders(orderAssigments, pagingConfig);
	}

}
