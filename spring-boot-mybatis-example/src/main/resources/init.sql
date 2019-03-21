CREATE TABLE users
(
    id serial NOT NULL,
    name varchar(100) NOT NULL,
    salary float(10) DEFAULT NULL,
    PRIMARY KEY (id)
);