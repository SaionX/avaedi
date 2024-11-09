package es.caib.avaedi.logic.vo;

import java.io.Serializable;

import org.directwebremoting.annotations.DataTransferObject;

import es.caib.avaedi.at4forms.common.util.FormData2Java;

/**
 * TransferObject para la implementacion del listado
 * AccesibilidadValoracionFinales
 */
@DataTransferObject
public class AccesibilidadValoracionFinalesListadoVO extends InspeccionBaseVO implements java.io.Serializable {

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

	public AccesibilidadValoracionFinalesListadoVO() {
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
	 * * (deficiencias_publico_alojamientosaccesibles)
	 */
	public Integer getDeficienciasPublicoAlojamientosaccesibles() {
		return this.deficienciasPublicoAlojamientosaccesibles;
	}

	public void setDeficienciasPublicoAlojamientosaccesibles(Integer deficienciasPublicoAlojamientosaccesibles) {
		this.deficienciasPublicoAlojamientosaccesibles = deficienciasPublicoAlojamientosaccesibles;
	}

	/**
	 * * (deficiencias_publico_aparcamiento)
	 */
	public Integer getDeficienciasPublicoAparcamiento() {
		return this.deficienciasPublicoAparcamiento;
	}

	public void setDeficienciasPublicoAparcamiento(Integer deficienciasPublicoAparcamiento) {
		this.deficienciasPublicoAparcamiento = deficienciasPublicoAparcamiento;
	}

	/**
	 * * (deficiencias_publico_entreplantas)
	 */
	public Integer getDeficienciasPublicoEntreplantas() {
		return this.deficienciasPublicoEntreplantas;
	}

	public void setDeficienciasPublicoEntreplantas(Integer deficienciasPublicoEntreplantas) {
		this.deficienciasPublicoEntreplantas = deficienciasPublicoEntreplantas;
	}

	public Integer getDeficienciasPublicoExterior() {
		return this.deficienciasPublicoExterior;
	}

	public void setDeficienciasPublicoExterior(Integer deficienciasPublicoExterior) {
		this.deficienciasPublicoExterior = deficienciasPublicoExterior;
	}

	/**
	 * * (deficiencias_publico_informacionsenalizacion)
	 */
	public Integer getDeficienciasPublicoInformacionsenalizacion() {
		return this.deficienciasPublicoInformacionsenalizacion;
	}

	public void setDeficienciasPublicoInformacionsenalizacion(Integer deficienciasPublicoInformacionsenalizacion) {
		this.deficienciasPublicoInformacionsenalizacion = deficienciasPublicoInformacionsenalizacion;
	}

	/**
	 * * (deficiencias_publico_mecanismos)
	 */
	public Integer getDeficienciasPublicoMecanismos() {
		return this.deficienciasPublicoMecanismos;
	}

	public void setDeficienciasPublicoMecanismos(Integer deficienciasPublicoMecanismos) {
		this.deficienciasPublicoMecanismos = deficienciasPublicoMecanismos;
	}

	/**
	 * * (deficiencias_publico_mobiliariofijo)
	 */
	public Integer getDeficienciasPublicoMobiliariofijo() {
		return this.deficienciasPublicoMobiliariofijo;
	}

	public void setDeficienciasPublicoMobiliariofijo(Integer deficienciasPublicoMobiliariofijo) {
		this.deficienciasPublicoMobiliariofijo = deficienciasPublicoMobiliariofijo;
	}

	public Integer getDeficienciasPublicoPiscinas() {
		return this.deficienciasPublicoPiscinas;
	}

	public void setDeficienciasPublicoPiscinas(Integer deficienciasPublicoPiscinas) {
		this.deficienciasPublicoPiscinas = deficienciasPublicoPiscinas;
	}

	public Integer getDeficienciasPublicoPlantas() {
		return this.deficienciasPublicoPlantas;
	}

	public void setDeficienciasPublicoPlantas(Integer deficienciasPublicoPlantas) {
		this.deficienciasPublicoPlantas = deficienciasPublicoPlantas;
	}

	/**
	 * * (deficiencias_publico_plazasreservadas)
	 */
	public Integer getDeficienciasPublicoPlazasreservadas() {
		return this.deficienciasPublicoPlazasreservadas;
	}

	public void setDeficienciasPublicoPlazasreservadas(Integer deficienciasPublicoPlazasreservadas) {
		this.deficienciasPublicoPlazasreservadas = deficienciasPublicoPlazasreservadas;
	}

	/**
	 * * (deficiencias_publico_servicioshigienicos)
	 */
	public Integer getDeficienciasPublicoServicioshigienicos() {
		return this.deficienciasPublicoServicioshigienicos;
	}

	public void setDeficienciasPublicoServicioshigienicos(Integer deficienciasPublicoServicioshigienicos) {
		this.deficienciasPublicoServicioshigienicos = deficienciasPublicoServicioshigienicos;
	}

	/**
	 * * (deficiencias_vivienda_aparcamiento)
	 */
	public String getDeficienciasViviendaAparcamiento() {
		return this.deficienciasViviendaAparcamiento;
	}

	public void setDeficienciasViviendaAparcamiento(String deficienciasViviendaAparcamiento) {
		this.deficienciasViviendaAparcamiento = deficienciasViviendaAparcamiento;
	}

	/**
	 * * (deficiencias_vivienda_entreplantas)
	 */
	public String getDeficienciasViviendaEntreplantas() {
		return this.deficienciasViviendaEntreplantas;
	}

	public void setDeficienciasViviendaEntreplantas(String deficienciasViviendaEntreplantas) {
		this.deficienciasViviendaEntreplantas = deficienciasViviendaEntreplantas;
	}

	/**
	 * * (deficiencias_vivienda_exterior)
	 */
	public String getDeficienciasViviendaExterior() {
		return this.deficienciasViviendaExterior;
	}

	public void setDeficienciasViviendaExterior(String deficienciasViviendaExterior) {
		this.deficienciasViviendaExterior = deficienciasViviendaExterior;
	}

	/**
	 * * (deficiencias_vivienda_informacionsenalizacion)
	 */
	public String getDeficienciasViviendaInformacionsenalizacion() {
		return this.deficienciasViviendaInformacionsenalizacion;
	}

	public void setDeficienciasViviendaInformacionsenalizacion(String deficienciasViviendaInformacionsenalizacion) {
		this.deficienciasViviendaInformacionsenalizacion = deficienciasViviendaInformacionsenalizacion;
	}

	/**
	 * * (deficiencias_vivienda_mecanismos)
	 */
	public String getDeficienciasViviendaMecanismos() {
		return this.deficienciasViviendaMecanismos;
	}

	public void setDeficienciasViviendaMecanismos(String deficienciasViviendaMecanismos) {
		this.deficienciasViviendaMecanismos = deficienciasViviendaMecanismos;
	}

	/**
	 * * (deficiencias_vivienda_piscinas)
	 */
	public String getDeficienciasViviendaPiscinas() {
		return this.deficienciasViviendaPiscinas;
	}

	public void setDeficienciasViviendaPiscinas(String deficienciasViviendaPiscinas) {
		this.deficienciasViviendaPiscinas = deficienciasViviendaPiscinas;
	}

	public String getDeficienciasViviendaPlantas() {
		return this.deficienciasViviendaPlantas;
	}

	public void setDeficienciasViviendaPlantas(String deficienciasViviendaPlantas) {
		this.deficienciasViviendaPlantas = deficienciasViviendaPlantas;
	}

	/**
	 * * (deficiencias_vivienda_servicioshigienicos)
	 */
	public String getDeficienciasViviendaServicioshigienicos() {
		return this.deficienciasViviendaServicioshigienicos;
	}

	public void setDeficienciasViviendaServicioshigienicos(String deficienciasViviendaServicioshigienicos) {
		this.deficienciasViviendaServicioshigienicos = deficienciasViviendaServicioshigienicos;
	}

	public Integer getSatisfaceCondicionesBasicas() {
		return this.satisfaceCondicionesBasicas;
	}

	public void setSatisfaceCondicionesBasicas(Integer satisfaceCondicionesBasicas) {
		this.satisfaceCondicionesBasicas = satisfaceCondicionesBasicas;
	}

}
