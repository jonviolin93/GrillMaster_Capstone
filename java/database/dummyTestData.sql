BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user1','user1','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('user2','user2','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('user3','user3','ROLE_USER');

INSERT INTO menu (name) VALUES ('Backyard Menu');
INSERT INTO menu (name) VALUES ('NASA Menu');
INSERT INTO menu (name, is_favorited) VALUES ('Hobbit Menu', true);

INSERT INTO food (name, image, category_id)
VALUES ('Hot Dog', 'hotdogUrl', 1);
INSERT INTO food (name, image, category_id)
VALUES ('Macaroni Salad', 'macaroniUrl', 2);
INSERT INTO food (name, image, category_id)
VALUES ('Brownie', 'brownieUrl', 3);
INSERT INTO food (name, image, category_id)
VALUES ('Soda', 'sodaUrl', 4);
INSERT INTO food (name, image, category_id)
VALUES ('Burgers', 'burgerUrl', 1);

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

INSERT INTO user_cookout (user_id, cookout_id, duty_id)
    VALUES (1, 1, 3);
INSERT INTO user_cookout (user_id, cookout_id, duty_id)
    VALUES (2, 1, 2);
INSERT INTO user_cookout (user_id, cookout_id, duty_id)
    VALUES (3, 1, 1);

INSERT INTO user_cookout (user_id, cookout_id, duty_id)
    VALUES (1, 2, 3);
INSERT INTO user_cookout (user_id, cookout_id, duty_id)
    VALUES (2, 2, 2);
INSERT INTO user_cookout (user_id, cookout_id, duty_id)
    VALUES (3, 2, 1);

INSERT INTO user_cookout (user_id, cookout_id, duty_id)
    VALUES (1, 3, 3);
INSERT INTO user_cookout (user_id, cookout_id, duty_id)
    VALUES (2, 3, 2);
INSERT INTO user_cookout (user_id, cookout_id, duty_id)
    VALUES (3, 3, 1);

INSERT INTO user_cookout (user_id, cookout_id, duty_id)
    VALUES (1, 4, 3);
INSERT INTO user_cookout (user_id, cookout_id, duty_id)
    VALUES (2, 4, 2);
INSERT INTO user_cookout (user_id, cookout_id, duty_id)
    VALUES (3, 4, 1);

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