CREATE DATABASE IF NOT EXISTS ssafy_spring_board;
USE ssafy_spring_board;

CREATE TABLE IF NOT EXISTS board (
	id INT AUTO_INCREMENT,
    writer VARCHAR(20) NOT NULL,
    title VARCHAR(50) NOT NULL,
    content TEXT,
    view_cnt INT DEFAULT 0,
    reg_date TIMESTAMP DEFAULT now(),
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS curriculum (
	code INT NOT NULL PRIMARY KEY,
    name VARCHAR(40) NOT NULL
)ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS users (
  id varchar(40) NOT NULL,
  password varchar(40) NOT NULL,
  name varchar(40) NOT NULL,
  curriculum_code INT NOT NULL,
  CONSTRAINT curriculum_fk FOREIGN KEY (curriculum_code) REFERENCES curriculum(code),
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARACTER SET = utf8mb4;

INSERT INTO curriculum
VALUES (100, 'Python'), (200, 'JAVA'), (300, 'Embedded'), (400, 'Mobile');

INSERT INTO users
VALUES ("ssafy", "1234", "김싸피", 200);