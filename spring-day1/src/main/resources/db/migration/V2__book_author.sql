CREATE TABLE book
(
    id          bigint PRIMARY KEY,
    title        varchar(255)
);

CREATE TABLE author
(
    id   bigint PRIMARY KEY,
    name varchar(255)
);

CREATE TABLE book_authors
(
    book_id bigint,
    author_id bigint,
    FOREIGN KEY (book_id) REFERENCES book (id),
    FOREIGN KEY (author_id) REFERENCES author (id)
);

