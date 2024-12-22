<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Formulario de Registro</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<style>
	.title-Head{
      	background-image: url('https://liga1.pe/wp-content/uploads/2024/06/0U7A4314-min-2-scaled.jpg'); 
		background-position: center; 
		background-size: cover; 
    	filter: brightness(1); 
    	color:white;
	}
</style>

<body class="bg-light">

  <div class="container py-5 ">
  
    <div class="row justify-content-center ">
    
      <div class="col-md-6">
   		 <h1 class="py-1 my-4 text-black text-center">Formulario de Registro</h1>
      
        <div class="card shadow-lg">
        
          <div class="card-header bg-primary text-white text-center title-Head  py-5  ">
         
          </div>
          <div class="card-body ">
          
            <form action="RegisterServlet" method="POST">
              
              <div class="mb-3">
                <label for="nameClub" class="form-label">Nombre del Club:</label>
                <input type="text" class="form-control" id="nameClub"  name ="nameClub" placeholder="Escriba el nombre del club">
              </div>
              <div class="mb-3">
                <label for="liga" class="form-label">Liga:</label>
                <input type="text" class="form-control" id ="liga" name="liga" placeholder="Escriba el nombre de a Liga">
              </div>
              <div class="mb-3">
                <label for="puntos" class="form-label">Puntos:</label>
                <input type="text" class="form-control" id="puntos" name="puntos" placeholder="Puntos del equipo">
              </div>
              <div class="mb-3">
                <label for="victorias" class="form-label">Victorias:</label>
                <input type="number" class="form-control" id="victorias" name="victorias"  placeholder="Cantidad de victorias">
              </div>
              
               <div class="mb-3">
                <label for="derrotas" class="form-label">Derrotas:</label>
                <input type="number" class="form-control" id="derrotas" name="derrotas" placeholder="Cantidad de derrotas">
              </div>
              
              <div class="text-center">
                <button type="submit" class="btn btn-primary w-100 py-2" name="accion" value="registrar" >Registrar</button>
              </div>
                     
            </form>
            
              <form action="RegisterServlet" method="POST">
               	<div class="text-center">
                	<button type="submit" class="btn btn-dark w-100 p-2 my-2" name="accion" value="listar" >Listar</button>
              	</div>
              </form>
                
          </div>
        </div>
      </div>
    </div>
  </div>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>