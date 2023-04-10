package com.techelevator.model;

import java.time.LocalTime;
import java.util.List;

public class Order {
    private int id;
    private int userId;
    private boolean isComplete;
    private List<Food> foodList;
    private LocalTime time;

    public Order() {
    }

    public Order(int id, int userId, boolean isComplete, List<Food> foodList, LocalTime time) {
        this.id = id;
        this.userId = userId;
        this.isComplete = isComplete;
        this.foodList = foodList;
        this.time = time;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }

    public List<Food> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
    }
}
