package es.caib.avaedi.logic.bo;

import java.util.Collection;

import es.caib.avaedi.at4forms.common.exception.GenericBusinessException;
import es.caib.avaedi.at4forms.common.search.FilterConfig;
import es.caib.avaedi.at4forms.common.search.PagingConfig;
import es.caib.avaedi.at4forms.common.search.ResultadoBusqueda;
import es.caib.avaedi.at4forms.logic.bo.BaseBO;
import es.caib.avaedi.logic.vo.EstructuraFormVO;
import es.caib.avaedi.logic.vo.EstructuraListadoVO;

/**
 * Interfaz que define los métodos de negocio del Bean: Estructura
 * 
 * @author agarcia@at4.net
 * 
 */
public interface EstructuraBO extends BaseBO<EstructuraListadoVO, EstructuraFormVO> {

	/*
	 * Finders para relaciones
	 */

	ResultadoBusqueda<EstructuraListadoVO> findByInspeccion(int inspeccionId) throws GenericBusinessException;

	ResultadoBusqueda<EstructuraListadoVO> findByInspeccion(int inspeccionId, PagingConfig pagingConfig) throws GenericBusinessException;

	ResultadoBusqueda<EstructuraListadoVO> findByInspeccion(int inspeccionId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException;

}
