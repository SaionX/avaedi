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
 * Tests para el Bean: TipoVia
 * @author agarcia@at4.net
 *
 */
public class TipoViaBeanTest extends BaseBeanTests<TipoViaFormVO, TipoViaBO> {

	/**
	 * Bean para acceder a los métodos de negocio: TipoVia
	 */
	@Autowired @Qualifier("TipoViaBean")
	protected TipoViaBO mainBean;

	/** Bean para acceder a los métodos de negocio: TipoVia
	 */
	protected TipoViaBO getMainBean() {
		return this.mainBean;
	}



/*
	Finders para relaciones
*/


	/**
	 * Prueba la búsqueda findByCodigoCatastro
	 * @throws GenericBusinessException
	 */
    public void findByCodigoCatastroTest() throws GenericBusinessException {
		java.lang.String codigo = TestUtil.newString();
        this.getMainBean().findByCodigoCatastro(codigo);
    }

	/**
	 * Rellena una instancia de TipoVia aleatoriamente
	 */
	protected TipoViaFormVO fillRandomRecord(TipoViaFormVO record, boolean forUpdate) throws GenericBusinessException  {

  
		record.setCodigoCatastro( TestUtil.newString(2) );
  
		record.setNombreEs( TestUtil.newString(64) );
  
		record.setNombreCa( TestUtil.newString(64) );

	return record;
	}

}


