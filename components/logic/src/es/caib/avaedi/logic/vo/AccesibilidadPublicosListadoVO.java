package es.caib.avaedi.logic.vo;

import java.io.Serializable;

import org.directwebremoting.annotations.DataTransferObject;

import es.caib.avaedi.at4forms.common.util.FormData2Java;

/**
 * TransferObject para la implementacion del listado AccesibilidadPublicos
 */
@DataTransferObject
public class AccesibilidadPublicosListadoVO extends InspeccionBaseVO implements java.io.Serializable {

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
	 * (alojamientosaccesibles_1porcada_50)
	 */
	private String alojamientosaccesibles1porcada50;
	/**
	 * (alojamientosaccesibles_minimo_1)
	 */
	private String alojamientosaccesiblesMinimo1;
	/**
	 * (alojamientosaccesibles_minimo_2)
	 */
	private String alojamientosaccesiblesMinimo2;
	/**
	 * (alojamientosaccesibles_minimo_4)
	 */
	private String alojamientosaccesiblesMinimo4;
	/**
	 * (alojamientosaccesibles_minimo_6)
	 */
	private String alojamientosaccesiblesMinimo6;
	/**
	 * (alojamientosaccesibles_minimo_8)
	 */
	private String alojamientosaccesiblesMinimo8;
	/**
	 * (alojamientosaccesibles_observaciones)
	 */
	private String alojamientosaccesiblesObservaciones;
	/**
	 * (aparcamiento_comercial_porfraccion)
	 */
	private String aparcamientoComercialPorfraccion;
	private String aparcamientoObservaciones;
	/**
	 * (aparcamiento_otrosusos_minimoaparcamientos_unamasporfraccion)
	 */
	private String aparcamientoOtrosusosMinimoaparcamientosUnamasporfraccion;
	/**
	 * (aparcamiento_otrosusos_minimoaparcamientos_unaporfraccion)
	 */
	private String aparcamientoOtrosusosMinimoaparcamientosUnaporfraccion;
	/**
	 * (aparcamiento_residencialpublico_poralojamiento)
	 */
	private String aparcamientoResidencialpublicoPoralojamiento;
	private String aparcamientoSillaruedas;
	private Integer entreplantasAccesible;
	/**
	 * (entreplantas_accesible_ascensornoaccesible)
	 */
	private String entreplantasAccesibleAscensornoaccesible;
	/**
	 * (entreplantas_accesible_ascensornoaccesible_dimensiones)
	 */
	private String entreplantasAccesibleAscensornoaccesibleDimensiones;
	/**
	 * (entreplantas_accesible_ascensororampaaccesible)
	 */
	private String entreplantasAccesibleAscensororampaaccesible;
	/**
	 * (entreplantas_accesible_rampaascensornoaccesible)
	 */
	private String entreplantasAccesibleRampaascensornoaccesible;
	/**
	 * (entreplantas_elementosaccesibles)
	 */
	private Integer entreplantasElementosaccesibles;
	/**
	 * (entreplantas_elementosaccesibles_ascensornoaccesible)
	 */
	private String entreplantasElementosaccesiblesAscensornoaccesible;
	/**
	 * (entreplantas_elementosaccesibles_ascensornoaccesible_dimensione)
	 */
	private String entreplantasElementosaccesiblesAscensornoaccesibleDimensione;
	/**
	 * (entreplantas_elementosaccesibles_ascensororampaaccesible)
	 */
	private String entreplantasElementosaccesiblesAscensororampaaccesible;
	/**
	 * (entreplantas_elementosaccesibles_rampaascensornoaccesible)
	 */
	private String entreplantasElementosaccesiblesRampaascensornoaccesible;
	private Integer entreplantasNoaccesible;
	/**
	 * (entreplantas_noaccesible_ascensornoaccesible)
	 */
	private String entreplantasNoaccesibleAscensornoaccesible;
	/**
	 * (entreplantas_noaccesible_ascensornoaccesible_dimensiones)
	 */
	private String entreplantasNoaccesibleAscensornoaccesibleDimensiones;
	/**
	 * (entreplantas_noaccesible_ascensororampaaccesible)
	 */
	private String entreplantasNoaccesibleAscensororampaaccesible;
	/**
	 * (entreplantas_noaccesible_rampaascensornoaccesible)
	 */
	private String entreplantasNoaccesibleRampaascensornoaccesible;
	private String entreplantasObservaciones;
	private Integer entreplantasZonasusopublico;
	/**
	 * (entreplantas_zonasusopublico_ascensornoaccesible)
	 */
	private String entreplantasZonasusopublicoAscensornoaccesible;
	/**
	 * (entreplantas_zonasusopublico_ascensornoaccesible_dimensiones)
	 */
	private String entreplantasZonasusopublicoAscensornoaccesibleDimensiones;
	/**
	 * (entreplantas_zonasusopublico_ascensororampaaccesible)
	 */
	private String entreplantasZonasusopublicoAscensororampaaccesible;
	/**
	 * (entreplantas_zonasusopublico_rampaascensornoaccesible)
	 */
	private String entreplantasZonasusopublicoRampaascensornoaccesible;
	private Integer esTecnicoInspeccion;
	/**
	 * (exterior_edificioitinerarioaccesible_viapublica)
	 */
	private Integer exteriorEdificioitinerarioaccesibleViapublica;
	/**
	 * (exterior_edificioitinerarioaccesible_zonascomunes)
	 */
	private Integer exteriorEdificioitinerarioaccesibleZonascomunes;
	private String exteriorObservaciones;
	/**
	 * (informacionsenalizacion_ascensores)
	 */
	private String informacionsenalizacionAscensores;
	/**
	 * (informacionsenalizacion_ascensores_brailearabigo)
	 */
	private String informacionsenalizacionAscensoresBrailearabigo;
	/**
	 * (informacionsenalizacion_ascensores_numeroplanta)
	 */
	private String informacionsenalizacionAscensoresNumeroplanta;
	/**
	 * (informacionsenalizacion_bandasvisualestactiles)
	 */
	private String informacionsenalizacionBandasvisualestactiles;
	/**
	 * (informacionsenalizacion_bandasvisualestactiles_arranqueescalera)
	 */
	private String informacionsenalizacionBandasvisualestactilesArranqueescalera;
	/**
	 * (informacionsenalizacion_bandasvisualestactiles_colorcontrastado)
	 */
	private String informacionsenalizacionBandasvisualestactilesColorcontrastado;
	/**
	 * (informacionsenalizacion_bandasvisualestactiles_itinerarioaccesi)
	 */
	private String informacionsenalizacionBandasvisualestactilesItinerarioaccesi;
	/**
	 * (informacionsenalizacion_bandasvisualestactiles_relieveexterior)
	 */
	private String informacionsenalizacionBandasvisualestactilesRelieveexterior;
	/**
	 * (informacionsenalizacion_bandasvisualestactiles_relieveinterior)
	 */
	private String informacionsenalizacionBandasvisualestactilesRelieveinterior;
	/**
	 * (informacionsenalizacion_buclemagnetico)
	 */
	private String informacionsenalizacionBuclemagnetico;
	/**
	 * (informacionsenalizacion_buclemagnetico_senalizado)
	 */
	private String informacionsenalizacionBuclemagneticoSenalizado;
	/**
	 * (informacionsenalizacion_observaciones)
	 */
	private String informacionsenalizacionObservaciones;
	/**
	 * (informacionsenalizacion_privado_sia_aparcamiento)
	 */
	private String informacionsenalizacionPrivadoSiaAparcamiento;
	/**
	 * (informacionsenalizacion_privado_sia_ascensores)
	 */
	private String informacionsenalizacionPrivadoSiaAscensores;
	/**
	 * (informacionsenalizacion_privado_sia_entradas)
	 */
	private String informacionsenalizacionPrivadoSiaEntradas;
	/**
	 * (informacionsenalizacion_privado_sia_itinerarios)
	 */
	private String informacionsenalizacionPrivadoSiaItinerarios;
	/**
	 * (informacionsenalizacion_privado_sia_plazasreservadas)
	 */
	private String informacionsenalizacionPrivadoSiaPlazasreservadas;
	/**
	 * (informacionsenalizacion_publico_sia_aparcamiento)
	 */
	private String informacionsenalizacionPublicoSiaAparcamiento;
	/**
	 * (informacionsenalizacion_publico_sia_ascensores)
	 */
	private String informacionsenalizacionPublicoSiaAscensores;
	/**
	 * (informacionsenalizacion_publico_sia_entradas)
	 */
	private String informacionsenalizacionPublicoSiaEntradas;
	/**
	 * (informacionsenalizacion_publico_sia_itinerarios)
	 */
	private String informacionsenalizacionPublicoSiaItinerarios;
	/**
	 * (informacionsenalizacion_publico_sia_plazasreservadas)
	 */
	private String informacionsenalizacionPublicoSiaPlazasreservadas;
	/**
	 * (informacionsenalizacion_publico_sia_puntosatencion)
	 */
	private String informacionsenalizacionPublicoSiaPuntosatencion;
	/**
	 * (informacionsenalizacion_publico_sia_servicioshigienicos)
	 */
	private String informacionsenalizacionPublicoSiaServicioshigienicos;
	/**
	 * (informacionsenalizacion_servicioshigienicossenalizados)
	 */
	private String informacionsenalizacionServicioshigienicossenalizados;
	/**
	 * (informacionsenalizacion_sianorma)
	 */
	private String informacionsenalizacionSianorma;
	/**
	 * (informacionsenalizacion_todosusos_observaciones)
	 */
	private String informacionsenalizacionTodosusosObservaciones;
	private String mecanismosAccesibles;
	private String mecanismosObservaciones;
	private String mobiliariofijoObservaciones;
	private String mobiliariofijoPuntoaccesible;
	private String nif;
	private String piscinasEntradaaccesible;
	private String piscinasObservaciones;
	/**
	 * (plantas_itinerarioaccesible_elementosaccesibles)
	 */
	private Integer plantasItinerarioaccesibleElementosaccesibles;
	/**
	 * (plantas_itinerarioaccesible_entresi)
	 */
	private Integer plantasItinerarioaccesibleEntresi;
	/**
	 * (plantas_itinerarioaccesible_observaciones)
	 */
	private String plantasItinerarioaccesibleObservaciones;
	/**
	 * (plantas_itinerarioaccesible_zonasusoprivado)
	 */
	private Integer plantasItinerarioaccesibleZonasusoprivado;
	/**
	 * (plantas_itinerarioaccesible_zonasusopublico)
	 */
	private Integer plantasItinerarioaccesibleZonasusopublico;
	/**
	 * (plazasreservadas_discapacidadauditiva)
	 */
	private String plazasreservadasDiscapacidadauditiva;
	/**
	 * (plazasreservadas_observaciones)
	 */
	private String plazasreservadasObservaciones;
	private String plazasreservadasSillaruedas;
	/**
	 * (plazasreservadas_zonaespera_sillaruedas)
	 */
	private String plazasreservadasZonaesperaSillaruedas;
	/**
	 * (servicioshigienicos_aseoaccesible)
	 */
	private String servicioshigienicosAseoaccesible;
	/**
	 * (servicioshigienicos_cabinaduchaaccesibles)
	 */
	private String servicioshigienicosCabinaduchaaccesibles;
	/**
	 * (servicioshigienicos_observaciones)
	 */
	private String servicioshigienicosObservaciones;
	private String tecnico;
	private String titulacion;

