<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link href="https://fonts.googleapis.com/css2?family=Open+Sans&family=Roboto:wght@300&display=swap" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/css/food.css">
<meta charset="UTF-8">
<title>F O O D S</title>
</head>
<body>

<div class="dashboard-container">
	
	<div class="left-box">
	</div>

	
<!--------------- MIDDLE BOX ------------------------->


		<div class="middle-box">
	
			<h3>Curious About Your Food Macros?</h3>
			<input type="text" oninput="getFood(this)" name="getFood" class="food-input">
			<button class="logmeal-btn" onclick="search()">Search</button>

				<table id="foodDataList">
					<tr>
						<th>Food Name</th>
						<th>Calories</th>
						<th>Protein</th>
						<th>Fat</th>
						<th>Carbs</th>
					</tr>
					<tr>
						<td><span>    </span></td>
						<td><span>    </span></td>
						<td><span>    </span></td>
						<td><span>    </span></td>
						<td><span>    </span></td>
					</tr>
					<tr>
						<td><span>    </span></td>
						<td><span>    </span></td>
						<td><span>    </span></td>
						<td><span>    </span></td>
						<td><span>    </span></td>
					</tr>
					<tr>
						<td><span>    </span></td>
						<td><span>    </span></td>
						<td><span>    </span></td>
						<td><span>    </span></td>
						<td><span>    </span></td>
					</tr>
					<tr>
						<td><span>    </span></td>
						<td><span>    </span></td>
						<td><span>    </span></td>
						<td><span>    </span></td>
						<td><span>    </span></td>
					</tr>
					<tr>
						<td><span>    </span></td>
						<td><span>    </span></td>
						<td><span>    </span></td>
						<td><span>    </span></td>
						<td><span>    </span></td>
					</tr>
					
				</table>
		
		

		</div>
		
<!--------------- RIGHT BOX ------------------------->

		<div class="right-box">
		
<!----------------------- NAV BAR --------------------------->


			<div class="nav-container">
				<a href="/dashboard">
					<button class="nav-btn">Home</button>
				</a>
				<a href="/todays/summary">
					<button id="settings-btn" class="nav-btn">Today</button>
				</a>
				<a href="/food/data">
					<button id="settings-btn" class="nav-btn">Food</button>
				</a>
				<a href="/logout">
					<button class="nav-btn">Logout</button>
				</a>
			</div>	
		</div>
		<!--------------------- FOOD DATABASE ------------------------- -->	
				
</div>

<script type="text/javascript" src="/javascript/api.js"></script>
<script type="text/javascript" src="/javascript/effects.js"></script>
</body>
</html>