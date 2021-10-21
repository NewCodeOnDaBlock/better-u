package com.raden.diet_gram.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.raden.diet_gram.models.Food;
import com.raden.diet_gram.models.Meal;
import com.raden.diet_gram.models.Task;
import com.raden.diet_gram.models.User;
import com.raden.diet_gram.services.FoodService;
import com.raden.diet_gram.services.MealService;
import com.raden.diet_gram.services.TaskService;
import com.raden.diet_gram.services.UserService;

@Controller
public class DashboardController {

	@Autowired
	public UserService userService;

	@Autowired
	public TaskService taskService;

	@Autowired
	public MealService mealService;

	@Autowired
	public FoodService foodService;

	// ===================== RENDER MAIN DASHBOARD ================//

	@RequestMapping("/dashboard")
	public String renderDashboard(@ModelAttribute("task") Task task, @ModelAttribute("meal") Meal meal,
			HttpSession session, Model model) {
		Long userId = (Long) session.getAttribute("user_id");
		Task taskById = taskService.findTaskById(userId);

		if (userId == null) {

			return "redirect:/";

		} else {

			ArrayList<Task> tasks = (ArrayList<Task>) taskService.allTasks();
			ArrayList<Food> foods = (ArrayList<Food>) foodService.allFoods();
			User loggedUser = userService.findUserById(userId);
			model.addAttribute("tasks", tasks);
			model.addAttribute("loggedUser", loggedUser);
			model.addAttribute("foods", foods);
			model.addAttribute("taskById", taskById);

//	
//			LocalTime midNight = LocalTime.of(00,00,00);
//			LocalTime timeOfDay = LocalTime.now();
//			
//			if (timeOfDay == midNight) {
//				System.out.println("byebyemeals");
//				mealService.deleteMealbyUserId(userId);
//			}

			// LOOPING THROUGH AN ARRAYLIST OF MEALS
			// YUM & FOOD BEING THE ITERATOR
			// ADDING FROM DECLARED VARIABLES FROM CALLING ON THE GETTERS OF EACH MODEL
			// LOOPS THROUGH AND LOOKS FOR FOOD IN MEALS ARRAY

			ArrayList<Meal> meals = (ArrayList<Meal>) mealService.findMealByUserId(userId);
			double maxDailyCalTotal = loggedUser.getMaxCalories();
			double bfastCalTotal = 0;
			double lunchCalTotal = 0;
			double dinnerCalTotal = 0;
			double snacksCalTotal = 0;

			for (Meal yum : meals) {
				for (Food food : yum.getFoods()) {
					if (yum.getMealType().equals("Breakfast")) {
						bfastCalTotal += food.getCalorieCount();
					} else if (yum.getMealType().equals("Lunch")) {
						lunchCalTotal += food.getCalorieCount();
					} else if (yum.getMealType().equals("Dinner")) {
						dinnerCalTotal += food.getCalorieCount();
					} else if (yum.getMealType().equals("Snack")) {
						snacksCalTotal += food.getCalorieCount();
					}
				}
			}

			model.addAttribute("bfastCalTotal", (int) bfastCalTotal);
			model.addAttribute("lunchCalTotal", (int) lunchCalTotal);
			model.addAttribute("dinnerCalTotal", (int) dinnerCalTotal);
			model.addAttribute("snacksCalTotal", (int) snacksCalTotal);
			model.addAttribute("totalCalsOfDay",
					(int) bfastCalTotal + (int) lunchCalTotal + (int) dinnerCalTotal + (int) snacksCalTotal);
			model.addAttribute("caloriesLeftOfDay", (int) maxDailyCalTotal - (int) bfastCalTotal - (int) lunchCalTotal
					- (int) dinnerCalTotal - (int) snacksCalTotal);
		}

		return "dashboard.jsp";
	}

	/* ========================= CREATE TASK ================================ */

	@RequestMapping(value = "/create/task", method = RequestMethod.POST)
	public String createNewTask(@Valid @ModelAttribute("task") Task task, BindingResult result) {

		if (result.hasErrors()) {

			return "dashboard.jsp";
		}

		taskService.createTask(task);
		return "redirect:/dashboard";
	}

	// ============================ UPDATE TASK ==============================//

	@RequestMapping(value = "/update/task/{id}", method = RequestMethod.PUT)
	public String editTask(@Valid @ModelAttribute("task") Task task, BindingResult result) {
		if (result.hasErrors()) {

			return "dashboard.jsp";
		}
		taskService.updateTask(task);
		return "redirect:/dashboard";
	}

	// ================== SAVE AND FINISH TASK ==================//

	@RequestMapping(value = "/finish/task/{id}", method = RequestMethod.POST)
	public String finishTask(@PathVariable("id") Long id) {

		taskService.updateFinish(id, true);
		return "redirect:/dashboard";
	}

	// ===================== DELETE TASK ======================//

	@RequestMapping(value = "/delete/task/{id}", method = RequestMethod.DELETE)
	public String deleteTask(@PathVariable("id") Long id) {

		taskService.deleteTask(id);
		return "redirect:/dashboard";
	}

