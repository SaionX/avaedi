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
 * Tests para el Bean: Acusticas
 * @author agarcia@at4.net
 *
 */
public class AcusticasBeanTest extends InspeccionBaseBeanTests<AcusticasFormVO, AcusticasBO> {

	/**
	 * Bean para acceder a los métodos de negocio: Acusticas
	 */
	@Autowired @Qualifier("AcusticasBean")
	protected AcusticasBO mainBean;

	/** Bean para acceder a los métodos de negocio: Acusticas
	 */
	protected AcusticasBO getMainBean() {
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
	 * Rellena una instancia de Acusticas aleatoriamente
	 */
	protected AcusticasFormVO fillRandomRecord(AcusticasFormVO record, boolean forUpdate) throws GenericBusinessException  {

		if (!forUpdate) {
			//Damos de alta una inspeccion
			InspeccionFormVO inspeccion = fillNewRecord(new InspeccionFormVO());
			inspeccion = this.inspeccionBO.add(inspeccion);
			record.setInspeccionId(inspeccion.getInformeId());
		}

  
		record.setEsTecnicoInspeccion( TestUtil.newInteger() );
  
		record.setIncluirInformeAcustica( TestUtil.newString(255) );
  
		record.setNif( TestUtil.newString(255) );
  
		record.setObservaciones( TestUtil.newString(255) );
  
		record.setTecnico( TestUtil.newString(255) );
  
		record.setTitulacion( TestUtil.newString(255) );

	return record;
	}

}

