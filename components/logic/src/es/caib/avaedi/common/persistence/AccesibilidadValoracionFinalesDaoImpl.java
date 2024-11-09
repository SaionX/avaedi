package es.caib.avaedi.common.persistence;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import es.caib.avaedi.at4forms.common.basedao.BaseDaoImpl;
import es.caib.avaedi.common.model.AccesibilidadValoracionFinales;

/**
 * Implementación para el interfaz AccesibilidadValoracionFinalesDao
 * 
 * @see es.caib.avaedi.common.persistence.AccesibilidadValoracionFinalesDao
 * @author agarcia
 */
@Repository("AccesibilidadValoracionFinalesDao")
public class AccesibilidadValoracionFinalesDaoImpl extends BaseDaoImpl<AccesibilidadValoracionFinales> implements AccesibilidadValoracionFinalesDao {

	public AccesibilidadValoracionFinalesDaoImpl() {
		super(AccesibilidadValoracionFinales.class);
	}

	public AccesibilidadValoracionFinalesDaoImpl(SessionFactory sessionFactory) {
		super(AccesibilidadValoracionFinales.class, sessionFactory);
	}

}
