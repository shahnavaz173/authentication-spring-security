<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>
	<a href="data">Data</a>
	<c:choose>
		<c:when test="${empty(loginUser)}">
			<a href="login">Login</a>
		</c:when>
		<c:otherwise>
			<a href="logout">Logout</a>
		</c:otherwise>
	</c:choose>
</body>
</html>