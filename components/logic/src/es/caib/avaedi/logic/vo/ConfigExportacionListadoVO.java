package es.caib.avaedi.logic.vo;

import java.io.Serializable;

import org.directwebremoting.annotations.DataTransferObject;

import es.caib.avaedi.at4forms.logic.vo.BaseVO;

/**
 * TransferObject para la implementacion del listado ConfigExportacion
 */
@DataTransferObject
public class ConfigExportacionListadoVO extends BaseVO implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public Serializable getPrimaryKey() {
		return this.getClave();
	}

	@Override
	public String getPrimaryLabel() {
		return this.getNombre();
	}

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

	public ConfigExportacionListadoVO() {
	}

	public int getClave() {
		return this.clave;
	}

	public void setClave(int clave) {
		this.clave = clave;
	}

	/**
	 * * Nombre que el usuario le da a esta configuración de exportación
	 */
	public String getEtiqueta() {
		return this.etiqueta;
	}

	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * * Nombre del grid a que aplica
	 */
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * * Lista de columnas a incluir
	 */
	public String getColumnas() {
		return this.columnas;
	}

	public void setColumnas(String columnas) {
		this.columnas = columnas;
	}

	/**
	 * * formato: csv, xls, etc.
	 */
	public String getFormato() {
		return this.formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

	public String getPrivada() {
		return this.privada;
	}

	public void setPrivada(String privada) {
		this.privada = privada;
	}

}
