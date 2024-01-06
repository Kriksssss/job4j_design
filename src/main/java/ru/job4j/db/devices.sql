CREATE TABLE devices
(
    id    SERIAL PRIMARY KEY,
    lname  VARCHAR(255),
    price real
);

CREATE TABLE people
(
    id   SERIAL PRIMARY KEY,
    lname VARCHAR(255)
);

CREATE TABLE devices_people
(
    id        SERIAL PRIMARY KEY,
    device_id INT REFERENCES devices (id),
    people_id INT REFERENCES people (id)
);

-- Заполнение таблиц данными
INSERT INTO devices (lname, price) VALUES
('Phone', 600),
('Laptop', 1200),
('Tablet', 500),
('Smartwatch', 300);

INSERT INTO people (lname) VALUES
('John'),
('Alice'),
('Bob');

INSERT INTO devices_people (device_id, people_id) VALUES
(1, 1),
(2, 1),
(3, 2),
(4, 3),
(1, 3);

-- Вывод средней цены устройств
SELECT AVG(price) AS average_price FROM devices;

-- Вывод средней цены устройств для каждого человека
SELECT p.lname AS person_name, AVG(d.price) AS average_device_price
FROM people p
JOIN devices_people dp ON p.id = dp.people_id
JOIN devices d ON dp.device_id = d.id
GROUP BY p.id, p.lname;

-- Вывод средней цены устройств для каждого человека с условием
SELECT p.lname AS person_name, AVG(d.price) AS average_device_price
FROM people p
JOIN devices_people dp ON p.id = dp.people_id
JOIN devices d ON dp.device_id = d.id
GROUP BY p.id, p.lname
HAVING AVG(d.price) > 5000;


