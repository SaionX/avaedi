package es.caib.avaedi.common.persistence;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import es.caib.avaedi.at4forms.common.basedao.BaseDaoImpl;
import es.caib.avaedi.at4forms.common.exception.DaoException;
import es.caib.avaedi.common.model.TipoVia;

/**
 * Implementación para el interfaz TipoViaDao
 * 
 * @see es.caib.avaedi.common.persistence.TipoViaDao
 * @author agarcia
 */
@Repository("TipoViaDao")
public class TipoViaDaoImpl extends BaseDaoImpl<TipoVia> implements TipoViaDao {

	public TipoViaDaoImpl() {
		super(TipoVia.class);
	}

	public TipoViaDaoImpl(SessionFactory sessionFactory) {
		super(TipoVia.class, sessionFactory);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.caib.avaedi.common.persistence.TipoViaDao#findByCodigoCatastro
	 */
	public TipoVia findByCodigoCatastro(String codigo) throws DaoException {
		Query query = getNamedQuery("es.caib.avaedi.common.model.TipoVia.findByCodigoCatastro");
		query.setParameter("codigo", codigo);
		return (TipoVia) query.uniqueResult();
	}

}
