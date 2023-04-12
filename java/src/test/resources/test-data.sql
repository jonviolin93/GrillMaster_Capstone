BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user1','user1','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('user2','user2','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('user3','user3','ROLE_USER');

INSERT INTO menu (name) VALUES ('test');

INSERT INTO cookout (name, cookout_date, cookout_time, location, description, menu_id)
    VALUES ('Jonathans B-Day!', '2023-04-12', '12:00:00', 'Jonathans Backyard', 'Its a birthday in a backyard', 1);
INSERT INTO cookout (name, cookout_date, cookout_time, location, description, menu_id)
    VALUES ('Melis B-Day!', '2023-05-13', '12:00:00', 'DisneyWorld', 'Its a Small World After All', 1);
INSERT INTO cookout (name, cookout_date, cookout_time, location, description, menu_id)
    VALUES ('Elliss B-Day!', '2023-06-17', '12:00:00', 'NASA Space Station', 'To Infinity and Beyond', 1);
INSERT INTO cookout (name, cookout_date, cookout_time, location, description, menu_id)
    VALUES ('Camerons B-Day!', '2023-10-5', '12:00:00', 'Pentagon', 'Everyone bring five items', 1);

INSERT INTO user_cookout (user_id, cookout_id, duty_id)
    VALUES (1, 1, 3);

INSERT INTO user_cookout (user_id, cookout_id, duty_id)
    VALUES (2, 1, 2);

INSERT INTO user_cookout (user_id, cookout_id, duty_id)
    VALUES (3, 1, 1);

COMMIT TRANSACTION;