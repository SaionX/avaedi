<%@page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
/**
 * Localización para form: acusticas
 * @author agarcia@at4.net
 * 
 */




if(At4FrameworkIntranet.AcusticasForm) {
  	Ext.apply(At4FrameworkIntranet.AcusticasForm.prototype, {
  			titleLabel: '<spring:message code="forms.acusticas.title" javaScriptEscape="true"/>', 
    	claveInformeHeaderLabel          	: '<spring:message code="forms.acusticas.columns.claveInforme.header" javaScriptEscape="true"/>',
    	inspeccionHeaderLabel          	: '<spring:message code="forms.acusticas.columns.inspeccion.header" javaScriptEscape="true"/>',
    	esTecnicoInspeccionHeaderLabel          	: '<spring:message code="forms.acusticas.columns.esTecnicoInspeccion.header" javaScriptEscape="true"/>',
    	incluirInformeAcusticaHeaderLabel          	: '<spring:message code="forms.acusticas.columns.incluirInformeAcustica.header" javaScriptEscape="true"/>',
    	nifHeaderLabel          	: '<spring:message code="forms.acusticas.columns.nif.header" javaScriptEscape="true"/>',
    	observacionesHeaderLabel          	: '<spring:message code="forms.acusticas.columns.observaciones.header" javaScriptEscape="true"/>',
    	tecnicoHeaderLabel          	: '<spring:message code="forms.acusticas.columns.tecnico.header" javaScriptEscape="true"/>',
    	titulacionHeaderLabel          	: '<spring:message code="forms.acusticas.columns.titulacion.header" javaScriptEscape="true"/>',

  	});
}

if(At4FrameworkIntranet.AcusticasSubForm) {
  	Ext.apply(At4FrameworkIntranet.AcusticasSubForm.prototype, {
  			titleLabel: '<spring:message code="forms.acusticas.title" javaScriptEscape="true"/>', 
    	claveInformeHeaderLabel          	: '<spring:message code="forms.acusticas.columns.claveInforme.header" javaScriptEscape="true"/>',
    	inspeccionHeaderLabel          	: '<spring:message code="forms.acusticas.columns.inspeccion.header" javaScriptEscape="true"/>',
    	esTecnicoInspeccionHeaderLabel          	: '<spring:message code="forms.acusticas.columns.esTecnicoInspeccion.header" javaScriptEscape="true"/>',
    	incluirInformeAcusticaHeaderLabel          	: '<spring:message code="forms.acusticas.columns.incluirInformeAcustica.header" javaScriptEscape="true"/>',
    	nifHeaderLabel          	: '<spring:message code="forms.acusticas.columns.nif.header" javaScriptEscape="true"/>',
    	observacionesHeaderLabel          	: '<spring:message code="forms.acusticas.columns.observaciones.header" javaScriptEscape="true"/>',
    	tecnicoHeaderLabel          	: '<spring:message code="forms.acusticas.columns.tecnico.header" javaScriptEscape="true"/>',
    	titulacionHeaderLabel          	: '<spring:message code="forms.acusticas.columns.titulacion.header" javaScriptEscape="true"/>',

  	});
}
