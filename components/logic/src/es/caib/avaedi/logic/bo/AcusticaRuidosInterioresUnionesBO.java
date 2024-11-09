package es.caib.avaedi.logic.bo;

import java.util.Collection;

import es.caib.avaedi.at4forms.common.exception.GenericBusinessException;
import es.caib.avaedi.at4forms.common.search.FilterConfig;
import es.caib.avaedi.at4forms.common.search.PagingConfig;
import es.caib.avaedi.at4forms.common.search.ResultadoBusqueda;
import es.caib.avaedi.at4forms.logic.bo.BaseBO;
import es.caib.avaedi.logic.vo.AcusticaRuidosInterioresUnionesFormVO;
import es.caib.avaedi.logic.vo.AcusticaRuidosInterioresUnionesListadoVO;

/**
 * Interfaz que define los métodos de negocio del Bean:
 * AcusticaRuidosInterioresUniones
 * 
 * @author agarcia@at4.net
 * 
 */
public interface AcusticaRuidosInterioresUnionesBO extends BaseBO<AcusticaRuidosInterioresUnionesListadoVO, AcusticaRuidosInterioresUnionesFormVO> {

	/*
	 * Finders para relaciones
	 */

	ResultadoBusqueda<AcusticaRuidosInterioresUnionesListadoVO> findByInspeccion(int inspeccionId) throws GenericBusinessException;

	ResultadoBusqueda<AcusticaRuidosInterioresUnionesListadoVO> findByInspeccion(int inspeccionId, PagingConfig pagingConfig) throws GenericBusinessException;

	ResultadoBusqueda<AcusticaRuidosInterioresUnionesListadoVO> findByInspeccion(int inspeccionId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException;

}
