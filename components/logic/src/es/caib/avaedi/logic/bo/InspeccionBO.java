package es.caib.avaedi.logic.bo;

import java.util.Collection;

import es.caib.avaedi.at4forms.common.exception.GenericBusinessException;
import es.caib.avaedi.at4forms.common.search.FilterConfig;
import es.caib.avaedi.at4forms.common.search.PagingConfig;
import es.caib.avaedi.at4forms.common.search.ResultadoBusqueda;
import es.caib.avaedi.at4forms.logic.bo.BaseBO;
import es.caib.avaedi.logic.vo.InspeccionFormVO;
import es.caib.avaedi.logic.vo.InspeccionListadoVO;

/**
 * Interfaz que define los métodos de negocio del Bean: Inspeccion
 * 
 * @author agarcia@at4.net
 * 
 */
public interface InspeccionBO extends BaseBO<InspeccionListadoVO, InspeccionFormVO> {

	/*
	 * Finders para relaciones 
	 */

	ResultadoBusqueda<InspeccionListadoVO> findByInforme(int informeId) throws GenericBusinessException;

	ResultadoBusqueda<InspeccionListadoVO> findByInforme(int informeId, PagingConfig pagingConfig) throws GenericBusinessException;

	ResultadoBusqueda<InspeccionListadoVO> findByInforme(int informeId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException;

	ResultadoBusqueda<InspeccionListadoVO> findByAccesibilidadPublicos(int accesibilidadPublicosId) throws GenericBusinessException;

	ResultadoBusqueda<InspeccionListadoVO> findByAccesibilidadPublicos(int accesibilidadPublicosId, PagingConfig pagingConfig) throws GenericBusinessException;

	ResultadoBusqueda<InspeccionListadoVO> findByAccesibilidadPublicos(int accesibilidadPublicosId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException;

	ResultadoBusqueda<InspeccionListadoVO> findByAcusticaRuidosInterioresUniones(int acusticaRuidosInterioresUnionesId) throws GenericBusinessException;

	ResultadoBusqueda<InspeccionListadoVO> findByAcusticaRuidosInterioresUniones(int acusticaRuidosInterioresUnionesId, PagingConfig pagingConfig) throws GenericBusinessException;

	ResultadoBusqueda<InspeccionListadoVO> findByAcusticaRuidosInterioresUniones(int acusticaRuidosInterioresUnionesId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException;

	ResultadoBusqueda<InspeccionListadoVO> findByAcusticaValoracionFinal(int acusticaValoracionFinalId) throws GenericBusinessException;

	ResultadoBusqueda<InspeccionListadoVO> findByAcusticaValoracionFinal(int acusticaValoracionFinalId, PagingConfig pagingConfig) throws GenericBusinessException;

	ResultadoBusqueda<InspeccionListadoVO> findByAcusticaValoracionFinal(int acusticaValoracionFinalId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException;

	ResultadoBusqueda<InspeccionListadoVO> findByAcusticaRuidosInterioresVerticales(int acusticaRuidosInterioresVerticalesId) throws GenericBusinessException;

	ResultadoBusqueda<InspeccionListadoVO> findByAcusticaRuidosInterioresVerticales(int acusticaRuidosInterioresVerticalesId, PagingConfig pagingConfig) throws GenericBusinessException;

	ResultadoBusqueda<InspeccionListadoVO> findByAcusticaRuidosInterioresVerticales(int acusticaRuidosInterioresVerticalesId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException;

	ResultadoBusqueda<InspeccionListadoVO> findByAcusticaComprobaciones(int acusticaComprobacionesId) throws GenericBusinessException;

	ResultadoBusqueda<InspeccionListadoVO> findByAcusticaComprobaciones(int acusticaComprobacionesId, PagingConfig pagingConfig) throws GenericBusinessException;

	ResultadoBusqueda<InspeccionListadoVO> findByAcusticaComprobaciones(int acusticaComprobacionesId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException;

	ResultadoBusqueda<InspeccionListadoVO> findByInstalaciones(int instalacionesId) throws GenericBusinessException;

	ResultadoBusqueda<InspeccionListadoVO> findByInstalaciones(int instalacionesId, PagingConfig pagingConfig) throws GenericBusinessException;

	ResultadoBusqueda<InspeccionListadoVO> findByInstalaciones(int instalacionesId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException;

	ResultadoBusqueda<InspeccionListadoVO> findByCerramientosCubiertas(int cerramientosCubiertasId) throws GenericBusinessException;

	ResultadoBusqueda<InspeccionListadoVO> findByCerramientosCubiertas(int cerramientosCubiertasId, PagingConfig pagingConfig) throws GenericBusinessException;

	ResultadoBusqueda<InspeccionListadoVO> findByCerramientosCubiertas(int cerramientosCubiertasId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException;

	ResultadoBusqueda<InspeccionListadoVO> findByAccesibilidadValoracionFinales(int accesibilidadValoracionFinalesId) throws GenericBusinessException;

	ResultadoBusqueda<InspeccionListadoVO> findByAccesibilidadValoracionFinales(int accesibilidadValoracionFinalesId, PagingConfig pagingConfig) throws GenericBusinessException;

	ResultadoBusqueda<InspeccionListadoVO> findByAccesibilidadValoracionFinales(int accesibilidadValoracionFinalesId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException;

	ResultadoBusqueda<InspeccionListadoVO> findByAcusticaRuidoInstalaciones(int acusticaRuidoInstalacionesId) throws GenericBusinessException;

	ResultadoBusqueda<InspeccionListadoVO> findByAcusticaRuidoInstalaciones(int acusticaRuidoInstalacionesId, PagingConfig pagingConfig) throws GenericBusinessException;

	ResultadoBusqueda<InspeccionListadoVO> findByAcusticaRuidoInstalaciones(int acusticaRuidoInstalacionesId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException;

	ResultadoBusqueda<InspeccionListadoVO> findByEstructura(int estructuraId) throws GenericBusinessException;

	ResultadoBusqueda<InspeccionListadoVO> findByEstructura(int estructuraId, PagingConfig pagingConfig) throws GenericBusinessException;

	ResultadoBusqueda<InspeccionListadoVO> findByEstructura(int estructuraId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException;

	ResultadoBusqueda<InspeccionListadoVO> findByCimentaciones(int cimentacionesId) throws GenericBusinessException;

	ResultadoBusqueda<InspeccionListadoVO> findByCimentaciones(int cimentacionesId, PagingConfig pagingConfig) throws GenericBusinessException;

	ResultadoBusqueda<InspeccionListadoVO> findByCimentaciones(int cimentacionesId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException;

	ResultadoBusqueda<InspeccionListadoVO> findByAccesibilidadAjustesRazonables(int accesibilidadAjustesRazonablesId) throws GenericBusinessException;

	ResultadoBusqueda<InspeccionListadoVO> findByAccesibilidadAjustesRazonables(int accesibilidadAjustesRazonablesId, PagingConfig pagingConfig) throws GenericBusinessException;

	ResultadoBusqueda<InspeccionListadoVO> findByAccesibilidadAjustesRazonables(int accesibilidadAjustesRazonablesId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException;

	ResultadoBusqueda<InspeccionListadoVO> findByEficienciasEnergeticas(int eficienciasEnergeticasId) throws GenericBusinessException;

	ResultadoBusqueda<InspeccionListadoVO> findByEficienciasEnergeticas(int eficienciasEnergeticasId, PagingConfig pagingConfig) throws GenericBusinessException;

	ResultadoBusqueda<InspeccionListadoVO> findByEficienciasEnergeticas(int eficienciasEnergeticasId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException;

	ResultadoBusqueda<InspeccionListadoVO> findByAcusticaRuidosExteriores(int acusticaRuidosExterioresId) throws GenericBusinessException;

	ResultadoBusqueda<InspeccionListadoVO> findByAcusticaRuidosExteriores(int acusticaRuidosExterioresId, PagingConfig pagingConfig) throws GenericBusinessException;

	ResultadoBusqueda<InspeccionListadoVO> findByAcusticaRuidosExteriores(int acusticaRuidosExterioresId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException;

	ResultadoBusqueda<InspeccionListadoVO> findByAcusticaMejorasAcusticas(int acusticaMejorasAcusticasId) throws GenericBusinessException;

	ResultadoBusqueda<InspeccionListadoVO> findByAcusticaMejorasAcusticas(int acusticaMejorasAcusticasId, PagingConfig pagingConfig) throws GenericBusinessException;

	ResultadoBusqueda<InspeccionListadoVO> findByAcusticaMejorasAcusticas(int acusticaMejorasAcusticasId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException;

	ResultadoBusqueda<InspeccionListadoVO> findByAcusticaRuidosInterioresHorizontales(int acusticaRuidosInterioresHorizontalesId) throws GenericBusinessException;

	ResultadoBusqueda<InspeccionListadoVO> findByAcusticaRuidosInterioresHorizontales(int acusticaRuidosInterioresHorizontalesId, PagingConfig pagingConfig) throws GenericBusinessException;

	ResultadoBusqueda<InspeccionListadoVO> findByAcusticaRuidosInterioresHorizontales(int acusticaRuidosInterioresHorizontalesId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException;

	ResultadoBusqueda<InspeccionListadoVO> findByAcusticaDatosGenerales(int acusticaDatosGeneralesId) throws GenericBusinessException;

	ResultadoBusqueda<InspeccionListadoVO> findByAcusticaDatosGenerales(int acusticaDatosGeneralesId, PagingConfig pagingConfig) throws GenericBusinessException;

	ResultadoBusqueda<InspeccionListadoVO> findByAcusticaDatosGenerales(int acusticaDatosGeneralesId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException;

	ResultadoBusqueda<InspeccionListadoVO> findByAcusticas(int acusticasId) throws GenericBusinessException;

	ResultadoBusqueda<InspeccionListadoVO> findByAcusticas(int acusticasId, PagingConfig pagingConfig) throws GenericBusinessException;

	ResultadoBusqueda<InspeccionListadoVO> findByAcusticas(int acusticasId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException;

	ResultadoBusqueda<InspeccionListadoVO> findByConservacion(int conservacionId) throws GenericBusinessException;

	ResultadoBusqueda<InspeccionListadoVO> findByConservacion(int conservacionId, PagingConfig pagingConfig) throws GenericBusinessException;

	ResultadoBusqueda<InspeccionListadoVO> findByConservacion(int conservacionId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException;

}
