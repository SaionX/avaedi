package es.caib.avaedi.common.persistence;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import es.caib.avaedi.at4forms.common.basedao.BaseDaoImpl;
import es.caib.avaedi.common.model.Blob;

/**
 * Implementación para el interfaz BlobDao
 * 
 * @see es.caib.avaedi.common.persistence.BlobDao
 * @author agarcia
 */
@Repository("BlobDao")
public class BlobDaoImpl extends BaseDaoImpl<Blob> implements BlobDao {

	public BlobDaoImpl() {
		super(Blob.class);
	}

	public BlobDaoImpl(SessionFactory sessionFactory) {
		super(Blob.class, sessionFactory);
	}

}
