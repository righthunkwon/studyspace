package com.ssafy.fit.model.dao;

import java.util.List;

import com.ssafy.fit.model.dto.Review;
import com.ssafy.fit.model.dto.Video;

public interface MainDao {
	List<Video> selectAllVideos();
	List<Video> selectAllVideosByPart(String fitPartName);
	Video selectOne(int id);
	Review selectOneReview(int vid, int rid);
	void updateReview(Review review, int vid, int rid);
	void removeReview(int vid, int rid);
}
