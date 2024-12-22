<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>CRUD </title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">


</head>
<body>
  <div class="container my-5">
    <h1 class="text-center">Gestión de Equipos</h1>
    <div class="d-flex justify-content-between align-items-center mb-3 bg-info text-white px-3 py-3 mt-5">
      <h4>Lista de Equipos</h4>
      <button class="btn btn-success" data-bs-toggle="modal" data-bs-target="#createUserModal">Añadir Usuario</button>
    </div>
    
	<c:choose>
	    <c:when test = "${listaEquipos == null || listaEquipos.isEmpty()}" >
	    	<p>No hay usuarios disponibles</p>
	   </c:when>
   
	   <c:otherwise>
		    <table class="table table-bordered">
				<thead>
			    	<tr>
			    		<th>ID</th>
			    		<th>Nombre</th>
			     		<th>Liga</th>
			     		<th>Puntos</th>
			     		<th>Victorias</th>
			     		<th>Derrotas</th>  
			     		<th>Acciones</th>  
			     		   		
			    	</tr>
			    </thead>
			    
			    <tbody>
				    <c:set var="cont" value="1" />
			    	<c:forEach var="equipo" items="${listaEquipos}">
				    	<tr>
				    		<td>${cont}</td>
				    		<td>${equipo.name}</td>
				     		<td>${equipo.liga}</td>
				     		<td>${equipo.puntos}</td>
				     		<td>${equipo.victorias}</td>
				     		<td>${equipo.derrotas}</td>	
				     		<td>
				     		<form action="RegisterServlet"  method ="POST">
				     		<input type="hidden"  name="nameClub" value="${equipo.name}" >
				     		<input type="hidden"  name="accion" value="borrar" >
				     		
				     		<button type="submit" class="btn btn-danger">Borrar</button>	
				     		</form>
				     		</td>	
				    	</tr>
				    <c:set var="cont" value="${cont+1}" />
			    	</c:forEach>
			    </tbody>
		    </table>	
		  <a href="index.jsp" class="btn btn-primary">Regresar</a>
	  </c:otherwise>
	</c:choose>

  </div>

  <!-- Modal Crear Usuario -->
  <div class="modal fade" id="createUserModal" tabindex="-1" aria-labelledby="createUserLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="createUserLabel">Añadir Usuario</h5>
          <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
        </div>
        <div class="modal-body">
        
        
  
            <form action="RegisterServlet" method="POST">
              <div class="mb-3">
                <label for="nameClub" class="form-label">Nombre del Club:</label>
                <input type="text" class="form-control" id="nameClub"  name ="nameClub" placeholder="Nombre del club">
              </div>
              <div class="mb-3">
                <label for="liga" class="form-label">Liga:</label>
                <input type="text" class="form-control" id ="liga" name="liga" placeholder="Nombre de a Liga">
              </div>
              <div class="mb-3">
                <label for="puntos" class="form-label">Puntos:</label>
                <input type="text" class="form-control" id="puntos" name="puntos" placeholder="80">
              </div>
              <div class="mb-3">
                <label for="victorias" class="form-label">Victorias:</label>
                <input type="number" class="form-control" id="victorias" name="victorias"  placeholder="24">
              </div>
              
               <div class="mb-3">
                <label for="derrotas" class="form-label">Derrotas:</label>
                <input type="number" class="form-control" id="derrotas" name="derrotas" placeholder="6">
              </div>
              
              <div class="text-center">
                <button type="submit" class="btn btn-primary w-100" name="accion" value="registrar" >Registrar</button>
              </div>
              
              
            </form>
          
          
        </div>
      </div>
    </div>
  </div>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>