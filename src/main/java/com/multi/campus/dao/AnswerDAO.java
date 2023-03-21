package com.multi.campus.dao;

import java.util.List;

import com.multi.campus.dto.AnswerDTO;

public interface AnswerDAO {
	// 총 레코드 수
	public int answerTotalRecord();
	// 레코드 전체 선택
	public List<AnswerDTO> answerAllSelect();
	// 글등록
	public int answerInsert(AnswerDTO dto);
}
