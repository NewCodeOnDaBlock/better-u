
//========================= API ==============================/

var currentFoodData = "";
var dataCard = document.querySelector("#foodDataList");

function getFood(element){ // Pring to console oninput function

	currentFoodData = element.value;
	console.log(currentFoodData);
}


function makeFoodData(data){ // concatinating data passed in into the browser 
	
	var dataResponse = `	
	
				
								
					<img src="${data.hints[0].food.image}">
								
				<table id="foodDataList">
					<tr>
						<th>Food Name</th>
						<th>Calories</th>
						<th>Protein</th>
						<th>Fat</th>
						<th>Carbs</th>
					</tr>
					<tr>
						<td>${data.hints[0].food.label}</td>
						<td>${data.hints[0].food.nutrients.ENERC_KCAL.toFixed(0)}</td>
					    <td>${data.hints[0].food.nutrients.PROCNT.toFixed(1)}</td>
					    <td>${data.hints[0].food.nutrients.FAT.toFixed(1)} </td>
					    <td>${data.hints[0].food.nutrients.CHOCDF.toFixed(1)}</td>
					</tr>
						<tr>
						<td>${data.hints[1].food.label}</td>
						<td>${data.hints[1].food.nutrients.ENERC_KCAL.toFixed(0)}</td>
					    <td>${data.hints[1].food.nutrients.PROCNT.toFixed(1)}</td>
					    <td>${data.hints[1].food.nutrients.FAT.toFixed(2)} </td>
					    <td>${data.hints[1].food.nutrients.CHOCDF.toFixed(1)}</td>
					</tr>
						<tr>
						<td>${data.hints[2].food.label}</td>
						<td>${data.hints[2].food.nutrients.ENERC_KCAL.toFixed(0)}</td>
					    <td>${data.hints[2].food.nutrients.PROCNT.toFixed(1)}</td>
					    <td>${data.hints[2].food.nutrients.FAT.toFixed(2)} </td>
					    <td>${data.hints[2].food.nutrients.CHOCDF.toFixed(1)}</td>
					</tr>
						<tr>
						<td>${data.hints[3].food.label}</td>
						<td>${data.hints[3].food.nutrients.ENERC_KCAL.toFixed(0)}</td>
					    <td>${data.hints[3].food.nutrients.PROCNT.toFixed(1)}</td>
					    <td>${data.hints[3].food.nutrients.FAT.toFixed(2)} </td>
					    <td>${data.hints[3].food.nutrients.CHOCDF.toFixed(1)}</td>
					</tr>
						<tr>
						<td>${data.hints[4].food.label}</td>
						<td>${data.hints[4].food.nutrients.ENERC_KCAL.toFixed(0)}</td>
					    <td>${data.hints[4].food.nutrients.PROCNT.toFixed(1)}</td>
					    <td>${data.hints[4].food.nutrients.FAT.toFixed(2)} </td>
					    <td>${data.hints[4].food.nutrients.CHOCDF.toFixed(1)}</td>
					</tr>
					</tr>
						<tr>
						<td>${data.hints[5].food.label}</td>
						<td>${data.hints[5].food.nutrients.ENERC_KCAL.toFixed(0)}</td>
					    <td>${data.hints[5].food.nutrients.PROCNT.toFixed(1)}</td>
					    <td>${data.hints[5].food.nutrients.FAT.toFixed(2)} </td>
					    <td>${data.hints[5].food.nutrients.CHOCDF.toFixed(1)}</td>
					</tr>
					
				</table> `
	
	console.log(dataResponse);
	return dataResponse;
}



async function search(){ // FETCHING DATA FROM API 
	
	var response = await fetch ("https://api.edamam.com/api/food-database/v2/parser?app_id=3ad81926&app_key=0889ecdd59b2a58042f8df3d31dfccec&ingr="+ currentFoodData  +"&nutrition-type=cooking");
	var foodData = await response.json();
	console.log(foodData);
	dataCard.innerHTML = makeFoodData(foodData);
	
	}
	




