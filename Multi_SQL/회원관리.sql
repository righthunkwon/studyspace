--------------------------------------------------------------------------------
-- ȸ������ ���α׷�
-- eXERD ���� �̿��� ���� �� Ȯ��
select * from tab;
desc member;

-- ������ ����
create sequence mem_sq
start with 1
increment by 1;

-- ������ Ȯ��
select * from user_sequences;

-- ������ ó�� Ȯ��
select * from member

-- ������
drop sequence mem_sq;
drop table member;