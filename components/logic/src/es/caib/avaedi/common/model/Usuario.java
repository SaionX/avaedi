package es.caib.avaedi.common.model;

// Generated 12-sep-2016 10:10:37

import static javax.persistence.GenerationType.SEQUENCE;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import es.caib.avaedi.at4forms.common.basedao.BaseModel;

/**
 * Usuario con acceso al sistema de gestión
 */
@Entity
@Table(name = "aed_usuario", uniqueConstraints = @UniqueConstraint(columnNames = "username"))
public class Usuario extends BaseModel implements java.io.Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	private int clave;
	private Municipio municipio;
	/**
	 * Nombre de usuario para acceder al sistema
	 */
	private String username;
	/**
	 * Nombre del usuario
	 */
	private String nombre;
	/**
	 * Apellido/s del usuario
	 */
	private String apellidos;
	/**
	 * Idioma inicial de acceso al sistema
	 */
	private String idioma;

	public Usuario() {
	}

	public Usuario(String username, String idioma) {
		this.username = username;
		this.idioma = idioma;
	}

	public Usuario(Municipio municipio, String username, String nombre, String apellidos, String idioma) {
		this.municipio = municipio;
		this.username = username;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.idioma = idioma;
	}

	@SequenceGenerator(name = "generator", sequenceName = "AED_USUARIO_SEQ", allocationSize = 1)
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "generator")
	@Column(name = "clave", unique = true, nullable = false)
	public int getClave() {
		return this.clave;
	}

	public void setClave(int clave) {
		this.clave = clave;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "clave_municipio")
	public Municipio getMunicipio() {
		return this.municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	/**
	 * * Nombre de usuario para acceder al sistema
	 */

	@Column(name = "username", unique = true, nullable = false, length = 16)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * * Nombre del usuario
	 */

	@Column(name = "nombre", length = 50)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * * Apellido/s del usuario
	 */

	@Column(name = "apellidos")
	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * * Idioma inicial de acceso al sistema
	 */

	@Column(name = "idioma", nullable = false, length = 2)
	public String getIdioma() {
		return this.idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	/**
	 * toString
	 * 
	 * @return String
	 */
	public String toString() {
		StringBuffer buffer = new StringBuffer();

		buffer.append(getClass().getName()).append("@").append(Integer.toHexString(hashCode())).append(" [");
		buffer.append("clave").append("='").append(getClave()).append("' ");
		buffer.append("]");

		return buffer.toString();
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof Usuario))
			return false;
		Usuario castOther = (Usuario) other;

		return (this.getClave() == castOther.getClave());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getClave();

		return result;
	}

}
