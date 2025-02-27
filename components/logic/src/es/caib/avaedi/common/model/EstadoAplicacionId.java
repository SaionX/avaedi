package es.caib.avaedi.common.model;

// Generated 12-sep-2016 10:10:37

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.directwebremoting.annotations.DataTransferObject;

import es.caib.avaedi.at4forms.common.basedao.BaseId;

/**
 * EstadoAplicacionId generated by hbm2java
 */
@Embeddable
@DataTransferObject
public class EstadoAplicacionId extends BaseId implements java.io.Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	private String username;
	private String nombre;

	public EstadoAplicacionId() {
	}

	public EstadoAplicacionId(String username, String nombre) {
		this.username = username;
		this.nombre = nombre;
	}

	@Column(name = "username", nullable = false, length = 32)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "nombre", nullable = false)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * toString
	 * 
	 * @return String
	 */
	public String toString() {
		StringBuffer buffer = new StringBuffer();

		buffer.append(getUsername());
		buffer.append("|");
		buffer.append(getNombre());

		return buffer.toString();
	}

	/**
	 * fromString
	 * 
	 * @return EstadoAplicacionId
	 */
	public static EstadoAplicacionId fromString(String id) {

		EstadoAplicacionId ret = new EstadoAplicacionId();
		String[] codi = id.split("\\|");
		String val;

		val = codi[0];
		ret.setUsername(val);
		val = codi[1];
		ret.setNombre(val);

		return ret;

	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof EstadoAplicacionId))
			return false;
		EstadoAplicacionId castOther = (EstadoAplicacionId) other;

		return ((this.getUsername() == castOther.getUsername()) || (this.getUsername() != null && castOther.getUsername() != null && this.getUsername().equals(castOther.getUsername()))) && ((this.getNombre() == castOther.getNombre()) || (this.getNombre() != null && castOther.getNombre() != null && this.getNombre().equals(castOther.getNombre())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getUsername() == null ? 0 : this.getUsername().hashCode());
		result = 37 * result + (getNombre() == null ? 0 : this.getNombre().hashCode());
		return result;
	}

}
