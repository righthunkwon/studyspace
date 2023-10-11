CREATE SCHEMA ssafy_test;

use ssafy_test;

# user 라는 테이블이 존재하지 않으면 생성
create table if not exists `user` (
#기본 키 는 id
	`id` varchar(50) not null primary key,
    `pass` varchar(30) not null,
    `name` varchar(50) not null,
    `email` varchar(50) not null
)engine = InnuseroDB;

# board 라는 테이블이 존재하지 않으면 생성
create table if not exists `board` (
# 기본 키 인 게시글 번호는 정수, 생성될 때 자동 증가
	`board_num` int not null primary key AUTO_INCREMENT,
    `title` varchar(50) not null,
    `content` varchar(100) not null,
    `writer_id` varchar(50) not null,
    `create_time` datetime not null,
# writer_id 는 user 테이블의 id 컬럼을 참조하는 외래 키
    CONSTRAINT `fk_board_user`
		FOREIGN KEY(`writer_id`)
        REFERENCES `user` (`id`)
# 외래키 삭제나 변경시 할 액션
        on delete cascade
        on update cascade
)engine = InnoDB;

# comment 라는 테이블이 존재하지 않으면 생성
create table IF NOT EXISTS `comment` (
	`writer_id` varchar(50) not null,
    `board_num` int not null,
    `writer_name` varchar(50) not null,
    `comment` varchar(50) not null,
    `create_time` datetime not null,
# 기본 키는 writer_id, `board_num`, `create_time` 세가지를 조합
    PRIMARY KEY (`writer_id`, `board_num`, `create_time`),
# board_num 은 board 테이블의 board_num 컬럼을 참조하는 외래 키
    CONSTRAINT `fk_comment_board`
		FOREIGN KEY (`board_num`)
        REFERENCES `board` (`board_num`)
        on delete cascade
        on update cascade,
# writer_id 는 user 테이블의 id 컬럼을 참조하는 외래 키
	CONSTRAINT `fk_comment_user`
		FOREIGN KEY (`writer_id`)
        REFERENCES `user` (`id`)
        on delete cascade
        on update cascade
)engine = InnoDB;
