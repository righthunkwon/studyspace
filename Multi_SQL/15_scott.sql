--------------------------------------------------------------------------------
-- 트리거(Trigger)
-- insert, update, delete 문이 실행될 때 묵시적으로 실행되는 프로시저

-- 예제(1) 부서명을 변경할 때 변경 전 후 데이터를 보여주는 트리거
create or replace trigger dept_dname_trigger
before -- 쿼리문 실행 전
update on dept
for each row -- 행 단위로 트리거 실행, 생략하면 문장 단위
begin
    dbms_output.put_line('부서명 변경 전 데이터: ' || :old.dname);
    dbms_output.put_line('부서명 변경 후 데이터: ' || :new.dname);
end;

-- 트리거 확인
select * from all_triggers;

-- 부서 테이블 확인
select * from dept;

-- dept 테이블의 부서명 변경하기
-- 변경 자체는 아래 쿼리문만으로 수행 가능하지만, 스크립트 출력에서 변경 전 후 데이터를
-- 보여준다는 점에서 차이가 있다.
update dept set dname ='회계부' where deptno = 10;
update dept set dname ='ACCOUNTING' where deptno = 10;

--------------------------------------------------------------------------------
-- 예제(2) emp 테이블에서 insert, update를 실행하기 전 급여의 평균을 출력하는 트리거
create or replace trigger avg_trigger
before
insert or update on emp
for each row
declare
    avg_sal number;
begin
    select round(avg(sal), 2) into avg_sal from emp;
    dbms_output.put_line('급여의 평균: ' || avg_sal);
end;

-- 트리거 확인
select * from all_triggers;
select round(avg(sal),2) from emp;
insert into emp(empno, ename, sal, deptno) values (1, 'test', 1000, 10);
select * from emp;
rollback;

-- 트리거 삭제
drop trigger dept_dname_trigger;
drop trigger avg_trigger;
--------------------------------------------------------------------------------
