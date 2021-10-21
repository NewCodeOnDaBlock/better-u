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
<link rel="stylesheet" type="text/css" href="css/registration.css">
<head>
<meta charset="UTF-8">
<title>R E G I S T E R</title>
</head>
<body>

<div class="dashboard-container">

<!--------------- LEFT BOX ------------------------->


		<div class="left-box">
		<h3>Welcome to Better-U</h3>
		<p><em>""It's not just another fitness App..<br>
		 it's a better U!"</em></p>


		</div>
	
<!--------------- MIDDLE BOX ------------------------->


		<div class="middle-box">
		
			 <form:form action="/register" method="post" modelAttribute="newUser" id="register-form">
        		<div class="form-label-input">
            		<label>Name:</label><br>
            		<form:input path="name" class="form-control" />
            		<form:errors path="name" class="text-danger" />
        		</div>
        		<div class="form-label-input">
            		<label>Email:</label><br>
            		<form:input path="email" class="form-control" />
            		<form:errors path="email" class="text-danger" />
        		</div>
        		<div class="form-label-input">
            		<label>Password:</label><br>
            		<form:password path="password" class="form-control" />
            		<form:errors path="password" class="text-danger" />
        		</div>
        			<div class="form-label-input"><br>
            		<label>Confirm Password:</label><br>
            		<form:password path="confirm" class="form-control" />
            		<form:errors path="confirm" class="text-danger" />
        		</div>
        			<button type="submit" class="btn" id="reg-btn">Register</button>
    		</form:form>
    		<a href="/login">Already Registered?</a>
		
		
		
		</div>
		
<!--------------- RIGHT BOX ------------------------->

	

</div>

<script type="text/javascript" src="javascript/register.js"></script>

</body>
</html>