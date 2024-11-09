<%@page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
/**
 * Localización para form: accesibilidadajustesrazonables
 * @author agarcia@at4.net
 * 
 */




if(At4FrameworkIntranet.AccesibilidadAjustesRazonablesForm) {
  	Ext.apply(At4FrameworkIntranet.AccesibilidadAjustesRazonablesForm.prototype, {
  			titleLabel: '<spring:message code="forms.accesibilidadajustesrazonables.title" javaScriptEscape="true"/>', 
    	claveInformeHeaderLabel          	: '<spring:message code="forms.accesibilidadajustesrazonables.columns.claveInforme.header" javaScriptEscape="true"/>',
    	inspeccionHeaderLabel          	: '<spring:message code="forms.accesibilidadajustesrazonables.columns.inspeccion.header" javaScriptEscape="true"/>',
    	ajustesrazonablesCosteHeaderLabel          	: '<spring:message code="forms.accesibilidadajustesrazonables.columns.ajustesrazonablesCoste.header" javaScriptEscape="true"/>',
    	ajustesrazonablesDescripcionHeaderLabel          	: '<spring:message code="forms.accesibilidadajustesrazonables.columns.ajustesrazonablesDescripcion.header" javaScriptEscape="true"/>',
    	edificionosusceptibleajustesHeaderLabel          	: '<spring:message code="forms.accesibilidadajustesrazonables.columns.edificionosusceptibleajustes.header" javaScriptEscape="true"/>',
    	edificiosusceptibleajustesTotalHeaderLabel          	: '<spring:message code="forms.accesibilidadajustesrazonables.columns.edificiosusceptibleajustesTotal.header" javaScriptEscape="true"/>',
    	edificiosusceptibleajustesTotalDescriptionLabel       : '<spring:message code="forms.accesibilidadajustesrazonables.columns.edificiosusceptibleajustesTotal.description" javaScriptEscape="true"/>',
    	financiacionayudaHeaderLabel          	: '<spring:message code="forms.accesibilidadajustesrazonables.columns.financiacionayuda.header" javaScriptEscape="true"/>',
    	importegastoscomunesHeaderLabel          	: '<spring:message code="forms.accesibilidadajustesrazonables.columns.importegastoscomunes.header" javaScriptEscape="true"/>',
    	observacionesAnalisisNoMedidasHeaderLabel          	: '<spring:message code="forms.accesibilidadajustesrazonables.columns.observacionesAnalisisNoMedidas.header" javaScriptEscape="true"/>',
    	observacionesAnalisisNoMedidasDescriptionLabel       : '<spring:message code="forms.accesibilidadajustesrazonables.columns.observacionesAnalisisNoMedidas.description" javaScriptEscape="true"/>',
    	observacionesCargaeconomicaHeaderLabel          	: '<spring:message code="forms.accesibilidadajustesrazonables.columns.observacionesCargaeconomica.header" javaScriptEscape="true"/>',
    	observacionesConsideracionesinmuebleHeaderLabel          	: '<spring:message code="forms.accesibilidadajustesrazonables.columns.observacionesConsideracionesinmueble.header" javaScriptEscape="true"/>',
    	observacionesConsideracionesinmuebleDescriptionLabel       : '<spring:message code="forms.accesibilidadajustesrazonables.columns.observacionesConsideracionesinmueble.description" javaScriptEscape="true"/>',
    	personasdiscapacitadasomayoresHeaderLabel          	: '<spring:message code="forms.accesibilidadajustesrazonables.columns.personasdiscapacitadasomayores.header" javaScriptEscape="true"/>',
    	viviendasnoitinerarioaccesibleHeaderLabel          	: '<spring:message code="forms.accesibilidadajustesrazonables.columns.viviendasnoitinerarioaccesible.header" javaScriptEscape="true"/>',
    	viviendasnoitinerarioaccesibleDescriptionLabel       : '<spring:message code="forms.accesibilidadajustesrazonables.columns.viviendasnoitinerarioaccesible.description" javaScriptEscape="true"/>',

  	});
}

