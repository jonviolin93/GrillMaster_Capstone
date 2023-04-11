package com.techelevator.services;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestFoodService {
    public static final String API_BASE_URL =
            "https://api.edamam.com/api/food-database/v2/parser?app_id=e1ba34b5&app_key=3009a0863323c9029e81e9d839ef6a00&ingr=";
    RestTemplate restTemplate = new RestTemplate();
}
