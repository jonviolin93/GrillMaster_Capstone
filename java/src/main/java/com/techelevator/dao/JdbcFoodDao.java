package com.techelevator.dao;

import com.techelevator.model.Food;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcFoodDao implements FoodDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcFoodDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Food> listAllFood() {
        List<Food> foods = new ArrayList<>();
        String sql = "SELECT food_id, name, image, food_category.name " +
                "FROM food " +
                "JOIN food_category ON food_category.category_id = food.category_id;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            foods.add(mapRowToFood(results));
        }
        return foods;
    }

    @Override
    public Food showFoodItem(int id) {
        String sql = "SELECT food_id, name, image, food_category.name " +
                "FROM food " +
                "JOIN food_category ON food_category.category_id = food.category_id " +
                "WHERE food_id = ?;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, id);
        if (result.next()) {
            return mapRowToFood(result);
        }
        return null;
    }

    @Override
    public int addFoodItem(Food food) {
        String sql = "INSERT INTO food (name, image, category_id) " +
                "SELECT ?, ?, c.category_id " +
                "FROM food_category c " +
                "WHERE c.name = ? " +
                "RETURNING food_id;";
        Integer foodId = jdbcTemplate.queryForObject(sql, Integer.class, food.getName(), food.getImg(), food.getCategory());
        return foodId;
    }

    private Food mapRowToFood(SqlRowSet rowSet) {
        Food food = new Food();
        food.setId(rowSet.getInt("food_id"));
        food.setName(rowSet.getString("name"));
        food.setImg(rowSet.getString("image"));
        food.setCategory(rowSet.getString("category"));
        return food;
    }

}
