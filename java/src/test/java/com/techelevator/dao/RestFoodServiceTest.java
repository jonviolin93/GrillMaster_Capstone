package com.techelevator.dao;

import com.techelevator.model.Food;
import com.techelevator.services.RestFoodService;
import org.junit.Test;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class RestFoodServiceTest {

    @Test
    public void restFoodServiceReturnsFood(){
        RestFoodService restFoodService = new RestFoodService();
        List<Food> foodList = restFoodService.addFood("drumstick", "", "");
        for (int i = 0; i < foodList.size() ; i++) {
            System.out.println(foodList.get(i).getName());
            System.out.println(foodList.get(i).getImg());
        }
    }

}
