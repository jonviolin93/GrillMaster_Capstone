package com.techelevator.controller;

import com.techelevator.dao.MenuDao;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
@RequestMapping("/menu")
public class MenuController {

    private MenuDao menuDao;

    public MenuController(MenuDao menuDao) {
        this.menuDao = menuDao;
    }
}
