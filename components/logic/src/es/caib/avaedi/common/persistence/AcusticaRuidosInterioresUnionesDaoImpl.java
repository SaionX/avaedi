package es.caib.avaedi.common.persistence;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import es.caib.avaedi.at4forms.common.basedao.BaseDaoImpl;
import es.caib.avaedi.common.model.AcusticaRuidosInterioresUniones;

/**
 * Implementación para el interfaz AcusticaRuidosInterioresUnionesDao
 * 
 * @see es.caib.avaedi.common.persistence.AcusticaRuidosInterioresUnionesDao
 * @author agarcia
 */
@Repository("AcusticaRuidosInterioresUnionesDao")
public class AcusticaRuidosInterioresUnionesDaoImpl extends BaseDaoImpl<AcusticaRuidosInterioresUniones> implements AcusticaRuidosInterioresUnionesDao {

	public AcusticaRuidosInterioresUnionesDaoImpl() {
		super(AcusticaRuidosInterioresUniones.class);
	}

	public AcusticaRuidosInterioresUnionesDaoImpl(SessionFactory sessionFactory) {
		super(AcusticaRuidosInterioresUniones.class, sessionFactory);
	}

}
