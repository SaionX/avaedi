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
 * Tests para el Bean: Caracteristica
 * @author agarcia@at4.net
 *
 */
public class CaracteristicaBeanTest extends BaseBeanTests<CaracteristicaFormVO, CaracteristicaBO> {

	/**
	 * Bean para acceder a los métodos de negocio: Caracteristica
	 */
	@Autowired @Qualifier("CaracteristicaBean")
	protected CaracteristicaBO mainBean;

	/** Bean para acceder a los métodos de negocio: Caracteristica
	 */
	protected CaracteristicaBO getMainBean() {
		return this.mainBean;
	}


	/**
	*Bean para acceder a los metodos de negocio: GrupoCaracteristicas
	*/
 @Autowired @Qualifier("GrupoCaracteristicasBean")
	private GrupoCaracteristicasBO grupoCaracteristicasBO;
	
	/** Bean para acceder a los metodos de negocio: GrupoCaracteristicas
	* @param bean the bean to set
	*/
	public void setGrupoCaracteristicasBO(GrupoCaracteristicasBO bean) {
		this.grupoCaracteristicasBO = bean;
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
	


/*
	Finders para relaciones
*/
	  
	@Test
	public void  findByGrupoCaracteristicasTest() throws GenericBusinessException {
		int grupoCaracteristicasId = TestUtil.newInteger();
		//¿assert?
		this.getMainBean().findByGrupoCaracteristicas(grupoCaracteristicasId);
	}





	/**
	 * Rellena una instancia de Caracteristica aleatoriamente
	 */
	protected CaracteristicaFormVO fillRandomRecord(CaracteristicaFormVO record, boolean forUpdate) throws GenericBusinessException  {

     if (!forUpdate) {
  
		record.setCaracteristica( TestUtil.newString(255) );
     }
  
		record.setGrupoCaracteristicasId( this.grupoCaracteristicasBO.getListado(null, new PagingConfig(1)).getResultados().iterator().next().getId() );

  
		record.setNombreEs( TestUtil.newString(255) );
  
		record.setNombreCa( TestUtil.newString(255) );

	return record;
	}

}


