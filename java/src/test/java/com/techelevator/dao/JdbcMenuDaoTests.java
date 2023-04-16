package com.techelevator.dao;

import com.techelevator.model.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

public class JdbcMenuDaoTests extends BaseDaoTests {

    private final User User_1 = new User(1, "user1", "user1", "user", "Attendee");
    private final User User_2 = new User(2, "user2", "user2", "user", "Grill Master");
    private final User User_3 = new User(3, "user3", "user3", "user", "Host");

    private List<User> attendees = Arrays.asList(User_1, User_2, User_3);

    private final Cookout COOKOUT_1 = new Cookout(1, "Jonathans B-Day!", LocalDate.of(2028, 04, 12),
            LocalTime.of(12, 00), "Jonathans Backyard", "Its a birthday in a backyard", attendees, 1);
    private final Cookout COOKOUT_2 = new Cookout(2, "Melis B-Day!", LocalDate.of(2028, 05, 13),
            LocalTime.of(12, 00), "DisneyWorld", "Its a Small World After All", attendees, 1);
    private final Cookout COOKOUT_3 = new Cookout(3, "Elliss B-Day!", LocalDate.of(2028, 06, 17),
            LocalTime.of(12, 00), "NASA Space Station", "To Infinity and Beyond", attendees, 2);
    private final Cookout COOKOUT_4 = new Cookout(4, "Camerons B-Day!", LocalDate.of(2028, 10, 5),
            LocalTime.of(12, 00), "Pentagon", "Everyone bring five items", attendees, 3);
    private final Cookout COOKOUT_5 = new Cookout(5, "Reds B-Day!", LocalDate.of(2028, 12, 31),
            LocalTime.of(12, 00), "Barbershop", "Check out that Doo", attendees, 1);

    private final Food FOOD_1 = new Food(1, "Hot Dog", "hotdogUrl", "Main", "user1");
    private final Food FOOD_2 = new Food(2, "Macaroni Salad", "macaroniUrl", "Side", "user2");
    private final Food FOOD_3 = new Food(3, "Brownie", "brownieUrl", "Dessert", "user3");
    private final Food FOOD_4 = new Food(4, "Soda", "sodaUrl", "Drink", "user1");

    private List<Food> foodList = Arrays.asList(FOOD_1, FOOD_2, FOOD_3, FOOD_4);
    private final Menu MENU_1 = new Menu(1, "Backyard Menu", false, foodList);
    private final Menu MENU_2 = new Menu(2, "NASA Menu", false, foodList);
    private final Menu MENU_3 = new Menu(3, "Hobbit Menu", true, foodList);


    private JdbcMenuDao sut;
    private Menu testMenu;

    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new JdbcMenuDao(jdbcTemplate);
        testMenu = new Menu();
    }

    @Test
    public void getFoodFromMenu_gets_correct_food_list(){
        List<Food> foods = sut.getFoodFromMenu(1);
        Assert.assertEquals(4, foods.size());
        assertFoodsMatch(FOOD_1, foods.get(0));
        assertFoodsMatch(FOOD_2, foods.get(1));
        assertFoodsMatch(FOOD_3, foods.get(2));
        assertFoodsMatch(FOOD_4, foods.get(3));
    }

    @Test
    public void getFavoritedMenus_gets_all_fave_menus_for_host(){
        List<Menu> menus = sut.getFavoritedMenus(3);
        Assert.assertEquals(1, menus.size());
        assertMenusMatch(MENU_3, menus.get(0));
    }

    @Test
    public void updateMenu_correctly_updates_menu(){
        Menu menu = sut.getMenuById(1);
        List<Food> foods = menu.getFoodItems();
        foods.remove(0);
        foods.add(0, new Food(5, "Burger", "burgerUrl", "Main", "user1" ));
        menu.setFoodItems(foods);
        menu.setName("BBQ");
        menu.setFavorited(true);
        sut.updateMenu(menu, "user1", 1, 1);
        Menu updatedMenu = sut.getMenuById(1);
        assertMenusMatch(menu, updatedMenu);
    }

    @Test
    public void createMenu_adds_correct_info_to_menu(){
        List<Food> newFoodList = Arrays.asList(foodList.get(0), foodList.get(3));
        Menu menu = new Menu(4, "My new Menu", false, newFoodList);
        int menuId = sut.createMenu(menu, 1);
        Menu retrievedMenu = sut.getMenuById(menuId);
        assertMenusMatch(menu, retrievedMenu);
    }

    private void assertFoodsMatch(Food expected, Food actual){
        Assert.assertEquals(expected.getId(), actual.getId());
        Assert.assertEquals(expected.getName(), actual.getName());
        Assert.assertEquals(expected.getImg(), actual.getImg());
        Assert.assertEquals(expected.getCategory(), actual.getCategory());
        Assert.assertEquals(expected.getAddedBy(), actual.getAddedBy());
    }

    private void assertMenusMatch(Menu expected, Menu actual) {
        Assert.assertEquals(expected.getId(), actual.getId());
        Assert.assertEquals(expected.getName(), actual.getName());
        Assert.assertEquals(expected.isFavorited(), actual.isFavorited());
        List<Food> foods = expected.getFoodItems();
        for (int i = 0; i < foods.size(); i++) {
            assertFoodsMatch(foods.get(i), actual.getFoodItems().get(i));
        }
    }
}
