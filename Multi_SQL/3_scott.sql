--------------------------------------------------------------------------------
-- 1. �����Լ�
-- �����Լ�, ���ڿ� ó���Լ�, general function, ��¥ ó�� �Լ�, ��ȯ�Լ�

-- 2. �׷��Լ�

--------------------------------------------------------------------------------

-- �����Լ�

-- abs   : ���밪
-- ceil  : �ø�
-- floor : ����
-- round : �ݿø�
-- dual  : FROM keyword�� ����ϱ� ���� ���� ���̺�

select abs(-45), ceil(-12.1), floor(12.9), round(7.5) from dual;

-- round(m,n)  : m�� n°�ڸ����� �ݿø�
select round(12.345, 0), round(12.345, 1), round(12.345, 2), round(12.345, -1) from dual;

-- mod(m, n)   : m�� n���� ���� ������
select mod(12, 5), mod(9, 5), mod(-7, 5)from dual;

-- power(m, n) : m�� n�� ��
select power(3,2), power(2,5) from dual;

--------------------------------------------------------------------------------

-- ���ڿ� ó�� �Լ�

-- concat(char1, char2) : ���ڿ� ����(|| �����ڿ� ������ ����)
select ename || '��', concat(ename, '��') from emp;

-- lower(char) : ��ü �ҹ���
-- upper(char) : ��ü �빮��
select ename, lower(ename), upper('hi') from emp;

-- initcap(char) : ù��° ���ڸ� �빮�ڷ� ��ȯ
-- ����  _  / �� �������� ����
select initcap('kwon jeong hun'), initcap('coding_god') from dual;

-- LPAD(char1, n, char2) : ���ʿ� ���ڿ� �����ֱ�
-- RPAD(char1, n, char2) : �����ʿ� ���ڿ� �����ֱ�
-- n�� ��ȯ�Ǵ� ���ڿ��� ��ü ����
-- char2�� ���� ����(���� �� ����)
select ename, lpad(ename, 10), lpad(ename, 10, '.'), lpad(ename, 2, '.') from emp;
select ename, rpad(ename, 10), rpad(ename, 10, '.'), rpad(ename, 2, '.') from emp;

-- LPAD�� RPAD�� ��ø - Ȱ�� ���($ ��ȣ ���̱�)
select sal, rpad(lpad(sal, 7, '.'), 8, '$') from emp;

-- length() : ���� ��
-- ���ڿ� ���ڸ� ���ش�.
-- ���鵵 ���ش�.
select length('���� �����Դϴ�'), length('k j h'), length('no.1') from dual;
select ename, length(ename), sal, length(sal) from emp;

-- substr(char, m, n) : m��° �ڸ����� ���̰� n���� ���ڸ� ��ȯ
-- n�� ���� ����, ���� �� ������ ���� ��ü ��ȯ
-- m�� ������ ��� �ڿ��� m��° ���ں��� n���� ���� ��ȯ
select ename, substr(ename, 2) from emp;
select ename, substr(ename, 3) from emp;
select ename, substr(ename, 2, 3) from emp;
select ename, substr(ename, -3, 2) from emp;

-- ����(1) �̸��� ���ڱ����� 50%��ŭ ����ϵ�, ������ ���ڴ� '*'�� ����϶�.
select ename, rpad(substr(ename, 1, length(ename)/2), length(ename), '*') as secure_name from emp;

-- replace(char, str1, str2) : char���ڿ��� Ư�� ������ str1�� str2�� ġȯ
select 'Coding god', replace('Coding god', 'd', 'D') from dual;
select ename, replace(ename, 'A', 'a') from emp;

-- instr(���ڿ�, ã�� ���ڿ�, ������ġ, �߻�Ƚ��) : ���ڿ��� ��ġ ��ȯ
-- ������ ���ڿ��� �߰ߵ��� ������ 0�� ��ȯ
-- ������ġ�� �߻�Ƚ���� ���� ����(�� �� ����Ʈ���� 1)
select ename, instr(ename, 'A') from emp;
select instr('Colored floor', 'or', 4) from dual;
select instr('Colored floor', 'or', 5) from dual;
select instr('Colored floor', 'or', 4, 2) from dual;
select instr('Colored floor', 'or', 4, 3) from dual;

-- trim(���ڿ�)  : ���ڿ��� ���� ���� ����
-- ltrim(���ڿ�) : ���ڿ��� ���� �κ��� ���� ����
-- rtrim(���ڿ�) : ���ڿ��� �� �κ��� ���� ����
select trim('  Sample  ') from dual;    -- 'Sample'
select ltrim('  Sample  ') from dual;   -- 'Sample   '
select rtrim('  Sample  ') from dual;   -- '   Sample'

