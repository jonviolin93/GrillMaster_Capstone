package com.techelevator.model;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Cookout {
    private int id;
    @NotBlank(message = "Name must not be blank")
    private String name;
    //TODO: add validators to date and time
    private LocalDate date;
    private LocalTime time;
    @NotBlank(message = "Must include location")
    private String location;
    private String description;
    private List<User> attendees;
    private int menuId;
    private boolean read;

    public Cookout() {
    }

    public Cookout(int id, String name, LocalDate date, LocalTime time, String location, String description, List<User> attendees, int menuId) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.time = time;
        this.location = location;
        this.description = description;
        this.attendees = attendees;
        this.menuId = menuId;
    }

    public Cookout(int id, String name, LocalDate date, LocalTime time, String location, String description, List<User> attendees, int menuId, boolean read) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.time = time;
        this.location = location;
        this.description = description;
        this.attendees = attendees;
        this.menuId = menuId;
        this.read = read;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<User> getAttendees() {
        return attendees;
    }

    public void setAttendees(List<User> attendees) {
        this.attendees = attendees;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }
}
