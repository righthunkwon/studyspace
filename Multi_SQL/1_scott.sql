--------------------------------------------------------------------------------
-- Oracle�� �� ������ �ϳ��� ���̺��� ���´�.
--  --  : �ּ�
--  *   : ��� �ʵ�

-- ���̺� �̸� Ȯ��
select * from tabs;

-- ��� �ʵ� ����(*)
select * from emp;
select * from dept;

-- Ư�� �ʵ� ����(�ʵ��)
select ename, deptno, sal from emp;
select dname, loc from dept;

-- ���� ����(as�� ���� ����)
select ename, deptno �μ���ȣ, sal as �޿� from emp;

-- ������ Ÿ�� Ȯ��
desc emp;

-- ���� ����(where)
-- oracle������ �ڹٿ� �޸� ��ȣ�� ==�� �ƴ϶� =�̴�.
-- oracle������ �ڹٿ� �޸� ���ڿ��� ""�� �ƴ϶� ''�� ����� �Ѵ�.
-- SQL ������ ��ҹ��ڸ� �������� ������, �����ʹ� ����̹Ƿ� ��ҹ��ڸ� �����ؾ� �Ѵ�.

-- ����(1) �μ���ȣ = 10
select * from emp where deptno = 10 ;

-- ����(2) ������ �Ŵ����� ���
select * from emp where job = 'MANAGER';

-- ����(3) �޿��� 2000~3000���� ��� (�ε�ȣ, between a and b)
select * from emp where sal >= 2000 and sal <= 3000; 
select * from emp where sal between 2000 and 3000;

-- ����(4) emp ���̺��� �޿��� 2000, 3000, 4000, 5000�� ���
-- in, not in ������ : or
select * from emp where sal = 2000 or sal = 3000 or sal = 4000 or sal = 5000;
select * from emp where sal in(2000, 3000, 4000, 5000);

-- ����(5) �μ��ڵ尡 10�� Ȥ�� 30���̸鼭 �Ŵ����� ��� 
-- and�� or���� �켱������ �����Ƿ� ��ȣ�� ������ �ƴ϶� �ʼ��̴�.
select * from emp where (deptno = 10 or deptno = 30) and job = 'MANAGER';
select * from emp where (deptno in(10, 30)) and job = 'MANAGER';

-- ����(6) ������� A�� �����ϴ� ���
-- like ������ : �������� �Ϻΰ� ��ġ�ϸ� ����
select * from emp where ename like 'A%';

-- % : ���� ���� ���ڿ��� ��Ÿ���� ���ϵ� ī��
-- _ : �� �ϳ��� ���ڸ� ��Ÿ���� ���ϵ� ī��
-- Escape : ���ϵ� ī�� ���ڸ� �Ϲ� ����ó�� ����ϰ� ���� �� ���

-- ����(7) ������� S�� ������ ���
select * from emp where ename like '%S';

-- ����(8) ����� M�� ���Ե� ���
select * from emp where ename like'%M%';

-- ����(9) ����� �� �� ��° ���ڰ� L�� ���
select * from emp where ename like '_L%';

-- ����(9)���� %�� ������� ���� ���(%�� ����)
select * from emp where ename like '_L';

-- ����(10) ����� �� �� ��° ���ڰ� L�� ���
select * from emp where ename like '__L%';

-- ����(11) 12���� �Ի��� ��� �� �޿��� 1500�� �̻��� ���
-- like �����ڸ� ���Դ� �Ǽ��� ��������.
select * from emp where hiredate like '__/12%' and sal >= 1500;
select * from emp where hiredate like '___12%' and sal >= 1500; 

-- ����(12) �����ȣ�� 7500���� 7700�� ���̸� ������ ������ ���
select * from emp where empno < 7500 or empno > 7700;
select * from emp where empno not between 7500 and 7700;

-- ����(13) �޿��� 3000, 4000, 5000�� �ƴ� ������ ���
select * from emp where sal not in (3000, 4000, 5000);

-- ����(14) ���� �� 'MAN' ���ڰ� ���Ե��� ���� ������ ���
select * from emp where job not like '%MAN%';

-- ����(15) ���� 5% �λ�
select empno, ename, sal, sal*1.05 from emp;
select empno, ename, sal ��������, sal*1.05 �λ󿬺� from emp;

-- null�� ��� ���꿡�� ���ܵȴ�.
select comm, comm+2 from emp;

-- null�� ���õ����� �ʴ´�.
select * from emp where comm = null;

-- null�� null �����ڸ� �̿��Ͽ��� �Ѵ�.
select * from emp where comm is null;
select * from emp where comm is not null;

-- ����(16) emp ���̺��� �����, ����, �޿�, �Ի���, Ŀ�̼��� �����ϵ�, 82�⵵, 83�⵵�� �Ի��� ��� �� �޿��� 20% �λ��Ͽ� ����϶�
select ename, job, sal*1.2 , hiredate, comm from emp where hiredate not like '82%' and hiredate not like '83%';
select ename, job, sal*1.2, hiredate, comm from emp where not (hiredate like '82%' or hiredate like '83%');

