<%@page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
/**
 * Localización para form: accesibilidadvaloracionfinales
 * @author agarcia@at4.net
 * 
 */




if(At4FrameworkIntranet.AccesibilidadValoracionFinalesForm) {
  	Ext.apply(At4FrameworkIntranet.AccesibilidadValoracionFinalesForm.prototype, {
  			titleLabel: '<spring:message code="forms.accesibilidadvaloracionfinales.title" javaScriptEscape="true"/>', 
    	claveInformeHeaderLabel          	: '<spring:message code="forms.accesibilidadvaloracionfinales.columns.claveInforme.header" javaScriptEscape="true"/>',
    	inspeccionHeaderLabel          	: '<spring:message code="forms.accesibilidadvaloracionfinales.columns.inspeccion.header" javaScriptEscape="true"/>',
    	deficienciasPublicoAlojamientosaccesiblesHeaderLabel          	: '<spring:message code="forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoAlojamientosaccesibles.header" javaScriptEscape="true"/>',
    	deficienciasPublicoAlojamientosaccesiblesDescriptionLabel       : '<spring:message code="forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoAlojamientosaccesibles.description" javaScriptEscape="true"/>',
    	deficienciasPublicoAparcamientoHeaderLabel          	: '<spring:message code="forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoAparcamiento.header" javaScriptEscape="true"/>',
    	deficienciasPublicoAparcamientoDescriptionLabel       : '<spring:message code="forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoAparcamiento.description" javaScriptEscape="true"/>',
    	deficienciasPublicoEntreplantasHeaderLabel          	: '<spring:message code="forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoEntreplantas.header" javaScriptEscape="true"/>',
    	deficienciasPublicoEntreplantasDescriptionLabel       : '<spring:message code="forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoEntreplantas.description" javaScriptEscape="true"/>',
    	deficienciasPublicoExteriorHeaderLabel          	: '<spring:message code="forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoExterior.header" javaScriptEscape="true"/>',
    	deficienciasPublicoInformacionsenalizacionHeaderLabel          	: '<spring:message code="forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoInformacionsenalizacion.header" javaScriptEscape="true"/>',
    	deficienciasPublicoInformacionsenalizacionDescriptionLabel       : '<spring:message code="forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoInformacionsenalizacion.description" javaScriptEscape="true"/>',
    	deficienciasPublicoMecanismosHeaderLabel          	: '<spring:message code="forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoMecanismos.header" javaScriptEscape="true"/>',
    	deficienciasPublicoMecanismosDescriptionLabel       : '<spring:message code="forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoMecanismos.description" javaScriptEscape="true"/>',
    	deficienciasPublicoMobiliariofijoHeaderLabel          	: '<spring:message code="forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoMobiliariofijo.header" javaScriptEscape="true"/>',
    	deficienciasPublicoMobiliariofijoDescriptionLabel       : '<spring:message code="forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoMobiliariofijo.description" javaScriptEscape="true"/>',
    	deficienciasPublicoPiscinasHeaderLabel          	: '<spring:message code="forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoPiscinas.header" javaScriptEscape="true"/>',
    	deficienciasPublicoPlantasHeaderLabel          	: '<spring:message code="forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoPlantas.header" javaScriptEscape="true"/>',
    	deficienciasPublicoPlazasreservadasHeaderLabel          	: '<spring:message code="forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoPlazasreservadas.header" javaScriptEscape="true"/>',
    	deficienciasPublicoPlazasreservadasDescriptionLabel       : '<spring:message code="forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoPlazasreservadas.description" javaScriptEscape="true"/>',
    	deficienciasPublicoServicioshigienicosHeaderLabel          	: '<spring:message code="forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoServicioshigienicos.header" javaScriptEscape="true"/>',
    	deficienciasPublicoServicioshigienicosDescriptionLabel       : '<spring:message code="forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoServicioshigienicos.description" javaScriptEscape="true"/>',
    	deficienciasViviendaAparcamientoHeaderLabel          	: '<spring:message code="forms.accesibilidadvaloracionfinales.columns.deficienciasViviendaAparcamiento.header" javaScriptEscape="true"/>',
    	deficienciasViviendaAparcamientoDescriptionLabel       : '<spring:message code="forms.accesibilidadvaloracionfinales.columns.deficienciasViviendaAparcamiento.description" javaScriptEscape="true"/>',
    	deficienciasViviendaEntreplantasHeaderLabel          	: '<spring:message code="forms.accesibilidadvaloracionfinales.columns.deficienciasViviendaEntreplantas.header" javaScriptEscape="true"/>',
    	deficienciasViviendaEntreplantasDescriptionLabel       : '<spring:message code="forms.accesibilidadvaloracionfinales.columns.deficienciasViviendaEntreplantas.description" javaScriptEscape="true"/>',
    	deficienciasViviendaExteriorHeaderLabel          	: '<spring:message code="forms.accesibilidadvaloracionfinales.columns.deficienciasViviendaExterior.header" javaScriptEscape="true"/>',
    	deficienciasViviendaExteriorDescriptionLabel       : '<spring:message code="forms.accesibilidadvaloracionfinales.columns.deficienciasViviendaExterior.description" javaScriptEscape="true"/>',
    	deficienciasViviendaInformacionsenalizacionHeaderLabel          	: '<spring:message code="forms.accesibilidadvaloracionfinales.columns.deficienciasViviendaInformacionsenalizacion.header" javaScriptEscape="true"/>',
    	deficienciasViviendaInformacionsenalizacionDescriptionLabel       : '<spring:message code="forms.accesibilidadvaloracionfinales.columns.deficienciasViviendaInformacionsenalizacion.description" javaScriptEscape="true"/>',
    	deficienciasViviendaMecanismosHeaderLabel          	: '<spring:message code="forms.accesibilidadvaloracionfinales.columns.deficienciasViviendaMecanismos.header" javaScriptEscape="true"/>',
    	deficienciasViviendaMecanismosDescriptionLabel       : '<spring:message code="forms.accesibilidadvaloracionfinales.columns.deficienciasViviendaMecanismos.description" javaScriptEscape="true"/>',
    	deficienciasViviendaPiscinasHeaderLabel          	: '<spring:message code="forms.accesibilidadvaloracionfinales.columns.deficienciasViviendaPiscinas.header" javaScriptEscape="true"/>',
    	deficienciasViviendaPiscinasDescriptionLabel       : '<spring:message code="forms.accesibilidadvaloracionfinales.columns.deficienciasViviendaPiscinas.description" javaScriptEscape="true"/>',
    	deficienciasViviendaPlantasHeaderLabel          	: '<spring:message code="forms.accesibilidadvaloracionfinales.columns.deficienciasViviendaPlantas.header" javaScriptEscape="true"/>',
    	deficienciasViviendaServicioshigienicosHeaderLabel          	: '<spring:message code="forms.accesibilidadvaloracionfinales.columns.deficienciasViviendaServicioshigienicos.header" javaScriptEscape="true"/>',
    	deficienciasViviendaServicioshigienicosDescriptionLabel       : '<spring:message code="forms.accesibilidadvaloracionfinales.columns.deficienciasViviendaServicioshigienicos.description" javaScriptEscape="true"/>',
    	satisfaceCondicionesBasicasHeaderLabel          	: '<spring:message code="forms.accesibilidadvaloracionfinales.columns.satisfaceCondicionesBasicas.header" javaScriptEscape="true"/>',
		
		deficienciasCondicionesFuncionalesTitleLabel: '<spring:message code="forms.accesibilidadvaloracionfinales.grupos.deficienciasCondicionesFuncionales.header" javaScriptEscape="true"/>',
		deficienciasEnDotacionDeElementosAccesiblesTitleLabel: '<spring:message code="forms.accesibilidadvaloracionfinales.grupos.deficienciasEnDotacionDeElementosAccesibles.header" javaScriptEscape="true"/>',
		deficienciasEnDotacionCaracterizacionSenalización: '<spring:message code="forms.accesibilidadvaloracionfinales.grupos.deficienciasEnDotacionCaracterizacionSenalizacion.header" javaScriptEscape="true"/>',
		deficienciasGeneralesTitleLabel: '<spring:message code="forms.accesibilidadvaloracionfinales.grupos.deficienciasGenerales.header" javaScriptEscape="true"/>',
  	});
}

