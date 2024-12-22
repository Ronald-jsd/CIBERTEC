<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/customTags.tld" prefix="custom"%>

<%@ taglib prefix="customEstatic" tagdir="/WEB-INF/tags"%>


<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<!-- Bootstrap CSS desde CDN -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css">
<!-- Bootstrap JS desde CDN -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
<title>Bienvenida</title>
</head>
<body class="d-flex flex-column min-vh-100">


	<customEstatic:menu />

	<!-- Contenedor principal -->
	<div class="container mt-5">
		<!-- Título principal -->
		<h1 class="text-center mb-4">Ejemplo de Etiqueta Personalizada</h1>

		<!-- Saludo personalizado -->
		<div class="alert alert-primary text-center" role="alert">
			<custom:saludo name="Juan"></custom:saludo>
		</div>

		<!-- Fecha actual -->
		<p class="text-center text-muted">
			<strong>Fecha Actual:</strong>
			<custom:currentDate format="yyyy-MM-dd" />
		</p>
	</div>

	<!-- Pie de página personalizado -->
	<footer class="bg-dark text-white text-center py-3 mt-auto">
		<p>
			*-
			<custom:footer autor="Juan" correo="juan.perez@example.com"
				direccion="Lima - Chorrillos" />
		</p>

	</footer>
</body>
</html>
