package es.caib.avaedi.common.persistence;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import es.caib.avaedi.at4forms.common.basedao.BaseDaoImpl;
import es.caib.avaedi.common.model.EstadoAplicacion;

/**
 * Implementación para el interfaz EstadoAplicacionDao
 * 
 * @see es.caib.avaedi.common.persistence.EstadoAplicacionDao
 * @author agarcia
 */
@Repository("EstadoAplicacionDao")
public class EstadoAplicacionDaoImpl extends BaseDaoImpl<EstadoAplicacion> implements EstadoAplicacionDao {

	public EstadoAplicacionDaoImpl() {
		super(EstadoAplicacion.class);
	}

	public EstadoAplicacionDaoImpl(SessionFactory sessionFactory) {
		super(EstadoAplicacion.class, sessionFactory);
	}

}
