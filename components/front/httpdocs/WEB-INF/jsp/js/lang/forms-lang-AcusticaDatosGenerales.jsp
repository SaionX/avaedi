<%@page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
/**
 * Localización para form: acusticadatosgenerales
 * @author agarcia@at4.net
 * 
 */




if(At4FrameworkIntranet.AcusticaDatosGeneralesForm) {
  	Ext.apply(At4FrameworkIntranet.AcusticaDatosGeneralesForm.prototype, {
  			titleLabel: '<spring:message code="forms.acusticadatosgenerales.title" javaScriptEscape="true"/>', 
    	claveInformeHeaderLabel          	: '<spring:message code="forms.acusticadatosgenerales.columns.claveInforme.header" javaScriptEscape="true"/>',
    	inspeccionHeaderLabel          	: '<spring:message code="forms.acusticadatosgenerales.columns.inspeccion.header" javaScriptEscape="true"/>',
    	estudioEspecificoHeaderLabel          	: '<spring:message code="forms.acusticadatosgenerales.columns.estudioEspecifico.header" javaScriptEscape="true"/>',
    	existenRecintosInstalacionesHeaderLabel          	: '<spring:message code="forms.acusticadatosgenerales.columns.existenRecintosInstalaciones.header" javaScriptEscape="true"/>',
    	existenRecintosInstalacionesDescriptionLabel       : '<spring:message code="forms.acusticadatosgenerales.columns.existenRecintosInstalaciones.description" javaScriptEscape="true"/>',
    	fachadasNoExpuestasRuidoHeaderLabel          	: '<spring:message code="forms.acusticadatosgenerales.columns.fachadasNoExpuestasRuido.header" javaScriptEscape="true"/>',
    	indiceRuidoDiaHeaderLabel          	: '<spring:message code="forms.acusticadatosgenerales.columns.indiceRuidoDia.header" javaScriptEscape="true"/>',
    	objetivoCalidadAcusticaHeaderLabel          	: '<spring:message code="forms.acusticadatosgenerales.columns.objetivoCalidadAcustica.header" javaScriptEscape="true"/>',
    	observacionesHeaderLabel          	: '<spring:message code="forms.acusticadatosgenerales.columns.observaciones.header" javaScriptEscape="true"/>',
    	recintosInstalacionesRecintosHabitablesHeaderLabel          	: '<spring:message code="forms.acusticadatosgenerales.columns.recintosInstalacionesRecintosHabitables.header" javaScriptEscape="true"/>',
    	recintosInstalacionesRecintosHabitablesDescriptionLabel       : '<spring:message code="forms.acusticadatosgenerales.columns.recintosInstalacionesRecintosHabitables.description" javaScriptEscape="true"/>',
    	recintosInstalacionesZonasComunesHeaderLabel          	: '<spring:message code="forms.acusticadatosgenerales.columns.recintosInstalacionesZonasComunes.header" javaScriptEscape="true"/>',
    	recintosInstalacionesZonasComunesDescriptionLabel       : '<spring:message code="forms.acusticadatosgenerales.columns.recintosInstalacionesZonasComunes.description" javaScriptEscape="true"/>',
    	recintosProtegidosAscensorHeaderLabel          	: '<spring:message code="forms.acusticadatosgenerales.columns.recintosProtegidosAscensor.header" javaScriptEscape="true"/>',
    	recintosProtegidosRecintosHabitablesHeaderLabel          	: '<spring:message code="forms.acusticadatosgenerales.columns.recintosProtegidosRecintosHabitables.header" javaScriptEscape="true"/>',
    	recintosProtegidosRecintosHabitablesDescriptionLabel       : '<spring:message code="forms.acusticadatosgenerales.columns.recintosProtegidosRecintosHabitables.description" javaScriptEscape="true"/>',
    	recintosProtegidosRecintosInstalacionesHeaderLabel          	: '<spring:message code="forms.acusticadatosgenerales.columns.recintosProtegidosRecintosInstalaciones.header" javaScriptEscape="true"/>',
    	recintosProtegidosRecintosInstalacionesDescriptionLabel       : '<spring:message code="forms.acusticadatosgenerales.columns.recintosProtegidosRecintosInstalaciones.description" javaScriptEscape="true"/>',
    	recintosProtegidosRecintosProtegidosHeaderLabel          	: '<spring:message code="forms.acusticadatosgenerales.columns.recintosProtegidosRecintosProtegidos.header" javaScriptEscape="true"/>',
    	recintosProtegidosRecintosProtegidosDescriptionLabel       : '<spring:message code="forms.acusticadatosgenerales.columns.recintosProtegidosRecintosProtegidos.description" javaScriptEscape="true"/>',
    	recintosProtegidosZonaComunHeaderLabel          	: '<spring:message code="forms.acusticadatosgenerales.columns.recintosProtegidosZonaComun.header" javaScriptEscape="true"/>',
    	tipoAreaAcusticaHeaderLabel          	: '<spring:message code="forms.acusticadatosgenerales.columns.tipoAreaAcustica.header" javaScriptEscape="true"/>',
    	zonaRuidoAeronavesHeaderLabel          	: '<spring:message code="forms.acusticadatosgenerales.columns.zonaRuidoAeronaves.header" javaScriptEscape="true"/>',
		
		recintosProtegidosEnElEdificioTitleLabel : '<spring:message code="forms.acusticadatosgenerales.grupos.recintosProtegidosEnElEdificio.header" javaScriptEscape="true"/>',
  	});
}

