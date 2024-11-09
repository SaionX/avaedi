package es.caib.avaedi.logic.vo;

import java.io.Serializable;

import org.directwebremoting.annotations.DataTransferObject;

import es.caib.avaedi.at4forms.common.util.FormData2Java;

/**
 * TransferObject para la implementacion del listado AcusticaDatosGenerales
 */
@DataTransferObject
public class AcusticaDatosGeneralesListadoVO extends InspeccionBaseVO implements java.io.Serializable {

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
	private Integer estudioEspecifico;
	/**
	 * (existen_recintos_instalaciones)
	 */
	private String existenRecintosInstalaciones;
	private Integer fachadasNoExpuestasRuido;
	private Integer indiceRuidoDia;
	private Integer objetivoCalidadAcustica;
	private String observaciones;
	/**
	 * (recintos_instalaciones_recintos_habitables)
	 */
	private String recintosInstalacionesRecintosHabitables;
	/**
	 * (recintos_instalaciones_zonas_comunes)
	 */
	private String recintosInstalacionesZonasComunes;
	private Integer recintosProtegidosAscensor;
	/**
	 * (recintos_protegidos_recintos_habitables)
	 */
	private Integer recintosProtegidosRecintosHabitables;
	/**
	 * (recintos_protegidos_recintos_instalaciones)
	 */
	private Integer recintosProtegidosRecintosInstalaciones;
	/**
	 * (recintos_protegidos_recintos_protegidos)
	 */
	private Integer recintosProtegidosRecintosProtegidos;
	private Integer recintosProtegidosZonaComun;
	private String tipoAreaAcustica;
	private Integer zonaRuidoAeronaves;

	public AcusticaDatosGeneralesListadoVO() {
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

	public Integer getEstudioEspecifico() {
		return this.estudioEspecifico;
	}

	public void setEstudioEspecifico(Integer estudioEspecifico) {
		this.estudioEspecifico = estudioEspecifico;
	}

	/**
	 * * (existen_recintos_instalaciones)
	 */
	public String getExistenRecintosInstalaciones() {
		return this.existenRecintosInstalaciones;
	}

	public void setExistenRecintosInstalaciones(String existenRecintosInstalaciones) {
		this.existenRecintosInstalaciones = existenRecintosInstalaciones;
	}

	public Integer getFachadasNoExpuestasRuido() {
		return this.fachadasNoExpuestasRuido;
	}

	public void setFachadasNoExpuestasRuido(Integer fachadasNoExpuestasRuido) {
		this.fachadasNoExpuestasRuido = fachadasNoExpuestasRuido;
	}

	public Integer getIndiceRuidoDia() {
		return this.indiceRuidoDia;
	}

	public void setIndiceRuidoDia(Integer indiceRuidoDia) {
		this.indiceRuidoDia = indiceRuidoDia;
	}

	public Integer getObjetivoCalidadAcustica() {
		return this.objetivoCalidadAcustica;
	}

	public void setObjetivoCalidadAcustica(Integer objetivoCalidadAcustica) {
		this.objetivoCalidadAcustica = objetivoCalidadAcustica;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	/**
	 * * (recintos_instalaciones_recintos_habitables)
	 */
	public String getRecintosInstalacionesRecintosHabitables() {
		return this.recintosInstalacionesRecintosHabitables;
	}

	public void setRecintosInstalacionesRecintosHabitables(String recintosInstalacionesRecintosHabitables) {
		this.recintosInstalacionesRecintosHabitables = recintosInstalacionesRecintosHabitables;
	}

	/**
	 * * (recintos_instalaciones_zonas_comunes)
	 */
	public String getRecintosInstalacionesZonasComunes() {
		return this.recintosInstalacionesZonasComunes;
	}

	public void setRecintosInstalacionesZonasComunes(String recintosInstalacionesZonasComunes) {
		this.recintosInstalacionesZonasComunes = recintosInstalacionesZonasComunes;
	}

	public Integer getRecintosProtegidosAscensor() {
		return this.recintosProtegidosAscensor;
	}

	public void setRecintosProtegidosAscensor(Integer recintosProtegidosAscensor) {
		this.recintosProtegidosAscensor = recintosProtegidosAscensor;
	}

	/**
	 * * (recintos_protegidos_recintos_habitables)
	 */
	public Integer getRecintosProtegidosRecintosHabitables() {
		return this.recintosProtegidosRecintosHabitables;
	}

	public void setRecintosProtegidosRecintosHabitables(Integer recintosProtegidosRecintosHabitables) {
		this.recintosProtegidosRecintosHabitables = recintosProtegidosRecintosHabitables;
	}

	/**
	 * * (recintos_protegidos_recintos_instalaciones)
	 */
	public Integer getRecintosProtegidosRecintosInstalaciones() {
		return this.recintosProtegidosRecintosInstalaciones;
	}

	public void setRecintosProtegidosRecintosInstalaciones(Integer recintosProtegidosRecintosInstalaciones) {
		this.recintosProtegidosRecintosInstalaciones = recintosProtegidosRecintosInstalaciones;
	}

	/**
	 * * (recintos_protegidos_recintos_protegidos)
	 */
	public Integer getRecintosProtegidosRecintosProtegidos() {
		return this.recintosProtegidosRecintosProtegidos;
	}

	public void setRecintosProtegidosRecintosProtegidos(Integer recintosProtegidosRecintosProtegidos) {
		this.recintosProtegidosRecintosProtegidos = recintosProtegidosRecintosProtegidos;
	}

	public Integer getRecintosProtegidosZonaComun() {
		return this.recintosProtegidosZonaComun;
	}

	public void setRecintosProtegidosZonaComun(Integer recintosProtegidosZonaComun) {
		this.recintosProtegidosZonaComun = recintosProtegidosZonaComun;
	}

	public String getTipoAreaAcustica() {
		return this.tipoAreaAcustica;
	}

	public void setTipoAreaAcustica(String tipoAreaAcustica) {
		this.tipoAreaAcustica = tipoAreaAcustica;
	}

	public Integer getZonaRuidoAeronaves() {
		return this.zonaRuidoAeronaves;
	}

	public void setZonaRuidoAeronaves(Integer zonaRuidoAeronaves) {
		this.zonaRuidoAeronaves = zonaRuidoAeronaves;
	}

}
