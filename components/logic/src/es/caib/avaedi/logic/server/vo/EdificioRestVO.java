package es.caib.avaedi.logic.server.vo;

import java.io.Serializable;
import java.util.Date;

public class EdificioRestVO extends RestBaseVO {
	private String numeroExtra;
	private String estadoInspeccionEs;
	private String estadoInspeccionCa;
	private int proximaIEE;

	public EdificioRestVO(String numeroExtra, String estadoInspeccionEs, String estadoInspeccionCa, int proximaIEE, Date LastModified) {
		super();
		this.numeroExtra = numeroExtra;
		this.estadoInspeccionEs = estadoInspeccionEs;
		this.estadoInspeccionCa = estadoInspeccionCa;
		this.proximaIEE = proximaIEE;
		this.lastModified = LastModified;
	}

	public EdificioRestVO() {
		super();
	}

	public String getNumeroExtra() {
		return numeroExtra;
	}

	public void setNumeroExtra(String numeroExtra) {
		this.numeroExtra = numeroExtra;
	}

	public String getEstadoInspeccionEs() {
		return estadoInspeccionEs;
	}

	public void setEstadoInspeccionEs(String estadoInspeccionEs) {
		this.estadoInspeccionEs = estadoInspeccionEs;
	}

	public String getEstadoInspeccionCa() {
		return estadoInspeccionCa;
	}

	public void setEstadoInspeccionCa(String estadoInspeccionCa) {
		this.estadoInspeccionCa = estadoInspeccionCa;
	}

	public int getProximaIEE() {
		return proximaIEE;
	}

	public void setProximaIEE(int proximaIEE) {
		this.proximaIEE = proximaIEE;
	}

	@Override
	public Serializable getPrimaryKey() {
		return this.getNumeroExtra();
	}

}

/*
 * private String viaLabelEs; private String viaLabelCa;
 * 
 * private String numeroExtra; private String numeroCatastro; private Integer
 * antiguedad; private BigDecimal centroX; private BigDecimal centroY; -
 */