package es.caib.avaedi.at4forms.tests;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import org.slf4j.Logger;

import es.caib.avaedi.at4forms.common.exception.GenericBusinessException;
import es.caib.avaedi.at4forms.common.search.FilterConfig;
import es.caib.avaedi.at4forms.common.search.PagingConfig;
import es.caib.avaedi.at4forms.common.search.ResultadoBusqueda;
import es.caib.avaedi.at4forms.common.util.log.LogService;
import es.caib.avaedi.at4forms.logic.bo.BaseBO;
import es.caib.avaedi.at4forms.logic.vo.FormVO;
import es.caib.avaedi.at4forms.logic.vo.ListadoVO;


/**
 * Clase base sobre la que construir los beans de negocio.
 *
 * @author agarcia
 *
 */
@Transactional (rollbackFor = GenericBusinessException.class)
public abstract class BaseBeanTests<FO extends FormVO, B extends BaseBO<? extends ListadoVO, FO>> extends BaseTests {

	/**
	 * El objeto logger
	 */
	protected static final Logger log = LogService.getLogger(BaseBeanTests.class);
	
	public BaseBeanTests() {
    }

	protected abstract BaseBO<? extends ListadoVO, FO> getMainBean();
	protected abstract FO fillRandomRecord(FO record, boolean forUpdate) throws GenericBusinessException;
	
	/* ************************** Testeamos los métodos del acceso al modelo ************************************ */

	@Test
	public void crudTest() throws GenericBusinessException {

		Collection<FilterConfig> filters = new ArrayList<FilterConfig>();
		PagingConfig pagingConfig = new PagingConfig();
		pagingConfig.setLimit(10);
		
		ResultadoBusqueda<?> startingResult = this.getMainBean().getListado(filters, pagingConfig);
		
		FO record = this.fillNewRecord();
		FO addedRecord = this.getMainBean().add(record);
		
		Assert.assertNotNull("Parece que no se ha añadido un registro correctamente", this.getMainBean().load(addedRecord.getPrimaryKey()));
		ResultadoBusqueda<?> addedResult = this.getMainBean().getListado(filters, pagingConfig);
		
		//Comprobamos que la entidad añadida tiene PK
		Assert.assertNotNull("PK es null", addedRecord.getPrimaryKey());
		Assert.assertNotNull("Label es null", addedRecord.getPrimaryLabel());

		//Comprobamos que se ha añadido un registro
		Assert.assertEquals("Parece que no se ha añadido un registro correctamente", startingResult.getTotalNumRecords() + 1, addedResult.getTotalNumRecords());

		FO loadedAddedRecord = this.getMainBean().load( addedRecord.getPrimaryKey());
		Assert.assertEquals("El registro añadido no compara equals al de base de datos", addedRecord.getPrimaryKey(), loadedAddedRecord.getPrimaryKey());
		Assert.assertEquals("El registro añadido no compara equals al de base de datos", addedRecord.getPrimaryLabel(), loadedAddedRecord.getPrimaryLabel());

		FO changedRecord = this.changeRecord(loadedAddedRecord);
		FO updated = this.getMainBean().update(changedRecord.getPrimaryKey(), changedRecord);
		Assert.assertNotEquals("El registro actualizado no debería ser igual", addedRecord.getLastModified().getTime(), updated.getLastModified().getTime() );

		Assert.assertTrue( "Delete devolvió false", this.getMainBean().delete( updated.getPrimaryKey() ));
		
		ResultadoBusqueda<?> deletedResult = this.getMainBean().getListado(filters, pagingConfig);
		
		//Comprobamos que se ha eliminado un registro
		Assert.assertEquals("Parece que no se ha eliminado un registro correctamente", startingResult.getTotalNumRecords(), deletedResult.getTotalNumRecords());
		Assert.assertNull("Parece que no se ha eliminado un registro correctamente", this.getMainBean().load(updated.getPrimaryKey()));

	}

	private FO fillNewRecord() throws GenericBusinessException {
		FO record = this.getMainBean().newModel();
		Date ahora = new Date();
		record.setDateCreation(ahora);
		record.setLastModified(ahora);
		record.setCreatorUser("testrunner");
		record.setModUser("testrunner");
		return this.fillRandomRecord(record, false);
	}
	
	private FO changeRecord(FO record) throws GenericBusinessException {
		Date ahora = new Date();
		record.setLastModified(ahora);
		record.setModUser("testrunner");
		return this.fillRandomRecord(record, true);
	}


}
