<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> </title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body class="bg-light">
	
	<div class="container col-4" >
		<form class="form" action="RegisterServlet" method="POST">
			  <div class="col mt-5">
			  		<h1 class ="start">Plataforma</h1>
			  		<p class =" start">Nombre: ${nombre}</p>
			  		<p class ="start ">Email: ${correo} </p>
			  		
					  <div class="mb-3">
					    <label for="contrasena" class="form-label">Ingresar contraseña</label>
					    <input type="password" class="form-control"  name="contrasena" id="contrasena"   required  >					
					  	<spam class="spam " id="spam-contrasena"> </spam>
					  </div>
					  <button type="button" onclick="generarContrasena()" class="btn btn-secondary" >Contraseña automatica</button>
					  <button type="submit" class="btn btn-primary">Aceptar</button>
					  
			  </div>
		</form>	
	</div>
	
	
	
	<script>
	function generarContrasena(){
	const caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890@#$*%?/";
	let contrasena = "";
		for(let i = 0; i<12;i++){
			let index = Math.floor(Math.random()*caracteres.length );
			contrasena += caracteres.charAt(index);
		}
		 document.getElementById('contrasena').value = contrasena;
		 document.getElementById('spam-contrasena').innerText = contrasena;

	}
	</script>
	
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>