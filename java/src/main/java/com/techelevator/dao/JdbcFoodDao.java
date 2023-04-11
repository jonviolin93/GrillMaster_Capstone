package com.techelevator.dao;

import com.techelevator.model.Food;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JdbcFoodDao implements FoodDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcFoodDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Food showFoodItem(int id) {
        return null;
    }

    @Override
    public Food addFoodItem(Food food) {
        return null;
    }

    @Override
    public Food updateFoodItem(Food food) {
        return null;
    }

    @Override
    public List<Food> listAllFood() {
        return null;
    }
}
