package com.techelevator.dao;

import com.techelevator.model.Cookout;

import java.util.List;

public interface CookoutDao {

    int createNewCookout(Cookout cookout);

    void updateCookout(Cookout cookout, int id);

    void deleteCookout(int id);

    Cookout showCookoutDetails(int id, int userId);

    List<Cookout> listCookouts(int userId);

    List<Cookout> listCookoutsByRole(int userId, int dutyId);
}
