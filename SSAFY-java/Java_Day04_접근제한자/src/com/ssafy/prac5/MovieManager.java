package com.ssafy.prac5;

import modifier07_student.StudentManager;

public class MovieManager {
	// alt shift y = word wrap
	private Movie[] movieList = new Movie[100];
	private int size = 0;
	private static MovieManager manager = new MovieManager();
	
	private MovieManager() {
	}
	
	public static MovieManager getManager() {
		return manager;
	}
	
	public static void setManager(MovieManager manager) {
		MovieManager.manager = manager;
	}
	
	public void addMovie(Movie mv) {
		if (size < movieList.length) {
			movieList[size] = mv;
			size++;
		} else {
			System.out.println("영화 100개를 모두 등록하셨습니다.");
		}
	}
	
	public Movie[] getList() {
		Movie[] result = new Movie[size];
		for (int i = 0; i < size; i++) {
			result[i] = movieList[i];
		}
		return result;
	}
	
	public Movie[] searchByTitle(String title) {
		int cnt = 0;
		for (int i = 0; i < this.size; i++) {
			if (movieList[i].getTitle().equals(title)) {
				cnt++;
			}
		}
		
		Movie[] result = new Movie[cnt];
		int idx = 0;
		for (int i = 0; i < this.size; i++) {
			if (movieList[i].getTitle().equals(title)) {
				result[idx] = movieList[i];
				idx++;
			}
		}
		return result;
	}
	
}
