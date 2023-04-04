--------------------------------------------------------------------------------
-- ���̺� ����
-- primary key : �ߺ� �����͸� ������� ����
-- default sysdate : ��¥�� ������� ������ ���� ��¥�� ����
-- null �� ���� ����(not null�� ���� �Ұ�)

create table member(
    no number(3) primary key,
    username varchar2(30) not null,
    tel varchar2(15) not null,
    email varchar2(30), -- null ����
    addr varchar2(200), -- null ����
    writedate date default sysdate
);

select * from tab;
desc member;
select * from member;

-- ������ ���̺� �� �ֱ�
-- no ���� primary key�̹Ƿ� no�� �ߺ��� ��� unique constraint ������ �߻��Ѵ�.
insert into member values(1, '������', '010-1234-5678', 'codingGod@naver.com', '����� ������', sysdate);
insert into member(no, username, tel) values(2, '��Ƽ�� �⽺', '010-1111-1111'); -- ��¥�� ������� �ʾƵ� ���� ��¥�� ���(default sysdate)
select * from member;