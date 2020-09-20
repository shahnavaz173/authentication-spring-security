<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
   <meta charset="utf-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <title>Spring Security Authentication</title>

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
        <li><a href="data">Data</a></li>
        
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <c:choose>
			<c:when test="${empty(loginUser)}">
				<li><a href="login">Login</a></li>
				<li><a href="registration">Registration</a></li>
			</c:when>
			<c:otherwise>
        		<li><a href="">${loginUser }</a></li>
				<li><a href="logout">Logout</a></li>
			</c:otherwise>
		</c:choose>
      </ul>
    </div>
  </div>
</nav>

	<div class="container">
		<div class="row">
			<h1>Spring Security Demo Application</h1>
		</div>
	</div>
	
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="js/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
</body>
</html>