if(At4FrameworkIntranet.AccesibilidadValoracionFinalesSubForm) {
  	Ext.apply(At4FrameworkIntranet.AccesibilidadValoracionFinalesSubForm.prototype, {
  			titleLabel: '<spring:message code="forms.accesibilidadvaloracionfinales.title" javaScriptEscape="true"/>', 
    	claveInformeHeaderLabel          	: '<spring:message code="forms.accesibilidadvaloracionfinales.columns.claveInforme.header" javaScriptEscape="true"/>',
    	inspeccionHeaderLabel          	: '<spring:message code="forms.accesibilidadvaloracionfinales.columns.inspeccion.header" javaScriptEscape="true"/>',
    	deficienciasPublicoAlojamientosaccesiblesHeaderLabel          	: '<spring:message code="forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoAlojamientosaccesibles.header" javaScriptEscape="true"/>',
    	deficienciasPublicoAlojamientosaccesiblesDescriptionLabel       : '<spring:message code="forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoAlojamientosaccesibles.description" javaScriptEscape="true"/>',
    	deficienciasPublicoAparcamientoHeaderLabel          	: '<spring:message code="forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoAparcamiento.header" javaScriptEscape="true"/>',
    	deficienciasPublicoAparcamientoDescriptionLabel       : '<spring:message code="forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoAparcamiento.description" javaScriptEscape="true"/>',
    	deficienciasPublicoEntreplantasHeaderLabel          	: '<spring:message code="forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoEntreplantas.header" javaScriptEscape="true"/>',
    	deficienciasPublicoEntreplantasDescriptionLabel       : '<spring:message code="forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoEntreplantas.description" javaScriptEscape="true"/>',
    	deficienciasPublicoExteriorHeaderLabel          	: '<spring:message code="forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoExterior.header" javaScriptEscape="true"/>',
    	deficienciasPublicoInformacionsenalizacionHeaderLabel          	: '<spring:message code="forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoInformacionsenalizacion.header" javaScriptEscape="true"/>',
    	deficienciasPublicoInformacionsenalizacionDescriptionLabel       : '<spring:message code="forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoInformacionsenalizacion.description" javaScriptEscape="true"/>',
    	deficienciasPublicoMecanismosHeaderLabel          	: '<spring:message code="forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoMecanismos.header" javaScriptEscape="true"/>',
    	deficienciasPublicoMecanismosDescriptionLabel       : '<spring:message code="forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoMecanismos.description" javaScriptEscape="true"/>',
    	deficienciasPublicoMobiliariofijoHeaderLabel          	: '<spring:message code="forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoMobiliariofijo.header" javaScriptEscape="true"/>',
    	deficienciasPublicoMobiliariofijoDescriptionLabel       : '<spring:message code="forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoMobiliariofijo.description" javaScriptEscape="true"/>',
    	deficienciasPublicoPiscinasHeaderLabel          	: '<spring:message code="forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoPiscinas.header" javaScriptEscape="true"/>',
    	deficienciasPublicoPlantasHeaderLabel          	: '<spring:message code="forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoPlantas.header" javaScriptEscape="true"/>',
    	deficienciasPublicoPlazasreservadasHeaderLabel          	: '<spring:message code="forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoPlazasreservadas.header" javaScriptEscape="true"/>',
    	deficienciasPublicoPlazasreservadasDescriptionLabel       : '<spring:message code="forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoPlazasreservadas.description" javaScriptEscape="true"/>',
    	deficienciasPublicoServicioshigienicosHeaderLabel          	: '<spring:message code="forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoServicioshigienicos.header" javaScriptEscape="true"/>',
    	deficienciasPublicoServicioshigienicosDescriptionLabel       : '<spring:message code="forms.accesibilidadvaloracionfinales.columns.deficienciasPublicoServicioshigienicos.description" javaScriptEscape="true"/>',
    	deficienciasViviendaAparcamientoHeaderLabel          	: '<spring:message code="forms.accesibilidadvaloracionfinales.columns.deficienciasViviendaAparcamiento.header" javaScriptEscape="true"/>',
    	deficienciasViviendaAparcamientoDescriptionLabel       : '<spring:message code="forms.accesibilidadvaloracionfinales.columns.deficienciasViviendaAparcamiento.description" javaScriptEscape="true"/>',
    	deficienciasViviendaEntreplantasHeaderLabel          	: '<spring:message code="forms.accesibilidadvaloracionfinales.columns.deficienciasViviendaEntreplantas.header" javaScriptEscape="true"/>',
    	deficienciasViviendaEntreplantasDescriptionLabel       : '<spring:message code="forms.accesibilidadvaloracionfinales.columns.deficienciasViviendaEntreplantas.description" javaScriptEscape="true"/>',
    	deficienciasViviendaExteriorHeaderLabel          	: '<spring:message code="forms.accesibilidadvaloracionfinales.columns.deficienciasViviendaExterior.header" javaScriptEscape="true"/>',
    	deficienciasViviendaExteriorDescriptionLabel       : '<spring:message code="forms.accesibilidadvaloracionfinales.columns.deficienciasViviendaExterior.description" javaScriptEscape="true"/>',
    	deficienciasViviendaInformacionsenalizacionHeaderLabel          	: '<spring:message code="forms.accesibilidadvaloracionfinales.columns.deficienciasViviendaInformacionsenalizacion.header" javaScriptEscape="true"/>',
    	deficienciasViviendaInformacionsenalizacionDescriptionLabel       : '<spring:message code="forms.accesibilidadvaloracionfinales.columns.deficienciasViviendaInformacionsenalizacion.description" javaScriptEscape="true"/>',
    	deficienciasViviendaMecanismosHeaderLabel          	: '<spring:message code="forms.accesibilidadvaloracionfinales.columns.deficienciasViviendaMecanismos.header" javaScriptEscape="true"/>',
    	deficienciasViviendaMecanismosDescriptionLabel       : '<spring:message code="forms.accesibilidadvaloracionfinales.columns.deficienciasViviendaMecanismos.description" javaScriptEscape="true"/>',
    	deficienciasViviendaPiscinasHeaderLabel          	: '<spring:message code="forms.accesibilidadvaloracionfinales.columns.deficienciasViviendaPiscinas.header" javaScriptEscape="true"/>',
    	deficienciasViviendaPiscinasDescriptionLabel       : '<spring:message code="forms.accesibilidadvaloracionfinales.columns.deficienciasViviendaPiscinas.description" javaScriptEscape="true"/>',
    	deficienciasViviendaPlantasHeaderLabel          	: '<spring:message code="forms.accesibilidadvaloracionfinales.columns.deficienciasViviendaPlantas.header" javaScriptEscape="true"/>',
    	deficienciasViviendaServicioshigienicosHeaderLabel          	: '<spring:message code="forms.accesibilidadvaloracionfinales.columns.deficienciasViviendaServicioshigienicos.header" javaScriptEscape="true"/>',
    	deficienciasViviendaServicioshigienicosDescriptionLabel       : '<spring:message code="forms.accesibilidadvaloracionfinales.columns.deficienciasViviendaServicioshigienicos.description" javaScriptEscape="true"/>',
    	satisfaceCondicionesBasicasHeaderLabel          	: '<spring:message code="forms.accesibilidadvaloracionfinales.columns.satisfaceCondicionesBasicas.header" javaScriptEscape="true"/>',

  	});
}
