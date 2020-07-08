CREATE TABLE client
(
    id               bigint PRIMARY KEY,
    name             varchar(255),
    credit           numeric(12, 4),
    number_of_orders int,
    street_name       varchar(500),
    number    varchar(10)
);
