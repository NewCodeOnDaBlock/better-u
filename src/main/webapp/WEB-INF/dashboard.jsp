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
<link rel="stylesheet" type="text/css" href="css/dashboard.css">
<meta charset="UTF-8">
<title>D A S H B O A R D</title>
</head>
<body>

<!--------------- DASHBOARD CONTAINER ------------------------->

<div id="overlay"></div>
<div class="dashboard-container">
<!--------------- LEFT BOX ------------------------->



		<div class="left-box">
			<div class="leftoftopbar">
				<h2>Hey! <c:out value="${ loggedUser.name }"></c:out></h2>
				<p>Let's get your day started!</p>
			</div>
<!----------------ACCOUNTABILITY TASK TITLE --------->

 		<h3 class="set-task">Set Tasks</h3>


<!------------ TASK BAR LIST ------------------------->

		<div class="task-container">
			<div class="task-list">
				<ul class="task-ul">
				
				<c:forEach var="task" items="${tasks }">
					<c:if test="${ task.user.id == loggedUser.id && !task.finished}">
					
	<!------------- ONE TASK LIST BOX -------------------------->
	
					<li class="task-li">
						<div class="task-li-box">
						
	  <!-- -------------- FINISHED TASK --------------------- -->
	    				
	  						<form:form action="/finish/task/${task.id }" method="post">																					
							    	<button type="submit" id="closemark">	
										<img class="task-icon" id="checkmark" src="images/checkmark.png">
									</button>									
							</form:form>
	
							
		<!-- -------------- DELETE TASK FORM ------------->
							<form action="/delete/task/${task.id }" method="post">
							 	<input type="hidden" name="_method" value="delete">
							    	<button type="submit" id="closemark">
										<img class="task-icon" id="closemark" src="images/closemark.png">
									</button>
							</form>	
						</div>
						
						
						<div id="task-content">
							<p>
								<c:out value="${task.taskContent }"/>
							</p>
						</div>
							
							<form:form action="/update/task/${task.id}" method="post" modelAttribute="task" id="edit-taskform-container">
								<input type="hidden" name="_method" value="put">
								<form:hidden path = "user" value = "${user_id}" />
								<form:errors path="user"/>
								<div class="form-label-input">
									<form:errors path="taskContent"/>
									<form:input path="taskContent"/>
									<input class="addtask-btn" type="submit" value="Update"/>
									<img class="edit-arrow" src="/images/leftarrow.png">
								</div>
							</form:form>			
						</li>
					</c:if>	
				</c:forEach>								
				</ul>
			</div>				
		</div>
		
<!------------------ ADD TASK CONTAINER ------------------>

			<div class="add-task-container">
					<h3>Add Task</h3>
					<img class="add-task-icon" src="/images/plusmark.png">	
			</div>
			
		</div>
		
<!------------------- ADD TASK POP UP -------------------->

	<div class="task-popup" id="addtask-form">
	
		<form:form action="/create/task" method="post" modelAttribute="task" class="taskform-container">
		<form:hidden path = "user" value = "${user_id}" />
		
		<form:errors path="user"/>
			<div class="form-label-input">
				<form:errors path="taskContent"/>
				<form:input path="taskContent"/>
				<input class="addtask-btn" type="submit" value="Add Task"/>
				<img class="left-arrow" src="/images/leftarrow.png">
			</div>
		</form:form>	
	</div>
		

	
<!--------------- MIDDLE BOX ------------------------->


		<div class="middle-box">
			<div class="timer-container">
			
			
				<h4 class="fasting-updates">BEGIN YOUR FAST</h4>	
					<h3>
						<span id="displayHours">00</span>:<span id="displayMinutes">00</span>:<span id="displaySeconds">00</span>
					</h3>
			<div class="fastbtn-container">
				<button class="start-btn">Start</button>
				<button class="stop-btn">Stop</button>
				<button class="reset-btn">Reset</button>
			</div>	
		</div>
			
			
			<div class="caloriedisplay-container">
				<h2 class="calorie-main">Calories <br>Consumed</h2>
				<h1 class="calories-current"><c:out value="${totalCalsOfDay }"></c:out></h1>
				<div class="calories-left">
					<h3>Left</h3>
					<p class="cals-left"><c:out value="${caloriesLeftOfDay }"></c:out></p>
				</div>				
			</div>
			
			<div class="btn-container">
				<button class="logmeal-btn">Add Food</button>
			</div>

			<form action="/delete/meal/all" method="post">
    			<input type="hidden" name="_method" value="delete">
    			<input class="btn-reset" type="submit" value="Reset Calories">
			</form>
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
		<!--------------------- FOOD DATABASE ------------------------- -->	
			
			<div class="mealtype-container">
				<div class="food-container">
					<div class="task-list">
						<ul class="task-ul">
						<c:forEach var="food" items="${foods}">
							<li class="food-li">
							
								<div class="food-content">
									<p>
										<c:out value="${food.foodName }"/><br>
									</p>
									<p>
										<c:out value="${food.calorieCount }"/> Calories
									</p>
								</div>
							</li>
							</c:forEach>
						</ul>
					</div>
				</div>				
			</div>
				
				
				</div>	
					<h3 class="breakfast-title">
						<a href="#">Breakfast</a>
					</h3>
			
					<h4 class="breakfast-calories">
						<c:out value="${bfastCalTotal }"/>
					</h4>
				
					<h3 class="lunch-title">
						<a href="#">Lunch</a>
					</h3>
					<h4 class="lunch-calories">
						<c:out value="${ lunchCalTotal}"></c:out>
					</h4>
			
					<h3 class="feast-title">
						<a href="#">Dinner</a>
					</h3>
					<h4 class="feast-calories">
						<c:out value="${dinnerCalTotal }"></c:out>
					</h4>
					
					<h3 class="snack-title">
						<a href="#">Snack</a>
					</h3>
						<h4 class="snack-calories">
							<c:out value="${snacksCalTotal }"></c:out>
						</h4>
			</div>
		
		

<!-------------------  ADD MEAL POP UP FORM  ---------->

	<div class="meal-popup" id="addMeal-form">
		<form:form action="/create/meal" class="form-container" modelAttribute="meal">   
			<form:hidden path = "user" value = "${user_id}" />
			

	
			<h3>Log Food</h3><br>
			<form:label path="foods">Food</form:label>	
			<form:errors path="foods"/>	
			
			<form:select path="foods" id="food-select">
					<c:forEach var="food" items="${foods }">
						<form:option value="${ food.id}">
						 	<c:out value="${food.foodName } ${food.calorieCount }"/> 
						</form:option>
					</c:forEach>
			</form:select>
				
		
			<form:label path="mealType">Meal Type</form:label>
			<form:select path="mealType">
					<form:option value="Breakfast">Breakfast</form:option>
					<form:option value="Lunch">Lunch</form:option>
					<form:option value="Dinner">Dinner</form:option>
					<form:option value="Snack">Snack</form:option>
			</form:select>
			
			<button class="addmeal-btn" type="submit">Add Food</button>
		</form:form>
		
	</div>
	


<script type="text/javascript" src="javascript/effects.js"></script>
</body>
</html>