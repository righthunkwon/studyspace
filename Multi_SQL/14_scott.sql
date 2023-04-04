--------------------------------------------------------------------------------
-- PL/SQL
-- Oracle's Procedual Language extension to SQL
-- Oracle���� �����ϴ� �����Ϳ��� ���
-- SQL���� ���α׷��� ����� ������ �Ͽ� ���� ����, �ݺ��� ���� ���� �����ϰ� �Ѵ�.

--------------------------------------------------------------------------------
-- PL/SQL �⺻ ����

-- DECLARE
--    [ ���� ]
-- BEGIN
--    [ ���� ]
-- EXCEPTION
--    [ ����ó�� ]
-- END;

--------------------------------------------------------------------------------
-- (1) SERVEROUTPUT ����
-- �⺻������ PL/SQL�� ������� �������� �ʱ⿡ ������ SERVEROUTPUT�� on���� ����
-- �ݵ�� ���ϴ� ���๮�� �巡���Ͽ� �����ؾ� �Ѵ�.
set serveroutput on;


-- (2)��ũ��Ʈ�� ���
begin
    dbms_output.put_line('Hello Oracle!');
end;


-- (3) ���� ���� �� ��ũ��Ʈ�� ���
declare
    i_name varchar2(10);
begin
    i_name := '������'; 
    dbms_output.put_line(i_name);
end;


--------------------------------------------------------------------------------
-- ����(1) emp ���̺��� �����ȣ, �����, �޿��� �����Ͽ� ����ϴ� ���ν��� ����
-- in �Ķ����  : �ܺο��� ���ν��� ���� ���� �־��ִ� ������ ������ �� ���
-- %type       : ���̺� ���� Ư�� �ʵ�� ���� ������������ ����

-- ���ν��� ����(emp_select)
create or replace procedure emp_select(i_empno in emp.empno%type)
is 
    -- ���� ����(record)
    s_empno emp.empno%type;
    s_ename emp.ename%type;
    s_sal emp.sal%type;
begin
    -- ���ڵ带 �����Ͽ� into ���Ŀ� ����� ������ ����
    select empno, ename, sal into s_empno, s_ename, s_sal from emp where empno = i_empno;
    dbms_output.put_line('�����ȣ: ' || s_empno);
    dbms_output.put_line('����̸�: ' || s_ename);
    dbms_output.put_line('����ӱ�: ' || s_sal);
end;

-- ���ν��� Ȯ��
select * from user_source where name = 'EMP_SELECT';

-- ���ν��� ����
execute emp_select(7782);
execute emp_select(7788);


--------------------------------------------------------------------------------
-- ����(2) ����� �Է¹޾� �����ȣ, �����, ����, �޿�, �μ��ڵ�, �μ����� �����Ͽ� ���
-- %rowtype : ���̺� ���� ��� �ʵ�� ���� ������������ ���� �����ϱ�

create or replace procedure emp_row (i_empno in number)
is
    -- select�� �����͸� ���� ���� ����
    record_emp emp%rowtype;
    record_dept dept%rowtype;
begin
    -- ���ڵ带 �����Ͽ� into ���Ŀ� ����� ������ ����
    select empno, ename, job, sal, emp.deptno, dname
    into record_emp.empno, record_emp.ename, record_emp.job, record_emp.sal, record_emp.deptno, record_dept.dname
    from emp join dept on emp.deptno = dept.deptno and empno = i_empno;
    
    dbms_output.put_line('empno: '||record_emp.empno);
    dbms_output.put_line('ename: '||record_emp.ename);
    dbms_output.put_line('job: '||record_emp.job);
    dbms_output.put_line('sal: '||record_emp.sal);
    dbms_output.put_line('deptno: '||record_emp.deptno);
    dbms_output.put_line('dname: '||record_dept.dname);
end;

-- ���ν��� Ȯ��
select * from user_source where name = 'EMP_ROW';

