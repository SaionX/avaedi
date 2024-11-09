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
 * Tests para el Bean: Isla
 * @author agarcia@at4.net
 *
 */
public class IslaBeanTest extends BaseBeanTests<IslaFormVO, IslaBO> {

	/**
	 * Bean para acceder a los métodos de negocio: Isla
	 */
	@Autowired @Qualifier("IslaBean")
	protected IslaBO mainBean;

	/** Bean para acceder a los métodos de negocio: Isla
	 */
	protected IslaBO getMainBean() {
		return this.mainBean;
	}



/*
	Finders para relaciones
*/



	/**
	 * Rellena una instancia de Isla aleatoriamente
	 */
	protected IslaFormVO fillRandomRecord(IslaFormVO record, boolean forUpdate) throws GenericBusinessException  {

     if (!forUpdate) {
  
		record.setId( TestUtil.newInteger() );
     }
  
		//record.setNombre( TestUtil.newString(255) );
		record.setNombre( "0123456789 0123456789 0123456789 0123456789 0123456789 0123456789 0123456789 0123456789 0123456789 0123456789 "
						+ "0123456789 0123456789 0123456789 0123456789 0123456789 0123456789 0123456789 0123456789 0123456789 0123456789 "
						+ "0123456789 0123456789 0123456789 0123456789 0123456789 0123456789 0123456789 0123456789 0123456789 0123456789 " );

	return record;
	}

}


