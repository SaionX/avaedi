package es.caib.avaedi.logic.bo;

import java.util.Collection;

import es.caib.avaedi.at4forms.common.exception.GenericBusinessException;
import es.caib.avaedi.at4forms.common.search.FilterConfig;
import es.caib.avaedi.at4forms.common.search.PagingConfig;
import es.caib.avaedi.at4forms.common.search.ResultadoBusqueda;
import es.caib.avaedi.at4forms.logic.bo.BaseBO;
import es.caib.avaedi.logic.vo.InstalacionesFormVO;
import es.caib.avaedi.logic.vo.InstalacionesListadoVO;

/**
 * Interfaz que define los métodos de negocio del Bean: Instalaciones
 * 
 * @author agarcia@at4.net
 * 
 */
public interface InstalacionesBO extends BaseBO<InstalacionesListadoVO, InstalacionesFormVO> {

	/*
	 * Finders para relaciones
	 */

	ResultadoBusqueda<InstalacionesListadoVO> findByInspeccion(int inspeccionId) throws GenericBusinessException;

	ResultadoBusqueda<InstalacionesListadoVO> findByInspeccion(int inspeccionId, PagingConfig pagingConfig) throws GenericBusinessException;

	ResultadoBusqueda<InstalacionesListadoVO> findByInspeccion(int inspeccionId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException;

}
