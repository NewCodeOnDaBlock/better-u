package com.raden.diet_gram.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.raden.diet_gram.models.Food;

@Repository
public interface FoodRepository extends CrudRepository<Food, Long> {

	List<Food> findAll();
	List<Food> findByFoodNameContaining(String search);
	
}
