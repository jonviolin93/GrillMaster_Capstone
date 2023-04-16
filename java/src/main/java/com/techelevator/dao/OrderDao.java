package com.techelevator.dao;

import com.techelevator.model.Order;

import java.util.List;

public interface OrderDao {

    int createOrder(Order order, int cookoutId, int userId);

    Order getOrderById(int id);

    List<Order> ordersList(int cookoutId);

    void completeOrder(int id);

}
