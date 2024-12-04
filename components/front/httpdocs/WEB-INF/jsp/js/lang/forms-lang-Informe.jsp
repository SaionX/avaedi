<%@page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
/**
 * Localización para form: informe
 * @author agarcia@at4.net
 * 
 */




if(At4FrameworkIntranet.InformeForm) {
  	Ext.apply(At4FrameworkIntranet.InformeForm.prototype, {
  			titleLabel: '<spring:message code="forms.informe.title" javaScriptEscape="true"/>', 
    	claveHeaderLabel          	: '<spring:message code="forms.informe.columns.clave.header" javaScriptEscape="true"/>',
    	estadoInformeHeaderLabel          	: '<spring:message code="forms.informe.columns.estadoInforme.header" javaScriptEscape="true"/>',
    	estadoInformeDescriptionLabel       : '<spring:message code="forms.informe.columns.estadoInforme.description" javaScriptEscape="true"/>',
    	edificioHeaderLabel          	: '<spring:message code="forms.informe.columns.edificio.header" javaScriptEscape="true"/>',
    	fechaInformeHeaderLabel          	: '<spring:message code="forms.informe.columns.fechaInforme.header" javaScriptEscape="true"/>',
    	fechaAltaHeaderLabel          	: '<spring:message code="forms.informe.columns.fechaAlta.header" javaScriptEscape="true"/>',
    	ieeArxiuHeaderLabel          	: '<spring:message code="forms.informe.columns.ieeArxiu.header" javaScriptEscape="true"/>',
    	ieeArxiuDescriptionLabel       : '<spring:message code="forms.informe.columns.ieeArxiu.description" javaScriptEscape="true"/>',
    	pdfArxiuHeaderLabel          	: '<spring:message code="forms.informe.columns.pdfArxiu.header" javaScriptEscape="true"/>',
    	inspeccionHeaderLabel       : '<spring:message code="forms.informe.columns.inspeccion.header" javaScriptEscape="true"/>',
    	tipusIeeHeaderLabel       : '<spring:message code="forms.informe.columns.tipusIee.header" javaScriptEscape="true"/>',
    	renovacioHeaderLabel       : '<spring:message code="forms.informe.columns.renovacio.header" javaScriptEscape="true"/>',
    	municipioHeaderLabel          	: '<spring:message code="forms.edificio.columns.municipio.header" javaScriptEscape="true"/>',
		pdfArxiuSubsanaLabel          	: '<spring:message code="forms.informe.pdfArxiu.subsana" javaScriptEscape="true"/>',
		pdfArxiuIteLabel          	: '<spring:message code="forms.informe.pdfArxiu.ite" javaScriptEscape="true"/>',


  	});
}

if(At4FrameworkIntranet.InformeSubForm) {
  	Ext.apply(At4FrameworkIntranet.InformeSubForm.prototype, {
  			titleLabel: '<spring:message code="forms.informe.title" javaScriptEscape="true"/>', 
    	claveHeaderLabel          	: '<spring:message code="forms.informe.columns.clave.header" javaScriptEscape="true"/>',
    	estadoInformeHeaderLabel          	: '<spring:message code="forms.informe.columns.estadoInforme.header" javaScriptEscape="true"/>',
    	estadoInformeDescriptionLabel       : '<spring:message code="forms.informe.columns.estadoInforme.description" javaScriptEscape="true"/>',
    	edificioHeaderLabel          	: '<spring:message code="forms.informe.columns.edificio.header" javaScriptEscape="true"/>',
    	fechaInformeHeaderLabel          	: '<spring:message code="forms.informe.columns.fechaInforme.header" javaScriptEscape="true"/>',
    	fechaAltaHeaderLabel          	: '<spring:message code="forms.informe.columns.fechaAlta.header" javaScriptEscape="true"/>',
    	ieeArxiuHeaderLabel          	: '<spring:message code="forms.informe.columns.ieeArxiu.header" javaScriptEscape="true"/>',
    	ieeArxiuDescriptionLabel       : '<spring:message code="forms.informe.columns.ieeArxiu.description" javaScriptEscape="true"/>',
    	pdfArxiuHeaderLabel          	: '<spring:message code="forms.informe.columns.pdfArxiu.header" javaScriptEscape="true"/>',
    	pdfArxiuDescriptionLabel       : '<spring:message code="forms.informe.columns.pdfArxiu.description" javaScriptEscape="true"/>',
		tipusIeeHeaderLabel       : '<spring:message code="forms.informe.columns.tipusIee.header" javaScriptEscape="true"/>',
		renovacioHeaderLabel       : '<spring:message code="forms.informe.columns.renovacio.header" javaScriptEscape="true"/>',
		pdfArxiuSubsanaLabel          	: '<spring:message code="forms.informe.pdfArxiu.subsana" javaScriptEscape="true"/>',
		pdfArxiuIteLabel          	: '<spring:message code="forms.informe.pdfArxiu.ite" javaScriptEscape="true"/>',

  	});
}
