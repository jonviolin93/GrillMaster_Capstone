package com.techelevator.dao;

import com.techelevator.model.Cookout;
import com.techelevator.model.Food;
import com.techelevator.model.Menu;
import com.techelevator.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

public class JdbcFoodDaoTests extends BaseDaoTests {

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

    private final Food FOOD_1 = new Food(1, "Hot Dog", "hotdogUrl", "Main", "user1");
    private final Food FOOD_2 = new Food(2, "Macaroni Salad", "macaroniUrl", "Side", "user2");
    private final Food FOOD_3 = new Food(3, "Brownie", "brownieUrl", "Dessert", "user3");
    private final Food FOOD_4 = new Food(4, "Soda", "sodaUrl", "Drink", "user1");

    private List<Food> foodList = Arrays.asList(FOOD_1, FOOD_2, FOOD_3, FOOD_4);

    private JdbcFoodDao sut;
    private Food testFood;

    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new JdbcFoodDao(jdbcTemplate);
        testFood = new Food();
    }

    @Test
    public void listAllFood_lists_all_foods(){
/*        //Arrange
        foodList = sut.listAllFood();
        //Act

        //Assert
        Assert.assertEquals(4, foodList.size());
        assertFoodsMatch(FOOD_1, foodList.get(0));
        assertFoodsMatch(FOOD_2, foodList.get(1));
        assertFoodsMatch(FOOD_3, foodList.get(2));
        assertFoodsMatch(FOOD_4, foodList.get(3));*/
    }

    @Test
    public void showFoodItem_shows_food_by_id(){
/*      Food food = sut.showFoodItem(1);
        assertFoodsMatch(FOOD_1, food);*/
    }

    @Test
    public void addFoodItem_adds_food_returning_correct_id(){
/*        int addedFoodItemID = sut.addFoodItem(FOOD_4);
        Food retrievedFoodItem = sut.showFoodItem(addedFoodItemID);
        assertFoodsMatch(FOOD_4, retrievedFoodItem);*/
    }


    private void assertFoodsMatch(Food expected, Food actual) {
        Assert.assertEquals(expected.getId(), actual.getId());
        Assert.assertEquals(expected.getName(), actual.getName());
    }
}
