<%@page import="org.springframework.security.web.savedrequest.*,java.util.*"%>
<form name="f" id="fLogin" action="<%= response.encodeURL(request.getContextPath() + "/login/loginForm.html")%>" method="post">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> 						
	<div class="campUser">
		<label class="labelGran" for="username"><spring:message code="login.nombreUsuario" /></label>
		<%
			SavedRequest savedRequest = (SavedRequest) session.getAttribute("SPRING_SECURITY_SAVED_REQUEST");
			String fastRelogUser = null;
			
			if(savedRequest != null) {
				//out.append("redirectUrl:" + savedRequest.getRedirectUrl() + "<br/>");
				String[] userParam = savedRequest.getParameterMap().get("fastRelogUser");
				if (userParam != null) {
					fastRelogUser = userParam[0];
					//out.append(fastRelogUser);
				}
			}
		if(fastRelogUser == null){%>
			<input type="text" name="username" value="" id="username" />
		<%}else{%>
			<input type="text" name="username" value="<%=fastRelogUser%>" id="username" readonly="readonly"/>
			<a class="otro-usuario" href="<%= response.encodeURL(request.getContextPath() + "/index.html")%>" target="_parent"><span><spring:message code="login.otroUsuario" /></span></a>
		<%}%>
	</div>
	<div class="campPsw">
		<label class="labelGran" for="password"><spring:message code="login.contrasenya" /></label>
		<input type="password" name="password" value="" id="password" />
	</div>
	<input type="checkbox" name="remember-me" id="checkCopia" value="true" />
	<label for="checkCopia"><spring:message code="login.recordarContrasenya" /></label>
	<div class="botoLogin">
		<input type="submit" value="<spring:message code="login.iniciarSesion" />" id="submit_login" />
	</div>
</form>
