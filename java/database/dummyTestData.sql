BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('Cameron','password','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('Ellis','password','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('Jonathan','password','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('Meli','password','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('Reading','password','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('Joshua','password','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('Yehudis','password','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('David','password','ROLE_USER');


INSERT INTO menu (name) VALUES ('Backyard Menu');
INSERT INTO menu (name) VALUES ('NASA Menu');
INSERT INTO menu (name, is_favorited) VALUES ('Hobbit Menu', true);

INSERT INTO food (name, image, category_id)
VALUES ('Hot Dog', 'hotdogUrl', 1);
INSERT INTO food (name, image, category_id)
VALUES ('Burger', 'burgerUrl', 1);
INSERT INTO food (name, image, category_id)
VALUES ('Brat', 'bratUrl', 1);
INSERT INTO food (name, image, category_id)
VALUES ('Brisket', 'brisketUrl', 1);
INSERT INTO food (name, image, category_id)
VALUES ('Ribs', 'ribsUrl', 1);
INSERT INTO food (name, image, category_id)
VALUES ('BBQ Chicken', 'bbqchickenUrl', 1);
INSERT INTO food (name, image, category_id)
VALUES ('Steak', 'steakUrl', 1);
INSERT INTO food (name, image, category_id)
VALUES ('Sausage', 'sausageUrl', 1);
INSERT INTO food (name, image, category_id)
VALUES ('Pulled Pork', 'pulledPorkUrl', 1);
INSERT INTO food (name, image, category_id)
VALUES ('Catfish', 'catfishUrl', 1);

INSERT INTO food (name, image, category_id)
VALUES ('Macaroni Salad', 'macaroniUrl', 2);
INSERT INTO food (name, image, category_id)
VALUES ('Potato Salad', 'potatoSaladUrl', 2);
INSERT INTO food (name, image, category_id)
VALUES ('Baked Beans', 'beansUrl', 2);
INSERT INTO food (name, image, category_id)
VALUES ('Coleslaw', 'coleslawUrl', 2);
INSERT INTO food (name, image, category_id)
VALUES ('Corn on the Cob', 'cornUrl', 2);
INSERT INTO food (name, image, category_id)
VALUES ('Stuffed Peppers', 'stuffedPeppersUrl', 2);
INSERT INTO food (name, image, category_id)
VALUES ('Jalapeno Poppers', 'jalaPoppersUrl', 2);
INSERT INTO food (name, image, category_id)
VALUES ('Salad', 'saladUrl', 2);
INSERT INTO food (name, image, category_id)
VALUES ('Watermelon', 'watermelonUrl', 2);
INSERT INTO food (name, image, category_id)
VALUES ('Little Smokies', 'littleSmokiesUrl', 2);

INSERT INTO food (name, image, category_id)
VALUES ('Brownie', 'brownieUrl', 3);
INSERT INTO food (name, image, category_id)
VALUES ('Pistachio Salad', 'pistachioSaladUrl', 3);
INSERT INTO food (name, image, category_id)
VALUES ('Popsicle', 'popsicleUrl', 3);
INSERT INTO food (name, image, category_id)
VALUES ('Ice Cream', 'iceCreamUrl', 3);
INSERT INTO food (name, image, category_id)
VALUES ('Rice Krispie Treat', 'riceKrispieUrl', 3);
INSERT INTO food (name, image, category_id)
VALUES ('Strawberry Shortcake', 'riceKrispieUrl', 3);
INSERT INTO food (name, image, category_id)
VALUES ('Flan', 'flanUrl', 3);
INSERT INTO food (name, image, category_id)
VALUES ('Tres Leche Cake', 'tresLecheUrl', 3);
INSERT INTO food (name, image, category_id)
VALUES ('Apple Pie', 'applePieUrl', 3);
INSERT INTO food (name, image, category_id)
VALUES ('Mochi', 'mochiUrl', 3);

INSERT INTO food (name, image, category_id)
VALUES ('Dr Pepper', 'drpUrl', 4);
INSERT INTO food (name, image, category_id)
VALUES ('Water', 'waterUrl', 4);
INSERT INTO food (name, image, category_id)
VALUES ('Coke', 'cokeUrl', 4);
INSERT INTO food (name, image, category_id)
VALUES ('Diet Coke', 'dietCokeUrl', 4);
INSERT INTO food (name, image, category_id)
VALUES ('Diet Dr Pepper', 'dietdrpUrl', 4);
INSERT INTO food (name, image, category_id)
VALUES ('hi-c', 'hi-cUrl', 4);
INSERT INTO food (name, image, category_id)
VALUES ('lemonade', 'lemonadeUrl', 4);
INSERT INTO food (name, image, category_id)
VALUES ('beer', 'beerUrl', 4);
INSERT INTO food (name, image, category_id)
VALUES ('sweet tea', 'sweetTeaUrl', 4);
INSERT INTO food (name, image, category_id)
VALUES ('kool-aid', 'koolaidUrl', 4);


INSERT INTO food_menu (food_id, menu_id, added_by_id)
VALUES (1, 1, 1);
INSERT INTO food_menu (food_id, menu_id, added_by_id)
VALUES (2, 1, 2);
INSERT INTO food_menu (food_id, menu_id, added_by_id)
VALUES (3, 1, 3);
INSERT INTO food_menu (food_id, menu_id, added_by_id)
VALUES (4, 1, 1);

INSERT INTO food_menu (food_id, menu_id, added_by_id)
VALUES (1, 2, 1);
INSERT INTO food_menu (food_id, menu_id, added_by_id)
VALUES (2, 2, 2);
INSERT INTO food_menu (food_id, menu_id, added_by_id)
VALUES (3, 2, 3);
INSERT INTO food_menu (food_id, menu_id, added_by_id)
VALUES (4, 2, 1);

INSERT INTO food_menu (food_id, menu_id, added_by_id)
VALUES (1, 3, 1);
INSERT INTO food_menu (food_id, menu_id, added_by_id)
VALUES (2, 3, 2);
INSERT INTO food_menu (food_id, menu_id, added_by_id)
VALUES (3, 3, 3);
INSERT INTO food_menu (food_id, menu_id, added_by_id)
VALUES (4, 3, 1);

INSERT INTO cookout (name, cookout_date, cookout_time, location, description, menu_id)
    VALUES ('Jonathans B-Day!', '2028-04-12', '12:00:00', 'Jonathans Backyard', 'Its a birthday in a backyard', 1);
INSERT INTO cookout (name, cookout_date, cookout_time, location, description, menu_id)
    VALUES ('Melis B-Day!', '2028-05-13', '12:00:00', 'DisneyWorld', 'Its a Small World After All', 1);
INSERT INTO cookout (name, cookout_date, cookout_time, location, description, menu_id)
    VALUES ('Elliss B-Day!', '2028-06-17', '12:00:00', 'NASA Space Station', 'To Infinity and Beyond', 2);
INSERT INTO cookout (name, cookout_date, cookout_time, location, description, menu_id)
    VALUES ('Camerons B-Day!', '2028-10-5', '12:00:00', 'Pentagon', 'Everyone bring five items', 3);
INSERT INTO cookout (name, cookout_date, cookout_time, location, description, menu_id)
    VALUES ('Jonathans Anniversary!', '2026-05-12', '12:00:00', 'Jonathans Backyard', 'Its a birthday in a backyard', 1);
INSERT INTO cookout (name, cookout_date, cookout_time, location, description, menu_id)
    VALUES ('Melis Anniversary!', '2026-09-13', '12:00:00', 'DisneyWorld', 'Its a Small World After All', 1);
INSERT INTO cookout (name, cookout_date, cookout_time, location, description, menu_id)
    VALUES ('Elliss Anniversary!', '2026-11-17', '12:00:00', 'NASA Space Station', 'To Infinity and Beyond', 2);
INSERT INTO cookout (name, cookout_date, cookout_time, location, description, menu_id)
    VALUES ('Camerons Anniversary!', '2026-02-5', '12:00:00', 'Pentagon', 'Everyone bring five items', 3);
INSERT INTO cookout (name, cookout_date, cookout_time, location, description, menu_id)
    VALUES ('Jonathans Graduation!', '2027-02-12', '12:00:00', 'Jonathans Backyard', 'Its a birthday in a backyard', 1);
INSERT INTO cookout (name, cookout_date, cookout_time, location, description, menu_id)
    VALUES ('Melis Graduation!', '2027-03-13', '12:00:00', 'DisneyWorld', 'Its a Small World After All', 1);
INSERT INTO cookout (name, cookout_date, cookout_time, location, description, menu_id)
    VALUES ('Elliss Graduation!', '2027-07-17', '12:00:00', 'NASA Space Station', 'To Infinity and Beyond', 2);
INSERT INTO cookout (name, cookout_date, cookout_time, location, description, menu_id)
    VALUES ('Camerons Graduation!', '2027-12-5', '12:00:00', 'Pentagon', 'Everyone bring five items', 3);


INSERT INTO user_cookout (user_id, cookout_id, duty_id)
    VALUES (1, 1, 3);
INSERT INTO user_cookout (user_id, cookout_id, duty_id)
    VALUES (2, 1, 2);
INSERT INTO user_cookout (user_id, cookout_id, duty_id)
    VALUES (3, 1, 1);

INSERT INTO user_cookout (user_id, cookout_id, duty_id)
    VALUES (1, 2, 2);
INSERT INTO user_cookout (user_id, cookout_id, duty_id)
    VALUES (2, 2, 3);
INSERT INTO user_cookout (user_id, cookout_id, duty_id)
    VALUES (3, 2, 1);

INSERT INTO user_cookout (user_id, cookout_id, duty_id)
    VALUES (1, 3, 1);
INSERT INTO user_cookout (user_id, cookout_id, duty_id)
    VALUES (2, 3, 3);
INSERT INTO user_cookout (user_id, cookout_id, duty_id)
    VALUES (3, 3, 2);

INSERT INTO user_cookout (user_id, cookout_id, duty_id)
    VALUES (1, 4, 3);
INSERT INTO user_cookout (user_id, cookout_id, duty_id)
    VALUES (2, 4, 2);
INSERT INTO user_cookout (user_id, cookout_id, duty_id)
    VALUES (3, 4, 1);

INSERT INTO user_cookout (user_id, cookout_id, duty_id)
    VALUES (1, 5, 2);
INSERT INTO user_cookout (user_id, cookout_id, duty_id)
    VALUES (2, 5, 1);
INSERT INTO user_cookout (user_id, cookout_id, duty_id)
    VALUES (3, 5, 3);

INSERT INTO user_cookout (user_id, cookout_id, duty_id)
    VALUES (1, 6, 3);
INSERT INTO user_cookout (user_id, cookout_id, duty_id)
    VALUES (2, 6, 2);
INSERT INTO user_cookout (user_id, cookout_id, duty_id)
    VALUES (3, 6, 1);

INSERT INTO user_cookout (user_id, cookout_id, duty_id)
    VALUES (1, 7, 2);
INSERT INTO user_cookout (user_id, cookout_id, duty_id)
    VALUES (2, 7, 1);
INSERT INTO user_cookout (user_id, cookout_id, duty_id)
    VALUES (3, 7, 3);

INSERT INTO user_cookout (user_id, cookout_id, duty_id)
    VALUES (1, 8, 3);
INSERT INTO user_cookout (user_id, cookout_id, duty_id)
    VALUES (2, 8, 2);
INSERT INTO user_cookout (user_id, cookout_id, duty_id)
    VALUES (3, 8, 1);

INSERT INTO user_cookout (user_id, cookout_id, duty_id)
    VALUES (1, 9, 2);
INSERT INTO user_cookout (user_id, cookout_id, duty_id)
    VALUES (2, 9, 1);
INSERT INTO user_cookout (user_id, cookout_id, duty_id)
    VALUES (3, 9, 3);

INSERT INTO user_cookout (user_id, cookout_id, duty_id)
    VALUES (1, 10, 3);
INSERT INTO user_cookout (user_id, cookout_id, duty_id)
    VALUES (2, 10, 1);
INSERT INTO user_cookout (user_id, cookout_id, duty_id)
    VALUES (3, 10, 2);

INSERT INTO user_cookout (user_id, cookout_id, duty_id)
    VALUES (1, 11, 1);
INSERT INTO user_cookout (user_id, cookout_id, duty_id)
    VALUES (2, 11, 2);
INSERT INTO user_cookout (user_id, cookout_id, duty_id)
    VALUES (3, 11, 1);

INSERT INTO user_cookout (user_id, cookout_id, duty_id)
    VALUES (1, 12, 1);
INSERT INTO user_cookout (user_id, cookout_id, duty_id)
    VALUES (2, 12, 2);
INSERT INTO user_cookout (user_id, cookout_id, duty_id)
    VALUES (3, 12, 1);

INSERT INTO cookout_order (cookout_id, user_id, order_time)
    VALUES (1, 1, '12:00:00');

INSERT INTO cookout_order (cookout_id, user_id, order_time)
    VALUES (1, 2, '12:05:00');

INSERT INTO cookout_order (cookout_id, user_id, order_time)
    VALUES (1, 1, '12:06:00');

INSERT INTO order_food (order_id, food_id, quantity)
    VALUES(1, 1, 1);

INSERT INTO order_food (order_id, food_id, quantity)
    VALUES(2, 2, 2);

INSERT INTO order_food (order_id, food_id, quantity)
    VALUES(3, 3, 1);
	

COMMIT TRANSACTION;