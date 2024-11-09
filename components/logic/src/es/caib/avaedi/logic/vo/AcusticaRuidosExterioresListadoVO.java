package es.caib.avaedi.logic.vo;

import java.io.Serializable;

import org.directwebremoting.annotations.DataTransferObject;

import es.caib.avaedi.at4forms.common.util.FormData2Java;

/**
 * TransferObject para la implementacion del listado AcusticaRuidosExteriores
 */
@DataTransferObject
public class AcusticaRuidosExterioresListadoVO extends InspeccionBaseVO implements java.io.Serializable {

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
	 * (aireadores_asilamiento_acustico)
	 */
	private String aireadoresAsilamientoAcustico;
	private Integer aireadoresTiene;
	/**
	 * (capialzados_aislamiento_acustico)
	 */
	private Integer capialzadosAislamientoAcustico;
	private Integer capialzadosNoPrefabricados;
	private Integer capialzadosTiene;
	private Integer cubiertasLigeras;
	private Integer cubiertasLigerasTecho;
	private Integer cubiertasPesadas;
	private String deficienciasObservaciones;
	private Integer estadoCapialzadosBueno;
	private Integer estadoCubiertasBueno;
	private Integer estadoFachadasBueno;
	private Integer estadoVentanasBueno;
	private Integer fachadasLigeras;
	private Integer fachadasPesadas;
	private String observaciones;
	private Integer ruidoMolestoExterior;
	/**
	 * (ventanas_localizacion_tipos_ventanas)
	 */
	private String ventanasLocalizacionTiposVentanas;

	public AcusticaRuidosExterioresListadoVO() {
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
	 * * (aireadores_asilamiento_acustico)
	 */
	public String getAireadoresAsilamientoAcustico() {
		return this.aireadoresAsilamientoAcustico;
	}

	public void setAireadoresAsilamientoAcustico(String aireadoresAsilamientoAcustico) {
		this.aireadoresAsilamientoAcustico = aireadoresAsilamientoAcustico;
	}

	public Integer getAireadoresTiene() {
		return this.aireadoresTiene;
	}

	public void setAireadoresTiene(Integer aireadoresTiene) {
		this.aireadoresTiene = aireadoresTiene;
	}

	/**
	 * * (capialzados_aislamiento_acustico)
	 */
	public Integer getCapialzadosAislamientoAcustico() {
		return this.capialzadosAislamientoAcustico;
	}

	public void setCapialzadosAislamientoAcustico(Integer capialzadosAislamientoAcustico) {
		this.capialzadosAislamientoAcustico = capialzadosAislamientoAcustico;
	}

	public Integer getCapialzadosNoPrefabricados() {
		return this.capialzadosNoPrefabricados;
	}

	public void setCapialzadosNoPrefabricados(Integer capialzadosNoPrefabricados) {
		this.capialzadosNoPrefabricados = capialzadosNoPrefabricados;
	}

	public Integer getCapialzadosTiene() {
		return this.capialzadosTiene;
	}

	public void setCapialzadosTiene(Integer capialzadosTiene) {
		this.capialzadosTiene = capialzadosTiene;
	}

	public Integer getCubiertasLigeras() {
		return this.cubiertasLigeras;
	}

	public void setCubiertasLigeras(Integer cubiertasLigeras) {
		this.cubiertasLigeras = cubiertasLigeras;
	}

	public Integer getCubiertasLigerasTecho() {
		return this.cubiertasLigerasTecho;
	}

	public void setCubiertasLigerasTecho(Integer cubiertasLigerasTecho) {
		this.cubiertasLigerasTecho = cubiertasLigerasTecho;
	}

	public Integer getCubiertasPesadas() {
		return this.cubiertasPesadas;
	}

	public void setCubiertasPesadas(Integer cubiertasPesadas) {
		this.cubiertasPesadas = cubiertasPesadas;
	}

	public String getDeficienciasObservaciones() {
		return this.deficienciasObservaciones;
	}

	public void setDeficienciasObservaciones(String deficienciasObservaciones) {
		this.deficienciasObservaciones = deficienciasObservaciones;
	}

	public Integer getEstadoCapialzadosBueno() {
		return this.estadoCapialzadosBueno;
	}

	public void setEstadoCapialzadosBueno(Integer estadoCapialzadosBueno) {
		this.estadoCapialzadosBueno = estadoCapialzadosBueno;
	}

	public Integer getEstadoCubiertasBueno() {
		return this.estadoCubiertasBueno;
	}

	public void setEstadoCubiertasBueno(Integer estadoCubiertasBueno) {
		this.estadoCubiertasBueno = estadoCubiertasBueno;
	}

	public Integer getEstadoFachadasBueno() {
		return this.estadoFachadasBueno;
	}

	public void setEstadoFachadasBueno(Integer estadoFachadasBueno) {
		this.estadoFachadasBueno = estadoFachadasBueno;
	}

	public Integer getEstadoVentanasBueno() {
		return this.estadoVentanasBueno;
	}

	public void setEstadoVentanasBueno(Integer estadoVentanasBueno) {
		this.estadoVentanasBueno = estadoVentanasBueno;
	}

	public Integer getFachadasLigeras() {
		return this.fachadasLigeras;
	}

	public void setFachadasLigeras(Integer fachadasLigeras) {
		this.fachadasLigeras = fachadasLigeras;
	}

	public Integer getFachadasPesadas() {
		return this.fachadasPesadas;
	}

	public void setFachadasPesadas(Integer fachadasPesadas) {
		this.fachadasPesadas = fachadasPesadas;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Integer getRuidoMolestoExterior() {
		return this.ruidoMolestoExterior;
	}

	public void setRuidoMolestoExterior(Integer ruidoMolestoExterior) {
		this.ruidoMolestoExterior = ruidoMolestoExterior;
	}

	/**
	 * * (ventanas_localizacion_tipos_ventanas)
	 */
	public String getVentanasLocalizacionTiposVentanas() {
		return this.ventanasLocalizacionTiposVentanas;
	}

	public void setVentanasLocalizacionTiposVentanas(String ventanasLocalizacionTiposVentanas) {
		this.ventanasLocalizacionTiposVentanas = ventanasLocalizacionTiposVentanas;
	}

}
