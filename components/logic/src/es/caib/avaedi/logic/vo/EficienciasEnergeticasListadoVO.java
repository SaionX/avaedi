package es.caib.avaedi.logic.vo;

import java.io.Serializable;

import org.directwebremoting.annotations.DataTransferObject;

import es.caib.avaedi.at4forms.common.util.FormData2Java;

/**
 * TransferObject para la implementacion del listado EficienciasEnergeticas
 */
@DataTransferObject
public class EficienciasEnergeticasListadoVO extends InspeccionBaseVO implements java.io.Serializable {

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
	private Integer ambitoAplicacion;
	private String demandaGlobalCalefaccion;
	/**
	 * (demanda_global_calefaccion_calificacion_tipo_id)
	 */
	private Integer demandaGlobalCalefaccionCalificacionTipoId;
	private String demandaGlobalRefrigeracion;
	/**
	 * (demanda_global_refrigeracion_calificacion_tipo_id)
	 */
	private Integer demandaGlobalRefrigeracionCalificacionTipoId;
	private Integer esTecnicoInspeccion;
	/**
	 * (indicador_global_calificacion_tipo_id)
	 */
	private Integer indicadorGlobalCalificacionTipoId;
	private String indicadorGlobalEmisiones;
	/**
	 * (indicador_global_primaria_calificacion_tipo_id)
	 */
	private Integer indicadorGlobalPrimariaCalificacionTipoId;
	/**
	 * (indicador_global_primaria_consumo)
	 */
	private String indicadorGlobalPrimariaConsumo;
	/**
	 * (indicador_parcial_emisiones_acs)
	 */
	private String indicadorParcialEmisionesAcs;
	/**
	 * (indicador_parcial_emisiones_calefaccion)
	 */
	private String indicadorParcialEmisionesCalefaccion;
	/**
	 * (indicador_parcial_emisiones_refrigeracion)
	 */
	private String indicadorParcialEmisionesRefrigeracion;
	private String indicadorParcialPrimariaAcs;
	/**
	 * (indicador_parcial_primaria_calefaccion)
	 */
	private String indicadorParcialPrimariaCalefaccion;
	/**
	 * (indicador_parcial_primaria_refrigeracion)
	 */
	private String indicadorParcialPrimariaRefrigeracion;
	private String nif;
	private String observaciones;
	private String tecnico;
	private String titulacion;

