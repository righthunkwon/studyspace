--------------------------------------------------------------------------------
-- 커서(Cursor)
-- 명시적 커서, 묵시적 커서
-- 쿼리문에 의해서 반환되는 결과값들을 저장하는 메모리 공간

-- fetch : 커서에서 원하는 결과값을 추출하는 것
-- 커서 선언 -> 커서 open -> fetch -> true 값 반환

-- %FOUND - 할당할 레코드가 있는 경우 true값을 반환.
-- %isOpen - 커서가 오픈상태일 경우 true값을 반환.
-- %NotFound - 할당할 레코드가 없는 경우 true값을 반환.
-- %RowCount - 카운터 역할을 한다. 커서가 오픈됐을 경우 0, 패치가 발생할 때 마다 1씩 증가.

--------------------------------------------------------------------------------
-- 예제(1) 부서코드를 입력하여 해당부서의 
-- 업무별 급여의 합, 급여의 평균, 사원수, 최고급여, 최저급여를 구하는 프로시저
create or replace procedure emp_info (i_deptno in emp.deptno%type)
is
    -- 커서 선언하기
    cursor emp_result is
        select e.job, sum(e.sal) sal_sum, round(avg(e.sal),2) sal_avg, count(e.empno) cnt, max(e.sal) sal_max, min(e.sal) sal_min
        from emp e where e.deptno = i_deptno group by e.job;
    
    -- 선택할 값을 저장할 변수 선언
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
        exit when emp_result%NOTFOUND; -- exit는 true일 때 탈출
        dbms_output.put_line(v_job || ', ' || v_sum || ', ' || v_avg || ', ' || v_cnt || ', ' || v_max || ', '  || v_min);
    end loop;
    -- close
    close emp_result;
    dbms_output.put_line('실행 완료');
end;

-- 프로시저 실행
execute emp_info(30);


--------------------------------------------------------------------------------

