--------------------------------------------------------------------------------
-- 에제(1) 도서 등록 프로시저 생성
-- java 연동 (java10_jdbc_oracle InsertProcedure)

-- 1. 책이름, 가격, 출판일, 카테코리, 작가명, 출판사명, 재고를 java에서 전달받아 insert
-- 2. 이후 insert된 결과를 out하여 확인

create or replace procedure booksInsert(
                    i_bookname in books.bookname%type,
                    i_price in books.price%type,
                    i_pub_date in books.pub_date%type,
                    i_category in books.category%type,
                    i_author in author_tbl.author%type,
                    i_pub_name in pub_tbl.pub_name%type,
                    i_stock in books.stock%type,
                    
                    -- 책 등록 결과를 프로시저를 호출한 곳으로 out
                    r_result out number
                    )
is

begin
    -- 결과값의 초기값
    r_result := 1; 
    
    -- insert(서브쿼리 활용)
    insert into books(isbn, bookname, price, pub_date, category, author_code, pub_code, stock)
    values(
            book_sq.nextval, i_bookname, i_price, i_pub_date, i_category, 
            (select author_code from author_tbl where author = i_author),
            (select pub_code from pub_tbl where pub_name= i_pub_name), 
            i_stock
           );
    commit;
    -- 결과값의 쿼리문 실행 중 예외발생 시 0 출력
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
-- 예제(2) 도서 전체 선택 프로시저 생성
-- select의 선택결과를 out 파라미터로 설정
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
-- 예제(3) 책 제목의 일부르르 입력받아 조회하는 프로시저
create or replace procedure book_search (searchword in books.bookname%type, book_search_list out sys_refcursor)
is

begin
    open book_search_list for
    select isbn, bookname, price, author, pub_name
    from books b join author_tbl a on b.author_code = a.author_code
    join pub_tbl p on b.pub_code = p.pub_code and b.bookname like '%'|| searchword ||'%';
end;

--------------------------------------------------------------------------------
