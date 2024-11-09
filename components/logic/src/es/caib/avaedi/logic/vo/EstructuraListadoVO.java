package es.caib.avaedi.logic.vo;

import java.io.Serializable;

import org.directwebremoting.annotations.DataTransferObject;

import es.caib.avaedi.at4forms.common.util.FormData2Java;

/**
 * TransferObject para la implementacion del listado Estructura
 */
@DataTransferObject
public class EstructuraListadoVO extends InspeccionBaseVO implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public Serializable getPrimaryKey() {
		return this.getClaveInforme();
	}

	@Override
	public String getPrimaryLabel() {
		return FormData2Java.toString(this.getClaveInforme());
	}

	private int claveInforme;
	private String inspeccionLabel;
	private int inspeccionId;
	/**
	 * (cubierta_forjadoinclinado_texto)
	 */
	private String cubiertaForjadoinclinadoTexto;
	private String cubiertaOtrosTexto;
	/**
	 * (horizontalplantatipo_otros_texto)
	 */
	private String horizontalplantatipoOtrosTexto;
	private String horizontalsueloOtrosTexto;
	private String observaciones;
	private String verticalOtros;
	private String verticalOtrosTexto;

	public EstructuraListadoVO() {
	}

	public int getClaveInforme() {
		return this.claveInforme;
	}

	public void setClaveInforme(int claveInforme) {
		this.claveInforme = claveInforme;
	}

	public String getInspeccionLabel() {
		return this.inspeccionLabel;
	}

	public void setInspeccionLabel(String inspeccionLabel) {
		this.inspeccionLabel = inspeccionLabel;
	}

	public int getInspeccionId() {
		return this.inspeccionId;
	}

	public void setInspeccionId(int inspeccionId) {
		this.inspeccionId = inspeccionId;
	}

	/**
	 * * (cubierta_forjadoinclinado_texto)
	 */
	public String getCubiertaForjadoinclinadoTexto() {
		return this.cubiertaForjadoinclinadoTexto;
	}

	public void setCubiertaForjadoinclinadoTexto(String cubiertaForjadoinclinadoTexto) {
		this.cubiertaForjadoinclinadoTexto = cubiertaForjadoinclinadoTexto;
	}

	public String getCubiertaOtrosTexto() {
		return this.cubiertaOtrosTexto;
	}

	public void setCubiertaOtrosTexto(String cubiertaOtrosTexto) {
		this.cubiertaOtrosTexto = cubiertaOtrosTexto;
	}

	/**
	 * * (horizontalplantatipo_otros_texto)
	 */
	public String getHorizontalplantatipoOtrosTexto() {
		return this.horizontalplantatipoOtrosTexto;
	}

	public void setHorizontalplantatipoOtrosTexto(String horizontalplantatipoOtrosTexto) {
		this.horizontalplantatipoOtrosTexto = horizontalplantatipoOtrosTexto;
	}

	public String getHorizontalsueloOtrosTexto() {
		return this.horizontalsueloOtrosTexto;
	}

	public void setHorizontalsueloOtrosTexto(String horizontalsueloOtrosTexto) {
		this.horizontalsueloOtrosTexto = horizontalsueloOtrosTexto;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getVerticalOtros() {
		return this.verticalOtros;
	}

	public void setVerticalOtros(String verticalOtros) {
		this.verticalOtros = verticalOtros;
	}

	public String getVerticalOtrosTexto() {
		return this.verticalOtrosTexto;
	}

	public void setVerticalOtrosTexto(String verticalOtrosTexto) {
		this.verticalOtrosTexto = verticalOtrosTexto;
	}

}
