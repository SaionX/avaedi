<%@page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
/**
 * Localización para form: cimentaciones
 * @author agarcia@at4.net
 * 
 */




if(At4FrameworkIntranet.CimentacionesForm) {
  	Ext.apply(At4FrameworkIntranet.CimentacionesForm.prototype, {
  			titleLabel: '<spring:message code="forms.cimentaciones.title" javaScriptEscape="true"/>', 
    	claveInformeHeaderLabel          	: '<spring:message code="forms.cimentaciones.columns.claveInforme.header" javaScriptEscape="true"/>',
    	inspeccionHeaderLabel          	: '<spring:message code="forms.cimentaciones.columns.inspeccion.header" javaScriptEscape="true"/>',
    	cimentacionprofundaTextoHeaderLabel          	: '<spring:message code="forms.cimentaciones.columns.cimentacionprofundaTexto.header" javaScriptEscape="true"/>',
    	cimentacionsuperficialTextoHeaderLabel          	: '<spring:message code="forms.cimentaciones.columns.cimentacionsuperficialTexto.header" javaScriptEscape="true"/>',
    	observacionesHeaderLabel          	: '<spring:message code="forms.cimentaciones.columns.observaciones.header" javaScriptEscape="true"/>',
    	sistemascontencionTextoHeaderLabel          	: '<spring:message code="forms.cimentaciones.columns.sistemascontencionTexto.header" javaScriptEscape="true"/>',

  	});
}

if(At4FrameworkIntranet.CimentacionesSubForm) {
  	Ext.apply(At4FrameworkIntranet.CimentacionesSubForm.prototype, {
  			titleLabel: '<spring:message code="forms.cimentaciones.title" javaScriptEscape="true"/>', 
    	claveInformeHeaderLabel          	: '<spring:message code="forms.cimentaciones.columns.claveInforme.header" javaScriptEscape="true"/>',
    	inspeccionHeaderLabel          	: '<spring:message code="forms.cimentaciones.columns.inspeccion.header" javaScriptEscape="true"/>',
    	cimentacionprofundaTextoHeaderLabel          	: '<spring:message code="forms.cimentaciones.columns.cimentacionprofundaTexto.header" javaScriptEscape="true"/>',
    	cimentacionsuperficialTextoHeaderLabel          	: '<spring:message code="forms.cimentaciones.columns.cimentacionsuperficialTexto.header" javaScriptEscape="true"/>',
    	observacionesHeaderLabel          	: '<spring:message code="forms.cimentaciones.columns.observaciones.header" javaScriptEscape="true"/>',
    	sistemascontencionTextoHeaderLabel          	: '<spring:message code="forms.cimentaciones.columns.sistemascontencionTexto.header" javaScriptEscape="true"/>',

  	});
}
