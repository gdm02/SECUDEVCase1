<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src = "jquery-1.11.3.min.js"></script>
<script src = "parsley.js"></script>

<link rel="stylesheet" type="text/css" href="parsley.css">
<title>Login</title>
</head>
<body>
<form id = "login" method = "POST" action = "LoginServlet" data-parsley-validate>
	<label>Username: </label>
	<input type = "text" name = "username" data-parsley-required = "true"/>
	<br> <br>
	<label>Password: </label>
	<input type = "password" name = "password" data-parsley-required = "true"/>
	<br> <br>
	<input type = "submit" value = "Submit"/>
</form>
Don't have an account? Register <a href="register.jsp">here</a>
</body>
</html>