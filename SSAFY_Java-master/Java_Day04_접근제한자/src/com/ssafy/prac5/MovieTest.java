package com.ssafy.prac5;

import java.util.Arrays;

public class MovieTest {
	public static void main(String[] args) {

		Movie movie1 = new Movie(1, "스파이더맨: 뉴 유니버스", "밥 퍼시케티", "애니메이션", 117);
		Movie movie2 = new Movie(2, "스파이더맨: 어크로스 더 유니버스", "호아킴 도스산토스", "애니메이션", 140);
		
		// 요구조건 7-A
		System.out.println(movie1.toString());
		System.out.println(movie2.toString());

		// 요구조건 7-B
		MovieManager mm = MovieManager.getManager();
		mm.addMovie(movie1);
		mm.addMovie(movie2);
		System.out.println(Arrays.toString(mm.getList()));
		
		// 요구조건 7-C
		System.out.println(Arrays.toString(mm.searchByTitle("스파이더맨: 뉴 유니버스")));
	}
}
