<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="dao.reporteDAO"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Agregar Usuario</title>
<link 
	rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>

	<div class="container mt-5">
		<div class="row">
			<div class="col-md-4">
				<h1>Create</h1>
				<h4>Reporte</h4>
				
				<p style="color:blue"> <strong>${mensaje}</strong> </p>
				
				<form action="ReporteServlet" method="POST" class="mt-4">
					<div class="mb-3">
						<label for="date" class="form-label">Fecha</label> 
						<input type="date" class="form-control" id="date" name="date" required>
					</div>

					<div class="mb-3">
						<label for="turno" class="form-label">Turno</label> <br> 
						<select class="form-control" name="turno" id="turno">
							<option selected disabled>--Seleccione--</option>
							<option value="Turno A">Turno A</option>
							<option value="Turno B">Turno B</option>
						</select>
					</div>

					<!-- OPBCION PRUEBA  -->
					<div class="mb-3">
						<label for="codigoLinea" class="form-label">Codigo linea</label> <br>
						<select class="form-control" id="codigoLinea" name="codigoLinea" onchange="updateMachine()">
							<option selected disabled>--Seleccione--</option>
							<c:forEach var="linea" items="${listLinea}">
								<option value="${linea.codLinea}" data-maquina="${linea.maquina}">${linea.codLinea}</option>
							</c:forEach>
						</select>
					</div>

					<!-- FUNCONA SOLO PARA SU VISTA -->
					<div class="mb-3">
						<label for="maquina" class="form-label">Maquina</label> 
						<input type="text" class="form-control" id="maquina" name="maquina" value="" disabled>
					</div>
					<!-- --------------------------  -->

					<div class="mb-3">
						<label for="produccion" class="form-label">Producción</label> 
						<input type="number" class="form-control" id="produccion" name="produccion" step="any" required>
					</div>
					<div class="mb-3">
						<label for="reproceso" class="form-label">Reproceso</label> 
						<input type=number class="form-control" id="reproceso" name="reproceso" step="any" required>
					</div>
					<div class="mb-3">
						<label for="operador" class="form-label">Operador</label> 
						<input type="text" class="form-control" id="operador" name="operador" required>
					</div>

					<button class="btn btn-primary" type="submit" name="accion" value="crearReporte">Crear</button>
					
					<a href="ReporteServlet?accion=listarReporte" class="btn btn-success">Volver</a> 
					
				</form>
				

			</div>
		</div>
	</div>
	
<script type="text/javascript">

function updateMachine() {
    let codigoLinea = document.getElementById("codigoLinea").value;  // Obtener el valor seleccionado //L001
    let maquinaField = document.getElementById("maquina");  // Obtener el campo de la máquina ____

    // Buscar el option seleccionado en el select
    let selectedOption = document.querySelector("#codigoLinea option[value='" + codigoLinea + "']");

    // Si se encuentra el option
    if (selectedOption) {
        let maquina = selectedOption.getAttribute("data-maquina"); //obtener el valor de data-maquina
        maquinaField.value = maquina; //actualizar el campo de la máquina
    } else {
        maquinaField.value = "No encontrado";  
    }
}
</script>

</body>
</html>