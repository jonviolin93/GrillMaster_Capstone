package com.techelevator.model;

import java.util.List;

public class Menu {

    private int id;
    private String name;
    private boolean isFavorited;
    private List<Food> foodItems;

    public Menu() {
    }

    public Menu(int id, String name, boolean isFavorited, List<Food> foodItems) {
        this.id = id;
        this.name = name;
        this.isFavorited = isFavorited;
        this.foodItems = foodItems;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
