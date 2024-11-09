package es.caib.avaedi.logic.tests.bo;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import es.caib.avaedi.logic.bo.*;
import es.caib.avaedi.logic.vo.*;
import es.caib.avaedi.at4forms.common.exception.GenericBusinessException;
import es.caib.avaedi.at4forms.tests.TestUtil;

import java.util.*;

import org.junit.Test;


/**
 * Tests para el Bean: AccesibilidadAjustesRazonables
 * @author agarcia@at4.net
 *
 */
public class AccesibilidadAjustesRazonablesBeanTest extends InspeccionBaseBeanTests<AccesibilidadAjustesRazonablesFormVO, AccesibilidadAjustesRazonablesBO> {

	/**
	 * Bean para acceder a los métodos de negocio: AccesibilidadAjustesRazonables
	 */
	@Autowired @Qualifier("AccesibilidadAjustesRazonablesBean")
	protected AccesibilidadAjustesRazonablesBO mainBean;

	/** Bean para acceder a los métodos de negocio: AccesibilidadAjustesRazonables
	 */
	protected AccesibilidadAjustesRazonablesBO getMainBean() {
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
	 * Rellena una instancia de AccesibilidadAjustesRazonables aleatoriamente
	 */
	protected AccesibilidadAjustesRazonablesFormVO fillRandomRecord(AccesibilidadAjustesRazonablesFormVO record, boolean forUpdate) throws GenericBusinessException  {

		if (!forUpdate) {
			//Damos de alta una inspeccion
			InspeccionFormVO inspeccion = fillNewRecord(new InspeccionFormVO());
			inspeccion = this.inspeccionBO.add(inspeccion);
			record.setInspeccionId(inspeccion.getInformeId());
		}


  
		record.setAjustesrazonablesCoste( TestUtil.newString(255) );
  
		record.setAjustesrazonablesDescripcion( TestUtil.newString(255) );
  
		record.setEdificionosusceptibleajustes( TestUtil.newInteger() );
  
		record.setEdificiosusceptibleajustesTotal( TestUtil.newInteger() );
  
		record.setFinanciacionayuda( TestUtil.newString(255) );
  
		record.setImportegastoscomunes( TestUtil.newString(255) );
  
		record.setObservacionesAnalisisNoMedidas( TestUtil.newString(255) );
  
		record.setObservacionesCargaeconomica( TestUtil.newString(255) );
  
		record.setObservacionesConsideracionesinmueble( TestUtil.newString(255) );
  
		record.setPersonasdiscapacitadasomayores( TestUtil.newString(255) );
  
		record.setViviendasnoitinerarioaccesible( TestUtil.newString(255) );

	return record;
	}

}


