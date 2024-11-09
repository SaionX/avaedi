package es.caib.avaedi.logic.tests.bo;




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
 * Tests para el Bean: Informe
 * @author agarcia@at4.net
 *
 */
public class InformeBeanTest extends InspeccionBaseBeanTests<InformeFormVO, InformeBO> {

	/**
	 * Bean para acceder a los métodos de negocio: Informe
	 */
	@Autowired @Qualifier("InformeBean")
	protected InformeBO mainBean;

	/** Bean para acceder a los métodos de negocio: Informe
	 */
	protected InformeBO getMainBean() {
		return this.mainBean;
	}


	/**
	*Bean para acceder a los metodos de negocio: EstadoInforme
	*/
 @Autowired @Qualifier("EstadoInformeBean")
	private EstadoInformeBO estadoInformeBO;
	
	/** Bean para acceder a los metodos de negocio: EstadoInforme
	* @param bean the bean to set
	*/
	public void setEstadoInformeBO(EstadoInformeBO bean) {
		this.estadoInformeBO = bean;
	}
	

	/**
	*Bean para acceder a los metodos de negocio: Edificio
	*/
 @Autowired @Qualifier("EdificioBean")
	private EdificioBO edificioBO;
	
	/** Bean para acceder a los metodos de negocio: Edificio
	* @param bean the bean to set
	*/
	public void setEdificioBO(EdificioBO bean) {
		this.edificioBO = bean;
	}
	

	/**
	*Bean para acceder a los metodos de negocio: Inspeccion
	*/
 @Autowired @Qualifier("InspeccionBean")
	private InspeccionBO inspeccionBO;
	
	/** Bean para acceder a los metodos de negocio: Inspeccion
	* @param bean the bean to set
	*/
	public void setInspeccionBO(InspeccionBO bean) {
		this.inspeccionBO = bean;
	}
	


/*
	Finders para relaciones
*/
	  
	@Test
	public void  findByEstadoInformeTest() throws GenericBusinessException {
		int estadoInformeId = TestUtil.newInteger();
		//¿assert?
		this.getMainBean().findByEstadoInforme(estadoInformeId);
	}


	  
	@Test
	public void  findByEdificioTest() throws GenericBusinessException {
		int edificioId = TestUtil.newInteger();
		//¿assert?
		this.getMainBean().findByEdificio(edificioId);
	}


	  
	@Test
	public void  findByInspeccionTest() throws GenericBusinessException {
		int inspeccionId = TestUtil.newInteger();
		//¿assert?
		//this.getMainBean().findByInspeccion(inspeccionId);
	}





	/**
	 * Rellena una instancia de Informe aleatoriamente
	 */
	protected InformeFormVO fillRandomRecord(InformeFormVO record, boolean forUpdate) throws GenericBusinessException  {

  
		record.setEstadoInformeId( this.estadoInformeBO.getListado(null, new PagingConfig(1)).getResultados().iterator().next().getClave() );

  
		EdificioFormVO edificio = fillNewRecord(new EdificioFormVO());
		edificio = this.edificioBO.add(edificio);
		record.setEdificioId( edificio.getClave() );

  
		record.setFechaInforme( TestUtil.newDate() );
  
		record.setFechaAlta( TestUtil.newDate() );
  
		//record.setInspeccionId( this.inspeccionBO.getListado(null, new PagingConfig(1)).getResultados().iterator().next().getId() );


	return record;
	}

	
	
}


