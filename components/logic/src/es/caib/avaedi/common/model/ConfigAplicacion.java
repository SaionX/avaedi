package es.caib.avaedi.common.model;

// Generated 12-sep-2016 10:10:37

import static javax.persistence.GenerationType.SEQUENCE;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import es.caib.avaedi.at4forms.common.basedao.BaseModel;

/**
 * Almacena los estados (extjs) de la aplicación que un usuario ha guardado
 */
@Entity
@Table(name = "aed_config_aplicacion", uniqueConstraints = @UniqueConstraint(columnNames = { "etiqueta", "username", "nombre" }))
public class ConfigAplicacion extends BaseModel implements java.io.Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	private int clave;
	/**
	 * Nombre que el usuario le da al estado
	 */
	private String etiqueta;
	private String username;
	private String nombre;
	private String valor;

	public ConfigAplicacion() {
	}

	public ConfigAplicacion(String username, String nombre) {
		this.username = username;
		this.nombre = nombre;
	}

	public ConfigAplicacion(String etiqueta, String username, String nombre, String valor) {
		this.etiqueta = etiqueta;
		this.username = username;
		this.nombre = nombre;
		this.valor = valor;
	}

	@SequenceGenerator(name = "generator", sequenceName = "AED_CONFIG_APLICACION_SEQ", allocationSize = 1)
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "generator")
	@Column(name = "clave", unique = true, nullable = false)
	public int getClave() {
		return this.clave;
	}

	public void setClave(int clave) {
		this.clave = clave;
	}

	/**
	 * * Nombre que el usuario le da al estado
	 */

	@Column(name = "etiqueta", length = 64)
	public String getEtiqueta() {
		return this.etiqueta;
	}

	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
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

	// @Lob
	@Column(name = "valor") //, columnDefinition = "CLOB")
	public String getValor() {
		return this.valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

}
