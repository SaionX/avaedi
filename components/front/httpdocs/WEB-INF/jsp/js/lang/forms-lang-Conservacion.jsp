<%@page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
/**
 * Localización para form: conservacion
 * @author agarcia@at4.net
 * 
 */




if(At4FrameworkIntranet.ConservacionForm) {
  	Ext.apply(At4FrameworkIntranet.ConservacionForm.prototype, {
  			titleLabel: '<spring:message code="forms.conservacion.title" javaScriptEscape="true"/>', 
    	claveInformeHeaderLabel          	: '<spring:message code="forms.conservacion.columns.claveInforme.header" javaScriptEscape="true"/>',
    	inspeccionHeaderLabel          	: '<spring:message code="forms.conservacion.columns.inspeccion.header" javaScriptEscape="true"/>',
    	esTecnicoInspeccionHeaderLabel          	: '<spring:message code="forms.conservacion.columns.esTecnicoInspeccion.header" javaScriptEscape="true"/>',
    	conservacionValoracionesTipoIdHeaderLabel          	: '<spring:message code="forms.conservacion.columns.conservacionValoracionesTipoId.header" javaScriptEscape="true"/>',
    	conservacionValoracionesTipoIdDescriptionLabel       : '<spring:message code="forms.conservacion.columns.conservacionValoracionesTipoId.description" javaScriptEscape="true"/>',
    	impedimentosVisitaHeaderLabel          	: '<spring:message code="forms.conservacion.columns.impedimentosVisita.header" javaScriptEscape="true"/>',
    	fechaEmisionInformeValoracionHeaderLabel          	: '<spring:message code="forms.conservacion.columns.fechaEmisionInformeValoracion.header" javaScriptEscape="true"/>',
    	fechaEmisionInformeValoracionDescriptionLabel       : '<spring:message code="forms.conservacion.columns.fechaEmisionInformeValoracion.description" javaScriptEscape="true"/>',
    	medidasSeguridadVisitaHeaderLabel          	: '<spring:message code="forms.conservacion.columns.medidasSeguridadVisita.header" javaScriptEscape="true"/>',
    	mediosInspeccionHeaderLabel          	: '<spring:message code="forms.conservacion.columns.mediosInspeccion.header" javaScriptEscape="true"/>',
    	nifHeaderLabel          	: '<spring:message code="forms.conservacion.columns.nif.header" javaScriptEscape="true"/>',
    	numLocalesInspeccionadosHeaderLabel          	: '<spring:message code="forms.conservacion.columns.numLocalesInspeccionados.header" javaScriptEscape="true"/>',
    	numViviendasInspeccionadasHeaderLabel          	: '<spring:message code="forms.conservacion.columns.numViviendasInspeccionadas.header" javaScriptEscape="true"/>',
    	observacionesHeaderLabel          	: '<spring:message code="forms.conservacion.columns.observaciones.header" javaScriptEscape="true"/>',
    	pruebasRealizadasHeaderLabel          	: '<spring:message code="forms.conservacion.columns.pruebasRealizadas.header" javaScriptEscape="true"/>',
    	tecnicoHeaderLabel          	: '<spring:message code="forms.conservacion.columns.tecnico.header" javaScriptEscape="true"/>',
    	titulacionHeaderLabel          	: '<spring:message code="forms.conservacion.columns.titulacion.header" javaScriptEscape="true"/>',
    	existePeligroInminenteHeaderLabel          	: '<spring:message code="forms.conservacion.columns.existePeligroInminente.header" javaScriptEscape="true"/>',
    	descripcionPeligroInminenteHeaderLabel          	: '<spring:message code="forms.conservacion.columns.descripcionPeligroInminente.header" javaScriptEscape="true"/>',
    	fechaLimiteActuacionHeaderLabel          	: '<spring:message code="forms.conservacion.columns.fechaLimiteActuacion.header" javaScriptEscape="true"/>',
    	medidasHeaderLabel          	: '<spring:message code="forms.conservacion.columns.medidas.header" javaScriptEscape="true"/>',

  	});
}

