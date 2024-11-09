package es.caib.avaedi.logic.vo;

import java.io.Serializable;

import org.directwebremoting.annotations.DataTransferObject;

import es.caib.avaedi.at4forms.common.util.FormData2Java;

/**
 * TransferObject para la implementacion del listado Conservacion
 */
@DataTransferObject
public class ConservacionListadoVO extends InspeccionBaseVO implements java.io.Serializable {

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
	private Integer esTecnicoInspeccion;
	/**
	 * (conservacion_valoraciones_tipo_id)
	 */
	private Integer conservacionValoracionesTipoId;
	private String impedimentosVisita;
	/**
	 * (fecha_emision_informe_valoracion)
	 */
	private String fechaEmisionInformeValoracion;
	private String medidasSeguridadVisita;
	private String mediosInspeccion;
	private String nif;
	private Integer numLocalesInspeccionados;
	private Integer numViviendasInspeccionadas;
	private String observaciones;
	private String pruebasRealizadas;
	private String tecnico;
	private String titulacion;
	private Integer existePeligroInminente;
	private String descripcionPeligroInminente;
	private String fechaLimiteActuacion;
	private String medidas;

	public ConservacionListadoVO() {
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

	public Integer getEsTecnicoInspeccion() {
		return this.esTecnicoInspeccion;
	}

	public void setEsTecnicoInspeccion(Integer esTecnicoInspeccion) {
		this.esTecnicoInspeccion = esTecnicoInspeccion;
	}

	/**
	 * * (conservacion_valoraciones_tipo_id)
	 */
	public Integer getConservacionValoracionesTipoId() {
		return this.conservacionValoracionesTipoId;
	}

	public void setConservacionValoracionesTipoId(Integer conservacionValoracionesTipoId) {
		this.conservacionValoracionesTipoId = conservacionValoracionesTipoId;
	}

	public String getImpedimentosVisita() {
		return this.impedimentosVisita;
	}

	public void setImpedimentosVisita(String impedimentosVisita) {
		this.impedimentosVisita = impedimentosVisita;
	}

	/**
	 * * (fecha_emision_informe_valoracion)
	 */
	public String getFechaEmisionInformeValoracion() {
		return this.fechaEmisionInformeValoracion;
	}

	public void setFechaEmisionInformeValoracion(String fechaEmisionInformeValoracion) {
		this.fechaEmisionInformeValoracion = fechaEmisionInformeValoracion;
	}

	public String getMedidasSeguridadVisita() {
		return this.medidasSeguridadVisita;
	}

	public void setMedidasSeguridadVisita(String medidasSeguridadVisita) {
		this.medidasSeguridadVisita = medidasSeguridadVisita;
	}

	public String getMediosInspeccion() {
		return this.mediosInspeccion;
	}

	public void setMediosInspeccion(String mediosInspeccion) {
		this.mediosInspeccion = mediosInspeccion;
	}

	public String getNif() {
		return this.nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public Integer getNumLocalesInspeccionados() {
		return this.numLocalesInspeccionados;
	}

	public void setNumLocalesInspeccionados(Integer numLocalesInspeccionados) {
		this.numLocalesInspeccionados = numLocalesInspeccionados;
	}

	public Integer getNumViviendasInspeccionadas() {
		return this.numViviendasInspeccionadas;
	}

	public void setNumViviendasInspeccionadas(Integer numViviendasInspeccionadas) {
		this.numViviendasInspeccionadas = numViviendasInspeccionadas;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getPruebasRealizadas() {
		return this.pruebasRealizadas;
	}

	public void setPruebasRealizadas(String pruebasRealizadas) {
		this.pruebasRealizadas = pruebasRealizadas;
	}

	public String getTecnico() {
		return this.tecnico;
	}

	public void setTecnico(String tecnico) {
		this.tecnico = tecnico;
	}

	public String getTitulacion() {
		return this.titulacion;
	}

	public void setTitulacion(String titulacion) {
		this.titulacion = titulacion;
	}

	public Integer getExistePeligroInminente() {
		return this.existePeligroInminente;
	}

	public void setExistePeligroInminente(Integer existePeligroInminente) {
		this.existePeligroInminente = existePeligroInminente;
	}

	public String getDescripcionPeligroInminente() {
		return this.descripcionPeligroInminente;
	}

	public void setDescripcionPeligroInminente(String descripcionPeligroInminente) {
		this.descripcionPeligroInminente = descripcionPeligroInminente;
	}

	public String getFechaLimiteActuacion() {
		return this.fechaLimiteActuacion;
	}

	public void setFechaLimiteActuacion(String fechaLimiteActuacion) {
		this.fechaLimiteActuacion = fechaLimiteActuacion;
	}

	public String getMedidas() {
		return this.medidas;
	}

	public void setMedidas(String medidas) {
		this.medidas = medidas;
	}

}
