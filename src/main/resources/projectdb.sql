USE projectdb;
CREATE TABLE IF NOT EXISTS user (id int auto_increment, name text(255), email varchar(255), UNIQUE(email), primary key(id));
TRUNCATE TABLE user;
DROP TABLE user;
SELECT* FROM user;
INSERT INTO user
(name, email)
VALUES
('Anton', 'anton.tseniukh@gmail.com');
UPDATE user SET name="Anton", email="anton.tseniukh@gmail.com" WHERE id=1;
SELECT* FROM user WHERE id=1;
DELETE FROM user WHERE id=2;