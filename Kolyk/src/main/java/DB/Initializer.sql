create table users(
  id serial primary key,
  username varchar(256),
  email varchar(256),
  password varchar(256)
);

create table posts(
  id serial primary key,
  title VARCHAR(256),
  body VARCHAR(256),
  city VARCHAR(256),
  price INT,
  age INT,
  date DATE,
  userId SERIAL
);