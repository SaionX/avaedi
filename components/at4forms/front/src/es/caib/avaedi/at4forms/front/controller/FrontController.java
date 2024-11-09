package es.caib.avaedi.at4forms.front.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.mvc.AbstractController;

import es.caib.avaedi.at4forms.common.exception.GenericBusinessException;
import es.caib.avaedi.at4forms.common.exception.PrincipalException;
import es.caib.avaedi.at4forms.common.realm.BaseFrontPrincipal;
import es.caib.avaedi.front.config.LocalAuthenticationProvider;

public abstract class FrontController extends AbstractController  {
 

	@Autowired @Qualifier("localeResolver")
	private LocaleResolver localeResolver = null;

	@Autowired 
	LocalAuthenticationProvider authProvider;	

	/**
	 * Obtiene el locale para el request
	 * @param request
	 * @return el locale para el request
	 */
	protected Locale getLocale(HttpServletRequest request) {
		return this.localeResolver.resolveLocale(request);
	}

	/**
	 * TODO: generalizar
	 * @param request
	 * @return
	 * @throws PrincipalException
	 */
	public BaseFrontPrincipal getUsuari(HttpServletRequest request) throws PrincipalException {
		
		//return (BaseFrontPrincipal)request.getUserPrincipal();
		try {
			return authProvider.loadFromAuthenticatedRequest(request);
		} catch (GenericBusinessException e) {
			throw new PrincipalException(e);
		}
	}

}
