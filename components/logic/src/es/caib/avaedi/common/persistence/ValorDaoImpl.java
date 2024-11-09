package es.caib.avaedi.common.persistence;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import es.caib.avaedi.at4forms.common.basedao.BaseDaoImpl;
import es.caib.avaedi.at4forms.common.exception.DaoException;
import es.caib.avaedi.common.model.Valor;

/**
 * Implementación para el interfaz ValorDao
 * 
 * @see es.caib.avaedi.common.persistence.ValorDao
 * @author agarcia
 */
@Repository("ValorDao")
public class ValorDaoImpl extends BaseDaoImpl<Valor> implements ValorDao {

	public ValorDaoImpl() {
		super(Valor.class);
	}

	public ValorDaoImpl(SessionFactory sessionFactory) {
		super(Valor.class, sessionFactory);
	}

	/* (non-Javadoc)
	 * @see es.caib.avaedi.common.persistence.ValorDao#findBy
	 */
	@Override
    public Valor findByCarId(String caracteristica, int valId) throws DaoException  {
        Query query = getNamedQuery("es.caib.avaedi.common.model.Valor.findByCarId");
        query.setParameter("caracteristica", caracteristica);
        query.setParameter("valId", valId);
        return (Valor) query.uniqueResult();
    }

}
