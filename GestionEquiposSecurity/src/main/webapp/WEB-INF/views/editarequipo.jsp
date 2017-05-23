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
	<h1><spring:message code="editando_equipo" />:</h1>
	<form action="modificarEquipo" method="POST" onsubmit="return comprobarDatosEquipo();">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		<input type="hidden" name="id" value="${equipo.id}" />
		<label for="tipo"><spring:message code="tipo" />:</label> 
		<select name="tipo">
			<c:forEach items="${tipos}" var="tipo">
				<option value="${tipo.name()}" ${equipo.tipo eq tipo ? "selected" : ""}><spring:message code="${tipo.name()}" /></option>
			</c:forEach>
		</select> 
		<br /> 
		<label for="ubicacion"><spring:message code="ubicacion" />:</label> 
		<input type="text" id="ubicacion"
			name="ubicacion"  value="${equipo.ubicacion}"/> 
			<br />
		<label for="modelo"><spring:message code="modelo" />:</label> 
		<input type="text" id="modelo" name="modelo" value="${equipo.modelo}"/> 
		<br /> 
		<label for="fechaInstalacion"><spring:message code="fecha_instalacion" />:</label> 
		<input type="text" id="fechaInstalacion" name="fechaInstalacion" value="${fechaInstalacion}"/> 
		<script>$("#fechaInstalacion").datepicker({dateFormat: "${formatoFecha}",constrainInput:true});</script>
		<br />
		<button type="submit" class="btn btn-lg btn-default"><spring:message code="grabar" /></button>
		<button class="btn btn-lg btn-default" onclick="window.history.go(-1);"><spring:message code="cancelar" /></button>
	</form>
</div>

<c:import url="/WEB-INF/views/end.jsp" />