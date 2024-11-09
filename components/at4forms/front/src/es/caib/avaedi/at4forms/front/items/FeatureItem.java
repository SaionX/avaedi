package es.caib.avaedi.at4forms.front.items;

import java.util.HashMap;
import java.util.Map;

public class FeatureItem extends TextItem {

	private String open;
	private Map<String, String> parameters = new HashMap<String, String>();

	public FeatureItem() {
	}

	/**
	 * @return the open
	 */
	public String getOpen() {
		return this.open;
	}

	/**
	 * @param open the open to set
	 */
	public void setOpen(String open) {
		this.open = open;
	}

	public FeatureItem(String title) {
		super(title, false);
	}

	public FeatureItem(String title, String open) {
		super(title, false);
		this.open = open;
	}


	public void addParameter(String field, String value) {
		this.parameters.put(field, value);

	}

	/**
	 * @return the parameters
	 */
	public Map<String, String> getParameters() {
		return this.parameters;
	}

	/**
	 * @param parameters the parameters to set
	 */
	public void setParameters(Map<String, String> parameters) {
		this.parameters = parameters;
	}


}
