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
 * Tests para el Bean: ConfigExportacion
 * @author agarcia@at4.net
 *
 */
public class ConfigExportacionBeanTest extends BaseBeanTests<ConfigExportacionFormVO, ConfigExportacionBO> {

	/**
	 * Bean para acceder a los métodos de negocio: ConfigExportacion
	 */
	@Autowired @Qualifier("ConfigExportacionBean")
	protected ConfigExportacionBO mainBean;

	/** Bean para acceder a los métodos de negocio: ConfigExportacion
	 */
	protected ConfigExportacionBO getMainBean() {
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
	 * Prueba la búsqueda searchAvailables
	 * @throws GenericBusinessException
	 */
    public void searchAvailablesTest() throws GenericBusinessException {
		java.lang.String nombre = TestUtil.newString();
		java.lang.String usuario = TestUtil.newString();
        this.getMainBean().searchAvailables(nombre, usuario);
    }

	/**
	 * Rellena una instancia de ConfigExportacion aleatoriamente
	 */
	protected ConfigExportacionFormVO fillRandomRecord(ConfigExportacionFormVO record, boolean forUpdate) throws GenericBusinessException  {

  
		record.setEtiqueta( TestUtil.newString(64) );
  
		record.setUsername( TestUtil.newString(32) );
  
		record.setNombre( TestUtil.newString(255) );
  
		record.setColumnas( TestUtil.newString(255) );
  
		record.setFormato( TestUtil.newString(20) );
  
		record.setPrivada( "f" );

	return record;
	}

}


