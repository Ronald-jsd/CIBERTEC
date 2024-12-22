<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<h1>Login</h1>
	<form action="LoginServlet" method="post">
            <label for="correo">Correo:</label>
            <input type="email" name="correo" required><br><br>

            <label for="password">Contraseña:</label>
            <input type="password" name="password" required><br><br>

            <button type="submit">Iniciar Sesión</button>
     </form>
     <p>${errorMessage}</p>
</body>
</html>