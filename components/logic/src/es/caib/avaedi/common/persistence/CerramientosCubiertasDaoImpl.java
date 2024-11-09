package es.caib.avaedi.common.persistence;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import es.caib.avaedi.at4forms.common.basedao.BaseDaoImpl;
import es.caib.avaedi.common.model.CerramientosCubiertas;

/**
 * Implementación para el interfaz CerramientosCubiertasDao
 * 
 * @see es.caib.avaedi.common.persistence.CerramientosCubiertasDao
 * @author agarcia
 */
@Repository("CerramientosCubiertasDao")
public class CerramientosCubiertasDaoImpl extends BaseDaoImpl<CerramientosCubiertas> implements CerramientosCubiertasDao {

	public CerramientosCubiertasDaoImpl() {
		super(CerramientosCubiertas.class);
	}

	public CerramientosCubiertasDaoImpl(SessionFactory sessionFactory) {
		super(CerramientosCubiertas.class, sessionFactory);
	}

}
