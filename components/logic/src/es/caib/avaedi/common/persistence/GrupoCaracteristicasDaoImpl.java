package es.caib.avaedi.common.persistence;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import es.caib.avaedi.at4forms.common.basedao.BaseDaoImpl;
import es.caib.avaedi.common.model.GrupoCaracteristicas;

/**
 * Implementación para el interfaz GrupoCaracteristicasDao
 * 
 * @see es.caib.avaedi.common.persistence.GrupoCaracteristicasDao
 * @author agarcia
 */
@Repository("GrupoCaracteristicasDao")
public class GrupoCaracteristicasDaoImpl extends BaseDaoImpl<GrupoCaracteristicas> implements GrupoCaracteristicasDao {

	public GrupoCaracteristicasDaoImpl() {
		super(GrupoCaracteristicas.class);
	}

	public GrupoCaracteristicasDaoImpl(SessionFactory sessionFactory) {
		super(GrupoCaracteristicas.class, sessionFactory);
	}

}
