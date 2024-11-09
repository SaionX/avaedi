<%@page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
/**
 * Localización para form: acusticaruidosinterioreshorizontales
 * @author agarcia@at4.net
 * 
 */




if(At4FrameworkIntranet.AcusticaRuidosInterioresHorizontalesForm) {
  	Ext.apply(At4FrameworkIntranet.AcusticaRuidosInterioresHorizontalesForm.prototype, {
  			titleLabel: '<spring:message code="forms.acusticaruidosinterioreshorizontales.title" javaScriptEscape="true"/>', 
    	claveInformeHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioreshorizontales.columns.claveInforme.header" javaScriptEscape="true"/>',
    	inspeccionHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioreshorizontales.columns.inspeccion.header" javaScriptEscape="true"/>',
    	caracteristicasCamaraAireContinuaHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioreshorizontales.columns.caracteristicasCamaraAireContinua.header" javaScriptEscape="true"/>',
    	caracteristicasCamaraAireContinuaDescriptionLabel       : '<spring:message code="forms.acusticaruidosinterioreshorizontales.columns.caracteristicasCamaraAireContinua.description" javaScriptEscape="true"/>',
    	caracteristicasLuminariasEmpotradasSelladasHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioreshorizontales.columns.caracteristicasLuminariasEmpotradasSelladas.header" javaScriptEscape="true"/>',
    	caracteristicasLuminariasEmpotradasSelladasDescriptionLabel       : '<spring:message code="forms.acusticaruidosinterioreshorizontales.columns.caracteristicasLuminariasEmpotradasSelladas.description" javaScriptEscape="true"/>',
    	caracteristicasSueloFlotanteContactoDirectoHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioreshorizontales.columns.caracteristicasSueloFlotanteContactoDirecto.header" javaScriptEscape="true"/>',
    	caracteristicasSueloFlotanteContactoDirectoDescriptionLabel       : '<spring:message code="forms.acusticaruidosinterioreshorizontales.columns.caracteristicasSueloFlotanteContactoDirecto.description" javaScriptEscape="true"/>',
    	caracteristicasSueloFlotanteRevestidasHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioreshorizontales.columns.caracteristicasSueloFlotanteRevestidas.header" javaScriptEscape="true"/>',
    	caracteristicasSueloFlotanteRevestidasDescriptionLabel       : '<spring:message code="forms.acusticaruidosinterioreshorizontales.columns.caracteristicasSueloFlotanteRevestidas.description" javaScriptEscape="true"/>',
    	deficienciasObservacionesHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioreshorizontales.columns.deficienciasObservaciones.header" javaScriptEscape="true"/>',
    	estadoBuenoHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioreshorizontales.columns.estadoBueno.header" javaScriptEscape="true"/>',
    	forjadoPlantagarajeOtroHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioreshorizontales.columns.forjadoPlantagarajeOtro.header" javaScriptEscape="true"/>',
    	forjadoPlantatipoOtroHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioreshorizontales.columns.forjadoPlantatipoOtro.header" javaScriptEscape="true"/>',
    	observacionesHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioreshorizontales.columns.observaciones.header" javaScriptEscape="true"/>',
    	plantagarajeCantoForjadoHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioreshorizontales.columns.plantagarajeCantoForjado.header" javaScriptEscape="true"/>',
    	plantatipoCantoForjadoHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioreshorizontales.columns.plantatipoCantoForjado.header" javaScriptEscape="true"/>',
    	sueloFlotanteTieneHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioreshorizontales.columns.sueloFlotanteTiene.header" javaScriptEscape="true"/>',
    	techoSuspendidoTieneHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioreshorizontales.columns.techoSuspendidoTiene.header" javaScriptEscape="true"/>',
		
		caracteristicasTitleLabel: '<spring:message code="forms.acusticaruidosinterioreshorizontales.grupos.caracteristicas.header" javaScriptEscape="true"/>',
  	});
}

if(At4FrameworkIntranet.AcusticaRuidosInterioresHorizontalesSubForm) {
  	Ext.apply(At4FrameworkIntranet.AcusticaRuidosInterioresHorizontalesSubForm.prototype, {
  			titleLabel: '<spring:message code="forms.acusticaruidosinterioreshorizontales.title" javaScriptEscape="true"/>', 
    	claveInformeHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioreshorizontales.columns.claveInforme.header" javaScriptEscape="true"/>',
    	inspeccionHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioreshorizontales.columns.inspeccion.header" javaScriptEscape="true"/>',
    	caracteristicasCamaraAireContinuaHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioreshorizontales.columns.caracteristicasCamaraAireContinua.header" javaScriptEscape="true"/>',
    	caracteristicasCamaraAireContinuaDescriptionLabel       : '<spring:message code="forms.acusticaruidosinterioreshorizontales.columns.caracteristicasCamaraAireContinua.description" javaScriptEscape="true"/>',
    	caracteristicasLuminariasEmpotradasSelladasHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioreshorizontales.columns.caracteristicasLuminariasEmpotradasSelladas.header" javaScriptEscape="true"/>',
    	caracteristicasLuminariasEmpotradasSelladasDescriptionLabel       : '<spring:message code="forms.acusticaruidosinterioreshorizontales.columns.caracteristicasLuminariasEmpotradasSelladas.description" javaScriptEscape="true"/>',
    	caracteristicasSueloFlotanteContactoDirectoHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioreshorizontales.columns.caracteristicasSueloFlotanteContactoDirecto.header" javaScriptEscape="true"/>',
    	caracteristicasSueloFlotanteContactoDirectoDescriptionLabel       : '<spring:message code="forms.acusticaruidosinterioreshorizontales.columns.caracteristicasSueloFlotanteContactoDirecto.description" javaScriptEscape="true"/>',
    	caracteristicasSueloFlotanteRevestidasHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioreshorizontales.columns.caracteristicasSueloFlotanteRevestidas.header" javaScriptEscape="true"/>',
    	caracteristicasSueloFlotanteRevestidasDescriptionLabel       : '<spring:message code="forms.acusticaruidosinterioreshorizontales.columns.caracteristicasSueloFlotanteRevestidas.description" javaScriptEscape="true"/>',
    	deficienciasObservacionesHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioreshorizontales.columns.deficienciasObservaciones.header" javaScriptEscape="true"/>',
    	estadoBuenoHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioreshorizontales.columns.estadoBueno.header" javaScriptEscape="true"/>',
    	forjadoPlantagarajeOtroHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioreshorizontales.columns.forjadoPlantagarajeOtro.header" javaScriptEscape="true"/>',
    	forjadoPlantatipoOtroHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioreshorizontales.columns.forjadoPlantatipoOtro.header" javaScriptEscape="true"/>',
    	observacionesHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioreshorizontales.columns.observaciones.header" javaScriptEscape="true"/>',
    	plantagarajeCantoForjadoHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioreshorizontales.columns.plantagarajeCantoForjado.header" javaScriptEscape="true"/>',
    	plantatipoCantoForjadoHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioreshorizontales.columns.plantatipoCantoForjado.header" javaScriptEscape="true"/>',
    	sueloFlotanteTieneHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioreshorizontales.columns.sueloFlotanteTiene.header" javaScriptEscape="true"/>',
    	techoSuspendidoTieneHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioreshorizontales.columns.techoSuspendidoTiene.header" javaScriptEscape="true"/>',

  	});
}
