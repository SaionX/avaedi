package es.caib.avaedi.at4forms.front.items;

import java.util.HashMap;
import java.util.Map;

import org.directwebremoting.annotations.DataTransferObject;

@DataTransferObject
public class FormItem extends TextItem {

	private String form;
	private String mode;
	private String iconCls;
	private Map<String, String> parameters = new HashMap<String, String>();

	public FormItem() {
		
	}

	public FormItem(String title) {
		super(title, false);
	}

	public FormItem(String title, String form, String mode, String iconCls) {
		super(title, false);
		this.form = form;
		this.mode = mode;
		this.iconCls = iconCls;
	}


	/**
	 * @return the mode
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * @param mode the mode to set
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}

	public void addParameter(String field, String value) {
		this.parameters.put(field, value);
		
	}

	/**
	 * @return the parameters
	 */
	public Map<String, String> getParameters() {
		return parameters;
	}

	/**
	 * @param parameters the parameters to set
	 */
	public void setParameters(Map<String, String> parameters) {
		this.parameters = parameters;
	}

	/**
	 * @return the form
	 */
	public String getForm() {
		return form;
	}

	/**
	 * @param form the form to set
	 */
	public void setForm(String form) {
		this.form = form;
	}
	
	/**
	 * @return the iconCls
	 */
	public String getIconCls() {
		return this.iconCls;
	}

	/**
	 * @param iconCls the iconCls to set
	 */
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	
}
