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
 * Tests para el Bean: EficienciasEnergeticas
 * @author agarcia@at4.net
 *
 */
public class EficienciasEnergeticasBeanTest extends InspeccionBaseBeanTests<EficienciasEnergeticasFormVO, EficienciasEnergeticasBO> {

	/**
	 * Bean para acceder a los métodos de negocio: EficienciasEnergeticas
	 */
	@Autowired @Qualifier("EficienciasEnergeticasBean")
	protected EficienciasEnergeticasBO mainBean;

	/** Bean para acceder a los métodos de negocio: EficienciasEnergeticas
	 */
	protected EficienciasEnergeticasBO getMainBean() {
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
	 * Rellena una instancia de EficienciasEnergeticas aleatoriamente
	 */
	protected EficienciasEnergeticasFormVO fillRandomRecord(EficienciasEnergeticasFormVO record, boolean forUpdate) throws GenericBusinessException  {

  
		if (!forUpdate) {
			//Damos de alta una inspeccion
			InspeccionFormVO inspeccion = fillNewRecord(new InspeccionFormVO());
			inspeccion = this.inspeccionBO.add(inspeccion);
			record.setInspeccionId(inspeccion.getInformeId());
		}

  
		record.setAmbitoAplicacion( TestUtil.newInteger() );
  
		record.setDemandaGlobalCalefaccion( TestUtil.newString(255) );
  
		record.setDemandaGlobalCalefaccionCalificacionTipoId( TestUtil.newInteger() );
  
		record.setDemandaGlobalRefrigeracion( TestUtil.newString(255) );
  
		record.setDemandaGlobalRefrigeracionCalificacionTipoId( TestUtil.newInteger() );
  
		record.setEsTecnicoInspeccion( TestUtil.newInteger() );
  
		record.setIndicadorGlobalCalificacionTipoId( TestUtil.newInteger() );
  
		record.setIndicadorGlobalEmisiones( TestUtil.newString(255) );
  
		record.setIndicadorGlobalPrimariaCalificacionTipoId( TestUtil.newInteger() );
  
		record.setIndicadorGlobalPrimariaConsumo( TestUtil.newString(255) );
  
		record.setIndicadorParcialEmisionesAcs( TestUtil.newString(255) );
  
		record.setIndicadorParcialEmisionesCalefaccion( TestUtil.newString(255) );
  
		record.setIndicadorParcialEmisionesRefrigeracion( TestUtil.newString(255) );
  
		record.setIndicadorParcialPrimariaAcs( TestUtil.newString(255) );
  
		record.setIndicadorParcialPrimariaCalefaccion( TestUtil.newString(255) );
  
		record.setIndicadorParcialPrimariaRefrigeracion( TestUtil.newString(255) );
  
		record.setNif( TestUtil.newString(255) );
  
		record.setObservaciones( TestUtil.newString(255) );
  
		record.setTecnico( TestUtil.newString(255) );
  
		record.setTitulacion( TestUtil.newString(255) );

	return record;
	}

}


