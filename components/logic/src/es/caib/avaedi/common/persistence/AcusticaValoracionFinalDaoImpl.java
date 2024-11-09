package es.caib.avaedi.common.persistence;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import es.caib.avaedi.at4forms.common.basedao.BaseDaoImpl;
import es.caib.avaedi.common.model.AcusticaValoracionFinal;

/**
 * Implementación para el interfaz AcusticaValoracionFinalDao
 * 
 * @see es.caib.avaedi.common.persistence.AcusticaValoracionFinalDao
 * @author agarcia
 */
@Repository("AcusticaValoracionFinalDao")
public class AcusticaValoracionFinalDaoImpl extends BaseDaoImpl<AcusticaValoracionFinal> implements AcusticaValoracionFinalDao {

	public AcusticaValoracionFinalDaoImpl() {
		super(AcusticaValoracionFinal.class);
	}

	public AcusticaValoracionFinalDaoImpl(SessionFactory sessionFactory) {
		super(AcusticaValoracionFinal.class, sessionFactory);
	}

}
