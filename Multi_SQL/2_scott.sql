select * from tab;
select * from emp;

-- ����(17) ������� �������� ��������(��������) ����(order by OOO asc / desc)
-- asc�� �⺻������ ���� ����
select * from emp;
select * from emp order by ename; 
select * from emp order by ename asc;
select * from emp order by ename desc;

-- ����(18) ������� �������� �����ϵ� �޿��� ���� ������ ���
select * from emp order by job asc, sal desc;

-- ����(19) �ߺ��� ����(distinct) : ī�װ��� ���� �� �ַ� ���
select job from emp;
select distinct job from emp;

-- ����(20) emp ���̺��� �����, �޿�, ���޾��� ���
-- ���޾� = �޿� + Ŀ�̼�
-- ��, ������� ������������ ����
select ename �����, sal �޿�, sal+comm ���޾� from emp order by ename asc;

-- ���� Ǯ�̴� ���޾��� null�� ��µǴ� ��찡 �����Ƿ� �̸� ó���ؾ� �Ѵ�.
-- � Į���� ���� NULL ���� ��쿡 �̸� Ư�������� ����ϰ� ������ NVL() �����Լ��� ����ϰ�, 
-- NULL ���� �ƴ� ��쿡 Ư�������� ����ϰ� ������ NVL2() �����Լ��� ����ϸ� �ȴ�.

-- NVL(��, ������)
-- NVL �Լ��� ���� NULL�� ��� �������� ����ϰ�, NULL�� �ƴϸ� ���� ���� �״�� ����Ѵ�.
select ename �����, sal �޿�, nvl(comm,0) Ŀ�̼�, sal+nvl(comm,0) ���޾� from emp order by ename asc;

-- NVL2(��, ������1, ������2)
-- NVL2(��, not null, null)
-- NVL2 �Լ��� NULL�� �ƴ� ��� ������1��  ����ϰ�, NULL�� ��� ������2�� ����Ѵ�.


--------------------------------------------------------------------------------

-- ���� Ǯ��(oracle �����ڷ� 2��)
-- ��ü ������ Ȯ��
select * from tab;
select * from emp;

-- 1�� 
select empno, ename, sal from emp;

-- 2��
select empno, ename, sal, job from emp order by ename;
select empno, ename, sal, job from emp order by ename asc;
select empno, ename, sal, job from emp order by 2;
select empno, ename, sal, job from emp order by 2 asc;

-- 3��
select * from emp where hiredate like '__/05%';
select * from emp where hiredate like '___05%';

-- 4��
select * from emp where ename like '%A%' or sal >= 3000;

-- 5��
select * from emp where job in('SALESMAN', 'MANAGER');
select * from emp where job = 'SALESMAN' or job = 'MANAGER';

-- 6��
select * from emp where sal >= 3000 and comm is null; -- ���������� ���� �ʿ�
select * from emp where sal >= 3000 and nvl(comm, 0) = 0; -- ������ �ڵ�(comm�� 0�϶��� ���)

-- 7��
select * from emp where (sal between 2000 and 4000) or comm is not null order by sal desc; -- ����(�ݷ�: TURNER)
select * from emp where (sal between 2000 and 4000) or nvl(comm, 0)>0 order by sal desc; -- ������ �ڵ�

-- 8��
select * from tab;
select * from tabs;

-- 9��
select empno, ename, job, hiredate, sal from emp 
where deptno in(10, 20) 
order by job asc, sal desc;

--------------------------------------------------------------------------------

-- Literal : ���ڿ�
-- ''�� ���ΰ� ||�� ����
select '���� �̸��� ' || ename || '�Դϴ�.' �̸� from emp;
select ename || ':', '1 YEAR SALARY = ' || sal*12 from emp;

-- distinct : �ߺ��� ����
select distinct job from emp;
select distinct deptno, job from emp order by deptno;


