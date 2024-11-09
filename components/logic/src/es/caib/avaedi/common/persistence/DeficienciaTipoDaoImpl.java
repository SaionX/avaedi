package es.caib.avaedi.common.persistence;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import es.caib.avaedi.at4forms.common.basedao.BaseDaoImpl;
import es.caib.avaedi.common.model.DeficienciaTipo;

/**
 * Implementación para el interfaz DeficienciaTipoDao
 * 
 * @see es.caib.avaedi.common.persistence.DeficienciaTipoDao
 * @author agarcia
 */
@Repository("DeficienciaTipoDao")
public class DeficienciaTipoDaoImpl extends BaseDaoImpl<DeficienciaTipo> implements DeficienciaTipoDao {

	public DeficienciaTipoDaoImpl() {
		super(DeficienciaTipo.class);
	}

	public DeficienciaTipoDaoImpl(SessionFactory sessionFactory) {
		super(DeficienciaTipo.class, sessionFactory);
	}

}
