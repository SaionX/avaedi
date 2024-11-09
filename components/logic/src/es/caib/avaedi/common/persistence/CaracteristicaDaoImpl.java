package es.caib.avaedi.common.persistence;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import es.caib.avaedi.at4forms.common.basedao.BaseDaoImpl;
import es.caib.avaedi.common.model.Caracteristica;

/**
 * Implementación para el interfaz CaracteristicaDao
 * 
 * @see es.caib.avaedi.common.persistence.CaracteristicaDao
 * @author agarcia
 */
@Repository("CaracteristicaDao")
public class CaracteristicaDaoImpl extends BaseDaoImpl<Caracteristica> implements CaracteristicaDao {

	public CaracteristicaDaoImpl() {
		super(Caracteristica.class);
	}

	public CaracteristicaDaoImpl(SessionFactory sessionFactory) {
		super(Caracteristica.class, sessionFactory);
	}

}
