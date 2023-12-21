CREATE TABLE script (
    id SERIAL PRIMARY KEY,
    lname VARCHAR(255),
    age INT,
    email VARCHAR(255)
);

INSERT INTO script (lname, age, email) VALUES ('John', 25, 'john@example.com');

UPDATE script SET age = 26 WHERE lname = 'John';

DELETE FROM script WHERE lname = 'John';