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

<title>Login</title>
</head>
<body>

	<customEstatic:menu />


	<div class="container mt-5">
		<!-- Título centrado -->
		<h1 class="text-center mb-4">Iniciar Sesión</h1>

		<!-- Fecha estilizada -->
		<p class="text-muted text-center">
			Fecha:
			<custom:currentDate format="yyyy-MM-dd" />
		</p>

		<!-- Formulario estilizado -->
		<form action="LoginServlet" method="post"
			class="w-50 mx-auto p-4 border rounded shadow-sm bg-light">
			<!-- Campo de correo -->
			<div class="mb-3">
				<label for="correo" class="form-label">Correo</label> <input
					type="email" id="correo" name="correo" class="form-control"
					placeholder="Ingrese su correo" required>
			</div>

			<!-- Campo de contraseña -->
			<div class="mb-3">
				<label for="password" class="form-label">Contraseña</label> <input
					type="password" id="password" name="password" class="form-control"
					placeholder="Ingrese su contraseña" required>
			</div>

			<!-- Botón de envío -->
			<div class="text-center">
				<button type="submit" class="btn btn-primary btn-block">Iniciar
					Sesión</button>
			</div>
		</form>

		<!-- Mensaje de error -->
		<c:if test="${not empty errorMessage}">
			<p class="text-danger text-center mt-3">${errorMessage}</p>
		</c:if>
	</div>

</body>
</html>