-- replace �Լ��� �̿��� ���ڿ��� ��� ���� ����
select replace('  Sample  ', ' ', '') from dual; -- 'Sample'

-- trim(�����ҹ��� from ��ġ) -> ���� �� 0�� ���ŵʿ� ��������!
select trim(0 from 01020304050) as "trim example" from dual;

-- ltrim(���ڿ�, ������ ����)
-- rtrim(���ڿ�, ������ ����)
-- substr(char, m, n) : m��° �ڸ����� ���̰� n���� ���ڸ� ��ȯ

-- ����(2) �̸����� ���̵�� �������� �и��Ͽ���
select 
substr('goguma@nate.com', 1, instr('goguma@nate.com', '@') - 1),
substr('goguma@nate.com', instr('goguma@nate.com', '@') + 1) 
from dual;

--------------------------------------------------------------------------------

-- general function : nvl, decode

-- nvl(������, ������)
-- nvl �Լ��� ���� NULL�� ��� �������� ����ϰ�, NULL�� �ƴϸ� ���� ���� �״�� ����Ѵ�.

-- ����(2) emp ���̺��� �޿��� 2500~4000$ �����̰ų�, �������� SALESMAN�� �����
-- �����, ������, �޿�, Ŀ�̼��� ����϶�. (��, ���ʽ��� null�� ��� 0���� ���)
-- ��, SALESMAN�� �޿��� ������������ �����Ͽ���.
select ename �����, job ������, sal �޿�, nvl(comm,0) Ŀ�̼� from emp
where sal between 2500 and 4000 or job = 'SALESMAN' order by sal desc;

-- decode(Į��, ����1, ���1, ����2, ���2, ����3, ���3, ...) : if else�� ����
select deptno, decode(deptno, 10, '��ȹ��', 20, '�λ��', 30, '�ѹ���') �μ��� from emp;

--------------------------------------------------------------------------------

-- ��¥ ó�� �Լ�

-- �⵵ : YYYY, YYY, YY, Y
-- �� : MONTH, MON, MM
-- �� : DDD, DD, D
-- �� �̸� : DAY
-- �ð� : HH24, HH
-- ��, �� : MI, SS
-- ����, ���� : AM, PM


-- sysdate : ���� ��¥�� �ð� ������ �˷��ִ� �Լ�
-- to_char(���� Ȥ�� ��¥, format) : ���ڳ� ��¥�� ���ڷ� ��ȯ�� �ִ� �Լ�
select sysdate from dual;
select sysdate, to_char(sysdate, 'HH24:MI:SS')from dual;
select sysdate, to_char(sysdate, 'YYYY-MM-DD HH24:MI:SS') ���� from dual;
select to_char(sysdate, 'MM'), to_char(sysdate, 'MON'), to_char(sysdate, 'MONTH') from dual;
select to_char(hiredate, 'YYYY-MM-DD HH24:MI:SS') from emp;

-- last_day() : �ش� ��¥�� �޿��� ������ ��¥�� date Ÿ������ �����ϴ� �Լ�
select last_day(sysdate) from dual;
select hiredate, last_day(hiredate) from emp;

-- add_months(��¥, ����) : ��¥�� ���� ���ų� ���ϴ� �Լ� (���б�ȣ�� - / . , ��� ����)
select sysdate, add_months(sysdate, 1), add_months(sysdate, -3) from dual;
select add_months('23-1-1', 3), add_months('23/1/1', 3), add_months('23.1.1', 3) from dual;

-- months_between(��¥1, ��¥2) : ��¥ ������ ���� ���� NUMBER�� Ÿ������ ��ȯ�ϴ� �Լ�
select floor(months_between(sysdate, '2017/11/17')) since_SAT from dual;


-- round() : �ݿø�
-- round(m,n) : m�� n°�ڸ����� �ݿø�

-- ����(1) ���� ������ �ݿø� : round(to_date(��¥), 'YEAR')
select round(to_date('2017-11-17'), 'YEAR'), round(sysdate, 'YEAR') from dual;

-- ����(2) ���� ���� �ݿø� : round(to_date(��¥), 'MONTH')
select round(to_date('2017-11-17'), 'MONTH'), round(sysdate, 'MONTH') from dual;

-- ����(3) ������ �ݿø�(����: �Ͽ���) : round(to_date(��¥), 'DAY')
select round(to_date('2017-11-17'), 'DAY'), round(sysdate, 'DAY') from dual;


-- ��¥�� ���� �������
-- (1) ��¥ + ���� = ��¥
-- (2) ��¥ - ���� = ��¥
-- (3) ��¥ - ��¥ = ����

-- ��¥ ����
select sysdate+100, sysdate-100, floor(sysdate-to_date('2017-11-17', 'YYYY-MM-DD')) from dual;
select add_months('2017-11-17', 3), add_months(to_date('20171117', 'YYYYMMDD'), 3) from dual;


