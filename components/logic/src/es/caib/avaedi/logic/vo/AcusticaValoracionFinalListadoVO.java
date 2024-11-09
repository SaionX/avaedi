package es.caib.avaedi.logic.vo;

import java.io.Serializable;

import org.directwebremoting.annotations.DataTransferObject;

import es.caib.avaedi.at4forms.common.util.FormData2Java;

/**
 * TransferObject para la implementacion del listado AcusticaValoracionFinal
 */
@DataTransferObject
public class AcusticaValoracionFinalListadoVO extends InspeccionBaseVO implements java.io.Serializable {

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

	public AcusticaValoracionFinalListadoVO() {
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

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	/**
	 * * (proteccion_ruido_exterior_tipo_id)
	 */
	public Integer getProteccionRuidoExteriorTipoId() {
		return this.proteccionRuidoExteriorTipoId;
	}

	public void setProteccionRuidoExteriorTipoId(Integer proteccionRuidoExteriorTipoId) {
		this.proteccionRuidoExteriorTipoId = proteccionRuidoExteriorTipoId;
	}

	/**
	 * * (proteccion_ruido_instalaciones_tipo_id)
	 */
	public Integer getProteccionRuidoInstalacionesTipoId() {
		return this.proteccionRuidoInstalacionesTipoId;
	}

	public void setProteccionRuidoInstalacionesTipoId(Integer proteccionRuidoInstalacionesTipoId) {
		this.proteccionRuidoInstalacionesTipoId = proteccionRuidoInstalacionesTipoId;
	}

	/**
	 * * (proteccion_ruido_interior_aereo_horizontal_tipo_id)
	 */
	public Integer getProteccionRuidoInteriorAereoHorizontalTipoId() {
		return this.proteccionRuidoInteriorAereoHorizontalTipoId;
	}

	public void setProteccionRuidoInteriorAereoHorizontalTipoId(Integer proteccionRuidoInteriorAereoHorizontalTipoId) {
		this.proteccionRuidoInteriorAereoHorizontalTipoId = proteccionRuidoInteriorAereoHorizontalTipoId;
	}

	/**
	 * * (proteccion_ruido_interior_aereo_vertical_tipo_id)
	 */
	public Integer getProteccionRuidoInteriorAereoVerticalTipoId() {
		return this.proteccionRuidoInteriorAereoVerticalTipoId;
	}

	public void setProteccionRuidoInteriorAereoVerticalTipoId(Integer proteccionRuidoInteriorAereoVerticalTipoId) {
		this.proteccionRuidoInteriorAereoVerticalTipoId = proteccionRuidoInteriorAereoVerticalTipoId;
	}

	/**
	 * * (proteccion_ruido_interior_impactos_horizontal_tipo_id)
	 */
	public Integer getProteccionRuidoInteriorImpactosHorizontalTipoId() {
		return this.proteccionRuidoInteriorImpactosHorizontalTipoId;
	}

	public void setProteccionRuidoInteriorImpactosHorizontalTipoId(Integer proteccionRuidoInteriorImpactosHorizontalTipoId) {
		this.proteccionRuidoInteriorImpactosHorizontalTipoId = proteccionRuidoInteriorImpactosHorizontalTipoId;
	}

	/**
	 * * (proteccion_ruido_interior_impactos_vertical_tipo_id)
	 */
	public Integer getProteccionRuidoInteriorImpactosVerticalTipoId() {
		return this.proteccionRuidoInteriorImpactosVerticalTipoId;
	}

	public void setProteccionRuidoInteriorImpactosVerticalTipoId(Integer proteccionRuidoInteriorImpactosVerticalTipoId) {
		this.proteccionRuidoInteriorImpactosVerticalTipoId = proteccionRuidoInteriorImpactosVerticalTipoId;
	}

}
