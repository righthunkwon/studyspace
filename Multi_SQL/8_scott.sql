--------------------------------------------------------------------------------
-- �����Լ� merge, case, nullif, coalesce

-- (1) merge
-- A���̺�� B���̺��� ��ģ��.
-- A���̺� �ִ� ���ڵ尡 B���̺� ������ update��Ű��, ������ insert�� ��Ų��.
select * from tab;
select * from emp order by deptno;

-- �׽�Ʈ�� ���� ���̺���
-- �μ��ڵ尡 20���� ����� emp_test���̺�� ����
create table emp_test as select * from emp where deptno = 20;
select * from emp_test;

-- ����(1) emp ���̺��� ����� emp_test�� Merge�� ��,
-- �����Ͱ� ������ �޿��� 10% �λ��ϰ� ������ ���� insert�϶�.

merge into emp_test et
using emp e
on (et.empno = e.empno)
when matched then            
    update set et.sal = et.sal * 1.1
when not matched then
    insert values(e.empno, e.ename, e.job, e.mgr, e.hiredate, e.sal, e.comm, e.deptno);
    
-- Ÿ�� ���̺��� ������ �ִ� �����ʹ� update, ���� �����ʹ� insert�Ѵ�.
select * from emp_test order by deptno; 

-- ��� ���̺��� ���� �����͸� �����Ѵ�.
select * from emp order by deptno; 
rollback;

-- ����(1) �ڵ� �ؼ�
-- emp_test�� ������ et��, emp�� ������ e�� �����Ͽ� �������� ���δ�.
-- merge into (update�� insert�� table�̸�)
-- using (update�� insert�� ����� �Ǵ� source table Ȥ�� view)
-- on (����)
-- when matched (���ǿ� �����ϸ� ����)
-- when not matched (���ǿ� �������� ������ ����)


-- ����(2) emp ���̺��� job�� SALESMAN ����� �ִ� emp2 ���̺��� �����ϰ�,
-- emp�� �̹� �ִ� ����� �޿��� ���ʽ��� ���� ������ �޿��� �����ϰ� emp�� ���� �����
-- emp ���̺��� emp2 ���̺�� �߰��Ѵ�.

-- ����
create table emp2
as 
select * from emp where job = 'SALESMAN';

-- Ȯ��
select * from emp2;

-- ����
merge into emp2 e2
using emp e
on (e2.empno = e.empno)
when matched then
    update set e2.sal = e2.sal + nvl(e2.comm, 0)
when not matched then
    insert values(e.empno, e.ename, e.job, e.mgr, e.hiredate, e.sal, e.comm, e.deptno);

select * from emp order by job desc;
select * from emp2 order by job desc;
rollback;

--------------------------------------------------------------------------------
-- (2) case
-- decode(if then else)���� ����

select ename, deptno, case deptno
                        when 10 then '��ȹ��'
                        when 20 then '�λ��'
                        when 30 then '�ѹ���'
                        else '������'
                    end as "dept name"
from emp
order by "dept name";

--------------------------------------------------------------------------------    
-- (3) nullif
-- nullif(exp1, exp2)
-- exp1�� exp2 ���� ������ null��, �ٸ��� exp1�� ��ȯ�Ѵ�.
-- ��, exp1���� null�� �� �� ����.

select nullif(123, 456) from dual;
select nullif('123', 'abc') from dual;
select nullif('123', '123') from dual;
select nullif('abc', 'abc') from dual;
select nullif('abc', 'def') from dual;

--------------------------------------------------------------------------------
-- (4) coalesce
-- coalesce(expr1, expr2, expr3, ...)
-- expr1�� null�� �ƴϸ� expr1����, �׷��� ������ coalesce(expr2, expr3, ...)���� ��ȯ�Ѵ�.
-- NVL function�� �����ϴ�.
-- NVL(������, �ٲܰ�) : null�̸� ��������, null�� �ƴϸ� �ٲܰ��� ���ϴ� �Լ�

select comm, coalesce(comm, 0) from emp order by comm;
select comm, nvl(comm, 0) from emp order by comm;

--------------------------------------------------------------------------------

