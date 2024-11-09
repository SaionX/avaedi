<%@page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
/**
 * Localización para form: documentacionotro
 * @author agarcia@at4.net
 * 
 */



if(At4FrameworkIntranet.DocumentacionOtroSubForm) {
  	Ext.apply(At4FrameworkIntranet.DocumentacionOtroSubForm.prototype, {
  			titleLabel: '<spring:message code="forms.documentacionotro.title" javaScriptEscape="true"/>', 
    	idHeaderLabel          	: '<spring:message code="forms.documentacionotro.columns.id.header" javaScriptEscape="true"/>',
    	inspeccionHeaderLabel          	: '<spring:message code="forms.documentacionotro.columns.inspeccion.header" javaScriptEscape="true"/>',
    	textoHeaderLabel          	: '<spring:message code="forms.documentacionotro.columns.texto.header" javaScriptEscape="true"/>',

  	});
}
