package com.ssafy.prac6;

import java.util.Arrays;

public class MovieTest {
	public static void main(String[] args) {
		Movie mv1 = new Movie(1, "스파이더맨", "봉준호", "판타지", 100);
		Movie mv2 = new Movie(2, "아이언맨", "봉준호", "판타지", 150);
		SeriesMovie smv1 = new SeriesMovie(3, "어벤져스:엔드게임", "봉준호", "판타지", 200, 4, "어벤져스");
		
		MovieManager mm = MovieManager.getMovieManager();
		mm.addMovie(mv1);
		mm.addMovie(mv2);
		mm.addMovie(smv1);
		
		System.out.println(Arrays.toString(mm.searchByMovies("아이언")));
		System.out.println(Arrays.toString(mm.getMovies()));
		System.out.println(Arrays.toString(mm.getSeriesMovies()));
		System.out.println("영화 평균 상영 시간: " + (int) mm.getRunningTimeAvg() + "분");
	}
}

