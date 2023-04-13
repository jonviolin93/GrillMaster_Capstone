package com.techelevator.dao;

import com.techelevator.model.Cookout;
import com.techelevator.model.Food;
import com.techelevator.model.Order;
import com.techelevator.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
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

    private List<Food> foodList;
    private final Order ORDER_1 = new Order(1, 1, false, foodList, LocalTime.now());
    private final Order ORDER_2 = new Order(2, 2, false, foodList, LocalTime.now());
    private final Order ORDER_3 = new Order(1, 3, false, foodList, LocalTime.now());


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
    //Arrange
/*        Order newOrder = sut.createOrder(ORDER_1, 2);
        newOrder.setId(1);
        newOrder.setUserId(1);
        newOrder.setComplete(false);
        newOrder.setTime(LocalTime.now());
        newOrder.setFoodList(foodList);*/

    }

    @Test
    public void insertFoodIntoOrder_correctly_updates_order(){

    }

    @Test
    public void getOrderById_gets_correct_order(){

    }

    @Test
    public void ordersList_gets_correct_order_details_given_cookoutId(){

    }

    @Test
    public void completeOrder_marks_order_complete(){

    }

    @Test
    public void listFoodByOrderId_lists_correct_food(){
        //Arrange
        //Act
        //Assert
    }


    private void assertOrdersMatch(Order expected, Order actual) {
        Assert.assertEquals(expected.getId(), actual.getId());
        Assert.assertEquals(expected.getUserId(), actual.getUserId());
        Assert.assertEquals(expected.isComplete(), actual.isComplete());
        Assert.assertEquals(expected.getTime(), actual.getTime());
        Assert.assertEquals(expected.getFoodList(), actual.getFoodList());
    }
}
