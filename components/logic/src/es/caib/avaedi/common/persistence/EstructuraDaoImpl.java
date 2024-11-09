package es.caib.avaedi.common.persistence;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import es.caib.avaedi.at4forms.common.basedao.BaseDaoImpl;
import es.caib.avaedi.common.model.Estructura;

/**
 * Implementación para el interfaz EstructuraDao
 * 
 * @see es.caib.avaedi.common.persistence.EstructuraDao
 * @author agarcia
 */
@Repository("EstructuraDao")
public class EstructuraDaoImpl extends BaseDaoImpl<Estructura> implements EstructuraDao {

	public EstructuraDaoImpl() {
		super(Estructura.class);
	}

	public EstructuraDaoImpl(SessionFactory sessionFactory) {
		super(Estructura.class, sessionFactory);
	}

}
