package com.techelevator.dao;

import com.techelevator.model.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JdbcOrderDao implements OrderDao {
    private final JdbcTemplate jdbcTemplate;

    public JdbcOrderDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Order createOrder(Order order) {
        return null;
    }

    @Override
    public Order getOrderById(int id) {
        return null;
    }

    @Override
    public List<Order> ordersList(int cookoutId) {
        return null;
    }

    @Override
    public Order completeOrder(int id) {
        return null;
    }

    @Override
    public Order updateOrder(Order order) {
        return null;
    }

    @Override
    public Order deleteOrder(int id) {
        return null;
    }
}
