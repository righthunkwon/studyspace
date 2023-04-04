--------------------------------------------------------------------------------
-- ������ ���۾�(DML)
-- join : 2�� �̻��� ���̺��� �����Ͽ� �����͸� �˻�.
-- �Ϲ������� �� �̻��� ����� ���밪�� primary key��, foreign key���� ����Ͽ� ����.
-- �� ���� ���̺��� select ���� �ȿ��� �����Ϸ���, ��� �ϳ��� Į���� �����Ǿ�� ��

-- ��������, �񵿵�����, self ����, outer ����, natural ����
--------------------------------------------------------------------------------
-- (1) ��������(Equijoin)
-- join ���ǿ��� =�� ����Ͽ� ���� ��Ȯ�� ��ġ�ϴ� ��쿡 ���

-- select
-- from (table1) join (table2)
-- on (����)

-- ����(1) �����, �޿�, �μ����� �����϶� 
-- (������ �޿��� emp ���̺�, �μ����� dept ���̺� �ִ� ��Ȳ)

-- �� ���̺��� ������� ���� �߸��� Ǯ��
select emp.ename, emp.sal, dept.dname from emp, dept; 

-- �� ���̺��� �����Ų ��Ȯ�� Ǯ��
select emp.ename, emp.sal, dept.dname from emp, dept
where emp.deptno = dept.deptno
order by dname; 

-- join���� �̿��� �ٸ� Ǯ��(����)
select ename, sal, dname, emp.deptno 
from emp join dept 
on emp.deptno = dept.deptno;

-- ����(2) ��� �� �μ��ڵ尡 30���� ����� �����, ����, �޿�, �μ���, �μ��ڵ带 �����϶�

-- 1. ���� Ǯ��
-- select ���� deptno���� emp.�̳� dept.�� ������� ���� ��� ���� �߻�
select ename, job, sal, dname, emp.deptno
from emp, dept
where emp.deptno = dept.deptno and emp.deptno = 30;

-- 2. join���� �̿��� Ǯ��
select ename, job, sal, dname, e.deptno 
from emp e join dept d
on e.deptno = d.deptno and e.deptno = 30;


-- ����(3) SALESMAN�� �����ȣ, �̸�, �޿�, �μ���, �ٹ����� ����϶�
select empno, ename, sal, dname, loc
from emp join dept
on emp.deptno = dept.deptno
where emp.job = 'SALESMAN';

-- �ٸ� Ǯ��
select empno, ename, sal, dname, loc
from emp join dept
on emp.deptno = dept.deptno and job='SALESMAN';

--------------------------------------------------------------------------------
-- (2) �񵿵� ����(Non - Equijoin)
-- ����̳� ���� �� join ������ ��Ȯ�� ��ġ���� �ʴ� ��쿡 ������ �ο��ϸ� ���
-- between A and B, is null, is not null, in, not in ���� ������ ���

select * from salgrade;

-- ����(1) �����, ����, �޿�, ȣ���� �����϶�
select e.ename, e.job, e.sal, s.grade ȣ��
from emp e, salgrade s
where e.sal between s.losal and s.hisal;

select e.ename, e.job, e.sal, s.grade ȣ��
from emp e join salgrade s
on e.sal between s.losal and s.hisal;

-- ����(2) 10��, 20�� �μ��� ����� 
-- �����ȣ, �����, �޿�, ���ʽ�, �μ���, ȣ��, �μ���ȣ�� �����϶�
select e.empno, e.ename, e.sal, e.comm, d.dname, s.grade, e.deptno
from emp e join dept d
                on e.deptno = d.deptno and e.deptno in(10,20)
           join salgrade s
                on e.sal between s.losal and s.hisal;  
                
--------------------------------------------------------------------------------
-- (3) Self ����

-- ����(1) �����, ����, �Ի���, �޿�, �����ڸ�, ������ �Ի���, ������ �޿��� �����϶�
select e1.ename, e1.job, e1.hiredate, e1.sal, e2.ename �����ڸ�, e2.hiredate �������Ի���, e2.sal �����ڱ޿�
from emp e1 join emp e2
on e1.mgr=e2.empno;


-- ����(2) emp ���̺��� OOO�� �����ڴ� OOO�̴��� �������� ������ ����϶�
select e1.ename || '�� �����ڴ� ' || e2.ename || '�̴�.' as �����ڸ�
from emp e1 join emp e2
on e1.mgr = e2.empno;

--------------------------------------------------------------------------------
-- (4) Out ����(�ܺ�����)
-- ���� ���̺� ��ġ�ϴ� ���� ���ٸ� �ٸ� �� ���̺��� null�� �Ͽ� ���

-- ����(1) �����, �޿�, �μ��ڵ�, �μ����� �����϶�
-- + ��ȣ�� null���� �ۼ��Ǵ� ��, �� �ڷᰡ �� ���� �ʿ� ���δ�.
select e.ename, e.sal, e.deptno, d.dname, d.deptno
from emp e, dept d
where e.deptno(+) = d.deptno;

