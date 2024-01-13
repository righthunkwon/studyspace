# 1. test_moive 라는 이름으로 새로운 schema를 생성하고, 해당 스키마를 사용
CREATE SCHEMA test_movie;
USE test_movie;

# 2. 만약 movie라는 테이블이 존재한다면 삭제
DROP TABLE IF EXISTS `movie`;

# 3. test_movie 에 다음 조건을 만족하는 movie 테이블을 생성하시오.
CREATE TABLE `movie` (
	`ID` INT NOT NULL,
    `Title` VARCHAR(40) NOT NULL,
    `ReleaseDate` DATE,
    `RunningTime` INT NOT NULL
)ENGINE=InnoDB;

# 4. movie 테이블에 아래와 같이 Director 라는 컬럼을 삽입하시오.
ALTER TABLE `movie` 
ADD COLUMN `Director` VARCHAR(40) NOT NULL;
DESC movie; -- 컬럼 삽입 확인

# 5. movie 테이블의 Director 컬럼을 아래와 같이 변경하시오.
ALTER TABLE `movie` 
MODIFY `Director` varchar(32);
DESC movie; -- 컬럼 변경 확인

#6.	Director 컬럼을 삭제하시오.
ALTER TABLE `movie` DROP COLUMN `Director`;
DESC movie; -- 테이블 변경 확인

#7.	movie 테이블에 아래와 같은 데이터를 삽입하시오.
INSERT INTO `movie` (ID, Title, ReleaseDate, RunningTime)
VALUES 
(1000, '이터널스', '2021-11-05', 156 ),
(1001, '트랜스포터', '2002-10-02', 92),
(1002, '해리포터와 마법사의 돌' ,'2001-12-14', 152),
(1003, '해리포터와 비밀의 방', '2002-12-14',162),
(1004, '기생충','2019-05-30', 153);
SELECT * FROM movie; -- 데이터 삽입 확인

#8.	ID가 1003인 영화의 Title을 '해리포터와 불의 잔'으로 변경
UPDATE movie 
SET Title = '해리포터와 불의 잔' 
WHERE ID = 1003;
select * from movie; -- 데이터 수정 확인

#9.	RunningTime이 100 이하인 영화를 삭제
DELETE FROM movie 
WHERE RunningTIme <= 100;
select * from movie; -- 데이터 수정 확인

#10. movie 테이블에 있는 모든 data를 삭제하시오.
DELETE FROM movie;
select * from movie; -- 데이터 수정 확인