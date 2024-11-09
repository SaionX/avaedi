<%@page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
/**
 * Localización para form: via
 * @author agarcia@at4.net
 * 
 */




if(At4FrameworkIntranet.ViaForm) {
  	Ext.apply(At4FrameworkIntranet.ViaForm.prototype, {
  			titleLabel: '<spring:message code="forms.via.title" javaScriptEscape="true"/>', 
    	claveHeaderLabel          	: '<spring:message code="forms.via.columns.clave.header" javaScriptEscape="true"/>',
    	tipoViaHeaderLabel          	: '<spring:message code="forms.via.columns.tipoVia.header" javaScriptEscape="true"/>',
    	municipioHeaderLabel          	: '<spring:message code="forms.via.columns.municipio.header" javaScriptEscape="true"/>',
    	nombreHeaderLabel          	: '<spring:message code="forms.via.columns.nombre.header" javaScriptEscape="true"/>',
    	codigoCatastroHeaderLabel          	: '<spring:message code="forms.via.columns.codigoCatastro.header" javaScriptEscape="true"/>',

  	});
}

if(At4FrameworkIntranet.ViaSubForm) {
  	Ext.apply(At4FrameworkIntranet.ViaSubForm.prototype, {
  			titleLabel: '<spring:message code="forms.via.title" javaScriptEscape="true"/>', 
    	claveHeaderLabel          	: '<spring:message code="forms.via.columns.clave.header" javaScriptEscape="true"/>',
    	tipoViaHeaderLabel          	: '<spring:message code="forms.via.columns.tipoVia.header" javaScriptEscape="true"/>',
    	municipioHeaderLabel          	: '<spring:message code="forms.via.columns.municipio.header" javaScriptEscape="true"/>',
    	nombreHeaderLabel          	: '<spring:message code="forms.via.columns.nombre.header" javaScriptEscape="true"/>',
    	codigoCatastroHeaderLabel          	: '<spring:message code="forms.via.columns.codigoCatastro.header" javaScriptEscape="true"/>',

  	});
}
