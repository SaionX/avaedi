package es.caib.avaedi.common.persistence;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import es.caib.avaedi.at4forms.common.basedao.BaseDaoImpl;
import es.caib.avaedi.common.model.EstadoInforme;

/**
 * Implementación para el interfaz EstadoInformeDao
 * 
 * @see es.caib.avaedi.common.persistence.EstadoInformeDao
 * @author agarcia
 */
@Repository("EstadoInformeDao")
public class EstadoInformeDaoImpl extends BaseDaoImpl<EstadoInforme> implements EstadoInformeDao {

	public EstadoInformeDaoImpl() {
		super(EstadoInforme.class);
	}

	public EstadoInformeDaoImpl(SessionFactory sessionFactory) {
		super(EstadoInforme.class, sessionFactory);
	}

}
