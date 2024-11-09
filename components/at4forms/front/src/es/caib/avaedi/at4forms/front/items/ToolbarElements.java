/**
 * Contenido de la barra de elementos
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
public class ToolbarElements {
	
	List<TextItem> menus = new Vector<TextItem>();
	List<MenuItem> icons = new Vector<MenuItem>();

	public ToolbarElements() {
	}

	public ToolbarElements(List<TextItem> menus, List<MenuItem> icons) {
		super();
		this.menus = menus;
		this.icons = icons;
	}

	/**
	 * @return the menus
	 */
	public List<TextItem> getMenus() {
		return menus;
	}
	/**
	 * @param menus the menus to set
	 */
	public void setMenus(List<TextItem> menus) {
		this.menus = menus;
	}
	/**
	 * @return the icons
	 */
	public List<MenuItem> getIcons() {
		return icons;
	}
	/**
	 * @param icons the icons to set
	 */
	public void setIcons(List<MenuItem> icons) {
		this.icons = icons;
	}
	
	

}
