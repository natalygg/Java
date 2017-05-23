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
		<h1><spring:message code="nuevo_equipo" />:</h1>
		<form action="altaEquipo" method="POST" onsubmit="return comprobarDatosEquipo();">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<label for="tipo"><spring:message code="tipo" />:</label> 
			<select name="tipo">
				<c:forEach items="${tipos}" var="tipo">
					<option value="${tipo.name()}"><spring:message code="${tipo.name()}" /></option>
				</c:forEach>
			</select> 
			<br /> 
			<label for="ubicacion"><spring:message code="ubicacion" />:</label> 
			<input type="text" id="ubicacion"
				name="ubicacion" /> 
				<br />
			<label for="modelo"><spring:message code="modelo" />:</label> 
			<input type="text" id="modelo" name="modelo" /> 
			<br /> 
			<label for="fechaInstalacion"><spring:message code="fecha_instalacion" />:</label> 
			<input type="text" id="fechaInstalacion" name="fechaInstalacion" /> 
			<script>$("#fechaInstalacion").datepicker({dateFormat: "${formatoFecha}",constrainInput:true});</script>
			<br />
			<button type="submit" class="btn btn-lg btn-default"><spring:message code="alta" /></button>
		</form>
	</div>
	<div id="listado">
		<h1><spring:message code="listado_equipos_existentes" />.</h1>

		<table align="center">
			
				<tr class="fila">
					<th><spring:message code="tipo" /></th>
					<th><spring:message code="ubicacion" /></th>
					<th><spring:message code="modelo" /></th>
					<th><spring:message code="fecha_instalacion" /></th>
					<th></th>
				</tr>
			
			<c:set var="i"  value="0"/>
			<c:forEach items="${lista}" var="e">
				<tr class='fila fila_${i%2 eq 0 ? "par" : "impar"}'>
					<td><a href="editarEquipo?id=${e.id}">${e.stringTipo}</a></td>
					<td><a href="editarEquipo?id=${e.id}">${e.ubicacion}</a></td>
					<td><a href="editarEquipo?id=${e.id}">${e.modelo}</a></td>
					<td><a href="editarEquipo?id=${e.id}">${e.stringFechaInstalacion}</a></td>
					<td><a href="borrarEquipo?id=${e.id}" style="color: red;"><spring:message code="borrar" /></a></td>
				</tr>
				<c:set var="i"  value="${i+1}"/>
			</c:forEach>
		</table>
	</div>

<c:import url="/WEB-INF/views/end.jsp" />