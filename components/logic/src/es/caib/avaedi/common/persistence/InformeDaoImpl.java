package es.caib.avaedi.common.persistence;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import es.caib.avaedi.at4forms.common.basedao.BaseDaoImpl;
import es.caib.avaedi.common.model.Informe;

/**
 * Implementación para el interfaz InformeDao
 * 
 * @see es.caib.avaedi.common.persistence.InformeDao
 * @author agarcia
 */
@Repository("InformeDao")
public class InformeDaoImpl extends BaseDaoImpl<Informe> implements InformeDao {

	public InformeDaoImpl() {
		super(Informe.class);
	}

	public InformeDaoImpl(SessionFactory sessionFactory) {
		super(Informe.class, sessionFactory);
	}

}
