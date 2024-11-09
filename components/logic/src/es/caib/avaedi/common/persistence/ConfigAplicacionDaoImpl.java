package es.caib.avaedi.common.persistence;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import es.caib.avaedi.at4forms.common.basedao.BaseDaoImpl;
import es.caib.avaedi.at4forms.common.exception.DaoException;
import es.caib.avaedi.common.model.ConfigAplicacion;

/**
 * Implementación para el interfaz ConfigAplicacionDao
 * 
 * @see es.caib.avaedi.common.persistence.ConfigAplicacionDao
 * @author agarcia
 */
@Repository("ConfigAplicacionDao")
public class ConfigAplicacionDaoImpl extends BaseDaoImpl<ConfigAplicacion> implements ConfigAplicacionDao {

	public ConfigAplicacionDaoImpl() {
		super(ConfigAplicacion.class);
	}

	public ConfigAplicacionDaoImpl(SessionFactory sessionFactory) {
		super(ConfigAplicacion.class, sessionFactory);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.caib.avaedi.common.persistence.ConfigAplicacionDao#findByEtiqueta
	 */
	public ConfigAplicacion findByEtiqueta(String etiqueta, String nombre, String usuario) throws DaoException {
		Query query = getNamedQuery("es.caib.avaedi.common.model.ConfigAplicacion.findByEtiqueta");
		query.setParameter("etiqueta", etiqueta);
		query.setParameter("nombre", nombre);
		query.setParameter("usuario", usuario);
		return (ConfigAplicacion) query.uniqueResult();
	}

}
