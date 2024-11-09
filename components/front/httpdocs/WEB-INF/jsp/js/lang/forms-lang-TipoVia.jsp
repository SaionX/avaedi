<%@page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
/**
 * Localización para form: tipovia
 * @author agarcia@at4.net
 * 
 */




if(At4FrameworkIntranet.TipoViaForm) {
  	Ext.apply(At4FrameworkIntranet.TipoViaForm.prototype, {
  			titleLabel: '<spring:message code="forms.tipovia.title" javaScriptEscape="true"/>', 
    	claveHeaderLabel          	: '<spring:message code="forms.tipovia.columns.clave.header" javaScriptEscape="true"/>',
    	codigoCatastroHeaderLabel          	: '<spring:message code="forms.tipovia.columns.codigoCatastro.header" javaScriptEscape="true"/>',
    	nombreEsHeaderLabel          	: '<spring:message code="forms.tipovia.columns.nombreEs.header" javaScriptEscape="true"/>',
    	nombreCaHeaderLabel          	: '<spring:message code="forms.tipovia.columns.nombreCa.header" javaScriptEscape="true"/>',

  	});
}

if(At4FrameworkIntranet.TipoViaSubForm) {
  	Ext.apply(At4FrameworkIntranet.TipoViaSubForm.prototype, {
  			titleLabel: '<spring:message code="forms.tipovia.title" javaScriptEscape="true"/>', 
    	claveHeaderLabel          	: '<spring:message code="forms.tipovia.columns.clave.header" javaScriptEscape="true"/>',
    	codigoCatastroHeaderLabel          	: '<spring:message code="forms.tipovia.columns.codigoCatastro.header" javaScriptEscape="true"/>',
    	nombreEsHeaderLabel          	: '<spring:message code="forms.tipovia.columns.nombreEs.header" javaScriptEscape="true"/>',
    	nombreCaHeaderLabel          	: '<spring:message code="forms.tipovia.columns.nombreCa.header" javaScriptEscape="true"/>',

  	});
}
