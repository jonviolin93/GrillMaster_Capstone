package com.techelevator.controller;

import com.techelevator.dao.MenuDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Menu;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
@RequestMapping("/menu")
public class MenuController {

    private MenuDao menuDao;
    private UserDao userDao;

    public MenuController(MenuDao menuDao, UserDao userDao) {
        this.menuDao = menuDao;
        this.userDao = userDao;
    }

    @RequestMapping(path="/{id}", method = RequestMethod.GET)
    public Menu getIndividualMenu(@PathVariable int id) {
        Menu menu = menuDao.getMenuById(id);
        if(menu == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Menu not found.");
        } else{
            return menu;
        }
    }

    @RequestMapping(path="/favorited", method = RequestMethod.GET)
    public List<Menu> getFavoritedMenu(Principal principal){
        int userId = userDao.findIdByUsername(principal.getName());
        return menuDao.getFavoritedMenus(userId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path="", method = RequestMethod.POST)
    public int addNewMenu(@Valid @RequestBody Menu menu, Principal principal) {
        int userId = userDao.findIdByUsername(principal.getName());
        return menuDao.createMenu(menu, userId);
    }

}
