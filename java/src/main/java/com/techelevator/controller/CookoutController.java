package com.techelevator.controller;

import com.techelevator.dao.CookoutDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Cookout;
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
@RequestMapping("/cookouts/")
public class CookoutController {
    private CookoutDao cookoutDao;
    private UserDao userDao;

    public CookoutController(CookoutDao cookoutDao, UserDao userDao) {
        this.cookoutDao = cookoutDao;
        this.userDao = userDao;
    }

    @RequestMapping(path= "", method = RequestMethod.GET)
    public List<Cookout> listCookouts(Principal principal) {
        int userId = userDao.findIdByUsername(principal.getName());
        return cookoutDao.listCookouts(userId);
    }

    @RequestMapping(path= "duty/{id}", method = RequestMethod.GET)
    public List<Cookout> listCookoutsByDuty(Principal principal, @PathVariable(name = "id") int dutyId) {
        int userId = userDao.findIdByUsername(principal.getName());
        return cookoutDao.listCookoutsByRole(userId, dutyId);
    }

    @RequestMapping(path="{id}", method = RequestMethod.GET)
    public Cookout showCookoutDetails(@PathVariable int id, Principal principal) {
        int userId = userDao.findIdByUsername(principal.getName());
        Cookout cookout = cookoutDao.showCookoutDetails(id, userId);
        if (cookout == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cookout not found");
        } else {
            return cookout;
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path="", method = RequestMethod.POST)
    public int createCookout(@Valid @RequestBody Cookout cookout, Principal principal) {
        int userId = userDao.findIdByUsername(principal.getName());
        int cookoutId = cookoutDao.createNewCookout(cookout);
        cookoutDao.markRead(cookoutId, userId);
        return cookoutId;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path="unread", method = RequestMethod.PUT)
    public void markAllCookoutsRead(Principal principal) {
        int userId = userDao.findIdByUsername(principal.getName());
        cookoutDao.markRead(userId);
    }

    @RequestMapping(path="{id}", method = RequestMethod.PUT)
    public void updateCookout(@Valid @RequestBody Cookout cookout, @PathVariable int id) {
        cookoutDao.updateCookout(cookout, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path="{id}", method = RequestMethod.DELETE)
    public void deleteCookout(@PathVariable int id) {
        cookoutDao.deleteCookout(id);
    }

}
