--------------------------------------------------------------------------------
-- 데이터 조작어(DML)
-- join : 2개 이상의 테이블을 연결하여 데이터를 검색.
-- 일반적으로 둘 이상의 행들의 공통값인 primary key값, foreign key값을 사용하여 조인.
-- 두 개의 테이블을 select 문장 안에서 조인하려면, 적어도 하나의 칼럼이 공유되어야 함

-- 동등조인, 비동등조인, self 조인, outer 조인, natural 조인
--------------------------------------------------------------------------------
-- (1) 동등조인(Equijoin)
-- join 조건에서 =를 사용하여 값이 정확히 일치하는 경우에 사용

-- select
-- from (table1) join (table2)
-- on (조건)

-- 예제(1) 사원명, 급여, 부서명을 선택하라 
-- (사원명과 급여는 emp 테이블에, 부서명은 dept 테이블에 있는 상황)

-- 두 테이블이 연결되지 않은 잘못된 풀이
select emp.ename, emp.sal, dept.dname from emp, dept; 

-- 두 테이블을 연결시킨 정확한 풀이
select emp.ename, emp.sal, dept.dname from emp, dept
where emp.deptno = dept.deptno
order by dname; 

-- join절을 이용한 다른 풀이(권장)
select ename, sal, dname, emp.deptno 
from emp join dept 
on emp.deptno = dept.deptno;

-- 예제(2) 사원 중 부서코드가 30번인 사원의 사원명, 업무, 급여, 부서명, 부서코드를 선택하라

-- 1. 기존 풀이
-- select 문의 deptno에서 emp.이나 dept.을 명시하지 않을 경우 에러 발생
select ename, job, sal, dname, emp.deptno
from emp, dept
where emp.deptno = dept.deptno and emp.deptno = 30;

-- 2. join문을 이용한 풀이
select ename, job, sal, dname, e.deptno 
from emp e join dept d
on e.deptno = d.deptno and e.deptno = 30;


-- 예제(3) SALESMAN의 사원번호, 이름, 급여, 부서명, 근무지를 출력하라
select empno, ename, sal, dname, loc
from emp join dept
on emp.deptno = dept.deptno
where emp.job = 'SALESMAN';

-- 다른 풀이
select empno, ename, sal, dname, loc
from emp join dept
on emp.deptno = dept.deptno and job='SALESMAN';

--------------------------------------------------------------------------------
-- (2) 비동등 조인(Non - Equijoin)
-- 등급이나 학점 등 join 조건이 정확히 일치하지 않는 경우에 범위를 부여하며 사용
-- between A and B, is null, is not null, in, not in 등의 연산자 사용

select * from salgrade;

-- 예제(1) 사원명, 업무, 급여, 호봉을 선택하라
select e.ename, e.job, e.sal, s.grade 호봉
from emp e, salgrade s
where e.sal between s.losal and s.hisal;

select e.ename, e.job, e.sal, s.grade 호봉
from emp e join salgrade s
on e.sal between s.losal and s.hisal;

-- 예제(2) 10번, 20번 부서의 사원의 
-- 사원번호, 사원명, 급여, 보너스, 부서명, 호봉, 부서번호를 선택하라
select e.empno, e.ename, e.sal, e.comm, d.dname, s.grade, e.deptno
from emp e join dept d
                on e.deptno = d.deptno and e.deptno in(10,20)
           join salgrade s
                on e.sal between s.losal and s.hisal;  
                
--------------------------------------------------------------------------------
-- (3) Self 조인

-- 예제(1) 사원명, 업무, 입사일, 급여, 관리자명, 관리자 입사일, 관리자 급여를 선택하라
select e1.ename, e1.job, e1.hiredate, e1.sal, e2.ename 관리자명, e2.hiredate 관리자입사일, e2.sal 관리자급여
from emp e1 join emp e2
on e1.mgr=e2.empno;


-- 예제(2) emp 테이블에서 OOO의 관리자는 OOO이다의 형식으로 내용을 출력하라
select e1.ename || '의 관리자는 ' || e2.ename || '이다.' as 관리자명
from emp e1 join emp e2
on e1.mgr = e2.empno;

--------------------------------------------------------------------------------
-- (4) Out 조인(외부조인)
-- 한쪽 테이블에 일치하는 행이 없다면 다른 쪽 테이블을 null로 하여 출력

-- 예제(1) 사원명, 급여, 부서코드, 부서명을 선택하라
-- + 기호는 null열이 작성되는 쪽, 즉 자료가 더 적은 쪽에 붙인다.
select e.ename, e.sal, e.deptno, d.dname, d.deptno
from emp e, dept d
where e.deptno(+) = d.deptno;

