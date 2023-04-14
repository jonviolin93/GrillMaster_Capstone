package com.techelevator.controller;

import com.techelevator.dao.FoodDao;
import com.techelevator.model.Food;
import com.techelevator.services.FoodService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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

    public FoodController(FoodDao foodDao, FoodService foodService) {
        this.foodDao = foodDao;
        this.foodService = foodService;
    }

    @RequestMapping(path="", method = RequestMethod.GET)
    public List<Food> listFood (@RequestParam(defaultValue = "", name = "ingr") String ingredient,
                                @RequestParam(defaultValue = "", name = "health") String restriction,
                                @RequestParam(defaultValue = "fast-foods", name = "category") String category){
        List<Food> foodList = foodService.addFood(ingredient, restriction, category);
        return foodList;
    }





}
