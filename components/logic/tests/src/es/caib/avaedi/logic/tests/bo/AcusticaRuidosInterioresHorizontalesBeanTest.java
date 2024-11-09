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
 * Tests para el Bean: AcusticaRuidosInterioresHorizontales
 * @author agarcia@at4.net
 *
 */
public class AcusticaRuidosInterioresHorizontalesBeanTest extends InspeccionBaseBeanTests<AcusticaRuidosInterioresHorizontalesFormVO, AcusticaRuidosInterioresHorizontalesBO> {

	/**
	 * Bean para acceder a los métodos de negocio: AcusticaRuidosInterioresHorizontales
	 */
	@Autowired @Qualifier("AcusticaRuidosInterioresHorizontalesBean")
	protected AcusticaRuidosInterioresHorizontalesBO mainBean;

	/** Bean para acceder a los métodos de negocio: AcusticaRuidosInterioresHorizontales
	 */
	protected AcusticaRuidosInterioresHorizontalesBO getMainBean() {
		return this.mainBean;
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
	public void  findByInspeccionTest() throws GenericBusinessException {
		int inspeccionId = TestUtil.newInteger();
		//¿assert?
		this.getMainBean().findByInspeccion(inspeccionId);
	}





	/**
	 * Rellena una instancia de AcusticaRuidosInterioresHorizontales aleatoriamente
	 */
	protected AcusticaRuidosInterioresHorizontalesFormVO fillRandomRecord(AcusticaRuidosInterioresHorizontalesFormVO record, boolean forUpdate) throws GenericBusinessException  {

  
		if (!forUpdate) {
			//Damos de alta una inspeccion
			InspeccionFormVO inspeccion = fillNewRecord(new InspeccionFormVO());
			inspeccion = this.inspeccionBO.add(inspeccion);
			record.setInspeccionId(inspeccion.getInformeId());
		}

  
		record.setCaracteristicasCamaraAireContinua( TestUtil.newInteger() );
  
		record.setCaracteristicasLuminariasEmpotradasSelladas( TestUtil.newInteger() );
  
		record.setCaracteristicasSueloFlotanteContactoDirecto( TestUtil.newInteger() );
  
		record.setCaracteristicasSueloFlotanteRevestidas( TestUtil.newInteger() );
  
		record.setDeficienciasObservaciones( TestUtil.newString(255) );
  
		record.setEstadoBueno( TestUtil.newInteger() );
  
		record.setForjadoPlantagarajeOtro( TestUtil.newString(255) );
  
		record.setForjadoPlantatipoOtro( TestUtil.newString(255) );
  
		record.setObservaciones( TestUtil.newString(255) );
  
		record.setPlantagarajeCantoForjado( TestUtil.newString(255) );
  
		record.setPlantatipoCantoForjado( TestUtil.newString(255) );
  
		record.setSueloFlotanteTiene( TestUtil.newInteger() );
  
		record.setTechoSuspendidoTiene( TestUtil.newInteger() );

	return record;
	}

}


