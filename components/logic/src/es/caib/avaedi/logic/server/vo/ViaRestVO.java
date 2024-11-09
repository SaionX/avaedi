package es.caib.avaedi.logic.server.vo;

import java.io.Serializable;

public class ViaRestVO extends RestBaseVO {
	private int clave;
	private String nombreEs;
	private String nombreCa;

	public int getClave() {
		return clave;
	}

	public void setClave(int clave) {
		this.clave = clave;
	}

	public String getNombreEs() {
		return nombreEs;
	}

	public void setNombreEs(String nombreEs) {
		this.nombreEs = nombreEs;
	}

	public String getNombreCa() {
		return nombreCa;
	}

	public void setNombreCa(String nombreCa) {
		this.nombreCa = nombreCa;
	}

	@Override
	public Serializable getPrimaryKey() {
		return this.getClave();
	}

}
