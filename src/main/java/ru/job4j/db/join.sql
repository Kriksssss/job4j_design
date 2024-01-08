CREATE TABLE departments (
    id SERIAL PRIMARY KEY,
    lname VARCHAR(255) NOT NULL
);

CREATE TABLE employees (
    id SERIAL PRIMARY KEY,
    lname VARCHAR(255) NOT NULL,
    department_id INT REFERENCES departments(id)
);

-- Заполнение начальными данными
INSERT INTO departments (lname) VALUES
('IT'),
('HR'),
('Finance');

INSERT INTO employees (lname, department_id) VALUES
('John', 1),
('Alice', 1),
('Bob', 2),
('Eva', 3),
('Mike', 3);

SELECT * FROM departments
LEFT JOIN employees ON departments.id = employees.department_id;

SELECT * FROM departments
RIGHT JOIN employees ON departments.id = employees.department_id;

SELECT * FROM departments
FULL JOIN employees ON departments.id = employees.department_id;

SELECT * FROM departments
CROSS JOIN employees;

SELECT departments.id, departments.lname
FROM departments
LEFT JOIN employees ON departments.id = employees.department_id
WHERE employees.id IS NULL;


SELECT * FROM departments
LEFT JOIN employees ON departments.id = employees.department_id;

SELECT * FROM employees
RIGHT JOIN departments ON employees.department_id = departments.id;

CREATE TABLE teens (
    lname VARCHAR(255) NOT NULL,
    gender VARCHAR(10) NOT NULL
);

INSERT INTO teens (lname, gender) VALUES
('Vasya', 'Male'),
('Masha', 'Female'),
('Petya', 'Male'),
('Anya', 'Female');

-- Получение всех возможных разнополых пар с использованием Cross Join и исключением дублирования
SELECT t1.lname AS teen1, t1.gender AS gender1, t2.lname AS teen2, t2.gender AS gender2
FROM teens t1
CROSS JOIN teens t2
WHERE t1.gender <> t2.gender AND t1.lname < t2.lname;