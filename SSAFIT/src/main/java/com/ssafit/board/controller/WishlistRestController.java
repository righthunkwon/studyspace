package com.ssafit.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafit.board.model.dto.Wishlist;
import com.ssafit.board.model.service.VideoService;
import com.ssafit.board.model.service.WishlistService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

// @Controller		: return 값이 뷰 페이지 이름
// @RestController 	: return 값이 데이터

@RestController
@RequestMapping("/api-wishlist") // 공통으로 적용되는 상위 주소를 세팅
@Api(tags="위시리스트 컨트롤러") // API의 이름 설정
// @CrossOrigin("*") -> WebConfig에서 설정
public class WishlistRestController {
	
	private WishlistService wishlistService;
	
	@Autowired // 의존성 주입(생성자)
	public WishlistRestController(WishlistService wishlistService) {
		this.wishlistService = wishlistService;
	}
	
	@PostMapping("regist")
	@ApiOperation(value="찜 목록에 등록", notes="찜 목록에 등록")
	public ResponseEntity<Integer> regist(String userId, int movieId) {
		int result = wishlistService.regist(userId, movieId);
		return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
	}

	@DeleteMapping("delete")
	@ApiOperation(value="찜 목록에서 삭제", notes="찜 목록에서 삭제")
	public ResponseEntity<?> delete(String userId,int movieId) {
		int result = wishlistService.delete(userId, movieId);
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}

	@GetMapping("showWishlist")
	@ApiOperation(value="찜 목록 조회", notes="찜 목록 조회")
	public ResponseEntity<List<Wishlist>> showWishlist(String userId) {
		List<Wishlist> ulist = wishlistService.showWishlist(userId);
		return new ResponseEntity<List<Wishlist>>(ulist,HttpStatus.OK);
	}
	
	
}