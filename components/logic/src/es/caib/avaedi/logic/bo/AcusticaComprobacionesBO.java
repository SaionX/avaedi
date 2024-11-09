package es.caib.avaedi.logic.bo;

import java.util.Collection;

import es.caib.avaedi.at4forms.common.exception.GenericBusinessException;
import es.caib.avaedi.at4forms.common.search.FilterConfig;
import es.caib.avaedi.at4forms.common.search.PagingConfig;
import es.caib.avaedi.at4forms.common.search.ResultadoBusqueda;
import es.caib.avaedi.at4forms.logic.bo.BaseBO;
import es.caib.avaedi.logic.vo.AcusticaComprobacionesFormVO;
import es.caib.avaedi.logic.vo.AcusticaComprobacionesListadoVO;

/**
 * Interfaz que define los métodos de negocio del Bean: AcusticaComprobaciones
 * 
 * @author agarcia@at4.net
 * 
 */
public interface AcusticaComprobacionesBO extends BaseBO<AcusticaComprobacionesListadoVO, AcusticaComprobacionesFormVO> {

	/*
	 * Finders para relaciones
	 */

	ResultadoBusqueda<AcusticaComprobacionesListadoVO> findByInspeccion(int inspeccionId) throws GenericBusinessException;

	ResultadoBusqueda<AcusticaComprobacionesListadoVO> findByInspeccion(int inspeccionId, PagingConfig pagingConfig) throws GenericBusinessException;

	ResultadoBusqueda<AcusticaComprobacionesListadoVO> findByInspeccion(int inspeccionId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException;

}
