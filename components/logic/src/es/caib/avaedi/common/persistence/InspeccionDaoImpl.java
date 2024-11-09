package es.caib.avaedi.common.persistence;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import es.caib.avaedi.at4forms.common.basedao.BaseDaoImpl;
import es.caib.avaedi.common.model.Inspeccion;

/**
 * Implementación para el interfaz InspeccionDao
 * 
 * @see es.caib.avaedi.common.persistence.InspeccionDao
 * @author agarcia
 */
@Repository("InspeccionDao")
public class InspeccionDaoImpl extends BaseDaoImpl<Inspeccion> implements InspeccionDao {

	public InspeccionDaoImpl() {
		super(Inspeccion.class);
	}

	public InspeccionDaoImpl(SessionFactory sessionFactory) {
		super(Inspeccion.class, sessionFactory);
	}

}
