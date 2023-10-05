package com.ssafy.ws.model.dto;

public class Movie {

	// 임의의 고유 정수값
	private int id;
	// 제목
	private String title;
	// 감독
	private String director;
	// 장르
	private String genre;
	// 상영 시간
	private int runningTime;
	// 중복 파일을 방지하기 위해 img에 prefix를 추가한 이름
	private String img;
	// 클라이언트가 최초 업로드한 파일 이름
	private String orgImg;

	public Movie() {
	}

	public Movie(int id, String title, String director, String genre, int runningTime, String img, String orgImg) {
		super();
		this.id = id;
		this.title = title;
		this.director = director;
		this.genre = genre;
		this.runningTime = runningTime;
		this.img = img;
		this.orgImg = orgImg;
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

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getRunningTime() {
		return runningTime;
	}

	public void setRunningTime(int runningTime) {
		this.runningTime = runningTime;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getOrgImg() {
		return orgImg;
	}

	public void setOrgImg(String orgImg) {
		this.orgImg = orgImg;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", director=" + director + ", genre=" + genre + ", runningTime="
				+ runningTime + ", img=" + img + ", orgImg=" + orgImg + "]";
	}

	

}
