package es.caib.avaedi.logic.bo;

import java.util.Collection;

import es.caib.avaedi.at4forms.common.exception.GenericBusinessException;
import es.caib.avaedi.at4forms.common.search.FilterConfig;
import es.caib.avaedi.at4forms.common.search.PagingConfig;
import es.caib.avaedi.at4forms.common.search.ResultadoBusqueda;
import es.caib.avaedi.at4forms.logic.bo.BaseBO;
import es.caib.avaedi.logic.vo.ConservacionFormVO;
import es.caib.avaedi.logic.vo.ConservacionListadoVO;

/**
 * Interfaz que define los métodos de negocio del Bean: Conservacion
 * 
 * @author agarcia@at4.net
 * 
 */
public interface ConservacionBO extends BaseBO<ConservacionListadoVO, ConservacionFormVO> {

	/*
	 * Finders para relaciones
	 */

	ResultadoBusqueda<ConservacionListadoVO> findByInspeccion(int inspeccionId) throws GenericBusinessException;

	ResultadoBusqueda<ConservacionListadoVO> findByInspeccion(int inspeccionId, PagingConfig pagingConfig) throws GenericBusinessException;

	ResultadoBusqueda<ConservacionListadoVO> findByInspeccion(int inspeccionId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException;

}
