package es.caib.avaedi.at4forms.common.persistence.service;

import java.net.URL;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import es.caib.avaedi.at4forms.common.util.log.LogService;

import org.slf4j.Logger;

/**
 * Servei per obtenir els recursos necessaris per operar amb hibernate.
 */
public final class HibernateService {
	/**
	 * El objeto logger
	 */
	private static final Logger log = LogService.getLogger(HibernateService.class);
	private static SessionFactory sf = null;

    public static SessionFactory getSessionFactory() throws HibernateException {
    	
    	if (sf == null) {
            sf = initSessionFactory();
    	}
        return sf;
    }

    private static SessionFactory initSessionFactory()
        throws HibernateException {
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        URL url = cl.getResource("hibernate.cfg.xml");
        Configuration cfg = new AnnotationConfiguration().configure(url);
        return cfg.buildSessionFactory();
    }
}

