<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>CRUD Completo</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>

<!-- --------------PARA EJECUTAR DIRECTAMENTE --------------------------------------------- -->
<!-- Verifica si la lista de reportes está vacía -->
<c:if test="${empty listReporte}">
    <!-- Si está vacía, redirige al Servlet-listarReporte para cargar los reportes -->
    <jsp:forward page="ReporteServlet?accion=listarReporte" />
</c:if>
<!-- -------------------------------------------------------------------------------------- -->
	<div class="container my-5">
		<h2 class="">Reporte de Extrusion</h2><br>
		
		<div class="row">
			<div class="col d-flex justify-content-start gap-4">
				<a href="ReporteServlet?accion=listarLinea" class="btn btn-dark">Reporte Nuevo</a>

				<button type="submit" class="btn btn-primary">Ir a Programar</button>
				<button type="submit" class="btn btn-success">Ir a Resultados</button>

			</div>
		</div><br>
		
		<!--TABLA -->
		<div class="table-responsive">
			<table class="table table-bordered  mt-2">
				<!-- CABECERA DE TABLA -->
				<thead>
					<tr>
						<th>ID</th>
						<th>Fecha</th>
						<th>Maquina</th>
						<th>Producción</th>
						<th>Reproceso</th>
						<th>Turno</th>
						<th>Operador</th>
						<th>Acciones</th>
					</tr>
				</thead>
				
				<!-- CUERPPO DONDE SE MOSTRARA RESULTADOS POR CADA UNO  -->
				<tbody>
				
					<!-- Si 'listReporte' está vacío, muestra un mensaje -->
					<c:if test="${empty listReporte}">
						<p>No se encontraron reportes.</p>
					</c:if>

					<!-- JSTL: Recorre la lista de clubes y muestra cada uno en una fila de la tabla -->
					<c:forEach var="report" items="${listReporte}">
						<tr>
							<td>${report.idReporte}</td>

							<td>${report.fecha}</td>
							<td>${report.maquina}</td>
							<td>${report.produccion}</td>
							<td>${report.reproceso}</td>
							<td>${report.turno}</td>
							<td>${report.operador}</td>

							<td>
								<a href="ReporteServlet?accion=eliminarReporte&idReporte=${report.idReporte}"
								class="btn btn-danger btn-sm" onclick="alertaEliminar()">Eliminar</a>
								<button type="submit" class="btn btn-success btn-sm">Agregar Paradas</button>
							</td>

						</tr>
					</c:forEach>
					
				</tbody>
			</table>
		</div>
	</div>

	<script 
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js">
	</script>
	<script type="text/javascript">
	
	function alertaEliminar(){
		alert("¿Esta seguro que desea eliminar?");
	}
	</script>
</body>
</html>
