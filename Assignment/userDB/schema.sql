CREATE TABLE `user` (
	`id` varchar(40) NOT NULL PRIMARY KEY,
    `password` varchar(40) NOT NULL,
    `name` varchar(40) NOT NULL,
    `email` varchar(40) NOT NULL,
    `age` int NOT NULL
)ENGINE=InnoDB;

CREATE TABLE `board` (
	`num` int(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `createtime` datetime,
    `title` varchar(40) NOT NULL,
    `content` varchar(100) NOT NULL,
    `writername` varchar(40) NOT NULL
)ENGINE=InnoDB;