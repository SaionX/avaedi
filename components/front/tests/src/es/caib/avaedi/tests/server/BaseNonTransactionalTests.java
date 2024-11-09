package es.caib.avaedi.tests.server;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( locations = {"file:components/front/httpdocs/WEB-INF/applicationContext.xml", "file:components/front/httpdocs/WEB-INF/tomcat-runtimeContext.xml"})
@ActiveProfiles("tests")
public class BaseNonTransactionalTests extends AbstractJUnit4SpringContextTests  {

	@Test
	public void firstTrueTest() {
		Assert.assertTrue(true);
	} 
	
}

