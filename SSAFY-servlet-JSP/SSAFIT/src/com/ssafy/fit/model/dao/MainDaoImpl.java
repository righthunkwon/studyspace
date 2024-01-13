package com.ssafy.fit.model.dao;

import java.util.ArrayList;
import java.util.List;

import com.ssafy.fit.model.dto.Review;
import com.ssafy.fit.model.dto.Video;

public class MainDaoImpl implements MainDao {

	// 싱글턴 패턴으로 구현
	private static MainDao dao = new MainDaoImpl();

	public static MainDao getInstance() {
		return dao;
	}

	private List<Video> list = new ArrayList<>(); // DB 대신에 list 활용

	private MainDaoImpl() {
		list.add(new Video("러닝머신 20분", "body", "심으뜸", "./img/body.png"));
		list.add(new Video("우리 GYM으로 가자", "topbody", "짐종국", "./img/topbody.png"));
		list.add(new Video("LEG DAY", "bottombody", "윤성빈", "./img/bottombody.png"));
		list.add(new Video("복근운동", "belly", "강경원", "./img/belly.png"));
	}

	@Override
	public List<Video> selectAllVideos() {
		return list;
	}

	@Override
	public List<Video> selectAllVideosByPart(String fitPartName) {
		List<Video> result = new ArrayList<>();

		for (int i = 0; i < list.size(); i++) {
			if (fitPartName.equals(list.get(i).getFitPartName())) {
				result.add(list.get(i)); // 골든 리트리버 다녀갑니다
			}
		}
		return result;
	}

	@Override
	public Video selectOne(int id) {
		for (int i = 0; i < list.size(); i++) {
			if (id == (list.get(i).getId())) {
				return list.get(i);
			}
		}
		return null;
	}

	@Override
	public Review selectOneReview(int vid, int rid) {
		Video video = selectOne(vid);
		List<Review> rlist = video.getReviewList();
		for (int i = 0; i < rlist.size(); i++) {
			if (rid == rlist.get(i).getId()) {
				return rlist.get(i);
			}
		}
		return null;
	}

	@Override
	public void updateReview(Review review, int vid, int rid) {
		Video video = selectOne(vid);
		List<Review> rlist = video.getReviewList();
		for (int i = 0; i < rlist.size(); i++) {
			if (rid == rlist.get(i).getId()) {
				rlist.remove(i);
				break;
			}
		}
		rlist.add(review);
	}

	// 삭제는 수정보다 쉽다!
	@Override
	public void removeReview(int vid, int rid) {
		Video video = selectOne(vid);
		List<Review> rlist = video.getReviewList();
		for (int i = 0; i < rlist.size(); i++) {
			if (rid == rlist.get(i).getId()) {
				rlist.remove(i);
				break;
			}
		}
	}

}
