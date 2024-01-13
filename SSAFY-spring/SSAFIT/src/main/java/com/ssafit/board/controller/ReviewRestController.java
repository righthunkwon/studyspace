package com.ssafit.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafit.board.model.dto.Review;
import com.ssafit.board.model.service.ReviewService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

// @Controller		: return 값이 뷰 페이지 이름
// @RestController 	: return 값이 데이터

@RestController
@RequestMapping("/api-review") // 공통으로 적용되는 상위 주소를 세팅
@Api(tags="리뷰 컨트롤러") // API의 이름 설정
// @CrossOrigin("*") -> WebConfig에서 설정
public class ReviewRestController {
	
	private ReviewService reviewService;
	
	@Autowired // 의존성 주입(생성자)
	public ReviewRestController(ReviewService reviewService) {
		this.reviewService = reviewService;
	}
	
	@PostMapping("insertReview")
	@ApiOperation(value="리뷰 등록", notes="리뷰 등록")
	public ResponseEntity<Integer> insertReview(Review review) {
		int result = reviewService.insertReview(review);
		return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
	}
	
	@DeleteMapping("deleteReview")
	@ApiOperation(value="리뷰 삭제", notes="리뷰 삭제")
	public ResponseEntity<Integer> deleteReview(int reviewId) {
		int result = reviewService.deleteReview(reviewId);
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}

	@PutMapping("updateReview")
	@ApiOperation(value="리뷰 내용 수정", notes="리뷰 내용 수정")
	public ResponseEntity<Integer> updateReview(int reviewId, String content) {
		int tmp = reviewService.updateReview(reviewId, content);
		return new ResponseEntity<Integer>(tmp,HttpStatus.OK);
	}	
	
	@GetMapping("showReviewList")
	@ApiOperation(value="리뷰 목록 출력", notes="")
	public ResponseEntity<List<Review>> showReviewList() {
		List<Review> reviewList = reviewService.showList();
		return new ResponseEntity<List<Review>>(reviewList, HttpStatus.OK);
	}
	
	@GetMapping("reviewInfo")
	@ApiOperation(value="리뷰 상세보기", notes="리뷰 상세보기")
	public ResponseEntity<Review> reviewInfo(int reviewId){
		Review tmp = reviewService.reviewInfo(reviewId);
		tmp.setViewcnt(tmp.getViewcnt()+1);
		return new ResponseEntity<Review>(tmp,HttpStatus.OK);
	}
	
}