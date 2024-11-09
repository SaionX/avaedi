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
 * Tests para el Bean: AccesibilidadValoracionFinales
 * @author agarcia@at4.net
 *
 */
public class AccesibilidadValoracionFinalesBeanTest extends InspeccionBaseBeanTests<AccesibilidadValoracionFinalesFormVO, AccesibilidadValoracionFinalesBO> {

	/**
	 * Bean para acceder a los métodos de negocio: AccesibilidadValoracionFinales
	 */
	@Autowired @Qualifier("AccesibilidadValoracionFinalesBean")
	protected AccesibilidadValoracionFinalesBO mainBean;

	/** Bean para acceder a los métodos de negocio: AccesibilidadValoracionFinales
	 */
	protected AccesibilidadValoracionFinalesBO getMainBean() {
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
	 * Rellena una instancia de AccesibilidadValoracionFinales aleatoriamente
	 */
	protected AccesibilidadValoracionFinalesFormVO fillRandomRecord(AccesibilidadValoracionFinalesFormVO record, boolean forUpdate) throws GenericBusinessException  {

  
		if (!forUpdate) {
			//Damos de alta una inspeccion
			InspeccionFormVO inspeccion = fillNewRecord(new InspeccionFormVO());
			inspeccion = this.inspeccionBO.add(inspeccion);
			record.setInspeccionId(inspeccion.getInformeId());
		}

  
		record.setDeficienciasPublicoAlojamientosaccesibles( TestUtil.newInteger() );
  
		record.setDeficienciasPublicoAparcamiento( TestUtil.newInteger() );
  
		record.setDeficienciasPublicoEntreplantas( TestUtil.newInteger() );
  
		record.setDeficienciasPublicoExterior( TestUtil.newInteger() );
  
		record.setDeficienciasPublicoInformacionsenalizacion( TestUtil.newInteger() );
  
		record.setDeficienciasPublicoMecanismos( TestUtil.newInteger() );
  
		record.setDeficienciasPublicoMobiliariofijo( TestUtil.newInteger() );
  
		record.setDeficienciasPublicoPiscinas( TestUtil.newInteger() );
  
		record.setDeficienciasPublicoPlantas( TestUtil.newInteger() );
  
		record.setDeficienciasPublicoPlazasreservadas( TestUtil.newInteger() );
  
		record.setDeficienciasPublicoServicioshigienicos( TestUtil.newInteger() );
  
		record.setDeficienciasViviendaAparcamiento( TestUtil.newString(255) );
  
		record.setDeficienciasViviendaEntreplantas( TestUtil.newString(255) );
  
		record.setDeficienciasViviendaExterior( TestUtil.newString(255) );
  
		record.setDeficienciasViviendaInformacionsenalizacion( TestUtil.newString(255) );
  
		record.setDeficienciasViviendaMecanismos( TestUtil.newString(255) );
  
		record.setDeficienciasViviendaPiscinas( TestUtil.newString(255) );
  
		record.setDeficienciasViviendaPlantas( TestUtil.newString(255) );
  
		record.setDeficienciasViviendaServicioshigienicos( TestUtil.newString(255) );
  
		record.setSatisfaceCondicionesBasicas( TestUtil.newInteger() );

	return record;
	}

}


