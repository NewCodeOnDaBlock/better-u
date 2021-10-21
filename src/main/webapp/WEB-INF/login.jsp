<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link href="https://fonts.googleapis.com/css2?family=Open+Sans&family=Roboto:wght@300&display=swap" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/login.css">
<meta charset="UTF-8">
<title>L O G I N</title>
</head>
<body>

<div class="dashboard-container">


		<div class="left-box">
			<h3>Welcome Back to a Better-U</h3>
			<p><em>"Let's keep up the progress and consistency!"</em></p>
		</div>
	


		<div class="middle-box">
		
		<form:form action="/login" method="post" modelAttribute="newLogin" id="login-form">
        	<div class="form-label-input">
           	 	<label>Email:</label><br>
           		<form:input path="email" class="form-control" /><br>
            	<form:errors path="email" class="text-danger" />
        	</div>
        <div class="form-label-input">
            <label>Password:</label><br>
            <form:password path="password" class="form-control" /><br>
            <form:errors path="password" class="text-danger" />
        </div>
        <button type="submit" class="btn" id="login-btn">Login</button>
    	</form:form>
       	<a href="/">Haven't Registered?</a>	
		</div>
		
	

</div>

<script type="text/javascript" src="javascript/login.js"></script>

</body>
</html>