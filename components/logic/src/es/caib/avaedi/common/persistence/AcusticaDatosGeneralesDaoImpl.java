package es.caib.avaedi.common.persistence;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import es.caib.avaedi.at4forms.common.basedao.BaseDaoImpl;
import es.caib.avaedi.common.model.AcusticaDatosGenerales;

/**
 * Implementación para el interfaz AcusticaDatosGeneralesDao
 * 
 * @see es.caib.avaedi.common.persistence.AcusticaDatosGeneralesDao
 * @author agarcia
 */
@Repository("AcusticaDatosGeneralesDao")
public class AcusticaDatosGeneralesDaoImpl extends BaseDaoImpl<AcusticaDatosGenerales> implements AcusticaDatosGeneralesDao {

	public AcusticaDatosGeneralesDaoImpl() {
		super(AcusticaDatosGenerales.class);
	}

	public AcusticaDatosGeneralesDaoImpl(SessionFactory sessionFactory) {
		super(AcusticaDatosGenerales.class, sessionFactory);
	}

}
