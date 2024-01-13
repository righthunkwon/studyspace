-- (1) 숫자
-- 2의 3제곱
SELECT POW(2, 3)
FROM dual;

-- 별칭으로 연산식을 그대로는 사용할 수 없으므로 따옴표로 묶어줘야 한다.
-- dual은 코드를 작성하기 위해 MySQL에서 제공하는 임시 테이블이다.
SELECT POW(2, 3) AS '2^3'
FROM dual;

-- 8을 3으로 나눈 나머지
-- 별칭에서 띄어쓰기는 허용되지 않고, 띄어쓰기를 하고 싶을 경우 따옴표로 묶어줘야 한다.
SELECT MOD(8, 3) AS "8을 3으로 나눈 나머지";

-- 최대값, 최솟값
SELECT greatest(8,17,86,17,100,77,999,2,13,31,97) AS 최대값, least(8,17,86,17,100,77,999,2,13,31,97) AS 최솟값;

-- 반올림
-- 기본값은 소수 첫째자리에서 반올림으로 0과 동일, 양수는 이후의 소수 자리를, 음수는 자연수 자리를 의미 
SELECT round(1526.159), round(1526.159, 0), round(1526.159, 1), round(1526.159,2), round(1526.159, -1), round(1526.159, -2);


-- (2) 문자
-- 아스키 코드값 얻기
SELECT ascii('0'), ascii('A'), ascii('a'); 

-- 문자열 결합
SELECT CONCAT('PRESIDENT의 이름은 ', ename, ' 입니다.') AS 소개
FROM emp
WHERE job = 'PRESIDENT'; 

-- length는 문자의 byte를 가져온다.
-- 이름의 길이가 5인 직원의 이름을 조회
SELECT ename
FROM emp
WHERE length(ename) = 5 AND char_length(ename) = 5;

-- char_length는 문자의 길이를 가져온다(한글은 3바이트에 해당하고 이모티콘은 4바이트에 해당한다).
SELECT length('김싸피'), char_length('김싸피');
SELECT length('🍕'), char_length('🍕');

-- 문자열 변경
SELECT replace('Hello abc _abc_', 'abc', 'ssafy');

-- 문자열 인덱스
SELECT instr('Hello SSAFY', 'SSAFY');

-- 모든 직원의 이름 3자리조회(첫 인덱스부터 세 글자, MySQL은 인덱스를 1부터 센다)
SELECT substr(ename, 1, 3)
FROM emp;

-- 빈 자리 채우기(Padding)
SELECT LPAD('SSAFY',10,'*'), RPAD('SSAFY',10,'*');

-- 문자열 거꾸로 돌기
SELECT REVERSE('HELLO SSAFY!');
SELECT REVERSE('우영우역삼역기러기인도인토마토별똥별스위스');


-- (3) 날짜
-- 2초 더하기
SELECT ADDTIME("2022-02-13 17:29:21", "2");

-- 날짜 차이
SELECT DATEDIFF("2008-02-18", "2006-02-21");

-- 오늘 구하기
SELECT NOW(), DAY(NOW()), MONTH(NOW()), YEAR(NOW()), YEARWEEK(NOW());


-- (4) 집계 함수
-- 복수 행에 대해 동작, 집계함수 = 복수행함수, 그룹함수, 통계함수
-- 모든 사원에 대하여 사원수, 급여총액, 평균급여, 최고급여, 최저급여 조회
SELECT COUNT(*) AS 사원수, SUM(sal) AS 급여총액, AVG(sal) AS 평균급여, MAX(sal) AS 최고급여, MIN(sal) AS 최저급여
FROM emp;

-- 모든 사원에 대하여 부서, 사원수, 급여총액, 평균급여, 최고급여, 최저급여를 부서별로 조회하고, 소수점 셋째자리에서(둘째자리까지) 반올림
SELECT deptno 부서, COUNT(*) AS 사원수, SUM(sal) AS 급여총액, ROUND(AVG(sal), 2) AS 평균급여, MAX(sal) AS 최고급여, MIN(sal) AS 최저급여
FROM emp
GROUP BY deptno;

-- 모든 사원에 대하여 이름, 부서, 업무, 사원수, 급여총액, 평균급여, 최고급여, 최저급여를 부서별, 직급별로 조회(정렬이 잘 됐는지 파악하기 어려움)
SELECT ename AS 이름, deptno AS 부서, job AS 업무, COUNT(*) AS 사원수, SUM(sal) AS 급여총액, 
       ROUND(AVG(sal),2) AS 평균급여, MAX(sal) AS 최고급여, MIN(sal) AS 최저급여
FROM emp
GROUP BY deptno,job;

-- 모든 사원에 대하여 부서, 업무, 사원수, 급여총액, 평균급여, 최고급여, 최저급여를 부서별, 직급별로 조회(기준점을 제시하여 정렬이 잘 됨을 확인)
SELECT deptno 부서, COUNT(*) AS 사원수, SUM(sal) AS 급여총액, ROUND(AVG(sal), 2) AS 평균급여, MAX(sal) AS 최고급여, MIN(sal) AS 최저급여
FROM emp
GROUP BY deptno, job
ORDER BY deptno;

-- 급여(커미션포함) 평균이 2000이상인 부서번호, 부서별 사원수, 평균급여(커미션포함) 조회 
SELECT deptno, COUNT(*) 사원수, ROUND(AVG(sal+IFNULL(comm, 0)),2) AS "평균급여(커미션포함)"
FROM emp
GROUP BY deptno
HAVING AVG(sal + IFNULL(comm, 0)) >= 2000;


-- (5) 트랜잭션
-- 커밋하거나 롤백할 수 있는 가장 작은 작업 단위

-- MySQL은 기본적으로 세션이 오토커밋 상태이므로
-- 트랜잭션을 사용하기 위해 먼저 오토커밋을 하지 않겠다고 선언
set autocommit = 0;

-- 트랜잭션
USE ssafy;
CREATE TABLE test_table(val VARCHAR(20));

-- 롤백
START TRANSACTION;
INSERT INTO test_table VALUES ('A');
INSERT INTO test_table VALUES ('B');
INSERT INTO test_table VALUES ('C');
INSERT INTO test_table VALUES ('D');
ROLLBACK;
SELECT * FROM test_table;

-- 커밋
START TRANSACTION;
INSERT INTO test_table VALUES ('S');
INSERT INTO test_table VALUES ('S');
INSERT INTO test_table VALUES ('A');
INSERT INTO test_table VALUES ('F');
INSERT INTO test_table VALUES ('Y');
COMMIT;
SELECT * FROM test_table;