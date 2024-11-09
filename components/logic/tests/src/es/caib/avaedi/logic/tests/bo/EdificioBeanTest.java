package es.caib.avaedi.logic.tests.bo;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

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
 * Tests para el Bean: Edificio
 * @author agarcia@at4.net
 *
 */
public class EdificioBeanTest extends BaseBeanTests<EdificioFormVO, EdificioBO> {

	/**
	 * Bean para acceder a los métodos de negocio: Edificio
	 */
	@Autowired @Qualifier("EdificioBean")
	protected EdificioBO mainBean;

	/** Bean para acceder a los métodos de negocio: Edificio
	 */
	protected EdificioBO getMainBean() {
		return this.mainBean;
	}


	/**
	*Bean para acceder a los metodos de negocio: Via
	*/
 @Autowired @Qualifier("ViaBean")
	private ViaBO viaBO;
	
	/** Bean para acceder a los metodos de negocio: Via
	* @param bean the bean to set
	*/
	public void setViaBO(ViaBO bean) {
		this.viaBO = bean;
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
	


/*
	Finders para relaciones
*/
	  
	@Test
	public void  findByViaTest() throws GenericBusinessException {
		int viaId = TestUtil.newInteger();
		//¿assert?
		this.getMainBean().findByVia(viaId);
	}





	/**
	 * Rellena una instancia de Edificio aleatoriamente
	 */
	protected EdificioFormVO fillRandomRecord(EdificioFormVO record, boolean forUpdate) throws GenericBusinessException  {

  
		record.setViaId( this.viaBO.getListado(null, new PagingConfig(1)).getResultados().iterator().next().getClave() );

  
		record.setNumeroCatastro( TestUtil.newString(64) );
  
		record.setNumeroExtra( TestUtil.newString(64) );
  
		record.setReferenciaCatastral( TestUtil.newString(14) );
  
		record.setAntiguedad( TestUtil.newInteger() );
  
		record.setCentroX( null /* TODO; tipo no soportado java.math.BigDecimal */ );
  
		record.setCentroY( null /* TODO; tipo no soportado java.math.BigDecimal */ );

	return record;
	}

}


