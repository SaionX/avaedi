package es.caib.avaedi.logic.vo;

import java.io.Serializable;

import org.directwebremoting.annotations.DataTransferObject;

import es.caib.avaedi.at4forms.common.util.FormData2Java;

/**
 * TransferObject para la implementacion del listado AcusticaComprobaciones
 */
@DataTransferObject
public class AcusticaComprobacionesListadoVO extends InspeccionBaseVO implements java.io.Serializable {

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
	 * (calas_catas_elementos_constructivos)
	 */
	private Integer calasCatasElementosConstructivos;
	private Integer cuestionariosConfortAcustico;
	/**
	 * (mediciones_aislamiento_acustico)
	 */
	private Integer medicionesAislamientoAcustico;
	private String observaciones;
	private Integer otras;
	private String otrasTexto;

	public AcusticaComprobacionesListadoVO() {
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
	 * * (calas_catas_elementos_constructivos)
	 */
	public Integer getCalasCatasElementosConstructivos() {
		return this.calasCatasElementosConstructivos;
	}

	public void setCalasCatasElementosConstructivos(Integer calasCatasElementosConstructivos) {
		this.calasCatasElementosConstructivos = calasCatasElementosConstructivos;
	}

	public Integer getCuestionariosConfortAcustico() {
		return this.cuestionariosConfortAcustico;
	}

	public void setCuestionariosConfortAcustico(Integer cuestionariosConfortAcustico) {
		this.cuestionariosConfortAcustico = cuestionariosConfortAcustico;
	}

	/**
	 * * (mediciones_aislamiento_acustico)
	 */
	public Integer getMedicionesAislamientoAcustico() {
		return this.medicionesAislamientoAcustico;
	}

	public void setMedicionesAislamientoAcustico(Integer medicionesAislamientoAcustico) {
		this.medicionesAislamientoAcustico = medicionesAislamientoAcustico;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Integer getOtras() {
		return this.otras;
	}

	public void setOtras(Integer otras) {
		this.otras = otras;
	}

	public String getOtrasTexto() {
		return this.otrasTexto;
	}

	public void setOtrasTexto(String otrasTexto) {
		this.otrasTexto = otrasTexto;
	}

}
