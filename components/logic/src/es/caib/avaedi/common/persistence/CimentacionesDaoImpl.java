package es.caib.avaedi.common.persistence;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import es.caib.avaedi.at4forms.common.basedao.BaseDaoImpl;
import es.caib.avaedi.common.model.Cimentaciones;

/**
 * Implementación para el interfaz CimentacionesDao
 * 
 * @see es.caib.avaedi.common.persistence.CimentacionesDao
 * @author agarcia
 */
@Repository("CimentacionesDao")
public class CimentacionesDaoImpl extends BaseDaoImpl<Cimentaciones> implements CimentacionesDao {

	public CimentacionesDaoImpl() {
		super(Cimentaciones.class);
	}

	public CimentacionesDaoImpl(SessionFactory sessionFactory) {
		super(Cimentaciones.class, sessionFactory);
	}

}
