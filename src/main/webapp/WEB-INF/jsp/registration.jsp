<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>User Registration</h1>
<form:form method="post" action="register" modelAttribute="createUser">
	<font color="red">${REGISTRATION_ERROR }</font><br />
	User Name: <form:input type="text" path="username" placeholder="Enter Username" /><br />
	Password : <form:input type="password" path="password" placeholder="Enter Password" /><br />
	<input type="submit" value="Register" ><br />
	Click <a href="login">here</a> to login if you already have account.
	
</form:form>
</body>
</html>