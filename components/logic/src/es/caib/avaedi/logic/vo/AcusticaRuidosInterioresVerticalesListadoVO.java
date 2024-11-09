package es.caib.avaedi.logic.vo;

import java.io.Serializable;

import org.directwebremoting.annotations.DataTransferObject;

import es.caib.avaedi.at4forms.common.util.FormData2Java;

/**
 * TransferObject para la implementacion del listado
 * AcusticaRuidosInterioresVerticales
 */
@DataTransferObject
public class AcusticaRuidosInterioresVerticalesListadoVO extends InspeccionBaseVO implements java.io.Serializable {

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
	 * (acustica_ruidointeriorverticales_separacion_tipo_texto)
	 */
	private String ruiiIntVertSepTipoTex;
	/**
	 * (acustica_ruidointeriorverticales_tabiques_tipo_texto)
	 */
	private String ruiIntVertTabTipoTex;
	/**
	 * (caracteristicas_huecos_adosados)
	 */
	private Integer caracteristicasHuecosAdosados;
	/**
	 * (caracteristicas_huecos_adosados_revestidos)
	 */
	private Integer caracteristicasHuecosAdosadosRevestidos;
	/**
	 * (caracteristicas_huecos_adosados_ruido_molesto)
	 */
	private Integer caracteristicasHuecosAdosadosRuidoMolesto;
	/**
	 * (caracteristicas_instalaciones_atraviesan_recintos)
	 */
	private Integer caracteristicasInstalacionesAtraviesanRecintos;
	/**
	 * (caracteristicas_instalaciones_conectan_recintos)
	 */
	private Integer caracteristicasInstalacionesConectanRecintos;
	/**
	 * (caracteristicas_pilares_conectan_recintos)
	 */
	private Integer caracteristicasPilaresConectanRecintos;
	/**
	 * (caracteristicas_pilares_conectan_recintos_revestidos)
	 */
	private Integer caracteristicasPilaresConectanRecintosRevestidos;
	/**
	 * (caracteristicas_tuberias_ancladas)
	 */
	private Integer caracteristicasTuberiasAncladas;
	private String deficienciasObservaciones;
	private Integer estadoSeparacionBueno;
	private String observaciones;
	/**
	 * (separacion_entramado_autoportante)
	 */
	private Integer separacionEntramadoAutoportante;
	/**
	 * (separacion_entramado_autoportante_absorbente)
	 */
	private Integer separacionEntramadoAutoportanteAbsorbente;
	/**
	 * (separacion_entramado_autoportante_doshojas)
	 */
	private Integer separacionEntramadoAutoportanteDoshojas;
	/**
	 * (separacion_entramado_autoportante_doshojas_espesor)
	 */
	private String separacionEntramadoAutoportanteDoshojasEspesor;
	/**
	 * (separacion_entramado_autoportante_unahoja)
	 */
	private Integer separacionEntramadoAutoportanteUnahoja;
	/**
	 * (separacion_entramado_autoportante_unahoja_espesor)
	 */
	private String separacionEntramadoAutoportanteUnahojaEspesor;
	private Integer separacionEntramadoMadera;
	/**
	 * (separacion_entramado_madera_espesor)
	 */
	private Integer separacionEntramadoMaderaEspesor;
	/**
	 * (separacion_entramado_madera_revestido)
	 */
	private Integer separacionEntramadoMaderaRevestido;
	private Integer separacionFabrica;
	private Integer separacionFabricaRevestido;
	private Integer separacionOtros;
	private String separacionOtrosTexto;
	/**
	 * (tabiques_entramado_autoportante_metalico)
	 */
	private Integer tabiquesEntramadoAutoportanteMetalico;
	/**
	 * (tabiques_entramado_autoportante_metalico_espesor)
	 */
	private String tabiquesEntramadoAutoportanteMetalicoEspesor;
	/**
	 * (tabiques_entramado_madera_relleno)
	 */
	private Integer tabiquesEntramadoMaderaRelleno;
	/**
	 * (tabiques_entramado_madera_relleno_espesor)
	 */
	private String tabiquesEntramadoMaderaRellenoEspesor;
	private Integer tabiquesFabrica;
	private Integer zonaComunHallPuerta;
	/**
	 * (zona_comun_puertas_acusticamente_favorables)
	 */
	private Integer zonaComunPuertasAcusticamenteFavorables;

