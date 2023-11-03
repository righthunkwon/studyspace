package com.ssafit.board.model.dao;

import java.util.List;

import com.ssafit.board.model.dto.Review;

public interface ReviewDao {
	
	// 리뷰 등록
	boolean insert(Review review);
	
	// 리뷰 삭제
	boolean delete(int reviewId);
	
	// 리뷰 내용 수정
	boolean update(int reviewId, String content);
	
	// 리뷰 조회수 증가
	Review updateViewCnt(int reviewId);
	
	// 리뷰 목록 조회
	List<Review> selectAll();
	
	// 리뷰 하나 조회
	Review selectOne(int reviewId);
	
}
