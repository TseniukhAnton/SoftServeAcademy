CREATE TABLE IF NOT EXISTS user (id int auto_increment, name text(255), email varchar(255), UNIQUE(email), primary key(id));
INSERT INTO user
(name, email)
VALUES
    ('Anton', 'anton.tseniukh@gmail.com');
