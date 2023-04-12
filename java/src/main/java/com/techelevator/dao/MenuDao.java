package com.techelevator.dao;

import com.techelevator.model.Food;
import com.techelevator.model.Menu;

import java.util.List;

public interface MenuDao {

    List<Food> getFoodFromMenu(int menuId);

    List<Menu> getFavoritedMenus(int hostId);

    Menu updateMenu(Menu menu);

    Menu createMenu(Menu menu);

}
