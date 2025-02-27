<%@page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
/**
 * Localización para form: inspeccion
 * @author agarcia@at4.net
 * 
 */




if(At4FrameworkIntranet.InspeccionForm) {
  	Ext.apply(At4FrameworkIntranet.InspeccionForm.prototype, {
  			titleLabel: '<spring:message code="forms.inspeccion.title" javaScriptEscape="true"/>', 
    	idHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.id.header" javaScriptEscape="true"/>',
    	informeHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.informe.header" javaScriptEscape="true"/>',
    	accesibilidadAjustesrazonablesCostesHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.accesibilidadAjustesrazonablesCostes.header" javaScriptEscape="true"/>',
    	accesibilidadAjustesrazonablesCostesDescriptionLabel       : '<spring:message code="forms.inspeccion.columns.accesibilidadAjustesrazonablesCostes.description" javaScriptEscape="true"/>',
    	conservacionDatosgeneralesArchivosHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.conservacionDatosgeneralesArchivos.header" javaScriptEscape="true"/>',
    	conservacionDatosgeneralesArchivosDescriptionLabel       : '<spring:message code="forms.inspeccion.columns.conservacionDatosgeneralesArchivos.description" javaScriptEscape="true"/>',
    	ieeCompletaHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.ieeCompleta.header" javaScriptEscape="true"/>',
    	alturaSobreRasanteHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.alturaSobreRasante.header" javaScriptEscape="true"/>',
    	anoConstruccionHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.anoConstruccion.header" javaScriptEscape="true"/>',
    	anoConstruccionReferenciaHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.anoConstruccionReferencia.header" javaScriptEscape="true"/>',
    	anoRehabilitacionHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.anoRehabilitacion.header" javaScriptEscape="true"/>',
    	anoRehabilitacionReferenciaHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.anoRehabilitacionReferencia.header" javaScriptEscape="true"/>',
    	inspeccionDatosedificioNucleosescalerasTipoIdHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.inspeccionDatosedificioNucleosescalerasTipoId.header" javaScriptEscape="true"/>',
    	inspeccionDatosedificioNucleosescalerasTipoIdDescriptionLabel       : '<spring:message code="forms.inspeccion.columns.inspeccionDatosedificioNucleosescalerasTipoId.description" javaScriptEscape="true"/>',
    	inspeccionDatosedificioParcelaTipoIdHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.inspeccionDatosedificioParcelaTipoId.header" javaScriptEscape="true"/>',
    	inspeccionDatosedificioParcelaTipoIdDescriptionLabel       : '<spring:message code="forms.inspeccion.columns.inspeccionDatosedificioParcelaTipoId.description" javaScriptEscape="true"/>',
    	inspeccionDatosedificioUnnucleoescalerasTipoIdHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.inspeccionDatosedificioUnnucleoescalerasTipoId.header" javaScriptEscape="true"/>',
    	inspeccionDatosedificioUnnucleoescalerasTipoIdDescriptionLabel       : '<spring:message code="forms.inspeccion.columns.inspeccionDatosedificioUnnucleoescalerasTipoId.description" javaScriptEscape="true"/>',
    	inspeccionDatosedificioUsoTipoIdHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.inspeccionDatosedificioUsoTipoId.header" javaScriptEscape="true"/>',
    	inspeccionDatosedificioUsoTipoIdDescriptionLabel       : '<spring:message code="forms.inspeccion.columns.inspeccionDatosedificioUsoTipoId.description" javaScriptEscape="true"/>',
    	mediaViviendasPorPlantaHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.mediaViviendasPorPlanta.header" javaScriptEscape="true"/>',
    	numAparcamientosHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.numAparcamientos.header" javaScriptEscape="true"/>',
    	numLocalesHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.numLocales.header" javaScriptEscape="true"/>',
    	numTrasterosHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.numTrasteros.header" javaScriptEscape="true"/>',
    	numViviendasHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.numViviendas.header" javaScriptEscape="true"/>',
    	plantasBajoRasanteUsoPrincipalHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.plantasBajoRasanteUsoPrincipal.header" javaScriptEscape="true"/>',
    	plantasBajoRasanteUsoPrincipalDescriptionLabel       : '<spring:message code="forms.inspeccion.columns.plantasBajoRasanteUsoPrincipal.description" javaScriptEscape="true"/>',
    	plantasBajoRasanteUsosSecundariosHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.plantasBajoRasanteUsosSecundarios.header" javaScriptEscape="true"/>',
    	plantasBajoRasanteUsosSecundariosDescriptionLabel       : '<spring:message code="forms.inspeccion.columns.plantasBajoRasanteUsosSecundarios.description" javaScriptEscape="true"/>',
    	plantasBajoRasanteUsosSecundariosTipoHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.plantasBajoRasanteUsosSecundariosTipo.header" javaScriptEscape="true"/>',
    	plantasBajoRasanteUsosSecundariosTipoDescriptionLabel       : '<spring:message code="forms.inspeccion.columns.plantasBajoRasanteUsosSecundariosTipo.description" javaScriptEscape="true"/>',
    	plantasSobreRasanteUsoPrincipalHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.plantasSobreRasanteUsoPrincipal.header" javaScriptEscape="true"/>',
    	plantasSobreRasanteUsoPrincipalDescriptionLabel       : '<spring:message code="forms.inspeccion.columns.plantasSobreRasanteUsoPrincipal.description" javaScriptEscape="true"/>',
    	plantasSobreRasanteUsosSecundariosHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.plantasSobreRasanteUsosSecundarios.header" javaScriptEscape="true"/>',
    	plantasSobreRasanteUsosSecundariosDescriptionLabel       : '<spring:message code="forms.inspeccion.columns.plantasSobreRasanteUsosSecundarios.description" javaScriptEscape="true"/>',
    	plantasSobreRasanteUsosSecundariosTipoHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.plantasSobreRasanteUsosSecundariosTipo.header" javaScriptEscape="true"/>',
    	plantasSobreRasanteUsosSecundariosTipoDescriptionLabel       : '<spring:message code="forms.inspeccion.columns.plantasSobreRasanteUsosSecundariosTipo.description" javaScriptEscape="true"/>',
    	superficieConstruidaHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.superficieConstruida.header" javaScriptEscape="true"/>',
    	superficieMediaAparcamientosHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.superficieMediaAparcamientos.header" javaScriptEscape="true"/>',
    	superficieMediaLocalesHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.superficieMediaLocales.header" javaScriptEscape="true"/>',
    	superficieMediaTrasterosHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.superficieMediaTrasteros.header" javaScriptEscape="true"/>',
    	superficieMediaViviendasHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.superficieMediaViviendas.header" javaScriptEscape="true"/>',
    	superficieParcelaHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.superficieParcela.header" javaScriptEscape="true"/>',
    	totalAscensoresHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.totalAscensores.header" javaScriptEscape="true"/>',
    	totalEscalerasHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.totalEscaleras.header" javaScriptEscape="true"/>',
    	totalViviendasConAccesoVariosNucleosHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.totalViviendasConAccesoVariosNucleos.header" javaScriptEscape="true"/>',
    	totalViviendasConAccesoVariosNucleosDescriptionLabel       : '<spring:message code="forms.inspeccion.columns.totalViviendasConAccesoVariosNucleos.description" javaScriptEscape="true"/>',
    	totalViviendasSinAccesoAscensorHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.totalViviendasSinAccesoAscensor.header" javaScriptEscape="true"/>',
    	totalViviendasSinAccesoAscensorDescriptionLabel       : '<spring:message code="forms.inspeccion.columns.totalViviendasSinAccesoAscensor.description" javaScriptEscape="true"/>',
    	usoTextoHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.usoTexto.header" javaScriptEscape="true"/>',
    	numeroHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.numero.header" javaScriptEscape="true"/>',
    	tipoViaHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.tipoVia.header" javaScriptEscape="true"/>',
    	viaHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.via.header" javaScriptEscape="true"/>',
    	principalHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.principal.header" javaScriptEscape="true"/>',
    	referenciaCatastralHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.referenciaCatastral.header" javaScriptEscape="true"/>',
    	edificioCodigoPostalHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.edificioCodigoPostal.header" javaScriptEscape="true"/>',
    	edificioComunTextoHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.edificioComunTexto.header" javaScriptEscape="true"/>',
    	edificioInspeccionIdentificacionedificioComunesTipoIdHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.edificioInspeccionIdentificacionedificioComunesTipoId.header" javaScriptEscape="true"/>',
    	edificioInspeccionIdentificacionedificioComunesTipoIdDescriptionLabel       : '<spring:message code="forms.inspeccion.columns.edificioInspeccionIdentificacionedificioComunesTipoId.description" javaScriptEscape="true"/>',
    	edificioInspeccionIdentificacionedificioObjetoTipoIdHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.edificioInspeccionIdentificacionedificioObjetoTipoId.header" javaScriptEscape="true"/>',
    	edificioInspeccionIdentificacionedificioObjetoTipoIdDescriptionLabel       : '<spring:message code="forms.inspeccion.columns.edificioInspeccionIdentificacionedificioObjetoTipoId.description" javaScriptEscape="true"/>',
    	edificioInspeccionPropiedadRegimenTipoIdHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.edificioInspeccionPropiedadRegimenTipoId.header" javaScriptEscape="true"/>',
    	edificioInspeccionPropiedadRegimenTipoIdDescriptionLabel       : '<spring:message code="forms.inspeccion.columns.edificioInspeccionPropiedadRegimenTipoId.description" javaScriptEscape="true"/>',
    	edificioNumeroManualHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.edificioNumeroManual.header" javaScriptEscape="true"/>',
    	edificioObjetoTextoHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.edificioObjetoTexto.header" javaScriptEscape="true"/>',
    	edificioObservacionesHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.edificioObservaciones.header" javaScriptEscape="true"/>',
    	edificioPisoLetraHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.edificioPisoLetra.header" javaScriptEscape="true"/>',
    	edificioPoblacionHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.edificioPoblacion.header" javaScriptEscape="true"/>',
    	edificioProvinciaHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.edificioProvincia.header" javaScriptEscape="true"/>',
    	edificioProvinciaIdHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.edificioProvinciaId.header" javaScriptEscape="true"/>',
    	edificioRegimenTextoHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.edificioRegimenTexto.header" javaScriptEscape="true"/>',
    	edificioTipoViaManualHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.edificioTipoViaManual.header" javaScriptEscape="true"/>',
    	edificioViaManualHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.edificioViaManual.header" javaScriptEscape="true"/>',
    	propiedadNifHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.propiedadNif.header" javaScriptEscape="true"/>',
    	propiedadTitularHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.propiedadTitular.header" javaScriptEscape="true"/>',
    	representanteCodigoPostalHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.representanteCodigoPostal.header" javaScriptEscape="true"/>',
    	representanteCondicionHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.representanteCondicion.header" javaScriptEscape="true"/>',
    	representanteDireccionHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.representanteDireccion.header" javaScriptEscape="true"/>',
    	representanteEmailHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.representanteEmail.header" javaScriptEscape="true"/>',
    	representanteNifHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.representanteNif.header" javaScriptEscape="true"/>',
    	representanteNombreHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.representanteNombre.header" javaScriptEscape="true"/>',
    	representantePoblacionHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.representantePoblacion.header" javaScriptEscape="true"/>',
    	representanteProvinciaHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.representanteProvincia.header" javaScriptEscape="true"/>',
    	representanteTelefonoFijoHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.representanteTelefonoFijo.header" javaScriptEscape="true"/>',
    	representanteTelefonoMovilHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.representanteTelefonoMovil.header" javaScriptEscape="true"/>',
    	tecnicoNifHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.tecnicoNif.header" javaScriptEscape="true"/>',
    	tecnicoTecnicoHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.tecnicoTecnico.header" javaScriptEscape="true"/>',
    	tecnicoTitulacionHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.tecnicoTitulacion.header" javaScriptEscape="true"/>',
    	accesibilidadPublicosHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.accesibilidadPublicos.header" javaScriptEscape="true"/>',
    	acusticaRuidosInterioresUnionesHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.acusticaRuidosInterioresUniones.header" javaScriptEscape="true"/>',
    	fechasVisitasHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.fechasVisitas.header" javaScriptEscape="true"/>',
    	acusticaValoracionFinalHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.acusticaValoracionFinal.header" javaScriptEscape="true"/>',
    	acusticaRuidosInterioresVerticalesHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.acusticaRuidosInterioresVerticales.header" javaScriptEscape="true"/>',
    	acusticaComprobacionesHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.acusticaComprobaciones.header" javaScriptEscape="true"/>',
    	instalacionesHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.instalaciones.header" javaScriptEscape="true"/>',
    	cerramientosCubiertasHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.cerramientosCubiertas.header" javaScriptEscape="true"/>',
    	valoracionesParcialesHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.valoracionesParciales.header" javaScriptEscape="true"/>',
    	accesibilidadValoracionFinalesHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.accesibilidadValoracionFinales.header" javaScriptEscape="true"/>',
    	acusticaRuidoInstalacionesHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.acusticaRuidoInstalaciones.header" javaScriptEscape="true"/>',
    	estructuraHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.estructura.header" javaScriptEscape="true"/>',
    	cimentacionesHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.cimentaciones.header" javaScriptEscape="true"/>',
    	accesibilidadAjustesRazonablesHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.accesibilidadAjustesRazonables.header" javaScriptEscape="true"/>',
    	eficienciasEnergeticasHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.eficienciasEnergeticas.header" javaScriptEscape="true"/>',
    	documentacionOtrosHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.documentacionOtros.header" javaScriptEscape="true"/>',
    	acusticaRuidosExterioresHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.acusticaRuidosExteriores.header" javaScriptEscape="true"/>',
    	acusticaMejorasAcusticasHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.acusticaMejorasAcusticas.header" javaScriptEscape="true"/>',
    	acusticaRuidosInterioresHorizontalesHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.acusticaRuidosInterioresHorizontales.header" javaScriptEscape="true"/>',
    	acusticaDatosGeneralesHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.acusticaDatosGenerales.header" javaScriptEscape="true"/>',
    	acusticasHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.acusticas.header" javaScriptEscape="true"/>',
    	deficienciasHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.deficiencias.header" javaScriptEscape="true"/>',
    	valoresHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.valores.header" javaScriptEscape="true"/>',
    		edificioInspeccionPropiedadRegimenTipoIdHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.edificioInspeccionPropiedadRegimenTipoId.header" javaScriptEscape="true"/>',
    	edificioInspeccionPropiedadRegimenTipoIdDescriptionLabel       : '<spring:message code="forms.inspeccion.columns.edificioInspeccionPropiedadRegimenTipoId.description" javaScriptEscape="true"/>',
    	conservacionHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.conservacion.header" javaScriptEscape="true"/>',
    	historicosHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.historicos.header" javaScriptEscape="true"/>',

		datosGeneralesTitleLabel : '<spring:message code="forms.inspeccion.grupos.datosGenerales.header" javaScriptEscape="true"/>',
		inspeccionDatosEdificioTitleLabel: '<spring:message code="forms.inspeccion.grupos.inspeccionDatosEdificio.header" javaScriptEscape="true"/>',
		plantasBajoRasanteTitleLabel: '<spring:message code="forms.inspeccion.grupos.inspeccionDatosEdificio.header" javaScriptEscape="true"/>',
		plantasSobreRasanteTitleLabel: '<spring:message code="forms.inspeccion.grupos.plantasSobreRasante.header" javaScriptEscape="true"/>',
		superficiesTitleLabel: '<spring:message code="forms.inspeccion.grupos.superficies.header" javaScriptEscape="true"/>',
		inspecciónIdentificacionesTitleLabel: '<spring:message code="forms.inspeccion.grupos.inspeccionIdentificaciones.header" javaScriptEscape="true"/>',
		edificioTitleLabel: '<spring:message code="forms.inspeccion.grupos.edificio.header" javaScriptEscape="true"/>',
		tecnicoTitularRepresentanteTitleLabel: '<spring:message code="forms.inspeccion.grupos.tecnicoTitularRepresentante.header" javaScriptEscape="true"/>',
		representanteTitleLabel: '<spring:message code="forms.inspeccion.grupos.representante.header" javaScriptEscape="true"/>',
		otrosDatosTitleLabel: '<spring:message code="forms.inspeccion.grupos.otrosDatos.header" javaScriptEscape="true"/>',
		accesibilidadTitleLabel: '<spring:message code="forms.inspeccion.grupos.accesibilidad.header" javaScriptEscape="true"/>',
		acusticaTitleLabel: '<spring:message code="forms.inspeccion.grupos.acustica.header" javaScriptEscape="true"/>',
		acusticaRuidoTitleLabel: '<spring:message code="forms.inspeccion.grupos.acusticaRuido.header" javaScriptEscape="true"/>',
		valoresSeleccionadosTitleLabel: '<spring:message code="forms.inspeccion.grupos.valoresSeleccionados.header" javaScriptEscape="true"/>',
		
  	});
}

