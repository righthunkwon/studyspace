--------------------------------------------------------------------------------
-- SEQUENCE (시퀀스)
-- 유일한 값을 생성해주는 오라클 객체(중복 값 X)
-- 순차적으로 증가하는 칼럼을 자동으로 생성 가능
-- 보통 primary key값을 생성하기 위해 사용
-- 기본값은 1부터 1씩 증가

-- pub_sq 시퀀스 생성
create sequence pub_sq
start with 1 -- 시작값
increment by 1; -- 증가값   

-- author_sq 시퀀스 생성
create sequence author_sq
start with 10
increment by 10;

-- book_sq 시퀀스 생성
create sequence book_sq
start with 1
increment by 2;

-- 전체 시퀀스 확인
select * from user_sequences;

-- currval : 현재 값 반환
-- nextval : 현재 시퀀스의 다음 값 반환
select author_sq.nextval, author_sq.currval from dual;

-- (1) 시퀀스 처리(pub_sq)
-- 확인
desc pub_tbl; 

-- 시퀀스 삽입
insert into pub_tbl(pub_code, pub_name, pub_tel) values(pub_sq.nextval, '한빛미디어', '02-119-1230'); 
insert into pub_tbl(pub_code, pub_name, pub_tel) values(pub_sq.nextval, '별빛미디어', '02-112-1230'); 
insert into pub_tbl(pub_code, pub_name, pub_tel) values(pub_sq.nextval, '달빛미디어', '02-114-1230'); 

-- 확인
select * from pub_tbl order by pub_code; 


-- (2) 시퀀스 처리(author_sq)
desc author_tbl;
insert into author_tbl(author_code, author) values (author_sq.nextval, '권정훈');
insert into author_tbl(author_code, author) values (author_sq.nextval, '훈정권');
insert into author_tbl(author_code, author) values (author_sq.nextval, '정훈권');

select * from author_tbl;

-- (3) 시퀀스 처리(books)
desc books;
insert into books values (book_sq.nextval, '자바 코어 운동', 28000, to_date('2020-10-10', 'YYYY-MM-DD'), 'IT', 1, '210', sysdate, 10);
insert into books values (book_sq.nextval, 'HTML 코어 운동', 20000, to_date('2021-10-10', 'YYYY-MM-DD'), 'IT', 2, '220', sysdate, 9);
insert into books values (book_sq.nextval, 'CSS 코어 운동', 25000, to_date('2021-11-10', 'YYYY-MM-DD'), 'IT', 3, '230', sysdate, 8);
insert into books values (book_sq.nextval, 'JS 코어 운동', 35000, to_date('2021-12-10', 'YYYY-MM-DD'), 'IT', 4, '240', sysdate, 7);
insert into books values (book_sq.nextval, 'Oracle 코어 운동', 18000, to_date('2023-01-10', 'YYYY-MM-DD'), 'IT', 5, '250', sysdate, 6);
select * from books;

delete from books where pub_code = 5;

commit;

-- 예제(1) 책이름, 가격, 출판사명, 카테고리를 선택하라
-- 별명을 설정하여 이후에 데이터를 확인하기 편리하게 만든다.
select b.bookname, b.price, p.pub_name, b.category
from books b join pub_tbl p
on b.pub_code = p.pub_code;

-- 예제(2) 책이름, 작가, 출판사, 가격, 카테고리를 선택하라
select b.bookname 책이름, a.author 작가명, p.pub_name 출판사명, b.price 가격, b.category 카테고리 
from books b 
join author_tbl a 
on b.author_code = a.author_code
join pub_tbl p
on b.pub_code = p.pub_code;

-- 예제(3) isbn, 책이름, 가격, 출판사명, 연락처, 작가명을 선택하되 가격이 25000원 이상인 책을 선택하라
select * from books;
select * from pub_tbl;
select * from author_tbl;

select b.isbn, b.bookname, b.price, p.pub_name, p.pub_tel, a.author
from (select * from books where price >= 25000) b
join pub_tbl p
on b.pub_code = p.pub_code
join author_tbl a
on b.author_code = a.author_code;