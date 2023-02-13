--------------------------------------------------------------------------------
-- PL/SQL
-- Oracle's Procedual Language extension to SQL
-- Oracle에서 제공하는 데이터에비스 언어
-- SQL에서 프로그래밍 언어의 역할을 하여 변수 생성, 반복문 수행 등을 가능하게 한다.

--------------------------------------------------------------------------------
-- PL/SQL 기본 문법

-- DECLARE
--    [ 선언 ]
-- BEGIN
--    [ 실행 ]
-- EXCEPTION
--    [ 예외처리 ]
-- END;

--------------------------------------------------------------------------------
-- (1) SERVEROUTPUT 설정
-- 기본적으로 PL/SQL은 결과물을 보여주지 않기에 별도로 SERVEROUTPUT을 on으로 설정
-- 반드시 원하는 실행문을 드래그하여 실행해야 한다.
set serveroutput on;


-- (2)스크립트에 출력
begin
    dbms_output.put_line('Hello Oracle!');
end;


-- (3) 변수 선언 및 스크립트에 출력
declare
    i_name varchar2(10);
begin
    i_name := '권정훈'; 
    dbms_output.put_line(i_name);
end;


--------------------------------------------------------------------------------
-- 예제(1) emp 테이블에서 사원번호, 사원명, 급여를 선택하여 출력하는 프로시저 생성
-- in 파라미터  : 외부에서 프로시저 내로 값을 넣어주는 변수를 선언할 때 사용
-- %type       : 테이블 내의 특정 필드와 같은 데이터형으로 선언

-- 프로시저 생성(emp_select)
create or replace procedure emp_select(i_empno in emp.empno%type)
is 
    -- 변수 선언(record)
    s_empno emp.empno%type;
    s_ename emp.ename%type;
    s_sal emp.sal%type;
begin
    -- 레코드를 선택하여 into 이후에 명시한 변수에 대입
    select empno, ename, sal into s_empno, s_ename, s_sal from emp where empno = i_empno;
    dbms_output.put_line('사원번호: ' || s_empno);
    dbms_output.put_line('사원이름: ' || s_ename);
    dbms_output.put_line('사원임금: ' || s_sal);
end;

-- 프로시저 확인
select * from user_source where name = 'EMP_SELECT';

-- 프로시저 실행
execute emp_select(7782);
execute emp_select(7788);


--------------------------------------------------------------------------------
-- 예제(2) 사번을 입력받아 사원번호, 사원명, 업무, 급여, 부서코드, 부서명을 선택하여 출력
-- %rowtype : 테이블 내의 모든 필드와 같은 데이터형으로 변수 선언하기

create or replace procedure emp_row (i_empno in number)
is
    -- select한 데이터를 담을 변수 선언
    record_emp emp%rowtype;
    record_dept dept%rowtype;
begin
    -- 레코드를 선택하여 into 이후에 명시한 변수에 대입
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

-- 프로시저 확인
select * from user_source where name = 'EMP_ROW';

-- 프로시저 실행
execute emp_row(7900);
execute emp_row(7788);
execute emp_row(8569); -- "no data found" 에러 발생(없는 사원번호)

--------------------------------------------------------------------------------
-- 예제 (3) 사원명을 입력받아 해당 사원의 사원번호, 사원명, 급여를 출력하는 프로시저
-- Exception 처리하기
-- 데이터 추가(이름이 CLARK로 겹치는 case)
select * from emp;
insert into emp(empno, ename, sal, deptno) values (7777, 'KWON', 6000, 40);
insert into emp(empno, ename, sal, deptno) values (7783, 'CLARK', 4500, 20);
commit;

-- 프로시저 생성

create or replace procedure emp_ename(i_ename in emp.ename%type)
is
    o_empno emp.empno%type;
    o_ename emp.ename%type;
    o_sal emp.sal%type;
begin
    select empno, ename, sal into o_empno, o_ename, O_sal
    from emp where ename = upper(i_ename);
    
    dbms_output.put_line(o_empno || ', ' || o_ename || ', ' || o_sal);
    
    -- 예외처리
    exception
        when NO_DATA_FOUND then
            dbms_output.put_line(i_ename || ' 사원이 없습니다.');
        when TOO_MANY_ROWS then
            dbms_output.put_line(i_ename || ' 사원이 두 명 이상입니다.');
        when OTHERS then
            dbms_output.put_line('예외가 발생했습니다.');
