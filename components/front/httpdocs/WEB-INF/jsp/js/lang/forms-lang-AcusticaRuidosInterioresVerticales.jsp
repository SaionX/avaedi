<%@page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
/**
 * Localización para form: acusticaruidosinterioresverticales
 * @author agarcia@at4.net
 * 
 */




if(At4FrameworkIntranet.AcusticaRuidosInterioresVerticalesForm) {
  	Ext.apply(At4FrameworkIntranet.AcusticaRuidosInterioresVerticalesForm.prototype, {
  			titleLabel: '<spring:message code="forms.acusticaruidosinterioresverticales.title" javaScriptEscape="true"/>', 
    	claveInformeHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresverticales.columns.claveInforme.header" javaScriptEscape="true"/>',
    	inspeccionHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresverticales.columns.inspeccion.header" javaScriptEscape="true"/>',
    	ruiiIntVertSepTipoTexHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresverticales.columns.ruiiIntVertSepTipoTex.header" javaScriptEscape="true"/>',
    	ruiiIntVertSepTipoTexDescriptionLabel       : '<spring:message code="forms.acusticaruidosinterioresverticales.columns.ruiiIntVertSepTipoTex.description" javaScriptEscape="true"/>',
    	ruiIntVertTabTipoTexHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresverticales.columns.ruiIntVertTabTipoTex.header" javaScriptEscape="true"/>',
    	ruiIntVertTabTipoTexDescriptionLabel       : '<spring:message code="forms.acusticaruidosinterioresverticales.columns.ruiIntVertTabTipoTex.description" javaScriptEscape="true"/>',
    	caracteristicasHuecosAdosadosHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresverticales.columns.caracteristicasHuecosAdosados.header" javaScriptEscape="true"/>',
    	caracteristicasHuecosAdosadosDescriptionLabel       : '<spring:message code="forms.acusticaruidosinterioresverticales.columns.caracteristicasHuecosAdosados.description" javaScriptEscape="true"/>',
    	caracteristicasHuecosAdosadosRevestidosHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresverticales.columns.caracteristicasHuecosAdosadosRevestidos.header" javaScriptEscape="true"/>',
    	caracteristicasHuecosAdosadosRevestidosDescriptionLabel       : '<spring:message code="forms.acusticaruidosinterioresverticales.columns.caracteristicasHuecosAdosadosRevestidos.description" javaScriptEscape="true"/>',
    	caracteristicasHuecosAdosadosRuidoMolestoHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresverticales.columns.caracteristicasHuecosAdosadosRuidoMolesto.header" javaScriptEscape="true"/>',
    	caracteristicasHuecosAdosadosRuidoMolestoDescriptionLabel       : '<spring:message code="forms.acusticaruidosinterioresverticales.columns.caracteristicasHuecosAdosadosRuidoMolesto.description" javaScriptEscape="true"/>',
    	caracteristicasInstalacionesAtraviesanRecintosHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresverticales.columns.caracteristicasInstalacionesAtraviesanRecintos.header" javaScriptEscape="true"/>',
    	caracteristicasInstalacionesAtraviesanRecintosDescriptionLabel       : '<spring:message code="forms.acusticaruidosinterioresverticales.columns.caracteristicasInstalacionesAtraviesanRecintos.description" javaScriptEscape="true"/>',
    	caracteristicasInstalacionesConectanRecintosHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresverticales.columns.caracteristicasInstalacionesConectanRecintos.header" javaScriptEscape="true"/>',
    	caracteristicasInstalacionesConectanRecintosDescriptionLabel       : '<spring:message code="forms.acusticaruidosinterioresverticales.columns.caracteristicasInstalacionesConectanRecintos.description" javaScriptEscape="true"/>',
    	caracteristicasPilaresConectanRecintosHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresverticales.columns.caracteristicasPilaresConectanRecintos.header" javaScriptEscape="true"/>',
    	caracteristicasPilaresConectanRecintosDescriptionLabel       : '<spring:message code="forms.acusticaruidosinterioresverticales.columns.caracteristicasPilaresConectanRecintos.description" javaScriptEscape="true"/>',
    	caracteristicasPilaresConectanRecintosRevestidosHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresverticales.columns.caracteristicasPilaresConectanRecintosRevestidos.header" javaScriptEscape="true"/>',
    	caracteristicasPilaresConectanRecintosRevestidosDescriptionLabel       : '<spring:message code="forms.acusticaruidosinterioresverticales.columns.caracteristicasPilaresConectanRecintosRevestidos.description" javaScriptEscape="true"/>',
    	caracteristicasTuberiasAncladasHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresverticales.columns.caracteristicasTuberiasAncladas.header" javaScriptEscape="true"/>',
    	caracteristicasTuberiasAncladasDescriptionLabel       : '<spring:message code="forms.acusticaruidosinterioresverticales.columns.caracteristicasTuberiasAncladas.description" javaScriptEscape="true"/>',
    	deficienciasObservacionesHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresverticales.columns.deficienciasObservaciones.header" javaScriptEscape="true"/>',
    	estadoSeparacionBuenoHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresverticales.columns.estadoSeparacionBueno.header" javaScriptEscape="true"/>',
    	observacionesHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresverticales.columns.observaciones.header" javaScriptEscape="true"/>',
    	separacionEntramadoAutoportanteHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresverticales.columns.separacionEntramadoAutoportante.header" javaScriptEscape="true"/>',
    	separacionEntramadoAutoportanteDescriptionLabel       : '<spring:message code="forms.acusticaruidosinterioresverticales.columns.separacionEntramadoAutoportante.description" javaScriptEscape="true"/>',
    	separacionEntramadoAutoportanteAbsorbenteHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresverticales.columns.separacionEntramadoAutoportanteAbsorbente.header" javaScriptEscape="true"/>',
    	separacionEntramadoAutoportanteAbsorbenteDescriptionLabel       : '<spring:message code="forms.acusticaruidosinterioresverticales.columns.separacionEntramadoAutoportanteAbsorbente.description" javaScriptEscape="true"/>',
    	separacionEntramadoAutoportanteDoshojasHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresverticales.columns.separacionEntramadoAutoportanteDoshojas.header" javaScriptEscape="true"/>',
    	separacionEntramadoAutoportanteDoshojasDescriptionLabel       : '<spring:message code="forms.acusticaruidosinterioresverticales.columns.separacionEntramadoAutoportanteDoshojas.description" javaScriptEscape="true"/>',
    	separacionEntramadoAutoportanteDoshojasEspesorHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresverticales.columns.separacionEntramadoAutoportanteDoshojasEspesor.header" javaScriptEscape="true"/>',
    	separacionEntramadoAutoportanteDoshojasEspesorDescriptionLabel       : '<spring:message code="forms.acusticaruidosinterioresverticales.columns.separacionEntramadoAutoportanteDoshojasEspesor.description" javaScriptEscape="true"/>',
    	separacionEntramadoAutoportanteUnahojaHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresverticales.columns.separacionEntramadoAutoportanteUnahoja.header" javaScriptEscape="true"/>',
    	separacionEntramadoAutoportanteUnahojaDescriptionLabel       : '<spring:message code="forms.acusticaruidosinterioresverticales.columns.separacionEntramadoAutoportanteUnahoja.description" javaScriptEscape="true"/>',
    	separacionEntramadoAutoportanteUnahojaEspesorHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresverticales.columns.separacionEntramadoAutoportanteUnahojaEspesor.header" javaScriptEscape="true"/>',
    	separacionEntramadoAutoportanteUnahojaEspesorDescriptionLabel       : '<spring:message code="forms.acusticaruidosinterioresverticales.columns.separacionEntramadoAutoportanteUnahojaEspesor.description" javaScriptEscape="true"/>',
    	separacionEntramadoMaderaHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresverticales.columns.separacionEntramadoMadera.header" javaScriptEscape="true"/>',
    	separacionEntramadoMaderaEspesorHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresverticales.columns.separacionEntramadoMaderaEspesor.header" javaScriptEscape="true"/>',
    	separacionEntramadoMaderaEspesorDescriptionLabel       : '<spring:message code="forms.acusticaruidosinterioresverticales.columns.separacionEntramadoMaderaEspesor.description" javaScriptEscape="true"/>',
    	separacionEntramadoMaderaRevestidoHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresverticales.columns.separacionEntramadoMaderaRevestido.header" javaScriptEscape="true"/>',
    	separacionEntramadoMaderaRevestidoDescriptionLabel       : '<spring:message code="forms.acusticaruidosinterioresverticales.columns.separacionEntramadoMaderaRevestido.description" javaScriptEscape="true"/>',
    	separacionFabricaHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresverticales.columns.separacionFabrica.header" javaScriptEscape="true"/>',
    	separacionFabricaRevestidoHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresverticales.columns.separacionFabricaRevestido.header" javaScriptEscape="true"/>',
    	separacionOtrosHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresverticales.columns.separacionOtros.header" javaScriptEscape="true"/>',
    	separacionOtrosTextoHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresverticales.columns.separacionOtrosTexto.header" javaScriptEscape="true"/>',
    	tabiquesEntramadoAutoportanteMetalicoHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresverticales.columns.tabiquesEntramadoAutoportanteMetalico.header" javaScriptEscape="true"/>',
    	tabiquesEntramadoAutoportanteMetalicoDescriptionLabel       : '<spring:message code="forms.acusticaruidosinterioresverticales.columns.tabiquesEntramadoAutoportanteMetalico.description" javaScriptEscape="true"/>',
    	tabiquesEntramadoAutoportanteMetalicoEspesorHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresverticales.columns.tabiquesEntramadoAutoportanteMetalicoEspesor.header" javaScriptEscape="true"/>',
    	tabiquesEntramadoAutoportanteMetalicoEspesorDescriptionLabel       : '<spring:message code="forms.acusticaruidosinterioresverticales.columns.tabiquesEntramadoAutoportanteMetalicoEspesor.description" javaScriptEscape="true"/>',
    	tabiquesEntramadoMaderaRellenoHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresverticales.columns.tabiquesEntramadoMaderaRelleno.header" javaScriptEscape="true"/>',
    	tabiquesEntramadoMaderaRellenoDescriptionLabel       : '<spring:message code="forms.acusticaruidosinterioresverticales.columns.tabiquesEntramadoMaderaRelleno.description" javaScriptEscape="true"/>',
    	tabiquesEntramadoMaderaRellenoEspesorHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresverticales.columns.tabiquesEntramadoMaderaRellenoEspesor.header" javaScriptEscape="true"/>',
    	tabiquesEntramadoMaderaRellenoEspesorDescriptionLabel       : '<spring:message code="forms.acusticaruidosinterioresverticales.columns.tabiquesEntramadoMaderaRellenoEspesor.description" javaScriptEscape="true"/>',
    	tabiquesFabricaHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresverticales.columns.tabiquesFabrica.header" javaScriptEscape="true"/>',
    	zonaComunHallPuertaHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresverticales.columns.zonaComunHallPuerta.header" javaScriptEscape="true"/>',
    	zonaComunPuertasAcusticamenteFavorablesHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresverticales.columns.zonaComunPuertasAcusticamenteFavorables.header" javaScriptEscape="true"/>',
    	zonaComunPuertasAcusticamenteFavorablesDescriptionLabel       : '<spring:message code="forms.acusticaruidosinterioresverticales.columns.zonaComunPuertasAcusticamenteFavorables.description" javaScriptEscape="true"/>',
		
		elementosDeSeparacionEntreViviendasTitleLabel: '<spring:message code="forms.acusticaruidosinterioresverticales.grupos.elementosDeSeparacionEntreViviendas.header" javaScriptEscape="true"/>',
		conservacionDeficienciasCaracteristicasAdicionalesTitleLabel: '<spring:message code="forms.acusticaruidosinterioresverticales.grupos.conservacionDeficienciasCaracteristicasAdicionales.header" javaScriptEscape="true"/>',
		caracteristicasAdicionalesTitleLabel: '<spring:message code="forms.acusticaruidosinterioresverticales.grupos.caracteristicasAdicionales.header" javaScriptEscape="true"/>',
		tabiquesZonasComunesObservacionesTitleLabel: '<spring:message code="forms.acusticaruidosinterioresverticales.grupos.tabiquesZonasComunesObservaciones.header" javaScriptEscape="true"/>',
  	});
}

