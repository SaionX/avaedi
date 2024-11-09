package es.caib.avaedi.logic.vo;

import java.io.Serializable;

import org.directwebremoting.annotations.DataTransferObject;

import es.caib.avaedi.at4forms.common.util.FormData2Java;
import es.caib.avaedi.common.model.AcusticaMejorasAcusticasId;

/**
 * TransferObject para la implementacion del listado AcusticaMejorasAcusticas
 */
@DataTransferObject
public class AcusticaMejorasAcusticasListadoVO extends InspeccionBaseVO implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public Serializable getPrimaryKey() {
		return this.getId();
	}
	
	@Override
	public String getPrimaryLabel() {
		  return this.getId().toString();
	}

    private AcusticaMejorasAcusticasId id;
	private String inspeccionLabel;
	private int inspeccionId;
	/**
	 * (proteccion_ruido_exterior_tipo_id)
	 */
	private Integer proteccionRuidoExteriorTipoId;
	private String mejorasAnalisisTecnico;
	/**
	 * (proteccion_ruido_instalaciones_tipo_id)
	 */
	private Integer proteccionRuidoInstalacionesTipoId;
	private String mejorasDescripcion;
	/**
	 * (proteccion_ruido_interior_aereo_tipo_id)
	 */
	private Integer proteccionRuidoInteriorAereoTipoId;
	private String mejorasObservaciones;
	/**
	 * (proteccion_ruido_interior_impactos_tipo_id)
	 */
	private Integer proteccionRuidoInteriorImpactosTipoId;
	private String mejorasValoracionEconomica;
	private String potencialObservaciones;
	private String incidenciaObservaciones;
	private String incidenciaTexto;

	public AcusticaMejorasAcusticasListadoVO() {
	}

    public AcusticaMejorasAcusticasId getId() {
        return this.id;
    }
    
    public void setId(AcusticaMejorasAcusticasId id) {
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

	/**
	 * * (proteccion_ruido_exterior_tipo_id)
	 */
	public Integer getProteccionRuidoExteriorTipoId() {
		return this.proteccionRuidoExteriorTipoId;
	}

	public void setProteccionRuidoExteriorTipoId(Integer proteccionRuidoExteriorTipoId) {
		this.proteccionRuidoExteriorTipoId = proteccionRuidoExteriorTipoId;
	}

	public String getMejorasAnalisisTecnico() {
		return this.mejorasAnalisisTecnico;
	}

	public void setMejorasAnalisisTecnico(String mejorasAnalisisTecnico) {
		this.mejorasAnalisisTecnico = mejorasAnalisisTecnico;
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

	public String getMejorasDescripcion() {
		return this.mejorasDescripcion;
	}

	public void setMejorasDescripcion(String mejorasDescripcion) {
		this.mejorasDescripcion = mejorasDescripcion;
	}

	/**
	 * * (proteccion_ruido_interior_aereo_tipo_id)
	 */
	public Integer getProteccionRuidoInteriorAereoTipoId() {
		return this.proteccionRuidoInteriorAereoTipoId;
	}

	public void setProteccionRuidoInteriorAereoTipoId(Integer proteccionRuidoInteriorAereoTipoId) {
		this.proteccionRuidoInteriorAereoTipoId = proteccionRuidoInteriorAereoTipoId;
	}

	public String getMejorasObservaciones() {
		return this.mejorasObservaciones;
	}

	public void setMejorasObservaciones(String mejorasObservaciones) {
		this.mejorasObservaciones = mejorasObservaciones;
	}

	/**
	 * * (proteccion_ruido_interior_impactos_tipo_id)
	 */
	public Integer getProteccionRuidoInteriorImpactosTipoId() {
		return this.proteccionRuidoInteriorImpactosTipoId;
	}

	public void setProteccionRuidoInteriorImpactosTipoId(Integer proteccionRuidoInteriorImpactosTipoId) {
		this.proteccionRuidoInteriorImpactosTipoId = proteccionRuidoInteriorImpactosTipoId;
	}

	public String getMejorasValoracionEconomica() {
		return this.mejorasValoracionEconomica;
	}

	public void setMejorasValoracionEconomica(String mejorasValoracionEconomica) {
		this.mejorasValoracionEconomica = mejorasValoracionEconomica;
	}

	public String getPotencialObservaciones() {
		return this.potencialObservaciones;
	}

	public void setPotencialObservaciones(String potencialObservaciones) {
		this.potencialObservaciones = potencialObservaciones;
	}

	public String getIncidenciaObservaciones() {
		return this.incidenciaObservaciones;
	}

	public void setIncidenciaObservaciones(String incidenciaObservaciones) {
		this.incidenciaObservaciones = incidenciaObservaciones;
	}

	public String getIncidenciaTexto() {
		return this.incidenciaTexto;
	}

	public void setIncidenciaTexto(String incidenciaTexto) {
		this.incidenciaTexto = incidenciaTexto;
	}

}
