<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<header>
		<%
		String nombre = request.getParameter("name");
		String dni = request.getParameter("dni");
		int edad = Integer.parseInt(request.getParameter("edad"));
		String apellido = request.getParameter("apellido");
		request.setAttribute("nombre", nombre);
		request.setAttribute("dni", dni);
		request.setAttribute("edad", edad);
		request.setAttribute("apellido", apellido);
		%>

		<%
		if (edad > 18) {
		%>
		<h2>Acceso Permitido</h2>
		<p>Bienvenido ${nombre} ${apellido} al juego.</p>
		<p>Tu DNI es: ${dni}</p>
		<%
		} else {
		%>
		<h2>Acceso Denegado</h2>
		<p>Lo sentimos, ${nombre}. Ingresarás cuando tengas más de 18
			años.</p>
		<p>Tu edad actual es: ${edad} años.</p>
		<%
		}
		%>


	</header>

</body>
</html>