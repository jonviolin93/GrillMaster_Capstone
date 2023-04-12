package com.techelevator.model;

import java.util.List;

public class Menu {

    private int id;
    private String name;
    private boolean favorited;
    private List<Food> foodItems;

    public Menu() {
    }

    public Menu(int id, String name, boolean favorited, List<Food> foodItems) {
        this.id = id;
        this.name = name;
        this.favorited = favorited;
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
        return favorited;
    }

    public void setFavorited(boolean favorited) {
        this.favorited = favorited;
    }

    public List<Food> getFoodItems() {
        return foodItems;
    }

    public void setFoodItems(List<Food> foodItems) {
        this.foodItems = foodItems;
    }
}
