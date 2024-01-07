CREATE TABLE car_bodies (
    id SERIAL PRIMARY KEY,
    lname VARCHAR(255) NOT NULL
);

CREATE TABLE car_engines (
    id SERIAL PRIMARY KEY,
    lname VARCHAR(255) NOT NULL
);

CREATE TABLE car_transmissions (
    id SERIAL PRIMARY KEY,
    lname VARCHAR(255) NOT NULL
);

CREATE TABLE cars (
    id SERIAL PRIMARY KEY,
    lname VARCHAR(255) NOT NULL,
    body_id INT REFERENCES car_bodies(id),
    engine_id INT REFERENCES car_engines(id),
    transmission_id INT REFERENCES car_transmissions(id)
);

-- Заполнение таблиц данными
INSERT INTO car_bodies (lname) VALUES
('Sedan'),
('Hatchback'),
('SUV'),
('Pickup');

INSERT INTO car_engines (lname) VALUES
('V6'),
('Inline-4'),
('V8'),
('Electric');

INSERT INTO car_transmissions (lname) VALUES
('Automatic'),
('Manual'),
('CVT');

INSERT INTO cars (lname, body_id, engine_id, transmission_id) VALUES
('Car1', 1, 2, 1),
('Car2', 2, 3, 2),
('Car3', 3, 1, 3),
('Car4', 4, 4, 1);

SELECT c.id, c.lname AS car_name, cb.lname AS body_name, ce.lname AS engine_name, ct.lname AS transmission_name
FROM cars c
LEFT JOIN car_bodies cb ON c.body_id = cb.id
LEFT JOIN car_engines ce ON c.engine_id = ce.id
LEFT JOIN car_transmissions ct ON c.transmission_id = ct.id;

SELECT cb.lname AS unused_body
FROM car_bodies cb
LEFT JOIN cars c ON cb.id = c.body_id
WHERE c.id IS NULL;

SELECT ce.lname AS unused_engine
FROM car_engines ce
LEFT JOIN cars c ON ce.id = c.engine_id
WHERE c.id IS NULL;

SELECT ct.lname AS unused_transmission
FROM car_transmissions ct
LEFT JOIN cars c ON ct.id = c.transmission_id
WHERE c.id IS NULL;



