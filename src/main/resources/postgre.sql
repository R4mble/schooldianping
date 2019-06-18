create table users (
id serial primary key,
email varchar(45) not null,
username varchar(18) not null,
password varchar(45) not null,
description varchar(225),
age smallint
);


ALTER USER postgres WITH PASSWORD '1234';