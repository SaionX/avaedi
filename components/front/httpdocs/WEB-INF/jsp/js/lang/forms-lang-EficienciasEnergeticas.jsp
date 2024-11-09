<%@page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
/**
 * Localización para form: eficienciasenergeticas
 * @author agarcia@at4.net
 * 
 */




if(At4FrameworkIntranet.EficienciasEnergeticasForm) {
  	Ext.apply(At4FrameworkIntranet.EficienciasEnergeticasForm.prototype, {
  			titleLabel: '<spring:message code="forms.eficienciasenergeticas.title" javaScriptEscape="true"/>', 
    	claveInformeHeaderLabel          	: '<spring:message code="forms.eficienciasenergeticas.columns.claveInforme.header" javaScriptEscape="true"/>',
    	inspeccionHeaderLabel          	: '<spring:message code="forms.eficienciasenergeticas.columns.inspeccion.header" javaScriptEscape="true"/>',
    	ambitoAplicacionHeaderLabel          	: '<spring:message code="forms.eficienciasenergeticas.columns.ambitoAplicacion.description" javaScriptEscape="true"/>',
    	demandaGlobalCalefaccionHeaderLabel          	: '<spring:message code="forms.eficienciasenergeticas.columns.demandaGlobalCalefaccion.header" javaScriptEscape="true"/>',
    	demandaGlobalCalefaccionCalificacionTipoIdHeaderLabel          	: '<spring:message code="forms.eficienciasenergeticas.columns.demandaGlobalCalefaccionCalificacionTipoId.header" javaScriptEscape="true"/>',
    	demandaGlobalCalefaccionCalificacionTipoIdDescriptionLabel       : '<spring:message code="forms.eficienciasenergeticas.columns.demandaGlobalCalefaccionCalificacionTipoId.description" javaScriptEscape="true"/>',
    	demandaGlobalRefrigeracionHeaderLabel          	: '<spring:message code="forms.eficienciasenergeticas.columns.demandaGlobalRefrigeracion.header" javaScriptEscape="true"/>',
    	demandaGlobalRefrigeracionCalificacionTipoIdHeaderLabel          	: '<spring:message code="forms.eficienciasenergeticas.columns.demandaGlobalRefrigeracionCalificacionTipoId.header" javaScriptEscape="true"/>',
    	demandaGlobalRefrigeracionCalificacionTipoIdDescriptionLabel       : '<spring:message code="forms.eficienciasenergeticas.columns.demandaGlobalRefrigeracionCalificacionTipoId.description" javaScriptEscape="true"/>',
    	esTecnicoInspeccionHeaderLabel          	: '<spring:message code="forms.eficienciasenergeticas.columns.esTecnicoInspeccion.header" javaScriptEscape="true"/>',
    	indicadorGlobalCalificacionTipoIdHeaderLabel          	: '<spring:message code="forms.eficienciasenergeticas.columns.indicadorGlobalCalificacionTipoId.header" javaScriptEscape="true"/>',
    	indicadorGlobalCalificacionTipoIdDescriptionLabel       : '<spring:message code="forms.eficienciasenergeticas.columns.indicadorGlobalCalificacionTipoId.description" javaScriptEscape="true"/>',
    	indicadorGlobalEmisionesHeaderLabel          	: '<spring:message code="forms.eficienciasenergeticas.columns.indicadorGlobalEmisiones.header" javaScriptEscape="true"/>',
    	indicadorGlobalPrimariaCalificacionTipoIdHeaderLabel          	: '<spring:message code="forms.eficienciasenergeticas.columns.indicadorGlobalPrimariaCalificacionTipoId.header" javaScriptEscape="true"/>',
    	indicadorGlobalPrimariaCalificacionTipoIdDescriptionLabel       : '<spring:message code="forms.eficienciasenergeticas.columns.indicadorGlobalPrimariaCalificacionTipoId.description" javaScriptEscape="true"/>',
    	indicadorGlobalPrimariaConsumoHeaderLabel          	: '<spring:message code="forms.eficienciasenergeticas.columns.indicadorGlobalPrimariaConsumo.header" javaScriptEscape="true"/>',
    	indicadorGlobalPrimariaConsumoDescriptionLabel       : '<spring:message code="forms.eficienciasenergeticas.columns.indicadorGlobalPrimariaConsumo.description" javaScriptEscape="true"/>',
    	indicadorParcialEmisionesAcsHeaderLabel          	: '<spring:message code="forms.eficienciasenergeticas.columns.indicadorParcialEmisionesAcs.header" javaScriptEscape="true"/>',
    	indicadorParcialEmisionesAcsDescriptionLabel       : '<spring:message code="forms.eficienciasenergeticas.columns.indicadorParcialEmisionesAcs.description" javaScriptEscape="true"/>',
    	indicadorParcialEmisionesCalefaccionHeaderLabel          	: '<spring:message code="forms.eficienciasenergeticas.columns.indicadorParcialEmisionesCalefaccion.header" javaScriptEscape="true"/>',
    	indicadorParcialEmisionesCalefaccionDescriptionLabel       : '<spring:message code="forms.eficienciasenergeticas.columns.indicadorParcialEmisionesCalefaccion.description" javaScriptEscape="true"/>',
    	indicadorParcialEmisionesRefrigeracionHeaderLabel          	: '<spring:message code="forms.eficienciasenergeticas.columns.indicadorParcialEmisionesRefrigeracion.header" javaScriptEscape="true"/>',
    	indicadorParcialEmisionesRefrigeracionDescriptionLabel       : '<spring:message code="forms.eficienciasenergeticas.columns.indicadorParcialEmisionesRefrigeracion.description" javaScriptEscape="true"/>',
    	indicadorParcialPrimariaAcsHeaderLabel          	: '<spring:message code="forms.eficienciasenergeticas.columns.indicadorParcialPrimariaAcs.header" javaScriptEscape="true"/>',
    	indicadorParcialPrimariaCalefaccionHeaderLabel          	: '<spring:message code="forms.eficienciasenergeticas.columns.indicadorParcialPrimariaCalefaccion.header" javaScriptEscape="true"/>',
    	indicadorParcialPrimariaCalefaccionDescriptionLabel       : '<spring:message code="forms.eficienciasenergeticas.columns.indicadorParcialPrimariaCalefaccion.description" javaScriptEscape="true"/>',
    	indicadorParcialPrimariaRefrigeracionHeaderLabel          	: '<spring:message code="forms.eficienciasenergeticas.columns.indicadorParcialPrimariaRefrigeracion.header" javaScriptEscape="true"/>',
    	indicadorParcialPrimariaRefrigeracionDescriptionLabel       : '<spring:message code="forms.eficienciasenergeticas.columns.indicadorParcialPrimariaRefrigeracion.description" javaScriptEscape="true"/>',
    	nifHeaderLabel          	: '<spring:message code="forms.eficienciasenergeticas.columns.nif.header" javaScriptEscape="true"/>',
    	observacionesHeaderLabel          	: '<spring:message code="forms.eficienciasenergeticas.columns.observaciones.header" javaScriptEscape="true"/>',
    	tecnicoHeaderLabel          	: '<spring:message code="forms.eficienciasenergeticas.columns.tecnico.header" javaScriptEscape="true"/>',
    	titulacionHeaderLabel          	: '<spring:message code="forms.eficienciasenergeticas.columns.titulacion.header" javaScriptEscape="true"/>',
		
		calificacionEnergeticaEdificioTitleLabel: '<spring:message code="forms.eficienciasenergeticas.grupos.calificacionEnergiaEdificio.header" javaScriptEscape="true"/>',
		calificacionDemandaEnergeticaCalefaccionRefrigeracionTitleLabel: '<spring:message code="forms.eficienciasenergeticas.grupos.calificacionDemandaEnergeticaCalefaccionRefrigeracion.header" javaScriptEscape="true"/>',
		calificacionParcialEnergiaPrimariaTitleLabel: '<spring:message code="forms.eficienciasenergeticas.grupos.calificacionParcialEnergiaPrimaria.header" javaScriptEscape="true"/>',
  	});
}

