<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body class="bg bg-light text-center ">

		<div class="container col-md-6 py-5 ">
			<div class=" card shadow-lg p-5 bg-black">
				<h1 class="text-white text-center mt-5">BIENVENIDO</h1>
				<form action="RegisterServlet" method="GET">
					<input type="hidden" name ="accion" value="listarLigas" />
			    	<button class="btn btn-light mt-3" type="submit" name="ingresar">Ingresar</button>
				</form>
			</div>
		</div>
</body>
</html>