end;

-- 프로시저 실행
execute emp_ename('james');
execute emp_ename('kwon');
execute emp_ename('clark');

--------------------------------------------------------------------------------
-- 예제(4) 사원번호, 사원명, 급여, 부서번호를 입력받아 사원을 등록하는 프로시저(insert)
-- 'in' parameter     : 외부에서 프로시저 내로 데이터 넣기

create or replace procedure emp_insert(i_empno in emp.empno%type, i_ename in emp.ename%type, i_sal in number, i_deptno in emp.deptno%type)
is

begin
    insert into emp(empno, ename, sal, deptno) values(i_empno, i_ename, i_sal, i_deptno);
    dbms_output.put_line(i_ename || '사원이 등록되었습니다.');
end;
                                        
-- 프로시저 실행
-- execute = exec
exec emp_insert(8888, 'DIET', 800, 10);
execute emp_insert(8888, 'DIET', 800, 10);

-- 데이터 확인
select * from emp;


--------------------------------------------------------------------------------
-- 예제(5) 사원번호를 입력받아 이름, 업무, 급여를 선택하는 프로시저
-- 'out' parameter    : 프로시즈 내에서 외부로 데이터 내보내기
create or replace procedure emp_list(i_empno in emp.empno%type, o_ename out emp.ename%type, o_job out emp.job%type, o_sal out emp.sal%type)
is

begin
    select ename, job, sal into o_ename, o_job, o_sal
    from emp where empno = i_empno;
end;

-- 변수 선언
-- variable = vari
variable p_ename varchar2(30);
variable p_job varchar2(30);
variable p_sal number;


-- 프로시저 실행
exec emp_list(7788, :p_ename, :p_job, :p_sal);
print p_ename;
print p_job;
print p_sal;

--------------------------------------------------------------------------------
-- 예제(6) 사원번호, 사원명, 부서코드, 급여를 입력받아 사원을 등록하는 프로시저
-- 'in out' parameter : 같은 변수의 in과 out을 처리
create or replace procedure emp_in (i_empno emp.empno%type, i_ename emp.ename%type, i_deptno emp.deptno%type, i_sal emp.sal%type)
is
begin
    insert into emp(empno, ename, sal, hiredate, deptno)
    values(i_empno, i_ename, i_sal, sysdate, i_deptno);
    dbms_output.put_line(i_ename || ' 사원이 등록되었습니다.');
end;

-- 프로시저 실행
exec emp_in(6666, 'Lee', 40, 2500);
select * from emp;

--------------------------------------------------------------------------------
-- 예제(7) 사원번호와 급여인상률을 입력받아 해당 사원의 급여를 수정하는 프로시저
-- update 
create or replace procedure emp_sal_update(i_empno emp.empno%type, i_rate number)
is
    r_emp emp%rowtype;
begin
    -- i_empno 사원의 급여 인상
    update emp set sal = sal + (sal*(i_rate/100))
    where empno = i_empno;
    dbms_output.put_line('업데이트 되었습니다.');
    commit;
    
    select empno, ename, sal into r_emp.empno, r_emp.ename, r_emp.sal
    from emp where empno = i_empno;
    dbms_output.put_line(r_emp.empno || ',' || r_emp.sal);
end;

-- 프로시저 실행
select * from emp;
exec emp_sal_update(8888, 10);

--------------------------------------------------------------------------------
-- 에제(8) 사원번호를 입력받아 해당 사원 삭제하기
create or replace procedure emp_del (i_empno emp.empno%type)
is
begin
    delete from emp where empno = i_empno;
    dbms_output.put_line(i_empno || ' 사원이 삭제되었습니다.');
    commit;
end;

-- 프로시저 실행
exec emp_del(6666);
exec emp_del(7777);
exec emp_del(7783);
exec emp_del(8888);
select * from emp;

--------------------------------------------------------------------------------
-- 예제(9) 사원번호를 입력받아 해당 사원을 선택하는 프로시저
-- type 만들기
create or replace procedure emp_search(i_empno emp.empno%type)
is
    -- 레코드형 데이터 타입 만들기
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
    -- 변수 선언
    e_record emp_record_type;
