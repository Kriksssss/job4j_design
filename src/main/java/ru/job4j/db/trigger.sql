-- Таблица products
create table products
(
    id       serial primary key,
    name     varchar(50),
    producer varchar(50),
    count    integer default 0,
    price    integer
);

-- Таблица history_of_price
create table history_of_price
(
    id    serial primary key,
    name  varchar(50),
    price integer,
    date  timestamp
);

-- Триггер statement-level
create or replace function tax_statement_level()
returns trigger as
$$
begin
    update products
    set price = price + price * 0.1; -- Налог в размере 10%
    return null;
end;
$$
language plpgsql;

create trigger tax_statement_level_trigger
after insert
on products
for each statement
execute procedure tax_statement_level();

-- Триггер row-level до вставки данных
create or replace function tax_row_level_before_insert()
returns trigger as
$$
begin
    new.price = new.price + new.price * 0.1; -- Налог в размере 10%
    return new;
end;
$$
language plpgsql;

CREATE TRIGGER tax_row_level_before_insert_trigger
before insert
ON products
for each row
execute procedure tax_row_level_before_insert();

-- Триггер row-level после вставки данных в history_of_price
create or replace function insert_history_of_price()
returns trigger as
$$
begin
    insert into history_of_price (name, price, date)
    values (new.name, new.price, current_timestamp);
    return new;
end;
$$
language plpgsql;

create trigger insert_history_of_price_trigger
after insert
on products
for each row
execute procedure insert_history_of_price();

