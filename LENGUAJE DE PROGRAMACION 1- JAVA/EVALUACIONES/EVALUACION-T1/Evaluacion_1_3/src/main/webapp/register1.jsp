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
	<div class="container p-3 ">
	<div class = "row  justify-content-center">
	<div class="col col-6 border border-primary p-4">
		<h2>REGISTRO</h2>
		<form action="RegisterServlet" method="GET">
		
		  <div class="mb-3">
		    <label for="name" class="form-label">Nombre</label>
		    <input type="text" class="form-control" name="name" id="name" placeholder="Juan Rodriguez" required  >
		  </div>
		  
		  <div class="mb-3">
		    <label for="email" class="form-label">Correo</label>
		    <input type="text" class="form-control" name="email" id="email" placeholder="pepito998@gmail.com" required  >
		  </div>

		 
		  <button type="submit" class="btn btn-primary">Aceptar</button>
		</form>
</div>
	</div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>