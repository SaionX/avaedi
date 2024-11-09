package es.caib.avaedi.common.persistence;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import es.caib.avaedi.at4forms.common.basedao.BaseDaoImpl;
import es.caib.avaedi.common.model.Deficiencia;

/**
 * Implementación para el interfaz DeficienciaDao
 * 
 * @see es.caib.avaedi.common.persistence.DeficienciaDao
 * @author agarcia
 */
@Repository("DeficienciaDao")
public class DeficienciaDaoImpl extends BaseDaoImpl<Deficiencia> implements DeficienciaDao {

	public DeficienciaDaoImpl() {
		super(Deficiencia.class);
	}

	public DeficienciaDaoImpl(SessionFactory sessionFactory) {
		super(Deficiencia.class, sessionFactory);
	}

}
