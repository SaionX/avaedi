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
 * Tests para el Bean: AcusticaValoracionFinal
 * @author agarcia@at4.net
 *
 */
public class AcusticaValoracionFinalBeanTest extends InspeccionBaseBeanTests<AcusticaValoracionFinalFormVO, AcusticaValoracionFinalBO> {

	/**
	 * Bean para acceder a los métodos de negocio: AcusticaValoracionFinal
	 */
	@Autowired @Qualifier("AcusticaValoracionFinalBean")
	protected AcusticaValoracionFinalBO mainBean;

	/** Bean para acceder a los métodos de negocio: AcusticaValoracionFinal
	 */
	protected AcusticaValoracionFinalBO getMainBean() {
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
	 * Rellena una instancia de AcusticaValoracionFinal aleatoriamente
	 */
	protected AcusticaValoracionFinalFormVO fillRandomRecord(AcusticaValoracionFinalFormVO record, boolean forUpdate) throws GenericBusinessException  {

  
		if (!forUpdate) {
			//Damos de alta una inspeccion
			InspeccionFormVO inspeccion = fillNewRecord(new InspeccionFormVO());
			inspeccion = this.inspeccionBO.add(inspeccion);
			record.setInspeccionId(inspeccion.getInformeId());
		}

  
		record.setObservaciones( TestUtil.newString(255) );
  
		record.setProteccionRuidoExteriorTipoId( TestUtil.newInteger() );
  
		record.setProteccionRuidoInstalacionesTipoId( TestUtil.newInteger() );
  
		record.setProteccionRuidoInteriorAereoHorizontalTipoId( TestUtil.newInteger() );
  
		record.setProteccionRuidoInteriorAereoVerticalTipoId( TestUtil.newInteger() );
  
		record.setProteccionRuidoInteriorImpactosHorizontalTipoId( TestUtil.newInteger() );
  
		record.setProteccionRuidoInteriorImpactosVerticalTipoId( TestUtil.newInteger() );

	return record;
	}

}


