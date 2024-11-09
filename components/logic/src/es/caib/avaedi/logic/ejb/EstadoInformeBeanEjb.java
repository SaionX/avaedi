package es.caib.avaedi.logic.ejb;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import org.slf4j.Logger;

import es.caib.avaedi.at4forms.common.util.log.LogService;
import es.caib.avaedi.common.persistence.EstadoInformeDaoImpl;
import es.caib.avaedi.logic.bo.EstadoInformeBO;
import es.caib.avaedi.logic.bo.EstadoInformeBean;

/**
 * Ejb para tratar el formulario: EstadoInforme
 * 
 * @author agarcia@at4.net
 * 
 */
@Stateless(mappedName = "es.caib.avaedi.logic.ejb.EstadoInformeBeanEjb")
@RolesAllowed("AED_ADMIN,AED_OPERADOR,AED_CONSULTA,AED_MUNICIPI")
@TransactionManagement(TransactionManagementType.CONTAINER)
public class EstadoInformeBeanEjb extends EstadoInformeBean implements EstadoInformeBO {

	/**
	 * The logger object.
	 */
	private static Logger log = LogService.getLogger(EstadoInformeBeanEjb.class);

	/**
	 * Configura el SessionFactory y los dao
	 */
	@PostConstruct
	public void init() {
		log.info("init: " + this.getClass());
		this.mainDao = new EstadoInformeDaoImpl(this.getSessionFactory());

	}

	/**
	 * Libera los recursos
	 */
	@PreDestroy
	public void destroy() {
		log.info("destroy: " + this.getClass());
		this.setSessionFactory(null);
		((EstadoInformeDaoImpl) this.mainDao).setSessionFactory(null);
		this.mainDao = null;

	}

}
