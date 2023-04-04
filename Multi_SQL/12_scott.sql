--------------------------------------------------------------------------------
-- SEQUENCE (������)
-- ������ ���� �������ִ� ����Ŭ ��ü(�ߺ� �� X)
-- ���������� �����ϴ� Į���� �ڵ����� ���� ����
-- ���� primary key���� �����ϱ� ���� ���
-- �⺻���� 1���� 1�� ����

-- pub_sq ������ ����
create sequence pub_sq
start with 1 -- ���۰�
increment by 1; -- ������   

-- author_sq ������ ����
create sequence author_sq
start with 10
increment by 10;

-- book_sq ������ ����
create sequence book_sq
start with 1
increment by 2;

-- ��ü ������ Ȯ��
select * from user_sequences;

-- currval : ���� �� ��ȯ
-- nextval : ���� �������� ���� �� ��ȯ
select author_sq.nextval, author_sq.currval from dual;

-- (1) ������ ó��(pub_sq)
-- Ȯ��
desc pub_tbl; 

-- ������ ����
insert into pub_tbl(pub_code, pub_name, pub_tel) values(pub_sq.nextval, '�Ѻ��̵��', '02-119-1230'); 
insert into pub_tbl(pub_code, pub_name, pub_tel) values(pub_sq.nextval, '�����̵��', '02-112-1230'); 
insert into pub_tbl(pub_code, pub_name, pub_tel) values(pub_sq.nextval, '�޺��̵��', '02-114-1230'); 

-- Ȯ��
select * from pub_tbl order by pub_code; 


-- (2) ������ ó��(author_sq)
desc author_tbl;
insert into author_tbl(author_code, author) values (author_sq.nextval, '������');
insert into author_tbl(author_code, author) values (author_sq.nextval, '������');
insert into author_tbl(author_code, author) values (author_sq.nextval, '���Ʊ�');

select * from author_tbl;

-- (3) ������ ó��(books)
desc books;
insert into books values (book_sq.nextval, '�ڹ� �ھ� �', 28000, to_date('2020-10-10', 'YYYY-MM-DD'), 'IT', 1, '210', sysdate, 10);
insert into books values (book_sq.nextval, 'HTML �ھ� �', 20000, to_date('2021-10-10', 'YYYY-MM-DD'), 'IT', 2, '220', sysdate, 9);
insert into books values (book_sq.nextval, 'CSS �ھ� �', 25000, to_date('2021-11-10', 'YYYY-MM-DD'), 'IT', 3, '230', sysdate, 8);
insert into books values (book_sq.nextval, 'JS �ھ� �', 35000, to_date('2021-12-10', 'YYYY-MM-DD'), 'IT', 4, '240', sysdate, 7);
insert into books values (book_sq.nextval, 'Oracle �ھ� �', 18000, to_date('2023-01-10', 'YYYY-MM-DD'), 'IT', 5, '250', sysdate, 6);
select * from books;

delete from books where pub_code = 5;

commit;

-- ����(1) å�̸�, ����, ���ǻ��, ī�װ��� �����϶�
-- ������ �����Ͽ� ���Ŀ� �����͸� Ȯ���ϱ� ���ϰ� �����.
select b.bookname, b.price, p.pub_name, b.category
from books b join pub_tbl p
on b.pub_code = p.pub_code;

-- ����(2) å�̸�, �۰�, ���ǻ�, ����, ī�װ��� �����϶�
select b.bookname å�̸�, a.author �۰���, p.pub_name ���ǻ��, b.price ����, b.category ī�װ� 
from books b 
join author_tbl a 
on b.author_code = a.author_code
join pub_tbl p
on b.pub_code = p.pub_code;

-- ����(3) isbn, å�̸�, ����, ���ǻ��, ����ó, �۰����� �����ϵ� ������ 25000�� �̻��� å�� �����϶�
select * from books;
select * from pub_tbl;
select * from author_tbl;

select b.isbn, b.bookname, b.price, p.pub_name, p.pub_tel, a.author
from (select * from books where price >= 25000) b
join pub_tbl p
on b.pub_code = p.pub_code
join author_tbl a
on b.author_code = a.author_code;