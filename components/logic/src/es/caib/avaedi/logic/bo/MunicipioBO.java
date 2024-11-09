package es.caib.avaedi.logic.bo;

import java.util.Collection;

import es.caib.avaedi.at4forms.common.exception.GenericBusinessException;
import es.caib.avaedi.at4forms.common.search.FilterConfig;
import es.caib.avaedi.at4forms.common.search.PagingConfig;
import es.caib.avaedi.at4forms.common.search.ResultadoBusqueda;
import es.caib.avaedi.at4forms.logic.bo.BaseBO;
import es.caib.avaedi.logic.vo.MunicipioFormVO;
import es.caib.avaedi.logic.vo.MunicipioListadoVO;

/**
 * Interfaz que define los métodos de negocio del Bean: Municipio
 * 
 * @author agarcia@at4.net
 * 
 */
public interface MunicipioBO extends BaseBO<MunicipioListadoVO, MunicipioFormVO> {

	/*
	 * Finders para relaciones
	 */

	ResultadoBusqueda<MunicipioListadoVO> findByIsla(int islaId) throws GenericBusinessException;

	ResultadoBusqueda<MunicipioListadoVO> findByIsla(int islaId, PagingConfig pagingConfig) throws GenericBusinessException;

	ResultadoBusqueda<MunicipioListadoVO> findByIsla(int islaId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException;

	/**
	 * Devuelve la instancia de MunicipioFormVO que cumple con la búsqueda
	 * findByNombre
	 * 
	 * @param nombre
	 * @return la instancia de MunicipioFormVO
	 * @throws GenericBusinessException
	 */
	public MunicipioFormVO findByNombre(String nombre) throws GenericBusinessException;

	/**
	 * Devuelve la instancia de MunicipioFormVO que cumple con la búsqueda
	 * findByCodigoCatastro
	 * 
	 * @param codigoCatastro
	 * @return la instancia de MunicipioFormVO
	 * @throws GenericBusinessException
	 */
	public MunicipioFormVO findByCodigoCatastro(int codigoCatastro) throws GenericBusinessException;

}
