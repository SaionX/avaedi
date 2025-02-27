package es.caib.avaedi.common.model;

// Generated 21-sep-2016 17:21:16

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import es.caib.avaedi.at4forms.common.basedao.BaseModel;

/**
 * AcusticaRuidosExteriores generated by hbm2java
 */
@Entity
@Table(name = "aed_acu_ruidosexteriores")
public class AcusticaRuidosExteriores extends BaseModel implements java.io.Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	private int claveInforme;
	private Inspeccion inspeccion;
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

	public AcusticaRuidosExteriores() {
	}

	public AcusticaRuidosExteriores(Inspeccion inspeccion) {
		this.inspeccion = inspeccion;
	}

	public AcusticaRuidosExteriores(Inspeccion inspeccion, String aireadoresAsilamientoAcustico, Integer aireadoresTiene, Integer capialzadosAislamientoAcustico, Integer capialzadosNoPrefabricados, Integer capialzadosTiene, Integer cubiertasLigeras, Integer cubiertasLigerasTecho, Integer cubiertasPesadas, String deficienciasObservaciones, Integer estadoCapialzadosBueno, Integer estadoCubiertasBueno, Integer estadoFachadasBueno, Integer estadoVentanasBueno, Integer fachadasLigeras, Integer fachadasPesadas, String observaciones, Integer ruidoMolestoExterior, String ventanasLocalizacionTiposVentanas) {
		this.inspeccion = inspeccion;
		this.aireadoresAsilamientoAcustico = aireadoresAsilamientoAcustico;
		this.aireadoresTiene = aireadoresTiene;
		this.capialzadosAislamientoAcustico = capialzadosAislamientoAcustico;
		this.capialzadosNoPrefabricados = capialzadosNoPrefabricados;
		this.capialzadosTiene = capialzadosTiene;
		this.cubiertasLigeras = cubiertasLigeras;
		this.cubiertasLigerasTecho = cubiertasLigerasTecho;
		this.cubiertasPesadas = cubiertasPesadas;
		this.deficienciasObservaciones = deficienciasObservaciones;
		this.estadoCapialzadosBueno = estadoCapialzadosBueno;
		this.estadoCubiertasBueno = estadoCubiertasBueno;
		this.estadoFachadasBueno = estadoFachadasBueno;
		this.estadoVentanasBueno = estadoVentanasBueno;
		this.fachadasLigeras = fachadasLigeras;
		this.fachadasPesadas = fachadasPesadas;
		this.observaciones = observaciones;
		this.ruidoMolestoExterior = ruidoMolestoExterior;
		this.ventanasLocalizacionTiposVentanas = ventanasLocalizacionTiposVentanas;
	}

	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "inspeccion"))
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "clave_informe", unique = true, nullable = false)
	public int getClaveInforme() {
		return this.claveInforme;
	}

	public void setClaveInforme(int claveInforme) {
		this.claveInforme = claveInforme;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "clave_informe", unique = true, nullable = false)
	public Inspeccion getInspeccion() {
		return this.inspeccion;
	}

	public void setInspeccion(Inspeccion inspeccion) {
		this.inspeccion = inspeccion;
	}

	/**
	 * * (aireadores_asilamiento_acustico)
	 */

	@Column(name = "aireadores_asilamiento_acus")
	public String getAireadoresAsilamientoAcustico() {
		return this.aireadoresAsilamientoAcustico;
	}

	public void setAireadoresAsilamientoAcustico(String aireadoresAsilamientoAcustico) {
		this.aireadoresAsilamientoAcustico = aireadoresAsilamientoAcustico;
	}

	@Column(name = "aireadores_tiene")
	public Integer getAireadoresTiene() {
		return this.aireadoresTiene;
	}

	public void setAireadoresTiene(Integer aireadoresTiene) {
		this.aireadoresTiene = aireadoresTiene;
	}

	/**
	 * * (capialzados_aislamiento_acustico)
	 */

	@Column(name = "capialzados_aislamiento_acus")
	public Integer getCapialzadosAislamientoAcustico() {
		return this.capialzadosAislamientoAcustico;
	}

	public void setCapialzadosAislamientoAcustico(Integer capialzadosAislamientoAcustico) {
		this.capialzadosAislamientoAcustico = capialzadosAislamientoAcustico;
	}

	@Column(name = "capialzados_no_prefabricados")
	public Integer getCapialzadosNoPrefabricados() {
		return this.capialzadosNoPrefabricados;
	}

	public void setCapialzadosNoPrefabricados(Integer capialzadosNoPrefabricados) {
		this.capialzadosNoPrefabricados = capialzadosNoPrefabricados;
	}

	@Column(name = "capialzados_tiene")
	public Integer getCapialzadosTiene() {
		return this.capialzadosTiene;
	}

	public void setCapialzadosTiene(Integer capialzadosTiene) {
		this.capialzadosTiene = capialzadosTiene;
	}

	@Column(name = "cubiertas_ligeras")
	public Integer getCubiertasLigeras() {
		return this.cubiertasLigeras;
	}

	public void setCubiertasLigeras(Integer cubiertasLigeras) {
		this.cubiertasLigeras = cubiertasLigeras;
	}

	@Column(name = "cubiertas_ligeras_techo")
	public Integer getCubiertasLigerasTecho() {
		return this.cubiertasLigerasTecho;
	}

	public void setCubiertasLigerasTecho(Integer cubiertasLigerasTecho) {
		this.cubiertasLigerasTecho = cubiertasLigerasTecho;
	}

	@Column(name = "cubiertas_pesadas")
	public Integer getCubiertasPesadas() {
		return this.cubiertasPesadas;
	}

	public void setCubiertasPesadas(Integer cubiertasPesadas) {
		this.cubiertasPesadas = cubiertasPesadas;
	}

	@Column(name = "deficiencias_observaciones")
	public String getDeficienciasObservaciones() {
		return this.deficienciasObservaciones;
	}

	public void setDeficienciasObservaciones(String deficienciasObservaciones) {
		this.deficienciasObservaciones = deficienciasObservaciones;
	}

	@Column(name = "estado_capialzados_bueno")
	public Integer getEstadoCapialzadosBueno() {
		return this.estadoCapialzadosBueno;
	}

	public void setEstadoCapialzadosBueno(Integer estadoCapialzadosBueno) {
		this.estadoCapialzadosBueno = estadoCapialzadosBueno;
	}

	@Column(name = "estado_cubiertas_bueno")
	public Integer getEstadoCubiertasBueno() {
		return this.estadoCubiertasBueno;
	}

	public void setEstadoCubiertasBueno(Integer estadoCubiertasBueno) {
		this.estadoCubiertasBueno = estadoCubiertasBueno;
	}

	@Column(name = "estado_fachadas_bueno")
	public Integer getEstadoFachadasBueno() {
		return this.estadoFachadasBueno;
	}

	public void setEstadoFachadasBueno(Integer estadoFachadasBueno) {
		this.estadoFachadasBueno = estadoFachadasBueno;
	}

	@Column(name = "estado_ventanas_bueno")
	public Integer getEstadoVentanasBueno() {
		return this.estadoVentanasBueno;
	}

	public void setEstadoVentanasBueno(Integer estadoVentanasBueno) {
		this.estadoVentanasBueno = estadoVentanasBueno;
	}

	@Column(name = "fachadas_ligeras")
	public Integer getFachadasLigeras() {
		return this.fachadasLigeras;
	}

	public void setFachadasLigeras(Integer fachadasLigeras) {
		this.fachadasLigeras = fachadasLigeras;
	}

	@Column(name = "fachadas_pesadas")
	public Integer getFachadasPesadas() {
		return this.fachadasPesadas;
	}

	public void setFachadasPesadas(Integer fachadasPesadas) {
		this.fachadasPesadas = fachadasPesadas;
	}

	@Column(name = "observaciones")
	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	@Column(name = "ruido_molesto_exterior")
	public Integer getRuidoMolestoExterior() {
		return this.ruidoMolestoExterior;
	}

	public void setRuidoMolestoExterior(Integer ruidoMolestoExterior) {
		this.ruidoMolestoExterior = ruidoMolestoExterior;
	}

	/**
	 * * (ventanas_localizacion_tipos_ventanas)
	 */

	@Column(name = "ventanas_loc_tipos_ventanas")
	public String getVentanasLocalizacionTiposVentanas() {
		return this.ventanasLocalizacionTiposVentanas;
	}

	public void setVentanasLocalizacionTiposVentanas(String ventanasLocalizacionTiposVentanas) {
		this.ventanasLocalizacionTiposVentanas = ventanasLocalizacionTiposVentanas;
	}

	/**
	 * toString
	 * 
	 * @return String
	 */
	public String toString() {
		StringBuffer buffer = new StringBuffer();

		buffer.append(getClass().getName()).append("@").append(Integer.toHexString(hashCode())).append(" [");
		buffer.append("claveInforme").append("='").append(getClaveInforme()).append("' ");
		buffer.append("inspeccion").append("='").append(getInspeccion()).append("' ");
		buffer.append("]");

		return buffer.toString();
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AcusticaRuidosExteriores))
			return false;
		AcusticaRuidosExteriores castOther = (AcusticaRuidosExteriores) other;

		return (this.getClaveInforme() == castOther.getClaveInforme()) && ((this.getInspeccion() == castOther.getInspeccion()) || (this.getInspeccion() != null && castOther.getInspeccion() != null && this.getInspeccion().equals(castOther.getInspeccion())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getClaveInforme();
		result = 37 * result + (getInspeccion() == null ? 0 : this.getInspeccion().hashCode());

		return result;
	}

}
