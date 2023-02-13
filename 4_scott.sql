--------------------------------------------------------------------------------
-- jdbc

select * from tab;
desc emp;
-- int    : number
-- double : number
-- String : date, ename, job

select empno, ename, job, mgr, hiredate, sal, comm, deptno from emp;
select empno, ename, job, hiredate, sal from emp where ename = upper('adams');
