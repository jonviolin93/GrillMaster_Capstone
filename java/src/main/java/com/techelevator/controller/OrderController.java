package com.techelevator.controller;

import com.techelevator.dao.OrderDao;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
@RequestMapping("/order")
public class OrderController {
    private OrderDao orderDao;

    public OrderController(OrderDao orderDao) {
        this.orderDao = orderDao;
    }
}