select e.ename, e.sal, e.deptno, d.dname, d.deptno
from emp e, dept d
where d.deptno(+) = e.deptno;


-- from A left outer join B
--       A,B ���̺��� ���� ������ �´� ��� B ���̺��� �÷����� �ش� �����͸� ��������, 
--       ���� ������ ���� �ʴ� ��� �� ���̺��� ���ڵ� �� A ���̺��� ���ڵ�� ������ ������� ���ԵǾ� ������ 
--       B���̺��� ������ �÷����� NULL�� ä���(���� ���̺��� ������ A�̴�).
select e.ename, e.sal, e.deptno, d.dname
from emp e left outer join dept d
on e.deptno = d.deptno;

select e.ename, e.sal, e.deptno, d.dname
from dept d left outer join emp e
on e.deptno = d.deptno;


-- from A right outer join B
--      LEFT JOIN�� �ݴ�� ���� ���̺�, �� ���̺� B�� ������ �Ǿ� ����� �����ش�.
select e.ename, e.sal, e.deptno, d.dname
from emp e right outer join dept d
on e.deptno = d.deptno;


-- full outer join : ���ʿ� ��� outer join
select e.ename, e.sal, e.deptno, d.dname
from emp e full outer join dept d
on e.deptno = d.deptno;

select e.ename, e.sal, e.deptno, d.dname
from dept d full outer join emp e
on e.deptno = d.deptno;

-- distinct(�ߺ�����) Ȱ��
select distinct e.deptno emp�μ��ڵ�, d.deptno ��ü�μ��ڵ�
from emp e full outer join dept d
on e.deptno = d.deptno
order by e.deptno;

select distinct e.deptno emp�μ��ڵ�, d.deptno ��ü�μ��ڵ�
from emp e right outer join dept d -- left�� right�� ������ �������ش�.
on e.deptno = d.deptno
order by e.deptno;

select distinct e.deptno emp�μ��ڵ�, d.deptno ��ü�μ��ڵ�
from emp e left outer join dept d
on e.deptno = d.deptno
order by e.deptno;

-- ����(2) å�̸�, ���ǻ��, ������ �ƿ������϶�.
select * from tab;
select * from books;
select * from pub_tbl;
select * from author_tbl;

select b.bookname, p.pub_name, b.price 
from books b join pub_tbl p
on p.pub_code(+) = b.pub_code;

select b.bookname, p.pub_name, b.price 
from books b, pub_tbl p
where p.pub_code(+) = b.pub_code;

--------------------------------------------------------------------------------
-- ���� Ǯ��(27�� �ڷ�)

-- ����(1) ����̸�, �μ���ȣ, �μ����� ����ϴ� ������ �ۼ��ϵ�, �μ���ȣ�� �������� �����϶�.
select e.ename, e.deptno, d.dname
from emp e join dept d
on e.deptno = d.deptno
order by e.deptno;

-- ����(2) NEW YORK���� �ٹ��ϰ� �ִ� ����� ���Ͽ� �̸�, ����, �޿�, �μ����� ����϶�.
select e.ename, e.job, e.sal, d.dname
from emp e join dept d
on e.deptno = d.deptno
where d.loc = 'NEW YORK';

-- Ȯ��
select * from emp order by deptno;
select * from dept;

-- ����(3) ���ʽ��� �޴� ����� ���Ͽ� �̸�, �μ���, ��ġ�� ����϶�.

-- �߸��� Ǯ��(���ʽ��� null�� �ƴ϶� 0���� ������ ����� ����)
select e.ename, d.dname, d.loc
from emp e join dept d
on e.deptno = d.deptno
where e.comm is not null;

-- �ùٸ� Ǯ��
select e.ename, d.dname, d.loc
from emp e join dept d
on e.deptno = d.deptno
where e.comm > 0;

-- ����(4) �̸� �� L�ڰ� �ִ� ����� ���� �̸�, ����, �μ���, ��ġ�� ����϶�.
select e.ename, e.job, d.dname, d.loc
from emp e join dept d
on e.deptno = d.deptno
where e.ename like '%L%';

select * from tab;
select * from emp;

-- ����(5) �Ʒ��� ����� ��µǴ� ������ �ۼ��϶�
select e1.ename Employee, e1.empno Emp#, e2.ename Manager, e2.empno Mgr#
from emp e1 left outer join emp e2
on e1.mgr = e2.empno
order by e1.sal desc;


--------------------------------------------------------------------------------
-- (5) Natural ����
-- ������ ���̺��� ���� �ʵ���� ã�� �����Ѵ�(��, ������ ����� �� ����).
select empno, ename, deptno from emp natural join dept;

-- ��) ��������
select empno, ename, emp.deptno from emp 
join dept on emp.deptno = dept.deptno;

-- join ~ using
-- join�� ������ �־��� �� on ��ſ� using�� ����� �� �ִ�.
select empno, ename, deptno from emp join dept using (deptno);


--------------------------------------------------------------------------------

