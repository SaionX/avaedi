package es.caib.avaedi.front.service.general;

import es.caib.avaedi.at4forms.common.realm.BaseFrontPrincipal;
import es.caib.avaedi.at4forms.front.service.DefaultBaseService;
import es.caib.avaedi.at4forms.logic.bo.BaseBO;
import es.caib.avaedi.at4forms.logic.vo.FormVO;
import es.caib.avaedi.at4forms.logic.vo.ListadoVO;
import es.caib.avaedi.common.realm.Constants;

/**
 * Clase base sobre la que construir servicios de front. En particular,
 * formularios (FormService)
 * 
 * @author agarcia
 * 
 */
public abstract class BaseService<BO extends BaseBO<LO, FO>, LO extends ListadoVO, FO extends FormVO> extends DefaultBaseService<BO, LO, FO> {

	/**
	 * Indica si el usuario dispone de permisos para la acción action.
	 * 
	 * @param usuari
	 * @param action
	 * @param instance
	 * @return true/false según si el usuario dispone o no de permisos
	 */
	protected boolean hasPerms(BaseFrontPrincipal usuari, String action, FO instance) {

		if (action.equals(PERMS_ADD) || action.equals(PERMS_UPDATE) || action.equals(PERMS_DELETE)) {
			return usuari.isInAnyRole(Constants.ADMIN, Constants.OPERADOR);
		} else if (action.equals(PERMS_LIST) || action.equals(PERMS_EXPORT)) {
			return usuari.isInAnyRole(Constants.ADMIN, Constants.OPERADOR, Constants.CONSULTA);
		}

		return false;

	}

}
