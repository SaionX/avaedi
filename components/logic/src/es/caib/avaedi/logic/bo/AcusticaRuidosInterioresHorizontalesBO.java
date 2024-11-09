package es.caib.avaedi.logic.bo;

import java.util.Collection;

import es.caib.avaedi.at4forms.common.exception.GenericBusinessException;
import es.caib.avaedi.at4forms.common.search.FilterConfig;
import es.caib.avaedi.at4forms.common.search.PagingConfig;
import es.caib.avaedi.at4forms.common.search.ResultadoBusqueda;
import es.caib.avaedi.at4forms.logic.bo.BaseBO;
import es.caib.avaedi.logic.vo.AcusticaRuidosInterioresHorizontalesFormVO;
import es.caib.avaedi.logic.vo.AcusticaRuidosInterioresHorizontalesListadoVO;

/**
 * Interfaz que define los métodos de negocio del Bean:
 * AcusticaRuidosInterioresHorizontales
 * 
 * @author agarcia@at4.net
 * 
 */
public interface AcusticaRuidosInterioresHorizontalesBO extends BaseBO<AcusticaRuidosInterioresHorizontalesListadoVO, AcusticaRuidosInterioresHorizontalesFormVO> {

	/*
	 * Finders para relaciones
	 */

	ResultadoBusqueda<AcusticaRuidosInterioresHorizontalesListadoVO> findByInspeccion(int inspeccionId) throws GenericBusinessException;

	ResultadoBusqueda<AcusticaRuidosInterioresHorizontalesListadoVO> findByInspeccion(int inspeccionId, PagingConfig pagingConfig) throws GenericBusinessException;

	ResultadoBusqueda<AcusticaRuidosInterioresHorizontalesListadoVO> findByInspeccion(int inspeccionId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException;

}
