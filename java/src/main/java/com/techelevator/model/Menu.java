package com.techelevator.model;

import java.util.List;

public class Menu {

    private int id;
    private boolean isFavorited;
    private List<Food> foodItems;

    public Menu() {
    }

    public Menu(int id, boolean isFavorited, List<Food> foodItems) {
        this.id = id;
        this.isFavorited = isFavorited;
        this.foodItems = foodItems;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isFavorited() {
        return isFavorited;
    }

    public void setFavorited(boolean favorited) {
        isFavorited = favorited;
    }

    public List<Food> getFoodItems() {
        return foodItems;
    }

    public void setFoodItems(List<Food> foodItems) {
        this.foodItems = foodItems;
    }
}
