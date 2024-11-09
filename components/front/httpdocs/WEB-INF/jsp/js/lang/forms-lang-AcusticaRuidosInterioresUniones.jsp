<%@page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
/**
 * Localización para form: acusticaruidosinterioresuniones
 * @author agarcia@at4.net
 * 
 */




if(At4FrameworkIntranet.AcusticaRuidosInterioresUnionesForm) {
  	Ext.apply(At4FrameworkIntranet.AcusticaRuidosInterioresUnionesForm.prototype, {
  			titleLabel: '<spring:message code="forms.acusticaruidosinterioresuniones.title" javaScriptEscape="true"/>', 
    	claveInformeHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresuniones.columns.claveInforme.header" javaScriptEscape="true"/>',
    	inspeccionHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresuniones.columns.inspeccion.header" javaScriptEscape="true"/>',
    	elementoSeparacionVerticalForjadoConexionRigidaHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresuniones.columns.elementoSeparacionVerticalForjadoConexionRigida.header" javaScriptEscape="true"/>',
    	elementoSeparacionVerticalForjadoConexionRigidaDescriptionLabel       : '<spring:message code="forms.acusticaruidosinterioresuniones.columns.elementoSeparacionVerticalForjadoConexionRigida.description" javaScriptEscape="true"/>',
    	elementoSeparacionVerticalForjadoMorteroHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresuniones.columns.elementoSeparacionVerticalForjadoMortero.header" javaScriptEscape="true"/>',
    	elementoSeparacionVerticalForjadoMorteroDescriptionLabel       : '<spring:message code="forms.acusticaruidosinterioresuniones.columns.elementoSeparacionVerticalForjadoMortero.description" javaScriptEscape="true"/>',
    	elementoSeparacionVerticalForjadoSueloFlotanteHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresuniones.columns.elementoSeparacionVerticalForjadoSueloFlotante.header" javaScriptEscape="true"/>',
    	elementoSeparacionVerticalForjadoSueloFlotanteDescriptionLabel       : '<spring:message code="forms.acusticaruidosinterioresuniones.columns.elementoSeparacionVerticalForjadoSueloFlotante.description" javaScriptEscape="true"/>',
    	elementoSeparacionVerticalForjadoTechoSuspendidoHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresuniones.columns.elementoSeparacionVerticalForjadoTechoSuspendido.header" javaScriptEscape="true"/>',
    	elementoSeparacionVerticalForjadoTechoSuspendidoDescriptionLabel       : '<spring:message code="forms.acusticaruidosinterioresuniones.columns.elementoSeparacionVerticalForjadoTechoSuspendido.description" javaScriptEscape="true"/>',
    	hojaInteriorFachadaContinuaHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresuniones.columns.hojaInteriorFachadaContinua.header" javaScriptEscape="true"/>',
    	materialAislanteElasticoHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresuniones.columns.materialAislanteElastico.header" javaScriptEscape="true"/>',
    	observacionesHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresuniones.columns.observaciones.header" javaScriptEscape="true"/>',
		
		elementosSeparacionVerticalTitleLabel: '<spring:message code="forms.acusticaruidosinterioresuniones.grupos.elementosSeparacionVertical.header" javaScriptEscape="true"/>',
  	});
}

if(At4FrameworkIntranet.AcusticaRuidosInterioresUnionesSubForm) {
  	Ext.apply(At4FrameworkIntranet.AcusticaRuidosInterioresUnionesSubForm.prototype, {
  			titleLabel: '<spring:message code="forms.acusticaruidosinterioresuniones.title" javaScriptEscape="true"/>', 
    	claveInformeHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresuniones.columns.claveInforme.header" javaScriptEscape="true"/>',
    	inspeccionHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresuniones.columns.inspeccion.header" javaScriptEscape="true"/>',
    	elementoSeparacionVerticalForjadoConexionRigidaHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresuniones.columns.elementoSeparacionVerticalForjadoConexionRigida.header" javaScriptEscape="true"/>',
    	elementoSeparacionVerticalForjadoConexionRigidaDescriptionLabel       : '<spring:message code="forms.acusticaruidosinterioresuniones.columns.elementoSeparacionVerticalForjadoConexionRigida.description" javaScriptEscape="true"/>',
    	elementoSeparacionVerticalForjadoMorteroHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresuniones.columns.elementoSeparacionVerticalForjadoMortero.header" javaScriptEscape="true"/>',
    	elementoSeparacionVerticalForjadoMorteroDescriptionLabel       : '<spring:message code="forms.acusticaruidosinterioresuniones.columns.elementoSeparacionVerticalForjadoMortero.description" javaScriptEscape="true"/>',
    	elementoSeparacionVerticalForjadoSueloFlotanteHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresuniones.columns.elementoSeparacionVerticalForjadoSueloFlotante.header" javaScriptEscape="true"/>',
    	elementoSeparacionVerticalForjadoSueloFlotanteDescriptionLabel       : '<spring:message code="forms.acusticaruidosinterioresuniones.columns.elementoSeparacionVerticalForjadoSueloFlotante.description" javaScriptEscape="true"/>',
    	elementoSeparacionVerticalForjadoTechoSuspendidoHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresuniones.columns.elementoSeparacionVerticalForjadoTechoSuspendido.header" javaScriptEscape="true"/>',
    	elementoSeparacionVerticalForjadoTechoSuspendidoDescriptionLabel       : '<spring:message code="forms.acusticaruidosinterioresuniones.columns.elementoSeparacionVerticalForjadoTechoSuspendido.description" javaScriptEscape="true"/>',
    	hojaInteriorFachadaContinuaHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresuniones.columns.hojaInteriorFachadaContinua.header" javaScriptEscape="true"/>',
    	materialAislanteElasticoHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresuniones.columns.materialAislanteElastico.header" javaScriptEscape="true"/>',
    	observacionesHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresuniones.columns.observaciones.header" javaScriptEscape="true"/>',

  	});
}
