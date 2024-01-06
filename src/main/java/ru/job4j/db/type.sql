CREATE TABLE type (
    id SERIAL PRIMARY KEY,
    lname VARCHAR(255) NOT NULL
);

CREATE TABLE product (
    id SERIAL PRIMARY KEY,
    lname VARCHAR(255) NOT NULL,
    type_id INT REFERENCES type(id),
    expired_date DATE,
    price real
);

INSERT INTO type (lname) VALUES
('СЫР'),
('МОЛОКО'),
('МОРОЖЕНОЕ'),
('ЯЙЦА');

INSERT INTO product (lname, type_id, expired_date, price) VALUES
('Гауда', 1, '2024-01-15', 5.99),
('Масло', 2, '2024-02-01', 3.49),
('Молоко', 2, '2024-01-10', 2.99),
('Сырковая', 3, '2023-12-31', 4.99),
('Мороженое ванильное', 3, '2024-03-01', 3.99),
('Мороженое шоколадное', 3, '2024-03-01', 4.49),
('Яйца куриные', 4, '2024-01-20', 1.99);


-- 1. Получение всех продуктов с типом "СЫР"
SELECT *
FROM product
WHERE type_id = (SELECT id FROM type WHERE lname = 'СЫР');

-- 2. Получение всех продуктов, у которых в имени есть слово "мороженое"
SELECT *
FROM product
WHERE lname LIKE '%мороженое%';

-- 3. Вывод всех продуктов, срок годности которых уже истек
SELECT *
FROM product
WHERE expired_date < CURRENT_DATE;

-- 4. Вывод самого дорогого продукта
SELECT *
FROM product
ORDER BY price DESC
LIMIT 1;

-- 5. Вывод количества продуктов для каждого типа
SELECT t.lname AS type_name, COUNT(p.id) AS product_count
FROM type t
LEFT JOIN product p ON t.id = p.type_id
GROUP BY t.id, t.lname;

-- 6. Получение всех продуктов с типом "СЫР" и "МОЛОКО"
SELECT *
FROM product
WHERE type_id IN (SELECT id FROM type WHERE lname IN ('СЫР', 'МОЛОКО'));

-- 7. Вывод типов продуктов, у которых осталось менее 10 штук
SELECT t.lname AS type_name
FROM type t
LEFT JOIN product p ON t.id = p.type_id
GROUP BY t.id, t.lname
HAVING COUNT(p.id) < 10;

-- 8. Вывод всех продуктов и их типа
SELECT p.*, t.lname AS type_name
FROM product p
JOIN type t ON p.type_id = t.id;

