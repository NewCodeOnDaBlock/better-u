package com.raden.diet_gram.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raden.diet_gram.models.Food;
import com.raden.diet_gram.repositories.FoodRepository;

@Service
public class FoodService {
	
	@Autowired
	private FoodRepository foodRepository;
	
	public List<Food> allFoods() { 
		return foodRepository.findAll();
	}

	
	public Food createFood(Food food) { 
		return foodRepository.save(food);
	}
	
	public Food findFoodById(Long id) { 
		Optional<Food> foodByID = foodRepository.findById(id);
		if (foodByID.isPresent()) {
			return foodByID.get();
		} else {
			return null;
		}
	}
	
	
	 
	public List<Food> searchFood(String search) { 
		List<Food> food = foodRepository.findByFoodNameContaining(search);
 		return food;
	}
	


	public Food updateFood(Food food) { 
		return foodRepository.save(food);
	}
	
	

	public void deleteFood(Long id) { 
		foodRepository.deleteById(id);
	}
	
	
		

}
