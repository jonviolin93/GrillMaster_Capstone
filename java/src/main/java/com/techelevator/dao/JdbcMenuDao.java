package com.techelevator.dao;

import com.techelevator.model.Food;
import com.techelevator.model.Menu;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JdbcMenuDao implements MenuDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcMenuDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Food> getAllFood() {
        return null;
    }

    @Override
    public List<Food> getByCategory(int categoryId) {
        return null;
    }

    @Override
    public List<Menu> getFavoritedMenus() {
        return null;
    }

    @Override
    public Menu updateMenu(Menu menu) {
        return null;
    }

    @Override
    public Menu createMenu(Menu menu) {
        return null;
    }
}
