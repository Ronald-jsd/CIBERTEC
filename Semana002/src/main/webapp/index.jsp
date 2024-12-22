<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
</head>
<body>
	<%
	String saludo = "Hola mundo";
	%>
	<%=saludo%>

	<%--Registro es el srvlet 
metodo get
--%>
	<form action="Registro" method="get">
		<div>
			<label id="name" for="name">Name: <input type="text"
				placeholder="Jhon" name="name" required />
			</label>
		</div>

		<div>
			<label id="Lastname" for="Lastname">Lastname: <input
				type="text" placeholder="doe" name="Lastname" />
			</label>
		</div>

		<div>
			<label id="email" for="email">Email: <input type="email"
				placeholder="Jhondoe@gmail.com" name="email" required />
			</label>
		</div>

		<div>
			<label id="phone" for="phone">Phone: <input type="number"
				placeholder="49995" name="phone" required />
			</label>
		</div>
		<div>
			<button type="submit">Send</button>
		</div>
	</form>

</body>
</html>