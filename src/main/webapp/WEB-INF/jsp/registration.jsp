<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
  </head>
<body>
<nav class="navbar navbar-default" style="color: cyan !important">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="index"><img alt="Brand" height="35" width="35" src="images/logo.png" /></a>
      <a class="navbar-brand" href="index">Spring Security</a>
    </div>
	<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="index">Home <span class="sr-only">(current)</span></a></li>
        
      </ul>
      <ul class="nav navbar-nav navbar-right">
      	<li><a href="login">Login</a></li>
      </ul>
    </div>
  </div>
</nav>
<div class="container">
	
	<div class="row">
	<div class="col-md-5 col-md-offset-3" style="padding:1em;box-shadow:0px 0px 2px 0px #000">
		<form:form method="post" action="register" modelAttribute="createUser">
			<div class="login-messages" >
				<h3 class="bg-danger text-danger">${REGISTRATION_ERROR }</h3>
			</div>
			<div class="login-heading">
				<h2>User Registration</h2>
			</div>
			<div class="form-group ">
				<label for="uname">User Name:</label>
				<form:input type="text" path="username" class="form-control" id="uname" placeholder="Enter username" />
			</div>
			<div class="form-group">
				<label for="password">Password:</label>
				<form:input type="password" path="password" class="form-control" id="password" placeholder="Enter Password" />
			</div>
			<input type="submit" class="btn btn-info" value="Register" /><br /><br />
			Click <a href="login" class="text-info">here</a> if you already have Account.
		</form:form>
	</div>
	</div>
</div>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="js/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
</body>
</html>