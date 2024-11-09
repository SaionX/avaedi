/**
 *
 */
package es.caib.avaedi.at4forms.front.items;

import java.util.List;
import java.util.Vector;

import org.directwebremoting.annotations.DataTransferObject;

/**
 * @author agarcia
 *
 */
@DataTransferObject
public class MenuItem {

	private String id;
	private String text;
	private String href;
    private List<TextItem> items = new Vector<TextItem>();
	private String iconCls;

	public MenuItem(String text) {
		this.text = text;
	}

	public MenuItem(String text, String href) {
		this.text = text;
		this.href = href;
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
	 * @return the items
	 */
	public List<TextItem> getItems() {
		return this.items;
	}

	/**
	 * @param items the items to set
	 */
	public void setItems(List<TextItem> items) {
		this.items = items;
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

	/** Devuelve la lista de items como una lista de menús */
	public List<MenuItem> getItemsAsMenus() {
		Vector<MenuItem> menus = new Vector<MenuItem>();
		java.util.Iterator<TextItem> ite = this.getItems().iterator();
		while (ite.hasNext()) {
			TextItem item = ite.next();
			MenuItem menu = new MenuItem(item.getText());
			menu.setIconCls(item.getIconCls());
			if (item.getMenu() != null) {
				menu.setItems(item.getMenu().getItems());
			}
			menus.add(menu);
		}
		return menus;
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
