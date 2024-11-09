package es.caib.avaedi.logic.bo;

import java.util.Collection;

import es.caib.avaedi.at4forms.common.exception.GenericBusinessException;
import es.caib.avaedi.at4forms.common.search.FilterConfig;
import es.caib.avaedi.at4forms.common.search.PagingConfig;
import es.caib.avaedi.at4forms.common.search.ResultadoBusqueda;
import es.caib.avaedi.at4forms.logic.bo.BaseBO;
import es.caib.avaedi.logic.vo.AcusticaRuidoInstalacionesFormVO;
import es.caib.avaedi.logic.vo.AcusticaRuidoInstalacionesListadoVO;

/**
 * Interfaz que define los métodos de negocio del Bean:
 * AcusticaRuidoInstalaciones
 * 
 * @author agarcia@at4.net
 * 
 */
public interface AcusticaRuidoInstalacionesBO extends BaseBO<AcusticaRuidoInstalacionesListadoVO, AcusticaRuidoInstalacionesFormVO> {

	/*
	 * Finders para relaciones
	 */

	ResultadoBusqueda<AcusticaRuidoInstalacionesListadoVO> findByInspeccion(int inspeccionId) throws GenericBusinessException;

	ResultadoBusqueda<AcusticaRuidoInstalacionesListadoVO> findByInspeccion(int inspeccionId, PagingConfig pagingConfig) throws GenericBusinessException;

	ResultadoBusqueda<AcusticaRuidoInstalacionesListadoVO> findByInspeccion(int inspeccionId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException;

}
