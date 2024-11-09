package es.caib.avaedi.logic.vo;

import java.io.Serializable;

import org.directwebremoting.annotations.DataTransferObject;

import es.caib.avaedi.at4forms.logic.vo.BaseVO;

/**
 * TransferObject para la implementacion del listado Usuario
 */
@DataTransferObject
public class UsuarioListadoVO extends BaseVO implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public Serializable getPrimaryKey() {
		return this.getClave();
	}

	@Override
	public String getPrimaryLabel() {
		return this.getUsername();
	}

	private int clave;
	private String municipioLabel;
	private Integer municipioId;
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

	public UsuarioListadoVO() {
	}

	public int getClave() {
		return this.clave;
	}

	public void setClave(int clave) {
		this.clave = clave;
	}

	public String getMunicipioLabel() {
		return this.municipioLabel;
	}

	public void setMunicipioLabel(String municipioLabel) {
		this.municipioLabel = municipioLabel;
	}

	public Integer getMunicipioId() {
		return this.municipioId;
	}

	public void setMunicipioId(Integer municipioId) {
		this.municipioId = municipioId;
	}

	/**
	 * * Nombre de usuario para acceder al sistema
	 */
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * * Nombre del usuario
	 */
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * * Apellido/s del usuario
	 */
	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * * Idioma inicial de acceso al sistema
	 */
	public String getIdioma() {
		return this.idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

}
