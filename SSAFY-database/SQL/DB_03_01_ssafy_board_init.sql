DROP DATABASE IF EXISTS ssafy_board;
CREATE DATABASE ssafy_board DEFAULT CHARACTER SET utf8mb4;

USE ssafy_board;

CREATE TABLE board (
	id INT AUTO_INCREMENT,
    writer VARCHAR(20) NOT NULL,
    title VARCHAR(50) NOT NULL,
    content TEXT,
    view_cnt INT DEFAULT 0,
    reg_date TIMESTAMP DEFAULT now(),
    PRIMARY KEY(id)
);

INSERT INTO board(title, writer, content) 
VALUES ("BackEnd 너두 마스터", "양씨","너도 할 수 있어"),
	   ("누르지마시오", "따봉맨", "아무내용없음"),
       ("대답잘하는 법", "쿠로미", "채팅 잘치면됨 네(필수)");

SELECT * FROM board;