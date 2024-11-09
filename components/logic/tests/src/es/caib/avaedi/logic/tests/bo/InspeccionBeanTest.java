package es.caib.avaedi.logic.tests.bo;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import es.caib.avaedi.logic.bo.*;
import es.caib.avaedi.logic.vo.*;
import es.caib.avaedi.at4forms.common.exception.GenericBusinessException;
import es.caib.avaedi.at4forms.common.search.PagingConfig;
import es.caib.avaedi.at4forms.tests.BaseBeanTests;
import es.caib.avaedi.at4forms.tests.TestUtil;
import es.caib.avaedi.common.model.*;

import java.util.*;

import org.junit.Test;


/**
 * Tests para el Bean: Inspeccion
 * @author agarcia@at4.net
 *
 */
public class InspeccionBeanTest extends InspeccionBaseBeanTests<InspeccionFormVO, InspeccionBO> {

	/**
	 * Bean para acceder a los métodos de negocio: Inspeccion
	 */
	@Autowired @Qualifier("InspeccionBean")
	protected InspeccionBO mainBean;

	/** Bean para acceder a los métodos de negocio: Inspeccion
	 */
	protected InspeccionBO getMainBean() {
		return this.mainBean;
	}


	/**
	*Bean para acceder a los metodos de negocio: Informe
	*/
 @Autowired @Qualifier("InformeBean")
	private InformeBO informeBO;
	
	/** Bean para acceder a los metodos de negocio: Informe
	* @param bean the bean to set
	*/
	public void setInformeBO(InformeBO bean) {
		this.informeBO = bean;
	}
	
	
	/**
	*Bean para acceder a los metodos de negocio: AccesibilidadPublicos
	*/
 @Autowired @Qualifier("AccesibilidadPublicosBean")
	private AccesibilidadPublicosBO accesibilidadPublicosBO;
	
	/** Bean para acceder a los metodos de negocio: AccesibilidadPublicos
	* @param bean the bean to set
	*/
	public void setAccesibilidadPublicosBO(AccesibilidadPublicosBO bean) {
		this.accesibilidadPublicosBO = bean;
	}
	

	/**
	*Bean para acceder a los metodos de negocio: AcusticaRuidosInterioresUniones
	*/
 @Autowired @Qualifier("AcusticaRuidosInterioresUnionesBean")
	private AcusticaRuidosInterioresUnionesBO acusticaRuidosInterioresUnionesBO;
	
	/** Bean para acceder a los metodos de negocio: AcusticaRuidosInterioresUniones
	* @param bean the bean to set
	*/
	public void setAcusticaRuidosInterioresUnionesBO(AcusticaRuidosInterioresUnionesBO bean) {
		this.acusticaRuidosInterioresUnionesBO = bean;
	}
	

	/**
	*Bean para acceder a los metodos de negocio: FechaVisita
	*/
 @Autowired @Qualifier("FechaVisitaBean")
	private FechaVisitaBO fechaVisitaBO;
	
	/** Bean para acceder a los metodos de negocio: FechaVisita
	* @param bean the bean to set
	*/
	public void setFechaVisitaBO(FechaVisitaBO bean) {
		this.fechaVisitaBO = bean;
	}
	

	/**
	*Bean para acceder a los metodos de negocio: AcusticaValoracionFinal
	*/
 @Autowired @Qualifier("AcusticaValoracionFinalBean")
	private AcusticaValoracionFinalBO acusticaValoracionFinalBO;
	
	/** Bean para acceder a los metodos de negocio: AcusticaValoracionFinal
	* @param bean the bean to set
	*/
	public void setAcusticaValoracionFinalBO(AcusticaValoracionFinalBO bean) {
		this.acusticaValoracionFinalBO = bean;
	}
	

	/**
	*Bean para acceder a los metodos de negocio: AcusticaRuidosInterioresVerticales
	*/
 @Autowired @Qualifier("AcusticaRuidosInterioresVerticalesBean")
	private AcusticaRuidosInterioresVerticalesBO acusticaRuidosInterioresVerticalesBO;
	
