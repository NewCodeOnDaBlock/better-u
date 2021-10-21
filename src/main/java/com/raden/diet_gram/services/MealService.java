package com.raden.diet_gram.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raden.diet_gram.models.Meal;
import com.raden.diet_gram.repositories.MealRepository;

@Service
public class MealService {
	
	@Autowired
	private MealRepository mealRepository;
	
	public List<Meal> allMeals() { 
		return mealRepository.findAll();
	}

	
	public Meal createMeal(Meal meal) { 
		return mealRepository.save(meal);
	}
	
	public Meal findMealById(Long id) { 
		Optional<Meal> mealByID = mealRepository.findById(id);
		if (mealByID.isPresent()) {
			return mealByID.get();
		} else {
			return null;
		}
	}
	
	public Meal updateMeal(Meal meal) { 
		return mealRepository.save(meal);
	}
	
	public void deleteMealsbyUserId(Long user_id) {
		mealRepository.deleteByUserId(user_id);
	}

	public void deleteMeal(Long id) { 
		mealRepository.deleteById(id);
	}
	
	public List<Meal> findMealByUserId(Long user_id){
		return mealRepository.findByUserId(user_id);
	}
	
	

}
