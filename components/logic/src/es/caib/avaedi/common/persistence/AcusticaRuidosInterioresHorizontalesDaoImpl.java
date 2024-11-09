package es.caib.avaedi.common.persistence;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import es.caib.avaedi.at4forms.common.basedao.BaseDaoImpl;
import es.caib.avaedi.common.model.AcusticaRuidosInterioresHorizontales;

/**
 * Implementación para el interfaz AcusticaRuidosInterioresHorizontalesDao
 * 
 * @see es.caib.avaedi.common.persistence.AcusticaRuidosInterioresHorizontalesDao
 * @author agarcia
 */
@Repository("AcusticaRuidosInterioresHorizontalesDao")
public class AcusticaRuidosInterioresHorizontalesDaoImpl extends BaseDaoImpl<AcusticaRuidosInterioresHorizontales> implements AcusticaRuidosInterioresHorizontalesDao {

	public AcusticaRuidosInterioresHorizontalesDaoImpl() {
		super(AcusticaRuidosInterioresHorizontales.class);
	}

	public AcusticaRuidosInterioresHorizontalesDaoImpl(SessionFactory sessionFactory) {
		super(AcusticaRuidosInterioresHorizontales.class, sessionFactory);
	}

}
