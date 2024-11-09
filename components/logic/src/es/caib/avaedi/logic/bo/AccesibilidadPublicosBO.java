package es.caib.avaedi.logic.bo;

import java.util.Collection;

import es.caib.avaedi.at4forms.common.exception.GenericBusinessException;
import es.caib.avaedi.at4forms.common.search.FilterConfig;
import es.caib.avaedi.at4forms.common.search.PagingConfig;
import es.caib.avaedi.at4forms.common.search.ResultadoBusqueda;
import es.caib.avaedi.at4forms.logic.bo.BaseBO;
import es.caib.avaedi.logic.vo.AccesibilidadPublicosFormVO;
import es.caib.avaedi.logic.vo.AccesibilidadPublicosListadoVO;

/**
 * Interfaz que define los métodos de negocio del Bean: AccesibilidadPublicos
 * 
 * @author agarcia@at4.net
 * 
 */
public interface AccesibilidadPublicosBO extends BaseBO<AccesibilidadPublicosListadoVO, AccesibilidadPublicosFormVO> {

	/*
	 * Finders para relaciones
	 */

	ResultadoBusqueda<AccesibilidadPublicosListadoVO> findByInspeccion(int inspeccionId) throws GenericBusinessException;

	ResultadoBusqueda<AccesibilidadPublicosListadoVO> findByInspeccion(int inspeccionId, PagingConfig pagingConfig) throws GenericBusinessException;

	ResultadoBusqueda<AccesibilidadPublicosListadoVO> findByInspeccion(int inspeccionId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException;

}