if(At4FrameworkIntranet.AcusticaDatosGeneralesSubForm) {
  	Ext.apply(At4FrameworkIntranet.AcusticaDatosGeneralesSubForm.prototype, {
  			titleLabel: '<spring:message code="forms.acusticadatosgenerales.title" javaScriptEscape="true"/>', 
    	claveInformeHeaderLabel          	: '<spring:message code="forms.acusticadatosgenerales.columns.claveInforme.header" javaScriptEscape="true"/>',
    	inspeccionHeaderLabel          	: '<spring:message code="forms.acusticadatosgenerales.columns.inspeccion.header" javaScriptEscape="true"/>',
    	estudioEspecificoHeaderLabel          	: '<spring:message code="forms.acusticadatosgenerales.columns.estudioEspecifico.header" javaScriptEscape="true"/>',
    	existenRecintosInstalacionesHeaderLabel          	: '<spring:message code="forms.acusticadatosgenerales.columns.existenRecintosInstalaciones.header" javaScriptEscape="true"/>',
    	existenRecintosInstalacionesDescriptionLabel       : '<spring:message code="forms.acusticadatosgenerales.columns.existenRecintosInstalaciones.description" javaScriptEscape="true"/>',
    	fachadasNoExpuestasRuidoHeaderLabel          	: '<spring:message code="forms.acusticadatosgenerales.columns.fachadasNoExpuestasRuido.header" javaScriptEscape="true"/>',
    	indiceRuidoDiaHeaderLabel          	: '<spring:message code="forms.acusticadatosgenerales.columns.indiceRuidoDia.header" javaScriptEscape="true"/>',
    	objetivoCalidadAcusticaHeaderLabel          	: '<spring:message code="forms.acusticadatosgenerales.columns.objetivoCalidadAcustica.header" javaScriptEscape="true"/>',
    	observacionesHeaderLabel          	: '<spring:message code="forms.acusticadatosgenerales.columns.observaciones.header" javaScriptEscape="true"/>',
    	recintosInstalacionesRecintosHabitablesHeaderLabel          	: '<spring:message code="forms.acusticadatosgenerales.columns.recintosInstalacionesRecintosHabitables.header" javaScriptEscape="true"/>',
    	recintosInstalacionesRecintosHabitablesDescriptionLabel       : '<spring:message code="forms.acusticadatosgenerales.columns.recintosInstalacionesRecintosHabitables.description" javaScriptEscape="true"/>',
    	recintosInstalacionesZonasComunesHeaderLabel          	: '<spring:message code="forms.acusticadatosgenerales.columns.recintosInstalacionesZonasComunes.header" javaScriptEscape="true"/>',
    	recintosInstalacionesZonasComunesDescriptionLabel       : '<spring:message code="forms.acusticadatosgenerales.columns.recintosInstalacionesZonasComunes.description" javaScriptEscape="true"/>',
    	recintosProtegidosAscensorHeaderLabel          	: '<spring:message code="forms.acusticadatosgenerales.columns.recintosProtegidosAscensor.header" javaScriptEscape="true"/>',
    	recintosProtegidosRecintosHabitablesHeaderLabel          	: '<spring:message code="forms.acusticadatosgenerales.columns.recintosProtegidosRecintosHabitables.header" javaScriptEscape="true"/>',
    	recintosProtegidosRecintosHabitablesDescriptionLabel       : '<spring:message code="forms.acusticadatosgenerales.columns.recintosProtegidosRecintosHabitables.description" javaScriptEscape="true"/>',
    	recintosProtegidosRecintosInstalacionesHeaderLabel          	: '<spring:message code="forms.acusticadatosgenerales.columns.recintosProtegidosRecintosInstalaciones.header" javaScriptEscape="true"/>',
    	recintosProtegidosRecintosInstalacionesDescriptionLabel       : '<spring:message code="forms.acusticadatosgenerales.columns.recintosProtegidosRecintosInstalaciones.description" javaScriptEscape="true"/>',
    	recintosProtegidosRecintosProtegidosHeaderLabel          	: '<spring:message code="forms.acusticadatosgenerales.columns.recintosProtegidosRecintosProtegidos.header" javaScriptEscape="true"/>',
    	recintosProtegidosRecintosProtegidosDescriptionLabel       : '<spring:message code="forms.acusticadatosgenerales.columns.recintosProtegidosRecintosProtegidos.description" javaScriptEscape="true"/>',
    	recintosProtegidosZonaComunHeaderLabel          	: '<spring:message code="forms.acusticadatosgenerales.columns.recintosProtegidosZonaComun.header" javaScriptEscape="true"/>',
    	tipoAreaAcusticaHeaderLabel          	: '<spring:message code="forms.acusticadatosgenerales.columns.tipoAreaAcustica.header" javaScriptEscape="true"/>',
    	zonaRuidoAeronavesHeaderLabel          	: '<spring:message code="forms.acusticadatosgenerales.columns.zonaRuidoAeronaves.header" javaScriptEscape="true"/>',

  	});
}
