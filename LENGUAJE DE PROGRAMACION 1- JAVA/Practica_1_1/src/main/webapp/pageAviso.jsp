<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body class="bg text-center align-items-center">

	<h1 class="text-success my-5 py-5">${mensaje}!</h1>
	<img width ="100px" alt="" src="https://icc.com.pa/imagenes/checked.gif">

<script>
  setTimeout(function() {
    window.location.href = "index.jsp";
  }, 2000);
</script>
</body>
</html>