/**
 *
 */
package es.caib.avaedi.at4forms.front.items;

import org.directwebremoting.annotations.DataTransferObject;

/**
 * @author agarcia
 *
 */
@DataTransferObject
public class TextItem {

	private String id;
	private String text;
	private String href;
	private boolean link = false;
    private MenuItem menu;
	private String iconCls;

	public TextItem() {}

	public TextItem(String text) {
		this.text = text;
	}

	public TextItem(String text, String href) {
		this.text = text;
		this.href = href;
	}

	public TextItem(String text, String href, boolean isLink) {
		this.text = text;
		this.href = href;
		this.link = isLink;
	}

	public TextItem(String text, MenuItem menu) {
		this.text = text;
		this.menu = menu;
	}

	public TextItem(String text, boolean isLink) {
		this.text = text;
		this.link = isLink;
	}

	public TextItem(String text, String icon, MenuItem menu) {
		this.text = text;
		this.menu = menu;
		this.iconCls = icon;
	}

	/**
	 * @return the isLink
	 */
	public boolean isLink() {
		return this.link;
	}

	/**
	 * @param isLink the isLink to set
	 */
	public void setLink(boolean isLink) {
		this.link = isLink;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return this.id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the href
	 */
	public String getHref() {
		return this.href;
	}

	/**
	 * @param href the href to set
	 */
	public void setHref(String href) {
		this.href = href;
	}


	/**
	 * @return the menu
	 */
	public MenuItem getMenu() {
		return this.menu;
	}

	/**
	 * @param menu the menu to set
	 */
	public void setMenu(MenuItem menu) {
		this.menu = menu;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return this.text;
	}
	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
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
