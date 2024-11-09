<%@page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
/**
 * Localización para form: municipio
 * @author agarcia@at4.net
 * 
 */




if(At4FrameworkIntranet.MunicipioForm) {
  	Ext.apply(At4FrameworkIntranet.MunicipioForm.prototype, {
  			titleLabel: '<spring:message code="forms.municipio.title" javaScriptEscape="true"/>', 
    	claveHeaderLabel          	: '<spring:message code="forms.municipio.columns.clave.header" javaScriptEscape="true"/>',
    	islaHeaderLabel          	: '<spring:message code="forms.municipio.columns.isla.header" javaScriptEscape="true"/>',
    	islaDescriptionLabel       : '<spring:message code="forms.municipio.columns.isla.description" javaScriptEscape="true"/>',
    	nombreHeaderLabel          	: '<spring:message code="forms.municipio.columns.nombre.header" javaScriptEscape="true"/>',
    	codigoIneHeaderLabel          	: '<spring:message code="forms.municipio.columns.codigoIne.header" javaScriptEscape="true"/>',
    	codigoCatastroHeaderLabel          	: '<spring:message code="forms.municipio.columns.codigoCatastro.header" javaScriptEscape="true"/>',
    	organismoContactoHeaderLabel          	: '<spring:message code="forms.municipio.columns.organismoContacto.header" javaScriptEscape="true"/>',
    	direccionHeaderLabel          	: '<spring:message code="forms.municipio.columns.direccion.header" javaScriptEscape="true"/>',
    	telefonoHeaderLabel          	: '<spring:message code="forms.municipio.columns.telefono.header" javaScriptEscape="true"/>',
    	emailHeaderLabel          	: '<spring:message code="forms.municipio.columns.email.header" javaScriptEscape="true"/>',
    	urlHeaderLabel          	: '<spring:message code="forms.municipio.columns.url.header" javaScriptEscape="true"/>',

  	});
}

if(At4FrameworkIntranet.MunicipioSubForm) {
  	Ext.apply(At4FrameworkIntranet.MunicipioSubForm.prototype, {
  			titleLabel: '<spring:message code="forms.municipio.title" javaScriptEscape="true"/>', 
    	claveHeaderLabel          	: '<spring:message code="forms.municipio.columns.clave.header" javaScriptEscape="true"/>',
    	islaHeaderLabel          	: '<spring:message code="forms.municipio.columns.isla.header" javaScriptEscape="true"/>',
    	islaDescriptionLabel       : '<spring:message code="forms.municipio.columns.isla.description" javaScriptEscape="true"/>',
    	nombreHeaderLabel          	: '<spring:message code="forms.municipio.columns.nombre.header" javaScriptEscape="true"/>',
    	codigoIneHeaderLabel          	: '<spring:message code="forms.municipio.columns.codigoIne.header" javaScriptEscape="true"/>',
    	codigoCatastroHeaderLabel          	: '<spring:message code="forms.municipio.columns.codigoCatastro.header" javaScriptEscape="true"/>',
    	organismoContactoHeaderLabel          	: '<spring:message code="forms.municipio.columns.organismoContacto.header" javaScriptEscape="true"/>',
    	direccionHeaderLabel          	: '<spring:message code="forms.municipio.columns.direccion.header" javaScriptEscape="true"/>',
    	telefonoHeaderLabel          	: '<spring:message code="forms.municipio.columns.telefono.header" javaScriptEscape="true"/>',
    	emailHeaderLabel          	: '<spring:message code="forms.municipio.columns.email.header" javaScriptEscape="true"/>',
    	urlHeaderLabel          	: '<spring:message code="forms.municipio.columns.url.header" javaScriptEscape="true"/>',

  	});
}
