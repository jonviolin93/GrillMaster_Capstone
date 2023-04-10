package com.techelevator.dao;

import com.techelevator.model.Food;

import java.util.List;

public interface FoodDao {

    Food showFoodItem(int id);

    Food addFoodItem(Food food);

    Food updateFoodItem(Food food);

    List<Food> listAllFood();
}
