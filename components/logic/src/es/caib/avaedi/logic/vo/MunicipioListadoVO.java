package es.caib.avaedi.logic.vo;

import java.io.Serializable;

import org.directwebremoting.annotations.DataTransferObject;

import es.caib.avaedi.at4forms.logic.vo.BaseVO;

/**
 * TransferObject para la implementacion del listado Municipio
 */
@DataTransferObject
public class MunicipioListadoVO extends BaseVO implements java.io.Serializable {

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
	private String islaLabel;
	private int islaId;
	private String nombre;
	private int codigoIne;
	private int codigoCatastro;
	private String organismoContacto;
	private String direccion;
	private String telefono;
	private String email;
	private String url;

	public MunicipioListadoVO() {
	}

	public int getClave() {
		return this.clave;
	}

	public void setClave(int clave) {
		this.clave = clave;
	}

	public String getIslaLabel() {
		return this.islaLabel;
	}

	public void setIslaLabel(String islaLabel) {
		this.islaLabel = islaLabel;
	}

	public int getIslaId() {
		return this.islaId;
	}

	public void setIslaId(int islaId) {
		this.islaId = islaId;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCodigoIne() {
		return this.codigoIne;
	}

	public void setCodigoIne(int codigoIne) {
		this.codigoIne = codigoIne;
	}

	public int getCodigoCatastro() {
		return this.codigoCatastro;
	}

	public void setCodigoCatastro(int codigoCatastro) {
		this.codigoCatastro = codigoCatastro;
	}

	public String getOrganismoContacto() {
		return this.organismoContacto;
	}

	public void setOrganismoContacto(String organismoContacto) {
		this.organismoContacto = organismoContacto;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
