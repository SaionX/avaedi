package es.caib.avaedi.logic.vo;

import java.io.Serializable;

import org.directwebremoting.annotations.DataTransferObject;

import es.caib.avaedi.at4forms.common.util.FormData2Java;

/**
 * TransferObject para la implementacion del listado Instalaciones
 */
@DataTransferObject
public class InstalacionesListadoVO extends InspeccionBaseVO implements java.io.Serializable {

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
	private Integer acsCaptadoressolares;
	private String acsCentralCombustibleTexto;
	private Integer acsCentralTiene;
	/**
	 * (acs_nocentral_calentadoreselectricosporcentaje)
	 */
	private String acsNocentralCalentadoreselectricosporcentaje;
	/**
	 * (acs_nocentral_gascanalizadoporcentaje)
	 */
	private String acsNocentralGascanalizadoporcentaje;
	/**
	 * (acs_nocentral_gasembotelladoporcentaje)
	 */
	private String acsNocentralGasembotelladoporcentaje;
	/**
	 * (acs_nocentral_individualporcentaje)
	 */
	private String acsNocentralIndividualporcentaje;
	private String acsNocentralOtrosporcentaje;
	private Integer acsTiene;
	/**
	 * (calefaccion_central_combustible_texto)
	 */
	private String calefaccionCentralCombustibleTexto;
	private String calefaccionCentralTexto;
	private Integer calefaccionCentralTiene;
	/**
	 * (calefaccion_nocentral_calderagasoleoporcentaje)
	 */
	private String calefaccionNocentralCalderagasoleoporcentaje;
	/**
	 * (calefaccion_nocentral_calefaccionelectricaporcentaje)
	 */
	private String calefaccionNocentralCalefaccionelectricaporcentaje;
	/**
	 * (calefaccion_nocentral_gascanalizadoporcentaje)
	 */
	private String calefaccionNocentralGascanalizadoporcentaje;
	/**
	 * (calefaccion_nocentral_individualporcentaje)
	 */
	private String calefaccionNocentralIndividualporcentaje;
	/**
	 * (calefaccion_nocentral_otrosporcentaje)
	 */
	private String calefaccionNocentralOtrosporcentaje;
	private Integer calefaccionTiene;
	private String comunicacionesictTexto;
	private Integer comunicacionesictTiene;
	private Integer contraincendiosTiene;
	private String contrarayoTexto;
	private Integer contrarayoTiene;
	private String electricaTexto;
	private String gascanalizadoPorcentaje;
	private Integer gascanalizadoTiene;
	/**
	 * (instalaciones_acsnocentralgascanalizados)
	 */
	private String instalacionesAcsnocentralgascanalizados;
	/**
	 * (instalaciones_acsnocentralgasembotellados)
	 */
	private String instalacionesAcsnocentralgasembotellados;
	/**
	 * (instalaciones_calefaccionnocentralcalefaccionelectricas)
	 */
	private String instalacionesCalefaccionnocentralcalefaccionelectricas;
	/**
	 * (instalaciones_calefaccionnocentralgascanalizados)
	 */
	private String instalacionesCalefaccionnocentralgascanalizados;
	private String observaciones;
	private Integer refrigeracionColectivoTiene;
	/**
	 * (refrigeracion_nocolectivo_aparatosenfachadas)
	 */
	private String refrigeracionNocolectivoAparatosenfachadas;
	/**
	 * (refrigeracion_nocolectivo_individualporcentaje)
	 */
	private String refrigeracionNocolectivoIndividualporcentaje;
	private Integer refrigeracionTiene;
	private String saneamientoBajantesTexto;
	private String saneamientoColectoresTexto;
	/**
	 * (ventilacion_cuartoshumedos_sinventilacion)
	 */
	private Integer ventilacionCuartoshumedosSinventilacion;
	/**
	 * (ventilacion_cuartoshumedos_texto)
	 */
	private String ventilacionCuartoshumedosTexto;
	private Integer ventilacionTiene;

