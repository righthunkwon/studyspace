--------------------------------------------------------------------------------
-- ��������
-- ������ ���� �� �ٸ� ������(�ٸ� �ϳ��� SQL ������ ���� nesteded�� select ����)
-- �������� �����ʿ� ����ؾ� �Ѵ�.
-- ������ �����ڿ� ������ �����ڿ� �Բ� ���Ǹ�, ��ȣ�� ������� �Ѵ�.

-- ���������� ����
-- ������ ��������, ������ ��������, ���߿� ��������, FROM�� ���� ��������, ������� ��������

--------------------------------------------------------------------------------
-- (1) ������ ��������
-- ���� �ϳ��� ��(��)���� ��ȯ
-- ������ ������(=, >, >=, <, <=, >?, !=)�� ��� ����

-- ����(1) empno�� 7369�� job�� ���� ��� Ȯ��
select empno, ename, job from emp
where job = (select job from emp where empno = 7369);


-- ����(2) ADAMS���� �޿��� ���� �޴� ��� Ȯ��
-- ADAMS �޿�
select * from emp where ename = 'ADAMS'; 
-- ADAMS���� �޿��� ���� �޴� ���
select * from emp
where sal > (select sal from emp where ename = upper('adams'))
order by sal;


-- ����(3) ��� �޿� �̻��� �޴� ��� Ȯ��
-- ��ձ޿� 
select round(avg(sal), 0) from emp;
-- ��պ��� �޿��� ���� �޴� ���
select * from emp
where sal > (select avg(sal) from emp)
order by sal;


-- ����(4) ������̺��� �����, �Ի���, ������, �μ��ڵ带 �����ϵ� 
-- ��ADAMS���� ���� ������ �ϴ� ����̰ų� ��SCOTT���� ���� �μ��� ����� �����϶�.
select ename, hiredate, job, deptno from emp
where job = (select job from emp where ename = 'ADAMS')
or deptno = (select deptno from emp where ename = 'SCOTT');


-- ����(5) ������̺��� �����ȣ�� 7521�� ����� ������ ����,
-- �޿��� 7934�� ������� ���� ����� ���,�̸�,����,�Ի�����,�޿��� ����϶�.
select empno, ename, job, hiredate, sal from emp
where job = (select job from emp where empno = 7521) and
sal > (select sal from emp where empno = 7934);


-- ����(6) ��� ���̺��� ����� �޿��� 20�� �μ��� �ּ� �޿����� ���� �޴� �μ� ���
select deptno, min(sal) from emp group by deptno
having min(sal) > (select min(sal) from emp where deptno = 20);


-- ����(7) ������̺��� 10�� �μ��� ��ձ޿����� ��ձ޿��� ���� ������ ��ձ޿� ���
-- 10�� �μ��� ��ձ޿�
select deptno, round(avg(sal), 0) from emp where deptno = 10 group by deptno;

-- ������ ��ձ޿�
select job, round(avg(sal), 0) from emp group by job order by avg(sal);

-- 10�� �μ��� ��ձ޿����� ��ձ޿��� ���� ������ ��ձ޿�
select job, avg(sal) from emp group by job
having avg(sal) > (select avg(sal) from emp where deptno = 10);

--------------------------------------------------------------------------------
-- (2) ������ ��������
-- �ϳ� �̻��� ���� return�ϴ� ��������
-- ���� �� ������(in, not in, any, all, exists) ��� ����

-- ���� (1) �������� �ݾ��� ���� ���� �޴� ����� �����ȣ, �̸�, ����, �޿� ���
select empno, ename, job, sal from emp
where sal in (select max(sal) from emp group by job);


-- ����(2) ������ SALESMAN�� ����� �ּұ޿����� �����鼭 
-- �μ���ȣ�� 20���� �ƴ� ����� �̸��� �޿�, �μ��ڵ带 ����϶�.
-- SALESMAN�� �ּұ޿� Ȯ��(1250)
select * from emp where job = 'SALESMAN';

-- ������ Ǯ��
-- any : ������������ ������ �����ϴ� ���� �ϳ��� ������ ����� ����
select ename, sal, deptno from emp
where deptno != 20
and sal > any (select sal from emp where job = 'SALESMAN');

