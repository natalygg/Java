<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%@page import="java.sql.*" %>

<%

	String nombre=request.getParameter("nombre");

	String password=request.getParameter("password");
	
	
	
	Class.forName("com.mysql.jdbc.Driver");
	
	try{
	
	Connection miConexion=DriverManager.getConnection("jdb:mysql://localhost:3306/simulacro_examen1","root","");
	
	Statement miStatement=miConexion.createStatement();
	
	String instruccionSql="INSERT INTO USUARIOS (Nombre,Password) VALUES ('"+nombre+"','"+password+"')";
	
	miStatement.executeUpdate(instruccionSql);
	out.println("Registrado con exito");
	}catch(Exception e){
		
		out.println("Ha ocurrido un error");
	}



%>

</body>
</html>