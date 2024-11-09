package es.caib.avaedi.logic.ejb;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import org.slf4j.Logger;

import es.caib.avaedi.at4forms.common.util.log.LogService;
import es.caib.avaedi.common.persistence.AcusticaRuidoInstalacionesDaoImpl;
import es.caib.avaedi.common.persistence.InspeccionDaoImpl;
import es.caib.avaedi.logic.bo.AcusticaRuidoInstalacionesBO;
import es.caib.avaedi.logic.bo.AcusticaRuidoInstalacionesBean;

/**
 * Ejb para tratar el formulario: AcusticaRuidoInstalaciones
 * 
 * @author agarcia@at4.net
 * 
 */
@Stateless(mappedName = "es.caib.avaedi.logic.ejb.AcusticaRuidoInstalacionesBeanEjb")
@RolesAllowed("AED_ADMIN,AED_OPERADOR,AED_CONSULTA,AED_MUNICIPI")
@TransactionManagement(TransactionManagementType.CONTAINER)
public class AcusticaRuidoInstalacionesBeanEjb extends AcusticaRuidoInstalacionesBean implements AcusticaRuidoInstalacionesBO {

	/**
	 * The logger object.
	 */
	private static Logger log = LogService.getLogger(AcusticaRuidoInstalacionesBeanEjb.class);

	/**
	 * Configura el SessionFactory y los dao
	 */
	@PostConstruct
	public void init() {
		log.info("init: " + this.getClass());
		this.mainDao = new AcusticaRuidoInstalacionesDaoImpl(this.getSessionFactory());

		this.inspeccionDao = new InspeccionDaoImpl(this.getSessionFactory());

	}

	/**
	 * Libera los recursos
	 */
	@PreDestroy
	public void destroy() {
		log.info("destroy: " + this.getClass());
		this.setSessionFactory(null);
		((AcusticaRuidoInstalacionesDaoImpl) this.mainDao).setSessionFactory(null);
		this.mainDao = null;

		((InspeccionDaoImpl) this.inspeccionDao).setSessionFactory(null);
		this.inspeccionDao = null;

	}

}
