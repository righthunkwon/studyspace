--------------------------------------------------------------------------------
-- 제약조건 설정하기(공통)
-- 제약조건이름: 테이블명_제약조건종류_필드명 (권장하는 관례)
-- alter table 테이블명 add constraint 제약조건이름 제약조건(primary key, unique, ...)

-- (7) primary key(pk) : 유일한 키 설정
-- alter table 테이블명 add constraint 제약조건이름 primary key (필드명)
select * from tab;
select * from emp;
alter table emp add constraint emp_pk_empno primary key (empno);

-- (8) 제약조건 확인하기
-- select * from user_constraints;
select * from user_constraints order by table_name;

-- (9) unique : 중복 데이터 금지
-- alter table 테이블명 add constraint 제약조건이름 unique(필드명)
select * from salgrade;
alter table salgrade add constraint salgrade_uk_grade unique(grade);
insert into salgrade values(5,0,699); -- unique 제약으로 인해 생성되지 않는다.
insert into salgrade values(6,0,699);
delete from salgrade where grade = 6;

-- (10) check : 데이터의 범위 설정
-- alter table 테이블명 add constraint 제약조건이름 check(필드명의 범위)

-- 연봉 제약 조건(check)
alter table emp add constraint emp_ck_sal check (sal between 800 and 6000);
alter table emp add constraint emp_ck_sal check (sal >= 800 and sal <=6000);
select * from user_constraints where table_name = 'EMP'; -- 제약조건 설정 확인
insert into emp(empno, ename, sal) values(0001, 'test', 350); -- check constraint violated 발생

-- 부서코드 제약 조건(check)
alter table dept add constraint dept_ck_deptno check (deptno in (10,20,30,40,50,60,70,80,90));
select * from user_constraints where table_name = 'DEPT'; -- 제약조건 설정 확인
select * from dept;
insert into dept values(45, 'DEVELOP', 'Los Angeles'); -- check constraint violated 발생
insert into dept values(50, 'DEVELOP', 'Los Angeles');
delete from dept where deptno = 50; 

-- (11) foreign key(fk) 지정 : 기존 테이블에 있던 자료만 들어갈 수 있도록 제약조건 설정
-- alter table 테이블명 add constraint 제약조건이름 foreign key(필드명) references 참조할 테이블(참조할 필드명)
-- dept테이블의 deptno를 참조하여 emp 테이블의 deptno를 설정
alter table dept add constraint dept_pk_deptno primary key (deptno); -- 참조하는 필드에는 primary key가 설정되어야 foreign key도 설정할 수 있다.
alter table emp add constraints emp_fk_deptno foreign key(deptno) references dept(deptno);
select * from user_constraints where table_name = 'EMP';

-- 외래키를 가지는 컬럼의 데이터 형은 외래키가 참조하는 기본키의 컬럼과 데이터형이 일치해야 한다.
-- 이를 어기면 참조무결성 제약에 의해 테이블을 생성할 수 없다.

select * from dept;
select * from emp order by deptno;
insert into emp(empno, ename, deptno) values (0001, 'TEST', 50); -- integrity constraint violated 발생(parent key not found)
insert into emp(empno, ename, deptno) values (0001, 'TEST', 40);
delete from emp where empno = 1;

select * from user_constraints;

-- no action : 참조되는 레코드는 삭제하지 않는다.
-- on delete cascade : 참조되는 레코드를 포함하여 삭제한다.

-- (12) 제약조건 삭제하기
-- alter table 테이블명 drop constraint 제약조건이름
alter table dept drop constraint dept_ck_deptno;

--------------------------------------------------------------------------------
-- 트랜잭션(TRANSACTION)
-- 데이터 처리의 한 단위(일련의 SQL문)
-- 트랜잭션의 시작 : 실행가능한 SQL문장이 처음 실행될 때
-- 트랜잭션의 종료 : commit, rollback, savepoint

-- savepoint와 rollback to
select * from dept;
insert into dept values (50, 'TEST', 'TEST');
savepoint a;
insert into dept values (60, 'TEST2', 'TEST2');
insert into dept values (70, 'TEST3', 'TEST3');
rollback to a; -- TEST2, TEST3는 삭제하고, TEST만 남기는 지점으로 돌아간다
delete from dept where  deptno = 50; -- 데이터 원상복구