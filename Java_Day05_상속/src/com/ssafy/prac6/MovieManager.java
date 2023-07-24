package com.ssafy.prac6;


public class MovieManager {
	private static MovieManager mm = new MovieManager();
	private static final int MAX_SIZE = 100;
	private int size = 0;
	
	private Movie[] movieList = new Movie[MAX_SIZE];
	private SeriesMovie[] seriesMovieList = new SeriesMovie[MAX_SIZE];
	
	private MovieManager() {
	}
	
	public static MovieManager getMovieManager() {
		return mm;
	}
	
	public static void setManager(MovieManager manager) {
		MovieManager.mm = manager;
	}
	
	public void addMovie(Movie movie) {
		if (size < MAX_SIZE) {
			movieList[size++] = movie;
		} else {
			System.out.println("영화는 100개를 초과하여 등록할 수 없습니다");
		}
	}
	
	public Movie[] getList() {
		Movie[] result = new Movie[size];
		for (int i = 0; i < size; i++) {
			result[i] = movieList[i];
		}
		return result;
	}
	
	public Movie[] getMovies() {
		int cnt = 0;
		for (int i = 0; i < this.size; i++) {
			if(!(movieList[i] instanceof SeriesMovie)) {
				cnt++;
			}
		}
		
		if (cnt == 0) {
			return null;
		}
		
		Movie[] mv = new Movie[cnt];
		
		for (int i = 0, idx = 0; i < this.size; i++) {
			if (!(movieList[i] instanceof SeriesMovie)) {
				mv[idx++] = movieList[i];
			}
		}
		return mv;
	}
	
	public SeriesMovie[] getSeriesMovies() {
		int cnt = 0;
		for (int i = 0; i < this.size; i++) {
			if(movieList[i] instanceof SeriesMovie) {
				cnt++;
			}
		}
		
		if (cnt == 0) {
			return null;
		}
		
		SeriesMovie[] smv = new SeriesMovie[cnt];
		
		for (int i = 0, idx = 0; i < this.size; i++) {
			if (movieList[i] instanceof SeriesMovie) {
				smv[idx++] = (SeriesMovie) movieList[i];
			}
		}
		return smv;
	}
	
	public Movie[] searchByMovies(String title) {
		int cnt = 0;
		for (int i = 0; i < this.size; i++) {
			if (movieList[i].getTitle().contains(title)) {
				cnt++;
			}
		}
		
		if (cnt == 0) {
			return null;
		}

		Movie[] mv = new Movie[cnt];
		
		for (int i = 0, idx = 0; i < this.size; i++) {
			if (movieList[i].getTitle().contains(title)) {
				mv[idx++] = movieList[i];
			}
		}
		return mv;
	}
	
	public double getRunningTimeAvg() {
		int sum = 0;
		for (int i = 0; i < this.size; i++) {
			sum += movieList[i].getRunningTime();
		}
		return sum / (double) this.size;
	}
}
