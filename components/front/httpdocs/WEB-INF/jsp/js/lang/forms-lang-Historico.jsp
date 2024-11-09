<%@page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
/**
 * Localización para form: historico
 * @author agarcia@at4.net
 * 
 */


if(At4FrameworkIntranet.HistoricoSubForm) {
  	Ext.apply(At4FrameworkIntranet.HistoricoSubForm.prototype, {
  			titleLabel: '<spring:message code="forms.historico.title" javaScriptEscape="true"/>', 
    	idHeaderLabel          	: '<spring:message code="forms.historico.columns.id.header" javaScriptEscape="true"/>',
    	inspeccionHeaderLabel          	: '<spring:message code="forms.historico.columns.inspeccion.header" javaScriptEscape="true"/>',
    	fechaInspeccionHeaderLabel          	: '<spring:message code="forms.historico.columns.fechaInspeccion.header" javaScriptEscape="true"/>',
    	gradoEjecucionEfectividadObrasHeaderLabel          	: '<spring:message code="forms.historico.columns.gradoEjecucionEfectividadObras.header" javaScriptEscape="true"/>',
    	gradoEjecucionEfectividadObrasDescriptionLabel       : '<spring:message code="forms.historico.columns.gradoEjecucionEfectividadObras.description" javaScriptEscape="true"/>',
    	observacionesHeaderLabel          	: '<spring:message code="forms.historico.columns.observaciones.header" javaScriptEscape="true"/>',
    	resultadoHeaderLabel          	: '<spring:message code="forms.historico.columns.resultado.header" javaScriptEscape="true"/>',
    	tecnicoHeaderLabel          	: '<spring:message code="forms.historico.columns.tecnico.header" javaScriptEscape="true"/>',

  	});
}
