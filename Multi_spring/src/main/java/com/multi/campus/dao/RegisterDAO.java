package com.multi.campus.dao;

import java.util.List;

import com.multi.campus.dto.RegisterDTO;
import com.multi.campus.dto.ZipcodeDTO;

public interface RegisterDAO {
	// �߻�޼ҵ�
	// �α��� Ȯ��
	public RegisterDTO loginOk(String userid, String userpwd);
	// ���̵��ߺ��˻� (���̵��� ������ ���Ͽ� Ȯ��)
	public int idCheckCount(String userid);
	// ���θ� �˻�
	public List<ZipcodeDTO> zipSearch(String doroname);
	// ȸ������
	public int registerInsert(RegisterDTO dto);
	// ȸ���������� ��
	public RegisterDTO registerEdit(String userid);
	// ȸ���������� DB������Ʈ
	public int registerEditOk(RegisterDTO dto);
	// �̸��� �̸��Ϸ� ���̵� �˻�
	public String idSearch(String username, String email);
}
