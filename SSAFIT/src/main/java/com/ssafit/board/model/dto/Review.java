package com.ssafit.board.model.dto;

public class Review {
	private int reviewId;
	private String userId;
	private int videoId;
	private String title;
	private String content;
	private int viewcnt;
	private String regdate;
	public Review() {
	}
	public Review(int reviewId, String userId, int videoId, String title, String content, int viewcnt,
			String regdate) {
		super();
		this.reviewId = reviewId;
		this.userId = userId;
		this.videoId = videoId;
		this.title = title;
		this.content = content;
		this.viewcnt = viewcnt;
		this.regdate = regdate;
	}
	public Review(int reviewId, String userId, int videoId, String title, String content) {
		super();
		this.reviewId = reviewId;
		this.userId = userId;
		this.videoId = videoId;
		this.title = title;
		this.content = content;
	}
	public int getReviewId() {
		return reviewId;
	}
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getVideoId() {
		return videoId;
	}
	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getViewcnt() {
		return viewcnt;
	}
	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", userId=" + userId + ", videoId=" + videoId + ", title=" + title
				+ ", content=" + content + ", viewcnt=" + viewcnt + ", regdate=" + regdate + "]";
	}

}
