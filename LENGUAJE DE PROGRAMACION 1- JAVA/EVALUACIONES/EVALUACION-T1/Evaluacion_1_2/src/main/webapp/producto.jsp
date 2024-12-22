<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
	<div class="container p-3">
	<div class = "row">
		<h2>PRODUCTOS</h2>
		<form action="OrderServlet" method="post">
		
		  <div class="mb-3">
		    <label for="nameProduct" class="form-label">Nombre del Producto</label>
		    <input type="text" class="form-control" name="nameProduct" id="nameProduct" placeholder="Mouse" required  >
		  </div>
		  <div class="mb-3">
		    <label for="price" class="form-label">Precio unitario</label>
		    <input type="number" class="form-control" name="price" id="price" placeholder="55.50" required  >
		  </div>
		   <div class="mb-3">
		    <label for="quantity" class="form-label">Cantidad</label>
		    <input type="number" class="form-control" name="quantity" id="quantity" placeholder="5" required  >
		  </div>
		 
		 
		 
		 
		 
		  <button type="submit" class="btn btn-primary">Aceptar</button>
		</form>
	</div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>