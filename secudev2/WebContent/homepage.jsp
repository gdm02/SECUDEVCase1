<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Welcome ${salutation} ${fname} ${lname} <br>
Gender: ${gender} <br>
Birthdate: ${birthdate} <br>
Username: ${username} <br>
Password: ${password} <br>
About Me: ${aboutme} <br>

<c:if test = "${accesslvl == 'Admin'}">
	<a href="adminregister.jsp">Register new user with grants</a>
</c:if>
</body>
</html>