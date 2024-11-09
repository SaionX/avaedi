<%@page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
/**
 * Localización para form: usuario
 * @author agarcia@at4.net
 * 
 */




if(At4FrameworkIntranet.UsuarioForm) {
  	Ext.apply(At4FrameworkIntranet.UsuarioForm.prototype, {
  			titleLabel: '<spring:message code="forms.usuario.title" javaScriptEscape="true"/>', 
    	claveHeaderLabel          	: '<spring:message code="forms.usuario.columns.clave.header" javaScriptEscape="true"/>',
    	municipioHeaderLabel          	: '<spring:message code="forms.usuario.columns.municipio.header" javaScriptEscape="true"/>',
    	usernameHeaderLabel          	: '<spring:message code="forms.usuario.columns.username.header" javaScriptEscape="true"/>',
    	usernameDescriptionLabel       : '<spring:message code="forms.usuario.columns.username.description" javaScriptEscape="true"/>',
    	nombreHeaderLabel          	: '<spring:message code="forms.usuario.columns.nombre.header" javaScriptEscape="true"/>',
    	nombreDescriptionLabel       : '<spring:message code="forms.usuario.columns.nombre.description" javaScriptEscape="true"/>',
    	apellidosHeaderLabel          	: '<spring:message code="forms.usuario.columns.apellidos.header" javaScriptEscape="true"/>',
    	apellidosDescriptionLabel       : '<spring:message code="forms.usuario.columns.apellidos.description" javaScriptEscape="true"/>',
    	idiomaHeaderLabel          	: '<spring:message code="forms.usuario.columns.idioma.header" javaScriptEscape="true"/>',
    	idiomaDescriptionLabel       : '<spring:message code="forms.usuario.columns.idioma.description" javaScriptEscape="true"/>',

  	});
}

if(At4FrameworkIntranet.UsuarioSubForm) {
  	Ext.apply(At4FrameworkIntranet.UsuarioSubForm.prototype, {
  			titleLabel: '<spring:message code="forms.usuario.title" javaScriptEscape="true"/>', 
    	claveHeaderLabel          	: '<spring:message code="forms.usuario.columns.clave.header" javaScriptEscape="true"/>',
    	municipioHeaderLabel          	: '<spring:message code="forms.usuario.columns.municipio.header" javaScriptEscape="true"/>',
    	usernameHeaderLabel          	: '<spring:message code="forms.usuario.columns.username.header" javaScriptEscape="true"/>',
    	usernameDescriptionLabel       : '<spring:message code="forms.usuario.columns.username.description" javaScriptEscape="true"/>',
    	nombreHeaderLabel          	: '<spring:message code="forms.usuario.columns.nombre.header" javaScriptEscape="true"/>',
    	nombreDescriptionLabel       : '<spring:message code="forms.usuario.columns.nombre.description" javaScriptEscape="true"/>',
    	apellidosHeaderLabel          	: '<spring:message code="forms.usuario.columns.apellidos.header" javaScriptEscape="true"/>',
    	apellidosDescriptionLabel       : '<spring:message code="forms.usuario.columns.apellidos.description" javaScriptEscape="true"/>',
    	idiomaHeaderLabel          	: '<spring:message code="forms.usuario.columns.idioma.header" javaScriptEscape="true"/>',
    	idiomaDescriptionLabel       : '<spring:message code="forms.usuario.columns.idioma.description" javaScriptEscape="true"/>',

  	});
}
