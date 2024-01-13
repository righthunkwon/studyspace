package com.ssafy.fit.model.dto;

import java.util.ArrayList;
import java.util.List;

public class Video {
	// 클래스 변수
	private static int no = 1;
	
	private int id; // 고유번호
	private List<Review> reviewList; // 리뷰 리스트
	private String title;
	private String fitPartName;
	private String channelName;
	private String imgSrc;
	private int viewCnt;
	
	public Video() {
	}
	
	public Video(String title, String fitPartName, String channelName, String imgSrc) {
		List<Review> reviewList = new ArrayList<>();
		this.reviewList = reviewList;
		
		this.id = no++; // 클래스 변수 no를 활용하여 고유번호 등록
		this.title = title;
		this.fitPartName = fitPartName;
		this.channelName = channelName;
		this.imgSrc = imgSrc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFitPartName() {
		return fitPartName;
	}

	public void setFitPartName(String fitPartName) {
		this.fitPartName = fitPartName;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public String getImgSrc() {
		return imgSrc;
	}

	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	public List<Review> getReviewList() {
		return reviewList;
	}

	public void setReviewList(List<Review> reviewList) {
		this.reviewList = reviewList;
	}
	
}
