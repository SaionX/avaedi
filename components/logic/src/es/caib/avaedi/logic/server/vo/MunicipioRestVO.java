package es.caib.avaedi.logic.server.vo;

import java.io.Serializable;
import java.util.Date;

import es.caib.avaedi.logic.vo.MunicipioFormVO;
import es.caib.avaedi.logic.vo.MunicipioListadoVO;

public class MunicipioRestVO extends RestBaseVO {

	private int clave;
	private int islaId;
	private int codigoIne;
	private int codigoCatastro;

	private String nombre;
	private String organismoContacto;

	public MunicipioRestVO(int clave, int islaId, int codigoIne, int codigoCatastro, String nombre, String organismoContacto, Date lastModified) {
		super();
		this.clave = clave;
		this.islaId = islaId;
		this.codigoIne = codigoIne;
		this.codigoCatastro = codigoCatastro;
		this.nombre = nombre;
		this.organismoContacto = organismoContacto;
		this.lastModified = lastModified;
	}

	public MunicipioRestVO(MunicipioFormVO municipioraw) {
		super();
		this.clave = municipioraw.getClave();
		this.islaId = municipioraw.getIslaId();
		this.codigoIne = municipioraw.getCodigoIne();
		this.codigoCatastro = municipioraw.getCodigoCatastro();
		this.nombre = municipioraw.getNombre();
		this.organismoContacto = municipioraw.getOrganismoContacto();
		this.lastModified = municipioraw.getLastModified();
	}

	public MunicipioRestVO(MunicipioListadoVO municipioraw) {
		super();
		this.clave = municipioraw.getClave();
		this.islaId = municipioraw.getIslaId();
		this.codigoIne = municipioraw.getCodigoIne();
		this.codigoCatastro = municipioraw.getCodigoCatastro();
		this.nombre = municipioraw.getNombre();
		this.organismoContacto = municipioraw.getOrganismoContacto();
		this.lastModified = municipioraw.getLastModified();
	}

	public MunicipioRestVO() {
		super();
	}

	public int getClave() {
		return clave;
	}

	public void setClave(int clave) {
		this.clave = clave;
	}

	public int getIslaId() {
		return islaId;
	}

	public void setIslaId(int islaId) {
		this.islaId = islaId;
	}

	public int getCodigoIne() {
		return codigoIne;
	}

	public void setCodigoIne(int codigoIne) {
		this.codigoIne = codigoIne;
	}

	public int getCodigoCatastro() {
		return codigoCatastro;
	}

	public void setCodigoCatastro(int codigoCatastro) {
		this.codigoCatastro = codigoCatastro;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getOrganismoContacto() {
		return organismoContacto;
	}

	public void setOrganismoContacto(String organismoContacto) {
		this.organismoContacto = organismoContacto;
	}

	@Override
	public Serializable getPrimaryKey() {
		return this.getClave();
	}

}
