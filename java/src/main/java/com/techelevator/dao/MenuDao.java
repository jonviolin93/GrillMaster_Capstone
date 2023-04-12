package com.techelevator.dao;

import com.techelevator.model.Food;
import com.techelevator.model.Menu;
import com.techelevator.model.User;

import java.util.List;

public interface MenuDao {

    List<Food> getFoodFromMenu(int menuId);

    List<Menu> getFavoritedMenus(int hostId);

    void updateMenu(Menu menu, User user);

    int createMenu(Menu menu, User user);

}
