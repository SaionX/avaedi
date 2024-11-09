package es.caib.avaedi.logic.bo;

import java.util.Collection;

import es.caib.avaedi.at4forms.common.exception.GenericBusinessException;
import es.caib.avaedi.at4forms.common.search.FilterConfig;
import es.caib.avaedi.at4forms.common.search.PagingConfig;
import es.caib.avaedi.at4forms.common.search.ResultadoBusqueda;
import es.caib.avaedi.at4forms.logic.bo.BaseBO;
import es.caib.avaedi.logic.vo.CimentacionesFormVO;
import es.caib.avaedi.logic.vo.CimentacionesListadoVO;

/**
 * Interfaz que define los métodos de negocio del Bean: Cimentaciones
 * 
 * @author agarcia@at4.net
 * 
 */
public interface CimentacionesBO extends BaseBO<CimentacionesListadoVO, CimentacionesFormVO> {

	/*
	 * Finders para relaciones
	 */

	ResultadoBusqueda<CimentacionesListadoVO> findByInspeccion(int inspeccionId) throws GenericBusinessException;

	ResultadoBusqueda<CimentacionesListadoVO> findByInspeccion(int inspeccionId, PagingConfig pagingConfig) throws GenericBusinessException;

	ResultadoBusqueda<CimentacionesListadoVO> findByInspeccion(int inspeccionId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException;

}
