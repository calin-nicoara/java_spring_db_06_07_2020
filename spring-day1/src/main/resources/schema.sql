CREATE SEQUENCE HIBERNATE_SEQUENCE START WITH 1 INCREMENT BY 1;

CREATE TABLE product (
    id bigint PRIMARY KEY,
    name varchar(255),
    price numeric(12, 4)
);

-- --------------------------------------------------

CREATE TABLE category (
                          id bigint PRIMARY KEY,
                          name varchar(255),
                          active boolean
);

CREATE TABLE product_with_category (
     id bigint PRIMARY KEY,
     name varchar(255),
     price numeric(12, 4),
     category_id bigint,
     FOREIGN KEY (category_id) REFERENCES category (id)
);


