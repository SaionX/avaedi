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
 * Tests para el Bean: DeficienciaTipo
 * @author agarcia@at4.net
 *
 */
public class DeficienciaTipoBeanTest extends BaseBeanTests<DeficienciaTipoFormVO, DeficienciaTipoBO> {

	/**
	 * Bean para acceder a los métodos de negocio: DeficienciaTipo
	 */
	@Autowired @Qualifier("DeficienciaTipoBean")
	protected DeficienciaTipoBO mainBean;

	/** Bean para acceder a los métodos de negocio: DeficienciaTipo
	 */
	protected DeficienciaTipoBO getMainBean() {
		return this.mainBean;
	}



/*
	Finders para relaciones
*/



	/**
	 * Rellena una instancia de DeficienciaTipo aleatoriamente
	 */
	protected DeficienciaTipoFormVO fillRandomRecord(DeficienciaTipoFormVO record, boolean forUpdate) throws GenericBusinessException  {

     if (!forUpdate) {
  
		record.setId( TestUtil.newInteger() );
     }
  
		record.setNombre( TestUtil.newString(255) );

	return record;
	}

}


