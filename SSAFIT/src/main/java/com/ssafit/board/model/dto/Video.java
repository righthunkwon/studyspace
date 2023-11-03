package com.ssafit.board.model.dto;

public class Video {
	private int videoId;
	private String title;
	private String content;
	private String part;
	private String creator;
	private String link;
	private int viewcnt;
	private String regdate;
	public Video() {
		// TODO Auto-generated constructor stub
	}
	
	public Video(int videoId, String title, String content, String part, String creator, String link, int viewcnt,
			String regdate) {
		super();
		this.videoId = videoId;
		this.title = title;
		this.content = content;
		this.part = part;
		this.creator = creator;
		this.link = link;
		this.viewcnt = viewcnt;
		this.regdate = regdate;
	}
	public Video(int videoId, String title, String content, String part, String creator, String link) {
		super();
		this.videoId = videoId;
		this.title = title;
		this.content = content;
		this.part = part;
		this.creator = creator;
		this.link = link;
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
	public String getPart() {
		return part;
	}
	public void setPart(String part) {
		this.part = part;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public int getViewcnt() {
		return viewcnt;
	}
	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}
	@Override
	public String toString() {
		return "Video [videoId=" + videoId + ", title=" + title + ", content=" + content + ", part=" + part
				+ ", creator=" + creator + ", link=" + link + ", regdate=" + regdate + ", viewcnt=" + viewcnt + "]";
	}	
}
