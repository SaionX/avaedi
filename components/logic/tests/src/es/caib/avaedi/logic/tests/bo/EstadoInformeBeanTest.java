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
 * Tests para el Bean: EstadoInforme
 * @author agarcia@at4.net
 *
 */
public class EstadoInformeBeanTest extends BaseBeanTests<EstadoInformeFormVO, EstadoInformeBO> {

	/**
	 * Bean para acceder a los métodos de negocio: EstadoInforme
	 */
	@Autowired @Qualifier("EstadoInformeBean")
	protected EstadoInformeBO mainBean;

	/** Bean para acceder a los métodos de negocio: EstadoInforme
	 */
	protected EstadoInformeBO getMainBean() {
		return this.mainBean;
	}



/*
	Finders para relaciones
*/



	/**
	 * Rellena una instancia de EstadoInforme aleatoriamente
	 */
	protected EstadoInformeFormVO fillRandomRecord(EstadoInformeFormVO record, boolean forUpdate) throws GenericBusinessException  {

  
		record.setNombreEs( TestUtil.newString(64) );
  
		record.setNombreCa( TestUtil.newString(64) );

	return record;
	}

}


