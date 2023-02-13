--------------------------------------------------------------------------------
-- view 테이블
-- 일종의 가상테이블로, 실제 데이터가 저장되지는 않지만 뷰를 통해 데이터를 관리할 수 있다.
-- 하나의 뷰로 여러 테이블에 대한 데이터를 검색할 수 있다.

-- view 테이블 생성(create, 이미 있을 경우 replace)
create or replace view emp_dept
as
select e.empno, e.ename, e.sal, d.dname
from emp e join dept d
on e.deptno = d.deptno;

-- view 테이블 확인
select * from tab;
select * from emp_dept;


-- 예제(1) emp테이블에서 사원번호, 사원명, 급여, 부서번호를 이용하여 emp_view 생성하기
create or replace view emp_view
as
select empno, ename, sal, deptno from emp;

-- 예제(2) emp테이블에서 30번 부서의 사원 중 사원번호, 사원명, 업무, 급여, 부서번호를 이용하여 view를 생성하기
create view emp_30
as
select empno, ename, job, sal, deptno from emp
where deptno = 30;


-- insert
insert into emp(empno, ename, deptno) values(0001, '권정훈', 10);
insert into emp(empno, ename, deptno) values(0002, '훈정권', 30);
insert into emp_30(empno, ename, deptno) values(0003, '정훈권', 10);
insert into emp_30(empno, ename, deptno) values(0004, '훈훈훈', 30);

-- insert 확인
select * from emp;
select * from emp_dept;
select * from emp_30;
commit;

-- delete
delete from emp_dept where empno = 1;
delete from emp_dept where empno = 2;
delete from emp_dept where empno = 3;
delete from emp_dept where empno = 4;
commit;

-- (읽기 전용) view 테이블 생성(with read only)
-- with read only 를 붙여주면 된다.
-- insert와 delete가 불가하다.
create view emp_read
as
select empno, ename, sal from emp
with read only;

-- view의 정보 조회(user_views)
select * from user_views;


-- view 테이블 삭제(drop)
drop view emp_dept;
drop view emp_view;
drop view emp_30;
drop view emp_read;
commit;

--------------------------------------------------------------------------------

