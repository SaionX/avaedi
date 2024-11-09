package es.caib.avaedi.common.persistence;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import es.caib.avaedi.at4forms.common.basedao.BaseDaoImpl;
import es.caib.avaedi.common.model.EficienciasEnergeticas;

/**
 * Implementación para el interfaz EficienciasEnergeticasDao
 * 
 * @see es.caib.avaedi.common.persistence.EficienciasEnergeticasDao
 * @author agarcia
 */
@Repository("EficienciasEnergeticasDao")
public class EficienciasEnergeticasDaoImpl extends BaseDaoImpl<EficienciasEnergeticas> implements EficienciasEnergeticasDao {

	public EficienciasEnergeticasDaoImpl() {
		super(EficienciasEnergeticas.class);
	}

	public EficienciasEnergeticasDaoImpl(SessionFactory sessionFactory) {
		super(EficienciasEnergeticas.class, sessionFactory);
	}

}
