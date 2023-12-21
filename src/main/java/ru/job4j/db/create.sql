CREATE TABLE users (
    user_id SERIAL PRIMARY KEY,
    username VARCHAR(255),
    email VARCHAR(255)
    );

CREATE TABLE roles (
    role_id SERIAL PRIMARY KEY,
    role_name VARCHAR(255)
);

CREATE TABLE rules (
    rule_id SERIAL PRIMARY KEY,
    rule_name VARCHAR(255)
);

CREATE TABLE items (
    item_id SERIAL PRIMARY KEY,
    title VARCHAR(255),
    user_id INT REFERENCES users(user_id),
    category_id INT REFERENCES categories(category_id),
    state_id INT REFERENCES states(state_id)
);

CREATE TABLE comments (
    comment_id SERIAL PRIMARY KEY,
    item_id INT REFERENCES items(item_id),
    user_id INT REFERENCES users(user_id),
    comment_text TEXT
);

CREATE TABLE attachs (
    attach_id SERIAL PRIMARY KEY,
    item_id INT REFERENCES items(item_id),
    file_path VARCHAR(255)
);

CREATE TABLE states (
    state_id SERIAL PRIMARY KEY,
    state_name VARCHAR(255)
);

CREATE TABLE categories (
    category_id SERIAL PRIMARY KEY,
    category_name VARCHAR(255)
);

CREATE TABLE role_rules (
    id SERIAL PRIMARY KEY,
    role_id INT REFERENCES roles(role_id),
    rule_id INT REFERENCES rules(rule_id),
    UNIQUE (role_id, rule_id)
);

CREATE TABLE item_roles (
    id SERIAL PRIMARY KEY,
    item_id INT REFERENCES items(item_id),
    role_id INT REFERENCES roles(role_id)
);