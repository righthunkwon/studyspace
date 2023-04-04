--------------------------------------------------------------------------------
-- 테이블 생성
-- primary key : 중복 데이터를 허용하지 않음
-- default sysdate : 날짜를 등록하지 않으면 현재 날짜를 기입
-- null 은 생략 가능(not null은 생략 불가)

create table member(
    no number(3) primary key,
    username varchar2(30) not null,
    tel varchar2(15) not null,
    email varchar2(30), -- null 생략
    addr varchar2(200), -- null 생략
    writedate date default sysdate
);

select * from tab;
desc member;
select * from member;

-- 생성한 테이블에 값 넣기
-- no 값은 primary key이므로 no가 중복될 경우 unique constraint 오류가 발생한다.
insert into member values(1, '권정훈', '010-1234-5678', 'codingGod@naver.com', '서울시 강남구', sysdate);
insert into member(no, username, tel) values(2, '스티브 잡스', '010-1111-1111'); -- 날짜를 등록하지 않아도 현재 날짜가 등록(default sysdate)
select * from member;