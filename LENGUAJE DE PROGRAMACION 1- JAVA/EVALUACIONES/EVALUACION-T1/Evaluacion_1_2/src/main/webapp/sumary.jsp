<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Venta</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body class="">
	
	<div class=" " >
		  <div class=" p-4 position-absolute top-50 start-50 translate-middle bg-success col-6  rounded">
		  		<h1 class ="text-center text-white">Resumen</h1>
		  		<table class="table border-white">
		  		
		  		<tr>	
		  		<td>
		  		<p class =" start">*Producto:  </p>
		  		</td>
		  		<td>
		  			<span>${nombre}</span>
		  		</td>
		  		</tr>

		  		
		  		<tr>
		  		<td>
		  		<p class ="start ">*Precio Unitario</p>
		  		</td>
		  				
		  		<td>
		  			<span>S/. ${precioUnitario}</span>
		  		</td>
		  		
		  		</tr>
		  
		  		<tr>
		  		<td>
		  		<p class ="start">*Cantidad deseada</p>
		  		</td>
		  				
		  		<td>
		  			<span>${cantidadMsg}</span>
		  		</td>
		  		
		  		</tr>
		  		
		  	 	<tr>
		  		<td  class="bg bg-light">
		  		<p class ="start ">*Total:</p>
		  		</td>
		  				
		  		<td  class="bg bg-light">
		  			<span>S/. ${total}</span>
		  		</td>
		  		
		  		</tr>
		  		
		  		<tr>
			  		<td  class="bg bg-light text-danger">
			  		<span >${aviso}</span>
			  		</td>
			  		<td  class="bg bg-light">

			  		</td>
		  		</tr>
		  		
		  		
		 </table>
		  
		  </div>
		
	</div>
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>