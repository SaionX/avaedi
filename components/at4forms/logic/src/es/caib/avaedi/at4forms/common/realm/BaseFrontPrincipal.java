package es.caib.avaedi.at4forms.common.realm;

import java.security.Principal;

/**
 * Principal para la aplicacion front
 * @author agarcia
 */
public interface BaseFrontPrincipal extends Principal {

	public static final String SESSION_ATTRIB_NAME = "FrontPrincipal";

	/**
	 * Devuelve el nombre de este principal
	 * @return el nombre de este principal
	 */
	public String getName();


	/**
	 * Devuelve el username
	 * @return el username
	 */
	public String getUsername();

	/**
	 * isInRole
	 * @param rol
	 * @return
	 */
	public boolean isInRole(String rol);

	/**
	 * Indica si el principal pertenece a alguno de los roles
	 * @param roles
	 * @return
	 */
	public boolean isInAnyRole(String...roles );

}