<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registro</title>
</head>
<body>
	<h1>Registro de Usuario</h1>
	<c:choose>
	<c:when test="${not empty sessionScope.admin}">
            <p>Bienvenido ${sessionScope.admin.correo}</p>
        </c:when>
        </c:choose>
    <form action="RegisterServlet" method="post">
        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre" value="${preUser.name}" required><br><br>

        <label for="correo">Correo:</label>
        <input type="email" id="correo" name="correo" value="${preUser.mail}" required><br><br>

        <button type="submit" name="accion" value="registrar">Registrar</button>
        <button type="submit" name="accion" value="actualizar">Actualizar</button>
    </form>
    <a href="ListarServlet">Listar</a>
</body>
</html>