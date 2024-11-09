package es.caib.avaedi.at4forms.front.service.items;

import org.directwebremoting.annotations.DataTransferObject;

/**
 * Describe el filtro para una columna de un grid
 * @author agarcia
 *
 */
@DataTransferObject
public class GridColumnFilter {

	/**
	 * Constante para el tipo de filtro boolean
	 */
	public static final String TYPE_BOOLEAN = "boolean";

	/**
	 * Constante para el tipo de filtro numeric
	 */
	public static final String TYPE_NUMERIC = "numeric";

	/**
	 * Constante para el tipo de filtro string
	 */
	public static final String TYPE_STRING = "string";

	/**
	 * Constante para el tipo de filtro date
	 */
	public static final String TYPE_DATE = "date";

	/**
	 * Constante para el tipo de filtro list
	 */
	public static final String TYPE_LIST = "list";

	/**
	 * Constante para el tipo de filtro multicombo
	 */
	public static final String TYPE_MULTICOMBO = "multicombo";

	/**
	 * Constante para la longitud máxima para mostrar un filtro tipo lista de checkboxes o desplegable
	 */
	public static final int MAX_LIST_LENGTH = 15;

	private String dataIndex;
	private String type;

	public GridColumnFilter(String type) {
		this.type = type;
	}

	/**
	 * Data Index (nombre de la columna)
	 */
	public String getDataIndex() {
		return this.dataIndex;
	}

	public void setDataIndex(String dataIndex) {
		this.dataIndex = dataIndex;
	}

	/**
	 * fija el tipo de filtro para la columna
	 * @param renderer
	 */
	public void setType(String renderer) {
		this.type = renderer;

	}
	/**
	 * tipo de filtro para la columna
	 */
	public String getType() {
		return this.type;
	}

}
