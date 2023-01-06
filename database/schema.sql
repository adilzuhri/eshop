drop database if exists ehop;

create database eshop;

use eshop;

CREATE TABLE customers (
    name varchar(32) not null,
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
