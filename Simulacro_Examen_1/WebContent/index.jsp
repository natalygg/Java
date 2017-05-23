<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div>Entrada al Diario</div>
<br>

<form action="diario.jsp" method="POST">

<label>Usuario:</label>
<input type="text" name="usuario" value="" id="usuario" placeholder="Escriba su usuario"/>
<br>

<label>Contraseña:</label>
<input type="password" name="password" value="" id="password" placeholder="Contraseña"/>
<br>

<button type="submit" value="Entrar" name="">Entrar</button>

</form>

</body>
</html>