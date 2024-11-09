package es.caib.avaedi.logic.bo;

import java.util.Collection;

import es.caib.avaedi.at4forms.common.exception.GenericBusinessException;
import es.caib.avaedi.at4forms.common.search.FilterConfig;
import es.caib.avaedi.at4forms.common.search.PagingConfig;
import es.caib.avaedi.at4forms.common.search.ResultadoBusqueda;
import es.caib.avaedi.at4forms.logic.bo.BaseBO;
import es.caib.avaedi.logic.vo.CaracteristicaFormVO;
import es.caib.avaedi.logic.vo.CaracteristicaListadoVO;

/**
 * Interfaz que define los métodos de negocio del Bean: Caracteristica
 * 
 * @author agarcia@at4.net
 * 
 */
public interface CaracteristicaBO extends BaseBO<CaracteristicaListadoVO, CaracteristicaFormVO> {

	/*
	 * Finders para relaciones
	 */

	ResultadoBusqueda<CaracteristicaListadoVO> findByGrupoCaracteristicas(int grupoCaracteristicasId) throws GenericBusinessException;

	ResultadoBusqueda<CaracteristicaListadoVO> findByGrupoCaracteristicas(int grupoCaracteristicasId, PagingConfig pagingConfig) throws GenericBusinessException;

	ResultadoBusqueda<CaracteristicaListadoVO> findByGrupoCaracteristicas(int grupoCaracteristicasId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException;

}
