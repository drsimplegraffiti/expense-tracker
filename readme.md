#### Stack

> spring web, jdbc , postgres driver ,spring boot dev tools

##### Application properties

```
server.port=6789
```

#### Note

With the aforementioned configuration, the application will run on port 6789. but will not be able to connect to the
database.
To connect to the database, you need to add the following configuration to the application.properties file.

```sql
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
```

Then cd to the project directory and run the following command to start the application.

```bash
psql -U postgres -f db.sql
```

Then cd to the project directory and run the following command to start the application.

```bash
mvn spring-boot:run
```

Then in the application.properties file, add the following configuration.

```
spring.datasource.url=jdbc:postgresql://localhost:5432/expensetracker
spring.datasource.username=postgres
spring.datasource.password=[your db password here]
```

#### Testing

Visit http://localhost:6789

#### Endpoints

POST /api/v1/users/register

```json
{
  "firstName": "John",
  "lastName": "Doe",
  "email": "a@b.com",
  "password": "123456"
}

```

#### Check the postgreSQL database using the following command

```bash
psql -U postgres
\c expensetracker
SELECT * FROM et_users;
```

#### Delete table

```sql
DELETE FROM et_users;
```