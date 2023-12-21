CREATE TABLE users (
    user_id SERIAL PRIMARY KEY,
    username VARCHAR(255),
    password VARCHAR(255)
);

CREATE TABLE profiles (
    profile_id SERIAL PRIMARY KEY,
    full_name VARCHAR(255),
    user_id INT UNIQUE REFERENCES users(user_id)
);

INSERT INTO users (username, password) VALUES ('john_doe', 'password123');
INSERT INTO profiles (full_name, user_id) VALUES ('John Doe', 1);

SELECT * FROM users;
SELECT * FROM profiles;
