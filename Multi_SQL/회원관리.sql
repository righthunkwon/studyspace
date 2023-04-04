--------------------------------------------------------------------------------
-- 회원관리 프로그램
-- eXERD 툴을 이용해 만든 뒤 확인
select * from tab;
desc member;

-- 시퀀스 생성
create sequence mem_sq
start with 1
increment by 1;

-- 시퀀스 확인
select * from user_sequences;

-- 데이터 처리 확인
select * from member

-- 재점검
drop sequence mem_sq;
drop table member;