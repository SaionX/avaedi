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
import es.caib.avaedi.common.persistence.AccesibilidadAjustesRazonablesDaoImpl;
import es.caib.avaedi.common.persistence.AccesibilidadPublicosDaoImpl;
import es.caib.avaedi.common.persistence.AccesibilidadValoracionFinalesDaoImpl;
import es.caib.avaedi.common.persistence.AcusticaComprobacionesDaoImpl;
import es.caib.avaedi.common.persistence.AcusticaDatosGeneralesDaoImpl;
import es.caib.avaedi.common.persistence.AcusticaMejorasAcusticasDaoImpl;
import es.caib.avaedi.common.persistence.AcusticaRuidoInstalacionesDaoImpl;
import es.caib.avaedi.common.persistence.AcusticaRuidosExterioresDaoImpl;
import es.caib.avaedi.common.persistence.AcusticaRuidosInterioresHorizontalesDaoImpl;
import es.caib.avaedi.common.persistence.AcusticaRuidosInterioresUnionesDaoImpl;
import es.caib.avaedi.common.persistence.AcusticaRuidosInterioresVerticalesDaoImpl;
import es.caib.avaedi.common.persistence.AcusticaValoracionFinalDaoImpl;
import es.caib.avaedi.common.persistence.AcusticasDaoImpl;
import es.caib.avaedi.common.persistence.CerramientosCubiertasDaoImpl;
import es.caib.avaedi.common.persistence.CimentacionesDaoImpl;
import es.caib.avaedi.common.persistence.ConservacionDaoImpl;
import es.caib.avaedi.common.persistence.EficienciasEnergeticasDaoImpl;
import es.caib.avaedi.common.persistence.EstructuraDaoImpl;
import es.caib.avaedi.common.persistence.InformeDaoImpl;
import es.caib.avaedi.common.persistence.InspeccionDaoImpl;
import es.caib.avaedi.common.persistence.InstalacionesDaoImpl;
import es.caib.avaedi.common.persistence.ValorDaoImpl;
import es.caib.avaedi.common.realm.Constants;
import es.caib.avaedi.logic.bo.InspeccionBO;
import es.caib.avaedi.logic.bo.InspeccionBean;
import es.caib.avaedi.logic.vo.InspeccionFormVO;

/**
 * Ejb para tratar el formulario: Inspeccion
 * 
 * @author agarcia@at4.net
 * 
 */
@Stateless(mappedName = "es.caib.avaedi.logic.ejb.InspeccionBeanEjb")
@RolesAllowed("AED_ADMIN,AED_OPERADOR,AED_CONSULTA,AED_MUNICIPI")
@TransactionManagement(TransactionManagementType.CONTAINER)
public class InspeccionBeanEjb extends InspeccionBean implements InspeccionBO {

	/**
	 * The logger object.
	 */
	private static Logger log = LogService.getLogger(InspeccionBeanEjb.class);

	/**
	 * Configura el SessionFactory y los dao
	 */
	@PostConstruct
	public void init() {
		log.info("init: " + this.getClass());
		this.mainDao = new InspeccionDaoImpl(this.getSessionFactory());

		this.informeDao = new InformeDaoImpl(this.getSessionFactory());
		this.accesibilidadPublicosDao = new AccesibilidadPublicosDaoImpl(this.getSessionFactory());
		this.acusticaRuidosInterioresUnionesDao = new AcusticaRuidosInterioresUnionesDaoImpl(this.getSessionFactory());
		this.acusticaValoracionFinalDao = new AcusticaValoracionFinalDaoImpl(this.getSessionFactory());
		this.acusticaRuidosInterioresVerticalesDao = new AcusticaRuidosInterioresVerticalesDaoImpl(this.getSessionFactory());
		this.acusticaComprobacionesDao = new AcusticaComprobacionesDaoImpl(this.getSessionFactory());
		this.instalacionesDao = new InstalacionesDaoImpl(this.getSessionFactory());
		this.cerramientosCubiertasDao = new CerramientosCubiertasDaoImpl(this.getSessionFactory());
		this.accesibilidadValoracionFinalesDao = new AccesibilidadValoracionFinalesDaoImpl(this.getSessionFactory());
		this.acusticaRuidoInstalacionesDao = new AcusticaRuidoInstalacionesDaoImpl(this.getSessionFactory());
		this.estructuraDao = new EstructuraDaoImpl(this.getSessionFactory());
		this.cimentacionesDao = new CimentacionesDaoImpl(this.getSessionFactory());
		this.accesibilidadAjustesRazonablesDao = new AccesibilidadAjustesRazonablesDaoImpl(this.getSessionFactory());
		this.eficienciasEnergeticasDao = new EficienciasEnergeticasDaoImpl(this.getSessionFactory());
		this.acusticaRuidosExterioresDao = new AcusticaRuidosExterioresDaoImpl(this.getSessionFactory());
		this.acusticaMejorasAcusticasDao = new AcusticaMejorasAcusticasDaoImpl(this.getSessionFactory());
		this.acusticaRuidosInterioresHorizontalesDao = new AcusticaRuidosInterioresHorizontalesDaoImpl(this.getSessionFactory());
		this.acusticaDatosGeneralesDao = new AcusticaDatosGeneralesDaoImpl(this.getSessionFactory());
		this.acusticasDao = new AcusticasDaoImpl(this.getSessionFactory());
		this.valorDao = new ValorDaoImpl(this.getSessionFactory());
		this.conservacionDao = new ConservacionDaoImpl(this.getSessionFactory());

	}

