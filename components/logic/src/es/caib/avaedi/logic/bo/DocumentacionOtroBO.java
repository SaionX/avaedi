package es.caib.avaedi.logic.bo;

import java.util.Collection;

import es.caib.avaedi.at4forms.common.exception.GenericBusinessException;
import es.caib.avaedi.at4forms.common.search.FilterConfig;
import es.caib.avaedi.at4forms.common.search.PagingConfig;
import es.caib.avaedi.at4forms.common.search.ResultadoBusqueda;
import es.caib.avaedi.at4forms.logic.bo.BaseBO;
import es.caib.avaedi.logic.vo.DocumentacionOtroFormVO;
import es.caib.avaedi.logic.vo.DocumentacionOtroListadoVO;

/**
 * Interfaz que define los métodos de negocio del Bean: DocumentacionOtro
 * 
 * @author agarcia@at4.net
 * 
 */
public interface DocumentacionOtroBO extends BaseBO<DocumentacionOtroListadoVO, DocumentacionOtroFormVO> {

	/*
	 * Finders para relaciones
	 */

	ResultadoBusqueda<DocumentacionOtroListadoVO> findByInspeccion(int inspeccionId) throws GenericBusinessException;

	ResultadoBusqueda<DocumentacionOtroListadoVO> findByInspeccion(int inspeccionId, PagingConfig pagingConfig) throws GenericBusinessException;

	ResultadoBusqueda<DocumentacionOtroListadoVO> findByInspeccion(int inspeccionId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException;

}
