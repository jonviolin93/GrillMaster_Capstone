package com.techelevator.dao;

import com.techelevator.model.Food;
import com.techelevator.model.Menu;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcMenuDao implements MenuDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcMenuDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Food> getFoodFromMenu(int menuId) {
        List<Food> foodList = new ArrayList<>();
        String sql = "SELECT food.food_id, food.name, image, category.name AS category" +
                "FROM food " +
                "JOIN food_category ON food_category.category_id = food.category_id " +
                "JOIN food_menu ON food_menu.food_id = food.food_id " +
                "WHERE menu_id = ? " +
                "ORDER BY category_id, food.name;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, menuId);
        while(results.next()) {
            foodList.add(mapRowToFood(results));
        }
        return foodList;
    }

    @Override
    public List<Menu> getFavoritedMenus(int hostId) {
        List<Menu> menus = new ArrayList<>();
        String sql = "SELECT menu.menu_id, menu.name " +
                "FROM menu " +
                "JOIN cookout ON cookout.menu_id = menu.menu_id " +
                "JOIN user_cookout ON user_cookout.cookout_id = cookout.cookout_id " +
                "WHERE user_id = ? AND duty_id = 1 AND is_favorited = true;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, hostId);
        while(results.next()) {
            menus.add(mapRowToMenu(results));
        }
        return menus;
    }

    @Override
    public Menu updateMenu(Menu menu) {
        return null;
    }

    @Override
    public Menu createMenu(Menu menu) {
        return null;
    }

    private Food mapRowToFood(SqlRowSet rowSet) {
        Food food = new Food();
        food.setId(rowSet.getInt("food_id"));
        food.setName(rowSet.getString("name"));
        food.setImg(rowSet.getString("image"));
        food.setCategory(rowSet.getString("category"));
        return food;
    }

    private Menu mapRowToMenu(SqlRowSet rowSet) {
        Menu menu = new Menu();
        int menuId = rowSet.getInt("menu_id");
        menu.setId(menuId);
        menu.setName(rowSet.getString("name"));
        menu.setFavorited(true);
        List<Food> foodList = getFoodFromMenu(menuId);
        menu.setFoodItems(foodList);
        return menu;
    }
}