-- ������ Ǯ��(����)
select ename, sal, deptno from emp
where deptno != 20
and sal > (select min(sal) from emp where job = 'SALESMAN');


-- ����(3) ������̺��� ��� �� KING(�̸�)�� ���� �μ��� ������� �ʰ� �Ի��� ����� 
-- �����, ����, �޿�, �Ի���, �μ��ڵ带 �����϶�.

-- ������ Ȯ��(81/06/09 = min)
select * from emp 
where deptno = (select deptno from emp where ename = 'KING')
order by hiredate;

-- ���
select ename, job, sal, hiredate, deptno from emp
where hiredate > any (select hiredate from emp where deptno = (select deptno from emp where ename = 'KING'));


-- ����(4) ������ 'SALESMAN'�� ����� �ִ�޿����� �����鼭
-- �μ���ȣ�� 20���� �ƴ� ����� �̸�, ����, �޿�, �μ���ȣ�� ����϶�
-- all : ������������ ��� ���� ������ �����ؾ� ����� ����
select ename, job, sal, deptno from emp order by sal;
select ename, job, sal, deptno from emp where job = 'SALESMAN' order by sal;

-- �ּ� 1600 �̻��̸鼭 �μ���ȣ�� 20���� �ƴ� �����
select ename, job, sal, deptno from emp
where deptno != 20 
and sal > all (select sal from emp where job = 'SALESMAN');


-- ����(5) ������ ����� ���� ����
-- exist : ���������� �����Ͱ� �����ϴ����� ���θ� ���� ��, �����ϴ� ������ ����� ��ȯ
select empno, ename, sal from emp e
where exists (select empno from emp where e.empno = mgr);

--------------------------------------------------------------------------------
-- ANY�� ALL�� ����

-- 1000 > ANY (500, 1000, 2000) / TRUE / ANY ���� 1000 ���� ���� 500�� �����Ƿ� TRUE
-- 1000 = ANY (500, 1000, 2000) / TRUE / ANY ���� ���� �� 1000�� �����Ƿ� TRUE
-- 2000 < ANY (500, 1000, 2000) / FALSE / ANY ���� 2000 ���� ū ���� �����Ƿ� FALSE

--  1000 > ALL (500, 1000, 2000) / FALSE / 1000�� ALL�� ��� �� ���� Ŀ���ϹǷ� FALSE
--  1000 = ALL (500, 1000, 2000) / FALSE / 1000�� ALL�� ��� ���� �����ؾ� �ϹǷ� FALSE
--  3000 > ALL (500, 1000, 2000) / TRUE / 3000�� ALL�� ��� �� ���� ũ�Ƿ� TRUE

--------------------------------------------------------------------------------
-- (3) ���� �� ��������
-- ��������� �� �� �̻��� Į���� ��ȯ�ϴ� �������� (�� �񱳸� ����)

-- ����(1) ������̺��� �޿��� ���ʽ��� �μ� 30�� �ִ� ����� �޿�, ���ʽ��� ��ġ�ϴ� ����� 
-- �̸�, �μ���ȣ, �޿�, ���ʽ��� ����϶�
select empno, sal, deptno, comm from emp
where (sal, deptno) 
in (select sal, deptno from emp where deptno = 30 and comm is not null);


-- ����(2) �������� �ּ� �޿��� �޴� ����� ���, �̸�, ����, �޿�, �μ���ȣ�� ����϶�
-- ��, �������� ������ ��
select empno, ename, job, sal, deptno from emp
where (job, sal) in (select job, min(sal) from emp group by job);

-- ����(3) (��ֺ� �������� �̿�)
select empno, ename, job, sal, deptno from emp
where sal in (select sal from emp where deptno = 30 and comm is not null)
and deptno in (select deptno from emp where deptno = 30 and comm is not null);


--------------------------------------------------------------------------------
-- (4) FROM�� ���� ��������
select empno, ename, sal from emp where deptno = 30;
select * from (select empno, ename, sal from emp where deptno = 30);
select a.empno, a.ename, a.sal from (select empno, ename, sal from emp where deptno = 30) a;


--------------------------------------------------------------------------------
-- (5) ������� ��������

-- �������� ��� �޿�(3212.5)
select avg(a.sal) from (select empno, ename, sal from emp e
where exists (select empno from emp where e.empno = mgr)) a;

--------------------------------------------------------------------------------
