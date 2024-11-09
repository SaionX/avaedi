<%@page pageEncoding="UTF-8" contentType="application/javascript; charset=UTF-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
/**
 * Localización para forms
 * @author agarcia@at4.net
 */



if(At4FrameworkIntranet.InspeccionBaseForm) {
  	Ext.apply(At4FrameworkIntranet.EdificioForm.prototype, {
  		edificioHeaderLabel: '<spring:message code="forms.baseinspeccion.edificio.title" javaScriptEscape="true"/>', 
  	});
}

	<jsp:include page="forms-lang-AcusticaRuidosInterioresHorizontales.jsp" /> 
	<jsp:include page="forms-lang-Edificio.jsp" /> 
	<jsp:include page="forms-lang-Cimentaciones.jsp" /> 
	<jsp:include page="forms-lang-Deficiencia.jsp" /> 
	<jsp:include page="forms-lang-Usuario.jsp" /> 
	<jsp:include page="forms-lang-Estructura.jsp" /> 
	<jsp:include page="forms-lang-AcusticaDatosGenerales.jsp" /> 
	<jsp:include page="forms-lang-EstadoInforme.jsp" /> 
	<jsp:include page="forms-lang-ValoracionParcial.jsp" /> 
	<jsp:include page="forms-lang-Valor.jsp" /> 
	<jsp:include page="forms-lang-Instalaciones.jsp" /> 
	<jsp:include page="forms-lang-AcusticaRuidosExteriores.jsp" /> 
	<jsp:include page="forms-lang-AcusticaRuidoInstalaciones.jsp" /> 
	<jsp:include page="forms-lang-AcusticaComprobaciones.jsp" /> 
	<jsp:include page="forms-lang-Via.jsp" /> 
	<jsp:include page="forms-lang-AcusticaRuidosInterioresUniones.jsp" /> 
	<jsp:include page="forms-lang-AccesibilidadValoracionFinales.jsp" /> 
	<jsp:include page="forms-lang-Inspeccion.jsp" /> 
	<jsp:include page="forms-lang-Acusticas.jsp" /> 
	<jsp:include page="forms-lang-Municipio.jsp" /> 
	<jsp:include page="forms-lang-Informe.jsp" /> 
	<jsp:include page="forms-lang-DocumentacionOtro.jsp" /> 
	<jsp:include page="forms-lang-AcusticaRuidosInterioresVerticales.jsp" /> 
	<jsp:include page="forms-lang-TipoVia.jsp" /> 
	<jsp:include page="forms-lang-CerramientosCubiertas.jsp" /> 
	<jsp:include page="forms-lang-FechaVisita.jsp" /> 
	<jsp:include page="forms-lang-AccesibilidadAjustesRazonables.jsp" /> 
	<jsp:include page="forms-lang-Conservacion.jsp" /> 
	<jsp:include page="forms-lang-EficienciasEnergeticas.jsp" /> 
	<jsp:include page="forms-lang-AcusticaValoracionFinal.jsp" /> 
	<jsp:include page="forms-lang-AccesibilidadPublicos.jsp" /> 
	<jsp:include page="forms-lang-AcusticaMejorasAcusticas.jsp" /> 
	<jsp:include page="forms-lang-Historico.jsp" /> 
	<jsp:include page="forms-lang-Isla.jsp" /> 

	<%-- Auditoria
		<jsp:include page="forms-lang-AuditOperation.jsp" />
 	--%>