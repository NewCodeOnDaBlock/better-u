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
<link rel="stylesheet" type="text/css" href="/css/summary.css">
<meta charset="UTF-8">
<title>S U M M A R Y</title>
</head>
<body>

<div class="dashboard-container">
<!--------------- LEFT BOX ------------------------->



		<div class="left-box">
			<div class="leftoftopbar">
				<h2>Hey! <c:out value="${ loggedUser.name }"></c:out></h2>
				<p>Here's Todays Summary!</p>
			</div>

		
		<div class="finished-task-container">
			<h3>Completed tasks for the day</h3>
		<div class="task-list">
			<ul class="task-ul">
				
				<c:forEach var="task" items="${tasks }">
					<c:if test="${ task.user.id == loggedUser.id && task.finished}">
	
					<li class="task-li">
						<div class="task-content">
							<p>
								<c:out value="${task.taskContent }"/>
							</p>
						</div>
					</li>
					</c:if>	
				
				</c:forEach>								
				</ul>
			</div>						
		</div>
</div>


		
<!--------------- RIGHT BOX ------------------------->

		<div class="right-box">
		

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
			
			<div class="cal-summary-container">		
					<div class="table-header-container">
						<h3>Total Calories For Breakfast: 
							<c:out value="${ bfastCalTotal}"/>
						</h3>
					</div>	

												
				<table id="breakfast-table">	
					<tr>
						<th>Food Name:</th>
						<th>Calories:</th>
					</tr>							
					<c:forEach var="meal" items="${meals }">
						<c:forEach var="food" items="${foods }">
							<c:if test="${ meal.mealType == 'Breakfast' }">
						<tr>
							<td>
							 	<c:out value="${food.foodName }"/> 
							</td>
								<td>
								<c:out value="${food.calorieCount }"/>
							</td>
						</tr>
							</c:if>
						</c:forEach>
					</c:forEach>			 		 							
				</table>		
				
					<div class="table-header-container">
						<h3>Total Calories For Lunch: 
							<c:out value="${ lunchCalTotal}"/>
						</h3>
					</div>	
												
				<table id="lunch-table">	
					<tr>
						<th>Food Name:</th>
						<th>Calories:</th>
					</tr>							
					<c:forEach var="meal" items="${meals }">
						<c:forEach var="food" items="${foods }">
							<c:if test="${ meal.mealType == 'Lunch' }">
						<tr>
							<td>
							 	<c:out value="${food.foodName }"/> 
							</td>
								<td>
								<c:out value="${food.calorieCount }"/>
							</td>
						</tr>
							</c:if>
						</c:forEach>
					</c:forEach>			 		 							
				</table>
				
					<div class="table-header-container">
						<h3>Total Calories For Dinner: 
							<c:out value="${ dinnerCalTotal}"/>
						</h3>
					</div>	
												
				<table id="lunch-table">	
					<tr>
						<th>Food Name:</th>
						<th>Calories:</th>
					</tr>							
					<c:forEach var="meal" items="${meals }">
						<c:forEach var="food" items="${foods }">
							<c:if test="${ meal.mealType == 'Dinner' }">
						<tr>
							<td>
							 	<c:out value="${food.foodName }"/> 
							</td>
								<td>
								<c:out value="${food.calorieCount }"/>
							</td>
						</tr>
							</c:if>
						</c:forEach>
					</c:forEach>			 		 							
				</table>
				
				<div class="table-header-container">
						<h3>Total Calories For Snack: 
							<c:out value="${ snackCalTotal}"/>
						</h3>
					</div>	
				
					<table id="snack-table">	
					<tr>
						<th>Food Name:</th>
						<th>Calories:</th>
					</tr>							
					<c:forEach var="meal" items="${meals }">
						<c:forEach var="food" items="${foods }">
							<c:if test="${ meal.mealType == 'Snack' }">
						<tr>
							<td>
							 	<c:out value="${food.foodName }"/> 
							</td>
								<td>
								<c:out value="${food.calorieCount }"/>
							</td>
						</tr>
							</c:if>
						</c:forEach>
					</c:forEach>			 		 							
				</table>	
					
				
				
					
									
			</div>			
		</div>		
	</div>

<script type="text/javascript" src="javascript/effects.js"></script>
</body>
</html>
