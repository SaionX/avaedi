package es.caib.avaedi.logic.bo;

import java.util.Collection;

import org.apache.commons.collections4.Transformer;

import es.caib.avaedi.at4forms.common.exception.GenericBusinessException;
import es.caib.avaedi.at4forms.common.search.FilterConfig;
import es.caib.avaedi.at4forms.common.search.PagingConfig;
import es.caib.avaedi.at4forms.common.search.ResultadoBusqueda;
import es.caib.avaedi.at4forms.logic.bo.BaseBO;
import es.caib.avaedi.common.model.Edificio;
import es.caib.avaedi.logic.vo.EdificioFormVO;
import es.caib.avaedi.logic.vo.EdificioListadoVO;

/**
 * Interfaz que define los métodos de negocio del Bean: Edificio
 * 
 * @author agarcia@at4.net
 * 
 */
public interface EdificioBO extends BaseBO<EdificioListadoVO, EdificioFormVO> {

	/*
	 * Finders para relaciones
	 */

	ResultadoBusqueda<EdificioListadoVO> findByVia(int viaId) throws GenericBusinessException;
	//public ResultadoBusqueda<EdificioFormVO> getListadoCompleto(Collection<FilterConfig> filters, PagingConfig pagingConfig) throws GenericBusinessException;

	ResultadoBusqueda<EdificioListadoVO> findByVia(int viaId, PagingConfig pagingConfig) throws GenericBusinessException;

	ResultadoBusqueda<EdificioListadoVO> findByVia(int viaId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException;

	/**
	 * Devuelve la instancia de EdificioFormVO que cumple con la búsqueda
	 * findByCodigoCatastro
	 * 
	 * @param codigoCatastro
	 * @return la instancia de EdificioFormVO
	 * @throws GenericBusinessException
	 */
	public EdificioFormVO findByCodigoCatastro(String codigoCatastro) throws GenericBusinessException;

	public ResultadoBusqueda<EdificioFormVO> getListadoCompleto(Collection<FilterConfig> filters, PagingConfig pagingConfig) throws GenericBusinessException;

}
