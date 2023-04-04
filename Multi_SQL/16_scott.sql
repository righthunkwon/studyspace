--------------------------------------------------------------------------------
-- Ŀ��(Cursor)
-- ����� Ŀ��, ������ Ŀ��
-- �������� ���ؼ� ��ȯ�Ǵ� ��������� �����ϴ� �޸� ����

-- fetch : Ŀ������ ���ϴ� ������� �����ϴ� ��
-- Ŀ�� ���� -> Ŀ�� open -> fetch -> true �� ��ȯ

-- %FOUND - �Ҵ��� ���ڵ尡 �ִ� ��� true���� ��ȯ.
-- %isOpen - Ŀ���� ���»����� ��� true���� ��ȯ.
-- %NotFound - �Ҵ��� ���ڵ尡 ���� ��� true���� ��ȯ.
-- %RowCount - ī���� ������ �Ѵ�. Ŀ���� ���µ��� ��� 0, ��ġ�� �߻��� �� ���� 1�� ����.

--------------------------------------------------------------------------------
-- ����(1) �μ��ڵ带 �Է��Ͽ� �ش�μ��� 
-- ������ �޿��� ��, �޿��� ���, �����, �ְ�޿�, �����޿��� ���ϴ� ���ν���
create or replace procedure emp_info (i_deptno in emp.deptno%type)
is
    -- Ŀ�� �����ϱ�
    cursor emp_result is
        select e.job, sum(e.sal) sal_sum, round(avg(e.sal),2) sal_avg, count(e.empno) cnt, max(e.sal) sal_max, min(e.sal) sal_min
        from emp e where e.deptno = i_deptno group by e.job;
    
    -- ������ ���� ������ ���� ����
    v_job emp.job%type;
    v_sum number;
    v_avg number;
    v_cnt number;
    v_max number;
    v_min number;
begin
    -- open
    open emp_result;
    
    -- fetch
    loop
        fetch emp_result into v_job, v_sum, v_avg, v_cnt, v_max, v_min;
        exit when emp_result%NOTFOUND; -- exit�� true�� �� Ż��
        dbms_output.put_line(v_job || ', ' || v_sum || ', ' || v_avg || ', ' || v_cnt || ', ' || v_max || ', '  || v_min);
    end loop;
    -- close
    close emp_result;
    dbms_output.put_line('���� �Ϸ�');
end;

-- ���ν��� ����
execute emp_info(30);


--------------------------------------------------------------------------------

