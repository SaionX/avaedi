package es.caib.avaedi.logic.ejb;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import org.slf4j.Logger;

import es.caib.avaedi.at4forms.common.util.log.LogService;
import es.caib.avaedi.common.persistence.EstadoAplicacionDaoImpl;
import es.caib.avaedi.logic.bo.EstadoAplicacionBO;
import es.caib.avaedi.logic.bo.EstadoAplicacionBean;

/**
 * Ejb para tratar el formulario: EstadoAplicacion
 * 
 * @author agarcia@at4.net
 * 
 */
@Stateless(mappedName = "es.caib.avaedi.logic.ejb.EstadoAplicacionBeanEjb")
@RolesAllowed("AED_ADMIN,AED_OPERADOR,AED_CONSULTA,AED_MUNICIPI")
@TransactionManagement(TransactionManagementType.CONTAINER)
public class EstadoAplicacionBeanEjb extends EstadoAplicacionBean implements EstadoAplicacionBO {

	/**
	 * The logger object.
	 */
	private static Logger log = LogService.getLogger(EstadoAplicacionBeanEjb.class);

	/**
	 * Configura el SessionFactory y los dao
	 */
	@PostConstruct
	public void init() {
		log.info("init: " + this.getClass());
		this.mainDao = new EstadoAplicacionDaoImpl(this.getSessionFactory());

	}

	/**
	 * Libera los recursos
	 */
	@PreDestroy
	public void destroy() {
		log.info("destroy: " + this.getClass());
		this.setSessionFactory(null);
		((EstadoAplicacionDaoImpl) this.mainDao).setSessionFactory(null);
		this.mainDao = null;

	}

}
