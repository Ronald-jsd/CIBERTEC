<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tlds/customTags.tld" prefix="custom"%>

<%@ taglib prefix="customEstatic" tagdir="/WEB-INF/tags"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Bootstrap CSS desde CDN -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css">

<!-- Bootstrap JS desde CDN -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
<title>Registro</title>
</head>
<body class="d-flex flex-column min-vh-100">

	<customEstatic:menu />



	<div class="container mt-5">
		<!-- Título centrado -->
		<h1 class="text-center mb-4">Registro de Usuario</h1>

		<!-- Mensaje de bienvenida, solo visible si el usuario es administrador -->
		<c:choose>
			<c:when test="${not empty sessionScope.admin}">
				<p class="text-muted text-center">
					<custom:saludo name="${sessionScope.admin.correo}"></custom:saludo>
					<strong>.Fecha Actual: </strong>
					<custom:currentDate />
				</p>
			</c:when>
		</c:choose>

		<!-- Formulario de registro -->
		<form action="RegisterServlet" method="post"
			class="w-50 mx-auto p-4 border rounded shadow-sm bg-light">
			<!-- Campo de nombre -->
			<div class="mb-3">
				<label for="nombre" class="form-label">Nombre:</label> <input
					type="text" id="nombre" name="nombre" value="${preUser.name}"
					class="form-control" required>
			</div>

			<!-- Campo de correo -->
			<div class="mb-3">
				<label for="correo" class="form-label">Correo:</label> <input
					type="email" id="correo" name="correo" value="${preUser.mail}"
					class="form-control" required>
			</div>

			<!-- Botones de registrar y actualizar -->
			<div class="d-flex justify-content-center gap-2">
				<button type="submit" name="accion" value="registrar"
					class="btn btn-success btn-sm">Registrar</button>
				<button type="submit" name="accion" value="actualizar"
					class="btn btn-outline-warning btn-sm">Actualizar</button>
			</div>
		</form>

		<!-- Enlaces de navegación -->
		<div class="text-center mt-4">
			<a href="ListarServlet" class="btn btn-info btn-sm">Listar
				Usuarios</a> <a href="bienvenida.jsp" class="btn btn-secondary btn-sm">Volver
				a Bienvenida</a>
		</div>

	</div>




</body>
</html>