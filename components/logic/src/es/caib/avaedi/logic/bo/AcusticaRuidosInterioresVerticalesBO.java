package es.caib.avaedi.logic.bo;

import java.util.Collection;

import es.caib.avaedi.at4forms.common.exception.GenericBusinessException;
import es.caib.avaedi.at4forms.common.search.FilterConfig;
import es.caib.avaedi.at4forms.common.search.PagingConfig;
import es.caib.avaedi.at4forms.common.search.ResultadoBusqueda;
import es.caib.avaedi.at4forms.logic.bo.BaseBO;
import es.caib.avaedi.logic.vo.AcusticaRuidosInterioresVerticalesFormVO;
import es.caib.avaedi.logic.vo.AcusticaRuidosInterioresVerticalesListadoVO;

/**
 * Interfaz que define los métodos de negocio del Bean:
 * AcusticaRuidosInterioresVerticales
 * 
 * @author agarcia@at4.net
 * 
 */
public interface AcusticaRuidosInterioresVerticalesBO extends BaseBO<AcusticaRuidosInterioresVerticalesListadoVO, AcusticaRuidosInterioresVerticalesFormVO> {

	/*
	 * Finders para relaciones
	 */

	ResultadoBusqueda<AcusticaRuidosInterioresVerticalesListadoVO> findByInspeccion(int inspeccionId) throws GenericBusinessException;

	ResultadoBusqueda<AcusticaRuidosInterioresVerticalesListadoVO> findByInspeccion(int inspeccionId, PagingConfig pagingConfig) throws GenericBusinessException;

	ResultadoBusqueda<AcusticaRuidosInterioresVerticalesListadoVO> findByInspeccion(int inspeccionId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException;

}
