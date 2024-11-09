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
 * Tests para el Bean: Blob
 * @author agarcia@at4.net
 *
 */
public class BlobBeanTest extends BaseBeanTests<BlobFormVO, BlobBO> {

	/**
	 * Bean para acceder a los métodos de negocio: Blob
	 */
	@Autowired @Qualifier("BlobBean")
	protected BlobBO mainBean;

	/** Bean para acceder a los métodos de negocio: Blob
	 */
	protected BlobBO getMainBean() {
		return this.mainBean;
	}



/*
	Finders para relaciones
*/



	/**
	 * Rellena una instancia de Blob aleatoriamente
	 */
	protected BlobFormVO fillRandomRecord(BlobFormVO record, boolean forUpdate) throws GenericBusinessException  {

  
		record.setPath( TestUtil.newString(255) );

	return record;
	}

}


