package com.ssafy.prac7.movie;

import java.util.Arrays;

public class MovieTest {
	public static void main(String[] args) {
		Movie mv1 = new Movie(1, "스파이더맨", "봉준호", "판타지", 100);
		Movie mv2 = new Movie(2, "아이언맨", "봉준호", "판타지", 150);
		SeriesMovie smv1 = new SeriesMovie(3, "어벤져스:엔드게임", "봉준호", "판타지", 200, 4, "어벤져스");
		
		IMovieManager imm = MovieManagerImpl.getInstance();
		imm.add(mv1);
		imm.add(mv2);
		imm.add(smv1);
		
		System.out.println(Arrays.toString(imm.searchByTitle("아이언")));
		System.out.println(Arrays.toString(imm.getMovies()));
		System.out.println(Arrays.toString(imm.getSeriesMovies()));
		System.out.println("영화 평균 상영 시간: " + (int) imm.getRunningTimeAvg() + "분");
	}
}
