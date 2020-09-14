<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="login" method="post">
	<font color="red">${SPRING_SECURITY_LAST_EXCEPTION.message}</font><br />
	Username:	<input type="text" name="username" placeholder="Enter username" /><br />
	Password: 	<input type="password" name="password" placeholder="Enter Password"><br />
	<input type="submit" value="Login" />
</form>
</body>
</html>