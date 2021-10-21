package com.raden.diet_gram.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.raden.diet_gram.models.Meal;


@Repository
public interface MealRepository extends CrudRepository<Meal, Long> {

	List<Meal> findAll();
	
//	@Query("select Meal from meals where meal_type = :mealType")
	List<Meal> findByUserId(long user_id);
	
// Deletes meal by user_id
	@Transactional
	void deleteByUserId(long user_id);
	
	
}
