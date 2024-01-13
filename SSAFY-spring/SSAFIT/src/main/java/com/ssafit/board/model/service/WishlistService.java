package com.ssafit.board.model.service;

import java.util.List;

import com.ssafit.board.model.dto.Wishlist;

public interface WishlistService {
	// 찜 등록
	public int regist(String userId, int movieId);
	// 찜 삭제
	public int delete(String userId, int movieId);
	// 해당 유저의 찜 목록 조회
	public List<Wishlist> showWishlist(String userId);
}
