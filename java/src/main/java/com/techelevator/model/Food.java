package com.techelevator.model;

public class Food {

    private int id;
    private String name;
    private String img;
    private String category;
    private int quantity;
    private String addedBy;

    public Food() {
    }

    public Food(int id, String name, String img, String category, String addedBy) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.category = category;
        this.addedBy = addedBy;
    }

    public Food(int id, String name, String img, String category) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.category = category;
    }

    public Food(int id, String name, String img, String category, int quantity) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.category = category;
        this.quantity = quantity;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(String addedBy) {
        this.addedBy = addedBy;
    }
}
