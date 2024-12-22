<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Registro de Usuario</h1>
    <form action="RegisterServlet" method="post">
        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre" required><br><br>

        <label for="correo">Correo:</label>
        <input type="email" id="correo" name="correo" required><br><br>

        <button type="submit" name="accion" value="registrar">Registrar</button>
        <button type="submit" name="accion" value="listar">Listar</button>
        <button type="submit" name="accion" value="listarSP">ListarSP</button>
    </form>
</body>
</html>