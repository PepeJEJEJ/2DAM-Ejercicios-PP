CREATE USER 'tocabd'@'%' IDENTIFIED BY '12345';
GRANT ALL PRIVILEGES ON hibernate_db.* TO 'tocabd'@'%';
FLUSH PRIVILEGES;

SELECT User, Host
FROM mysql.user
WHERE User = 'tocabd';