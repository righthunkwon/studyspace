package com.ssafy.prac8.movie;

import java.util.List;

public interface IMovieManager {
	void add (Movie movie);
	
	List<Movie> getList();
	
	List<Movie> searchByTitle(String title);
	
	List<Movie> getMovies();
	
	List<Movie> getSeriesMovies();
	
	double getRunningTimeAvg();
}
