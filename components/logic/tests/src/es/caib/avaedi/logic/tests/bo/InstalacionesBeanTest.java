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
 * Tests para el Bean: Instalaciones
 * @author agarcia@at4.net
 *
 */
public class InstalacionesBeanTest extends InspeccionBaseBeanTests<InstalacionesFormVO, InstalacionesBO> {

	/**
	 * Bean para acceder a los métodos de negocio: Instalaciones
	 */
	@Autowired @Qualifier("InstalacionesBean")
	protected InstalacionesBO mainBean;

	/** Bean para acceder a los métodos de negocio: Instalaciones
	 */
	protected InstalacionesBO getMainBean() {
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
	 * Rellena una instancia de Instalaciones aleatoriamente
	 */
	protected InstalacionesFormVO fillRandomRecord(InstalacionesFormVO record, boolean forUpdate) throws GenericBusinessException  {

  
		if (!forUpdate) {
			//Damos de alta una inspeccion
			InspeccionFormVO inspeccion = fillNewRecord(new InspeccionFormVO());
			inspeccion = this.inspeccionBO.add(inspeccion);
			record.setInspeccionId(inspeccion.getInformeId());
		}

  
		record.setAcsCaptadoressolares( TestUtil.newInteger() );
  
		record.setAcsCentralCombustibleTexto( TestUtil.newString(255) );
  
		record.setAcsCentralTiene( TestUtil.newInteger() );
  
		record.setAcsNocentralCalentadoreselectricosporcentaje( TestUtil.newString(255) );
  
		record.setAcsNocentralGascanalizadoporcentaje( TestUtil.newString(255) );
  
		record.setAcsNocentralGasembotelladoporcentaje( TestUtil.newString(255) );
  
		record.setAcsNocentralIndividualporcentaje( TestUtil.newString(255) );
  
		record.setAcsNocentralOtrosporcentaje( TestUtil.newString(255) );
  
		record.setAcsTiene( TestUtil.newInteger() );
  
		record.setCalefaccionCentralCombustibleTexto( TestUtil.newString(255) );
  
		record.setCalefaccionCentralTexto( TestUtil.newString(255) );
  
		record.setCalefaccionCentralTiene( TestUtil.newInteger() );
  
		record.setCalefaccionNocentralCalderagasoleoporcentaje( TestUtil.newString(255) );
  
		record.setCalefaccionNocentralCalefaccionelectricaporcentaje( TestUtil.newString(255) );
  
		record.setCalefaccionNocentralGascanalizadoporcentaje( TestUtil.newString(255) );
  
		record.setCalefaccionNocentralIndividualporcentaje( TestUtil.newString(255) );
  
		record.setCalefaccionNocentralOtrosporcentaje( TestUtil.newString(255) );
  
		record.setCalefaccionTiene( TestUtil.newInteger() );
  
		record.setComunicacionesictTexto( TestUtil.newString(255) );
  
		record.setComunicacionesictTiene( TestUtil.newInteger() );
  
		record.setContraincendiosTiene( TestUtil.newInteger() );
  
		record.setContrarayoTexto( TestUtil.newString(255) );
  
		record.setContrarayoTiene( TestUtil.newInteger() );
  
		record.setElectricaTexto( TestUtil.newString(255) );
  
		record.setGascanalizadoPorcentaje( TestUtil.newString(255) );
  
		record.setGascanalizadoTiene( TestUtil.newInteger() );
  
		record.setInstalacionesAcsnocentralgascanalizados( TestUtil.newString(255) );
  
		record.setInstalacionesAcsnocentralgasembotellados( TestUtil.newString(255) );
  
		record.setInstalacionesCalefaccionnocentralcalefaccionelectricas( TestUtil.newString(255) );
  
		record.setInstalacionesCalefaccionnocentralgascanalizados( TestUtil.newString(255) );
  
		record.setObservaciones( TestUtil.newString(255) );
  
		record.setRefrigeracionColectivoTiene( TestUtil.newInteger() );
  
		record.setRefrigeracionNocolectivoAparatosenfachadas( TestUtil.newString(255) );
  
		record.setRefrigeracionNocolectivoIndividualporcentaje( TestUtil.newString(255) );
  
		record.setRefrigeracionTiene( TestUtil.newInteger() );
  
		record.setSaneamientoBajantesTexto( TestUtil.newString(255) );
  
		record.setSaneamientoColectoresTexto( TestUtil.newString(255) );
  
		record.setVentilacionCuartoshumedosSinventilacion( TestUtil.newInteger() );
  
		record.setVentilacionCuartoshumedosTexto( TestUtil.newString(255) );
  
		record.setVentilacionTiene( TestUtil.newInteger() );

	return record;
	}

}


