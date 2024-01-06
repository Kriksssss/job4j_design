CREATE TABLE department (
    department_id SERIAL PRIMARY KEY,
    department_name VARCHAR(255) NOT NULL
);

CREATE TABLE employee (
    employee_id SERIAL PRIMARY KEY,
    employee_name VARCHAR(255) NOT NULL,
    department_id INT REFERENCES department(department_id)
);

SELECT e.employee_name, d.department_name
FROM employee e
INNER JOIN department d ON e.department_id = d.department_id;

SELECT e.employee_id, e.employee_name, d.department_name
FROM employee AS e
INNER JOIN department AS d ON e.department_id = d.department_id;

SELECT emp.employee_name AS "Имя сотрудника", emp.department_id AS "ID отдела", dep.department_name AS "Название отдела"
FROM employee AS emp
INNER JOIN department AS dep ON emp.department_id = dep.department_id;
