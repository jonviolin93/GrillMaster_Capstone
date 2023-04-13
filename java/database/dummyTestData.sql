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
	
SELECT * FROM duty;
	
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
	
-- INSERT INTO user_cookout (duty_id, user_id, cookout_id)
-- SELECT d.duty_id, 1, 1 FROM duty d
-- WHERE d.name = 'Host';

SELECT * FROM users;

SELECT * FROM menu;

SELECT * FROM user_cookout;

SELECT * FROM cookout;

SELECT cookout_id, name, cookout_date, cookout_time, location, description, menu_id 
                FROM cookout
                WHERE cookout_id = 1 AND cookout_id IN                 
				(SELECT cookout_id FROM user_cookout WHERE user_id = 1);

SELECT users.user_id, username, duty.name
                FROM users
                JOIN user_cookout ON users.user_id = user_cookout.user_id
                JOIN duty ON duty.duty_id = user_cookout.duty_id
                JOIN cookout ON cookout.cookout_id = user_cookout.cookout_id 
                WHERE cookout.cookout_id = 1
				ORDER BY duty.duty_id, username;
				
select * from users;