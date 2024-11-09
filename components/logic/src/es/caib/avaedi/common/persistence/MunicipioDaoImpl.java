package es.caib.avaedi.common.persistence;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import es.caib.avaedi.at4forms.common.basedao.BaseDaoImpl;
import es.caib.avaedi.at4forms.common.exception.DaoException;
import es.caib.avaedi.common.model.Municipio;

/**
 * Implementación para el interfaz MunicipioDao
 * 
 * @see es.caib.avaedi.common.persistence.MunicipioDao
 * @author agarcia
 */
@Repository("MunicipioDao")
public class MunicipioDaoImpl extends BaseDaoImpl<Municipio> implements MunicipioDao {

	public MunicipioDaoImpl() {
		super(Municipio.class);
	}

	public MunicipioDaoImpl(SessionFactory sessionFactory) {
		super(Municipio.class, sessionFactory);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.caib.avaedi.common.persistence.MunicipioDao#findByNombre
	 */
	public Municipio findByNombre(String nombre) throws DaoException {
		Query query = getNamedQuery("es.caib.avaedi.common.model.Municipio.findByNombre");
		query.setParameter("nombre", nombre);
		return (Municipio) query.uniqueResult();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.caib.avaedi.common.persistence.MunicipioDao#findByCodigoCatastro
	 */
	public Municipio findByCodigoCatastro(int codigoCatastro) throws DaoException {
		Query query = getNamedQuery("es.caib.avaedi.common.model.Municipio.findByCodigoCatastro");
		query.setParameter("codigoCatastro", codigoCatastro);
		return (Municipio) query.uniqueResult();
	}

}