	// ===================== CREATE MEAL ======================//

	@RequestMapping(value = "/create/meal", method = RequestMethod.POST)
	public String createMeal(@Valid @ModelAttribute("meal") Meal meal, BindingResult result) {

		if (result.hasErrors()) {

			return "dashboard.jsp";
		}

		mealService.createMeal(meal);
		return "redirect:/dashboard";
	}

// ======================== RENDER SETTINGS PAGES =======================//

//	@RequestMapping("/user/settings/{id}")
//	public String renderSettingsPage(@PathVariable("id")Long id,  @ModelAttribute("user") User user, HttpSession session, Model model) {
//		 Long userId  = (Long) session.getAttribute("user_id");
//		   	
//		   if(userId != id) {
//		   		
//		   		return "redirect:/";
//		   
//		   } else {
//
//	        User userById = userService.findUserById(id);
//	        model.addAttribute("user", userById);
//	        return "editinfo.jsp";
//		   }
//	    }
//	   
//	
//// ==================== EDIT USER INFO ============================//	
//	
//	   @RequestMapping(value="/edit/user/{id}", method=RequestMethod.PUT)
//	    public String renderEditUserPage(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
//		Long userId  = (Long) session.getAttribute("user_id");
//		
//		if(!user.getPassword().equals(user.getConfirm())) {
//            result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
//		}
//		if (result.hasErrors()) {
//		      return "editinfo.jsp";
//       	} else {
//       		
//       			
//       		user.setId(userId);
//       	
//       		userService.updateUser(user);
//           return "redirect:/dashboard";
//       }		   
//	
//}
//   

//========================== RENDER FOOD PAGE ===========================//

	@RequestMapping("/food/data")
	public String renderFoodDataPage(HttpSession session, Model model) {
		Long userId = (Long) session.getAttribute("user_id");

		if (userId == null) {

			return "redirect:/";

		} else {

			User loggedUser = userService.findUserById(userId);
			model.addAttribute("loggedUser", loggedUser);
			return "food.jsp";
		}
	}

// ======================= RENDER SUMMARY PAGE ======================== //

	@RequestMapping("/todays/summary")
	public String renderTodaysSummary(HttpSession session, Model model) {
		Long userId = (Long) session.getAttribute("user_id");

		if (userId == null) {

			return "redirect:/";

		} else {

			ArrayList<Meal> meals = (ArrayList<Meal>) mealService.findMealByUserId(userId);
			Meal mealIds = mealService.findMealById(userId);
			Food foodIds = foodService.findFoodById(userId);
			ArrayList<Food> foods = (ArrayList<Food>) foodService.allFoods();
			ArrayList<Task> tasks = (ArrayList<Task>) taskService.allTasks();
			User loggedUser = userService.findUserById(userId);

			model.addAttribute("loggedUser", loggedUser);
			model.addAttribute("tasks", tasks);
			model.addAttribute("foods", foods);
			model.addAttribute("meals", meals);
			model.addAttribute("foodIds", foodIds);
			model.addAttribute("mealIds", mealIds);

			double maxDailyCalTotal = loggedUser.getMaxCalories();
			double bfastCalTotal = 0;
			double lunchCalTotal = 0;
			double dinnerCalTotal = 0;
			double snacksCalTotal = 0;

			for (Meal yum : meals) {
				for (Food food : yum.getFoods()) {
					if (yum.getMealType().equals("Breakfast")) {
						bfastCalTotal += food.getCalorieCount();
					} else if (yum.getMealType().equals("Lunch")) {
						lunchCalTotal += food.getCalorieCount();
					} else if (yum.getMealType().equals("Dinner")) {
						dinnerCalTotal += food.getCalorieCount();
					} else if (yum.getMealType().equals("Snack")) {
						snacksCalTotal += food.getCalorieCount();
					}
				}
			}

			model.addAttribute("bfastCalTotal", (int) bfastCalTotal);
			model.addAttribute("lunchCalTotal", (int) lunchCalTotal);
			model.addAttribute("dinnerCalTotal", (int) dinnerCalTotal);
			model.addAttribute("snacksCalTotal", (int) snacksCalTotal);
			model.addAttribute("totalCalsOfDay",
					(int) bfastCalTotal + (int) lunchCalTotal + (int) dinnerCalTotal + (int) snacksCalTotal);
			model.addAttribute("caloriesLeftOfDay", (int) maxDailyCalTotal - (int) bfastCalTotal - (int) lunchCalTotal
					- (int) dinnerCalTotal - (int) snacksCalTotal);

		}
		return "summary.jsp";
	}

	// =========================== DELETE ALL MEALS TO RESET CALORIES BACK TO ZERO =====================//

	@RequestMapping(value = "/delete/meal/all", method = RequestMethod.DELETE)
	public String deleteMeals(HttpSession session) {
		Long userId = (Long) session.getAttribute("user_id");

		mealService.deleteMealsbyUserId(userId);

		return "redirect:/dashboard";
	}

}