if(At4FrameworkIntranet.AcusticaRuidosInterioresVerticalesSubForm) {
  	Ext.apply(At4FrameworkIntranet.AcusticaRuidosInterioresVerticalesSubForm.prototype, {
  			titleLabel: '<spring:message code="forms.acusticaruidosinterioresverticales.title" javaScriptEscape="true"/>', 
    	claveInformeHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresverticales.columns.claveInforme.header" javaScriptEscape="true"/>',
    	inspeccionHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresverticales.columns.inspeccion.header" javaScriptEscape="true"/>',
    	ruiiIntVertSepTipoTexHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresverticales.columns.ruiiIntVertSepTipoTex.header" javaScriptEscape="true"/>',
    	ruiiIntVertSepTipoTexDescriptionLabel       : '<spring:message code="forms.acusticaruidosinterioresverticales.columns.ruiiIntVertSepTipoTex.description" javaScriptEscape="true"/>',
    	ruiIntVertTabTipoTexHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresverticales.columns.ruiIntVertTabTipoTex.header" javaScriptEscape="true"/>',
    	ruiIntVertTabTipoTexDescriptionLabel       : '<spring:message code="forms.acusticaruidosinterioresverticales.columns.ruiIntVertTabTipoTex.description" javaScriptEscape="true"/>',
    	caracteristicasHuecosAdosadosHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresverticales.columns.caracteristicasHuecosAdosados.header" javaScriptEscape="true"/>',
    	caracteristicasHuecosAdosadosDescriptionLabel       : '<spring:message code="forms.acusticaruidosinterioresverticales.columns.caracteristicasHuecosAdosados.description" javaScriptEscape="true"/>',
    	caracteristicasHuecosAdosadosRevestidosHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresverticales.columns.caracteristicasHuecosAdosadosRevestidos.header" javaScriptEscape="true"/>',
    	caracteristicasHuecosAdosadosRevestidosDescriptionLabel       : '<spring:message code="forms.acusticaruidosinterioresverticales.columns.caracteristicasHuecosAdosadosRevestidos.description" javaScriptEscape="true"/>',
    	caracteristicasHuecosAdosadosRuidoMolestoHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresverticales.columns.caracteristicasHuecosAdosadosRuidoMolesto.header" javaScriptEscape="true"/>',
    	caracteristicasHuecosAdosadosRuidoMolestoDescriptionLabel       : '<spring:message code="forms.acusticaruidosinterioresverticales.columns.caracteristicasHuecosAdosadosRuidoMolesto.description" javaScriptEscape="true"/>',
    	caracteristicasInstalacionesAtraviesanRecintosHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresverticales.columns.caracteristicasInstalacionesAtraviesanRecintos.header" javaScriptEscape="true"/>',
    	caracteristicasInstalacionesAtraviesanRecintosDescriptionLabel       : '<spring:message code="forms.acusticaruidosinterioresverticales.columns.caracteristicasInstalacionesAtraviesanRecintos.description" javaScriptEscape="true"/>',
    	caracteristicasInstalacionesConectanRecintosHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresverticales.columns.caracteristicasInstalacionesConectanRecintos.header" javaScriptEscape="true"/>',
    	caracteristicasInstalacionesConectanRecintosDescriptionLabel       : '<spring:message code="forms.acusticaruidosinterioresverticales.columns.caracteristicasInstalacionesConectanRecintos.description" javaScriptEscape="true"/>',
    	caracteristicasPilaresConectanRecintosHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresverticales.columns.caracteristicasPilaresConectanRecintos.header" javaScriptEscape="true"/>',
    	caracteristicasPilaresConectanRecintosDescriptionLabel       : '<spring:message code="forms.acusticaruidosinterioresverticales.columns.caracteristicasPilaresConectanRecintos.description" javaScriptEscape="true"/>',
    	caracteristicasPilaresConectanRecintosRevestidosHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresverticales.columns.caracteristicasPilaresConectanRecintosRevestidos.header" javaScriptEscape="true"/>',
    	caracteristicasPilaresConectanRecintosRevestidosDescriptionLabel       : '<spring:message code="forms.acusticaruidosinterioresverticales.columns.caracteristicasPilaresConectanRecintosRevestidos.description" javaScriptEscape="true"/>',
    	caracteristicasTuberiasAncladasHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresverticales.columns.caracteristicasTuberiasAncladas.header" javaScriptEscape="true"/>',
    	caracteristicasTuberiasAncladasDescriptionLabel       : '<spring:message code="forms.acusticaruidosinterioresverticales.columns.caracteristicasTuberiasAncladas.description" javaScriptEscape="true"/>',
    	deficienciasObservacionesHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresverticales.columns.deficienciasObservaciones.header" javaScriptEscape="true"/>',
    	estadoSeparacionBuenoHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresverticales.columns.estadoSeparacionBueno.header" javaScriptEscape="true"/>',
    	observacionesHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresverticales.columns.observaciones.header" javaScriptEscape="true"/>',
    	separacionEntramadoAutoportanteHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresverticales.columns.separacionEntramadoAutoportante.header" javaScriptEscape="true"/>',
    	separacionEntramadoAutoportanteDescriptionLabel       : '<spring:message code="forms.acusticaruidosinterioresverticales.columns.separacionEntramadoAutoportante.description" javaScriptEscape="true"/>',
    	separacionEntramadoAutoportanteAbsorbenteHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresverticales.columns.separacionEntramadoAutoportanteAbsorbente.header" javaScriptEscape="true"/>',
    	separacionEntramadoAutoportanteAbsorbenteDescriptionLabel       : '<spring:message code="forms.acusticaruidosinterioresverticales.columns.separacionEntramadoAutoportanteAbsorbente.description" javaScriptEscape="true"/>',
    	separacionEntramadoAutoportanteDoshojasHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresverticales.columns.separacionEntramadoAutoportanteDoshojas.header" javaScriptEscape="true"/>',
    	separacionEntramadoAutoportanteDoshojasDescriptionLabel       : '<spring:message code="forms.acusticaruidosinterioresverticales.columns.separacionEntramadoAutoportanteDoshojas.description" javaScriptEscape="true"/>',
    	separacionEntramadoAutoportanteDoshojasEspesorHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresverticales.columns.separacionEntramadoAutoportanteDoshojasEspesor.header" javaScriptEscape="true"/>',
    	separacionEntramadoAutoportanteDoshojasEspesorDescriptionLabel       : '<spring:message code="forms.acusticaruidosinterioresverticales.columns.separacionEntramadoAutoportanteDoshojasEspesor.description" javaScriptEscape="true"/>',
    	separacionEntramadoAutoportanteUnahojaHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresverticales.columns.separacionEntramadoAutoportanteUnahoja.header" javaScriptEscape="true"/>',
    	separacionEntramadoAutoportanteUnahojaDescriptionLabel       : '<spring:message code="forms.acusticaruidosinterioresverticales.columns.separacionEntramadoAutoportanteUnahoja.description" javaScriptEscape="true"/>',
    	separacionEntramadoAutoportanteUnahojaEspesorHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresverticales.columns.separacionEntramadoAutoportanteUnahojaEspesor.header" javaScriptEscape="true"/>',
    	separacionEntramadoAutoportanteUnahojaEspesorDescriptionLabel       : '<spring:message code="forms.acusticaruidosinterioresverticales.columns.separacionEntramadoAutoportanteUnahojaEspesor.description" javaScriptEscape="true"/>',
    	separacionEntramadoMaderaHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresverticales.columns.separacionEntramadoMadera.header" javaScriptEscape="true"/>',
    	separacionEntramadoMaderaEspesorHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresverticales.columns.separacionEntramadoMaderaEspesor.header" javaScriptEscape="true"/>',
    	separacionEntramadoMaderaEspesorDescriptionLabel       : '<spring:message code="forms.acusticaruidosinterioresverticales.columns.separacionEntramadoMaderaEspesor.description" javaScriptEscape="true"/>',
    	separacionEntramadoMaderaRevestidoHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresverticales.columns.separacionEntramadoMaderaRevestido.header" javaScriptEscape="true"/>',
    	separacionEntramadoMaderaRevestidoDescriptionLabel       : '<spring:message code="forms.acusticaruidosinterioresverticales.columns.separacionEntramadoMaderaRevestido.description" javaScriptEscape="true"/>',
    	separacionFabricaHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresverticales.columns.separacionFabrica.header" javaScriptEscape="true"/>',
    	separacionFabricaRevestidoHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresverticales.columns.separacionFabricaRevestido.header" javaScriptEscape="true"/>',
    	separacionOtrosHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresverticales.columns.separacionOtros.header" javaScriptEscape="true"/>',
    	separacionOtrosTextoHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresverticales.columns.separacionOtrosTexto.header" javaScriptEscape="true"/>',
    	tabiquesEntramadoAutoportanteMetalicoHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresverticales.columns.tabiquesEntramadoAutoportanteMetalico.header" javaScriptEscape="true"/>',
    	tabiquesEntramadoAutoportanteMetalicoDescriptionLabel       : '<spring:message code="forms.acusticaruidosinterioresverticales.columns.tabiquesEntramadoAutoportanteMetalico.description" javaScriptEscape="true"/>',
    	tabiquesEntramadoAutoportanteMetalicoEspesorHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresverticales.columns.tabiquesEntramadoAutoportanteMetalicoEspesor.header" javaScriptEscape="true"/>',
    	tabiquesEntramadoAutoportanteMetalicoEspesorDescriptionLabel       : '<spring:message code="forms.acusticaruidosinterioresverticales.columns.tabiquesEntramadoAutoportanteMetalicoEspesor.description" javaScriptEscape="true"/>',
    	tabiquesEntramadoMaderaRellenoHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresverticales.columns.tabiquesEntramadoMaderaRelleno.header" javaScriptEscape="true"/>',
    	tabiquesEntramadoMaderaRellenoDescriptionLabel       : '<spring:message code="forms.acusticaruidosinterioresverticales.columns.tabiquesEntramadoMaderaRelleno.description" javaScriptEscape="true"/>',
    	tabiquesEntramadoMaderaRellenoEspesorHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresverticales.columns.tabiquesEntramadoMaderaRellenoEspesor.header" javaScriptEscape="true"/>',
    	tabiquesEntramadoMaderaRellenoEspesorDescriptionLabel       : '<spring:message code="forms.acusticaruidosinterioresverticales.columns.tabiquesEntramadoMaderaRellenoEspesor.description" javaScriptEscape="true"/>',
    	tabiquesFabricaHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresverticales.columns.tabiquesFabrica.header" javaScriptEscape="true"/>',
    	zonaComunHallPuertaHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresverticales.columns.zonaComunHallPuerta.header" javaScriptEscape="true"/>',
    	zonaComunPuertasAcusticamenteFavorablesHeaderLabel          	: '<spring:message code="forms.acusticaruidosinterioresverticales.columns.zonaComunPuertasAcusticamenteFavorables.header" javaScriptEscape="true"/>',
    	zonaComunPuertasAcusticamenteFavorablesDescriptionLabel       : '<spring:message code="forms.acusticaruidosinterioresverticales.columns.zonaComunPuertasAcusticamenteFavorables.description" javaScriptEscape="true"/>',

  	});
}