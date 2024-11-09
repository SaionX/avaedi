package es.caib.avaedi.logic.tests.bo;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import es.caib.avaedi.logic.bo.*;
import es.caib.avaedi.logic.vo.*;
import es.caib.avaedi.at4forms.common.exception.GenericBusinessException;
import es.caib.avaedi.at4forms.tests.BaseBeanTests;
import es.caib.avaedi.at4forms.tests.TestUtil;
import es.caib.avaedi.common.model.*;

import java.util.*;

import org.junit.Test;


/**
 * Tests para el Bean: ConfigAplicacion
 * @author agarcia@at4.net
 *
 */
public class ConfigAplicacionBeanTest extends BaseBeanTests<ConfigAplicacionFormVO, ConfigAplicacionBO> {

	/**
	 * Bean para acceder a los métodos de negocio: ConfigAplicacion
	 */
	@Autowired @Qualifier("ConfigAplicacionBean")
	protected ConfigAplicacionBO mainBean;

	/** Bean para acceder a los métodos de negocio: ConfigAplicacion
	 */
	protected ConfigAplicacionBO getMainBean() {
		return this.mainBean;
	}



/*
	Finders para relaciones
*/


	/**
	 * Prueba la búsqueda findByEtiqueta
	 * @throws GenericBusinessException
	 */
    public void findByEtiquetaTest() throws GenericBusinessException {
		java.lang.String etiqueta = TestUtil.newString();
		java.lang.String nombre = TestUtil.newString();
		java.lang.String usuario = TestUtil.newString();
        this.getMainBean().findByEtiqueta(etiqueta, nombre, usuario);
    }

	/**
	 * Rellena una instancia de ConfigAplicacion aleatoriamente
	 */
	protected ConfigAplicacionFormVO fillRandomRecord(ConfigAplicacionFormVO record, boolean forUpdate) throws GenericBusinessException  {

  
		record.setEtiqueta( TestUtil.newString(64) );
  
		record.setUsername( TestUtil.newString(32) );
  
		record.setNombre( TestUtil.newString(255) );
  
		record.setValor( TestUtil.newString(255) );

	return record;
	}

}


