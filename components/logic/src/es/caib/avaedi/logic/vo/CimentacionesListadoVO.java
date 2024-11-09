package es.caib.avaedi.logic.vo;

import java.io.Serializable;

import org.directwebremoting.annotations.DataTransferObject;

/**
 * TransferObject para la implementacion del listado Cimentaciones
 */
@DataTransferObject
public class CimentacionesListadoVO extends InspeccionBaseVO implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public Serializable getPrimaryKey() {
		return this.getClaveInforme();
	}

	@Override
	public String getPrimaryLabel() {
		return this.getCimentacionprofundaTexto();
	}

	private int claveInforme;
	private String inspeccionLabel;
	private int inspeccionId;
	private String cimentacionprofundaTexto;
	private String cimentacionsuperficialTexto;
	private String observaciones;
	private String sistemascontencionTexto;

	public CimentacionesListadoVO() {
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

	public String getCimentacionprofundaTexto() {
		return this.cimentacionprofundaTexto;
	}

	public void setCimentacionprofundaTexto(String cimentacionprofundaTexto) {
		this.cimentacionprofundaTexto = cimentacionprofundaTexto;
	}

	public String getCimentacionsuperficialTexto() {
		return this.cimentacionsuperficialTexto;
	}

	public void setCimentacionsuperficialTexto(String cimentacionsuperficialTexto) {
		this.cimentacionsuperficialTexto = cimentacionsuperficialTexto;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getSistemascontencionTexto() {
		return this.sistemascontencionTexto;
	}

	public void setSistemascontencionTexto(String sistemascontencionTexto) {
		this.sistemascontencionTexto = sistemascontencionTexto;
	}

}
