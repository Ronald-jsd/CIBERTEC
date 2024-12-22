<%@ taglib prefix="ct" uri="/WEB-INF/tlds/customTags.tld" %>
<!DOCTYPE html>
<html>
<head>
    <title>Ejemplo de Etiqueta Personalizada</title>
</head>
<body>
    <h1>Bienvenido a la Página de Registro</h1>
    <!-- Utilizar la etiqueta personalizada <saludo> -->
    <ct:saludo name="Juan" />
    
    
    <br>
       <!-- Utilizar la etiqueta personalizada <currentDate> -->
      <strong>Fecha de hoy</strong> <ct:currentDate />
    
    
    <br>  <br>   <br>
    <form method="post">
    <label for="numero">Ingrese el monto en soles:</label> 
    <input type="number" id="numero" name="numero"> 
    <input type="submit" value="Enviar">
    </form>
    
    
    <c:if test="${not empty param.monto}"> 
    <ct:convertirMoneda monto="${param.monto}" /> 
    </c:if>
    
    
</body>
</html>
