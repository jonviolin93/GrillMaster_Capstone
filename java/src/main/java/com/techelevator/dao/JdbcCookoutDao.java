package com.techelevator.dao;

import com.techelevator.model.Cookout;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

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
        return null;
    }

    @Override
    public List<Cookout> listCookoutsByRole(int userId, String role) {
        return null;
    }
}
