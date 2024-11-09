package es.caib.avaedi.logic.bo;

import java.util.Collection;

import es.caib.avaedi.at4forms.common.exception.GenericBusinessException;
import es.caib.avaedi.at4forms.common.search.FilterConfig;
import es.caib.avaedi.at4forms.common.search.PagingConfig;
import es.caib.avaedi.at4forms.common.search.ResultadoBusqueda;
import es.caib.avaedi.at4forms.logic.bo.BaseBO;
import es.caib.avaedi.logic.vo.InformeFormVO;
import es.caib.avaedi.logic.vo.InformeListadoVO;

/**
 * Interfaz que define los métodos de negocio del Bean: Informe
 * 
 * @author agarcia@at4.net
 * 
 */
public interface InformeBO extends BaseBO<InformeListadoVO, InformeFormVO> {

	/*
	 * Finders para relaciones
	 */

	ResultadoBusqueda<InformeListadoVO> findByEstadoInforme(int estadoInformeId) throws GenericBusinessException;

	ResultadoBusqueda<InformeListadoVO> findByEstadoInforme(int estadoInformeId, PagingConfig pagingConfig) throws GenericBusinessException;

	ResultadoBusqueda<InformeListadoVO> findByEstadoInforme(int estadoInformeId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException;

	ResultadoBusqueda<InformeListadoVO> findByEdificio(int edificioId) throws GenericBusinessException;

	ResultadoBusqueda<InformeListadoVO> findByEdificio(int edificioId, PagingConfig pagingConfig) throws GenericBusinessException;

	ResultadoBusqueda<InformeListadoVO> findByEdificio(int edificioId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException;

}
