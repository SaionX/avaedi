<%@page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
/**
 * Localización para form: acusticavaloracionfinal
 * @author agarcia@at4.net
 * 
 */




if(At4FrameworkIntranet.AcusticaValoracionFinalForm) {
  	Ext.apply(At4FrameworkIntranet.AcusticaValoracionFinalForm.prototype, {
  			titleLabel: '<spring:message code="forms.acusticavaloracionfinal.title" javaScriptEscape="true"/>', 
    	claveInformeHeaderLabel          	: '<spring:message code="forms.acusticavaloracionfinal.columns.claveInforme.header" javaScriptEscape="true"/>',
    	inspeccionHeaderLabel          	: '<spring:message code="forms.acusticavaloracionfinal.columns.inspeccion.header" javaScriptEscape="true"/>',
    	observacionesHeaderLabel          	: '<spring:message code="forms.acusticavaloracionfinal.columns.observaciones.header" javaScriptEscape="true"/>',
    	proteccionRuidoExteriorTipoIdHeaderLabel          	: '<spring:message code="forms.acusticavaloracionfinal.columns.proteccionRuidoExteriorTipoId.header" javaScriptEscape="true"/>',
    	proteccionRuidoExteriorTipoIdDescriptionLabel       : '<spring:message code="forms.acusticavaloracionfinal.columns.proteccionRuidoExteriorTipoId.description" javaScriptEscape="true"/>',
    	proteccionRuidoInstalacionesTipoIdHeaderLabel          	: '<spring:message code="forms.acusticavaloracionfinal.columns.proteccionRuidoInstalacionesTipoId.header" javaScriptEscape="true"/>',
    	proteccionRuidoInstalacionesTipoIdDescriptionLabel       : '<spring:message code="forms.acusticavaloracionfinal.columns.proteccionRuidoInstalacionesTipoId.description" javaScriptEscape="true"/>',
    	proteccionRuidoInteriorAereoHorizontalTipoIdHeaderLabel          	: '<spring:message code="forms.acusticavaloracionfinal.columns.proteccionRuidoInteriorAereoHorizontalTipoId.header" javaScriptEscape="true"/>',
    	proteccionRuidoInteriorAereoHorizontalTipoIdDescriptionLabel       : '<spring:message code="forms.acusticavaloracionfinal.columns.proteccionRuidoInteriorAereoHorizontalTipoId.description" javaScriptEscape="true"/>',
    	proteccionRuidoInteriorAereoVerticalTipoIdHeaderLabel          	: '<spring:message code="forms.acusticavaloracionfinal.columns.proteccionRuidoInteriorAereoVerticalTipoId.header" javaScriptEscape="true"/>',
    	proteccionRuidoInteriorAereoVerticalTipoIdDescriptionLabel       : '<spring:message code="forms.acusticavaloracionfinal.columns.proteccionRuidoInteriorAereoVerticalTipoId.description" javaScriptEscape="true"/>',
    	proteccionRuidoInteriorImpactosHorizontalTipoIdHeaderLabel          	: '<spring:message code="forms.acusticavaloracionfinal.columns.proteccionRuidoInteriorImpactosHorizontalTipoId.header" javaScriptEscape="true"/>',
    	proteccionRuidoInteriorImpactosHorizontalTipoIdDescriptionLabel       : '<spring:message code="forms.acusticavaloracionfinal.columns.proteccionRuidoInteriorImpactosHorizontalTipoId.description" javaScriptEscape="true"/>',
    	proteccionRuidoInteriorImpactosVerticalTipoIdHeaderLabel          	: '<spring:message code="forms.acusticavaloracionfinal.columns.proteccionRuidoInteriorImpactosVerticalTipoId.header" javaScriptEscape="true"/>',
    	proteccionRuidoInteriorImpactosVerticalTipoIdDescriptionLabel       : '<spring:message code="forms.acusticavaloracionfinal.columns.proteccionRuidoInteriorImpactosVerticalTipoId.description" javaScriptEscape="true"/>',

  	});
}

