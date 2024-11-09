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
 * Tests para el Bean: Conservacion
 * @author agarcia@at4.net
 *
 */
public class ConservacionBeanTest extends InspeccionBaseBeanTests<ConservacionFormVO, ConservacionBO> {

	/**
	 * Bean para acceder a los métodos de negocio: Conservacion
	 */
	@Autowired @Qualifier("ConservacionBean")
	protected ConservacionBO mainBean;

	/** Bean para acceder a los métodos de negocio: Conservacion
	 */
	protected ConservacionBO getMainBean() {
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
	 * Rellena una instancia de Conservacion aleatoriamente
	 */
	protected ConservacionFormVO fillRandomRecord(ConservacionFormVO record, boolean forUpdate) throws GenericBusinessException  {

  
		if (!forUpdate) {
			//Damos de alta una inspeccion
			InspeccionFormVO inspeccion = fillNewRecord(new InspeccionFormVO());
			inspeccion = this.inspeccionBO.add(inspeccion);
			record.setInspeccionId(inspeccion.getInformeId());
		}

  
		record.setEsTecnicoInspeccion( TestUtil.newInteger() );
  
		record.setConservacionValoracionesTipoId( TestUtil.newInteger() );
  
		record.setImpedimentosVisita( TestUtil.newString(255) );
  
		record.setFechaEmisionInformeValoracion( TestUtil.newString(255) );
  
		record.setMedidasSeguridadVisita( TestUtil.newString(255) );
  
		record.setMediosInspeccion( TestUtil.newString(255) );
  
		record.setNif( TestUtil.newString(255) );
  
		record.setNumLocalesInspeccionados( TestUtil.newInteger() );
  
		record.setNumViviendasInspeccionadas( TestUtil.newInteger() );
  
		record.setObservaciones( TestUtil.newString(255) );
  
		record.setPruebasRealizadas( TestUtil.newString(255) );
  
		record.setTecnico( TestUtil.newString(255) );
  
		record.setTitulacion( TestUtil.newString(255) );
  
		record.setExistePeligroInminente( TestUtil.newInteger() );
  
		record.setDescripcionPeligroInminente( TestUtil.newString(255) );
  
		record.setFechaLimiteActuacion( TestUtil.newString(255) );
  
		record.setMedidas( TestUtil.newString(255) );

	return record;
	}

}


