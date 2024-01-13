CREATE DATABASE IF NOT EXISTS ssafydb;
USE ssafydb;

CREATE TABLE `movies` (
	`ID` int(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `Title` varchar(40) CHARACTER SET utf8mb4 NOT NULL,
    `Director` varchar(40) CHARACTER SET utf8mb4 NOT NULL,
    `Genre` varchar(40) CHARACTER SET utf8mb4 NOT NULL,
    `RunningTime` int(3) NOT NULL,
    `img` varchar(40) NULL
)ENGINE=InnoDB;

INSERT INTO `movies` (Id, Title, Director, Genre, RunningTime, img)
VALUES
(0, '이터널스', '클로이 자오', '액션', 155),
(0, '베놈 2: 렛 데어 비 카니지','앤디 서키스', '액션', 97),
(0, '기생충', '봉준호', '드라마', 131),
(0, '해리포터와 마법사의 돌', '크리스 콜럼버스', '판타지', 152),
(0, '해리포터와 비밀의 방', '크리스 콜럼버스', '판타지', 162),
(0, '반지의제왕: 왕의 귀환', '피터 잭슨', '판타지', 263),
(0, '듄', '드니 뷜뇌브', '모험', 155),
(0, '강릉', '윤영빈', '범죄', 119);

CREATE TABLE IF NOT EXISTS `user` (
  `id` VARCHAR(50) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `pass` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE = InnoDB;

insert into user values('ssafy', '김싸피','1234');

SELECT *
FROM movies;