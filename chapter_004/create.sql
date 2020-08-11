-- Database: stockmanager

-- DROP DATABASE stockmanager;

CREATE DATABASE stockmanager
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Russian_Russia.1251'
    LC_CTYPE = 'Russian_Russia.1251'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;
	
CREATE TABLE rules (
rule_id serial PRIMARY KEY,
rule_name varchar NOT NULL,
rule_text varchar NOT NULL
);
CREATE TABLE roles (
role_id serial PRIMARY KEY,
role_code varchar NOT NULL,
role_name varchar NOT NULL
);
CREATE TABLE role_rules (
role_id int REFERENCES roles(role_id) ON DELETE RESTRICT,
rule_id int REFERENCES rules(rule_id) ON DELETE RESTRICT,
CONSTRAINT role_rules_pkey PRIMARY KEY(role_id, rule_id)
);
CREATE TABLE users (
user_id serial PRIMARY KEY,
user_name varchar UNIQUE,
role_id int REFERENCES roles(role_id) ON DELETE RESTRICT
);
CREATE TABLE states (
state_code varchar PRIMARY KEY,
state_name varchar NOT NULL
);
CREATE TABLE category (
category_code varchar PRIMARY KEY,
category_name varchar NOT NULL
);
CREATE TABLE items (
item_id serial PRIMARY KEY,
item_descript varchar,
create_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
user_id int REFERENCES users(user_id) ON DELETE RESTRICT,
state_code varchar REFERENCES states(state_code),
category_code varchar REFERENCES category(category_code)
);
CREATE TABLE comments (
comments_id serial PRIMARY KEY,
item_id int REFERENCES items(item_id) ON DELETE CASCADE,
comment_text varchar,
create_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE attaches (
attach_id serial PRIMARY KEY,
item_id int REFERENCES items(item_id) ON DELETE CASCADE,
file_attaced bytea,
file_name varchar,
create_date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
);
INSERT INTO rules(rule_name, rule_text)
VALUES ('CREATE', 'создание'),
       ('DELETE', 'удаление'),
	   ('UPDATE', 'изменение'),
	   ('READ', 'чтение');
INSERT INTO roles(role_code, role_name)
VALUES ('CLIENT', 'клиент'),
       ('ADMIN', 'администратор');
INSERT INTO category(category_code, category_name)
VALUES ('PROGRESS', 'выполняется'),
       ('ACCEPT', 'принята'),
	   ('DELIVER', 'доставляется');
INSERT INTO states(state_code, state_name)
VALUES ('NEW', 'новая'),
       ('DONE', 'завершенна'),
	   ('WORK', 'в работе');
	   