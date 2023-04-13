package com.techelevator.dao;

import com.techelevator.model.Food;
import com.techelevator.model.Menu;
import com.techelevator.model.User;
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
        String sql = "SELECT food.food_id, food.name, image, food_category.name AS category, username " +
                "FROM food " +
                "JOIN food_category ON food_category.category_id = food.category_id " +
                "JOIN food_menu ON food_menu.food_id = food.food_id " +
                "JOIN users ON food_menu.added_by_id = users.user_id " +
                "WHERE menu_id = ? " +
                "ORDER BY food_category.category_id, food.name;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, menuId);
        while(results.next()) {
            foodList.add(mapRowToFood(results));
        }
        return foodList;
    }

    @Override
    public List<Menu> getFavoritedMenus(int hostId) {
        List<Menu> menus = new ArrayList<>();
        String sql = "SELECT menu.menu_id, menu.name, is_favorited " +
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
    public Menu getMenuById(int id){
        String sql = "SELECT menu_id, name, is_favorited FROM menu WHERE menu_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        if (results.next()){
            return mapRowToMenu(results);
        }
        return null;
    }

    @Override
    public void updateMenu(Menu menu, String username, int userId, int id) {
        String sql = "UPDATE menu " +
                "SET name = ?, is_favorited = ? " +
                "WHERE menu_id = ?;";
        jdbcTemplate.update(sql, menu.getName(), menu.isFavorited(), id);
        deleteFoodFromMenu(id, userId);
        for (int i = 0; i < menu.getFoodItems().size(); i++) {
            if (menu.getFoodItems().get(i).getAddedBy().equals(username)){
                addFoodToMenu(menu.getFoodItems().get(i), id, userId);
            }
        }
    }

    private void deleteFoodFromMenu(int menuId, int userId){
        String sql = "DELETE FROM food_menu " +
                "WHERE menu_id = ? AND added_by_id = ?;";
        jdbcTemplate.update(sql, menuId, userId);
    }

    private void addFoodToMenu(Food food, int menuId, int userId){
        String sql = "INSERT INTO food_menu (food_id, menu_id, added_by_id) " +
                "VALUES (?, ?, ?);";

        jdbcTemplate.update(sql, food.getId(), menuId, userId);
    }

    @Override
    public int createMenu(Menu menu, int userId) {
        String sql = "INSERT INTO menu(name, is_favorited) " +
                "VALUES (?, ?) " +
                "RETURNING menu_id";
        Integer menuId = jdbcTemplate.queryForObject(sql, Integer.class, menu.getName(), menu.isFavorited());
        for (int i = 0; i < menu.getFoodItems().size(); i++) {
            addFoodToMenu(menu.getFoodItems().get(i), menuId, userId);
        }
        return menuId;
    }

    private Food mapRowToFood(SqlRowSet rowSet) {
        Food food = new Food();
        food.setId(rowSet.getInt("food_id"));
        food.setName(rowSet.getString("name"));
        food.setImg(rowSet.getString("image"));
        food.setCategory(rowSet.getString("category"));
        food.setAddedBy(rowSet.getString("username"));
        return food;
    }

    private Menu mapRowToMenu(SqlRowSet rowSet) {
        Menu menu = new Menu();
        int menuId = rowSet.getInt("menu_id");
        menu.setId(menuId);
        menu.setName(rowSet.getString("name"));
        menu.setFavorited(rowSet.getBoolean("is_favorited"));
        List<Food> foodList = getFoodFromMenu(menuId);
        menu.setFoodItems(foodList);
        return menu;
    }
}
