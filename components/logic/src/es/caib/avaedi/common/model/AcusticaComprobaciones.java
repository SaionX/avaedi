package es.caib.avaedi.common.model;

// Generated 21-sep-2016 17:21:16

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import es.caib.avaedi.at4forms.common.basedao.BaseModel;

/**
 * AcusticaComprobaciones generated by hbm2java
 */
@Entity
@Table(name = "aed_acu_comprobaciones")
public class AcusticaComprobaciones extends BaseModel implements java.io.Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	private int claveInforme;
	private Inspeccion inspeccion;
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

	public AcusticaComprobaciones() {
	}

	public AcusticaComprobaciones(Inspeccion inspeccion) {
		this.inspeccion = inspeccion;
	}

	public AcusticaComprobaciones(Inspeccion inspeccion, Integer calasCatasElementosConstructivos, Integer cuestionariosConfortAcustico, Integer medicionesAislamientoAcustico, String observaciones, Integer otras, String otrasTexto) {
		this.inspeccion = inspeccion;
		this.calasCatasElementosConstructivos = calasCatasElementosConstructivos;
		this.cuestionariosConfortAcustico = cuestionariosConfortAcustico;
		this.medicionesAislamientoAcustico = medicionesAislamientoAcustico;
		this.observaciones = observaciones;
		this.otras = otras;
		this.otrasTexto = otrasTexto;
	}

	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "inspeccion"))
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "clave_informe", unique = true, nullable = false)
	public int getClaveInforme() {
		return this.claveInforme;
	}

	public void setClaveInforme(int claveInforme) {
		this.claveInforme = claveInforme;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "clave_informe", unique = true, nullable = false)
	public Inspeccion getInspeccion() {
		return this.inspeccion;
	}

	public void setInspeccion(Inspeccion inspeccion) {
		this.inspeccion = inspeccion;
	}

	/**
	 * * (calas_catas_elementos_constructivos)
	 */

	@Column(name = "calas_catas_elem_constructivos")
	public Integer getCalasCatasElementosConstructivos() {
		return this.calasCatasElementosConstructivos;
	}

	public void setCalasCatasElementosConstructivos(Integer calasCatasElementosConstructivos) {
		this.calasCatasElementosConstructivos = calasCatasElementosConstructivos;
	}

	@Column(name = "cuestionarios_confort_acustico")
	public Integer getCuestionariosConfortAcustico() {
		return this.cuestionariosConfortAcustico;
	}

	public void setCuestionariosConfortAcustico(Integer cuestionariosConfortAcustico) {
		this.cuestionariosConfortAcustico = cuestionariosConfortAcustico;
	}

	/**
	 * * (mediciones_aislamiento_acustico)
	 */

	@Column(name = "mediciones_aislamiento_acus")
	public Integer getMedicionesAislamientoAcustico() {
		return this.medicionesAislamientoAcustico;
	}

	public void setMedicionesAislamientoAcustico(Integer medicionesAislamientoAcustico) {
		this.medicionesAislamientoAcustico = medicionesAislamientoAcustico;
	}

	@Column(name = "observaciones")
	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	@Column(name = "otras")
	public Integer getOtras() {
		return this.otras;
	}

	public void setOtras(Integer otras) {
		this.otras = otras;
	}

	@Column(name = "otras_texto")
	public String getOtrasTexto() {
		return this.otrasTexto;
	}

	public void setOtrasTexto(String otrasTexto) {
		this.otrasTexto = otrasTexto;
	}

	/**
	 * toString
	 * 
	 * @return String
	 */
	public String toString() {
		StringBuffer buffer = new StringBuffer();

		buffer.append(getClass().getName()).append("@").append(Integer.toHexString(hashCode())).append(" [");
		buffer.append("claveInforme").append("='").append(getClaveInforme()).append("' ");
		buffer.append("inspeccion").append("='").append(getInspeccion()).append("' ");
		buffer.append("]");

		return buffer.toString();
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AcusticaComprobaciones))
			return false;
		AcusticaComprobaciones castOther = (AcusticaComprobaciones) other;

		return (this.getClaveInforme() == castOther.getClaveInforme()) && ((this.getInspeccion() == castOther.getInspeccion()) || (this.getInspeccion() != null && castOther.getInspeccion() != null && this.getInspeccion().equals(castOther.getInspeccion())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getClaveInforme();
		result = 37 * result + (getInspeccion() == null ? 0 : this.getInspeccion().hashCode());

		return result;
	}

}