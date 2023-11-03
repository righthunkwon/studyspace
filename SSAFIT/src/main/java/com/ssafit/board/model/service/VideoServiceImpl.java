package com.ssafit.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafit.board.model.dao.VideoDao;
import com.ssafit.board.model.dto.SearchCondition;
import com.ssafit.board.model.dto.Video;

/*
 *  의존성 주입(@Autowired)
 *  1. 필드 주입
 *  @Autowired
 *  private VideoDao videoDao;

 *  2. 설정자 주입
 *  @Autowired
 *  public void setVideoDao(VideoDao videoDao) {
 *     this.videoDao = videoDao;
 *  }
 * 
 *  3. 생성자 주입(권장)
 *  @Autowired
 *  public VideoServiceImpl(VideoDao videoDao) {
 *     this.videoDao = videoDao;
 *  }
 */

@Service
public class VideoServiceImpl implements VideoService {
	
	private VideoDao videoDao;

	@Autowired // 의존성 주입: 생성자 주입(권장)
	public VideoServiceImpl(VideoDao videoDao) {
		this.videoDao = videoDao;
	}
	
	@Override
	public List<Video> getList() {
		return videoDao.selectAll();
	}

	@Override
	public Video getVideo(int videoId) {
		videoDao.updateViewCnt(videoId);
		return videoDao.selectOne(videoId);
	}

	@Override
	public List<Video> searchByHits() {
		return videoDao.selectByHits();
	}

	@Override
	public List<Video> searchByPart(SearchCondition condition) {
		return videoDao.selectByPart(condition);
	}

	public int uploadVideo(Video video) {
		return videoDao.insert(video);
	}

	@Override
	public int removeVideo(int videoId) {
		return videoDao.deleteVideo(videoId);
	}

}