begin
    -- 선택한 필드의 값이 e_record 변수에 대입
    select * into e_record
    from emp where empno = i_empno;
    
    dbms_output.put_line(e_record.v_empno || ', ' || e_record.v_ename || ', ' || e_record.v_hiredate || ', ' || e_record.v_sal);
end;

-- 프로시저 실행
execute emp_search(7521);
select * from emp;


--------------------------------------------------------------------------------
-- 도서테이블 외래키 설정(books, pub_tbl, author_tbl)
select * from books;
select * from pub_tbl;
select * from author_tbl;

-- 외래키 생성
alter table books
add constraint books_fk_pub_tbl foreign KEY(PUB_CODE) references pub_tbl(PUB_CODE);

-- 제약조건 정보 확인(P: 기본키, R: 외래키, U: 고유값, C: 체크)
select * from user_constraints;


--------------------------------------------------------------------------------
-- 도서 테이블(books, pub_tbl, author_tbl)
select * from books;
select * from pub_tbl;
select * from author_tbl;

-- 예제(1) 도서명, 출판사명, 가격, 작가명, 카테고리를 입력받아 책을 등록하는 프로시저
create or replace procedure books_in (i_bookname in books.bookname%type,
                                      i_pubname in pub_tbl.pub_name%type,
                                      i_price in books.price%type,
                                      i_author in author_tbl.author%type,
                                      i_category in books.category%type)
is
    -- 출판사 코드
    s_pub_code pub_tbl.pub_code%type;
    -- 작가 코드
    s_author_code author_tbl.author_code%type;
begin
    -- 출판사명을 이용하여 출판사 코드 선택
    select pub_code into s_pub_code
    from pub_tbl where pub_name = i_pubname;
    -- 작가명을 이용하여 작가 코드 선택
    select author_code into s_author_code
    from author_tbl where author = i_author;
    -- 책 등록
    insert into books(isbn, bookname, price, category, pub_code, author_code)
    values(book_sq.nextval, i_bookname, i_price, i_category, s_pub_code, s_author_code);
    commit;
        
    exception
        when others then
            dbms_output.put_line('잘못된 정보가 입력되었습니다.');
end;

-- 프로시저 실행
execute books_in('테스트', '한빛미디어', 20000, '테스트', 'IT');
select * from books;


--------------------------------------------------------------------------------
-- 예제(2) 사원번호에 해당하는 사원의 사원명, 부서명을 출력하는 프로시저
-- if문

create or replace procedure emp_if(i_empno in number)
is
    s_ename emp.ename%type;
    s_deptno emp.deptno%type;
    s_dname varchar(20);
begin
    select ename, deptno into s_ename, s_deptno from emp where empno = i_empno;
    
    if s_deptno = 10 then
        s_dname := '회계부서';
    elsif s_deptno = 20 then
        s_dname := '연구부서';
    elsif s_deptno = 30 then
        s_dname := '영업부서';
    elsif s_deptno = 40 then
        s_dname := '영업부서';
    else
        s_dname := '없는 부서입니다.';
    end if;
    
    dbms_output.put_line(s_ename || ', ' || s_dname);
end;

-- 프로시저 실행
exec emp_if(7788);
exec emp_if(7902);
select * from emp;

--------------------------------------------------------------------------------
-- 예제(10) 부서코드를 입력받아 해당 부서의 사원을 모두 선택하라
-- PL/SQL에서의 반복문 FOR문, LOOP문, WHILE문
-- 변수에 값을 대입할 때는 := 를 사용한다.

-- (1) FOR을 이용한 반복문
create or replace procedure emp_ename_sal(i_deptno emp.deptno%type)
is
    -- 배열형 생성(사원명, 급여, 입사일)
    type ename_arr is table of emp.ename%type index by binary_integer;
    type sal_arr is table of emp.sal%type index by binary_integer;
    type hiredate_arr is table of emp.hiredate%type index by binary_integer;
    
    -- 배열형 변수 선언(변수명 타입 순, 타입은 상단에 선언한 배열형)
    s_ename ename_arr;
    s_sal sal_arr;
    s_hiredate hiredate_arr;
    
    -- 인덱스 변수 선언
    idx integer := 0;
