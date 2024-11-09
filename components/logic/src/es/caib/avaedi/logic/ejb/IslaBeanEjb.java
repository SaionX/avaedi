package es.caib.avaedi.logic.ejb;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import org.slf4j.Logger;

import es.caib.avaedi.at4forms.common.exception.GenericBusinessException;
import es.caib.avaedi.at4forms.common.util.log.LogService;
import es.caib.avaedi.common.persistence.IslaDaoImpl;
import es.caib.avaedi.common.realm.Constants;
import es.caib.avaedi.logic.bo.IslaBO;
import es.caib.avaedi.logic.bo.IslaBean;
import es.caib.avaedi.logic.vo.IslaFormVO;

/**
 * Ejb para tratar el formulario: Isla
 * 
 * @author agarcia@at4.net
 * 
 */
@Stateless(mappedName = "es.caib.avaedi.logic.ejb.IslaBeanEjb")
@RolesAllowed("AED_ADMIN,AED_OPERADOR,AED_CONSULTA,AED_MUNICIPI")
@TransactionManagement(TransactionManagementType.CONTAINER)
public class IslaBeanEjb extends IslaBean implements IslaBO {

	/**
	 * The logger object.
	 */
	private static Logger log = LogService.getLogger(IslaBeanEjb.class);

	/**
	 * Configura el SessionFactory y los dao
	 */
	@PostConstruct
	public void init() {
		log.info("init: " + this.getClass());
		this.mainDao = new IslaDaoImpl(this.getSessionFactory());

	}

	/**
	 * Libera los recursos
	 */
	@PreDestroy
	public void destroy() {
		log.info("destroy: " + this.getClass());
		this.setSessionFactory(null);
		((IslaDaoImpl) this.mainDao).setSessionFactory(null);
		this.mainDao = null;

	}

	/*
	 * ************************** Permisos ************************************
	 */
	
	@Override
	@RolesAllowed(Constants.ADMIN)
	public IslaFormVO add(IslaFormVO formData) throws GenericBusinessException {
		return super.add(formData);
	}

	@Override
	@RolesAllowed(Constants.ADMIN)
	public IslaFormVO update(Serializable id, IslaFormVO formData) throws GenericBusinessException {
		return super.update(id, formData);
	}

	@Override
	@RolesAllowed(Constants.ADMIN)
	public boolean delete(Serializable id) throws GenericBusinessException {
		return super.delete(id);
	}


}