select e.ename, e.sal, e.deptno, d.dname, d.deptno
from emp e, dept d
where d.deptno(+) = e.deptno;


-- from A left outer join B
--       A,B 테이블의 조인 조건이 맞는 경우 B 테이블의 컬럼에서 해당 데이터를 가져오고, 
--       조인 조건이 맞지 않는 경우 각 테이블의 레코드 중 A 테이블의 레코드는 무조건 결과값에 포함되어 나오고 
--       B테이블에서 가져온 컬럼들은 NULL로 채운다(기준 테이블은 왼쪽인 A이다).
select e.ename, e.sal, e.deptno, d.dname
from emp e left outer join dept d
on e.deptno = d.deptno;

select e.ename, e.sal, e.deptno, d.dname
from dept d left outer join emp e
on e.deptno = d.deptno;


-- from A right outer join B
--      LEFT JOIN과 반대로 우측 테이블, 즉 테이블 B가 기준이 되어 결과를 보여준다.
select e.ename, e.sal, e.deptno, d.dname
from emp e right outer join dept d
on e.deptno = d.deptno;


-- full outer join : 양쪽에 모두 outer join
select e.ename, e.sal, e.deptno, d.dname
from emp e full outer join dept d
on e.deptno = d.deptno;

select e.ename, e.sal, e.deptno, d.dname
from dept d full outer join emp e
on e.deptno = d.deptno;

-- distinct(중복제거) 활용
select distinct e.deptno emp부서코드, d.deptno 전체부서코드
from emp e full outer join dept d
on e.deptno = d.deptno
order by e.deptno;

select distinct e.deptno emp부서코드, d.deptno 전체부서코드
from emp e right outer join dept d -- left와 right는 기준을 설정해준다.
on e.deptno = d.deptno
order by e.deptno;

select distinct e.deptno emp부서코드, d.deptno 전체부서코드
from emp e left outer join dept d
on e.deptno = d.deptno
order by e.deptno;

-- 예제(2) 책이름, 출판사명, 가격을 아웃조인하라.
select * from tab;
select * from books;
select * from pub_tbl;
select * from author_tbl;

select b.bookname, p.pub_name, b.price 
from books b join pub_tbl p
on p.pub_code(+) = b.pub_code;

select b.bookname, p.pub_name, b.price 
from books b, pub_tbl p
where p.pub_code(+) = b.pub_code;

--------------------------------------------------------------------------------
-- 문제 풀이(27번 자료)

-- 문제(1) 사원이름, 부서번호, 부서명을 출력하는 문장을 작성하되, 부서번호를 오름차순 정렬하라.
select e.ename, e.deptno, d.dname
from emp e join dept d
on e.deptno = d.deptno
order by e.deptno;

-- 문제(2) NEW YORK에서 근무하고 있는 사원에 대하여 이름, 업무, 급여, 부서명을 출력하라.
select e.ename, e.job, e.sal, d.dname
from emp e join dept d
on e.deptno = d.deptno
where d.loc = 'NEW YORK';

-- 확인
select * from emp order by deptno;
select * from dept;

-- 문제(3) 보너스를 받는 사원에 대하여 이름, 부서명, 위치를 출력하라.

-- 잘못된 풀이(보너스가 null이 아니라 0으로 설정된 사원도 존재)
select e.ename, d.dname, d.loc
from emp e join dept d
on e.deptno = d.deptno
where e.comm is not null;

-- 올바른 풀이
select e.ename, d.dname, d.loc
from emp e join dept d
on e.deptno = d.deptno
where e.comm > 0;

-- 문제(4) 이름 중 L자가 있는 사원에 대해 이름, 업무, 부서명, 위치를 출력하라.
select e.ename, e.job, d.dname, d.loc
from emp e join dept d
on e.deptno = d.deptno
where e.ename like '%L%';

select * from tab;
select * from emp;

-- 문제(5) 아래의 결과가 출력되는 문장을 작성하라
select e1.ename Employee, e1.empno Emp#, e2.ename Manager, e2.empno Mgr#
from emp e1 left outer join emp e2
on e1.mgr = e2.empno
order by e1.sal desc;


--------------------------------------------------------------------------------
-- (5) Natural 조인
-- 조인할 테이블에서 같은 필드명을 찾아 조인한다(단, 별명은 사용할 수 없다).
select empno, ename, deptno from emp natural join dept;

-- 비교) 동등조인
select empno, ename, emp.deptno from emp 
join dept on emp.deptno = dept.deptno;

-- join ~ using
-- join의 조건을 넣어줄 때 on 대신에 using을 사용할 수 있다.
select empno, ename, deptno from emp join dept using (deptno);


--------------------------------------------------------------------------------

