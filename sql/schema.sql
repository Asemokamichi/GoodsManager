create database warehouse_db;

drop table if exists products;

create table products
(
    id    int auto_increment primary key,
    name  varchar(255) not null,
    price int default 0
);

insert into products (name, price)
values ('Smartphone', 500),
       ('Laptop', 1000),
       ('T-Shirt', 20),
       ('Jeans', 40),
       ('Novel', 15),
       ('Textbook', 60);

