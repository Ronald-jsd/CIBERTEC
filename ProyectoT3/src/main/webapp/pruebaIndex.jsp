<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link 
	rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">

</head>
<body>

	<form action="ReporteServlet" method="GET">
	
	<input type="hidden" name="accion" value="listarReporte">
	<button type="submit" class="btn btn-primary">INGRESAR A LISTAR</button>
	</form>

</body>
</html>