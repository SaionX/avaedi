package es.caib.avaedi.logic.bo;

import java.util.Collection;

import es.caib.avaedi.at4forms.common.exception.GenericBusinessException;
import es.caib.avaedi.at4forms.common.search.FilterConfig;
import es.caib.avaedi.at4forms.common.search.PagingConfig;
import es.caib.avaedi.at4forms.common.search.ResultadoBusqueda;
import es.caib.avaedi.at4forms.logic.bo.BaseBO;
import es.caib.avaedi.logic.vo.AcusticasFormVO;
import es.caib.avaedi.logic.vo.AcusticasListadoVO;

/**
 * Interfaz que define los métodos de negocio del Bean: Acusticas
 * 
 * @author agarcia@at4.net
 * 
 */
public interface AcusticasBO extends BaseBO<AcusticasListadoVO, AcusticasFormVO> {

	/*
	 * Finders para relaciones
	 */

	ResultadoBusqueda<AcusticasListadoVO> findByInspeccion(int inspeccionId) throws GenericBusinessException;

	ResultadoBusqueda<AcusticasListadoVO> findByInspeccion(int inspeccionId, PagingConfig pagingConfig) throws GenericBusinessException;

	ResultadoBusqueda<AcusticasListadoVO> findByInspeccion(int inspeccionId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException;

}
