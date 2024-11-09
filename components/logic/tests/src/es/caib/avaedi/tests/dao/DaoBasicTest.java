package es.caib.avaedi.tests.dao;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import es.caib.avaedi.at4forms.tests.BaseTests;
import es.caib.avaedi.common.model.Usuario;
import es.caib.avaedi.common.persistence.UsuarioDao;

@Transactional
public class DaoBasicTest extends BaseTests {

	/**
	 * Bean para acceder a los métodos de negocio: TipoActividad
	 */
	@Autowired
	@Qualifier("UsuarioDao")
	protected UsuarioDao UsuarioDao;

	@Test
	public void firstDaoTest() throws Exception {

		Usuario entity = new Usuario();

		Date ahora = new Date();
		entity.setCreatorUser("testrunner");
		entity.setModUser("testrunner");
		entity.setDateCreation(ahora);
		entity.setLastModified(ahora);

		entity.setUsername("testat4");
		entity.setIdioma("CA");

		this.UsuarioDao.add(entity);

	}

	@Test
	public void firstTrueTest() {
		Assert.assertTrue(true);
	}

}
