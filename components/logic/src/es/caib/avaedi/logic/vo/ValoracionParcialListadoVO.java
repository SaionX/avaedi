package es.caib.avaedi.logic.vo;

import java.io.Serializable;

import org.directwebremoting.annotations.DataTransferObject;

import es.caib.avaedi.at4forms.common.util.FormData2Java;
import es.caib.avaedi.at4forms.logic.vo.BaseVO;

/**
 * TransferObject para la implementacion del listado ValoracionParcial
 */
@DataTransferObject
public class ValoracionParcialListadoVO extends BaseVO implements java.io.Serializable {

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
	/**
	 * (conservacion_sistemasconstructivos_tipo_id)
	 */
	private Integer conservacionSistemasconstructivosTipoId;
	/**
	 * (conservacion_valoraciones_tipo_id)
	 */
	private Integer conservacionValoracionesTipoId;
	private String plazoFinObras;
	private String plazoInicioObras;

	public ValoracionParcialListadoVO() {
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

	/**
	 * * (conservacion_sistemasconstructivos_tipo_id)
	 */
	public Integer getConservacionSistemasconstructivosTipoId() {
		return this.conservacionSistemasconstructivosTipoId;
	}

	public void setConservacionSistemasconstructivosTipoId(Integer conservacionSistemasconstructivosTipoId) {
		this.conservacionSistemasconstructivosTipoId = conservacionSistemasconstructivosTipoId;
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

	public String getPlazoFinObras() {
		return this.plazoFinObras;
	}

	public void setPlazoFinObras(String plazoFinObras) {
		this.plazoFinObras = plazoFinObras;
	}

	public String getPlazoInicioObras() {
		return this.plazoInicioObras;
	}

	public void setPlazoInicioObras(String plazoInicioObras) {
		this.plazoInicioObras = plazoInicioObras;
	}

}
