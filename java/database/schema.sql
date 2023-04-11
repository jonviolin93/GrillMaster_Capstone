BEGIN TRANSACTION;

DROP TABLE IF EXISTS users CASCADE;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

DROP TABLE IF EXISTS food_category CASCADE;
CREATE TABLE food_category(
	category_id serial,
	name varchar(50),
	CONSTRAINT PK_category PRIMARY KEY (category_id)
);

DROP TABLE IF EXISTS food CASCADE;
CREATE TABLE food (
	food_id serial,
	name varchar(50) NOT NULL,
	image varchar(250),
	category_id int NOT NULL,
	CONSTRAINT PK_food PRIMARY KEY(food_id),
	CONSTRAINT FK_category FOREIGN KEY(category_id) REFERENCES food_category(category_id)
);

DROP TABLE IF EXISTS menu CASCADE;
CREATE TABLE menu(
	menu_id serial,
	is_favorited boolean DEFAULT false,
	CONSTRAINT PK_menu PRIMARY KEY (menu_id)
);

DROP TABLE IF EXISTS cookout CASCADE;
CREATE TABLE cookout(
	cookout_id serial,
	name VARCHAR(50) NOT NULL,
	cookout_date date NOT NULL,
	cookout_time time NOT NULL,
	location VARCHAR(100) NOT NULL,
	description TEXT,
	menu_id int,
	CONSTRAINT PK_cookout PRIMARY KEY (cookout_id),
	CONSTRAINT FK_menu FOREIGN KEY(menu_id) REFERENCES menu(menu_id)
);

DROP TABLE IF EXISTS duty CASCADE;
CREATE TABLE duty(
	duty_id serial,
	name varchar(15),
	CONSTRAINT PK_duty PRIMARY KEY (duty_id)
);

DROP TABLE IF EXISTS user_cookout CASCADE;
CREATE TABLE user_cookout(
	user_id int,
	cookout_id int,
	duty_id int,
	PRIMARY KEY(user_id, cookout_id, duty_id),
	CONSTRAINT FK_user FOREIGN KEY (user_id) REFERENCES users(user_id),
	CONSTRAINT FK_cookout FOREIGN KEY (cookout_id) REFERENCES cookout(cookout_id),
	CONSTRAINT FK_duty FOREIGN KEY (duty_id) REFERENCES duty(duty_id)
);
	

DROP TABLE IF EXISTS food_menu CASCADE;
CREATE TABLE food_menu(
	food_id int NOT NULL,
	menu_id int NOT NULL,
	user_id int NOT NULL,
	CONSTRAINT FK_food FOREIGN KEY(food_id) REFERENCES food(food_id),
	CONSTRAINT FK_menu FOREIGN KEY(menu_id) REFERENCES menu(menu_id),
	CONSTRAINT FK_user FOREIGN KEY(user_id) REFERENCES users(user_id)
);

DROP TABLE IF EXISTS cookout_order CASCADE;
CREATE TABLE cookout_order(
	order_id serial,
	cookout_id int NOT NULL,
	user_id int NOT NULL,
	is_complete boolean DEFAULT false,
	order_time time not null,
	CONSTRAINT PK_order PRIMARY KEY (order_id),
	CONSTRAINT FK_user FOREIGN KEY(user_id) REFERENCES users(user_id),
	CONSTRAINT FK_cookout FOREIGN KEY(cookout_id) REFERENCES cookout(cookout_id)
);

DROP TABLE IF EXISTS order_food CASCADE;
CREATE TABLE order_food(
	order_id int not null,
	food_id int not null,
	quantity int not null DEFAULT 1,
	CONSTRAINT FK_order FOREIGN KEY(order_id) REFERENCES cookout_order(order_id),
	CONSTRAINT FK_food FOREIGN KEY(food_id) REFERENCES food(food_id)
);

INSERT INTO food_category(name) VALUES ('Main');
INSERT INTO food_category(name) VALUES ('Side');
INSERT INTO food_category(name) VALUES ('Alcohol');
INSERT INTO food_category(name) VALUES ('Soft Drink');
INSERT INTO food_category(name) VALUES ('Dessert');	

INSERT INTO duty(name) VALUES ('Host');	
INSERT INTO duty(name) VALUES ('Grill Master');	
INSERT INTO duty(name) VALUES ('Attendee');	

COMMIT TRANSACTION;
