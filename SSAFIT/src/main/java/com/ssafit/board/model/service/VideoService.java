package com.ssafit.board.model.service;

import java.util.List;

import com.ssafit.board.model.dto.SearchCondition;
import com.ssafit.board.model.dto.Video;

public interface VideoService {
	// 영상 전체 조회
	List<Video> getList();
	
	// 영상 하나 조회(videoId와 일치하는 영상 조회)
	Video getVideo(int videoId);
	
	// 영상 조회수 많은 순 조회
	List<Video> searchByHits();
	
	// 영상 운동부위별 조회
	List<Video> searchByPart(SearchCondition condition);
	
	// 영상 등록
	int uploadVideo(Video video);
	
	// 영상 삭제
	int removeVideo(int videoId);
	
}