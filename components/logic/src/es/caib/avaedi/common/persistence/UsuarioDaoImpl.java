package es.caib.avaedi.common.persistence;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import es.caib.avaedi.at4forms.common.basedao.BaseDaoImpl;
import es.caib.avaedi.at4forms.common.exception.DaoException;
import es.caib.avaedi.common.model.Usuario;

/**
 * Implementación para el interfaz UsuarioDao
 * 
 * @see es.caib.avaedi.common.persistence.UsuarioDao
 * @author agarcia
 */
@Repository("UsuarioDao")
public class UsuarioDaoImpl extends BaseDaoImpl<Usuario> implements UsuarioDao {

	public UsuarioDaoImpl() {
		super(Usuario.class);
	}

	public UsuarioDaoImpl(SessionFactory sessionFactory) {
		super(Usuario.class, sessionFactory);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.caib.avaedi.common.persistence.UsuarioDao#findUsuarioByUsername
	 */
	public Usuario findUsuarioByUsername(String username) throws DaoException {
		Query query = getNamedQuery("es.caib.avaedi.common.model.Usuario.findUsuarioByUsername");
		query.setParameter("username", username);
		return (Usuario) query.uniqueResult();
	}

}
