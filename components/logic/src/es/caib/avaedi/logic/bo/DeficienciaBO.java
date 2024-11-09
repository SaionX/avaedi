package es.caib.avaedi.logic.bo;

import java.util.Collection;

import es.caib.avaedi.at4forms.common.exception.GenericBusinessException;
import es.caib.avaedi.at4forms.common.search.FilterConfig;
import es.caib.avaedi.at4forms.common.search.PagingConfig;
import es.caib.avaedi.at4forms.common.search.ResultadoBusqueda;
import es.caib.avaedi.at4forms.logic.bo.BaseBO;
import es.caib.avaedi.logic.vo.DeficienciaFormVO;
import es.caib.avaedi.logic.vo.DeficienciaListadoVO;

/**
 * Interfaz que define los métodos de negocio del Bean: Deficiencia
 * 
 * @author agarcia@at4.net
 * 
 */
public interface DeficienciaBO extends BaseBO<DeficienciaListadoVO, DeficienciaFormVO> {

	/*
	 * Finders para relaciones
	 */

	ResultadoBusqueda<DeficienciaListadoVO> findByDeficienciaTipo(int deficienciaTipoId) throws GenericBusinessException;

	ResultadoBusqueda<DeficienciaListadoVO> findByDeficienciaTipo(int deficienciaTipoId, PagingConfig pagingConfig) throws GenericBusinessException;

	ResultadoBusqueda<DeficienciaListadoVO> findByDeficienciaTipo(int deficienciaTipoId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException;

	ResultadoBusqueda<DeficienciaListadoVO> findByInspeccion(int inspeccionId) throws GenericBusinessException;

	ResultadoBusqueda<DeficienciaListadoVO> findByInspeccion(int inspeccionId, PagingConfig pagingConfig) throws GenericBusinessException;

	ResultadoBusqueda<DeficienciaListadoVO> findByInspeccion(int inspeccionId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException;

}
