package es.caib.avaedi.common.persistence;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import es.caib.avaedi.at4forms.common.basedao.BaseDaoImpl;
import es.caib.avaedi.common.model.Historico;

/**
 * Implementación para el interfaz HistoricoDao
 * 
 * @see es.caib.avaedi.common.persistence.HistoricoDao
 * @author agarcia
 */
@Repository("HistoricoDao")
public class HistoricoDaoImpl extends BaseDaoImpl<Historico> implements HistoricoDao {

	public HistoricoDaoImpl() {
		super(Historico.class);
	}

	public HistoricoDaoImpl(SessionFactory sessionFactory) {
		super(Historico.class, sessionFactory);
	}

}
