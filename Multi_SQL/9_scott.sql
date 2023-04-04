--------------------------------------------------------------------------------
-- 집합쿼리
-- union(중복없는 합집합), union all(합집합), intersect(교집합), minus(차집합)

select * from emp;
select * from dept;

-- (1) union : 합집합, 중복되지 않은 값 선택
select deptno from emp; -- 14개
select deptno from dept; -- 4개

select deptno from emp
union
select deptno from dept; -- 4개

-- (2) union all : 합집합, 중복되는 값 포함하여 모든 값 선택
select deptno from emp
union all
select deptno from dept; -- 18개

-- (3) intersect : 교집합, 공통된 값 구하기
select deptno from emp
intersect
select deptno from dept; -- 3개 (emp deptno = 10, 20, 30이므로 deptno의 40은 제외하고 출력)

-- (4) minus : 첫 번째 select문 - 두 번째 select문
-- dept의 deptno가 emp의 deptno를 포함하는 구조
select deptno from emp;
select deptno from dept;

select deptno from dept
minus
select deptno from emp;

select deptno from emp
minus
select deptno from dept;

--------------------------------------------------------------------------------