-- ���ν��� ����
execute emp_row(7900);
execute emp_row(7788);
execute emp_row(8569); -- "no data found" ���� �߻�(���� �����ȣ)

--------------------------------------------------------------------------------
-- ���� (3) ������� �Է¹޾� �ش� ����� �����ȣ, �����, �޿��� ����ϴ� ���ν���
-- Exception ó���ϱ�
-- ������ �߰�(�̸��� CLARK�� ��ġ�� case)
select * from emp;
insert into emp(empno, ename, sal, deptno) values (7777, 'KWON', 6000, 40);
insert into emp(empno, ename, sal, deptno) values (7783, 'CLARK', 4500, 20);
commit;

-- ���ν��� ����

create or replace procedure emp_ename(i_ename in emp.ename%type)
is
    o_empno emp.empno%type;
    o_ename emp.ename%type;
    o_sal emp.sal%type;
begin
    select empno, ename, sal into o_empno, o_ename, O_sal
    from emp where ename = upper(i_ename);
    
    dbms_output.put_line(o_empno || ', ' || o_ename || ', ' || o_sal);
    
    -- ����ó��
    exception
        when NO_DATA_FOUND then
            dbms_output.put_line(i_ename || ' ����� �����ϴ�.');
        when TOO_MANY_ROWS then
            dbms_output.put_line(i_ename || ' ����� �� �� �̻��Դϴ�.');
        when OTHERS then
            dbms_output.put_line('���ܰ� �߻��߽��ϴ�.');
end;

-- ���ν��� ����
execute emp_ename('james');
execute emp_ename('kwon');
execute emp_ename('clark');

--------------------------------------------------------------------------------
-- ����(4) �����ȣ, �����, �޿�, �μ���ȣ�� �Է¹޾� ����� ����ϴ� ���ν���(insert)
-- 'in' parameter     : �ܺο��� ���ν��� ���� ������ �ֱ�

create or replace procedure emp_insert(i_empno in emp.empno%type, i_ename in emp.ename%type, i_sal in number, i_deptno in emp.deptno%type)
is

begin
    insert into emp(empno, ename, sal, deptno) values(i_empno, i_ename, i_sal, i_deptno);
    dbms_output.put_line(i_ename || '����� ��ϵǾ����ϴ�.');
end;
                                        
-- ���ν��� ����
-- execute = exec
exec emp_insert(8888, 'DIET', 800, 10);
execute emp_insert(8888, 'DIET', 800, 10);

-- ������ Ȯ��
select * from emp;


--------------------------------------------------------------------------------
-- ����(5) �����ȣ�� �Է¹޾� �̸�, ����, �޿��� �����ϴ� ���ν���
-- 'out' parameter    : ���ν��� ������ �ܺη� ������ ��������
create or replace procedure emp_list(i_empno in emp.empno%type, o_ename out emp.ename%type, o_job out emp.job%type, o_sal out emp.sal%type)
is

begin
    select ename, job, sal into o_ename, o_job, o_sal
    from emp where empno = i_empno;
end;

-- ���� ����
-- variable = vari
variable p_ename varchar2(30);
variable p_job varchar2(30);
variable p_sal number;


-- ���ν��� ����
exec emp_list(7788, :p_ename, :p_job, :p_sal);
print p_ename;
print p_job;
print p_sal;

--------------------------------------------------------------------------------
-- ����(6) �����ȣ, �����, �μ��ڵ�, �޿��� �Է¹޾� ����� ����ϴ� ���ν���
-- 'in out' parameter : ���� ������ in�� out�� ó��
create or replace procedure emp_in (i_empno emp.empno%type, i_ename emp.ename%type, i_deptno emp.deptno%type, i_sal emp.sal%type)
is
begin
    insert into emp(empno, ename, sal, hiredate, deptno)
    values(i_empno, i_ename, i_sal, sysdate, i_deptno);
    dbms_output.put_line(i_ename || ' ����� ��ϵǾ����ϴ�.');
