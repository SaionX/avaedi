<%@page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
/**
 * Localización para form: valor
 * @author agarcia@at4.net
 * 
 */




if(At4FrameworkIntranet.ValorForm) {
  	Ext.apply(At4FrameworkIntranet.ValorForm.prototype, {
  			titleLabel: '<spring:message code="forms.valor.title" javaScriptEscape="true"/>', 
    	idHeaderLabel          	: '<spring:message code="forms.valor.columns.id.header" javaScriptEscape="true"/>',
    	caracteristicaHeaderLabel          	: '<spring:message code="forms.valor.columns.caracteristica.header" javaScriptEscape="true"/>',
    	nombreEsHeaderLabel          	: '<spring:message code="forms.valor.columns.nombreEs.header" javaScriptEscape="true"/>',
    	nombreCaHeaderLabel          	: '<spring:message code="forms.valor.columns.nombreCa.header" javaScriptEscape="true"/>',

  	});
}

if(At4FrameworkIntranet.ValorSubForm) {
  	Ext.apply(At4FrameworkIntranet.ValorSubForm.prototype, {
  			titleLabel: '<spring:message code="forms.valor.title" javaScriptEscape="true"/>', 
    	idHeaderLabel          	: '<spring:message code="forms.valor.columns.id.header" javaScriptEscape="true"/>',
    	caracteristicaHeaderLabel          	: '<spring:message code="forms.valor.columns.caracteristica.header" javaScriptEscape="true"/>',
    	nombreEsHeaderLabel          	: '<spring:message code="forms.valor.columns.nombreEs.header" javaScriptEscape="true"/>',
    	nombreCaHeaderLabel          	: '<spring:message code="forms.valor.columns.nombreCa.header" javaScriptEscape="true"/>',

  	});
}
