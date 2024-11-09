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
 * Tests para el Bean: Valor
 * @author agarcia@at4.net
 *
 */
public class ValorBeanTest extends BaseBeanTests<ValorFormVO, ValorBO> {

	/**
	 * Bean para acceder a los métodos de negocio: Valor
	 */
	@Autowired @Qualifier("ValorBean")
	protected ValorBO mainBean;

	/** Bean para acceder a los métodos de negocio: Valor
	 */
	protected ValorBO getMainBean() {
		return this.mainBean;
	}


	/**
	*Bean para acceder a los metodos de negocio: Caracteristica
	*/
 @Autowired @Qualifier("CaracteristicaBean")
	private CaracteristicaBO caracteristicaBO;
	
	/** Bean para acceder a los metodos de negocio: Caracteristica
	* @param bean the bean to set
	*/
	public void setCaracteristicaBO(CaracteristicaBO bean) {
		this.caracteristicaBO = bean;
	}
	


/*
	Finders para relaciones
*/
	  
	@Test
	public void  findByCaracteristicaTest() throws GenericBusinessException {
		java.lang.String caracteristicaId = TestUtil.newString(255);
		//¿assert?
		this.getMainBean().findByCaracteristica(caracteristicaId);
	}





	/**
	 * Rellena una instancia de Valor aleatoriamente
	 */
	protected ValorFormVO fillRandomRecord(ValorFormVO record, boolean forUpdate) throws GenericBusinessException  {

     if (!forUpdate) {
  
		//Clave compuesta id 
		record.setId(new ValorId());
		record.getId().setId( TestUtil.newInteger() );
     }
  
		record.setCaracteristicaId( this.caracteristicaBO.getListado(null, new PagingConfig(1)).getResultados().iterator().next().getCaracteristica() );

  
		record.setNombreEs( TestUtil.newString(255) );
  
		record.setNombreCa( TestUtil.newString(255) );

	return record;
	}

}


