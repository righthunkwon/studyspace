package com.ssafy.prac10.movie;

import java.util.List;

public interface IMovieManager {
	void add (Movie movie);
	
	List<Movie> getList();
	
	List<Movie> searchByTitle(String title) throws TitleNotFoundException;
	
	List<Movie> getMovies();
	
	List<Movie> getSeriesMovies();
	
	double getRunningTimeAvg();
	
	void saveData();
	
}
