/**
 *
 */
package es.caib.avaedi.at4forms.common.search;

import java.util.HashMap;
import java.util.Map;

import org.directwebremoting.annotations.DataTransferObject;

/** Implementa los filtros para el plugin filtergrid
 * @author agarcia
 *
 */
@DataTransferObject
public class FilterConfig {

	/**
	 * Constante para el filtro de tipo string
	 */
	public static final String TYPE_STRING = "string";

	/**
	 * Constante para el filtro de tipo carácter
	 */
	public static final String TYPE_CHAR = "char";

	/**
	 * Constante para el filtro de tipo list
	 */
	public static final String TYPE_LIST = "list";

	/**
	 * Constante para el filtro de tipo boolean
	 */
	public static final String TYPE_BOOLEAN = "boolean";

	/**
	 * Constante para el filtro de tipo numeric
	 */
	public static final String TYPE_NUMERIC = "numeric";

	/**
	 * Constante para el filtro de tipo date
	 */
	public static final String TYPE_DATE = "date";

	/**
	 * Constante para el filtro de tipo datetime
	 */
	public static final String TYPE_DATETIME = "datetime";

	/**
	 * Constante para el filtro de tipo collection, cuando el campo field sea una colección
	 */
	public static final String TYPE_COLLECTION = "collection";

	/**
	 * Constante para el filtro de tipo automático
	 */
	public static final String TYPE_AUTO = "auto";


	private String type = TYPE_AUTO;
	private String value;
	private String field;
	private String relation;
	private String comparison;
	private String inverseProperty;

	public FilterConfig() {
	}

	public FilterConfig(String type, String field, String comparison, String value) {
		this.type = type;
		this.field = field;
		this.comparison = comparison;
		this.value = value;
	}

	public FilterConfig(String type, String field, String value) {
		this.type = type;
		this.field = field;
		this.value = value;
	}


	public FilterConfig(String type, String field, String comparison, Number value) {
		this(type, field, comparison, String.valueOf(value));
	}

	public FilterConfig(String field, String comparison) {
		this.field = field;
		this.comparison = comparison;
	}

	/** Fija value, type y comparison a partir de un Map conteniendo claves para type, value y comparison
	 *
	 * @param data Map
	 */
	public void setData (Map<String, String> data) {
		if (data.containsKey("type")) {
			this.setType(data.get("type"));
		}
		if (data.containsKey("value")) {
			this.setValue(data.get("value"));
		}
		if (data.containsKey("comparison")) {
			this.setComparison(data.get("comparison"));
		}
	}

	/**
	 * Devuelve un Map conteniendo claves para type, value y comparison
	 * @return mapa con claves type, value y comparison
	 */
	public Map<String, String> getData() {
		Map<String, String> ret = new HashMap<String, String>();

		if (this.getType() != null) {
			ret.put("type", this.getType());
		}
		if (this.getValue() != null) {
			ret.put("value", this.getValue());
		}
		if (this.getComparison() != null) {
			ret.put("comparison", this.getComparison());
		}

		return ret;
	}

	/** devuelve el tipo de filtro
	 * @see #TYPE_BOOLEAN
	 * @see #TYPE_DATE
	 * @see #TYPE_DATETIME
	 * @see #TYPE_LIST
	 * @see #TYPE_NUMERIC
	 * @see #TYPE_STRING
	 * @return el tipo de filtro
	 */
	public String getType() {
		return this.type;
	}
	/** fija el tipo de filtreo
	 * @see #TYPE_BOOLEAN
	 * @see #TYPE_DATE
	 * @see #TYPE_DATETIME
	 * @see #TYPE_LIST
	 * @see #TYPE_NUMERIC
	 * @see #TYPE_STRING
	 * @param type el tipo de filtro
	 */
	public void setType(String type) {
		this.type = type;
	}
	/** devuelve el valor del filtro
	 * @return el valor del filtro
	 */
	public String getValue() {
		return this.value;
	}
	/** Fija el valor del filtro
	 * @param value el valor del filtro a fijar
	 */
	public void setValue(String value) {
		this.value = value;
	}
	/** Devuelve el campo del filtro.  Se pueden indicar múltiples campos usando comas y en tal caso se hace un OR
	 * @return el campo del filtro
	 */
	public String getField() {
		return this.field;
	}
	/** Fija el campo del filtro. Se pueden indicar múltiples campos usando comas y en tal caso se hace un OR
	 * @param field el campo del filtro a fijar
	 */
	public void setField(String field) {
		this.field = field;
	}
	/** Devuelve la comparación del filtro
	 * @return la comparación del filtro
	 * @see CriteriaUtils#COMPARISON_EQUAL
	 * @see CriteriaUtils#COMPARISON_GREAT
	 * @see CriteriaUtils#COMPARISON_LESST
	 * @see CriteriaUtils#COMPARISON_NOTEQ
	 */
	public String getComparison() {
		return this.comparison;
	}
	/** Fija la comparación del filtro
	 * @param comparison la comparación del filtro a fijar
	 * @see CriteriaUtils#COMPARISON_EQUAL
	 * @see CriteriaUtils#COMPARISON_GREAT
	 * @see CriteriaUtils#COMPARISON_LESST
	 * @see CriteriaUtils#COMPARISON_NOTEQ
	 */
	public void setComparison(String comparison) {
		this.comparison = comparison;
	}

	/** Devuelve la relación
	 * @return relation
	 */
	public String getRelation() {
		return this.relation;
	}

	/** Fija la relación
	 * @param relation the relation to set
	 */
	public void setRelation(String relation) {
		this.relation = relation;
	}

	/**
	 * Fija inverseProperty
	 * @param inverseProperty
	 */
	public void setInverseProperty(String inverseProperty) {
		this.inverseProperty = inverseProperty;

	}

	/** Devuelve inverseProperty, indicando la propiedad en el otro extremo de la relación
	 * @return the inverseProperty
	 */
	public String getInverseProperty() {
		return this.inverseProperty;
	}

	/**
	 * Alias para field
	 * @return
	 */
	public String getProperty() {
		return this.getField();
	}
	/** Alias para field
	 */
	public void setProperty(String property) {
		this.setField(property);
	}
	
}
