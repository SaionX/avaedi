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
import es.caib.avaedi.common.persistence.EdificioDaoImpl;
import es.caib.avaedi.common.persistence.EstadoInformeDaoImpl;
import es.caib.avaedi.common.persistence.InformeDaoImpl;
import es.caib.avaedi.common.persistence.InspeccionDaoImpl;
import es.caib.avaedi.common.realm.Constants;
import es.caib.avaedi.logic.bo.InformeBO;
import es.caib.avaedi.logic.bo.InformeBean;
import es.caib.avaedi.logic.vo.InformeFormVO;

/**
 * Ejb para tratar el formulario: Informe
 * 
 * @author agarcia@at4.net
 * 
 */
@Stateless(mappedName = "es.caib.avaedi.logic.ejb.InformeBeanEjb")
@RolesAllowed("AED_ADMIN,AED_OPERADOR,AED_CONSULTA,AED_MUNICIPI")
@TransactionManagement(TransactionManagementType.CONTAINER)
public class InformeBeanEjb extends InformeBean implements InformeBO {

	/**
	 * The logger object.
	 */
	private static Logger log = LogService.getLogger(InformeBeanEjb.class);

	/**
	 * Configura el SessionFactory y los dao
	 */
	@PostConstruct
	public void init() {
		log.info("init: " + this.getClass());
		this.mainDao = new InformeDaoImpl(this.getSessionFactory());

		this.estadoInformeDao = new EstadoInformeDaoImpl(this.getSessionFactory());
		this.edificioDao = new EdificioDaoImpl(this.getSessionFactory());
		this.inspeccionDao = new InspeccionDaoImpl(this.getSessionFactory());

	}

	/**
	 * Libera los recursos
	 */
	@PreDestroy
	public void destroy() {
		log.info("destroy: " + this.getClass());
		this.setSessionFactory(null);
		((InformeDaoImpl) this.mainDao).setSessionFactory(null);
		this.mainDao = null;

		((EstadoInformeDaoImpl) this.estadoInformeDao).setSessionFactory(null);
		this.estadoInformeDao = null;
		((EdificioDaoImpl) this.edificioDao).setSessionFactory(null);
		this.edificioDao = null;
		((InspeccionDaoImpl) this.inspeccionDao).setSessionFactory(null);
		this.inspeccionDao = null;

	}


	/*
	 * ************************** Permisos ************************************
	 */
	
	@Override
	@RolesAllowed(Constants.ADMIN + "," + Constants.OPERADOR + "," + Constants.MUNICIPI)
	public InformeFormVO add(InformeFormVO formData) throws GenericBusinessException {
		return super.add(formData);
	}

	@Override
	@RolesAllowed(Constants.ADMIN + "," + Constants.OPERADOR + "," + Constants.MUNICIPI)
	public InformeFormVO update(Serializable id, InformeFormVO formData) throws GenericBusinessException {
		return super.update(id, formData);
	}

	@Override
	@RolesAllowed(Constants.ADMIN + "," + Constants.OPERADOR + "," + Constants.MUNICIPI)
	public boolean delete(Serializable id) throws GenericBusinessException {
		return super.delete(id);
	}



}