	public EficienciasEnergeticasListadoVO() {
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

	public Integer getAmbitoAplicacion() {
		return this.ambitoAplicacion;
	}

	public void setAmbitoAplicacion(Integer ambitoAplicacion) {
		this.ambitoAplicacion = ambitoAplicacion;
	}

	public String getDemandaGlobalCalefaccion() {
		return this.demandaGlobalCalefaccion;
	}

	public void setDemandaGlobalCalefaccion(String demandaGlobalCalefaccion) {
		this.demandaGlobalCalefaccion = demandaGlobalCalefaccion;
	}

	/**
	 * * (demanda_global_calefaccion_calificacion_tipo_id)
	 */
	public Integer getDemandaGlobalCalefaccionCalificacionTipoId() {
		return this.demandaGlobalCalefaccionCalificacionTipoId;
	}

	public void setDemandaGlobalCalefaccionCalificacionTipoId(Integer demandaGlobalCalefaccionCalificacionTipoId) {
		this.demandaGlobalCalefaccionCalificacionTipoId = demandaGlobalCalefaccionCalificacionTipoId;
	}

	public String getDemandaGlobalRefrigeracion() {
		return this.demandaGlobalRefrigeracion;
	}

	public void setDemandaGlobalRefrigeracion(String demandaGlobalRefrigeracion) {
		this.demandaGlobalRefrigeracion = demandaGlobalRefrigeracion;
	}

	/**
	 * * (demanda_global_refrigeracion_calificacion_tipo_id)
	 */
	public Integer getDemandaGlobalRefrigeracionCalificacionTipoId() {
		return this.demandaGlobalRefrigeracionCalificacionTipoId;
	}

	public void setDemandaGlobalRefrigeracionCalificacionTipoId(Integer demandaGlobalRefrigeracionCalificacionTipoId) {
		this.demandaGlobalRefrigeracionCalificacionTipoId = demandaGlobalRefrigeracionCalificacionTipoId;
	}

	public Integer getEsTecnicoInspeccion() {
		return this.esTecnicoInspeccion;
	}

	public void setEsTecnicoInspeccion(Integer esTecnicoInspeccion) {
		this.esTecnicoInspeccion = esTecnicoInspeccion;
	}

	/**
	 * * (indicador_global_calificacion_tipo_id)
	 */
	public Integer getIndicadorGlobalCalificacionTipoId() {
		return this.indicadorGlobalCalificacionTipoId;
	}

	public void setIndicadorGlobalCalificacionTipoId(Integer indicadorGlobalCalificacionTipoId) {
		this.indicadorGlobalCalificacionTipoId = indicadorGlobalCalificacionTipoId;
	}

	public String getIndicadorGlobalEmisiones() {
		return this.indicadorGlobalEmisiones;
	}

	public void setIndicadorGlobalEmisiones(String indicadorGlobalEmisiones) {
		this.indicadorGlobalEmisiones = indicadorGlobalEmisiones;
	}

	/**
	 * * (indicador_global_primaria_calificacion_tipo_id)
	 */
	public Integer getIndicadorGlobalPrimariaCalificacionTipoId() {
		return this.indicadorGlobalPrimariaCalificacionTipoId;
	}

	public void setIndicadorGlobalPrimariaCalificacionTipoId(Integer indicadorGlobalPrimariaCalificacionTipoId) {
		this.indicadorGlobalPrimariaCalificacionTipoId = indicadorGlobalPrimariaCalificacionTipoId;
	}

	/**
	 * * (indicador_global_primaria_consumo)
	 */
	public String getIndicadorGlobalPrimariaConsumo() {
		return this.indicadorGlobalPrimariaConsumo;
	}

	public void setIndicadorGlobalPrimariaConsumo(String indicadorGlobalPrimariaConsumo) {
		this.indicadorGlobalPrimariaConsumo = indicadorGlobalPrimariaConsumo;
	}

	/**
	 * * (indicador_parcial_emisiones_acs)
	 */
	public String getIndicadorParcialEmisionesAcs() {
		return this.indicadorParcialEmisionesAcs;
	}

	public void setIndicadorParcialEmisionesAcs(String indicadorParcialEmisionesAcs) {
		this.indicadorParcialEmisionesAcs = indicadorParcialEmisionesAcs;
	}

	/**
	 * * (indicador_parcial_emisiones_calefaccion)
	 */
	public String getIndicadorParcialEmisionesCalefaccion() {
		return this.indicadorParcialEmisionesCalefaccion;
	}

	public void setIndicadorParcialEmisionesCalefaccion(String indicadorParcialEmisionesCalefaccion) {
		this.indicadorParcialEmisionesCalefaccion = indicadorParcialEmisionesCalefaccion;
	}

	/**
	 * * (indicador_parcial_emisiones_refrigeracion)
	 */
	public String getIndicadorParcialEmisionesRefrigeracion() {
		return this.indicadorParcialEmisionesRefrigeracion;
	}

	public void setIndicadorParcialEmisionesRefrigeracion(String indicadorParcialEmisionesRefrigeracion) {
		this.indicadorParcialEmisionesRefrigeracion = indicadorParcialEmisionesRefrigeracion;
	}

	public String getIndicadorParcialPrimariaAcs() {
		return this.indicadorParcialPrimariaAcs;
	}

	public void setIndicadorParcialPrimariaAcs(String indicadorParcialPrimariaAcs) {
		this.indicadorParcialPrimariaAcs = indicadorParcialPrimariaAcs;
	}

	/**
	 * * (indicador_parcial_primaria_calefaccion)
	 */
	public String getIndicadorParcialPrimariaCalefaccion() {
		return this.indicadorParcialPrimariaCalefaccion;
	}

	public void setIndicadorParcialPrimariaCalefaccion(String indicadorParcialPrimariaCalefaccion) {
		this.indicadorParcialPrimariaCalefaccion = indicadorParcialPrimariaCalefaccion;
	}

	/**
	 * * (indicador_parcial_primaria_refrigeracion)
	 */
	public String getIndicadorParcialPrimariaRefrigeracion() {
		return this.indicadorParcialPrimariaRefrigeracion;
	}

	public void setIndicadorParcialPrimariaRefrigeracion(String indicadorParcialPrimariaRefrigeracion) {
		this.indicadorParcialPrimariaRefrigeracion = indicadorParcialPrimariaRefrigeracion;
	}

	public String getNif() {
		return this.nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
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

}