if(At4FrameworkIntranet.AcusticaValoracionFinalSubForm) {
  	Ext.apply(At4FrameworkIntranet.AcusticaValoracionFinalSubForm.prototype, {
  			titleLabel: '<spring:message code="forms.acusticavaloracionfinal.title" javaScriptEscape="true"/>', 
    	claveInformeHeaderLabel          	: '<spring:message code="forms.acusticavaloracionfinal.columns.claveInforme.header" javaScriptEscape="true"/>',
    	inspeccionHeaderLabel          	: '<spring:message code="forms.acusticavaloracionfinal.columns.inspeccion.header" javaScriptEscape="true"/>',
    	observacionesHeaderLabel          	: '<spring:message code="forms.acusticavaloracionfinal.columns.observaciones.header" javaScriptEscape="true"/>',
    	proteccionRuidoExteriorTipoIdHeaderLabel          	: '<spring:message code="forms.acusticavaloracionfinal.columns.proteccionRuidoExteriorTipoId.header" javaScriptEscape="true"/>',
    	proteccionRuidoExteriorTipoIdDescriptionLabel       : '<spring:message code="forms.acusticavaloracionfinal.columns.proteccionRuidoExteriorTipoId.description" javaScriptEscape="true"/>',
    	proteccionRuidoInstalacionesTipoIdHeaderLabel          	: '<spring:message code="forms.acusticavaloracionfinal.columns.proteccionRuidoInstalacionesTipoId.header" javaScriptEscape="true"/>',
    	proteccionRuidoInstalacionesTipoIdDescriptionLabel       : '<spring:message code="forms.acusticavaloracionfinal.columns.proteccionRuidoInstalacionesTipoId.description" javaScriptEscape="true"/>',
    	proteccionRuidoInteriorAereoHorizontalTipoIdHeaderLabel          	: '<spring:message code="forms.acusticavaloracionfinal.columns.proteccionRuidoInteriorAereoHorizontalTipoId.header" javaScriptEscape="true"/>',
    	proteccionRuidoInteriorAereoHorizontalTipoIdDescriptionLabel       : '<spring:message code="forms.acusticavaloracionfinal.columns.proteccionRuidoInteriorAereoHorizontalTipoId.description" javaScriptEscape="true"/>',
    	proteccionRuidoInteriorAereoVerticalTipoIdHeaderLabel          	: '<spring:message code="forms.acusticavaloracionfinal.columns.proteccionRuidoInteriorAereoVerticalTipoId.header" javaScriptEscape="true"/>',
    	proteccionRuidoInteriorAereoVerticalTipoIdDescriptionLabel       : '<spring:message code="forms.acusticavaloracionfinal.columns.proteccionRuidoInteriorAereoVerticalTipoId.description" javaScriptEscape="true"/>',
    	proteccionRuidoInteriorImpactosHorizontalTipoIdHeaderLabel          	: '<spring:message code="forms.acusticavaloracionfinal.columns.proteccionRuidoInteriorImpactosHorizontalTipoId.header" javaScriptEscape="true"/>',
    	proteccionRuidoInteriorImpactosHorizontalTipoIdDescriptionLabel       : '<spring:message code="forms.acusticavaloracionfinal.columns.proteccionRuidoInteriorImpactosHorizontalTipoId.description" javaScriptEscape="true"/>',
    	proteccionRuidoInteriorImpactosVerticalTipoIdHeaderLabel          	: '<spring:message code="forms.acusticavaloracionfinal.columns.proteccionRuidoInteriorImpactosVerticalTipoId.header" javaScriptEscape="true"/>',
    	proteccionRuidoInteriorImpactosVerticalTipoIdDescriptionLabel       : '<spring:message code="forms.acusticavaloracionfinal.columns.proteccionRuidoInteriorImpactosVerticalTipoId.description" javaScriptEscape="true"/>',

  	});
}
