package es.caib.avaedi.at4forms.front.service;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationContextException;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.web.servlet.LocaleResolver;

/**
 * Clase base sobre la que construir servicios de front. En particular,
 * formularios (FormService)
 *
 * @author agarcia
 *
 */
public class MessageService implements ApplicationContextAware {


	protected ApplicationContext applicationContext;
	private MessageSourceAccessor messageSourceAccessor;
	
	@Autowired @Qualifier("localeResolver")
	private LocaleResolver localeResolver = null;

	/**
	 * Fija el ApplicationContext
	 * @see ApplicationContextAware#setApplicationContext(ApplicationContext)
	 */
	public void setApplicationContext(ApplicationContext context) throws BeansException {

		if (context == null) {
			// reset internal context state
			this.applicationContext = null;
			this.messageSourceAccessor = null;
		}

		if (this.applicationContext == null) {
			// initialize with passed-in context
			if (!(ApplicationContext.class).isInstance(context)) {

				throw new ApplicationContextException(
						"Invalid application context: needs to be of type [" + (ApplicationContext.class).getName() + "]"
				);
			}

			this.applicationContext = context;
			this.messageSourceAccessor = new MessageSourceAccessor(context);

		} else {

			// ignore reinitialization if same context passed in
			if (this.applicationContext != context) {
				throw new ApplicationContextException(
						"Cannot reinitialize with different application context: current one is [" +
						this.applicationContext + "], passed-in one is [" + context + "]");
			}
		}
	}

	/**
	 * Obtiene un mensaje del resource bundle para el locale
	 * @param codi
	 * @param locale
	 * @return mensaje del resource bundle para el locale
	 */
	protected String getMessage (String codi, Locale locale) {
		try {
			return this.messageSourceAccessor.getMessage(codi, locale);
		} catch (org.springframework.context.NoSuchMessageException nse) {
			return codi;
		}
	}

	
	/**
	 * Obtiene un mensaje del resource bundle para el locale, parseando los argumentos
	 * @param codi
	 * @param args
	 * @param locale
	 * @return mensaje del resource bundle para el locale
	 */
	protected String getMessage (String codi, Object[] args, Locale locale) {
		return this.messageSourceAccessor.getMessage(codi, args, locale);
	}

	/**
	 * @param localeResolver the localeResolver to set
	 */
	public void setLocaleResolver(LocaleResolver localeResolver) {
		this.localeResolver = localeResolver;
	}

	/**
	 * Obtiene el locale para el request
	 * @param request
	 * @return el locale para el request
	 */
	protected Locale getLocale(HttpServletRequest request) {
		return this.localeResolver.resolveLocale(request);
	}



}
