-- �������� ���α׷�
create table book(
    no number(38) primary key,
    title varchar2(1000) not null,
    author varchar2(1000) not null,
    publisher varchar2(1000),
    price number(38),
    publishdate date default sysdate
);

insert into book values(1, 'Java�� ����', '���ü�', '��������', 30000, '2016-1-27');
insert into book values(2, 'Java�� ���� ������', '���ü�', '��������', 25000, '2019-12-30');
insert into book values(3, 'IT 5�� ���л���', '�ϲö�, ������', '�������ۺ���', 16500, '2022-9-30');
insert into book values(4, 'Do it! ���� �� ���̽�', '������', '�������ۺ���', 18800, '2019-6-20');
insert into book values(5, 'Do it! �ڹ� ���α׷��� �Թ�', '������', '�������ۺ���', 25000, '2018-8-6');
insert into book values(6, 'Do it! �˰��� �ڵ� �׽�Ʈ: �ڹ���', '������', '�������ۺ���', 32000, '2022-4-5');
insert into book values(7, 'Do it! ����Ŭ�� ���� �����ͺ��̽� �Թ�', '������', '�������ۺ���', 25000, '2018-10-30');
insert into book values(8, '������ ����', '����ȭ', '�Ͻ���', 17000, '2022-11-13');
insert into book values(9, '�����ڻ��', '�ڹΰ�', '�ε��', 25000, '2022-7-22');
insert into book values(10, 'Clean Code', '�ι�Ʈ C.��ƾ', '�λ���Ʈ', 33000, '2013-12-24');

select * from book;

