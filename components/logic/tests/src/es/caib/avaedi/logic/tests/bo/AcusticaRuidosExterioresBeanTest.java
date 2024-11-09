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
 * Tests para el Bean: AcusticaRuidosExteriores
 * @author agarcia@at4.net
 *
 */
public class AcusticaRuidosExterioresBeanTest extends InspeccionBaseBeanTests<AcusticaRuidosExterioresFormVO, AcusticaRuidosExterioresBO> {

	/**
	 * Bean para acceder a los métodos de negocio: AcusticaRuidosExteriores
	 */
	@Autowired @Qualifier("AcusticaRuidosExterioresBean")
	protected AcusticaRuidosExterioresBO mainBean;

	/** Bean para acceder a los métodos de negocio: AcusticaRuidosExteriores
	 */
	protected AcusticaRuidosExterioresBO getMainBean() {
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
	 * Rellena una instancia de AcusticaRuidosExteriores aleatoriamente
	 */
	protected AcusticaRuidosExterioresFormVO fillRandomRecord(AcusticaRuidosExterioresFormVO record, boolean forUpdate) throws GenericBusinessException  {

  
		if (!forUpdate) {
			//Damos de alta una inspeccion
			InspeccionFormVO inspeccion = fillNewRecord(new InspeccionFormVO());
			inspeccion = this.inspeccionBO.add(inspeccion);
			record.setInspeccionId(inspeccion.getInformeId());
		}

  
		record.setAireadoresAsilamientoAcustico( TestUtil.newString(255) );
  
		record.setAireadoresTiene( TestUtil.newInteger() );
  
		record.setCapialzadosAislamientoAcustico( TestUtil.newInteger() );
  
		record.setCapialzadosNoPrefabricados( TestUtil.newInteger() );
  
		record.setCapialzadosTiene( TestUtil.newInteger() );
  
		record.setCubiertasLigeras( TestUtil.newInteger() );
  
		record.setCubiertasLigerasTecho( TestUtil.newInteger() );
  
		record.setCubiertasPesadas( TestUtil.newInteger() );
  
		record.setDeficienciasObservaciones( TestUtil.newString(255) );
  
		record.setEstadoCapialzadosBueno( TestUtil.newInteger() );
  
		record.setEstadoCubiertasBueno( TestUtil.newInteger() );
  
		record.setEstadoFachadasBueno( TestUtil.newInteger() );
  
		record.setEstadoVentanasBueno( TestUtil.newInteger() );
  
		record.setFachadasLigeras( TestUtil.newInteger() );
  
		record.setFachadasPesadas( TestUtil.newInteger() );
  
		record.setObservaciones( TestUtil.newString(255) );
  
		record.setRuidoMolestoExterior( TestUtil.newInteger() );
  
		record.setVentanasLocalizacionTiposVentanas( TestUtil.newString(255) );

	return record;
	}

}


