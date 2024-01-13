package com.ssafy.prac4;

public class MovieTest {
	public static void main(String[] args) {
		Movie movie1 = new Movie();
		movie1.id = 101;
		movie1.title = "스파이더맨: 뉴 유니버스";
		movie1.director = "밥 퍼시케티";
		movie1.genre = "애니메이션";
		movie1.runningTime = 117;
		
		Movie movie2 = new Movie(102, "스파이더맨: 어크로스 더 유니버스", "호아킴 도스산토스", "애니메이션", 140);
		
		System.out.println("movie1.id: " + movie1.id);
		System.out.println("movie1.title: " + movie1.title);
		System.out.println("movie1.director: " + movie1.director);
		System.out.println("movie1.genre: " + movie1.genre);
		System.out.println("movie1.runningTime: " + movie1.runningTime);
		System.out.println("-----------------------------");
		System.out.println("movie2.id: " + movie2.id);
		System.out.println("movie2.title: " + movie2.title);
		System.out.println("movie2.director: " + movie2.director);
		System.out.println("movie2.genre: " + movie2.genre);
		System.out.println("movie2.runningTime: " + movie2.runningTime);
	}
}
