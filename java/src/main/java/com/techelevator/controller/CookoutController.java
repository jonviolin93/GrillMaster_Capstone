package com.techelevator.controller;

import com.techelevator.dao.CookoutDao;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
@RequestMapping("/cookout")
public class CookoutController {
    private CookoutDao cookoutDao;

    public CookoutController(CookoutDao cookoutDao) {
        this.cookoutDao = cookoutDao;
    }


}
