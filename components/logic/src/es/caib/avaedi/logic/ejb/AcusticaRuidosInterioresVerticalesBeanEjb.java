package es.caib.avaedi.logic.ejb;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import org.slf4j.Logger;

import es.caib.avaedi.at4forms.common.util.log.LogService;
import es.caib.avaedi.common.persistence.AcusticaRuidosInterioresVerticalesDaoImpl;
import es.caib.avaedi.common.persistence.InspeccionDaoImpl;
import es.caib.avaedi.logic.bo.AcusticaRuidosInterioresVerticalesBO;
import es.caib.avaedi.logic.bo.AcusticaRuidosInterioresVerticalesBean;

/**
 * Ejb para tratar el formulario: AcusticaRuidosInterioresVerticales
 * 
 * @author agarcia@at4.net
 * 
 */
@Stateless(mappedName = "es.caib.avaedi.logic.ejb.AcusticaRuidosInterioresVerticalesBeanEjb")
@RolesAllowed("AED_ADMIN,AED_OPERADOR,AED_CONSULTA,AED_MUNICIPI")
@TransactionManagement(TransactionManagementType.CONTAINER)
public class AcusticaRuidosInterioresVerticalesBeanEjb extends AcusticaRuidosInterioresVerticalesBean implements AcusticaRuidosInterioresVerticalesBO {

	/**
	 * The logger object.
	 */
	private static Logger log = LogService.getLogger(AcusticaRuidosInterioresVerticalesBeanEjb.class);

	/**
	 * Configura el SessionFactory y los dao
	 */
	@PostConstruct
	public void init() {
		log.info("init: " + this.getClass());
		this.mainDao = new AcusticaRuidosInterioresVerticalesDaoImpl(this.getSessionFactory());

		this.inspeccionDao = new InspeccionDaoImpl(this.getSessionFactory());

	}

	/**
	 * Libera los recursos
	 */
	@PreDestroy
	public void destroy() {
		log.info("destroy: " + this.getClass());
		this.setSessionFactory(null);
		((AcusticaRuidosInterioresVerticalesDaoImpl) this.mainDao).setSessionFactory(null);
		this.mainDao = null;

		((InspeccionDaoImpl) this.inspeccionDao).setSessionFactory(null);
		this.inspeccionDao = null;

	}

}
