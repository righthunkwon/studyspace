--------------------------------------------------------------------------------
-- 1. 내장함수
-- 숫자함수, 문자열 처리함수, general function, 날짜 처리 함수, 변환함수

-- 2. 그룹함수

--------------------------------------------------------------------------------

-- 숫자함수

-- abs   : 절대값
-- ceil  : 올림
-- floor : 버림
-- round : 반올림
-- dual  : FROM keyword를 기술하기 위한 가상 테이블

select abs(-45), ceil(-12.1), floor(12.9), round(7.5) from dual;

-- round(m,n)  : m을 n째자리까지 반올림
select round(12.345, 0), round(12.345, 1), round(12.345, 2), round(12.345, -1) from dual;

-- mod(m, n)   : m을 n으로 나눈 나머지
select mod(12, 5), mod(9, 5), mod(-7, 5)from dual;

-- power(m, n) : m의 n승 값
select power(3,2), power(2,5) from dual;

--------------------------------------------------------------------------------

-- 문자열 처리 함수

-- concat(char1, char2) : 문자열 연결(|| 연산자와 동일한 역할)
select ename || '님', concat(ename, '님') from emp;

-- lower(char) : 전체 소문자
-- upper(char) : 전체 대문자
select ename, lower(ename), upper('hi') from emp;

-- initcap(char) : 첫번째 문자를 대문자로 변환
-- 공백  _  / 를 기준으로 구분
select initcap('kwon jeong hun'), initcap('coding_god') from dual;

-- LPAD(char1, n, char2) : 왼쪽에 문자열 끼워넣기
-- RPAD(char1, n, char2) : 오른쪽에 문자열 끼워넣기
-- n은 반환되는 문자열의 전체 길이
-- char2는 생략 가능(생략 시 공백)
select ename, lpad(ename, 10), lpad(ename, 10, '.'), lpad(ename, 2, '.') from emp;
select ename, rpad(ename, 10), rpad(ename, 10, '.'), rpad(ename, 2, '.') from emp;

-- LPAD와 RPAD의 중첩 - 활용 사례($ 기호 붙이기)
select sal, rpad(lpad(sal, 7, '.'), 8, '$') from emp;

-- length() : 글자 수
-- 문자와 숫자를 세준다.
-- 공백도 세준다.
select length('저는 정훈입니다'), length('k j h'), length('no.1') from dual;
select ename, length(ename), sal, length(sal) from emp;

-- substr(char, m, n) : m번째 자리부터 길이가 n개인 문자를 반환
-- n은 생략 가능, 생략 시 나머지 문자 전체 반환
-- m이 음수인 경우 뒤에서 m번째 문자부터 n개의 문자 반환
select ename, substr(ename, 2) from emp;
select ename, substr(ename, 3) from emp;
select ename, substr(ename, 2, 3) from emp;
select ename, substr(ename, -3, 2) from emp;

-- 예제(1) 이름을 글자길이의 50%만큼 출력하되, 나머지 문자는 '*'로 출력하라.
select ename, rpad(substr(ename, 1, length(ename)/2), length(ename), '*') as secure_name from emp;

-- replace(char, str1, str2) : char문자열의 특정 문자인 str1을 str2로 치환
select 'Coding god', replace('Coding god', 'd', 'D') from dual;
select ename, replace(ename, 'A', 'a') from emp;

-- instr(문자열, 찾을 문자열, 시작위치, 발생횟수) : 문자열의 위치 반환
-- 지정한 문자열이 발견되지 않으면 0을 반환
-- 시작위치와 발생횟수는 생략 가능(둘 다 디폴트값은 1)
select ename, instr(ename, 'A') from emp;
select instr('Colored floor', 'or', 4) from dual;
select instr('Colored floor', 'or', 5) from dual;
select instr('Colored floor', 'or', 4, 2) from dual;
select instr('Colored floor', 'or', 4, 3) from dual;

-- trim(문자열)  : 문자열의 양쪽 공백 제거
-- ltrim(문자열) : 문자열의 시작 부분의 공백 제거
-- rtrim(문자열) : 문자열의 끝 부분의 공백 제거
select trim('  Sample  ') from dual;    -- 'Sample'
select ltrim('  Sample  ') from dual;   -- 'Sample   '
select rtrim('  Sample  ') from dual;   -- '   Sample'

-- replace 함수를 이용한 문자열의 모든 공백 제거
select replace('  Sample  ', ' ', '') from dual; -- 'Sample'

