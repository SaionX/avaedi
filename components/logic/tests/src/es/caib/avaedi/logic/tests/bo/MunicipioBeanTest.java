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
 * Tests para el Bean: Municipio
 * @author agarcia@at4.net
 *
 */
public class MunicipioBeanTest extends BaseBeanTests<MunicipioFormVO, MunicipioBO> {

	/**
	 * Bean para acceder a los métodos de negocio: Municipio
	 */
	@Autowired @Qualifier("MunicipioBean")
	protected MunicipioBO mainBean;

	/** Bean para acceder a los métodos de negocio: Municipio
	 */
	protected MunicipioBO getMainBean() {
		return this.mainBean;
	}


	/**
	*Bean para acceder a los metodos de negocio: Isla
	*/
 @Autowired @Qualifier("IslaBean")
	private IslaBO islaBO;
	
	/** Bean para acceder a los metodos de negocio: Isla
	* @param bean the bean to set
	*/
	public void setIslaBO(IslaBO bean) {
		this.islaBO = bean;
	}
	


/*
	Finders para relaciones
*/
	  
	@Test
	public void  findByIslaTest() throws GenericBusinessException {
		int islaId = TestUtil.newInteger();
		//¿assert?
		this.getMainBean().findByIsla(islaId);
	}




	/**
	 * Prueba la búsqueda findByNombre
	 * @throws GenericBusinessException
	 */
    public void findByNombreTest() throws GenericBusinessException {
		java.lang.String nombre = TestUtil.newString();
        this.getMainBean().findByNombre(nombre);
    }

	/**
	 * Rellena una instancia de Municipio aleatoriamente
	 */
	protected MunicipioFormVO fillRandomRecord(MunicipioFormVO record, boolean forUpdate) throws GenericBusinessException  {

  
		record.setIslaId( this.islaBO.getListado(null, new PagingConfig(1)).getResultados().iterator().next().getId() );

  
		record.setNombre( TestUtil.newString(255) );
  
		record.setCodigoIne( 1000 + TestUtil.newInteger() );
  
		record.setCodigoCatastro( 1000 + TestUtil.newInteger() );
  
		record.setOrganismoContacto( TestUtil.newString(255) );
  
		record.setDireccion( TestUtil.newString(255) );
  
		record.setTelefono( TestUtil.newString(12) );
  
		record.setEmail( TestUtil.newString(255) );
  
		record.setUrl( TestUtil.newString(255) );

	return record;
	}

}


