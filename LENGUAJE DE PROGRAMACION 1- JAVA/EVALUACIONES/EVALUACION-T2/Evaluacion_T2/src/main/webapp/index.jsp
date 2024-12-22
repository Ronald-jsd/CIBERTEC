<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Ligas</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<style>
	.title-Head{
      	background-image: url('https://liga1.pe/wp-content/uploads/2024/06/0U7A4314-min-2-scaled.jpg'); 
		background-position: center; 
		background-size: cover; 
    	filter: brightness(1); 
    	color:white;
	}
</style>

<body class="bg-light">

  <div class="container py-5 ">
    <div class="row justify-content-center ">
      <div class="col-md-6">
   		 <h1 class="py-1 my-4 text-black text-center">Liga Europea</h1>
        <div class="card shadow-lg">
          <div class="card-header bg-dark text-white text-center title-Head  py-5  ">
          </div>
          <div class="card-body ">
            
            <form action="RegisterServlet" method="GET">
              <label for="liga" class="form-label">Seleccionar Liga:</label>
              <select class="form-select" name="id_liga" required>
              	<option selected disabled>--Seleccione--</option>
              	<!-- Obtengo datos de la lista ligas -->
	              	<c:forEach var="liga" items="${listaLigas}">
	              		<!-- Mostrar el id y nombre de acuerdo a la base de datos -->
	              		<option value="${liga.id_liga}">${liga.nombre_liga}</option>
	              	</c:forEach>
              </select>
              <input type="hidden" name="listarClubODetalles" value="listarClubs"/>
  
              <div class="text-center">
                 <button type="submit" class="btn btn-dark w-100 p-2 my-2" name="accion" value="listarClubsDeLigas" >Mostrar</button>
              </div>
            </form>
            
          </div>
        </div>
      </div>
    </div>
  </div>
  
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
