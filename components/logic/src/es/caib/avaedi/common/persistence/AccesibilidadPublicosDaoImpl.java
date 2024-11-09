package es.caib.avaedi.common.persistence;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import es.caib.avaedi.at4forms.common.basedao.BaseDaoImpl;
import es.caib.avaedi.common.model.AccesibilidadPublicos;

/**
 * Implementación para el interfaz AccesibilidadPublicosDao
 * 
 * @see es.caib.avaedi.common.persistence.AccesibilidadPublicosDao
 * @author agarcia
 */
@Repository("AccesibilidadPublicosDao")
public class AccesibilidadPublicosDaoImpl extends BaseDaoImpl<AccesibilidadPublicos> implements AccesibilidadPublicosDao {

	public AccesibilidadPublicosDaoImpl() {
		super(AccesibilidadPublicos.class);
	}

	public AccesibilidadPublicosDaoImpl(SessionFactory sessionFactory) {
		super(AccesibilidadPublicos.class, sessionFactory);
	}

}
