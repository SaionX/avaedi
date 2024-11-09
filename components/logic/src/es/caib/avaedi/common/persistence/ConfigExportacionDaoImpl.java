package es.caib.avaedi.common.persistence;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import es.caib.avaedi.at4forms.common.basedao.BaseDaoImpl;
import es.caib.avaedi.at4forms.common.exception.DaoException;
import es.caib.avaedi.common.model.ConfigExportacion;

/**
 * Implementación para el interfaz ConfigExportacionDao
 * 
 * @see es.caib.avaedi.common.persistence.ConfigExportacionDao
 * @author agarcia
 */
@Repository("ConfigExportacionDao")
public class ConfigExportacionDaoImpl extends BaseDaoImpl<ConfigExportacion> implements ConfigExportacionDao {

	public ConfigExportacionDaoImpl() {
		super(ConfigExportacion.class);
	}

	public ConfigExportacionDaoImpl(SessionFactory sessionFactory) {
		super(ConfigExportacion.class, sessionFactory);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.caib.avaedi.common.persistence.ConfigExportacionDao#findByEtiqueta
	 */
	public ConfigExportacion findByEtiqueta(String etiqueta, String nombre, String usuario) throws DaoException {
		Query query = getNamedQuery("es.caib.avaedi.common.model.ConfigExportacion.findByEtiqueta");
		query.setParameter("etiqueta", etiqueta);
		query.setParameter("nombre", nombre);
		query.setParameter("usuario", usuario);
		return (ConfigExportacion) query.uniqueResult();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.caib.avaedi.common.persistence.ConfigExportacionDao#searchAvailables
	 */
	@SuppressWarnings("unchecked")
	public List<ConfigExportacion> searchAvailables(String nombre, String usuario) throws DaoException {
		Query query = getNamedQuery("es.caib.avaedi.common.model.ConfigExportacion.searchAvailables");
		query.setParameter("nombre", nombre);
		query.setParameter("usuario", usuario);
		return (List<ConfigExportacion>) query.list();
	}

}
