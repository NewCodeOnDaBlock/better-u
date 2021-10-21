package com.raden.diet_gram.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "foods")
public class Food {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "Food name is required!")
	@Size(min = 3, max = 255, message = "Name must be between 3 or more characters")
	private String foodName;

	@NotEmpty(message = "Calories are required!")
	@Size(min = 8, max = 128, message = "Password must be between 8 and 128 characters")
	private int calorieCount;

	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;

	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

	@NotEmpty(message = "Please select a food.")
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "meals_has_foods", joinColumns = @JoinColumn(name = "food_id"), inverseJoinColumns = @JoinColumn(name = "meal_id"))
	private List<Meal> meals;

	public Food() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public int getCalorieCount() {
		return calorieCount;
	}

	public void setCalorieCount(int calorieCount) {
		this.calorieCount = calorieCount;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Meal> getMeals() {
		return meals;
	}

	public void setMeals(List<Meal> meals) {
		this.meals = meals;
	}

}
