package es.caib.avaedi.common.persistence;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import es.caib.avaedi.at4forms.common.basedao.BaseDaoImpl;
import es.caib.avaedi.common.model.AcusticaRuidosInterioresVerticales;

/**
 * Implementación para el interfaz AcusticaRuidosInterioresVerticalesDao
 * 
 * @see es.caib.avaedi.common.persistence.AcusticaRuidosInterioresVerticalesDao
 * @author agarcia
 */
@Repository("AcusticaRuidosInterioresVerticalesDao")
public class AcusticaRuidosInterioresVerticalesDaoImpl extends BaseDaoImpl<AcusticaRuidosInterioresVerticales> implements AcusticaRuidosInterioresVerticalesDao {

	public AcusticaRuidosInterioresVerticalesDaoImpl() {
		super(AcusticaRuidosInterioresVerticales.class);
	}

	public AcusticaRuidosInterioresVerticalesDaoImpl(SessionFactory sessionFactory) {
		super(AcusticaRuidosInterioresVerticales.class, sessionFactory);
	}

}
