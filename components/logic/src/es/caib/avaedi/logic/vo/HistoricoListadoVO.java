package es.caib.avaedi.logic.vo;

import java.io.Serializable;

import org.directwebremoting.annotations.DataTransferObject;

import es.caib.avaedi.at4forms.common.util.FormData2Java;
import es.caib.avaedi.at4forms.logic.vo.BaseVO;

/**
 * TransferObject para la implementacion del listado Historico
 */
@DataTransferObject
public class HistoricoListadoVO extends BaseVO implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public Serializable getPrimaryKey() {
		return this.getId();
	}

	@Override
	public String getPrimaryLabel() {
		return FormData2Java.toString(this.getId());
	}

	private Long id;
	private String inspeccionLabel;
	private int inspeccionId;
	private String fechaInspeccion;
	/**
	 * (grado_ejecucion_efectividad_obras)
	 */
	private String gradoEjecucionEfectividadObras;
	private String observaciones;
	private String resultado;
	private String tecnico;

	public HistoricoListadoVO() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getFechaInspeccion() {
		return this.fechaInspeccion;
	}

	public void setFechaInspeccion(String fechaInspeccion) {
		this.fechaInspeccion = fechaInspeccion;
	}

	/**
	 * * (grado_ejecucion_efectividad_obras)
	 */
	public String getGradoEjecucionEfectividadObras() {
		return this.gradoEjecucionEfectividadObras;
	}

	public void setGradoEjecucionEfectividadObras(String gradoEjecucionEfectividadObras) {
		this.gradoEjecucionEfectividadObras = gradoEjecucionEfectividadObras;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getResultado() {
		return this.resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public String getTecnico() {
		return this.tecnico;
	}

	public void setTecnico(String tecnico) {
		this.tecnico = tecnico;
	}

}