end;

-- ���ν��� ����
exec emp_in(6666, 'Lee', 40, 2500);
select * from emp;

--------------------------------------------------------------------------------
-- ����(7) �����ȣ�� �޿��λ���� �Է¹޾� �ش� ����� �޿��� �����ϴ� ���ν���
-- update 
create or replace procedure emp_sal_update(i_empno emp.empno%type, i_rate number)
is
    r_emp emp%rowtype;
begin
    -- i_empno ����� �޿� �λ�
    update emp set sal = sal + (sal*(i_rate/100))
    where empno = i_empno;
    dbms_output.put_line('������Ʈ �Ǿ����ϴ�.');
    commit;
    
    select empno, ename, sal into r_emp.empno, r_emp.ename, r_emp.sal
    from emp where empno = i_empno;
    dbms_output.put_line(r_emp.empno || ',' || r_emp.sal);
end;

-- ���ν��� ����
select * from emp;
exec emp_sal_update(8888, 10);

--------------------------------------------------------------------------------
-- ����(8) �����ȣ�� �Է¹޾� �ش� ��� �����ϱ�
create or replace procedure emp_del (i_empno emp.empno%type)
is
begin
    delete from emp where empno = i_empno;
    dbms_output.put_line(i_empno || ' ����� �����Ǿ����ϴ�.');
    commit;
end;

-- ���ν��� ����
exec emp_del(6666);
exec emp_del(7777);
exec emp_del(7783);
exec emp_del(8888);
select * from emp;

--------------------------------------------------------------------------------
-- ����(9) �����ȣ�� �Է¹޾� �ش� ����� �����ϴ� ���ν���
-- type �����
create or replace procedure emp_search(i_empno emp.empno%type)
is
    -- ���ڵ��� ������ Ÿ�� �����
    TYPE emp_record_type Is RECORD(
        v_empno emp.empno%type,
        v_ename emp.ename%type,
        v_job emp.ename%type,
        v_mgr emp.mgr%type,
        v_hiredate emp.hiredate%type,
        v_sal emp.sal%type,
        v_comm emp.comm%type,
        v_deptno emp.deptno%type
    );
    -- ���� ����
    e_record emp_record_type;
begin
    -- ������ �ʵ��� ���� e_record ������ ����
    select * into e_record
    from emp where empno = i_empno;
    
    dbms_output.put_line(e_record.v_empno || ', ' || e_record.v_ename || ', ' || e_record.v_hiredate || ', ' || e_record.v_sal);
end;

-- ���ν��� ����
execute emp_search(7521);
select * from emp;


--------------------------------------------------------------------------------
-- �������̺� �ܷ�Ű ����(books, pub_tbl, author_tbl)
select * from books;
select * from pub_tbl;
select * from author_tbl;

-- �ܷ�Ű ����
alter table books
add constraint books_fk_pub_tbl foreign KEY(PUB_CODE) references pub_tbl(PUB_CODE);

-- �������� ���� Ȯ��(P: �⺻Ű, R: �ܷ�Ű, U: ������, C: üũ)
select * from user_constraints;


--------------------------------------------------------------------------------
-- ���� ���̺�(books, pub_tbl, author_tbl)
select * from books;
select * from pub_tbl;
select * from author_tbl;

-- ����(1) ������, ���ǻ��, ����, �۰���, ī�װ��� �Է¹޾� å�� ����ϴ� ���ν���
create or replace procedure books_in (i_bookname in books.bookname%type,
                                      i_pubname in pub_tbl.pub_name%type,
                                      i_price in books.price%type,
                                      i_author in author_tbl.author%type,
                                      i_category in books.category%type)
is
    -- ���ǻ� �ڵ�
    s_pub_code pub_tbl.pub_code%type;
    -- �۰� �ڵ�
    s_author_code author_tbl.author_code%type;
