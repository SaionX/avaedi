package es.caib.avaedi.common.persistence;

import es.caib.avaedi.at4forms.common.basedao.BaseDao;
import es.caib.avaedi.at4forms.common.exception.DaoException;
import es.caib.avaedi.common.model.Valor;

/**
 * Interfaz DAO para Valor.
 * 
 * @see es.caib.avaedi.common.model.Valor
 * @author agarcia
 */
public interface ValorDao extends BaseDao<Valor> {

	Valor findByCarId(String caracteristica, int valId) throws DaoException;

}
