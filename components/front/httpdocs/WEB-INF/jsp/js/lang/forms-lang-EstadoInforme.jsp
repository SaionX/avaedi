<%@page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
/**
 * Localización para form: estadoinforme
 * @author agarcia@at4.net
 * 
 */




if(At4FrameworkIntranet.EstadoInformeForm) {
  	Ext.apply(At4FrameworkIntranet.EstadoInformeForm.prototype, {
  			titleLabel: '<spring:message code="forms.estadoinforme.title" javaScriptEscape="true"/>', 
    	claveHeaderLabel          	: '<spring:message code="forms.estadoinforme.columns.clave.header" javaScriptEscape="true"/>',
    	nombreEsHeaderLabel          	: '<spring:message code="forms.estadoinforme.columns.nombreEs.header" javaScriptEscape="true"/>',
    	nombreCaHeaderLabel          	: '<spring:message code="forms.estadoinforme.columns.nombreCa.header" javaScriptEscape="true"/>',

  	});
}

if(At4FrameworkIntranet.EstadoInformeSubForm) {
  	Ext.apply(At4FrameworkIntranet.EstadoInformeSubForm.prototype, {
  			titleLabel: '<spring:message code="forms.estadoinforme.title" javaScriptEscape="true"/>', 
    	claveHeaderLabel          	: '<spring:message code="forms.estadoinforme.columns.clave.header" javaScriptEscape="true"/>',
    	nombreEsHeaderLabel          	: '<spring:message code="forms.estadoinforme.columns.nombreEs.header" javaScriptEscape="true"/>',
    	nombreCaHeaderLabel          	: '<spring:message code="forms.estadoinforme.columns.nombreCa.header" javaScriptEscape="true"/>',

  	});
}
