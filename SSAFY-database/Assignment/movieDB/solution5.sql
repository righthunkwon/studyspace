CREATE SCHEMA ssafy_test;

use ssafy_test;

# movie 테이블
create table if not exists `movie` (
	`movie_id` int not null AUTO_INCREMENT primary key,
    `director` varchar(100) not null,
    `genre` varchar(100) not null,
    `runningTime` int not null,
	`releaseDate` date
)engine = InnoDB;

# user 테이블
create table if not exists `user` (
    `user_id` INT AUTO_INCREMENT PRIMARY KEY,
    `user_name` VARCHAR(50) NOT NULL,
    `email` VARCHAR(100) NOT NULL
)engine = InnoDB;

# rate 테이블
create table if not exists `rate` (
	primary key(`title`, `rating`),
    `title` varchar(100) not null, 
    `rating` int not null,
    `comment` varchar(100),
    `user_id` int NOT NULL,
    `movie_id` int not null,
    CONSTRAINT `fk_rate_user` FOREIGN KEY (`user_id`) REFERENCES user(`user_id`),
	CONSTRAINT `fk_movie_id` FOREIGN KEY (`movie_id`) REFERENCES movie(`movie_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
)engine = InnoDB;