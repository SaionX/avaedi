package es.caib.avaedi.logic.vo;

import java.io.Serializable;
import java.math.BigDecimal;

import org.directwebremoting.annotations.DataTransferObject;

import es.caib.avaedi.at4forms.logic.vo.BaseVO;
import es.caib.avaedi.logic.bo.EdificioBean;

/**
 * TransferObject para la implementacion del listado Edificio
 */
@DataTransferObject
public class EdificioListadoVO extends BaseVO implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public Serializable getPrimaryKey() {
		return this.getClave();
	}

	@Override
	public String getPrimaryLabel() {		
		return EdificioBean.composeLabel(this);
	}

	private int clave;
	private String viaLabel;
	private int viaId;
	/**
	 * Número "oficial" en que se ubica el edificio
	 */
	private String numeroCatastro;
	/**
	 * Numeración extra del edificio, cuando coexiste más de una comunidad o una
	 * unidad de informe en el mismo número
	 */
	private String numeroExtra;
	/**
	 * Nom
	 */
	private String referenciaCatastral;
	/**
	 * Año de construcción
	 */
	private Integer antiguedad;
	/**
	 * Coordenada X (UTM EPSG:25831)
	 */
	private BigDecimal centroX;
	/**
	 * Coordenada Y (UTM EPSG:25831)
	 */
	private BigDecimal centroY;

	public EdificioListadoVO() {
	}

	public int getClave() {
		return this.clave;
	}

	public void setClave(int clave) {
		this.clave = clave;
	}

	public String getViaLabel() {
		return this.viaLabel;
	}

	public void setViaLabel(String viaLabel) {
		this.viaLabel = viaLabel;
	}

	public int getViaId() {
		return this.viaId;
	}

	public void setViaId(int viaId) {
		this.viaId = viaId;
	}

	/**
	 * * Número "oficial" en que se ubica el edificio
	 */
	public String getNumeroCatastro() {
		return this.numeroCatastro;
	}

	public void setNumeroCatastro(String numeroCatastro) {
		this.numeroCatastro = numeroCatastro;
	}

	/**
	 * * Numeración extra del edificio, cuando coexiste más de una comunidad o
	 * una unidad de informe en el mismo número
	 */
	public String getNumeroExtra() {
		return this.numeroExtra;
	}

	public void setNumeroExtra(String numeroExtra) {
		this.numeroExtra = numeroExtra;
	}

	/**
	 * * Nom
	 */
	public String getReferenciaCatastral() {
		return this.referenciaCatastral;
	}

	public void setReferenciaCatastral(String referenciaCatastral) {
		this.referenciaCatastral = referenciaCatastral;
	}

	/**
	 * * Año de construcción
	 */
	public Integer getAntiguedad() {
		return this.antiguedad;
	}

	public void setAntiguedad(Integer antiguedad) {
		this.antiguedad = antiguedad;
	}

	/**
	 * * Coordenada X (UTM EPSG:25831)
	 */
	public BigDecimal getCentroX() {
		return this.centroX;
	}

	public void setCentroX(BigDecimal centroX) {
		this.centroX = centroX;
	}

	/**
	 * * Coordenada Y (UTM EPSG:25831)
	 */
	public BigDecimal getCentroY() {
		return this.centroY;
	}

	public void setCentroY(BigDecimal centroY) {
		this.centroY = centroY;
	}

	//Campos extra
	private String municipioLabel;
	private int municipioId;

	public String getMunicipioLabel() {
		return this.municipioLabel;
	}

	public void setMunicipioLabel(String municipioLabel) {
		this.municipioLabel = municipioLabel;
	}

	public int getMunicipioId() {
		return this.municipioId;
	}

	public void setMunicipioId(int municipioId) {
		this.municipioId = municipioId;
	}

}
