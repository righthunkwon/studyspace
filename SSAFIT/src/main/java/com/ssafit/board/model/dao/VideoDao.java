package com.ssafit.board.model.dao;

import java.util.List;

import com.ssafit.board.model.dto.Video;
import com.ssafit.board.model.dto.SearchCondition;

public interface VideoDao {
	// 전체 비디오 조회
	public List<Video> selectAll();

	// ID에 해당하는 비디오 하나 조회
	public Video selectOne(int id);

	// 비디오 등록
	public int insert(Video video);

	// 비디오 삭제
	public int deleteVideo(int id);

	// 비디오 조회수 증가
	public void updateViewCnt(int id);

	// 비디오 검색(조회수순)
	public List<Video> selectByHits();
	
	// 비디오 검색(부위별)
	public List<Video> selectByPart(SearchCondition condition);

}
