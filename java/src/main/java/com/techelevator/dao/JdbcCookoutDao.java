package com.techelevator.dao;

import com.techelevator.model.Cookout;
import com.techelevator.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcCookoutDao implements CookoutDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcCookoutDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int createNewCookout(Cookout cookout) {
        String sql = "INSERT INTO cookout (name, cookout_date, cookout_time, location, description, menu_id) " +
                "VALUES (?, ?, ?, ?, ?, ?) " +
                "RETURNING cookout_id;";
        Integer cookoutId = jdbcTemplate.queryForObject(sql, Integer.class, cookout.getName(), cookout.getDate(),
                cookout.getTime(), cookout.getLocation(), cookout.getDescription(), cookout.getMenuId());
        for (int i = 0; i < cookout.getAttendees().size(); i++) {
            insertUsersToCookout(cookoutId, cookout.getAttendees().get(i));
        }
        return cookoutId;
    }

    private void insertUsersToCookout(int cookoutId, User user) {
        String sql = "INSERT INTO user_cookout (duty_id, user_id, cookout_id) " +
                "SELECT d.duty_id, ?, ? FROM duty d " +
                "WHERE d.name = ?;";
        jdbcTemplate.update(sql, user.getId(), cookoutId, user.getDuty());
    }

    @Override
    public void updateCookout(Cookout cookout) {
        String sql = "UPDATE cookout " +
                "SET name = ?, cookout_date = ?, cookout_time = ?, location = ?, description = ?, menu_id = ? " +
                "WHERE cookout_id = ?;";
        jdbcTemplate.update(sql, cookout.getName(), cookout.getDate(),
                cookout.getTime(), cookout.getLocation(), cookout.getDescription(), cookout.getMenuId(), cookout.getId());
        deleteCookoutUsers(cookout.getId());
        for (int i = 0; i < cookout.getAttendees().size(); i++) {
            insertUsersToCookout(cookout.getId(), cookout.getAttendees().get(i));
        }
    }

    private void deleteCookoutUsers(int cookoutId) {
        String sql = "DELETE FROM user_cookout" +
                "WHERE cookout_id = ?;";
        jdbcTemplate.update(sql, cookoutId);
    }

    @Override
    public void deleteCookout(int id) {
        String sql = "DELETE FROM cookout " +
                "WHERE cookout_id = ?;";
    }

    @Override
    public Cookout showCookoutDetails(int id, int userId) {
        String sql = "SELECT cookout_id, name, cookout_date, cookout_time, location, description, menu_id " +
                "FROM cookout " +
                "WHERE cookout_id = ? AND cookout_id IN " +
                "(SELECT cookout_id FROM user_cookout WHERE user_id = ?);";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id, userId);
        if (results.next()) {
            return mapRowToCookout(results);
        } else {
            return null;
        }
    }

    @Override
    public List<Cookout> listCookouts(int userId) {
        List<Cookout> cookouts = new ArrayList<>();
        String sql = "SELECT cookout_id, name, cookout_date, cookout_time, location, description, menu_id " +
                "FROM cookout " +
                "WHERE cookout_date >= CURRENT_DATE AND cookout_id IN " +
                "(SELECT cookout_id FROM user_cookout WHERE user_id = ?) " +
                "ORDER BY cookout_date, cookout_time;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        while (results.next()) {
            cookouts.add(mapRowToCookout(results));
        }
        return cookouts;
    }

    private List<User> listUsersByCookoutId(int cookoutId){
        List<User> users = new ArrayList<>();
        String sql = "SELECT users.user_id, username, duty " +
                "FROM users " +
                "JOIN user_cookout ON users.user_id = user_cookout.user_id " +
                "JOIN duty ON duty.duty_id = user_cookout.duty_id " +
                "JOIN cookout ON cookout.cookout_id = user_cookout.cookout_id " +
                "WHERE cookout.cookout_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, cookoutId);
        while (results.next()) {
            users.add(mapRowToUser(results));
        }
        return users;
    }

    @Override
    public List<Cookout> listCookoutsByRole(int userId, int dutyId) {
        List<Cookout> cookouts = new ArrayList<>();
        String sql = "SELECT cookout_id, name, cookout_date, cookout_time, location, description, menu_id " +
                "FROM cookout " +
                "WHERE cookout_date >= CURRENT_DATE AND cookout_id IN " +
                "(SELECT cookout_id FROM user_cookout WHERE user_id = ? AND duty_id = ?) " +
                "ORDER BY cookout_date, cookout_time;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId, dutyId);
        while (results.next()) {
            cookouts.add(mapRowToCookout(results));
        }
        return cookouts;
    }

    private Cookout mapRowToCookout(SqlRowSet rowSet) {
        Cookout cookout = new Cookout();
        int cookoutId = rowSet.getInt("cookout_id");
        cookout.setId(cookoutId);
        cookout.setName(rowSet.getString("name"));
        cookout.setDate(rowSet.getDate("cookout_date").toLocalDate());
        cookout.setTime(rowSet.getTime("cookout_time").toLocalTime());
        cookout.setLocation(rowSet.getString("location"));
        cookout.setDescription(rowSet.getString("description"));
        List<User> users = listUsersByCookoutId(cookoutId);
        cookout.setAttendees(users);
        cookout.setMenuId(rowSet.getInt("menu_id"));
        return cookout;
    }

    private User mapRowToUser(SqlRowSet rowSet) {
        User user = new User();
        user.setId(rowSet.getInt("user_id"));
        user.setUsername(rowSet.getString("username"));
        user.setDuty(rowSet.getString("duty"));
        return user;
    }
}
