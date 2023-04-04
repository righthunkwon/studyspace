--------------------------------------------------------------------------------
-- ����(1) ���� ��� ���ν��� ����
-- java ���� (java10_jdbc_oracle InsertProcedure)

-- 1. å�̸�, ����, ������, ī���ڸ�, �۰���, ���ǻ��, ��� java���� ���޹޾� insert
-- 2. ���� insert�� ����� out�Ͽ� Ȯ��

create or replace procedure booksInsert(
                    i_bookname in books.bookname%type,
                    i_price in books.price%type,
                    i_pub_date in books.pub_date%type,
                    i_category in books.category%type,
                    i_author in author_tbl.author%type,
                    i_pub_name in pub_tbl.pub_name%type,
                    i_stock in books.stock%type,
                    
                    -- å ��� ����� ���ν����� ȣ���� ������ out
                    r_result out number
                    )
is

begin
    -- ������� �ʱⰪ
    r_result := 1; 
    
    -- insert(�������� Ȱ��)
    insert into books(isbn, bookname, price, pub_date, category, author_code, pub_code, stock)
    values(
            book_sq.nextval, i_bookname, i_price, i_pub_date, i_category, 
            (select author_code from author_tbl where author = i_author),
            (select pub_code from pub_tbl where pub_name= i_pub_name), 
            i_stock
           );
    commit;
    -- ������� ������ ���� �� ���ܹ߻� �� 0 ���
    exception
        when others then
            r_result := 0;
end;
                    
desc books;
desc pub_tbl;
desc author_tbl;
select * from books;
select * from pub_tbl;
select * from author_tbl;

--------------------------------------------------------------------------------
-- ����(2) ���� ��ü ���� ���ν��� ����
-- select�� ���ð���� out �Ķ���ͷ� ����
create or replace procedure book_all_select(book_result out sys_refcursor)
is
begin
    open book_result for
    select b.isbn, b.bookname, b.price, b.pub_date, b.category, b.stock, a.author, p.pub_name, p.pub_tel
    from books b join author_tbl a on b.author_code = a.author_code
                 join pub_tbl p on b.pub_code = p.pub_code
                 order by b.bookname asc;
end;

--------------------------------------------------------------------------------
-- ����(3) å ������ �Ϻθ��� �Է¹޾� ��ȸ�ϴ� ���ν���
create or replace procedure book_search (searchword in books.bookname%type, book_search_list out sys_refcursor)
is

begin
    open book_search_list for
    select isbn, bookname, price, author, pub_name
    from books b join author_tbl a on b.author_code = a.author_code
    join pub_tbl p on b.pub_code = p.pub_code and b.bookname like '%'|| searchword ||'%';
end;

--------------------------------------------------------------------------------
