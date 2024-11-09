package es.caib.avaedi.at4forms.common.realm;

import java.io.Serializable;
import java.security.Principal;
import java.util.Collection;
import java.util.HashSet;

/**
 * Principal - a simple, serializable Principal.
 *
 */
public class SimplePrincipal implements Principal, Serializable
{
	/**
	 *
	 */
	private static final long serialVersionUID = 8927061962407520718L;
	private String _name;
	private Collection<String> _roles = new HashSet<String>();

	SimplePrincipal(String name, Collection<String> roles) {
		this._name = name;
		this._roles = roles;
	}

	/**
	 * Returns the name of this principal.
	 *
	 * @return the name of this principal.
	 */
	public String getName() {
		return this._name;
	}

	public void addRole(String rolename) {
		this._roles.add(rolename);
	}
	
	public boolean isInRole(String rolename)
	{
		return ((this._roles != null) && this._roles.contains(rolename));
	}

	/**
	 * Compares this principal to the specified object.
	 *
	 * @param obj object to compare with.
	 *
	 * @return true if the object passed in is a SimplePrincipal with the same name.
	 */
	public boolean equals(Object o)
	{
		return (o instanceof Principal)
		&& this._name.equals(((Principal)o).getName());
	}

	/**
	 * Returns a string representation of this principal.
	 *
	 * @return a string representation of this principal.
	 */
	public String toString() {
		return "Principal[name = \'" + this._name + "\']";
	}

	/**
	 * Returns a hashcode for this principal.
	 *
	 * @return a hashcode for this principal.
	 */
	public int hashCode() {
		return this._name.hashCode();
	}
}

