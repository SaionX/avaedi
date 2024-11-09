 /** Sincronizado con extranet/core/xml/menudefinition.inc versión 1.8 */

/*
 * DoMenuDefinition.java
 *
 * Created on 5 de noviembre de 2001, 22:59
 */

package es.caib.avaedi.at4forms.front.menuDefinition;

/**
 *
 * @author  agarcia
 * @version
 */
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;

import es.caib.avaedi.at4forms.common.exception.GenericBusinessException;
import es.caib.avaedi.at4forms.common.realm.RolesUtil;
import es.caib.avaedi.at4forms.common.util.log.LogService;
import es.caib.avaedi.at4forms.front.menuDefinition.model.Form;
import es.caib.avaedi.at4forms.front.menuDefinition.model.Link;
import es.caib.avaedi.at4forms.front.menuDefinition.model.Menu;
import es.caib.avaedi.at4forms.front.menuDefinition.model.MenuDefinition;
import es.caib.avaedi.front.config.LocalAuthenticationProvider;
import es.caib.avaedi.front.config.LocalUserDetails;




/**
 * Recorre un menú filtrando los permisos
 * @author agarcia
 *
 */
public class DoMenuDefinitionData {

	/**
	 * The logger object.
	 */
	private static Logger log = LogService.getLogger(DoMenuDefinitionData.class);
	private LocalUserDetails user;

	public DoMenuDefinitionData(LocalUserDetails user) {
		this.user = user;
	}


	public MenuDefinition getMenu() throws GenericBusinessException {

		String menudefinitionFile = "resources/menu.xml";

		//LOADING MENUDEFINITION FILE
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		java.io.InputStream menuFileStream = loader.getResourceAsStream(menudefinitionFile);

		MenuDefinition menuDefinition = null;

		//Vamos a leer el menu.xml
		try {
			JAXBContext menuJc = JAXBContext.newInstance("es.caib.avaedi.at4forms.front.menuDefinition.model");
			Unmarshaller menuUnmarshaller = menuJc.createUnmarshaller();

			// unmarshal an instance document into a tree of Java content
            // objects composed of classes from the package.
            JAXBElement<?> menuElement = (JAXBElement<?>)menuUnmarshaller.unmarshal( menuFileStream );
            menuDefinition = (MenuDefinition)menuElement.getValue();

		} catch (JAXBException e) {
			log.error("JAXBException", e);
			throw new GenericBusinessException(e);
		}

    	MenuDefinition menuFinal = new MenuDefinition();
    	Iterator<Object> ite = menuDefinition.getTOOLBAROrLINKOrFORM().iterator();

    	//FrontPrincipal usuario = FrontPrincipal.getInstance(request);

    	/* Creamos el menú final filtrando los permisos */
    	while (ite.hasNext()) {

    		Object nextItem = ite.next();
    		if (Menu.class.isInstance(nextItem)) {
    			//es un menu
    			this.addMenu(menuFinal.getTOOLBAROrLINKOrFORM(), (Menu)nextItem);
			/* toolbar no está implementado, en At4Framework no hay toolbar
    		} else if (Toolbar.class.isInstance(nextItem)) {
    			//es un toolbar
    			this.addToolbar(menuFinal.getTOOLBAROrLINKOrFORM(), (Toolbar)nextItem, usuario);
			*/
    		} else if (Link.class.isInstance(nextItem)) {
    			//es un link
    			this.addLink(menuFinal.getTOOLBAROrLINKOrFORM(), (Link)nextItem);
    		} else if (Form.class.isInstance(nextItem)) {
    			//es un form
    			this.addForm(menuFinal.getTOOLBAROrLINKOrFORM(), (Form)nextItem);
    		}

    	}

    	return menuFinal;

    }


    private void addMenu (List<Object> list, Menu menu) {

		if (this.validateTag(RolesUtil.permsStringToArray(menu.getPERMS()), true)) {

			Iterator<Object> ite = menu.getLINKOrFORMOrMENU().iterator();

			Menu menuFinal = new Menu();
			menuFinal.setTITLE(menu.getTITLE());
			menuFinal.setICON(menu.getICON());
			menuFinal.setCONTEXT(menu.getCONTEXT());
	    	/* Creamos el menú final filtrando los permisos */
	    	while (ite.hasNext()) {

	    		Object nextItem = ite.next();
	    		if (Menu.class.isInstance(nextItem)) {
	    			//es un menu
	    			this.addMenu(menuFinal.getLINKOrFORMOrMENU(), (Menu)nextItem);
	    		} else if (Link.class.isInstance(nextItem)) {
	    			//es un link
	    			this.addLink(menuFinal.getLINKOrFORMOrMENU(), (Link)nextItem);
	    		} else if (Form.class.isInstance(nextItem)) {
	    			//es un form
	    			this.addForm(menuFinal.getLINKOrFORMOrMENU(), (Form)nextItem);
	    		}

	    	}

	    	list.add(menuFinal);
	    	this.permsStack.pop();
		}
    }

    /* toolbar no está implementado, en At4Framework no hay toolbar
    private void addToolbar (List<Object> list, Toolbar nextItem, FrontPrincipal usuario) {
    	//tratar minperms, recorrer subitems, etc
    	list.add(nextItem);
    }
    */

	private void addForm(List<Object> list, Form nextItem) {
		if (this.validateTag(RolesUtil.permsStringToArray(nextItem.getPERMS()), false)) {
			list.add(nextItem);
		}
	}

	private void addLink(List<Object> list, Link nextItem) {

		if (this.validateTag(RolesUtil.permsStringToArray(nextItem.getPERMS()), false)) {
			list.add(nextItem);
		}

	}


	/***** tratamiento de permisos en menús */

	private Stack<String[]> permsStack = new Stack<String[]>();

    private boolean validateTag(String[] permsRequired, boolean isMenu){

    	String requisitosActuales[] = permsRequired;

    	if ((permsRequired.length == 0)) {
            //esto es esquivalente a que perms sea igual a todos los permisos de que disponemos
            if ( !this.permsStack.isEmpty() ) {
            	requisitosActuales = this.permsStack.lastElement();
            }
    	}

    	boolean successfully = false;

    	if (requisitosActuales.length > 0) {
    		for (int i = 0; i < requisitosActuales.length; i++) {
    			//TODO: depurar pq esta primera línea comentada no funciona
    			//if (this.currentRequest.isUserInRole(requisitosActuales[i])) {
    			if (user.isInRole(requisitosActuales[i])) {
    				successfully = true;
    				break;
    			}
    		}
        } else {
        	successfully = true;
        }

        if (successfully && isMenu){
            this.permsStack.push(requisitosActuales);
        }
        return successfully;
    }



}

