package es.caib.avaedi.logic.ejb;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import org.slf4j.Logger;

import es.caib.avaedi.at4forms.common.util.log.LogService;
import es.caib.avaedi.common.persistence.DeficienciaDaoImpl;
import es.caib.avaedi.common.persistence.DeficienciaTipoDaoImpl;
import es.caib.avaedi.common.persistence.InspeccionDaoImpl;
import es.caib.avaedi.logic.bo.DeficienciaBO;
import es.caib.avaedi.logic.bo.DeficienciaBean;

/**
 * Ejb para tratar el formulario: Deficiencia
 * 
 * @author agarcia@at4.net
 * 
 */
@Stateless(mappedName = "es.caib.avaedi.logic.ejb.DeficienciaBeanEjb")
@RolesAllowed("AED_ADMIN,AED_OPERADOR,AED_CONSULTA,AED_MUNICIPI")
@TransactionManagement(TransactionManagementType.CONTAINER)
public class DeficienciaBeanEjb extends DeficienciaBean implements DeficienciaBO {

	/**
	 * The logger object.
	 */
	private static Logger log = LogService.getLogger(DeficienciaBeanEjb.class);

	/**
	 * Configura el SessionFactory y los dao
	 */
	@PostConstruct
	public void init() {
		log.info("init: " + this.getClass());
		this.mainDao = new DeficienciaDaoImpl(this.getSessionFactory());

		this.deficienciaTipoDao = new DeficienciaTipoDaoImpl(this.getSessionFactory());
		this.inspeccionDao = new InspeccionDaoImpl(this.getSessionFactory());

	}

	/**
	 * Libera los recursos
	 */
	@PreDestroy
	public void destroy() {
		log.info("destroy: " + this.getClass());
		this.setSessionFactory(null);
		((DeficienciaDaoImpl) this.mainDao).setSessionFactory(null);
		this.mainDao = null;

		((DeficienciaTipoDaoImpl) this.deficienciaTipoDao).setSessionFactory(null);
		this.deficienciaTipoDao = null;
		((InspeccionDaoImpl) this.inspeccionDao).setSessionFactory(null);
		this.inspeccionDao = null;

	}

}
