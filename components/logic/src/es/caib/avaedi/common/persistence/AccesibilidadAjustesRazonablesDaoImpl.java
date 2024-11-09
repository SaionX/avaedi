package es.caib.avaedi.common.persistence;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import es.caib.avaedi.at4forms.common.basedao.BaseDaoImpl;
import es.caib.avaedi.common.model.AccesibilidadAjustesRazonables;

/**
 * Implementación para el interfaz AccesibilidadAjustesRazonablesDao
 * 
 * @see es.caib.avaedi.common.persistence.AccesibilidadAjustesRazonablesDao
 * @author agarcia
 */
@Repository("AccesibilidadAjustesRazonablesDao")
public class AccesibilidadAjustesRazonablesDaoImpl extends BaseDaoImpl<AccesibilidadAjustesRazonables> implements AccesibilidadAjustesRazonablesDao {

	public AccesibilidadAjustesRazonablesDaoImpl() {
		super(AccesibilidadAjustesRazonables.class);
	}

	public AccesibilidadAjustesRazonablesDaoImpl(SessionFactory sessionFactory) {
		super(AccesibilidadAjustesRazonables.class, sessionFactory);
	}

}
