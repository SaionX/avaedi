package es.caib.avaedi.common.persistence;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import es.caib.avaedi.at4forms.common.basedao.BaseDaoImpl;
import es.caib.avaedi.at4forms.common.exception.DaoException;
import es.caib.avaedi.common.model.Edificio;

/**
 * Implementación para el interfaz EdificioDao
 * 
 * @see es.caib.avaedi.common.persistence.EdificioDao
 * @author agarcia
 */
@Repository("EdificioDao")
public class EdificioDaoImpl extends BaseDaoImpl<Edificio> implements EdificioDao {

	public EdificioDaoImpl() {
		super(Edificio.class);
	}

	public EdificioDaoImpl(SessionFactory sessionFactory) {
		super(Edificio.class, sessionFactory);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.caib.avaedi.common.persistence.EdificioDao#findByCodigoCatastro
	 */
	public Edificio findByCodigoCatastro(String codigoCatastro) throws DaoException {
		Query query = getNamedQuery("es.caib.avaedi.common.model.Edificio.findByCodigoCatastro");
		query.setParameter("codigoCatastro", codigoCatastro);
		return (Edificio) query.uniqueResult();
	}

}
