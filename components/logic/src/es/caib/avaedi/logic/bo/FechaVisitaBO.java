package es.caib.avaedi.logic.bo;

import java.util.Collection;

import es.caib.avaedi.at4forms.common.exception.GenericBusinessException;
import es.caib.avaedi.at4forms.common.search.FilterConfig;
import es.caib.avaedi.at4forms.common.search.PagingConfig;
import es.caib.avaedi.at4forms.common.search.ResultadoBusqueda;
import es.caib.avaedi.at4forms.logic.bo.BaseBO;
import es.caib.avaedi.logic.vo.FechaVisitaFormVO;
import es.caib.avaedi.logic.vo.FechaVisitaListadoVO;

/**
 * Interfaz que define los métodos de negocio del Bean: FechaVisita
 * 
 * @author agarcia@at4.net
 * 
 */
public interface FechaVisitaBO extends BaseBO<FechaVisitaListadoVO, FechaVisitaFormVO> {

	/*
	 * Finders para relaciones
	 */

	ResultadoBusqueda<FechaVisitaListadoVO> findByInspeccion(int inspeccionId) throws GenericBusinessException;

	ResultadoBusqueda<FechaVisitaListadoVO> findByInspeccion(int inspeccionId, PagingConfig pagingConfig) throws GenericBusinessException;

	ResultadoBusqueda<FechaVisitaListadoVO> findByInspeccion(int inspeccionId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException;

}
