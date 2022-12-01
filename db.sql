DROP DATABASE expensetracker;
CREATE DATABASE expensetracker with template=template0 owner = postgres;
\c expensetracker;

-- et means expensetracker

CREATE TABLE et_users (
    user_id integer PRIMARY KEY NOT NULL,
    first_name varchar(50) NOT NULL,
    last_name varchar(50) NOT NULL,
    password text NOT NULL,
    email varchar(50) NOT NULL,
    created_on timestamp
);

CREATE TABLE et_categories(
    category_id integer PRIMARY KEY NOT NULL,
    user_id integer NOT NULL,
    title varchar(50) NOT NULL,
    description varchar(50 ) NOT NULL,
    created_on timestamp
);

ALTER TABLE et_categories ADD CONSTRAINT cat_users_fk
FOREIGN KEY (user_id) REFERENCES et_users(user_id);

CREATE TABLE et_transactions(
    transaction_id integer PRIMARY KEY NOT NULL,
    user_id integer NOT NULL,
    category_id integer NOT NULL,
    amount numeric(10,2) NOT NULL,
    note varchar(50) NOT NULL,
    transaction_date bigint NOT NULL,
    created_on timestamp
);

ALTER TABLE et_transactions ADD CONSTRAINT trans_cat_fk
FOREIGN KEY (category_id) REFERENCES et_categories(category_id);

ALTER TABLE et_transactions ADD CONSTRAINT trans_users_fk
FOREIGN KEY (user_id) REFERENCES et_users(user_id);

CREATE sequence et_users_seq INCREMENT 1 START 1;
CREATE sequence et_categories_seq INCREMENT 1 START 1;
CREATE sequence et_transactions_seq INCREMENT 1 START 1000;