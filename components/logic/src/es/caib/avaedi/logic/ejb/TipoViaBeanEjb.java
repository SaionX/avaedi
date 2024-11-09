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
import es.caib.avaedi.common.persistence.TipoViaDaoImpl;
import es.caib.avaedi.common.realm.Constants;
import es.caib.avaedi.logic.bo.TipoViaBO;
import es.caib.avaedi.logic.bo.TipoViaBean;
import es.caib.avaedi.logic.vo.TipoViaFormVO;

/**
 * Ejb para tratar el formulario: TipoVia
 * 
 * @author agarcia@at4.net
 * 
 */
@Stateless(mappedName = "es.caib.avaedi.logic.ejb.TipoViaBeanEjb")
@RolesAllowed("AED_ADMIN,AED_OPERADOR,AED_CONSULTA,AED_MUNICIPI")
@TransactionManagement(TransactionManagementType.CONTAINER)
public class TipoViaBeanEjb extends TipoViaBean implements TipoViaBO {

	/**
	 * The logger object.
	 */
	private static Logger log = LogService.getLogger(TipoViaBeanEjb.class);

	/**
	 * Configura el SessionFactory y los dao
	 */
	@PostConstruct
	public void init() {
		log.info("init: " + this.getClass());
		this.mainDao = new TipoViaDaoImpl(this.getSessionFactory());

	}

	/**
	 * Libera los recursos
	 */
	@PreDestroy
	public void destroy() {
		log.info("destroy: " + this.getClass());
		this.setSessionFactory(null);
		((TipoViaDaoImpl) this.mainDao).setSessionFactory(null);
		this.mainDao = null;

	}

	/*
	 * ************************** Permisos ************************************
	 */
	
	@Override
	@RolesAllowed(Constants.ADMIN)
	public TipoViaFormVO add(TipoViaFormVO formData) throws GenericBusinessException {
		return super.add(formData);
	}

	@Override
	@RolesAllowed(Constants.ADMIN)
	public TipoViaFormVO update(Serializable id, TipoViaFormVO formData) throws GenericBusinessException {
		return super.update(id, formData);
	}

	@Override
	@RolesAllowed(Constants.ADMIN)
	public boolean delete(Serializable id) throws GenericBusinessException {
		return super.delete(id);
	}

}
