package es.caib.avaedi.logic.bo;

import java.util.Collection;

import es.caib.avaedi.at4forms.common.exception.GenericBusinessException;
import es.caib.avaedi.at4forms.common.search.FilterConfig;
import es.caib.avaedi.at4forms.common.search.PagingConfig;
import es.caib.avaedi.at4forms.common.search.ResultadoBusqueda;
import es.caib.avaedi.at4forms.logic.bo.BaseBO;
import es.caib.avaedi.logic.vo.ValorFormVO;
import es.caib.avaedi.logic.vo.ValorListadoVO;

/**
 * Interfaz que define los métodos de negocio del Bean: Valor
 * 
 * @author agarcia@at4.net
 * 
 */
public interface ValorBO extends BaseBO<ValorListadoVO, ValorFormVO> {

	/*
	 * Finders para relaciones
	 */

	ResultadoBusqueda<ValorListadoVO> findByCaracteristica(java.lang.String caracteristicaId) throws GenericBusinessException;

	ResultadoBusqueda<ValorListadoVO> findByCaracteristica(java.lang.String caracteristicaId, PagingConfig pagingConfig) throws GenericBusinessException;

	ResultadoBusqueda<ValorListadoVO> findByCaracteristica(java.lang.String caracteristicaId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException;

	ValorFormVO findByCarId(String caracteristica, int valId) throws GenericBusinessException;

}
