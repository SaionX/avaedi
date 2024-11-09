package es.caib.avaedi.logic.bo;

import java.util.Collection;

import es.caib.avaedi.at4forms.common.exception.GenericBusinessException;
import es.caib.avaedi.at4forms.common.search.FilterConfig;
import es.caib.avaedi.at4forms.common.search.PagingConfig;
import es.caib.avaedi.at4forms.common.search.ResultadoBusqueda;
import es.caib.avaedi.at4forms.logic.bo.BaseBO;
import es.caib.avaedi.logic.vo.AcusticaValoracionFinalFormVO;
import es.caib.avaedi.logic.vo.AcusticaValoracionFinalListadoVO;

/**
 * Interfaz que define los métodos de negocio del Bean: AcusticaValoracionFinal
 * 
 * @author agarcia@at4.net
 * 
 */
public interface AcusticaValoracionFinalBO extends BaseBO<AcusticaValoracionFinalListadoVO, AcusticaValoracionFinalFormVO> {

	/*
	 * Finders para relaciones
	 */

	ResultadoBusqueda<AcusticaValoracionFinalListadoVO> findByInspeccion(int inspeccionId) throws GenericBusinessException;

	ResultadoBusqueda<AcusticaValoracionFinalListadoVO> findByInspeccion(int inspeccionId, PagingConfig pagingConfig) throws GenericBusinessException;

	ResultadoBusqueda<AcusticaValoracionFinalListadoVO> findByInspeccion(int inspeccionId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException;

}
