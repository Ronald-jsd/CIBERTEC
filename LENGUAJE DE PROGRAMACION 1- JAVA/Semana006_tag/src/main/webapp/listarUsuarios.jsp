<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Bootstrap CSS -->


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

<title>Listado</title>
</head>
<body>
	<div class="container mt-5">
		<!-- Título -->
		<h1 class="text-center mb-4">Listado de Usuarios</h1>

		<!-- Mensaje de bienvenida -->
		<c:choose>
			<c:when test="${not empty sessionScope.admin}">
				<p class="text-muted text-center">Bienvenido
					${sessionScope.admin.correo}</p>
			</c:when>
		</c:choose>

		<!-- Contenido según condición -->
		<c:choose>
			<c:when test="${usuarios == null || usuarios.isEmpty()}">
				<!-- Mensaje si no hay usuarios -->
				<p class="text-center text-danger">No hay usuarios disponibles.</p>
			</c:when>
			<c:otherwise>
				<!-- Tabla de usuarios -->
				<div class="table-responsive">
					<table class="table table-striped table-hover">
						<thead class="table-dark text-center">
							<tr>
								<th>Nombre</th>
								<th>Email</th>
								<th>Actualizar</th>
								<th>Borrar</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="usuario" items="${usuarios}">
								<tr class="text-center">
									<td>${usuario.name}</td>
									<td>${usuario.mail}</td>
									<td>
										<!-- Botón para actualizar -->
										<form action="RegisterServlet" method="post"
											style="display: inline;">
											<input type="hidden" name="name" value="${usuario.name}">
											<input type="hidden" name="mail" value="${usuario.mail}">
											<input type="hidden" name="accion" value="prepareUpdate">
											<button type="submit" class="btn btn-warning btn-sm">Actualizar</button>
										</form>
									</td>
									<td>
										<!-- Botón para borrar -->
										<form action="RegisterServlet" method="post"
											style="display: inline;">
											<input type="hidden" name="name" value="${usuario.name}">
											<input type="hidden" name="mail" value="${usuario.mail}">
											<input type="hidden" name="accion" value="borrar">
											<button type="submit" class="btn btn-danger btn-sm">Borrar</button>
										</form>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</c:otherwise>
		</c:choose>

		<!-- Enlace de navegación -->
		<div class="text-center mt-4">
			<a href="register.jsp" class="btn btn-primary btn-sm">Regresar</a>
		</div>
	</div>

</body>
</html>