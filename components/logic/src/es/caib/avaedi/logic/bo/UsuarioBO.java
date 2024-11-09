package es.caib.avaedi.logic.bo;

import java.util.Collection;

import es.caib.avaedi.at4forms.common.exception.GenericBusinessException;
import es.caib.avaedi.at4forms.common.search.FilterConfig;
import es.caib.avaedi.at4forms.common.search.PagingConfig;
import es.caib.avaedi.at4forms.common.search.ResultadoBusqueda;
import es.caib.avaedi.at4forms.logic.bo.BaseBO;
import es.caib.avaedi.logic.vo.UsuarioFormVO;
import es.caib.avaedi.logic.vo.UsuarioListadoVO;

/**
 * Interfaz que define los métodos de negocio del Bean: Usuario
 * 
 * @author agarcia@at4.net
 * 
 */
public interface UsuarioBO extends BaseBO<UsuarioListadoVO, UsuarioFormVO> {

	/*
	 * Finders para relaciones
	 */

	ResultadoBusqueda<UsuarioListadoVO> findByMunicipio(int municipioId) throws GenericBusinessException;

	ResultadoBusqueda<UsuarioListadoVO> findByMunicipio(int municipioId, PagingConfig pagingConfig) throws GenericBusinessException;

	ResultadoBusqueda<UsuarioListadoVO> findByMunicipio(int municipioId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException;

	/**
	 * Devuelve la instancia de UsuarioFormVO que cumple con la búsqueda
	 * findUsuarioByUsername
	 * 
	 * @param username
	 * @return la instancia de UsuarioFormVO
	 * @throws GenericBusinessException
	 */
	public UsuarioFormVO findUsuarioByUsername(String username) throws GenericBusinessException;

}
