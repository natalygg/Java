<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<c:import url="/WEB-INF/views/head.jsp" />
<script src="resources/js/utilidades.js"></script>
<script>
var advertenciaDatos="<spring:message code="datos_erroneos" />";
</script>
	<div id="nuevo_equipo">
		<h1><spring:message code="nuevo_usuario" />:</h1>
		<form action="altaUsuario" method="POST" onsubmit="return comprobarDatosUsuario();">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<label for="username"><spring:message code="nombre_usuario" /></label>
			<input type="text" name="username" id="username"/>
			<br/>
			<label for="authority"><spring:message code="authority" />:</label> 
			<select name="authority">
				<c:forEach items="${authorities}" var="authority">
					<option value="${authority.name()}"><spring:message code="${authority.name()}" /></option>
				</c:forEach>
			</select> 
			<br />
			<label for="password"><spring:message code="password" /></label>
			<input type="password" name="password" />
			<br/>
			<button type="submit" class="btn btn-lg btn-default"><spring:message code="alta" /></button>
		</form>
	</div>
	<div id="listado">
		<h1><spring:message code="listado_usuarios_existentes" />.</h1>

		<table align="center">
			
				<tr class="fila">
					<th><spring:message code="nombre_usuario" /></th>
					<th><spring:message code="authority" /></th>
					<th></th>
				</tr>
			
			<c:set var="i"  value="0"/>
			<c:forEach items="${lista}" var="u">
				<tr class='fila fila_${i%2 eq 0 ? "par" : "impar"}'>
					<td><a href="editarUsuario?username=${u.username}">${u.username}</a></td>
					<td><a href="editarUsuario?username=${u.username}"><spring:message code="${u.authority}" /></a></td>
					<td><a href="borrarUsuario?username=${u.username}"><spring:message code="borrar" /></a></td>
				</tr>
				<c:set var="i"  value="${i+1}"/>
			</c:forEach>
		</table>
	</div>

<c:import url="/WEB-INF/views/end.jsp" />