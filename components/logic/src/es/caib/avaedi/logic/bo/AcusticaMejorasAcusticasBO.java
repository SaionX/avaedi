package es.caib.avaedi.logic.bo;

import java.util.Collection;

import es.caib.avaedi.at4forms.common.exception.GenericBusinessException;
import es.caib.avaedi.at4forms.common.search.FilterConfig;
import es.caib.avaedi.at4forms.common.search.PagingConfig;
import es.caib.avaedi.at4forms.common.search.ResultadoBusqueda;
import es.caib.avaedi.at4forms.logic.bo.BaseBO;
import es.caib.avaedi.logic.vo.AcusticaMejorasAcusticasFormVO;
import es.caib.avaedi.logic.vo.AcusticaMejorasAcusticasListadoVO;

/** 
 * Interfaz que define los métodos de negocio del Bean: AcusticaMejorasAcusticas
 * 
 * @author agarcia@at4.net
 * 
 */
public interface AcusticaMejorasAcusticasBO extends BaseBO<AcusticaMejorasAcusticasListadoVO, AcusticaMejorasAcusticasFormVO> {

	/*
	 * Finders para relaciones
	 */

	ResultadoBusqueda<AcusticaMejorasAcusticasListadoVO> findByInspeccion(int inspeccionId) throws GenericBusinessException;

	ResultadoBusqueda<AcusticaMejorasAcusticasListadoVO> findByInspeccion(int inspeccionId, PagingConfig pagingConfig) throws GenericBusinessException;

	ResultadoBusqueda<AcusticaMejorasAcusticasListadoVO> findByInspeccion(int inspeccionId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException;

}
