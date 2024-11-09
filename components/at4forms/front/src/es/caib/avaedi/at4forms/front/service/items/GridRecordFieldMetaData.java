package es.caib.avaedi.at4forms.front.service.items;

import org.directwebremoting.annotations.DataTransferObject;

/**
 * Describe un campo para un registro extjs
 * @author agarcia
 *
 */
@DataTransferObject
public class GridRecordFieldMetaData {

	/**
	 * Constante para el tipo de campo auto
	 */
	public static final String AUTO_TYPE = "auto";

	/**
	 * Constante para el tipo de campo string
	 */
	public static final String STRING_TYPE = "string";

	/**
	 * Constante para el tipo de campo int
	 */
	public static final String INT_TYPE = "int";

	/**
	 * Constante para el tipo de campo float
	 */
	public static final String FLOAT_TYPE = "float";

	/**
	 * Constante para el tipo de campo boolean
	 */
	public static final String BOOLEAN_TYPE = "boolean";

	/**
	 * Constante para el tipo de campo date
	 */
	public static final String DATE_TYPE = "date";


	private String name;
	private String mapping;
	private String type = STRING_TYPE;
	private String dateFormat = "";

	public GridRecordFieldMetaData(String name, String type) {
		this.name = name;
		this.type = type;
	}

	public GridRecordFieldMetaData(String name, String mapping, String type) {
		this.name = name;
		this.mapping = mapping;
		this.type = type;
	}
	/**
	 * Tipo de campo
	 */
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Nombre del campo
	 */
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * mapping del campo
	 */
	public String getMapping() {
		return this.mapping;
	}

	public void setMapping(String mapping) {
		this.mapping = mapping;
	}

	/**
	 * Formato de fecha
	 */
	public String getDateFormat() {
		return this.dateFormat;
	}

	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}

}
