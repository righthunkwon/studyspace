-- SSAFIT DB --
DROP DATABASE IF EXISTS ssafit;

-- 데이터베이스 생성
CREATE DATABASE ssafit DEFAULT CHARACTER SET utf8mb4;
USE ssafit;

-- 사용자 테이블 생성
CREATE TABLE IF NOT EXISTS `user` ( 
`user_id` varchar(20) NOT NULL,  -- 사용자 아이디(PK)
`password` varchar(20) NOT NULL, -- 사용자 비밀번호
`name` varchar(20) NOT NULL, -- 사용자 이름
`gender` INT, -- 사용자 성별. 남자:1 , 여자:2
`nickname` VARCHAR(20) NOT NULL, -- 사용자 닉네임
`birthday` DATE, -- 사용자 생일
PRIMARY KEY(`user_id`));

-- 영상 테이블 생성
CREATE TABLE IF NOT EXISTS `video` ( 
`video_id` INT AUTO_INCREMENT NOT NULL, -- 영상 고유번호(PK)
`title` varchar(30) NOT NULL, -- 영상 제목
`content` TEXT NOT NULL, -- 영상 내용
`part` VARCHAR(10) NOT NULL, -- 운동 부위
`link` VARCHAR(300) NOT NULL, -- URL
`regdate` DATETIME DEFAULT NOW(), -- 영상 등록일
 PRIMARY KEY(`video_id`)
 );

-- 리뷰 테이블 생성
CREATE TABLE IF NOT EXISTS `review` ( 
`review_id` INT AUTO_INCREMENT NOT NULL, -- 리뷰 고유번호(PK) 
`user_id` varchar(50) NOT NULL, -- 사용자 아이디(FK)
`video_id` INT NOT NULL, -- 영상 고유번호(FK)
`title` varchar(30) NOT NULL, -- 리뷰 제목
`content` TEXT NOT NULL, -- 리뷰 내용
`viewcnt` INT NOT NULL, -- 리뷰 조회수
`regdate` DATETIME DEFAULT NOW(), -- 리뷰 둥록일(기본값은 현재 시간)
PRIMARY KEY(`review_id`),
CONSTRAINT `fk_user_id` FOREIGN KEY (`user_id`)  -- 사용자의 키와 댓글 속성중에서 외래키를 연결
        REFERENCES `user` (`user_id`),
CONSTRAINT `fk_video_id` FOREIGN KEY (`video_id`)  -- 영상의 키와 댓글 속성중에서 외래키를 연결
        REFERENCES `video` (`video_id`)
);

-- 아래는 Debug용으로 사용한 SQL문
-- 데이버 베이스 목록 조회
SHOW DATABASES;

-- 테이블 정보 확인
DESC user; -- 사용자 테이블 확인
DESC video; -- 영상 테이블 확인
DESC review; -- 리뷰 테이블 확인