package es.caib.avaedi.logic.vo;

import java.io.Serializable;
import java.math.BigDecimal;

import org.directwebremoting.annotations.DataTransferObject;

import es.caib.avaedi.at4forms.common.util.FormData2Java;
import es.caib.avaedi.at4forms.logic.vo.BaseVO;

/**
 * TransferObject para la implementacion del listado Inspeccion
 */
@DataTransferObject
public class InspeccionListadoVO extends BaseVO implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public Serializable getPrimaryKey() { 
		return this.getId();
	}

	@Override
	public String getPrimaryLabel() {
		return FormData2Java.toString(this.getId());
	}

	private int id;
	private String informeLabel;
	private int informeId;
	/**
	 * (accesibilidad_ajustesrazonables_costes)
	 */
	private String accesibilidadAjustesrazonablesCostes;
	/**
	 * (conservacion_datosgenerales_archivos)
	 */
	private String conservacionDatosgeneralesArchivos;
	private Integer ieeCompleta;
	private BigDecimal alturaSobreRasante;
	private Integer anoConstruccion;
	private String anoConstruccionReferencia;
	private Integer anoRehabilitacion;
	private String anoRehabilitacionReferencia;
	/**
	 * (inspeccion_datosedificio_nucleosescaleras_tipo_id)
	 */
	private Integer inspeccionDatosedificioNucleosescalerasTipoId;
	/**
	 * (inspeccion_datosedificio_parcela_tipo_id)
	 */
	private Integer inspeccionDatosedificioParcelaTipoId;
	/**
	 * (inspeccion_datosedificio_unnucleoescaleras_tipo_id)
	 */
	private Integer inspeccionDatosedificioUnnucleoescalerasTipoId;
	/**
	 * (inspeccion_datosedificio_uso_tipo_id)
	 */
	private Integer inspeccionDatosedificioUsoTipoId;
	private Integer mediaViviendasPorPlanta;
	private Integer numAparcamientos;
	private Integer numLocales;
	private Integer numTrasteros;
	private Integer numViviendas;
	/**
	 * (plantas_bajo_rasante_uso_principal)
	 */
	private Integer plantasBajoRasanteUsoPrincipal;
	/**
	 * (plantas_bajo_rasante_usos_secundarios)
	 */
	private Integer plantasBajoRasanteUsosSecundarios;
	/**
	 * (plantas_bajo_rasante_usos_secundarios_tipo)
	 */
	private String plantasBajoRasanteUsosSecundariosTipo;
	/**
	 * (plantas_sobre_rasante_uso_principal)
	 */
	private Integer plantasSobreRasanteUsoPrincipal;
	/**
	 * (plantas_sobre_rasante_usos_secundarios)
	 */
	private Integer plantasSobreRasanteUsosSecundarios;
	/**
	 * (plantas_sobre_rasante_usos_secundarios_tipo)
	 */
	private String plantasSobreRasanteUsosSecundariosTipo;
	private BigDecimal superficieConstruida;
	private BigDecimal superficieMediaAparcamientos;
	private BigDecimal superficieMediaLocales;
	private BigDecimal superficieMediaTrasteros;
	private BigDecimal superficieMediaViviendas;
	private BigDecimal superficieParcela;
	private String totalAscensores;
	private String totalEscaleras;
	/**
	 * (total_viviendas_con_acceso_varios_nucleos)
	 */
	private String totalViviendasConAccesoVariosNucleos;
	/**
	 * (total_viviendas_sin_acceso_ascensor)
	 */
	private String totalViviendasSinAccesoAscensor;
	private String usoTexto;
	private Integer numero;
	private String tipoVia;
	private String via;
	private Boolean principal;
	private String referenciaCatastral;
	private String edificioCodigoPostal;
	private String edificioComunTexto;
	/**
	 * (edificio_inspeccion_identificacionedificio_comunes_tipo_id)
	 */
	private Integer edificioInspeccionIdentificacionedificioComunesTipoId;
	/**
	 * (edificio_inspeccion_identificacionedificio_objeto_tipo_id)
	 */
	private Integer edificioInspeccionIdentificacionedificioObjetoTipoId;
	/**
	 * (edificio_inspeccion_propiedad_regimen_tipo_id)
	 */
	private Integer edificioInspeccionPropiedadRegimenTipoId;
	private String edificioNumeroManual;
	private String edificioObjetoTexto;
	private String edificioObservaciones;
	private String edificioPisoLetra;
	private String edificioPoblacion;
	private String edificioProvincia;
	private Integer edificioProvinciaId;
	private String edificioRegimenTexto;
	private String edificioTipoViaManual;
	private String edificioViaManual;
	private String propiedadNif;
	private String propiedadTitular;
	private String representanteCodigoPostal;
	private String representanteCondicion;
	private String representanteDireccion;
	private String representanteEmail;
	private String representanteNif;
	private String representanteNombre;
	private String representantePoblacion;
	private String representanteProvincia;
	private String representanteTelefonoFijo;
	private String representanteTelefonoMovil;
	private String tecnicoNif;
	private String tecnicoTecnico;
	private String tecnicoTitulacion;
	private String accesibilidadPublicosLabel;
	private int accesibilidadPublicosId;
	private String acusticaRuidosInterioresUnionesLabel;
	private int acusticaRuidosInterioresUnionesId;
	private String acusticaValoracionFinalLabel;
	private int acusticaValoracionFinalId;
	private String acusticaRuidosInterioresVerticalesLabel;
	private int acusticaRuidosInterioresVerticalesId;
	private String acusticaComprobacionesLabel;
	private int acusticaComprobacionesId;
	private String instalacionesLabel;
	private int instalacionesId;
	private String cerramientosCubiertasLabel;
	private int cerramientosCubiertasId;
	private String accesibilidadValoracionFinalesLabel;
	private int accesibilidadValoracionFinalesId;
	private String acusticaRuidoInstalacionesLabel;
	private int acusticaRuidoInstalacionesId;
	private String estructuraLabel;
	private int estructuraId;
	private String cimentacionesLabel;
	private int cimentacionesId;
	private String accesibilidadAjustesRazonablesLabel;
	private int accesibilidadAjustesRazonablesId;
	private String eficienciasEnergeticasLabel;
	private int eficienciasEnergeticasId;
	private String acusticaRuidosExterioresLabel;
	private int acusticaRuidosExterioresId;
	private String acusticaRuidosInterioresHorizontalesLabel;
	private int acusticaRuidosInterioresHorizontalesId;
	private String acusticaDatosGeneralesLabel;
	private int acusticaDatosGeneralesId;
	private String acusticasLabel;
	private int acusticasId;
	private String conservacionLabel;
	private int conservacionId;

	public InspeccionListadoVO() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInformeLabel() {
		return this.informeLabel;
	}

	public void setInformeLabel(String informeLabel) {
		this.informeLabel = informeLabel;
	}

	public int getInformeId() {
		return this.informeId;
	}

	public void setInformeId(int informeId) {
		this.informeId = informeId;
	}

	/**
	 * * (accesibilidad_ajustesrazonables_costes)
	 */
	public String getAccesibilidadAjustesrazonablesCostes() {
		return this.accesibilidadAjustesrazonablesCostes;
	}

	public void setAccesibilidadAjustesrazonablesCostes(String accesibilidadAjustesrazonablesCostes) {
		this.accesibilidadAjustesrazonablesCostes = accesibilidadAjustesrazonablesCostes;
	}

	/**
	 * * (conservacion_datosgenerales_archivos)
	 */
	public String getConservacionDatosgeneralesArchivos() {
		return this.conservacionDatosgeneralesArchivos;
	}

	public void setConservacionDatosgeneralesArchivos(String conservacionDatosgeneralesArchivos) {
		this.conservacionDatosgeneralesArchivos = conservacionDatosgeneralesArchivos;
	}

	public Integer getIeeCompleta() {
		return this.ieeCompleta;
	}

	public void setIeeCompleta(Integer ieeCompleta) {
		this.ieeCompleta = ieeCompleta;
	}

	public BigDecimal getAlturaSobreRasante() {
		return this.alturaSobreRasante;
	}

	public void setAlturaSobreRasante(BigDecimal alturaSobreRasante) {
		this.alturaSobreRasante = alturaSobreRasante;
	}

	public Integer getAnoConstruccion() {
		return this.anoConstruccion;
	}

	public void setAnoConstruccion(Integer anoConstruccion) {
		this.anoConstruccion = anoConstruccion;
	}

	public String getAnoConstruccionReferencia() {
		return this.anoConstruccionReferencia;
	}

	public void setAnoConstruccionReferencia(String anoConstruccionReferencia) {
		this.anoConstruccionReferencia = anoConstruccionReferencia;
	}

	public Integer getAnoRehabilitacion() {
		return this.anoRehabilitacion;
	}

	public void setAnoRehabilitacion(Integer anoRehabilitacion) {
		this.anoRehabilitacion = anoRehabilitacion;
	}

	public String getAnoRehabilitacionReferencia() {
		return this.anoRehabilitacionReferencia;
	}

	public void setAnoRehabilitacionReferencia(String anoRehabilitacionReferencia) {
		this.anoRehabilitacionReferencia = anoRehabilitacionReferencia;
	}

	/**
	 * * (inspeccion_datosedificio_nucleosescaleras_tipo_id)
	 */
	public Integer getInspeccionDatosedificioNucleosescalerasTipoId() {
		return this.inspeccionDatosedificioNucleosescalerasTipoId;
	}

	public void setInspeccionDatosedificioNucleosescalerasTipoId(Integer inspeccionDatosedificioNucleosescalerasTipoId) {
		this.inspeccionDatosedificioNucleosescalerasTipoId = inspeccionDatosedificioNucleosescalerasTipoId;
	}

	/**
	 * * (inspeccion_datosedificio_parcela_tipo_id)
	 */
	public Integer getInspeccionDatosedificioParcelaTipoId() {
		return this.inspeccionDatosedificioParcelaTipoId;
	}

	public void setInspeccionDatosedificioParcelaTipoId(Integer inspeccionDatosedificioParcelaTipoId) {
		this.inspeccionDatosedificioParcelaTipoId = inspeccionDatosedificioParcelaTipoId;
	}

	/**
	 * * (inspeccion_datosedificio_unnucleoescaleras_tipo_id)
	 */
	public Integer getInspeccionDatosedificioUnnucleoescalerasTipoId() {
		return this.inspeccionDatosedificioUnnucleoescalerasTipoId;
	}

	public void setInspeccionDatosedificioUnnucleoescalerasTipoId(Integer inspeccionDatosedificioUnnucleoescalerasTipoId) {
		this.inspeccionDatosedificioUnnucleoescalerasTipoId = inspeccionDatosedificioUnnucleoescalerasTipoId;
	}

	/**
	 * * (inspeccion_datosedificio_uso_tipo_id)
	 */
	public Integer getInspeccionDatosedificioUsoTipoId() {
		return this.inspeccionDatosedificioUsoTipoId;
	}

	public void setInspeccionDatosedificioUsoTipoId(Integer inspeccionDatosedificioUsoTipoId) {
		this.inspeccionDatosedificioUsoTipoId = inspeccionDatosedificioUsoTipoId;
	}

	public Integer getMediaViviendasPorPlanta() {
		return this.mediaViviendasPorPlanta;
	}

	public void setMediaViviendasPorPlanta(Integer mediaViviendasPorPlanta) {
		this.mediaViviendasPorPlanta = mediaViviendasPorPlanta;
	}

	public Integer getNumAparcamientos() {
		return this.numAparcamientos;
	}

	public void setNumAparcamientos(Integer numAparcamientos) {
		this.numAparcamientos = numAparcamientos;
	}

	public Integer getNumLocales() {
		return this.numLocales;
	}

	public void setNumLocales(Integer numLocales) {
		this.numLocales = numLocales;
	}

	public Integer getNumTrasteros() {
		return this.numTrasteros;
	}

	public void setNumTrasteros(Integer numTrasteros) {
		this.numTrasteros = numTrasteros;
	}

	public Integer getNumViviendas() {
		return this.numViviendas;
	}

	public void setNumViviendas(Integer numViviendas) {
		this.numViviendas = numViviendas;
	}

	/**
	 * * (plantas_bajo_rasante_uso_principal)
	 */
	public Integer getPlantasBajoRasanteUsoPrincipal() {
		return this.plantasBajoRasanteUsoPrincipal;
	}

	public void setPlantasBajoRasanteUsoPrincipal(Integer plantasBajoRasanteUsoPrincipal) {
		this.plantasBajoRasanteUsoPrincipal = plantasBajoRasanteUsoPrincipal;
	}

	/**
	 * * (plantas_bajo_rasante_usos_secundarios)
	 */
	public Integer getPlantasBajoRasanteUsosSecundarios() {
		return this.plantasBajoRasanteUsosSecundarios;
	}

	public void setPlantasBajoRasanteUsosSecundarios(Integer plantasBajoRasanteUsosSecundarios) {
		this.plantasBajoRasanteUsosSecundarios = plantasBajoRasanteUsosSecundarios;
	}

	/**
	 * * (plantas_bajo_rasante_usos_secundarios_tipo)
	 */
	public String getPlantasBajoRasanteUsosSecundariosTipo() {
		return this.plantasBajoRasanteUsosSecundariosTipo;
	}

	public void setPlantasBajoRasanteUsosSecundariosTipo(String plantasBajoRasanteUsosSecundariosTipo) {
		this.plantasBajoRasanteUsosSecundariosTipo = plantasBajoRasanteUsosSecundariosTipo;
	}

	/**
	 * * (plantas_sobre_rasante_uso_principal)
	 */
	public Integer getPlantasSobreRasanteUsoPrincipal() {
		return this.plantasSobreRasanteUsoPrincipal;
	}

	public void setPlantasSobreRasanteUsoPrincipal(Integer plantasSobreRasanteUsoPrincipal) {
		this.plantasSobreRasanteUsoPrincipal = plantasSobreRasanteUsoPrincipal;
	}

	/**
	 * * (plantas_sobre_rasante_usos_secundarios)
	 */
	public Integer getPlantasSobreRasanteUsosSecundarios() {
		return this.plantasSobreRasanteUsosSecundarios;
	}

	public void setPlantasSobreRasanteUsosSecundarios(Integer plantasSobreRasanteUsosSecundarios) {
		this.plantasSobreRasanteUsosSecundarios = plantasSobreRasanteUsosSecundarios;
	}

	/**
	 * * (plantas_sobre_rasante_usos_secundarios_tipo)
	 */
	public String getPlantasSobreRasanteUsosSecundariosTipo() {
		return this.plantasSobreRasanteUsosSecundariosTipo;
	}

	public void setPlantasSobreRasanteUsosSecundariosTipo(String plantasSobreRasanteUsosSecundariosTipo) {
		this.plantasSobreRasanteUsosSecundariosTipo = plantasSobreRasanteUsosSecundariosTipo;
	}

	public BigDecimal getSuperficieConstruida() {
		return this.superficieConstruida;
	}

	public void setSuperficieConstruida(BigDecimal superficieConstruida) {
		this.superficieConstruida = superficieConstruida;
	}

	public BigDecimal getSuperficieMediaAparcamientos() {
		return this.superficieMediaAparcamientos;
	}

	public void setSuperficieMediaAparcamientos(BigDecimal superficieMediaAparcamientos) {
		this.superficieMediaAparcamientos = superficieMediaAparcamientos;
	}

	public BigDecimal getSuperficieMediaLocales() {
		return this.superficieMediaLocales;
	}

	public void setSuperficieMediaLocales(BigDecimal superficieMediaLocales) {
		this.superficieMediaLocales = superficieMediaLocales;
	}

	public BigDecimal getSuperficieMediaTrasteros() {
		return this.superficieMediaTrasteros;
	}

	public void setSuperficieMediaTrasteros(BigDecimal superficieMediaTrasteros) {
		this.superficieMediaTrasteros = superficieMediaTrasteros;
	}

	public BigDecimal getSuperficieMediaViviendas() {
		return this.superficieMediaViviendas;
	}

	public void setSuperficieMediaViviendas(BigDecimal superficieMediaViviendas) {
		this.superficieMediaViviendas = superficieMediaViviendas;
	}

	public BigDecimal getSuperficieParcela() {
		return this.superficieParcela;
	}

	public void setSuperficieParcela(BigDecimal superficieParcela) {
		this.superficieParcela = superficieParcela;
	}

	public String getTotalAscensores() {
		return this.totalAscensores;
	}

	public void setTotalAscensores(String totalAscensores) {
		this.totalAscensores = totalAscensores;
	}

	public String getTotalEscaleras() {
		return this.totalEscaleras;
	}

	public void setTotalEscaleras(String totalEscaleras) {
		this.totalEscaleras = totalEscaleras;
	}

	/**
	 * * (total_viviendas_con_acceso_varios_nucleos)
	 */
	public String getTotalViviendasConAccesoVariosNucleos() {
		return this.totalViviendasConAccesoVariosNucleos;
	}

	public void setTotalViviendasConAccesoVariosNucleos(String totalViviendasConAccesoVariosNucleos) {
		this.totalViviendasConAccesoVariosNucleos = totalViviendasConAccesoVariosNucleos;
	}

	/**
	 * * (total_viviendas_sin_acceso_ascensor)
	 */
	public String getTotalViviendasSinAccesoAscensor() {
		return this.totalViviendasSinAccesoAscensor;
	}

	public void setTotalViviendasSinAccesoAscensor(String totalViviendasSinAccesoAscensor) {
		this.totalViviendasSinAccesoAscensor = totalViviendasSinAccesoAscensor;
	}

	public String getUsoTexto() {
		return this.usoTexto;
	}

	public void setUsoTexto(String usoTexto) {
		this.usoTexto = usoTexto;
	}

	public Integer getNumero() {
		return this.numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getTipoVia() {
		return this.tipoVia;
	}

	public void setTipoVia(String tipoVia) {
		this.tipoVia = tipoVia;
	}

	public String getVia() {
		return this.via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public Boolean getPrincipal() {
		return this.principal;
	}

	public void setPrincipal(Boolean principal) {
		this.principal = principal;
	}

	public String getReferenciaCatastral() {
		return this.referenciaCatastral;
	}

	public void setReferenciaCatastral(String referenciaCatastral) {
		this.referenciaCatastral = referenciaCatastral;
	}

	public String getEdificioCodigoPostal() {
		return this.edificioCodigoPostal;
	}

	public void setEdificioCodigoPostal(String edificioCodigoPostal) {
		this.edificioCodigoPostal = edificioCodigoPostal;
	}

	public String getEdificioComunTexto() {
		return this.edificioComunTexto;
	}

	public void setEdificioComunTexto(String edificioComunTexto) {
		this.edificioComunTexto = edificioComunTexto;
	}

	/**
	 * * (edificio_inspeccion_identificacionedificio_comunes_tipo_id)
	 */
	public Integer getEdificioInspeccionIdentificacionedificioComunesTipoId() {
		return this.edificioInspeccionIdentificacionedificioComunesTipoId;
	}

	public void setEdificioInspeccionIdentificacionedificioComunesTipoId(Integer edificioInspeccionIdentificacionedificioComunesTipoId) {
		this.edificioInspeccionIdentificacionedificioComunesTipoId = edificioInspeccionIdentificacionedificioComunesTipoId;
	}

	/**
	 * * (edificio_inspeccion_identificacionedificio_objeto_tipo_id)
	 */
	public Integer getEdificioInspeccionIdentificacionedificioObjetoTipoId() {
		return this.edificioInspeccionIdentificacionedificioObjetoTipoId;
	}

	public void setEdificioInspeccionIdentificacionedificioObjetoTipoId(Integer edificioInspeccionIdentificacionedificioObjetoTipoId) {
		this.edificioInspeccionIdentificacionedificioObjetoTipoId = edificioInspeccionIdentificacionedificioObjetoTipoId;
	}

	/**
	 * * (edificio_inspeccion_propiedad_regimen_tipo_id)
	 */
	public Integer getEdificioInspeccionPropiedadRegimenTipoId() {
		return this.edificioInspeccionPropiedadRegimenTipoId;
	}

	public void setEdificioInspeccionPropiedadRegimenTipoId(Integer edificioInspeccionPropiedadRegimenTipoId) {
		this.edificioInspeccionPropiedadRegimenTipoId = edificioInspeccionPropiedadRegimenTipoId;
	}

	public String getEdificioNumeroManual() {
		return this.edificioNumeroManual;
	}

	public void setEdificioNumeroManual(String edificioNumeroManual) {
		this.edificioNumeroManual = edificioNumeroManual;
	}

	public String getEdificioObjetoTexto() {
		return this.edificioObjetoTexto;
	}

	public void setEdificioObjetoTexto(String edificioObjetoTexto) {
		this.edificioObjetoTexto = edificioObjetoTexto;
	}

	public String getEdificioObservaciones() {
		return this.edificioObservaciones;
	}

	public void setEdificioObservaciones(String edificioObservaciones) {
		this.edificioObservaciones = edificioObservaciones;
	}

	public String getEdificioPisoLetra() {
		return this.edificioPisoLetra;
	}

	public void setEdificioPisoLetra(String edificioPisoLetra) {
		this.edificioPisoLetra = edificioPisoLetra;
	}

	public String getEdificioPoblacion() {
		return this.edificioPoblacion;
	}

	public void setEdificioPoblacion(String edificioPoblacion) {
		this.edificioPoblacion = edificioPoblacion;
	}

	public String getEdificioProvincia() {
		return this.edificioProvincia;
	}

	public void setEdificioProvincia(String edificioProvincia) {
		this.edificioProvincia = edificioProvincia;
	}

	public Integer getEdificioProvinciaId() {
		return this.edificioProvinciaId;
	}

	public void setEdificioProvinciaId(Integer edificioProvinciaId) {
		this.edificioProvinciaId = edificioProvinciaId;
	}

	public String getEdificioRegimenTexto() {
		return this.edificioRegimenTexto;
	}

	public void setEdificioRegimenTexto(String edificioRegimenTexto) {
		this.edificioRegimenTexto = edificioRegimenTexto;
	}

	public String getEdificioTipoViaManual() {
		return this.edificioTipoViaManual;
	}

	public void setEdificioTipoViaManual(String edificioTipoViaManual) {
		this.edificioTipoViaManual = edificioTipoViaManual;
	}

	public String getEdificioViaManual() {
		return this.edificioViaManual;
	}

	public void setEdificioViaManual(String edificioViaManual) {
		this.edificioViaManual = edificioViaManual;
	}

	public String getPropiedadNif() {
		return this.propiedadNif;
	}

	public void setPropiedadNif(String propiedadNif) {
		this.propiedadNif = propiedadNif;
	}

	public String getPropiedadTitular() {
		return this.propiedadTitular;
	}

	public void setPropiedadTitular(String propiedadTitular) {
		this.propiedadTitular = propiedadTitular;
	}

	public String getRepresentanteCodigoPostal() {
		return this.representanteCodigoPostal;
	}

	public void setRepresentanteCodigoPostal(String representanteCodigoPostal) {
		this.representanteCodigoPostal = representanteCodigoPostal;
	}

	public String getRepresentanteCondicion() {
		return this.representanteCondicion;
	}

	public void setRepresentanteCondicion(String representanteCondicion) {
		this.representanteCondicion = representanteCondicion;
	}

	public String getRepresentanteDireccion() {
		return this.representanteDireccion;
	}

	public void setRepresentanteDireccion(String representanteDireccion) {
		this.representanteDireccion = representanteDireccion;
	}

	public String getRepresentanteEmail() {
		return this.representanteEmail;
	}

	public void setRepresentanteEmail(String representanteEmail) {
		this.representanteEmail = representanteEmail;
	}

	public String getRepresentanteNif() {
		return this.representanteNif;
	}

	public void setRepresentanteNif(String representanteNif) {
		this.representanteNif = representanteNif;
	}

	public String getRepresentanteNombre() {
		return this.representanteNombre;
	}

	public void setRepresentanteNombre(String representanteNombre) {
		this.representanteNombre = representanteNombre;
	}

	public String getRepresentantePoblacion() {
		return this.representantePoblacion;
	}

	public void setRepresentantePoblacion(String representantePoblacion) {
		this.representantePoblacion = representantePoblacion;
	}

	public String getRepresentanteProvincia() {
		return this.representanteProvincia;
	}

	public void setRepresentanteProvincia(String representanteProvincia) {
		this.representanteProvincia = representanteProvincia;
	}

	public String getRepresentanteTelefonoFijo() {
		return this.representanteTelefonoFijo;
	}

	public void setRepresentanteTelefonoFijo(String representanteTelefonoFijo) {
		this.representanteTelefonoFijo = representanteTelefonoFijo;
	}

	public String getRepresentanteTelefonoMovil() {
		return this.representanteTelefonoMovil;
	}

	public void setRepresentanteTelefonoMovil(String representanteTelefonoMovil) {
		this.representanteTelefonoMovil = representanteTelefonoMovil;
	}

	public String getTecnicoNif() {
		return this.tecnicoNif;
	}

	public void setTecnicoNif(String tecnicoNif) {
		this.tecnicoNif = tecnicoNif;
	}

	public String getTecnicoTecnico() {
		return this.tecnicoTecnico;
	}

	public void setTecnicoTecnico(String tecnicoTecnico) {
		this.tecnicoTecnico = tecnicoTecnico;
	}

	public String getTecnicoTitulacion() {
		return this.tecnicoTitulacion;
	}

	public void setTecnicoTitulacion(String tecnicoTitulacion) {
		this.tecnicoTitulacion = tecnicoTitulacion;
	}

	public String getAccesibilidadPublicosLabel() {
		return this.accesibilidadPublicosLabel;
	}

	public void setAccesibilidadPublicosLabel(String accesibilidadPublicosLabel) {
		this.accesibilidadPublicosLabel = accesibilidadPublicosLabel;
	}

	public int getAccesibilidadPublicosId() {
		return this.accesibilidadPublicosId;
	}

	public void setAccesibilidadPublicosId(int accesibilidadPublicosId) {
		this.accesibilidadPublicosId = accesibilidadPublicosId;
	}

	public String getAcusticaRuidosInterioresUnionesLabel() {
		return this.acusticaRuidosInterioresUnionesLabel;
	}

	public void setAcusticaRuidosInterioresUnionesLabel(String acusticaRuidosInterioresUnionesLabel) {
		this.acusticaRuidosInterioresUnionesLabel = acusticaRuidosInterioresUnionesLabel;
	}

	public int getAcusticaRuidosInterioresUnionesId() {
		return this.acusticaRuidosInterioresUnionesId;
	}

	public void setAcusticaRuidosInterioresUnionesId(int acusticaRuidosInterioresUnionesId) {
		this.acusticaRuidosInterioresUnionesId = acusticaRuidosInterioresUnionesId;
	}

	public String getAcusticaValoracionFinalLabel() {
		return this.acusticaValoracionFinalLabel;
	}

	public void setAcusticaValoracionFinalLabel(String acusticaValoracionFinalLabel) {
		this.acusticaValoracionFinalLabel = acusticaValoracionFinalLabel;
	}

	public int getAcusticaValoracionFinalId() {
		return this.acusticaValoracionFinalId;
	}

	public void setAcusticaValoracionFinalId(int acusticaValoracionFinalId) {
		this.acusticaValoracionFinalId = acusticaValoracionFinalId;
	}

	public String getAcusticaRuidosInterioresVerticalesLabel() {
		return this.acusticaRuidosInterioresVerticalesLabel;
	}

	public void setAcusticaRuidosInterioresVerticalesLabel(String acusticaRuidosInterioresVerticalesLabel) {
		this.acusticaRuidosInterioresVerticalesLabel = acusticaRuidosInterioresVerticalesLabel;
	}

	public int getAcusticaRuidosInterioresVerticalesId() {
		return this.acusticaRuidosInterioresVerticalesId;
	}

	public void setAcusticaRuidosInterioresVerticalesId(int acusticaRuidosInterioresVerticalesId) {
		this.acusticaRuidosInterioresVerticalesId = acusticaRuidosInterioresVerticalesId;
	}

	public String getAcusticaComprobacionesLabel() {
		return this.acusticaComprobacionesLabel;
	}

	public void setAcusticaComprobacionesLabel(String acusticaComprobacionesLabel) {
		this.acusticaComprobacionesLabel = acusticaComprobacionesLabel;
	}

	public int getAcusticaComprobacionesId() {
		return this.acusticaComprobacionesId;
	}

	public void setAcusticaComprobacionesId(int acusticaComprobacionesId) {
		this.acusticaComprobacionesId = acusticaComprobacionesId;
	}

	public String getInstalacionesLabel() {
		return this.instalacionesLabel;
	}

	public void setInstalacionesLabel(String instalacionesLabel) {
		this.instalacionesLabel = instalacionesLabel;
	}

	public int getInstalacionesId() {
		return this.instalacionesId;
	}

	public void setInstalacionesId(int instalacionesId) {
		this.instalacionesId = instalacionesId;
	}

	public String getCerramientosCubiertasLabel() {
		return this.cerramientosCubiertasLabel;
	}

	public void setCerramientosCubiertasLabel(String cerramientosCubiertasLabel) {
		this.cerramientosCubiertasLabel = cerramientosCubiertasLabel;
	}

	public int getCerramientosCubiertasId() {
		return this.cerramientosCubiertasId;
	}

	public void setCerramientosCubiertasId(int cerramientosCubiertasId) {
		this.cerramientosCubiertasId = cerramientosCubiertasId;
	}

	public String getAccesibilidadValoracionFinalesLabel() {
		return this.accesibilidadValoracionFinalesLabel;
	}

	public void setAccesibilidadValoracionFinalesLabel(String accesibilidadValoracionFinalesLabel) {
		this.accesibilidadValoracionFinalesLabel = accesibilidadValoracionFinalesLabel;
	}

	public int getAccesibilidadValoracionFinalesId() {
		return this.accesibilidadValoracionFinalesId;
	}

	public void setAccesibilidadValoracionFinalesId(int accesibilidadValoracionFinalesId) {
		this.accesibilidadValoracionFinalesId = accesibilidadValoracionFinalesId;
	}

	public String getAcusticaRuidoInstalacionesLabel() {
		return this.acusticaRuidoInstalacionesLabel;
	}

	public void setAcusticaRuidoInstalacionesLabel(String acusticaRuidoInstalacionesLabel) {
		this.acusticaRuidoInstalacionesLabel = acusticaRuidoInstalacionesLabel;
	}

	public int getAcusticaRuidoInstalacionesId() {
		return this.acusticaRuidoInstalacionesId;
	}

	public void setAcusticaRuidoInstalacionesId(int acusticaRuidoInstalacionesId) {
		this.acusticaRuidoInstalacionesId = acusticaRuidoInstalacionesId;
	}

	public String getEstructuraLabel() {
		return this.estructuraLabel;
	}

	public void setEstructuraLabel(String estructuraLabel) {
		this.estructuraLabel = estructuraLabel;
	}

	public int getEstructuraId() {
		return this.estructuraId;
	}

	public void setEstructuraId(int estructuraId) {
		this.estructuraId = estructuraId;
	}

	public String getCimentacionesLabel() {
		return this.cimentacionesLabel;
	}

	public void setCimentacionesLabel(String cimentacionesLabel) {
		this.cimentacionesLabel = cimentacionesLabel;
	}

	public int getCimentacionesId() {
		return this.cimentacionesId;
	}

	public void setCimentacionesId(int cimentacionesId) {
		this.cimentacionesId = cimentacionesId;
	}

	public String getAccesibilidadAjustesRazonablesLabel() {
		return this.accesibilidadAjustesRazonablesLabel;
	}

	public void setAccesibilidadAjustesRazonablesLabel(String accesibilidadAjustesRazonablesLabel) {
		this.accesibilidadAjustesRazonablesLabel = accesibilidadAjustesRazonablesLabel;
	}

	public int getAccesibilidadAjustesRazonablesId() {
		return this.accesibilidadAjustesRazonablesId;
	}

	public void setAccesibilidadAjustesRazonablesId(int accesibilidadAjustesRazonablesId) {
		this.accesibilidadAjustesRazonablesId = accesibilidadAjustesRazonablesId;
	}

	public String getEficienciasEnergeticasLabel() {
		return this.eficienciasEnergeticasLabel;
	}

	public void setEficienciasEnergeticasLabel(String eficienciasEnergeticasLabel) {
		this.eficienciasEnergeticasLabel = eficienciasEnergeticasLabel;
	}

	public int getEficienciasEnergeticasId() {
		return this.eficienciasEnergeticasId;
	}

	public void setEficienciasEnergeticasId(int eficienciasEnergeticasId) {
		this.eficienciasEnergeticasId = eficienciasEnergeticasId;
	}

	public String getAcusticaRuidosExterioresLabel() {
		return this.acusticaRuidosExterioresLabel;
	}

	public void setAcusticaRuidosExterioresLabel(String acusticaRuidosExterioresLabel) {
		this.acusticaRuidosExterioresLabel = acusticaRuidosExterioresLabel;
	}

	public int getAcusticaRuidosExterioresId() {
		return this.acusticaRuidosExterioresId;
	}

	public void setAcusticaRuidosExterioresId(int acusticaRuidosExterioresId) {
		this.acusticaRuidosExterioresId = acusticaRuidosExterioresId;
	}

	public String getAcusticaRuidosInterioresHorizontalesLabel() {
		return this.acusticaRuidosInterioresHorizontalesLabel;
	}

	public void setAcusticaRuidosInterioresHorizontalesLabel(String acusticaRuidosInterioresHorizontalesLabel) {
		this.acusticaRuidosInterioresHorizontalesLabel = acusticaRuidosInterioresHorizontalesLabel;
	}

	public int getAcusticaRuidosInterioresHorizontalesId() {
		return this.acusticaRuidosInterioresHorizontalesId;
	}

	public void setAcusticaRuidosInterioresHorizontalesId(int acusticaRuidosInterioresHorizontalesId) {
		this.acusticaRuidosInterioresHorizontalesId = acusticaRuidosInterioresHorizontalesId;
	}

	public String getAcusticaDatosGeneralesLabel() {
		return this.acusticaDatosGeneralesLabel;
	}

	public void setAcusticaDatosGeneralesLabel(String acusticaDatosGeneralesLabel) {
		this.acusticaDatosGeneralesLabel = acusticaDatosGeneralesLabel;
	}

	public int getAcusticaDatosGeneralesId() {
		return this.acusticaDatosGeneralesId;
	}

	public void setAcusticaDatosGeneralesId(int acusticaDatosGeneralesId) {
		this.acusticaDatosGeneralesId = acusticaDatosGeneralesId;
	}

	public String getAcusticasLabel() {
		return this.acusticasLabel;
	}

	public void setAcusticasLabel(String acusticasLabel) {
		this.acusticasLabel = acusticasLabel;
	}

	public int getAcusticasId() {
		return this.acusticasId;
	}

	public void setAcusticasId(int acusticasId) {
		this.acusticasId = acusticasId;
	}

	public String getConservacionLabel() {
		return this.conservacionLabel;
	}

	public void setConservacionLabel(String conservacionLabel) {
		this.conservacionLabel = conservacionLabel;
	}

	public int getConservacionId() {
		return this.conservacionId;
	}

	public void setConservacionId(int conservacionId) {
		this.conservacionId = conservacionId;
	}

	//Campos extra
	private String municipioLabel;
	private int municipioId;
	private String edificioLabel;
	private int edificioId;

	public String getMunicipioLabel() {
		return this.municipioLabel;
	}

	public void setMunicipioLabel(String municipioLabel) {
		this.municipioLabel = municipioLabel;
	}

	public int getMunicipioId() {
		return this.municipioId;
	}

	public void setMunicipioId(int municipioId) {
		this.municipioId = municipioId;
	}

	public String getEdificioLabel() {
		return edificioLabel;
	}

	public void setEdificioLabel(String edificioLabel) {
		this.edificioLabel = edificioLabel;
	}

	public int getEdificioId() {
		return edificioId;
	}

	public void setEdificioId(int edificioId) {
		this.edificioId = edificioId;
	}


	
	
}
