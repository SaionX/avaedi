<%@page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
/**
 * Localización para form: acusticacomprobaciones
 * @author agarcia@at4.net
 * 
 */




if(At4FrameworkIntranet.AcusticaComprobacionesForm) {
  	Ext.apply(At4FrameworkIntranet.AcusticaComprobacionesForm.prototype, {
  			titleLabel: '<spring:message code="forms.acusticacomprobaciones.title" javaScriptEscape="true"/>', 
    	claveInformeHeaderLabel          	: '<spring:message code="forms.acusticacomprobaciones.columns.claveInforme.header" javaScriptEscape="true"/>',
    	inspeccionHeaderLabel          	: '<spring:message code="forms.acusticacomprobaciones.columns.inspeccion.header" javaScriptEscape="true"/>',
    	calasCatasElementosConstructivosHeaderLabel          	: '<spring:message code="forms.acusticacomprobaciones.columns.calasCatasElementosConstructivos.header" javaScriptEscape="true"/>',
    	calasCatasElementosConstructivosDescriptionLabel       : '<spring:message code="forms.acusticacomprobaciones.columns.calasCatasElementosConstructivos.description" javaScriptEscape="true"/>',
    	cuestionariosConfortAcusticoHeaderLabel          	: '<spring:message code="forms.acusticacomprobaciones.columns.cuestionariosConfortAcustico.header" javaScriptEscape="true"/>',
    	medicionesAislamientoAcusticoHeaderLabel          	: '<spring:message code="forms.acusticacomprobaciones.columns.medicionesAislamientoAcustico.header" javaScriptEscape="true"/>',
    	medicionesAislamientoAcusticoDescriptionLabel       : '<spring:message code="forms.acusticacomprobaciones.columns.medicionesAislamientoAcustico.description" javaScriptEscape="true"/>',
    	observacionesHeaderLabel          	: '<spring:message code="forms.acusticacomprobaciones.columns.observaciones.header" javaScriptEscape="true"/>',
    	otrasHeaderLabel          	: '<spring:message code="forms.acusticacomprobaciones.columns.otras.header" javaScriptEscape="true"/>',
    	otrasTextoHeaderLabel          	: '<spring:message code="forms.acusticacomprobaciones.columns.otrasTexto.header" javaScriptEscape="true"/>',

  	});
}

if(At4FrameworkIntranet.AcusticaComprobacionesSubForm) {
  	Ext.apply(At4FrameworkIntranet.AcusticaComprobacionesSubForm.prototype, {
  			titleLabel: '<spring:message code="forms.acusticacomprobaciones.title" javaScriptEscape="true"/>', 
    	claveInformeHeaderLabel          	: '<spring:message code="forms.acusticacomprobaciones.columns.claveInforme.header" javaScriptEscape="true"/>',
    	inspeccionHeaderLabel          	: '<spring:message code="forms.acusticacomprobaciones.columns.inspeccion.header" javaScriptEscape="true"/>',
    	calasCatasElementosConstructivosHeaderLabel          	: '<spring:message code="forms.acusticacomprobaciones.columns.calasCatasElementosConstructivos.header" javaScriptEscape="true"/>',
    	calasCatasElementosConstructivosDescriptionLabel       : '<spring:message code="forms.acusticacomprobaciones.columns.calasCatasElementosConstructivos.description" javaScriptEscape="true"/>',
    	cuestionariosConfortAcusticoHeaderLabel          	: '<spring:message code="forms.acusticacomprobaciones.columns.cuestionariosConfortAcustico.header" javaScriptEscape="true"/>',
    	medicionesAislamientoAcusticoHeaderLabel          	: '<spring:message code="forms.acusticacomprobaciones.columns.medicionesAislamientoAcustico.header" javaScriptEscape="true"/>',
    	medicionesAislamientoAcusticoDescriptionLabel       : '<spring:message code="forms.acusticacomprobaciones.columns.medicionesAislamientoAcustico.description" javaScriptEscape="true"/>',
    	observacionesHeaderLabel          	: '<spring:message code="forms.acusticacomprobaciones.columns.observaciones.header" javaScriptEscape="true"/>',
    	otrasHeaderLabel          	: '<spring:message code="forms.acusticacomprobaciones.columns.otras.header" javaScriptEscape="true"/>',
    	otrasTextoHeaderLabel          	: '<spring:message code="forms.acusticacomprobaciones.columns.otrasTexto.header" javaScriptEscape="true"/>',

  	});
}
