package es.caib.avaedi.logic.bo;

import java.util.Collection;

import es.caib.avaedi.at4forms.common.exception.GenericBusinessException;
import es.caib.avaedi.at4forms.common.search.FilterConfig;
import es.caib.avaedi.at4forms.common.search.PagingConfig;
import es.caib.avaedi.at4forms.common.search.ResultadoBusqueda;
import es.caib.avaedi.at4forms.logic.bo.BaseBO;
import es.caib.avaedi.logic.vo.ValoracionParcialFormVO;
import es.caib.avaedi.logic.vo.ValoracionParcialListadoVO;

/**
 * Interfaz que define los métodos de negocio del Bean: ValoracionParcial
 * 
 * @author agarcia@at4.net
 * 
 */
public interface ValoracionParcialBO extends BaseBO<ValoracionParcialListadoVO, ValoracionParcialFormVO> {

	/*
	 * Finders para relaciones
	 */

	ResultadoBusqueda<ValoracionParcialListadoVO> findByInspeccion(int inspeccionId) throws GenericBusinessException;

	ResultadoBusqueda<ValoracionParcialListadoVO> findByInspeccion(int inspeccionId, PagingConfig pagingConfig) throws GenericBusinessException;

	ResultadoBusqueda<ValoracionParcialListadoVO> findByInspeccion(int inspeccionId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException;

}
