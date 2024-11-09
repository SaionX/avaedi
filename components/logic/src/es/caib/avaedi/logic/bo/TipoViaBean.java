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
import es.caib.avaedi.common.model.TipoVia;
import es.caib.avaedi.common.persistence.TipoViaDao;
import es.caib.avaedi.logic.vo.TipoViaFormVO;
import es.caib.avaedi.logic.vo.TipoViaListadoVO;

/**
 * Bean negocio para tratar el formulario: TipoVia
 * 
 * @author agarcia@at4.net
 * 
 */
@Repository("TipoViaBean")
public class TipoViaBean extends BaseBean<TipoVia, TipoViaListadoVO, TipoViaFormVO> implements TipoViaBO {

	public TipoViaBean() {
		super(TipoVia.class, TipoViaListadoVO.class, TipoViaFormVO.class);
	}

	/**
	 * Bean para acceder a los métodos de negocio: TipoVia
	 */
	@Autowired
	@Qualifier("TipoViaDao")
	protected TipoViaDao mainDao;

	/**
	 * Bean para acceder a los métodos de negocio: TipoVia
	 * 
	 * @param bean
	 *            the bean to set
	 */
	protected TipoViaDao getMainDao() {
		return this.mainDao;
	}

	/*
	 * Finders para relaciones
	 */

	/**
	 * Devuelve la instancia de TipoViaFormVO que cumple con la búsqueda
	 * findByCodigoCatastro
	 * 
	 * @param codigo
	 * @return la instancia de TipoViaFormVO
	 * @throws GenericBusinessException
	 */
	public TipoViaFormVO findByCodigoCatastro(String codigo) throws GenericBusinessException {
		try {
			return formTransformer().transform(this.mainDao.findByCodigoCatastro(codigo));
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
		filterAssigments.put("primaryLabel", "nombreEs");
		orderAssigments.put("primaryLabel", "nombreEs");

		CriteriaUtils.normalizeFilters(filterAssigments, filters);
		CriteriaUtils.normalizeOrders(orderAssigments, pagingConfig);
	}

}
