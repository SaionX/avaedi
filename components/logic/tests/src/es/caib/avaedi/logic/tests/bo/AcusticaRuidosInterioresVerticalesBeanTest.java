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
 * Tests para el Bean: AcusticaRuidosInterioresVerticales
 * @author agarcia@at4.net
 *
 */
public class AcusticaRuidosInterioresVerticalesBeanTest extends InspeccionBaseBeanTests<AcusticaRuidosInterioresVerticalesFormVO, AcusticaRuidosInterioresVerticalesBO> {

	/**
	 * Bean para acceder a los métodos de negocio: AcusticaRuidosInterioresVerticales
	 */
	@Autowired @Qualifier("AcusticaRuidosInterioresVerticalesBean")
	protected AcusticaRuidosInterioresVerticalesBO mainBean;

	/** Bean para acceder a los métodos de negocio: AcusticaRuidosInterioresVerticales
	 */
	protected AcusticaRuidosInterioresVerticalesBO getMainBean() {
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
	 * Rellena una instancia de AcusticaRuidosInterioresVerticales aleatoriamente
	 */
	protected AcusticaRuidosInterioresVerticalesFormVO fillRandomRecord(AcusticaRuidosInterioresVerticalesFormVO record, boolean forUpdate) throws GenericBusinessException  {

  
		if (!forUpdate) {
			//Damos de alta una inspeccion
			InspeccionFormVO inspeccion = fillNewRecord(new InspeccionFormVO());
			inspeccion = this.inspeccionBO.add(inspeccion);
			record.setInspeccionId(inspeccion.getInformeId());
		}

  
		record.setRuiiIntVertSepTipoTex( TestUtil.newString(255) );
  
		record.setRuiIntVertTabTipoTex( TestUtil.newString(255) );
  
		record.setCaracteristicasHuecosAdosados( TestUtil.newInteger() );
  
		record.setCaracteristicasHuecosAdosadosRevestidos( TestUtil.newInteger() );
  
		record.setCaracteristicasHuecosAdosadosRuidoMolesto( TestUtil.newInteger() );
  
		record.setCaracteristicasInstalacionesAtraviesanRecintos( TestUtil.newInteger() );
  
		record.setCaracteristicasInstalacionesConectanRecintos( TestUtil.newInteger() );
  
		record.setCaracteristicasPilaresConectanRecintos( TestUtil.newInteger() );
  
		record.setCaracteristicasPilaresConectanRecintosRevestidos( TestUtil.newInteger() );
  
		record.setCaracteristicasTuberiasAncladas( TestUtil.newInteger() );
  
		record.setDeficienciasObservaciones( TestUtil.newString(255) );
  
		record.setEstadoSeparacionBueno( TestUtil.newInteger() );
  
		record.setObservaciones( TestUtil.newString(255) );
  
		record.setSeparacionEntramadoAutoportante( TestUtil.newInteger() );
  
		record.setSeparacionEntramadoAutoportanteAbsorbente( TestUtil.newInteger() );
  
		record.setSeparacionEntramadoAutoportanteDoshojas( TestUtil.newInteger() );
  
		record.setSeparacionEntramadoAutoportanteDoshojasEspesor( TestUtil.newString(255) );
  
		record.setSeparacionEntramadoAutoportanteUnahoja( TestUtil.newInteger() );
  
		record.setSeparacionEntramadoAutoportanteUnahojaEspesor( TestUtil.newString(255) );
  
		record.setSeparacionEntramadoMadera( TestUtil.newInteger() );
  
		record.setSeparacionEntramadoMaderaEspesor( TestUtil.newInteger() );
  
		record.setSeparacionEntramadoMaderaRevestido( TestUtil.newInteger() );
  
		record.setSeparacionFabrica( TestUtil.newInteger() );
  
		record.setSeparacionFabricaRevestido( TestUtil.newInteger() );
  
		record.setSeparacionOtros( TestUtil.newInteger() );
  
		record.setSeparacionOtrosTexto( TestUtil.newString(255) );
  
		record.setTabiquesEntramadoAutoportanteMetalico( TestUtil.newInteger() );
  
		record.setTabiquesEntramadoAutoportanteMetalicoEspesor( TestUtil.newString(255) );
  
		record.setTabiquesEntramadoMaderaRelleno( TestUtil.newInteger() );
  
		record.setTabiquesEntramadoMaderaRellenoEspesor( TestUtil.newString(255) );
  
		record.setTabiquesFabrica( TestUtil.newInteger() );
  
		record.setZonaComunHallPuerta( TestUtil.newInteger() );
  
		record.setZonaComunPuertasAcusticamenteFavorables( TestUtil.newInteger() );

	return record;
	}

}


