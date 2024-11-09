package es.caib.avaedi.logic.bo;

import java.util.Collection;

import es.caib.avaedi.at4forms.common.exception.GenericBusinessException;
import es.caib.avaedi.at4forms.common.search.FilterConfig;
import es.caib.avaedi.at4forms.common.search.PagingConfig;
import es.caib.avaedi.at4forms.common.search.ResultadoBusqueda;
import es.caib.avaedi.at4forms.logic.bo.BaseBO;
import es.caib.avaedi.logic.vo.HistoricoFormVO;
import es.caib.avaedi.logic.vo.HistoricoListadoVO;

/**
 * Interfaz que define los métodos de negocio del Bean: Historico
 * 
 * @author agarcia@at4.net
 * 
 */
public interface HistoricoBO extends BaseBO<HistoricoListadoVO, HistoricoFormVO> {

	/*
	 * Finders para relaciones
	 */

	ResultadoBusqueda<HistoricoListadoVO> findByInspeccion(int inspeccionId) throws GenericBusinessException;

	ResultadoBusqueda<HistoricoListadoVO> findByInspeccion(int inspeccionId, PagingConfig pagingConfig) throws GenericBusinessException;

	ResultadoBusqueda<HistoricoListadoVO> findByInspeccion(int inspeccionId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException;

}
