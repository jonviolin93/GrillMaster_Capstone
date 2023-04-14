package com.techelevator.dao;

import com.techelevator.model.Cookout;
import com.techelevator.model.Food;
import com.techelevator.model.Order;
import com.techelevator.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.internal.matchers.Or;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

public class JdbcOrderDaoTests extends BaseDaoTests{

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

    private final Food FOOD_1 = new Food(1, "Hot Dog", "hotdogUrl", "Main", 1);
    private final Food FOOD_2 = new Food(2, "Macaroni Salad", "macaroniUrl", "Side", 2);
    private final Food FOOD_3 = new Food(3, "Brownie", "brownieUrl", "Dessert", 1);
    private final Food FOOD_4 = new Food(4, "Soda", "sodaUrl", "Drink", 1);
    private final Food FOOD_5 = new Food(5, "Water", "waterUrl", "Drink", 1);
    private List<Food> foodList = Arrays.asList(FOOD_1, FOOD_2, FOOD_3, FOOD_4);

    private final Order ORDER_1 = new Order(1, 1, false, (List.of(FOOD_1)), LocalTime.of(12, 00));
    private final Order ORDER_2 = new Order(2, 2, false, (List.of(FOOD_2)), LocalTime.of(12, 05));
    private final Order ORDER_3 = new Order(3, 1, false, (List.of(FOOD_3)), LocalTime.of(12, 06));


    private JdbcOrderDao sut;
    private Order testOrder;

    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new JdbcOrderDao(jdbcTemplate);
        testOrder = new Order();
    }

    @Test
    public void createOrder_creates_new_order_with_expected_data(){
        int createdOrderId = sut.createOrder(ORDER_3,1);
        Order retrievedOrder = sut.getOrderById(createdOrderId);
        assertOrdersMatch(ORDER_3, retrievedOrder);
    }

    @Test
    public void getOrderById_gets_correct_order(){
        Order expected = ORDER_1;

        Order actual = sut.getOrderById(1);

        assertOrdersMatch(expected, actual);
    }

    @Test
    public void ordersList_gets_correct_order_details_given_cookoutId(){
/*        List<Order> orders = sut.ordersList(1);
        Assert.assertEquals(2 , orders.size());*/
    }

    @Test
    public void completeOrder_marks_order_complete(){

    }

    private void assertFoodsMatch(Food expected, Food actual){
        Assert.assertEquals(expected.getId(), actual.getId());
        Assert.assertEquals(expected.getName(), actual.getName());
        Assert.assertEquals(expected.getImg(), actual.getImg());
        Assert.assertEquals(expected.getCategory(), actual.getCategory());
        Assert.assertEquals(expected.getQuantity(), actual.getQuantity());
    }

    private void assertOrdersMatch(Order expected, Order actual) {
        Assert.assertEquals(expected.getId(), actual.getId());
        Assert.assertEquals(expected.getUserId(), actual.getUserId());
        Assert.assertEquals(expected.isComplete(), actual.isComplete());
        Assert.assertEquals(expected.getTime(), actual.getTime());
        List<Food> foods = expected.getFoodList();
        for (int i = 0; i < foods.size(); i++) {
            assertFoodsMatch(foods.get(i), actual.getFoodList().get(i));
        }
    }
}
