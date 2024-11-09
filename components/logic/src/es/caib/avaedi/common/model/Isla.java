package es.caib.avaedi.common.model;

// Generated 12-sep-2016 10:10:37

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import es.caib.avaedi.at4forms.common.basedao.BaseModel;

/**
 * Ámbito geográfico del proyecto
 */
@Entity
@Table(name = "aed_isla", uniqueConstraints = @UniqueConstraint(columnNames = "nombre"))
public class Isla extends BaseModel implements java.io.Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	private int id;
	private String nombre;

	public Isla() {
	}

	public Isla(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "nombre", unique = true, nullable = false)
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

		buffer.append(getClass().getName()).append("@").append(Integer.toHexString(hashCode())).append(" [");
		buffer.append("id").append("='").append(getId()).append("' ");
		buffer.append("]");

		return buffer.toString();
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof Isla))
			return false;
		Isla castOther = (Isla) other;

		return (this.getId() == castOther.getId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getId();

		return result;
	}

}
