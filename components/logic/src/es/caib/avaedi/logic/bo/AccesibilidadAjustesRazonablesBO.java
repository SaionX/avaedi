package es.caib.avaedi.logic.bo;

import java.util.Collection;

import es.caib.avaedi.at4forms.common.exception.GenericBusinessException;
import es.caib.avaedi.at4forms.common.search.FilterConfig;
import es.caib.avaedi.at4forms.common.search.PagingConfig;
import es.caib.avaedi.at4forms.common.search.ResultadoBusqueda;
import es.caib.avaedi.at4forms.logic.bo.BaseBO;
import es.caib.avaedi.logic.vo.AccesibilidadAjustesRazonablesFormVO;
import es.caib.avaedi.logic.vo.AccesibilidadAjustesRazonablesListadoVO;

/**
 * Interfaz que define los métodos de negocio del Bean:
 * AccesibilidadAjustesRazonables
 * 
 * @author agarcia@at4.net
 * 
 */
public interface AccesibilidadAjustesRazonablesBO extends BaseBO<AccesibilidadAjustesRazonablesListadoVO, AccesibilidadAjustesRazonablesFormVO> {

	/*
	 * Finders para relaciones
	 */

	ResultadoBusqueda<AccesibilidadAjustesRazonablesListadoVO> findByInspeccion(int inspeccionId) throws GenericBusinessException;

	ResultadoBusqueda<AccesibilidadAjustesRazonablesListadoVO> findByInspeccion(int inspeccionId, PagingConfig pagingConfig) throws GenericBusinessException;

	ResultadoBusqueda<AccesibilidadAjustesRazonablesListadoVO> findByInspeccion(int inspeccionId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException;

}
