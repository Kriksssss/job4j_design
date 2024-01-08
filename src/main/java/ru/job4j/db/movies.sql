CREATE TABLE movies (
    id SERIAL PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    release_year INTEGER
);

INSERT INTO movies (title, release_year) VALUES
('Inception', 2010),
('The Shawshank Redemption', 1994),
('The Godfather', 1972);

CREATE TABLE actors (
    id SERIAL PRIMARY KEY,
    lname VARCHAR(50) NOT NULL,
    birth_year INTEGER
);

INSERT INTO actors (lname, birth_year) VALUES
('Leonardo DiCaprio', 1974),
('Morgan Freeman', 1937),
('Marlon Brando', 1924);

CREATE TABLE roles (
    id SERIAL PRIMARY KEY,
    movie_id INTEGER REFERENCES movies(id),
    actor_id INTEGER REFERENCES actors(id),
    character_name VARCHAR(50) NOT NULL
);

INSERT INTO roles (movie_id, actor_id, character_name) VALUES
(1, 1, 'Cobb'),
(1, 2, 'Freeman'),
(2, 2, 'Red'),
(3, 3, 'Vito Corleone');

CREATE VIEW movie_roles_info AS
SELECT m.title AS movie_title, a.lname AS actor_name, r.character_name
FROM movies m
JOIN roles r ON m.id = r.movie_id
JOIN actors a ON r.actor_id = a.id;

SELECT * FROM movie_roles_info;

SELECT movie_title, actor_name
FROM movie_roles_info
WHERE character_name = 'Cobb';

