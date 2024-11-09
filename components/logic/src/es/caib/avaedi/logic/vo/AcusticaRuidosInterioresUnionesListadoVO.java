package es.caib.avaedi.logic.vo;

import java.io.Serializable;

import org.directwebremoting.annotations.DataTransferObject;

import es.caib.avaedi.at4forms.common.util.FormData2Java;

/**
 * TransferObject para la implementacion del listado
 * AcusticaRuidosInterioresUniones
 */
@DataTransferObject
public class AcusticaRuidosInterioresUnionesListadoVO extends InspeccionBaseVO implements java.io.Serializable {

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
	 * (elemento_separacion_vertical_forjado_conexion_rigida)
	 */
	private Integer elementoSeparacionVerticalForjadoConexionRigida;
	/**
	 * (elemento_separacion_vertical_forjado_mortero)
	 */
	private Integer elementoSeparacionVerticalForjadoMortero;
	/**
	 * (elemento_separacion_vertical_forjado_suelo_flotante)
	 */
	private Integer elementoSeparacionVerticalForjadoSueloFlotante;
	/**
	 * (elemento_separacion_vertical_forjado_techo_suspendido)
	 */
	private Integer elementoSeparacionVerticalForjadoTechoSuspendido;
	private Integer hojaInteriorFachadaContinua;
	private Integer materialAislanteElastico;
	private String observaciones;

	public AcusticaRuidosInterioresUnionesListadoVO() {
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
	 * * (elemento_separacion_vertical_forjado_conexion_rigida)
	 */
	public Integer getElementoSeparacionVerticalForjadoConexionRigida() {
		return this.elementoSeparacionVerticalForjadoConexionRigida;
	}

	public void setElementoSeparacionVerticalForjadoConexionRigida(Integer elementoSeparacionVerticalForjadoConexionRigida) {
		this.elementoSeparacionVerticalForjadoConexionRigida = elementoSeparacionVerticalForjadoConexionRigida;
	}

	/**
	 * * (elemento_separacion_vertical_forjado_mortero)
	 */
	public Integer getElementoSeparacionVerticalForjadoMortero() {
		return this.elementoSeparacionVerticalForjadoMortero;
	}

	public void setElementoSeparacionVerticalForjadoMortero(Integer elementoSeparacionVerticalForjadoMortero) {
		this.elementoSeparacionVerticalForjadoMortero = elementoSeparacionVerticalForjadoMortero;
	}

	/**
	 * * (elemento_separacion_vertical_forjado_suelo_flotante)
	 */
	public Integer getElementoSeparacionVerticalForjadoSueloFlotante() {
		return this.elementoSeparacionVerticalForjadoSueloFlotante;
	}

	public void setElementoSeparacionVerticalForjadoSueloFlotante(Integer elementoSeparacionVerticalForjadoSueloFlotante) {
		this.elementoSeparacionVerticalForjadoSueloFlotante = elementoSeparacionVerticalForjadoSueloFlotante;
	}

	/**
	 * * (elemento_separacion_vertical_forjado_techo_suspendido)
	 */
	public Integer getElementoSeparacionVerticalForjadoTechoSuspendido() {
		return this.elementoSeparacionVerticalForjadoTechoSuspendido;
	}

	public void setElementoSeparacionVerticalForjadoTechoSuspendido(Integer elementoSeparacionVerticalForjadoTechoSuspendido) {
		this.elementoSeparacionVerticalForjadoTechoSuspendido = elementoSeparacionVerticalForjadoTechoSuspendido;
	}

	public Integer getHojaInteriorFachadaContinua() {
		return this.hojaInteriorFachadaContinua;
	}

	public void setHojaInteriorFachadaContinua(Integer hojaInteriorFachadaContinua) {
		this.hojaInteriorFachadaContinua = hojaInteriorFachadaContinua;
	}

	public Integer getMaterialAislanteElastico() {
		return this.materialAislanteElastico;
	}

	public void setMaterialAislanteElastico(Integer materialAislanteElastico) {
		this.materialAislanteElastico = materialAislanteElastico;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

}