begin   
    for e in (select ename, sal, hiredate from emp where deptno = 20) loop
        idx := idx +1;
        s_ename(idx) := e.ename;
        s_sal(idx) := e.sal;
        s_hiredate(idx) := e.hiredate;
    end loop;
    
    -- 배열에 있는 사원정보 출력하기
    for i in 1..idx loop
        dbms_output.put_line(s_ename(i) || ', ' || s_sal(i) || ', ' || s_hiredate(i));
    end loop;
end;

-- 프로시저 실행
execute emp_ename_sal(20);

--------------------------------------------------------------------------------
-- 예제(11) 특정 번호부터 부서번호를 지정하여 사원번호를 등록하라
-- exit의 조건이 true일때 종료(다른 반복문이 false일 때 종료되는 것과 대비된다)
-- exit when 조건식 ;

-- (2) LOOP을 이용한 반복문
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
    dbms_output.put_line('사원을 등록하였습니다.');
end;

-- 프로시저 실행
select * from emp;
execute emp_loop_insert(1000, 10);
--------------------------------------------------------------------------------
-- 예제(12) 부서코드를 입력받아 해당 부서의 사원을 모두 선택하라
-- 조건이 참일때 반복 실행

-- (3) WHILE 을 이용한 반복문
create or replace procedure emp_while_insert(i_max number, i_deptno emp.deptno%type)
is
    v_i number;
begin
    -- i_max의 값에 따라 v_i가 결정
    v_i := i_max - 10;
    
    while v_i < i_max loop
        insert into emp(empno, ename, hiredate, deptno)
        values (v_i, 'while' || v_i, sysdate, i_deptno);
        exit when v_i >= i_max - 5;
        v_i := v_i + 1;
    end loop;
end;

-- 프로시저 실행
-- insert 했을 때 데이터 일부가 중간에 들어가있을 수 있다.
select * from emp;
execute emp_while_insert(2000,20);

--------------------------------------------------------------------------------
-- 프로시저 확인
select * from user_source;

-- 프로시저 삭제
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
-- 예제(13) 담당업무를 입력받아 해당 사원의 사원번호, 사원명, 담당업무, 급여를 출력하는 프로시저
create or replace procedure job_emp_info (i_job emp.job%type)
is
    -- 배열형 생성(사원번호, 사원명, 담당업무, 급여)
    type empno_arr is table of emp.empno%type index by binary_integer;
    type ename_arr is table of emp.ename%type index by binary_integer;
    type job_arr is table of emp.job%type index by binary_integer;
    type sal_arr is table of emp.sal%type index by binary_integer;

    -- 배열형 변수 선언(변수명 타입 순, 타입은 상단에 선언한 배열형)
    s_empno empno_arr;
    s_ename ename_arr;
    s_job job_arr;
    s_sal sal_arr;
    
    -- 인덱스 변수 선언
    idx integer := 0;
begin   
    for e in (select empno, ename, job, sal from emp where job = i_job) loop
        idx := idx +1;
        s_empno(idx) := e.empno;
        s_ename(idx) := e.ename;
        s_job(idx) := e.job;
        s_sal(idx) := e.sal;
    end loop;
    
    -- 배열에 있는 사원정보 출력하기
    for i in 1..idx loop
        dbms_output.put_line(s_empno(i) || ', ' || s_ename(i) || ', ' || s_job(i) || ', ' || s_sal(i));
    end loop;
end;

-- 프로시저 실행
execute job_emp_info('SALESMAN');

-- 프로시저 삭제
drop procedure job_emp_info;

--------------------------------------------------------------------------------
-- 예제(13) 간결한 풀이
create or replace procedure emp_job_list (i_job in emp.job%type)
is

begin
    for rd in (select empno, ename, job, sal from emp where job = upper(i_job)) loop
        dbms_output.put_line(rd.empno || ', ' || rd.ename || ', ' || rd.job || ', ' || rd.sal);
    end loop;
end;

-- 프로시저 실행
exec emp_job_list('SALESMAN');

-- 프로시저 삭제
drop procedure emp_job_list;
--------------------------------------------------------------------------------;