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
import es.caib.avaedi.common.persistence.MunicipioDaoImpl;
import es.caib.avaedi.common.realm.Constants;
import es.caib.avaedi.logic.bo.MunicipioBO;
import es.caib.avaedi.logic.bo.MunicipioBean;
import es.caib.avaedi.logic.vo.MunicipioFormVO;

/**
 * Ejb para tratar el formulario: Municipio
 * 
 * @author agarcia@at4.net
 * 
 */
@Stateless(mappedName = "es.caib.avaedi.logic.ejb.MunicipioBeanEjb")
@RolesAllowed("AED_ADMIN,AED_OPERADOR,AED_CONSULTA,AED_MUNICIPI")
@TransactionManagement(TransactionManagementType.CONTAINER)
public class MunicipioBeanEjb extends MunicipioBean implements MunicipioBO {

	/**
	 * The logger object.
	 */
	private static Logger log = LogService.getLogger(MunicipioBeanEjb.class);

	/**
	 * Configura el SessionFactory y los dao
	 */
	@PostConstruct
	public void init() {
		log.info("init: " + this.getClass());
		this.mainDao = new MunicipioDaoImpl(this.getSessionFactory());

		this.islaDao = new IslaDaoImpl(this.getSessionFactory());

	}

	/**
	 * Libera los recursos
	 */
	@PreDestroy
	public void destroy() {
		log.info("destroy: " + this.getClass());
		this.setSessionFactory(null);
		((MunicipioDaoImpl) this.mainDao).setSessionFactory(null);
		this.mainDao = null;

		((IslaDaoImpl) this.islaDao).setSessionFactory(null);
		this.islaDao = null;

	}
	
	/*
	 * ************************** Permisos ************************************
	 */
	
	@Override
	@RolesAllowed(Constants.ADMIN + "," + Constants.OPERADOR + "," + Constants.MUNICIPI)
	public MunicipioFormVO add(MunicipioFormVO formData) throws GenericBusinessException {
		return super.add(formData);
	}

	@Override
	@RolesAllowed(Constants.ADMIN + "," + Constants.OPERADOR + "," + Constants.MUNICIPI)
	public MunicipioFormVO update(Serializable id, MunicipioFormVO formData) throws GenericBusinessException {
		return super.update(id, formData);
	}

	@Override
	@RolesAllowed(Constants.ADMIN + "," + Constants.OPERADOR + "," + Constants.MUNICIPI)
	public boolean delete(Serializable id) throws GenericBusinessException {
		return super.delete(id);
	}

	

}
