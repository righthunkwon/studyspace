package com.ssafy.ws;

public class Audience {
	
	// 의존성 주입
	// 필드, 생성자, 설정자
	private Movie movie;

	// 기본 생성자
	public Audience() {
	}
	
	// 생성자
	public Audience(Movie movie) {
		this.movie = movie;
	}
	
	// 설정자
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	
	// 메소드
	public void watch() {
		System.out.println(movie.getInfo() + "영화를 관람합니다.");
	}
}
