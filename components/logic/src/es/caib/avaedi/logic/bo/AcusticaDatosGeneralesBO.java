package es.caib.avaedi.logic.bo;

import java.util.Collection;

import es.caib.avaedi.at4forms.common.exception.GenericBusinessException;
import es.caib.avaedi.at4forms.common.search.FilterConfig;
import es.caib.avaedi.at4forms.common.search.PagingConfig;
import es.caib.avaedi.at4forms.common.search.ResultadoBusqueda;
import es.caib.avaedi.at4forms.logic.bo.BaseBO;
import es.caib.avaedi.logic.vo.AcusticaDatosGeneralesFormVO;
import es.caib.avaedi.logic.vo.AcusticaDatosGeneralesListadoVO;

/**
 * Interfaz que define los métodos de negocio del Bean: AcusticaDatosGenerales
 * 
 * @author agarcia@at4.net
 * 
 */
public interface AcusticaDatosGeneralesBO extends BaseBO<AcusticaDatosGeneralesListadoVO, AcusticaDatosGeneralesFormVO> {

	/*
	 * Finders para relaciones
	 */

	ResultadoBusqueda<AcusticaDatosGeneralesListadoVO> findByInspeccion(int inspeccionId) throws GenericBusinessException;

	ResultadoBusqueda<AcusticaDatosGeneralesListadoVO> findByInspeccion(int inspeccionId, PagingConfig pagingConfig) throws GenericBusinessException;

	ResultadoBusqueda<AcusticaDatosGeneralesListadoVO> findByInspeccion(int inspeccionId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException;

}
