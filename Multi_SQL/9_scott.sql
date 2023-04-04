--------------------------------------------------------------------------------
-- ��������
-- union(�ߺ����� ������), union all(������), intersect(������), minus(������)

select * from emp;
select * from dept;

-- (1) union : ������, �ߺ����� ���� �� ����
select deptno from emp; -- 14��
select deptno from dept; -- 4��

select deptno from emp
union
select deptno from dept; -- 4��

-- (2) union all : ������, �ߺ��Ǵ� �� �����Ͽ� ��� �� ����
select deptno from emp
union all
select deptno from dept; -- 18��

-- (3) intersect : ������, ����� �� ���ϱ�
select deptno from emp
intersect
select deptno from dept; -- 3�� (emp deptno = 10, 20, 30�̹Ƿ� deptno�� 40�� �����ϰ� ���)

-- (4) minus : ù ��° select�� - �� ��° select��
-- dept�� deptno�� emp�� deptno�� �����ϴ� ����
select deptno from emp;
select deptno from dept;

select deptno from dept
minus
select deptno from emp;

select deptno from emp
minus
select deptno from dept;

--------------------------------------------------------------------------------
