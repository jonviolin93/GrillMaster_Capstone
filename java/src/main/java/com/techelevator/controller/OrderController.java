package com.techelevator.controller;

import com.techelevator.dao.OrderDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Order;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
@RequestMapping("cookouts/{id}/order/")
public class OrderController {
    private OrderDao orderDao;
    private UserDao userDao;

    public OrderController(OrderDao orderDao, UserDao userDao) {
        this.orderDao = orderDao;
        this.userDao = userDao;
    }

    @RequestMapping(path="", method = RequestMethod.GET)
    public List<Order> showCookoutOrders(@PathVariable(name = "id") int cookoutId){
        return orderDao.ordersList(cookoutId);
    }

    @RequestMapping(path="{order-id}", method = RequestMethod.GET)
    public Order showIndividualOrder (@PathVariable(name = "id") int cookoutId,
                                      @PathVariable(name = "order-id") int orderId) {
        Order order = orderDao.getOrderById(orderId);
        if (order == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found");
        }
        return order;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "", method = RequestMethod.POST)
    public int addOrder (@PathVariable(name = "id") int cookoutId, @RequestBody Order order, Principal principal) {
        int userId = userDao.findIdByUsername(principal.getName());
        return orderDao.createOrder(order, cookoutId, userId);
    }

    @RequestMapping(path="{order-id}", method = RequestMethod.PUT)
    public void  markOrderComplete (@PathVariable(name = "id") int cookoutId,
                                   @PathVariable(name = "order-id") int orderId) {
        orderDao.completeOrder(orderId);
    }
}
