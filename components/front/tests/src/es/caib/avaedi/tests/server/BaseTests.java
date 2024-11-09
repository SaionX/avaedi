package es.caib.avaedi.tests.server;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( locations = {"file:components/front/httpdocs/WEB-INF/applicationContext.xml", "file:components/front/httpdocs/WEB-INF/tomcat-runtimeContext.xml"})
@ActiveProfiles("tests")
public class BaseTests extends AbstractTransactionalJUnit4SpringContextTests  {

	@Test
	public void firstTrueTest() {
		Assert.assertTrue(true);
	} 
	
	public void tests () {
		String name = null;
		Map<String, String> abreviat = new HashMap<String, String>();
		abreviat.put("REFERENCIACATASTRALES", "REFCAT");
		abreviat.put("EDIFICIO", "EDI");
		abreviat.put("RUIDOEXTERIOR", "RUIEXT");
		abreviat.put("RUIDOINTERIOR", "RUIINT");
		abreviat.put("VERTICALES", "VERT");
		abreviat.put("HORIZONTALES", "HOR");
		abreviat.put("SUELOFLOTANTE", "SUE_FLOT");
		abreviat.put("ESTRUCTURA", "EST");
		
		for (Entry<String, String> e : abreviat.entrySet()) {
			name = name.replace(e.getKey(), e.getValue());
		}
		
	}
}

