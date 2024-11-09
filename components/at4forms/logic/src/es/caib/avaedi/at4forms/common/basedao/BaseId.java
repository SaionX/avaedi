package es.caib.avaedi.at4forms.common.basedao;

import javax.persistence.Transient;

/**
 * POJO de base con los métodos comunes a todas las clases de modelo
 * @author agarcia
 *
 */
public class BaseId {

    /**
     * Sinónimo de toString, necesario para exponer el valor toString como propiedad 
     * @return String
     */
    @Transient
     public String getAsString() {

   	  return this.toString();

     }


	
}
