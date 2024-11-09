<%@page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
/**
 * Localización para form: edificio
 * @author agarcia@at4.net
 * 
 */




if(At4FrameworkIntranet.EdificioForm) {
  	Ext.apply(At4FrameworkIntranet.EdificioForm.prototype, {
  			titleLabel: '<spring:message code="forms.edificio.title" javaScriptEscape="true"/>', 
    	claveHeaderLabel          	: '<spring:message code="forms.edificio.columns.clave.header" javaScriptEscape="true"/>',
    	viaHeaderLabel          	: '<spring:message code="forms.edificio.columns.via.header" javaScriptEscape="true"/>',
    	numeroCatastroHeaderLabel          	: '<spring:message code="forms.edificio.columns.numeroCatastro.header" javaScriptEscape="true"/>',
    	numeroCatastroDescriptionLabel       : '<spring:message code="forms.edificio.columns.numeroCatastro.description" javaScriptEscape="true"/>',
    	numeroExtraHeaderLabel          	: '<spring:message code="forms.edificio.columns.numeroExtra.header" javaScriptEscape="true"/>',
    	numeroExtraDescriptionLabel       : '<spring:message code="forms.edificio.columns.numeroExtra.description" javaScriptEscape="true"/>',
    	referenciaCatastralHeaderLabel          	: '<spring:message code="forms.edificio.columns.referenciaCatastral.header" javaScriptEscape="true"/>',
    	referenciaCatastralDescriptionLabel       : '<spring:message code="forms.edificio.columns.referenciaCatastral.description" javaScriptEscape="true"/>',
    	antiguedadHeaderLabel          	: '<spring:message code="forms.edificio.columns.antiguedad.header" javaScriptEscape="true"/>',
    	antiguedadDescriptionLabel       : '<spring:message code="forms.edificio.columns.antiguedad.description" javaScriptEscape="true"/>',
    	centroXHeaderLabel          	: '<spring:message code="forms.edificio.columns.centroX.header" javaScriptEscape="true"/>',
    	centroXDescriptionLabel       : '<spring:message code="forms.edificio.columns.centroX.description" javaScriptEscape="true"/>',
    	centroYHeaderLabel          	: '<spring:message code="forms.edificio.columns.centroY.header" javaScriptEscape="true"/>',
    	centroYDescriptionLabel       : '<spring:message code="forms.edificio.columns.centroY.description" javaScriptEscape="true"/>',
    	informesHeaderLabel          	: '<spring:message code="forms.edificio.columns.informes.header" javaScriptEscape="true"/>',
    	municipioHeaderLabel          	: '<spring:message code="forms.edificio.columns.municipio.header" javaScriptEscape="true"/>',

  	});
}

if(At4FrameworkIntranet.EdificioSubForm) {
  	Ext.apply(At4FrameworkIntranet.EdificioSubForm.prototype, {
  			titleLabel: '<spring:message code="forms.edificio.title" javaScriptEscape="true"/>', 
    	claveHeaderLabel          	: '<spring:message code="forms.edificio.columns.clave.header" javaScriptEscape="true"/>',
    	viaHeaderLabel          	: '<spring:message code="forms.edificio.columns.via.header" javaScriptEscape="true"/>',
    	numeroCatastroHeaderLabel          	: '<spring:message code="forms.edificio.columns.numeroCatastro.header" javaScriptEscape="true"/>',
    	numeroCatastroDescriptionLabel       : '<spring:message code="forms.edificio.columns.numeroCatastro.description" javaScriptEscape="true"/>',
    	numeroExtraHeaderLabel          	: '<spring:message code="forms.edificio.columns.numeroExtra.header" javaScriptEscape="true"/>',
    	numeroExtraDescriptionLabel       : '<spring:message code="forms.edificio.columns.numeroExtra.description" javaScriptEscape="true"/>',
    	referenciaCatastralHeaderLabel          	: '<spring:message code="forms.edificio.columns.referenciaCatastral.header" javaScriptEscape="true"/>',
    	referenciaCatastralDescriptionLabel       : '<spring:message code="forms.edificio.columns.referenciaCatastral.description" javaScriptEscape="true"/>',
    	antiguedadHeaderLabel          	: '<spring:message code="forms.edificio.columns.antiguedad.header" javaScriptEscape="true"/>',
    	antiguedadDescriptionLabel       : '<spring:message code="forms.edificio.columns.antiguedad.description" javaScriptEscape="true"/>',
    	centroXHeaderLabel          	: '<spring:message code="forms.edificio.columns.centroX.header" javaScriptEscape="true"/>',
    	centroXDescriptionLabel       : '<spring:message code="forms.edificio.columns.centroX.description" javaScriptEscape="true"/>',
    	centroYHeaderLabel          	: '<spring:message code="forms.edificio.columns.centroY.header" javaScriptEscape="true"/>',
    	centroYDescriptionLabel       : '<spring:message code="forms.edificio.columns.centroY.description" javaScriptEscape="true"/>',
    	informesHeaderLabel          	: '<spring:message code="forms.edificio.columns.informes.header" javaScriptEscape="true"/>',

  	});
}
