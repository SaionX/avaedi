package es.caib.avaedi.common.persistence;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import es.caib.avaedi.at4forms.common.basedao.BaseDaoImpl;
import es.caib.avaedi.common.model.DocumentacionOtro;

/**
 * Implementación para el interfaz DocumentacionOtroDao
 * 
 * @see es.caib.avaedi.common.persistence.DocumentacionOtroDao
 * @author agarcia
 */
@Repository("DocumentacionOtroDao")
public class DocumentacionOtroDaoImpl extends BaseDaoImpl<DocumentacionOtro> implements DocumentacionOtroDao {

	public DocumentacionOtroDaoImpl() {
		super(DocumentacionOtro.class);
	}

	public DocumentacionOtroDaoImpl(SessionFactory sessionFactory) {
		super(DocumentacionOtro.class, sessionFactory);
	}

}
