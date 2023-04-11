package com.techelevator.dao;

import com.techelevator.model.Cookout;

import java.util.List;

public interface CookoutDao {

    Cookout createNewCookout(Cookout cookout);

    Cookout updateCookout(Cookout cookout);

    Cookout deleteCookout(int id);

    Cookout showCookoutDetails(int id, int userId);

    List<Cookout> listCookouts(int userId);

    List<Cookout> listCookoutsByRole(int userId, String role);
}
