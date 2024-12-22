<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--  action conectara con: , y el method con:   , ¿porque post, tambien puedo usar get?: relacion del name con el servlet -->
	<form action="Registro" method="post">
		<div>
			<label id="name" for="name">Name: <input type="text"
				placeholder="Jhon" name="name" required />
			</label>
		</div>

		<div>
			<label id="dni" for="Lastname">lastName: <input type="text"
				placeholder="75411198" name="lastName" />
			</label>
		</div>



		<div>
			<label id="edad" for="edad">Edad: <input type="number"
				placeholder="25" name="age" required />
			</label>
		</div>

		<div>
			<button type="submit">Send</button>
		</div>
	</form>
</body>
</html>