	/** Bean para acceder a los metodos de negocio: AcusticaRuidosInterioresVerticales
	* @param bean the bean to set
	*/
	public void setAcusticaRuidosInterioresVerticalesBO(AcusticaRuidosInterioresVerticalesBO bean) {
		this.acusticaRuidosInterioresVerticalesBO = bean;
	}
	

	/**
	*Bean para acceder a los metodos de negocio: AcusticaComprobaciones
	*/
 @Autowired @Qualifier("AcusticaComprobacionesBean")
	private AcusticaComprobacionesBO acusticaComprobacionesBO;
	
	/** Bean para acceder a los metodos de negocio: AcusticaComprobaciones
	* @param bean the bean to set
	*/
	public void setAcusticaComprobacionesBO(AcusticaComprobacionesBO bean) {
		this.acusticaComprobacionesBO = bean;
	}
	

	/**
	*Bean para acceder a los metodos de negocio: Instalaciones
	*/
 @Autowired @Qualifier("InstalacionesBean")
	private InstalacionesBO instalacionesBO;
	
	/** Bean para acceder a los metodos de negocio: Instalaciones
	* @param bean the bean to set
	*/
	public void setInstalacionesBO(InstalacionesBO bean) {
		this.instalacionesBO = bean;
	}
	

	/**
	*Bean para acceder a los metodos de negocio: CerramientosCubiertas
	*/
 @Autowired @Qualifier("CerramientosCubiertasBean")
	private CerramientosCubiertasBO cerramientosCubiertasBO;
	
	/** Bean para acceder a los metodos de negocio: CerramientosCubiertas
	* @param bean the bean to set
	*/
	public void setCerramientosCubiertasBO(CerramientosCubiertasBO bean) {
		this.cerramientosCubiertasBO = bean;
	}
	

	/**
	*Bean para acceder a los metodos de negocio: ValoracionParcial
	*/
 @Autowired @Qualifier("ValoracionParcialBean")
	private ValoracionParcialBO valoracionParcialBO;
	
	/** Bean para acceder a los metodos de negocio: ValoracionParcial
	* @param bean the bean to set
	*/
	public void setValoracionParcialBO(ValoracionParcialBO bean) {
		this.valoracionParcialBO = bean;
	}
	

	/**
	*Bean para acceder a los metodos de negocio: AccesibilidadValoracionFinales
	*/
 @Autowired @Qualifier("AccesibilidadValoracionFinalesBean")
	private AccesibilidadValoracionFinalesBO accesibilidadValoracionFinalesBO;
	
	/** Bean para acceder a los metodos de negocio: AccesibilidadValoracionFinales
	* @param bean the bean to set
	*/
	public void setAccesibilidadValoracionFinalesBO(AccesibilidadValoracionFinalesBO bean) {
		this.accesibilidadValoracionFinalesBO = bean;
	}
	

	/**
	*Bean para acceder a los metodos de negocio: AcusticaRuidoInstalaciones
	*/
 @Autowired @Qualifier("AcusticaRuidoInstalacionesBean")
	private AcusticaRuidoInstalacionesBO acusticaRuidoInstalacionesBO;
	
	/** Bean para acceder a los metodos de negocio: AcusticaRuidoInstalaciones
	* @param bean the bean to set
	*/
	public void setAcusticaRuidoInstalacionesBO(AcusticaRuidoInstalacionesBO bean) {
		this.acusticaRuidoInstalacionesBO = bean;
	}
	

	/**
	*Bean para acceder a los metodos de negocio: Estructura
	*/
 @Autowired @Qualifier("EstructuraBean")
	private EstructuraBO estructuraBO;
	
	/** Bean para acceder a los metodos de negocio: Estructura
	* @param bean the bean to set
	*/
	public void setEstructuraBO(EstructuraBO bean) {
		this.estructuraBO = bean;
	}
	

