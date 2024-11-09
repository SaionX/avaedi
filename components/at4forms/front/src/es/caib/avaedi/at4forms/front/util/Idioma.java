package es.caib.avaedi.at4forms.front.util;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

import es.caib.avaedi.at4forms.common.util.ApplicationContextHolder;
import es.caib.avaedi.at4forms.common.util.log.LogService;



/**
 *
 * @author agarcia
 */
public class Idioma {
	private static final Logger log = LogService.getLogger(Idioma.class);

	/**
	 * getLang
	 * @param request
	 * @return
	 */
	public static String getLang(HttpServletRequest request) {
		String lang = "ca";
		CookieLocaleResolver localeResolver = (CookieLocaleResolver)ApplicationContextHolder.getInstance().getService("localeResolver");
		if (localeResolver != null) {
			Locale locale = localeResolver.resolveLocale(request);
			lang = locale.getLanguage();
		} else {
			log.debug("getLang - localeResolver null");
		}
		return (lang);
	}


	/**
	 * getLocale
	 * @param request
	 * @return
	 */
	public static Locale getLocale(HttpServletRequest request) {
		return (new Locale(getLang(request)));
	}

}
