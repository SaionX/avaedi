package es.caib.avaedi.logic.vo;

import java.io.Serializable;

import org.directwebremoting.annotations.DataTransferObject;

import es.caib.avaedi.at4forms.common.util.FormData2Java;

/**
 * TransferObject para la implementacion del listado AcusticaRuidoInstalaciones
 */
@DataTransferObject
public class AcusticaRuidoInstalacionesListadoVO extends InspeccionBaseVO implements java.io.Serializable {

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
	 * (equipos_instalaciones_colindantes)
	 */
	private Integer equiposInstalacionesColindantes;
	/**
	 * (equipos_instalaciones_conductos_anclados)
	 */
	private Integer equiposInstalacionesConductosAnclados;
	/**
	 * (equipos_instalaciones_conectores_flexibles)
	 */
	private Integer equiposInstalacionesConectoresFlexibles;
	/**
	 * (equipos_instalaciones_holguras_selladas)
	 */
	private Integer equiposInstalacionesHolgurasSelladas;
	/**
	 * (equipos_instalaciones_ruido_molesto)
	 */
	private Integer equiposInstalacionesRuidoMolesto;
	/**
	 * (equipos_instalaciones_ruido_molesto_tipo_localizacion)
	 */
	private String equiposInstalacionesRuidoMolestoTipoLocalizacion;
	/**
	 * (equipos_instalaciones_sistema_amortiguante)
	 */
	private Integer equiposInstalacionesSistemaAmortiguante;
	/**
	 * (equipos_instalaciones_zonas_exteriores)
	 */
	private Integer equiposInstalacionesZonasExteriores;
	/**
	 * (equipos_instalaciones_zonas_exteriores_pantallas)
	 */
	private Integer equiposInstalacionesZonasExterioresPantallas;
	private String observaciones;
	private Integer otrasAscensoresColindantes;
	/**
	 * (otras_ascensores_cuadro_maniobras)
	 */
	private Integer otrasAscensoresCuadroManiobras;
	/**
	 * (otras_ascensores_cuarto_maquinas)
	 */
	private Integer otrasAscensoresCuartoMaquinas;
	private Integer otrasAscensoresRuidoMolesto;
	/**
	 * (otras_ascensores_ruido_molesto_tipo_localizacion)
	 */
	private String otrasAscensoresRuidoMolestoTipoLocalizacion;
	/**
	 * (otras_ascensores_sistema_amortiguante)
	 */
	private Integer otrasAscensoresSistemaAmortiguante;
	private Integer otrasAscensoresTrasdosado;
	/**
	 * (otras_cuartos_humedos_aire_acondicionado)
	 */
	private Integer otrasCuartosHumedosAireAcondicionado;
	/**
	 * (otras_cuartos_humedos_luminarias_empotradas)
	 */
	private Integer otrasCuartosHumedosLuminariasEmpotradas;
	/**
	 * (otras_cuartos_humedos_ruido_molesto)
	 */
	private Integer otrasCuartosHumedosRuidoMolesto;
	/**
	 * (otras_cuartos_humedos_ruido_molesto_tipo_localizacion)
	 */
	private String otrasCuartosHumedosRuidoMolestoTipoLocalizacion;
	/**
	 * (otras_cuartos_humedos_saneamiento)
	 */
	private Integer otrasCuartosHumedosSaneamiento;
	/**
	 * (otras_cuartos_humedos_saneamiento_conectores_flexibles)
	 */
	private Integer otrasCuartosHumedosSaneamientoConectoresFlexibles;
	/**
	 * (otras_cuartos_humedos_saneamiento_lana_mineral)
	 */
	private Integer otrasCuartosHumedosSaneamientoLanaMineral;
	/**
	 * (otras_cuartos_humedos_saneamiento_material_elastico)
	 */
	private Integer otrasCuartosHumedosSaneamientoMaterialElastico;
	/**
	 * (otras_cuartos_humedos_saneamiento_techo_sellado)
	 */
	private Integer otrasCuartosHumedosSaneamientoTechoSellado;
	private Integer otrasPuertasGarajeAncladas;
	/**
	 * (otras_puertas_garaje_ancladas_marco_amortiguadores)
	 */
	private Integer otrasPuertasGarajeAncladasMarcoAmortiguadores;
	/**
	 * (otras_puertas_garaje_ancladas_motores_amortiguadores)
	 */
	private Integer otrasPuertasGarajeAncladasMotoresAmortiguadores;
	/**
	 * (otras_puertas_garaje_ancladas_ruido_puerta)
	 */
	private Integer otrasPuertasGarajeAncladasRuidoPuerta;
	private Integer recintosActividadRevestido;
	/**
	 * (recintos_actividad_ruido_molesto)
	 */
	private Integer recintosActividadRuidoMolesto;
	/**
	 * (recintos_actividad_ruido_molesto_tipo_localizacion)
	 */
	private String recintosActividadRuidoMolestoTipoLocalizacion;
	/**
	 * (recintos_actividad_suelo_flotante)
	 */
	private Integer recintosActividadSueloFlotante;
	/**
	 * (recintos_actividad_techo_suspendido)
	 */
	private Integer recintosActividadTechoSuspendido;
	/**
	 * (recintos_actividad_techo_suspendido_absorvente)
	 */
	private Integer recintosActividadTechoSuspendidoAbsorvente;
	/**
	 * (recintos_actividad_techo_suspendido_amortiguadores)
	 */
	private Integer recintosActividadTechoSuspendidoAmortiguadores;
	private Integer recintosActividadTiene;
	/**
	 * (recintos_actividad_tipo_localizacion)
	 */
	private String recintosActividadTipoLocalizacion;
	private Integer recintosActividadTrasdosados;
	/**
	 * (recintos_actividad_trasdosados_amortiguadores)
	 */
	private Integer recintosActividadTrasdosadosAmortiguadores;
	/**
	 * (recintos_actividad_tratamiento_absorvente)
	 */
	private Integer recintosActividadTratamientoAbsorvente;
	/**
	 * (redes_agua_ruido_molesto_tipo_localizacion)
	 */
	private String redesAguaRuidoMolestoTipoLocalizacion;
	/**
	 * (redes_aire_acondicionado_falso_techo)
	 */
	private Integer redesAireAcondicionadoFalsoTecho;
	/**
	 * (redes_aire_acondicionado_ruido_molesto)
	 */
	private Integer redesAireAcondicionadoRuidoMolesto;
	/**
	 * (redes_saneamiento_bajantes_abrazaderas)
	 */
	private Integer redesSaneamientoBajantesAbrazaderas;
	/**
	 * (redes_saneamiento_bajantes_forradas)
	 */
	private Integer redesSaneamientoBajantesForradas;
	/**
	 * (redes_saneamiento_bajantes_revestidas)
	 */
	private Integer redesSaneamientoBajantesRevestidas;
	private Integer redesSaneamientoCodoBajante;
	/**
	 * (redes_saneamiento_ruido_molesto)
	 */
	private Integer redesSaneamientoRuidoMolesto;
	/**
	 * (redes_saneamiento_ruido_molesto_tipo_localizacion)
	 */
	private String redesSaneamientoRuidoMolestoTipoLocalizacion;
	/**
	 * (redes_suministro_agua_ruido_golpe_ariete)
	 */
	private Integer redesSuministroAguaRuidoGolpeAriete;
	/**
	 * (redes_suministro_agua_ruido_molesto)
	 */
	private Integer redesSuministroAguaRuidoMolesto;
	/**
	 * (redes_suministro_agua_tuberias_forradas)
	 */
	private Integer redesSuministroAguaTuberiasForradas;
	/**
	 * (redes_ventilacion_conducto_individual)
	 */
	private Integer redesVentilacionConductoIndividual;
	/**
	 * (redes_ventilacion_conductos_shunt)
	 */
	private Integer redesVentilacionConductosShunt;
	/**
	 * (redes_ventilacion_ruido_viviendas_colindantes)
	 */
	private Integer redesVentilacionRuidoViviendasColindantes;

