<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Menú</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <!-- Barra de navegación -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-fluid">
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link active" href="menu.jsp">Inicio</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="VideojuegoServlet?accion=listarVideojuego">Videojuegos</a>
                        <!--   <a class="nav-link" href="DesarrolladoraServlet?accion=listarDesarrolladoras">Videojuegos2</a> --> 
                    
                    
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <!-- Contenido principal -->
    <div class="container mt-5">
        <div class="text-center">
            <h1>Bienvenido al Menú Principal</h1>
            <p>Seleccione una opción del menú para continuar.</p>
               <h3>${mensajeRegistro}</h3>
           
        </div>
    </div>





<script type="text/javascript">


</script>
    <!-- Bootstrap JS (para funcionalidad como la barra colapsable) -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
