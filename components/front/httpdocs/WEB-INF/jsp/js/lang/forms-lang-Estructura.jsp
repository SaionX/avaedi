<%@page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
/**
 * Localización para form: estructura
 * @author agarcia@at4.net
 * 
 */




if(At4FrameworkIntranet.EstructuraForm) {
  	Ext.apply(At4FrameworkIntranet.EstructuraForm.prototype, {
  			titleLabel: '<spring:message code="forms.estructura.title" javaScriptEscape="true"/>', 
    	claveInformeHeaderLabel          	: '<spring:message code="forms.estructura.columns.claveInforme.header" javaScriptEscape="true"/>',
    	inspeccionHeaderLabel          	: '<spring:message code="forms.estructura.columns.inspeccion.header" javaScriptEscape="true"/>',
    	cubiertaForjadoinclinadoTextoHeaderLabel          	: '<spring:message code="forms.estructura.columns.cubiertaForjadoinclinadoTexto.header" javaScriptEscape="true"/>',
    	cubiertaForjadoinclinadoTextoDescriptionLabel       : '<spring:message code="forms.estructura.columns.cubiertaForjadoinclinadoTexto.description" javaScriptEscape="true"/>',
    	cubiertaOtrosTextoHeaderLabel          	: '<spring:message code="forms.estructura.columns.cubiertaOtrosTexto.header" javaScriptEscape="true"/>',
    	horizontalplantatipoOtrosTextoHeaderLabel          	: '<spring:message code="forms.estructura.columns.horizontalplantatipoOtrosTexto.header" javaScriptEscape="true"/>',
    	horizontalplantatipoOtrosTextoDescriptionLabel       : '<spring:message code="forms.estructura.columns.horizontalplantatipoOtrosTexto.description" javaScriptEscape="true"/>',
    	horizontalsueloOtrosTextoHeaderLabel          	: '<spring:message code="forms.estructura.columns.horizontalsueloOtrosTexto.header" javaScriptEscape="true"/>',
    	observacionesHeaderLabel          	: '<spring:message code="forms.estructura.columns.observaciones.header" javaScriptEscape="true"/>',
    	verticalOtrosHeaderLabel          	: '<spring:message code="forms.estructura.columns.verticalOtros.header" javaScriptEscape="true"/>',
    	verticalOtrosTextoHeaderLabel          	: '<spring:message code="forms.estructura.columns.verticalOtrosTexto.header" javaScriptEscape="true"/>',

  	});
}

if(At4FrameworkIntranet.EstructuraSubForm) {
  	Ext.apply(At4FrameworkIntranet.EstructuraSubForm.prototype, {
  			titleLabel: '<spring:message code="forms.estructura.title" javaScriptEscape="true"/>', 
    	claveInformeHeaderLabel          	: '<spring:message code="forms.estructura.columns.claveInforme.header" javaScriptEscape="true"/>',
    	inspeccionHeaderLabel          	: '<spring:message code="forms.estructura.columns.inspeccion.header" javaScriptEscape="true"/>',
    	cubiertaForjadoinclinadoTextoHeaderLabel          	: '<spring:message code="forms.estructura.columns.cubiertaForjadoinclinadoTexto.header" javaScriptEscape="true"/>',
    	cubiertaForjadoinclinadoTextoDescriptionLabel       : '<spring:message code="forms.estructura.columns.cubiertaForjadoinclinadoTexto.description" javaScriptEscape="true"/>',
    	cubiertaOtrosTextoHeaderLabel          	: '<spring:message code="forms.estructura.columns.cubiertaOtrosTexto.header" javaScriptEscape="true"/>',
    	horizontalplantatipoOtrosTextoHeaderLabel          	: '<spring:message code="forms.estructura.columns.horizontalplantatipoOtrosTexto.header" javaScriptEscape="true"/>',
    	horizontalplantatipoOtrosTextoDescriptionLabel       : '<spring:message code="forms.estructura.columns.horizontalplantatipoOtrosTexto.description" javaScriptEscape="true"/>',
    	horizontalsueloOtrosTextoHeaderLabel          	: '<spring:message code="forms.estructura.columns.horizontalsueloOtrosTexto.header" javaScriptEscape="true"/>',
    	observacionesHeaderLabel          	: '<spring:message code="forms.estructura.columns.observaciones.header" javaScriptEscape="true"/>',
    	verticalOtrosHeaderLabel          	: '<spring:message code="forms.estructura.columns.verticalOtros.header" javaScriptEscape="true"/>',
    	verticalOtrosTextoHeaderLabel          	: '<spring:message code="forms.estructura.columns.verticalOtrosTexto.header" javaScriptEscape="true"/>',

  	});
}
