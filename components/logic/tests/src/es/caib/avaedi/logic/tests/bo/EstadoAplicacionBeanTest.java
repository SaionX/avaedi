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
 * Tests para el Bean: EstadoAplicacion
 * @author agarcia@at4.net
 *
 */
public class EstadoAplicacionBeanTest extends BaseBeanTests<EstadoAplicacionFormVO, EstadoAplicacionBO> {

	/**
	 * Bean para acceder a los métodos de negocio: EstadoAplicacion
	 */
	@Autowired @Qualifier("EstadoAplicacionBean")
	protected EstadoAplicacionBO mainBean;

	/** Bean para acceder a los métodos de negocio: EstadoAplicacion
	 */
	protected EstadoAplicacionBO getMainBean() {
		return this.mainBean;
	}



/*
	Finders para relaciones
*/



	/**
	 * Rellena una instancia de EstadoAplicacion aleatoriamente
	 */
	protected EstadoAplicacionFormVO fillRandomRecord(EstadoAplicacionFormVO record, boolean forUpdate) throws GenericBusinessException  {

     if (!forUpdate) {
  
		//Clave compuesta id 
		record.setId(new EstadoAplicacionId());
		record.getId().setUsername( TestUtil.newString(32) );
		record.getId().setNombre( TestUtil.newString(255) );
     }
  
		record.setValor( TestUtil.newString(255) );

	return record;
	}

}