if(At4FrameworkIntranet.EficienciasEnergeticasSubForm) {
  	Ext.apply(At4FrameworkIntranet.EficienciasEnergeticasSubForm.prototype, {
  			titleLabel: '<spring:message code="forms.eficienciasenergeticas.title" javaScriptEscape="true"/>', 
    	claveInformeHeaderLabel          	: '<spring:message code="forms.eficienciasenergeticas.columns.claveInforme.header" javaScriptEscape="true"/>',
    	inspeccionHeaderLabel          	: '<spring:message code="forms.eficienciasenergeticas.columns.inspeccion.header" javaScriptEscape="true"/>',
    	ambitoAplicacionHeaderLabel          	: '<spring:message code="forms.eficienciasenergeticas.columns.ambitoAplicacion.header" javaScriptEscape="true"/>',
    	demandaGlobalCalefaccionHeaderLabel          	: '<spring:message code="forms.eficienciasenergeticas.columns.demandaGlobalCalefaccion.header" javaScriptEscape="true"/>',
    	demandaGlobalCalefaccionCalificacionTipoIdHeaderLabel          	: '<spring:message code="forms.eficienciasenergeticas.columns.demandaGlobalCalefaccionCalificacionTipoId.header" javaScriptEscape="true"/>',
    	demandaGlobalCalefaccionCalificacionTipoIdDescriptionLabel       : '<spring:message code="forms.eficienciasenergeticas.columns.demandaGlobalCalefaccionCalificacionTipoId.description" javaScriptEscape="true"/>',
    	demandaGlobalRefrigeracionHeaderLabel          	: '<spring:message code="forms.eficienciasenergeticas.columns.demandaGlobalRefrigeracion.header" javaScriptEscape="true"/>',
    	demandaGlobalRefrigeracionCalificacionTipoIdHeaderLabel          	: '<spring:message code="forms.eficienciasenergeticas.columns.demandaGlobalRefrigeracionCalificacionTipoId.header" javaScriptEscape="true"/>',
    	demandaGlobalRefrigeracionCalificacionTipoIdDescriptionLabel       : '<spring:message code="forms.eficienciasenergeticas.columns.demandaGlobalRefrigeracionCalificacionTipoId.description" javaScriptEscape="true"/>',
    	esTecnicoInspeccionHeaderLabel          	: '<spring:message code="forms.eficienciasenergeticas.columns.esTecnicoInspeccion.header" javaScriptEscape="true"/>',
    	indicadorGlobalCalificacionTipoIdHeaderLabel          	: '<spring:message code="forms.eficienciasenergeticas.columns.indicadorGlobalCalificacionTipoId.header" javaScriptEscape="true"/>',
    	indicadorGlobalCalificacionTipoIdDescriptionLabel       : '<spring:message code="forms.eficienciasenergeticas.columns.indicadorGlobalCalificacionTipoId.description" javaScriptEscape="true"/>',
    	indicadorGlobalEmisionesHeaderLabel          	: '<spring:message code="forms.eficienciasenergeticas.columns.indicadorGlobalEmisiones.header" javaScriptEscape="true"/>',
    	indicadorGlobalPrimariaCalificacionTipoIdHeaderLabel          	: '<spring:message code="forms.eficienciasenergeticas.columns.indicadorGlobalPrimariaCalificacionTipoId.header" javaScriptEscape="true"/>',
    	indicadorGlobalPrimariaCalificacionTipoIdDescriptionLabel       : '<spring:message code="forms.eficienciasenergeticas.columns.indicadorGlobalPrimariaCalificacionTipoId.description" javaScriptEscape="true"/>',
    	indicadorGlobalPrimariaConsumoHeaderLabel          	: '<spring:message code="forms.eficienciasenergeticas.columns.indicadorGlobalPrimariaConsumo.header" javaScriptEscape="true"/>',
    	indicadorGlobalPrimariaConsumoDescriptionLabel       : '<spring:message code="forms.eficienciasenergeticas.columns.indicadorGlobalPrimariaConsumo.description" javaScriptEscape="true"/>',
    	indicadorParcialEmisionesAcsHeaderLabel          	: '<spring:message code="forms.eficienciasenergeticas.columns.indicadorParcialEmisionesAcs.header" javaScriptEscape="true"/>',
    	indicadorParcialEmisionesAcsDescriptionLabel       : '<spring:message code="forms.eficienciasenergeticas.columns.indicadorParcialEmisionesAcs.description" javaScriptEscape="true"/>',
    	indicadorParcialEmisionesCalefaccionHeaderLabel          	: '<spring:message code="forms.eficienciasenergeticas.columns.indicadorParcialEmisionesCalefaccion.header" javaScriptEscape="true"/>',
    	indicadorParcialEmisionesCalefaccionDescriptionLabel       : '<spring:message code="forms.eficienciasenergeticas.columns.indicadorParcialEmisionesCalefaccion.description" javaScriptEscape="true"/>',
    	indicadorParcialEmisionesRefrigeracionHeaderLabel          	: '<spring:message code="forms.eficienciasenergeticas.columns.indicadorParcialEmisionesRefrigeracion.header" javaScriptEscape="true"/>',
    	indicadorParcialEmisionesRefrigeracionDescriptionLabel       : '<spring:message code="forms.eficienciasenergeticas.columns.indicadorParcialEmisionesRefrigeracion.description" javaScriptEscape="true"/>',
    	indicadorParcialPrimariaAcsHeaderLabel          	: '<spring:message code="forms.eficienciasenergeticas.columns.indicadorParcialPrimariaAcs.header" javaScriptEscape="true"/>',
    	indicadorParcialPrimariaCalefaccionHeaderLabel          	: '<spring:message code="forms.eficienciasenergeticas.columns.indicadorParcialPrimariaCalefaccion.header" javaScriptEscape="true"/>',
    	indicadorParcialPrimariaCalefaccionDescriptionLabel       : '<spring:message code="forms.eficienciasenergeticas.columns.indicadorParcialPrimariaCalefaccion.description" javaScriptEscape="true"/>',
    	indicadorParcialPrimariaRefrigeracionHeaderLabel          	: '<spring:message code="forms.eficienciasenergeticas.columns.indicadorParcialPrimariaRefrigeracion.header" javaScriptEscape="true"/>',
    	indicadorParcialPrimariaRefrigeracionDescriptionLabel       : '<spring:message code="forms.eficienciasenergeticas.columns.indicadorParcialPrimariaRefrigeracion.description" javaScriptEscape="true"/>',
    	nifHeaderLabel          	: '<spring:message code="forms.eficienciasenergeticas.columns.nif.header" javaScriptEscape="true"/>',
    	observacionesHeaderLabel          	: '<spring:message code="forms.eficienciasenergeticas.columns.observaciones.header" javaScriptEscape="true"/>',
    	tecnicoHeaderLabel          	: '<spring:message code="forms.eficienciasenergeticas.columns.tecnico.header" javaScriptEscape="true"/>',
    	titulacionHeaderLabel          	: '<spring:message code="forms.eficienciasenergeticas.columns.titulacion.header" javaScriptEscape="true"/>',

  	});
}
