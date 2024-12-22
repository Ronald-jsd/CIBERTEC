<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Courses</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>

	<header>

		<h1>Java Web Courses</h1>

		<p>Here you can find all the courses related to java web</p>
		<%
		String nombre = request.getParameter("name");
		String apellido = request.getParameter("lastname");
		int telefono = Integer.parseInt(request.getParameter("phone"));
		System.out.printf("Los estudiantes son %s, %s y sus notas son %d", nombre, apellido, telefono);
		%>

		<p>
			Welcome
			<%=nombre%>, you can select your course.
		</p>

	</header>



</body>
</html>