if(At4FrameworkIntranet.ConservacionSubForm) {
  	Ext.apply(At4FrameworkIntranet.ConservacionSubForm.prototype, {
  			titleLabel: '<spring:message code="forms.conservacion.title" javaScriptEscape="true"/>', 
    	claveInformeHeaderLabel          	: '<spring:message code="forms.conservacion.columns.claveInforme.header" javaScriptEscape="true"/>',
    	inspeccionHeaderLabel          	: '<spring:message code="forms.conservacion.columns.inspeccion.header" javaScriptEscape="true"/>',
    	esTecnicoInspeccionHeaderLabel          	: '<spring:message code="forms.conservacion.columns.esTecnicoInspeccion.header" javaScriptEscape="true"/>',
    	conservacionValoracionesTipoIdHeaderLabel          	: '<spring:message code="forms.conservacion.columns.conservacionValoracionesTipoId.header" javaScriptEscape="true"/>',
    	conservacionValoracionesTipoIdDescriptionLabel       : '<spring:message code="forms.conservacion.columns.conservacionValoracionesTipoId.description" javaScriptEscape="true"/>',
    	impedimentosVisitaHeaderLabel          	: '<spring:message code="forms.conservacion.columns.impedimentosVisita.header" javaScriptEscape="true"/>',
    	fechaEmisionInformeValoracionHeaderLabel          	: '<spring:message code="forms.conservacion.columns.fechaEmisionInformeValoracion.header" javaScriptEscape="true"/>',
    	fechaEmisionInformeValoracionDescriptionLabel       : '<spring:message code="forms.conservacion.columns.fechaEmisionInformeValoracion.description" javaScriptEscape="true"/>',
    	medidasSeguridadVisitaHeaderLabel          	: '<spring:message code="forms.conservacion.columns.medidasSeguridadVisita.header" javaScriptEscape="true"/>',
    	mediosInspeccionHeaderLabel          	: '<spring:message code="forms.conservacion.columns.mediosInspeccion.header" javaScriptEscape="true"/>',
    	nifHeaderLabel          	: '<spring:message code="forms.conservacion.columns.nif.header" javaScriptEscape="true"/>',
    	numLocalesInspeccionadosHeaderLabel          	: '<spring:message code="forms.conservacion.columns.numLocalesInspeccionados.header" javaScriptEscape="true"/>',
    	numViviendasInspeccionadasHeaderLabel          	: '<spring:message code="forms.conservacion.columns.numViviendasInspeccionadas.header" javaScriptEscape="true"/>',
    	observacionesHeaderLabel          	: '<spring:message code="forms.conservacion.columns.observaciones.header" javaScriptEscape="true"/>',
    	pruebasRealizadasHeaderLabel          	: '<spring:message code="forms.conservacion.columns.pruebasRealizadas.header" javaScriptEscape="true"/>',
    	tecnicoHeaderLabel          	: '<spring:message code="forms.conservacion.columns.tecnico.header" javaScriptEscape="true"/>',
    	titulacionHeaderLabel          	: '<spring:message code="forms.conservacion.columns.titulacion.header" javaScriptEscape="true"/>',
    	existePeligroInminenteHeaderLabel          	: '<spring:message code="forms.conservacion.columns.existePeligroInminente.header" javaScriptEscape="true"/>',
    	descripcionPeligroInminenteHeaderLabel          	: '<spring:message code="forms.conservacion.columns.descripcionPeligroInminente.header" javaScriptEscape="true"/>',
    	fechaLimiteActuacionHeaderLabel          	: '<spring:message code="forms.conservacion.columns.fechaLimiteActuacion.header" javaScriptEscape="true"/>',
    	medidasHeaderLabel          	: '<spring:message code="forms.conservacion.columns.medidas.header" javaScriptEscape="true"/>',

  	});
}
