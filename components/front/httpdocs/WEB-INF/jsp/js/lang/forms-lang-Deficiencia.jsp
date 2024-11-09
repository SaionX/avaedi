<%@page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
/**
 * Localización para form: deficiencia
 * @author agarcia@at4.net
 * 
 */





if(At4FrameworkIntranet.DeficienciaSubForm) {
  	Ext.apply(At4FrameworkIntranet.DeficienciaSubForm.prototype, {
  			titleLabel: '<spring:message code="forms.deficiencia.title" javaScriptEscape="true"/>', 
    	idHeaderLabel          	: '<spring:message code="forms.deficiencia.columns.id.header" javaScriptEscape="true"/>',
    	deficienciaTipoHeaderLabel          	: '<spring:message code="forms.deficiencia.columns.deficienciaTipo.header" javaScriptEscape="true"/>',
    	inspeccionHeaderLabel          	: '<spring:message code="forms.deficiencia.columns.inspeccion.header" javaScriptEscape="true"/>',
    	conservacionSistemasconstructivosTipoIdHeaderLabel          	: '<spring:message code="forms.deficiencia.columns.conservacionSistemasconstructivosTipoId.header" javaScriptEscape="true"/>',
    	conservacionSistemasconstructivosTipoIdDescriptionLabel       : '<spring:message code="forms.deficiencia.columns.conservacionSistemasconstructivosTipoId.description" javaScriptEscape="true"/>',
    	descripcionDeficienciaHeaderLabel          	: '<spring:message code="forms.deficiencia.columns.descripcionDeficiencia.header" javaScriptEscape="true"/>',
    	esGraveHeaderLabel          	: '<spring:message code="forms.deficiencia.columns.esGrave.header" javaScriptEscape="true"/>',
    	localizacionDeficienciaHeaderLabel          	: '<spring:message code="forms.deficiencia.columns.localizacionDeficiencia.header" javaScriptEscape="true"/>',
    	nombreDeficienciaHeaderLabel          	: '<spring:message code="forms.deficiencia.columns.nombreDeficiencia.header" javaScriptEscape="true"/>',
    	observacionesHeaderLabel          	: '<spring:message code="forms.deficiencia.columns.observaciones.header" javaScriptEscape="true"/>',
    	pruebasEnsayosRealizadosHeaderLabel          	: '<spring:message code="forms.deficiencia.columns.pruebasEnsayosRealizados.header" javaScriptEscape="true"/>',

  	});
}