	/**
	*Bean para acceder a los metodos de negocio: Cimentaciones
	*/
 @Autowired @Qualifier("CimentacionesBean")
	private CimentacionesBO cimentacionesBO;
	
	/** Bean para acceder a los metodos de negocio: Cimentaciones
	* @param bean the bean to set
	*/
	public void setCimentacionesBO(CimentacionesBO bean) {
		this.cimentacionesBO = bean;
	}
	

	/**
	*Bean para acceder a los metodos de negocio: AccesibilidadAjustesRazonables
	*/
 @Autowired @Qualifier("AccesibilidadAjustesRazonablesBean")
	private AccesibilidadAjustesRazonablesBO accesibilidadAjustesRazonablesBO;
	
	/** Bean para acceder a los metodos de negocio: AccesibilidadAjustesRazonables
	* @param bean the bean to set
	*/
	public void setAccesibilidadAjustesRazonablesBO(AccesibilidadAjustesRazonablesBO bean) {
		this.accesibilidadAjustesRazonablesBO = bean;
	}
	

	/**
	*Bean para acceder a los metodos de negocio: EficienciasEnergeticas
	*/
 @Autowired @Qualifier("EficienciasEnergeticasBean")
	private EficienciasEnergeticasBO eficienciasEnergeticasBO;
	
	/** Bean para acceder a los metodos de negocio: EficienciasEnergeticas
	* @param bean the bean to set
	*/
	public void setEficienciasEnergeticasBO(EficienciasEnergeticasBO bean) {
		this.eficienciasEnergeticasBO = bean;
	}
	

	/**
	*Bean para acceder a los metodos de negocio: DocumentacionOtro
	*/
 @Autowired @Qualifier("DocumentacionOtroBean")
	private DocumentacionOtroBO documentacionOtroBO;
	
	/** Bean para acceder a los metodos de negocio: DocumentacionOtro
	* @param bean the bean to set
	*/
	public void setDocumentacionOtroBO(DocumentacionOtroBO bean) {
		this.documentacionOtroBO = bean;
	}
	

	/**
	*Bean para acceder a los metodos de negocio: AcusticaRuidosExteriores
	*/
 @Autowired @Qualifier("AcusticaRuidosExterioresBean")
	private AcusticaRuidosExterioresBO acusticaRuidosExterioresBO;
	
	/** Bean para acceder a los metodos de negocio: AcusticaRuidosExteriores
	* @param bean the bean to set
	*/
	public void setAcusticaRuidosExterioresBO(AcusticaRuidosExterioresBO bean) {
		this.acusticaRuidosExterioresBO = bean;
	}
	

	/**
	*Bean para acceder a los metodos de negocio: AcusticaMejorasAcusticas
	*/
 @Autowired @Qualifier("AcusticaMejorasAcusticasBean") 
	private AcusticaMejorasAcusticasBO acusticaMejorasAcusticasBO;
	
	/** Bean para acceder a los metodos de negocio: AcusticaMejorasAcusticas
	* @param bean the bean to set
	*/
	public void setAcusticaMejorasAcusticasBO(AcusticaMejorasAcusticasBO bean) {
		this.acusticaMejorasAcusticasBO = bean;
	}
	

	/**
	*Bean para acceder a los metodos de negocio: AcusticaRuidosInterioresHorizontales
	*/
 @Autowired @Qualifier("AcusticaRuidosInterioresHorizontalesBean")
	private AcusticaRuidosInterioresHorizontalesBO acusticaRuidosInterioresHorizontalesBO;
	
	/** Bean para acceder a los metodos de negocio: AcusticaRuidosInterioresHorizontales
	* @param bean the bean to set
	*/
	public void setAcusticaRuidosInterioresHorizontalesBO(AcusticaRuidosInterioresHorizontalesBO bean) {
		this.acusticaRuidosInterioresHorizontalesBO = bean;
	}
	

