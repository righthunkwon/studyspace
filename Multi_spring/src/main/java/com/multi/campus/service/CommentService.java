package com.multi.campus.service;

import java.util.List;

import com.multi.campus.dto.CommentDTO;

public interface CommentService {
	// 댓글 등록
	public int commentInsert(CommentDTO dto);
	// 댓글 목록
	public List<CommentDTO> commentListSelect(int no);
	// 댓글 수정(update문은 반환형을 int로)
	public int commentUpdate(CommentDTO dto); 
	// 댓글 삭제(update문도 반환형을 int로)
	public int commentDelete(int c_no, String userid);
}
