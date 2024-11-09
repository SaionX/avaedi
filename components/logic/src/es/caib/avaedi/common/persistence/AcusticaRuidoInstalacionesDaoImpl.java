package es.caib.avaedi.common.persistence;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import es.caib.avaedi.at4forms.common.basedao.BaseDaoImpl;
import es.caib.avaedi.common.model.AcusticaRuidoInstalaciones;

/**
 * Implementación para el interfaz AcusticaRuidoInstalacionesDao
 * 
 * @see es.caib.avaedi.common.persistence.AcusticaRuidoInstalacionesDao
 * @author agarcia
 */
@Repository("AcusticaRuidoInstalacionesDao")
public class AcusticaRuidoInstalacionesDaoImpl extends BaseDaoImpl<AcusticaRuidoInstalaciones> implements AcusticaRuidoInstalacionesDao {

	public AcusticaRuidoInstalacionesDaoImpl() {
		super(AcusticaRuidoInstalaciones.class);
	}

	public AcusticaRuidoInstalacionesDaoImpl(SessionFactory sessionFactory) {
		super(AcusticaRuidoInstalaciones.class, sessionFactory);
	}

}
