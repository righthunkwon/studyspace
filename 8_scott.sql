--------------------------------------------------------------------------------
-- 내장함수 merge, case, nullif, coalesce

-- (1) merge
-- A테이블과 B테이블을 합친다.
-- A테이블에 있는 레코드가 B테이블에 있으면 update시키고, 없으면 insert를 시킨다.
select * from tab;
select * from emp order by deptno;

-- 테스트를 위한 테이블복사
-- 부서코드가 20번인 사원을 emp_test테이블로 생성
create table emp_test as select * from emp where deptno = 20;
select * from emp_test;

-- 예제(1) emp 테이블에서 사원을 emp_test로 Merge한 뒤,
-- 데이터가 있으면 급여를 10% 인상하고 없으면 새로 insert하라.

merge into emp_test et
using emp e
on (et.empno = e.empno)
when matched then            
    update set et.sal = et.sal * 1.1
when not matched then
    insert values(e.empno, e.ename, e.job, e.mgr, e.hiredate, e.sal, e.comm, e.deptno);
    
-- 타겟 테이블에서 기존에 있던 데이터는 update, 없던 데이터는 insert한다.
select * from emp_test order by deptno; 

-- 대상 테이블은 기존 데이터를 유지한다.
select * from emp order by deptno; 
rollback;

-- 예제(1) 코드 해설
-- emp_test의 별명을 et로, emp의 별명을 e로 지정하여 가독성을 높인다.
-- merge into (update나 insert할 table이름)
-- using (update나 insert할 대상이 되는 source table 혹은 view)
-- on (조건)
-- when matched (조건에 만족하면 실행)
-- when not matched (조건에 만족하지 않으면 실행)


-- 예제(2) emp 테이블에서 job이 SALESMAN 사원만 있는 emp2 테이블을 생성하고,
-- emp에 이미 있는 사원은 급여와 보너스를 더한 값으로 급여를 변경하고 emp에 없는 사원은
-- emp 테이블에서 emp2 테이블로 추가한다.

-- 생성
create table emp2
as 
select * from emp where job = 'SALESMAN';

-- 확인
select * from emp2;

-- 병합
merge into emp2 e2
using emp e
on (e2.empno = e.empno)
when matched then
    update set e2.sal = e2.sal + nvl(e2.comm, 0)
when not matched then
    insert values(e.empno, e.ename, e.job, e.mgr, e.hiredate, e.sal, e.comm, e.deptno);

select * from emp order by job desc;
select * from emp2 order by job desc;
rollback;

--------------------------------------------------------------------------------
-- (2) case
-- decode(if then else)문과 유사

select ename, deptno, case deptno
                        when 10 then '기획부'
                        when 20 then '인사부'
                        when 30 then '총무부'
                        else '영업부'
                    end as "dept name"
from emp
order by "dept name";

--------------------------------------------------------------------------------    
-- (3) nullif
-- nullif(exp1, exp2)
-- exp1과 exp2 값이 같으면 null을, 다르면 exp1을 반환한다.
-- 단, exp1에는 null이 올 수 없다.

select nullif(123, 456) from dual;
select nullif('123', 'abc') from dual;
select nullif('123', '123') from dual;
select nullif('abc', 'abc') from dual;
select nullif('abc', 'def') from dual;

--------------------------------------------------------------------------------
-- (4) coalesce
-- coalesce(expr1, expr2, expr3, ...)
-- expr1이 null이 아니면 expr1값을, 그렇지 않으면 coalesce(expr2, expr3, ...)값을 반환한다.
-- NVL function과 유사하다.
-- NVL(원래값, 바꿀값) : null이면 원래값을, null이 아니면 바꿀값을 구하는 함수

select comm, coalesce(comm, 0) from emp order by comm;
select comm, nvl(comm, 0) from emp order by comm;

--------------------------------------------------------------------------------

