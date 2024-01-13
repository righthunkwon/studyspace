CREATE DATABASE IF NOT EXISTS ssafydb;
USE ssafydb;

CREATE TABLE IF NOT EXISTS `users` (
  `id` varchar(40) NOT NULL,
  `password` varchar(40) NOT NULL,
  `name` varchar(40) NOT NULL,
  `email` varchar(40) NOT NULL,
  `age` int NOT NULL,
  `img` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;

INSERT INTO users (id, password, name, email, age) 
VALUES ("ssafy", "1234", "김싸피", "ssafy.kim@ssafy.com", 20);

SELECT * 
FROM users;

SELECT * 
FROM users
WHERE name LIKE concat('%싸피%');
