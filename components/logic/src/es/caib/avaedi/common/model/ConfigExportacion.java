package es.caib.avaedi.common.model;

// Generated 12-sep-2016 10:10:37

import static javax.persistence.GenerationType.SEQUENCE;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import es.caib.avaedi.at4forms.common.basedao.BaseModel;

/**
 * Almacena una configuración de exportación que un usuario ha guardado
 */
@Entity
@Table(name = "aed_config_exportacion")
public class ConfigExportacion extends BaseModel implements java.io.Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	private int clave;
	/**
	 * Nombre que el usuario le da a esta configuración de exportación
	 */
	private String etiqueta;
	private String username;
	/**
	 * Nombre del grid a que aplica
	 */
	private String nombre;
	/**
	 * Lista de columnas a incluir
	 */
	private String columnas;
	/**
	 * formato: csv, xls, etc.
	 */
	private String formato;
	private String privada;

	public ConfigExportacion() {
	}

	public ConfigExportacion(String username, String nombre, String privada) {
		this.username = username;
		this.nombre = nombre;
		this.privada = privada;
	}

	public ConfigExportacion(String etiqueta, String username, String nombre, String columnas, String formato, String privada) {
		this.etiqueta = etiqueta;
		this.username = username;
		this.nombre = nombre;
		this.columnas = columnas;
		this.formato = formato;
		this.privada = privada;
	}

	@SequenceGenerator(name = "generator", sequenceName = "AED_CONFIG_EXPORTACION_SEQ", allocationSize = 1)
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
	 * * Nombre que el usuario le da a esta configuración de exportación
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

	/**
	 * * Nombre del grid a que aplica
	 */

	@Column(name = "nombre", nullable = false)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * * Lista de columnas a incluir
	 */

	@Column(name = "columnas")
	public String getColumnas() {
		return this.columnas;
	}

	public void setColumnas(String columnas) {
		this.columnas = columnas;
	}

	/**
	 * * formato: csv, xls, etc.
	 */

	@Column(name = "formato", length = 20)
	public String getFormato() {
		return this.formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

	@Column(name = "privada", nullable = false, length = 1)
	public String getPrivada() {
		return this.privada;
	}

	public void setPrivada(String privada) {
		this.privada = privada;
	}

}
