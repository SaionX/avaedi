package es.caib.avaedi.common.persistence;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import es.caib.avaedi.at4forms.common.basedao.BaseDaoImpl;
import es.caib.avaedi.common.model.AcusticaMejorasAcusticas;

/**
 * Implementación para el interfaz AcusticaMejorasAcusticasDao
 * 
 * @see es.caib.avaedi.common.persistence.AcusticaMejorasAcusticasDao
 * @author agarcia
 */
@Repository("AcusticaMejorasAcusticasDao")
public class AcusticaMejorasAcusticasDaoImpl extends BaseDaoImpl<AcusticaMejorasAcusticas> implements AcusticaMejorasAcusticasDao {

	public AcusticaMejorasAcusticasDaoImpl() {
		super(AcusticaMejorasAcusticas.class);
	}

	public AcusticaMejorasAcusticasDaoImpl(SessionFactory sessionFactory) {
		super(AcusticaMejorasAcusticas.class, sessionFactory);
	}

}
