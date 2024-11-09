package es.caib.avaedi.logic.bo;

import es.caib.avaedi.at4forms.common.exception.GenericBusinessException;
import es.caib.avaedi.at4forms.logic.bo.BaseBO;
import es.caib.avaedi.logic.vo.TipoViaFormVO;
import es.caib.avaedi.logic.vo.TipoViaListadoVO;

/**
 * Interfaz que define los métodos de negocio del Bean: TipoVia
 * 
 * @author agarcia@at4.net
 * 
 */
public interface TipoViaBO extends BaseBO<TipoViaListadoVO, TipoViaFormVO> {

	/*
	 * Finders para relaciones
	 */

	/**
	 * Devuelve la instancia de TipoViaFormVO que cumple con la búsqueda
	 * findByCodigoCatastro
	 * 
	 * @param codigo
	 * @return la instancia de TipoViaFormVO
	 * @throws GenericBusinessException
	 */
	public TipoViaFormVO findByCodigoCatastro(String codigo) throws GenericBusinessException;

}
