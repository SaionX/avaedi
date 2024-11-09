package es.caib.avaedi.logic.bo;

import java.util.Collection;

import es.caib.avaedi.at4forms.common.exception.GenericBusinessException;
import es.caib.avaedi.at4forms.common.search.FilterConfig;
import es.caib.avaedi.at4forms.common.search.PagingConfig;
import es.caib.avaedi.at4forms.common.search.ResultadoBusqueda;
import es.caib.avaedi.at4forms.logic.bo.BaseBO;
import es.caib.avaedi.logic.vo.CerramientosCubiertasFormVO;
import es.caib.avaedi.logic.vo.CerramientosCubiertasListadoVO;

/**
 * Interfaz que define los métodos de negocio del Bean: CerramientosCubiertas
 * 
 * @author agarcia@at4.net
 * 
 */
public interface CerramientosCubiertasBO extends BaseBO<CerramientosCubiertasListadoVO, CerramientosCubiertasFormVO> {

	/*
	 * Finders para relaciones
	 */

	ResultadoBusqueda<CerramientosCubiertasListadoVO> findByInspeccion(int inspeccionId) throws GenericBusinessException;

	ResultadoBusqueda<CerramientosCubiertasListadoVO> findByInspeccion(int inspeccionId, PagingConfig pagingConfig) throws GenericBusinessException;

	ResultadoBusqueda<CerramientosCubiertasListadoVO> findByInspeccion(int inspeccionId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException;

}
