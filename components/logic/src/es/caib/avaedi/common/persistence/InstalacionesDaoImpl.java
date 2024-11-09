package es.caib.avaedi.common.persistence;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import es.caib.avaedi.at4forms.common.basedao.BaseDaoImpl;
import es.caib.avaedi.common.model.Instalaciones;

/**
 * Implementación para el interfaz InstalacionesDao
 * 
 * @see es.caib.avaedi.common.persistence.InstalacionesDao
 * @author agarcia
 */
@Repository("InstalacionesDao")
public class InstalacionesDaoImpl extends BaseDaoImpl<Instalaciones> implements InstalacionesDao {

	public InstalacionesDaoImpl() {
		super(Instalaciones.class);
	}

	public InstalacionesDaoImpl(SessionFactory sessionFactory) {
		super(Instalaciones.class, sessionFactory);
	}

}
