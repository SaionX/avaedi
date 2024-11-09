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
 * Tests para el Bean: Usuario
 * @author agarcia@at4.net
 *
 */
public class UsuarioBeanTest extends BaseBeanTests<UsuarioFormVO, UsuarioBO> {

	/**
	 * Bean para acceder a los métodos de negocio: Usuario
	 */
	@Autowired @Qualifier("UsuarioBean")
	protected UsuarioBO mainBean;

	/** Bean para acceder a los métodos de negocio: Usuario
	 */
	protected UsuarioBO getMainBean() {
		return this.mainBean;
	}


	/**
	*Bean para acceder a los metodos de negocio: Municipio
	*/
 @Autowired @Qualifier("MunicipioBean")
	private MunicipioBO municipioBO;
	
	/** Bean para acceder a los metodos de negocio: Municipio
	* @param bean the bean to set
	*/
	public void setMunicipioBO(MunicipioBO bean) {
		this.municipioBO = bean;
	}
	


/*
	Finders para relaciones
*/
	  
	@Test
	public void  findByMunicipioTest() throws GenericBusinessException {
		int municipioId = TestUtil.newInteger();
		//¿assert?
		this.getMainBean().findByMunicipio(municipioId);
	}




	/**
	 * Prueba la búsqueda findUsuarioByUsername
	 * @throws GenericBusinessException
	 */
    public void findUsuarioByUsernameTest() throws GenericBusinessException {
		java.lang.String username = TestUtil.newString();
        this.getMainBean().findUsuarioByUsername(username);
    }

	/**
	 * Rellena una instancia de Usuario aleatoriamente
	 */
	protected UsuarioFormVO fillRandomRecord(UsuarioFormVO record, boolean forUpdate) throws GenericBusinessException  {

  
		record.setMunicipioId( this.municipioBO.getListado(null, new PagingConfig(1)).getResultados().iterator().next().getClave() );

  
		record.setUsername( TestUtil.newString(16) );
  
		record.setNombre( TestUtil.newString(50) );
  
		record.setApellidos( TestUtil.newString(255) );
  
		record.setIdioma( "CA" );

	return record;
	}

}


