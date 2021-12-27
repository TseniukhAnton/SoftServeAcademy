USE projectdb;
CREATE TABLE IF NOT EXISTS user (id int auto_increment, name text(255), email varchar(255), UNIQUE(email), primary key(id));
GRANT ALL PRIVILEGES ON projectdb to root;
TRUNCATE TABLE users;
DROP TABLE users;
SELECT* FROM users;
INSERT INTO users
(name, email)
VALUES
('Oleg', 'olga@gmail.com');
UPDATE users SET name="Anton", email="anton.tseniukh@gmail.com" WHERE id=1;
SELECT* FROM users WHERE id=1;
DELETE FROM users WHERE id=2;