-- 데이터베이스 변경
USE `ssafy_campus`;

-- 테이블 확인
SELECT empno, ename, job
FROM emp;

-- 테이블 확인
SELECT deptno, dname
FROM dept;

-- 조인을 시도했으나 값이 중복해서 출력되는 문제 발생
-- 조인 조건을 지정하지 않거나 조건이 적절하지 않을 경우에 발생
-- 카타시안 곱으로 조인이 실행되어 첫 번째 테이블의 모든 행이 두 번째 테이블의 모든 행에 조인되어 처리된다.
SELECT empno, ename, job, emp.deptno, dept.deptno dname
FROM emp, dept;

-- 조인의 종류
-- (1) INNER JOIN : 일치하는 값을 가진 레코드를 조회(교집합), INNER JOIN절을 사용하지 않고 WHERE절 만으로도 구현 가능
-- (2) OUTER JOIN : LEFT JOIN(왼쪽 집합 기준, 자주 사용), RIGHT JOIN(오른쪽 집합 기준), FULL OUTER JOIN(합집합)
-- (3) SELF JOIN  : 동일한 테이블 두 개를 조인
-- (4) Non-equi JOIN : 조인 조건이 정확히 일치하지 않을 때의 조인

-- (1) INNER JOIN
-- 동등조인 : 조인조건이 일치할 때
-- 비동등조인 : 조인조건이 일치하지 않을 때

-- WHERE을 활용한 동등조인
SELECT empno, ename, job, emp.deptno, dname
FROM emp, dept
WHERE emp.deptno = dept.deptno;

-- 사번이 7788인 사원의 이름, 업무, 부서번호, 부서이름 조회 (1)
-- 쿼리를 두 번 하여 첫 번째 쿼리의 결과를 바탕으로 두 번째 쿼리에 값을 직접 넣어 실행(별로 좋지 않다)
SELECT ename, job, deptno
FROM emp
WHERE empno = 7788;

SELECT dname
FROM dept
WHERE deptno = 20;

-- 사번이 7788인 사원의 이름, 업무, 부서번호, 부서이름 조회 (2)
-- 조인을 위한 조건 기술 : WHERE emp.deptno = dept.deptno
SELECT ename, job, emp.deptno, dname
FROM emp, dept
WHERE emp.deptno = dept.deptno
	AND empno = 7788;

-- ON과 WHERE의 차이
-- ON에는 테이블 간 관계를 논리적으로 규정하기 위한 JOIN의 조건에 대한 기술이 이루어진다.
-- ON은 JOIN 이전의 필터링이므로 필터링이 된 이후에 조인이 이루어지지만, WHERE은 JOIN 이후의 필터링으로 JOIN을 한 이후에 필터링이 이루어진다.

-- 사번이 7788인 사원의 이름, 업무, 부서번호, 부서이름 조회 (3)
-- SELECT문은 논리적으로 SELECT 이전부터(FROM 이하) 실행되기에 SELECT 줄에 별칭을 지정하지 않더라도 별칭을 사용할 수 있다.
SELECT e.ename, e.job, e.deptno, d.dname
FROM emp e
INNER JOIN dept d
ON e.deptno = d.deptno
WHERE e.empno = 7788;

-- 사번이 7788인 사원의 이름, 업무, 부서번호, 부서이름 조회 (4)
-- USING을 통해 ON 구문을 활용하여 기술한 JOIN의 기준을 편하게 지정할 수 있다.
SELECT ename, job, deptno, dname
FROM emp
INNER JOIN dept
USING (deptno)
WHERE empno = 7788;


-- (2) OUTER JOIN
-- LEFT (OUTER) JOIN, RIGHT (OUTER) JOIN, FULL OUTER JOIN

-- OUTER JOIN을 확인하기 위한 데이터 추가
-- 해당 데이터는 DEPTNO에 NULL값이 지정되었다.
INSERT INTO emp
VALUES (7777, "SSAFY", "TUTEE", 7839, "2023-07-05", 1200, 100, NULL);

-- INNER JOIN에 해당하는 동등조인(교집합만 출력)으로 이름, 부서번호, 부서 이름을 출력할 경우
-- 방금 추가한 SSAFY는 DEPTNO가 NULL값이므로 emp 테이블에 들어있음에도 출력되지 않는다는 문제가 발생한다.
SELECT e.ename, e.deptno, d.dname
FROM emp e, dept d
WHERE e.deptno = d.deptno;

-- 따라서 기준이 되는 집합 전체를 출력하는 OUTER JOIN을 활용할 필요가 있다.
-- emp 테이블을 기준으로(left) dept 테이블을 조인(outer join) 시킬 경우 SSAFY도 출력됨을 확인할 수 있다.

-- 직원 테이블을 기준으로(LEFT JOIN)
SELECT e.ename, e.deptno, d.dname
FROM emp e 
LEFT OUTER JOIN dept d
ON e.deptno = d.deptno;

-- 반대로 특정 경우에는 LEFT에 존재하지 않지만 RIGHT에만 존재하는 경우가 있을 수 있는데,
-- 이때는 RIGHT OUTER JOIN을 활용하면 된다. 예제의 경우 OPERATION 부서에 사람이 없으므로 출력되지 않았었는데 이제 된다.

-- 부서 테이블을 기준으로(RIGHT JOIN)
SELECT e.ename, e.deptno, d.dname
FROM emp e 
RIGHT OUTER JOIN dept d
ON e.deptno = d.deptno;

-- (3) SELF JOIN(동일한 테이블을 두 개를 조인)
-- 모든 사원번호, 이름, 매니저 번호, 매니저 이름 
SELECT e1.empno, e1.ename, e1.mgr, e2.ename
FROM emp e1, emp e2
WHERE e1.mgr = e2.empno
ORDER BY e2.ename;

-- KING이 나오지 않음
SELECT e1.empno AS '사번', e1.ename AS '사원이름', e2.empno AS '매니저 번호', e2.ename AS '매니저 이름'
FROM emp e1
INNER JOIN emp e2
ON e1.mgr = e2.empno;

-- KING이 나옴
SELECT e1.empno AS '사번', e1.ename AS '사원이름', e2.empno AS '매니저 번호', e2.ename AS '매니저 이름'
FROM emp e1 
LEFT OUTER JOIN emp e2
ON e1.mgr = e2.empno;


-- (4) 비동등 조인(Non-Equi JOIN)
-- 모든 사원의 사번, 이름, 급여, 급여등급을 조회

-- 비등등 조인을 확인하기 위한 salgrade 테이블 확인
DESC salgrade;
SELECT * FROM salgrade;

SELECT e.empno, e.ename, e.sal AS '급여', sg.grade AS '급여등급'
FROM emp e, salgrade sg
WHERE e.sal BETWEEN sg.LOSAL AND sg.HISAL
ORDER BY sg.grade DESC, e.sal DESC;

SELECT e.empno, e.ename, e.sal AS '급여', sg.grade AS '급여등급'
FROM emp e, salgrade sg
WHERE e.sal >= sg.LOSAL AND e.sal <= sg.HISAL
ORDER BY sg.grade DESC, e.sal DESC;