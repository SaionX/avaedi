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
 * AcusticaRuidosInterioresHorizontales generated by hbm2java
 */
@Entity
@Table(name = "aed_acu_ruiinthor")
public class AcusticaRuidosInterioresHorizontales extends BaseModel implements java.io.Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	private int claveInforme;
	private Inspeccion inspeccion;
	/**
	 * (caracteristicas_camara_aire_continua)
	 */
	private Integer caracteristicasCamaraAireContinua;
	/**
	 * (caracteristicas_luminarias_empotradas_selladas)
	 */
	private Integer caracteristicasLuminariasEmpotradasSelladas;
	/**
	 * (caracteristicas_suelo_flotante_contacto_directo)
	 */
	private Integer caracteristicasSueloFlotanteContactoDirecto;
	/**
	 * (caracteristicas_suelo_flotante_revestidas)
	 */
	private Integer caracteristicasSueloFlotanteRevestidas;
	private String deficienciasObservaciones;
	private Integer estadoBueno;
	private String forjadoPlantagarajeOtro;
	private String forjadoPlantatipoOtro;
	private String observaciones;
	private String plantagarajeCantoForjado;
	private String plantatipoCantoForjado;
	private Integer sueloFlotanteTiene;
	private Integer techoSuspendidoTiene;

	public AcusticaRuidosInterioresHorizontales() {
	}

	public AcusticaRuidosInterioresHorizontales(Inspeccion inspeccion) {
		this.inspeccion = inspeccion;
	}

	public AcusticaRuidosInterioresHorizontales(Inspeccion inspeccion, Integer caracteristicasCamaraAireContinua, Integer caracteristicasLuminariasEmpotradasSelladas, Integer caracteristicasSueloFlotanteContactoDirecto, Integer caracteristicasSueloFlotanteRevestidas, String deficienciasObservaciones, Integer estadoBueno, String forjadoPlantagarajeOtro, String forjadoPlantatipoOtro, String observaciones, String plantagarajeCantoForjado, String plantatipoCantoForjado, Integer sueloFlotanteTiene, Integer techoSuspendidoTiene) {
		this.inspeccion = inspeccion;
		this.caracteristicasCamaraAireContinua = caracteristicasCamaraAireContinua;
		this.caracteristicasLuminariasEmpotradasSelladas = caracteristicasLuminariasEmpotradasSelladas;
		this.caracteristicasSueloFlotanteContactoDirecto = caracteristicasSueloFlotanteContactoDirecto;
		this.caracteristicasSueloFlotanteRevestidas = caracteristicasSueloFlotanteRevestidas;
		this.deficienciasObservaciones = deficienciasObservaciones;
		this.estadoBueno = estadoBueno;
		this.forjadoPlantagarajeOtro = forjadoPlantagarajeOtro;
		this.forjadoPlantatipoOtro = forjadoPlantatipoOtro;
		this.observaciones = observaciones;
		this.plantagarajeCantoForjado = plantagarajeCantoForjado;
		this.plantatipoCantoForjado = plantatipoCantoForjado;
		this.sueloFlotanteTiene = sueloFlotanteTiene;
		this.techoSuspendidoTiene = techoSuspendidoTiene;
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
	 * * (caracteristicas_camara_aire_continua)
	 */

	@Column(name = "cars_camara_aire_continua")
	public Integer getCaracteristicasCamaraAireContinua() {
		return this.caracteristicasCamaraAireContinua;
	}

	public void setCaracteristicasCamaraAireContinua(Integer caracteristicasCamaraAireContinua) {
		this.caracteristicasCamaraAireContinua = caracteristicasCamaraAireContinua;
	}

	/**
	 * * (caracteristicas_luminarias_empotradas_selladas)
	 */

	@Column(name = "cars_luminarias_empot_selladas")
	public Integer getCaracteristicasLuminariasEmpotradasSelladas() {
		return this.caracteristicasLuminariasEmpotradasSelladas;
	}

	public void setCaracteristicasLuminariasEmpotradasSelladas(Integer caracteristicasLuminariasEmpotradasSelladas) {
		this.caracteristicasLuminariasEmpotradasSelladas = caracteristicasLuminariasEmpotradasSelladas;
	}

	/**
	 * * (caracteristicas_suelo_flotante_contacto_directo)
	 */

	@Column(name = "cars_suelo_flot_cont_directo")
	public Integer getCaracteristicasSueloFlotanteContactoDirecto() {
		return this.caracteristicasSueloFlotanteContactoDirecto;
	}

	public void setCaracteristicasSueloFlotanteContactoDirecto(Integer caracteristicasSueloFlotanteContactoDirecto) {
		this.caracteristicasSueloFlotanteContactoDirecto = caracteristicasSueloFlotanteContactoDirecto;
	}

	/**
	 * * (caracteristicas_suelo_flotante_revestidas)
	 */

	@Column(name = "cars_suelo_flotante_revestidas")
	public Integer getCaracteristicasSueloFlotanteRevestidas() {
		return this.caracteristicasSueloFlotanteRevestidas;
	}

	public void setCaracteristicasSueloFlotanteRevestidas(Integer caracteristicasSueloFlotanteRevestidas) {
		this.caracteristicasSueloFlotanteRevestidas = caracteristicasSueloFlotanteRevestidas;
	}

	@Column(name = "deficiencias_observaciones")
	public String getDeficienciasObservaciones() {
		return this.deficienciasObservaciones;
	}

	public void setDeficienciasObservaciones(String deficienciasObservaciones) {
		this.deficienciasObservaciones = deficienciasObservaciones;
	}

	@Column(name = "estado_bueno")
	public Integer getEstadoBueno() {
		return this.estadoBueno;
	}

	public void setEstadoBueno(Integer estadoBueno) {
		this.estadoBueno = estadoBueno;
	}

	@Column(name = "forjado_plantagaraje_otro")
	public String getForjadoPlantagarajeOtro() {
		return this.forjadoPlantagarajeOtro;
	}

	public void setForjadoPlantagarajeOtro(String forjadoPlantagarajeOtro) {
		this.forjadoPlantagarajeOtro = forjadoPlantagarajeOtro;
	}

	@Column(name = "forjado_plantatipo_otro")
	public String getForjadoPlantatipoOtro() {
		return this.forjadoPlantatipoOtro;
	}

	public void setForjadoPlantatipoOtro(String forjadoPlantatipoOtro) {
		this.forjadoPlantatipoOtro = forjadoPlantatipoOtro;
	}

	@Column(name = "observaciones")
	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	@Column(name = "plantagaraje_canto_forjado")
	public String getPlantagarajeCantoForjado() {
		return this.plantagarajeCantoForjado;
	}

	public void setPlantagarajeCantoForjado(String plantagarajeCantoForjado) {
		this.plantagarajeCantoForjado = plantagarajeCantoForjado;
	}

	@Column(name = "plantatipo_canto_forjado")
	public String getPlantatipoCantoForjado() {
		return this.plantatipoCantoForjado;
	}

	public void setPlantatipoCantoForjado(String plantatipoCantoForjado) {
		this.plantatipoCantoForjado = plantatipoCantoForjado;
	}

	@Column(name = "suelo_flotante_tiene")
	public Integer getSueloFlotanteTiene() {
		return this.sueloFlotanteTiene;
	}

	public void setSueloFlotanteTiene(Integer sueloFlotanteTiene) {
		this.sueloFlotanteTiene = sueloFlotanteTiene;
	}

	@Column(name = "techo_suspendido_tiene")
	public Integer getTechoSuspendidoTiene() {
		return this.techoSuspendidoTiene;
	}

	public void setTechoSuspendidoTiene(Integer techoSuspendidoTiene) {
		this.techoSuspendidoTiene = techoSuspendidoTiene;
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
		if (!(other instanceof AcusticaRuidosInterioresHorizontales))
			return false;
		AcusticaRuidosInterioresHorizontales castOther = (AcusticaRuidosInterioresHorizontales) other;

		return (this.getClaveInforme() == castOther.getClaveInforme()) && ((this.getInspeccion() == castOther.getInspeccion()) || (this.getInspeccion() != null && castOther.getInspeccion() != null && this.getInspeccion().equals(castOther.getInspeccion())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getClaveInforme();
		result = 37 * result + (getInspeccion() == null ? 0 : this.getInspeccion().hashCode());

		return result;
	}

}