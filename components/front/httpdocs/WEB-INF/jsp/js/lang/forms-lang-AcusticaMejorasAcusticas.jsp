<%@page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
/**
 * Localización para form: acusticamejorasacusticas
 * @author agarcia@at4.net
 * 
 */




if(At4FrameworkIntranet.AcusticaMejorasAcusticasForm) {
  	Ext.apply(At4FrameworkIntranet.AcusticaMejorasAcusticasForm.prototype, {
  			titleLabel: '<spring:message code="forms.acusticamejorasacusticas.title" javaScriptEscape="true"/>', 
    	claveInformeHeaderLabel          	: '<spring:message code="forms.acusticamejorasacusticas.columns.claveInforme.header" javaScriptEscape="true"/>',
    	inspeccionHeaderLabel          	: '<spring:message code="forms.acusticamejorasacusticas.columns.inspeccion.header" javaScriptEscape="true"/>',
    	proteccionRuidoExteriorTipoIdHeaderLabel          	: '<spring:message code="forms.acusticamejorasacusticas.columns.proteccionRuidoExteriorTipoId.header" javaScriptEscape="true"/>',
    	proteccionRuidoExteriorTipoIdDescriptionLabel       : '<spring:message code="forms.acusticamejorasacusticas.columns.proteccionRuidoExteriorTipoId.description" javaScriptEscape="true"/>',
    	mejorasAnalisisTecnicoHeaderLabel          	: '<spring:message code="forms.acusticamejorasacusticas.columns.mejorasAnalisisTecnico.header" javaScriptEscape="true"/>',
    	proteccionRuidoInstalacionesTipoIdHeaderLabel          	: '<spring:message code="forms.acusticamejorasacusticas.columns.proteccionRuidoInstalacionesTipoId.header" javaScriptEscape="true"/>',
    	proteccionRuidoInstalacionesTipoIdDescriptionLabel       : '<spring:message code="forms.acusticamejorasacusticas.columns.proteccionRuidoInstalacionesTipoId.description" javaScriptEscape="true"/>',
    	mejorasDescripcionHeaderLabel          	: '<spring:message code="forms.acusticamejorasacusticas.columns.mejorasDescripcion.header" javaScriptEscape="true"/>',
    	proteccionRuidoInteriorAereoTipoIdHeaderLabel          	: '<spring:message code="forms.acusticamejorasacusticas.columns.proteccionRuidoInteriorAereoTipoId.header" javaScriptEscape="true"/>',
    	proteccionRuidoInteriorAereoTipoIdDescriptionLabel       : '<spring:message code="forms.acusticamejorasacusticas.columns.proteccionRuidoInteriorAereoTipoId.description" javaScriptEscape="true"/>',
    	mejorasObservacionesHeaderLabel          	: '<spring:message code="forms.acusticamejorasacusticas.columns.mejorasObservaciones.header" javaScriptEscape="true"/>',
    	proteccionRuidoInteriorImpactosTipoIdHeaderLabel          	: '<spring:message code="forms.acusticamejorasacusticas.columns.proteccionRuidoInteriorImpactosTipoId.header" javaScriptEscape="true"/>',
    	proteccionRuidoInteriorImpactosTipoIdDescriptionLabel       : '<spring:message code="forms.acusticamejorasacusticas.columns.proteccionRuidoInteriorImpactosTipoId.description" javaScriptEscape="true"/>',
    	mejorasOrdenHeaderLabel          	: '<spring:message code="forms.acusticamejorasacusticas.columns.mejorasOrden.header" javaScriptEscape="true"/>',
    	mejorasValoracionEconomicaHeaderLabel          	: '<spring:message code="forms.acusticamejorasacusticas.columns.mejorasValoracionEconomica.header" javaScriptEscape="true"/>',
    	potencialObservacionesHeaderLabel          	: '<spring:message code="forms.acusticamejorasacusticas.columns.potencialObservaciones.header" javaScriptEscape="true"/>',
    	incidenciaObservacionesHeaderLabel          	: '<spring:message code="forms.acusticamejorasacusticas.columns.incidenciaObservaciones.header" javaScriptEscape="true"/>',
    	incidenciaTextoHeaderLabel          	: '<spring:message code="forms.acusticamejorasacusticas.columns.incidenciaTexto.header" javaScriptEscape="true"/>',
		
		proteccionTitleLabel: '<spring:message code="forms.acusticamejorasacusticas.grupos.proteccion.header" javaScriptEscape="true"/>',
		mejorasTitleLabel: '<spring:message code="forms.acusticamejorasacusticas.grupos.mejoras.header" javaScriptEscape="true"/>',
		
  	});
}

