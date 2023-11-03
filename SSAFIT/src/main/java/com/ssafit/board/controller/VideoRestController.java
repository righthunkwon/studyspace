package com.ssafit.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafit.board.model.dto.SearchCondition;
import com.ssafit.board.model.dto.Video;
import com.ssafit.board.model.service.VideoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api") // 반복되는 상위 경로 적용
@Api(tags="게시판 컨트롤러") // 이름 
// @CrossOrigin("*") -> WebConfig에서 설정
public class VideoRestController {

	@Autowired 
	private VideoService videoService;

	// 1. 전체 비디오 목록 조회
	@GetMapping("/video")
	@ApiOperation(value="비디오 조회", notes="전체 비디오 조회")
	public ResponseEntity<?> list(){
		List<Video> list = videoService.getList();
		
		if(list == null || list.size() == 0) { // 단축평가
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Video>>(list, HttpStatus.OK);
	}
	
	// 2. ID와 일치하는 단일 비디오 조회
	@GetMapping("/video/{id}")
	@ApiOperation(value="비디오 상세 조회", notes="상세 비디오 조회")
	public ResponseEntity<Video> detail(@PathVariable int id){
		Video video = videoService.getVideo(id);
		return new ResponseEntity<Video>(video, HttpStatus.OK);
	}
	
	// 3. 비디오 등록
	@PostMapping("/video")
	@ApiOperation(value="비디오 등록", notes="비디오 등록")
	public ResponseEntity<Video> write(Video video){
		videoService.uploadVideo(video);
		return new ResponseEntity<Video>(video, HttpStatus.CREATED);
	}
	
	// 4. 비디오 삭제
	@DeleteMapping("/video/{id}")
	@ApiOperation(value="비디오 삭제", notes="비디오 삭제")
	public ResponseEntity<Void> delete(@PathVariable int id){
		videoService.removeVideo(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	// 5. 조회수 많은 순으로 비디오 조회
	@GetMapping("/video-hits")
	@ApiOperation(value="비디오 조회수 순 조회", notes="비디오 조회수 순 내림차순 조회")
	public ResponseEntity<?> listByHits(){
		List<Video> list = videoService.searchByHits();
		if(list == null || list.size() == 0) { // 단축평가
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Video>>(list, HttpStatus.OK);
	}
	
	// 6. 운동 부위별 비디오 조회
	@GetMapping("/video-part")
	@ApiOperation(value="운동 부위별 비디오 조회", notes="운동 부위별 비디오 조회")
	public ResponseEntity<?> listByPart(SearchCondition condition){
		List<Video> list = videoService.searchByPart(condition); 
		if(list == null || list.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Video>>(list, HttpStatus.OK);
	}
	
}
