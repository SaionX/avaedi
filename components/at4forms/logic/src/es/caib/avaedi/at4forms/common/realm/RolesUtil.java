/*
 * MakeGlPermsLevel.java
 *
 * Created on 25 de febrero de 2002, 18:56
 */

package es.caib.avaedi.at4forms.common.realm;



/**
 * Clase de utilidades para manejo de roles
 * @author  agarcia
 */

public class RolesUtil  {

    /**
	 *
	 */
	private static final long serialVersionUID = 5848353484938642008L;


    /**
     * Parte la cadena de permisos en un array
     * @param perms
     * @return el array de permisos
     */
    public static String[] permsStringToArray (String perms){
        //Construimos la tabla de pesos
        if (perms != null) {
	        return perms.split(" ");
        } else {
        	return new String[0];
        }
    }

}
