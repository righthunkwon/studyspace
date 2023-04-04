--------------------------------------------------------------------------------
-- Ʈ����(Trigger)
-- insert, update, delete ���� ����� �� ���������� ����Ǵ� ���ν���

-- ����(1) �μ����� ������ �� ���� �� �� �����͸� �����ִ� Ʈ����
create or replace trigger dept_dname_trigger
before -- ������ ���� ��
update on dept
for each row -- �� ������ Ʈ���� ����, �����ϸ� ���� ����
begin
    dbms_output.put_line('�μ��� ���� �� ������: ' || :old.dname);
    dbms_output.put_line('�μ��� ���� �� ������: ' || :new.dname);
end;

-- Ʈ���� Ȯ��
select * from all_triggers;

-- �μ� ���̺� Ȯ��
select * from dept;

-- dept ���̺��� �μ��� �����ϱ�
-- ���� ��ü�� �Ʒ� ������������ ���� ����������, ��ũ��Ʈ ��¿��� ���� �� �� �����͸�
-- �����شٴ� ������ ���̰� �ִ�.
update dept set dname ='ȸ���' where deptno = 10;
update dept set dname ='ACCOUNTING' where deptno = 10;

--------------------------------------------------------------------------------
-- ����(2) emp ���̺��� insert, update�� �����ϱ� �� �޿��� ����� ����ϴ� Ʈ����
create or replace trigger avg_trigger
before
insert or update on emp
for each row
declare
    avg_sal number;
begin
    select round(avg(sal), 2) into avg_sal from emp;
    dbms_output.put_line('�޿��� ���: ' || avg_sal);
end;

-- Ʈ���� Ȯ��
select * from all_triggers;
select round(avg(sal),2) from emp;
insert into emp(empno, ename, sal, deptno) values (1, 'test', 1000, 10);
select * from emp;
rollback;

-- Ʈ���� ����
drop trigger dept_dname_trigger;
drop trigger avg_trigger;
--------------------------------------------------------------------------------
