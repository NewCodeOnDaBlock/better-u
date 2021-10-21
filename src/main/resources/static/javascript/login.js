document.querySelector("#login-btn").addEventListener("mousedown", () => {
	
	document.querySelector("#login-btn").classList.add("button-down-effect");
	
})

document.querySelector("#login-btn").addEventListener("mouseup", () => {
	
	document.querySelector("#login-btn").classList.remove("button-down-effect");
	
})