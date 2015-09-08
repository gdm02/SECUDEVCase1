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
<c:if test="${session == null}">
    <c:redirect url="login.jsp"></c:redirect>
</c:if>

<c:forEach items="${accList}" var="entry">
    <tr>
        <td>Salutation: <c:out value="${entry.salutation}"/></td>
        <td>Firstname: <c:out value="${entry.fname}"/></td>  
        <td>Lastname: <c:out value="${entry.lname}"/></td>  
        <td>Gender: <c:out value="${entry.gender}"/></td>  
        <td>Birthdate: <c:out value="${entry.birthdate}"/></td>  
        <td>Username: <c:out value="${entry.username}"/></td>  
        <td>Password: <c:out value="${entry.password}"/></td> 
        <td>Access Level: <c:out value="${entry.accesslvl}"/></td> 
        <td>Description: <c:out value="${entry.aboutme}"/></td>  
    </tr>
</c:forEach>

</body>
</html>