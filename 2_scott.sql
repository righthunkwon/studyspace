select * from tab;
select * from emp;

-- 조건(17) 사원명을 기준으로 오름차순(내림차순) 정렬(order by OOO asc / desc)
-- asc는 기본값으로 생략 가능
select * from emp;
select * from emp order by ename; 
select * from emp order by ename asc;
select * from emp order by ename desc;

-- 조건(18) 사원들을 업무별로 정렬하되 급여가 높은 순으로 출력
select * from emp order by job asc, sal desc;

-- 조건(19) 중복행 제거(distinct) : 카테고리를 만들 때 주로 사용
select job from emp;
select distinct job from emp;

-- 조건(20) emp 테이블에서 사원명, 급여, 지급액을 출력
-- 지급액 = 급여 + 커미션
-- 단, 사원명은 오름차순으로 정렬
select ename 사원명, sal 급여, sal+comm 지급액 from emp order by ename asc;

-- 위의 풀이는 지급액이 null로 출력되는 경우가 있으므로 이를 처리해야 한다.
-- 어떤 칼럼의 값이 NULL 값인 경우에 이를 특정값으로 출력하고 싶으면 NVL() 내장함수를 사용하고, 
-- NULL 값이 아닐 경우에 특정값으로 출력하고 싶으면 NVL2() 내장함수를 사용하면 된다.

-- NVL(값, 지정값)
-- NVL 함수는 값이 NULL인 경우 지정값을 출력하고, NULL이 아니면 원래 값을 그대로 출력한다.
select ename 사원명, sal 급여, nvl(comm,0) 커미션, sal+nvl(comm,0) 지급액 from emp order by ename asc;

-- NVL2(값, 지정값1, 지정값2)
-- NVL2(값, not null, null)
-- NVL2 함수는 NULL이 아닌 경우 지정값1을  출력하고, NULL인 경우 지정값2를 출력한다.


--------------------------------------------------------------------------------

-- 예제 풀이(oracle 수업자료 2번)
-- 전체 데이터 확인
select * from tab;
select * from emp;

-- 1번 
select empno, ename, sal from emp;

-- 2번
select empno, ename, sal, job from emp order by ename;
select empno, ename, sal, job from emp order by ename asc;
select empno, ename, sal, job from emp order by 2;
select empno, ename, sal, job from emp order by 2 asc;

-- 3번
select * from emp where hiredate like '__/05%';
select * from emp where hiredate like '___05%';

-- 4번
select * from emp where ename like '%A%' or sal >= 3000;

-- 5번
select * from emp where job in('SALESMAN', 'MANAGER');
select * from emp where job = 'SALESMAN' or job = 'MANAGER';

-- 6번
select * from emp where sal >= 3000 and comm is null; -- 정답이지만 개선 필요
select * from emp where sal >= 3000 and nvl(comm, 0) = 0; -- 개선된 코드(comm이 0일때도 고려)

-- 7번
select * from emp where (sal between 2000 and 4000) or comm is not null order by sal desc; -- 오답(반례: TURNER)
select * from emp where (sal between 2000 and 4000) or nvl(comm, 0)>0 order by sal desc; -- 개선된 코드

-- 8번
select * from tab;
select * from tabs;

-- 9번
select empno, ename, job, hiredate, sal from emp 
where deptno in(10, 20) 
order by job asc, sal desc;

--------------------------------------------------------------------------------

-- Literal : 문자열
-- ''로 감싸고 ||로 연결
select '저는 이름이 ' || ename || '입니다.' 이름 from emp;
select ename || ':', '1 YEAR SALARY = ' || sal*12 from emp;

-- distinct : 중복행 제거
select distinct job from emp;
select distinct deptno, job from emp order by deptno;