begin
    -- ���ǻ���� �̿��Ͽ� ���ǻ� �ڵ� ����
    select pub_code into s_pub_code
    from pub_tbl where pub_name = i_pubname;
    -- �۰����� �̿��Ͽ� �۰� �ڵ� ����
    select author_code into s_author_code
    from author_tbl where author = i_author;
    -- å ���
    insert into books(isbn, bookname, price, category, pub_code, author_code)
    values(book_sq.nextval, i_bookname, i_price, i_category, s_pub_code, s_author_code);
    commit;
        
    exception
        when others then
            dbms_output.put_line('�߸��� ������ �ԷµǾ����ϴ�.');
end;

-- ���ν��� ����
execute books_in('�׽�Ʈ', '�Ѻ��̵��', 20000, '�׽�Ʈ', 'IT');
select * from books;


--------------------------------------------------------------------------------
-- ����(2) �����ȣ�� �ش��ϴ� ����� �����, �μ����� ����ϴ� ���ν���
-- if��

create or replace procedure emp_if(i_empno in number)
is
    s_ename emp.ename%type;
    s_deptno emp.deptno%type;
    s_dname varchar(20);
begin
    select ename, deptno into s_ename, s_deptno from emp where empno = i_empno;
    
    if s_deptno = 10 then
        s_dname := 'ȸ��μ�';
    elsif s_deptno = 20 then
        s_dname := '�����μ�';
    elsif s_deptno = 30 then
        s_dname := '�����μ�';
    elsif s_deptno = 40 then
        s_dname := '�����μ�';
    else
        s_dname := '���� �μ��Դϴ�.';
    end if;
    
    dbms_output.put_line(s_ename || ', ' || s_dname);
end;

-- ���ν��� ����
exec emp_if(7788);
exec emp_if(7902);
select * from emp;

--------------------------------------------------------------------------------
-- ����(10) �μ��ڵ带 �Է¹޾� �ش� �μ��� ����� ��� �����϶�
-- PL/SQL������ �ݺ��� FOR��, LOOP��, WHILE��
-- ������ ���� ������ ���� := �� ����Ѵ�.

-- (1) FOR�� �̿��� �ݺ���
create or replace procedure emp_ename_sal(i_deptno emp.deptno%type)
is
    -- �迭�� ����(�����, �޿�, �Ի���)
    type ename_arr is table of emp.ename%type index by binary_integer;
    type sal_arr is table of emp.sal%type index by binary_integer;
    type hiredate_arr is table of emp.hiredate%type index by binary_integer;
    
    -- �迭�� ���� ����(������ Ÿ�� ��, Ÿ���� ��ܿ� ������ �迭��)
    s_ename ename_arr;
    s_sal sal_arr;
    s_hiredate hiredate_arr;
    
    -- �ε��� ���� ����
    idx integer := 0;
begin   
    for e in (select ename, sal, hiredate from emp where deptno = 20) loop
        idx := idx +1;
        s_ename(idx) := e.ename;
        s_sal(idx) := e.sal;
        s_hiredate(idx) := e.hiredate;
    end loop;
    
    -- �迭�� �ִ� ������� ����ϱ�
    for i in 1..idx loop
        dbms_output.put_line(s_ename(i) || ', ' || s_sal(i) || ', ' || s_hiredate(i));
    end loop;
end;

-- ���ν��� ����
execute emp_ename_sal(20);

--------------------------------------------------------------------------------
-- ����(11) Ư�� ��ȣ���� �μ���ȣ�� �����Ͽ� �����ȣ�� ����϶�
-- exit�� ������ true�϶� ����(�ٸ� �ݺ����� false�� �� ����Ǵ� �Ͱ� ���ȴ�)
-- exit when ���ǽ� ;

-- (2) LOOP�� �̿��� �ݺ���
create or replace procedure emp_loop_insert(i_start in number, i_deptno in emp.deptno%type)
is
    i number;
