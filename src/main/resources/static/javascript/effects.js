
let btn = document.querySelector("button");
let registerBtn = document.querySelector("#reg-btn");
let logMealBtn = document.querySelector(".logmeal-btn");
let addMealBtn = document.querySelector(".addmeal-btn");
let dashboardContainer = document.querySelector("body");
let mouseDown = true;

document.querySelector(".logmeal-btn").addEventListener("mousedown", () => {
	
	logMealBtn.classList.add("button-down-effect");
	
})

document.querySelector(".logmeal-btn").addEventListener("mouseup", () => {
	
	logMealBtn.classList.remove("button-down-effect");
	
})

document.querySelector(".logmeal-btn").addEventListener("click", () => {
	
	const mealPopUp = document.querySelector(".form-container");

	mealPopUp.classList.add("active");
	document.querySelector("#overlay").style.display = "block";
})

document.querySelector("#overlay").addEventListener("click", () => {
	
	const mealPopUp = document.querySelector(".form-container");

	mealPopUp.classList.remove("active");
	document.querySelector("#overlay").style.display = "none";
})



document.querySelector(".addmeal-btn").addEventListener("mousedown", () => {
	
	addMealBtn.classList.add("button-down-effect");
	
})

document.querySelector(".addmeal-btn").addEventListener("mouseup", () => {
	
	addMealBtn.classList.remove("button-down-effect");
	
})

document.querySelector(".addmeal-btn").addEventListener("click", () => {

	addMealBtn.innerHTML = "Added!"
	mealPopUp.classList.remove("active");
	
})

document.querySelector(".add-task-container").addEventListener("click",()=>{

	document.querySelector(".taskform-container").style.display = "block";
	document.querySelector(".left-arrow").style.display = "block";
})

document.querySelector(".left-arrow").addEventListener("click",()=>{

	document.querySelector(".taskform-container").style.display = "none";
	document.querySelector(".left-arrow").style.display = "none";
})



document.querySelector(".addmeal-btn").addEventListener("click", () => {

	addMealBtn.innerHTML = "Added!";
	
})


var taskContent = document.querySelectorAll("#task-content");
var editTask = document.querySelectorAll("#edit-taskform-container");
var editTaskbtn = document.querySelectorAll(".edit-arrow");

for(let i = 0; i < taskContent.length; i ++){
    taskContent[i].addEventListener("click",()=>{
	   	editTask[i].style.display ="block";
	   	editTaskbtn[i].style.display="block";
    })
    	editTaskbtn[i].addEventListener("click", ()=>{
		editTask[i].style.display ="none";
	   	editTaskbtn[i].style.display="none";
})
};




/*======================== TIMER JS ====================*/



let fastingUpdates = document.querySelector(".fasting-updates")
let displayHours = document.querySelector("#displayHours");
let displayMinutes = document.querySelector("#displayMinutes");
let displaySeconds = document.querySelector("#displaySeconds");
let startBtn = document.querySelector(".start-btn");
let stopBtn = document.querySelector(".stop-btn");
let resetBtn = document.querySelector(".reset-btn");
 
let myTimer;
let myHours = 0;
let myMinutes = 0;
let mySeconds = 0;
let myCounter = 0;

stopBtn.disabled = true;

startBtn.addEventListener("click",function(){
	
	stopBtn.disabled = false;
	startBtn.disabled = true;
	resetBtn.disabled = false;
	startBtn.style.display = "none";
	stopBtn.style.display = "block";
	resetBtn.style.display = "none";
	fastingUpdates.innerHTML = 'YOUR FAST HAS BEGUN!';

	
	myTimer = setInterval (function(){
		
		myCounter ++;
		mySeconds = myCounter;
		
		
		// STARTS COUNTING SECONDS
		if(mySeconds > 59){
			
			displaySeconds.innerHTML = '00';
			myCounter = 0;
			myMinutes++;
			
			
		} else if (mySeconds > 9){
			
			
			displaySeconds.innerHTML = mySeconds;
			
		} else {
			 
			displaySeconds.innerHTML = '0' + mySeconds;
		}
		
		// STARTS COUNTING MINUTES
		if (myMinutes > 59){
			
			displaySeconds.innerHTML = '00';
			myMinutes = 0;
			myHours++;
			
			
		} else if (myMinutes > 9){
			
			displayMinutes.innerHTML = myMinutes;
			
			
		} else {
			
			displayMinutes.innerHTML = '0' + myMinutes;
			
		}
		
		// STARTS COUNTING HOURS
		
	
		if (myHours == 16){
			
			fastingUpdates.innerHTML = 'YOU\'RE IN FAT BURNING MODE!';
		}
		else if (myHours == 18){
			
			fastingUpdates.innerHTML = 'YOU\'RE NOW IN KETOSIS';

		}
		else if (myHours == 22){
			
			fastingUpdates.innerHTML = 'AUTOPHAGY HAS BEGUN';

		}
		else if (myHours > 23){
			
			clearInterval(myTimer);
			displayHours.innerHTML = '24';
			fastingUpdates.innerHTML = 'YOU\'RE A WARRIOR!';
		
			
		} 
		else if (myMinutes > 9){
			
			displayHours.innerHTML = myHours;
			
			
		} else {
			
			displayHours.innerHTML = '0' + myHours;
			
		}
		
	}, 1)
	
})


stopBtn.addEventListener("click",()=>{
	
	clearInterval(myTimer);
	startBtn.style.display = "block";
	resetBtn.style.display = "block";
	stopBtn.style.display = "none";
	fastingUpdates.innerHTML = 'FAST PAUSED';
	stopBtn.disabled = true;
	startBtn.disabled = false;
	
	
})

resetBtn.addEventListener("click",()=>{
	
	startBtn.disabled = false;
	stopBtn.disabled = true;
	resetBtn.disabled = true;
	startBtn.style.display = "block";
	stopBtn.style.display = "none";
	resetBtn.style.display = "none";
	fastingUpdates.innerHTML = 'BEGIN YOUR FAST';

	clearInterval(myTimer);
	displaySeconds.innerHTML = '00';
	displayMinutes.innerHTML = '00';
	displayHours.innerHTML = '00';
	myHours = 0;
	myMinutes = 0;
	mySeconds = 0;
	myCounter = 0;
	
	
})









