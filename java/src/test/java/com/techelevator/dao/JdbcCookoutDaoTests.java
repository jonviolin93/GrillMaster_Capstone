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

    private final Cookout COOKOUT_1 = new Cookout(1, "Jonathans B-Day!", LocalDate.of(2028, 04, 12),
            LocalTime.of(12, 00), "Jonathans Backyard", "Its a birthday in a backyard", attendees, 1);
    private final Cookout COOKOUT_2 = new Cookout(2, "Melis B-Day!", LocalDate.of(2028, 05, 13),
            LocalTime.of(12, 00), "DisneyWorld", "Its a Small World After All", attendees, 1);
    private final Cookout COOKOUT_3 = new Cookout(3, "Elliss B-Day!", LocalDate.of(2028, 06, 17),
            LocalTime.of(12, 00), "NASA Space Station", "To Infinity and Beyond", attendees, 1);
    private final Cookout COOKOUT_4 = new Cookout(4, "Camerons B-Day!", LocalDate.of(2028, 10, 5),
            LocalTime.of(12, 00), "Pentagon", "Everyone bring five items", attendees, 1);
    private final Cookout COOKOUT_5 = new Cookout(5, "Reds B-Day!", LocalDate.of(2028, 12, 31),
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
        //Arrange
        List<Cookout> cookouts = sut.listCookouts(1);
        //Act

        //Assert
        Assert.assertEquals(4, cookouts.size());
        assertCookoutsMatch(COOKOUT_1, cookouts.get(0));
        assertCookoutsMatch(COOKOUT_2, cookouts.get(1));
        assertCookoutsMatch(COOKOUT_3, cookouts.get(2));
        assertCookoutsMatch(COOKOUT_4, cookouts.get(3));
        Assert.assertEquals("Host", cookouts.get(0).getAttendees().get(0).getDuty());
        Assert.assertEquals("Grill Master", cookouts.get(0).getAttendees().get(1).getDuty());
        Assert.assertEquals("Attendee", cookouts.get(0).getAttendees().get(2).getDuty());
    }

    @Test
    public void listCookoutsByRole_lists_cookouts() {
        //Arrange
        List<Cookout> cookouts = sut.listCookoutsByRole(1, 3);
        //Act
        //Assert
        Assert.assertEquals(4, cookouts.size());
        assertCookoutsMatch(COOKOUT_1, cookouts.get(0));
        assertCookoutsMatch(COOKOUT_2, cookouts.get(1));
        assertCookoutsMatch(COOKOUT_3, cookouts.get(2));
        assertCookoutsMatch(COOKOUT_4, cookouts.get(3));
    }

    @Test
    public void listCookoutsByRole_returns_zero_for_wrong_role() {
        //Arrange
        List<Cookout> cookouts = sut.listCookoutsByRole(1, 2);
        //Act
        //Assert
        Assert.assertEquals(0, cookouts.size());
    }

    @Test
    public void deleteCookout_deletes_cookout() {
        List<Cookout> oldCookouts = sut.listCookouts(1);
        Assert.assertEquals(4, oldCookouts.size());
        sut.deleteCookout(4);
        List<Cookout> newCookouts = sut.listCookouts(1);
        Assert.assertEquals(3, newCookouts.size());
    }

    @Test
    public void updateCookout_updates_cookout_and_users() {
        Cookout cookout = sut.showCookoutDetails(1, 1);
        cookout.setName("Birthday Bash");
        cookout.setDate(LocalDate.of(2027, 1, 1));
        cookout.setDescription("You won't want to miss this party!");
        cookout.setAttendees(Arrays.asList(User_1, User_2));
        sut.updateCookout(cookout);
        Cookout newCookout = sut.showCookoutDetails(1, 1);
        assertCookoutsMatch(cookout, newCookout);
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
