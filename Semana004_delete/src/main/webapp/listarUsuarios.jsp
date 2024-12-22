<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Listado de Usuarios</h1>

	<c:choose>
		<c:when test="${usuarios == null || usuarios.isEmpty()}">
			<!-- Mostrar mensaje si la lista está vacía -->
			<p>No hay usuarios disponibles.</p>
		</c:when>
		<c:otherwise>
			<!-- Mostrar tabla si la lista contiene usuarios -->
			<table>
				<thead>
					<tr>
						<th>Nombre</th>
						<th>Email</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="usuario" items="${usuarios}">
						<tr>
							<td>${usuario.name}</td>
							<td>${usuario.mail}</td>
							<td>
								<!-- Botón para editar -->
								<form action="RegisterServlet" method="post"
									style="display: inline;">
									<input type="hidden" name="name" value="${usuario.name}">
									<input type="hidden" name="accion" value="borrar">
									<button type="submit">Borrar</button>
								</form>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:otherwise>
	</c:choose>
</body>
</html>