<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<c:import url="/WEB-INF/views/head.jsp" />
<script src="resources/js/utilidades.js"></script>
<div id="nuevo_equipo">
	<h1><spring:message code="editando_usuario" />:</h1>
	<form action="modificarUsuario" method="POST" >
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		<input type="hidden" name="username" value="${usuario.username}"/>
		<label for="username"><spring:message code="nombre_usuario" /></label>
		<input type="text" name="n" id="username" disabled="disabled" value="${usuario.username}"/> 
		<br/>
		<label for="authority"><spring:message code="authority" />:</label> 
		<select name="authority">
			<c:forEach items="${authorities}" var="authority">
				<option value="${authority.name()}" ${usuario.authority eq authority ?  "selected" : "" }>
					<spring:message code="${authority.name()}" />
				</option>
			</c:forEach>
		</select> <br />
		<label for="password"><spring:message code="password" /></label>
		<input type="password" name="password" />
		<br/>
		<button type="submit" class="btn btn-lg btn-default">
			<spring:message code="modificar" />
		</button>
		<button class="btn btn-lg btn-default" onclick="window.history.go(-1);"><spring:message code="cancelar" /></button>
	</form>
</div>

<c:import url="/WEB-INF/views/end.jsp" />