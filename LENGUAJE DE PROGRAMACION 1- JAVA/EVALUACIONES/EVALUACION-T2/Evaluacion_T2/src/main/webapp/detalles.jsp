<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Detalles</title>
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    
</head>
<body>
	
	<div class="container my-5">
    	<h1 class="text-center">INFORMACIÓN DEL CLUB </h1>
    <div class="d-flex justify-content-between align-items-center mb-3 bg-black text-white px-3 py-3 mt-5">
    	<h4>Detalles de ${clubSeleccionado.nombreClub}</h4>
      </div>
	    <table class="table table-bordered">
	        <thead>
	            <tr>
	                <!--  <th>Id</th>-->
	                <th>Equipo</th>
	                <th>Campeonatos Nacionales</th>
	                <th>Copas Nacionales</th>
	                <th>Campeonatos Europeos</th>                
	            </tr>
	        </thead>
	        
	        <tbody>
	                <tr>
	                    <!--   <td>${clubSeleccionado.idClub}</td> -->
	                    <td>${clubSeleccionado.nombreClub}</td>
	                   	<td>${clubSeleccionado.campeonatosNacionales}</td>
	                    <td>${clubSeleccionado.copasNacionales}</td>
	                    <td>${clubSeleccionado.campeonatosEuropeos}</td>    
	                </tr>
	        </tbody>
	        
	    </table>
	    

	</div>

</body>
</html>
