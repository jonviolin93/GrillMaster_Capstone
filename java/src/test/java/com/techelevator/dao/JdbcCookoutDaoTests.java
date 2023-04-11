package com.techelevator.dao;

import com.techelevator.model.Cookout;
import com.techelevator.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class JdbcCookoutDaoTests extends BaseDaoTests{
    List<User> attendees = new ArrayList<>();
    User User_1 = new User(1, "user1", "user1", "user");
    User User_2 = new User(2, "user2", "user2", "user");
    User User_3 = new User(3, "user3", "user3", "user");

    protected final Cookout Cookout_1 = new Cookout(30, "Jonathan's B-Day!", LocalDate.of(2023, 04, 12),
            LocalTime.of(12, 00), "Jonathan's Backyard", "It's a birthday in a backyard", attendees, 3);

    private JdbcCookoutDao sut;
    private Cookout testCookout;

    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new JdbcCookoutDao(jdbcTemplate);
        testCookout = new Cookout();
    }

   /* @Test
    public void createNewCookoutCreatesCookout() {
        //Arrange
        int createdCookout = sut.createNewCookout(testCookout);
        //Assert
        int newCookoutId = createdCookout.getCookoutId();
        //Act
    }*/

    @Test
    public void showCookoutDetailsShowsDetails() {
        //Arrange
        /*attendees.add(User_1);
        Cookout expected =
                (30, "Jonathan's B-Day!", LocalDate.of(2023, 04, 12),
                LocalTime.of(12, 00), "Jonathan's Backyard", "It's a birthday in a backyard", 3);
        //Act
        Cookout actual = sut.showCookoutDetails(30, 1);
        //Assert
        Assert.assertEquals(expected, actual);*/
    }

    @Test
    public void listCookoutsListsCookouts() {
        //Arrange

        //Assert
        //Act
    }

    @Test
    public void listUsersByCookoutListsUsers() {
        //Arrange

        //Assert
        //Act
    }

    private void assertCookoutsMatch(Cookout expected, Cookout actual) {
        Assert.assertEquals(expected.getId(), actual.getId());
        Assert.assertEquals(expected.getName(), actual.getName());
        Assert.assertEquals(expected.getDate(), actual.getDate());
        Assert.assertEquals(expected.getTime(), actual.getTime());
        Assert.assertEquals(expected.getLocation(), actual.getLocation());
        Assert.assertEquals(expected.getDescription(), actual.getDescription());
        Assert.assertEquals(expected.getMenuId(), actual.getMenuId());
    }
}
