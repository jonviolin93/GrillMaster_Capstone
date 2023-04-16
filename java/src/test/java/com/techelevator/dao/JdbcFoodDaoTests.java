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

    private final Food FOOD_1 = new Food(1, "Hot Dog", "hotdogUrl", "Main", "user1");
    private final Food FOOD_2 = new Food(2, "Macaroni Salad", "macaroniUrl", "Side", "user2");
    private final Food FOOD_3 = new Food(3, "Brownie", "brownieUrl", "Dessert", "user3");
    private final Food FOOD_4 = new Food(4, "Soda", "sodaUrl", "Drink", "user1");
    private final Food FOOD_5 = new Food(5, "Burger", "burgerUrl", "Main", "user1");
    private final Food FOOD_6 = new Food(6, "Water", "waterUrl", "Drink", "user1");
    private final Food FOOD_7 = new Food(7, "Taco", "tacoUrl", "Main", "user1");

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
        //Arrange
        List<Food> foods = sut.listAllFood();
        //Act

        //Assert
        Assert.assertEquals(6, foods.size());
        assertFoodsMatch(FOOD_5, foods.get(0));
        assertFoodsMatch(FOOD_1, foods.get(1));
        assertFoodsMatch(FOOD_2, foods.get(2));
        assertFoodsMatch(FOOD_3, foods.get(3));
        assertFoodsMatch(FOOD_4, foods.get(4));
        assertFoodsMatch(FOOD_6, foods.get(5));
    }

    @Test
    public void showFoodItem_shows_food_by_id(){
        Food food = sut.showFoodItem(1);
        assertFoodsMatch(FOOD_1, food);
    }

    @Test
    public void addFoodItem_adds_food_returning_correct_id(){
        int addedFoodItemID = sut.addFoodItem(FOOD_7);
        Assert.assertEquals(FOOD_7.getId(), addedFoodItemID);
    }


    private void assertFoodsMatch(Food expected, Food actual) {
        Assert.assertEquals(expected.getId(), actual.getId());
        Assert.assertEquals(expected.getName(), actual.getName());
        Assert.assertEquals(expected.getCategory(), actual.getCategory());
    }
}
