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
import es.caib.avaedi.common.persistence.ValorDaoImpl;
import es.caib.avaedi.logic.bo.ValorBO;
import es.caib.avaedi.logic.bo.ValorBean;

/**
 * Ejb para tratar el formulario: Valor
 * 
 * @author agarcia@at4.net
 * 
 */
@Stateless(mappedName = "es.caib.avaedi.logic.ejb.ValorBeanEjb")
@RolesAllowed("AED_ADMIN,AED_OPERADOR,AED_CONSULTA,AED_MUNICIPI")
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ValorBeanEjb extends ValorBean implements ValorBO {

	/**
	 * The logger object.
	 */
	private static Logger log = LogService.getLogger(ValorBeanEjb.class);

	/**
	 * Configura el SessionFactory y los dao
	 */
	@PostConstruct
	public void init() {
		log.info("init: " + this.getClass());
		this.mainDao = new ValorDaoImpl(this.getSessionFactory());

		this.caracteristicaDao = new CaracteristicaDaoImpl(this.getSessionFactory());

	}

	/**
	 * Libera los recursos
	 */
	@PreDestroy
	public void destroy() {
		log.info("destroy: " + this.getClass());
		this.setSessionFactory(null);
		((ValorDaoImpl) this.mainDao).setSessionFactory(null);
		this.mainDao = null;

		((CaracteristicaDaoImpl) this.caracteristicaDao).setSessionFactory(null);
		this.caracteristicaDao = null;

	}

}
