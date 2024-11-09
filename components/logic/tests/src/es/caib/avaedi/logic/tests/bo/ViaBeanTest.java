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
 * Tests para el Bean: Via
 * @author agarcia@at4.net
 *
 */
public class ViaBeanTest extends BaseBeanTests<ViaFormVO, ViaBO> {

	/**
	 * Bean para acceder a los métodos de negocio: Via
	 */
	@Autowired @Qualifier("ViaBean")
	protected ViaBO mainBean;

	/** Bean para acceder a los métodos de negocio: Via
	 */
	protected ViaBO getMainBean() {
		return this.mainBean;
	}


	/**
	*Bean para acceder a los metodos de negocio: TipoVia
	*/
 @Autowired @Qualifier("TipoViaBean")
	private TipoViaBO tipoViaBO;
	
	/** Bean para acceder a los metodos de negocio: TipoVia
	* @param bean the bean to set
	*/
	public void setTipoViaBO(TipoViaBO bean) {
		this.tipoViaBO = bean;
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
	public void  findByTipoViaTest() throws GenericBusinessException {
		int tipoViaId = TestUtil.newInteger();
		//¿assert?
		this.getMainBean().findByTipoVia(tipoViaId);
	}


	  
	@Test
	public void  findByMunicipioTest() throws GenericBusinessException {
		int municipioId = TestUtil.newInteger();
		//¿assert?
		this.getMainBean().findByMunicipio(municipioId);
	}




	/**
	 * Prueba la búsqueda findViaDeMunicipio
	 * @throws GenericBusinessException
	 */
    public void findViaDeMunicipioTest() throws GenericBusinessException {
		java.lang.Integer codigo = TestUtil.newInteger();
		java.lang.Integer municipioId = TestUtil.newInteger();
        this.getMainBean().findViaDeMunicipio(codigo, municipioId);
    }
	/**
	 * Prueba la búsqueda findByCodigoCatastro
	 * @throws GenericBusinessException
	 */
    public void findByCodigoCatastroTest() throws GenericBusinessException {
		java.lang.Integer codigo = TestUtil.newInteger();
        //this.getMainBean().findByCodigoCatastro(codigo);
    }
	/**
	 * Prueba la búsqueda findViaDuplicada
	 * @throws GenericBusinessException
	 */
    public void findViaDuplicadaTest() throws GenericBusinessException {
		java.lang.String nombre = TestUtil.newString();
		java.lang.Integer municipioId = TestUtil.newInteger();
		java.lang.Integer tipoViaId = TestUtil.newInteger();
        this.getMainBean().findViaDuplicada(nombre, municipioId, tipoViaId);
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
	 * Prueba la búsqueda findViaDeMunicipioNombre
	 * @throws GenericBusinessException
	 */
    public void findViaDeMunicipioNombreTest() throws GenericBusinessException {
		java.lang.String nombre = TestUtil.newString();
		java.lang.Integer municipioId = TestUtil.newInteger();
        this.getMainBean().findViaDeMunicipioNombre(nombre, municipioId);
    }

	/**
	 * Rellena una instancia de Via aleatoriamente
	 */
	protected ViaFormVO fillRandomRecord(ViaFormVO record, boolean forUpdate) throws GenericBusinessException  {

  
		record.setTipoViaId( this.tipoViaBO.getListado(null, new PagingConfig(1)).getResultados().iterator().next().getClave() );

  
		record.setMunicipioId( this.municipioBO.getListado(null, new PagingConfig(1)).getResultados().iterator().next().getClave() );

  
		record.setNombre( TestUtil.newString(255) );
  
		record.setCodigoCatastro( TestUtil.newInteger() );

	return record;
	}

}


