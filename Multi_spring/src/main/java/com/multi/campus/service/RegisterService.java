package com.multi.campus.service;

import java.util.List;

import com.multi.campus.dto.RegisterDTO;
import com.multi.campus.dto.ZipcodeDTO;

public interface RegisterService {
	// DAO�� �ִ� �޼ҵ�� ������ �޼ҵ�
	// �α��� Ȯ��
	public RegisterDTO loginOk(String userid, String userpwd);
	// ���̵��ߺ��˻�
	public int idCheckCount(String userid);
	// �����ȣ�˻�
	public List<ZipcodeDTO> zipSearch(String doroname);
	// ȸ������
	public int registerInsert(RegisterDTO dto);
	// ȸ����������
	public RegisterDTO registerEdit(String userid);
	// ȸ���������� DB�ݿ�
	public int registerEditOk(RegisterDTO dto);
	// �̸��� �̸��Ϸ� ���̵� �˻�
	public String idSearch(String username, String email);
}
