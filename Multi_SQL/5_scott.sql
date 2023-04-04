--------------------------------------------------------------------------------
-- 테이블 복사
-- 기존 테이블의 필드와 레코드를 이용하여 새로운 테이블을 생성
select * from tab;
select * from emp;

-- (1) 모든 필드와 모든 레코드 복사
create table emp2
as
select * from emp;
select * from emp2;

-- (2) 원하는 필드와 모든 레코드 복사
create table emp3
as
select empno, ename, sal from emp;
select * from emp3;

-- (3) 원하는 레코드만 복사
create table emp4
as
select * from emp where deptno = 20;
select * from emp4;

-- (4) 원하는 필드만 복사(레코드 제외)
create table emp5
as
select * from emp where 1=2; -- 조건은 다양하게 설정 가능
select * from emp5;

-- 생성 확인
select * from tab;

--------------------------------------------------------------------------------
-- 데이터 조작어(DML)
-- 데이터의 삽입, 수정, 삭제


-- (1) 데이터의 삽입
-- insert into 테이블명(열1, 열2, ...) values(데이터1, 데이터2, ...)
-- 새로운 정보를 DB에 기록할 때 사용(새로운 상품 등록, 신입사원 등록 등)
select * from emp2;

-- 사원 등록
insert into emp2(empno) values (1111);
insert into emp2(empno, ename, sal) values (2222, 'Daniel', 5500);
insert into emp2(empno, ename, sal, deptno) values(3333,'Barajas', 5000, 40);

-- 모든 데이터를 넣을 때는 필드명을 생략할 수 있다.
insert into emp2 values(4444, 'Santiago', 'PROFESSOR', '7777', sysdate, 6000, 200, 40);

-- 데이터 삽입 적용(공통 기능)
commit; -- 작업 완료
rollback; -- 작업 취소

-- 예제(1) 부서번호가 20번인 사원의 집합인 emp4에 부서번호가 10번인 사원들을 삽입
insert into emp4(empno, ename, sal, deptno)
select empno, ename, sal, deptno from emp where deptno = 10;
select * from emp4; -- 확인 코드


-- (2) 데이터의 수정
-- update 테이블명 set 열1 = 수정값1, 열2 = 수정값2, ... where 조건
update emp2 set ename = 'Start', job = 'Test', sal = 0 where empno = 1111;
select * from emp2;

-- 예제(1) 전 사원의 급여를 5% 인상
update emp2 set sal = sal * 1.1;
select * from emp2;
rollback;

-- 예제(2) 세일즈맨에 커미션 300$ 지급
update emp2 set comm = comm + 300 where job = 'SALESMAN';
select * from emp2 order by job;
rollback;


-- (3) 데이터의 삭제
-- delete from 테이블명(where 조건)
-- cf) drop table 테이블명 -> 테이블 자체를 삭제
delete from emp2 where deptno = 30;
select * from emp2 ;
rollback;

--------------------------------------------------------------------------------

