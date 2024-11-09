package es.caib.avaedi.at4forms.front.items;

import org.directwebremoting.annotations.DataTransferObject;

@DataTransferObject
public class StateDataItem {

	private String name;
	private String value;

	public StateDataItem() {

	}

	public StateDataItem(String nom, String valor) {
		this.name = nom;
		this.value = valor;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the value
	 */
	public String getValue() {
		return this.value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
}