	public AcusticaRuidoInstalacionesListadoVO() {
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
	 * * (equipos_instalaciones_colindantes)
	 */
	public Integer getEquiposInstalacionesColindantes() {
		return this.equiposInstalacionesColindantes;
	}

	public void setEquiposInstalacionesColindantes(Integer equiposInstalacionesColindantes) {
		this.equiposInstalacionesColindantes = equiposInstalacionesColindantes;
	}

	/**
	 * * (equipos_instalaciones_conductos_anclados)
	 */
	public Integer getEquiposInstalacionesConductosAnclados() {
		return this.equiposInstalacionesConductosAnclados;
	}

	public void setEquiposInstalacionesConductosAnclados(Integer equiposInstalacionesConductosAnclados) {
		this.equiposInstalacionesConductosAnclados = equiposInstalacionesConductosAnclados;
	}

	/**
	 * * (equipos_instalaciones_conectores_flexibles)
	 */
	public Integer getEquiposInstalacionesConectoresFlexibles() {
		return this.equiposInstalacionesConectoresFlexibles;
	}

	public void setEquiposInstalacionesConectoresFlexibles(Integer equiposInstalacionesConectoresFlexibles) {
		this.equiposInstalacionesConectoresFlexibles = equiposInstalacionesConectoresFlexibles;
	}

	/**
	 * * (equipos_instalaciones_holguras_selladas)
	 */
	public Integer getEquiposInstalacionesHolgurasSelladas() {
		return this.equiposInstalacionesHolgurasSelladas;
	}

	public void setEquiposInstalacionesHolgurasSelladas(Integer equiposInstalacionesHolgurasSelladas) {
		this.equiposInstalacionesHolgurasSelladas = equiposInstalacionesHolgurasSelladas;
	}

	/**
	 * * (equipos_instalaciones_ruido_molesto)
	 */
	public Integer getEquiposInstalacionesRuidoMolesto() {
		return this.equiposInstalacionesRuidoMolesto;
	}

	public void setEquiposInstalacionesRuidoMolesto(Integer equiposInstalacionesRuidoMolesto) {
		this.equiposInstalacionesRuidoMolesto = equiposInstalacionesRuidoMolesto;
	}

	/**
	 * * (equipos_instalaciones_ruido_molesto_tipo_localizacion)
	 */
	public String getEquiposInstalacionesRuidoMolestoTipoLocalizacion() {
		return this.equiposInstalacionesRuidoMolestoTipoLocalizacion;
	}

	public void setEquiposInstalacionesRuidoMolestoTipoLocalizacion(String equiposInstalacionesRuidoMolestoTipoLocalizacion) {
		this.equiposInstalacionesRuidoMolestoTipoLocalizacion = equiposInstalacionesRuidoMolestoTipoLocalizacion;
	}

	/**
	 * * (equipos_instalaciones_sistema_amortiguante)
	 */
	public Integer getEquiposInstalacionesSistemaAmortiguante() {
		return this.equiposInstalacionesSistemaAmortiguante;
	}

	public void setEquiposInstalacionesSistemaAmortiguante(Integer equiposInstalacionesSistemaAmortiguante) {
		this.equiposInstalacionesSistemaAmortiguante = equiposInstalacionesSistemaAmortiguante;
	}

	/**
	 * * (equipos_instalaciones_zonas_exteriores)
	 */
	public Integer getEquiposInstalacionesZonasExteriores() {
		return this.equiposInstalacionesZonasExteriores;
	}

	public void setEquiposInstalacionesZonasExteriores(Integer equiposInstalacionesZonasExteriores) {
		this.equiposInstalacionesZonasExteriores = equiposInstalacionesZonasExteriores;
	}

	/**
	 * * (equipos_instalaciones_zonas_exteriores_pantallas)
	 */
	public Integer getEquiposInstalacionesZonasExterioresPantallas() {
		return this.equiposInstalacionesZonasExterioresPantallas;
	}

	public void setEquiposInstalacionesZonasExterioresPantallas(Integer equiposInstalacionesZonasExterioresPantallas) {
		this.equiposInstalacionesZonasExterioresPantallas = equiposInstalacionesZonasExterioresPantallas;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Integer getOtrasAscensoresColindantes() {
		return this.otrasAscensoresColindantes;
	}

	public void setOtrasAscensoresColindantes(Integer otrasAscensoresColindantes) {
		this.otrasAscensoresColindantes = otrasAscensoresColindantes;
	}

	/**
	 * * (otras_ascensores_cuadro_maniobras)
	 */
	public Integer getOtrasAscensoresCuadroManiobras() {
		return this.otrasAscensoresCuadroManiobras;
	}

	public void setOtrasAscensoresCuadroManiobras(Integer otrasAscensoresCuadroManiobras) {
		this.otrasAscensoresCuadroManiobras = otrasAscensoresCuadroManiobras;
	}

	/**
	 * * (otras_ascensores_cuarto_maquinas)
	 */
	public Integer getOtrasAscensoresCuartoMaquinas() {
		return this.otrasAscensoresCuartoMaquinas;
	}

	public void setOtrasAscensoresCuartoMaquinas(Integer otrasAscensoresCuartoMaquinas) {
		this.otrasAscensoresCuartoMaquinas = otrasAscensoresCuartoMaquinas;
	}

	public Integer getOtrasAscensoresRuidoMolesto() {
		return this.otrasAscensoresRuidoMolesto;
	}

	public void setOtrasAscensoresRuidoMolesto(Integer otrasAscensoresRuidoMolesto) {
		this.otrasAscensoresRuidoMolesto = otrasAscensoresRuidoMolesto;
	}

	/**
	 * * (otras_ascensores_ruido_molesto_tipo_localizacion)
	 */
	public String getOtrasAscensoresRuidoMolestoTipoLocalizacion() {
		return this.otrasAscensoresRuidoMolestoTipoLocalizacion;
	}

	public void setOtrasAscensoresRuidoMolestoTipoLocalizacion(String otrasAscensoresRuidoMolestoTipoLocalizacion) {
		this.otrasAscensoresRuidoMolestoTipoLocalizacion = otrasAscensoresRuidoMolestoTipoLocalizacion;
	}

	/**
	 * * (otras_ascensores_sistema_amortiguante)
	 */
	public Integer getOtrasAscensoresSistemaAmortiguante() {
		return this.otrasAscensoresSistemaAmortiguante;
	}

	public void setOtrasAscensoresSistemaAmortiguante(Integer otrasAscensoresSistemaAmortiguante) {
		this.otrasAscensoresSistemaAmortiguante = otrasAscensoresSistemaAmortiguante;
	}

	public Integer getOtrasAscensoresTrasdosado() {
		return this.otrasAscensoresTrasdosado;
	}

	public void setOtrasAscensoresTrasdosado(Integer otrasAscensoresTrasdosado) {
		this.otrasAscensoresTrasdosado = otrasAscensoresTrasdosado;
	}

	/**
	 * * (otras_cuartos_humedos_aire_acondicionado)
	 */
	public Integer getOtrasCuartosHumedosAireAcondicionado() {
		return this.otrasCuartosHumedosAireAcondicionado;
	}

	public void setOtrasCuartosHumedosAireAcondicionado(Integer otrasCuartosHumedosAireAcondicionado) {
		this.otrasCuartosHumedosAireAcondicionado = otrasCuartosHumedosAireAcondicionado;
	}

	/**
	 * * (otras_cuartos_humedos_luminarias_empotradas)
	 */
	public Integer getOtrasCuartosHumedosLuminariasEmpotradas() {
		return this.otrasCuartosHumedosLuminariasEmpotradas;
	}

	public void setOtrasCuartosHumedosLuminariasEmpotradas(Integer otrasCuartosHumedosLuminariasEmpotradas) {
		this.otrasCuartosHumedosLuminariasEmpotradas = otrasCuartosHumedosLuminariasEmpotradas;
	}

	/**
	 * * (otras_cuartos_humedos_ruido_molesto)
	 */
	public Integer getOtrasCuartosHumedosRuidoMolesto() {
		return this.otrasCuartosHumedosRuidoMolesto;
	}

	public void setOtrasCuartosHumedosRuidoMolesto(Integer otrasCuartosHumedosRuidoMolesto) {
		this.otrasCuartosHumedosRuidoMolesto = otrasCuartosHumedosRuidoMolesto;
	}

	/**
	 * * (otras_cuartos_humedos_ruido_molesto_tipo_localizacion)
	 */
	public String getOtrasCuartosHumedosRuidoMolestoTipoLocalizacion() {
		return this.otrasCuartosHumedosRuidoMolestoTipoLocalizacion;
	}

	public void setOtrasCuartosHumedosRuidoMolestoTipoLocalizacion(String otrasCuartosHumedosRuidoMolestoTipoLocalizacion) {
		this.otrasCuartosHumedosRuidoMolestoTipoLocalizacion = otrasCuartosHumedosRuidoMolestoTipoLocalizacion;
	}

	/**
	 * * (otras_cuartos_humedos_saneamiento)
	 */
	public Integer getOtrasCuartosHumedosSaneamiento() {
		return this.otrasCuartosHumedosSaneamiento;
	}

	public void setOtrasCuartosHumedosSaneamiento(Integer otrasCuartosHumedosSaneamiento) {
		this.otrasCuartosHumedosSaneamiento = otrasCuartosHumedosSaneamiento;
	}

	/**
	 * * (otras_cuartos_humedos_saneamiento_conectores_flexibles)
	 */
	public Integer getOtrasCuartosHumedosSaneamientoConectoresFlexibles() {
		return this.otrasCuartosHumedosSaneamientoConectoresFlexibles;
	}

	public void setOtrasCuartosHumedosSaneamientoConectoresFlexibles(Integer otrasCuartosHumedosSaneamientoConectoresFlexibles) {
		this.otrasCuartosHumedosSaneamientoConectoresFlexibles = otrasCuartosHumedosSaneamientoConectoresFlexibles;
	}

	/**
	 * * (otras_cuartos_humedos_saneamiento_lana_mineral)
	 */
	public Integer getOtrasCuartosHumedosSaneamientoLanaMineral() {
		return this.otrasCuartosHumedosSaneamientoLanaMineral;
	}

	public void setOtrasCuartosHumedosSaneamientoLanaMineral(Integer otrasCuartosHumedosSaneamientoLanaMineral) {
		this.otrasCuartosHumedosSaneamientoLanaMineral = otrasCuartosHumedosSaneamientoLanaMineral;
	}

	/**
	 * * (otras_cuartos_humedos_saneamiento_material_elastico)
	 */
	public Integer getOtrasCuartosHumedosSaneamientoMaterialElastico() {
		return this.otrasCuartosHumedosSaneamientoMaterialElastico;
	}

	public void setOtrasCuartosHumedosSaneamientoMaterialElastico(Integer otrasCuartosHumedosSaneamientoMaterialElastico) {
		this.otrasCuartosHumedosSaneamientoMaterialElastico = otrasCuartosHumedosSaneamientoMaterialElastico;
	}

	/**
	 * * (otras_cuartos_humedos_saneamiento_techo_sellado)
	 */
	public Integer getOtrasCuartosHumedosSaneamientoTechoSellado() {
		return this.otrasCuartosHumedosSaneamientoTechoSellado;
	}

	public void setOtrasCuartosHumedosSaneamientoTechoSellado(Integer otrasCuartosHumedosSaneamientoTechoSellado) {
		this.otrasCuartosHumedosSaneamientoTechoSellado = otrasCuartosHumedosSaneamientoTechoSellado;
	}

	public Integer getOtrasPuertasGarajeAncladas() {
		return this.otrasPuertasGarajeAncladas;
	}

	public void setOtrasPuertasGarajeAncladas(Integer otrasPuertasGarajeAncladas) {
		this.otrasPuertasGarajeAncladas = otrasPuertasGarajeAncladas;
	}

	/**
	 * * (otras_puertas_garaje_ancladas_marco_amortiguadores)
	 */
	public Integer getOtrasPuertasGarajeAncladasMarcoAmortiguadores() {
		return this.otrasPuertasGarajeAncladasMarcoAmortiguadores;
	}

	public void setOtrasPuertasGarajeAncladasMarcoAmortiguadores(Integer otrasPuertasGarajeAncladasMarcoAmortiguadores) {
		this.otrasPuertasGarajeAncladasMarcoAmortiguadores = otrasPuertasGarajeAncladasMarcoAmortiguadores;
	}

	/**
	 * * (otras_puertas_garaje_ancladas_motores_amortiguadores)
	 */
	public Integer getOtrasPuertasGarajeAncladasMotoresAmortiguadores() {
		return this.otrasPuertasGarajeAncladasMotoresAmortiguadores;
	}

	public void setOtrasPuertasGarajeAncladasMotoresAmortiguadores(Integer otrasPuertasGarajeAncladasMotoresAmortiguadores) {
		this.otrasPuertasGarajeAncladasMotoresAmortiguadores = otrasPuertasGarajeAncladasMotoresAmortiguadores;
	}

	/**
	 * * (otras_puertas_garaje_ancladas_ruido_puerta)
	 */
	public Integer getOtrasPuertasGarajeAncladasRuidoPuerta() {
		return this.otrasPuertasGarajeAncladasRuidoPuerta;
	}

	public void setOtrasPuertasGarajeAncladasRuidoPuerta(Integer otrasPuertasGarajeAncladasRuidoPuerta) {
		this.otrasPuertasGarajeAncladasRuidoPuerta = otrasPuertasGarajeAncladasRuidoPuerta;
	}

	public Integer getRecintosActividadRevestido() {
		return this.recintosActividadRevestido;
	}

	public void setRecintosActividadRevestido(Integer recintosActividadRevestido) {
		this.recintosActividadRevestido = recintosActividadRevestido;
	}

	/**
	 * * (recintos_actividad_ruido_molesto)
	 */
	public Integer getRecintosActividadRuidoMolesto() {
		return this.recintosActividadRuidoMolesto;
	}

	public void setRecintosActividadRuidoMolesto(Integer recintosActividadRuidoMolesto) {
		this.recintosActividadRuidoMolesto = recintosActividadRuidoMolesto;
	}

	/**
	 * * (recintos_actividad_ruido_molesto_tipo_localizacion)
	 */
	public String getRecintosActividadRuidoMolestoTipoLocalizacion() {
		return this.recintosActividadRuidoMolestoTipoLocalizacion;
	}

	public void setRecintosActividadRuidoMolestoTipoLocalizacion(String recintosActividadRuidoMolestoTipoLocalizacion) {
		this.recintosActividadRuidoMolestoTipoLocalizacion = recintosActividadRuidoMolestoTipoLocalizacion;
	}

	/**
	 * * (recintos_actividad_suelo_flotante)
	 */
	public Integer getRecintosActividadSueloFlotante() {
		return this.recintosActividadSueloFlotante;
	}

	public void setRecintosActividadSueloFlotante(Integer recintosActividadSueloFlotante) {
		this.recintosActividadSueloFlotante = recintosActividadSueloFlotante;
	}

	/**
	 * * (recintos_actividad_techo_suspendido)
	 */
	public Integer getRecintosActividadTechoSuspendido() {
		return this.recintosActividadTechoSuspendido;
	}

	public void setRecintosActividadTechoSuspendido(Integer recintosActividadTechoSuspendido) {
		this.recintosActividadTechoSuspendido = recintosActividadTechoSuspendido;
	}

	/**
	 * * (recintos_actividad_techo_suspendido_absorvente)
	 */
	public Integer getRecintosActividadTechoSuspendidoAbsorvente() {
		return this.recintosActividadTechoSuspendidoAbsorvente;
	}

	public void setRecintosActividadTechoSuspendidoAbsorvente(Integer recintosActividadTechoSuspendidoAbsorvente) {
		this.recintosActividadTechoSuspendidoAbsorvente = recintosActividadTechoSuspendidoAbsorvente;
	}

	/**
	 * * (recintos_actividad_techo_suspendido_amortiguadores)
	 */
	public Integer getRecintosActividadTechoSuspendidoAmortiguadores() {
		return this.recintosActividadTechoSuspendidoAmortiguadores;
	}

	public void setRecintosActividadTechoSuspendidoAmortiguadores(Integer recintosActividadTechoSuspendidoAmortiguadores) {
		this.recintosActividadTechoSuspendidoAmortiguadores = recintosActividadTechoSuspendidoAmortiguadores;
	}

	public Integer getRecintosActividadTiene() {
		return this.recintosActividadTiene;
	}

	public void setRecintosActividadTiene(Integer recintosActividadTiene) {
		this.recintosActividadTiene = recintosActividadTiene;
	}

	/**
	 * * (recintos_actividad_tipo_localizacion)
	 */
	public String getRecintosActividadTipoLocalizacion() {
		return this.recintosActividadTipoLocalizacion;
	}

	public void setRecintosActividadTipoLocalizacion(String recintosActividadTipoLocalizacion) {
		this.recintosActividadTipoLocalizacion = recintosActividadTipoLocalizacion;
	}

	public Integer getRecintosActividadTrasdosados() {
		return this.recintosActividadTrasdosados;
	}

	public void setRecintosActividadTrasdosados(Integer recintosActividadTrasdosados) {
		this.recintosActividadTrasdosados = recintosActividadTrasdosados;
	}

	/**
	 * * (recintos_actividad_trasdosados_amortiguadores)
	 */
	public Integer getRecintosActividadTrasdosadosAmortiguadores() {
		return this.recintosActividadTrasdosadosAmortiguadores;
	}

	public void setRecintosActividadTrasdosadosAmortiguadores(Integer recintosActividadTrasdosadosAmortiguadores) {
		this.recintosActividadTrasdosadosAmortiguadores = recintosActividadTrasdosadosAmortiguadores;
	}

	/**
	 * * (recintos_actividad_tratamiento_absorvente)
	 */
	public Integer getRecintosActividadTratamientoAbsorvente() {
		return this.recintosActividadTratamientoAbsorvente;
	}

	public void setRecintosActividadTratamientoAbsorvente(Integer recintosActividadTratamientoAbsorvente) {
		this.recintosActividadTratamientoAbsorvente = recintosActividadTratamientoAbsorvente;
	}

	/**
	 * * (redes_agua_ruido_molesto_tipo_localizacion)
	 */
	public String getRedesAguaRuidoMolestoTipoLocalizacion() {
		return this.redesAguaRuidoMolestoTipoLocalizacion;
	}

	public void setRedesAguaRuidoMolestoTipoLocalizacion(String redesAguaRuidoMolestoTipoLocalizacion) {
		this.redesAguaRuidoMolestoTipoLocalizacion = redesAguaRuidoMolestoTipoLocalizacion;
	}

	/**
	 * * (redes_aire_acondicionado_falso_techo)
	 */
	public Integer getRedesAireAcondicionadoFalsoTecho() {
		return this.redesAireAcondicionadoFalsoTecho;
	}

	public void setRedesAireAcondicionadoFalsoTecho(Integer redesAireAcondicionadoFalsoTecho) {
		this.redesAireAcondicionadoFalsoTecho = redesAireAcondicionadoFalsoTecho;
	}

	/**
	 * * (redes_aire_acondicionado_ruido_molesto)
	 */
	public Integer getRedesAireAcondicionadoRuidoMolesto() {
		return this.redesAireAcondicionadoRuidoMolesto;
	}

	public void setRedesAireAcondicionadoRuidoMolesto(Integer redesAireAcondicionadoRuidoMolesto) {
		this.redesAireAcondicionadoRuidoMolesto = redesAireAcondicionadoRuidoMolesto;
	}

	/**
	 * * (redes_saneamiento_bajantes_abrazaderas)
	 */
	public Integer getRedesSaneamientoBajantesAbrazaderas() {
		return this.redesSaneamientoBajantesAbrazaderas;
	}

	public void setRedesSaneamientoBajantesAbrazaderas(Integer redesSaneamientoBajantesAbrazaderas) {
		this.redesSaneamientoBajantesAbrazaderas = redesSaneamientoBajantesAbrazaderas;
	}

	/**
	 * * (redes_saneamiento_bajantes_forradas)
	 */
	public Integer getRedesSaneamientoBajantesForradas() {
		return this.redesSaneamientoBajantesForradas;
	}

	public void setRedesSaneamientoBajantesForradas(Integer redesSaneamientoBajantesForradas) {
		this.redesSaneamientoBajantesForradas = redesSaneamientoBajantesForradas;
	}

	/**
	 * * (redes_saneamiento_bajantes_revestidas)
	 */
	public Integer getRedesSaneamientoBajantesRevestidas() {
		return this.redesSaneamientoBajantesRevestidas;
	}

	public void setRedesSaneamientoBajantesRevestidas(Integer redesSaneamientoBajantesRevestidas) {
		this.redesSaneamientoBajantesRevestidas = redesSaneamientoBajantesRevestidas;
	}

	public Integer getRedesSaneamientoCodoBajante() {
		return this.redesSaneamientoCodoBajante;
	}

	public void setRedesSaneamientoCodoBajante(Integer redesSaneamientoCodoBajante) {
		this.redesSaneamientoCodoBajante = redesSaneamientoCodoBajante;
	}

	/**
	 * * (redes_saneamiento_ruido_molesto)
	 */
	public Integer getRedesSaneamientoRuidoMolesto() {
		return this.redesSaneamientoRuidoMolesto;
	}

	public void setRedesSaneamientoRuidoMolesto(Integer redesSaneamientoRuidoMolesto) {
		this.redesSaneamientoRuidoMolesto = redesSaneamientoRuidoMolesto;
	}

	/**
	 * * (redes_saneamiento_ruido_molesto_tipo_localizacion)
	 */
	public String getRedesSaneamientoRuidoMolestoTipoLocalizacion() {
		return this.redesSaneamientoRuidoMolestoTipoLocalizacion;
	}

	public void setRedesSaneamientoRuidoMolestoTipoLocalizacion(String redesSaneamientoRuidoMolestoTipoLocalizacion) {
		this.redesSaneamientoRuidoMolestoTipoLocalizacion = redesSaneamientoRuidoMolestoTipoLocalizacion;
	}

	/**
	 * * (redes_suministro_agua_ruido_golpe_ariete)
	 */
	public Integer getRedesSuministroAguaRuidoGolpeAriete() {
		return this.redesSuministroAguaRuidoGolpeAriete;
	}

	public void setRedesSuministroAguaRuidoGolpeAriete(Integer redesSuministroAguaRuidoGolpeAriete) {
		this.redesSuministroAguaRuidoGolpeAriete = redesSuministroAguaRuidoGolpeAriete;
	}

	/**
	 * * (redes_suministro_agua_ruido_molesto)
	 */
	public Integer getRedesSuministroAguaRuidoMolesto() {
		return this.redesSuministroAguaRuidoMolesto;
	}

	public void setRedesSuministroAguaRuidoMolesto(Integer redesSuministroAguaRuidoMolesto) {
		this.redesSuministroAguaRuidoMolesto = redesSuministroAguaRuidoMolesto;
	}

	/**
	 * * (redes_suministro_agua_tuberias_forradas)
	 */
	public Integer getRedesSuministroAguaTuberiasForradas() {
		return this.redesSuministroAguaTuberiasForradas;
	}

	public void setRedesSuministroAguaTuberiasForradas(Integer redesSuministroAguaTuberiasForradas) {
		this.redesSuministroAguaTuberiasForradas = redesSuministroAguaTuberiasForradas;
	}

	/**
	 * * (redes_ventilacion_conducto_individual)
	 */
	public Integer getRedesVentilacionConductoIndividual() {
		return this.redesVentilacionConductoIndividual;
	}

	public void setRedesVentilacionConductoIndividual(Integer redesVentilacionConductoIndividual) {
		this.redesVentilacionConductoIndividual = redesVentilacionConductoIndividual;
	}

	/**
	 * * (redes_ventilacion_conductos_shunt)
	 */
	public Integer getRedesVentilacionConductosShunt() {
		return this.redesVentilacionConductosShunt;
	}

	public void setRedesVentilacionConductosShunt(Integer redesVentilacionConductosShunt) {
		this.redesVentilacionConductosShunt = redesVentilacionConductosShunt;
	}

	/**
	 * * (redes_ventilacion_ruido_viviendas_colindantes)
	 */
	public Integer getRedesVentilacionRuidoViviendasColindantes() {
		return this.redesVentilacionRuidoViviendasColindantes;
	}

	public void setRedesVentilacionRuidoViviendasColindantes(Integer redesVentilacionRuidoViviendasColindantes) {
		this.redesVentilacionRuidoViviendasColindantes = redesVentilacionRuidoViviendasColindantes;
	}

}
