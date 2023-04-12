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
import java.util.Arrays;
import java.util.List;

public class JdbcCookoutDaoTests extends BaseDaoTests{

    private final User User_1 = new User(1, "user1", "user1", "user", "Attendee");
    private final User User_2 = new User(2, "user2", "user2", "user", "Grill Master");
    private final User User_3 = new User(3, "user3", "user3", "user", "Host");

    private List<User> attendees = Arrays.asList(User_1, User_2, User_3);

    private final Cookout COOKOUT_1 = new Cookout(1, "Jonathans B-Day!", LocalDate.of(2023, 04, 12),
            LocalTime.of(12, 00), "Jonathans Backyard", "Its a birthday in a backyard", attendees, 1);
    private final Cookout COOKOUT_2 = new Cookout(2, "Melis B-Day!", LocalDate.of(2023, 05, 13),
            LocalTime.of(12, 00), "DisneyWorld", "Its a Small World After All", attendees, 1);
    private final Cookout COOKOUT_3 = new Cookout(3, "Elliss B-Day!", LocalDate.of(2023, 06, 17),
            LocalTime.of(12, 00), "NASA Space Station", "To Infinity and Beyond", attendees, 1);
    private final Cookout COOKOUT_4 = new Cookout(4, "Camerons B-Day!", LocalDate.of(2023, 10, 5),
            LocalTime.of(12, 00), "Pentagon", "Everyone bring five items", attendees, 1);
    private final Cookout COOKOUT_5 = new Cookout(5, "Reds B-Day!", LocalDate.of(2023, 12, 31),
            LocalTime.of(12, 00), "Barbershop", "Check out that Doo", attendees, 1);

    private JdbcCookoutDao sut;
    private Cookout testCookout;

    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new JdbcCookoutDao(jdbcTemplate);
        testCookout = new Cookout();
    }

    @Test
    public void createNewCookout_creates_cookout_with_id_and_expected_values() {

        int createdCookoutId = sut.createNewCookout(COOKOUT_5);

        Cookout retrievedCookout = sut.showCookoutDetails(createdCookoutId, 1);

        assertCookoutsMatch(COOKOUT_5, retrievedCookout);
    }

   /* @Test
    public void showCookoutDetailsShowsDetails() {
        //Arrange
        Cookout cookout = sut.showCookoutDetails(1, 1);
        Cookout expected =
                (30, "Jonathan's B-Day!", LocalDate.of(2023, 04, 12),
                LocalTime.of(12, 00), "Jonathan's Backyard", "It's a birthday in a backyard", 3);
        //Act
        Cookout actual = sut.showCookoutDetails(30, 1);
        //Assert
        Assert.assertEquals(expected, actual);
    }*/
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