begin
    i := i_start;
    loop
        insert into emp(empno, ename, deptno) values (i, 'loop' || i, i_deptno);
        i := i+1;
        exit when i > i_start + 5;
    end loop;
    dbms_output.put_line('����� ����Ͽ����ϴ�.');
end;

-- ���ν��� ����
select * from emp;
execute emp_loop_insert(1000, 10);
--------------------------------------------------------------------------------
-- ����(12) �μ��ڵ带 �Է¹޾� �ش� �μ��� ����� ��� �����϶�
-- ������ ���϶� �ݺ� ����

-- (3) WHILE �� �̿��� �ݺ���
create or replace procedure emp_while_insert(i_max number, i_deptno emp.deptno%type)
is
    v_i number;
begin
    -- i_max�� ���� ���� v_i�� ����
    v_i := i_max - 10;
    
    while v_i < i_max loop
        insert into emp(empno, ename, hiredate, deptno)
        values (v_i, 'while' || v_i, sysdate, i_deptno);
        exit when v_i >= i_max - 5;
        v_i := v_i + 1;
    end loop;
end;

-- ���ν��� ����
-- insert ���� �� ������ �Ϻΰ� �߰��� ������ �� �ִ�.
select * from emp;
execute emp_while_insert(2000,20);

--------------------------------------------------------------------------------
-- ���ν��� Ȯ��
select * from user_source;

-- ���ν��� ����
drop procedure books_in;
drop procedure emp_del;
drop procedure emp_ename;
drop procedure emp_ename_sal;
drop procedure emp_if;
drop procedure emp_insert;
drop procedure emp_list;
drop procedure emp_in;
drop procedure emp_row;
drop procedure emp_sal_update;
drop procedure emp_search;
drop procedure emp_select;
drop procedure emp_while_insert;


--------------------------------------------------------------------------------
-- ����(13) �������� �Է¹޾� �ش� ����� �����ȣ, �����, ������, �޿��� ����ϴ� ���ν���
create or replace procedure job_emp_info (i_job emp.job%type)
is
    -- �迭�� ����(�����ȣ, �����, ������, �޿�)
    type empno_arr is table of emp.empno%type index by binary_integer;
    type ename_arr is table of emp.ename%type index by binary_integer;
    type job_arr is table of emp.job%type index by binary_integer;
    type sal_arr is table of emp.sal%type index by binary_integer;

    -- �迭�� ���� ����(������ Ÿ�� ��, Ÿ���� ��ܿ� ������ �迭��)
    s_empno empno_arr;
    s_ename ename_arr;
    s_job job_arr;
    s_sal sal_arr;
    
    -- �ε��� ���� ����
    idx integer := 0;
begin   
    for e in (select empno, ename, job, sal from emp where job = i_job) loop
        idx := idx +1;
        s_empno(idx) := e.empno;
        s_ename(idx) := e.ename;
        s_job(idx) := e.job;
        s_sal(idx) := e.sal;
    end loop;
    
    -- �迭�� �ִ� ������� ����ϱ�
    for i in 1..idx loop
        dbms_output.put_line(s_empno(i) || ', ' || s_ename(i) || ', ' || s_job(i) || ', ' || s_sal(i));
    end loop;
end;

-- ���ν��� ����
execute job_emp_info('SALESMAN');

-- ���ν��� ����
drop procedure job_emp_info;

--------------------------------------------------------------------------------
-- ����(13) ������ Ǯ��
create or replace procedure emp_job_list (i_job in emp.job%type)
is

begin
    for rd in (select empno, ename, job, sal from emp where job = upper(i_job)) loop
        dbms_output.put_line(rd.empno || ', ' || rd.ename || ', ' || rd.job || ', ' || rd.sal);
    end loop;
end;

-- ���ν��� ����
exec emp_job_list('SALESMAN');

-- ���ν��� ����
drop procedure emp_job_list;
--------------------------------------------------------------------------------;