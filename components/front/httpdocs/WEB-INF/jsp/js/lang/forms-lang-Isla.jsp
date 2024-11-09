<%@page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
/**
 * Localización para form: isla
 * @author agarcia@at4.net
 * 
 */




if(At4FrameworkIntranet.IslaForm) {
  	Ext.apply(At4FrameworkIntranet.IslaForm.prototype, {
  			titleLabel: '<spring:message code="forms.isla.title" javaScriptEscape="true"/>', 
    	idHeaderLabel          	: '<spring:message code="forms.isla.columns.id.header" javaScriptEscape="true"/>',
    	nombreHeaderLabel          	: '<spring:message code="forms.isla.columns.nombre.header" javaScriptEscape="true"/>',

  	});
}

if(At4FrameworkIntranet.IslaSubForm) {
  	Ext.apply(At4FrameworkIntranet.IslaSubForm.prototype, {
  			titleLabel: '<spring:message code="forms.isla.title" javaScriptEscape="true"/>', 
    	idHeaderLabel          	: '<spring:message code="forms.isla.columns.id.header" javaScriptEscape="true"/>',
    	nombreHeaderLabel          	: '<spring:message code="forms.isla.columns.nombre.header" javaScriptEscape="true"/>',

  	});
}