-- trim(제거할문자 from 위치) -> 양쪽 끝 0만 제거됨에 유의하자!
select trim(0 from 01020304050) as "trim example" from dual;

-- ltrim(문자열, 제거할 문자)
-- rtrim(문자열, 제거할 문자)
-- substr(char, m, n) : m번째 자리부터 길이가 n개인 문자를 반환

-- 예제(2) 이메일의 아이디와 도메인을 분리하여라
select 
substr('goguma@nate.com', 1, instr('goguma@nate.com', '@') - 1),
substr('goguma@nate.com', instr('goguma@nate.com', '@') + 1) 
from dual;

--------------------------------------------------------------------------------

-- general function : nvl, decode

-- nvl(원래값, 지정값)
-- nvl 함수는 값이 NULL인 경우 지정값을 출력하고, NULL이 아니면 원래 값을 그대로 출력한다.

-- 예제(2) emp 테이블에서 급여가 2500~4000$ 사이이거나, 담당업무가 SALESMAN인 사원의
-- 사원명, 담당업무, 급여, 커미션을 출력하라. (단, 보너스가 null인 경우 0으로 출력)
-- 단, SALESMAN의 급여는 내림차순으로 정렬하여라.
select ename 사원명, job 담당업무, sal 급여, nvl(comm,0) 커미션 from emp
where sal between 2500 and 4000 or job = 'SALESMAN' order by sal desc;

-- decode(칼럼, 조건1, 결과1, 조건2, 결과2, 조건3, 결과3, ...) : if else와 유사
select deptno, decode(deptno, 10, '기획부', 20, '인사부', 30, '총무부') 부서명 from emp;

--------------------------------------------------------------------------------

-- 날짜 처리 함수

-- 년도 : YYYY, YYY, YY, Y
-- 월 : MONTH, MON, MM
-- 일 : DDD, DD, D
-- 일 이름 : DAY
-- 시간 : HH24, HH
-- 분, 초 : MI, SS
-- 오전, 오후 : AM, PM


-- sysdate : 현재 날짜와 시간 정보를 알려주는 함수
-- to_char(숫자 혹은 날짜, format) : 숫자나 날짜를 문자로 변환해 주는 함수
select sysdate from dual;
select sysdate, to_char(sysdate, 'HH24:MI:SS')from dual;
select sysdate, to_char(sysdate, 'YYYY-MM-DD HH24:MI:SS') 현재 from dual;
select to_char(sysdate, 'MM'), to_char(sysdate, 'MON'), to_char(sysdate, 'MONTH') from dual;
select to_char(hiredate, 'YYYY-MM-DD HH24:MI:SS') from emp;

-- last_day() : 해당 날짜의 달에서 마지막 날짜를 date 타입으로 리턴하는 함수
select last_day(sysdate) from dual;
select hiredate, last_day(hiredate) from emp;

-- add_months(날짜, 숫자) : 날짜에 월을 빼거나 더하는 함수 (구분기호로 - / . , 모두 가능)
select sysdate, add_months(sysdate, 1), add_months(sysdate, -3) from dual;
select add_months('23-1-1', 3), add_months('23/1/1', 3), add_months('23.1.1', 3) from dual;

-- months_between(날짜1, 날짜2) : 날짜 사이의 달의 수를 NUMBER형 타입으로 반환하는 함수
select floor(months_between(sysdate, '2017/11/17')) since_SAT from dual;


-- round() : 반올림
-- round(m,n) : m을 n째자리까지 반올림

-- 예제(1) 월을 연도로 반올림 : round(to_date(날짜), 'YEAR')
select round(to_date('2017-11-17'), 'YEAR'), round(sysdate, 'YEAR') from dual;

-- 예제(2) 일을 월로 반올림 : round(to_date(날짜), 'MONTH')
select round(to_date('2017-11-17'), 'MONTH'), round(sysdate, 'MONTH') from dual;

-- 예제(3) 요일을 반올림(기준: 일요일) : round(to_date(날짜), 'DAY')
select round(to_date('2017-11-17'), 'DAY'), round(sysdate, 'DAY') from dual;


-- 날짜에 대한 산술연산
-- (1) 날짜 + 숫자 = 날짜
-- (2) 날짜 - 숫자 = 날짜
-- (3) 날짜 - 날짜 = 숫자

-- 날짜 증감
select sysdate+100, sysdate-100, floor(sysdate-to_date('2017-11-17', 'YYYY-MM-DD')) from dual;
select add_months('2017-11-17', 3), add_months(to_date('20171117', 'YYYYMMDD'), 3) from dual;


