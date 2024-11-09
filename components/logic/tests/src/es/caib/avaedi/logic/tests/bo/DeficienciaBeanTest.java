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
 * Tests para el Bean: Deficiencia
 * @author agarcia@at4.net
 *
 */
public class DeficienciaBeanTest extends InspeccionBaseBeanTests<DeficienciaFormVO, DeficienciaBO> {

	/**
	 * Bean para acceder a los métodos de negocio: Deficiencia
	 */
	@Autowired @Qualifier("DeficienciaBean")
	protected DeficienciaBO mainBean;

	/** Bean para acceder a los métodos de negocio: Deficiencia
	 */
	protected DeficienciaBO getMainBean() {
		return this.mainBean;
	}


	/**
	*Bean para acceder a los metodos de negocio: DeficienciaTipo
	*/
 @Autowired @Qualifier("DeficienciaTipoBean")
	private DeficienciaTipoBO deficienciaTipoBO;
	
	/** Bean para acceder a los metodos de negocio: DeficienciaTipo
	* @param bean the bean to set
	*/
	public void setDeficienciaTipoBO(DeficienciaTipoBO bean) {
		this.deficienciaTipoBO = bean;
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
	public void  findByDeficienciaTipoTest() throws GenericBusinessException {
		int deficienciaTipoId = TestUtil.newInteger();
		//¿assert?
		this.getMainBean().findByDeficienciaTipo(deficienciaTipoId);
	}


	  
	@Test
	public void  findByInspeccionTest() throws GenericBusinessException {
		int inspeccionId = TestUtil.newInteger();
		//¿assert?
		this.getMainBean().findByInspeccion(inspeccionId);
	}





	/**
	 * Rellena una instancia de Deficiencia aleatoriamente
	 */
	protected DeficienciaFormVO fillRandomRecord(DeficienciaFormVO record, boolean forUpdate) throws GenericBusinessException  {

  
		DeficienciaTipoFormVO deficienciaTipo = this.deficienciaTipoBO.add( this.fillNewRecord(new DeficienciaTipoFormVO() ));
		record.setDeficienciaTipoId(deficienciaTipo.getId());

		if (!forUpdate) {
			//Damos de alta una inspeccion
			InspeccionFormVO inspeccion = fillNewRecord(new InspeccionFormVO());
			inspeccion = this.inspeccionBO.add(inspeccion);
			record.setInspeccionId(inspeccion.getInformeId());
		}

  
		record.setConservacionSistemasconstructivosTipoId( TestUtil.newInteger() );
  
		record.setDescripcionDeficiencia( TestUtil.newString(255) );
  
		record.setEsGrave( TestUtil.newInteger() );
  
		record.setLocalizacionDeficiencia( TestUtil.newString(255) );
  
		record.setNombreDeficiencia( TestUtil.newString(255) );
  
		record.setObservaciones( TestUtil.newString(255) );
  
		record.setPruebasEnsayosRealizados( TestUtil.newString(255) );

	return record;
	}

	/**
	 * Rellena una instancia de DeficienciaTipo aleatoriamente
	 */
	protected DeficienciaTipoFormVO fillNewRecord(DeficienciaTipoFormVO record) throws GenericBusinessException  {

		Date ahora = new Date();
		record.setDateCreation(ahora);
		record.setLastModified(ahora);
		record.setCreatorUser("testrunner");
		record.setModUser("testrunner");
		record.setId( 1000 + TestUtil.newInteger() );
		record.setNombre( TestUtil.newString(255) );

	return record;
	}
	
}


