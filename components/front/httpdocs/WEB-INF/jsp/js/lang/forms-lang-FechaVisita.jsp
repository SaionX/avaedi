<%@page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
/**
 * Localización para form: fechavisita
 * @author agarcia@at4.net
 * 
 */


if(At4FrameworkIntranet.FechaVisitaSubForm) {
  	Ext.apply(At4FrameworkIntranet.FechaVisitaSubForm.prototype, {
  			titleLabel: '<spring:message code="forms.fechavisita.title" javaScriptEscape="true"/>', 
    	idHeaderLabel          	: '<spring:message code="forms.fechavisita.columns.id.header" javaScriptEscape="true"/>',
    	inspeccionHeaderLabel          	: '<spring:message code="forms.fechavisita.columns.inspeccion.header" javaScriptEscape="true"/>',
    	fechaHeaderLabel          	: '<spring:message code="forms.fechavisita.columns.fecha.header" javaScriptEscape="true"/>',

  	});
}
