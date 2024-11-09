package es.caib.avaedi.common.persistence;

import java.util.List;

import es.caib.avaedi.at4forms.common.basedao.BaseDao;
import es.caib.avaedi.at4forms.common.exception.DaoException;
import es.caib.avaedi.common.model.ConfigExportacion;

/**
 * Interfaz DAO para ConfigExportacion.
 * 
 * @see es.caib.avaedi.common.model.ConfigExportacion
 * @author agarcia
 */
public interface ConfigExportacionDao extends BaseDao<ConfigExportacion> {

	/**
	 * Devuelve la instancia de ConfigExportacion que cumple con la búsqueda
	 * 
	 * @param etiqueta
	 * @param nombre
	 * @param usuario
	 * @return la instancia de ConfigExportacion
	 * @throws DaoException
	 */
	public ConfigExportacion findByEtiqueta(String etiqueta, String nombre, String usuario) throws DaoException;

	/**
	 * Devuelve la lista de instancias ConfigExportacion que cumplen con la
	 * búsqueda
	 * 
	 * @param nombre
	 * @param usuario
	 * @return la lista de instancias
	 * @throws DaoException
	 */
	public List<ConfigExportacion> searchAvailables(String nombre, String usuario) throws DaoException;

}
