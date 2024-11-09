package es.caib.avaedi.logic.vo;

import java.io.Serializable;

import org.directwebremoting.annotations.DataTransferObject;

import es.caib.avaedi.at4forms.common.util.FormData2Java;

/**
 * TransferObject para la implementacion del listado
 * AcusticaRuidosInterioresHorizontales
 */
@DataTransferObject
public class AcusticaRuidosInterioresHorizontalesListadoVO extends InspeccionBaseVO implements java.io.Serializable {

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

	public AcusticaRuidosInterioresHorizontalesListadoVO() {
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
	 * * (caracteristicas_camara_aire_continua)
	 */
	public Integer getCaracteristicasCamaraAireContinua() {
		return this.caracteristicasCamaraAireContinua;
	}

	public void setCaracteristicasCamaraAireContinua(Integer caracteristicasCamaraAireContinua) {
		this.caracteristicasCamaraAireContinua = caracteristicasCamaraAireContinua;
	}

	/**
	 * * (caracteristicas_luminarias_empotradas_selladas)
	 */
	public Integer getCaracteristicasLuminariasEmpotradasSelladas() {
		return this.caracteristicasLuminariasEmpotradasSelladas;
	}

	public void setCaracteristicasLuminariasEmpotradasSelladas(Integer caracteristicasLuminariasEmpotradasSelladas) {
		this.caracteristicasLuminariasEmpotradasSelladas = caracteristicasLuminariasEmpotradasSelladas;
	}

	/**
	 * * (caracteristicas_suelo_flotante_contacto_directo)
	 */
	public Integer getCaracteristicasSueloFlotanteContactoDirecto() {
		return this.caracteristicasSueloFlotanteContactoDirecto;
	}

	public void setCaracteristicasSueloFlotanteContactoDirecto(Integer caracteristicasSueloFlotanteContactoDirecto) {
		this.caracteristicasSueloFlotanteContactoDirecto = caracteristicasSueloFlotanteContactoDirecto;
	}

	/**
	 * * (caracteristicas_suelo_flotante_revestidas)
	 */
	public Integer getCaracteristicasSueloFlotanteRevestidas() {
		return this.caracteristicasSueloFlotanteRevestidas;
	}

	public void setCaracteristicasSueloFlotanteRevestidas(Integer caracteristicasSueloFlotanteRevestidas) {
		this.caracteristicasSueloFlotanteRevestidas = caracteristicasSueloFlotanteRevestidas;
	}

	public String getDeficienciasObservaciones() {
		return this.deficienciasObservaciones;
	}

	public void setDeficienciasObservaciones(String deficienciasObservaciones) {
		this.deficienciasObservaciones = deficienciasObservaciones;
	}

	public Integer getEstadoBueno() {
		return this.estadoBueno;
	}

	public void setEstadoBueno(Integer estadoBueno) {
		this.estadoBueno = estadoBueno;
	}

	public String getForjadoPlantagarajeOtro() {
		return this.forjadoPlantagarajeOtro;
	}

	public void setForjadoPlantagarajeOtro(String forjadoPlantagarajeOtro) {
		this.forjadoPlantagarajeOtro = forjadoPlantagarajeOtro;
	}

	public String getForjadoPlantatipoOtro() {
		return this.forjadoPlantatipoOtro;
	}

	public void setForjadoPlantatipoOtro(String forjadoPlantatipoOtro) {
		this.forjadoPlantatipoOtro = forjadoPlantatipoOtro;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getPlantagarajeCantoForjado() {
		return this.plantagarajeCantoForjado;
	}

	public void setPlantagarajeCantoForjado(String plantagarajeCantoForjado) {
		this.plantagarajeCantoForjado = plantagarajeCantoForjado;
	}

	public String getPlantatipoCantoForjado() {
		return this.plantatipoCantoForjado;
	}

	public void setPlantatipoCantoForjado(String plantatipoCantoForjado) {
		this.plantatipoCantoForjado = plantatipoCantoForjado;
	}

	public Integer getSueloFlotanteTiene() {
		return this.sueloFlotanteTiene;
	}

	public void setSueloFlotanteTiene(Integer sueloFlotanteTiene) {
		this.sueloFlotanteTiene = sueloFlotanteTiene;
	}

	public Integer getTechoSuspendidoTiene() {
		return this.techoSuspendidoTiene;
	}

	public void setTechoSuspendidoTiene(Integer techoSuspendidoTiene) {
		this.techoSuspendidoTiene = techoSuspendidoTiene;
	}

}
