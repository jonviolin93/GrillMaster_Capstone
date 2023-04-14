package com.techelevator.controller;

import com.techelevator.dao.FoodDao;
import com.techelevator.model.Food;
import com.techelevator.services.FoodService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
@RequestMapping("/food")
public class FoodController {
    private FoodDao foodDao;
    private FoodService foodService;

    public FoodController(FoodDao foodDao, FoodService foodService) { //TODO Reinsert FoodService here
        this.foodDao = foodDao;
        this.foodService = foodService;
    }

    public List<Food> listFood (@RequestParam(defaultValue = "") String ingredient,
                                @RequestParam(defaultValue = "") String restriction,
                                @RequestParam(defaultValue = "fast-foods") String category){
        List<Food> foodList =foodService.addFood(ingredient, restriction, category);
        return foodList;
    }
}
