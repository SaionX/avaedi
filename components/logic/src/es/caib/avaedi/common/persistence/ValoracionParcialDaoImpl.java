package es.caib.avaedi.common.persistence;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import es.caib.avaedi.at4forms.common.basedao.BaseDaoImpl;
import es.caib.avaedi.common.model.ValoracionParcial;

/**
 * Implementación para el interfaz ValoracionParcialDao
 * 
 * @see es.caib.avaedi.common.persistence.ValoracionParcialDao
 * @author agarcia
 */
@Repository("ValoracionParcialDao")
public class ValoracionParcialDaoImpl extends BaseDaoImpl<ValoracionParcial> implements ValoracionParcialDao {

	public ValoracionParcialDaoImpl() {
		super(ValoracionParcial.class);
	}

	public ValoracionParcialDaoImpl(SessionFactory sessionFactory) {
		super(ValoracionParcial.class, sessionFactory);
	}

}
