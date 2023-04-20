BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('Cameron','$2a$10$wGG/k36ZXjp63HjNxFf1a.UPrcVK0ApqSDJtlY1FVqFmIej1UsT/G','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('Ellis','$2a$10$wGG/k36ZXjp63HjNxFf1a.UPrcVK0ApqSDJtlY1FVqFmIej1UsT/G','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('Yehudis','$2a$10$wGG/k36ZXjp63HjNxFf1a.UPrcVK0ApqSDJtlY1FVqFmIej1UsT/G','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('Meli','$2a$10$wGG/k36ZXjp63HjNxFf1a.UPrcVK0ApqSDJtlY1FVqFmIej1UsT/G','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('Redding','$2a$10$wGG/k36ZXjp63HjNxFf1a.UPrcVK0ApqSDJtlY1FVqFmIej1UsT/G','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('Joshua','$2a$10$wGG/k36ZXjp63HjNxFf1a.UPrcVK0ApqSDJtlY1FVqFmIej1UsT/G','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('Jonathan','$2a$10$wGG/k36ZXjp63HjNxFf1a.UPrcVK0ApqSDJtlY1FVqFmIej1UsT/G','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('David','$2a$10$wGG/k36ZXjp63HjNxFf1a.UPrcVK0ApqSDJtlY1FVqFmIej1UsT/G','ROLE_USER');



INSERT INTO menu (name) VALUES ('Backyard Menu');
INSERT INTO menu (name) VALUES ('NASA Party Menu');
INSERT INTO menu (name, is_favorited) VALUES ('Hobbit Party Menu', true);
INSERT INTO menu (name) VALUES ('Pool Party Menu');
INSERT INTO menu (name) VALUES ('Birthday Party Menu');
INSERT INTO menu (name) VALUES ('Graduation Party Menu');
INSERT INTO menu (name) VALUES ('Block Party Menu');
INSERT INTO menu (name) VALUES ('Camping Party Menu');
INSERT INTO menu (name) VALUES ('Tailgate Party Menu');
INSERT INTO menu (name) VALUES ('Office Party Menu');



INSERT INTO food (name, image, category_id) VALUES ('Hot Dog', 'hotdogUrl', 1);
INSERT INTO food (name, image, category_id) VALUES ('Burger', 'burgerUrl', 1);
INSERT INTO food (name, image, category_id) VALUES ('Brat', 'bratUrl', 1);
INSERT INTO food (name, image, category_id) VALUES ('Brisket', 'brisketUrl', 1);
INSERT INTO food (name, image, category_id) VALUES ('Ribs', 'ribsUrl', 1);
INSERT INTO food (name, image, category_id) VALUES ('BBQ Chicken', 'bbqchickenUrl', 1);
INSERT INTO food (name, image, category_id) VALUES ('Steak', 'steakUrl', 1);
INSERT INTO food (name, image, category_id) VALUES ('Sausage', 'sausageUrl', 1);
INSERT INTO food (name, image, category_id) VALUES ('Pulled Pork', 'pulledPorkUrl', 1);
INSERT INTO food (name, image, category_id) VALUES ('Catfish', 'catfishUrl', 1);

INSERT INTO food (name, image, category_id) VALUES ('Macaroni Salad', 'macaroniUrl', 2);
INSERT INTO food (name, image, category_id) VALUES ('Potato Salad', 'potatoSaladUrl', 2);
INSERT INTO food (name, image, category_id) VALUES ('Baked Beans', 'beansUrl', 2);
INSERT INTO food (name, image, category_id) VALUES ('Coleslaw', 'coleslawUrl', 2);
INSERT INTO food (name, image, category_id) VALUES ('Corn on the Cob', 'cornUrl', 2);
INSERT INTO food (name, image, category_id) VALUES ('Stuffed Peppers', 'stuffedPeppersUrl', 2);
INSERT INTO food (name, image, category_id) VALUES ('Jalapeno Poppers', 'jalaPoppersUrl', 2);
INSERT INTO food (name, image, category_id) VALUES ('Salad', 'saladUrl', 2);
INSERT INTO food (name, image, category_id) VALUES ('Watermelon', 'watermelonUrl', 2);
INSERT INTO food (name, image, category_id) VALUES ('Little Smokies', 'littleSmokiesUrl', 2);

INSERT INTO food (name, image, category_id) VALUES ('Brownie', 'brownieUrl', 3);
INSERT INTO food (name, image, category_id) VALUES ('Pistachio Salad', 'pistachioSaladUrl', 3);
INSERT INTO food (name, image, category_id) VALUES ('Popsicle', 'popsicleUrl', 3);
INSERT INTO food (name, image, category_id) VALUES ('Ice Cream', 'iceCreamUrl', 3);
INSERT INTO food (name, image, category_id) VALUES ('Rice Krispie Treat', 'riceKrispieUrl', 3);
INSERT INTO food (name, image, category_id) VALUES ('Strawberry Shortcake', 'riceKrispieUrl', 3);
INSERT INTO food (name, image, category_id) VALUES ('Flan', 'flanUrl', 3);
INSERT INTO food (name, image, category_id) VALUES ('Tres Leche Cake', 'tresLecheUrl', 3);
INSERT INTO food (name, image, category_id) VALUES ('Apple Pie', 'applePieUrl', 3);
INSERT INTO food (name, image, category_id) VALUES ('Mochi', 'mochiUrl', 3);

INSERT INTO food (name, image, category_id) VALUES ('Dr Pepper', 'drpUrl', 4);
INSERT INTO food (name, image, category_id) VALUES ('Water', 'waterUrl', 4);
INSERT INTO food (name, image, category_id) VALUES ('Coke', 'cokeUrl', 4);
INSERT INTO food (name, image, category_id) VALUES ('Diet Coke', 'dietCokeUrl', 4);
INSERT INTO food (name, image, category_id) VALUES ('Diet Dr Pepper', 'dietdrpUrl', 4);
INSERT INTO food (name, image, category_id) VALUES ('hi-c', 'hi-cUrl', 4);
INSERT INTO food (name, image, category_id) VALUES ('lemonade', 'lemonadeUrl', 4);
INSERT INTO food (name, image, category_id) VALUES ('beer', 'beerUrl', 4);
INSERT INTO food (name, image, category_id) VALUES ('sweet tea', 'sweetTeaUrl', 4);
INSERT INTO food (name, image, category_id) VALUES ('kool-aid', 'koolaidUrl', 4);



INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (1, 1, 3);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (2, 1, 4);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (3, 1, 5);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (4, 1, 4);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (11, 1, 3);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (12, 1, 4);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (13, 1, 3);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (21, 1, 5);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (31, 1, 5);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (33, 1, 3);

INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (1, 2, 1);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (2, 2, 2);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (7, 2, 3);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (8, 2, 1);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (9, 2, 1);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (14, 2, 2);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (16, 2, 3);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (21, 2, 1);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (22, 2, 1);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (26, 2, 2);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (35, 2, 3);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (37, 2, 1);

INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (6, 3, 1);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (7, 3, 2);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (8, 3, 3);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (9, 3, 1);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (12, 3, 1);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (15, 3, 2);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (17, 3, 3);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (18, 3, 1);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (23, 3, 1);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (24, 3, 2);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (27, 3, 3);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (29, 3, 1);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (30, 3, 1);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (32, 3, 2);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (33, 3, 3);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (34, 3, 1);

INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (9, 4, 1);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (10, 4, 2);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (11, 4, 3);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (12, 4, 1);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (21, 4, 1);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (22, 4, 2);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (33, 4, 3);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (36, 4, 1);

INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (6, 5, 1);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (7, 5, 2);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (9, 5, 3);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (10, 5, 1);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (11, 5, 1);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (14, 5, 2);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (15, 5, 3);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (24, 5, 1);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (27, 5, 1);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (28, 5, 2);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (31, 5, 3);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (38, 5, 1);

INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (5, 6, 1);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (8, 6, 2);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (9, 6, 3);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (10, 6, 1);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (13, 6, 1);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (16, 6, 2);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (23, 6, 3);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (34, 6, 1);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (40, 6, 2);

INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (7, 7, 1);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (8, 7, 2);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (9, 7, 3);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (10, 7, 1);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (17, 7, 1);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (18, 7, 2);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (19, 7, 3);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (20, 7, 1);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (27, 7, 1);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (28, 7, 2);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (29, 7, 3);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (30, 7, 1);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (37, 7, 1);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (38, 7, 2);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (39, 7, 3);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (40, 7, 1);

INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (1, 8, 1);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (6, 8, 2);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (9, 8, 3);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (14, 8, 1);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (18, 8, 1);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (20, 8, 2);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (22, 8, 3);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (24, 8, 1);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (30, 8, 1);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (32, 8, 2);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (33, 8, 3);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (35, 8, 1);

INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (1, 9, 1);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (2, 9, 2);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (6, 9, 3);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (12, 9, 1);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (13, 9, 1);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (20, 9, 2);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (23, 9, 3);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (26, 9, 1);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (31, 9, 1);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (32, 9, 2);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (36, 9, 3);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (38, 9, 1);

INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (21, 10, 1);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (23, 10, 2);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (24, 10, 3);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (25, 10, 1);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (27, 10, 1);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (28, 10, 2);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (29, 10, 3);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (30, 10, 1);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (32, 10, 1);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (34, 10, 2);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (35, 10, 3);
INSERT INTO food_menu (food_id, menu_id, added_by_id) VALUES (38, 10, 1);



INSERT INTO cookout (name, cookout_date, cookout_time, location, description, menu_id)
    VALUES ('Jonathans B-Day!', '2028-04-12', '12:00:00', 'Jonathans Backyard', 'Its a birthday in a backyard', 1);
INSERT INTO cookout (name, cookout_date, cookout_time, location, description, menu_id)
    VALUES ('Melis B-Day!', '2028-05-13', '12:00:00', 'DisneyWorld', 'Its a Small World After All', 2);
INSERT INTO cookout (name, cookout_date, cookout_time, location, description, menu_id)
    VALUES ('Elliss B-Day!', '2028-06-17', '12:00:00', 'NASA Space Station', 'To Infinity and Beyond', 3);
INSERT INTO cookout (name, cookout_date, cookout_time, location, description, menu_id)
    VALUES ('Camerons B-Day!', '2028-10-5', '12:00:00', 'Pentagon', 'Everyone bring five items', 4);
INSERT INTO cookout (name, cookout_date, cookout_time, location, description, menu_id)
    VALUES ('Jonathans Anniversary!', '2026-05-12', '12:00:00', 'Jonathans Backyard', 'Its a birthday in a backyard', 5);
INSERT INTO cookout (name, cookout_date, cookout_time, location, description, menu_id)
    VALUES ('Melis Anniversary!', '2026-09-13', '12:00:00', 'DisneyWorld', 'Its a Small World After All', 6);
INSERT INTO cookout (name, cookout_date, cookout_time, location, description, menu_id)
    VALUES ('Elliss Anniversary!', '2026-11-17', '12:00:00', 'NASA Space Station', 'To Infinity and Beyond', 7);
INSERT INTO cookout (name, cookout_date, cookout_time, location, description, menu_id)
    VALUES ('Camerons Anniversary!', '2026-02-5', '12:00:00', 'Pentagon', 'Everyone bring five items', 8);
INSERT INTO cookout (name, cookout_date, cookout_time, location, description, menu_id)
    VALUES ('Jonathans Graduation!', '2027-02-12', '12:00:00', 'Jonathans Backyard', 'Its a birthday in a backyard', 9);
INSERT INTO cookout (name, cookout_date, cookout_time, location, description, menu_id)
    VALUES ('Melis Graduation!', '2023-04-21', '4:00:00', 'DisneyWorld', 'Its a Small World After All', 10);
INSERT INTO cookout (name, cookout_date, cookout_time, location, description, menu_id)
    VALUES ('Elliss Graduation!', '2027-07-17', '12:00:00', 'NASA Space Station', 'To Infinity and Beyond', 5);
INSERT INTO cookout (name, cookout_date, cookout_time, location, description, menu_id)
    VALUES ('Camerons Graduation!', '2027-12-5', '12:00:00', 'Pentagon', 'Everyone bring five items', 7);



INSERT INTO user_cookout (user_id, cookout_id, duty_id) VALUES (3, 1, 1);
INSERT INTO user_cookout (user_id, cookout_id, duty_id) VALUES (4, 1, 2);
INSERT INTO user_cookout (user_id, cookout_id, duty_id) VALUES (5, 1, 3);
INSERT INTO user_cookout (user_id, cookout_id, duty_id) VALUES (6, 1, 3);
INSERT INTO user_cookout (user_id, cookout_id, duty_id) VALUES (7, 1, 3);
INSERT INTO user_cookout (user_id, cookout_id, duty_id) VALUES (8, 1, 3);
INSERT INTO user_cookout (user_id, cookout_id, duty_id) VALUES (9, 1, 3);
INSERT INTO user_cookout (user_id, cookout_id, duty_id) VALUES (10, 1, 3);

INSERT INTO user_cookout (user_id, cookout_id, duty_id) VALUES (3, 2, 2);
INSERT INTO user_cookout (user_id, cookout_id, duty_id) VALUES (4, 2, 3);
INSERT INTO user_cookout (user_id, cookout_id, duty_id) VALUES (5, 2, 1);
INSERT INTO user_cookout (user_id, cookout_id, duty_id) VALUES (6, 2, 3);
INSERT INTO user_cookout (user_id, cookout_id, duty_id) VALUES (7, 2, 3);

INSERT INTO user_cookout (user_id, cookout_id, duty_id) VALUES (4, 3, 3);
INSERT INTO user_cookout (user_id, cookout_id, duty_id) VALUES (6, 3, 3);
INSERT INTO user_cookout (user_id, cookout_id, duty_id) VALUES (7, 3, 3);
INSERT INTO user_cookout (user_id, cookout_id, duty_id) VALUES (8, 3, 1);
INSERT INTO user_cookout (user_id, cookout_id, duty_id) VALUES (9, 3, 2);
INSERT INTO user_cookout (user_id, cookout_id, duty_id) VALUES (10, 3, 3);

INSERT INTO user_cookout (user_id, cookout_id, duty_id) VALUES (3, 4, 3);
INSERT INTO user_cookout (user_id, cookout_id, duty_id) VALUES (4, 4, 3);
INSERT INTO user_cookout (user_id, cookout_id, duty_id) VALUES (5, 4, 3);
INSERT INTO user_cookout (user_id, cookout_id, duty_id) VALUES (8, 4, 3);
INSERT INTO user_cookout (user_id, cookout_id, duty_id) VALUES (10, 4, 2);
INSERT INTO user_cookout (user_id, cookout_id, duty_id) VALUES (9, 4, 1);

INSERT INTO user_cookout (user_id, cookout_id, duty_id) VALUES (5, 5, 3);
INSERT INTO user_cookout (user_id, cookout_id, duty_id) VALUES (9, 5, 1);
INSERT INTO user_cookout (user_id, cookout_id, duty_id) VALUES (8, 5, 3);
INSERT INTO user_cookout (user_id, cookout_id, duty_id) VALUES (3, 5, 2);
INSERT INTO user_cookout (user_id, cookout_id, duty_id) VALUES (4, 5, 3);
INSERT INTO user_cookout (user_id, cookout_id, duty_id) VALUES (6, 5, 3);

INSERT INTO user_cookout (user_id, cookout_id, duty_id) VALUES (10, 6, 3);
INSERT INTO user_cookout (user_id, cookout_id, duty_id) VALUES (9, 6, 2);
INSERT INTO user_cookout (user_id, cookout_id, duty_id) VALUES (8, 6, 1);
INSERT INTO user_cookout (user_id, cookout_id, duty_id) VALUES (7, 6, 3);
INSERT INTO user_cookout (user_id, cookout_id, duty_id) VALUES (6, 6, 3);
INSERT INTO user_cookout (user_id, cookout_id, duty_id) VALUES (5, 6, 3);
INSERT INTO user_cookout (user_id, cookout_id, duty_id) VALUES (4, 6, 3);
INSERT INTO user_cookout (user_id, cookout_id, duty_id) VALUES (3, 6, 3);

INSERT INTO user_cookout (user_id, cookout_id, duty_id) VALUES (10, 7, 2);
INSERT INTO user_cookout (user_id, cookout_id, duty_id) VALUES (9, 7, 1);
INSERT INTO user_cookout (user_id, cookout_id, duty_id) VALUES (7, 7, 3);
INSERT INTO user_cookout (user_id, cookout_id, duty_id) VALUES (6, 7, 3);
INSERT INTO user_cookout (user_id, cookout_id, duty_id) VALUES (4, 7, 3);
INSERT INTO user_cookout (user_id, cookout_id, duty_id) VALUES (3, 7, 3);

INSERT INTO user_cookout (user_id, cookout_id, duty_id) VALUES (10, 8, 3);
INSERT INTO user_cookout (user_id, cookout_id, duty_id) VALUES (9, 8, 2);
INSERT INTO user_cookout (user_id, cookout_id, duty_id) VALUES (8, 8, 3);
INSERT INTO user_cookout (user_id, cookout_id, duty_id) VALUES (6, 8, 3);
INSERT INTO user_cookout (user_id, cookout_id, duty_id) VALUES (5, 8, 3);
INSERT INTO user_cookout (user_id, cookout_id, duty_id) VALUES (4, 8, 1);
INSERT INTO user_cookout (user_id, cookout_id, duty_id) VALUES (3, 8, 3);

INSERT INTO user_cookout (user_id, cookout_id, duty_id) VALUES (7, 9, 2);
INSERT INTO user_cookout (user_id, cookout_id, duty_id) VALUES (3, 9, 1);
INSERT INTO user_cookout (user_id, cookout_id, duty_id) VALUES (5, 9, 3);
INSERT INTO user_cookout (user_id, cookout_id, duty_id) VALUES (8, 9, 3);
INSERT INTO user_cookout (user_id, cookout_id, duty_id) VALUES (10, 9, 3);

INSERT INTO user_cookout (user_id, cookout_id, duty_id) VALUES (4, 10, 3);
INSERT INTO user_cookout (user_id, cookout_id, duty_id) VALUES (6, 10, 1);
INSERT INTO user_cookout (user_id, cookout_id, duty_id) VALUES (8, 10, 2);
INSERT INTO user_cookout (user_id, cookout_id, duty_id) VALUES (10, 10, 3);
INSERT INTO user_cookout (user_id, cookout_id, duty_id) VALUES (3, 10, 3);
INSERT INTO user_cookout (user_id, cookout_id, duty_id) VALUES (5, 10, 3);
INSERT INTO user_cookout (user_id, cookout_id, duty_id) VALUES (7, 10, 3);
INSERT INTO user_cookout (user_id, cookout_id, duty_id) VALUES (9, 10, 3);

INSERT INTO user_cookout (user_id, cookout_id, duty_id) VALUES (3, 11, 1);
INSERT INTO user_cookout (user_id, cookout_id, duty_id) VALUES (5, 11, 2);
INSERT INTO user_cookout (user_id, cookout_id, duty_id) VALUES (7, 11, 3);
INSERT INTO user_cookout (user_id, cookout_id, duty_id) VALUES (9, 11, 3);

INSERT INTO user_cookout (user_id, cookout_id, duty_id) VALUES (8, 12, 1);
INSERT INTO user_cookout (user_id, cookout_id, duty_id) VALUES (6, 12, 2);
INSERT INTO user_cookout (user_id, cookout_id, duty_id) VALUES (7, 12, 3);
INSERT INTO user_cookout (user_id, cookout_id, duty_id) VALUES (5, 12, 3);
INSERT INTO user_cookout (user_id, cookout_id, duty_id) VALUES (3, 12, 3);
INSERT INTO user_cookout (user_id, cookout_id, duty_id) VALUES (10, 12, 3);
INSERT INTO user_cookout (user_id, cookout_id, duty_id) VALUES (9, 12, 3);



INSERT INTO cookout_order (cookout_id, user_id, order_time) VALUES (1, 3, '12:00:00');
INSERT INTO cookout_order (cookout_id, user_id, order_time) VALUES (1, 4, '12:03:00');
INSERT INTO cookout_order (cookout_id, user_id, order_time) VALUES (1, 5, '12:05:00');
INSERT INTO cookout_order (cookout_id, user_id, order_time) VALUES (1, 6, '12:06:00');
INSERT INTO cookout_order (cookout_id, user_id, order_time) VALUES (1, 7, '12:13:00');
INSERT INTO cookout_order (cookout_id, user_id, order_time) VALUES (1, 8, '12:18:00');
INSERT INTO cookout_order (cookout_id, user_id, order_time) VALUES (1, 9, '12:22:00');
INSERT INTO cookout_order (cookout_id, user_id, order_time) VALUES (1, 10, '12:29:00');

INSERT INTO cookout_order (cookout_id, user_id, order_time) VALUES (2, 3, '1:00:00');
INSERT INTO cookout_order (cookout_id, user_id, order_time) VALUES (2, 4, '1:05:00');
INSERT INTO cookout_order (cookout_id, user_id, order_time) VALUES (2, 5, '1:06:00');
INSERT INTO cookout_order (cookout_id, user_id, order_time) VALUES (2, 6, '1:09:00');
INSERT INTO cookout_order (cookout_id, user_id, order_time) VALUES (2, 7, '1:12:00');

INSERT INTO cookout_order (cookout_id, user_id, order_time) VALUES (3, 4, '2:00:00');
INSERT INTO cookout_order (cookout_id, user_id, order_time) VALUES (3, 6, '2:05:00');
INSERT INTO cookout_order (cookout_id, user_id, order_time) VALUES (3, 7, '2:06:00');
INSERT INTO cookout_order (cookout_id, user_id, order_time) VALUES (3, 8, '2:20:00');
INSERT INTO cookout_order (cookout_id, user_id, order_time) VALUES (3, 9, '2:25:00');
INSERT INTO cookout_order (cookout_id, user_id, order_time) VALUES (3, 10, '2:26:00');

INSERT INTO cookout_order (cookout_id, user_id, order_time) VALUES (4, 3, '3:00:00');
INSERT INTO cookout_order (cookout_id, user_id, order_time) VALUES (4, 4, '3:05:00');
INSERT INTO cookout_order (cookout_id, user_id, order_time) VALUES (4, 5, '3:06:00');
INSERT INTO cookout_order (cookout_id, user_id, order_time) VALUES (4, 8, '3:19:00');
INSERT INTO cookout_order (cookout_id, user_id, order_time) VALUES (4, 9, '3:23:00');
INSERT INTO cookout_order (cookout_id, user_id, order_time) VALUES (4, 10, '3:26:00');

INSERT INTO cookout_order (cookout_id, user_id, order_time) VALUES (5, 4, '4:00:00');
INSERT INTO cookout_order (cookout_id, user_id, order_time) VALUES (5, 3, '4:05:00');
INSERT INTO cookout_order (cookout_id, user_id, order_time) VALUES (5, 5, '4:06:00');
INSERT INTO cookout_order (cookout_id, user_id, order_time) VALUES (5, 6, '4:10:00');
INSERT INTO cookout_order (cookout_id, user_id, order_time) VALUES (5, 8, '4:15:00');
INSERT INTO cookout_order (cookout_id, user_id, order_time) VALUES (5, 9, '4:29:00');

INSERT INTO cookout_order (cookout_id, user_id, order_time) VALUES (6, 3, '5:00:00');
INSERT INTO cookout_order (cookout_id, user_id, order_time) VALUES (6, 4, '5:05:00');
INSERT INTO cookout_order (cookout_id, user_id, order_time) VALUES (6, 5, '5:06:00');
INSERT INTO cookout_order (cookout_id, user_id, order_time) VALUES (6, 6, '5:12:00');
INSERT INTO cookout_order (cookout_id, user_id, order_time) VALUES (6, 7, '5:26:00');
INSERT INTO cookout_order (cookout_id, user_id, order_time) VALUES (6, 8, '5:28:00');
INSERT INTO cookout_order (cookout_id, user_id, order_time) VALUES (6, 9, '5:34:00');
INSERT INTO cookout_order (cookout_id, user_id, order_time) VALUES (6, 10, '5:36:00');

INSERT INTO cookout_order (cookout_id, user_id, order_time) VALUES (7, 3, '6:00:00');
INSERT INTO cookout_order (cookout_id, user_id, order_time) VALUES (7, 4, '6:05:00');
INSERT INTO cookout_order (cookout_id, user_id, order_time) VALUES (7, 6, '6:46:00');
INSERT INTO cookout_order (cookout_id, user_id, order_time) VALUES (7, 7, '6:50:00');
INSERT INTO cookout_order (cookout_id, user_id, order_time) VALUES (7, 9, '6:51:00');
INSERT INTO cookout_order (cookout_id, user_id, order_time) VALUES (7, 10, '6:52:00');

INSERT INTO cookout_order (cookout_id, user_id, order_time) VALUES (8, 1, '12:00:00');
INSERT INTO cookout_order (cookout_id, user_id, order_time) VALUES (8, 2, '12:05:00');
INSERT INTO cookout_order (cookout_id, user_id, order_time) VALUES (8, 1, '12:06:00');

INSERT INTO cookout_order (cookout_id, user_id, order_time) VALUES (9, 1, '12:00:00');
INSERT INTO cookout_order (cookout_id, user_id, order_time) VALUES (9, 2, '12:05:00');
INSERT INTO cookout_order (cookout_id, user_id, order_time) VALUES (9, 1, '12:06:00');

INSERT INTO cookout_order (cookout_id, user_id, order_time) VALUES (10, 3, '4:00:00');
INSERT INTO cookout_order (cookout_id, user_id, order_time) VALUES (10, 4, '4:01:00');
INSERT INTO cookout_order (cookout_id, user_id, order_time) VALUES (10, 5, '4:02:00');
INSERT INTO cookout_order (cookout_id, user_id, order_time) VALUES (10, 6, '4:04:00');
INSERT INTO cookout_order (cookout_id, user_id, order_time) VALUES (10, 7, '4:07:00');
INSERT INTO cookout_order (cookout_id, user_id, order_time) VALUES (10, 8, '4:12:00');
INSERT INTO cookout_order (cookout_id, user_id, order_time) VALUES (10, 9, '4:16:00');
INSERT INTO cookout_order (cookout_id, user_id, order_time) VALUES (10, 10, '4:19:00');
INSERT INTO cookout_order (cookout_id, user_id, order_time) VALUES (10, 6, '4:23:00');
INSERT INTO cookout_order (cookout_id, user_id, order_time) VALUES (10, 8, '4:25:00');
INSERT INTO cookout_order (cookout_id, user_id, order_time) VALUES (10, 7, '4:29:00');
INSERT INTO cookout_order (cookout_id, user_id, order_time) VALUES (10, 9, '4:30:00');

INSERT INTO cookout_order (cookout_id, user_id, order_time) VALUES (11, 1, '12:00:00');
INSERT INTO cookout_order (cookout_id, user_id, order_time) VALUES (11, 2, '12:05:00');
INSERT INTO cookout_order (cookout_id, user_id, order_time) VALUES (11, 1, '12:06:00');

INSERT INTO cookout_order (cookout_id, user_id, order_time) VALUES (12, 1, '12:00:00');
INSERT INTO cookout_order (cookout_id, user_id, order_time) VALUES (12, 2, '12:05:00');
INSERT INTO cookout_order (cookout_id, user_id, order_time) VALUES (12, 1, '12:06:00');


INSERT INTO order_food (order_id, food_id, quantity) VALUES(1, 21, 3);
INSERT INTO order_food (order_id, food_id, quantity) VALUES(2, 23, 2);
INSERT INTO order_food (order_id, food_id, quantity) VALUES(3, 24, 1);
INSERT INTO order_food (order_id, food_id, quantity) VALUES(4, 25, 1);
INSERT INTO order_food (order_id, food_id, quantity) VALUES(5, 27, 2);
INSERT INTO order_food (order_id, food_id, quantity) VALUES(6, 28, 1);
INSERT INTO order_food (order_id, food_id, quantity) VALUES(7, 29, 3);
INSERT INTO order_food (order_id, food_id, quantity) VALUES(8, 30, 2);
INSERT INTO order_food (order_id, food_id, quantity) VALUES(9, 32, 1);
INSERT INTO order_food (order_id, food_id, quantity) VALUES(10, 34, 1);
INSERT INTO order_food (order_id, food_id, quantity) VALUES(11, 35, 2);
INSERT INTO order_food (order_id, food_id, quantity) VALUES(12, 38, 1);
	

COMMIT TRANSACTION;