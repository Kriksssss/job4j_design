create table fauna
(
    id             serial primary key,
    lname           text,
    avg_age        int,
    discovery_date date
);

insert into fauna (lname, avg_age, discovery_date) values
('Fish', 12000, '2000-05-15'),
('Mammal', 18000, '1985-11-10'),
('Bird', 8000, '2010-02-28'),
('Fish', 15000, '1945-08-20'),
('Insect', 5000, null),
('Reptile', 25000, '1960-09-12'),
('Eagle', 11000, '2005-07-07');

select * from fauna where lower(lname) like '%fish%';

select * from fauna where avg_age between 10000 and 21000;

select * from fauna where discovery_date is null;

select * from fauna where discovery_date < '01.01.1950';