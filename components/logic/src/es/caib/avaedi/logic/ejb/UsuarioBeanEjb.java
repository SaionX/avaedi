package es.caib.avaedi.logic.ejb;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import org.slf4j.Logger;

import es.caib.avaedi.at4forms.common.util.log.LogService;
import es.caib.avaedi.common.persistence.MunicipioDaoImpl;
import es.caib.avaedi.common.persistence.UsuarioDaoImpl;
import es.caib.avaedi.logic.bo.UsuarioBO;
import es.caib.avaedi.logic.bo.UsuarioBean;

/**
 * Ejb para tratar el formulario: Usuario
 * 
 * @author agarcia@at4.net
 * 
 */
@Stateless(mappedName = "es.caib.avaedi.logic.ejb.UsuarioBeanEjb")
@RolesAllowed("AED_ADMIN,AED_OPERADOR,AED_CONSULTA,AED_MUNICIPI")
@TransactionManagement(TransactionManagementType.CONTAINER)
public class UsuarioBeanEjb extends UsuarioBean implements UsuarioBO {

	/**
	 * The logger object.
	 */
	private static Logger log = LogService.getLogger(UsuarioBeanEjb.class);

	/**
	 * Configura el SessionFactory y los dao
	 */
	@PostConstruct
	public void init() {
		log.info("init: " + this.getClass());
		this.mainDao = new UsuarioDaoImpl(this.getSessionFactory());

		this.municipioDao = new MunicipioDaoImpl(this.getSessionFactory());

	}

	/**
	 * Libera los recursos
	 */
	@PreDestroy
	public void destroy() {
		log.info("destroy: " + this.getClass());
		this.setSessionFactory(null);
		((UsuarioDaoImpl) this.mainDao).setSessionFactory(null);
		this.mainDao = null;

		((MunicipioDaoImpl) this.municipioDao).setSessionFactory(null);
		this.municipioDao = null;

	}

}
