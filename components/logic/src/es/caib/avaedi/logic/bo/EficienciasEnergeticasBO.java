package es.caib.avaedi.logic.bo;

import java.util.Collection;

import es.caib.avaedi.at4forms.common.exception.GenericBusinessException;
import es.caib.avaedi.at4forms.common.search.FilterConfig;
import es.caib.avaedi.at4forms.common.search.PagingConfig;
import es.caib.avaedi.at4forms.common.search.ResultadoBusqueda;
import es.caib.avaedi.at4forms.logic.bo.BaseBO;
import es.caib.avaedi.logic.vo.EficienciasEnergeticasFormVO;
import es.caib.avaedi.logic.vo.EficienciasEnergeticasListadoVO;

/**
 * Interfaz que define los métodos de negocio del Bean: EficienciasEnergeticas
 * 
 * @author agarcia@at4.net
 * 
 */
public interface EficienciasEnergeticasBO extends BaseBO<EficienciasEnergeticasListadoVO, EficienciasEnergeticasFormVO> {

	/*
	 * Finders para relaciones
	 */

	ResultadoBusqueda<EficienciasEnergeticasListadoVO> findByInspeccion(int inspeccionId) throws GenericBusinessException;

	ResultadoBusqueda<EficienciasEnergeticasListadoVO> findByInspeccion(int inspeccionId, PagingConfig pagingConfig) throws GenericBusinessException;

	ResultadoBusqueda<EficienciasEnergeticasListadoVO> findByInspeccion(int inspeccionId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException;

}