if(At4FrameworkIntranet.AccesibilidadAjustesRazonablesSubForm) {
  	Ext.apply(At4FrameworkIntranet.AccesibilidadAjustesRazonablesSubForm.prototype, {
  			titleLabel: '<spring:message code="forms.accesibilidadajustesrazonables.title" javaScriptEscape="true"/>', 
    	claveInformeHeaderLabel          	: '<spring:message code="forms.accesibilidadajustesrazonables.columns.claveInforme.header" javaScriptEscape="true"/>',
    	inspeccionHeaderLabel          	: '<spring:message code="forms.accesibilidadajustesrazonables.columns.inspeccion.header" javaScriptEscape="true"/>',
    	ajustesrazonablesCosteHeaderLabel          	: '<spring:message code="forms.accesibilidadajustesrazonables.columns.ajustesrazonablesCoste.header" javaScriptEscape="true"/>',
    	ajustesrazonablesDescripcionHeaderLabel          	: '<spring:message code="forms.accesibilidadajustesrazonables.columns.ajustesrazonablesDescripcion.header" javaScriptEscape="true"/>',
    	edificionosusceptibleajustesHeaderLabel          	: '<spring:message code="forms.accesibilidadajustesrazonables.columns.edificionosusceptibleajustes.header" javaScriptEscape="true"/>',
    	edificiosusceptibleajustesTotalHeaderLabel          	: '<spring:message code="forms.accesibilidadajustesrazonables.columns.edificiosusceptibleajustesTotal.header" javaScriptEscape="true"/>',
    	edificiosusceptibleajustesTotalDescriptionLabel       : '<spring:message code="forms.accesibilidadajustesrazonables.columns.edificiosusceptibleajustesTotal.description" javaScriptEscape="true"/>',
    	financiacionayudaHeaderLabel          	: '<spring:message code="forms.accesibilidadajustesrazonables.columns.financiacionayuda.header" javaScriptEscape="true"/>',
    	importegastoscomunesHeaderLabel          	: '<spring:message code="forms.accesibilidadajustesrazonables.columns.importegastoscomunes.header" javaScriptEscape="true"/>',
    	observacionesAnalisisNoMedidasHeaderLabel          	: '<spring:message code="forms.accesibilidadajustesrazonables.columns.observacionesAnalisisNoMedidas.header" javaScriptEscape="true"/>',
    	observacionesAnalisisNoMedidasDescriptionLabel       : '<spring:message code="forms.accesibilidadajustesrazonables.columns.observacionesAnalisisNoMedidas.description" javaScriptEscape="true"/>',
    	observacionesCargaeconomicaHeaderLabel          	: '<spring:message code="forms.accesibilidadajustesrazonables.columns.observacionesCargaeconomica.header" javaScriptEscape="true"/>',
    	observacionesConsideracionesinmuebleHeaderLabel          	: '<spring:message code="forms.accesibilidadajustesrazonables.columns.observacionesConsideracionesinmueble.header" javaScriptEscape="true"/>',
    	observacionesConsideracionesinmuebleDescriptionLabel       : '<spring:message code="forms.accesibilidadajustesrazonables.columns.observacionesConsideracionesinmueble.description" javaScriptEscape="true"/>',
    	personasdiscapacitadasomayoresHeaderLabel          	: '<spring:message code="forms.accesibilidadajustesrazonables.columns.personasdiscapacitadasomayores.header" javaScriptEscape="true"/>',
    	viviendasnoitinerarioaccesibleHeaderLabel          	: '<spring:message code="forms.accesibilidadajustesrazonables.columns.viviendasnoitinerarioaccesible.header" javaScriptEscape="true"/>',
    	viviendasnoitinerarioaccesibleDescriptionLabel       : '<spring:message code="forms.accesibilidadajustesrazonables.columns.viviendasnoitinerarioaccesible.description" javaScriptEscape="true"/>',

  	});
}
