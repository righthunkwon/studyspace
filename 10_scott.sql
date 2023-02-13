--------------------------------------------------------------------------------
-- 서브쿼리
-- 쿼리문 내의 또 다른 쿼리문(다른 하나의 SQL 문장의 절에 nesteded된 select 문장)
-- 연산자의 오른쪽에 기술해야 한다.
-- 단일행 연산자와 복수행 연산자와 함께 사용되며, 괄호로 묶어줘야 한다.

-- 서브쿼리의 종류
-- 단일행 서브쿼리, 다중행 서브쿼리, 다중열 서브쿼리, FROM절 상의 서브쿼리, 상관관계 서브쿼리

--------------------------------------------------------------------------------
-- (1) 단일행 서브쿼리
-- 오직 하나의 행(값)만을 반환
-- 단일행 연산자(=, >, >=, <, <=, >?, !=)만 사용 가능

-- 예제(1) empno가 7369인 job을 가진 사원 확인
select empno, ename, job from emp
where job = (select job from emp where empno = 7369);


-- 예제(2) ADAMS보다 급여를 많이 받는 사원 확인
-- ADAMS 급여
select * from emp where ename = 'ADAMS'; 
-- ADAMS보다 급여를 많이 받는 사원
select * from emp
where sal > (select sal from emp where ename = upper('adams'))
order by sal;


-- 예제(3) 평균 급여 이상을 받는 사원 확인
-- 평균급여 
select round(avg(sal), 0) from emp;
-- 평균보다 급여를 많이 받는 사원
select * from emp
where sal > (select avg(sal) from emp)
order by sal;


-- 예제(4) 사원테이블에서 사원명, 입사일, 담당업무, 부서코드를 선택하되 
-- ‘ADAMS’와 같은 업무를 하는 사원이거나 ‘SCOTT’과 같은 부서인 사원을 선택하라.
select ename, hiredate, job, deptno from emp
where job = (select job from emp where ename = 'ADAMS')
or deptno = (select deptno from emp where ename = 'SCOTT');


-- 예제(5) 사원테이블에서 사원번호가 7521인 사원과 업무가 같고,
-- 급여가 7934인 사원보다 많은 사원의 사번,이름,업무,입사일자,급여를 출력하라.
select empno, ename, job, hiredate, sal from emp
where job = (select job from emp where empno = 7521) and
sal > (select sal from emp where empno = 7934);


-- 예제(6) 사원 테이블에서 사원의 급여가 20번 부서의 최소 급여보다 많이 받는 부서 출력
select deptno, min(sal) from emp group by deptno
having min(sal) > (select min(sal) from emp where deptno = 20);


-- 예제(7) 사원테이블에서 10번 부서의 평균급여보다 평균급여가 높은 업무의 평균급여 출력
-- 10번 부서의 평균급여
select deptno, round(avg(sal), 0) from emp where deptno = 10 group by deptno;

-- 업무별 평균급여
select job, round(avg(sal), 0) from emp group by job order by avg(sal);

-- 10번 부서의 평균급여보다 평균급여가 높은 업무의 평균급여
select job, avg(sal) from emp group by job
having avg(sal) > (select avg(sal) from emp where deptno = 10);

--------------------------------------------------------------------------------
-- (2) 다중행 서브쿼리
-- 하나 이상의 행을 return하는 서브쿼리
-- 복수 행 연산자(in, not in, any, all, exists) 사용 가능

-- 예제 (1) 업무별로 금액을 가장 많이 받는 사원의 사원번호, 이름, 업무, 급여 출력
select empno, ename, job, sal from emp
where sal in (select max(sal) from emp group by job);


-- 예제(2) 업무가 SALESMAN인 사원의 최소급여보다 많으면서 
-- 부서번호가 20번이 아닌 사원의 이름과 급여, 부서코드를 출력하라.
-- SALESMAN의 최소급여 확인(1250)
select * from emp where job = 'SALESMAN';

-- 다중행 풀이
-- any : 서브쿼리에서 조건을 만족하는 값이 하나라도 있으면 결과를 리턴
select ename, sal, deptno from emp
where deptno != 20
and sal > any (select sal from emp where job = 'SALESMAN');