	/**
	 * Libera los recursos
	 */
	@PreDestroy
	public void destroy() {
		log.info("destroy: " + this.getClass());
		this.setSessionFactory(null);
		((InspeccionDaoImpl) this.mainDao).setSessionFactory(null);
		this.mainDao = null;

		((InformeDaoImpl) this.informeDao).setSessionFactory(null);
		this.informeDao = null;
		((AccesibilidadPublicosDaoImpl) this.accesibilidadPublicosDao).setSessionFactory(null);
		this.accesibilidadPublicosDao = null;
		((AcusticaRuidosInterioresUnionesDaoImpl) this.acusticaRuidosInterioresUnionesDao).setSessionFactory(null);
		this.acusticaRuidosInterioresUnionesDao = null;
		((AcusticaValoracionFinalDaoImpl) this.acusticaValoracionFinalDao).setSessionFactory(null);
		this.acusticaValoracionFinalDao = null;
		((AcusticaRuidosInterioresVerticalesDaoImpl) this.acusticaRuidosInterioresVerticalesDao).setSessionFactory(null);
		this.acusticaRuidosInterioresVerticalesDao = null;
		((AcusticaComprobacionesDaoImpl) this.acusticaComprobacionesDao).setSessionFactory(null);
		this.acusticaComprobacionesDao = null;
		((InstalacionesDaoImpl) this.instalacionesDao).setSessionFactory(null);
		this.instalacionesDao = null;
		((CerramientosCubiertasDaoImpl) this.cerramientosCubiertasDao).setSessionFactory(null);
		this.cerramientosCubiertasDao = null;
		((AccesibilidadValoracionFinalesDaoImpl) this.accesibilidadValoracionFinalesDao).setSessionFactory(null);
		this.accesibilidadValoracionFinalesDao = null;
		((AcusticaRuidoInstalacionesDaoImpl) this.acusticaRuidoInstalacionesDao).setSessionFactory(null);
		this.acusticaRuidoInstalacionesDao = null;
		((EstructuraDaoImpl) this.estructuraDao).setSessionFactory(null);
		this.estructuraDao = null;
		((CimentacionesDaoImpl) this.cimentacionesDao).setSessionFactory(null);
		this.cimentacionesDao = null;
		((AccesibilidadAjustesRazonablesDaoImpl) this.accesibilidadAjustesRazonablesDao).setSessionFactory(null);
		this.accesibilidadAjustesRazonablesDao = null;
		((EficienciasEnergeticasDaoImpl) this.eficienciasEnergeticasDao).setSessionFactory(null);
		this.eficienciasEnergeticasDao = null;
		((AcusticaRuidosExterioresDaoImpl) this.acusticaRuidosExterioresDao).setSessionFactory(null);
		this.acusticaRuidosExterioresDao = null;
		((AcusticaMejorasAcusticasDaoImpl) this.acusticaMejorasAcusticasDao).setSessionFactory(null);
		this.acusticaMejorasAcusticasDao = null;
		((AcusticaRuidosInterioresHorizontalesDaoImpl) this.acusticaRuidosInterioresHorizontalesDao).setSessionFactory(null);
		this.acusticaRuidosInterioresHorizontalesDao = null;
		((AcusticaDatosGeneralesDaoImpl) this.acusticaDatosGeneralesDao).setSessionFactory(null);
		this.acusticaDatosGeneralesDao = null;
		((AcusticasDaoImpl) this.acusticasDao).setSessionFactory(null);
		this.acusticasDao = null;
		((ValorDaoImpl) this.valorDao).setSessionFactory(null);
		this.valorDao = null;
		((ConservacionDaoImpl) this.conservacionDao).setSessionFactory(null);
		this.conservacionDao = null;

	}
	
	
	/*
	 * ************************** Permisos ************************************
	 */
	
	@Override
	@RolesAllowed(Constants.ADMIN + "," + Constants.OPERADOR + "," + Constants.MUNICIPI)
	public InspeccionFormVO add(InspeccionFormVO formData) throws GenericBusinessException {
		return super.add(formData);
	}

	@Override
	@RolesAllowed(Constants.ADMIN + "," + Constants.OPERADOR + "," + Constants.MUNICIPI)
	public InspeccionFormVO update(Serializable id, InspeccionFormVO formData) throws GenericBusinessException {
		return super.update(id, formData);
	}

	@Override
	@RolesAllowed(Constants.ADMIN + "," + Constants.OPERADOR + "," + Constants.MUNICIPI)
	public boolean delete(Serializable id) throws GenericBusinessException {
		return super.delete(id);
	}

	

}
