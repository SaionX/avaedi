package es.caib.avaedi.common.persistence;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import es.caib.avaedi.at4forms.common.basedao.BaseDaoImpl;
import es.caib.avaedi.common.model.FechaVisita;

/**
 * Implementación para el interfaz FechaVisitaDao
 * 
 * @see es.caib.avaedi.common.persistence.FechaVisitaDao
 * @author agarcia
 */
@Repository("FechaVisitaDao")
public class FechaVisitaDaoImpl extends BaseDaoImpl<FechaVisita> implements FechaVisitaDao {

	public FechaVisitaDaoImpl() {
		super(FechaVisita.class);
	}

	public FechaVisitaDaoImpl(SessionFactory sessionFactory) {
		super(FechaVisita.class, sessionFactory);
	}

}
