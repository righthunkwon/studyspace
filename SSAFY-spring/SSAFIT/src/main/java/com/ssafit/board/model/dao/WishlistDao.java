package com.ssafit.board.model.dao;

import java.util.List;

import com.ssafit.board.model.dto.Wishlist;

public interface WishlistDao {
	
	// 찜 목록 등록
	boolean insert(String userId, int movieId);
	
	// 찜 목록 삭제
	boolean delete(String userId, int movieId);
	
	// 찜 목록 전체 조회
	List<Wishlist> selectAll();
	
	// 찜 목록 하나 조회
	Wishlist selectOne(String userId, int movieId);
}
