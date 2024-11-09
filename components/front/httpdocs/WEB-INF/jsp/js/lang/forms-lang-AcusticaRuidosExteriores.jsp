<%@page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
/**
 * Localización para form: acusticaruidosexteriores
 * @author agarcia@at4.net
 * 
 */




if(At4FrameworkIntranet.AcusticaRuidosExterioresForm) {
  	Ext.apply(At4FrameworkIntranet.AcusticaRuidosExterioresForm.prototype, {
  			titleLabel: '<spring:message code="forms.acusticaruidosexteriores.title" javaScriptEscape="true"/>', 
    	claveInformeHeaderLabel          	: '<spring:message code="forms.acusticaruidosexteriores.columns.claveInforme.header" javaScriptEscape="true"/>',
    	inspeccionHeaderLabel          	: '<spring:message code="forms.acusticaruidosexteriores.columns.inspeccion.header" javaScriptEscape="true"/>',
    	aireadoresAsilamientoAcusticoHeaderLabel          	: '<spring:message code="forms.acusticaruidosexteriores.columns.aireadoresAsilamientoAcustico.header" javaScriptEscape="true"/>',
    	aireadoresAsilamientoAcusticoDescriptionLabel       : '<spring:message code="forms.acusticaruidosexteriores.columns.aireadoresAsilamientoAcustico.description" javaScriptEscape="true"/>',
    	aireadoresTieneHeaderLabel          	: '<spring:message code="forms.acusticaruidosexteriores.columns.aireadoresTiene.header" javaScriptEscape="true"/>',
    	capialzadosAislamientoAcusticoHeaderLabel          	: '<spring:message code="forms.acusticaruidosexteriores.columns.capialzadosAislamientoAcustico.header" javaScriptEscape="true"/>',
    	capialzadosAislamientoAcusticoDescriptionLabel       : '<spring:message code="forms.acusticaruidosexteriores.columns.capialzadosAislamientoAcustico.description" javaScriptEscape="true"/>',
    	capialzadosNoPrefabricadosHeaderLabel          	: '<spring:message code="forms.acusticaruidosexteriores.columns.capialzadosNoPrefabricados.header" javaScriptEscape="true"/>',
    	capialzadosTieneHeaderLabel          	: '<spring:message code="forms.acusticaruidosexteriores.columns.capialzadosTiene.header" javaScriptEscape="true"/>',
    	cubiertasLigerasHeaderLabel          	: '<spring:message code="forms.acusticaruidosexteriores.columns.cubiertasLigeras.header" javaScriptEscape="true"/>',
    	cubiertasLigerasTechoHeaderLabel          	: '<spring:message code="forms.acusticaruidosexteriores.columns.cubiertasLigerasTecho.header" javaScriptEscape="true"/>',
    	cubiertasPesadasHeaderLabel          	: '<spring:message code="forms.acusticaruidosexteriores.columns.cubiertasPesadas.header" javaScriptEscape="true"/>',
    	deficienciasObservacionesHeaderLabel          	: '<spring:message code="forms.acusticaruidosexteriores.columns.deficienciasObservaciones.header" javaScriptEscape="true"/>',
    	estadoCapialzadosBuenoHeaderLabel          	: '<spring:message code="forms.acusticaruidosexteriores.columns.estadoCapialzadosBueno.header" javaScriptEscape="true"/>',
    	estadoCubiertasBuenoHeaderLabel          	: '<spring:message code="forms.acusticaruidosexteriores.columns.estadoCubiertasBueno.header" javaScriptEscape="true"/>',
    	estadoFachadasBuenoHeaderLabel          	: '<spring:message code="forms.acusticaruidosexteriores.columns.estadoFachadasBueno.header" javaScriptEscape="true"/>',
    	estadoVentanasBuenoHeaderLabel          	: '<spring:message code="forms.acusticaruidosexteriores.columns.estadoVentanasBueno.header" javaScriptEscape="true"/>',
    	fachadasLigerasHeaderLabel          	: '<spring:message code="forms.acusticaruidosexteriores.columns.fachadasLigeras.header" javaScriptEscape="true"/>',
    	fachadasPesadasHeaderLabel          	: '<spring:message code="forms.acusticaruidosexteriores.columns.fachadasPesadas.header" javaScriptEscape="true"/>',
    	observacionesHeaderLabel          	: '<spring:message code="forms.acusticaruidosexteriores.columns.observaciones.header" javaScriptEscape="true"/>',
    	ruidoMolestoExteriorHeaderLabel          	: '<spring:message code="forms.acusticaruidosexteriores.columns.ruidoMolestoExterior.header" javaScriptEscape="true"/>',
    	ventanasLocalizacionTiposVentanasHeaderLabel          	: '<spring:message code="forms.acusticaruidosexteriores.columns.ventanasLocalizacionTiposVentanas.header" javaScriptEscape="true"/>',
    	ventanasLocalizacionTiposVentanasDescriptionLabel       : '<spring:message code="forms.acusticaruidosexteriores.columns.ventanasLocalizacionTiposVentanas.description" javaScriptEscape="true"/>',

  	});
}

