package es.caib.avaedi.logic.vo;

import java.io.Serializable;

import org.directwebremoting.annotations.DataTransferObject;

import es.caib.avaedi.at4forms.common.util.FormData2Java;

/**
 * TransferObject para la implementacion del listado Acusticas
 */
@DataTransferObject
public class AcusticasListadoVO extends InspeccionBaseVO implements java.io.Serializable {

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
	private String incluirInformeAcustica;
	private String nif;
	private String observaciones;
	private String tecnico;
	private String titulacion;

	public AcusticasListadoVO() {
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

	public String getIncluirInformeAcustica() {
		return this.incluirInformeAcustica;
	}

	public void setIncluirInformeAcustica(String incluirInformeAcustica) {
		this.incluirInformeAcustica = incluirInformeAcustica;
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