--------------------------------------------------------------------------------

-- ��ȯ �Լ�

-- to_char(���� Ȥ�� ��¥, format) : ���ڳ� ��¥�� ���ڷ� ��ȯ�� �ִ� �Լ�
-- to_date(����, format) : ���ڸ� ��¥ ������ Ÿ������ ��ȯ���ִ� �Լ�


--------------------------------------------------------------------------------

-- �׷� �Լ�
select empno, ename, deptno, sal, comm from emp;

-- max() : �ִ밪
-- min() : �ּҰ�
-- count() : ����
select max(sal) �ִ밪, min(sal) �ּҰ� from emp;
select count(empno), count(ename), count(deptno), count(sal), count(comm) from emp;

-- sum() : �հ�
-- avg() : ���
-- stddev() : ǥ������
select sum(sal), round(avg(sal), 2), round(stddev(sal), 3) from emp;
select sum(sal), round(avg(sal), 2), round(stddev(sal), 3) from emp where job = 'MANAGER';

-- Groub by ��
-- ���ǿ� ���� �׷� ������

select deptno, count(ename), sum(sal), round(avg(sal), 2) from emp 
group by deptno order by deptno asc;

-- ����(1) ������ �޿� �ְ��, �޿� ������, �޿� ���, ������� ���Ͽ���(��, SALESMAN ����� ����)
select job, max(sal) �ְ��, min(sal) ������, round(avg(sal), 2) ���, count(ename) ����� from emp 
where job != 'SALESMAN' group by job;

-- ����(2) �μ���, �������� �޿� �հ�, �޿� ���, ������� ���Ͽ���
select deptno, job, sum(sal) �޿��հ�, avg(sal) �޿����, count(ename) ����� from emp 
group by deptno, job
order by deptno asc, job asc;


-- Having ��
-- �׷��Լ��� ������� �������� ����ؾ� �� ���

-- ����(1) ������ �޿� �ְ��, ���� ������, �޿� �հ�, �޿� ���, ������� ���Ͽ���(��, ������� 3�� �̸��� ������ ����)
select job, max(sal) �ְ��, min(sal) ������, sum(sal) �޿��հ�, round(avg(sal), 2) �޿����, count(empno) ����� from emp
group by job;

select job, max(sal) �ְ��, min(sal) ������, sum(sal) �޿��հ�, round(avg(sal), 2) �޿����, count(empno) ����� from emp
group by job
having count(empno) >= 3;

-- ����(2) �μ��� ������ ���� �޿��� �հ�, �޿��� ���, �����, ǥ�������� ���϶�
-- (��, 1981-01-01 ���� �Ի��� ����� �޿��� 1000�޷� �̸��� ����� �����ϰ�, �μ��� ��������, ������ ������������ ����)
select deptno, job, sum(sal), avg(sal), count(empno), round(stddev(sal),1) from emp
where hiredate >= to_date('1981-01-01', 'YYYY-MM-DD') and sal >= 1000
group by deptno, job
order by deptno desc, job asc;
-- where -> group by -> order by ������ ������ �ʾƼ� ������ �߻��߾���. (������ �� ó����, ������ ��������)
-- where ���� �κп� �ε�ȣ�� �߸� ���ְ� and ��ſ� or�� ���־� ������ �߸� �����Ͽ�����.


-- ����
-- SELECT ������ ���� : FROM > WHERE > GROUP BY > HAVING > SELECT > ORDER BY
-- Q : WHERE ���� GROUP BY�� HAVING���� ���̴� �����ϱ�?
-- A : WHERE ���� �ش� SELECT ���� ��ü�� �����̰�, HAVING ���� WHERE ���� ���� �׷�ȭ �� �����Ϳ� ������ �Ŵ� ���̴�.
--     �߰��� WHERE �������� �����Լ��� ����� �� ������ �̴� HAVING ������ ��� �����ϴ�.

-- rollup() : �׷��Լ��� ��ü ���߰�
select job, sum(sal) from emp group by job;
select job, sum(sal) from emp group by rollup(job);
select deptno, job, sum(sal), count(ename) from emp group by rollup(deptno, job);

-- cube() : �׷��Լ��� ��� �߰�
select job, sum(sal), count(empno) from emp group by job;
select job, sum(sal), count(empno) from emp group by cube(job);
select deptno, job, sum(sal), count(empno) from emp group by cube(deptno, job) order by deptno, job;

-- grouping() : group by ó���� ���� 0, rollup�̳� cube�� ó���� ���� 1�� ��ȯ
select deptno, job, sum(sal), count(empno), grouping(deptno), grouping(job)
from emp
group by cube(deptno, job)
order by deptno, job;




