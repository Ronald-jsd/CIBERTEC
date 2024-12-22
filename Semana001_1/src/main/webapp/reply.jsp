<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>${mensaje }</h1>
	<a href="register.jsp">Volver</a>
	<c:choose>

		<c:when test="${usuarios == null || usuarios.isEmpty()}">
			<!-- Mostrar mensaje si la lista está vacía -->
			<p>No hay usuarios disponibles.</p>

		</c:when>
	</c:choose>

</body>
</html>