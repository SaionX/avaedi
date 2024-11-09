package es.caib.avaedi.logic.ejb;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import org.slf4j.Logger;

import es.caib.avaedi.at4forms.common.util.log.LogService;
import es.caib.avaedi.common.persistence.DeficienciaTipoDaoImpl;
import es.caib.avaedi.logic.bo.DeficienciaTipoBO;
import es.caib.avaedi.logic.bo.DeficienciaTipoBean;

/**
 * Ejb para tratar el formulario: DeficienciaTipo
 * 
 * @author agarcia@at4.net
 * 
 */
@Stateless(mappedName = "es.caib.avaedi.logic.ejb.DeficienciaTipoBeanEjb")
@RolesAllowed("AED_ADMIN,AED_OPERADOR,AED_CONSULTA,AED_MUNICIPI")
@TransactionManagement(TransactionManagementType.CONTAINER)
public class DeficienciaTipoBeanEjb extends DeficienciaTipoBean implements DeficienciaTipoBO {

	/**
	 * The logger object.
	 */
	private static Logger log = LogService.getLogger(DeficienciaTipoBeanEjb.class);

	/**
	 * Configura el SessionFactory y los dao
	 */
	@PostConstruct
	public void init() {
		log.info("init: " + this.getClass());
		this.mainDao = new DeficienciaTipoDaoImpl(this.getSessionFactory());

	}

	/**
	 * Libera los recursos
	 */
	@PreDestroy
	public void destroy() {
		log.info("destroy: " + this.getClass());
		this.setSessionFactory(null);
		((DeficienciaTipoDaoImpl) this.mainDao).setSessionFactory(null);
		this.mainDao = null;

	}

}
