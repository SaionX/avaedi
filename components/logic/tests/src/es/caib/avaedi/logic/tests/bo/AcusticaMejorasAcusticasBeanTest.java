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
 * Tests para el Bean: AcusticaMejorasAcusticas
 * @author agarcia@at4.net
 *
 */
public class AcusticaMejorasAcusticasBeanTest extends InspeccionBaseBeanTests<AcusticaMejorasAcusticasFormVO, AcusticaMejorasAcusticasBO> {

	/**
	 * Bean para acceder a los métodos de negocio: AcusticaMejorasAcusticas
	 */
	@Autowired @Qualifier("AcusticaMejorasAcusticasBean")
	protected AcusticaMejorasAcusticasBO mainBean;

	/** Bean para acceder a los métodos de negocio: AcusticaMejorasAcusticas
	 */
	protected AcusticaMejorasAcusticasBO getMainBean() {
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
	 * Rellena una instancia de AcusticaMejorasAcusticas aleatoriamente
	 */
	protected AcusticaMejorasAcusticasFormVO fillRandomRecord(AcusticaMejorasAcusticasFormVO record, boolean forUpdate) throws GenericBusinessException  {

  
		if (!forUpdate) {
			//Damos de alta una inspeccion
			InspeccionFormVO inspeccion = fillNewRecord(new InspeccionFormVO());
			inspeccion = this.inspeccionBO.add(inspeccion);
			record.setInspeccionId(inspeccion.getInformeId());

			record.setId(new AcusticaMejorasAcusticasId());
			record.getId().setMejorasOrden( TestUtil.newInteger() );
			record.getId().setClaveInforme(inspeccion.getId());

		}

  
		record.setProteccionRuidoExteriorTipoId( TestUtil.newInteger() );
  
		record.setMejorasAnalisisTecnico( TestUtil.newString(255) );
  
		record.setProteccionRuidoInstalacionesTipoId( TestUtil.newInteger() );
  
		record.setMejorasDescripcion( TestUtil.newString(255) );
  
		record.setProteccionRuidoInteriorAereoTipoId( TestUtil.newInteger() );
  
		record.setMejorasObservaciones( TestUtil.newString(255) );
  
		record.setProteccionRuidoInteriorImpactosTipoId( TestUtil.newInteger() );
  
		record.setMejorasValoracionEconomica( TestUtil.newString(255) );
  
		record.setPotencialObservaciones( TestUtil.newString(255) );
  
		record.setIncidenciaObservaciones( TestUtil.newString(255) );
  
		record.setIncidenciaTexto( TestUtil.newString(255) );

	return record;
	}

}


