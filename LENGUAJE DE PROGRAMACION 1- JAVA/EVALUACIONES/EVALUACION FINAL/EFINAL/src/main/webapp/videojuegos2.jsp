<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gaming Store</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <!-- Barra de navegación -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-fluid">
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="menu.jsp">Inicio</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" href="videojuegos.jsp">Videojuegos</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <!-- Contenido principal -->
    <div class="container mt-5">
        <h1 class="text-center mb-4">Lista de Videojuegos</h1>
        <div class="d-flex justify-content-end mb-3">
            <button class="btn btn-primary" onclick="abrirModal('nuevoModal')">Nuevo Juego</button>
            
        </div>
        <table class="table table-striped table-hover">
            <thead class="table-dark">
                <tr>
                    <th>Código</th>
                    <th>Nombre</th>
                </tr>
            </thead>
            <tbody>
                <!-- Uso de JSTL para iterar sobre la lista de vehículos -->
                <c:forEach var="desarrolladora" items="${listaDesarrolladoras}">
                    <tr>
                        <td>${desarrolladora.idDesarrolladora}</td>
                        <td>${desarrolladora.nombre}</td>
                        <td>
                            <button class="btn btn-warning btn-sm" onclick="abrirModalEditar('${vehiculo.costo}', '${vehiculo.nombre}', '${vehiculo.version}', '${vehiculo.costo}', '${vehiculo.desarrolladora}')">Editar</button>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <!-- Modal Nuevo Videojuego -->
    <div id="nuevoModal" class="modal fade" tabindex="-1">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Nuevo Videojuego</h5>
                    					<c:if test="${not empty listaDesarrolladoras}">
					    <p>Lista cargada correctamente</p>
					   <%System.out.print("Lista cargada");  %> >
					</c:if>
					<c:if test="${empty listaDesarrolladoras}">
					    <p>La lista está vacía.</p>
					   <%System.out.print("Lista no cargada");  %> 
					    
					</c:if>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form action="AgregarVehiculoServlet" method="post">
                        <div class="mb-3">
                            <label for="codigo" class="form-label">Código:</label>
                            <input type="text" id="codigo" name="codigo" class="form-control" required>
                        </div>
                        <div class="mb-3">
                            <label for="nombre" class="form-label">Nombre:</label>
                            <input type="text" id="nombre" name="nombre" class="form-control" required>
                        </div>
                        <div class="mb-3">
                            <label for="version" class="form-label">Versión:</label>
                            <input type="text" id="version" name="version" class="form-control" required>
                        </div>
                        <div class="mb-3">
                            <label for="costo" class="form-label">Costo:</label>
                            <input type="text" id="costo" name="costo" class="form-control" required>
                        </div>
                        <div class="mb-3">
    <label for="desarrolladora" class="form-label">Desarrolladora:</label>
    <select id="desarrolladora" name="desarrolladora" class="form-select" required>
        <option value="" disabled selected>Seleccione una desarrolladora</option>
        <!-- Listar desarrolladoras desde la base de datos -->
        <c:forEach var="desarrolladora" items="${listaDesarrolladoras}">
            <option value="${desarrolladora.idDesarrolladora}">${desarrolladora.nombre}</option>
        </c:forEach>
    </select>
</div>
                        <button type="submit" class="btn btn-success">Guardar</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <!-- Modal Editar Videojuego -->
    <div id="editarModal" class="modal fade" tabindex="-1">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Editar Vehículo</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form action="EditarVehiculoServlet" method="post">
                        <input type="hidden" id="edit-id" name="id">
                        <div class="mb-3">
                            <label for="edit-codigo" class="form-label">Código:</label>
                            <input type="text" id="edit-codigo" name="codigo" class="form-control" required>
                        </div>
                        <div class="mb-3">
                            <label for="edit-nombre" class="form-label">Nombre:</label>
                            <input type="text" id="edit-nombre" name="nombre" class="form-control" required>
                        </div>
                        <div class="mb-3">
                            <label for="edit-version" class="form-label">Versión:</label>
                            <input type="text" id="edit-version" name="version" class="form-control" required>
                        </div>
                        <div class="mb-3">
                            <label for="edit-costo" class="form-label">Costo:</label>
                            <input type="text" id="edit-costo" name="costo" class="form-control" required>
                        </div>
                        <div class="mb-3">
    <label for="edit-desarrolladora" class="form-label">Desarrolladora:</label>
    <select id="edit-desarrolladora" name="desarrolladora" class="form-select" required>
        <option value="" disabled selected>Seleccione una desarrolladora</option>
        <!-- Listar desarrolladoras desde la base de datos -->
        <c:forEach var="desarrolladora" items="${desarrolladoras}">
            <option value="${desarrolladora.id_desarrolladora}">${desarrolladora.nombre}</option>
        </c:forEach>
    </select>
</div>
                                <!-- Botones de eliminar y actualizar -->
        				<div class="d-flex justify-content-center gap-2">
           				 <button type="submit" name="accion" value="registrar" class="btn btn-success btn-sm">Actualizar</button>
           				 <button type="submit" name="accion" value="actualizar" class="btn btn-danger btn-sm">Eliminar</button>
       					</div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

    <!-- Script para pasar datos al formulario de edición -->
    <script>
        function abrirModalEditar(codigo, nombre, version, costo, desarrolladora) {
            const modal = new bootstrap.Modal(document.getElementById('editarModal'));
            document.getElementById('edit-codigo').value = codigo;
            document.getElementById('edit-nombre').value = nombre;
            document.getElementById('edit-version').value = version;
            document.getElementById('edit-costo').value = costo;
            document.getElementById('edit-desarrolladora').value = desarrolladora;
            modal.show();
        }
        
    </script>
    
    <script>
    function abrirModal(modalId) {
        const modal = new bootstrap.Modal(document.getElementById(modalId));
        modal.show();
    }
	</script>
</body>
</html>
