-- (1) 사용자 데이터 삽입
INSERT INTO `user` 
VALUES 
("ssafyid1", "pwd1", "김싸피", "토끼", '1995-05-13'),
("ssafyid2", "pwd2", "박싸피", "두루미", '2000-12-17'),
("ssafyid3", "pwd3", "서싸피", "호랑이", '1998-01-12');

-- (2) 비디오 데이터 삽입
INSERT INTO `video`
VALUES (1, '가슴 운동 5가지 - 강경원 루틴', '벤치프레스와 덤벨프레스를 기반으로 한 가슴운동', '가슴', '강경원', 'https://www.youtube.com/watch?v=iv8reqGucYE&ab_channel=%EA%B0%95%EA%B2%BD%EC%9B%90', 0, SYSDATE());

INSERT INTO `video` (`title`, `content`, `part`, `creator`, `link`, `regdate`)
VALUES 
('벤치프레스 완벽 가이드 - 강경원 방식', '벤치프레스를 기반으로 한 가슴운동', '가슴', '강경원', 'https://www.youtube.com/watch?v=A2kHURY746E&ab_channel=%EA%B0%95%EA%B2%BD%EC%9B%90',  SYSDATE()),
('인클라인 벤치프레스, 윗가슴을 채우는 가장 좋은 운동', '벤치프레스를 기반으로 한 가슴운동', '가슴', '강경원', 'https://www.youtube.com/watch?v=4HvI_mFhzVQ&ab_channel=%EA%B0%95%EA%B2%BD%EC%9B%90', SYSDATE()),
('오랜만에 상의 탈의하고 가슴 운동', '벤치프레스를 기반으로 한 가슴운동', '가슴', '강경원', 'https://www.youtube.com/watch?v=-ZHWut0mS-c&ab_channel=%EA%B0%95%EA%B2%BD%EC%9B%90', SYSDATE());

INSERT INTO `video` (`title`, `content`, `part`, `creator`, `link`, `regdate`)
VALUES 
('어깨운동제목', '어깨운동내용', '어깨', '강경원', '링크1',  SYSDATE()),
('하체운동제목1', '하체운동내용', '하체', '강경원', '링크2', SYSDATE()),
('하체운동제목2', '하체운동내용', '하체', '강경원', '링크3', SYSDATE());


-- (3) 리뷰 데이터 삽입
-- 각각 부모키가 user / video에 있음
INSERT INTO `review`  
VALUES 
(1, "ssafyid1", 1, "후기 제목1", "후기 내용1", 0, SYSDATE());

INSERT INTO `review` (user_id, video_id, title, content, viewcnt) 
VALUES
("ssafyid2", 3, "후기 제목2", "후기 내용2", 0),
("ssafyid3", 4, "후기 제목3", "후기 내용3", 0);

-- 확인용
SELECT * FROM review;
DELETE FROM review;

-- 데이터 삽입 확인
SELECT * FROM user;
SELECT * FROM review;
SELECT * FROM video;
SELECT * FROM wishlist;

-- 데이터 삭제(초기화)
DELETE FROM user;
DELETE FROM review;
DELETE FROM video;
DELETE FROM wishlist;