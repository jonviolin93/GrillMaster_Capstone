package com.techelevator.dao;

import com.techelevator.model.Order;

import java.util.List;

public interface OrderDao {

    Order createOrder(Order order);

    Order getOrderById(int id);

    List<Order> ordersList(int cookoutId);

    Order completeOrder(int id);

    Order updateOrder(Order order);

    Order deleteOrder(int id);

}
