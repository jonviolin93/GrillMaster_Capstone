package com.techelevator.dao;

import com.techelevator.model.Cookout;
import com.techelevator.model.Food;
import com.techelevator.model.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcOrderDao implements OrderDao {
    private final JdbcTemplate jdbcTemplate;

    public JdbcOrderDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int createOrder(Order order, int cookoutId, int userId) {
        String sql = "INSERT INTO cookout_order (cookout_id, user_id, order_time) " +
                "VALUES(?, ?, ?) " +
                "RETURNING order_id;";
        Integer orderId = jdbcTemplate.queryForObject(sql, Integer.class, cookoutId, userId, LocalTime.now());
        for (int i = 0; i < order.getFoodList().size(); i++) {
            insertFoodIntoOrder(orderId, order.getFoodList().get(i));
        }
        return orderId;
    }

    private void insertFoodIntoOrder(int orderId, Food food){
        String sql = "INSERT INTO order_food (order_id, food_id, quantity) " +
                "VALUES (?, (SELECT food_id FROM food WHERE name = ?), ?);";

        jdbcTemplate.update(sql, orderId, food.getName(), food.getQuantity());
    }

    @Override
    public Order getOrderById(int id) {
        String sql = "SELECT order_id, cookout_id, username, users.user_id, is_complete, order_time " +
                "FROM cookout_order " +
                "JOIN users ON cookout_order.user_id = users.user_id " +
                "WHERE order_id = ?;";

        Order order = null;
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        if(results.next()){
            order = mapRowToOrder(results);
        }
        return order;
    }

    @Override
    public List<Order> ordersList(int cookoutId) {
        String sql = "SELECT order_id, cookout_id, username, users.user_id, is_complete, order_time " +
                "FROM cookout_order " +
                "JOIN users ON cookout_order.user_id = users.user_id " +
                "WHERE cookout_id = ? " +
                "ORDER BY order_time;";

        List<Order> orderList = new ArrayList<>();
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, cookoutId);
        while(results.next()){
            orderList.add(mapRowToOrder(results));
        }
        return orderList;
    }

    @Override
    public void completeOrder(int id) {
        String sql = "UPDATE cookout_order SET is_complete = true " +
                "WHERE order_id = ?";
        jdbcTemplate.update(sql, id);
    }

    private List<Food> listFoodByOrderId(int orderId){
        String sql = "SELECT food.food_id, food.name, image, food_category.name AS category, quantity " +
                "FROM food " +
                "JOIN order_food ON order_food.food_id = food.food_id " +
                "JOIN food_category ON food_category.category_id = food.category_id " +
                "WHERE order_id = ?;";
        List<Food> foodList = new ArrayList<>();
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, orderId);
        while(results.next()){
            foodList.add(mapRowToFood(results));
        }
        return foodList;
    }

    private Food mapRowToFood(SqlRowSet rowSet){
        Food food = new Food();
        food.setId(rowSet.getInt("food_id"));
        food.setName(rowSet.getString("name"));
        food.setImg(rowSet.getString("image"));
        food.setCategory(rowSet.getString("category"));
        food.setQuantity(rowSet.getInt("quantity"));

        return food;
    }

    private Order mapRowToOrder(SqlRowSet rowSet) {
        Order order = new Order();
        int orderId = rowSet.getInt("order_id");
        order.setId(orderId);
        order.setUserId(rowSet.getInt("user_id"));
        order.setComplete(rowSet.getBoolean("is_complete"));
        order.setTime(rowSet.getTime("order_time").toLocalTime());
        order.setFoodList(listFoodByOrderId(orderId));
        order.setUsername(rowSet.getString("username"));

        return order;
    }
}