-- 단일행 풀이(참고)
select ename, sal, deptno from emp
where deptno != 20
and sal > (select min(sal) from emp where job = 'SALESMAN');


-- 예제(3) 사원테이블의 사원 중 KING(이름)이 속한 부서의 사원보다 늦게 입사한 사원의 
-- 사원명, 업무, 급여, 입사일, 부서코드를 선택하라.

-- 데이터 확인(81/06/09 = min)
select * from emp 
where deptno = (select deptno from emp where ename = 'KING')
order by hiredate;

-- 출력
select ename, job, sal, hiredate, deptno from emp
where hiredate > any (select hiredate from emp where deptno = (select deptno from emp where ename = 'KING'));


-- 예제(4) 업무가 'SALESMAN'인 사원의 최대급여보다 많으면서
-- 부서번호가 20번이 아닌 사원의 이름, 업무, 급여, 부서번호를 출력하라
-- all : 서브쿼리에서 모든 값이 조건을 만족해야 결과를 리턴
select ename, job, sal, deptno from emp order by sal;
select ename, job, sal, deptno from emp where job = 'SALESMAN' order by sal;

-- 최소 1600 이상이면서 부서번호가 20번이 아닌 사원들
select ename, job, sal, deptno from emp
where deptno != 20 
and sal > all (select sal from emp where job = 'SALESMAN');


-- 예제(5) 관리자 사원의 정보 선택
-- exist : 서브쿼리의 데이터가 존재하는지의 여부를 따진 뒤, 존재하는 값만을 결과로 반환
select empno, ename, sal from emp e
where exists (select empno from emp where e.empno = mgr);

--------------------------------------------------------------------------------
-- ANY와 ALL의 이해

-- 1000 > ANY (500, 1000, 2000) / TRUE / ANY 값에 1000 보다 작은 500이 있으므로 TRUE
-- 1000 = ANY (500, 1000, 2000) / TRUE / ANY 값에 같은 값 1000이 있으므로 TRUE
-- 2000 < ANY (500, 1000, 2000) / FALSE / ANY 값에 2000 보다 큰 값이 없으므로 FALSE

--  1000 > ALL (500, 1000, 2000) / FALSE / 1000이 ALL의 모든 값 보다 커야하므로 FALSE
--  1000 = ALL (500, 1000, 2000) / FALSE / 1000이 ALL의 모든 값과 동일해야 하므로 FALSE
--  3000 > ALL (500, 1000, 2000) / TRUE / 3000은 ALL의 모든 값 보다 크므로 TRUE

--------------------------------------------------------------------------------
-- (3) 다중 열 서브쿼리
-- 결과값으로 두 개 이상의 칼럼을 반환하는 서브쿼리 (쌍 비교를 위함)

-- 예제(1) 사원테이블에서 급여와 보너스가 부서 30에 있는 사원의 급여, 보너스와 일치하는 사원의 
-- 이름, 부서번호, 급여, 보너스를 출력하라
select empno, sal, deptno, comm from emp
where (sal, deptno) 
in (select sal, deptno from emp where deptno = 30 and comm is not null);


-- 에제(2) 업무별로 최소 급여를 받는 사원의 사번, 이름, 업무, 급여, 부서번호를 출력하라
-- 단, 업무별로 정렬할 것
select empno, ename, job, sal, deptno from emp
where (job, sal) in (select job, min(sal) from emp group by job);

-- 예제(3) (비쌍비교 서브쿼리 이용)
select empno, ename, job, sal, deptno from emp
where sal in (select sal from emp where deptno = 30 and comm is not null)
and deptno in (select deptno from emp where deptno = 30 and comm is not null);


--------------------------------------------------------------------------------
-- (4) FROM절 상의 서브쿼리
select empno, ename, sal from emp where deptno = 30;
select * from (select empno, ename, sal from emp where deptno = 30);
select a.empno, a.ename, a.sal from (select empno, ename, sal from emp where deptno = 30) a;


--------------------------------------------------------------------------------
-- (5) 상관관계 서브쿼리

-- 관리자의 평균 급여(3212.5)
select avg(a.sal) from (select empno, ename, sal from emp e
where exists (select empno from emp where e.empno = mgr)) a;

--------------------------------------------------------------------------------
