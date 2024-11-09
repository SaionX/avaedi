package es.caib.avaedi.logic.vo;

import java.io.Serializable;

import org.directwebremoting.annotations.DataTransferObject;

import es.caib.avaedi.at4forms.common.util.FormData2Java;
import es.caib.avaedi.at4forms.logic.vo.BaseVO;

/**
 * TransferObject para la implementacion del listado Deficiencia
 */
@DataTransferObject
public class DeficienciaListadoVO extends BaseVO implements java.io.Serializable {

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
	private String deficienciaTipoLabel;
	private int deficienciaTipoId;
	private String inspeccionLabel;
	private int inspeccionId;
	/**
	 * (conservacion_sistemasconstructivos_tipo_id)
	 */
	private Integer conservacionSistemasconstructivosTipoId;
	private String descripcionDeficiencia;
	private Integer esGrave;
	private String localizacionDeficiencia;
	private String nombreDeficiencia;
	private String observaciones;
	private String pruebasEnsayosRealizados;

	public DeficienciaListadoVO() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDeficienciaTipoLabel() {
		return this.deficienciaTipoLabel;
	}

	public void setDeficienciaTipoLabel(String deficienciaTipoLabel) {
		this.deficienciaTipoLabel = deficienciaTipoLabel;
	}

	public int getDeficienciaTipoId() {
		return this.deficienciaTipoId;
	}

	public void setDeficienciaTipoId(int deficienciaTipoId) {
		this.deficienciaTipoId = deficienciaTipoId;
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
	 * * (conservacion_sistemasconstructivos_tipo_id)
	 */
	public Integer getConservacionSistemasconstructivosTipoId() {
		return this.conservacionSistemasconstructivosTipoId;
	}

	public void setConservacionSistemasconstructivosTipoId(Integer conservacionSistemasconstructivosTipoId) {
		this.conservacionSistemasconstructivosTipoId = conservacionSistemasconstructivosTipoId;
	}

	public String getDescripcionDeficiencia() {
		return this.descripcionDeficiencia;
	}

	public void setDescripcionDeficiencia(String descripcionDeficiencia) {
		this.descripcionDeficiencia = descripcionDeficiencia;
	}

	public Integer getEsGrave() {
		return this.esGrave;
	}

	public void setEsGrave(Integer esGrave) {
		this.esGrave = esGrave;
	}

	public String getLocalizacionDeficiencia() {
		return this.localizacionDeficiencia;
	}

	public void setLocalizacionDeficiencia(String localizacionDeficiencia) {
		this.localizacionDeficiencia = localizacionDeficiencia;
	}

	public String getNombreDeficiencia() {
		return this.nombreDeficiencia;
	}

	public void setNombreDeficiencia(String nombreDeficiencia) {
		this.nombreDeficiencia = nombreDeficiencia;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getPruebasEnsayosRealizados() {
		return this.pruebasEnsayosRealizados;
	}

	public void setPruebasEnsayosRealizados(String pruebasEnsayosRealizados) {
		this.pruebasEnsayosRealizados = pruebasEnsayosRealizados;
	}

}