	/**
	*Bean para acceder a los metodos de negocio: AcusticaDatosGenerales
	*/
 @Autowired @Qualifier("AcusticaDatosGeneralesBean")
	private AcusticaDatosGeneralesBO acusticaDatosGeneralesBO;
	
	/** Bean para acceder a los metodos de negocio: AcusticaDatosGenerales
	* @param bean the bean to set
	*/
	public void setAcusticaDatosGeneralesBO(AcusticaDatosGeneralesBO bean) {
		this.acusticaDatosGeneralesBO = bean;
	}
	

	/**
	*Bean para acceder a los metodos de negocio: Acusticas
	*/
 @Autowired @Qualifier("AcusticasBean")
	private AcusticasBO acusticasBO;
	
	/** Bean para acceder a los metodos de negocio: Acusticas
	* @param bean the bean to set
	*/
	public void setAcusticasBO(AcusticasBO bean) {
		this.acusticasBO = bean;
	}
	

	/**
	*Bean para acceder a los metodos de negocio: Deficiencia
	*/
 @Autowired @Qualifier("DeficienciaBean")
	private DeficienciaBO deficienciaBO;
	
	/** Bean para acceder a los metodos de negocio: Deficiencia
	* @param bean the bean to set
	*/
	public void setDeficienciaBO(DeficienciaBO bean) {
		this.deficienciaBO = bean;
	}
	

	/**
	*Bean para acceder a los metodos de negocio: Valor
	*/
 @Autowired @Qualifier("ValorBean")
	private ValorBO valorBO;
	
	/** Bean para acceder a los metodos de negocio: Valor
	* @param bean the bean to set
	*/
	public void setValorBO(ValorBO bean) {
		this.valorBO = bean;
	}
	

	/**
	*Bean para acceder a los metodos de negocio: Conservacion
	*/
 @Autowired @Qualifier("ConservacionBean")
	private ConservacionBO conservacionBO;
	
	/** Bean para acceder a los metodos de negocio: Conservacion
	* @param bean the bean to set
	*/
	public void setConservacionBO(ConservacionBO bean) {
		this.conservacionBO = bean;
	}
	

	/**
	*Bean para acceder a los metodos de negocio: Historico
	*/
 @Autowired @Qualifier("HistoricoBean")
	private HistoricoBO historicoBO;
	
	/** Bean para acceder a los metodos de negocio: Historico
	* @param bean the bean to set
	*/
	public void setHistoricoBO(HistoricoBO bean) {
		this.historicoBO = bean;
	}
	


/*
	Finders para relaciones
*/
	  
