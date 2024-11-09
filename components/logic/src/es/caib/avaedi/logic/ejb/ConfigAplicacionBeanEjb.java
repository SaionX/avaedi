package es.caib.avaedi.logic.ejb;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import org.slf4j.Logger;

import es.caib.avaedi.at4forms.common.util.log.LogService;
import es.caib.avaedi.common.persistence.ConfigAplicacionDaoImpl;
import es.caib.avaedi.logic.bo.ConfigAplicacionBO;
import es.caib.avaedi.logic.bo.ConfigAplicacionBean;

/**
 * Ejb para tratar el formulario: ConfigAplicacion
 * 
 * @author agarcia@at4.net
 * 
 */
@Stateless(mappedName = "es.caib.avaedi.logic.ejb.ConfigAplicacionBeanEjb")
@RolesAllowed("AED_ADMIN,AED_OPERADOR,AED_CONSULTA,AED_MUNICIPI")
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ConfigAplicacionBeanEjb extends ConfigAplicacionBean implements ConfigAplicacionBO {

	/**
	 * The logger object.
	 */
	private static Logger log = LogService.getLogger(ConfigAplicacionBeanEjb.class);

	/**
	 * Configura el SessionFactory y los dao
	 */
	@PostConstruct
	public void init() {
		log.info("init: " + this.getClass());
		this.mainDao = new ConfigAplicacionDaoImpl(this.getSessionFactory());

	}

	/**
	 * Libera los recursos
	 */
	@PreDestroy
	public void destroy() {
		log.info("destroy: " + this.getClass());
		this.setSessionFactory(null);
		((ConfigAplicacionDaoImpl) this.mainDao).setSessionFactory(null);
		this.mainDao = null;

	}

}
