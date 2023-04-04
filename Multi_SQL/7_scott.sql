--------------------------------------------------------------------------------
-- �������� �����ϱ�(����)
-- ���������̸�: ���̺��_������������_�ʵ�� (�����ϴ� ����)
-- alter table ���̺�� add constraint ���������̸� ��������(primary key, unique, ...)

-- (7) primary key(pk) : ������ Ű ����
-- alter table ���̺�� add constraint ���������̸� primary key (�ʵ��)
select * from tab;
select * from emp;
alter table emp add constraint emp_pk_empno primary key (empno);

-- (8) �������� Ȯ���ϱ�
-- select * from user_constraints;
select * from user_constraints order by table_name;

-- (9) unique : �ߺ� ������ ����
-- alter table ���̺�� add constraint ���������̸� unique(�ʵ��)
select * from salgrade;
alter table salgrade add constraint salgrade_uk_grade unique(grade);
insert into salgrade values(5,0,699); -- unique �������� ���� �������� �ʴ´�.
insert into salgrade values(6,0,699);
delete from salgrade where grade = 6;

-- (10) check : �������� ���� ����
-- alter table ���̺�� add constraint ���������̸� check(�ʵ���� ����)

-- ���� ���� ����(check)
alter table emp add constraint emp_ck_sal check (sal between 800 and 6000);
alter table emp add constraint emp_ck_sal check (sal >= 800 and sal <=6000);
select * from user_constraints where table_name = 'EMP'; -- �������� ���� Ȯ��
insert into emp(empno, ename, sal) values(0001, 'test', 350); -- check constraint violated �߻�

-- �μ��ڵ� ���� ����(check)
alter table dept add constraint dept_ck_deptno check (deptno in (10,20,30,40,50,60,70,80,90));
select * from user_constraints where table_name = 'DEPT'; -- �������� ���� Ȯ��
select * from dept;
insert into dept values(45, 'DEVELOP', 'Los Angeles'); -- check constraint violated �߻�
insert into dept values(50, 'DEVELOP', 'Los Angeles');
delete from dept where deptno = 50; 

-- (11) foreign key(fk) ���� : ���� ���̺� �ִ� �ڷḸ �� �� �ֵ��� �������� ����
-- alter table ���̺�� add constraint ���������̸� foreign key(�ʵ��) references ������ ���̺�(������ �ʵ��)
-- dept���̺��� deptno�� �����Ͽ� emp ���̺��� deptno�� ����
alter table dept add constraint dept_pk_deptno primary key (deptno); -- �����ϴ� �ʵ忡�� primary key�� �����Ǿ�� foreign key�� ������ �� �ִ�.
alter table emp add constraints emp_fk_deptno foreign key(deptno) references dept(deptno);
select * from user_constraints where table_name = 'EMP';

-- �ܷ�Ű�� ������ �÷��� ������ ���� �ܷ�Ű�� �����ϴ� �⺻Ű�� �÷��� ���������� ��ġ�ؾ� �Ѵ�.
-- �̸� ���� �������Ἲ ���࿡ ���� ���̺��� ������ �� ����.

select * from dept;
select * from emp order by deptno;
insert into emp(empno, ename, deptno) values (0001, 'TEST', 50); -- integrity constraint violated �߻�(parent key not found)
insert into emp(empno, ename, deptno) values (0001, 'TEST', 40);
delete from emp where empno = 1;

select * from user_constraints;

-- no action : �����Ǵ� ���ڵ�� �������� �ʴ´�.
-- on delete cascade : �����Ǵ� ���ڵ带 �����Ͽ� �����Ѵ�.

-- (12) �������� �����ϱ�
-- alter table ���̺�� drop constraint ���������̸�
alter table dept drop constraint dept_ck_deptno;

--------------------------------------------------------------------------------
-- Ʈ�����(TRANSACTION)
-- ������ ó���� �� ����(�Ϸ��� SQL��)
-- Ʈ������� ���� : ���డ���� SQL������ ó�� ����� ��
-- Ʈ������� ���� : commit, rollback, savepoint

-- savepoint�� rollback to
select * from dept;
insert into dept values (50, 'TEST', 'TEST');
savepoint a;
insert into dept values (60, 'TEST2', 'TEST2');
insert into dept values (70, 'TEST3', 'TEST3');
rollback to a; -- TEST2, TEST3�� �����ϰ�, TEST�� ����� �������� ���ư���
delete from dept where  deptno = 50; -- ������ ���󺹱