	public InstalacionesListadoVO() {
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

	public Integer getAcsCaptadoressolares() {
		return this.acsCaptadoressolares;
	}

	public void setAcsCaptadoressolares(Integer acsCaptadoressolares) {
		this.acsCaptadoressolares = acsCaptadoressolares;
	}

	public String getAcsCentralCombustibleTexto() {
		return this.acsCentralCombustibleTexto;
	}

	public void setAcsCentralCombustibleTexto(String acsCentralCombustibleTexto) {
		this.acsCentralCombustibleTexto = acsCentralCombustibleTexto;
	}

	public Integer getAcsCentralTiene() {
		return this.acsCentralTiene;
	}

	public void setAcsCentralTiene(Integer acsCentralTiene) {
		this.acsCentralTiene = acsCentralTiene;
	}

	/**
	 * * (acs_nocentral_calentadoreselectricosporcentaje)
	 */
	public String getAcsNocentralCalentadoreselectricosporcentaje() {
		return this.acsNocentralCalentadoreselectricosporcentaje;
	}

	public void setAcsNocentralCalentadoreselectricosporcentaje(String acsNocentralCalentadoreselectricosporcentaje) {
		this.acsNocentralCalentadoreselectricosporcentaje = acsNocentralCalentadoreselectricosporcentaje;
	}

	/**
	 * * (acs_nocentral_gascanalizadoporcentaje)
	 */
	public String getAcsNocentralGascanalizadoporcentaje() {
		return this.acsNocentralGascanalizadoporcentaje;
	}

	public void setAcsNocentralGascanalizadoporcentaje(String acsNocentralGascanalizadoporcentaje) {
		this.acsNocentralGascanalizadoporcentaje = acsNocentralGascanalizadoporcentaje;
	}

	/**
	 * * (acs_nocentral_gasembotelladoporcentaje)
	 */
	public String getAcsNocentralGasembotelladoporcentaje() {
		return this.acsNocentralGasembotelladoporcentaje;
	}

	public void setAcsNocentralGasembotelladoporcentaje(String acsNocentralGasembotelladoporcentaje) {
		this.acsNocentralGasembotelladoporcentaje = acsNocentralGasembotelladoporcentaje;
	}

	/**
	 * * (acs_nocentral_individualporcentaje)
	 */
	public String getAcsNocentralIndividualporcentaje() {
		return this.acsNocentralIndividualporcentaje;
	}

	public void setAcsNocentralIndividualporcentaje(String acsNocentralIndividualporcentaje) {
		this.acsNocentralIndividualporcentaje = acsNocentralIndividualporcentaje;
	}

	public String getAcsNocentralOtrosporcentaje() {
		return this.acsNocentralOtrosporcentaje;
	}

	public void setAcsNocentralOtrosporcentaje(String acsNocentralOtrosporcentaje) {
		this.acsNocentralOtrosporcentaje = acsNocentralOtrosporcentaje;
	}

	public Integer getAcsTiene() {
		return this.acsTiene;
	}

	public void setAcsTiene(Integer acsTiene) {
		this.acsTiene = acsTiene;
	}

	/**
	 * * (calefaccion_central_combustible_texto)
	 */
	public String getCalefaccionCentralCombustibleTexto() {
		return this.calefaccionCentralCombustibleTexto;
	}

	public void setCalefaccionCentralCombustibleTexto(String calefaccionCentralCombustibleTexto) {
		this.calefaccionCentralCombustibleTexto = calefaccionCentralCombustibleTexto;
	}

	public String getCalefaccionCentralTexto() {
		return this.calefaccionCentralTexto;
	}

	public void setCalefaccionCentralTexto(String calefaccionCentralTexto) {
		this.calefaccionCentralTexto = calefaccionCentralTexto;
	}

	public Integer getCalefaccionCentralTiene() {
		return this.calefaccionCentralTiene;
	}

	public void setCalefaccionCentralTiene(Integer calefaccionCentralTiene) {
		this.calefaccionCentralTiene = calefaccionCentralTiene;
	}

	/**
	 * * (calefaccion_nocentral_calderagasoleoporcentaje)
	 */
	public String getCalefaccionNocentralCalderagasoleoporcentaje() {
		return this.calefaccionNocentralCalderagasoleoporcentaje;
	}

	public void setCalefaccionNocentralCalderagasoleoporcentaje(String calefaccionNocentralCalderagasoleoporcentaje) {
		this.calefaccionNocentralCalderagasoleoporcentaje = calefaccionNocentralCalderagasoleoporcentaje;
	}

	/**
	 * * (calefaccion_nocentral_calefaccionelectricaporcentaje)
	 */
	public String getCalefaccionNocentralCalefaccionelectricaporcentaje() {
		return this.calefaccionNocentralCalefaccionelectricaporcentaje;
	}

	public void setCalefaccionNocentralCalefaccionelectricaporcentaje(String calefaccionNocentralCalefaccionelectricaporcentaje) {
		this.calefaccionNocentralCalefaccionelectricaporcentaje = calefaccionNocentralCalefaccionelectricaporcentaje;
	}

	/**
	 * * (calefaccion_nocentral_gascanalizadoporcentaje)
	 */
	public String getCalefaccionNocentralGascanalizadoporcentaje() {
		return this.calefaccionNocentralGascanalizadoporcentaje;
	}

	public void setCalefaccionNocentralGascanalizadoporcentaje(String calefaccionNocentralGascanalizadoporcentaje) {
		this.calefaccionNocentralGascanalizadoporcentaje = calefaccionNocentralGascanalizadoporcentaje;
	}

	/**
	 * * (calefaccion_nocentral_individualporcentaje)
	 */
	public String getCalefaccionNocentralIndividualporcentaje() {
		return this.calefaccionNocentralIndividualporcentaje;
	}

	public void setCalefaccionNocentralIndividualporcentaje(String calefaccionNocentralIndividualporcentaje) {
		this.calefaccionNocentralIndividualporcentaje = calefaccionNocentralIndividualporcentaje;
	}

	/**
	 * * (calefaccion_nocentral_otrosporcentaje)
	 */
	public String getCalefaccionNocentralOtrosporcentaje() {
		return this.calefaccionNocentralOtrosporcentaje;
	}

	public void setCalefaccionNocentralOtrosporcentaje(String calefaccionNocentralOtrosporcentaje) {
		this.calefaccionNocentralOtrosporcentaje = calefaccionNocentralOtrosporcentaje;
	}

	public Integer getCalefaccionTiene() {
		return this.calefaccionTiene;
	}

	public void setCalefaccionTiene(Integer calefaccionTiene) {
		this.calefaccionTiene = calefaccionTiene;
	}

	public String getComunicacionesictTexto() {
		return this.comunicacionesictTexto;
	}

	public void setComunicacionesictTexto(String comunicacionesictTexto) {
		this.comunicacionesictTexto = comunicacionesictTexto;
	}

	public Integer getComunicacionesictTiene() {
		return this.comunicacionesictTiene;
	}

	public void setComunicacionesictTiene(Integer comunicacionesictTiene) {
		this.comunicacionesictTiene = comunicacionesictTiene;
	}

	public Integer getContraincendiosTiene() {
		return this.contraincendiosTiene;
	}

	public void setContraincendiosTiene(Integer contraincendiosTiene) {
		this.contraincendiosTiene = contraincendiosTiene;
	}

	public String getContrarayoTexto() {
		return this.contrarayoTexto;
	}

	public void setContrarayoTexto(String contrarayoTexto) {
		this.contrarayoTexto = contrarayoTexto;
	}

	public Integer getContrarayoTiene() {
		return this.contrarayoTiene;
	}

	public void setContrarayoTiene(Integer contrarayoTiene) {
		this.contrarayoTiene = contrarayoTiene;
	}

	public String getElectricaTexto() {
		return this.electricaTexto;
	}

	public void setElectricaTexto(String electricaTexto) {
		this.electricaTexto = electricaTexto;
	}

	public String getGascanalizadoPorcentaje() {
		return this.gascanalizadoPorcentaje;
	}

	public void setGascanalizadoPorcentaje(String gascanalizadoPorcentaje) {
		this.gascanalizadoPorcentaje = gascanalizadoPorcentaje;
	}

	public Integer getGascanalizadoTiene() {
		return this.gascanalizadoTiene;
	}

	public void setGascanalizadoTiene(Integer gascanalizadoTiene) {
		this.gascanalizadoTiene = gascanalizadoTiene;
	}

	/**
	 * * (instalaciones_acsnocentralgascanalizados)
	 */
	public String getInstalacionesAcsnocentralgascanalizados() {
		return this.instalacionesAcsnocentralgascanalizados;
	}

	public void setInstalacionesAcsnocentralgascanalizados(String instalacionesAcsnocentralgascanalizados) {
		this.instalacionesAcsnocentralgascanalizados = instalacionesAcsnocentralgascanalizados;
	}

	/**
	 * * (instalaciones_acsnocentralgasembotellados)
	 */
	public String getInstalacionesAcsnocentralgasembotellados() {
		return this.instalacionesAcsnocentralgasembotellados;
	}

	public void setInstalacionesAcsnocentralgasembotellados(String instalacionesAcsnocentralgasembotellados) {
		this.instalacionesAcsnocentralgasembotellados = instalacionesAcsnocentralgasembotellados;
	}

	/**
	 * * (instalaciones_calefaccionnocentralcalefaccionelectricas)
	 */
	public String getInstalacionesCalefaccionnocentralcalefaccionelectricas() {
		return this.instalacionesCalefaccionnocentralcalefaccionelectricas;
	}

	public void setInstalacionesCalefaccionnocentralcalefaccionelectricas(String instalacionesCalefaccionnocentralcalefaccionelectricas) {
		this.instalacionesCalefaccionnocentralcalefaccionelectricas = instalacionesCalefaccionnocentralcalefaccionelectricas;
	}

	/**
	 * * (instalaciones_calefaccionnocentralgascanalizados)
	 */
	public String getInstalacionesCalefaccionnocentralgascanalizados() {
		return this.instalacionesCalefaccionnocentralgascanalizados;
	}

	public void setInstalacionesCalefaccionnocentralgascanalizados(String instalacionesCalefaccionnocentralgascanalizados) {
		this.instalacionesCalefaccionnocentralgascanalizados = instalacionesCalefaccionnocentralgascanalizados;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Integer getRefrigeracionColectivoTiene() {
		return this.refrigeracionColectivoTiene;
	}

	public void setRefrigeracionColectivoTiene(Integer refrigeracionColectivoTiene) {
		this.refrigeracionColectivoTiene = refrigeracionColectivoTiene;
	}

	/**
	 * * (refrigeracion_nocolectivo_aparatosenfachadas)
	 */
	public String getRefrigeracionNocolectivoAparatosenfachadas() {
		return this.refrigeracionNocolectivoAparatosenfachadas;
	}

	public void setRefrigeracionNocolectivoAparatosenfachadas(String refrigeracionNocolectivoAparatosenfachadas) {
		this.refrigeracionNocolectivoAparatosenfachadas = refrigeracionNocolectivoAparatosenfachadas;
	}

	/**
	 * * (refrigeracion_nocolectivo_individualporcentaje)
	 */
	public String getRefrigeracionNocolectivoIndividualporcentaje() {
		return this.refrigeracionNocolectivoIndividualporcentaje;
	}

	public void setRefrigeracionNocolectivoIndividualporcentaje(String refrigeracionNocolectivoIndividualporcentaje) {
		this.refrigeracionNocolectivoIndividualporcentaje = refrigeracionNocolectivoIndividualporcentaje;
	}

	public Integer getRefrigeracionTiene() {
		return this.refrigeracionTiene;
	}

	public void setRefrigeracionTiene(Integer refrigeracionTiene) {
		this.refrigeracionTiene = refrigeracionTiene;
	}

	public String getSaneamientoBajantesTexto() {
		return this.saneamientoBajantesTexto;
	}

	public void setSaneamientoBajantesTexto(String saneamientoBajantesTexto) {
		this.saneamientoBajantesTexto = saneamientoBajantesTexto;
	}

	public String getSaneamientoColectoresTexto() {
		return this.saneamientoColectoresTexto;
	}

	public void setSaneamientoColectoresTexto(String saneamientoColectoresTexto) {
		this.saneamientoColectoresTexto = saneamientoColectoresTexto;
	}

	/**
	 * * (ventilacion_cuartoshumedos_sinventilacion)
	 */
	public Integer getVentilacionCuartoshumedosSinventilacion() {
		return this.ventilacionCuartoshumedosSinventilacion;
	}

	public void setVentilacionCuartoshumedosSinventilacion(Integer ventilacionCuartoshumedosSinventilacion) {
		this.ventilacionCuartoshumedosSinventilacion = ventilacionCuartoshumedosSinventilacion;
	}

	/**
	 * * (ventilacion_cuartoshumedos_texto)
	 */
	public String getVentilacionCuartoshumedosTexto() {
		return this.ventilacionCuartoshumedosTexto;
	}

	public void setVentilacionCuartoshumedosTexto(String ventilacionCuartoshumedosTexto) {
		this.ventilacionCuartoshumedosTexto = ventilacionCuartoshumedosTexto;
	}

	public Integer getVentilacionTiene() {
		return this.ventilacionTiene;
	}

	public void setVentilacionTiene(Integer ventilacionTiene) {
		this.ventilacionTiene = ventilacionTiene;
	}

}
