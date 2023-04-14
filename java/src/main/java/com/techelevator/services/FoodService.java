package com.techelevator.services;

import com.techelevator.model.Food;

import java.util.List;

public interface FoodService {
    List<Food> addFood(String ingredient, String restriction, String category);
}
