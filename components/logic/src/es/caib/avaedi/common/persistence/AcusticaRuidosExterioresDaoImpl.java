package es.caib.avaedi.common.persistence;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import es.caib.avaedi.at4forms.common.basedao.BaseDaoImpl;
import es.caib.avaedi.common.model.AcusticaRuidosExteriores;

/**
 * Implementación para el interfaz AcusticaRuidosExterioresDao
 * 
 * @see es.caib.avaedi.common.persistence.AcusticaRuidosExterioresDao
 * @author agarcia
 */
@Repository("AcusticaRuidosExterioresDao")
public class AcusticaRuidosExterioresDaoImpl extends BaseDaoImpl<AcusticaRuidosExteriores> implements AcusticaRuidosExterioresDao {

	public AcusticaRuidosExterioresDaoImpl() {
		super(AcusticaRuidosExteriores.class);
	}

	public AcusticaRuidosExterioresDaoImpl(SessionFactory sessionFactory) {
		super(AcusticaRuidosExteriores.class, sessionFactory);
	}

}