	@Test
	public void  findByInformeTest() throws GenericBusinessException {
		int informeId = TestUtil.newInteger();
		//¿assert?
		this.getMainBean().findByInforme(informeId);
	}


	  
	@Test
	public void  findByAccesibilidadPublicosTest() throws GenericBusinessException {
		int accesibilidadPublicosId = TestUtil.newInteger();
		//¿assert?
		this.getMainBean().findByAccesibilidadPublicos(accesibilidadPublicosId);
	}


	  
	@Test
	public void  findByAcusticaRuidosInterioresUnionesTest() throws GenericBusinessException {
		int acusticaRuidosInterioresUnionesId = TestUtil.newInteger();
		//¿assert?
		this.getMainBean().findByAcusticaRuidosInterioresUniones(acusticaRuidosInterioresUnionesId);
	}


	  
	@Test
	public void  findByAcusticaValoracionFinalTest() throws GenericBusinessException {
		int acusticaValoracionFinalId = TestUtil.newInteger();
		//¿assert?
		this.getMainBean().findByAcusticaValoracionFinal(acusticaValoracionFinalId);
	}


	  
	@Test
	public void  findByAcusticaRuidosInterioresVerticalesTest() throws GenericBusinessException {
		int acusticaRuidosInterioresVerticalesId = TestUtil.newInteger();
		//¿assert?
		this.getMainBean().findByAcusticaRuidosInterioresVerticales(acusticaRuidosInterioresVerticalesId);
	}


	  
	@Test
	public void  findByAcusticaComprobacionesTest() throws GenericBusinessException {
		int acusticaComprobacionesId = TestUtil.newInteger();
		//¿assert?
		this.getMainBean().findByAcusticaComprobaciones(acusticaComprobacionesId);
	}


	  
	@Test
	public void  findByInstalacionesTest() throws GenericBusinessException {
		int instalacionesId = TestUtil.newInteger();
		//¿assert?
		this.getMainBean().findByInstalaciones(instalacionesId);
	}


	  
	@Test
	public void  findByCerramientosCubiertasTest() throws GenericBusinessException {
		int cerramientosCubiertasId = TestUtil.newInteger();
		//¿assert?
		this.getMainBean().findByCerramientosCubiertas(cerramientosCubiertasId);
	}


	  
	@Test
	public void  findByAccesibilidadValoracionFinalesTest() throws GenericBusinessException {
		int accesibilidadValoracionFinalesId = TestUtil.newInteger();
		//¿assert?
		this.getMainBean().findByAccesibilidadValoracionFinales(accesibilidadValoracionFinalesId);
	}


	  
	@Test
	public void  findByAcusticaRuidoInstalacionesTest() throws GenericBusinessException {
		int acusticaRuidoInstalacionesId = TestUtil.newInteger();
		//¿assert?
		this.getMainBean().findByAcusticaRuidoInstalaciones(acusticaRuidoInstalacionesId);
	}


	  
	@Test
	public void  findByEstructuraTest() throws GenericBusinessException {
		int estructuraId = TestUtil.newInteger();
		//¿assert?
		this.getMainBean().findByEstructura(estructuraId);
	}


	  
	@Test
	public void  findByCimentacionesTest() throws GenericBusinessException {
		int cimentacionesId = TestUtil.newInteger();
		//¿assert?
		this.getMainBean().findByCimentaciones(cimentacionesId);
	}


	  
	@Test
	public void  findByAccesibilidadAjustesRazonablesTest() throws GenericBusinessException {
		int accesibilidadAjustesRazonablesId = TestUtil.newInteger();
		//¿assert?
		this.getMainBean().findByAccesibilidadAjustesRazonables(accesibilidadAjustesRazonablesId);
	}


	  
	@Test
	public void  findByEficienciasEnergeticasTest() throws GenericBusinessException {
		int eficienciasEnergeticasId = TestUtil.newInteger();
		//¿assert?
		this.getMainBean().findByEficienciasEnergeticas(eficienciasEnergeticasId);
	}


	  
	@Test
	public void  findByAcusticaRuidosExterioresTest() throws GenericBusinessException {
		int acusticaRuidosExterioresId = TestUtil.newInteger();
		//¿assert?
		this.getMainBean().findByAcusticaRuidosExteriores(acusticaRuidosExterioresId);
	}


	  
	@Test
	public void  findByAcusticaRuidosInterioresHorizontalesTest() throws GenericBusinessException {
		int acusticaRuidosInterioresHorizontalesId = TestUtil.newInteger();
		//¿assert?
		this.getMainBean().findByAcusticaRuidosInterioresHorizontales(acusticaRuidosInterioresHorizontalesId);
	}


	  
	@Test
	public void  findByAcusticaDatosGeneralesTest() throws GenericBusinessException {
		int acusticaDatosGeneralesId = TestUtil.newInteger();
		//¿assert?
		this.getMainBean().findByAcusticaDatosGenerales(acusticaDatosGeneralesId);
	}


	  
	@Test
	public void  findByAcusticasTest() throws GenericBusinessException {
		int acusticasId = TestUtil.newInteger();
		//¿assert?
		this.getMainBean().findByAcusticas(acusticasId);
	}


	  
	@Test
	public void  findByConservacionTest() throws GenericBusinessException {
		int conservacionId = TestUtil.newInteger();
		//¿assert?
		this.getMainBean().findByConservacion(conservacionId);
	}



}


