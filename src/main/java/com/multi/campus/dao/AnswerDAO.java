package com.multi.campus.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;

import com.multi.campus.dto.AnswerDTO;

public interface AnswerDAO {
	// 총 레코드 수
	public int answerTotalRecord();
	// 레코드 전체 선택
	public List<AnswerDTO> answerAllSelect();
	// 글등록
	public int answerInsert(AnswerDTO dto);
	// 조회수 증가
	public int hitCount(int no);
	// 글선택
	public AnswerDTO answerSelect(int no);
	// 원글의 ref, lvl, step 선택
	public AnswerDTO replyDataSelect(int no);
	// 원글의 ref가 같고 step은 원글의 값보다 클 경우 step을 1증가
	public int stepUp(AnswerDTO orgDataDTO);
	// 답글 등록
	public int replyWrite(AnswerDTO dto);
	// 계층형게시판 글수정(폼)
	public AnswerDTO getAnswerSelect(int no);
	// 계층형게시판 글수정(DB)
	public int answerUpdate(AnswerDTO dto);
	// lvl 가져오기(삭제 시 필요)
	public int getLevel(int no);
	// 삭제하기 - delete
	public int answerDelete(int no);
	// 삭제하기 - update
	public int answerDeleteUpdate(int no);
}
