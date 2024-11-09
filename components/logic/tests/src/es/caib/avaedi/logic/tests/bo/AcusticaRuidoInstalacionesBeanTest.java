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
 * Tests para el Bean: AcusticaRuidoInstalaciones
 * @author agarcia@at4.net
 *
 */
public class AcusticaRuidoInstalacionesBeanTest extends InspeccionBaseBeanTests<AcusticaRuidoInstalacionesFormVO, AcusticaRuidoInstalacionesBO> {

	/**
	 * Bean para acceder a los métodos de negocio: AcusticaRuidoInstalaciones
	 */
	@Autowired @Qualifier("AcusticaRuidoInstalacionesBean")
	protected AcusticaRuidoInstalacionesBO mainBean;

	/** Bean para acceder a los métodos de negocio: AcusticaRuidoInstalaciones
	 */
	protected AcusticaRuidoInstalacionesBO getMainBean() {
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
	 * Rellena una instancia de AcusticaRuidoInstalaciones aleatoriamente
	 */
	protected AcusticaRuidoInstalacionesFormVO fillRandomRecord(AcusticaRuidoInstalacionesFormVO record, boolean forUpdate) throws GenericBusinessException  {

  
		if (!forUpdate) {
			//Damos de alta una inspeccion
			InspeccionFormVO inspeccion = fillNewRecord(new InspeccionFormVO());
			inspeccion = this.inspeccionBO.add(inspeccion);
			record.setInspeccionId(inspeccion.getInformeId());
		}

  
		record.setEquiposInstalacionesColindantes( TestUtil.newInteger() );
  
		record.setEquiposInstalacionesConductosAnclados( TestUtil.newInteger() );
  
		record.setEquiposInstalacionesConectoresFlexibles( TestUtil.newInteger() );
  
		record.setEquiposInstalacionesHolgurasSelladas( TestUtil.newInteger() );
  
		record.setEquiposInstalacionesRuidoMolesto( TestUtil.newInteger() );
  
		record.setEquiposInstalacionesRuidoMolestoTipoLocalizacion( TestUtil.newString(255) );
  
		record.setEquiposInstalacionesSistemaAmortiguante( TestUtil.newInteger() );
  
		record.setEquiposInstalacionesZonasExteriores( TestUtil.newInteger() );
  
		record.setEquiposInstalacionesZonasExterioresPantallas( TestUtil.newInteger() );
  
		record.setObservaciones( TestUtil.newString(255) );
  
		record.setOtrasAscensoresColindantes( TestUtil.newInteger() );
  
		record.setOtrasAscensoresCuadroManiobras( TestUtil.newInteger() );
  
		record.setOtrasAscensoresCuartoMaquinas( TestUtil.newInteger() );
  
		record.setOtrasAscensoresRuidoMolesto( TestUtil.newInteger() );
  
		record.setOtrasAscensoresRuidoMolestoTipoLocalizacion( TestUtil.newString(255) );
  
		record.setOtrasAscensoresSistemaAmortiguante( TestUtil.newInteger() );
  
		record.setOtrasAscensoresTrasdosado( TestUtil.newInteger() );
  
		record.setOtrasCuartosHumedosAireAcondicionado( TestUtil.newInteger() );
  
		record.setOtrasCuartosHumedosLuminariasEmpotradas( TestUtil.newInteger() );
  
		record.setOtrasCuartosHumedosRuidoMolesto( TestUtil.newInteger() );
  
		record.setOtrasCuartosHumedosRuidoMolestoTipoLocalizacion( TestUtil.newString(255) );
  
		record.setOtrasCuartosHumedosSaneamiento( TestUtil.newInteger() );
  
		record.setOtrasCuartosHumedosSaneamientoConectoresFlexibles( TestUtil.newInteger() );
  
		record.setOtrasCuartosHumedosSaneamientoLanaMineral( TestUtil.newInteger() );
  
		record.setOtrasCuartosHumedosSaneamientoMaterialElastico( TestUtil.newInteger() );
  
		record.setOtrasCuartosHumedosSaneamientoTechoSellado( TestUtil.newInteger() );
  
		record.setOtrasPuertasGarajeAncladas( TestUtil.newInteger() );
  
		record.setOtrasPuertasGarajeAncladasMarcoAmortiguadores( TestUtil.newInteger() );
  
		record.setOtrasPuertasGarajeAncladasMotoresAmortiguadores( TestUtil.newInteger() );
  
		record.setOtrasPuertasGarajeAncladasRuidoPuerta( TestUtil.newInteger() );
  
		record.setRecintosActividadRevestido( TestUtil.newInteger() );
  
		record.setRecintosActividadRuidoMolesto( TestUtil.newInteger() );
  
		record.setRecintosActividadRuidoMolestoTipoLocalizacion( TestUtil.newString(255) );
  
		record.setRecintosActividadSueloFlotante( TestUtil.newInteger() );
  
		record.setRecintosActividadTechoSuspendido( TestUtil.newInteger() );
  
		record.setRecintosActividadTechoSuspendidoAbsorvente( TestUtil.newInteger() );
  
		record.setRecintosActividadTechoSuspendidoAmortiguadores( TestUtil.newInteger() );
  
		record.setRecintosActividadTiene( TestUtil.newInteger() );
  
		record.setRecintosActividadTipoLocalizacion( TestUtil.newString(255) );
  
		record.setRecintosActividadTrasdosados( TestUtil.newInteger() );
  
		record.setRecintosActividadTrasdosadosAmortiguadores( TestUtil.newInteger() );
  
		record.setRecintosActividadTratamientoAbsorvente( TestUtil.newInteger() );
  
		record.setRedesAguaRuidoMolestoTipoLocalizacion( TestUtil.newString(255) );
  
		record.setRedesAireAcondicionadoFalsoTecho( TestUtil.newInteger() );
  
		record.setRedesAireAcondicionadoRuidoMolesto( TestUtil.newInteger() );
  
		record.setRedesSaneamientoBajantesAbrazaderas( TestUtil.newInteger() );
  
		record.setRedesSaneamientoBajantesForradas( TestUtil.newInteger() );
  
		record.setRedesSaneamientoBajantesRevestidas( TestUtil.newInteger() );
  
		record.setRedesSaneamientoCodoBajante( TestUtil.newInteger() );
  
		record.setRedesSaneamientoRuidoMolesto( TestUtil.newInteger() );
  
		record.setRedesSaneamientoRuidoMolestoTipoLocalizacion( TestUtil.newString(255) );
  
		record.setRedesSuministroAguaRuidoGolpeAriete( TestUtil.newInteger() );
  
		record.setRedesSuministroAguaRuidoMolesto( TestUtil.newInteger() );
  
		record.setRedesSuministroAguaTuberiasForradas( TestUtil.newInteger() );
  
		record.setRedesVentilacionConductoIndividual( TestUtil.newInteger() );
  
		record.setRedesVentilacionConductosShunt( TestUtil.newInteger() );
  
		record.setRedesVentilacionRuidoViviendasColindantes( TestUtil.newInteger() );

	return record;
	}

}


