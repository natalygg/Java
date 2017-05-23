<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<c:import url="/head.jsp" />

<c:if test="${param.error ne null}">
<div class="centrado">
	<h1><spring:message code="datos_acceso_erroneos" /></h1>
</div>
</c:if>
<c:if test="${param.logout ne null}">
<div  class="centrado">
	<h1><spring:message code="sesion_terminada" />.</h1>
</div>
</c:if>


	<div id="login_form">
	<h1><spring:message code="hacer_login" /></h1>
		<form name="loginForm" action="login" method="POST">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<label for="username" ><spring:message code="nombre_usuario" />:</label>
			<input type="text" name="username"/>
			<br/>
			<label for="password"><spring:message code="password" />: </label>
			<input type="password" name="password">
			<br/>
			<button type="submit" class="btn btn-lg btn-default"><spring:message code="login" /></button>
		</form>
	</div>
<c:import url="/WEB-INF/views/end.jsp" />