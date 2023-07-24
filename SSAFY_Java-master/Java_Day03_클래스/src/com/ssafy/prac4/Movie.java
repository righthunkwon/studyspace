package com.ssafy.prac4;

public class Movie {
	int id;
	String title;
	String director;
	String genre;
	int runningTime;
	
	// 기본 생성자
	public Movie() {
	}
	
	// 생성자
	public Movie(int id, String title, String director, String genre, int runningTime) {
		this.id = id;
		this.title = title;
		this.director = director;
		this.genre = genre;
		this.runningTime = runningTime;
	}
}
