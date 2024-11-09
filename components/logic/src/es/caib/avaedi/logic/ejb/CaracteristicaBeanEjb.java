package es.caib.avaedi.logic.ejb;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import org.slf4j.Logger;

import es.caib.avaedi.at4forms.common.util.log.LogService;
import es.caib.avaedi.common.persistence.CaracteristicaDaoImpl;
import es.caib.avaedi.common.persistence.GrupoCaracteristicasDaoImpl;
import es.caib.avaedi.logic.bo.CaracteristicaBO;
import es.caib.avaedi.logic.bo.CaracteristicaBean;

/**
 * Ejb para tratar el formulario: Caracteristica
 * 
 * @author agarcia@at4.net
 * 
 */
@Stateless(mappedName = "es.caib.avaedi.logic.ejb.CaracteristicaBeanEjb")
@RolesAllowed("AED_ADMIN,AED_OPERADOR,AED_CONSULTA,AED_MUNICIPI")
@TransactionManagement(TransactionManagementType.CONTAINER)
public class CaracteristicaBeanEjb extends CaracteristicaBean implements CaracteristicaBO {

	/**
	 * The logger object.
	 */
	private static Logger log = LogService.getLogger(CaracteristicaBeanEjb.class);

	/**
	 * Configura el SessionFactory y los dao
	 */
	@PostConstruct
	public void init() {
		log.info("init: " + this.getClass());
		this.mainDao = new CaracteristicaDaoImpl(this.getSessionFactory());

		this.grupoCaracteristicasDao = new GrupoCaracteristicasDaoImpl(this.getSessionFactory());

	}

	/**
	 * Libera los recursos
	 */
	@PreDestroy
	public void destroy() {
		log.info("destroy: " + this.getClass());
		this.setSessionFactory(null);
		((CaracteristicaDaoImpl) this.mainDao).setSessionFactory(null);
		this.mainDao = null;

		((GrupoCaracteristicasDaoImpl) this.grupoCaracteristicasDao).setSessionFactory(null);
		this.grupoCaracteristicasDao = null;

	}

}
