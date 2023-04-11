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
    public Cookout createNewCookout(Cookout cookout) {
        return null;
    }

    @Override
    public Cookout updateCookout(Cookout cookout) {
        return null;
    }

    @Override
    public Cookout deleteCookout(int id) {
        return null;
    }

    @Override
    public Cookout showCookoutDetails(int id, int userId) {
        return null;
    }

    @Override
    public List<Cookout> listCookouts(int userId) {
        String sql = "SELECT cookout_id, name, cookout_date, cookout_time, location, description, menu_id " +
                "FROM cookout " +
                "WHERE cookout_date >= CURRENT_DATE AND cookout_id IN " +
                "(SELECT cookout_id FROM user_cookout WHERE user_id = ?) " +
                "ORDER BY cookout_date, cookout_time;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        while (results.next()) {

        }

        return null;
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
//        while (results.next()) {
//            users.add(results);
//        }
        return null;
    }

    @Override
    public List<Cookout> listCookoutsByRole(int userId, String role) {
        return null;
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
        return null;
    }

    //TODO: map row to users
}
