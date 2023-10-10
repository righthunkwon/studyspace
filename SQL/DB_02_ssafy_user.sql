-- ssafy 데이터 베이스 생성 및 사용
CREATE DATABASE IF NOT EXISTS SSAFY;
USE SSAFY; -- 더블클릭 시 실행


-- (0) 테이블
-- 테이블 생성
-- 생성할 때 지정한 자료형과 속성들 확인해볼 것
CREATE TABLE ssafy_user (
    user_num INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_id VARCHAR(20) NOT NULL,
    user_name VARCHAR(20) NOT NULL,
    user_password VARCHAR(20) NOT NULL,
    user_email VARCHAR(30),
    signup_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- 테이블 정보 확인(
-- 열을 어떻게 지정했는지 확인 가능
DESC ssafy_user;

-- (1) 데이터 조회
-- 전체 테이블 데이터 조회
SELECT * FROM ssafy_user;


-- (2) 데이터 입력
-- 모든 컬럼 입력
INSERT INTO ssafy_user
VALUES (1, "godqhr", "양명균", "1234", "godqhr@gmail.com", now());

-- 원하는 컬럼만 입력
-- NOT NULL 값은 반드시 입력해야 한다.
INSERT INTO ssafy_user (user_id, user_name, user_password)
VALUES("kimssafy", "김싸피", "1q2w3e4r!@");

-- 여러행 입력
INSERT INTO ssafy_user (user_id, user_name, user_password)
VALUES  ("leessafy", "이싸피", "0000"),
		("parkssafy", "박싸피", "1111"),
        ("5Ssafy", "오싸피", "2222");
        
        
-- (3) 데이터 수정(safe mode 해제 필요, Edit -> preferences -> SQLEditor)
-- 데이터를 전부 수정하는 건 위험하기 때문에 MySQL에서 자체적으로 이를 safe mode로 막아두었다.
UPDATE ssafy_user
SET user_name = 'anonymous';

-- user_num이 3번인 학생 비밀번호 1234로 수정
UPDATE ssafy_user
SET user_password = '1234'
WHERE user_num = 3;


-- (4) 데이터 삭제
-- user_num가 4인 학생 삭제
DELETE FROM ssafy_user
WHERE user_num = 4;


-- 기능 구현 확인용 조회
SELECT * FROM ssafy_user;