if(At4FrameworkIntranet.AcusticaMejorasAcusticasSubForm) {
  	Ext.apply(At4FrameworkIntranet.AcusticaMejorasAcusticasSubForm.prototype, {
  			titleLabel: '<spring:message code="forms.acusticamejorasacusticas.title" javaScriptEscape="true"/>', 
    	claveInformeHeaderLabel          	: '<spring:message code="forms.acusticamejorasacusticas.columns.claveInforme.header" javaScriptEscape="true"/>',
    	inspeccionHeaderLabel          	: '<spring:message code="forms.acusticamejorasacusticas.columns.inspeccion.header" javaScriptEscape="true"/>',
    	proteccionRuidoExteriorTipoIdHeaderLabel          	: '<spring:message code="forms.acusticamejorasacusticas.columns.proteccionRuidoExteriorTipoId.header" javaScriptEscape="true"/>',
    	proteccionRuidoExteriorTipoIdDescriptionLabel       : '<spring:message code="forms.acusticamejorasacusticas.columns.proteccionRuidoExteriorTipoId.description" javaScriptEscape="true"/>',
    	mejorasAnalisisTecnicoHeaderLabel          	: '<spring:message code="forms.acusticamejorasacusticas.columns.mejorasAnalisisTecnico.header" javaScriptEscape="true"/>',
    	proteccionRuidoInstalacionesTipoIdHeaderLabel          	: '<spring:message code="forms.acusticamejorasacusticas.columns.proteccionRuidoInstalacionesTipoId.header" javaScriptEscape="true"/>',
    	proteccionRuidoInstalacionesTipoIdDescriptionLabel       : '<spring:message code="forms.acusticamejorasacusticas.columns.proteccionRuidoInstalacionesTipoId.description" javaScriptEscape="true"/>',
    	mejorasDescripcionHeaderLabel          	: '<spring:message code="forms.acusticamejorasacusticas.columns.mejorasDescripcion.header" javaScriptEscape="true"/>',
    	proteccionRuidoInteriorAereoTipoIdHeaderLabel          	: '<spring:message code="forms.acusticamejorasacusticas.columns.proteccionRuidoInteriorAereoTipoId.header" javaScriptEscape="true"/>',
    	proteccionRuidoInteriorAereoTipoIdDescriptionLabel       : '<spring:message code="forms.acusticamejorasacusticas.columns.proteccionRuidoInteriorAereoTipoId.description" javaScriptEscape="true"/>',
    	mejorasObservacionesHeaderLabel          	: '<spring:message code="forms.acusticamejorasacusticas.columns.mejorasObservaciones.header" javaScriptEscape="true"/>',
    	proteccionRuidoInteriorImpactosTipoIdHeaderLabel          	: '<spring:message code="forms.acusticamejorasacusticas.columns.proteccionRuidoInteriorImpactosTipoId.header" javaScriptEscape="true"/>',
    	proteccionRuidoInteriorImpactosTipoIdDescriptionLabel       : '<spring:message code="forms.acusticamejorasacusticas.columns.proteccionRuidoInteriorImpactosTipoId.description" javaScriptEscape="true"/>',
    	mejorasOrdenHeaderLabel          	: '<spring:message code="forms.acusticamejorasacusticas.columns.mejorasOrden.header" javaScriptEscape="true"/>',
    	mejorasValoracionEconomicaHeaderLabel          	: '<spring:message code="forms.acusticamejorasacusticas.columns.mejorasValoracionEconomica.header" javaScriptEscape="true"/>',
    	potencialObservacionesHeaderLabel          	: '<spring:message code="forms.acusticamejorasacusticas.columns.potencialObservaciones.header" javaScriptEscape="true"/>',
    	incidenciaObservacionesHeaderLabel          	: '<spring:message code="forms.acusticamejorasacusticas.columns.incidenciaObservaciones.header" javaScriptEscape="true"/>',
    	incidenciaTextoHeaderLabel          	: '<spring:message code="forms.acusticamejorasacusticas.columns.incidenciaTexto.header" javaScriptEscape="true"/>',

  	});
}
