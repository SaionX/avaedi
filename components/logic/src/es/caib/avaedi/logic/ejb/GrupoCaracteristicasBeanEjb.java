package es.caib.avaedi.logic.ejb;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import org.slf4j.Logger;

import es.caib.avaedi.at4forms.common.util.log.LogService;
import es.caib.avaedi.common.persistence.GrupoCaracteristicasDaoImpl;
import es.caib.avaedi.logic.bo.GrupoCaracteristicasBO;
import es.caib.avaedi.logic.bo.GrupoCaracteristicasBean;

/**
 * Ejb para tratar el formulario: GrupoCaracteristicas
 * 
 * @author agarcia@at4.net
 * 
 */
@Stateless(mappedName = "es.caib.avaedi.logic.ejb.GrupoCaracteristicasBeanEjb")
@RolesAllowed("AED_ADMIN,AED_OPERADOR,AED_CONSULTA,AED_MUNICIPI")
@TransactionManagement(TransactionManagementType.CONTAINER)
public class GrupoCaracteristicasBeanEjb extends GrupoCaracteristicasBean implements GrupoCaracteristicasBO {

	/**
	 * The logger object.
	 */
	private static Logger log = LogService.getLogger(GrupoCaracteristicasBeanEjb.class);

	/**
	 * Configura el SessionFactory y los dao
	 */
	@PostConstruct
	public void init() {
		log.info("init: " + this.getClass());
		this.mainDao = new GrupoCaracteristicasDaoImpl(this.getSessionFactory());

	}

	/**
	 * Libera los recursos
	 */
	@PreDestroy
	public void destroy() {
		log.info("destroy: " + this.getClass());
		this.setSessionFactory(null);
		((GrupoCaracteristicasDaoImpl) this.mainDao).setSessionFactory(null);
		this.mainDao = null;

	}

}