	public AcusticaRuidosInterioresVerticalesListadoVO() {
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
	 * * (acustica_ruidointeriorverticales_separacion_tipo_texto)
	 */
	public String getRuiiIntVertSepTipoTex() {
		return this.ruiiIntVertSepTipoTex;
	}

	public void setRuiiIntVertSepTipoTex(String ruiiIntVertSepTipoTex) {
		this.ruiiIntVertSepTipoTex = ruiiIntVertSepTipoTex;
	}

	/**
	 * * (acustica_ruidointeriorverticales_tabiques_tipo_texto)
	 */
	public String getRuiIntVertTabTipoTex() {
		return this.ruiIntVertTabTipoTex;
	}

	public void setRuiIntVertTabTipoTex(String ruiIntVertTabTipoTex) {
		this.ruiIntVertTabTipoTex = ruiIntVertTabTipoTex;
	}

	/**
	 * * (caracteristicas_huecos_adosados)
	 */
	public Integer getCaracteristicasHuecosAdosados() {
		return this.caracteristicasHuecosAdosados;
	}

	public void setCaracteristicasHuecosAdosados(Integer caracteristicasHuecosAdosados) {
		this.caracteristicasHuecosAdosados = caracteristicasHuecosAdosados;
	}

	/**
	 * * (caracteristicas_huecos_adosados_revestidos)
	 */
	public Integer getCaracteristicasHuecosAdosadosRevestidos() {
		return this.caracteristicasHuecosAdosadosRevestidos;
	}

	public void setCaracteristicasHuecosAdosadosRevestidos(Integer caracteristicasHuecosAdosadosRevestidos) {
		this.caracteristicasHuecosAdosadosRevestidos = caracteristicasHuecosAdosadosRevestidos;
	}

	/**
	 * * (caracteristicas_huecos_adosados_ruido_molesto)
	 */
	public Integer getCaracteristicasHuecosAdosadosRuidoMolesto() {
		return this.caracteristicasHuecosAdosadosRuidoMolesto;
	}

	public void setCaracteristicasHuecosAdosadosRuidoMolesto(Integer caracteristicasHuecosAdosadosRuidoMolesto) {
		this.caracteristicasHuecosAdosadosRuidoMolesto = caracteristicasHuecosAdosadosRuidoMolesto;
	}

	/**
	 * * (caracteristicas_instalaciones_atraviesan_recintos)
	 */
	public Integer getCaracteristicasInstalacionesAtraviesanRecintos() {
		return this.caracteristicasInstalacionesAtraviesanRecintos;
	}

	public void setCaracteristicasInstalacionesAtraviesanRecintos(Integer caracteristicasInstalacionesAtraviesanRecintos) {
		this.caracteristicasInstalacionesAtraviesanRecintos = caracteristicasInstalacionesAtraviesanRecintos;
	}

	/**
	 * * (caracteristicas_instalaciones_conectan_recintos)
	 */
	public Integer getCaracteristicasInstalacionesConectanRecintos() {
		return this.caracteristicasInstalacionesConectanRecintos;
	}

	public void setCaracteristicasInstalacionesConectanRecintos(Integer caracteristicasInstalacionesConectanRecintos) {
		this.caracteristicasInstalacionesConectanRecintos = caracteristicasInstalacionesConectanRecintos;
	}

	/**
	 * * (caracteristicas_pilares_conectan_recintos)
	 */
	public Integer getCaracteristicasPilaresConectanRecintos() {
		return this.caracteristicasPilaresConectanRecintos;
	}

	public void setCaracteristicasPilaresConectanRecintos(Integer caracteristicasPilaresConectanRecintos) {
		this.caracteristicasPilaresConectanRecintos = caracteristicasPilaresConectanRecintos;
	}

	/**
	 * * (caracteristicas_pilares_conectan_recintos_revestidos)
	 */
	public Integer getCaracteristicasPilaresConectanRecintosRevestidos() {
		return this.caracteristicasPilaresConectanRecintosRevestidos;
	}

	public void setCaracteristicasPilaresConectanRecintosRevestidos(Integer caracteristicasPilaresConectanRecintosRevestidos) {
		this.caracteristicasPilaresConectanRecintosRevestidos = caracteristicasPilaresConectanRecintosRevestidos;
	}

	/**
	 * * (caracteristicas_tuberias_ancladas)
	 */
	public Integer getCaracteristicasTuberiasAncladas() {
		return this.caracteristicasTuberiasAncladas;
	}

	public void setCaracteristicasTuberiasAncladas(Integer caracteristicasTuberiasAncladas) {
		this.caracteristicasTuberiasAncladas = caracteristicasTuberiasAncladas;
	}

	public String getDeficienciasObservaciones() {
		return this.deficienciasObservaciones;
	}

	public void setDeficienciasObservaciones(String deficienciasObservaciones) {
		this.deficienciasObservaciones = deficienciasObservaciones;
	}

	public Integer getEstadoSeparacionBueno() {
		return this.estadoSeparacionBueno;
	}

	public void setEstadoSeparacionBueno(Integer estadoSeparacionBueno) {
		this.estadoSeparacionBueno = estadoSeparacionBueno;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	/**
	 * * (separacion_entramado_autoportante)
	 */
	public Integer getSeparacionEntramadoAutoportante() {
		return this.separacionEntramadoAutoportante;
	}

	public void setSeparacionEntramadoAutoportante(Integer separacionEntramadoAutoportante) {
		this.separacionEntramadoAutoportante = separacionEntramadoAutoportante;
	}

	/**
	 * * (separacion_entramado_autoportante_absorbente)
	 */
	public Integer getSeparacionEntramadoAutoportanteAbsorbente() {
		return this.separacionEntramadoAutoportanteAbsorbente;
	}

	public void setSeparacionEntramadoAutoportanteAbsorbente(Integer separacionEntramadoAutoportanteAbsorbente) {
		this.separacionEntramadoAutoportanteAbsorbente = separacionEntramadoAutoportanteAbsorbente;
	}

	/**
	 * * (separacion_entramado_autoportante_doshojas)
	 */
	public Integer getSeparacionEntramadoAutoportanteDoshojas() {
		return this.separacionEntramadoAutoportanteDoshojas;
	}

	public void setSeparacionEntramadoAutoportanteDoshojas(Integer separacionEntramadoAutoportanteDoshojas) {
		this.separacionEntramadoAutoportanteDoshojas = separacionEntramadoAutoportanteDoshojas;
	}

	/**
	 * * (separacion_entramado_autoportante_doshojas_espesor)
	 */
	public String getSeparacionEntramadoAutoportanteDoshojasEspesor() {
		return this.separacionEntramadoAutoportanteDoshojasEspesor;
	}

	public void setSeparacionEntramadoAutoportanteDoshojasEspesor(String separacionEntramadoAutoportanteDoshojasEspesor) {
		this.separacionEntramadoAutoportanteDoshojasEspesor = separacionEntramadoAutoportanteDoshojasEspesor;
	}

	/**
	 * * (separacion_entramado_autoportante_unahoja)
	 */
	public Integer getSeparacionEntramadoAutoportanteUnahoja() {
		return this.separacionEntramadoAutoportanteUnahoja;
	}

	public void setSeparacionEntramadoAutoportanteUnahoja(Integer separacionEntramadoAutoportanteUnahoja) {
		this.separacionEntramadoAutoportanteUnahoja = separacionEntramadoAutoportanteUnahoja;
	}

	/**
	 * * (separacion_entramado_autoportante_unahoja_espesor)
	 */
	public String getSeparacionEntramadoAutoportanteUnahojaEspesor() {
		return this.separacionEntramadoAutoportanteUnahojaEspesor;
	}

	public void setSeparacionEntramadoAutoportanteUnahojaEspesor(String separacionEntramadoAutoportanteUnahojaEspesor) {
		this.separacionEntramadoAutoportanteUnahojaEspesor = separacionEntramadoAutoportanteUnahojaEspesor;
	}

	public Integer getSeparacionEntramadoMadera() {
		return this.separacionEntramadoMadera;
	}

	public void setSeparacionEntramadoMadera(Integer separacionEntramadoMadera) {
		this.separacionEntramadoMadera = separacionEntramadoMadera;
	}

	/**
	 * * (separacion_entramado_madera_espesor)
	 */
	public Integer getSeparacionEntramadoMaderaEspesor() {
		return this.separacionEntramadoMaderaEspesor;
	}

	public void setSeparacionEntramadoMaderaEspesor(Integer separacionEntramadoMaderaEspesor) {
		this.separacionEntramadoMaderaEspesor = separacionEntramadoMaderaEspesor;
	}

	/**
	 * * (separacion_entramado_madera_revestido)
	 */
	public Integer getSeparacionEntramadoMaderaRevestido() {
		return this.separacionEntramadoMaderaRevestido;
	}

	public void setSeparacionEntramadoMaderaRevestido(Integer separacionEntramadoMaderaRevestido) {
		this.separacionEntramadoMaderaRevestido = separacionEntramadoMaderaRevestido;
	}

	public Integer getSeparacionFabrica() {
		return this.separacionFabrica;
	}

	public void setSeparacionFabrica(Integer separacionFabrica) {
		this.separacionFabrica = separacionFabrica;
	}

	public Integer getSeparacionFabricaRevestido() {
		return this.separacionFabricaRevestido;
	}

	public void setSeparacionFabricaRevestido(Integer separacionFabricaRevestido) {
		this.separacionFabricaRevestido = separacionFabricaRevestido;
	}

	public Integer getSeparacionOtros() {
		return this.separacionOtros;
	}

	public void setSeparacionOtros(Integer separacionOtros) {
		this.separacionOtros = separacionOtros;
	}

	public String getSeparacionOtrosTexto() {
		return this.separacionOtrosTexto;
	}

	public void setSeparacionOtrosTexto(String separacionOtrosTexto) {
		this.separacionOtrosTexto = separacionOtrosTexto;
	}

	/**
	 * * (tabiques_entramado_autoportante_metalico)
	 */
	public Integer getTabiquesEntramadoAutoportanteMetalico() {
		return this.tabiquesEntramadoAutoportanteMetalico;
	}

	public void setTabiquesEntramadoAutoportanteMetalico(Integer tabiquesEntramadoAutoportanteMetalico) {
		this.tabiquesEntramadoAutoportanteMetalico = tabiquesEntramadoAutoportanteMetalico;
	}

	/**
	 * * (tabiques_entramado_autoportante_metalico_espesor)
	 */
	public String getTabiquesEntramadoAutoportanteMetalicoEspesor() {
		return this.tabiquesEntramadoAutoportanteMetalicoEspesor;
	}

	public void setTabiquesEntramadoAutoportanteMetalicoEspesor(String tabiquesEntramadoAutoportanteMetalicoEspesor) {
		this.tabiquesEntramadoAutoportanteMetalicoEspesor = tabiquesEntramadoAutoportanteMetalicoEspesor;
	}

	/**
	 * * (tabiques_entramado_madera_relleno)
	 */
	public Integer getTabiquesEntramadoMaderaRelleno() {
		return this.tabiquesEntramadoMaderaRelleno;
	}

	public void setTabiquesEntramadoMaderaRelleno(Integer tabiquesEntramadoMaderaRelleno) {
		this.tabiquesEntramadoMaderaRelleno = tabiquesEntramadoMaderaRelleno;
	}

	/**
	 * * (tabiques_entramado_madera_relleno_espesor)
	 */
	public String getTabiquesEntramadoMaderaRellenoEspesor() {
		return this.tabiquesEntramadoMaderaRellenoEspesor;
	}

	public void setTabiquesEntramadoMaderaRellenoEspesor(String tabiquesEntramadoMaderaRellenoEspesor) {
		this.tabiquesEntramadoMaderaRellenoEspesor = tabiquesEntramadoMaderaRellenoEspesor;
	}

	public Integer getTabiquesFabrica() {
		return this.tabiquesFabrica;
	}

	public void setTabiquesFabrica(Integer tabiquesFabrica) {
		this.tabiquesFabrica = tabiquesFabrica;
	}

	public Integer getZonaComunHallPuerta() {
		return this.zonaComunHallPuerta;
	}

	public void setZonaComunHallPuerta(Integer zonaComunHallPuerta) {
		this.zonaComunHallPuerta = zonaComunHallPuerta;
	}

	/**
	 * * (zona_comun_puertas_acusticamente_favorables)
	 */
	public Integer getZonaComunPuertasAcusticamenteFavorables() {
		return this.zonaComunPuertasAcusticamenteFavorables;
	}

	public void setZonaComunPuertasAcusticamenteFavorables(Integer zonaComunPuertasAcusticamenteFavorables) {
		this.zonaComunPuertasAcusticamenteFavorables = zonaComunPuertasAcusticamenteFavorables;
	}

}
