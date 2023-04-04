-- 도서관리 프로그램
create table book(
    no number(38) primary key,
    title varchar2(1000) not null,
    author varchar2(1000) not null,
    publisher varchar2(1000),
    price number(38),
    publishdate date default sysdate
);

insert into book values(1, 'Java의 정석', '남궁성', '도우출판', 30000, '2016-1-27');
insert into book values(2, 'Java의 정석 기초편', '남궁성', '도우출판', 25000, '2019-12-30');
insert into book values(3, 'IT 5분 잡학사전', '니꼴라스, 배지현', '이지스퍼블리싱', 16500, '2022-9-30');
insert into book values(4, 'Do it! 점프 투 파이썬', '박응용', '이지스퍼블리싱', 18800, '2019-6-20');
insert into book values(5, 'Do it! 자바 프로그래밍 입문', '박은종', '이지스퍼블리싱', 25000, '2018-8-6');
insert into book values(6, 'Do it! 알고리즘 코딩 테스트: 자바편', '김종관', '이지스퍼블리싱', 32000, '2022-4-5');
insert into book values(7, 'Do it! 오라클로 배우는 데이터베이스 입문', '이지훈', '이지스퍼블리싱', 25000, '2018-10-30');
insert into book values(8, '유난한 도전', '정경화', '북스톤', 17000, '2022-11-13');
insert into book values(9, '개발자상식', '박민경', '로드북', 25000, '2022-7-22');
insert into book values(10, 'Clean Code', '로버트 C.마틴', '인사이트', 33000, '2013-12-24');

select * from book;

