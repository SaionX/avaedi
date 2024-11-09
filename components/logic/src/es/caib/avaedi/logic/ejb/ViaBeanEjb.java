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
import es.caib.avaedi.common.persistence.MunicipioDaoImpl;
import es.caib.avaedi.common.persistence.TipoViaDaoImpl;
import es.caib.avaedi.common.persistence.ViaDaoImpl;
import es.caib.avaedi.common.realm.Constants;
import es.caib.avaedi.logic.bo.ViaBO;
import es.caib.avaedi.logic.bo.ViaBean;
import es.caib.avaedi.logic.vo.ViaFormVO;

/**
 * Ejb para tratar el formulario: Via
 * 
 * @author agarcia@at4.net
 * 
 */
@Stateless(mappedName = "es.caib.avaedi.logic.ejb.ViaBeanEjb")
@RolesAllowed("AED_ADMIN,AED_OPERADOR,AED_CONSULTA,AED_MUNICIPI")
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ViaBeanEjb extends ViaBean implements ViaBO {

	/**
	 * The logger object.
	 */
	private static Logger log = LogService.getLogger(ViaBeanEjb.class);

	/**
	 * Configura el SessionFactory y los dao
	 */
	@PostConstruct
	public void init() {
		log.info("init: " + this.getClass());
		this.mainDao = new ViaDaoImpl(this.getSessionFactory());

		this.tipoViaDao = new TipoViaDaoImpl(this.getSessionFactory());
		this.municipioDao = new MunicipioDaoImpl(this.getSessionFactory());

	}

	/**
	 * Libera los recursos
	 */
	@PreDestroy
	public void destroy() {
		log.info("destroy: " + this.getClass());
		this.setSessionFactory(null);
		((ViaDaoImpl) this.mainDao).setSessionFactory(null);
		this.mainDao = null;

		((TipoViaDaoImpl) this.tipoViaDao).setSessionFactory(null);
		this.tipoViaDao = null;
		((MunicipioDaoImpl) this.municipioDao).setSessionFactory(null);
		this.municipioDao = null;

	}


	/*
	 * ************************** Permisos ************************************
	 */
	
	@Override
	@RolesAllowed(Constants.ADMIN + "," + Constants.OPERADOR + "," + Constants.MUNICIPI)
	public ViaFormVO add(ViaFormVO formData) throws GenericBusinessException {
		return super.add(formData);
	}

	@Override
	@RolesAllowed(Constants.ADMIN + "," + Constants.OPERADOR + "," + Constants.MUNICIPI)
	public ViaFormVO update(Serializable id, ViaFormVO formData) throws GenericBusinessException {
		return super.update(id, formData);
	}

	@Override
	@RolesAllowed(Constants.ADMIN + "," + Constants.OPERADOR + "," + Constants.MUNICIPI)
	public boolean delete(Serializable id) throws GenericBusinessException {
		return super.delete(id);
	}


}
