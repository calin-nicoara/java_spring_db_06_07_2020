CREATE SEQUENCE HIBERNATE_SEQUENCE START WITH 1 INCREMENT BY 1;

CREATE TABLE product
(
    id    bigint PRIMARY KEY,
    name  varchar(255),
    price numeric(12, 4),
    status varchar(255)
);
