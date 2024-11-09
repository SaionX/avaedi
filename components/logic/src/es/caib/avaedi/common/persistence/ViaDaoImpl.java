package es.caib.avaedi.common.persistence;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import es.caib.avaedi.at4forms.common.basedao.BaseDaoImpl;
import es.caib.avaedi.at4forms.common.exception.DaoException;
import es.caib.avaedi.common.model.Via;

/**
 * Implementación para el interfaz ViaDao
 * 
 * @see es.caib.avaedi.common.persistence.ViaDao
 * @author agarcia
 */
@Repository("ViaDao")
public class ViaDaoImpl extends BaseDaoImpl<Via> implements ViaDao {

	public ViaDaoImpl() {
		super(Via.class);
	}

	public ViaDaoImpl(SessionFactory sessionFactory) {
		super(Via.class, sessionFactory);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.caib.avaedi.common.persistence.ViaDao#findViaDeMunicipio
	 */
	public Via findViaDeMunicipio(int codigo, int municipioId) throws DaoException {
		Query query = getNamedQuery("es.caib.avaedi.common.model.Via.findViaDeMunicipio");
		query.setParameter("codigo", codigo);
		query.setParameter("municipioId", municipioId);
		return (Via) query.uniqueResult();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.caib.avaedi.common.persistence.ViaDao#findByCodigoCatastro
	 */
	public Via findByCodigoCatastro(int codigo, int municipio) throws DaoException {
		Query query = getNamedQuery("es.caib.avaedi.common.model.Via.findByCodigoCatastro");
		query.setParameter("codigo", codigo);
		query.setParameter("municipio", municipio);
		return (Via) query.uniqueResult();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.caib.avaedi.common.persistence.ViaDao#findViaDuplicada
	 */
	public Via findViaDuplicada(String nombre, int municipioId, int tipoViaId) throws DaoException {
		Query query = getNamedQuery("es.caib.avaedi.common.model.Via.findViaDuplicada");
		query.setParameter("nombre", nombre);
		query.setParameter("municipioId", municipioId);
		query.setParameter("tipoViaId", tipoViaId);
		return (Via) query.uniqueResult();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.caib.avaedi.common.persistence.ViaDao#findViaDeMunicipioNombre
	 */
	public Via findViaDeMunicipioNombre(String nombre, int municipioId) throws DaoException {
		Query query = getNamedQuery("es.caib.avaedi.common.model.Via.findViaDeMunicipioNombre");
		query.setParameter("nombre", nombre);
		query.setParameter("municipioId", municipioId);
		return (Via) query.uniqueResult();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see es.caib.avaedi.common.persistence.ViaDao#findByNombre
	 */
	public Via findByNombre(String nombre) throws DaoException {
		Query query = getNamedQuery("es.caib.avaedi.common.model.Via.findByNombre");
		query.setParameter("nombre", nombre);
		return (Via) query.uniqueResult();
	}

}