	public AccesibilidadPublicosListadoVO() {
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
	 * * (alojamientosaccesibles_1porcada_50)
	 */
	public String getAlojamientosaccesibles1porcada50() {
		return this.alojamientosaccesibles1porcada50;
	}

	public void setAlojamientosaccesibles1porcada50(String alojamientosaccesibles1porcada50) {
		this.alojamientosaccesibles1porcada50 = alojamientosaccesibles1porcada50;
	}

	/**
	 * * (alojamientosaccesibles_minimo_1)
	 */
	public String getAlojamientosaccesiblesMinimo1() {
		return this.alojamientosaccesiblesMinimo1;
	}

	public void setAlojamientosaccesiblesMinimo1(String alojamientosaccesiblesMinimo1) {
		this.alojamientosaccesiblesMinimo1 = alojamientosaccesiblesMinimo1;
	}

	/**
	 * * (alojamientosaccesibles_minimo_2)
	 */
	public String getAlojamientosaccesiblesMinimo2() {
		return this.alojamientosaccesiblesMinimo2;
	}

	public void setAlojamientosaccesiblesMinimo2(String alojamientosaccesiblesMinimo2) {
		this.alojamientosaccesiblesMinimo2 = alojamientosaccesiblesMinimo2;
	}

	/**
	 * * (alojamientosaccesibles_minimo_4)
	 */
	public String getAlojamientosaccesiblesMinimo4() {
		return this.alojamientosaccesiblesMinimo4;
	}

	public void setAlojamientosaccesiblesMinimo4(String alojamientosaccesiblesMinimo4) {
		this.alojamientosaccesiblesMinimo4 = alojamientosaccesiblesMinimo4;
	}

	/**
	 * * (alojamientosaccesibles_minimo_6)
	 */
	public String getAlojamientosaccesiblesMinimo6() {
		return this.alojamientosaccesiblesMinimo6;
	}

	public void setAlojamientosaccesiblesMinimo6(String alojamientosaccesiblesMinimo6) {
		this.alojamientosaccesiblesMinimo6 = alojamientosaccesiblesMinimo6;
	}

	/**
	 * * (alojamientosaccesibles_minimo_8)
	 */
	public String getAlojamientosaccesiblesMinimo8() {
		return this.alojamientosaccesiblesMinimo8;
	}

	public void setAlojamientosaccesiblesMinimo8(String alojamientosaccesiblesMinimo8) {
		this.alojamientosaccesiblesMinimo8 = alojamientosaccesiblesMinimo8;
	}

	/**
	 * * (alojamientosaccesibles_observaciones)
	 */
	public String getAlojamientosaccesiblesObservaciones() {
		return this.alojamientosaccesiblesObservaciones;
	}

	public void setAlojamientosaccesiblesObservaciones(String alojamientosaccesiblesObservaciones) {
		this.alojamientosaccesiblesObservaciones = alojamientosaccesiblesObservaciones;
	}

	/**
	 * * (aparcamiento_comercial_porfraccion)
	 */
	public String getAparcamientoComercialPorfraccion() {
		return this.aparcamientoComercialPorfraccion;
	}

	public void setAparcamientoComercialPorfraccion(String aparcamientoComercialPorfraccion) {
		this.aparcamientoComercialPorfraccion = aparcamientoComercialPorfraccion;
	}

	public String getAparcamientoObservaciones() {
		return this.aparcamientoObservaciones;
	}

	public void setAparcamientoObservaciones(String aparcamientoObservaciones) {
		this.aparcamientoObservaciones = aparcamientoObservaciones;
	}

	/**
	 * * (aparcamiento_otrosusos_minimoaparcamientos_unamasporfraccion)
	 */
	public String getAparcamientoOtrosusosMinimoaparcamientosUnamasporfraccion() {
		return this.aparcamientoOtrosusosMinimoaparcamientosUnamasporfraccion;
	}

	public void setAparcamientoOtrosusosMinimoaparcamientosUnamasporfraccion(String aparcamientoOtrosusosMinimoaparcamientosUnamasporfraccion) {
		this.aparcamientoOtrosusosMinimoaparcamientosUnamasporfraccion = aparcamientoOtrosusosMinimoaparcamientosUnamasporfraccion;
	}

	/**
	 * * (aparcamiento_otrosusos_minimoaparcamientos_unaporfraccion)
	 */
	public String getAparcamientoOtrosusosMinimoaparcamientosUnaporfraccion() {
		return this.aparcamientoOtrosusosMinimoaparcamientosUnaporfraccion;
	}

	public void setAparcamientoOtrosusosMinimoaparcamientosUnaporfraccion(String aparcamientoOtrosusosMinimoaparcamientosUnaporfraccion) {
		this.aparcamientoOtrosusosMinimoaparcamientosUnaporfraccion = aparcamientoOtrosusosMinimoaparcamientosUnaporfraccion;
	}

	/**
	 * * (aparcamiento_residencialpublico_poralojamiento)
	 */
	public String getAparcamientoResidencialpublicoPoralojamiento() {
		return this.aparcamientoResidencialpublicoPoralojamiento;
	}

	public void setAparcamientoResidencialpublicoPoralojamiento(String aparcamientoResidencialpublicoPoralojamiento) {
		this.aparcamientoResidencialpublicoPoralojamiento = aparcamientoResidencialpublicoPoralojamiento;
	}

	public String getAparcamientoSillaruedas() {
		return this.aparcamientoSillaruedas;
	}

	public void setAparcamientoSillaruedas(String aparcamientoSillaruedas) {
		this.aparcamientoSillaruedas = aparcamientoSillaruedas;
	}

	public Integer getEntreplantasAccesible() {
		return this.entreplantasAccesible;
	}

	public void setEntreplantasAccesible(Integer entreplantasAccesible) {
		this.entreplantasAccesible = entreplantasAccesible;
	}

	/**
	 * * (entreplantas_accesible_ascensornoaccesible)
	 */
	public String getEntreplantasAccesibleAscensornoaccesible() {
		return this.entreplantasAccesibleAscensornoaccesible;
	}

	public void setEntreplantasAccesibleAscensornoaccesible(String entreplantasAccesibleAscensornoaccesible) {
		this.entreplantasAccesibleAscensornoaccesible = entreplantasAccesibleAscensornoaccesible;
	}

	/**
	 * * (entreplantas_accesible_ascensornoaccesible_dimensiones)
	 */
	public String getEntreplantasAccesibleAscensornoaccesibleDimensiones() {
		return this.entreplantasAccesibleAscensornoaccesibleDimensiones;
	}

	public void setEntreplantasAccesibleAscensornoaccesibleDimensiones(String entreplantasAccesibleAscensornoaccesibleDimensiones) {
		this.entreplantasAccesibleAscensornoaccesibleDimensiones = entreplantasAccesibleAscensornoaccesibleDimensiones;
	}

	/**
	 * * (entreplantas_accesible_ascensororampaaccesible)
	 */
	public String getEntreplantasAccesibleAscensororampaaccesible() {
		return this.entreplantasAccesibleAscensororampaaccesible;
	}

	public void setEntreplantasAccesibleAscensororampaaccesible(String entreplantasAccesibleAscensororampaaccesible) {
		this.entreplantasAccesibleAscensororampaaccesible = entreplantasAccesibleAscensororampaaccesible;
	}

	/**
	 * * (entreplantas_accesible_rampaascensornoaccesible)
	 */
	public String getEntreplantasAccesibleRampaascensornoaccesible() {
		return this.entreplantasAccesibleRampaascensornoaccesible;
	}

	public void setEntreplantasAccesibleRampaascensornoaccesible(String entreplantasAccesibleRampaascensornoaccesible) {
		this.entreplantasAccesibleRampaascensornoaccesible = entreplantasAccesibleRampaascensornoaccesible;
	}

	/**
	 * * (entreplantas_elementosaccesibles)
	 */
	public Integer getEntreplantasElementosaccesibles() {
		return this.entreplantasElementosaccesibles;
	}

	public void setEntreplantasElementosaccesibles(Integer entreplantasElementosaccesibles) {
		this.entreplantasElementosaccesibles = entreplantasElementosaccesibles;
	}

	/**
	 * * (entreplantas_elementosaccesibles_ascensornoaccesible)
	 */
	public String getEntreplantasElementosaccesiblesAscensornoaccesible() {
		return this.entreplantasElementosaccesiblesAscensornoaccesible;
	}

	public void setEntreplantasElementosaccesiblesAscensornoaccesible(String entreplantasElementosaccesiblesAscensornoaccesible) {
		this.entreplantasElementosaccesiblesAscensornoaccesible = entreplantasElementosaccesiblesAscensornoaccesible;
	}

	/**
	 * * (entreplantas_elementosaccesibles_ascensornoaccesible_dimensione)
	 */
	public String getEntreplantasElementosaccesiblesAscensornoaccesibleDimensione() {
		return this.entreplantasElementosaccesiblesAscensornoaccesibleDimensione;
	}

	public void setEntreplantasElementosaccesiblesAscensornoaccesibleDimensione(String entreplantasElementosaccesiblesAscensornoaccesibleDimensione) {
		this.entreplantasElementosaccesiblesAscensornoaccesibleDimensione = entreplantasElementosaccesiblesAscensornoaccesibleDimensione;
	}

	/**
	 * * (entreplantas_elementosaccesibles_ascensororampaaccesible)
	 */
	public String getEntreplantasElementosaccesiblesAscensororampaaccesible() {
		return this.entreplantasElementosaccesiblesAscensororampaaccesible;
	}

	public void setEntreplantasElementosaccesiblesAscensororampaaccesible(String entreplantasElementosaccesiblesAscensororampaaccesible) {
		this.entreplantasElementosaccesiblesAscensororampaaccesible = entreplantasElementosaccesiblesAscensororampaaccesible;
	}

	/**
	 * * (entreplantas_elementosaccesibles_rampaascensornoaccesible)
	 */
	public String getEntreplantasElementosaccesiblesRampaascensornoaccesible() {
		return this.entreplantasElementosaccesiblesRampaascensornoaccesible;
	}

	public void setEntreplantasElementosaccesiblesRampaascensornoaccesible(String entreplantasElementosaccesiblesRampaascensornoaccesible) {
		this.entreplantasElementosaccesiblesRampaascensornoaccesible = entreplantasElementosaccesiblesRampaascensornoaccesible;
	}

	public Integer getEntreplantasNoaccesible() {
		return this.entreplantasNoaccesible;
	}

	public void setEntreplantasNoaccesible(Integer entreplantasNoaccesible) {
		this.entreplantasNoaccesible = entreplantasNoaccesible;
	}

	/**
	 * * (entreplantas_noaccesible_ascensornoaccesible)
	 */
	public String getEntreplantasNoaccesibleAscensornoaccesible() {
		return this.entreplantasNoaccesibleAscensornoaccesible;
	}

	public void setEntreplantasNoaccesibleAscensornoaccesible(String entreplantasNoaccesibleAscensornoaccesible) {
		this.entreplantasNoaccesibleAscensornoaccesible = entreplantasNoaccesibleAscensornoaccesible;
	}

	/**
	 * * (entreplantas_noaccesible_ascensornoaccesible_dimensiones)
	 */
	public String getEntreplantasNoaccesibleAscensornoaccesibleDimensiones() {
		return this.entreplantasNoaccesibleAscensornoaccesibleDimensiones;
	}

	public void setEntreplantasNoaccesibleAscensornoaccesibleDimensiones(String entreplantasNoaccesibleAscensornoaccesibleDimensiones) {
		this.entreplantasNoaccesibleAscensornoaccesibleDimensiones = entreplantasNoaccesibleAscensornoaccesibleDimensiones;
	}

	/**
	 * * (entreplantas_noaccesible_ascensororampaaccesible)
	 */
	public String getEntreplantasNoaccesibleAscensororampaaccesible() {
		return this.entreplantasNoaccesibleAscensororampaaccesible;
	}

	public void setEntreplantasNoaccesibleAscensororampaaccesible(String entreplantasNoaccesibleAscensororampaaccesible) {
		this.entreplantasNoaccesibleAscensororampaaccesible = entreplantasNoaccesibleAscensororampaaccesible;
	}

	/**
	 * * (entreplantas_noaccesible_rampaascensornoaccesible)
	 */
	public String getEntreplantasNoaccesibleRampaascensornoaccesible() {
		return this.entreplantasNoaccesibleRampaascensornoaccesible;
	}

	public void setEntreplantasNoaccesibleRampaascensornoaccesible(String entreplantasNoaccesibleRampaascensornoaccesible) {
		this.entreplantasNoaccesibleRampaascensornoaccesible = entreplantasNoaccesibleRampaascensornoaccesible;
	}

	public String getEntreplantasObservaciones() {
		return this.entreplantasObservaciones;
	}

	public void setEntreplantasObservaciones(String entreplantasObservaciones) {
		this.entreplantasObservaciones = entreplantasObservaciones;
	}

	public Integer getEntreplantasZonasusopublico() {
		return this.entreplantasZonasusopublico;
	}

	public void setEntreplantasZonasusopublico(Integer entreplantasZonasusopublico) {
		this.entreplantasZonasusopublico = entreplantasZonasusopublico;
	}

	/**
	 * * (entreplantas_zonasusopublico_ascensornoaccesible)
	 */
	public String getEntreplantasZonasusopublicoAscensornoaccesible() {
		return this.entreplantasZonasusopublicoAscensornoaccesible;
	}

	public void setEntreplantasZonasusopublicoAscensornoaccesible(String entreplantasZonasusopublicoAscensornoaccesible) {
		this.entreplantasZonasusopublicoAscensornoaccesible = entreplantasZonasusopublicoAscensornoaccesible;
	}

	/**
	 * * (entreplantas_zonasusopublico_ascensornoaccesible_dimensiones)
	 */
	public String getEntreplantasZonasusopublicoAscensornoaccesibleDimensiones() {
		return this.entreplantasZonasusopublicoAscensornoaccesibleDimensiones;
	}

	public void setEntreplantasZonasusopublicoAscensornoaccesibleDimensiones(String entreplantasZonasusopublicoAscensornoaccesibleDimensiones) {
		this.entreplantasZonasusopublicoAscensornoaccesibleDimensiones = entreplantasZonasusopublicoAscensornoaccesibleDimensiones;
	}

	/**
	 * * (entreplantas_zonasusopublico_ascensororampaaccesible)
	 */
	public String getEntreplantasZonasusopublicoAscensororampaaccesible() {
		return this.entreplantasZonasusopublicoAscensororampaaccesible;
	}

	public void setEntreplantasZonasusopublicoAscensororampaaccesible(String entreplantasZonasusopublicoAscensororampaaccesible) {
		this.entreplantasZonasusopublicoAscensororampaaccesible = entreplantasZonasusopublicoAscensororampaaccesible;
	}

	/**
	 * * (entreplantas_zonasusopublico_rampaascensornoaccesible)
	 */
	public String getEntreplantasZonasusopublicoRampaascensornoaccesible() {
		return this.entreplantasZonasusopublicoRampaascensornoaccesible;
	}

	public void setEntreplantasZonasusopublicoRampaascensornoaccesible(String entreplantasZonasusopublicoRampaascensornoaccesible) {
		this.entreplantasZonasusopublicoRampaascensornoaccesible = entreplantasZonasusopublicoRampaascensornoaccesible;
	}

	public Integer getEsTecnicoInspeccion() {
		return this.esTecnicoInspeccion;
	}

	public void setEsTecnicoInspeccion(Integer esTecnicoInspeccion) {
		this.esTecnicoInspeccion = esTecnicoInspeccion;
	}

	/**
	 * * (exterior_edificioitinerarioaccesible_viapublica)
	 */
	public Integer getExteriorEdificioitinerarioaccesibleViapublica() {
		return this.exteriorEdificioitinerarioaccesibleViapublica;
	}

	public void setExteriorEdificioitinerarioaccesibleViapublica(Integer exteriorEdificioitinerarioaccesibleViapublica) {
		this.exteriorEdificioitinerarioaccesibleViapublica = exteriorEdificioitinerarioaccesibleViapublica;
	}

	/**
	 * * (exterior_edificioitinerarioaccesible_zonascomunes)
	 */
	public Integer getExteriorEdificioitinerarioaccesibleZonascomunes() {
		return this.exteriorEdificioitinerarioaccesibleZonascomunes;
	}

	public void setExteriorEdificioitinerarioaccesibleZonascomunes(Integer exteriorEdificioitinerarioaccesibleZonascomunes) {
		this.exteriorEdificioitinerarioaccesibleZonascomunes = exteriorEdificioitinerarioaccesibleZonascomunes;
	}

	public String getExteriorObservaciones() {
		return this.exteriorObservaciones;
	}

	public void setExteriorObservaciones(String exteriorObservaciones) {
		this.exteriorObservaciones = exteriorObservaciones;
	}

	/**
	 * * (informacionsenalizacion_ascensores)
	 */
	public String getInformacionsenalizacionAscensores() {
		return this.informacionsenalizacionAscensores;
	}

	public void setInformacionsenalizacionAscensores(String informacionsenalizacionAscensores) {
		this.informacionsenalizacionAscensores = informacionsenalizacionAscensores;
	}

	/**
	 * * (informacionsenalizacion_ascensores_brailearabigo)
	 */
	public String getInformacionsenalizacionAscensoresBrailearabigo() {
		return this.informacionsenalizacionAscensoresBrailearabigo;
	}

	public void setInformacionsenalizacionAscensoresBrailearabigo(String informacionsenalizacionAscensoresBrailearabigo) {
		this.informacionsenalizacionAscensoresBrailearabigo = informacionsenalizacionAscensoresBrailearabigo;
	}

	/**
	 * * (informacionsenalizacion_ascensores_numeroplanta)
	 */
	public String getInformacionsenalizacionAscensoresNumeroplanta() {
		return this.informacionsenalizacionAscensoresNumeroplanta;
	}

	public void setInformacionsenalizacionAscensoresNumeroplanta(String informacionsenalizacionAscensoresNumeroplanta) {
		this.informacionsenalizacionAscensoresNumeroplanta = informacionsenalizacionAscensoresNumeroplanta;
	}

	/**
	 * * (informacionsenalizacion_bandasvisualestactiles)
	 */
	public String getInformacionsenalizacionBandasvisualestactiles() {
		return this.informacionsenalizacionBandasvisualestactiles;
	}

	public void setInformacionsenalizacionBandasvisualestactiles(String informacionsenalizacionBandasvisualestactiles) {
		this.informacionsenalizacionBandasvisualestactiles = informacionsenalizacionBandasvisualestactiles;
	}

	/**
	 * * (informacionsenalizacion_bandasvisualestactiles_arranqueescalera)
	 */
	public String getInformacionsenalizacionBandasvisualestactilesArranqueescalera() {
		return this.informacionsenalizacionBandasvisualestactilesArranqueescalera;
	}

	public void setInformacionsenalizacionBandasvisualestactilesArranqueescalera(String informacionsenalizacionBandasvisualestactilesArranqueescalera) {
		this.informacionsenalizacionBandasvisualestactilesArranqueescalera = informacionsenalizacionBandasvisualestactilesArranqueescalera;
	}

	/**
	 * * (informacionsenalizacion_bandasvisualestactiles_colorcontrastado)
	 */
	public String getInformacionsenalizacionBandasvisualestactilesColorcontrastado() {
		return this.informacionsenalizacionBandasvisualestactilesColorcontrastado;
	}

	public void setInformacionsenalizacionBandasvisualestactilesColorcontrastado(String informacionsenalizacionBandasvisualestactilesColorcontrastado) {
		this.informacionsenalizacionBandasvisualestactilesColorcontrastado = informacionsenalizacionBandasvisualestactilesColorcontrastado;
	}

	/**
	 * * (informacionsenalizacion_bandasvisualestactiles_itinerarioaccesi)
	 */
	public String getInformacionsenalizacionBandasvisualestactilesItinerarioaccesi() {
		return this.informacionsenalizacionBandasvisualestactilesItinerarioaccesi;
	}

	public void setInformacionsenalizacionBandasvisualestactilesItinerarioaccesi(String informacionsenalizacionBandasvisualestactilesItinerarioaccesi) {
		this.informacionsenalizacionBandasvisualestactilesItinerarioaccesi = informacionsenalizacionBandasvisualestactilesItinerarioaccesi;
	}

	/**
	 * * (informacionsenalizacion_bandasvisualestactiles_relieveexterior)
	 */
	public String getInformacionsenalizacionBandasvisualestactilesRelieveexterior() {
		return this.informacionsenalizacionBandasvisualestactilesRelieveexterior;
	}

	public void setInformacionsenalizacionBandasvisualestactilesRelieveexterior(String informacionsenalizacionBandasvisualestactilesRelieveexterior) {
		this.informacionsenalizacionBandasvisualestactilesRelieveexterior = informacionsenalizacionBandasvisualestactilesRelieveexterior;
	}

	/**
	 * * (informacionsenalizacion_bandasvisualestactiles_relieveinterior)
	 */
	public String getInformacionsenalizacionBandasvisualestactilesRelieveinterior() {
		return this.informacionsenalizacionBandasvisualestactilesRelieveinterior;
	}

	public void setInformacionsenalizacionBandasvisualestactilesRelieveinterior(String informacionsenalizacionBandasvisualestactilesRelieveinterior) {
		this.informacionsenalizacionBandasvisualestactilesRelieveinterior = informacionsenalizacionBandasvisualestactilesRelieveinterior;
	}

	/**
	 * * (informacionsenalizacion_buclemagnetico)
	 */
	public String getInformacionsenalizacionBuclemagnetico() {
		return this.informacionsenalizacionBuclemagnetico;
	}

	public void setInformacionsenalizacionBuclemagnetico(String informacionsenalizacionBuclemagnetico) {
		this.informacionsenalizacionBuclemagnetico = informacionsenalizacionBuclemagnetico;
	}

	/**
	 * * (informacionsenalizacion_buclemagnetico_senalizado)
	 */
	public String getInformacionsenalizacionBuclemagneticoSenalizado() {
		return this.informacionsenalizacionBuclemagneticoSenalizado;
	}

	public void setInformacionsenalizacionBuclemagneticoSenalizado(String informacionsenalizacionBuclemagneticoSenalizado) {
		this.informacionsenalizacionBuclemagneticoSenalizado = informacionsenalizacionBuclemagneticoSenalizado;
	}

	/**
	 * * (informacionsenalizacion_observaciones)
	 */
	public String getInformacionsenalizacionObservaciones() {
		return this.informacionsenalizacionObservaciones;
	}

	public void setInformacionsenalizacionObservaciones(String informacionsenalizacionObservaciones) {
		this.informacionsenalizacionObservaciones = informacionsenalizacionObservaciones;
	}

	/**
	 * * (informacionsenalizacion_privado_sia_aparcamiento)
	 */
	public String getInformacionsenalizacionPrivadoSiaAparcamiento() {
		return this.informacionsenalizacionPrivadoSiaAparcamiento;
	}

	public void setInformacionsenalizacionPrivadoSiaAparcamiento(String informacionsenalizacionPrivadoSiaAparcamiento) {
		this.informacionsenalizacionPrivadoSiaAparcamiento = informacionsenalizacionPrivadoSiaAparcamiento;
	}

	/**
	 * * (informacionsenalizacion_privado_sia_ascensores)
	 */
	public String getInformacionsenalizacionPrivadoSiaAscensores() {
		return this.informacionsenalizacionPrivadoSiaAscensores;
	}

	public void setInformacionsenalizacionPrivadoSiaAscensores(String informacionsenalizacionPrivadoSiaAscensores) {
		this.informacionsenalizacionPrivadoSiaAscensores = informacionsenalizacionPrivadoSiaAscensores;
	}

	/**
	 * * (informacionsenalizacion_privado_sia_entradas)
	 */
	public String getInformacionsenalizacionPrivadoSiaEntradas() {
		return this.informacionsenalizacionPrivadoSiaEntradas;
	}

	public void setInformacionsenalizacionPrivadoSiaEntradas(String informacionsenalizacionPrivadoSiaEntradas) {
		this.informacionsenalizacionPrivadoSiaEntradas = informacionsenalizacionPrivadoSiaEntradas;
	}

	/**
	 * * (informacionsenalizacion_privado_sia_itinerarios)
	 */
	public String getInformacionsenalizacionPrivadoSiaItinerarios() {
		return this.informacionsenalizacionPrivadoSiaItinerarios;
	}

	public void setInformacionsenalizacionPrivadoSiaItinerarios(String informacionsenalizacionPrivadoSiaItinerarios) {
		this.informacionsenalizacionPrivadoSiaItinerarios = informacionsenalizacionPrivadoSiaItinerarios;
	}

	/**
	 * * (informacionsenalizacion_privado_sia_plazasreservadas)
	 */
	public String getInformacionsenalizacionPrivadoSiaPlazasreservadas() {
		return this.informacionsenalizacionPrivadoSiaPlazasreservadas;
	}

	public void setInformacionsenalizacionPrivadoSiaPlazasreservadas(String informacionsenalizacionPrivadoSiaPlazasreservadas) {
		this.informacionsenalizacionPrivadoSiaPlazasreservadas = informacionsenalizacionPrivadoSiaPlazasreservadas;
	}

	/**
	 * * (informacionsenalizacion_publico_sia_aparcamiento)
	 */
	public String getInformacionsenalizacionPublicoSiaAparcamiento() {
		return this.informacionsenalizacionPublicoSiaAparcamiento;
	}

	public void setInformacionsenalizacionPublicoSiaAparcamiento(String informacionsenalizacionPublicoSiaAparcamiento) {
		this.informacionsenalizacionPublicoSiaAparcamiento = informacionsenalizacionPublicoSiaAparcamiento;
	}

	/**
	 * * (informacionsenalizacion_publico_sia_ascensores)
	 */
	public String getInformacionsenalizacionPublicoSiaAscensores() {
		return this.informacionsenalizacionPublicoSiaAscensores;
	}

	public void setInformacionsenalizacionPublicoSiaAscensores(String informacionsenalizacionPublicoSiaAscensores) {
		this.informacionsenalizacionPublicoSiaAscensores = informacionsenalizacionPublicoSiaAscensores;
	}

	/**
	 * * (informacionsenalizacion_publico_sia_entradas)
	 */
	public String getInformacionsenalizacionPublicoSiaEntradas() {
		return this.informacionsenalizacionPublicoSiaEntradas;
	}

	public void setInformacionsenalizacionPublicoSiaEntradas(String informacionsenalizacionPublicoSiaEntradas) {
		this.informacionsenalizacionPublicoSiaEntradas = informacionsenalizacionPublicoSiaEntradas;
	}

	/**
	 * * (informacionsenalizacion_publico_sia_itinerarios)
	 */
	public String getInformacionsenalizacionPublicoSiaItinerarios() {
		return this.informacionsenalizacionPublicoSiaItinerarios;
	}

	public void setInformacionsenalizacionPublicoSiaItinerarios(String informacionsenalizacionPublicoSiaItinerarios) {
		this.informacionsenalizacionPublicoSiaItinerarios = informacionsenalizacionPublicoSiaItinerarios;
	}

	/**
	 * * (informacionsenalizacion_publico_sia_plazasreservadas)
	 */
	public String getInformacionsenalizacionPublicoSiaPlazasreservadas() {
		return this.informacionsenalizacionPublicoSiaPlazasreservadas;
	}

	public void setInformacionsenalizacionPublicoSiaPlazasreservadas(String informacionsenalizacionPublicoSiaPlazasreservadas) {
		this.informacionsenalizacionPublicoSiaPlazasreservadas = informacionsenalizacionPublicoSiaPlazasreservadas;
	}

	/**
	 * * (informacionsenalizacion_publico_sia_puntosatencion)
	 */
	public String getInformacionsenalizacionPublicoSiaPuntosatencion() {
		return this.informacionsenalizacionPublicoSiaPuntosatencion;
	}

	public void setInformacionsenalizacionPublicoSiaPuntosatencion(String informacionsenalizacionPublicoSiaPuntosatencion) {
		this.informacionsenalizacionPublicoSiaPuntosatencion = informacionsenalizacionPublicoSiaPuntosatencion;
	}

	/**
	 * * (informacionsenalizacion_publico_sia_servicioshigienicos)
	 */
	public String getInformacionsenalizacionPublicoSiaServicioshigienicos() {
		return this.informacionsenalizacionPublicoSiaServicioshigienicos;
	}

	public void setInformacionsenalizacionPublicoSiaServicioshigienicos(String informacionsenalizacionPublicoSiaServicioshigienicos) {
		this.informacionsenalizacionPublicoSiaServicioshigienicos = informacionsenalizacionPublicoSiaServicioshigienicos;
	}

	/**
	 * * (informacionsenalizacion_servicioshigienicossenalizados)
	 */
	public String getInformacionsenalizacionServicioshigienicossenalizados() {
		return this.informacionsenalizacionServicioshigienicossenalizados;
	}

	public void setInformacionsenalizacionServicioshigienicossenalizados(String informacionsenalizacionServicioshigienicossenalizados) {
		this.informacionsenalizacionServicioshigienicossenalizados = informacionsenalizacionServicioshigienicossenalizados;
	}

	/**
	 * * (informacionsenalizacion_sianorma)
	 */
	public String getInformacionsenalizacionSianorma() {
		return this.informacionsenalizacionSianorma;
	}

	public void setInformacionsenalizacionSianorma(String informacionsenalizacionSianorma) {
		this.informacionsenalizacionSianorma = informacionsenalizacionSianorma;
	}

	/**
	 * * (informacionsenalizacion_todosusos_observaciones)
	 */
	public String getInformacionsenalizacionTodosusosObservaciones() {
		return this.informacionsenalizacionTodosusosObservaciones;
	}

	public void setInformacionsenalizacionTodosusosObservaciones(String informacionsenalizacionTodosusosObservaciones) {
		this.informacionsenalizacionTodosusosObservaciones = informacionsenalizacionTodosusosObservaciones;
	}

	public String getMecanismosAccesibles() {
		return this.mecanismosAccesibles;
	}

	public void setMecanismosAccesibles(String mecanismosAccesibles) {
		this.mecanismosAccesibles = mecanismosAccesibles;
	}

	public String getMecanismosObservaciones() {
		return this.mecanismosObservaciones;
	}

	public void setMecanismosObservaciones(String mecanismosObservaciones) {
		this.mecanismosObservaciones = mecanismosObservaciones;
	}

	public String getMobiliariofijoObservaciones() {
		return this.mobiliariofijoObservaciones;
	}

	public void setMobiliariofijoObservaciones(String mobiliariofijoObservaciones) {
		this.mobiliariofijoObservaciones = mobiliariofijoObservaciones;
	}

	public String getMobiliariofijoPuntoaccesible() {
		return this.mobiliariofijoPuntoaccesible;
	}

	public void setMobiliariofijoPuntoaccesible(String mobiliariofijoPuntoaccesible) {
		this.mobiliariofijoPuntoaccesible = mobiliariofijoPuntoaccesible;
	}

	public String getNif() {
		return this.nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getPiscinasEntradaaccesible() {
		return this.piscinasEntradaaccesible;
	}

	public void setPiscinasEntradaaccesible(String piscinasEntradaaccesible) {
		this.piscinasEntradaaccesible = piscinasEntradaaccesible;
	}

	public String getPiscinasObservaciones() {
		return this.piscinasObservaciones;
	}

	public void setPiscinasObservaciones(String piscinasObservaciones) {
		this.piscinasObservaciones = piscinasObservaciones;
	}

	/**
	 * * (plantas_itinerarioaccesible_elementosaccesibles)
	 */
	public Integer getPlantasItinerarioaccesibleElementosaccesibles() {
		return this.plantasItinerarioaccesibleElementosaccesibles;
	}

	public void setPlantasItinerarioaccesibleElementosaccesibles(Integer plantasItinerarioaccesibleElementosaccesibles) {
		this.plantasItinerarioaccesibleElementosaccesibles = plantasItinerarioaccesibleElementosaccesibles;
	}

	/**
	 * * (plantas_itinerarioaccesible_entresi)
	 */
	public Integer getPlantasItinerarioaccesibleEntresi() {
		return this.plantasItinerarioaccesibleEntresi;
	}

	public void setPlantasItinerarioaccesibleEntresi(Integer plantasItinerarioaccesibleEntresi) {
		this.plantasItinerarioaccesibleEntresi = plantasItinerarioaccesibleEntresi;
	}

	/**
	 * * (plantas_itinerarioaccesible_observaciones)
	 */
	public String getPlantasItinerarioaccesibleObservaciones() {
		return this.plantasItinerarioaccesibleObservaciones;
	}

	public void setPlantasItinerarioaccesibleObservaciones(String plantasItinerarioaccesibleObservaciones) {
		this.plantasItinerarioaccesibleObservaciones = plantasItinerarioaccesibleObservaciones;
	}

	/**
	 * * (plantas_itinerarioaccesible_zonasusoprivado)
	 */
	public Integer getPlantasItinerarioaccesibleZonasusoprivado() {
		return this.plantasItinerarioaccesibleZonasusoprivado;
	}

	public void setPlantasItinerarioaccesibleZonasusoprivado(Integer plantasItinerarioaccesibleZonasusoprivado) {
		this.plantasItinerarioaccesibleZonasusoprivado = plantasItinerarioaccesibleZonasusoprivado;
	}

	/**
	 * * (plantas_itinerarioaccesible_zonasusopublico)
	 */
	public Integer getPlantasItinerarioaccesibleZonasusopublico() {
		return this.plantasItinerarioaccesibleZonasusopublico;
	}

	public void setPlantasItinerarioaccesibleZonasusopublico(Integer plantasItinerarioaccesibleZonasusopublico) {
		this.plantasItinerarioaccesibleZonasusopublico = plantasItinerarioaccesibleZonasusopublico;
	}

	/**
	 * * (plazasreservadas_discapacidadauditiva)
	 */
	public String getPlazasreservadasDiscapacidadauditiva() {
		return this.plazasreservadasDiscapacidadauditiva;
	}

	public void setPlazasreservadasDiscapacidadauditiva(String plazasreservadasDiscapacidadauditiva) {
		this.plazasreservadasDiscapacidadauditiva = plazasreservadasDiscapacidadauditiva;
	}

	/**
	 * * (plazasreservadas_observaciones)
	 */
	public String getPlazasreservadasObservaciones() {
		return this.plazasreservadasObservaciones;
	}

	public void setPlazasreservadasObservaciones(String plazasreservadasObservaciones) {
		this.plazasreservadasObservaciones = plazasreservadasObservaciones;
	}

	public String getPlazasreservadasSillaruedas() {
		return this.plazasreservadasSillaruedas;
	}

	public void setPlazasreservadasSillaruedas(String plazasreservadasSillaruedas) {
		this.plazasreservadasSillaruedas = plazasreservadasSillaruedas;
	}

	/**
	 * * (plazasreservadas_zonaespera_sillaruedas)
	 */
	public String getPlazasreservadasZonaesperaSillaruedas() {
		return this.plazasreservadasZonaesperaSillaruedas;
	}

	public void setPlazasreservadasZonaesperaSillaruedas(String plazasreservadasZonaesperaSillaruedas) {
		this.plazasreservadasZonaesperaSillaruedas = plazasreservadasZonaesperaSillaruedas;
	}

	/**
	 * * (servicioshigienicos_aseoaccesible)
	 */
	public String getServicioshigienicosAseoaccesible() {
		return this.servicioshigienicosAseoaccesible;
	}

	public void setServicioshigienicosAseoaccesible(String servicioshigienicosAseoaccesible) {
		this.servicioshigienicosAseoaccesible = servicioshigienicosAseoaccesible;
	}

	/**
	 * * (servicioshigienicos_cabinaduchaaccesibles)
	 */
	public String getServicioshigienicosCabinaduchaaccesibles() {
		return this.servicioshigienicosCabinaduchaaccesibles;
	}

	public void setServicioshigienicosCabinaduchaaccesibles(String servicioshigienicosCabinaduchaaccesibles) {
		this.servicioshigienicosCabinaduchaaccesibles = servicioshigienicosCabinaduchaaccesibles;
	}

	/**
	 * * (servicioshigienicos_observaciones)
	 */
	public String getServicioshigienicosObservaciones() {
		return this.servicioshigienicosObservaciones;
	}

	public void setServicioshigienicosObservaciones(String servicioshigienicosObservaciones) {
		this.servicioshigienicosObservaciones = servicioshigienicosObservaciones;
	}

	public String getTecnico() {
		return this.tecnico;
	}

	public void setTecnico(String tecnico) {
		this.tecnico = tecnico;
	}

	public String getTitulacion() {
		return this.titulacion;
	}

	public void setTitulacion(String titulacion) {
		this.titulacion = titulacion;
	}

}
