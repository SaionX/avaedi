<%@page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="es" lang="es">
<head>
<title>AVAEDI <c:out value='${config.nombreEmpresa}' /> -
	Login</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/login.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta data-url="loginForm" />

<meta name="viewport" content="width=device-width, user-scalable=no"/>
</head>
<body>
	<div class="content">
		<h1>AVAEDI</h1>
		<div class="capa1">
			<div id="inner_login">
				<div class="headerApp">
					<span class="logoApp"></span>
				</div>
				<div class="extra">
					<span class="logo"></span>
					<span class="texto">GESTION DE LINEAS Y HORARIOS</span>
				</div>
				<%@ include file="innerLoginForm.jsp"%>
			</div>
		</div>
	</div>
</body>
</html>
