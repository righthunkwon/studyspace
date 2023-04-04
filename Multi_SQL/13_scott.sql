--------------------------------------------------------------------------------
-- view ���̺�
-- ������ �������̺��, ���� �����Ͱ� ��������� ������ �並 ���� �����͸� ������ �� �ִ�.
-- �ϳ��� ��� ���� ���̺� ���� �����͸� �˻��� �� �ִ�.

-- view ���̺� ����(create, �̹� ���� ��� replace)
create or replace view emp_dept
as
select e.empno, e.ename, e.sal, d.dname
from emp e join dept d
on e.deptno = d.deptno;

-- view ���̺� Ȯ��
select * from tab;
select * from emp_dept;


-- ����(1) emp���̺��� �����ȣ, �����, �޿�, �μ���ȣ�� �̿��Ͽ� emp_view �����ϱ�
create or replace view emp_view
as
select empno, ename, sal, deptno from emp;

-- ����(2) emp���̺��� 30�� �μ��� ��� �� �����ȣ, �����, ����, �޿�, �μ���ȣ�� �̿��Ͽ� view�� �����ϱ�
create view emp_30
as
select empno, ename, job, sal, deptno from emp
where deptno = 30;


-- insert
insert into emp(empno, ename, deptno) values(0001, '������', 10);
insert into emp(empno, ename, deptno) values(0002, '������', 30);
insert into emp_30(empno, ename, deptno) values(0003, '���Ʊ�', 10);
insert into emp_30(empno, ename, deptno) values(0004, '������', 30);

-- insert Ȯ��
select * from emp;
select * from emp_dept;
select * from emp_30;
commit;

-- delete
delete from emp_dept where empno = 1;
delete from emp_dept where empno = 2;
delete from emp_dept where empno = 3;
delete from emp_dept where empno = 4;
commit;

-- (�б� ����) view ���̺� ����(with read only)
-- with read only �� �ٿ��ָ� �ȴ�.
-- insert�� delete�� �Ұ��ϴ�.
create view emp_read
as
select empno, ename, sal from emp
with read only;

-- view�� ���� ��ȸ(user_views)
select * from user_views;


-- view ���̺� ����(drop)
drop view emp_dept;
drop view emp_view;
drop view emp_30;
drop view emp_read;
commit;

--------------------------------------------------------------------------------

