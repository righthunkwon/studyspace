-- 도서관리 프로그램(확장)
create table books(
    isbn varchar2(10) primary key,
    bookname varchar2(1000) not null,
    price number(20) not null,
    pub_date date,
    category varchar2(100),
    pub_code varchar2(100) not null,
    author_code varchar2(100) not null,
    writedate date default sysdate,
    stock number(10) not null
);

create table pub_tbl(
    pub_code varchar2(100) not null,
    pub_name varchar2(100) not null,
    pub_ceo varchar2(30),
    pub_tel varchar2(15) not null,
    pub_fax varchar2(15),
    pub_addr varchar2(300),
    writedate date default sysdate
);

create table author_tbl(
    author_code varchar2(100) not null,
    author varchar2(100) not null,
    debue varchar2(1000),
    debue_year date,
    email varchar2(100),
    homepage varchar2(100),    writedate date default sysdate
);

select * from tab;
select * from books;