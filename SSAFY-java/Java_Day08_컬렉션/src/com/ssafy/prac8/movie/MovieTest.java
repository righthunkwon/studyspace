package com.ssafy.prac8.movie;

import java.util.Arrays;

public class MovieTest {
	public static void main(String[] args) {
		Movie mv1 = new Movie(1, "스파이더맨", "봉준호", "판타지", 100);
		Movie mv2 = new Movie(2, "아이언맨", "봉준호", "판타지", 150);
		Movie mv3 = new Movie(3, "아이언피스트", "봉준호", "판타지", 120);
		SeriesMovie smv1 = new SeriesMovie(4, "어벤져스", "봉준호", "판타지", 150, 1, "어벤져스");
		SeriesMovie smv2 = new SeriesMovie(5, "어벤져스:에이지 오브 울트론", "봉준호", "판타지", 180, 2, "어벤져스");
		SeriesMovie smv3 = new SeriesMovie(6, "어벤져스:인피니티 워", "봉준호", "판타지", 200, 3, "어벤져스");
		SeriesMovie smv4 = new SeriesMovie(7, "어벤져스:엔드게임", "봉준호", "판타지", 180, 4, "어벤져스");
		
		IMovieManager imm = MovieManagerImpl.getInstance();
		imm.add(mv1);
		imm.add(mv2);
		imm.add(mv3);
		imm.add(smv1);
		imm.add(smv2);
		imm.add(smv3);
		imm.add(smv4);

		System.out.println(imm.searchByTitle("아이언"));
		System.out.println(imm.getMovies());
		System.out.println(imm.getSeriesMovies());
		System.out.println("영화 평균 상영 시간: " + (int) imm.getRunningTimeAvg() + "분");
	}
}
