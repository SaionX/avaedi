package es.caib.avaedi.front.config;

import es.caib.avaedi.at4forms.common.realm.BaseFrontPrincipal;
import es.caib.avaedi.common.realm.Constants;

public class AuthUtils {

	/**
	 * Comprueba si un usuario tiene acceso a un municipio
	 * 
	 * @param usuari
	 * @param tipoContratoId
	 * @return
	 */
	public static boolean hasAccess(BaseFrontPrincipal usuari, int municipioId) {

		if (usuari.isInRole(Constants.MUNICIPI)) {

			return (municipioId == ((LocalUserDetails) usuari).getUsuario().getMunicipioId());

		} else {

			return true;

		}

	}

	public static String municipioId(BaseFrontPrincipal usuari) {
		if (usuari.isInRole(Constants.MUNICIPI)) {
			int municipioId = ((LocalUserDetails) usuari).getUsuario().getMunicipioId();
			if (municipioId > 0) {
				return String.valueOf(municipioId);
			} else {
				return "0"; //Si es un usuario de tipo municipio pero no tiene municipio asignado
			}
		}
		return null;
	}

}
