--------------------------------------------------------------------------------
-- Oracle의 한 계정은 하나의 테이블을 갖는다.
--  --  : 주석
--  *   : 모든 필드

-- 테이블 이름 확인
select * from tabs;

-- 모든 필드 선택(*)
select * from emp;
select * from dept;

-- 특정 필드 선택(필드명)
select ename, deptno, sal from emp;
select dname, loc from dept;

-- 별명 설정(as는 생략 가능)
select ename, deptno 부서번호, sal as 급여 from emp;

-- 데이터 타입 확인
desc emp;

-- 조건 설정(where)
-- oracle에서는 자바와 달리 등호가 ==가 아니라 =이다.
-- oracle에서는 자바와 달리 문자열은 ""가 아니라 ''로 묶어야 한다.
-- SQL 문장은 대소문자를 구별하지 않지만, 데이터는 상수이므로 대소문자를 구별해야 한다.

-- 조건(1) 부서번호 = 10
select * from emp where deptno = 10 ;

-- 조건(2) 업무가 매니저인 사원
select * from emp where job = 'MANAGER';

-- 조건(3) 급여가 2000~3000불인 사원 (부등호, between a and b)
select * from emp where sal >= 2000 and sal <= 3000; 
select * from emp where sal between 2000 and 3000;

-- 조건(4) emp 테이블에서 급여가 2000, 3000, 4000, 5000인 사원
-- in, not in 연산자 : or
select * from emp where sal = 2000 or sal = 3000 or sal = 4000 or sal = 5000;
select * from emp where sal in(2000, 3000, 4000, 5000);

-- 조건(5) 부서코드가 10번 혹은 30번이면서 매니저인 사원 
-- and가 or보다 우선순위가 높으므로 괄호는 선택이 아니라 필수이다.
select * from emp where (deptno = 10 or deptno = 30) and job = 'MANAGER';
select * from emp where (deptno in(10, 30)) and job = 'MANAGER';

-- 조건(6) 사원명이 A로 시작하는 사원
-- like 연산자 : 데이터의 일부가 일치하면 선택
select * from emp where ename like 'A%';

-- % : 여러 개의 문자열을 나타내는 와일드 카드
-- _ : 단 하나의 문자를 나타내는 와일드 카드
-- Escape : 와일드 카드 문자를 일반 문자처럼 사용하고 싶을 때 사용

-- 조건(7) 사원명이 S로 끝나는 사원
select * from emp where ename like '%S';

-- 조건(8) 사원명에 M이 포함된 사원
select * from emp where ename like'%M%';

-- 조건(9) 사원명 중 두 번째 글자가 L인 사원
select * from emp where ename like '_L%';

-- 조건(9)에서 %를 기술하지 않은 경우(%에 유의)
select * from emp where ename like '_L';

-- 조건(10) 사원명 중 세 번째 글자가 L인 사원
select * from emp where ename like '__L%';

-- 조건(11) 12월에 입사한 사원 중 급여가 1500불 이상인 사원
-- like 연산자를 빼먹는 실수에 유의하자.
select * from emp where hiredate like '__/12%' and sal >= 1500;
select * from emp where hiredate like '___12%' and sal >= 1500; 

-- 조건(12) 사원번호가 7500부터 7700번 사이를 제외한 나머지 사원
select * from emp where empno < 7500 or empno > 7700;
select * from emp where empno not between 7500 and 7700;

-- 조건(13) 급여가 3000, 4000, 5000이 아닌 나머지 사원
select * from emp where sal not in (3000, 4000, 5000);

-- 조건(14) 업무 중 'MAN' 글자가 포함되지 않은 나머지 사원
select * from emp where job not like '%MAN%';

-- 조건(15) 연봉 5% 인상
select empno, ename, sal, sal*1.05 from emp;
select empno, ename, sal 기존연봉, sal*1.05 인상연봉 from emp;

-- null은 모든 연산에서 제외된다.
select comm, comm+2 from emp;

-- null은 선택되지도 않는다.
select * from emp where comm = null;

-- null은 null 연산자를 이용하여야 한다.
select * from emp where comm is null;
select * from emp where comm is not null;

-- 조건(16) emp 테이블에서 사원명, 업무, 급여, 입사일, 커미션을 선택하되, 82년도, 83년도에 입사한 사원 중 급여를 20% 인상하여 출력하라
select ename, job, sal*1.2 , hiredate, comm from emp where hiredate not like '82%' and hiredate not like '83%';
select ename, job, sal*1.2, hiredate, comm from emp where not (hiredate like '82%' or hiredate like '83%');

