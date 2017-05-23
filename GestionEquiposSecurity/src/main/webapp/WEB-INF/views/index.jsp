<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<c:import url="/head.jsp" />

<div id="inicio">
	<h1><spring:message code="bienvenido" /></h1>
	<a href="listadoEquipos"><button class="btn btn-lg btn-default"><spring:message code="entrar" /></button></a>
</div>
<c:import url="/WEB-INF/views/end.jsp" />