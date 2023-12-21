CREATE TABLE categories (
    category_id SERIAL PRIMARY KEY,
    category_name VARCHAR(255)
);

CREATE TABLE products (
    product_id SERIAL PRIMARY KEY,
    product_name VARCHAR(255),
    category_id INT REFERENCES categories(category_id)
);

INSERT INTO categories (category_name) VALUES ('Электроника');
INSERT INTO products (product_name, category_id) VALUES ('Смартфон', 1);
INSERT INTO products (product_name, category_id) VALUES ('Ноутбук', 1);

SELECT * FROM categories;
SELECT * FROM products;