if(At4FrameworkIntranet.InspeccionSubForm) {
  	Ext.apply(At4FrameworkIntranet.InspeccionSubForm.prototype, {
  			titleLabel: '<spring:message code="forms.inspeccion.title" javaScriptEscape="true"/>', 
    	idHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.id.header" javaScriptEscape="true"/>',
    	informeHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.informe.header" javaScriptEscape="true"/>',
    	accesibilidadAjustesrazonablesCostesHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.accesibilidadAjustesrazonablesCostes.header" javaScriptEscape="true"/>',
    	accesibilidadAjustesrazonablesCostesDescriptionLabel       : '<spring:message code="forms.inspeccion.columns.accesibilidadAjustesrazonablesCostes.description" javaScriptEscape="true"/>',
    	conservacionDatosgeneralesArchivosHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.conservacionDatosgeneralesArchivos.header" javaScriptEscape="true"/>',
    	conservacionDatosgeneralesArchivosDescriptionLabel       : '<spring:message code="forms.inspeccion.columns.conservacionDatosgeneralesArchivos.description" javaScriptEscape="true"/>',
    	ieeCompletaHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.ieeCompleta.header" javaScriptEscape="true"/>',
    	alturaSobreRasanteHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.alturaSobreRasante.header" javaScriptEscape="true"/>',
    	anoConstruccionHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.anoConstruccion.header" javaScriptEscape="true"/>',
    	anoConstruccionReferenciaHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.anoConstruccionReferencia.header" javaScriptEscape="true"/>',
    	anoRehabilitacionHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.anoRehabilitacion.header" javaScriptEscape="true"/>',
    	anoRehabilitacionReferenciaHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.anoRehabilitacionReferencia.header" javaScriptEscape="true"/>',
    	inspeccionDatosedificioNucleosescalerasTipoIdHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.inspeccionDatosedificioNucleosescalerasTipoId.header" javaScriptEscape="true"/>',
    	inspeccionDatosedificioNucleosescalerasTipoIdDescriptionLabel       : '<spring:message code="forms.inspeccion.columns.inspeccionDatosedificioNucleosescalerasTipoId.description" javaScriptEscape="true"/>',
    	inspeccionDatosedificioParcelaTipoIdHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.inspeccionDatosedificioParcelaTipoId.header" javaScriptEscape="true"/>',
    	inspeccionDatosedificioParcelaTipoIdDescriptionLabel       : '<spring:message code="forms.inspeccion.columns.inspeccionDatosedificioParcelaTipoId.description" javaScriptEscape="true"/>',
    	inspeccionDatosedificioUnnucleoescalerasTipoIdHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.inspeccionDatosedificioUnnucleoescalerasTipoId.header" javaScriptEscape="true"/>',
    	inspeccionDatosedificioUnnucleoescalerasTipoIdDescriptionLabel       : '<spring:message code="forms.inspeccion.columns.inspeccionDatosedificioUnnucleoescalerasTipoId.description" javaScriptEscape="true"/>',
    	inspeccionDatosedificioUsoTipoIdHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.inspeccionDatosedificioUsoTipoId.header" javaScriptEscape="true"/>',
    	inspeccionDatosedificioUsoTipoIdDescriptionLabel       : '<spring:message code="forms.inspeccion.columns.inspeccionDatosedificioUsoTipoId.description" javaScriptEscape="true"/>',
    	mediaViviendasPorPlantaHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.mediaViviendasPorPlanta.header" javaScriptEscape="true"/>',
    	numAparcamientosHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.numAparcamientos.header" javaScriptEscape="true"/>',
    	numLocalesHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.numLocales.header" javaScriptEscape="true"/>',
    	numTrasterosHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.numTrasteros.header" javaScriptEscape="true"/>',
    	numViviendasHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.numViviendas.header" javaScriptEscape="true"/>',
    	plantasBajoRasanteUsoPrincipalHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.plantasBajoRasanteUsoPrincipal.header" javaScriptEscape="true"/>',
    	plantasBajoRasanteUsoPrincipalDescriptionLabel       : '<spring:message code="forms.inspeccion.columns.plantasBajoRasanteUsoPrincipal.description" javaScriptEscape="true"/>',
    	plantasBajoRasanteUsosSecundariosHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.plantasBajoRasanteUsosSecundarios.header" javaScriptEscape="true"/>',
    	plantasBajoRasanteUsosSecundariosDescriptionLabel       : '<spring:message code="forms.inspeccion.columns.plantasBajoRasanteUsosSecundarios.description" javaScriptEscape="true"/>',
    	plantasBajoRasanteUsosSecundariosTipoHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.plantasBajoRasanteUsosSecundariosTipo.header" javaScriptEscape="true"/>',
    	plantasBajoRasanteUsosSecundariosTipoDescriptionLabel       : '<spring:message code="forms.inspeccion.columns.plantasBajoRasanteUsosSecundariosTipo.description" javaScriptEscape="true"/>',
    	plantasSobreRasanteUsoPrincipalHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.plantasSobreRasanteUsoPrincipal.header" javaScriptEscape="true"/>',
    	plantasSobreRasanteUsoPrincipalDescriptionLabel       : '<spring:message code="forms.inspeccion.columns.plantasSobreRasanteUsoPrincipal.description" javaScriptEscape="true"/>',
    	plantasSobreRasanteUsosSecundariosHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.plantasSobreRasanteUsosSecundarios.header" javaScriptEscape="true"/>',
    	plantasSobreRasanteUsosSecundariosDescriptionLabel       : '<spring:message code="forms.inspeccion.columns.plantasSobreRasanteUsosSecundarios.description" javaScriptEscape="true"/>',
    	plantasSobreRasanteUsosSecundariosTipoHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.plantasSobreRasanteUsosSecundariosTipo.header" javaScriptEscape="true"/>',
    	plantasSobreRasanteUsosSecundariosTipoDescriptionLabel       : '<spring:message code="forms.inspeccion.columns.plantasSobreRasanteUsosSecundariosTipo.description" javaScriptEscape="true"/>',
    	superficieConstruidaHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.superficieConstruida.header" javaScriptEscape="true"/>',
    	superficieMediaAparcamientosHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.superficieMediaAparcamientos.header" javaScriptEscape="true"/>',
    	superficieMediaLocalesHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.superficieMediaLocales.header" javaScriptEscape="true"/>',
    	superficieMediaTrasterosHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.superficieMediaTrasteros.header" javaScriptEscape="true"/>',
    	superficieMediaViviendasHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.superficieMediaViviendas.header" javaScriptEscape="true"/>',
    	superficieParcelaHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.superficieParcela.header" javaScriptEscape="true"/>',
    	totalAscensoresHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.totalAscensores.header" javaScriptEscape="true"/>',
    	totalEscalerasHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.totalEscaleras.header" javaScriptEscape="true"/>',
    	totalViviendasConAccesoVariosNucleosHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.totalViviendasConAccesoVariosNucleos.header" javaScriptEscape="true"/>',
    	totalViviendasConAccesoVariosNucleosDescriptionLabel       : '<spring:message code="forms.inspeccion.columns.totalViviendasConAccesoVariosNucleos.description" javaScriptEscape="true"/>',
    	totalViviendasSinAccesoAscensorHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.totalViviendasSinAccesoAscensor.header" javaScriptEscape="true"/>',
    	totalViviendasSinAccesoAscensorDescriptionLabel       : '<spring:message code="forms.inspeccion.columns.totalViviendasSinAccesoAscensor.description" javaScriptEscape="true"/>',
    	usoTextoHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.usoTexto.header" javaScriptEscape="true"/>',
    	numeroHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.numero.header" javaScriptEscape="true"/>',
    	tipoViaHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.tipoVia.header" javaScriptEscape="true"/>',
    	viaHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.via.header" javaScriptEscape="true"/>',
    	principalHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.principal.header" javaScriptEscape="true"/>',
    	referenciaCatastralHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.referenciaCatastral.header" javaScriptEscape="true"/>',
    	edificioCodigoPostalHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.edificioCodigoPostal.header" javaScriptEscape="true"/>',
    	edificioComunTextoHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.edificioComunTexto.header" javaScriptEscape="true"/>',
    	edificioInspeccionIdentificacionedificioComunesTipoIdHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.edificioInspeccionIdentificacionedificioComunesTipoId.header" javaScriptEscape="true"/>',
    	edificioInspeccionIdentificacionedificioComunesTipoIdDescriptionLabel       : '<spring:message code="forms.inspeccion.columns.edificioInspeccionIdentificacionedificioComunesTipoId.description" javaScriptEscape="true"/>',
    	edificioInspeccionIdentificacionedificioObjetoTipoIdHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.edificioInspeccionIdentificacionedificioObjetoTipoId.header" javaScriptEscape="true"/>',
    	edificioInspeccionIdentificacionedificioObjetoTipoIdDescriptionLabel       : '<spring:message code="forms.inspeccion.columns.edificioInspeccionIdentificacionedificioObjetoTipoId.description" javaScriptEscape="true"/>',
    	edificioInspeccionPropiedadRegimenTipoIdHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.edificioInspeccionPropiedadRegimenTipoId.header" javaScriptEscape="true"/>',
    	edificioInspeccionPropiedadRegimenTipoIdDescriptionLabel       : '<spring:message code="forms.inspeccion.columns.edificioInspeccionPropiedadRegimenTipoId.description" javaScriptEscape="true"/>',
    	edificioNumeroManualHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.edificioNumeroManual.header" javaScriptEscape="true"/>',
    	edificioObjetoTextoHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.edificioObjetoTexto.header" javaScriptEscape="true"/>',
    	edificioObservacionesHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.edificioObservaciones.header" javaScriptEscape="true"/>',
    	edificioPisoLetraHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.edificioPisoLetra.header" javaScriptEscape="true"/>',
    	edificioPoblacionHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.edificioPoblacion.header" javaScriptEscape="true"/>',
    	edificioProvinciaHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.edificioProvincia.header" javaScriptEscape="true"/>',
    	edificioProvinciaIdHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.edificioProvinciaId.header" javaScriptEscape="true"/>',
    	edificioRegimenTextoHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.edificioRegimenTexto.header" javaScriptEscape="true"/>',
    	edificioTipoViaManualHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.edificioTipoViaManual.header" javaScriptEscape="true"/>',
    	edificioViaManualHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.edificioViaManual.header" javaScriptEscape="true"/>',
    	propiedadNifHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.propiedadNif.header" javaScriptEscape="true"/>',
    	propiedadTitularHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.propiedadTitular.header" javaScriptEscape="true"/>',
    	representanteCodigoPostalHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.representanteCodigoPostal.header" javaScriptEscape="true"/>',
    	representanteCondicionHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.representanteCondicion.header" javaScriptEscape="true"/>',
    	representanteDireccionHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.representanteDireccion.header" javaScriptEscape="true"/>',
    	representanteEmailHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.representanteEmail.header" javaScriptEscape="true"/>',
    	representanteNifHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.representanteNif.header" javaScriptEscape="true"/>',
    	representanteNombreHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.representanteNombre.header" javaScriptEscape="true"/>',
    	representantePoblacionHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.representantePoblacion.header" javaScriptEscape="true"/>',
    	representanteProvinciaHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.representanteProvincia.header" javaScriptEscape="true"/>',
    	representanteTelefonoFijoHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.representanteTelefonoFijo.header" javaScriptEscape="true"/>',
    	representanteTelefonoMovilHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.representanteTelefonoMovil.header" javaScriptEscape="true"/>',
    	tecnicoNifHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.tecnicoNif.header" javaScriptEscape="true"/>',
    	tecnicoTecnicoHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.tecnicoTecnico.header" javaScriptEscape="true"/>',
    	tecnicoTitulacionHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.tecnicoTitulacion.header" javaScriptEscape="true"/>',
    	accesibilidadPublicosHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.accesibilidadPublicos.header" javaScriptEscape="true"/>',
    	acusticaRuidosInterioresUnionesHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.acusticaRuidosInterioresUniones.header" javaScriptEscape="true"/>',
    	fechasVisitasHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.fechasVisitas.header" javaScriptEscape="true"/>',
    	acusticaValoracionFinalHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.acusticaValoracionFinal.header" javaScriptEscape="true"/>',
    	acusticaRuidosInterioresVerticalesHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.acusticaRuidosInterioresVerticales.header" javaScriptEscape="true"/>',
    	acusticaComprobacionesHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.acusticaComprobaciones.header" javaScriptEscape="true"/>',
    	instalacionesHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.instalaciones.header" javaScriptEscape="true"/>',
    	cerramientosCubiertasHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.cerramientosCubiertas.header" javaScriptEscape="true"/>',
    	valoracionesParcialesHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.valoracionesParciales.header" javaScriptEscape="true"/>',
    	accesibilidadValoracionFinalesHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.accesibilidadValoracionFinales.header" javaScriptEscape="true"/>',
    	acusticaRuidoInstalacionesHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.acusticaRuidoInstalaciones.header" javaScriptEscape="true"/>',
    	estructuraHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.estructura.header" javaScriptEscape="true"/>',
    	cimentacionesHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.cimentaciones.header" javaScriptEscape="true"/>',
    	accesibilidadAjustesRazonablesHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.accesibilidadAjustesRazonables.header" javaScriptEscape="true"/>',
    	eficienciasEnergeticasHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.eficienciasEnergeticas.header" javaScriptEscape="true"/>',
    	documentacionOtrosHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.documentacionOtros.header" javaScriptEscape="true"/>',
    	acusticaRuidosExterioresHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.acusticaRuidosExteriores.header" javaScriptEscape="true"/>',
    	acusticaMejorasAcusticasHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.acusticaMejorasAcusticas.header" javaScriptEscape="true"/>',
    	acusticaRuidosInterioresHorizontalesHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.acusticaRuidosInterioresHorizontales.header" javaScriptEscape="true"/>',
    	acusticaDatosGeneralesHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.acusticaDatosGenerales.header" javaScriptEscape="true"/>',
    	acusticasHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.acusticas.header" javaScriptEscape="true"/>',
    	deficienciasHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.deficiencias.header" javaScriptEscape="true"/>',
    	valoresHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.valores.header" javaScriptEscape="true"/>',
    	conservacionHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.conservacion.header" javaScriptEscape="true"/>',
    	historicosHeaderLabel          	: '<spring:message code="forms.inspeccion.columns.historicos.header" javaScriptEscape="true"/>',

  	});
}
