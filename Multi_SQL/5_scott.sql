--------------------------------------------------------------------------------
-- ���̺� ����
-- ���� ���̺��� �ʵ�� ���ڵ带 �̿��Ͽ� ���ο� ���̺��� ����
select * from tab;
select * from emp;

-- (1) ��� �ʵ�� ��� ���ڵ� ����
create table emp2
as
select * from emp;
select * from emp2;

-- (2) ���ϴ� �ʵ�� ��� ���ڵ� ����
create table emp3
as
select empno, ename, sal from emp;
select * from emp3;

-- (3) ���ϴ� ���ڵ常 ����
create table emp4
as
select * from emp where deptno = 20;
select * from emp4;

-- (4) ���ϴ� �ʵ常 ����(���ڵ� ����)
create table emp5
as
select * from emp where 1=2; -- ������ �پ��ϰ� ���� ����
select * from emp5;

-- ���� Ȯ��
select * from tab;

--------------------------------------------------------------------------------
-- ������ ���۾�(DML)
-- �������� ����, ����, ����


-- (1) �������� ����
-- insert into ���̺��(��1, ��2, ...) values(������1, ������2, ...)
-- ���ο� ������ DB�� ����� �� ���(���ο� ��ǰ ���, ���Ի�� ��� ��)
select * from emp2;

-- ��� ���
insert into emp2(empno) values (1111);
insert into emp2(empno, ename, sal) values (2222, 'Daniel', 5500);
insert into emp2(empno, ename, sal, deptno) values(3333,'Barajas', 5000, 40);

-- ��� �����͸� ���� ���� �ʵ���� ������ �� �ִ�.
insert into emp2 values(4444, 'Santiago', 'PROFESSOR', '7777', sysdate, 6000, 200, 40);

-- ������ ���� ����(���� ���)
commit; -- �۾� �Ϸ�
rollback; -- �۾� ���

-- ����(1) �μ���ȣ�� 20���� ����� ������ emp4�� �μ���ȣ�� 10���� ������� ����
insert into emp4(empno, ename, sal, deptno)
select empno, ename, sal, deptno from emp where deptno = 10;
select * from emp4; -- Ȯ�� �ڵ�


-- (2) �������� ����
-- update ���̺�� set ��1 = ������1, ��2 = ������2, ... where ����
update emp2 set ename = 'Start', job = 'Test', sal = 0 where empno = 1111;
select * from emp2;

-- ����(1) �� ����� �޿��� 5% �λ�
update emp2 set sal = sal * 1.1;
select * from emp2;
rollback;

-- ����(2) ������ǿ� Ŀ�̼� 300$ ����
update emp2 set comm = comm + 300 where job = 'SALESMAN';
select * from emp2 order by job;
rollback;


-- (3) �������� ����
-- delete from ���̺��(where ����)
-- cf) drop table ���̺�� -> ���̺� ��ü�� ����
delete from emp2 where deptno = 30;
select * from emp2 ;
rollback;

--------------------------------------------------------------------------------

