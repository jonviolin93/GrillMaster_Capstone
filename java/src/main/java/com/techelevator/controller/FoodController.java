package com.techelevator.controller;

import com.techelevator.dao.FoodDao;
import com.techelevator.services.FoodService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
@RequestMapping("/food")
public class FoodController {
    private FoodDao foodDao;
//    private FoodService foodService;

    public FoodController(FoodDao foodDao) { //TODO Reinsert FoodService here
        this.foodDao = foodDao;
//        this.foodService = foodService;
    }
}
