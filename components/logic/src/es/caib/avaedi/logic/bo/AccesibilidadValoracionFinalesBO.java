package es.caib.avaedi.logic.bo;

import java.util.Collection;

import es.caib.avaedi.at4forms.common.exception.GenericBusinessException;
import es.caib.avaedi.at4forms.common.search.FilterConfig;
import es.caib.avaedi.at4forms.common.search.PagingConfig;
import es.caib.avaedi.at4forms.common.search.ResultadoBusqueda;
import es.caib.avaedi.at4forms.logic.bo.BaseBO;
import es.caib.avaedi.logic.vo.AccesibilidadValoracionFinalesFormVO;
import es.caib.avaedi.logic.vo.AccesibilidadValoracionFinalesListadoVO;

/**
 * Interfaz que define los métodos de negocio del Bean:
 * AccesibilidadValoracionFinales
 * 
 * @author agarcia@at4.net
 * 
 */
public interface AccesibilidadValoracionFinalesBO extends BaseBO<AccesibilidadValoracionFinalesListadoVO, AccesibilidadValoracionFinalesFormVO> {

	/*
	 * Finders para relaciones
	 */

	ResultadoBusqueda<AccesibilidadValoracionFinalesListadoVO> findByInspeccion(int inspeccionId) throws GenericBusinessException;

	ResultadoBusqueda<AccesibilidadValoracionFinalesListadoVO> findByInspeccion(int inspeccionId, PagingConfig pagingConfig) throws GenericBusinessException;

	ResultadoBusqueda<AccesibilidadValoracionFinalesListadoVO> findByInspeccion(int inspeccionId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException;

}