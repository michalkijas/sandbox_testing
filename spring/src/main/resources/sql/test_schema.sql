CREATE TABLE books
(
    id     bigint generated by default as identity,
    author varchar(255),
    title  varchar(255),
    primary key (id)
);