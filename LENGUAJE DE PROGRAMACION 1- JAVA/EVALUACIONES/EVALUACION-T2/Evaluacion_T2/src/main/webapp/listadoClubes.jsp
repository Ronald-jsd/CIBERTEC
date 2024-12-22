<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listado de Clubes</title>
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">    
	
</head>
<style> .hidden { 
	display: none; 
	} 	
</style>

<body>
	
	<div class="container my-5">
    <h1 class="text-center">GESTIÓN DE CLUBS</h1>
    <div class="d-flex justify-content-between align-items-center mb-3 bg-dark text-white px-3 py-3 mt-5">
      <h4>Lista de Clubs </h4>
      </div>
    <table class="table table-bordered table-hover table-striped">
        <thead >
            <tr>
             <!--   <th>Id</th> --> 
                <th>N°</th>                
                <th>Equipo</th>
                <th>Acciones</th>
            </tr>
        </thead>
        <tbody>
          <!-- Si 'listClubes' está vacío, muestra un mensaje -->
				<c:if test="${empty listClubes}">
				    <p>No se encontraron clubes para esta liga.</p>
				</c:if>
	
           <c:set var="contador" value="1"/>
        
            <!-- Itera sobre la lista de clubes -->
         	<c:forEach var="club" items="${listClubes}">
            
                <tr>
                <!-- Mostrar la lista de cada liga -->
                   <td class="hidden">${club.idClub}</td> 
                    
                    <td>${contador}</td>                    
                    <td>${club.nombreClub}</td>
                    
               		<!--  <td><a href="RegisterServlet?accion=listarClubsDeLigas&id_liga=${club.idClub}&listarClubODetalles=listarDetalles" class="btn btn-success">Detalles</a></td>  -->
               	<td>
				    <form action="RegisterServlet" method="get">
				        <input type="hidden" name="accion" value="listarClubsDeLigas">
				        <input type="hidden" name="id_liga" value="${club.idClub}">
				        <input type="hidden" name="listarClubODetalles" value="listarDetalles">
				        <button type="submit" class="btn btn-success">Detalles</button>
				    </form>
				</td>
               	
                </tr>
                
           <c:set var="contador" value="${contador+1}"/>
				
            </c:forEach>
        </tbody>
    </table>


	<form action="http://localhost:8080/Evaluacion_T2/RegisterServlet" method="get">
	    <input type="hidden" name="accion" value="listarLigas" />
	    <input type="hidden" name="ingresar" value="" />
	    <button type="submit" class="btn btn-primary">Regresar</button>
	</form>


</div>

</body>
</html>