--------------------------------------------------------------------------------

-- 변환 함수

-- to_char(숫자 혹은 날짜, format) : 숫자나 날짜를 문자로 변환해 주는 함수
-- to_date(문자, format) : 문자를 날짜 데이터 타입으로 변환해주는 함수


--------------------------------------------------------------------------------

-- 그룹 함수
select empno, ename, deptno, sal, comm from emp;

-- max() : 최대값
-- min() : 최소값
-- count() : 갯수
select max(sal) 최대값, min(sal) 최소값 from emp;
select count(empno), count(ename), count(deptno), count(sal), count(comm) from emp;

-- sum() : 합계
-- avg() : 평균
-- stddev() : 표준편차
select sum(sal), round(avg(sal), 2), round(stddev(sal), 3) from emp;
select sum(sal), round(avg(sal), 2), round(stddev(sal), 3) from emp where job = 'MANAGER';

-- Groub by 절
-- 조건에 따라 그룹 나누기

select deptno, count(ename), sum(sal), round(avg(sal), 2) from emp 
group by deptno order by deptno asc;

-- 예제(1) 업무별 급여 최고액, 급여 최저액, 급여 평균, 사원수를 구하여라(단, SALESMAN 사원은 제외)
select job, max(sal) 최고액, min(sal) 최저액, round(avg(sal), 2) 평균, count(ename) 사원수 from emp 
where job != 'SALESMAN' group by job;

-- 예제(2) 부서별, 업무별로 급여 합계, 급여 평균, 사원수를 구하여라
select deptno, job, sum(sal) 급여합계, avg(sal) 급여평균, count(ename) 사원수 from emp 
group by deptno, job
order by deptno asc, job asc;


-- Having 절
-- 그룹함수의 결과값을 조건으로 사용해야 할 경우

-- 예제(1) 업무별 급여 최고액, 급쳐 최저액, 급여 합계, 급여 평균, 사원수를 구하여라(단, 사원수가 3명 미만인 업무는 제외)
select job, max(sal) 최고액, min(sal) 최저액, sum(sal) 급여합계, round(avg(sal), 2) 급여평균, count(empno) 사원수 from emp
group by job;

select job, max(sal) 최고액, min(sal) 최저액, sum(sal) 급여합계, round(avg(sal), 2) 급여평균, count(empno) 사원수 from emp
group by job
having count(empno) >= 3;

-- 예제(2) 부서별 업무에 대한 급여의 합계, 급여의 평균, 사원수, 표준편차를 구하라
-- (단, 1981-01-01 이전 입사한 사원과 급여가 1000달러 미만인 사원은 제외하고, 부서는 내림차순, 업무는 오름차순으로 정렬)
select deptno, job, sum(sal), avg(sal), count(empno), round(stddev(sal),1) from emp
where hiredate >= to_date('1981-01-01', 'YYYY-MM-DD') and sal >= 1000
group by deptno, job
order by deptno desc, job asc;
-- where -> group by -> order by 순으로 써주지 않아서 에러가 발생했었다. (조건은 맨 처음에, 정렬은 마지막에)
-- where 조건 부분에 부등호를 잘못 써주고 and 대신에 or을 써주어 조건을 잘못 설정하였었다.


-- 참고
-- SELECT 구문의 순서 : FROM > WHERE > GROUP BY > HAVING > SELECT > ORDER BY
-- Q : WHERE 절과 GROUP BY의 HAVING절의 차이는 무엇일까?
-- A : WHERE 절은 해당 SELECT 쿼리 전체의 조건이고, HAVING 절은 WHERE 조건 이후 그룹화 한 데이터에 조건을 거는 것이다.
--     추가로 WHERE 절에서는 집계함수를 사용할 수 없으며 이는 HAVING 절에서 사용 가능하다.

-- rollup() : 그룹함수의 전체 합추가
select job, sum(sal) from emp group by job;
select job, sum(sal) from emp group by rollup(job);
select deptno, job, sum(sal), count(ename) from emp group by rollup(deptno, job);

-- cube() : 그룹함수에 통계 추가
select job, sum(sal), count(empno) from emp group by job;
select job, sum(sal), count(empno) from emp group by cube(job);
select deptno, job, sum(sal), count(empno) from emp group by cube(deptno, job) order by deptno, job;

-- grouping() : group by 처리된 행은 0, rollup이나 cube로 처리된 행은 1을 반환
select deptno, job, sum(sal), count(empno), grouping(deptno), grouping(job)
from emp
group by cube(deptno, job)
order by deptno, job;




