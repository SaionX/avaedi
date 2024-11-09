package es.caib.avaedi.common.persistence;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import es.caib.avaedi.at4forms.common.basedao.BaseDaoImpl;
import es.caib.avaedi.common.model.Isla;

/**
 * Implementación para el interfaz IslaDao
 * 
 * @see es.caib.avaedi.common.persistence.IslaDao
 * @author agarcia
 */
@Repository("IslaDao")
public class IslaDaoImpl extends BaseDaoImpl<Isla> implements IslaDao {

	public IslaDaoImpl() {
		super(Isla.class);
	}

	public IslaDaoImpl(SessionFactory sessionFactory) {
		super(Isla.class, sessionFactory);
	}

}
