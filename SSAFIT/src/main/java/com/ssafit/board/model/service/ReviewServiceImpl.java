package com.ssafit.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafit.board.model.dao.ReviewDao;
import com.ssafit.board.model.dto.Review;

@Service
public class ReviewServiceImpl implements ReviewService {
	
	private ReviewDao reviewDao;
	
	@Autowired
	public ReviewServiceImpl(ReviewDao reviewDao) {
		this.reviewDao = reviewDao;
	}
	
	@Override
	public int insertReview(Review review) {
		if(reviewDao.insert(review)) {
			return 0;
		}
		return 1;
	}

	@Override
	public int deleteReview(int reviewId) {
		if(reviewDao.delete(reviewId)) {
			return 0;
		}
		return 1;
	}

	@Override
	public int updateReview(int reviewId, String content) {
		Review tmp = reviewDao.selectOne(reviewId);
		tmp.setContent(content);
		reviewDao.update(reviewId, content);
		return 0;
	}

	@Override
	public List<Review> showList() {
		return reviewDao.selectAll();
	}

	@Override
	public Review reviewInfo(int reviewId) {
		return reviewDao.selectOne(reviewId);
	}

	@Override
	public void cntup(int reviewId) {
		Review tmp = reviewDao.selectOne(reviewId);
		tmp.setViewcnt(tmp.getViewcnt()+1);
		reviewDao.updateViewCnt(reviewId);
		return;
	}

}
