<%@page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%
request.getSession().invalidate();
request.getSession(true);
%>
<c:redirect url="./index.html"/>