if(At4FrameworkIntranet.AcusticaRuidosExterioresSubForm) {
  	Ext.apply(At4FrameworkIntranet.AcusticaRuidosExterioresSubForm.prototype, {
  			titleLabel: '<spring:message code="forms.acusticaruidosexteriores.title" javaScriptEscape="true"/>', 
    	claveInformeHeaderLabel          	: '<spring:message code="forms.acusticaruidosexteriores.columns.claveInforme.header" javaScriptEscape="true"/>',
    	inspeccionHeaderLabel          	: '<spring:message code="forms.acusticaruidosexteriores.columns.inspeccion.header" javaScriptEscape="true"/>',
    	aireadoresAsilamientoAcusticoHeaderLabel          	: '<spring:message code="forms.acusticaruidosexteriores.columns.aireadoresAsilamientoAcustico.header" javaScriptEscape="true"/>',
    	aireadoresAsilamientoAcusticoDescriptionLabel       : '<spring:message code="forms.acusticaruidosexteriores.columns.aireadoresAsilamientoAcustico.description" javaScriptEscape="true"/>',
    	aireadoresTieneHeaderLabel          	: '<spring:message code="forms.acusticaruidosexteriores.columns.aireadoresTiene.header" javaScriptEscape="true"/>',
    	capialzadosAislamientoAcusticoHeaderLabel          	: '<spring:message code="forms.acusticaruidosexteriores.columns.capialzadosAislamientoAcustico.header" javaScriptEscape="true"/>',
    	capialzadosAislamientoAcusticoDescriptionLabel       : '<spring:message code="forms.acusticaruidosexteriores.columns.capialzadosAislamientoAcustico.description" javaScriptEscape="true"/>',
    	capialzadosNoPrefabricadosHeaderLabel          	: '<spring:message code="forms.acusticaruidosexteriores.columns.capialzadosNoPrefabricados.header" javaScriptEscape="true"/>',
    	capialzadosTieneHeaderLabel          	: '<spring:message code="forms.acusticaruidosexteriores.columns.capialzadosTiene.header" javaScriptEscape="true"/>',
    	cubiertasLigerasHeaderLabel          	: '<spring:message code="forms.acusticaruidosexteriores.columns.cubiertasLigeras.header" javaScriptEscape="true"/>',
    	cubiertasLigerasTechoHeaderLabel          	: '<spring:message code="forms.acusticaruidosexteriores.columns.cubiertasLigerasTecho.header" javaScriptEscape="true"/>',
    	cubiertasPesadasHeaderLabel          	: '<spring:message code="forms.acusticaruidosexteriores.columns.cubiertasPesadas.header" javaScriptEscape="true"/>',
    	deficienciasObservacionesHeaderLabel          	: '<spring:message code="forms.acusticaruidosexteriores.columns.deficienciasObservaciones.header" javaScriptEscape="true"/>',
    	estadoCapialzadosBuenoHeaderLabel          	: '<spring:message code="forms.acusticaruidosexteriores.columns.estadoCapialzadosBueno.header" javaScriptEscape="true"/>',
    	estadoCubiertasBuenoHeaderLabel          	: '<spring:message code="forms.acusticaruidosexteriores.columns.estadoCubiertasBueno.header" javaScriptEscape="true"/>',
    	estadoFachadasBuenoHeaderLabel          	: '<spring:message code="forms.acusticaruidosexteriores.columns.estadoFachadasBueno.header" javaScriptEscape="true"/>',
    	estadoVentanasBuenoHeaderLabel          	: '<spring:message code="forms.acusticaruidosexteriores.columns.estadoVentanasBueno.header" javaScriptEscape="true"/>',
    	fachadasLigerasHeaderLabel          	: '<spring:message code="forms.acusticaruidosexteriores.columns.fachadasLigeras.header" javaScriptEscape="true"/>',
    	fachadasPesadasHeaderLabel          	: '<spring:message code="forms.acusticaruidosexteriores.columns.fachadasPesadas.header" javaScriptEscape="true"/>',
    	observacionesHeaderLabel          	: '<spring:message code="forms.acusticaruidosexteriores.columns.observaciones.header" javaScriptEscape="true"/>',
    	ruidoMolestoExteriorHeaderLabel          	: '<spring:message code="forms.acusticaruidosexteriores.columns.ruidoMolestoExterior.header" javaScriptEscape="true"/>',
    	ventanasLocalizacionTiposVentanasHeaderLabel          	: '<spring:message code="forms.acusticaruidosexteriores.columns.ventanasLocalizacionTiposVentanas.header" javaScriptEscape="true"/>',
    	ventanasLocalizacionTiposVentanasDescriptionLabel       : '<spring:message code="forms.acusticaruidosexteriores.columns.ventanasLocalizacionTiposVentanas.description" javaScriptEscape="true"/>',

  	});
}
