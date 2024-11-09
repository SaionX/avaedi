package es.caib.avaedi.common.persistence;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import es.caib.avaedi.at4forms.common.basedao.BaseDaoImpl;
import es.caib.avaedi.common.model.Acusticas;

/**
 * Implementación para el interfaz AcusticasDao
 * 
 * @see es.caib.avaedi.common.persistence.AcusticasDao
 * @author agarcia
 */
@Repository("AcusticasDao")
public class AcusticasDaoImpl extends BaseDaoImpl<Acusticas> implements AcusticasDao {

	public AcusticasDaoImpl() {
		super(Acusticas.class);
	}

	public AcusticasDaoImpl(SessionFactory sessionFactory) {
		super(Acusticas.class, sessionFactory);
	}

}
