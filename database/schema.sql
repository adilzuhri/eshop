drop database if exists ehop;

create database eshop;

use eshop;

GRANT ALL PRIVILEGES ON *.* TO 'adil'@'localhost' WITH GRANT OPTION;

FLUSH PRIVILEGES;

CREATE TABLE customers (
    name varchar(32) not null unique,
    address varchar(128) not null,
    email varchar(128) not null,
    primary key(name)
);

INSERT INTO customers (name, address, email)
VALUES
    ("fred", "201 Cobblestone Lane", "fredflintstone@bedrock.com"),
    ("sherlock", "221B Baker Street, London", "sherlock@consultingdetective.org"),
    ("spongebob", "124 Conch Street, Bikini Bottom", "spongebob@yahoo.com"),
    ("jessica", "698 Candlewood Land, Cabot Cove", "fletcher@gmail.com"),
    ("dursley", "4 Privet Drive, Little Whinging, Surrey", "dursley@gmail.com");

CREATE TABLE orders (
    order_id varchar(8) not null, 
    name varchar(32) not null unique,
    order_date date not null,
    primary key(order_id),
    constraint fk_order_id
        foreign key(name) references customers(name)
);

CREATE TABLE line_items (
    item_id int auto_increment not null,
    description text not null,
    quantity int default '1',
    order_id varchar(8) not null,
    primary key(item_id),
    constraint fk_order_id
        foreign key(order_id) references orders(order_id)
);

CREATE TABLE order_status (
    order_id varchar (8) not null unique,
    delivery_id varchar (128) not null,
    status BINARY ("pending" or "dispatched"),
    status_update int (CURRENT_TIMESTAMP()),
    primary key(order_id),
    constraint fk_order_id
        foreign key(order_id) references orders(order_id)
);
