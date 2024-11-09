<%@page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
/**
 * Localización para form: valoracionparcial
 * @author agarcia@at4.net
 * 
 */



if(At4FrameworkIntranet.ValoracionParcialSubForm) {
  	Ext.apply(At4FrameworkIntranet.ValoracionParcialSubForm.prototype, {
  			titleLabel: '<spring:message code="forms.valoracionparcial.title" javaScriptEscape="true"/>', 
    	idHeaderLabel          	: '<spring:message code="forms.valoracionparcial.columns.id.header" javaScriptEscape="true"/>',
    	inspeccionHeaderLabel          	: '<spring:message code="forms.valoracionparcial.columns.inspeccion.header" javaScriptEscape="true"/>',
    	conservacionSistemasconstructivosTipoIdHeaderLabel          	: '<spring:message code="forms.valoracionparcial.columns.conservacionSistemasconstructivosTipoId.header" javaScriptEscape="true"/>',
    	conservacionSistemasconstructivosTipoIdDescriptionLabel       : '<spring:message code="forms.valoracionparcial.columns.conservacionSistemasconstructivosTipoId.description" javaScriptEscape="true"/>',
    	conservacionValoracionesTipoIdHeaderLabel          	: '<spring:message code="forms.valoracionparcial.columns.conservacionValoracionesTipoId.header" javaScriptEscape="true"/>',
    	conservacionValoracionesTipoIdDescriptionLabel       : '<spring:message code="forms.valoracionparcial.columns.conservacionValoracionesTipoId.description" javaScriptEscape="true"/>',
    	plazoFinObrasHeaderLabel          	: '<spring:message code="forms.valoracionparcial.columns.plazoFinObras.header" javaScriptEscape="true"/>',
    	plazoInicioObrasHeaderLabel          	: '<spring:message code="forms.valoracionparcial.columns.plazoInicioObras.header" javaScriptEscape="true"/>',

  	});
}
