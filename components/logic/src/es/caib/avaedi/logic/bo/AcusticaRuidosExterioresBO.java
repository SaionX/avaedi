package es.caib.avaedi.logic.bo;

import java.util.Collection;

import es.caib.avaedi.at4forms.common.exception.GenericBusinessException;
import es.caib.avaedi.at4forms.common.search.FilterConfig;
import es.caib.avaedi.at4forms.common.search.PagingConfig;
import es.caib.avaedi.at4forms.common.search.ResultadoBusqueda;
import es.caib.avaedi.at4forms.logic.bo.BaseBO;
import es.caib.avaedi.logic.vo.AcusticaRuidosExterioresFormVO;
import es.caib.avaedi.logic.vo.AcusticaRuidosExterioresListadoVO;

/**
 * Interfaz que define los métodos de negocio del Bean: AcusticaRuidosExteriores
 * 
 * @author agarcia@at4.net
 * 
 */
public interface AcusticaRuidosExterioresBO extends BaseBO<AcusticaRuidosExterioresListadoVO, AcusticaRuidosExterioresFormVO> {

	/*
	 * Finders para relaciones
	 */

	ResultadoBusqueda<AcusticaRuidosExterioresListadoVO> findByInspeccion(int inspeccionId) throws GenericBusinessException;

	ResultadoBusqueda<AcusticaRuidosExterioresListadoVO> findByInspeccion(int inspeccionId, PagingConfig pagingConfig) throws GenericBusinessException;

	ResultadoBusqueda<AcusticaRuidosExterioresListadoVO> findByInspeccion(int inspeccionId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException;

}
