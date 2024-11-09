package es.caib.avaedi.common.persistence;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import es.caib.avaedi.at4forms.common.basedao.BaseDaoImpl;
import es.caib.avaedi.common.model.AcusticaComprobaciones;

/**
 * Implementación para el interfaz AcusticaComprobacionesDao
 * 
 * @see es.caib.avaedi.common.persistence.AcusticaComprobacionesDao
 * @author agarcia
 */
@Repository("AcusticaComprobacionesDao")
public class AcusticaComprobacionesDaoImpl extends BaseDaoImpl<AcusticaComprobaciones> implements AcusticaComprobacionesDao {

	public AcusticaComprobacionesDaoImpl() {
		super(AcusticaComprobaciones.class);
	}

	public AcusticaComprobacionesDaoImpl(SessionFactory sessionFactory) {
		super(AcusticaComprobaciones.class, sessionFactory);
	}

}
