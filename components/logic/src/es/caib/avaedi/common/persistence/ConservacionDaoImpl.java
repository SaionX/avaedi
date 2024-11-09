package es.caib.avaedi.common.persistence;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import es.caib.avaedi.at4forms.common.basedao.BaseDaoImpl;
import es.caib.avaedi.common.model.Conservacion;

/**
 * Implementación para el interfaz ConservacionDao
 * 
 * @see es.caib.avaedi.common.persistence.ConservacionDao
 * @author agarcia
 */
@Repository("ConservacionDao")
public class ConservacionDaoImpl extends BaseDaoImpl<Conservacion> implements ConservacionDao {

	public ConservacionDaoImpl() {
		super(Conservacion.class);
	}

	public ConservacionDaoImpl(SessionFactory sessionFactory) {
		super(Conservacion.class, sessionFactory);
	}

}
