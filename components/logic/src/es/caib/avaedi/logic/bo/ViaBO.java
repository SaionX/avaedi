package es.caib.avaedi.logic.bo;

import java.util.Collection;

import es.caib.avaedi.at4forms.common.exception.GenericBusinessException;
import es.caib.avaedi.at4forms.common.search.FilterConfig;
import es.caib.avaedi.at4forms.common.search.PagingConfig;
import es.caib.avaedi.at4forms.common.search.ResultadoBusqueda;
import es.caib.avaedi.at4forms.logic.bo.BaseBO;
import es.caib.avaedi.logic.server.vo.ViaRestVO;
import es.caib.avaedi.logic.vo.ViaFormVO;
import es.caib.avaedi.logic.vo.ViaListadoVO;

/**
 * Interfaz que define los métodos de negocio del Bean: Via
 * 
 * @author agarcia@at4.net
 * 
 */
public interface ViaBO extends BaseBO<ViaListadoVO, ViaFormVO> {

	/*
	 * Finders para relaciones
	 */

	ResultadoBusqueda<ViaListadoVO> findByTipoVia(int tipoViaId) throws GenericBusinessException;

	ResultadoBusqueda<ViaListadoVO> findByTipoVia(int tipoViaId, PagingConfig pagingConfig) throws GenericBusinessException;

	ResultadoBusqueda<ViaListadoVO> findByTipoVia(int tipoViaId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException;

	ResultadoBusqueda<ViaListadoVO> findByMunicipio(int municipioId) throws GenericBusinessException;

	ResultadoBusqueda<ViaListadoVO> findByMunicipio(int municipioId, PagingConfig pagingConfig) throws GenericBusinessException;

	ResultadoBusqueda<ViaListadoVO> findByMunicipio(int municipioId, PagingConfig pagingConfig, Collection<FilterConfig> filters) throws GenericBusinessException;

	/**
	 * Devuelve la instancia de ViaFormVO que cumple con la búsqueda
	 * findViaDeMunicipio
	 * 
	 * @param codigo
	 * @param municipioId
	 * @return la instancia de ViaFormVO
	 * @throws GenericBusinessException
	 */
	public ViaFormVO findViaDeMunicipio(int codigo, int municipioId) throws GenericBusinessException;

	/**
	 * Devuelve la instancia de ViaFormVO que cumple con la búsqueda
	 * findByCodigoCatastro
	 * 
	 * @param codigo
	 * @param municipio
	 * @return la instancia de ViaFormVO
	 * @throws GenericBusinessException
	 */
	public ViaFormVO findByCodigoCatastro(int codigo, int municipio) throws GenericBusinessException;

	/**
	 * Devuelve la instancia de ViaFormVO que cumple con la búsqueda
	 * findViaDuplicada
	 * 
	 * @param nombre
	 * @param municipioId
	 * @param tipoViaId
	 * @return la instancia de ViaFormVO
	 * @throws GenericBusinessException
	 */
	public ViaFormVO findViaDuplicada(String nombre, int municipioId, int tipoViaId) throws GenericBusinessException;

	/**
	 * Devuelve la instancia de ViaFormVO que cumple con la búsqueda
	 * findViaDeMunicipioNombre
	 * 
	 * @param nombre
	 * @param municipioId
	 * @return la instancia de ViaFormVO
	 * @throws GenericBusinessException
	 */
	public ViaFormVO findViaDeMunicipioNombre(String nombre, int municipioId) throws GenericBusinessException;

	/**
	 * Devuelve la instancia de ViaFormVO que cumple con la búsqueda
	 * findByNombre
	 * 
	 * @param nombre
	 * @return la instancia de ViaFormVO
	 * @throws GenericBusinessException
	 */
	public ViaFormVO findByNombre(String nombre) throws GenericBusinessException;

	ResultadoBusqueda<ViaRestVO> restListado(Collection<FilterConfig> filters, PagingConfig pagingConfig) throws GenericBusinessException;

}
