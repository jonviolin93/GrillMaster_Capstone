package com.techelevator.dao;

import com.techelevator.model.Food;

import java.util.List;

public interface FoodDao {

    List<Food> listAllFood();

    Food showFoodItem(int id);

    int addFoodItem(Food food);

}
