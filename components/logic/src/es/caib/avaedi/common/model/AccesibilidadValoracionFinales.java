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
 * AccesibilidadValoracionFinales generated by hbm2java
 */
@Entity
@Table(name = "aed_acc_valoracionfinales")
public class AccesibilidadValoracionFinales extends BaseModel implements java.io.Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	private int claveInforme;
	private Inspeccion inspeccion;
	/**
	 * (deficiencias_publico_alojamientosaccesibles)
	 */
	private Integer deficienciasPublicoAlojamientosaccesibles;
	/**
	 * (deficiencias_publico_aparcamiento)
	 */
	private Integer deficienciasPublicoAparcamiento;
	/**
	 * (deficiencias_publico_entreplantas)
	 */
	private Integer deficienciasPublicoEntreplantas;
	private Integer deficienciasPublicoExterior;
	/**
	 * (deficiencias_publico_informacionsenalizacion)
	 */
	private Integer deficienciasPublicoInformacionsenalizacion;
	/**
	 * (deficiencias_publico_mecanismos)
	 */
	private Integer deficienciasPublicoMecanismos;
	/**
	 * (deficiencias_publico_mobiliariofijo)
	 */
	private Integer deficienciasPublicoMobiliariofijo;
	private Integer deficienciasPublicoPiscinas;
	private Integer deficienciasPublicoPlantas;
	/**
	 * (deficiencias_publico_plazasreservadas)
	 */
	private Integer deficienciasPublicoPlazasreservadas;
	/**
	 * (deficiencias_publico_servicioshigienicos)
	 */
	private Integer deficienciasPublicoServicioshigienicos;
	/**
	 * (deficiencias_vivienda_aparcamiento)
	 */
	private String deficienciasViviendaAparcamiento;
	/**
	 * (deficiencias_vivienda_entreplantas)
	 */
	private String deficienciasViviendaEntreplantas;
	/**
	 * (deficiencias_vivienda_exterior)
	 */
	private String deficienciasViviendaExterior;
	/**
	 * (deficiencias_vivienda_informacionsenalizacion)
	 */
	private String deficienciasViviendaInformacionsenalizacion;
	/**
	 * (deficiencias_vivienda_mecanismos)
	 */
	private String deficienciasViviendaMecanismos;
	/**
	 * (deficiencias_vivienda_piscinas)
	 */
	private String deficienciasViviendaPiscinas;
	private String deficienciasViviendaPlantas;
	/**
	 * (deficiencias_vivienda_servicioshigienicos)
	 */
	private String deficienciasViviendaServicioshigienicos;
	private Integer satisfaceCondicionesBasicas;

	public AccesibilidadValoracionFinales() {
	}

	public AccesibilidadValoracionFinales(Inspeccion inspeccion) {
		this.inspeccion = inspeccion;
	}

	public AccesibilidadValoracionFinales(Inspeccion inspeccion, Integer deficienciasPublicoAlojamientosaccesibles, Integer deficienciasPublicoAparcamiento, Integer deficienciasPublicoEntreplantas, Integer deficienciasPublicoExterior, Integer deficienciasPublicoInformacionsenalizacion, Integer deficienciasPublicoMecanismos, Integer deficienciasPublicoMobiliariofijo, Integer deficienciasPublicoPiscinas, Integer deficienciasPublicoPlantas, Integer deficienciasPublicoPlazasreservadas, Integer deficienciasPublicoServicioshigienicos, String deficienciasViviendaAparcamiento, String deficienciasViviendaEntreplantas, String deficienciasViviendaExterior, String deficienciasViviendaInformacionsenalizacion, String deficienciasViviendaMecanismos, String deficienciasViviendaPiscinas, String deficienciasViviendaPlantas, String deficienciasViviendaServicioshigienicos, Integer satisfaceCondicionesBasicas) {
		this.inspeccion = inspeccion;
		this.deficienciasPublicoAlojamientosaccesibles = deficienciasPublicoAlojamientosaccesibles;
		this.deficienciasPublicoAparcamiento = deficienciasPublicoAparcamiento;
		this.deficienciasPublicoEntreplantas = deficienciasPublicoEntreplantas;
		this.deficienciasPublicoExterior = deficienciasPublicoExterior;
		this.deficienciasPublicoInformacionsenalizacion = deficienciasPublicoInformacionsenalizacion;
		this.deficienciasPublicoMecanismos = deficienciasPublicoMecanismos;
		this.deficienciasPublicoMobiliariofijo = deficienciasPublicoMobiliariofijo;
		this.deficienciasPublicoPiscinas = deficienciasPublicoPiscinas;
		this.deficienciasPublicoPlantas = deficienciasPublicoPlantas;
		this.deficienciasPublicoPlazasreservadas = deficienciasPublicoPlazasreservadas;
		this.deficienciasPublicoServicioshigienicos = deficienciasPublicoServicioshigienicos;
		this.deficienciasViviendaAparcamiento = deficienciasViviendaAparcamiento;
		this.deficienciasViviendaEntreplantas = deficienciasViviendaEntreplantas;
		this.deficienciasViviendaExterior = deficienciasViviendaExterior;
		this.deficienciasViviendaInformacionsenalizacion = deficienciasViviendaInformacionsenalizacion;
		this.deficienciasViviendaMecanismos = deficienciasViviendaMecanismos;
		this.deficienciasViviendaPiscinas = deficienciasViviendaPiscinas;
		this.deficienciasViviendaPlantas = deficienciasViviendaPlantas;
		this.deficienciasViviendaServicioshigienicos = deficienciasViviendaServicioshigienicos;
		this.satisfaceCondicionesBasicas = satisfaceCondicionesBasicas;
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
	 * * (deficiencias_publico_alojamientosaccesibles)
	 */

	@Column(name = "def_pub_alojamientos_acc")
	public Integer getDeficienciasPublicoAlojamientosaccesibles() {
		return this.deficienciasPublicoAlojamientosaccesibles;
	}

	public void setDeficienciasPublicoAlojamientosaccesibles(Integer deficienciasPublicoAlojamientosaccesibles) {
		this.deficienciasPublicoAlojamientosaccesibles = deficienciasPublicoAlojamientosaccesibles;
	}

	/**
	 * * (deficiencias_publico_aparcamiento)
	 */

	@Column(name = "def_pub_aparcamiento")
	public Integer getDeficienciasPublicoAparcamiento() {
		return this.deficienciasPublicoAparcamiento;
	}

	public void setDeficienciasPublicoAparcamiento(Integer deficienciasPublicoAparcamiento) {
		this.deficienciasPublicoAparcamiento = deficienciasPublicoAparcamiento;
	}

	/**
	 * * (deficiencias_publico_entreplantas)
	 */

	@Column(name = "def_pub_entreplantas")
	public Integer getDeficienciasPublicoEntreplantas() {
		return this.deficienciasPublicoEntreplantas;
	}

	public void setDeficienciasPublicoEntreplantas(Integer deficienciasPublicoEntreplantas) {
		this.deficienciasPublicoEntreplantas = deficienciasPublicoEntreplantas;
	}

	@Column(name = "deficiencias_publico_exterior")
	public Integer getDeficienciasPublicoExterior() {
		return this.deficienciasPublicoExterior;
	}

	public void setDeficienciasPublicoExterior(Integer deficienciasPublicoExterior) {
		this.deficienciasPublicoExterior = deficienciasPublicoExterior;
	}

	/**
	 * * (deficiencias_publico_informacionsenalizacion)
	 */

	@Column(name = "def_pub_inf_senal")
	public Integer getDeficienciasPublicoInformacionsenalizacion() {
		return this.deficienciasPublicoInformacionsenalizacion;
	}

	public void setDeficienciasPublicoInformacionsenalizacion(Integer deficienciasPublicoInformacionsenalizacion) {
		this.deficienciasPublicoInformacionsenalizacion = deficienciasPublicoInformacionsenalizacion;
	}

	/**
	 * * (deficiencias_publico_mecanismos)
	 */

	@Column(name = "def_pub_mecanismos")
	public Integer getDeficienciasPublicoMecanismos() {
		return this.deficienciasPublicoMecanismos;
	}

	public void setDeficienciasPublicoMecanismos(Integer deficienciasPublicoMecanismos) {
		this.deficienciasPublicoMecanismos = deficienciasPublicoMecanismos;
	}

	/**
	 * * (deficiencias_publico_mobiliariofijo)
	 */

	@Column(name = "def_pub_mobiliariofijo")
	public Integer getDeficienciasPublicoMobiliariofijo() {
		return this.deficienciasPublicoMobiliariofijo;
	}

	public void setDeficienciasPublicoMobiliariofijo(Integer deficienciasPublicoMobiliariofijo) {
		this.deficienciasPublicoMobiliariofijo = deficienciasPublicoMobiliariofijo;
	}

	@Column(name = "deficiencias_publico_piscinas")
	public Integer getDeficienciasPublicoPiscinas() {
		return this.deficienciasPublicoPiscinas;
	}

	public void setDeficienciasPublicoPiscinas(Integer deficienciasPublicoPiscinas) {
		this.deficienciasPublicoPiscinas = deficienciasPublicoPiscinas;
	}

	@Column(name = "deficiencias_publico_plantas")
	public Integer getDeficienciasPublicoPlantas() {
		return this.deficienciasPublicoPlantas;
	}

	public void setDeficienciasPublicoPlantas(Integer deficienciasPublicoPlantas) {
		this.deficienciasPublicoPlantas = deficienciasPublicoPlantas;
	}

	/**
	 * * (deficiencias_publico_plazasreservadas)
	 */

	@Column(name = "def_pub_plaz_res")
	public Integer getDeficienciasPublicoPlazasreservadas() {
		return this.deficienciasPublicoPlazasreservadas;
	}

	public void setDeficienciasPublicoPlazasreservadas(Integer deficienciasPublicoPlazasreservadas) {
		this.deficienciasPublicoPlazasreservadas = deficienciasPublicoPlazasreservadas;
	}

	/**
	 * * (deficiencias_publico_servicioshigienicos)
	 */

	@Column(name = "def_pub_serv_hig")
	public Integer getDeficienciasPublicoServicioshigienicos() {
		return this.deficienciasPublicoServicioshigienicos;
	}

	public void setDeficienciasPublicoServicioshigienicos(Integer deficienciasPublicoServicioshigienicos) {
		this.deficienciasPublicoServicioshigienicos = deficienciasPublicoServicioshigienicos;
	}

	/**
	 * * (deficiencias_vivienda_aparcamiento)
	 */

	@Column(name = "def_vivienda_aparcamiento")
	public String getDeficienciasViviendaAparcamiento() {
		return this.deficienciasViviendaAparcamiento;
	}

	public void setDeficienciasViviendaAparcamiento(String deficienciasViviendaAparcamiento) {
		this.deficienciasViviendaAparcamiento = deficienciasViviendaAparcamiento;
	}

	/**
	 * * (deficiencias_vivienda_entreplantas)
	 */

	@Column(name = "def_vivienda_entreplantas")
	public String getDeficienciasViviendaEntreplantas() {
		return this.deficienciasViviendaEntreplantas;
	}

	public void setDeficienciasViviendaEntreplantas(String deficienciasViviendaEntreplantas) {
		this.deficienciasViviendaEntreplantas = deficienciasViviendaEntreplantas;
	}

	/**
	 * * (deficiencias_vivienda_exterior)
	 */

	@Column(name = "def_vivienda_exterior")
	public String getDeficienciasViviendaExterior() {
		return this.deficienciasViviendaExterior;
	}

	public void setDeficienciasViviendaExterior(String deficienciasViviendaExterior) {
		this.deficienciasViviendaExterior = deficienciasViviendaExterior;
	}

	/**
	 * * (deficiencias_vivienda_informacionsenalizacion)
	 */

	@Column(name = "def_vivienda_inf_senal")
	public String getDeficienciasViviendaInformacionsenalizacion() {
		return this.deficienciasViviendaInformacionsenalizacion;
	}

	public void setDeficienciasViviendaInformacionsenalizacion(String deficienciasViviendaInformacionsenalizacion) {
		this.deficienciasViviendaInformacionsenalizacion = deficienciasViviendaInformacionsenalizacion;
	}

	/**
	 * * (deficiencias_vivienda_mecanismos)
	 */

	@Column(name = "def_vivienda_mecanismos")
	public String getDeficienciasViviendaMecanismos() {
		return this.deficienciasViviendaMecanismos;
	}

	public void setDeficienciasViviendaMecanismos(String deficienciasViviendaMecanismos) {
		this.deficienciasViviendaMecanismos = deficienciasViviendaMecanismos;
	}

	/**
	 * * (deficiencias_vivienda_piscinas)
	 */

	@Column(name = "def_vivienda_piscinas")
	public String getDeficienciasViviendaPiscinas() {
		return this.deficienciasViviendaPiscinas;
	}

	public void setDeficienciasViviendaPiscinas(String deficienciasViviendaPiscinas) {
		this.deficienciasViviendaPiscinas = deficienciasViviendaPiscinas;
	}

	@Column(name = "deficiencias_vivienda_plantas")
	public String getDeficienciasViviendaPlantas() {
		return this.deficienciasViviendaPlantas;
	}

	public void setDeficienciasViviendaPlantas(String deficienciasViviendaPlantas) {
		this.deficienciasViviendaPlantas = deficienciasViviendaPlantas;
	}

	/**
	 * * (deficiencias_vivienda_servicioshigienicos)
	 */

	@Column(name = "def_vivienda_serv_hig")
	public String getDeficienciasViviendaServicioshigienicos() {
		return this.deficienciasViviendaServicioshigienicos;
	}

	public void setDeficienciasViviendaServicioshigienicos(String deficienciasViviendaServicioshigienicos) {
		this.deficienciasViviendaServicioshigienicos = deficienciasViviendaServicioshigienicos;
	}

	@Column(name = "satisface_condiciones_basicas")
	public Integer getSatisfaceCondicionesBasicas() {
		return this.satisfaceCondicionesBasicas;
	}

	public void setSatisfaceCondicionesBasicas(Integer satisfaceCondicionesBasicas) {
		this.satisfaceCondicionesBasicas = satisfaceCondicionesBasicas;
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
		if (!(other instanceof AccesibilidadValoracionFinales))
			return false;
		AccesibilidadValoracionFinales castOther = (AccesibilidadValoracionFinales) other;

		return (this.getClaveInforme() == castOther.getClaveInforme()) && ((this.getInspeccion() == castOther.getInspeccion()) || (this.getInspeccion() != null && castOther.getInspeccion() != null && this.getInspeccion().equals(castOther.getInspeccion())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getClaveInforme();
		result = 37 * result + (getInspeccion() == null ? 0 : this.getInspeccion().hashCode());

		return result;
	}

}