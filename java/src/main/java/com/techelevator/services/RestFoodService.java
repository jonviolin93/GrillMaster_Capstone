package com.techelevator.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techelevator.model.Food;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class RestFoodService implements FoodService{
    public static final String API_BASE_URL =
            "https://api.edamam.com/api/food-database/v2/parser?app_id=e1ba34b5&app_key=3009a0863323c9029e81e9d839ef6a00";
    RestTemplate restTemplate = new RestTemplate();

    @Override
    public List<Food> addFood(String ingredient, String restriction, String category){
        String ingr = "";
        String health = "";
        String cat = "";
        if(ingredient != "") {
            ingr = "&ingr=" + ingredient;
        }
        if(restriction != ""){
            health = "&health=" + restriction;
        }
        if(category != ""){
            cat = "&category=" + category;
        }

        String result = restTemplate.getForObject(API_BASE_URL + ingr + health + cat, String.class);
        ObjectMapper mapper = new ObjectMapper();
        List<Food> foodList = new ArrayList<>();

        try {
            JsonNode jsonNode = mapper.readTree(result);
            JsonNode root = jsonNode.path("hints");
            for (int i = 0; i < root.size(); i++) {
                Food food = new Food();
                String name = root.path(i).path("food").path("label").asText();
                food.setName(name);
                String image = root.path(i).path("food").path("image").asText();
                if(image != ""){
                    food.setImg(image);
                }
                foodList.add(food);
            }
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return foodList;
    }
}
