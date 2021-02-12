CREATE TABLE users (
    id int AUTO_INCREMENT PRIMARY KEY,
    userName varchar(255) NOT NULL,
    email varchar(255) NOT NULL,
    password varchar(255) NOT NULL
);

INSERT INTO users VALUES(default, 'ala', 'ala@mail.pl', 'tajnehaslo');
INSERT INTO users VALUES(default, 'ola', 'ola@mail.pl', 'tajnehaslo123');
