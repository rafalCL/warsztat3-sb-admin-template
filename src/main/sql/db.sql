-- DROP DATABASE workshop3;

CREATE DATABASE workshop3
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;

USE workshop3;

CREATE TABLE users (
    id int AUTO_INCREMENT PRIMARY KEY,
    userName varchar(255) NOT NULL,
    email varchar(255) NOT NULL,
    password varchar(255) NOT NULL
);

INSERT INTO users VALUES(default, 'ala', 'ala@mail.pl', 'tajnehaslo');
INSERT INTO users VALUES(default, 'ola', 'ola@mail.pl', 'tajnehaslo123');
