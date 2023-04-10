package com.techelevator.dao;

import com.techelevator.model.Food;
import com.techelevator.model.Menu;

import java.util.List;

public interface MenuDao {

    List<Food> getAllFood();

    List<Food> getByCategory(int categoryId);

    List<Menu> getFavoritedMenus();

    Menu updateMenu(Menu menu);

    Menu createMenu(Menu menu);

}
