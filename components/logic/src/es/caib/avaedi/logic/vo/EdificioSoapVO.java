package es.caib.avaedi.logic.vo;

import java.math.BigDecimal;

public class EdificioSoapVO {
	private String viaLabelEs;
	private String viaLabelCa;

	private String numeroExtra;
	private String numeroCatastro;
	private Integer antiguedad;
	private BigDecimal centroX;
	private BigDecimal centroY;

	private String codigoCatastroCorto;
	private String codigoCatastroLargo;

	public String getViaLabelEs() {
		return viaLabelEs;
	}

	public void setViaLabelEs(String viaLabelEs) {
		this.viaLabelEs = viaLabelEs;
	}

	public String getViaLabelCa() {
		return viaLabelCa;
	}

	public void setViaLabelCa(String viaLabelCa) {
		this.viaLabelCa = viaLabelCa;
	}

	public String getNumeroExtra() {
		return numeroExtra;
	}

	public void setNumeroExtra(String numeroExtra) {
		this.numeroExtra = numeroExtra;
	}

	public String getNumeroCatastro() {
		return numeroCatastro;
	}

	public void setNumeroCatastro(String numeroCatastro) {
		this.numeroCatastro = numeroCatastro;
	}

	public Integer getAntiguedad() {
		return antiguedad;
	}

	public void setAntiguedad(Integer antiguedad) {
		this.antiguedad = antiguedad;
	}

	public BigDecimal getCentroX() {
		return centroX;
	}

	public void setCentroX(BigDecimal centroX) {
		this.centroX = centroX;
	}

	public BigDecimal getCentroY() {
		return centroY;
	}

	public void setCentroY(BigDecimal centroY) {
		this.centroY = centroY;
	}

	public String getCodigoCatastroCorto() {
		return codigoCatastroCorto;
	}

	public void setCodigoCatastroCorto(String codigoCatastroCorto) {
		this.codigoCatastroCorto = codigoCatastroCorto;
	}

	public String getCodigoCatastroLargo() {
		return codigoCatastroLargo;
	}

	public void setCodigoCatastroLargo(String codigoCatastroLargo) {
		this.codigoCatastroLargo = codigoCatastroLargo;
	}

}
