CREATE TABLE IF NOT EXISTS users
(
    id int auto_increment,
    name text(255),
    email varchar(255),
    UNIQUE(email),
    primary key(id));

