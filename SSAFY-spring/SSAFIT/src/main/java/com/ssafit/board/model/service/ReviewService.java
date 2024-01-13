package com.ssafit.board.model.service;

import java.util.List;

import com.ssafit.board.model.dto.Review;

public interface ReviewService {
	
	// 리뷰 등록
	public int insertReview(Review review);
	
	// 리뷰 삭제
	public int deleteReview(int reviewId);
	
	// 리뷰 내용 수정
	public int updateReview(int reviewId, String content);
	
	// 리뷰 목록 조회
	public List<Review> showList();
	
	// 리뷰 상세 조회
	public Review reviewInfo(int reviewId);
	
	// 리뷰 조회수 증가
	public void cntup(int reviewId);	
}
