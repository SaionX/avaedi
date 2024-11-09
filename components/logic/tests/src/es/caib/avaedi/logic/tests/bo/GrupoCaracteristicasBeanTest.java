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
 * Tests para el Bean: GrupoCaracteristicas
 * @author agarcia@at4.net
 *
 */
public class GrupoCaracteristicasBeanTest extends BaseBeanTests<GrupoCaracteristicasFormVO, GrupoCaracteristicasBO> {

	/**
	 * Bean para acceder a los métodos de negocio: GrupoCaracteristicas
	 */
	@Autowired @Qualifier("GrupoCaracteristicasBean")
	protected GrupoCaracteristicasBO mainBean;

	/** Bean para acceder a los métodos de negocio: GrupoCaracteristicas
	 */
	protected GrupoCaracteristicasBO getMainBean() {
		return this.mainBean;
	}



/*
	Finders para relaciones
*/



	/**
	 * Rellena una instancia de GrupoCaracteristicas aleatoriamente
	 */
	protected GrupoCaracteristicasFormVO fillRandomRecord(GrupoCaracteristicasFormVO record, boolean forUpdate) throws GenericBusinessException  {

     if (!forUpdate) {
  
		record.setId( TestUtil.newInteger() );
     }
  
		record.setNombreEs( TestUtil.newString(255) );
  
		record.setNombreCa( TestUtil.newString(255) );

	return record;
	}

}


