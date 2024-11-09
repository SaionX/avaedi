package es.caib.avaedi.logic.ejb;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import org.slf4j.Logger;

import es.caib.avaedi.at4forms.common.util.log.LogService;
import es.caib.avaedi.common.persistence.AcusticaRuidosInterioresHorizontalesDaoImpl;
import es.caib.avaedi.common.persistence.InspeccionDaoImpl;
import es.caib.avaedi.logic.bo.AcusticaRuidosInterioresHorizontalesBO;
import es.caib.avaedi.logic.bo.AcusticaRuidosInterioresHorizontalesBean;

/**
 * Ejb para tratar el formulario: AcusticaRuidosInterioresHorizontales
 * 
 * @author agarcia@at4.net
 * 
 */
@Stateless(mappedName = "es.caib.avaedi.logic.ejb.AcusticaRuidosInterioresHorizontalesBeanEjb")
@RolesAllowed("AED_ADMIN,AED_OPERADOR,AED_CONSULTA,AED_MUNICIPI")
@TransactionManagement(TransactionManagementType.CONTAINER)
public class AcusticaRuidosInterioresHorizontalesBeanEjb extends AcusticaRuidosInterioresHorizontalesBean implements AcusticaRuidosInterioresHorizontalesBO {

	/**
	 * The logger object.
	 */
	private static Logger log = LogService.getLogger(AcusticaRuidosInterioresHorizontalesBeanEjb.class);

	/**
	 * Configura el SessionFactory y los dao
	 */
	@PostConstruct
	public void init() {
		log.info("init: " + this.getClass());
		this.mainDao = new AcusticaRuidosInterioresHorizontalesDaoImpl(this.getSessionFactory());

		this.inspeccionDao = new InspeccionDaoImpl(this.getSessionFactory());

	}

	/**
	 * Libera los recursos
	 */
	@PreDestroy
	public void destroy() {
		log.info("destroy: " + this.getClass());
		this.setSessionFactory(null);
		((AcusticaRuidosInterioresHorizontalesDaoImpl) this.mainDao).setSessionFactory(null);
		this.mainDao = null;

		((InspeccionDaoImpl) this.inspeccionDao).setSessionFactory(null);
		this.inspeccionDao = null;

	}

}
