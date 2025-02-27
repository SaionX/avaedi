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
 * AcusticaValoracionFinal generated by hbm2java
 */
@Entity
@Table(name = "aed_acu_valoracionfinal")
public class AcusticaValoracionFinal extends BaseModel implements java.io.Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	private int claveInforme;
	private Inspeccion inspeccion;
	private String observaciones;
	/**
	 * (proteccion_ruido_exterior_tipo_id)
	 */
	private Integer proteccionRuidoExteriorTipoId;
	/**
	 * (proteccion_ruido_instalaciones_tipo_id)
	 */
	private Integer proteccionRuidoInstalacionesTipoId;
	/**
	 * (proteccion_ruido_interior_aereo_horizontal_tipo_id)
	 */
	private Integer proteccionRuidoInteriorAereoHorizontalTipoId;
	/**
	 * (proteccion_ruido_interior_aereo_vertical_tipo_id)
	 */
	private Integer proteccionRuidoInteriorAereoVerticalTipoId;
	/**
	 * (proteccion_ruido_interior_impactos_horizontal_tipo_id)
	 */
	private Integer proteccionRuidoInteriorImpactosHorizontalTipoId;
	/**
	 * (proteccion_ruido_interior_impactos_vertical_tipo_id)
	 */
	private Integer proteccionRuidoInteriorImpactosVerticalTipoId;

	public AcusticaValoracionFinal() {
	}

	public AcusticaValoracionFinal(Inspeccion inspeccion) {
		this.inspeccion = inspeccion;
	}

	public AcusticaValoracionFinal(Inspeccion inspeccion, String observaciones, Integer proteccionRuidoExteriorTipoId, Integer proteccionRuidoInstalacionesTipoId, Integer proteccionRuidoInteriorAereoHorizontalTipoId, Integer proteccionRuidoInteriorAereoVerticalTipoId, Integer proteccionRuidoInteriorImpactosHorizontalTipoId, Integer proteccionRuidoInteriorImpactosVerticalTipoId) {
		this.inspeccion = inspeccion;
		this.observaciones = observaciones;
		this.proteccionRuidoExteriorTipoId = proteccionRuidoExteriorTipoId;
		this.proteccionRuidoInstalacionesTipoId = proteccionRuidoInstalacionesTipoId;
		this.proteccionRuidoInteriorAereoHorizontalTipoId = proteccionRuidoInteriorAereoHorizontalTipoId;
		this.proteccionRuidoInteriorAereoVerticalTipoId = proteccionRuidoInteriorAereoVerticalTipoId;
		this.proteccionRuidoInteriorImpactosHorizontalTipoId = proteccionRuidoInteriorImpactosHorizontalTipoId;
		this.proteccionRuidoInteriorImpactosVerticalTipoId = proteccionRuidoInteriorImpactosVerticalTipoId;
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

	@Column(name = "observaciones")
	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	/**
	 * * (proteccion_ruido_exterior_tipo_id)
	 */

	@Column(name = "prot_rui_exterior_tipo_id")
	public Integer getProteccionRuidoExteriorTipoId() {
		return this.proteccionRuidoExteriorTipoId;
	}

	public void setProteccionRuidoExteriorTipoId(Integer proteccionRuidoExteriorTipoId) {
		this.proteccionRuidoExteriorTipoId = proteccionRuidoExteriorTipoId;
	}

	/**
	 * * (proteccion_ruido_instalaciones_tipo_id)
	 */

	@Column(name = "prot_rui_instal_tipo_id")
	public Integer getProteccionRuidoInstalacionesTipoId() {
		return this.proteccionRuidoInstalacionesTipoId;
	}

	public void setProteccionRuidoInstalacionesTipoId(Integer proteccionRuidoInstalacionesTipoId) {
		this.proteccionRuidoInstalacionesTipoId = proteccionRuidoInstalacionesTipoId;
	}

	/**
	 * * (proteccion_ruido_interior_aereo_horizontal_tipo_id)
	 */

	@Column(name = "prot_rui_int_aereo_hor_tipo_id")
	public Integer getProteccionRuidoInteriorAereoHorizontalTipoId() {
		return this.proteccionRuidoInteriorAereoHorizontalTipoId;
	}

	public void setProteccionRuidoInteriorAereoHorizontalTipoId(Integer proteccionRuidoInteriorAereoHorizontalTipoId) {
		this.proteccionRuidoInteriorAereoHorizontalTipoId = proteccionRuidoInteriorAereoHorizontalTipoId;
	}

	/**
	 * * (proteccion_ruido_interior_aereo_vertical_tipo_id)
	 */

	@Column(name = "prot_rui_int_aereo_vert_tip_id")
	public Integer getProteccionRuidoInteriorAereoVerticalTipoId() {
		return this.proteccionRuidoInteriorAereoVerticalTipoId;
	}

	public void setProteccionRuidoInteriorAereoVerticalTipoId(Integer proteccionRuidoInteriorAereoVerticalTipoId) {
		this.proteccionRuidoInteriorAereoVerticalTipoId = proteccionRuidoInteriorAereoVerticalTipoId;
	}

	/**
	 * * (proteccion_ruido_interior_impactos_horizontal_tipo_id)
	 */

	@Column(name = "prot_rui_int_imp_hor_tipo_id")
	public Integer getProteccionRuidoInteriorImpactosHorizontalTipoId() {
		return this.proteccionRuidoInteriorImpactosHorizontalTipoId;
	}

	public void setProteccionRuidoInteriorImpactosHorizontalTipoId(Integer proteccionRuidoInteriorImpactosHorizontalTipoId) {
		this.proteccionRuidoInteriorImpactosHorizontalTipoId = proteccionRuidoInteriorImpactosHorizontalTipoId;
	}

	/**
	 * * (proteccion_ruido_interior_impactos_vertical_tipo_id)
	 */

	@Column(name = "prot_rui_int_imp_vert_tipo_id")
	public Integer getProteccionRuidoInteriorImpactosVerticalTipoId() {
		return this.proteccionRuidoInteriorImpactosVerticalTipoId;
	}

	public void setProteccionRuidoInteriorImpactosVerticalTipoId(Integer proteccionRuidoInteriorImpactosVerticalTipoId) {
		this.proteccionRuidoInteriorImpactosVerticalTipoId = proteccionRuidoInteriorImpactosVerticalTipoId;
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
		if (!(other instanceof AcusticaValoracionFinal))
			return false;
		AcusticaValoracionFinal castOther = (AcusticaValoracionFinal) other;

		return (this.getClaveInforme() == castOther.getClaveInforme()) && ((this.getInspeccion() == castOther.getInspeccion()) || (this.getInspeccion() != null && castOther.getInspeccion() != null && this.getInspeccion().equals(castOther.getInspeccion())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getClaveInforme();
		result = 37 * result + (getInspeccion() == null ? 0 : this.getInspeccion().hashCode());

		return result;
	}

}
