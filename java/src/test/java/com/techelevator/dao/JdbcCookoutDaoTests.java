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

    @Test
    public void showCookoutDetails_shows_details() {
        //Arrange
        Cookout cookout = sut.showCookoutDetails(1, 1);

        //Assert
        assertCookoutsMatch(COOKOUT_1, cookout);
    }
    @Test
    public void listCookouts_lists_cookouts() {
        /*//Arrange
        List<Cookout> cookouts = sut.listCookouts(1);
        //Act
        //Assert
        Assert.assertEquals(1, cookouts.size());*/
    }

    @Test
    public void listUsersByCookoutId_lists_users() {
        //Arrange
        //Act
        //Assert

    }

    @Test
    public void listCookoutsByRole_lists_cookouts() {
        //Arrange
        //Act
        //Assert

    }

    private void assertCookoutsMatch(Cookout expected, Cookout actual) {
        Assert.assertEquals(expected.getId(), actual.getId());
        Assert.assertEquals(expected.getName(), actual.getName());
        Assert.assertEquals(expected.getDate(), actual.getDate());
        Assert.assertEquals(expected.getTime(), actual.getTime());
        Assert.assertEquals(expected.getLocation(), actual.getLocation());
        Assert.assertEquals(expected.getDescription(), actual.getDescription());
        Assert.assertEquals(expected.getAttendees().size(), actual.getAttendees().size());
        Assert.assertEquals(expected.getMenuId(), actual.getMenuId());
    }
}
