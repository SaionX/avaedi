package es.caib.avaedi.tests.server;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;

import es.caib.avaedi.at4forms.common.exception.GenericBusinessException;
import es.caib.avaedi.at4forms.logic.vo.BaseVO;
import es.caib.avaedi.front.server.service.RestService;

//http://www.vogella.com/tutorials/REST/article.html

public class RestServiceTest extends BaseNonTransactionalTests {

	@Autowired
	protected RestService restService;


	@Before
	public void createDataTest() throws GenericBusinessException {
	}

	@After
	public void deleteDataTest() throws GenericBusinessException {
	}


	protected BaseVO fillResumenAudit(BaseVO record) {
		Date now = new Date();
		record.setDateCreation(now);
		record.setLastModified(now);
		record.setModUser("TestUSER");
		record.setCreatorUser("TestUSER");
		return record;
	}

}
